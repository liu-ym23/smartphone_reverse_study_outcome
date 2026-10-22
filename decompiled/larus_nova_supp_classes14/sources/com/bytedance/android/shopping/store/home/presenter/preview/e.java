package com.bytedance.android.shopping.store.home.presenter.preview;

import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class e implements View.OnLayoutChangeListener {
    public final /* synthetic */ ViewGroup a;

    public e(ViewGroup r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        if (this.a.getWidth() > 0) goto L5;
        return;
    L5:
        if (this.a.getHeight() <= 0) goto L9;
        ViewGroup r10 = this.a;
        r10.setPivotX(r10.getWidth());
        ViewGroup r11 = this.a;
        r11.setPivotY(r11.getHeight());
        this.a.setScaleX(0.95f);
        this.a.setScaleY(0.95f);
        return;
    }
}
