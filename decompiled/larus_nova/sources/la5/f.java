package la5;

import android.view.GestureDetector;
import android.view.MotionEvent;

/* JADX INFO: loaded from: classes16.dex */
public final class f extends GestureDetector.SimpleOnGestureListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f508179a;

    public f(i r100) {
        this.f508179a = r100;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public final boolean onDoubleTap(MotionEvent r100) {
        this.f508179a.getClass();
        tt5.a.k("DriveSdkSimpleTitleBar", "scrollToTop, not support in Drive.");
        return super.onDoubleTap(r100);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public final boolean onSingleTapConfirmed(MotionEvent r100) {
        return super.onSingleTapConfirmed(r100);
    }
}
