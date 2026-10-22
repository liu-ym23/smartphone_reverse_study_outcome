package com.bytedance.android.shopping.feed.fragment;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class g implements View.OnTouchListener {
    public final /* synthetic */ ProductFeedContentFragment a;

    public g(ProductFeedContentFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r4, MotionEvent r5) {
        this.a.U90().setOperate(true);
        int r6 = r5.getAction();
        if (r6 == 0) goto L7;
        if (r6 != 1) goto L8;
        this.a.U90().setOperate(false);
    L8:
        dm.a.a("lgz_log_debug").a("recyclerView touch");
        return false;
    L7:
        this.a.U90().getGestureGuideLiveData().setValue(new sd3.a(Boolean.FALSE, 2));
        goto L8
    }
}
