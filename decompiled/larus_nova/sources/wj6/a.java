package wj6;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.view.GestureDetector;
import android.view.MotionEvent;
import com.bytedance.live.photoviewer.ZoomableControllerImp;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes19.dex */
public class a extends GestureDetector.SimpleOnGestureListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PointF f560016a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ZoomableControllerImp f560017b;

    /* JADX INFO: renamed from: wj6.a$a, reason: collision with other inner class name */
    public static final class RunnableC8122a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ZoomableControllerImp f560018a;

        public RunnableC8122a(ZoomableControllerImp r100) {
            this.f560018a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f560018a.A = false;     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public a(ZoomableControllerImp r100) {
        this.f560017b = r100;
        this.f560016a = new PointF();
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public final boolean onDoubleTapEvent(MotionEvent r110) {
        ZoomableControllerImp r100 = this.f560017b;
        PointF r101 = new PointF(r110.getX(), r110.getY());
        int r111 = r110.getActionMasked();
        if (r111 == 0) goto L20;
        if (r111 == 1) goto L7;
    L21:
        return true;
    L7:
        if (r100.f255627t != null) goto L9;
        r100.f255627t = new uj6.b(r100);
    L9:
        uj6.c r112 = r100.f255627t;
        r100.b(r100.f550404k);
        uj6.b r113 = (uj6.b) r112;
        float r102 = r113.f550407a.f550399f;
        float r103 = 2;
        r100.A = true;
        float r104 = r100.b(r100.f550404k);
        ZoomableControllerImp r114 = r113.f550407a;
        float r105 = r114.f550399f;
        if (r105 != 0.0f) goto L13;
        r105 = r114.f550400g;
    L13:
        if (r104 < ((r105 + 1.0f) / r103)) goto L16;
        r105 = 1.0f;
    L16:
        RunnableC8122a r115 = new RunnableC8122a(r100);
        if (r100.f255629v.isRunning() == false) goto L19;
        r100.q();
    L19:
        r100.f255624q.reset();
        Matrix r106 = r100.f255624q;
        float[] r107 = r100.f550406m;
        r107[0] = r101.x;
        r107[1] = r101.y;
        r100.f550404k.invert(r100.f550405l);
        r100.f550405l.mapPoints(r107, 0, r107, 0, 1);
        PointF r108 = new PointF(r107[0], r107[1]);
        r106.setScale(r105, r105, r108.x, r108.y);
        r100.j(r106, r108.x, r108.y);
        r100.k(r106);
        r100.p(r100.f255624q, r100.f255630w, r115, null);
        goto L21
    L20:
        this.f560016a.set(r101);
        goto L21
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final void onLongPress(MotionEvent r100) {
        super.onLongPress(r100);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public final boolean onSingleTapConfirmed(MotionEvent r100) {
        return super.onSingleTapConfirmed(r100);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent r110, MotionEvent r111, float r112, float r113) {
        ZoomableControllerImp r114 = this.f560017b;
        if (r114.b(r114.f550404k) <= 1.0f) goto L17;
        int r100 = (int) r112;
        int r101 = (int) r113;
        if (r114.f255629v.isRunning() == false) goto L7;
        return false;
    L7:
        if (r114.f550398e == true) goto L10;
        return false;
    L10:
        if (r114.f255632y.computeScrollOffset() == true) goto L12;
    L14:
        r114.f255632y.fling(0, 0, r100, r101, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
        r114.f255626s.set(r114.f550404k);
        Matrix r115 = r114.f550404k;
        r115.set(r115);
        r114.c();
        return false;
    L12:
        if (r114.f255632y.computeScrollOffset() == false) goto L14;
        r114.f255632y.forceFinished(true);
        goto L14
    L17:
        return false;
    }
}
