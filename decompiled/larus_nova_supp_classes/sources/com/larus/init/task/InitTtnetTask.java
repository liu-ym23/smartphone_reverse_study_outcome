package com.larus.init.task;

import android.util.EventsUtils;
import bf6.d;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.concurrent.ThreadPlus;
import com.bytedance.retrofit2.intercept.Interceptor;
import com.bytedance.ttnet.utils.RetrofitUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.business.debug.api.IDebugService;
import com.larus.common.apphost.AppHost;
import com.larus.common.mssdk.api.SecurityService;
import com.larus.network.ttnet.TTNetCommonQueryParamsInjector;
import com.larus.network.ttnet.p;
import com.larus.settings.value.cs;
import com.larus.settings.value.e10;
import com.larus.settings.value.iv;
import com.larus.settings.value.ow;
import com.larus.utils.l0;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.quota.BDNetworkTagManager;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00192\u00020\u00012\u00020\u0002:\u0001\u0019B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u0013H\u0002J\b\u0010\u0017\u001a\u00020\u0013H\u0002J\b\u0010\u0018\u001a\u00020\u0013H\u0002R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u0006X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0011\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/larus/init/task/InitTtnetTask;", "Lcom/bytedance/lego/init/model/IInitTask;", "Lcom/larus/init/task/base/IFlowInitReportTask;", "<init>", "()V", "scene", XmlPullParser.NO_NAMESPACE, "getScene", "()Ljava/lang/String;", "firstStyle", "getFirstStyle", "appNetworkConfig", "Lcom/larus/settings/net/InfraNetworkConfig;", "getAppNetworkConfig", "()Lcom/larus/settings/net/InfraNetworkConfig;", "appNetworkConfig$delegate", "Lkotlin/Lazy;", "TAG", "runInternal", XmlPullParser.NO_NAMESPACE, "isInteractorProcess", XmlPullParser.NO_NAMESPACE, "initInterfaceDyeing", "addBackgroundNetController", "addBackgroundNetworkInterceptorManager", "Companion", "app_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public final class InitTtnetTask extends d implements bg9.i {
    public static final /* synthetic */ int e = 0;
    public final String a;
    public final String b;
    public final Lazy c;
    public final String d;

    public static final class a {
    }

    static {
    }

    @Override // bg9.i
    public final void runInternal() {
        Map r0 = TTNetCommonQueryParamsInjector.a;
        FLogger.a.i("TTNetCommonQueryParamsInjector", "load skip, inject disabled");
        if (((nt9.b) this.c.getValue()).a() == true) goto L5;
    L7:
        String r1 = com.bytedance.apm.d.c();
        boolean r4 = false;
        if (r1 != null) goto L10;
    L12:
        if (r4 == false) goto L16;
        com.bytedance.frameworks.baselib.network.http.cookie.b.d.set(true);
        if (Logger.debug() == false) goto L16;
        Logger.d("CookieInitializer", "setForceDisableWebViewCookieMgr");
    L16:
        Lazy r2 = com.larus.network.m.a;
        String[] r3 = yo8.c.a;
        Map r5 = yo8.c.b;
        e10 r6 = e10.a;
        int r7 = l0.a;
        com.larus.network.m.b(r3, r5, ((Number) l0.a(2, new ow())).intValue(), (com.larus.network.h) l0.a(new com.larus.network.h(null), new cs()), 8);
        b r8 = new b();
        Intrinsics.checkNotNullParameter(r8, "listener");
        ((ArrayList) p.c).add(r8);
        ThreadPlus.submitRunnable(new l0(this));
        IDebugService r9 = (IDebugService) ServiceManager.get().getService(IDebugService.class);
        if (r9 == null) goto L22;
        Interceptor r10 = r9.n();
        if (r10 == null) goto L22;
        RetrofitUtils.addInterceptor(r10);
    L22:
        if (((Boolean) l0.a(Boolean.FALSE, new iv())).booleanValue() == false) goto L24;
        RetrofitUtils.addInterceptor(new gm9.c());
    L24:
        SecurityService r11 = (SecurityService) ServiceManager.get().getService(SecurityService.class);
        if (r11 == null) goto L28;
        r11.h();
        return;
    L28:
        return;
    L10:
        if (StringsKt.contains$default(r1, ":interactor", false, 2, null) != true) goto L12;
        r4 = true;
        goto L12
    L5:
        if (((nt9.b) this.c.getValue()).b() == false) goto L7;
        BDNetworkTagManager.getInstance().init(AppHost.a.getApplication(), new p0());
        goto L7
    }

    public InitTtnetTask() {
        this.a = "Infra";
        this.b = "asyncThreadWhenFirst";
        this.c = LazyKt.lazy(new k0());
        this.d = "InitTtnetTask";
    }

    @Override // java.lang.Runnable, bg9.i
    public final void run() {
        bg9.i.a.a(this);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    @Override // bg9.i
    public final String getScene() {
        return this.a;
    }

    @Override // bg9.i
    public final String v() {
        return this.b;
    }
}
