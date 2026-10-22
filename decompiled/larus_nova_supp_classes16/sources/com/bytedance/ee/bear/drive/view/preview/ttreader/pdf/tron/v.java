package com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron;

import androidx.lifecycle.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class v<T> implements Observer {
    public final /* synthetic */ PDFCtrlView a;

    public v(PDFCtrlView r1) {
        this.a = r1;
    }

    public final void onChanged(Object r4) {
        Boolean r0 = Boolean.TRUE;
        if (Intrinsics.areEqual((Boolean) r4, r0) == false) goto L15;
        PDFCtrlViewModel r5 = this.a.k;
        PDFCtrlViewModel r1 = null;
        if (r5 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r5 = null;
    L8:
        if (Intrinsics.areEqual(r5.getShowThumbnail().getValue(), r0) == false) goto L16;
        PDFCtrlViewModel r6 = this.a.k;
        if (r6 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L13:
        r1.getShowThumbnail().postValue(Boolean.FALSE);
        return;
    L12:
        r1 = r6;
        goto L13
    L16:
        return;
    }
}
