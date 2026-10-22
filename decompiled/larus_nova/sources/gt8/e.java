package gt8;

import android.graphics.PointF;
import android.view.MotionEvent;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class e implements d.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f482613a;

    @Override // gt8.d.b
    public int getType() {
        return 2;
    }

    public e(d r100) {
        this.f482613a = r100;
    }

    @Override // gt8.d.b
    public final void a(MotionEvent r110) {
        Intrinsics.checkNotNullParameter(r110, "event");
        b0 r100 = this.f482613a.f482603h;
        Intrinsics.checkNotNull(r110);
        r100.getClass();
        Intrinsics.checkNotNullParameter(r110, "event");
        int r101 = r110.getPointerCount();
        int r102 = r110.getAction() & 255;
        if (r102 == 0) goto L54;
        PointF r103 = null;
        if (r102 != 1) goto L7;
        r100.f482591c = null;
        r100.f482590b = null;
        r100.f482589a.d();
        r100.f482589a.a();
        return;
    L7:
        if (r102 == 2) goto L22;
        if (r102 != 5) goto L11;
        r100.f482590b = new a0(r110.getX(), r110.getY(), r110.getX(1), r110.getY(1));
        r100.a(r110);
        a0 r111 = r100.f482590b;
        if (r111 == null) goto L17;
        r103 = r111.f482587c;
    L17:
        r100.f482592d = r103;
        r100.f482589a.f();
        if (r100.f482594f == true) goto L20;
        r100.f482589a.onTransformStart();
        r100.f482594f = true;
    L20:
        FLogger.f375446a.d("TransformActionHandler", "ACTION_POINTER_DOWN");
        return;
    L11:
        if (r102 != 6) goto L60;
        FLogger.f375446a.d("TransformActionHandler", "ACTION_POINTER_UP");
        r100.f482589a.c();
        return;
    L60:
        return;
    L22:
        if (r100.f482594f == true) goto L24;
        r100.f482594f = true;
        r100.f482589a.onTransformStart();
    L24:
        float r104 = 0.0f;
        float r105 = 1.0f;
        if (r101 == 1) goto L44;
        if (r101 != 2) goto L43;
        r100.f482593e = null;
        r100.a(r110);
        if (r100.f482590b != null) goto L31;
        a0 r106 = new a0(r110.getX(), r110.getY(), r110.getX(1), r110.getY(1));
        r100.f482590b = r106;
        r100.f482592d = r106.f482587c;
    L31:
        a0 r112 = r100.f482590b;
        if (r112 == null) goto L43;
        a0 r107 = r100.f482591c;
        if (r107 == null) goto L43;
        Intrinsics.checkNotNullParameter(r107, "nextPoint");
        r105 = r107.a() / r112.a();
        Intrinsics.checkNotNullParameter(r107, "nextPoint");
        float r108 = r112.f482585a.x;
        float r109 = r107.f482585a.x;
        float r113 = r112.f482586b.x;
        float r114 = r107.f482586b.x;
        if (((r108 - r109) * (r113 - r114)) < 0.0f) goto L38;
        float r115 = ((r109 - r108) + (r114 - r113)) / 2;
    L39:
        Intrinsics.checkNotNullParameter(r107, "nextPoint");
        float r116 = r112.f482585a.y;
        float r117 = r107.f482585a.y;
        float r118 = r112.f482586b.y;
        float r119 = r107.f482586b.y;
        if (((r116 - r117) * (r118 - r119)) < 0.0f) goto L42;
        r104 = ((r117 - r116) + (r119 - r118)) / 2;
    L42:
        Intrinsics.checkNotNullParameter(r107, "points");
        PointF r120 = r112.f482585a;
        PointF r121 = r107.f482585a;
        r120.x = r121.x;
        r120.y = r121.y;
        PointF r122 = r112.f482586b;
        PointF r123 = r107.f482586b;
        float r124 = r123.x;
        r122.x = r124;
        float r125 = r123.y;
        r122.y = r125;
        PointF r126 = r112.f482587c;
        float r127 = 2;
        r126.x = (r120.x + r124) / r127;
        r126.y = (r120.y + r125) / r127;
        float r128 = r104;
        r104 = r115;
    L52:
        FLogger.f375446a.d("TransformActionHandler", "ACTION_MOVE, scale = " + r105 + ", translateX = " + r104 + ", translateY = " + r128);
        r100.f482589a.e(r100.f482592d, r105, r104, r128);
        r100.f482589a.g();
        return;
    L38:
        r115 = 0.0f;
    L43:
        r128 = 0.0f;
        goto L52
    L44:
        PointF r129 = r100.f482593e;
        if (r129 != null) goto L50;
        PointF r130 = new PointF();
        r100.f482593e = r130;
        r130.x = r110.getX();
        PointF r131 = r100.f482593e;
        if (r131 == null) goto L49;
        r131.y = r110.getY();
    L49:
        float r132 = 0.0f;
    L51:
        r100.f482590b = null;
        float r133 = r104;
        r104 = r132;
        r128 = r133;
        goto L52
    L50:
        float r134 = r110.getX() - r129.x;
        float r135 = r110.getY() - r129.y;
        r129.x = r110.getX();
        r129.y = r110.getY();
        r132 = r134;
        r104 = r135;
        goto L51
    L54:
        r100.f482589a.b();
    }
}
