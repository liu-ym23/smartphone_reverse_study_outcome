package mm9;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import com.bytedance.common.utility.concurrent.ThreadPlus;
import com.bytedance.lego.init.InitScheduler;
import com.bytedance.lego.init.config.TaskConfig;
import com.bytedance.lego.init.monitor.InitMonitor;
import com.larus.common.apphost.AppHost;
import com.larus.common.mssdk.api.ISecPrivacyService;
import com.larus.home.api.main.HomeService;
import com.larus.hotpatch.IHotPatch;
import com.larus.mirabridge.api.plugin.service.IPluginInternalService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class r implements h {

    public static final class a implements ThreadFactory {
        public final AtomicInteger a;

        public a() {
            this.a = new AtomicInteger(1);
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable r4) {
            Intrinsics.checkNotNullParameter(r4, "r");
            return new PthreadThreadV2(r4, "_a_init_" + this.a.getAndIncrement());
        }
    }

    public r() {
    }

    @Override // mm9.h
    public final void a(Application r3) {
        Intrinsics.checkNotNullParameter(r3, "application");
        if (Build.VERSION.SDK_INT < 24) goto L9;
        IPluginInternalService r4 = (IPluginInternalService) ServiceManager.get().getService(IPluginInternalService.class);
        if (r4 == null) goto L8;
        r4.b(AppHost.a.getApplication());
    L8:
        FLogger.a.d("MiraInit", "init morpheus finish");
    L9:
        HomeService.a.U();
    }

    @Override // mm9.h
    public final void afterAttachBaseContext(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        IHotPatch r4 = (IHotPatch) ServiceManager.get().getService(IHotPatch.class);
        if (r4 == null) goto L6;
        r4.c();
    L6:
        if (Build.VERSION.SDK_INT < 24) goto L12;
        IPluginInternalService r5 = (IPluginInternalService) ServiceManager.get().getService(IPluginInternalService.class);
        if (r5 == null) goto L11;
        r5.d(AppHost.a.getApplication());
    L11:
        FLogger.a.d("MiraInit", "init mira finish");
    L12:
        HomeService.a.g0();
    }

    @Override // mm9.h
    public final void b(Application r2) {
        Intrinsics.checkNotNullParameter(r2, "application");
        HomeService.a.M(r2);
    }

    @Override // mm9.h
    public final void beforeAttachBaseContext(Context r9) {
        Intrinsics.checkNotNullParameter(r9, "context");
        long r0 = System.currentTimeMillis();
        HomeService r2 = HomeService.a;
        r2.G();
        InitMonitor r3 = InitMonitor.INSTANCE;
        r3.onAttachBase();
        boolean r4 = AppHost.a.isTestChannel();
        TaskConfig.Builder r1 = new TaskConfig.Builder(r9, com.bytedance.apm.d.l(), com.bytedance.apm.d.c()).isDebug(r4).setTimeOut(10000).enableCatchException(!r4).setThreadFactory(new a()).setCoreThreadNum(Runtime.getRuntime().availableProcessors() * 2).setExecutorService(ag9.a.a).setApplicationStartTime(r0);
        ISecPrivacyService.a.getClass();
        ISecPrivacyService r5 = ISecPrivacyService.a.a();
        if (r5 == null) goto L5;
        boolean r6 = r5.h();
    L6:
        InitScheduler.config(r1.agreePrivacyPopupWindow(r6).build());
        CountDownLatch r7 = bg9.f.a;
        r3.allowMonitor(false);
        ThreadPlus.submitRunnable(new q());
        r2.t(r9);
        return;
    L5:
        r6 = false;
        goto L6
    }
}
