package com.bytedance.android.shopping.store.home.view;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class r implements View.OnLayoutChangeListener {
    public final /* synthetic */ ECStoreXzgLevelView a;

    public r(ECStoreXzgLevelView r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        if (this.a.getWidth() >= this.a.a.getMeasuredWidth()) goto L6;
        this.a.a.setVisibility(8);
        return;
    }
}
