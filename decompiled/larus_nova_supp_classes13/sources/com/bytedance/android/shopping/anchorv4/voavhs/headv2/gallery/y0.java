package com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class y0 implements View.OnLayoutChangeListener {
    public Integer a;
    public final /* synthetic */ w0 b;

    public y0(w0 r1) {
        this.b = r1;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        if (r1 == null) goto L14;
        int r10 = r1.getHeight();
        Integer r11 = this.a;
        if (r11 != null) goto L7;
    L8:
        this.a = Integer.valueOf(r1.getHeight());
        l r12 = this.b.i;
        if (r12 == null) goto L16;
        GalleryViewModel r13 = r12.f;
        if (r13 == null) goto L17;
        r13.setBottomBarHeight(r1.getHeight());
        return;
    L17:
        return;
    L16:
        return;
    L7:
        if (r10 != r11.intValue()) goto L8;
        return;
    }
}
