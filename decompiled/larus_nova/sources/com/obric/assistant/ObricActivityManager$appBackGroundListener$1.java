package com.obric.assistant;

import android.os.SystemClock;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.reporter.IObricReporter;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes4.dex */
public final class ObricActivityManager$appBackGroundListener$1 implements f09.a.b {
    public ObricActivityManager$appBackGroundListener$1() {
    }

    @Override // f09.a.b
    public final void onAllActivityDestroyed() {
        FLogger r100 = FLogger.f375446a;
        Job r101 = ObricActivityManager.f385129a;
        r100.d("ObricActivityManager", "onAllActivityDestroyed");
    }

    @Override // f09.a.b
    public final void onAppBackground() {
        FLogger r100 = FLogger.f375446a;
        Job r101 = ObricActivityManager.f385129a;
        r100.d("ObricActivityManager", "onAppBackground");
        IObricReporter r102 = (IObricReporter) ObricActivityManager.f385132d.getValue();
        if (r102 == null) goto L5;
        SystemClock.elapsedRealtime();
        r102.g();
    L5:
        Job r103 = ObricActivityManager.f385129a;
        if (r103 == null) goto L8;
        Job.DefaultImpls.cancel$default(r103, null, 1, null);
    L8:
        ObricActivityManager.f385129a = null;
        ObricActivityManager.f385129a = BuildersKt.launch$default(ObricActivityManager.f385131c, null, null, new ObricActivityManager$appBackGroundListener$1$onAppBackground$1(null), 3, null);
    }

    @Override // f09.a.b
    public final void onAppForeground() {
        FLogger r100 = FLogger.f375446a;
        Job r101 = ObricActivityManager.f385129a;
        r100.d("ObricActivityManager", "onAppForeground");
        Job r102 = ObricActivityManager.f385129a;
        if (r102 == null) goto L5;
        Job.DefaultImpls.cancel$default(r102, null, 1, null);
    L5:
        ObricActivityManager.f385129a = null;
    }
}
