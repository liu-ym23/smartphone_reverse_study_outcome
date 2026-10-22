package com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.drive.biz.preview.orientation.DrivePreviewStatus;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a0<T> implements Observer {
    public final /* synthetic */ PDFCtrlView a;

    public a0(PDFCtrlView r1) {
        this.a = r1;
    }

    public final void onChanged(Object r1) {
        DrivePreviewStatus r2 = (DrivePreviewStatus) r1;
        this.a.getPdfThumbnailViewFromXml().e.notifyDataSetChanged();
    }
}
