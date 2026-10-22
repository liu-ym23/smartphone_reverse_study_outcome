package ec9;

import com.bytedance.lego.init.InitScheduler;
import com.bytedance.lego.init.model.InitPeriod;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class h implements Runnable {
    public /* synthetic */ h() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        InitPeriod r100 = InitPeriod.APP_SUPER2ATTACHBASEEND;
        InitScheduler.onPeriodStart(r100);
        InitScheduler.onPeriodEnd(r100);
    }
}
