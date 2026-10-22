package com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron;

import android.widget.FrameLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class r0 implements PDFVerticalSliderBar.b {
    public boolean a;
    public boolean b;
    public final /* synthetic */ PDFThumbnailSlider c;

    public final void a() {
        FrameLayout.LayoutParams r0 = (FrameLayout.LayoutParams) this.c.b.getLayoutParams();
        r0.topMargin = (int) (this.c.a.getIndicatorPercent() * this.c.getHeight());
        int r1 = (int) ((this.c.b.getHeight() - this.c.c.getHeight()) / 2.0f);
        int r2 = (int) ((r0.topMargin - (this.c.b.getHeight() / 2.0f)) + (this.c.a.getIndicatorHeight() / 2.0f));
        r0.topMargin = r2;
        int r3 = -r1;
        if (r2 >= r3) goto L6;
        r0.topMargin = r3;
    L8:
        this.c.b.setLayoutParams(r0);
        return;
    L6:
        if (r2 < ((this.c.getHeight() - this.c.b.getHeight()) + r1)) goto L8;
        r0.topMargin = (this.c.getHeight() - this.c.b.getHeight()) + r1;
        goto L8
    }

    public r0(PDFThumbnailSlider r1) {
        this.c = r1;
    }
}
