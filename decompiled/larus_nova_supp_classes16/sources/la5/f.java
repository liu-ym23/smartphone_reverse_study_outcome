package la5;

import android.view.GestureDetector;
import android.view.MotionEvent;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class f extends GestureDetector.SimpleOnGestureListener {
    public final /* synthetic */ i a;

    public f(i r1) {
        this.a = r1;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public final boolean onDoubleTap(MotionEvent r3) {
        this.a.getClass();
        tt5.a.k("DriveSdkSimpleTitleBar", "scrollToTop, not support in Drive.");
        return super.onDoubleTap(r3);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public final boolean onSingleTapConfirmed(MotionEvent r1) {
        return super.onSingleTapConfirmed(r1);
    }
}
