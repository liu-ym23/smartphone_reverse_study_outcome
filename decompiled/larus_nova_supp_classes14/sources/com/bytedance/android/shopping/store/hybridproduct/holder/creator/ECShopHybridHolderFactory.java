package com.bytedance.android.shopping.store.hybridproduct.holder.creator;

import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.hybrid.list.ECHybridListItemType;
import com.bytedance.android.shopping.store.hybridproduct.ECShopHybridProductViewModel;
import com.bytedance.android.shopping.store.hybridproduct.holder.ECShopBaseHolder;
import com.bytedance.android.shopping.store.hybridproduct.holder.ECShopEmptyHolder;
import com.bytedance.android.shopping.store.hybridproduct.holder.ECShopEmptyHolderNew;
import com.bytedance.android.shopping.store.hybridproduct.holder.ECShopEndHolder;
import com.bytedance.android.shopping.store.hybridproduct.holder.ECShopFooterHolder;
import com.bytedance.android.shopping.store.hybridproduct.holder.ECShopGuessLikeCardHolderNew;
import com.bytedance.android.shopping.store.hybridproduct.holder.ECShopMemberCardHolder;
import com.bytedance.android.shopping.store.hybridproduct.holder.ECShopMiddleCouponFilterHolder;
import com.bytedance.android.shopping.store.hybridproduct.holder.ECShopProductCardHolderNew;
import com.bytedance.android.shopping.store.hybridproduct.holder.ECShopRecommendDividerViewHolder;
import com.bytedance.android.shopping.store.hybridproduct.holder.ECShopSlcCommonCardHolder;
import com.bytedance.android.shopping.store.hybridproduct.holder.ECShopSlcProductCardHolder;
import com.bytedance.android.shopping.store.hybridproduct.holder.ECShopSlcProductCardHolderV2;
import com.bytedance.android.shopping.store.hybridproduct.holder.ECShopSliceSortBarAndFilterHolder;
import com.bytedance.android.shopping.store.hybridproduct.holder.ECShopSortBarAndFilterHolder;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import java.util.Map;
import km.b;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECShopHybridHolderFactory extends a {
    public static final Map<Integer, Function5<Fragment, ViewGroup, b, ECShopHybridProductViewModel, ECStoreViewModel, ECShopBaseHolder>> a = null;

    static {
        Integer r1 = Integer.valueOf(ECHybridListItemType.SHOP_PRODUCT_LIST_PRODUCT_CARD.getType());
        ECShopProductCardHolderNew.a r3 = ECShopProductCardHolderNew.u;
        Integer r2 = Integer.valueOf(ECHybridListItemType.SHOP_PRODUCT_LIST_PRODUCT_CARD_CUR_STORE_GUESS_LIKE.getType());
        ECShopGuessLikeCardHolderNew.a r4 = ECShopGuessLikeCardHolderNew.r;
        Integer r5 = Integer.valueOf(ECHybridListItemType.SHOP_MEMBER_CARD.getType());
        ECShopMemberCardHolder.a r6 = ECShopMemberCardHolder.r;
        Integer r7 = Integer.valueOf(ECHybridListItemType.SHOP_SLICE_PRODUCT_CARD.getType());
        ECShopSlcProductCardHolder.a r8 = ECShopSlcProductCardHolder.r;
        Integer r9 = Integer.valueOf(ECHybridListItemType.SHOP_SLICE_PRODUCT_CARD_NEW.getType());
        ECShopSlcProductCardHolderV2.a r10 = ECShopSlcProductCardHolderV2.r;
        a = MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(ECHybridListItemType.SHOP_PRODUCT_LIST_SORT_FILTER.getType()), new ECShopHybridHolderFactory$windowHolderCreators$1(ECShopSortBarAndFilterHolder.s)), TuplesKt.to(Integer.valueOf(ECHybridListItemType.SHOP_SLICE_PRODUCTS_FILTER_CARD.getType()), new ECShopHybridHolderFactory$windowHolderCreators$2(ECShopSliceSortBarAndFilterHolder.r)), TuplesKt.to(r1, new ECShopHybridHolderFactory$windowHolderCreators$3(r3)), TuplesKt.to(Integer.valueOf(ECHybridListItemType.SHOP_PRODUCT_LIST_PRODUCT_CARD_SINGLE.getType()), new ECShopHybridHolderFactory$windowHolderCreators$4(r3)), TuplesKt.to(r2, new ECShopHybridHolderFactory$windowHolderCreators$5(r4)), TuplesKt.to(Integer.valueOf(ECHybridListItemType.SHOP_PRODUCT_LIST_PRODUCT_CARD_CUR_STORE_GUESS_LIKE_SINGLE.getType()), new ECShopHybridHolderFactory$windowHolderCreators$6(r4)), TuplesKt.to(Integer.valueOf(ECHybridListItemType.SHOP_PRODUCT_LIST_PRODUCT_CARD_GUESS_LIKE.getType()), new ECShopHybridHolderFactory$windowHolderCreators$7(r4)), TuplesKt.to(Integer.valueOf(ECHybridListItemType.SHOP_PRODUCT_LIST_PRODUCT_CARD_GUESS_LIKE_SINGLE.getType()), new ECShopHybridHolderFactory$windowHolderCreators$8(r4)), TuplesKt.to(Integer.valueOf(ECHybridListItemType.SHOP_PRODUCT_LIST_RECOMMEND_FEED_DIVIDER.getType()), new ECShopHybridHolderFactory$windowHolderCreators$9(ECShopRecommendDividerViewHolder.r)), TuplesKt.to(Integer.valueOf(ECHybridListItemType.SHOP_PRODUCT_LIST_PRODUCTS_FOOTER.getType()), new ECShopHybridHolderFactory$windowHolderCreators$10(ECShopFooterHolder.r)), TuplesKt.to(Integer.valueOf(ECHybridListItemType.SHOP_PRODUCT_LIST_EMPTY.getType()), new ECShopHybridHolderFactory$windowHolderCreators$11(ECShopEmptyHolder.q)), TuplesKt.to(Integer.valueOf(ECHybridListItemType.SHOP_PRODUCT_LIST_END.getType()), new ECShopHybridHolderFactory$windowHolderCreators$12(ECShopEndHolder.q)), TuplesKt.to(Integer.valueOf(ECHybridListItemType.SHOP_PRODUCT_LIST_EMPTY_NEW.getType()), new ECShopHybridHolderFactory$windowHolderCreators$13(ECShopEmptyHolderNew.r)), TuplesKt.to(r5, new ECShopHybridHolderFactory$windowHolderCreators$14(r6)), TuplesKt.to(Integer.valueOf(ECHybridListItemType.SHOP_MEMBER_CARD_SINGLE.getType()), new ECShopHybridHolderFactory$windowHolderCreators$15(r6)), TuplesKt.to(r7, new ECShopHybridHolderFactory$windowHolderCreators$16(r8)), TuplesKt.to(Integer.valueOf(ECHybridListItemType.SHOP_SLICE_PRODUCT_CARD_SINGLE.getType()), new ECShopHybridHolderFactory$windowHolderCreators$17(r8)), TuplesKt.to(r9, new ECShopHybridHolderFactory$windowHolderCreators$18(r10)), TuplesKt.to(Integer.valueOf(ECHybridListItemType.SHOP_SLICE_PRODUCT_CARD_SINGLE_NEW.getType()), new ECShopHybridHolderFactory$windowHolderCreators$19(r10)), TuplesKt.to(Integer.valueOf(ECHybridListItemType.SHOP_SLICE_CLOTHES_PREVIEW.getType()), new ECShopHybridHolderFactory$windowHolderCreators$20(ECShopSlcCommonCardHolder.w)), TuplesKt.to(Integer.valueOf(ECHybridListItemType.SHOP_MIDDLE_COUPON_FILTER.getType()), new ECShopHybridHolderFactory$windowHolderCreators$21(ECShopMiddleCouponFilterHolder.r))});
    }
}
