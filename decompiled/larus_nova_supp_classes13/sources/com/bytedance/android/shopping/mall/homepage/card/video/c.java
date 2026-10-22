package com.bytedance.android.shopping.mall.homepage.card.video;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c implements View.OnClickListener {
    public final /* synthetic */ NativeVideoCard a;

    public c(NativeVideoCard r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        NativeVideoCard r3 = this.a;
        int r0 = NativeVideoCard.T1;
        r3.B4().callOnClick();
    }
}
