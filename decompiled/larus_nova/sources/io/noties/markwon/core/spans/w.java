package io.noties.markwon.core.spans;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.text.style.LeadingMarginSpan;

/* JADX INFO: loaded from: classes41.dex */
public final class w implements LeadingMarginSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final msc.s f492373a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Rect f492374b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Paint f492375c;

    @Override // android.text.style.LeadingMarginSpan
    public final int getLeadingMargin(boolean r100) {
        return 0;
    }

    public w(msc.s r100) {
        this.f492374b = p.f492357a;
        this.f492375c = p.f492359c;
        this.f492373a = r100;
    }

    @Override // android.text.style.LeadingMarginSpan
    public final void drawLeadingMargin(Canvas r100, Paint r101, int r102, int r103, int r104, int r105, int r106, CharSequence r107, int r110, int r111, boolean r112, Layout r113) {
        int r108 = r104 + ((r106 - r104) / 2);
        this.f492375c.set(r101);
        this.f492373a.c(this.f492375c);
        int r109 = (int) ((((int) (this.f492375c.getStrokeWidth() + 0.5f)) / 2.0f) + 0.5f);
        if (r103 <= 0) goto L5;
        int r114 = r100.getWidth();
    L6:
        this.f492374b.set(r102, r108 - r109, r114, r108 + r109);
        r100.drawRect(this.f492374b, this.f492375c);
        return;
    L5:
        r114 = r102;
        r102 = r102 - r100.getWidth();
        goto L6
    }
}
