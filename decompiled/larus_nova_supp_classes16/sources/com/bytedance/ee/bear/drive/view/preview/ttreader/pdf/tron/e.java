package com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e implements View.OnClickListener {
    public final /* synthetic */ PDFCtrlView a;

    public e(PDFCtrlView r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
        PDFCtrlViewModel r2 = this.a.k;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r2 = null;
    L5:
        r2.toggleThumbnail();
    }
}
