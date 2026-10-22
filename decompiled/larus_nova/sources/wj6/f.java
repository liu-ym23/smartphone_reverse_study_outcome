package wj6;

import android.view.MotionEvent;

/* JADX INFO: loaded from: classes19.dex */
public final class f extends a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final zj6.f f560043c;

    public f(zj6.f r100) {
        super(r100);
        this.f560043c = r100;
    }

    @Override // wj6.a, android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent r100, MotionEvent r101, float r102, float r103) {
        if (this.f560043c.D != 3) goto L5;
        boolean r104 = true;
    L6:
        if (r104 == false) goto L8;
        return false;
    L8:
        super.onFling(r100, r101, r102, r103);
        return false;
    L5:
        r104 = false;
        goto L6
    }
}
