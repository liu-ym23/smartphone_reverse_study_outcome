package com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron;

import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class g0<T> implements Consumer {
    public final /* synthetic */ int a;
    public final /* synthetic */ PDFCtrlView b;

    public g0(int r1, PDFCtrlView r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r5) {
        com.bytedance.ee.bear.drive.view.preview.pdf.a.C0181a r6 = (com.bytedance.ee.bear.drive.view.preview.pdf.a.C0181a) r5;
        Intrinsics.checkNotNullParameter(r6, "ret");
        tt5.a.h("PDFCtrlView", "loadPresentationPageView success position=" + this.a);
        this.b.getPresentationViewFromXml().b(this.b.getPageCount(), this.a, r6, this.b.q);
    }
}
