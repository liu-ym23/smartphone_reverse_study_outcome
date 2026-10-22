package ec9;

import com.bytedance.lego.init.InitScheduler;
import com.bytedance.lego.init.model.InitPeriod;

/* JADX INFO: loaded from: classes29.dex */
public final /* synthetic */ class b implements Runnable {
    public /* synthetic */ b() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        InitPeriod r100 = InitPeriod.MAIN_ONRESUME2SUPER;
        InitScheduler.onPeriodStart(r100);
        InitScheduler.onPeriodEnd(r100);
    }
}
