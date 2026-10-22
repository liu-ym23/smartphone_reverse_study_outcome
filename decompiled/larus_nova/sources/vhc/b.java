package vhc;

import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;
import com.ss.android.lark.utils.statistics.PerfLog;
import dj4.c;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public final class b extends vhc.a {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final PointF f554998j = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public PointF f554999f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public PointF f555000g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final PointF f555001h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final InterfaceC8010b f555002i;

    public static final class a {
    }

    /* JADX INFO: renamed from: vhc.b$b, reason: collision with other inner class name */
    public interface InterfaceC8010b {
        void a(b r100);

        void b(b r100);

        void c(b r100);
    }

    static {
        f554998j = new PointF();
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
        MotionEvent r101 = this.f554993a;
        MotionEvent r102 = this.f554994b;
        if (r102 == null) goto L5;
        Intrinsics.checkNotNull(r102);
        r102.recycle();
        this.f554994b = null;
    L5:
        this.f554994b = MotionEvent.obtain(r100);
        r100.getEventTime();
        Intrinsics.checkNotNull(r101);
        r101.getEventTime();
        this.f554995c = r100.getPressure(r100.getActionIndex());
        this.f554996d = r101.getPressure(r101.getActionIndex());
        MotionEvent r103 = this.f554993a;
        this.f554999f = c(r100);
        Intrinsics.checkNotNull(r103);
        this.f555000g = c(r103);
        if (r103.getPointerCount() == r100.getPointerCount()) goto L8;
        boolean r104 = true;
    L9:
        if (r104 == false) goto L11;
        PointF r105 = f554998j;
    L12:
        PointF r106 = this.f555001h;
        r106.x += r105.x;
        r106.y += r105.y;
        return;
    L11:
        PointF r107 = this.f554999f;
        Intrinsics.checkNotNull(r107);
        float r108 = r107.x;
        PointF r109 = this.f555000g;
        Intrinsics.checkNotNull(r109);
        float r110 = r108 - r109.x;
        PointF r111 = this.f554999f;
        Intrinsics.checkNotNull(r111);
        float r112 = r111.y;
        PointF r113 = this.f555000g;
        Intrinsics.checkNotNull(r113);
        r105 = new PointF(r110, r112 - r113.y);
        goto L12
    L8:
        r104 = false;
        goto L9
    }

    public b(Context r100, c r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "mListener");
        super(r100);
        this.f555002i = r101;
        this.f555001h = new PointF();
        new PointF();
    }
}
