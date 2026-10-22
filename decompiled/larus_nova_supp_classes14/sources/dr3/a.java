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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a extends FrameLayout {
    public static final int f = 0;
    public final int a;
    public final int b;
    public final Paint c;
    public final View d;
    public final C0117a e;

    /* JADX INFO: renamed from: dr3.a$a, reason: collision with other inner class name */
    public static final class C0117a {
        public final boolean a;
        public final int b;
        public final int c;
        public final int d;
        public final int e;
        public final int f;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof C0117a) == false) goto L18;
            C0117a r4 = (C0117a) r3;
            if (this.a == r4.a) goto L8;
            return false;
        L8:
            if (this.b == r4.b) goto L10;
            return false;
        L10:
            if (this.c == r4.c) goto L12;
            return false;
        L12:
            if (this.d == r4.d) goto L14;
            return false;
        L14:
            if (this.e == r4.e) goto L16;
            return false;
        L16:
            if (this.f == r4.f) goto L28;
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
            boolean r0 = this.a;
            ?? r1 = r0;
            if (r0 == false) goto L6;
            r1 = 1;
        L6:
            return (((((((((r1 * 31) + this.b) * 31) + this.c) * 31) + this.d) * 31) + this.e) * 31) + this.f;
        }

        public final String toString() {
            return "ArrowConfig(abovePosition=" + this.a + ", offsetXPx=" + this.b + ", color=" + this.c + ", radiusPx=" + this.d + ", marginToTargetPx=" + this.e + ", arrowHeight=" + this.f + ")";
        }

        public C0117a(boolean r1, int r2, int r3, int r4, int r5, int r6) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
        }
    }

    public static final class b {
    }

    static {
        f = com.bytedance.android.shopping.extensions.b.b(10) / 2;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r18) {
        Intrinsics.checkNotNullParameter(r18, "canvas");
        super.onDraw(r18);
        if (this.a != 0) goto L5;
        return;
    L5:
        C0117a r2 = this.e;
        boolean r3 = r2.a;
        int r4 = r2.b - (this.b / 2);
        int r5 = r2.d;
        int r6 = f;
        int r7 = RangesKt.coerceAtMost(RangesKt.coerceAtLeast(r4, r5 + r6), ((r18.getWidth() - this.b) - this.e.d) - r6);
        if (r3 == false) goto L8;
        int r8 = this.a;
    L9:
        if (r3 == false) goto L11;
        float r9 = this.e.e;
    L12:
        float r10 = r7;
        float r11 = r8;
        PointF r12 = new PointF(r10, r11);
        r12.offset(0.0f, r9);
        PointF r13 = new PointF(r10 + this.b, r11);
        r13.offset(0.0f, r9);
        float r14 = (r12.x + r13.x) / 2.0f;
        if (r3 == false) goto L15;
        float r15 = this.e.e;
    L16:
        PointF r16 = new PointF(r14, r15);
        Path r17 = new Path();
        r17.moveTo(r12.x, r12.y);
        float r19 = r16.x;
        float r20 = r19 - r12.x;
        float r21 = r20 / 2;
        float r22 = r20 / 4;
        float r23 = r16.y;
        r17.cubicTo(r19 - r21, r12.y, r19 - r22, r23, r19, r23);
        float r24 = r16.x;
        float r25 = r13.y;
        r17.cubicTo(r24 + r22, r16.y, r24 + r21, r25, r13.x, r25);
        r17.close();
        r18.drawPath(r17, this.c);
        return;
    L15:
        r15 = r18.getHeight() - this.e.e;
        goto L16
    L11:
        r9 = -this.e.e;
        goto L12
    L8:
        r8 = r18.getHeight() - this.a;
        goto L9
    }

    public a(View r2, C0117a r3) {
        super(r2.getContext());
        this.d = r2;
        this.e = r3;
        int r4 = r3.f;
        this.a = r4;
        this.b = r4 * 3;
        Paint r5 = new Paint();
        r5.setColor(r3.c);
        r5.setStrokeWidth(2.0f);
        r5.setStyle(Paint.Style.FILL);
        Unit r6 = Unit.INSTANCE;
        this.c = r5;
    }

    @Override // android.view.ViewGroup
    public final void measureChildWithMargins(View r1, int r2, int r3, int r4, int r5) {
        super.measureChildWithMargins(r1, r2, r3, r4, r5);
        int r6 = RangesKt.coerceAtLeast(this.d.getMeasuredWidth(), (this.b + (this.e.d * 2)) + f);
        setMinimumWidth(r6);
        if (r1 == null) goto L6;
        r1.setMinimumWidth(r6);
        return;
    }
}
