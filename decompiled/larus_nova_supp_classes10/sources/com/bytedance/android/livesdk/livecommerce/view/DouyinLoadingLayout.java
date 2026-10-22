package com.bytedance.android.livesdk.livecommerce.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class DouyinLoadingLayout extends FrameLayout {
    public View a;

    public DouyinLoadingLayout(Context r3) {
        super(r3);
        if (r3 == null) goto L7;
        this.a = LayoutInflater.from(r3).inflate(2131560763, this, true).findViewById(2131370123);
        return;
    }

    @Override // android.view.View
    public void setVisibility(int r2) {
        super.setVisibility(r2);
        View r0 = this.a;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.setVisibility(r2);
    }

    public DouyinLoadingLayout(Context r2, AttributeSet r3) {
        super(r2, r3);
        if (r2 == null) goto L7;
        this.a = LayoutInflater.from(r2).inflate(2131560763, this, true).findViewById(2131370123);
        return;
    }
}
