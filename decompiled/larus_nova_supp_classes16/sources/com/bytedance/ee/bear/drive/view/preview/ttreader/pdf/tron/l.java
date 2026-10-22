package com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron;

import com.bytedance.ee.bear.drive.view.preview.pdf.ExhibitionMode;
import com.bytedance.ee.bear.drive.view.preview.pdf.presentationview.PdfPresentationView;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class l<T> implements Predicate {
    public final /* synthetic */ PDFCtrlView a;

    public l(PDFCtrlView r1) {
        this.a = r1;
    }

    public final boolean test(Object r6) {
        PdfPresentationView.a r7 = (PdfPresentationView.a) r6;
        Intrinsics.checkNotNullParameter(r7, "flingEntity");
        tt5.a.h("PDFCtrlView", "presentation mode, fling coming, currentPageIndex: " + r7.a + "isPresentation=" + this.a.getCurrentMode() + ", direction: " + r7.b);
        if (this.a.getCurrentMode() == ExhibitionMode.PRESENTATION) goto L6;
        return false;
    L6:
        if (r7.a > this.a.getPageCount()) goto L8;
    L10:
        int r0 = r7.a;
        if (r0 >= 1) goto L16;
        if (r7.b != 0) goto L16;
        Toast.showCenterToast(this.a.getContext(), this.a.getContext().getText(2131888364), 0);
        return false;
    L16:
        if (r0 != this.a.getPresentationViewFromXml().getPageIndex()) goto L18;
        tt5.a.h("PDFCtrlView", "flingEntity.targetPage == presentation_view.pageIndex ignore");
        return false;
    L18:
        return true;
    L8:
        if (r7.b != 1) goto L10;
        Toast.showCenterToast(this.a.getContext(), this.a.getContext().getText(2131888365), 0);
        return false;
    }
}
