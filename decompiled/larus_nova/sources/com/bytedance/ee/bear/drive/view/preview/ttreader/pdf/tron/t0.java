package com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron;

import android.util.SizeF;
import android.view.View;
import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class t0 {
    public static final SizeF a(View r100, SizeF r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "pageSizeF");
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
        int r103 = r102.width;
        int r104 = r102.height;
        if (r101.getWidth() <= 0.0f) goto L8;
        if (r101.getHeight() <= 0.0f) goto L8;
        float r105 = r101.getWidth();
        float r106 = r101.getHeight();
        float r107 = Math.min(r103 / r105, r104 / r106);
        r103 = (int) (r105 * r107);
        r104 = (int) (r107 * r106);
    L8:
        return new SizeF(r103 * 1.0f, r104 * 1.0f);
    }

    public static final void b(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
        int r103 = (com.bytedance.ee.util.ui.n.v() - com.bytedance.ee.util.ui.n.d(20)) / r101;
        r102.width = r103;
        r102.height = (int) (((double) r103) * 1.29d);
        r100.requestLayout();
    }
}
