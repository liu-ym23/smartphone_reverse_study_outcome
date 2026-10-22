package com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class s0 implements View.OnClickListener {
    public final /* synthetic */ PDFThumbnailView a;
    public final /* synthetic */ int b;

    public s0(PDFThumbnailView r1, int r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        PDFThumbnailView.d r3 = this.a.getViewDelegate();
        if (r3 == null) goto L6;
        r3.onItemClick(this.b);
        return;
    }
}
