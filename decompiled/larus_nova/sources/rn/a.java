package rn;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.view.View;
import android.widget.FrameLayout;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes44.dex */
public final class a extends FrameLayout {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f538624f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f538625a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f538626b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Paint f538627c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f538628d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final C7503a f538629e;

    /* JADX INFO: renamed from: rn.a$a, reason: collision with other inner class name */
    public static final class C7503a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f538630a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f538631b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f538632c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f538633d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f538634e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f538635f;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof C7503a) == false) goto L18;
            C7503a r101 = (C7503a) r100;
            if (this.f538630a == r101.f538630a) goto L8;
            return false;
        L8:
            if (this.f538631b == r101.f538631b) goto L10;
            return false;
        L10:
            if (this.f538632c == r101.f538632c) goto L12;
            return false;
        L12:
            if (this.f538633d == r101.f538633d) goto L14;
            return false;
        L14:
            if (this.f538634e == r101.f538634e) goto L16;
            return false;
        L16:
            if (this.f538635f == r101.f538635f) goto L28;
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
            boolean r100 = this.f538630a;
            ?? r101 = r100;
            if (r100 == false) goto L6;
            r101 = 1;
        L6:
            return (((((((((r101 * 31) + this.f538631b) * 31) + this.f538632c) * 31) + this.f538633d) * 31) + this.f538634e) * 31) + this.f538635f;
        }

        public final String toString() {
            return "ArrowConfig(abovePosition=" + this.f538630a + ", offsetXPx=" + this.f538631b + ", color=" + this.f538632c + ", radiusPx=" + this.f538633d + ", marginToTargetPx=" + this.f538634e + ", arrowHeight=" + this.f538635f + ")";
        }

        public C7503a(boolean r100, int r101, int r102, int r103, int r104, int r105) {
            this.f538630a = r100;
            this.f538631b = r101;
            this.f538632c = r102;
            this.f538633d = r103;
            this.f538634e = r104;
            this.f538635f = r105;
        }
    }

    public static final class b {
    }

    static {
        f538624f = com.bytedance.android.shopping.extensions.b.b(10) / 2;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        super.onDraw(r110);
        if (this.f538625a != 0) goto L5;
        return;
    L5:
        C7503a r100 = this.f538629e;
        boolean r101 = r100.f538630a;
        int r102 = r100.f538631b - (this.f538626b / 2);
        int r103 = r100.f538633d;
        int r104 = f538624f;
        int r105 = RangesKt.coerceAtMost(RangesKt.coerceAtLeast(r102, r103 + r104), ((r110.getWidth() - this.f538626b) - this.f538629e.f538633d) - r104);
        if (r101 == false) goto L8;
        int r106 = this.f538625a;
    L9:
        if (r101 == false) goto L11;
        float r107 = this.f538629e.f538634e;
    L12:
        float r108 = r105;
        float r109 = r106;
        PointF r111 = new PointF(r108, r109);
        r111.offset(0.0f, r107);
        PointF r112 = new PointF(r108 + this.f538626b, r109);
        r112.offset(0.0f, r107);
        float r113 = (r111.x + r112.x) / 2.0f;
        if (r101 == false) goto L15;
        float r114 = this.f538629e.f538634e;
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
        r110.drawPath(r116, this.f538627c);
        return;
    L15:
        r114 = r110.getHeight() - this.f538629e.f538634e;
        goto L16
    L11:
        r107 = -this.f538629e.f538634e;
        goto L12
    L8:
        r106 = r110.getHeight() - this.f538625a;
        goto L9
    }

    public a(View r100, C7503a r101) {
        super(r100.getContext());
        this.f538628d = r100;
        this.f538629e = r101;
        int r102 = r101.f538635f;
        this.f538625a = r102;
        this.f538626b = r102 * 3;
        Paint r103 = new Paint();
        r103.setColor(r101.f538632c);
        r103.setStrokeWidth(2.0f);
        r103.setStyle(Paint.Style.FILL);
        Unit r104 = Unit.INSTANCE;
        this.f538627c = r103;
    }

    @Override // android.view.ViewGroup
    public final void measureChildWithMargins(View r100, int r101, int r102, int r103, int r104) {
        super.measureChildWithMargins(r100, r101, r102, r103, r104);
        int r105 = RangesKt.coerceAtLeast(this.f538628d.getMeasuredWidth(), (this.f538626b + (this.f538629e.f538633d * 2)) + f538624f);
        setMinimumWidth(r105);
        if (r100 == null) goto L6;
        r100.setMinimumWidth(r105);
        return;
    }
}
