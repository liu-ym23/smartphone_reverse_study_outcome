package com.larus.common.account.platform.larkauth;

import android.os.Build;
import android.os.Looper;
import android.os.Message;
import com.bytedance.keva.Keva;
import com.bytedance.sdk.account.utils.s;
import com.google.gson.Gson;
import com.larus.applog.api.IApplog;
import com.larus.settings.value.e10;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.sync.MutexImpl;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class AuthorizationFactory implements s.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AuthorizationFactory f326109a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f326110b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final long f326111c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f326112d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final s f326113e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Lazy f326114f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Lazy f326115g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Long> f326116h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static com.bytedance.dpop.c f326117i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final MutexImpl f326118j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static volatile a09.a f326119k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static String f326120l;

    public AuthorizationFactory() {
    }

    static {
        AuthorizationFactory r100 = new AuthorizationFactory();
        f326109a = r100;
        f326110b = 2;
        f326111c = 3600000;
        f326114f = LazyKt.lazy(new a());
        f326115g = LazyKt.lazy(new b());
        f326116h = new ConcurrentHashMap();
        f326118j = kotlinx.coroutines.sync.b.a();
        f326113e = new s(Looper.getMainLooper(), r100);
        e10 r101 = e10.f368561a;
        int r102 = e10.Z().getMaxRetryCount();
        f326110b = r102;
        if (r102 > 0) goto L5;
        f326110b = 2;
    L5:
        long r103 = ((long) e10.Z().getHeartBeatInterval()) * 1000;
        f326111c = r103;
        if (r103 > 0) goto L8;
        f326111c = 3600000;
    L8:
        FLogger.f375446a.i("AuthorizationFactory", "init maxRetryTimes=" + f326110b + ", heatBeatInterval=" + f326111c);
    }

    public static zz8.c d() {
        return (zz8.c) f326115g.getValue();
    }

    public static String f() {
        ConcurrentHashMap<String, Long> r100 = f326116h;
        String r101 = (String) CollectionsKt.firstOrNull(r100.keySet());
        if (o0.d(r101) == false) goto L11;
        long r102 = System.currentTimeMillis();
        Long r103 = r100.get(r101);
        if (r103 == null) goto L7;
        long r104 = r103.longValue();
    L9:
        if ((r102 - r104) >= 4000) goto L11;
        return r101;
    L7:
        r104 = 0;
    L11:
        String r105 = null;
        Object r106 = null;
        r105 = null;
        if (Build.VERSION.SDK_INT < 24) goto L27;
        com.bytedance.dpop.c r107 = f326117i;
        if (r107 != null) goto L19;
        int r108 = com.bytedance.dpop.c.f204775e;
        Object r109 = com.bytedance.dpop.c.a.a(d().f574105d, new ml4.c(d().f574106e));
        if (Result.m9455isFailureimpl(r109) == false) goto L18;
        r109 = null;
    L18:
        r107 = (com.bytedance.dpop.c) r109;
    L19:
        f326117i = r107;
        if (r107 == null) goto L27;
        Object r110 = r107.a().a();
        if (Result.m9455isFailureimpl(r110) == true) goto L25;
        r106 = r110;
    L25:
        r105 = (String) r106;
    L27:
        if (o0.d(r105) == false) goto L32;
        if (r105 != null) goto L30;
        String r111 = "";
    L31:
        r100.put(r111, Long.valueOf(System.currentTimeMillis()));
        IApplog.Companion r112 = IApplog.f287053a;
        JSONObject r113 = new JSONObject();
        r113.put("success", 1);
        Unit r114 = Unit.INSTANCE;
        r112.reportEvent("lark_auth_dpop_result", r113);
    L33:
        return r105;
    L30:
        r111 = r105;
        goto L31
    L32:
        IApplog.Companion r115 = IApplog.f287053a;
        JSONObject r116 = new JSONObject();
        r116.put("success", 0);
        Unit r117 = Unit.INSTANCE;
        r115.reportEvent("lark_auth_dpop_result", r116);
        goto L33
    }

    public static String b() {
        zz8.c r100 = d();
        LarkAuthTokenFetcher r101 = LarkAuthTokenFetcher.f326121a;
        return r100.a(LarkAuthTokenFetcher.a().f326143c);
    }

    public static a09.a e() {
        String r100 = b();
        a09.a r101 = f326119k;
        if (Intrinsics.areEqual(f326120l, r100) == true) goto L7;
        return null;
    L7:
        return r101;
    }

    public static final void a(AuthorizationFactory r100) {
        r100.getClass();
        String r101 = b();
        String r102 = ((Keva) f326114f.getValue()).getString(r101, "");
        Intrinsics.checkNotNull(r102);
        boolean r103 = true;
        if (r102.length() <= 0) goto L5;
        boolean r104 = true;
    L6:
        if (r104 == false) goto L35;
        Gson r105 = new Gson();     // Catch: Exception -> L28
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L10
        Object r107 = Result.m9449constructorimpl((a09.a) r105.fromJson(r102, a09.a.class));     // Catch: Throwable -> L10
    L13:
        if (Result.m9455isFailureimpl(r107) == false) goto L15;
        r107 = null;
    L15:
        a09.a r108 = (a09.a) r107;     // Catch: Exception -> L28
        if (r108 != null) goto L18;
    L20:
        r103 = false;
    L21:
        if (r103 == false) goto L36;
        f326119k = r108;     // Catch: Exception -> L28
        if (r108 != null) goto L26;
        r101 = null;
    L26:
        f326120l = r101;     // Catch: Exception -> L28
        return;
    L36:
        return;
    L18:
        if (r108.d() == true) goto L20;
    L10:
        th = move-exception;
        Result.Companion r109 = Result.Companion;     // Catch: Exception -> L28
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Exception -> L28
    L28:
        e = move-exception;
        FLogger.f375446a.e("AuthorizationFactory", "getTokenWithCache error e=" + e.getMessage());
        return;
    L35:
        return;
    L5:
        r104 = false;
        goto L6
    }

    public static void i(boolean r100) {
        FLogger.f375446a.i("AuthorizationFactory", "tryUpdateToken fromCache=" + r100);
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new AuthorizationFactory$tryUpdateToken$1(r100, null), 2, null);
    }

    public final Object g(Continuation r100) {
        if ((r100 instanceof AuthorizationFactory$getTokenByNet$1) == false) goto L7;
        AuthorizationFactory$getTokenByNet$1 r101 = (AuthorizationFactory$getTokenByNet$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        boolean r106 = true;
        if (r105 == 0) goto L20;
        if (r105 == 1) goto L19;
        if (r105 != 2) goto L18;
        String r107 = (String) r101.L$1;
        kotlinx.coroutines.sync.a r108 = (kotlinx.coroutines.sync.a) r101.L$0;
        ResultKt.throwOnFailure(r103);     // Catch: Throwable -> L15
    L27:
        a09.a r109 = (a09.a) r103;     // Catch: Throwable -> L15
        if (r109 == null) goto L30;
        f326109a.getClass();     // Catch: Throwable -> L15
        h(r109, r107);     // Catch: Throwable -> L15
    L30:
        a09.a r110 = (a09.a) r103;     // Catch: Throwable -> L15
        r108.unlock(null);
        FLogger r111 = FLogger.f375446a;
        StringBuilder r112 = new StringBuilder("fetch token completed, hasResponse=");
        if (r110 != null) goto L35;
        r106 = false;
    L35:
        r112.append(r106);
        r111.i("AuthorizationFactory", r112.toString());
        if (r110 != null) goto L38;
        r111.i("AuthorizationFactory", "fetch token net error");
    L38:
        return r110;
    L15:
        th = th;
        kotlinx.coroutines.sync.a r113 = r108;
    L41:
        r113.unlock(null);
        throw th;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        r113 = (kotlinx.coroutines.sync.a) r101.L$0;
        ResultKt.throwOnFailure(r103);
    L45:
        f326109a.getClass();     // Catch: Throwable -> L40
        String r114 = b();     // Catch: Throwable -> L40
        LarkAuthTokenFetcher r115 = LarkAuthTokenFetcher.f326121a;     // Catch: Throwable -> L40
        String r116 = f();     // Catch: Throwable -> L40
        r101.L$0 = r113;     // Catch: Throwable -> L40
        r101.L$1 = r114;     // Catch: Throwable -> L40
        r101.label = 2;     // Catch: Throwable -> L40
        Object r117 = LarkAuthTokenFetcher.c(r116, null, null, r101);     // Catch: Throwable -> L40
        if (r117 != r104) goto L26;
        return r104;
    L26:
        r107 = r114;
        r103 = r117;
        r108 = r113;
    L40:
        th = th;
        goto L41
    L20:
        ResultKt.throwOnFailure(r103);
        r113 = f326118j;
        r101.L$0 = r113;
        r101.label = 1;
        if (r113.a(null, r101) != r104) goto L45;
        return r104;
    L7:
        r101 = new AuthorizationFactory$getTokenByNet$1(this, r100);
        goto L8
    }

    @Override // com.bytedance.sdk.account.utils.s.a
    public final void handleMsg(Message r100) {
        boolean r101 = false;
        if (r100 != null) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == false) goto L13;
        s r103 = f326113e;
        if (r103 == null) goto L12;
        r103.removeMessages(1000);
    L12:
        i(false);
        return;
    L13:
        if (r100 != null) goto L15;
    L17:
        if (r101 == false) goto L21;
        i(true);
        return;
    L21:
        return;
    L15:
        if (r100.what != 2000) goto L17;
        r101 = true;
        goto L17
    L5:
        if (r100.what != 1000) goto L7;
        r102 = true;
        goto L8
    }

    public static boolean h(a09.a r100, String r101) {
        if (Intrinsics.areEqual(r101, b()) == true) goto L15;
        FLogger.f375446a.i("AuthorizationFactory", "account kind changed while fetching token");
        return false;
    L15:
        ((Keva) f326114f.getValue()).storeString(r101, new Gson().toJson(r100));     // Catch: Exception -> L12
        f326119k = r100;     // Catch: Exception -> L12
        if (r100 != null) goto L10;
        r101 = null;
    L10:
        f326120l = r101;     // Catch: Exception -> L12
        return true;
    L12:
        e = move-exception;
        FLogger.f375446a.e("AuthorizationFactory", "storeString error e=" + e.getMessage());
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object c(String r100, String r110, Continuation<? super a09.a> r111) {
        if ((r111 instanceof AuthorizationFactory$forceRefreshToken$1) == false) goto L7;
        AuthorizationFactory$forceRefreshToken$1 r101 = (AuthorizationFactory$forceRefreshToken$1) r111;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r112 = r101.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r101.label;
        boolean r105 = true;
        if (r104 == 0) goto L18;
        if (r104 == 1) goto L17;
        if (r104 != 2) goto L16;
        String r106 = (String) r101.L$1;
        kotlinx.coroutines.sync.a r113 = (kotlinx.coroutines.sync.a) r101.L$0;
        ResultKt.throwOnFailure(r112);     // Catch: Throwable -> L52
    L26:
        a09.a r114 = (a09.a) r112;     // Catch: Throwable -> L52
        if (r114 == null) goto L29;
        String r107 = r114.a();     // Catch: Throwable -> L52
    L31:
        if (r107 != null) goto L33;
    L36:
        if (r105 == true) goto L54;
        if (r114 == null) goto L41;
        Integer r108 = r114.b();     // Catch: Throwable -> L52
        if (r108 == null) goto L41;
        int r109 = r108.intValue();     // Catch: Throwable -> L52
    L42:
        if (r109 != 0) goto L54;
        f326109a.getClass();     // Catch: Throwable -> L52
        if (h(r114, r106) == false) goto L55;
        f326112d = 0;     // Catch: Throwable -> L52
        s r115 = f326113e;     // Catch: Throwable -> L52
        if (r115 == null) goto L50;
        r115.removeMessages(1000);     // Catch: Throwable -> L52
    L50:
        if (r115 == null) goto L56;
        Boxing.boxBoolean(r115.sendEmptyMessageDelayed(1000, f326111c));     // Catch: Throwable -> L52
    L56:
        r113.unlock(null);
        return r114;
    L55:
        r114 = null;
    L41:
        r109 = 0;
    L54:
        FLogger.f375446a.w("AuthorizationFactory", "force refresh token failed");     // Catch: Throwable -> L52
        goto L55
    L33:
        if (r107.length() == 0) goto L36;
        r105 = false;
        goto L36
    L29:
        r107 = null;
        goto L31
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        kotlinx.coroutines.sync.a r116 = (kotlinx.coroutines.sync.a) r101.L$2;
        String r117 = (String) r101.L$1;
        String r118 = (String) r101.L$0;
        ResultKt.throwOnFailure(r112);
        String r119 = r117;
        r113 = r116;
        r100 = r118;
    L22:
        f326109a.getClass();     // Catch: Throwable -> L52
        String r120 = b();     // Catch: Throwable -> L52
        LarkAuthTokenFetcher r121 = LarkAuthTokenFetcher.f326121a;     // Catch: Throwable -> L52
        String r122 = f();     // Catch: Throwable -> L52
        r101.L$0 = r113;     // Catch: Throwable -> L52
        r101.L$1 = r120;     // Catch: Throwable -> L52
        r101.L$2 = null;     // Catch: Throwable -> L52
        r101.label = 2;     // Catch: Throwable -> L52
        r112 = LarkAuthTokenFetcher.c(r122, r100, r119, r101);     // Catch: Throwable -> L52
        if (r112 != r103) goto L25;
        return r103;
    L25:
        r106 = r120;
        goto L26
    L18:
        ResultKt.throwOnFailure(r112);
        MutexImpl r123 = f326118j;
        r101.L$0 = r100;
        r101.L$1 = r110;
        r101.L$2 = r123;
        r101.label = 1;
        if (r123.a(null, r101) != r103) goto L21;
        return r103;
    L21:
        r119 = r110;
        r113 = r123;
    L52:
        th = move-exception;
        r110.unlock(null);
        throw th;
    L7:
        r101 = new AuthorizationFactory$forceRefreshToken$1(this, r111);
        goto L8
    }
}
