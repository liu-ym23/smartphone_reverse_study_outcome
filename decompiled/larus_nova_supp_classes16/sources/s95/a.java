package s95;

import android.view.ScaleGestureDetector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a implements ScaleGestureDetector.OnScaleGestureListener {
    public final /* synthetic */ b a;

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public final boolean onScaleBegin(ScaleGestureDetector r1) {
        return true;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public final void onScaleEnd(ScaleGestureDetector r1) {
    }

    public a(b r1) {
        this.a = r1;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public final boolean onScale(ScaleGestureDetector r4) {
        float r0 = r4.getScaleFactor();
        if (Float.isNaN(r0) == false) goto L5;
        return false;
    L5:
        if (Float.isInfinite(r0) == false) goto L8;
        return false;
    L8:
        if (r0 < 0.0f) goto L14;
        c r1 = this.a.j;
        j.a r2 = (j.a) r1;
        r2.a(r0, r4.getFocusX(), r4.getFocusY());
        return true;
    L14:
        return true;
    }
}
