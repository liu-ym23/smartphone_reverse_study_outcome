package dj4;

import android.view.MotionEvent;

/* JADX INFO: loaded from: classes15.dex */
public interface f {
    void a(vhc.b r100);

    boolean b(i r100);

    boolean c(i r100);

    void d(i r100);

    void onDoubleTap(MotionEvent r100);

    boolean onDown(MotionEvent r100);

    void onFling(MotionEvent r100, MotionEvent r101, float r102, float r103);

    void onLongPress(MotionEvent r100);

    boolean onScroll(MotionEvent r100, MotionEvent r101, float r102, float r103);

    void onSingleTapConfirmed(MotionEvent r100);
}
