package com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class z implements View.OnLayoutChangeListener {
    public final /* synthetic */ t a;

    public z(t r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        this.a.d.f.setMoreVideoHeight(r1.getHeight());
        t r10 = this.a;
        if (r10.c == true) goto L6;
        r10.h(false);
        return;
    }
}
