package com.obric.oui.common.style;

import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.obric.oui.material.OMaterialHelper;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes33.dex */
public final class k extends ViewOutlineProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l f399545a;

    public k(l r100) {
        this.f399545a = r100;
    }

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View r110, Outline r111) {
        int r100 = r110.getWidth();
        int r101 = r110.getHeight();
        if (r100 == 0) goto L34;
        if (r101 == 0) goto L38;
        float r102 = this.f399545a.k();
        float r103 = r102 * 2.0f;
        float r104 = Math.min(r100, r101);
        if (r103 <= r104) goto L9;
        float r105 = r104 / 2.0f;
    L10:
        l r106 = this.f399545a;
        if (r106.I == false) goto L14;
        Path r107 = new Path();
        RectF r108 = new RectF(0.0f, 0.0f, r100, r101);
        l r109 = this.f399545a;
        float r112 = r109.E;
        float r113 = r109.F;
        float r114 = r109.H;
        float r115 = r109.G;
        r107.addRoundRect(r108, new float[]{r112, r112, r113, r113, r114, r114, r115, r115}, Path.Direction.CW);
        r111.setConvexPath(r107);
        r110.setClipToOutline(!this.f399545a.f399546J);
        return;
    L14:
        int r116 = r106.f399561k0;
        int r117 = Math.max(r116 + 1, r101 - r106.f399568p0);
        l r118 = this.f399545a;
        int r119 = r118.Y;
        int r120 = r100 - r118.Z;
        if (r118.P == false) goto L17;
        r119 = r119 + r110.getPaddingLeft();
        r116 = r116 + r110.getPaddingTop();
        r120 = Math.max(r119 + 1, r120 - r110.getPaddingRight());
        r117 = Math.max(r116 + 1, r117 - r110.getPaddingBottom());
    L17:
        int r121 = r120;
        int r122 = r117;
        int r123 = r116;
        int r124 = r119;
        l r125 = this.f399545a;
        float r126 = r125.U;
        if (r125.T != 0) goto L20;
        r126 = 1.0f;
    L20:
        r111.setAlpha(r126);
        if (r105 > 0.0f) goto L24;
        r111.setRect(r124, r123, r121, r122);
        return;
    L24:
        if (r.f399603e == true) goto L26;
    L32:
        r111.setRoundRect(r124, r123, r121, r122, r105);
        return;
    L26:
        if (OMaterialHelper.k() == true) goto L32;
        if (Build.VERSION.SDK_INT < 30) goto L31;
        float r127 = r124;
        float r128 = r123;
        float r129 = r121;
        float r130 = r122;
        float r131 = r129 - r127;
        float r132 = r130 - r128;
        float r133 = RangesKt.coerceAtLeast(Math.min(r105, Math.min(Math.abs(r131), Math.abs(r132)) / 2.0f), 0.0f);
        r111.setPath(r.b(r133, Math.min(Math.abs(r131), Math.abs(r132))).f396561a.a(r127, r128, r129, r130, r133));
        return;
    L31:
        r111.setRoundRect(r124, r123, r121, r122, r105);
        return;
    L9:
        r105 = r102;
        goto L10
    L38:
        return;
    }
}
