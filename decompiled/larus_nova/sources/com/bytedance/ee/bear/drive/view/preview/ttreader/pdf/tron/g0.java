package com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron;

import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class g0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f225353a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PDFCtrlView f225354b;

    public g0(int r100, PDFCtrlView r101) {
        this.f225353a = r100;
        this.f225354b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        com.bytedance.ee.bear.drive.view.preview.pdf.a.C3237a r101 = (com.bytedance.ee.bear.drive.view.preview.pdf.a.C3237a) r100;
        Intrinsics.checkNotNullParameter(r101, "ret");
        tt5.a.h("PDFCtrlView", "loadPresentationPageView success position=" + this.f225353a);
        this.f225354b.getPresentationViewFromXml().b(this.f225354b.getPageCount(), this.f225353a, r101, this.f225354b.f225236q);
    }
}
