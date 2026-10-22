package com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.drive.view.preview.pdf.presentationview.PdfPresentationView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d0<T> implements Observer {
    public final /* synthetic */ PDFCtrlView a;

    public d0(PDFCtrlView r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        Boolean r3 = (Boolean) r2;
        if (this.a.isAttachedToWindow() == false) goto L7;
        PdfPresentationView r0 = this.a.getPresentationViewFromXml();
        Intrinsics.checkNotNull(r3);
        r0.setBackTitle(r3.booleanValue());
        return;
    }
}
