package com.bytedance.android.shopping.deepfeed.ui.view;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class m implements View.OnClickListener {
    public final /* synthetic */ DeepFeedTopBarManager a;

    public m(DeepFeedTopBarManager r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
        DeepFeedTopBarManager.a(this.a);
    }
}
