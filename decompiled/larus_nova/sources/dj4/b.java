package dj4;

import android.view.GestureDetector;
import android.view.MotionEvent;

/* JADX INFO: loaded from: classes15.dex */
public final class b implements GestureDetector.OnGestureListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f468908a;

    @Override // android.view.GestureDetector.OnGestureListener
    public final void onShowPress(MotionEvent r100) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onSingleTapUp(MotionEvent r100) {
        return false;
    }

    public b(e r100) {
        this.f468908a = r100;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onDown(MotionEvent r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        f r101 = this.f468908a.f468911a;
        if (r101 != null) goto L8;
        return false;
    L8:
        return r101.onDown(r100);
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final void onLongPress(MotionEvent r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        f r101 = this.f468908a.f468911a;
        if (r101 == null) goto L8;
        r101.onLongPress(r100);
        return;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent r100, MotionEvent r101, float r102, float r103) {
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r101 != null) goto L7;
        return false;
    L7:
        f r104 = this.f468908a.f468911a;
        if (r104 == null) goto L11;
        r104.onFling(r100, r101, r102, r103);
        return true;
    L11:
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onScroll(MotionEvent r100, MotionEvent r101, float r102, float r103) {
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r101 != null) goto L7;
        return false;
    L7:
        f r104 = this.f468908a.f468911a;
        if (r104 != null) goto L10;
        return false;
    L10:
        return r104.onScroll(r100, r101, r102, r103);
    }
}
