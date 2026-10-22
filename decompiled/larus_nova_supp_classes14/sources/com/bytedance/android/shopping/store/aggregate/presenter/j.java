package com.bytedance.android.shopping.store.aggregate.presenter;

import android.view.View;
import com.bytedance.android.ec.store.repository.vo.p;
import com.bytedance.android.shopping.store.aggregate.ShopAggregateParam;
import com.bytedance.android.shopping.store.aggregate.viewmodel.ShopAggregatePageProductViewModel;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentScene;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class j implements View.OnClickListener {
    public final /* synthetic */ k a;
    public final /* synthetic */ p b;

    public j(k r1, p r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        ShopAggregatePageProductViewModel r4 = this.a.a.f;
        if (r4 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        ShopAggregateParam r5 = r4.getStoreParam();
        qi3.a r0 = new qi3.a();
        r0.d = r5.getStoreAccountParam().getUserId();
        r0.e = r5.getShopId();
        r0.f = r5.getSecShopId();
        r0.g = r5.getEntranceLocation();
        r0.a = r5.getEnterFrom();
        r0.h = "store_page";
        r0.b = "store_page";
        r0.c = "product_list";
        r0.i = "featured";
        r0.j = r5.getTempId();
        r0.k = r5.getProductBasicRequestParam().getMaterialId();
        if (r5.isPreview() == false) goto L8;
        String r6 = CommentScene.COMMENTSCENE_NO_AWEME;
    L9:
        r0.l = r6;
        r0.post(null, null);
        com.bytedance.android.ec.sdk.helper.p.a.openSchema(this.a.a.Y().c(), this.b.a);
        return;
    L8:
        r6 = "0";
        goto L9
    }
}
