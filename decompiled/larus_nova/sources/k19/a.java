package k19;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.view.GestureDetector;
import android.view.MotionEvent;
import com.larus.common_ui.photoviewer.ZoomableControllerImp;
import j19.l;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public class a extends GestureDetector.SimpleOnGestureListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ZoomableControllerImp f501386a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PointF f501387b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public l f501388c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f501389d;

    public a(ZoomableControllerImp r100) {
        Intrinsics.checkNotNullParameter(r100, "zoomableControllerImp");
        this.f501386a = r100;
        this.f501387b = new PointF();
        this.f501389d = true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public final boolean onDoubleTapEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
        if (this.f501389d == true) goto L5;
        return false;
    L5:
        l r101 = this.f501388c;
        if (r101 != null) goto L8;
        return false;
    L8:
        ZoomableControllerImp r102 = this.f501386a;
        PointF r103 = new PointF(r100.getX(), r100.getY());
        int r104 = r100.getActionMasked();
        if (r104 == 0) goto L13;
        if (r104 != 1) goto L14;
        r102.f327679l.getValues(r102.f327681n);
        r102.y(r101.nextFactor(r102.f327681n[0]), r103, null, null);
    L14:
        return true;
    L13:
        this.f501387b.set(r103);
        goto L14
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final void onLongPress(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
        super.onLongPress(r100);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
        return super.onSingleTapConfirmed(r100);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent r110, MotionEvent r111, float r112, float r113) {
        Intrinsics.checkNotNullParameter(r111, "e2");
        ZoomableControllerImp r114 = this.f501386a;
        r114.f327679l.getValues(r114.f327681n);
        if (r114.f327681n[0] < r114.f327673f) goto L15;
        int r100 = (int) r112;
        int r101 = (int) r113;
        if (r114.f327662w.isRunning() == true) goto L15;
        if (r114.f327672e == false) goto L15;
        if (r114.f327665z.computeScrollOffset() == true) goto L12;
    L14:
        r114.f327665z.fling(0, 0, r100, r101, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
        r114.f327659t.set(r114.f327679l);
        Matrix r115 = r114.f327679l;
        r115.set(r115);
        r114.d();
        goto L15
    L12:
        if (r114.f327665z.computeScrollOffset() == false) goto L14;
        r114.f327665z.forceFinished(true);
    L15:
        return false;
    }
}
