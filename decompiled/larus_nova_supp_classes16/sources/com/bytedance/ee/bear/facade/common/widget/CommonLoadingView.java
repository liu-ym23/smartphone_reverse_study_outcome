package com.bytedance.ee.bear.facade.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.github.ybq.android.spinkit.SpinKitView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class CommonLoadingView extends LinearLayout {
    public Context a;
    public xu7.b b;

    public CommonLoadingView(Context r1) {
        super(r1);
        a(r1);
    }

    public final void a(Context r4) {
        setBackground(r4.getResources().getDrawable(2131235303));
        int r0 = com.bytedance.ee.util.ui.n.d(21);
        int r1 = com.bytedance.ee.util.ui.n.d(10);
        int r2 = com.bytedance.ee.util.ui.n.d(42);
        setPadding(r0, r1, r0, r1);
        setGravity(17);
        this.a = r4;
        SpinKitView r5 = new SpinKitView(this.a);
        ViewGroup.LayoutParams r3 = new LinearLayout.LayoutParams(r2, r2);
        r5.setVisibility(0);
        xu7.b r6 = new xu7.b();
        this.b = r6;
        r5.setIndeterminateDrawable(r6);
        this.b.stop();
        addView(r5, r3);
    }

    public CommonLoadingView(Context r1, AttributeSet r2) {
        super(r1, r2);
        a(r1);
    }

    public CommonLoadingView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        a(r1);
    }
}
