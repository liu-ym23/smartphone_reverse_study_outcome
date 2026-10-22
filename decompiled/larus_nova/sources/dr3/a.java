package dr3;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.view.View;
import android.widget.FrameLayout;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes14.dex */
public final class a extends FrameLayout {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f469748f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f469749a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f469750b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Paint f469751c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f469752d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final C5701a f469753e;

    /* JADX INFO: renamed from: dr3.a$a, reason: collision with other inner class name */
    public static final class C5701a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f469754a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f469755b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f469756c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f469757d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f469758e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f469759f;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof C5701a) == false) goto L18;
            C5701a r101 = (C5701a) r100;
            if (this.f469754a == r101.f469754a) goto L8;
            return false;
        L8:
            if (this.f469755b == r101.f469755b) goto L10;
            return false;
        L10:
            if (this.f469756c == r101.f469756c) goto L12;
            return false;
        L12:
            if (this.f469757d == r101.f469757d) goto L14;
            return false;
        L14:
            if (this.f469758e == r101.f469758e) goto L16;
            return false;
        L16:
            if (this.f469759f == r101.f469759f) goto L28;
            return false;
        L28:
            return true;
        L18:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v12 */
        /* JADX WARN: Type inference failed for: r0v13 */
        public final int hashCode() {
            boolean r100 = this.f469754a;
            ?? r101 = r100;
            if (r100 == false) goto L6;
            r101 = 1;
        L6:
            return (((((((((r101 * 31) + this.f469755b) * 31) + this.f469756c) * 31) + this.f469757d) * 31) + this.f469758e) * 31) + this.f469759f;
        }

        public final String toString() {
            return "ArrowConfig(abovePosition=" + this.f469754a + ", offsetXPx=" + this.f469755b + ", color=" + this.f469756c + ", radiusPx=" + this.f469757d + ", marginToTargetPx=" + this.f469758e + ", arrowHeight=" + this.f469759f + ")";
        }

        public C5701a(boolean r100, int r101, int r102, int r103, int r104, int r105) {
            this.f469754a = r100;
            this.f469755b = r101;
            this.f469756c = r102;
            this.f469757d = r103;
            this.f469758e = r104;
            this.f469759f = r105;
        }
    }

    public static final class b {
    }

    static {
        f469748f = com.bytedance.android.shopping.extensions.b.b(10) / 2;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        super.onDraw(r110);
        if (this.f469749a != 0) goto L5;
        return;
    L5:
        C5701a r100 = this.f469753e;
        boolean r101 = r100.f469754a;
        int r102 = r100.f469755b - (this.f469750b / 2);
        int r103 = r100.f469757d;
        int r104 = f469748f;
        int r105 = RangesKt.coerceAtMost(RangesKt.coerceAtLeast(r102, r103 + r104), ((r110.getWidth() - this.f469750b) - this.f469753e.f469757d) - r104);
        if (r101 == false) goto L8;
        int r106 = this.f469749a;
    L9:
        if (r101 == false) goto L11;
        float r107 = this.f469753e.f469758e;
    L12:
        float r108 = r105;
        float r109 = r106;
        PointF r111 = new PointF(r108, r109);
        r111.offset(0.0f, r107);
        PointF r112 = new PointF(r108 + this.f469750b, r109);
        r112.offset(0.0f, r107);
        float r113 = (r111.x + r112.x) / 2.0f;
        if (r101 == false) goto L15;
        float r114 = this.f469753e.f469758e;
    L16:
        PointF r115 = new PointF(r113, r114);
        Path r116 = new Path();
        r116.moveTo(r111.x, r111.y);
        float r117 = r115.x;
        float r118 = r117 - r111.x;
        float r119 = r118 / 2;
        float r120 = r118 / 4;
        float r121 = r115.y;
        r116.cubicTo(r117 - r119, r111.y, r117 - r120, r121, r117, r121);
        float r122 = r115.x;
        float r123 = r112.y;
        r116.cubicTo(r122 + r120, r115.y, r122 + r119, r123, r112.x, r123);
        r116.close();
        r110.drawPath(r116, this.f469751c);
        return;
    L15:
        r114 = r110.getHeight() - this.f469753e.f469758e;
        goto L16
    L11:
        r107 = -this.f469753e.f469758e;
        goto L12
    L8:
        r106 = r110.getHeight() - this.f469749a;
        goto L9
    }

    public a(View r100, C5701a r101) {
        super(r100.getContext());
        this.f469752d = r100;
        this.f469753e = r101;
        int r102 = r101.f469759f;
        this.f469749a = r102;
        this.f469750b = r102 * 3;
        Paint r103 = new Paint();
        r103.setColor(r101.f469756c);
        r103.setStrokeWidth(2.0f);
        r103.setStyle(Paint.Style.FILL);
        Unit r104 = Unit.INSTANCE;
        this.f469751c = r103;
    }

    @Override // android.view.ViewGroup
    public final void measureChildWithMargins(View r100, int r101, int r102, int r103, int r104) {
        super.measureChildWithMargins(r100, r101, r102, r103, r104);
        int r105 = RangesKt.coerceAtLeast(this.f469752d.getMeasuredWidth(), (this.f469750b + (this.f469753e.f469757d * 2)) + f469748f);
        setMinimumWidth(r105);
        if (r100 == null) goto L6;
        r100.setMinimumWidth(r105);
        return;
    }
}
