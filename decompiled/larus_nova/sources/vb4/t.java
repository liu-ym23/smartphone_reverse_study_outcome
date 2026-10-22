package vb4;

import com.bytedance.bdturing.livedetect.TuringLiveDetectActivity;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes14.dex */
public final class t implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TuringLiveDetectActivity f554047a;

    @Override // java.lang.Runnable
    public final void run() {
        TuringLiveDetectActivity r100 = this.f554047a;     // Catch: Throwable -> L9
        if (r100.f201829d == false) goto L14;
        return;
    L14:
        r100.P1();     // Catch: Exception -> L6 Throwable -> L9
        TuringLiveDetectActivity.G1(this.f554047a);     // Catch: Exception -> L6 Throwable -> L9
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

    public t(TuringLiveDetectActivity r100) {
        this.f554047a = r100;
    }
}
