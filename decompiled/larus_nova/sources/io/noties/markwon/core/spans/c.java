package io.noties.markwon.core.spans;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.text.Layout;
import android.text.Spanned;
import android.text.style.LeadingMarginSpan;
import com.larus.business.markdown.api.model.UnorderedSymbol;

/* JADX INFO: loaded from: classes41.dex */
public final class c implements LeadingMarginSpan {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final boolean f492312k = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final msc.s f492313a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f492314b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RectF f492315c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Rect f492316d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f492317e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f492318f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f492319g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ListMarginInfo f492320h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f492321i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public lw8.j f492322j;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f492323a = null;

        static {
            int[] r100 = new int[UnorderedSymbol.values().length];
            f492323a = r100;
            r100[UnorderedSymbol.DISC.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            f492323a[UnorderedSymbol.CIRCLE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            f492323a[UnorderedSymbol.SQUARE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    static {
        int r100 = Build.VERSION.SDK_INT;
        if (24 != r100) goto L5;
    L8:
        boolean r101 = true;
    L9:
        f492312k = r101;
        return;
    L5:
        if (25 == r100) goto L8;
        r101 = false;
        goto L9
    }

    @Override // android.text.style.LeadingMarginSpan
    public final int getLeadingMargin(boolean r100) {
        ListMarginInfo r101 = this.f492320h;
        if (r101 == null) goto L5;
        int r102 = r101.getListMargin();
    L7:
        return this.f492317e + r102;
    L5:
        r102 = this.f492313a.f515543c;
        goto L7
    }

    public c(msc.s r100, ListMarginInfo r101, int r102, int r103, boolean r104) {
        this.f492314b = p.f492359c;
        this.f492315c = p.f492358b;
        this.f492316d = p.f492357a;
        this.f492317e = 0;
        this.f492319g = true;
        this.f492320h = null;
        this.f492321i = 0;
        this.f492322j = null;
        this.f492313a = r100;
        this.f492320h = r101;
        this.f492318f = r102;
        this.f492317e = r103;
        this.f492319g = r104;
    }

    public final void a(boolean r100, Canvas r101, int r102, int r103, int r104, int r105) {
        this.f492315c.set(r102, r103, r104, r105);
        if (r100 == false) goto L5;
        Paint.Style r106 = Paint.Style.FILL;
    L6:
        this.f492314b.setStyle(r106);
        r101.drawOval(this.f492315c, this.f492314b);
        return;
    L5:
        r106 = Paint.Style.STROKE;
        goto L6
    }

    @Override // android.text.style.LeadingMarginSpan
    public final void drawLeadingMargin(Canvas r110, Paint r111, int r112, int r113, int r114, int r115, int r116, CharSequence r117, int r210, int r211, boolean r212, Layout r213) {
        if (this.f492319g == true) goto L5;
        return;
    L5:
        if (r212 == true) goto L7;
        return;
    L7:
        if (ftc.c.a(r210, r117, this) == false) goto L73;
        this.f492314b.set(r111);
        o[] r100 = (o[]) ((Spanned) r117).getSpans(r210, Math.min(r210 + 1, r211), o.class);
        if (r100.length <= 0) goto L12;
        this.f492314b.setAlpha((int) (this.f492314b.getAlpha() * (r100[0].getAlpha() / 255.0f)));
    L12:
        int r101 = this.f492321i;
        if (r101 == 0) goto L22;
        msc.s r102 = this.f492313a;
        int r103 = r102.f515541a;
        int r104 = r102.f515546f;
        int r105 = r102.f515551k;
        Paint r106 = this.f492314b;
        if (r101 != 0) goto L18;
        r101 = r104;
    L18:
        if (r101 == 0) goto L20;
        r106.setColor(r101);
    L20:
        if (r105 == 0) goto L23;
        r106.setStrokeWidth(r105);
    L23:
        int r107 = r110.save();
        ListMarginInfo r108 = this.f492320h;     // Catch: Throwable -> L68
        if (r108 == null) goto L27;
        int r109 = r108.getListMargin();     // Catch: Throwable -> L68
    L28:
        int r118 = (int) ((this.f492314b.descent() - this.f492314b.ascent()) + 0.5f);     // Catch: Throwable -> L68
        ListMarginInfo r119 = this.f492320h;     // Catch: Throwable -> L68
        if (r119 == null) goto L31;
        int r120 = r119.getDotDiameter();     // Catch: Throwable -> L68
    L36:
        int r121 = ((r109 - r120) / 2) + this.f492317e;     // Catch: Throwable -> L68
        ListMarginInfo r122 = this.f492320h;     // Catch: Throwable -> L68
        if (r122 == null) goto L40;
        r121 = r121 + r122.getBulletDotOffset();     // Catch: Throwable -> L68
    L40:
        if (f492312k == false) goto L45;
        if (r113 >= 0) goto L43;
        int r123 = r112 - (r213.getWidth() - (r109 * this.f492318f));     // Catch: Throwable -> L68
    L44:
        int r124 = (r121 * r113) + r112;     // Catch: Throwable -> L68
        int r125 = (r113 * r120) + r124;     // Catch: Throwable -> L68
        int r126 = r123 * r113;     // Catch: Throwable -> L68
        int r127 = Math.min(r124, r125) + r126;     // Catch: Throwable -> L68
        int r128 = Math.max(r124, r125) + r126;     // Catch: Throwable -> L68
    L49:
        int r129 = (r115 + ((int) (((this.f492314b.descent() + this.f492314b.ascent()) / 2.0f) + 0.5f))) - (r120 / 2);     // Catch: Throwable -> L68
        int r130 = r120 + r129;     // Catch: Throwable -> L68
        lw8.j r131 = this.f492322j;     // Catch: Throwable -> L68
        if (r131 == null) goto L60;
        int r132 = a.f492323a[r131.b(this.f492318f).ordinal()];     // Catch: Throwable -> L68
        if (r132 == 1) goto L59;
        if (r132 != 2) goto L55;
        a(false, r110, r127, r129, r128, r130);     // Catch: Throwable -> L68
    L66:
        r110.restoreToCount(r107);
        return;
    L55:
        if (r132 != 3) goto L66;
        this.f492316d.set(r127, r129, r128, r130);     // Catch: Throwable -> L68
        this.f492314b.setStyle(Paint.Style.FILL);     // Catch: Throwable -> L68
        r110.drawRect(this.f492316d, this.f492314b);     // Catch: Throwable -> L68
        goto L66
    L59:
        a(true, r110, r127, r129, r128, r130);     // Catch: Throwable -> L68
        goto L66
    L60:
        int r133 = this.f492318f;     // Catch: Throwable -> L68
        if (r133 != 0) goto L63;
        a(true, r110, r127, r129, r128, r130);     // Catch: Throwable -> L68
        goto L66
    L63:
        if (r133 != 1) goto L65;
        a(false, r110, r127, r129, r128, r130);     // Catch: Throwable -> L68
        goto L66
    L65:
        this.f492316d.set(r127, r129, r128, r130);     // Catch: Throwable -> L68
        this.f492314b.setStyle(Paint.Style.FILL);     // Catch: Throwable -> L68
        r110.drawRect(this.f492316d, this.f492314b);     // Catch: Throwable -> L68
        goto L66
    L43:
        r123 = (r109 * this.f492318f) - r112;     // Catch: Throwable -> L68
        goto L44
    L45:
        if (r113 <= 0) goto L47;
        int r134 = r112 + r121;     // Catch: Throwable -> L68
    L48:
        r128 = r134 + r120;     // Catch: Throwable -> L68
        r127 = r134;
        goto L49
    L47:
        r134 = (r112 - r109) + r121;     // Catch: Throwable -> L68
        goto L48
    L31:
        msc.s r135 = this.f492313a;     // Catch: Throwable -> L68
        r120 = Math.min(r135.f515543c, r118) / 2;     // Catch: Throwable -> L68
        int r136 = r135.f515552l;     // Catch: Throwable -> L68
        if (r136 == 0) goto L36;
        if (r136 > r120) goto L36;
        r120 = r136;
        goto L36
    L27:
        r109 = this.f492313a.f515543c;     // Catch: Throwable -> L68
    L68:
        th = move-exception;
        r110.restoreToCount(r107);
        throw th;
    L22:
        this.f492313a.b(this.f492314b, false);
        goto L23
    }
}
