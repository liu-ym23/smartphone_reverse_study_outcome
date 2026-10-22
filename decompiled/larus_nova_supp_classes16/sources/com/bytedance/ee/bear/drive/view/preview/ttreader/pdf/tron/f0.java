package com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.RectF;
import com.bytedance.ee.plugin.common.ttpdfreader.PagePart;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class f0<T, R> implements Function {
    public final /* synthetic */ int a;
    public final /* synthetic */ PDFCtrlView b;
    public final /* synthetic */ int[] c;

    public f0(int r1, PDFCtrlView r2, int[] r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final Object apply(Object r7) {
        Integer r8 = (Integer) r7;
        StringBuilder r9 = new StringBuilder("loadPresentationPageView position=");
        r9.append(this.a);
        r9.append(" requestedOrientation2=");
        Activity r0 = (Activity) this.b.getContext();
        Bitmap r1 = null;
        if (r0 == null) goto L5;
        Integer r2 = Integer.valueOf(r0.getRequestedOrientation());
    L6:
        r9.append(r2);
        tt5.a.h("PDFCtrlView", r9.toString());
        PDFCtrlViewModel r10 = this.b.k;
        if (r10 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r10 = null;
    L9:
        int r3 = this.a - 1;
        int[] r4 = this.c;
        int r5 = 0;
        PagePart r11 = r10.getPageForPresentation(r3, r4[0], r4[1]);
        if (r11 == null) goto L12;
        Bitmap r6 = r11.getRenderedBitmap();
    L13:
        if (r6 != null) goto L15;
        return null;
    L15:
        if (r11 == null) goto L17;
        r1 = r11.getRenderedBitmap();
    L17:
        if (r11 == null) goto L21;
        RectF r12 = r11.getPageRelativeBounds();
        if (r12 == null) goto L21;
        int r13 = (int) r12.width();
    L22:
        if (r11 == null) goto L27;
        RectF r14 = r11.getPageRelativeBounds();
        if (r14 == null) goto L27;
        r5 = (int) r14.height();
    L27:
        return new com.bytedance.ee.bear.drive.view.preview.pdf.a.C0181a(r1, r13, r5);
    L21:
        r13 = 0;
        goto L22
    L12:
        r6 = null;
        goto L13
    L5:
        r2 = null;
        goto L6
    }
}
