package com.bytedance.android.shopping.store.hybridproduct.extension;

import com.bytedance.android.ec.hybrid.list.ECHybridListItemType;
import com.bytedance.android.ec.store.repository.vo.ShopSlcProductItemV2;
import com.bytedance.android.ec.store.repository.vo.StoreV2ProductItemVO;
import com.bytedance.android.shopping.store.home.entity.Module;
import com.bytedance.android.shopping.store.hybridproduct.dto.ECShopEndDTO;
import com.bytedance.android.shopping.store.hybridproduct.dto.ECShopFooterDTO;
import com.bytedance.android.shopping.store.repository.dto.DividingLineDTO;
import com.bytedance.android.shopping.store.router.hybridpage.vo.HybridPageGeneralCardVO;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ShopHybridDataTransformer {
    public static final Map<Integer, p> a = null;

    static {
        Integer r1 = Integer.valueOf(ECHybridListItemType.SHOP_PRODUCT_LIST_SORT_FILTER.getType());
        int r2 = p.c;
        Integer r3 = Integer.valueOf(ECHybridListItemType.SHOP_PRODUCT_LIST_PRODUCT_CARD.getType());
        StoreV2ProductItemVO.a r4 = StoreV2ProductItemVO.Q;
        Integer r5 = Integer.valueOf(ECHybridListItemType.SHOP_MEMBER_CARD.getType());
        uj3.d.a r6 = uj3.d.k;
        Integer r7 = Integer.valueOf(ECHybridListItemType.SHOP_SLICE_PRODUCT_CARD.getType());
        com.bytedance.android.ec.store.repository.vo.l.a r8 = com.bytedance.android.ec.store.repository.vo.l.V;
        Integer r9 = Integer.valueOf(ECHybridListItemType.SHOP_SLICE_PRODUCT_CARD_NEW.getType());
        ShopSlcProductItemV2.a r10 = ShopSlcProductItemV2.x;
        a = MapsKt.mapOf(new Pair[]{TuplesKt.to(r1, p.a.a(dj3.g.class, new ShopHybridDataTransformer$customSingleTransformers$1(ej3.f.g))), TuplesKt.to(r3, p.a.a(com.bytedance.android.ec.store.repository.dto.l.class, new ShopHybridDataTransformer$customSingleTransformers$2(r4))), TuplesKt.to(Integer.valueOf(ECHybridListItemType.SHOP_PRODUCT_LIST_PRODUCT_CARD_SINGLE.getType()), p.a.a(com.bytedance.android.ec.store.repository.dto.l.class, new ShopHybridDataTransformer$customSingleTransformers$3(r4))), TuplesKt.to(Integer.valueOf(ECHybridListItemType.SHOP_PRODUCT_LIST_PRODUCT_CARD_CUR_STORE_GUESS_LIKE.getType()), p.a.a(com.bytedance.android.ec.store.repository.dto.l.class, new ShopHybridDataTransformer$customSingleTransformers$4(r4))), TuplesKt.to(Integer.valueOf(ECHybridListItemType.SHOP_PRODUCT_LIST_PRODUCT_CARD_CUR_STORE_GUESS_LIKE_SINGLE.getType()), p.a.a(com.bytedance.android.ec.store.repository.dto.l.class, new ShopHybridDataTransformer$customSingleTransformers$5(r4))), TuplesKt.to(Integer.valueOf(ECHybridListItemType.SHOP_PRODUCT_LIST_PRODUCT_CARD_GUESS_LIKE.getType()), p.a.a(com.bytedance.android.ec.store.repository.dto.l.class, new ShopHybridDataTransformer$customSingleTransformers$6(r4))), TuplesKt.to(Integer.valueOf(ECHybridListItemType.SHOP_PRODUCT_LIST_PRODUCT_CARD_GUESS_LIKE_SINGLE.getType()), p.a.a(com.bytedance.android.ec.store.repository.dto.l.class, new ShopHybridDataTransformer$customSingleTransformers$7(r4))), TuplesKt.to(Integer.valueOf(ECHybridListItemType.SHOP_PRODUCT_LIST_RECOMMEND_FEED_DIVIDER.getType()), p.a.a(DividingLineDTO.class, new ShopHybridDataTransformer$customSingleTransformers$8(pj3.a.c))), TuplesKt.to(Integer.valueOf(ECHybridListItemType.SHOP_PRODUCT_LIST_PRODUCTS_FOOTER.getType()), p.a.a(ECShopFooterDTO.class, new ShopHybridDataTransformer$customSingleTransformers$9(ej3.c.b))), TuplesKt.to(Integer.valueOf(ECHybridListItemType.SHOP_PRODUCT_LIST_EMPTY.getType()), p.a.a(dj3.f.class, new ShopHybridDataTransformer$customSingleTransformers$10(ej3.e.b))), TuplesKt.to(Integer.valueOf(ECHybridListItemType.SHOP_PRODUCT_LIST_END.getType()), p.a.a(ECShopEndDTO.class, new ShopHybridDataTransformer$customSingleTransformers$11(ej3.b.a))), TuplesKt.to(Integer.valueOf(ECHybridListItemType.SHOP_PRODUCT_LIST_EMPTY_NEW.getType()), p.a.a(dj3.e.class, new ShopHybridDataTransformer$customSingleTransformers$12(ej3.d.l))), TuplesKt.to(r5, p.a.a(Module.class, new ShopHybridDataTransformer$customSingleTransformers$13(r6))), TuplesKt.to(Integer.valueOf(ECHybridListItemType.SHOP_MEMBER_CARD_SINGLE.getType()), p.a.a(Module.class, new ShopHybridDataTransformer$customSingleTransformers$14(r6))), TuplesKt.to(r7, p.a.a(com.bytedance.android.ec.store.repository.dto.l.class, new ShopHybridDataTransformer$customSingleTransformers$15(r8))), TuplesKt.to(Integer.valueOf(ECHybridListItemType.SHOP_SLICE_PRODUCT_CARD_SINGLE.getType()), p.a.a(com.bytedance.android.ec.store.repository.dto.l.class, new ShopHybridDataTransformer$customSingleTransformers$16(r8))), TuplesKt.to(r9, p.a.a(String.class, new ShopHybridDataTransformer$customSingleTransformers$17(r10))), TuplesKt.to(Integer.valueOf(ECHybridListItemType.SHOP_SLICE_PRODUCT_CARD_SINGLE_NEW.getType()), p.a.a(String.class, new ShopHybridDataTransformer$customSingleTransformers$18(r10))), TuplesKt.to(Integer.valueOf(ECHybridListItemType.SHOP_SLICE_CLOTHES_PREVIEW.getType()), p.a.a(String.class, new ShopHybridDataTransformer$customSingleTransformers$19(r10))), TuplesKt.to(Integer.valueOf(ECHybridListItemType.SHOP_SLICE_PRODUCTS_FILTER_CARD.getType()), p.a.a(String.class, new ShopHybridDataTransformer$customSingleTransformers$20(com.bytedance.android.ec.store.repository.vo.k.i))), TuplesKt.to(Integer.valueOf(ECHybridListItemType.SHOP_MIDDLE_COUPON_FILTER.getType()), p.a.a(String.class, new ShopHybridDataTransformer$customSingleTransformers$21(com.bytedance.android.ec.store.repository.vo.h.a))), TuplesKt.to(Integer.valueOf(ECHybridListItemType.SHOP_SEARCH_RESULT_GENERAL_CARD.getType()), p.a.a(String.class, new ShopHybridDataTransformer$customSingleTransformers$22(HybridPageGeneralCardVO.i)))});
    }
}
