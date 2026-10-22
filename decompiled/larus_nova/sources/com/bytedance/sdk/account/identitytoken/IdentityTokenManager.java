package com.bytedance.sdk.account.identitytoken;

import android.os.SystemClock;
import com.bytedance.sdk.account.utils.NetworkUtils;
import com.bytedance.sdk.account.utils.l;
import com.bytedance.sdk.account.utils.n;
import com.bytedance.ttnet.cronet.CronetDataStorageAccess;
import com.ss.android.account.k;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.sync.MutexImpl;
import org.json.JSONObject;
import ta7.f;

/* JADX INFO: loaded from: classes3.dex */
public final class IdentityTokenManager implements ta7.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f268900a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicBoolean f268901b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile a f268902c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final MutexImpl f268903d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f268904e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Lazy f268905f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final b f268906g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final IdentityTokenManager f268907h = null;

    /* JADX INFO: loaded from: classes22.dex */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Deferred<Pair<String, Integer>> f268908a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f268909b;

        public a(Deferred<Pair<String, Integer>> r100, int r101) {
            this.f268908a = r100;
            this.f268909b = r101;
        }
    }

    public static final class b extends com.bytedance.sdk.account.utils.d.b {
        @Override // com.bytedance.sdk.account.utils.d.b
        public final void a() {
            com.bytedance.sdk.account.settings.common.a.a();
            if (com.bytedance.sdk.account.settings.common.a.B == false) goto L33;
            com.bytedance.sdk.account.settings.common.a.a();
            if (com.bytedance.sdk.account.settings.common.a.Y == false) goto L34;
            long r100 = com.bytedance.sdk.account.utils.d.a();
            com.bytedance.sdk.account.settings.common.a.a();
            long r101 = com.bytedance.sdk.account.settings.common.a.G;
            if (r101 <= 0) goto L15;
            if (r100 < 0) goto L15;
            if (r100 >= r101) goto L15;
            tb7.a.d("IdentityTokenManager", "onForeground, timeFromAppStart too short: " + r100 + " ms < " + r101 + " ms, abort");
            return;
        L15:
            if (r100 >= 0) goto L17;
            tb7.a.e("IdentityTokenManager", "onForeground, timeFromAppStart <= 0, minIntervalFromAppStartMs: " + r101 + " ms");
        L17:
            IdentityTokenManager.f268907h.getClass();
            com.bytedance.sdk.account.settings.common.a.a();
            if (com.bytedance.sdk.account.settings.common.a.B == true) goto L20;
            tb7.a.d("IdentityTokenManager", "checkIntervals, identity token disabled");
            return;
        L20:
            IdentityTokenCacheStorage.f268899e.getClass();
            com.bytedance.sdk.account.identitytoken.b r102 = IdentityTokenCacheStorage.a();
            if (r102 != null) goto L23;
        L26:
            boolean r103 = true;
        L27:
            tb7.a.d("IdentityTokenManager", "checkIntervals, isTokenNeedRefresh: " + r103 + ", triggerScene: account_sdk_foreground");
            if (r103 == true) goto L30;
            return;
        L30:
            if (IdentityTokenManager.b().isLogin() == false) goto L37;
            IdentityTokenManager.g("account_sdk_foreground", "account_sdk_foreground");
            return;
        L37:
            return;
        L23:
            if (r102.b() == true) goto L26;
            r103 = false;
            goto L27
        L34:
            return;
        }

        public b() {
        }
    }

    static {
        f268900a = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(IdentityTokenManager.class), "bdAccount", "getBdAccount()Lcom/bytedance/sdk/account/api/IBDAccount;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(IdentityTokenManager.class), "updateScope", "getUpdateScope()Lkotlinx/coroutines/CoroutineScope;"))};
        f268907h = new IdentityTokenManager();
        f268901b = new AtomicBoolean(false);
        f268903d = kotlinx.coroutines.sync.b.a();
        f268904e = LazyKt.lazy(IdentityTokenManager$bdAccount$2.INSTANCE);
        f268905f = LazyKt.lazy(IdentityTokenManager$updateScope$2.INSTANCE);
        f268906g = new b();
    }

    public IdentityTokenManager() {
    }

    public static f b() {
        Lazy r100 = f268904e;
        KProperty r101 = f268900a[0];
        return (f) r100.getValue();
    }

    @Override // ta7.c
    public final void M(ta7.b r110) {
        int r100 = r110.f545195a;
        if (r100 != 1) goto L5;
    L8:
        tb7.a.d("IdentityTokenManager", "Logout, clear token");
        IdentityTokenCacheStorage.f268899e.getClass();
        com.bytedance.sdk.account.identitytoken.b r111 = IdentityTokenCacheStorage.b(null, true);
        f268907h.getClass();
        d("clear_cache", "account_sdk_logout", false, 0, "", null, "", 0, "", 0, r111, "");
        return;
    L5:
        if (r100 == 2) goto L8;
        if (r100 == 3) goto L8;
    }

    public static void g(String r100, String r101) {
        Lazy r102 = f268905f;     // Catch: Exception -> L4
        KProperty r103 = f268900a[1];     // Catch: Exception -> L4
        BuildersKt.launch$default((CoroutineScope) r102.getValue(), null, null, new IdentityTokenManager$runAutoPreload$1(r101, r100, null), 3, null);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        tb7.a.c("IdentityTokenManager", "runAutoPreload process: failed, triggerScene: " + r100 + ", enterFrom: " + r101, e);
    }

    /* JADX WARN: Type inference failed for: r10v1, types: [com.bytedance.sdk.account.identitytoken.IdentityTokenManager$getIdentityTokenFromCacheInternal$2] */
    public final Object c(final GetIdentityTokenScene r110, final String r111, Continuation<? super com.bytedance.sdk.account.identitytoken.a> r210) {
        if ((r210 instanceof IdentityTokenManager$getIdentityTokenSuspend$1) == false) goto L7;
        IdentityTokenManager$getIdentityTokenSuspend$1 r100 = (IdentityTokenManager$getIdentityTokenSuspend$1) r210;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        IdentityTokenManager$getIdentityTokenSuspend$1 r102 = r100;
        Object r103 = r102.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r102.label;
        if (r105 == 0) goto L18;
        if (r105 != 1) goto L17;
        String r106 = (String) r102.L$4;
        com.bytedance.sdk.account.identitytoken.a r107 = (com.bytedance.sdk.account.identitytoken.a) r102.L$3;
        String r108 = (String) r102.L$2;
        GetIdentityTokenScene r109 = (GetIdentityTokenScene) r102.L$1;
        IdentityTokenManager r112 = (IdentityTokenManager) r102.L$0;
        ResultKt.throwOnFailure(r103);     // Catch: Exception -> L14
    L79:
        Pair r113 = (Pair) r103;     // Catch: Exception -> L14
        String r114 = (String) r113.component1();     // Catch: Exception -> L14
        int r115 = ((Number) r113.component2()).intValue();     // Catch: Exception -> L14
        if (n.a(r114) == false) goto L84;
        return new com.bytedance.sdk.account.identitytoken.a.b(r114, false);
    L84:
        return new com.bytedance.sdk.account.identitytoken.a.C3758a(r115);
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r103);
        long r116 = SystemClock.elapsedRealtime();
        final long r117 = SystemClock.elapsedRealtime();
        if (k.f406321e == true) goto L21;
        Object r118 = new com.bytedance.sdk.account.identitytoken.a.C3758a(-8);
    L27:
        int r119 = -10;
    L65:
        if ((r118 instanceof com.bytedance.sdk.account.identitytoken.a.b) == false) goto L67;
    L90:
        return r118;
    L67:
        if ((r118 instanceof com.bytedance.sdk.account.identitytoken.a.C3758a) == true) goto L69;
    L71:
        String r120 = r110.getLabel();
        if (r110 == GetIdentityTokenScene.PRELOAD) goto L75;
        boolean r121 = true;
    L76:
        r102.L$0 = this;     // Catch: Exception -> L14
        r102.L$1 = r110;     // Catch: Exception -> L14
        r102.L$2 = r111;     // Catch: Exception -> L14
        r102.J$0 = r116;     // Catch: Exception -> L14
        r102.L$3 = r118;     // Catch: Exception -> L14
        r102.L$4 = r120;     // Catch: Exception -> L14
        r102.label = 1;     // Catch: Exception -> L14
        r103 = f(r121, r111, r120, r116, true, r102);     // Catch: Exception -> L14
        if (r103 != r104) goto L79;
        return r104;
    L75:
        r121 = false;
        goto L76
    L69:
        if (((com.bytedance.sdk.account.identitytoken.a.C3758a) r118).f268918a == r119) goto L71;
    L21:
        com.bytedance.sdk.account.settings.common.a.a();
        if (com.bytedance.sdk.account.settings.common.a.B == true) goto L25;
        r118 = new com.bytedance.sdk.account.identitytoken.a.C3758a(-4);
        goto L27
    L25:
        if (b().isLogin() == true) goto L28;
        r118 = new com.bytedance.sdk.account.identitytoken.a.C3758a(-5);
        goto L27
    L28:
        IdentityTokenCacheStorage.f268899e.getClass();
        com.bytedance.sdk.account.identitytoken.b r122 = IdentityTokenCacheStorage.a();
        if (r122 != null) goto L31;
    L32:
        tb7.a.d("IdentityTokenManager", "getIdentityTokenFromCacheInternal, cache is null or expired, cache: " + r122 + " scene: " + r110 + ", enterFrom: " + r111 + ", isDirectGetCache: false");
    L33:
        if (r122 != null) goto L35;
    L37:
        boolean r123 = false;
    L38:
        if (r122 == null) goto L40;
        b().getUserId();
    L40:
        SystemClock.elapsedRealtime();
        ?? r124 = new IdentityTokenManager$getIdentityTokenFromCacheInternal$2(r110, r111, r117);
        if (r110 == GetIdentityTokenScene.RETRY) goto L55;
        if (r123 == false) goto L55;
        tb7.a.d("IdentityTokenManager", "getIdentityToken, cache valid, scene: " + r110 + ", enterFrom: " + r111);
        if (r122 != null) goto L47;
        Intrinsics.throwNpe();
    L47:
        if (r122.f268931j == false) goto L49;
    L50:
        StringBuilder r125 = new StringBuilder("getIdentityToken, cache need refresh, scene: ");
        r125.append(r110);
        r125.append(", enterFrom: ");
        r125.append(r111);
        r125.append(", isFromStorage: ");
        r125.append(r122.f268931j);
        r125.append(", cacheWallTime: ");
        r125.append(r122.f268923b);
        r125.append(", cacheElapsedTime: ");
        r125.append(r122.f268924c);
        r125.append(", currentElapsedTime: ");
        r125.append(SystemClock.elapsedRealtime());
        r125.append(", configRefreshTime: ");
        com.bytedance.sdk.account.settings.common.a.a();
        r125.append(com.bytedance.sdk.account.settings.common.a.D);
        r125.append(", isDirectGetCache: false");
        tb7.a.d("IdentityTokenManager", r125.toString());
        com.bytedance.sdk.account.settings.common.a.a();
        r124.invoke(com.bytedance.sdk.account.settings.common.a.F);
    L51:
        String r126 = r122.f268922a;
        if (r126 != null) goto L54;
        Intrinsics.throwNpe();
    L54:
        r118 = new com.bytedance.sdk.account.identitytoken.a.b(r126, true);
        goto L27
    L49:
        if (r122.b() == false) goto L51;
    L55:
        StringBuilder r127 = new StringBuilder("getIdentityToken, cache miss, scene: ");
        r127.append(r110);
        r127.append(", enterFrom: ");
        r127.append(r111);
        r127.append(", hasAnyCache: ");
        if (r122 == null) goto L58;
        boolean r128 = true;
    L59:
        r127.append(r128);
        r127.append(", cache time: ");
        if (r122 == null) goto L62;
        Long r129 = Long.valueOf(r122.f268923b);
    L63:
        r127.append(r129);
        r127.append(", isDirectGetCache: false");
        tb7.a.e("IdentityTokenManager", r127.toString());
        r119 = -10;
        r118 = new com.bytedance.sdk.account.identitytoken.a.C3758a(-10);
        goto L65
    L62:
        r129 = null;
        goto L63
    L58:
        r128 = false;
        goto L59
    L35:
        if (l.a(r122.f268922a) == true) goto L37;
        r123 = true;
        goto L38
    L31:
        if (r122.a() == false) goto L33;
    L14:
        e = move-exception;
        if ((e instanceof CancellationException) == true) goto L89;
        tb7.a.c("IdentityTokenManager", "getIdentityToken, requestIdentityTokenLocked throw exception", e);
        return new com.bytedance.sdk.account.identitytoken.a.C3758a(-1);
    L89:
        throw e;
    L7:
        r100 = new IdentityTokenManager$getIdentityTokenSuspend$1(this, r210);
        goto L8
    }

    public final Object e(boolean r110, String r111, String r112, Function1<? super d, Unit> r113, Continuation<? super d> r114) {
        if ((r114 instanceof IdentityTokenManager$requestIdentityToken$1) == false) goto L7;
        IdentityTokenManager$requestIdentityToken$1 r100 = (IdentityTokenManager$requestIdentityToken$1) r114;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        IdentityTokenManager$requestIdentityToken$1 r102 = r100;
        Object r103 = r102.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r102.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        String r106 = (String) r102.L$4;
        Function1 r107 = (Function1) r102.L$3;
        String r108 = (String) r102.L$2;
        String r109 = (String) r102.L$1;
        IdentityTokenManager r115 = (IdentityTokenManager) r102.L$0;
        ResultKt.throwOnFailure(r103);
    L17:
        d r116 = (d) r103;
        tb7.a.d("IdentityTokenManager", "requestIdentityToken: job starts");
        return r116;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        tb7.a.d("IdentityTokenManager", "requestIdentityTokenLocked: abTestGroup=, needForceGetTag=" + r110 + ", scene=" + r111 + ", triggerScene=" + r112);
        IdentityTokenRequestManager r117 = IdentityTokenRequestManager.f268913d;
        r102.L$0 = this;
        r102.Z$0 = r110;
        r102.L$1 = r111;
        r102.L$2 = r112;
        r102.L$3 = r113;
        r102.L$4 = "";
        r102.label = 1;
        r117.getClass();
        r103 = BuildersKt.withContext(Dispatchers.getIO(), new IdentityTokenRequestManager$getToken$2(r110, r111, r112, "", r113, null), r102);
        if (r103 != r104) goto L17;
        return r104;
    L7:
        r100 = new IdentityTokenManager$requestIdentityToken$1(this, r114);
        goto L8
    }

    public static final Deferred a(IdentityTokenManager r110, boolean r111, String r112, String r113, long r114, boolean r115) {
        r110.getClass();
        Lazy r100 = f268905f;
        KProperty r101 = f268900a[1];
        Deferred r102 = BuildersKt.async$default((CoroutineScope) r100.getValue(), null, null, new IdentityTokenManager$createDeferred$$inlined$run$lambda$1(null, r111, r112, r113, r114, r115), 3, null);
        f268902c = new a(r102, r111 ? 1 : 0);
        return r102;
    }

    public static /* synthetic */ Object f(boolean r100, String r110, String r111, long r112, boolean r113, Continuation r114) {
        return CoroutineScopeKt.coroutineScope(new IdentityTokenManager$requestIdentityTokenLocked$2(r100, r110, r111, r112, r113, null), r114);
    }

    public static void d(String r110, String r111, boolean r112, int r113, String r114, String r115, String r116, long r117, String r210, long r211, com.bytedance.sdk.account.identitytoken.b r212, String r213) {
        Pair[] r100 = new Pair[25];
        int r101 = 0;
        r100[0] = TuplesKt.to("scene", r110);
        int r102 = 1;
        r100[1] = TuplesKt.to("enter_from", r111);
        r100[2] = TuplesKt.to("is_retry", Integer.valueOf(r112 ? 1 : 0));
        r100[3] = TuplesKt.to("need_force_get_tag", Integer.valueOf(r112 ? 1 : 0));
        r100[4] = TuplesKt.to("error_code", Integer.valueOf(r113));
        r100[5] = TuplesKt.to("error_msg", r114);
        if (r115 == null) goto L5;
        com.bytedance.sdk.account.utils.k r103 = new com.bytedance.sdk.account.utils.k(r115);
    L6:
        r100[6] = TuplesKt.to("token", n.b(r103, 32));
        r100[7] = TuplesKt.to(CronetDataStorageAccess.LOGID, r116);
        r100[8] = TuplesKt.to("log_id", r116);
        r100[9] = TuplesKt.to("is_in_foreground", Integer.valueOf(com.bytedance.sdk.account.utils.d.d() ? 1 : 0));
        if (l.a(r115) == true) goto L10;
        int r104 = -1;
    L13:
        r100[10] = TuplesKt.to("network_available", Integer.valueOf(r104));
        r100[11] = TuplesKt.to("result", Integer.valueOf(!l.a(r115) ? 1 : 0));
        r100[12] = TuplesKt.to("duration", Long.valueOf(SystemClock.elapsedRealtime() - r117));
        r100[13] = TuplesKt.to("path", r210);
        r100[14] = TuplesKt.to("uid", Long.valueOf(r211));
        if (r212 == null) goto L30;
        String r105 = r212.f268922a;
        if (r105 == null) goto L18;
        com.bytedance.sdk.account.utils.k r106 = new com.bytedance.sdk.account.utils.k(r105);
    L20:
        if ((!Intrinsics.areEqual(r106, null)) == true) goto L22;
    L27:
        boolean r107 = false;
    L28:
        if (r107 == false) goto L30;
    L31:
        r100[15] = TuplesKt.to("has_cache", Integer.valueOf(r102));
        String r108 = "";
        if (r212 == null) goto L36;
        String r109 = r212.f268928g;
        if (r109 == null) goto L36;
    L37:
        r100[16] = TuplesKt.to("source_path", r109);
        if (r212 == null) goto L42;
        String r118 = r212.f268929h;
        if (r118 == null) goto L42;
    L43:
        r100[17] = TuplesKt.to("source_log_id", r118);
        if (r212 == null) goto L48;
        String r119 = r212.f268929h;
        if (r119 == null) goto L48;
    L49:
        r100[18] = TuplesKt.to("source_logid", r119);
        if (r212 == null) goto L52;
        long r120 = r212.f268923b;
    L53:
        r100[19] = TuplesKt.to("source_timestamp", Long.valueOf(r120));
        if (r212 == null) goto L58;
        String r121 = r212.f268930i;
        if (r121 == null) goto L58;
    L59:
        r100[20] = TuplesKt.to("source_ab_test_group", r121);
        if (r212 == null) goto L64;
        String r122 = r212.f268927f;
        if (r122 == null) goto L64;
        r108 = r122;
    L64:
        r100[21] = TuplesKt.to("source_enter_from", r108);
        long r123 = -1;
        if (r212 == null) goto L67;
        long r124 = r212.f268926e;
    L68:
        r100[22] = TuplesKt.to("source_uid", Long.valueOf(r124));
        if (r212 != null) goto L71;
    L75:
        r100[23] = TuplesKt.to("cache_life", Long.valueOf(r123));
        r100[24] = TuplesKt.to("ab_test_group", r213);
        JSONObject r125 = new JSONObject();
    L76:
        if (r101 >= 25) goto L78;
        Pair r126 = r100[r101];
        r125.putOpt((String) r126.getFirst(), r126.getSecond());
        r101 = r101 + 1;
        goto L76
    L78:
        com.bytedance.sdk.account.monitor.a.a("passport_get_identity_token", r125);
        return;
    L71:
        if (r212.f268924c > 0) goto L73;
        long r127 = System.currentTimeMillis();
        long r128 = r212.f268923b;
    L74:
        r123 = r127 - r128;
        goto L75
    L73:
        r127 = SystemClock.elapsedRealtime();
        r128 = r212.f268924c;
        goto L74
    L67:
        r124 = -1;
    L58:
        r121 = "";
        goto L59
    L52:
        r120 = 0;
    L48:
        r119 = "";
    L42:
        r118 = "";
    L36:
        r109 = "";
        goto L37
    L22:
        if (r105.length() <= 0) goto L24;
        boolean r129 = true;
    L25:
        if (r129 == false) goto L27;
        r107 = true;
        goto L28
    L24:
        r129 = false;
        goto L25
    L18:
        r106 = null;
    L30:
        r102 = 0;
        goto L31
    L10:
        if (NetworkUtils.d(k.c()) == false) goto L12;
        r104 = 1;
        goto L13
    L12:
        r104 = 0;
        goto L13
    L5:
        r103 = null;
        goto L6
    }
}
