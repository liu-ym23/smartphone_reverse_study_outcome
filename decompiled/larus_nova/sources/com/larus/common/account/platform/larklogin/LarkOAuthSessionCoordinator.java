package com.larus.common.account.platform.larklogin;

import android.net.Uri;
import android.util.Base64;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes.dex */
public final class LarkOAuthSessionCoordinator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<String> f326164a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<String> f326165b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<String> f326166c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Uri f326167d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Object f326168e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public a f326169f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final LinkedHashMap<String, a> f326170g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f326171h;

    /* JADX INFO: renamed from: com.larus.common.account.platform.larklogin.LarkOAuthSessionCoordinator$2, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function0<String> {
        public AnonymousClass2(Object r100) {
            super(0, r100, p.class, "getRandomNumber", "getRandomNumber()Ljava/lang/String;", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final String invoke2() {
            ((p) this.receiver).getClass();
            return StringsKt.replace$default(UUID.randomUUID().toString(), "-", "", false, 4, null);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ String invoke() {
            return invoke2();
        }
    }

    /* JADX INFO: renamed from: com.larus.common.account.platform.larklogin.LarkOAuthSessionCoordinator$3, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    final /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function0<String> {
        public AnonymousClass3(Object r100) {
            super(0, r100, p.class, "buildCodeVerifier", "buildCodeVerifier()Ljava/lang/String;", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final String invoke2() {
            ((p) this.receiver).getClass();
            byte[] r100 = StringsKt.replace$default(UUID.randomUUID().toString(), "-", "", false, 4, null).getBytes(Charsets.UTF_8);
            if (r100 != null) goto L5;
        L11:
            return "";
        L5:
            if (r100.length != 0) goto L7;
            boolean r101 = true;
        L8:
            if (r101 == true) goto L11;
            return Base64.encodeToString(r100, 11);
        L7:
            r101 = false;
            goto L8
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ String invoke() {
            return invoke2();
        }
    }

    /* JADX INFO: loaded from: classes27.dex */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/common/account/platform/larklogin/LarkOAuthSessionCoordinator$Kind;", "", "<init>", "(Ljava/lang/String;I)V", "LOGIN", "REFRESH", "SUPPLEMENT", "larkauth_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Kind extends Enum<Kind> {
        public static final Kind LOGIN = null;
        public static final Kind REFRESH = null;
        public static final Kind SUPPLEMENT = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Kind[] f326172a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f326173b = null;

        public static EnumEntries<Kind> getEntries() {
            return f326173b;
        }

        static {
            Kind r100 = new Kind("LOGIN", 0);
            LOGIN = r100;
            Kind r101 = new Kind("REFRESH", 1);
            REFRESH = r101;
            Kind r102 = new Kind("SUPPLEMENT", 2);
            SUPPLEMENT = r102;
            Kind[] r103 = {r100, r101, r102};
            f326172a = r103;
            f326173b = EnumEntriesKt.enumEntries(r103);
        }

        public static Kind[] values() {
            return (Kind[]) f326172a.clone();
        }

        public static Kind valueOf(String r100) {
            return (Kind) r27.a.a(Kind.class, r100);
        }

        public Kind(String r100, int r101) {
            super(r100, r101);
        }
    }

    /* JADX INFO: loaded from: classes27.dex */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/common/account/platform/larklogin/LarkOAuthSessionCoordinator$Phase;", "", "<init>", "(Ljava/lang/String;I)V", "AUTHORIZING", "WAITING", "EXCHANGING", "larkauth_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Phase extends Enum<Phase> {
        public static final Phase AUTHORIZING = null;
        public static final Phase EXCHANGING = null;
        public static final Phase WAITING = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Phase[] f326174a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f326175b = null;

        public static EnumEntries<Phase> getEntries() {
            return f326175b;
        }

        static {
            Phase r100 = new Phase("AUTHORIZING", 0);
            AUTHORIZING = r100;
            Phase r101 = new Phase("WAITING", 1);
            WAITING = r101;
            Phase r102 = new Phase("EXCHANGING", 2);
            EXCHANGING = r102;
            Phase[] r103 = {r100, r101, r102};
            f326174a = r103;
            f326175b = EnumEntriesKt.enumEntries(r103);
        }

        public static Phase[] values() {
            return (Phase[]) f326174a.clone();
        }

        public static Phase valueOf(String r100) {
            return (Phase) r27.a.a(Phase.class, r100);
        }

        public Phase(String r100, int r101) {
            super(r100, r101);
        }
    }

    /* JADX INFO: loaded from: classes27.dex */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final e f326176a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Kind f326177b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final d f326178c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Function3<String, String, String, Unit> f326179d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final List<Function1<c, Unit>> f326180e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Phase f326181f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f326182g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public Long f326183h;

        public a() {
            throw null;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f326176a, r101.f326176a) == true) goto L12;
            return false;
        L12:
            if (this.f326177b == r101.f326177b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f326178c, r101.f326178c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f326179d, r101.f326179d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f326180e, r101.f326180e) == true) goto L24;
            return false;
        L24:
            if (this.f326181f == r101.f326181f) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.f326182g, r101.f326182g) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.f326183h, r101.f326183h) == true) goto L32;
            return false;
        L32:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.f326176a.hashCode() * 31) + this.f326177b.hashCode()) * 31;
            d r101 = this.f326178c;
            int r102 = 0;
            if (r101 != null) goto L5;
            int r103 = 0;
        L6:
            int r104 = (((((((r100 + r103) * 31) + this.f326179d.hashCode()) * 31) + this.f326180e.hashCode()) * 31) + this.f326181f.hashCode()) * 31;
            String r105 = this.f326182g;
            if (r105 != null) goto L9;
            int r106 = 0;
        L10:
            int r107 = (r104 + r106) * 31;
            Long r108 = this.f326183h;
            if (r108 == null) goto L15;
            r102 = r108.hashCode();
        L15:
            return r107 + r102;
        L9:
            r106 = r105.hashCode();
            goto L10
        L5:
            r103 = r101.hashCode();
            goto L6
        }

        public final String toString() {
            return "ActiveSession(session=" + this.f326176a + ", kind=" + this.f326177b + ", requestKey=" + this.f326178c + ", exchange=" + this.f326179d + ", completions=" + this.f326180e + ", phase=" + this.f326181f + ", authorizationCode=" + this.f326182g + ", codeSequence=" + this.f326183h + ')';
        }

        public a(e r100, Kind r101, d r102, Function3 r103, List r104) {
            Phase r105 = Phase.AUTHORIZING;
            Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
            Intrinsics.checkNotNullParameter(r101, "kind");
            Intrinsics.checkNotNullParameter(r103, "exchange");
            Intrinsics.checkNotNullParameter(r104, "completions");
            Intrinsics.checkNotNullParameter(r105, "phase");
            this.f326176a = r100;
            this.f326177b = r101;
            this.f326178c = r102;
            this.f326179d = r103;
            this.f326180e = r104;
            this.f326181f = r105;
            this.f326182g = null;
            this.f326183h = null;
        }
    }

    public static final class b {
    }

    /* JADX INFO: loaded from: classes27.dex */
    public static abstract class c {

        public static final class a extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f326184a = null;

            static {
                f326184a = new a();
            }

            public a() {
            }
        }

        public static final class b extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final b f326185a = null;

            static {
                f326185a = new b();
            }

            public b() {
            }
        }

        /* JADX INFO: renamed from: com.larus.common.account.platform.larklogin.LarkOAuthSessionCoordinator$c$c, reason: collision with other inner class name */
        public static final class C4181c extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final String f326186a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final String f326187b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final Integer f326188c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final String f326189d;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof C4181c) == true) goto L8;
                return false;
            L8:
                C4181c r101 = (C4181c) r100;
                if (Intrinsics.areEqual(this.f326186a, r101.f326186a) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.f326187b, r101.f326187b) == true) goto L15;
                return false;
            L15:
                if (Intrinsics.areEqual(this.f326188c, r101.f326188c) == true) goto L18;
                return false;
            L18:
                if (Intrinsics.areEqual(this.f326189d, r101.f326189d) == true) goto L20;
                return false;
            L20:
                return true;
            }

            public final int hashCode() {
                int r100 = this.f326186a.hashCode() * 31;
                String r101 = this.f326187b;
                int r102 = 0;
                if (r101 != null) goto L5;
                int r103 = 0;
            L6:
                int r104 = (r100 + r103) * 31;
                Integer r105 = this.f326188c;
                if (r105 != null) goto L9;
                int r106 = 0;
            L10:
                int r107 = (r104 + r106) * 31;
                String r108 = this.f326189d;
                if (r108 == null) goto L15;
                r102 = r108.hashCode();
            L15:
                return r107 + r102;
            L9:
                r106 = r105.hashCode();
                goto L10
            L5:
                r103 = r101.hashCode();
                goto L6
            }

            public final String toString() {
                return "Failure(code=" + this.f326186a + ", message=" + this.f326187b + ", originCode=" + this.f326188c + ", originMessage=" + this.f326189d + ')';
            }

            public C4181c(String r100, String r101, Integer r102, String r103) {
                Intrinsics.checkNotNullParameter(r100, "code");
                this.f326186a = r100;
                this.f326187b = r101;
                this.f326188c = r102;
                this.f326189d = r103;
            }
        }

        public static final class d extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final Boolean f326190a;

            public d() {
                this(null);
            }

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof d) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.f326190a, ((d) r100).f326190a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                Boolean r100 = this.f326190a;
                if (r100 != null) goto L6;
                return 0;
            L6:
                return r100.hashCode();
            }

            public final String toString() {
                return "Success(isNewUser=" + this.f326190a + ')';
            }

            public d(Boolean r100) {
                this.f326190a = r100;
            }
        }

        public c() {
        }
    }

    /* JADX INFO: loaded from: classes27.dex */
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map<String, String> f326191a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f326192b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f326193c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L8;
            return false;
        L8:
            d r101 = (d) r100;
            if (Intrinsics.areEqual(this.f326191a, r101.f326191a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f326192b, r101.f326192b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f326193c, r101.f326193c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.f326191a.hashCode() * 31) + this.f326192b.hashCode()) * 31) + this.f326193c.hashCode();
        }

        public final String toString() {
            return "RequestKey(authorizeParams=" + this.f326191a + ", osType=" + this.f326192b + ", terminalType=" + this.f326193c + ')';
        }

        public d(Map<String, String> r100, String r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "authorizeParams");
            Intrinsics.checkNotNullParameter(r101, "osType");
            Intrinsics.checkNotNullParameter(r102, "terminalType");
            this.f326191a = r100;
            this.f326192b = r101;
            this.f326193c = r102;
        }
    }

    /* JADX INFO: loaded from: classes27.dex */
    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f326194a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f326195b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f326196c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof e) == true) goto L8;
            return false;
        L8:
            e r101 = (e) r100;
            if (Intrinsics.areEqual(this.f326194a, r101.f326194a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f326195b, r101.f326195b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f326196c, r101.f326196c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.f326194a.hashCode() * 31) + this.f326195b.hashCode()) * 31) + this.f326196c.hashCode();
        }

        public final String toString() {
            return "Session(id=" + this.f326194a + ", state=" + this.f326195b + ", codeVerifier=" + this.f326196c + ')';
        }

        public e(String r100, String r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "id");
            Intrinsics.checkNotNullParameter(r101, "state");
            Intrinsics.checkNotNullParameter(r102, "codeVerifier");
            this.f326194a = r100;
            this.f326195b = r101;
            this.f326196c = r102;
        }
    }

    /* JADX INFO: loaded from: classes27.dex */
    public static abstract class f {

        public static final class a extends f {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f326197a = null;

            static {
                f326197a = new a();
            }

            public a() {
            }
        }

        public static final class b extends f {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final e f326198a;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof b) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.f326198a, ((b) r100).f326198a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.f326198a.hashCode();
            }

            public final String toString() {
                return "Started(session=" + this.f326198a + ')';
            }

            public b(e r100) {
                Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
                this.f326198a = r100;
            }
        }

        public f() {
        }
    }

    static {
    }

    public LarkOAuthSessionCoordinator(int r100) {
        Function0<String> r101 = new l();
        p r102 = p.f326232a;
        AnonymousClass2 r103 = new AnonymousClass2(r102);
        AnonymousClass3 r104 = new AnonymousClass3(r102);
        Intrinsics.checkNotNullParameter("doubaolarkauth://flow/enterprise_auth_login", "redirectUri");
        Intrinsics.checkNotNullParameter(r101, "idFactory");
        Intrinsics.checkNotNullParameter(r103, "stateFactory");
        Intrinsics.checkNotNullParameter(r104, "verifierFactory");
        this.f326164a = r101;
        this.f326165b = r103;
        this.f326166c = r104;
        this.f326167d = UriProtector.parse("doubaolarkauth://flow/enterprise_auth_login");
        this.f326168e = new Object();
        this.f326170g = new LinkedHashMap();
    }

    public final a b(String r100) {
        a r101 = this.f326169f;
        Object r102 = null;
        if (r101 != null) goto L5;
    L9:
        Iterator<T> r103 = this.f326170g.values().iterator();
    L11:
        if (r103.hasNext() == false) goto L16;
        Object r104 = r103.next();
        if (Intrinsics.areEqual(((a) r104).f326176a.f326195b, r100) == false) goto L11;
        r102 = r104;
    L16:
        return (a) r102;
    L5:
        if (Intrinsics.areEqual(r101.f326176a.f326195b, r100) == true) goto L8;
        r101 = null;
    L8:
        if (r101 == null) goto L9;
        return r101;
    }

    public final void e(a r100) {
        String r101 = r100.f326182g;
        if (r101 != null) goto L9;
        return;
    L9:
        Function3<String, String, String, Unit> r102 = r100.f326179d;     // Catch: Throwable -> L7
        e r103 = r100.f326176a;     // Catch: Throwable -> L7
        r102.invoke(r103.f326194a, r101, r103.f326196c);     // Catch: Throwable -> L7
        return;
    L7:
        c(r100.f326176a.f326194a, new c.C4181c("enterprise_oauth_failed", null, null, null));
    }

    public final boolean f(Uri r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        if (Intrinsics.areEqual(r100.getScheme(), this.f326167d.getScheme()) == true) goto L7;
    L11:
        boolean r101 = false;
    L12:
        if (r101 == false) goto L16;
        return true;
    L16:
        return false;
    L7:
        if (Intrinsics.areEqual(r100.getAuthority(), this.f326167d.getAuthority()) == false) goto L11;
        if (Intrinsics.areEqual(r100.getPath(), this.f326167d.getPath()) == false) goto L11;
        r101 = true;
        goto L12
    }

    public final void c(String r100, c r101) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        Intrinsics.checkNotNullParameter(r101, "outcome");
        d(r100, r101, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v11 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [T] */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.util.ArrayList] */
    public final void d(String r110, c r111, Phase r112) {
        Ref.ObjectRef r100 = new Ref.ObjectRef();
        Object r101 = this.f326168e;
        monitor-enter(r101);
        a r102 = this.f326169f;     // Catch: Throwable -> L98
        ?? r103 = 0;
        if (r102 != null) goto L7;
    L11:
        r102 = this.f326170g.get(r110);     // Catch: Throwable -> L98
    L12:
        if (r102 != null) goto L14;
    L84:
        Collection r113 = CollectionsKt.emptyList();     // Catch: Throwable -> L98
    L85:
        monitor-exit(r101);
        Iterator r114 = r113.iterator();
    L88:
        if (r114.hasNext() == false) goto L94;
        Function1 r115 = (Function1) r114.next();
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L92
        r115.invoke(r111);     // Catch: Throwable -> L92
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L92
    L92:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L88
    L94:
        a r116 = (a) r100.element;
        if (r116 == null) goto L123;
        e(r116);
        return;
    L123:
        return;
    L14:
        if (r112 != null) goto L16;
    L21:
        boolean r117 = false;
    L22:
        if (r117 == true) goto L84;
        if (r102.f326177b == Kind.SUPPLEMENT) goto L27;
        this.f326169f = null;     // Catch: Throwable -> L98
        r113 = CollectionsKt.toList(r102.f326180e);     // Catch: Throwable -> L98
        goto L85
    L27:
        if ((r111 instanceof c.d) == false) goto L34;
        Collection<a> r118 = this.f326170g.values();     // Catch: Throwable -> L98
        ?? r106 = new ArrayList();     // Catch: Throwable -> L98
        Iterator r119 = r118.iterator();     // Catch: Throwable -> L98
    L30:
        if (r119.hasNext() == false) goto L35;
        Object r107 = r119.next();     // Catch: Throwable -> L98
        if (Intrinsics.areEqual(((a) r107).f326178c, r102.f326178c) == false) goto L30;
        r106.add(r107);     // Catch: Throwable -> L98
    L35:
        Iterator r120 = ((Iterable) r106).iterator();     // Catch: Throwable -> L98
    L37:
        if (r120.hasNext() == false) goto L40;
        this.f326170g.remove(((a) r120.next()).f326176a.f326194a);     // Catch: Throwable -> L98
        goto L37
    L40:
        if (r102.f326181f == Phase.EXCHANGING) goto L42;
    L79:
        r113 = new ArrayList();     // Catch: Throwable -> L98
        Iterator r121 = ((Iterable) r106).iterator();     // Catch: Throwable -> L98
    L81:
        if (r121.hasNext() == false) goto L85;
        CollectionsKt.addAll(r113, ((a) r121.next()).f326180e);     // Catch: Throwable -> L98
        goto L81
    L42:
        if ((r111 instanceof c.d) == true) goto L79;
        Collection<a> r122 = this.f326170g.values();     // Catch: Throwable -> L98
        ArrayList r108 = new ArrayList();     // Catch: Throwable -> L98
        Iterator r123 = r122.iterator();     // Catch: Throwable -> L98
    L45:
        if (r123.hasNext() == false) goto L56;
        Object r109 = r123.next();     // Catch: Throwable -> L98
        a r124 = (a) r109;     // Catch: Throwable -> L98
        if (Intrinsics.areEqual(r124.f326178c, r102.f326178c) == true) goto L49;
    L53:
        boolean r125 = false;
    L54:
        if (r125 == false) goto L45;
        r108.add(r109);     // Catch: Throwable -> L98
        goto L45
    L49:
        if (r124.f326181f != Phase.WAITING) goto L53;
        if (r124.f326182g == null) goto L53;
        r125 = true;
        goto L54
    L56:
        Iterator r126 = r108.iterator();     // Catch: Throwable -> L98
        if (r126.hasNext() == true) goto L59;
        Object r127 = null;
    L75:
        a r128 = (a) r127;     // Catch: Throwable -> L98
        if (r128 == null) goto L78;
        Phase r129 = Phase.EXCHANGING;     // Catch: Throwable -> L98
        Intrinsics.checkNotNullParameter(r129, "<set-?>");     // Catch: Throwable -> L98
        r128.f326181f = r129;     // Catch: Throwable -> L98
        r103 = r128;
    L78:
        r100.element = r103;     // Catch: Throwable -> L98
        goto L79
    L59:
        r127 = r126.next();     // Catch: Throwable -> L98
        if (r126.hasNext() == false) goto L75;
        Long r130 = ((a) r127).f326183h;     // Catch: Throwable -> L98
        if (r130 == null) goto L65;
        long r131 = r130.longValue();     // Catch: Throwable -> L98
    L66:
        Object r132 = r126.next();     // Catch: Throwable -> L98
        Long r133 = ((a) r132).f326183h;     // Catch: Throwable -> L98
        if (r133 == null) goto L69;
        long r134 = r133.longValue();     // Catch: Throwable -> L98
    L71:
        if (r131 <= r134) goto L74;
        r127 = r132;
        r131 = r134;
    L74:
        if (r126.hasNext() == true) goto L66;
    L69:
        r134 = Long.MAX_VALUE;
        goto L71
    L65:
        r131 = Long.MAX_VALUE;
        goto L66
    L34:
        r106 = CollectionsKt.listOf(r102);     // Catch: Throwable -> L98
        goto L35
    L16:
        if (r102.f326181f == r112) goto L18;
        boolean r135 = true;
    L19:
        if (r135 != true) goto L21;
        r117 = true;
        goto L22
    L18:
        r135 = false;
        goto L19
    L7:
        if (Intrinsics.areEqual(r102.f326176a.f326194a, r110) == true) goto L10;
        r102 = null;
    L10:
        if (r102 != null) goto L12;
    L98:
        th = move-exception;
        throw th;
    }

    public final a a(Kind r100, d r101, Function3<? super String, ? super String, ? super String, Unit> r110, Function1<? super c, Unit> r111) {
        return new a(new e(this.f326164a.invoke(), this.f326165b.invoke(), this.f326166c.invoke()), r100, r101, r110, CollectionsKt.mutableListOf(new Function1[]{r111}));
    }

    public final f g(Kind r100, Function3 r101, Function1 r102, boolean r103) {
        Object r104 = this.f326168e;
        monitor-enter(r104);
        a r105 = this.f326169f;     // Catch: Throwable -> L27
        if (r103 == false) goto L13;
        if (r105 == null) goto L8;
        Kind r106 = r105.f326177b;     // Catch: Throwable -> L27
    L9:
        if (r106 != r100) goto L13;
        if (r105.f326181f != Phase.AUTHORIZING) goto L13;
        boolean r107 = true;
    L14:
        if (r105 == null) goto L16;
        if (r107 == true) goto L16;
    L19:
        f r108 = f.a.f326197a;     // Catch: Throwable -> L27
    L22:
        monitor-exit(r104);
        if ((r108 instanceof f.a) == false) goto L26;
        r102.invoke(new c.C4181c("oauth_busy", null, null, null));
    L26:
        return r108;
    L16:
        if (r105 == null) goto L18;
    L20:
        a r109 = a(r100, null, r101, r102);     // Catch: Throwable -> L27
        this.f326169f = r109;     // Catch: Throwable -> L27
        r108 = new f.b(r109.f326176a);     // Catch: Throwable -> L27
        goto L22
    L18:
        if ((!this.f326170g.isEmpty()) == false) goto L20;
    L8:
        r106 = null;
    L13:
        r107 = false;
    L27:
        th = move-exception;
        throw th;
    }
}
