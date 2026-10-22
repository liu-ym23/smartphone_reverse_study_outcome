package qp9;

import android.view.MotionEvent;

/* JADX INFO: loaded from: classes31.dex */
public interface i {
    void a(rp9.c r100);

    void b(j r100);

    boolean c(j r100);

    boolean d(j r100);

    void onDoubleTap(MotionEvent r100);

    boolean onDown(MotionEvent r100);

    void onFling(MotionEvent r100, MotionEvent r101, float r102, float r103);

    void onLongPress(MotionEvent r100);

    boolean onScroll(MotionEvent r100, MotionEvent r101, float r102, float r103);

    void onSingleTapConfirmed(MotionEvent r100);
}
