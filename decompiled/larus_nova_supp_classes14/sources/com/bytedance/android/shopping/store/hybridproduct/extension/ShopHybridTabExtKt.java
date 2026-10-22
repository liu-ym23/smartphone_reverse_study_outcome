package com.bytedance.android.shopping.store.hybridproduct.extension;

import com.bytedance.android.ec.core.imagex.ImageExtensionsKt;
import com.bytedance.android.ec.core.imagex.r;
import com.bytedance.android.ec.core.utils.t0;
import com.bytedance.android.ec.hybrid.list.ECHybridListItemType;
import com.bytedance.android.ec.hybrid.list.entity.ECHybridListItemVO;
import com.bytedance.android.ec.hybrid.list.entity.ECSectionOperationType;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECHybridListItemDTO;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECNAMallCardExtra;
import com.bytedance.android.ec.store.common.uiext.ExtensionsKt;
import com.bytedance.android.ec.store.product.holder.LayoutTypes;
import com.bytedance.android.ec.store.repository.vo.ShopSlcProductItemV2;
import com.bytedance.android.ec.store.repository.vo.StoreV2ProductItemVO;
import com.bytedance.android.shopping.store.hybridproduct.ECShopHybridProductListPresenter;
import com.bytedance.android.shopping.store.hybridproduct.l0;
import com.facebook.imagepipeline.request.ImageRequest;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ShopHybridTabExtKt {
    public static final void b(final ECShopHybridProductListPresenter r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$addSortAndFilterEventObserver");
        com.bytedance.android.ec.core.arch.event.c.a(r4.N, Reflection.getOrCreateKotlinClass(kj3.b.class), Dispatchers.getMain(), new ShopHybridTabExtKt$addSortAndFilterEventObserver$1(r4));
        com.bytedance.android.ec.core.arch.event.c.a(r4.N, Reflection.getOrCreateKotlinClass(kj3.c.class), Dispatchers.getMain(), new ShopHybridTabExtKt$addSortAndFilterEventObserver$2(r4));
    }

    public static final boolean e(ECHybridListItemDTO r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$isProductItem");
        Integer r0 = r2.getItemType();
        int r1 = ECHybridListItemType.SHOP_PRODUCT_LIST_PRODUCT_CARD.getType();
        if (r0 != null) goto L6;
    L7:
        Integer r3 = r2.getItemType();
        int r4 = ECHybridListItemType.SHOP_PRODUCT_LIST_PRODUCT_CARD_SINGLE.getType();
        if (r3 != null) goto L11;
    L12:
        Integer r5 = r2.getItemType();
        int r6 = ECHybridListItemType.SHOP_SLICE_PRODUCT_CARD.getType();
        if (r5 != null) goto L16;
    L17:
        Integer r7 = r2.getItemType();
        int r8 = ECHybridListItemType.SHOP_SLICE_PRODUCT_CARD_SINGLE.getType();
        if (r7 != null) goto L21;
    L22:
        Integer r9 = r2.getItemType();
        int r10 = ECHybridListItemType.SHOP_SLICE_PRODUCT_CARD_NEW.getType();
        if (r9 != null) goto L26;
    L27:
        Integer r11 = r2.getItemType();
        int r12 = ECHybridListItemType.SHOP_SLICE_PRODUCT_CARD_SINGLE_NEW.getType();
        if (r11 != null) goto L31;
    L33:
        return false;
    L31:
        if (r11.intValue() != r12) goto L33;
    L34:
        return true;
    L26:
        if (r9.intValue() == r10) goto L34;
    L21:
        if (r7.intValue() == r8) goto L34;
    L16:
        if (r5.intValue() == r6) goto L34;
    L11:
        if (r3.intValue() == r4) goto L34;
    L6:
        if (r0.intValue() == r1) goto L34;
        goto L7
    }

    public static final boolean a(com.bytedance.android.ec.hybrid.list.entity.i r5, LayoutTypes r6) {
        String r0 = r5.a;
        if (r0 == null) goto L26;
        int r2 = r0.hashCode();
        if (r2 == (-162466282)) goto L19;
        if (r2 == 952823597) goto L16;
        if (r2 == 1641520170) goto L13;
        return false;
    L13:
        if (r0.equals("__PRODUCTS_SECTION__") == false) goto L23;
        h(r5, r6, ECHybridListItemType.SHOP_PRODUCT_LIST_PRODUCT_CARD_SINGLE.getType(), ECHybridListItemType.SHOP_PRODUCT_LIST_PRODUCT_CARD.getType(), true);
    L21:
        return true;
    L23:
        return false;
    L16:
        if (r0.equals("__GUESS_LIKE_PRODUCTS_CUR_STORE_SECTION__") == false) goto L24;
        h(r5, r6, ECHybridListItemType.SHOP_PRODUCT_LIST_PRODUCT_CARD_CUR_STORE_GUESS_LIKE_SINGLE.getType(), ECHybridListItemType.SHOP_PRODUCT_LIST_PRODUCT_CARD_CUR_STORE_GUESS_LIKE.getType(), false);
        goto L21
    L24:
        return false;
    L19:
        if (r0.equals("__GUESS_LIKE_PRODUCTS_CROSS_SHOP_SECTION__") == false) goto L25;
        h(r5, r6, ECHybridListItemType.SHOP_PRODUCT_LIST_PRODUCT_CARD_GUESS_LIKE_SINGLE.getType(), ECHybridListItemType.SHOP_PRODUCT_LIST_PRODUCT_CARD_GUESS_LIKE.getType(), true);
        goto L21
    L25:
        return false;
    L26:
        return false;
    }

    public static final void c(ECHybridListItemVO r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r6, "$this$handleImageRequest");
        if (r7 == false) goto L5;
        String r8 = "ec_shop_home_product_card_more";
    L6:
        r r0 = new r("ec_shop", r8);
        Object r9 = r6.d();
        Object r2 = null;
        if ((r9 instanceof StoreV2ProductItemVO) == true) goto L9;
        r9 = null;
    L9:
        StoreV2ProductItemVO r10 = (StoreV2ProductItemVO) r9;
        if (r10 == null) goto L12;
        r10.g = ImageExtensionsKt.C(r10.f, r0, Integer.valueOf(ExtensionsKt.a(150)), Integer.valueOf(ExtensionsKt.a(150)));
    L12:
        Object r11 = r6.d();
        if ((r11 instanceof com.bytedance.android.ec.store.repository.vo.l) == true) goto L15;
        r11 = null;
    L15:
        com.bytedance.android.ec.store.repository.vo.l r12 = (com.bytedance.android.ec.store.repository.vo.l) r11;
        if (r12 == null) goto L31;
        String r3 = (String) CollectionsKt.firstOrNull(((StoreV2ProductItemVO) r12).f);
        if (r3 == null) goto L31;
        Pair r4 = ((StoreV2ProductItemVO) r12).g;
        if (r4 == null) goto L24;
        ImageRequest[] r5 = (ImageRequest[]) r4.getSecond();
        if (r5 == null) goto L24;
        ImageRequest r13 = (ImageRequest) ArraysKt.firstOrNull(r5);
    L25:
        if (r13 == null) goto L31;
        com.bytedance.android.shopping.store.slicecard.c r14 = com.bytedance.android.shopping.store.slicecard.c.b;
        Pair r15 = ((StoreV2ProductItemVO) r12).g;
        if (r15 == null) goto L29;
        ImageRequest[] r16 = (ImageRequest[]) r15.getSecond();
    L30:
        r14.update(r3, r16);
        goto L31
    L29:
        r16 = null;
    L24:
        r13 = null;
    L31:
        Object r17 = r6.d();
        if ((r17 instanceof ShopSlcProductItemV2) == true) goto L34;
        r17 = null;
    L34:
        ShopSlcProductItemV2 r18 = (ShopSlcProductItemV2) r17;
        if (r18 == null) goto L52;
        r18.u = ImageExtensionsKt.C(r18.o, r0, Integer.valueOf(ExtensionsKt.a(150)), Integer.valueOf(ExtensionsKt.a(150)));
        List r19 = r18.o;
        if (r19 == null) goto L52;
        String r20 = (String) CollectionsKt.firstOrNull(r19);
        if (r20 == null) goto L52;
        Pair r21 = r18.u;
        if (r21 == null) goto L45;
        ImageRequest[] r22 = (ImageRequest[]) r21.getSecond();
        if (r22 == null) goto L45;
        ImageRequest r23 = (ImageRequest) ArraysKt.firstOrNull(r22);
    L46:
        if (r23 == null) goto L52;
        com.bytedance.android.shopping.store.slicecard.c r24 = com.bytedance.android.shopping.store.slicecard.c.b;
        Pair r25 = r18.u;
        if (r25 == null) goto L50;
        ImageRequest[] r26 = (ImageRequest[]) r25.getSecond();
    L51:
        r24.update(r20, r26);
        goto L52
    L50:
        r26 = null;
    L45:
        r23 = null;
    L52:
        Object r27 = r6.d();
        if ((r27 instanceof com.bytedance.android.ec.store.repository.vo.j) == false) goto L56;
        r2 = r27;
    L56:
        com.bytedance.android.ec.store.repository.vo.j r28 = (com.bytedance.android.ec.store.repository.vo.j) r2;
        if (r28 == null) goto L60;
        ImageExtensionsKt.C(r28.i, r0, Integer.valueOf(ExtensionsKt.a(150)), Integer.valueOf(ExtensionsKt.a(150)));
        return;
    L60:
        return;
    L5:
        r8 = "ec_shop_home_product_card_first";
        goto L6
    }

    public static final void d(ECHybridListItemVO r3, com.bytedance.android.ec.hybrid.list.entity.i r4) {
        Intrinsics.checkNotNullParameter(r3, "$this$handleSliceCardData");
        Intrinsics.checkNotNullParameter(r4, "sectionVO");
        dm.a.a("测试轻览").a("handleSliceCardData:" + r3.c);
        Object r0 = r3.d();
        Object r2 = null;
        if ((r0 instanceof com.bytedance.android.ec.store.repository.vo.l) == true) goto L5;
        r0 = null;
    L5:
        com.bytedance.android.ec.store.repository.vo.l r1 = (com.bytedance.android.ec.store.repository.vo.l) r0;
        if (r1 == null) goto L26;
        Intrinsics.checkNotNullParameter(r3, "vo");
        ECNAMallCardExtra r5 = r3.c();
        if (r5 == null) goto L10;
        String r6 = r5.getSliceActions();
    L11:
        r1.S = com.bytedance.android.shopping.store.slicecard.i.a(r6);
        ECNAMallCardExtra r7 = r3.c();
        if (r7 == null) goto L14;
        String r8 = r7.getSliceItemStates();
    L15:
        r1.U = com.bytedance.android.shopping.store.slicecard.i.c(r8);
        ECNAMallCardExtra r9 = r3.c();
        if (r9 == null) goto L18;
        String r10 = r9.getSliceItemExtra();
    L19:
        r1.T = com.bytedance.android.shopping.store.slicecard.i.b(r10);
        ECNAMallCardExtra r11 = r3.c();
        if (r11 == null) goto L22;
        String r12 = r11.getSliceItemStates();
    L23:
        r1.U = com.bytedance.android.shopping.store.slicecard.i.c(r12);
        ECNAMallCardExtra r13 = r3.c();
        if (r13 == null) goto L26;
        r13.getSliceItemType();
        goto L26
    L22:
        r12 = null;
        goto L23
    L18:
        r10 = null;
        goto L19
    L14:
        r8 = null;
        goto L15
    L10:
        r6 = null;
    L26:
        Object r14 = r3.d();
        if ((r14 instanceof ShopSlcProductItemV2) == true) goto L29;
        r14 = null;
    L29:
        ShopSlcProductItemV2 r15 = (ShopSlcProductItemV2) r14;
        if (r15 == null) goto L32;
        r15.b(r3);
        r15.g = r4.a;
    L32:
        Object r16 = r3.d();
        if ((r16 instanceof com.bytedance.android.ec.store.repository.vo.k) == false) goto L36;
        r2 = r16;
    L36:
        com.bytedance.android.ec.store.repository.vo.k r17 = (com.bytedance.android.ec.store.repository.vo.k) r2;
        if (r17 == null) goto L40;
        r17.b(r3);
        return;
    }

    public static final void g(ECShopHybridProductListPresenter r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "$this$updateIfShowGoTop");
        if (r3 < r2.p) goto L5;
        boolean r4 = true;
    L7:
        if (Intrinsics.areEqual(Boolean.valueOf(r4), (Boolean) r2.N.getScrollPositionFarEnough().getValue()) == false) goto L9;
        return;
    L9:
        r2.N.getScrollPositionFarEnough().setValue(Boolean.valueOf(r4));
        return;
    L5:
        r4 = false;
        goto L7
    }

    public static final void f(final ECShopHybridProductListPresenter r13, final com.bytedance.android.ec.hybrid.list.entity.k r14, final boolean r15) {
        Intrinsics.checkNotNullParameter(r13, "$this$processECHybridListVO");
        Intrinsics.checkNotNullParameter(r14, "originVO");
        dm.a.a("测试轻览").a("processECHybridListVO");
        ArrayList r0 = r14.c;
        if (r0 == null) goto L24;
        Iterator r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L32;
        final com.bytedance.android.ec.hybrid.list.entity.i r2 = (com.bytedance.android.ec.hybrid.list.entity.i) r1.next();
        r13.getClass();
        if (Intrinsics.areEqual(r2.a, "__CLOTHES_PREVIEW_SECTION__") == false) goto L6;
        int r3 = 3;
        int r4 = t0.a;     // Catch: Exception -> L18
        Gson r5 = t0.a.a;     // Catch: Exception -> L18
        Map r6 = r14.d;     // Catch: Exception -> L18
        if (r6 == null) goto L13;
        String r7 = (String) r6.get("clothes_preview_config");     // Catch: Exception -> L18
    L14:
        Integer r8 = ((dj3.d) r5.fromJson(r7, dj3.d.class)).a();     // Catch: Exception -> L18
        if (r8 == null) goto L17;
        r3 = r8.intValue();     // Catch: Exception -> L18
    L17:
        int r9 = r3;
    L20:
        final ArrayList r10 = new ArrayList();
        ArrayList r11 = r2.i;
        if (r11 == null) goto L23;
        final int r12 = r9;
        CollectionsKt.chunked(r11, r9, new ShopHybridTabExtKt$processECHybridListVO$$inlined$forEach$lambda$1(r12, r10, r2, r13, r14, r15));
    L23:
        r2.i = r10;
        goto L6
    L13:
        r7 = null;
    L18:
        e = move-exception;
        dm.a.a("ECShopHybridProductListPresenter").b(e.toString(), null);
        r9 = 3;
        goto L20
    L32:
        return;
    }

    public static final void h(com.bytedance.android.ec.hybrid.list.entity.i r4, LayoutTypes r5, int r6, int r7, boolean r8) {
        r4.c(ECSectionOperationType.INSERT_SECTION);
        ArrayList r9 = r4.i;
        if (r9 == null) goto L65;
        Iterator r10 = r9.iterator();
    L6:
        if (r10.hasNext() == false) goto L89;
        ECHybridListItemVO r0 = (ECHybridListItemVO) r10.next();
        r0.a = Integer.valueOf(2 - r5.getType());
        Integer r1 = r0.c;
        if (r1 == null) goto L12;
        if (com.bytedance.android.ec.hybrid.list.d.a(r1) != true) goto L12;
        r0.o(l0.a(r0.d(), r5.getType()));
    L12:
        Integer r2 = r0.c;
        ECHybridListItemType r3 = ECHybridListItemType.SHOP_MEMBER_CARD;
        int r11 = r3.getType();
        if (r2 != null) goto L16;
    L17:
        Integer r12 = r0.c;
        int r13 = ECHybridListItemType.SHOP_MEMBER_CARD_SINGLE.getType();
        if (r12 == null) goto L23;
        if (r12.intValue() != r13) goto L23;
    L60:
        int r14 = ECHybridListItemType.SHOP_MEMBER_CARD_SINGLE.getType();
        int r15 = r3.getType();
        if (r5 == LayoutTypes.RECYCLER_VIEW_ITEM_SINGLE) goto L64;
        r14 = r15;
    L64:
        r0.c = Integer.valueOf(r14);
    L23:
        if (r8 == false) goto L39;
        Integer r16 = r0.c;
        ECHybridListItemType r17 = ECHybridListItemType.SHOP_SLICE_PRODUCT_CARD;
        int r18 = r17.getType();
        if (r16 != null) goto L28;
    L29:
        Integer r19 = r0.c;
        int r20 = ECHybridListItemType.SHOP_SLICE_PRODUCT_CARD_SINGLE.getType();
        if (r19 == null) goto L39;
        if (r19.intValue() != r20) goto L39;
    L34:
        int r21 = ECHybridListItemType.SHOP_SLICE_PRODUCT_CARD_SINGLE.getType();
        int r22 = r17.getType();
        if (r5 == LayoutTypes.RECYCLER_VIEW_ITEM_SINGLE) goto L38;
        r21 = r22;
    L38:
        r0.c = Integer.valueOf(r21);
        goto L6
    L28:
        if (r16.intValue() == r18) goto L34;
    L39:
        Integer r23 = r0.c;
        ECHybridListItemType r24 = ECHybridListItemType.SHOP_SLICE_PRODUCT_CARD_NEW;
        int r25 = r24.getType();
        if (r23 != null) goto L43;
    L44:
        Integer r26 = r0.c;
        int r27 = ECHybridListItemType.SHOP_SLICE_PRODUCT_CARD_SINGLE_NEW.getType();
        if (r26 == null) goto L51;
        if (r26.intValue() != r27) goto L51;
    L55:
        int r28 = ECHybridListItemType.SHOP_SLICE_PRODUCT_CARD_SINGLE_NEW.getType();
        int r29 = r24.getType();
        if (r5 == LayoutTypes.RECYCLER_VIEW_ITEM_SINGLE) goto L59;
        r28 = r29;
    L59:
        r0.c = Integer.valueOf(r28);
    L51:
        if (r5 != LayoutTypes.RECYCLER_VIEW_ITEM_SINGLE) goto L53;
        int r30 = r6;
    L54:
        r0.c = Integer.valueOf(r30);
        goto L6
    L53:
        r30 = r7;
        goto L54
    L43:
        if (r23.intValue() == r25) goto L55;
    L16:
        if (r2.intValue() == r11) goto L60;
    L89:
        return;
    }
}
