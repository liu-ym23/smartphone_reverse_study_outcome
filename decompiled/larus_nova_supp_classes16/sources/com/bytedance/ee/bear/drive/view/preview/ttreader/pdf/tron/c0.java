package com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.drive.view.preview.pdf.ExhibitionMode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c0<T> implements Observer {
    public final /* synthetic */ PDFCtrlView a;

    public c0(PDFCtrlView r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        Void r4 = (Void) r3;
        if (this.a.isAttachedToWindow() == false) goto L13;
        PDFCtrlView r5 = this.a;
        boolean r6 = r5.i(r5.getCurrentPage());
        this.a.s("click");
        if (r6 == false) goto L11;
        PDFCtrlView r7 = this.a;
        r7.p = ExhibitionMode.PRESENTATION;
        com.bytedance.ee.bear.drive.biz.preview.vc.pdf.a.b r0 = r7.r;
        if (r0 == null) goto L12;
        r7.getCurrentPage();
        ((com.bytedance.ee.bear.drive.biz.preview.vc.pdf.b.C0156b) r0).a();
        return;
    L12:
        return;
    L11:
        return;
    }
}
