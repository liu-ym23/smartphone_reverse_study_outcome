package rp9;

import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import qp9.f;

/* JADX INFO: loaded from: classes31.dex */
public final class c extends rp9.a {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final PointF f538893j = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b f538894f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public PointF f538895g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public PointF f538896h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final PointF f538897i;

    public static final class a {
    }

    public interface b {
        void a(c r100);

        void b(c r100);

        void c(c r100);
    }

    static {
        f538893j = new PointF();
    }

    public static PointF c(MotionEvent r100) {
        int r101 = r100.getPointerCount();
        float r102 = 0.0f;
        float r103 = 0.0f;
        int r104 = 0;
    L3:
        if (r104 >= r101) goto L5;
        r102 = r102 + r100.getX(r104);
        r103 = r103 + r100.getY(r104);
        r104 = r104 + 1;
        goto L3
    L5:
        float r105 = r101;
        return new PointF(r102 / r105, r103 / r105);
    }

    public final void d(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "curr");
        Intrinsics.checkNotNullParameter(r100, "curr");
        MotionEvent r101 = this.f538886a;
        MotionEvent r102 = this.f538887b;
        if (r102 == null) goto L5;
        Intrinsics.checkNotNull(r102);
        r102.recycle();
        this.f538887b = null;
    L5:
        this.f538887b = MotionEvent.obtain(r100);
        r100.getEventTime();
        Intrinsics.checkNotNull(r101);
        r101.getEventTime();
        this.f538888c = r100.getPressure(r100.getActionIndex());
        this.f538889d = r101.getPressure(r101.getActionIndex());
        MotionEvent r103 = this.f538886a;
        this.f538895g = c(r100);
        Intrinsics.checkNotNull(r103);
        this.f538896h = c(r103);
        if (r103.getPointerCount() == r100.getPointerCount()) goto L8;
        boolean r104 = true;
    L9:
        if (r104 == false) goto L11;
        PointF r105 = f538893j;
    L12:
        PointF r106 = this.f538897i;
        r106.x += r105.x;
        r106.y += r105.y;
        return;
    L11:
        PointF r107 = this.f538895g;
        Intrinsics.checkNotNull(r107);
        float r108 = r107.x;
        PointF r109 = this.f538896h;
        Intrinsics.checkNotNull(r109);
        float r110 = r108 - r109.x;
        PointF r111 = this.f538895g;
        Intrinsics.checkNotNull(r111);
        float r112 = r111.y;
        PointF r113 = this.f538896h;
        Intrinsics.checkNotNull(r113);
        r105 = new PointF(r110, r112 - r113.y);
        goto L12
    L8:
        r104 = false;
        goto L9
    }

    public c(Context r100, f r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "mListener");
        super(r100);
        this.f538894f = r101;
        this.f538897i = new PointF();
        new PointF();
    }
}
