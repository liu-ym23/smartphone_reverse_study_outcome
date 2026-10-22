package com.bytedance.android.shopping.anchorv4.voavhs.base.extensions;

import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.bytedance.android.shopping.anchorv4.dto.base.Radius;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b {
    public Radius a;
    public final Path b;
    public final RectF c;
    public final float[] d;
    public boolean e;
    public final View f;

    public final class a extends ViewOutlineProvider {
        public final Radius a;

        public a(Radius r2) {
            Intrinsics.checkNotNullParameter(r2, "radius");
            this.a = r2;
        }

        @Override // android.view.ViewOutlineProvider
        public final void getOutline(View r4, Outline r5) {
            Intrinsics.checkNotNullParameter(r4, FreqActions.ACTION_VIEW);
            Intrinsics.checkNotNullParameter(r5, "outline");
            r5.setRoundRect(new Rect(0, 0, r4.getWidth(), r4.getHeight()), com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(this.a.getTopLeft())));
        }
    }

    public b(View r2) {
        Intrinsics.checkNotNullParameter(r2, FreqActions.ACTION_VIEW);
        this.f = r2;
        this.b = new Path();
        this.c = new RectF();
        this.d = new float[8];
    }

    public static boolean a(Radius r4) {
        if (r4.getTopLeft() != r4.getTopRight()) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
    L10:
        boolean r1 = false;
    L11:
        if (r1 == true) goto L13;
        return false;
    L13:
        if (r4.getTopLeft() != r4.getBottomRight()) goto L17;
        return true;
    L17:
        return false;
    L8:
        if (r4.getTopLeft() != r4.getBottomLeft()) goto L10;
        r1 = true;
        goto L11
    L5:
        r0 = false;
        goto L6
    }

    public static boolean b(Radius r1) {
        if (r1.getTopLeft() <= 0) goto L5;
    L12:
        return true;
    L5:
        if (r1.getTopRight() > 0) goto L12;
        if (r1.getBottomLeft() > 0) goto L12;
        if (r1.getBottomRight() > 0) goto L12;
        return false;
    }

    public final void d(Canvas r2) {
        if (this.e == false) goto L8;
        if (r2 == null) goto L6;
        r2.restore();
    L6:
        this.e = false;
        return;
    }

    public final void e(Canvas r4) {
        Radius r0 = this.a;
        if (r0 != null) goto L5;
        return;
    L5:
        if ((!a(r0)) == true) goto L8;
        r0 = null;
    L8:
        if (r0 != null) goto L10;
        return;
    L10:
        if (b(r0) == false) goto L19;
        if (r4 == null) goto L13;
        r4.save();
    L13:
        this.e = true;
        if (r4 == null) goto L20;
        r4.clipPath(this.b);
        return;
    L20:
        return;
    }

    public final void f(Radius r4) {
        this.a = r4;
        if (r4 != null) goto L5;
    L15:
        this.f.setClipToOutline(false);
    L16:
        this.f.invalidate();
        return;
    L5:
        if (b(r4) == true) goto L7;
    L9:
        boolean r1 = false;
    L10:
        if (r1 == true) goto L13;
        r4 = null;
    L13:
        if (r4 == null) goto L15;
        this.f.setClipToOutline(true);
        this.f.setOutlineProvider(new a(r4));
        goto L16
    L7:
        if (a(r4) == false) goto L9;
        r1 = true;
        goto L10
    }

    public final void c(int r4, int r5) {
        Radius r0 = this.a;
        if (r0 == null) goto L8;
        this.b.reset();
        if (b(r0) == false) goto L9;
        this.c.set(0.0f, 0.0f, r4, r5);
        this.d[0] = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r0.getTopLeft()));
        this.d[1] = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r0.getTopLeft()));
        this.d[2] = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r0.getTopRight()));
        this.d[3] = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r0.getTopRight()));
        this.d[4] = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r0.getBottomRight()));
        this.d[5] = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r0.getBottomRight()));
        this.d[6] = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r0.getBottomLeft()));
        this.d[7] = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r0.getBottomLeft()));
        this.b.addRoundRect(this.c, this.d, Path.Direction.CW);
        return;
    L9:
        return;
    }
}
