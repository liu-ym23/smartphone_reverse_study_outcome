package com.larus.common.account.platform.larklogin;

import android.net.Uri;
import android.util.Base64;
import android.util.EventsUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class LarkOAuthSessionCoordinator {
    public final Function0<String> a;
    public final Function0<String> b;
    public final Function0<String> c;
    public final Uri d;
    public final Object e;
    public a f;
    public final LinkedHashMap<String, a> g;
    public long h;

    /* JADX INFO: renamed from: com.larus.common.account.platform.larklogin.LarkOAuthSessionCoordinator$2, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
    final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function0<String> {
        public AnonymousClass2(Object r8) {
            super(0, r8, p.class, "getRandomNumber", "getRandomNumber()Ljava/lang/String;", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final String invoke2() {
            ((p) this.receiver).getClass();
            return StringsKt.replace$default(UUID.randomUUID().toString(), "-", XmlPullParser.NO_NAMESPACE, false, 4, null);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ String invoke() {
            return invoke2();
        }
    }

    /* JADX INFO: renamed from: com.larus.common.account.platform.larklogin.LarkOAuthSessionCoordinator$3, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
    final /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function0<String> {
        public AnonymousClass3(Object r8) {
            super(0, r8, p.class, "buildCodeVerifier", "buildCodeVerifier()Ljava/lang/String;", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final String invoke2() {
            ((p) this.receiver).getClass();
            byte[] r0 = StringsKt.replace$default(UUID.randomUUID().toString(), "-", XmlPullParser.NO_NAMESPACE, false, 4, null).getBytes(Charsets.UTF_8);
            if (r0 != null) goto L5;
        L11:
            return XmlPullParser.NO_NAMESPACE;
        L5:
            if (r0.length != 0) goto L7;
            boolean r1 = true;
        L8:
            if (r1 == true) goto L11;
            return Base64.encodeToString(r0, 11);
        L7:
            r1 = false;
            goto L8
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ String invoke() {
            return invoke2();
        }
    }

    public static final class b {
    }

    static {
    }

    public LarkOAuthSessionCoordinator(int r5) {
        Function0<String> r6 = new l();
        p r1 = p.a;
        AnonymousClass2 r0 = new AnonymousClass2(r1);
        AnonymousClass3 r2 = new AnonymousClass3(r1);
        Intrinsics.checkNotNullParameter("doubaolarkauth://flow/enterprise_auth_login", "redirectUri");
        Intrinsics.checkNotNullParameter(r6, "idFactory");
        Intrinsics.checkNotNullParameter(r0, "stateFactory");
        Intrinsics.checkNotNullParameter(r2, "verifierFactory");
        this.a = r6;
        this.b = r0;
        this.c = r2;
        this.d = UriProtector.parse("doubaolarkauth://flow/enterprise_auth_login");
        this.e = new Object();
        this.g = new LinkedHashMap();
    }

    public final a b(String r5) {
        a r0 = this.f;
        Object r1 = null;
        if (r0 != null) goto L5;
    L9:
        Iterator<T> r2 = this.g.values().iterator();
    L11:
        if (r2.hasNext() == false) goto L16;
        Object r3 = r2.next();
        if (Intrinsics.areEqual(((a) r3).a.b, r5) == false) goto L11;
        r1 = r3;
    L16:
        return (a) r1;
    L5:
        if (Intrinsics.areEqual(r0.a.b, r5) == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L9;
        return r0;
    }

    public final void e(a r5) {
        String r0 = r5.g;
        if (r0 != null) goto L9;
        return;
    L9:
        Function3 r1 = r5.d;     // Catch: Throwable -> L7
        e r2 = r5.a;     // Catch: Throwable -> L7
        r1.invoke(r2.a, r0, r2.c);     // Catch: Throwable -> L7
        return;
    L7:
        c(r5.a.a, new c.c("enterprise_oauth_failed", null, null, null));
    }

    public final boolean f(Uri r5) {
        if (r5 != null) goto L5;
        return false;
    L5:
        if (Intrinsics.areEqual(r5.getScheme(), this.d.getScheme()) == true) goto L7;
    L11:
        boolean r6 = false;
    L12:
        if (r6 == false) goto L16;
        return true;
    L16:
        return false;
    L7:
        if (Intrinsics.areEqual(r5.getAuthority(), this.d.getAuthority()) == false) goto L11;
        if (Intrinsics.areEqual(r5.getPath(), this.d.getPath()) == false) goto L11;
        r6 = true;
        goto L12
    }

    public final void c(String r2, c r3) {
        Intrinsics.checkNotNullParameter(r2, "sessionId");
        Intrinsics.checkNotNullParameter(r3, "outcome");
        d(r2, r3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v11 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [T] */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.util.ArrayList] */
    public final void d(String r13, c r14, Phase r15) {
        Ref$ObjectRef r0 = new Ref$ObjectRef();
        Object r1 = this.e;
        monitor-enter(r1);
        a r2 = this.f;     // Catch: Throwable -> L98
        ?? r3 = 0;
        if (r2 != null) goto L7;
    L11:
        r2 = this.g.get(r13);     // Catch: Throwable -> L98
    L12:
        if (r2 != null) goto L14;
    L84:
        Collection r16 = CollectionsKt.emptyList();     // Catch: Throwable -> L98
    L85:
        monitor-exit(r1);
        Iterator r17 = r16.iterator();
    L88:
        if (r17.hasNext() == false) goto L94;
        Function1 r18 = (Function1) r17.next();
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L92
        r18.invoke(r14);     // Catch: Throwable -> L92
        Result.m49constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L92
    L92:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        Result.m49constructorimpl(ResultKt.createFailure(th));
        goto L88
    L94:
        a r19 = (a) r0.element;
        if (r19 == null) goto L123;
        e(r19);
        return;
    L123:
        return;
    L14:
        if (r15 != null) goto L16;
    L21:
        boolean r110 = false;
    L22:
        if (r110 == true) goto L84;
        if (r2.b == Kind.SUPPLEMENT) goto L27;
        this.f = null;     // Catch: Throwable -> L98
        r16 = CollectionsKt.toList(r2.e);     // Catch: Throwable -> L98
        goto L85
    L27:
        if ((r14 instanceof c.d) == false) goto L34;
        Collection<a> r111 = this.g.values();     // Catch: Throwable -> L98
        ?? r6 = new ArrayList();     // Catch: Throwable -> L98
        Iterator r112 = r111.iterator();     // Catch: Throwable -> L98
    L30:
        if (r112.hasNext() == false) goto L35;
        Object r7 = r112.next();     // Catch: Throwable -> L98
        if (Intrinsics.areEqual(((a) r7).c, r2.c) == false) goto L30;
        r6.add(r7);     // Catch: Throwable -> L98
    L35:
        Iterator r113 = ((Iterable) r6).iterator();     // Catch: Throwable -> L98
    L37:
        if (r113.hasNext() == false) goto L40;
        this.g.remove(((a) r113.next()).a.a);     // Catch: Throwable -> L98
        goto L37
    L40:
        if (r2.f == Phase.EXCHANGING) goto L42;
    L79:
        r16 = new ArrayList();     // Catch: Throwable -> L98
        Iterator r114 = ((Iterable) r6).iterator();     // Catch: Throwable -> L98
    L81:
        if (r114.hasNext() == false) goto L85;
        CollectionsKt.addAll(r16, ((a) r114.next()).e);     // Catch: Throwable -> L98
        goto L81
    L42:
        if ((r14 instanceof c.d) == true) goto L79;
        Collection<a> r115 = this.g.values();     // Catch: Throwable -> L98
        ArrayList r8 = new ArrayList();     // Catch: Throwable -> L98
        Iterator r116 = r115.iterator();     // Catch: Throwable -> L98
    L45:
        if (r116.hasNext() == false) goto L56;
        Object r9 = r116.next();     // Catch: Throwable -> L98
        a r10 = (a) r9;     // Catch: Throwable -> L98
        if (Intrinsics.areEqual(r10.c, r2.c) == true) goto L49;
    L53:
        boolean r11 = false;
    L54:
        if (r11 == false) goto L45;
        r8.add(r9);     // Catch: Throwable -> L98
        goto L45
    L49:
        if (r10.f != Phase.WAITING) goto L53;
        if (r10.g == null) goto L53;
        r11 = true;
        goto L54
    L56:
        Iterator r117 = r8.iterator();     // Catch: Throwable -> L98
        if (r117.hasNext() == true) goto L59;
        Object r118 = null;
    L75:
        a r119 = (a) r118;     // Catch: Throwable -> L98
        if (r119 == null) goto L78;
        Phase r120 = Phase.EXCHANGING;     // Catch: Throwable -> L98
        Intrinsics.checkNotNullParameter(r120, "<set-?>");     // Catch: Throwable -> L98
        r119.f = r120;     // Catch: Throwable -> L98
        r3 = r119;
    L78:
        r0.element = r3;     // Catch: Throwable -> L98
        goto L79
    L59:
        r118 = r117.next();     // Catch: Throwable -> L98
        if (r117.hasNext() == false) goto L75;
        Long r12 = ((a) r118).h;     // Catch: Throwable -> L98
        if (r12 == null) goto L65;
        long r20 = r12.longValue();     // Catch: Throwable -> L98
    L66:
        Object r21 = r117.next();     // Catch: Throwable -> L98
        Long r22 = ((a) r21).h;     // Catch: Throwable -> L98
        if (r22 == null) goto L69;
        long r121 = r22.longValue();     // Catch: Throwable -> L98
    L71:
        if (r20 <= r121) goto L74;
        r118 = r21;
        r20 = r121;
    L74:
        if (r117.hasNext() == true) goto L66;
    L69:
        r121 = Long.MAX_VALUE;
        goto L71
    L65:
        r20 = Long.MAX_VALUE;
        goto L66
    L34:
        r6 = CollectionsKt.listOf(r2);     // Catch: Throwable -> L98
        goto L35
    L16:
        if (r2.f == r15) goto L18;
        boolean r122 = true;
    L19:
        if (r122 != true) goto L21;
        r110 = true;
        goto L22
    L18:
        r122 = false;
        goto L19
    L7:
        if (Intrinsics.areEqual(r2.a.a, r13) == true) goto L10;
        r2 = null;
    L10:
        if (r2 != null) goto L12;
    L98:
        th = move-exception;
        throw th;
    }

    public final a a(Kind r8, d r9, Function3<? super String, ? super String, ? super String, Unit> r10, Function1<? super c, Unit> r11) {
        return new a(new e(this.a.invoke(), this.b.invoke(), this.c.invoke()), r8, r9, r10, CollectionsKt.mutableListOf(new Function1[]{r11}));
    }

    public final f g(Kind r6, Function3 r7, Function1 r8, boolean r9) {
        Object r0 = this.e;
        monitor-enter(r0);
        a r1 = this.f;     // Catch: Throwable -> L27
        if (r9 == false) goto L13;
        if (r1 == null) goto L8;
        Kind r10 = r1.b;     // Catch: Throwable -> L27
    L9:
        if (r10 != r6) goto L13;
        if (r1.f != Phase.AUTHORIZING) goto L13;
        boolean r11 = true;
    L14:
        if (r1 == null) goto L16;
        if (r11 == true) goto L16;
    L19:
        f.a r12 = f.a.a;     // Catch: Throwable -> L27
    L22:
        monitor-exit(r0);
        if ((r12 instanceof f.a) == false) goto L26;
        r8.invoke(new c.c("oauth_busy", null, null, null));
    L26:
        return r12;
    L16:
        if (r1 == null) goto L18;
    L20:
        a r13 = a(r6, null, r7, r8);     // Catch: Throwable -> L27
        this.f = r13;     // Catch: Throwable -> L27
        r12 = new f.b(r13.a);     // Catch: Throwable -> L27
        goto L22
    L18:
        if ((!this.g.isEmpty()) == false) goto L20;
    L8:
        r10 = null;
    L13:
        r11 = false;
    L27:
        th = move-exception;
        throw th;
    }
}
