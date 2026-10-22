package com.bytedance.ee.bear.bitable.chameleon;

import com.bytedance.ee.bear.contract.route.parcelable.WikiInfo;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes15.dex */
public final class BitableWikiChecker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final BitableWikiChecker f209632a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CoroutineScope f209633b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap<c, b<WikiInfo>> f209634c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ConcurrentHashMap<a, b<Boolean>> f209635d = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f209636a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f209637b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f209636a, r101.f209636a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f209637b, r101.f209637b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f209636a.hashCode() * 31) + this.f209637b.hashCode();
        }

        public final String toString() {
            return "AppTypeKey(userId=" + this.f209636a + ", objToken=" + this.f209637b + ')';
        }

        public a(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "userId");
            Intrinsics.checkNotNullParameter(r101, "objToken");
            this.f209636a = r100;
            this.f209637b = r101;
        }
    }

    public static final class b<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f209638a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Deferred<T> f209639b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f209638a == r101.f209638a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f209639b, r101.f209639b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            long r100 = this.f209638a;
            return (((int) (r100 ^ (r100 >>> 32))) * 31) + this.f209639b.hashCode();
        }

        public final String toString() {
            return "CacheEntry(createdAt=" + this.f209638a + ", deferred=" + this.f209639b + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b(long r100, Deferred<? extends T> r101) {
            Intrinsics.checkNotNullParameter(r101, "deferred");
            this.f209638a = r100;
            this.f209639b = r101;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f209640a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f209641b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f209640a, r101.f209640a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f209641b, r101.f209641b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f209640a.hashCode() * 31) + this.f209641b.hashCode();
        }

        public final String toString() {
            return "WikiInfoKey(userId=" + this.f209640a + ", wikiToken=" + this.f209641b + ')';
        }

        public c(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "userId");
            Intrinsics.checkNotNullParameter(r101, WikiFolderPushPlugin.WIKI_TOKEN);
            this.f209640a = r100;
            this.f209641b = r101;
        }
    }

    public BitableWikiChecker() {
    }

    static {
        f209632a = new BitableWikiChecker();
        f209633b = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        f209634c = new ConcurrentHashMap();
        f209635d = new ConcurrentHashMap();
    }

    public static String b() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L4
        Object r101 = Result.m9449constructorimpl(com.bytedance.ee.bear.contract.a.a().docDynamicConfig().f216922f.f216928a);     // Catch: Throwable -> L4
    L7:
        if (Result.m9455isFailureimpl(r101) == false) goto L10;
        r101 = "";
    L10:
        return (String) r101;
    L4:
        th = move-exception;
        Result.Companion r102 = Result.Companion;
        r101 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public static j g(WikiInfo r100) {
        return new j(BitableSubType.Unknown, r100);
    }

    public static void d(ConcurrentHashMap r100, long r101) {
        Iterator r102 = r100.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L10;
        Map.Entry r103 = (Map.Entry) r102.next();
        Object r104 = r103.getKey();
        b r105 = (b) r103.getValue();
        if (r105.f209639b.isCompleted() == false) goto L4;
        if ((r101 - r105.f209638a) <= 30000) goto L4;
        r100.remove(r104);
        goto L4
    }

    public final Object c(String r110, Continuation<? super WikiInfo> r111) {
        if ((r111 instanceof BitableWikiChecker$getOrLoadWikiInfo$1) == false) goto L7;
        BitableWikiChecker$getOrLoadWikiInfo$1 r100 = (BitableWikiChecker$getOrLoadWikiInfo$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        Deferred<WikiInfo> r105 = (Deferred) r100.L$1;
        c r106 = (c) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L26:
        if (((WikiInfo) r102) != null) goto L28;
        BitableWikiChecker r107 = f209632a;
        ConcurrentHashMap<c, b<WikiInfo>> r108 = f209634c;
        r107.getClass();
        e(r108, r106, r105, "WikiInfo");
    L28:
        return r102;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        c r109 = new c(b(), r110);
        long r112 = System.currentTimeMillis();
        ConcurrentHashMap<c, b<WikiInfo>> r113 = f209634c;
        monitor-enter(r113);
        f209632a.getClass();     // Catch: Throwable -> L29
        d(r113, r112);     // Catch: Throwable -> L29
        b<WikiInfo> r114 = r113.get(r109);     // Catch: Throwable -> L29
        if (r114 == null) goto L19;
        tt5.a.h("BitableWikiChecker", "reuse WikiInfo request, completed=" + r114.f209639b.isCompleted());     // Catch: Throwable -> L29
        r105 = r114.f209639b;     // Catch: Throwable -> L29
    L20:
        monitor-exit(r113);
        r100.L$0 = r109;
        r100.L$1 = r105;
        r100.label = 1;
        Object r115 = r105.await(r100);
        if (r115 != r103) goto L24;
        return r103;
    L24:
        r106 = r109;
        r102 = r115;
        goto L26
    L19:
        r105 = BuildersKt.async$default(f209633b, null, CoroutineStart.LAZY, new BitableWikiChecker$getOrLoadWikiInfo$deferred$1$2(r110, null), 1, null);     // Catch: Throwable -> L29
        r113.put(r109, new b(r112, r105));     // Catch: Throwable -> L29
        tt5.a.h("BitableWikiChecker", "create WikiInfo request");     // Catch: Throwable -> L29
        r105.start();     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        throw th;
    L7:
        r100 = new BitableWikiChecker$getOrLoadWikiInfo$1(this, r111);
        goto L8
    }

    public final Object f(String r110, Continuation<? super Boolean> r210) {
        if ((r210 instanceof BitableWikiChecker$resolveBaseApp$1) == false) goto L7;
        BitableWikiChecker$resolveBaseApp$1 r100 = (BitableWikiChecker$resolveBaseApp$1) r210;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        Deferred<Boolean> r105 = (Deferred) r100.L$1;
        a r106 = (a) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L48:
        if (((Boolean) r102) != null) goto L50;
        BitableWikiChecker r107 = f209632a;
        ConcurrentHashMap<a, b<Boolean>> r108 = f209635d;
        r107.getClass();
        e(r108, r106, r105, "BaseApp");
    L50:
        return r102;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        if (StringsKt.isBlank(r110) == false) goto L55;
        return null;
    L55:
        Result.Companion r109 = Result.Companion;     // Catch: Throwable -> L19
        Object r111 = Result.m9449constructorimpl((bn4.a) org.koin.java.a.c(bn4.a.class, null, null, 6));     // Catch: Throwable -> L19
    L21:
        Throwable r112 = Result.m9452exceptionOrNullimpl(r111);
        if (r112 == null) goto L25;
        tt5.a.l("BitableWikiChecker", "get Bitable App service failed", r112);
    L25:
        if (Result.m9455isFailureimpl(r111) == false) goto L27;
        r111 = null;
    L27:
        bn4.a r113 = (bn4.a) r111;
        if (r113 != null) goto L30;
        return null;
    L30:
        Boolean r114 = r113.d(r110);
        if (r114 == null) goto L34;
        boolean r115 = r114.booleanValue();
        tt5.a.h("BitableWikiChecker", "resolve BaseApp from sync cache, isApp=" + r115);
        return Boxing.boxBoolean(r115);
    L34:
        a r116 = new a(b(), r110);
        long r117 = System.currentTimeMillis();
        ConcurrentHashMap<a, b<Boolean>> r118 = f209635d;
        monitor-enter(r118);
        f209632a.getClass();     // Catch: Throwable -> L51
        d(r118, r117);     // Catch: Throwable -> L51
        b<Boolean> r119 = r118.get(r116);     // Catch: Throwable -> L51
        if (r119 == null) goto L40;
        tt5.a.h("BitableWikiChecker", "reuse BaseApp request, completed=" + r119.f209639b.isCompleted());     // Catch: Throwable -> L51
        Deferred<Boolean> r120 = r119.f209639b;     // Catch: Throwable -> L51
    L39:
        r105 = r120;
        monitor-exit(r118);
        r100.L$0 = r116;
        r100.L$1 = r105;
        r100.label = 1;
        r102 = r105.await(r100);
        if (r102 != r103) goto L46;
        return r103;
    L46:
        r106 = r116;
        goto L48
    L40:
        r120 = BuildersKt.async$default(f209633b, null, CoroutineStart.LAZY, new BitableWikiChecker$resolveBaseApp$deferred$1$2(r113, r110, null), 1, null);     // Catch: Throwable -> L51
        r118.put(r116, new b(r117, r120));     // Catch: Throwable -> L51
        tt5.a.h("BitableWikiChecker", "create BaseApp request");     // Catch: Throwable -> L51
        r120.start();     // Catch: Throwable -> L51
    L51:
        th = move-exception;
        throw th;
    L19:
        th = move-exception;
        Result.Companion r121 = Result.Companion;
        r111 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L7:
        r100 = new BitableWikiChecker$resolveBaseApp$1(this, r210);
        goto L8
    }

    public final Object a(BearUrl r100, WikiInfo r110, Continuation<? super j> r111) {
        if ((r111 instanceof BitableWikiChecker$check$1) == false) goto L7;
        BitableWikiChecker$check$1 r101 = (BitableWikiChecker$check$1) r111;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r112 = r101.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r101.label;
        boolean r105 = true;
        if (r104 == 0) goto L16;
        if (r104 == 1) goto L15;
        if (r104 != 2) goto L14;
        WikiInfo r106 = (WikiInfo) r101.L$0;
        ResultKt.throwOnFailure(r112);
    L69:
        Boolean r113 = (Boolean) r112;
        if (r113 != null) goto L72;
        tt5.a.h("BitableWikiChecker", "check failed, BaseApp type unavailable");
        return g(r106);
    L72:
        if (r113.booleanValue() == false) goto L74;
        BitableSubType r114 = BitableSubType.BaseApp;
    L75:
        j r115 = new j(r114, r106);
        tt5.a.h("BitableWikiChecker", "check success, subType=" + r115.f209653a + ", fromCache=" + r106.from_cache);
        return r115;
    L74:
        r114 = BitableSubType.BaseMain;
        goto L75
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        String r107 = (String) r101.L$0;
        ResultKt.throwOnFailure(r112);
    L32:
        r110 = (WikiInfo) r112;
        if (r110 != null) goto L37;
        tt5.a.h("BitableWikiChecker", "check skipped, WikiInfo is unavailable");
        return g(null);
    L37:
        if (r110.isValidObjInfo() == true) goto L39;
    L41:
        boolean r116 = false;
    L42:
        if (r116 == true) goto L45;
        tt5.a.h("BitableWikiChecker", "check skipped, WikiInfo is invalid");
        return g(r110);
    L45:
        c r117 = new c(b(), r107);
        long r108 = System.currentTimeMillis();
        ConcurrentHashMap<c, b<WikiInfo>> r109 = f209634c;
        monitor-enter(r109);
        f209632a.getClass();     // Catch: Throwable -> L81
        d(r109, r108);     // Catch: Throwable -> L81
        b<WikiInfo> r118 = r109.get(r117);     // Catch: Throwable -> L81
        if (r118 == null) goto L54;
        Deferred<WikiInfo> r119 = r118.f209639b;     // Catch: Throwable -> L81
        if (r119 == null) goto L54;
        if (r119.isActive() != true) goto L54;
    L55:
        if (r105 == false) goto L58;
        monitor-exit(r109);
    L61:
        if (r110.getObjType() == 8) goto L63;
    L79:
        tt5.a.h("BitableWikiChecker", "check skipped, target is not Bitable, objType=" + r110.getObjType());
        return g(r110);
    L63:
        if (r110.getInSpace() == true) goto L79;
        String r120 = r110.getObjToken();
        r101.L$0 = r110;
        r101.label = 2;
        r112 = f(r120, r101);
        if (r112 != r103) goto L68;
        return r103;
    L68:
        r106 = r110;
        goto L69
    L58:
        r109.put(r117, new b(r108, CompletableDeferredKt.CompletableDeferred(r110)));     // Catch: Throwable -> L81
        tt5.a.h("BitableWikiChecker", "cache provided WikiInfo");     // Catch: Throwable -> L81
        Unit r121 = Unit.INSTANCE;     // Catch: Throwable -> L81
        monitor-exit(r109);
    L54:
        r105 = false;
    L81:
        th = move-exception;
        throw th;
    L39:
        if (Intrinsics.areEqual(r110.getWikiToken(), r107) == false) goto L41;
        r116 = true;
        goto L42
    L16:
        ResultKt.throwOnFailure(r112);
        if (fx4.a.g(r100) == false) goto L19;
        r107 = r100.f222561b;
        if (r107 != null) goto L23;
    L84:
        tt5.a.h("BitableWikiChecker", "check skipped, wiki token is empty");
        return g(null);
    L23:
        if ((!StringsKt.isBlank(r107)) == true) goto L26;
        r107 = null;
    L26:
        if (r107 == null) goto L84;
        if (r110 != null) goto L37;
        r101.L$0 = r107;
        r101.label = 1;
        r112 = c(r107, r101);
        if (r112 != r103) goto L32;
        return r103;
    L19:
        return g(null);
    L7:
        r101 = new BitableWikiChecker$check$1(this, r111);
        goto L8
    }

    public static void e(ConcurrentHashMap r100, Object r101, Deferred r102, String r103) {
        monitor-enter(r100);
        b r104 = (b) r100.get(r101);     // Catch: Throwable -> L13
        if (r104 == null) goto L7;
        Deferred r105 = r104.f209639b;     // Catch: Throwable -> L13
    L8:
        if (r105 != r102) goto L10;
        r100.remove(r101);     // Catch: Throwable -> L13
        tt5.a.h("BitableWikiChecker", "remove failed " + r103 + " request");     // Catch: Throwable -> L13
    L10:
        Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L13
        monitor-exit(r100);
        return;
    L7:
        r105 = null;
    L13:
        th = move-exception;
        throw th;
    }
}
