package com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron;

import com.bytedance.ee.bear.drive.view.preview.pdf.SimplePdfView;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class n<T> implements Consumer {
    public final /* synthetic */ PDFCtrlView a;

    public n(PDFCtrlView r1) {
        this.a = r1;
    }

    public final void accept(Object r5) {
        SimplePdfView.d r6 = (SimplePdfView.d) r5;
        Intrinsics.checkNotNullParameter(r6, "pdfResultWrapper");
        if (r6.b.a() == false) goto L7;
        this.a.getPresentationViewFromXml().b(this.a.getPageCount(), r6.a, r6.b, this.a.q);
        PDFCtrlView r7 = this.a;
        com.bytedance.ee.bear.drive.biz.preview.vc.pdf.a.b r0 = r7.r;
        if (r0 == null) goto L9;
        r7.getCurrentPage();
        tt5.a.b("CCMFollow_PDFVCFollowConnector", "ExhibitionModeChangeListener onScrollChange: ");
        ((l65.a.C0248a) ((com.bytedance.ee.bear.drive.biz.preview.vc.pdf.b.C0156b) r0).a).b();
        return;
    L9:
        return;
    L7:
        tt5.a.e("PDFCtrlView", "load page err. ", r6.b.d, false);
    }
}
