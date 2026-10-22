package com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron;

import com.bytedance.ee.bear.drive.view.preview.pdf.ExhibitionMode;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class x implements Runnable {
    public final /* synthetic */ PDFCtrlView a;

    public x(PDFCtrlView r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        PDFCtrlView r0 = this.a;     // Catch: Throwable -> L6
        com.bytedance.ee.bear.drive.biz.preview.vc.pdf.a.b r1 = r0.r;     // Catch: Throwable -> L6
        if (r1 == null) goto L9;
        ExhibitionMode r2 = ExhibitionMode.NORMAL;     // Catch: Throwable -> L6
        r0.getCurrentPage();     // Catch: Throwable -> L6
        ((com.bytedance.ee.bear.drive.biz.preview.vc.pdf.b.C0156b) r1).a();     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
