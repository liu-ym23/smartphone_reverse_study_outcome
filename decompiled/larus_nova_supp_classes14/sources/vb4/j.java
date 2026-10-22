package vb4;

import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import com.bytedance.bdturing.livedetect.TuringBaseLiveDetectActivity;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class j implements Runnable {
    public final /* synthetic */ TuringBaseLiveDetectActivity a;

    @Override // java.lang.Runnable
    public final void run() {
        ImageView r0 = this.a.b;     // Catch: Throwable -> L7
        if (r0 == null) goto L10;
        r0.setVisibility(0);     // Catch: Throwable -> L7
        RotateAnimation r1 = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);     // Catch: Throwable -> L7
        r1.setDuration(1000);     // Catch: Throwable -> L7
        r1.setRepeatCount(-1);     // Catch: Throwable -> L7
        r1.setInterpolator(new LinearInterpolator());     // Catch: Throwable -> L7
        this.a.b.startAnimation(r1);     // Catch: Throwable -> L7
        return;
    L10:
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L14;
        throw th;
    }

    public j(TuringBaseLiveDetectActivity r1) {
        this.a = r1;
    }
}
