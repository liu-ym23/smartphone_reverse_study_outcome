package k19;

import android.view.MotionEvent;
import kotlin.jvm.internal.Intrinsics;
import l19.l;

/* JADX INFO: loaded from: classes27.dex */
public final class f extends a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final l f501414e;

    public f(l r100) {
        Intrinsics.checkNotNullParameter(r100, "transitionZoomableControllerImp");
        super(r100);
        this.f501414e = r100;
    }

    @Override // k19.a, android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public final boolean onSingleTapConfirmed(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
        if (this.f501414e.isSingleTagDismissEnabled() == false) goto L5;
        l r101 = this.f501414e;
        r101.H.set(r101.f327679l);
        r101.z(true);
    L5:
        return true;
    }

    @Override // k19.a, android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent r100, MotionEvent r101, float r102, float r103) {
        Intrinsics.checkNotNullParameter(r101, "e2");
        if (this.f501414e.E != 3) goto L5;
        boolean r104 = true;
    L6:
        if (r104 == true) goto L9;
        super.onFling(r100, r101, r102, r103);
    L9:
        return false;
    L5:
        r104 = false;
        goto L6
    }
}
