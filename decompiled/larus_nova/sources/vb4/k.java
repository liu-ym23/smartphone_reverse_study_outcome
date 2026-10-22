package vb4;

import android.widget.ImageView;
import com.bytedance.bdturing.livedetect.TuringBaseLiveDetectActivity;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes14.dex */
public final class k implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TuringBaseLiveDetectActivity f554036a;

    @Override // java.lang.Runnable
    public final void run() {
        ImageView r100 = this.f554036a.f201824b;     // Catch: Throwable -> L7
        if (r100 == null) goto L10;
        r100.clearAnimation();     // Catch: Throwable -> L7
        this.f554036a.f201824b.setVisibility(4);     // Catch: Throwable -> L7
        return;
    L10:
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L14;
        throw th;
    }

    public k(TuringBaseLiveDetectActivity r100) {
        this.f554036a = r100;
    }
}
