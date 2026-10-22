package com.bytedance.ee.bear.facade.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.github.ybq.android.spinkit.SpinKitView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes16.dex */
public class CommonLoadingView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f226446a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public xu7.b f226447b;

    public CommonLoadingView(Context r100) {
        super(r100);
        a(r100);
    }

    public final void a(Context r100) {
        setBackground(r100.getResources().getDrawable(R.drawable.facade_loading_view_bg));
        int r101 = com.bytedance.ee.util.ui.n.d(21);
        int r102 = com.bytedance.ee.util.ui.n.d(10);
        int r103 = com.bytedance.ee.util.ui.n.d(42);
        setPadding(r101, r102, r101, r102);
        setGravity(17);
        this.f226446a = r100;
        SpinKitView r104 = new SpinKitView(this.f226446a);
        ViewGroup.LayoutParams r105 = new LinearLayout.LayoutParams(r103, r103);
        r104.setVisibility(0);
        xu7.b r106 = new xu7.b();
        this.f226447b = r106;
        r104.setIndeterminateDrawable(r106);
        this.f226447b.stop();
        addView(r104, r105);
    }

    public CommonLoadingView(Context r100, AttributeSet r101) {
        super(r100, r101);
        a(r100);
    }

    public CommonLoadingView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        a(r100);
    }
}
