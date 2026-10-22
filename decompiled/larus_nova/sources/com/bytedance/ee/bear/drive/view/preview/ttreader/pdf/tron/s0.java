package com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron;

import android.view.View;

/* JADX INFO: loaded from: classes16.dex */
public final class s0 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PDFThumbnailView f225388a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f225389b;

    public s0(PDFThumbnailView r100, int r101) {
        this.f225388a = r100;
        this.f225389b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        PDFThumbnailView.d r101 = this.f225388a.getViewDelegate();
        if (r101 == null) goto L6;
        r101.onItemClick(this.f225389b);
        return;
    }
}
