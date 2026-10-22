package com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron;

import android.graphics.Bitmap;
import android.graphics.RectF;
import com.bytedance.ee.bear.drive.view.preview.pdf.SimplePdfView;
import com.bytedance.ee.bear.drive.view.preview.pdf.presentationview.PdfPresentationView;
import com.bytedance.ee.plugin.common.ttpdfreader.PagePart;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class m<T, R> implements Function {
    public final /* synthetic */ PDFCtrlView a;

    public m(PDFCtrlView r1) {
        this.a = r1;
    }

    public final Object apply(Object r8) {
        PdfPresentationView.a r9 = (PdfPresentationView.a) r8;
        Intrinsics.checkNotNullParameter(r9, "flingEntity");
        int r10 = r9.a;
        tt5.a.b("PDFCtrlView", "presentation mode, load page: " + r10);
        PDFCtrlView r0 = this.a;
        PDFCtrlViewModel r1 = r0.k;
        Bitmap r3 = null;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r1 = null;
    L5:
        int r4 = r10 - 1;
        int[] r2 = r0.h(r1.getPageSizeF(r4));
        PDFCtrlViewModel r5 = this.a.k;
        if (r5 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r5 = null;
    L8:
        int r6 = 0;
        PagePart r7 = r5.getPageForPresentation(r4, r2[0], r2[1]);
        if (r7 == null) goto L11;
        r3 = r7.getRenderedBitmap();
    L11:
        if (r7 == null) goto L15;
        RectF r11 = r7.getPageRelativeBounds();
        if (r11 == null) goto L15;
        int r12 = (int) r11.width();
    L16:
        if (r7 == null) goto L21;
        RectF r13 = r7.getPageRelativeBounds();
        if (r13 == null) goto L21;
        r6 = (int) r13.height();
    L21:
        return new SimplePdfView.d(r10, new com.bytedance.ee.bear.drive.view.preview.pdf.a.C0181a(r3, r12, r6));
    L15:
        r12 = 0;
        goto L16
    }
}
