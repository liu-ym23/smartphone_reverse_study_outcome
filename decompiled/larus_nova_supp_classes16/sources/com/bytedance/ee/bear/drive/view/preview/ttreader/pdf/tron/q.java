package com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron;

import android.util.SizeF;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.drive.view.preview.pdf.ExhibitionMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class q<T> implements Observer {
    public final /* synthetic */ PDFCtrlView a;

    public q(PDFCtrlView r1) {
        this.a = r1;
    }

    public final void onChanged(Object r9) {
        if (((Boolean) r9).booleanValue() == false) goto L37;
        PDFThumbnailView r10 = this.a.getPdfThumbnailViewFromXml();
        PDFCtrlViewModel r0 = this.a.k;
        PDFCtrlViewModel r1 = null;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r0 = null;
    L8:
        int r2 = r0.getPageCount();
        PDFCtrlViewModel r3 = this.a.k;
        if (r3 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r3 = null;
    L11:
        SizeF r4 = r3.getPageSizeF(0);
        PDFCtrlViewModel r5 = this.a.k;
        if (r5 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r5 = null;
    L14:
        a r6 = r5.getPageLoader();
        r10.getClass();
        Intrinsics.checkNotNullParameter(r4, "pageSizeF");
        Intrinsics.checkNotNullParameter(r6, "pageLoader");
        tt5.a.h("PDFThumbnailView", "PDFThumbnailView.init, pageCount: " + r2 + ", pageSizeF: " + r4);
        r10.a = r2;
        r10.b = r4;
        r10.c = r6;
        r10.e.notifyDataSetChanged();
        PDFThumbnailSlider r11 = this.a.getPdfThumbnailSliderFromXml();
        PDFCtrlViewModel r7 = this.a.k;
        if (r7 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r7 = null;
    L17:
        int r8 = r7.getPageCount();
        PDFCtrlViewModel r12 = this.a.k;
        if (r12 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r12 = null;
    L20:
        SizeF r13 = r12.getPageSizeF(0);
        PDFCtrlViewModel r14 = this.a.k;
        if (r14 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r14 = null;
    L23:
        a r16 = r14.getPageLoader();
        r11.f = r8;
        r11.g = r13;
        r11.h = r16;
        r11.a.setMaxPageCount(r8);
        r11.a.setSeekListener(new r0(r11));
        PDFCtrlView r17 = this.a;
        PDFCtrlViewModel r18 = r17.k;
        if (r18 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L28:
        if (r1.isPPT() == true) goto L30;
    L32:
        com.bytedance.ee.bear.drive.biz.preview.vc.pdf.a.b r19 = r17.r;
        if (r19 == null) goto L36;
        ((com.bytedance.ee.bear.drive.biz.preview.vc.pdf.b.C0156b) r19).b();
        return;
    L36:
        return;
    L30:
        if (r17.v == false) goto L32;
        tt5.a.h("PDFCtrlView", "do checkDefaultExhibitionMode, auto enter presentation mode. ");
        r17.i(1);
        r17.p = ExhibitionMode.PRESENTATION;
        r17.s("auto");
        goto L32
    L26:
        r1 = r18;
        goto L28
    }
}
