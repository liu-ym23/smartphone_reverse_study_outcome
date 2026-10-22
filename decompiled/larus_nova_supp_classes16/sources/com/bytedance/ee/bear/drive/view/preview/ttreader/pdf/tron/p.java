package com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron;

import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.drive.view.preview.block.DriveBlockPreviewVM;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class p<T> implements Observer {
    public final /* synthetic */ PDFCtrlView a;

    public p(PDFCtrlView r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        DriveBlockPreviewVM.BlockState r4 = (DriveBlockPreviewVM.BlockState) r3;
        TextView r0 = this.a.getBlockIndicatorFromXml();
        if (r4 != DriveBlockPreviewVM.BlockState.BLOCK) goto L5;
        int r5 = 0;
    L6:
        r0.setVisibility(r5);
        this.a.m();
        this.a.n();
        return;
    L5:
        r5 = 8;
        goto L6
    }
}
