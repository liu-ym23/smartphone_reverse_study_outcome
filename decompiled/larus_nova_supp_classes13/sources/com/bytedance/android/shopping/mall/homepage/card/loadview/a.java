package com.bytedance.android.shopping.mall.homepage.card.loadview;

import android.view.View;
import com.bytedance.android.shopping.mall.feed.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ LoadingViewCardVH.b a;

    public a(n.a r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
        LoadingViewCardVH.b r2 = this.a;
        if (r2 == null) goto L6;
        r2.a();
        return;
    }
}
