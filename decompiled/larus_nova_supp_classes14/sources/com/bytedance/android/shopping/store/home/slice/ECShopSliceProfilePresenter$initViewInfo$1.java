package com.bytedance.android.shopping.store.home.slice;

import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.ec.store.repository.vo.ECTagListDTO;
import com.bytedance.android.ec.store.repository.vo.TagListScene;
import com.bytedance.android.ec.store.utils.m;
import com.bytedance.android.ec.store.view.ECTagListView;
import com.bytedance.android.ec.store.view.j;
import com.bytedance.android.shopping.store.hybridproduct.ECShopHybridProductViewModel;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECShopSliceProfilePresenter$initViewInfo$1 implements gk3.a {
    public final /* synthetic */ ECShopSliceProfilePresenter a;

    @Override // gk3.a
    public final ECStoreViewModel a() {
        return null;
    }

    @Override // gk3.a
    public final ECShopHybridProductViewModel c() {
        return null;
    }

    @Override // gk3.a
    public final void d(ECTagListView r1) {
    }

    @Override // gk3.a
    public final void e(ECTagListView r1, ECTagListDTO r2) {
        Intrinsics.checkNotNullParameter(r2, "tagListVO");
    }

    @Override // gk3.a
    public final LifecycleOwner getLifecycleOwner() {
        ECShopSliceProfilePresenter r0 = this.a;
        int r1 = ECShopSliceProfilePresenter.D;
        return r0.W();
    }

    public ECShopSliceProfilePresenter$initViewInfo$1(ECShopSliceProfilePresenter r1) {
        this.a = r1;
    }

    @Override // gk3.a
    public final j b(ECTagListDTO r10) {
        Intrinsics.checkNotNullParameter(r10, "tagListVO");
        return new j(TagListScene.SHOP_HEADER_SECOND_LINE_TAG_LIST.getScene(), null, MapsKt.toMutableMap(m.b(this.a.T().getBaseParams())), new ECShopSliceProfilePresenter$initViewInfo$1$getScrollTagListSceneParam$1(this), null, new ECShopSliceProfilePresenter$initViewInfo$1$getScrollTagListSceneParam$2(this), 18);
    }

    @Override // gk3.a
    public final j f(ECTagListDTO r9, View r10) {
        Intrinsics.checkNotNullParameter(r9, "tagListVO");
        return new j(TagListScene.SHOP_HEADRE_FIRST_LINE_TAG_LIST.getScene(), null, MapsKt.toMutableMap(m.b(this.a.T().getBaseParams())), new ECShopSliceProfilePresenter$initViewInfo$1$getTagListSceneParam$1(this), null, null, 82);
    }
}
