package com.bytedance.android.shopping.store.hybridproduct.presenter;

import android.view.View;
import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.store.preload.ShopImagePreloadConfig;
import com.bytedance.android.ec.store.product.holder.LayoutTypes;
import com.bytedance.android.ec.store.repository.vo.StoreV2ProductItemVO;
import com.bytedance.android.shopping.store.home.api.ECStoreParam;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import com.bytedance.android.shopping.widget.ecvideoplayer.ECVideoPlayer;
import java.util.HashSet;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECShopProductCardGroupPresenter$adapter$1 implements sm.h {
    public final /* synthetic */ ECShopProductCardGroupPresenter a;

    public final Function3<String, String, Long, Unit> b() {
        return null;
    }

    public final void i(View r1) {
    }

    public final jm.a<ej3.a> q() {
        return null;
    }

    public final String a() {
        return this.a.o0().getStoreParam().getStoreAccountParam().getUserId();
    }

    public final LayoutTypes c() {
        LayoutTypes r0 = (LayoutTypes) this.a.o0().getLayoutType().getValue();
        if (r0 == null) goto L5;
        return r0;
    L5:
        return LayoutTypes.RECYCLER_VIEW_ITEM_DOUBLE;
    }

    public final String d() {
        return this.a.o0().getStoreParam().getStoreAccountParam().getSecUserId();
    }

    public final Function1<Integer, Unit> e() {
        return new ECShopProductCardGroupPresenter$adapter$1$addCartListener$1(this);
    }

    public final xm.c f() {
        return this.a.o0().getTagPools();
    }

    public final String g() {
        String r1 = this.a.o0().getStoreParam().getStoreSourcePage();
        String r2 = this.a.o0().getStoreParam().getStoreSourceMethod();
        String r3 = this.a.o0().getStoreParam().getStoreGroupType();
        String r4 = this.a.o0().getStoreParam().getEnterFrom();
        String r5 = this.a.o0().getStoreParam().getTempId();
        String r6 = this.a.o0().getStoreParam().getProductBasicRequestParam().getMaterialId();
        if (((LayoutTypes) this.a.o0().getLayoutType().getValue()) != LayoutTypes.RECYCLER_VIEW_ITEM_SINGLE) goto L5;
        boolean r7 = true;
    L7:
        return u.a(r1, r2, r3, r4, r5, r6, r7, this.a.o0().hasDiscountSelected(), this.a.o0().getStoreParam().getShareContent(), this.a.o0().getStoreParam().getEntranceLocation());
    L5:
        r7 = false;
        goto L7
    }

    public final boolean isClickable() {
        return !this.a.o0().getStoreParam().isPreview();
    }

    public final qn.a<ECVideoPlayer> k() {
        ECStoreViewModel r0 = this.a.v;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getPlayerPool();
    }

    public final long l() {
        ECStoreViewModel r0 = this.a.v;
        if (r0 == null) goto L7;
        ECStoreParam r1 = r0.getStoreParam();
        if (r1 == null) goto L7;
        return r1.getLifecycleMonitorId();
    L7:
        return -1;
    }

    public final Integer n() {
        return this.a.o0().getTitleMaxLines();
    }

    public final xm.c o() {
        ECStoreViewModel r0 = this.a.v;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getMultiLeveViewCache();
    }

    public ECShopProductCardGroupPresenter$adapter$1(ECShopProductCardGroupPresenter r1) {
        this.a = r1;
    }

    public final boolean h(StoreV2ProductItemVO r2) {
        HashSet<String> r0 = this.a.o0().getSkuProductIdRecords();
        if (r2 == null) goto L5;
        String r3 = r2.a;
    L7:
        if (CollectionsKt.contains(r0, r3) == false) goto L10;
        return false;
    L10:
        return true;
    L5:
        r3 = null;
        goto L7
    }

    public final com.bytedance.android.ec.core.imagex.r j(Integer r2) {
        ShopImagePreloadConfig r0 = (ShopImagePreloadConfig) this.a.p.getValue();
        if (r0 == null) goto L7;
        Integer r1 = r0.getFirstScreenCount();
        if (r1 == null) goto L7;
        int r3 = r1.intValue();
    L8:
        if (r2 == null) goto L15;
        if (r3 < 0) goto L15;
        if (r2.intValue() > r3) goto L14;
        int r4 = com.bytedance.android.ec.core.imagex.r.h;
        return com.bytedance.android.ec.core.imagex.r.a.c("ec_shop_home_product_card_first");
    L14:
        int r5 = com.bytedance.android.ec.core.imagex.r.h;
        return com.bytedance.android.ec.core.imagex.r.a.c("ec_shop_home_product_card_more");
    L15:
        int r6 = com.bytedance.android.ec.core.imagex.r.h;
        return com.bytedance.android.ec.core.imagex.r.a.c("ec_shop_home_product_card");
    L7:
        r3 = -1;
        goto L8
    }

    public final boolean m(StoreV2ProductItemVO r9) {
        HashSet<String> r0 = this.a.o0().getSkuProductIdRecords();
        Boolean r1 = null;
        if (r9 == null) goto L5;
        String r2 = r9.a;
    L7:
        if (CollectionsKt.contains(r0, r2) == false) goto L9;
        return false;
    L9:
        ECStoreViewModel r3 = this.a.v;
        if (r3 != null) goto L12;
    L13:
        ECStoreViewModel r4 = this.a.v;
        if (r4 != null) goto L16;
    L18:
        boolean r5 = false;
    L19:
        ECStoreViewModel r6 = this.a.v;
        if (r6 == null) goto L24;
        jm.a<Float> r7 = r6.getCollapseFactor();
        if (r7 == null) goto L24;
        Float r8 = (Float) r7.getValue();
    L25:
        boolean r10 = Intrinsics.areEqual(r8, 1.0f);
        dm.a.b r11 = dm.a.a("测试播放");
        StringBuilder r12 = new StringBuilder("canScrollImage:是否有头部直播或者视频:");
        r12.append(r5);
        r12.append(",是否吸顶:");
        r12.append(r10);
        r12.append(",对应状态: ");
        int r13 = ECSdk.a;
        IAdapterService r14 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r14 == null) goto L30;
        com.bytedance.android.ec.adapter.api.j r15 = r14.getLiveWindowService();
        if (r15 == null) goto L30;
        r1 = Boolean.valueOf(r15.isFloatWindowShowing());
    L30:
        r12.append(r1);
        r11.a(r12.toString());
        if (r5 == false) goto L33;
        if (r10 == true) goto L33;
    L39:
        return false;
    L33:
        IAdapterService r16 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r16 == null) goto L40;
        com.bytedance.android.ec.adapter.api.j r17 = r16.getLiveWindowService();
        if (r17 == null) goto L40;
        if (r17.isFloatWindowShowing() == true) goto L39;
    L40:
        if (r9 == null) goto L46;
        com.bytedance.android.ec.store.repository.dto.l.b r18 = r9.s;
        if (r18 == null) goto L46;
        if (r18.c() != true) goto L46;
        return false;
    L46:
        return true;
    L24:
        r8 = null;
        goto L25
    L16:
        if (r4.couldLive() != true) goto L18;
    L17:
        r5 = true;
        goto L19
    L12:
        if (r3.couldVideo() == true) goto L17;
    L5:
        r2 = null;
        goto L7
    }

    public final com.bytedance.android.ec.core.imagex.r p(Integer r2) {
        ShopImagePreloadConfig r0 = (ShopImagePreloadConfig) this.a.p.getValue();
        if (r0 == null) goto L7;
        Integer r1 = r0.getFirstScreenCount();
        if (r1 == null) goto L7;
        int r3 = r1.intValue();
    L8:
        if (r2 == null) goto L15;
        if (r3 < 0) goto L15;
        if (r2.intValue() > r3) goto L14;
        int r4 = com.bytedance.android.ec.core.imagex.r.h;
        return com.bytedance.android.ec.core.imagex.r.a.c("ec_shop_home_product_card_sku_first");
    L14:
        int r5 = com.bytedance.android.ec.core.imagex.r.h;
        return com.bytedance.android.ec.core.imagex.r.a.c("ec_shop_home_product_card_sku_more");
    L15:
        int r6 = com.bytedance.android.ec.core.imagex.r.h;
        return com.bytedance.android.ec.core.imagex.r.a.c("ec_shop_home_product_card_sku");
    L7:
        r3 = -1;
        goto L8
    }
}
