package sw8;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.Layout;
import android.text.Spanned;
import android.text.style.LeadingMarginSpan;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import msc.s;

/* JADX INFO: loaded from: classes26.dex */
public final class a implements LeadingMarginSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s f543722a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f543723b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f543724c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Rect f543725d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Paint f543726e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Path f543727f;

    @Override // android.text.style.LeadingMarginSpan
    public final int getLeadingMargin(boolean r100) {
        int r101 = this.f543724c;
        if (r101 <= 0) goto L6;
        return r101;
    L6:
        return this.f543722a.f515543c;
    }

    public a(s r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "theme");
        this.f543722a = r100;
        this.f543723b = r101;
        this.f543724c = r102;
        this.f543725d = new Rect();
        this.f543726e = new Paint();
        this.f543727f = new Path();
    }

    @Override // android.text.style.LeadingMarginSpan
    public final void drawLeadingMargin(Canvas r100, Paint r101, int r102, int r103, int r104, int r105, int r106, CharSequence r107, int r108, int r110, boolean r111, Layout r112) {
        Intrinsics.checkNotNullParameter(r100, "c");
        s r109 = this.f543722a;
        int r113 = r109.f515544d;
        if (r113 != 0) goto L5;
        r113 = (int) ((r109.f515543c * 0.25f) + 0.5f);
    L5:
        this.f543726e.set(r101);
        s r114 = this.f543722a;
        Paint r115 = this.f543726e;
        int r116 = r114.f515545e;
        if (r116 != 0) goto L8;
        r116 = ftc.a.a(r115.getColor(), 25);
    L8:
        r115.setStyle(Paint.Style.FILL);
        r115.setColor(r116);
        int r117 = (r103 * r113) + r102;
        int r118 = RangesKt.coerceAtMost(r102, r117);
        int r119 = RangesKt.coerceAtLeast(r102, r117);
        if (this.f543723b > 0) goto L11;
    L19:
        this.f543725d.set(r118, r104, r119, r106);
        r100.drawRect(this.f543725d, this.f543726e);
        return;
    L11:
        if ((r107 instanceof Spanned) == false) goto L19;
        Spanned r120 = (Spanned) r107;
        if (r120.getSpanStart(this) != r108) goto L16;
        float r121 = r118;
        float r122 = r104;
        float r123 = r119;
        float r124 = r106;
        float r125 = this.f543723b;
        Path r126 = this.f543727f;
        this.f543726e.setAntiAlias(true);
        this.f543726e.setDither(true);
        r126.reset();
        r126.moveTo(r121, r124);
        r126.lineTo(r123, r124);
        float r127 = r122 + r125;
        r126.lineTo(r123, r127);
        r126.arcTo(new RectF(r123 - r125, r122, r123, r127), 0.0f, -90.0f, false);
        float r128 = r125 + r121;
        r126.lineTo(r128, r122);
        r126.arcTo(new RectF(r121, r122, r128, r127), 270.0f, -90.0f, false);
        r126.close();
        r100.drawPath(r126, this.f543726e);
        return;
    L16:
        if (r120.getSpanEnd(this) != r110) goto L18;
        float r129 = r118;
        float r130 = r104;
        float r131 = r119;
        float r132 = r106;
        float r133 = this.f543723b;
        Path r134 = this.f543727f;
        this.f543726e.setAntiAlias(true);
        this.f543726e.setDither(true);
        r134.reset();
        r134.moveTo(r129, r130);
        r134.lineTo(r131, r130);
        float r135 = r132 - r133;
        r134.lineTo(r131, r135);
        r134.arcTo(new RectF(r131 - r133, r135, r131, r132), 0.0f, 90.0f, false);
        float r136 = r133 + r129;
        r134.lineTo(r136, r132);
        r134.arcTo(new RectF(r129, r135, r136, r132), 90.0f, 90.0f, false);
        r134.close();
        r100.drawPath(r134, this.f543726e);
        return;
    L18:
        this.f543725d.set(r118, r104, r119, r106);
        r100.drawRect(this.f543725d, this.f543726e);
    }
}
