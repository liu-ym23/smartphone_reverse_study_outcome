package com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron;

import android.animation.ValueAnimator;
import android.content.Context;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class s<T> implements Observer {
    public final /* synthetic */ PDFCtrlView a;

    public s(PDFCtrlView r1) {
        this.a = r1;
    }

    public final void onChanged(Object r11) {
        Integer r12 = (Integer) r11;
        PDFCtrlView r0 = this.a;
        Intrinsics.checkNotNull(r12);
        int r13 = r12.intValue();
        int r1 = PDFCtrlView.G;
        PDFThumbnailSlider r2 = r0.getPdfThumbnailSliderFromXml();
        boolean r3 = r0.A;
        PDFVerticalSliderBar r4 = r2.a;
        if (r4 != null) goto L5;
    L21:
        TextView r5 = r0.getBlockIndicatorFromXml();
        Context r6 = r0.getContext();
        PDFCtrlViewModel r7 = r0.k;
        PDFCtrlViewModel r8 = null;
        if (r7 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r7 = null;
    L24:
        r5.setText(xo5.a.c(r6, 2131887216, "total", String.valueOf(r7.m372getPageCount().getValue())));
        PDFThumbnailView r9 = r0.getPdfThumbnailViewFromXml();
        PDFCtrlViewModel r10 = r0.k;
        if (r10 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r10 = null;
    L27:
        Integer r14 = (Integer) r10.getIndicator().getValue();
        if (r14 == null) goto L30;
        int r16 = r14.intValue();
    L31:
        r9.setSelected(r16);
        TextView r17 = r0.getIndicatorViewFromXml();
        StringBuilder r18 = new StringBuilder();
        r18.append(r13 + 1);
        r18.append('/');
        PDFCtrlViewModel r19 = r0.k;
        if (r19 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L35:
        r18.append(r8.m372getPageCount().getValue());
        r17.setText(r18.toString());
        r0.A = false;
        return;
    L34:
        r8 = r19;
        goto L35
    L30:
        r16 = 0;
        goto L31
    L5:
        if (r4.getCurrentIndicatorPage() == r13) goto L21;
        final PDFVerticalSliderBar r20 = r2.a;
        r20.g = r13;
        r20.d();
        final FrameLayout.LayoutParams r21 = (FrameLayout.LayoutParams) r20.b.getLayoutParams();
        if (r20.i == true) goto L16;
        if (r3 == true) goto L16;
        ValueAnimator r22 = r20.h;
        if (r22 != null) goto L12;
    L14:
        ValueAnimator r23 = ValueAnimator.ofInt(new int[]{r21.topMargin, r20.b(r20.g)});
        r20.h = r23;
        r23.addUpdateListener(new u0(r20, r21));
        r20.h.start();
    L20:
        r20.i = false;
        goto L21
    L12:
        if (r22.isRunning() == false) goto L14;
        r20.h.cancel();
    L16:
        if (r20.l == false) goto L18;
        int r24 = r20.b(r20.g);
    L19:
        r21.topMargin = r24;
        r20.j = r24;
        r20.b.setLayoutParams(r21);
        goto L20
    L18:
        r24 = r20.a(r20.g, r20.j);
        goto L19
    }
}
