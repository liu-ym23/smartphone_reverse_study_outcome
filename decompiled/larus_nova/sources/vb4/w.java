package vb4;

import com.bytedance.bdturing.livedetect.TuringLiveDetectActivity;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes14.dex */
public final class w implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TuringLiveDetectActivity f554050a;

    @Override // java.lang.Runnable
    public final void run() {
        this.f554050a.finish();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public w(TuringLiveDetectActivity r100) {
        this.f554050a = r100;
    }
}
