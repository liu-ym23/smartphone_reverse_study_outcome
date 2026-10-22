package com.bytedance.android.shopping.mall.homepage.card.live;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class i implements View.OnClickListener {
    public final /* synthetic */ NativeLiveCard a;

    public i(NativeLiveCard r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        NativeLiveCard r3 = this.a;
        int r0 = NativeLiveCard.Z2;
        r3.O4().callOnClick();
    }
}
