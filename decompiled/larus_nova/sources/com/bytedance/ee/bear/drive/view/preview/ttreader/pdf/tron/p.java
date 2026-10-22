package com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron;

import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.drive.view.preview.block.DriveBlockPreviewVM;

/* JADX INFO: loaded from: classes16.dex */
public final class p<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PDFCtrlView f225379a;

    public p(PDFCtrlView r100) {
        this.f225379a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        DriveBlockPreviewVM.BlockState r101 = (DriveBlockPreviewVM.BlockState) r100;
        TextView r102 = this.f225379a.getBlockIndicatorFromXml();
        if (r101 != DriveBlockPreviewVM.BlockState.BLOCK) goto L5;
        int r103 = 0;
    L6:
        r102.setVisibility(r103);
        this.f225379a.m();
        this.f225379a.n();
        return;
    L5:
        r103 = 8;
        goto L6
    }
}
