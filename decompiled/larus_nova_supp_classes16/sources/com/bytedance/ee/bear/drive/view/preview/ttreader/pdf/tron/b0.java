package com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.drive.biz.preview.vc.pdf.DrivePdfState;
import com.bytedance.ee.bear.drive.view.preview.pdf.ExhibitionMode;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b0<T> implements Observer {
    public final /* synthetic */ PDFCtrlView a;

    public b0(PDFCtrlView r1) {
        this.a = r1;
    }

    public final void onChanged(Object r8) {
        DrivePdfState.V2Offset r9 = (DrivePdfState.V2Offset) r8;
        tt5.a.h("PDFCtrlView", "get last preview config is " + r9 + " , scroll to it");
        PDFCtrlView r1 = this.a;
        if (r1.p != ExhibitionMode.PRESENTATION) goto L20;
        tt5.a.h("PDFCtrlView", "exhibitionMode is presentation, return");
        return;
    L20:
        int r5 = r9.pageNumber - 1;     // Catch: Exception -> L17
        float r10 = r9.pageOffsetTop;     // Catch: Exception -> L17
        if (r5 < r1.getPageCount()) goto L9;
        r5 = this.a.getPageCount() - 1;     // Catch: Exception -> L17
    L9:
        int r2 = RangesKt.coerceAtLeast(r5, 0);     // Catch: Exception -> L17
        int r6 = this.a.a(r2);     // Catch: Exception -> L17
        if (r6 <= 0) goto L12;
        int r11 = RangesKt.coerceAtLeast((int) (r6 * r10), 0);     // Catch: Exception -> L17
    L13:
        tt5.a.h("PDFCtrlView", "get last preview page is " + r2 + " offset is " + r11 + " , scroll to it");     // Catch: Exception -> L17
        PDFCtrlView r0 = this.a;     // Catch: Exception -> L17
        r0.A = true;     // Catch: Exception -> L17
        if (r2 > r0.getPageCount()) goto L23;
        this.a.e(r2, -r11);     // Catch: Exception -> L17
        return;
    L23:
        return;
    L12:
        r11 = 0;
    L17:
        e = move-exception;
        tt5.a.e("PDFCtrlView", "scrollToTargetPosition: ", e, false);
    }
}
