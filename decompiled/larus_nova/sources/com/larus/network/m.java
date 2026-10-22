package com.larus.network;

import com.bytedance.common.utility.NetworkClient;
import com.bytedance.common.utility.concurrent.ThreadPlus;
import com.bytedance.retrofit2.OptConfig;
import com.bytedance.retrofit2.intercept.Interceptor;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.ttnet.TTNetInit;
import com.bytedance.ttnet.config.JsonOptConfig;
import com.bytedance.ttnet.utils.RetrofitUtils;
import com.larus.account.base.api.IAccountService;
import com.larus.common.apphost.AppHost;
import com.larus.common.mssdk.api.SecurityService;
import com.larus.network.ttnet.o;
import com.larus.network.ttnet.p;
import com.larus.network.ttnet.q;
import com.larus.platform.service.g0;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.common.spi.network.IObricSecurityNetworkService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ttnet.org.chromium.net.urlconnection.MessageLoop;
import hq9.q1;
import java.io.File;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f360210a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile String f360211b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile String f360212c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile String f360213d;

    public m() {
    }

    static {
        f360210a = LazyKt.lazy(new l());
        boolean r100 = g.f360110a;
        f360211b = "";
        f360212c = "";
        f360213d = "";
    }

    public static q1 a() {
        return (q1) f360210a.getValue();
    }

    public static void c(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "boeEnv");
        Intrinsics.checkNotNullParameter(r101, "ppeEnv");
        boolean r102 = g.f360110a;
        Intrinsics.checkNotNullParameter(r100, "boeEnv");
        Intrinsics.checkNotNullParameter(r101, "ppeEnv");
    }

    public static void b(String[] r110, Map r111, int r112, h r113, int r114) {
        Unit r100 = null;
        if ((r114 & 8) == 0) goto L5;
        List r101 = CollectionsKt.emptyList();
    L7:
        if ((r114 & 16) == 0) goto L10;
        r112 = 2;
    L10:
        if ((r114 & 32) == 0) goto L12;
        r113 = new h(null);
    L12:
        Intrinsics.checkNotNullParameter(r110, "configServers");
        Intrinsics.checkNotNullParameter(r111, "serviceDomainMap");
        Intrinsics.checkNotNullParameter(r101, "interceptors");
        Intrinsics.checkNotNullParameter(r113, "flowAccessControlConfig");
        String[] r102 = p.f360240a;
        Intrinsics.checkNotNullParameter(r110, "configServersArray");
        Intrinsics.checkNotNullParameter(r111, "serviceDomainMap");
        Intrinsics.checkNotNullParameter(r113, "flowAccessControlConfig");
        p.f360240a = r110;
        p.f360241b = r111;
        p.f360243d = true;
        AppHost.Companion r115 = AppHost.f326268a;
        boolean r103 = false;
        if (r115.isDebug() == false) goto L15;
    L18:
        boolean r116 = true;
    L20:
        if (r116 == false) goto L100;
    L98:
        Result.Companion r117 = Result.Companion;     // Catch: Throwable -> L61
        org.chromium.d r118 = org.chromium.d.a();     // Catch: Throwable -> L61
        com.larus.network.ttnet.c r119 = com.larus.network.ttnet.c.f360221a;     // Catch: Throwable -> L61
        r118.f525638a = r119;     // Catch: Throwable -> L61
        org.chromium.c.h().l(r119);     // Catch: Throwable -> L61
        TTNetInit.setTTNetDepend(com.larus.network.ttnet.i.f360239a);     // Catch: Throwable -> L61
        AppHost.Companion r120 = AppHost.f326268a;     // Catch: Throwable -> L61
        if (r120.isOversea() == true) goto L42;
        sx5.b.f543816o = true;     // Catch: Throwable -> L61
    L42:
        TTNetInit.setCronetDepend(r119);     // Catch: Throwable -> L61
        TTNetInit.setBypassOfflineCheck(true);     // Catch: Throwable -> L61
        SecurityService r121 = (SecurityService) ServiceManager.get().getService(SecurityService.class);     // Catch: Throwable -> L61
        if (r121 != null) goto L45;
    L47:
        boolean r122 = false;
    L48:
        if (r122 == false) goto L50;
        FLogger.f375446a.i("TTNetExt", "enable ttnet encrypt");     // Catch: Throwable -> L61
        TTNetInit.setRetryEncryptedRequestEnabled(new com.larus.network.ttnet.l());     // Catch: Throwable -> L61
    L50:
        TTNetInit.setStateDelayNewStrategyEnabled(true);     // Catch: Throwable -> L61
        TTNetInit.setTelemetryOptionFlags(r112);     // Catch: Throwable -> L61
        if (((Boolean) p.f360248i.getValue()).booleanValue() == false) goto L53;
        JsonOptConfig.enableJsonOpt(true);     // Catch: Throwable -> L61
        JsonOptConfig.enableTNCJsonOpt(true);     // Catch: Throwable -> L61
        JsonOptConfig.setJsonHandler(new com.larus.network.ttnet.m());     // Catch: Throwable -> L61
        OptConfig.setEnableRequestOpt(true);     // Catch: Throwable -> L61
    L53:
        TTNetInit.tryInitTTNet(r120.getApplication(), r120.getApplication(), com.larus.network.ttnet.a.f360220a, com.larus.network.ttnet.e.f360227a, new q(), true, new boolean[]{true});     // Catch: Throwable -> L61
        if (((hq9.j) p.f360249j.getValue()).h() == true) goto L56;
        TTNetInit.preInitCronetKernel();     // Catch: Throwable -> L61
    L56:
        ThreadPlus.submitRunnable(new com.larus.network.ttnet.n());     // Catch: Throwable -> L61
        IObricSecurityNetworkService r123 = (IObricSecurityNetworkService) ServiceManager.get().getService(IObricSecurityNetworkService.class);     // Catch: Throwable -> L61
        if (r123 == null) goto L59;
        r123.c(r120.getApplication());     // Catch: Throwable -> L61
        r100 = Unit.INSTANCE;     // Catch: Throwable -> L61
    L59:
        Object r124 = Result.m9449constructorimpl(r100);     // Catch: Throwable -> L61
    L63:
        Throwable r125 = Result.m9452exceptionOrNullimpl(r124);
        if (r125 == null) goto L67;
        FLogger.f375446a.e("TTNetExt", "init error", r125);
    L67:
        RetrofitUtils.addInterceptor(new gm9.m());
        RetrofitUtils.addInterceptor(new gm9.b());
        SecurityService r126 = (SecurityService) ServiceManager.get().getService(SecurityService.class);
        if (r126 != null) goto L70;
    L72:
        boolean r127 = false;
    L73:
        if (r127 == false) goto L75;
        RetrofitUtils.addInterceptor(new gm9.p());
    L75:
        SecurityService r128 = (SecurityService) ServiceManager.get().getService(SecurityService.class);
        if (r128 != null) goto L78;
    L80:
        if (r103 == false) goto L82;
        RetrofitUtils.addInterceptor(new gm9.q());
    L82:
        RetrofitUtils.addInterceptor(new gm9.n());
        RetrofitUtils.addInterceptor(new gm9.h());
        if (AppHost.f326268a.isOversea() == true) goto L93;
        gm9.k r129 = gm9.k.f481765a;
        r129.getClass();
        Intrinsics.checkNotNullParameter(r113, "config");
        gm9.k.f481768d = r113;
        if (Intrinsics.areEqual(r113.b(), Boolean.FALSE) == false) goto L87;
        FLogger.f375446a.i("FlowAccessControl", "Skip access control interceptor registration, reason=disabled");
    L88:
        SecurityService r130 = (SecurityService) ServiceManager.get().getService(SecurityService.class);
        if (r130 == null) goto L93;
        t74.a r131 = r130.F();
        if (r131 == null) goto L93;
        RetrofitUtils.addInterceptor(r131);
        goto L93
    L87:
        RetrofitUtils.addInterceptor(r129);
    L93:
        Interceptor r132 = IAccountService.f286094a.t();
        if (r132 == null) goto L96;
        RetrofitUtils.addInterceptor(r132);
    L96:
        g0.f365740a.i();
        NetworkClient.setDefault(new px3.a());
        MessageLoop.disableVaildThreadAssert(true);
        ThreadPlus.submitRunnable(new o());
        return;
    L78:
        if (r128.u() != true) goto L80;
        r103 = true;
        goto L80
    L70:
        if (r126.j() != true) goto L72;
        r127 = true;
        goto L73
    L45:
        if (r121.u() != true) goto L47;
        r122 = true;
    L61:
        th = move-exception;
        Result.Companion r133 = Result.Companion;
        r124 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L63
    L100:
        Result.Companion r134 = Result.Companion;     // Catch: Throwable -> L34
        File r135 = r115.getApplication().getExternalCacheDir();     // Catch: Throwable -> L34
        if (r135 == null) goto L32;
        PolarisFileWrapper r136 = new PolarisFileWrapper(r135, "ttnet_debug.log");     // Catch: Throwable -> L34
        if (r136.isFile() == false) goto L32;
        if (r136.delete() == true) goto L32;
        if (r136.exists() == false) goto L32;
        FLogger.f375446a.w("TTNetExt", "Failed to delete stale TTNet debug log");     // Catch: Throwable -> L34
    L32:
        Object r137 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L34
    L36:
        Throwable r138 = Result.m9452exceptionOrNullimpl(r137);
        if (r138 == null) goto L98;
        FLogger.f375446a.w("TTNetExt", "Failed to clean stale TTNet debug log", r138);
    L34:
        th = move-exception;
        Result.Companion r139 = Result.Companion;
        r137 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L36
    L15:
        if (StringsKt.equals("local_test", r115.getBuildChannel(), true) == true) goto L18;
        r116 = false;
        goto L20
    L5:
        r101 = null;
        goto L7
    }
}
