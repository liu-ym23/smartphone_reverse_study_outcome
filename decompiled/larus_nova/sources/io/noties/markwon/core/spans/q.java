package io.noties.markwon.core.spans;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Layout;
import android.text.Spanned;

/* JADX INFO: loaded from: classes41.dex */
public final class q extends r {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ListMarginInfo f492360h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f492361i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f492362j;

    public q(msc.s r100, ListMarginInfo r101, String r102, int r103, boolean r104) {
        super(r100, r101, r102, r103, r104);
        this.f492362j = 0;
        this.f492361i = r102;
        this.f492360h = r101;
    }

    @Override // io.noties.markwon.core.spans.r, android.text.style.LeadingMarginSpan
    public final void drawLeadingMargin(Canvas r100, Paint r101, int r102, int r103, int r104, int r105, int r106, CharSequence r107, int r108, int r110, boolean r111, Layout r112) {
        if (r111 == true) goto L4;
        return;
    L4:
        if (ftc.c.a(r108, r107, this) == false) goto L37;
        this.f492365c.set(r101);
        o[] r109 = (o[]) ((Spanned) r107).getSpans(r108, Math.min(r108 + 1, r110), o.class);
        if (r109.length <= 0) goto L9;
        this.f492365c.setAlpha((int) (this.f492365c.getAlpha() * (r109[0].getAlpha() / 255.0f)));
    L9:
        int r113 = this.f492362j;
        if (r113 == 0) goto L19;
        msc.s r114 = this.f492363a;
        int r115 = r114.f515541a;
        int r116 = r114.f515546f;
        int r117 = r114.f515551k;
        Paint r118 = this.f492365c;
        if (r113 != 0) goto L15;
        r113 = r116;
    L15:
        if (r113 == 0) goto L17;
        r118.setColor(r113);
    L17:
        if (r117 == 0) goto L21;
        r118.setStrokeWidth(r117);
    L21:
        if (this.f492368f == true) goto L23;
        return;
    L23:
        int r119 = (int) (this.f492365c.measureText(this.f492364b) + 0.5f);
        ListMarginInfo r120 = this.f492360h;
        if (r120 == null) goto L26;
        int r121 = r120.getListMargin();
    L27:
        if (r119 <= r121) goto L29;
        this.f492366d = r119;
        r121 = r119;
    L30:
        int r122 = r121 + this.f492367e;
        if (r103 <= 0) goto L33;
        int r123 = (r102 + (r122 * r103)) - r119;
    L34:
        r100.drawText(this.f492364b, r123, r105, this.f492365c);
        return;
    L33:
        r123 = (r102 + (r103 * r122)) + (r122 - r119);
        goto L34
    L29:
        this.f492366d = 0;
        goto L30
    L26:
        r121 = this.f492363a.f515543c;
        goto L27
    L19:
        this.f492363a.b(this.f492365c, true);
        goto L21
    }
}
