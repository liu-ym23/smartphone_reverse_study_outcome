package com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron;

import android.widget.ImageView;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.drive.view.preview.block.DriveBlockPreviewVM;
import com.bytedance.ee.bear.drive.view.preview.wrapper.PreviewViewModel;
import com.bytedance.ee.bear.drive.view.preview.wrapper.ViewOwner;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class r<T> implements Observer {
    public final /* synthetic */ PDFCtrlView a;

    public r(PDFCtrlView r1) {
        this.a = r1;
    }

    public final void onChanged(Object r7) {
        Boolean r8 = (Boolean) r7;
        boolean r2 = true;
        this.a.getPdfContentViewFromXml().setVisible(!r8.booleanValue());
        ImageView r0 = this.a.getPdfThumbnailToggleViewFromXml();
        if (r8.booleanValue() == true) goto L5;
        int r1 = 2131253649;
    L6:
        r0.setImageResource(r1);
        boolean r3 = !r8.booleanValue();
        DriveBlockPreviewVM r4 = this.a.m;
        ViewOwner r5 = null;
        if (r4 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("blockVM");
        r4 = null;
    L9:
        int r6 = 0;
        if (r4.isFromBlockPreview() == false) goto L20;
        if (r3 == false) goto L18;
        DriveBlockPreviewVM r9 = this.a.m;
        if (r9 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("blockVM");
        r9 = null;
    L16:
        if (r9.getLiveBlockState().getValue() != DriveBlockPreviewVM.BlockState.FULLSCREEN) goto L18;
    L19:
        r3 = r2;
    L18:
        r2 = false;
    L20:
        tt5.a.h("PDFCtrlView", "bindView - showThumbnailObserver, sliderShow: " + r3);
        if (r3 == false) goto L23;
        this.a.getPdfThumbnailSliderFromXml().d(false);
    L24:
        PDFCtrlViewModel r10 = this.a.k;
        if (r10 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r10 = null;
    L27:
        r10.exitFullscreen();
        PDFThumbnailView r11 = this.a.getPdfThumbnailViewFromXml();
        Intrinsics.checkNotNull(r8);
        r11.setVisible(r8.booleanValue());
        PDFThumbnailView r12 = this.a.getPdfThumbnailViewFromXml();
        PDFCtrlViewModel r13 = this.a.k;
        if (r13 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r13 = null;
    L30:
        Integer r14 = (Integer) r13.getIndicator().getValue();
        if (r14 == null) goto L33;
        r6 = r14.intValue();
    L33:
        r12.setSelected(r6);
        ViewOwner r16 = this.a.j;
        if (r16 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("viewOwner");
    L37:
        ((PreviewViewModel) r5.viewModel(PreviewViewModel.class)).liveInnerThumbVisibleState().setValue(r8);
        return;
    L36:
        r5 = r16;
        goto L37
    L23:
        this.a.getPdfThumbnailSliderFromXml().c(false);
        goto L24
    L5:
        r1 = 2131256149;
        goto L6
    }
}
