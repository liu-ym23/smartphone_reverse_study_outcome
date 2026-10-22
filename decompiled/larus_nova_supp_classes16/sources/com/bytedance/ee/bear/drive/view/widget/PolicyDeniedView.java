package com.bytedance.ee.bear.drive.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEmptyState;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class PolicyDeniedView extends SpaceEmptyState {
    /* JADX WARN: Multi-variable type inference failed */
    public final void a() {
        Context r0 = getContext();
        setImageRes(2131232542);
        setImageSizeResource(2131165486);
        setTitle(r0.getString(2131888379));
        setDesc(r0.getString(2131888378));
        setBackgroundColor(getResources().getColor(2131100548));
        setFitsSystemWindows(true);
    }

    public PolicyDeniedView(Context r1) {
        super(r1);
        a();
    }

    public PolicyDeniedView(Context r1, AttributeSet r2) {
        super(r1, r2);
        a();
    }

    public PolicyDeniedView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        a();
    }
}
