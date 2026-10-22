package vb4;

import com.bytedance.bdturing.livedetect.TuringLiveDetectActivity;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class w implements Runnable {
    public final /* synthetic */ TuringLiveDetectActivity a;

    @Override // java.lang.Runnable
    public final void run() {
        this.a.finish();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public w(TuringLiveDetectActivity r1) {
        this.a = r1;
    }
}
