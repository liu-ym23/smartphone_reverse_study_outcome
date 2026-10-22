package com.bytedance.android.shopping.mall.homepage.card.video;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a implements View.OnLongClickListener {
    public final /* synthetic */ NativeVideoCard a;

    public a(NativeVideoCard r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r2) {
        NativeVideoCard r3 = this.a;
        int r0 = NativeVideoCard.T1;
        r3.v4();
        return true;
    }
}
