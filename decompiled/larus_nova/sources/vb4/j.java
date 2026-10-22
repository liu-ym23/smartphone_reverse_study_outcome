package vb4;

import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import com.bytedance.bdturing.livedetect.TuringBaseLiveDetectActivity;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes14.dex */
public final class j implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TuringBaseLiveDetectActivity f554035a;

    @Override // java.lang.Runnable
    public final void run() {
        ImageView r100 = this.f554035a.f201824b;     // Catch: Throwable -> L7
        if (r100 == null) goto L10;
        r100.setVisibility(0);     // Catch: Throwable -> L7
        RotateAnimation r101 = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);     // Catch: Throwable -> L7
        r101.setDuration(1000);     // Catch: Throwable -> L7
        r101.setRepeatCount(-1);     // Catch: Throwable -> L7
        r101.setInterpolator(new LinearInterpolator());     // Catch: Throwable -> L7
        this.f554035a.f201824b.startAnimation(r101);     // Catch: Throwable -> L7
        return;
    L10:
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L14;
        throw th;
    }

    public j(TuringBaseLiveDetectActivity r100) {
        this.f554035a = r100;
    }
}
