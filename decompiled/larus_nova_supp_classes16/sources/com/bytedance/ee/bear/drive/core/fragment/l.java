package com.bytedance.ee.bear.drive.core.fragment;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class l implements View.OnLayoutChangeListener {
    public final /* synthetic */ k a;

    public l(k r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        if (r5 <= r3) goto L10;
        k r10 = this.a;
        if (r10.p != null) goto L12;
        k.b(r10);
        this.a.j();
        k r11 = this.a;
        if (r11.p == null) goto L11;
        r11.e();
        return;
    L11:
        return;
    L12:
        return;
    }
}
