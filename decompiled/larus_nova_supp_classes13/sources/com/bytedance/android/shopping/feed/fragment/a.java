package com.bytedance.android.shopping.feed.fragment;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a implements View.OnTouchListener {
    public final /* synthetic */ ProductFeedContentFragment a;

    public a(ProductFeedContentFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r1, MotionEvent r2) {
        this.a.U90().setOperate(true);
        return true;
    }
}
