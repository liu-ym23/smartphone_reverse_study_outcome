package com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron;

import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes16.dex */
public final class r0 implements PDFVerticalSliderBar.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f225384a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f225385b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ PDFThumbnailSlider f225386c;

    public final void a() {
        FrameLayout.LayoutParams r100 = (FrameLayout.LayoutParams) this.f225386c.f225266b.getLayoutParams();
        r100.topMargin = (int) (this.f225386c.f225265a.getIndicatorPercent() * this.f225386c.getHeight());
        int r101 = (int) ((this.f225386c.f225266b.getHeight() - this.f225386c.f225267c.getHeight()) / 2.0f);
        int r102 = (int) ((r100.topMargin - (this.f225386c.f225266b.getHeight() / 2.0f)) + (this.f225386c.f225265a.getIndicatorHeight() / 2.0f));
        r100.topMargin = r102;
        int r103 = -r101;
        if (r102 >= r103) goto L6;
        r100.topMargin = r103;
    L8:
        this.f225386c.f225266b.setLayoutParams(r100);
        return;
    L6:
        if (r102 < ((this.f225386c.getHeight() - this.f225386c.f225266b.getHeight()) + r101)) goto L8;
        r100.topMargin = (this.f225386c.getHeight() - this.f225386c.f225266b.getHeight()) + r101;
        goto L8
    }

    public r0(PDFThumbnailSlider r100) {
        this.f225386c = r100;
    }
}
