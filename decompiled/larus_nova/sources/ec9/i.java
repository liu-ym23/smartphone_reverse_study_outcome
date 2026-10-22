package ec9;

import com.bytedance.lego.init.InitScheduler;
import com.bytedance.lego.init.model.InitPeriod;
import com.larus.home.api.main.IInitPeriodService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class i implements Runnable {
    public /* synthetic */ i() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        IInitPeriodService r100 = (IInitPeriodService) ServiceManager.get().getService(IInitPeriodService.class);
        if (r100 == null) goto L5;
        r100.b();
    L5:
        FLogger.f375446a.d("InitPeriodWrapper", "InitPeriodWrapper - after application create, curMills = " + System.currentTimeMillis());
        InitPeriod r101 = InitPeriod.APP_SUPER2ONCREATEEND;
        InitScheduler.onPeriodStart(r101);
        InitScheduler.onPeriodEnd(r101);
        InitScheduler.startDispatchDelayTask();
        InitScheduler.startDispatchIdleTask();
    }
}
