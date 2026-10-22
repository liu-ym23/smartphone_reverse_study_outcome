package vb4;

import com.bytedance.bdturing.livedetect.TuringLiveDetectActivity;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class t implements Runnable {
    public final /* synthetic */ TuringLiveDetectActivity a;

    @Override // java.lang.Runnable
    public final void run() {
        TuringLiveDetectActivity r0 = this.a;     // Catch: Throwable -> L9
        if (r0.d == false) goto L14;
        return;
    L14:
        r0.P1();     // Catch: Exception -> L6 Throwable -> L9
        TuringLiveDetectActivity.G1(this.a);     // Catch: Exception -> L6 Throwable -> L9
    L19:
        return;
    L6:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L18;
        throw th;
    }

    public t(TuringLiveDetectActivity r1) {
        this.a = r1;
    }
}
