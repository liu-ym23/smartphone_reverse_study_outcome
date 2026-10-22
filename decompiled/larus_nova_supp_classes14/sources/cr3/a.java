package cr3;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import com.bytedance.apm.constant.UploadTypeInf;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a implements Interpolator {
    public final PointF a;
    public final PointF b;
    public final PointF c;
    public final double d;
    public final PointF e;
    public final PointF f;

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float r12) {
        float r2 = r12;
        int r1 = 1;
    L4:
        if (r1 > 13) goto L9;
        PointF r3 = this.c;
        float r5 = 3;
        PointF r6 = this.e;
        float r7 = r6.x * r5;
        r3.x = r7;
        PointF r8 = this.b;
        float r9 = ((this.f.x - r6.x) * r5) - r7;
        r8.x = r9;
        PointF r10 = this.a;
        float r11 = (1 - r3.x) - r9;
        r10.x = r11;
        float r4 = ((r3.x + ((r8.x + (r11 * r2)) * r2)) * r2) - r12;
        if (Math.abs(r4) < this.d) goto L9;
        r2 = r2 - (r4 / (this.c.x + (((2 * this.b.x) + ((r5 * this.a.x) * r2)) * r2)));
        r1 = r1 + 1;
    L9:
        PointF r13 = this.c;
        float r14 = 3;
        PointF r15 = this.e;
        float r16 = r15.y * r14;
        r13.y = r16;
        PointF r17 = this.b;
        float r18 = (r14 * (this.f.y - r15.y)) - r16;
        r17.y = r18;
        PointF r19 = this.a;
        float r0 = (1 - r13.y) - r18;
        r19.y = r0;
        return r2 * (r13.y + ((r17.y + (r0 * r2)) * r2));
    }

    public a(float r4, float r5, float r6) {
        PointF r0 = new PointF(r4, r5);
        PointF r7 = new PointF(r6, 1.0f);
        Intrinsics.checkNotNullParameter(r0, UploadTypeInf.START);
        Intrinsics.checkNotNullParameter(r7, "end");
        this.e = r0;
        this.f = r7;
        float r8 = r0.x;
        boolean r9 = false;
        float r1 = 0;
        if (r8 >= r1) goto L5;
    L7:
        boolean r10 = false;
    L8:
        if (r10 == false) goto L20;
        float r11 = r7.x;
        if (r11 >= r1) goto L12;
    L14:
        if (r9 == false) goto L18;
        this.a = new PointF();
        this.b = new PointF();
        this.c = new PointF();
        this.d = 0.001d;
        return;
    L18:
        throw new IllegalArgumentException("endX value must be in the range [0, 1]".toString());
    L12:
        if (r11 > 1) goto L14;
        r9 = true;
        goto L14
    L20:
        throw new IllegalArgumentException("startX value must be in the range [0, 1]".toString());
    L5:
        if (r8 > 1) goto L7;
        r10 = true;
        goto L8
    }
}
