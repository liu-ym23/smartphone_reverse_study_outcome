package com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron;

import android.util.SizeF;
import android.view.View;
import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class t0 {
    public static final SizeF a(View r3, SizeF r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        Intrinsics.checkNotNullParameter(r4, "pageSizeF");
        ViewGroup.LayoutParams r5 = r3.getLayoutParams();
        int r0 = r5.width;
        int r6 = r5.height;
        if (r4.getWidth() <= 0.0f) goto L8;
        if (r4.getHeight() <= 0.0f) goto L8;
        float r1 = r4.getWidth();
        float r7 = r4.getHeight();
        float r8 = Math.min(r0 / r1, r6 / r7);
        r0 = (int) (r1 * r8);
        r6 = (int) (r8 * r7);
    L8:
        return new SizeF(r0 * 1.0f, r6 * 1.0f);
    }

    public static final void b(View r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "view");
        ViewGroup.LayoutParams r0 = r5.getLayoutParams();
        int r1 = (com.bytedance.ee.util.ui.n.v() - com.bytedance.ee.util.ui.n.d(20)) / r6;
        r0.width = r1;
        r0.height = (int) (((double) r1) * 1.29d);
        r5.requestLayout();
    }
}
