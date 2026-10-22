package s95;

import android.view.ScaleGestureDetector;

/* JADX INFO: loaded from: classes16.dex */
public final class a implements ScaleGestureDetector.OnScaleGestureListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f541067a;

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public final boolean onScaleBegin(ScaleGestureDetector r100) {
        return true;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public final void onScaleEnd(ScaleGestureDetector r100) {
    }

    public a(b r100) {
        this.f541067a = r100;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public final boolean onScale(ScaleGestureDetector r100) {
        float r101 = r100.getScaleFactor();
        if (Float.isNaN(r101) == false) goto L5;
        return false;
    L5:
        if (Float.isInfinite(r101) == false) goto L8;
        return false;
    L8:
        if (r101 < 0.0f) goto L14;
        c r102 = this.f541067a.f541077j;
        j.a r103 = (j.a) r102;
        r103.a(r101, r100.getFocusX(), r100.getFocusY());
        return true;
    L14:
        return true;
    }
}
