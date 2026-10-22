package com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.drive.biz.preview.vc.pdf.DrivePdfState;
import com.bytedance.ee.bear.drive.view.preview.pdf.ExhibitionMode;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes16.dex */
public final class b0<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PDFCtrlView f225326a;

    public b0(PDFCtrlView r100) {
        this.f225326a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        DrivePdfState.V2Offset r101 = (DrivePdfState.V2Offset) r100;
        tt5.a.h("PDFCtrlView", "get last preview config is " + r101 + " , scroll to it");
        PDFCtrlView r102 = this.f225326a;
        if (r102.f225235p != ExhibitionMode.PRESENTATION) goto L20;
        tt5.a.h("PDFCtrlView", "exhibitionMode is presentation, return");
        return;
    L20:
        int r103 = r101.pageNumber - 1;     // Catch: Exception -> L17
        float r104 = r101.pageOffsetTop;     // Catch: Exception -> L17
        if (r103 < r102.getPageCount()) goto L9;
        r103 = this.f225326a.getPageCount() - 1;     // Catch: Exception -> L17
    L9:
        int r105 = RangesKt.coerceAtLeast(r103, 0);     // Catch: Exception -> L17
        int r106 = this.f225326a.a(r105);     // Catch: Exception -> L17
        if (r106 <= 0) goto L12;
        int r107 = RangesKt.coerceAtLeast((int) (r106 * r104), 0);     // Catch: Exception -> L17
    L13:
        tt5.a.h("PDFCtrlView", "get last preview page is " + r105 + " offset is " + r107 + " , scroll to it");     // Catch: Exception -> L17
        PDFCtrlView r108 = this.f225326a;     // Catch: Exception -> L17
        r108.A = true;     // Catch: Exception -> L17
        if (r105 > r108.getPageCount()) goto L23;
        this.f225326a.e(r105, -r107);     // Catch: Exception -> L17
        return;
    L23:
        return;
    L12:
        r107 = 0;
    L17:
        e = move-exception;
        tt5.a.e("PDFCtrlView", "scrollToTargetPosition: ", e, false);
    }
}
