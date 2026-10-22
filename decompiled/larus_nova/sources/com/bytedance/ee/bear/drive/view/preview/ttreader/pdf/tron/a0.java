package com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.drive.biz.preview.orientation.DrivePreviewStatus;

/* JADX INFO: loaded from: classes16.dex */
public final class a0<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PDFCtrlView f225316a;

    public a0(PDFCtrlView r100) {
        this.f225316a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        DrivePreviewStatus r101 = (DrivePreviewStatus) r100;
        this.f225316a.getPdfThumbnailViewFromXml().f225285e.notifyDataSetChanged();
    }
}
