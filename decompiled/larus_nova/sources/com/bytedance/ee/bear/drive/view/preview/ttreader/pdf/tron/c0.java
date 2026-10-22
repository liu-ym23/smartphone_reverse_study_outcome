package com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.drive.view.preview.pdf.ExhibitionMode;

/* JADX INFO: loaded from: classes16.dex */
public final class c0<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PDFCtrlView f225330a;

    public c0(PDFCtrlView r100) {
        this.f225330a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Void r101 = (Void) r100;
        if (this.f225330a.isAttachedToWindow() == false) goto L13;
        PDFCtrlView r102 = this.f225330a;
        boolean r103 = r102.i(r102.getCurrentPage());
        this.f225330a.s("click");
        if (r103 == false) goto L11;
        PDFCtrlView r104 = this.f225330a;
        r104.f225235p = ExhibitionMode.PRESENTATION;
        com.bytedance.ee.bear.drive.biz.preview.vc.pdf.a.b r105 = r104.f225237r;
        if (r105 == null) goto L12;
        r104.getCurrentPage();
        ((com.bytedance.ee.bear.drive.biz.preview.vc.pdf.b.C3212b) r105).a();
        return;
    L12:
        return;
    L11:
        return;
    }
}
