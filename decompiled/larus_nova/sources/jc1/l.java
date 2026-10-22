package jc1;

import android.view.GestureDetector;
import android.view.MotionEvent;

/* JADX INFO: loaded from: classes7.dex */
public class l extends GestureDetector.SimpleOnGestureListener implements GestureDetector.OnGestureListener {
    public l() {
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent r100, MotionEvent r101, float r102, float r103) {
        return super.onFling(r100, r101, r102, r103);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent r100, MotionEvent r101, float r102, float r103) {
        return super.onScroll(r100, r101, r102, r103);
    }
}
