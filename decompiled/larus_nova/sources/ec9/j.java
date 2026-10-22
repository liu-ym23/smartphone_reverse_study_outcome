package ec9;

import com.bytedance.lego.init.InitScheduler;
import com.bytedance.lego.init.model.InitPeriod;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: classes29.dex */
public final /* synthetic */ class j implements Runnable {
    public /* synthetic */ j() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        FLogger.f375446a.d("InitPeriodWrapper", "InitPeriodWrapper - after super activity end, curMills = " + System.currentTimeMillis());
        InitScheduler.onPeriodEnd(InitPeriod.MAIN_SUPER2ONCREATEEND);
    }
}
