package vb4;

import android.widget.ImageView;
import com.bytedance.bdturing.livedetect.TuringBaseLiveDetectActivity;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class k implements Runnable {
    public final /* synthetic */ TuringBaseLiveDetectActivity a;

    @Override // java.lang.Runnable
    public final void run() {
        ImageView r0 = this.a.b;     // Catch: Throwable -> L7
        if (r0 == null) goto L10;
        r0.clearAnimation();     // Catch: Throwable -> L7
        this.a.b.setVisibility(4);     // Catch: Throwable -> L7
        return;
    L10:
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L14;
        throw th;
    }

    public k(TuringBaseLiveDetectActivity r1) {
        this.a = r1;
    }
}
