package com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class g implements PDFThumbnailSlider.a {
    public final /* synthetic */ PDFCtrlView a;

    @Override // com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron.PDFThumbnailSlider.a
    public final void b() {
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron.PDFThumbnailSlider.a
    public final void c() {
        this.a.getPdfThumbnailToggleViewFromXml().setVisibility(8);
    }

    public g(PDFCtrlView r1) {
        this.a = r1;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron.PDFThumbnailSlider.a
    public final void a(int r3) {
        this.a.getPdfThumbnailToggleViewFromXml().setVisibility(0);
        PDFCtrlViewModel r0 = this.a.k;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r0 = null;
    L5:
        r0.turnToPage(r3);
    }
}
