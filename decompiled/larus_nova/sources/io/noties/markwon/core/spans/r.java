package io.noties.markwon.core.spans;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Layout;
import android.text.Spanned;
import android.text.style.LeadingMarginSpan;

/* JADX INFO: loaded from: classes41.dex */
public class r implements LeadingMarginSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final msc.s f492363a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f492364b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Paint f492365c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f492366d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f492367e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f492368f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ListMarginInfo f492369g;

    @Override // android.text.style.LeadingMarginSpan
    public int getLeadingMargin(boolean r100) {
        ListMarginInfo r101 = this.f492369g;
        if (r101 == null) goto L5;
        int r102 = r101.getListMargin();
    L7:
        return Math.max(this.f492366d, r102) + this.f492367e;
    L5:
        r102 = this.f492363a.f515543c;
        goto L7
    }

    public r(msc.s r100, String r101) {
        this.f492365c = p.f492359c;
        this.f492368f = true;
        this.f492369g = null;
        this.f492363a = r100;
        this.f492364b = r101;
        this.f492367e = 0;
    }

    public r(msc.s r100, ListMarginInfo r101, String r102, int r103, boolean r104) {
        this.f492365c = p.f492359c;
        this.f492368f = true;
        this.f492369g = null;
        this.f492363a = r100;
        this.f492369g = r101;
        this.f492364b = r102;
        this.f492367e = r103;
        this.f492368f = r104;
    }

    @Override // android.text.style.LeadingMarginSpan
    public void drawLeadingMargin(Canvas r100, Paint r101, int r102, int r103, int r104, int r105, int r106, CharSequence r107, int r108, int r110, boolean r111, Layout r112) {
        if (r111 == true) goto L4;
        return;
    L4:
        if (ftc.c.a(r108, r107, this) == false) goto L26;
        this.f492365c.set(r101);
        o[] r109 = (o[]) ((Spanned) r107).getSpans(r108, Math.min(r108 + 1, r110), o.class);
        if (r109.length <= 0) goto L9;
        this.f492365c.setAlpha((int) (this.f492365c.getAlpha() * (r109[0].getAlpha() / 255.0f)));
    L9:
        this.f492363a.b(this.f492365c, true);
        if (this.f492368f == true) goto L12;
        return;
    L12:
        int r113 = (int) (this.f492365c.measureText(this.f492364b) + 0.5f);
        ListMarginInfo r114 = this.f492369g;
        if (r114 == null) goto L15;
        int r115 = r114.getListMargin();
    L16:
        if (r113 <= r115) goto L18;
        this.f492366d = r113;
        r115 = r113;
    L19:
        int r116 = r115 + this.f492367e;
        if (r103 <= 0) goto L22;
        int r117 = (r102 + (r116 * r103)) - r113;
    L23:
        r100.drawText(this.f492364b, r117, r105, this.f492365c);
        return;
    L22:
        r117 = (r102 + (r103 * r116)) + (r116 - r113);
        goto L23
    L18:
        this.f492366d = 0;
        goto L19
    L15:
        r115 = this.f492363a.f515543c;
        goto L16
    }
}
