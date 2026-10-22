package com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.drive.view.preview.block.DriveBlockPreviewVM;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class u<T> implements Observer {
    public final /* synthetic */ PDFCtrlView a;

    public u(PDFCtrlView r1) {
        this.a = r1;
    }

    public final void onChanged(Object r4) {
        DriveBlockPreviewVM.BlockState r5 = (DriveBlockPreviewVM.BlockState) r4;
        PDFCtrlViewModel r0 = this.a.k;
        PDFCtrlViewModel r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r0 = null;
    L5:
        Integer r2 = (Integer) r0.m372getPageCount().getValue();
        if (r2 == null) goto L8;
        int r3 = r2.intValue();
    L9:
        if (r3 > 0) goto L11;
        return;
    L11:
        if (r5 != DriveBlockPreviewVM.BlockState.BLOCK) goto L19;
        PDFCtrlViewModel r6 = this.a.k;
        if (r6 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L16:
        r1.setToFirstPage();
        return;
    L15:
        r1 = r6;
        goto L16
    L19:
        return;
    L8:
        r3 = 0;
        goto L9
    }
}
