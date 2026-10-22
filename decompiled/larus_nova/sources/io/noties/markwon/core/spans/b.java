package io.noties.markwon.core.spans;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.Layout;
import android.text.Spanned;
import android.text.style.LeadingMarginSpan;

/* JADX INFO: loaded from: classes41.dex */
public final class b implements LeadingMarginSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final msc.s f492306a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Rect f492307b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Paint f492308c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Path f492309d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f492310e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f492311f;

    @Override // android.text.style.LeadingMarginSpan
    public final int getLeadingMargin(boolean r100) {
        int r101 = this.f492311f;
        if (r101 <= 0) goto L6;
        return r101;
    L6:
        return this.f492306a.f515543c;
    }

    public b(msc.s r100, int r101, int r102) {
        this.f492307b = p.f492357a;
        this.f492308c = p.f492359c;
        this.f492309d = new Path();
        this.f492306a = r100;
        this.f492310e = r101;
        this.f492311f = r102;
    }

    @Override // android.text.style.LeadingMarginSpan
    public final void drawLeadingMargin(Canvas r100, Paint r101, int r102, int r103, int r104, int r105, int r106, CharSequence r107, int r108, int r110, boolean r111, Layout r112) {
        msc.s r109 = this.f492306a;
        int r113 = r109.f515544d;
        if (r113 != 0) goto L5;
        r113 = (int) ((r109.f515543c * 0.25f) + 0.5f);
    L5:
        this.f492308c.set(r101);
        msc.s r114 = this.f492306a;
        Paint r115 = this.f492308c;
        int r116 = r114.f515545e;
        if (r116 != 0) goto L8;
        r116 = ftc.a.a(r115.getColor(), 25);
    L8:
        r115.setStyle(Paint.Style.FILL);
        r115.setColor(r116);
        int r117 = r103 * r113;
        int r118 = r102 + r117;
        int r119 = r117 + r118;
        int r120 = Math.min(r118, r119);
        int r121 = Math.max(r118, r119);
        if (this.f492310e > 0) goto L11;
    L19:
        this.f492307b.set(r120, r104, r121, r106);
        r100.drawRect(this.f492307b, this.f492308c);
        return;
    L11:
        if ((r107 instanceof Spanned) == false) goto L19;
        Spanned r122 = (Spanned) r107;
        if (r122.getSpanStart(this) != r108) goto L16;
        float r123 = r120;
        float r124 = r104;
        float r125 = r121;
        float r126 = r106;
        float r127 = this.f492310e;
        Path r128 = this.f492309d;
        RectF r129 = p.f492358b;
        r128.reset();
        r128.moveTo(r123, r124 + r127);
        float r130 = 2.0f * r127;
        float r131 = r124 + r130;
        r129.set(r123, r124, r123 + r130, r131);
        r128.arcTo(r129, 180.0f, 90.0f);
        r128.lineTo(r125 - r127, r124);
        r129.set(r125 - r130, r124, r125, r131);
        r128.arcTo(r129, 270.0f, 90.0f);
        r128.lineTo(r125, r126);
        r128.lineTo(r123, r126);
        r128.close();
        r100.drawPath(r128, this.f492308c);
        return;
    L16:
        if (r122.getSpanEnd(this) != r110) goto L18;
        float r132 = r120;
        float r133 = r104;
        float r134 = r121;
        float r135 = r106;
        float r136 = this.f492310e;
        Path r137 = this.f492309d;
        RectF r138 = p.f492358b;
        r137.reset();
        r137.moveTo(r132, r133);
        r137.lineTo(r134, r133);
        r137.lineTo(r134, r135 - r136);
        float r139 = 2.0f * r136;
        float r140 = r135 - r139;
        r138.set(r134 - r139, r140, r134, r135);
        r137.arcTo(r138, 0.0f, 90.0f);
        r137.lineTo(r136 + r132, r135);
        r138.set(r132, r140, r139 + r132, r135);
        r137.arcTo(r138, 90.0f, 90.0f);
        r137.close();
        r100.drawPath(r137, this.f492308c);
        return;
    L18:
        this.f492307b.set(r120, r104, r121, r106);
        r100.drawRect(this.f492307b, this.f492308c);
    }
}
