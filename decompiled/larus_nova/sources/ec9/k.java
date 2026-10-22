package ec9;

import com.bytedance.lego.init.InitScheduler;
import com.bytedance.lego.init.model.InitPeriod;

/* JADX INFO: loaded from: classes29.dex */
public final /* synthetic */ class k implements Runnable {
    public /* synthetic */ k() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        InitPeriod r100 = InitPeriod.MAIN_SUPER2ONRESUMEEND;
        InitScheduler.onPeriodStart(r100);
        InitScheduler.onPeriodEnd(r100);
    }
}
