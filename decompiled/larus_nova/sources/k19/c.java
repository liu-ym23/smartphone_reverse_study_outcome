package k19;

import android.view.GestureDetector;
import android.view.MotionEvent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class c extends GestureDetector.SimpleOnGestureListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f501390a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public GestureDetector.SimpleOnGestureListener f501391b;

    public c(a r100) {
        Intrinsics.checkNotNullParameter(r100, "defaultGestureHandler");
        this.f501390a = r100;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public final boolean onDoubleTap(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
        GestureDetector.SimpleOnGestureListener r101 = this.f501391b;
        if (r101 == null) goto L6;
        r101.onDoubleTap(r100);
    L6:
        return this.f501390a.onDoubleTap(r100);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public final boolean onDoubleTapEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
        GestureDetector.SimpleOnGestureListener r101 = this.f501391b;
        if (r101 == null) goto L6;
        r101.onDoubleTapEvent(r100);
    L6:
        return this.f501390a.onDoubleTapEvent(r100);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onDown(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
        GestureDetector.SimpleOnGestureListener r101 = this.f501391b;
        if (r101 == null) goto L6;
        r101.onDown(r100);
    L6:
        return this.f501390a.onDown(r100);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final void onLongPress(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
        GestureDetector.SimpleOnGestureListener r101 = this.f501391b;
        if (r101 == null) goto L5;
        r101.onLongPress(r100);
    L5:
        this.f501390a.onLongPress(r100);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final void onShowPress(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
        GestureDetector.SimpleOnGestureListener r101 = this.f501391b;
        if (r101 == null) goto L5;
        r101.onShowPress(r100);
    L5:
        this.f501390a.onShowPress(r100);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public final boolean onSingleTapConfirmed(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
        GestureDetector.SimpleOnGestureListener r101 = this.f501391b;
        if (r101 == null) goto L6;
        r101.onSingleTapConfirmed(r100);
    L6:
        return this.f501390a.onSingleTapConfirmed(r100);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onSingleTapUp(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
        GestureDetector.SimpleOnGestureListener r101 = this.f501391b;
        if (r101 == null) goto L6;
        r101.onSingleTapUp(r100);
    L6:
        return this.f501390a.onSingleTapUp(r100);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent r100, MotionEvent r101, float r102, float r103) {
        Intrinsics.checkNotNullParameter(r101, "e2");
        GestureDetector.SimpleOnGestureListener r104 = this.f501391b;
        if (r104 == null) goto L6;
        r104.onFling(r100, r101, r102, r103);
    L6:
        return this.f501390a.onFling(r100, r101, r102, r103);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onScroll(MotionEvent r100, MotionEvent r101, float r102, float r103) {
        Intrinsics.checkNotNullParameter(r101, "e2");
        GestureDetector.SimpleOnGestureListener r104 = this.f501391b;
        if (r104 == null) goto L6;
        r104.onScroll(r100, r101, r102, r103);
    L6:
        return this.f501390a.onScroll(r100, r101, r102, r103);
    }
}
