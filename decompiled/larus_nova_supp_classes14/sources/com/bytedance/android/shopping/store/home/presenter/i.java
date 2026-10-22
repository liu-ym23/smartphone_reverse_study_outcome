package com.bytedance.android.shopping.store.home.presenter;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class i implements View.OnTouchListener {
    public final /* synthetic */ ECShopAutoCollapsePresenter a;

    public i(ECShopAutoCollapsePresenter r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r1, MotionEvent r2) {
        this.a.B = true;
        return false;
    }
}
