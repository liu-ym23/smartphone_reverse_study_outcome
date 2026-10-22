package com.bytedance.android.shopping.feed.widget;

import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c implements View.OnTouchListener {
    public final /* synthetic */ FrameLayout a;

    public c(FrameLayout r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r1, MotionEvent r2) {
        if (r2.getAction() != 0) goto L6;
        this.a.removeAllViews();
        this.a.setVisibility(8);
    L6:
        dm.a.a("lgz_log_debug").a("gestureContainer touch");
        return false;
    }
}
