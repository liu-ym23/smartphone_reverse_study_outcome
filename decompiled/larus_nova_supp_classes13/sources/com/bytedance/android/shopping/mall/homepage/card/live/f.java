package com.bytedance.android.shopping.mall.homepage.card.live;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class f implements View.OnLongClickListener {
    public final /* synthetic */ NativeLiveCard a;

    public f(NativeLiveCard r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r2) {
        NativeLiveCard r3 = this.a;
        int r0 = NativeLiveCard.Z2;
        r3.v4();
        return true;
    }
}
