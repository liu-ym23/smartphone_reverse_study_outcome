package com.bytedance.android.window.shop.home.tab.presenter;

import com.bytedance.android.window.shop.home.tab.common.CategoryRequestParamKey;
import com.bytedance.android.window.shop.repository.dto.WindowTabDataListResponseDTODeprecated;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class q implements com.bytedance.android.window.shop.home.tab.b {
    public final /* synthetic */ ECWindowTabPresenter a;

    public q(ECWindowTabPresenter r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.window.shop.home.tab.b
    public final void a(String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "categoryId");
        Intrinsics.checkNotNullParameter(r5, "categoryName");
        ECWindowTabPresenter r0 = this.a;
        int r1 = ECWindowTabPresenter.C;
        r0.i0().setCategoryName(r5);
        this.a.i0().prepareDataSource(r4, this.a.h0().getShopParam().getTargetTabType());
        this.a.i0().init(this.a.h0().getShopParam().getSecAuthorId(), (String) this.a.h0().getShopParam().getPassThroughParam("pass_through_api"), (WindowTabDataListResponseDTODeprecated) this.a.h0().getHeaderSubTabsParam().c.getValue());
        this.a.i0().fillNaviParam(this.a.h0().getShopParam().removeAnchorParam(new CategoryRequestParamKey(this.a.i0().getLastCategoryId(), this.a.h0().getShopParam().getTargetTabType())));
        this.a.i0().loadData();
    }
}
