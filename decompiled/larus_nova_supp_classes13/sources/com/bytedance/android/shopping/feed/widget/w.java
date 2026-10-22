package com.bytedance.android.shopping.feed.widget;

import android.view.View;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.shopping.feed.utils.ProductFeedActionHelper;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class w implements View.OnClickListener {
    public final /* synthetic */ SoldOutMainProductCard a;
    public final /* synthetic */ rd3.a b;

    public w(SoldOutMainProductCard r1, rd3.a r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r10) {
        BtmSDK.INSTANCE.willJumpToNextPage(new BtmItemBuilder("a1.b7365.c686480.d42999", null, 2, null).withView(this.a.b).build());
        ProductFeedActionHelper.h(r10, this.b, null, null, null, null, 124);
    }
}
