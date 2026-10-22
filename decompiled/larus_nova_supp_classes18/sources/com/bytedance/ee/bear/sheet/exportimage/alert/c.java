package com.bytedance.ee.bear.sheet.exportimage.alert;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.ee.util.ui.n;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c implements Runnable {
    public final /* synthetic */ ScreenshotImageAlertFragment a;

    public c(ScreenshotImageAlertFragment r1) {
        this.a = r1;
    }

    public final void a() {
        FrameLayout r0 = this.a.n;
        if (r0 == null) goto L5;
        int r1 = r0.getMeasuredWidth();
    L6:
        ScreenshotImageAlertFragment r2 = this.a;
        float r3 = r1 / r2.t;
        r2.v = r3;
        SubsamplingScaleImageView r4 = r2.o;
        if (r4 == null) goto L9;
        r4.setMinScale(r3);
    L9:
        ScreenshotImageAlertFragment r5 = this.a;
        SubsamplingScaleImageView r6 = r5.o;
        if (r6 == null) goto L12;
        float r7 = r5.v;
        int r8 = ScreenshotImageAlertFragment.w;
        r6.setMaxScale(RangesKt.coerceAtLeast(r7, 5.0f));
    L12:
        ScreenshotImageAlertFragment r9 = this.a;
        FrameLayout r10 = r9.n;
        if (r10 == null) goto L16;
        ViewGroup.LayoutParams r11 = r10.getLayoutParams();
        int r12 = ScreenshotImageAlertFragment.w;
        r11.height = Math.min(n.d(398), Math.max(n.d(26), (int) (r9.u * r9.v)));
        r10.setLayoutParams(r11);
        return;
    L16:
        return;
    L5:
        r1 = 0;
        goto L6
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
