package com.bytedance.android.shopping.feed.widget;

import android.widget.FrameLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b implements com.bytedance.android.shopping.feed.widget.gesture.b.InterfaceC0070b {
    public final /* synthetic */ FrameLayout a;

    @Override // com.bytedance.android.shopping.feed.widget.gesture.b.InterfaceC0070b
    public final void onAnimationCancel() {
        this.a.removeAllViews();
        this.a.setVisibility(8);
    }

    @Override // com.bytedance.android.shopping.feed.widget.gesture.b.InterfaceC0070b
    public final void onAnimationEnd() {
        this.a.removeAllViews();
        this.a.setVisibility(8);
    }

    public b(FrameLayout r1) {
        this.a = r1;
    }
}
