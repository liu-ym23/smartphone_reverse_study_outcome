package com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron;

import com.bytedance.ee.bear.drive.view.preview.pdf.ExhibitionMode;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes16.dex */
public final class x implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PDFCtrlView f225445a;

    public x(PDFCtrlView r100) {
        this.f225445a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        PDFCtrlView r100 = this.f225445a;     // Catch: Throwable -> L6
        com.bytedance.ee.bear.drive.biz.preview.vc.pdf.a.b r101 = r100.f225237r;     // Catch: Throwable -> L6
        if (r101 == null) goto L9;
        ExhibitionMode r102 = ExhibitionMode.NORMAL;     // Catch: Throwable -> L6
        r100.getCurrentPage();     // Catch: Throwable -> L6
        ((com.bytedance.ee.bear.drive.biz.preview.vc.pdf.b.C3212b) r101).a();     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
