package com.bytedance.android.shopping.anchorv4.voavhs.detailhead;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class s implements View.OnAttachStateChangeListener {
    public final /* synthetic */ View a;
    public final /* synthetic */ ExpandableLinearLayoutV4 b;

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r1) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r1) {
        this.a.removeOnAttachStateChangeListener(this);
        this.b.getOnBottomViewAttachListener();
    }

    public s(View r1, ExpandableLinearLayoutV4 r2) {
        this.a = r1;
        this.b = r2;
    }
}
