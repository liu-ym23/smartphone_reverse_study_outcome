package com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class h implements PDFThumbnailView.d {
    public final /* synthetic */ PDFCtrlView a;

    public h(PDFCtrlView r1) {
        this.a = r1;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron.PDFThumbnailView.d
    public final void onItemClick(int r4) {
        tt5.a.h("PDFCtrlView", "pdf_thumbnail click, page: " + r4);
        PDFCtrlViewModel r0 = this.a.k;
        PDFCtrlViewModel r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r0 = null;
    L5:
        r0.toggleThumbnail();
        PDFCtrlViewModel r2 = this.a.k;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L9:
        r1.turnToPage(r4);
        return;
    L8:
        r1 = r2;
        goto L9
    }
}
