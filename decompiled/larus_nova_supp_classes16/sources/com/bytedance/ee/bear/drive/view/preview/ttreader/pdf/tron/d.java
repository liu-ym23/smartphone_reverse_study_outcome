package com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d implements PDFContentView.b {
    public final /* synthetic */ PDFCtrlView a;

    @Override // com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron.PDFContentView.b
    public final void a() {
    }

    public d(PDFCtrlView r1) {
        this.a = r1;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron.PDFContentView.b
    public final void b(String r4) {
        PDFCtrlViewModel r0 = this.a.k;
        a95.a r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r0 = null;
    L5:
        a95.a r2 = this.a.B;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("userComponentAbility");
    L9:
        r0.openPdf(r4, r1);
        return;
    L8:
        r1 = r2;
        goto L9
    }
}
