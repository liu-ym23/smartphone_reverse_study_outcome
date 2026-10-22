package io.noties.markwon.core.spans;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.text.Layout;
import android.text.Spanned;
import android.text.style.LeadingMarginSpan;

/* JADX INFO: loaded from: classes6.dex */
public final class d implements LeadingMarginSpan {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final boolean f492324i = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final msc.s f492325a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f492326b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RectF f492327c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Rect f492328d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f492329e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f492330f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f492331g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ListMarginInfo f492332h;

    static {
        int r100 = Build.VERSION.SDK_INT;
        if (24 != r100) goto L5;
    L8:
        boolean r101 = true;
    L9:
        f492324i = r101;
        return;
    L5:
        if (25 == r100) goto L8;
        r101 = false;
        goto L9
    }

    @Override // android.text.style.LeadingMarginSpan
    public final int getLeadingMargin(boolean r100) {
        ListMarginInfo r101 = this.f492332h;
        if (r101 == null) goto L5;
        int r102 = r101.getListMargin();
    L7:
        return this.f492329e + r102;
    L5:
        r102 = this.f492325a.f515543c;
        goto L7
    }

    public d(msc.s r100, int r101, int r102, boolean r103) {
        this.f492326b = p.f492359c;
        this.f492327c = p.f492358b;
        this.f492328d = p.f492357a;
        this.f492329e = 0;
        this.f492330f = true;
        this.f492332h = null;
        this.f492325a = r100;
        this.f492332h = null;
        this.f492331g = r101;
        this.f492329e = r102;
        this.f492330f = r103;
    }

    @Override // android.text.style.LeadingMarginSpan
    public final void drawLeadingMargin(Canvas r100, Paint r101, int r102, int r103, int r104, int r105, int r106, CharSequence r107, int r108, int r110, boolean r111, Layout r112) {
        if (this.f492330f == true) goto L5;
        return;
    L5:
        if (r111 == true) goto L7;
        return;
    L7:
        if (ftc.c.a(r108, r107, this) == false) goto L56;
        this.f492326b.set(r101);
        o[] r109 = (o[]) ((Spanned) r107).getSpans(r108, Math.min(r108 + 1, r110), o.class);
        if (r109.length <= 0) goto L12;
        this.f492326b.setAlpha((int) (this.f492326b.getAlpha() * (r109[0].getAlpha() / 255.0f)));
    L12:
        this.f492325a.b(this.f492326b, false);
        int r113 = r100.save();
        ListMarginInfo r114 = this.f492332h;     // Catch: Throwable -> L51
        if (r114 == null) goto L16;
        int r115 = r114.getListMargin();     // Catch: Throwable -> L51
    L17:
        int r116 = (int) ((this.f492326b.descent() - this.f492326b.ascent()) + 0.5f);     // Catch: Throwable -> L51
        ListMarginInfo r117 = this.f492332h;     // Catch: Throwable -> L51
        if (r117 == null) goto L20;
        int r118 = r117.getDotDiameter();     // Catch: Throwable -> L51
    L25:
        int r119 = ((r115 - r118) / 2) + this.f492329e;     // Catch: Throwable -> L51
        ListMarginInfo r120 = this.f492332h;     // Catch: Throwable -> L51
        if (r120 == null) goto L29;
        r119 = r119 + r120.getBulletDotOffset();     // Catch: Throwable -> L51
    L29:
        if (f492324i == false) goto L34;
        if (r103 >= 0) goto L32;
        int r121 = r102 - (r112.getWidth() - (r115 * this.f492331g));     // Catch: Throwable -> L51
    L33:
        int r122 = r102 + (r119 * r103);     // Catch: Throwable -> L51
        int r123 = (r103 * r118) + r122;     // Catch: Throwable -> L51
        int r124 = r103 * r121;     // Catch: Throwable -> L51
        int r125 = Math.min(r122, r123) + r124;     // Catch: Throwable -> L51
        int r126 = Math.max(r122, r123) + r124;     // Catch: Throwable -> L51
    L38:
        int r127 = (r105 + ((int) (((this.f492326b.descent() + this.f492326b.ascent()) / 2.0f) + 0.5f))) - (r118 / 2);     // Catch: Throwable -> L51
        int r128 = r118 + r127;     // Catch: Throwable -> L51
        int r129 = this.f492331g;     // Catch: Throwable -> L51
        if (r129 != 0) goto L41;
    L44:
        this.f492327c.set(r125, r127, r126, r128);     // Catch: Throwable -> L51
        if (this.f492331g != 0) goto L47;
        Paint.Style r130 = Paint.Style.FILL;     // Catch: Throwable -> L51
    L48:
        this.f492326b.setStyle(r130);     // Catch: Throwable -> L51
        r100.drawOval(this.f492327c, this.f492326b);     // Catch: Throwable -> L51
    L49:
        r100.restoreToCount(r113);
        return;
    L47:
        r130 = Paint.Style.STROKE;     // Catch: Throwable -> L51
        goto L48
    L41:
        if (r129 == 1) goto L44;
        this.f492328d.set(r125, r127, r126, r128);     // Catch: Throwable -> L51
        this.f492326b.setStyle(Paint.Style.FILL);     // Catch: Throwable -> L51
        r100.drawRect(this.f492328d, this.f492326b);     // Catch: Throwable -> L51
        goto L49
    L32:
        r121 = (r115 * this.f492331g) - r102;     // Catch: Throwable -> L51
        goto L33
    L34:
        if (r103 > 0) goto L37;
        r102 = r102 - r115;     // Catch: Throwable -> L51
    L37:
        r125 = r102 + r119;     // Catch: Throwable -> L51
        r126 = r125 + r118;     // Catch: Throwable -> L51
        goto L38
    L20:
        msc.s r131 = this.f492325a;     // Catch: Throwable -> L51
        r118 = Math.min(r131.f515543c, r116) / 2;     // Catch: Throwable -> L51
        int r132 = r131.f515552l;     // Catch: Throwable -> L51
        if (r132 == 0) goto L25;
        if (r132 > r118) goto L25;
        r118 = r132;
        goto L25
    L16:
        r115 = this.f492325a.f515543c;     // Catch: Throwable -> L51
    L51:
        th = move-exception;
        r100.restoreToCount(r113);
        throw th;
    }
}
