package com.bytedance.android.shopping.store.hybridproduct;

import com.bytedance.android.ec.hybrid.list.ECHybridListItemType;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECHybridListItemDTO;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECHybridListSectionDTO;
import com.bytedance.android.ec.store.product.holder.LayoutTypes;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class l0 {
    public static final String a(Object r3, int r4) {
        JsonObject r0 = null;
        if (r3 != null) goto L5;
        return null;
    L5:
        String r5 = r3.toString();
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L14
        JsonObject r2 = (JsonObject) new Gson().fromJson(r5, JsonObject.class);     // Catch: Throwable -> L14
        if (r2 == null) goto L9;
        r2.addProperty("layout_type", Integer.valueOf(r4));     // Catch: Throwable -> L14
        r0 = r2;
    L9:
        String r6 = com.bytedance.android.ec.hybrid.list.util.k.d(r0);     // Catch: Throwable -> L14
        String r7 = r6;
        if (r6 != null) goto L12;
        r7 = r5;
    L12:
        Object r8 = Result.constructor-impl(r7);     // Catch: Throwable -> L14
    L16:
        Object r9 = r5;
        if (Result.exceptionOrNull-impl(r8) != null) goto L20;
        r9 = r8;
    L20:
        return (String) r9;
    L14:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L16
    }

    public static final void b(ECHybridListSectionDTO r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "$this$updateLynxLayout");
        ArrayList r0 = r5.getItems();
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        return;
    L11:
        if (Intrinsics.areEqual(r5.getSectionId(), "__PRODUCTS_SECTION__") == true) goto L63;
        ArrayList r7 = r5.getItems();
        if (r7 == null) goto L62;
        ArrayList r2 = new ArrayList();
        Iterator r8 = r7.iterator();
    L17:
        if (r8.hasNext() == false) goto L26;
        Object r3 = r8.next();
        Integer r4 = ((ECHybridListItemDTO) r3).getItemType();
        if (r4 != null) goto L21;
    L23:
        boolean r9 = false;
    L24:
        if (r9 == false) goto L17;
        r2.add(r3);
        goto L17
    L21:
        if (com.bytedance.android.ec.hybrid.list.d.a(r4) != true) goto L23;
        r9 = true;
        goto L24
    L26:
        Iterator r10 = r2.iterator();
    L28:
        if (r10.hasNext() == false) goto L64;
        ECHybridListItemDTO r11 = (ECHybridListItemDTO) r10.next();
        String r12 = r11.getItemData();
        String r13 = null;
        String r14 = r12;
        if (r12 != null) goto L50;
        r14 = null;
    L50:
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L41
        if (r14 == null) goto L39;
        String r16 = (JsonObject) new Gson().fromJson(r14, JsonObject.class);     // Catch: Throwable -> L41
        if (r16 == null) goto L38;
        r16.addProperty("layout_type", Integer.valueOf(r6));     // Catch: Throwable -> L41
        r13 = r16;
    L38:
        r13 = com.bytedance.android.ec.hybrid.list.util.k.d(r13);     // Catch: Throwable -> L41
    L39:
        Object r17 = Result.constructor-impl(r13);     // Catch: Throwable -> L41
    L43:
        Object r18 = r14;
        if (Result.exceptionOrNull-impl(r17) != null) goto L46;
        r18 = r17;
    L46:
        String r19 = (String) r18;
        if (r19 == null) goto L28;
        r11.setItemData(r19);
    L41:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        r17 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L43
    L64:
        return;
    L62:
        return;
    L63:
        return;
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }

    public static final void d(ECHybridListSectionDTO r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "$this$updateProductSectionLayoutType");
        if (Intrinsics.areEqual(r2.getSectionId(), "__PRODUCTS_SECTION__") == false) goto L6;
        c(r2, r3, ECHybridListItemType.SHOP_PRODUCT_LIST_PRODUCT_CARD_SINGLE.getType(), ECHybridListItemType.SHOP_PRODUCT_LIST_PRODUCT_CARD.getType());
        return;
    L6:
        if (Intrinsics.areEqual(r2.getSectionId(), "__GUESS_LIKE_PRODUCTS_CUR_STORE_SECTION__") == false) goto L9;
        c(r2, r3, ECHybridListItemType.SHOP_PRODUCT_LIST_PRODUCT_CARD_CUR_STORE_GUESS_LIKE_SINGLE.getType(), ECHybridListItemType.SHOP_PRODUCT_LIST_PRODUCT_CARD_CUR_STORE_GUESS_LIKE.getType());
        return;
    L9:
        if (Intrinsics.areEqual(r2.getSectionId(), "__GUESS_LIKE_PRODUCTS_CROSS_SHOP_SECTION__") == false) goto L14;
        c(r2, r3, ECHybridListItemType.SHOP_PRODUCT_LIST_PRODUCT_CARD_GUESS_LIKE_SINGLE.getType(), ECHybridListItemType.SHOP_PRODUCT_LIST_PRODUCT_CARD_GUESS_LIKE.getType());
        return;
    }

    public static final void c(ECHybridListSectionDTO r4, int r5, int r6, int r7) {
        ArrayList r8 = r4.getItems();
        if (r8 == null) goto L59;
        Iterator r9 = r8.iterator();
    L6:
        if (r9.hasNext() == false) goto L82;
        ECHybridListItemDTO r0 = (ECHybridListItemDTO) r9.next();
        r0.setSpanSize(Integer.valueOf(2 - r5));
        if (com.bytedance.android.ec.hybrid.list.d.a(r0.getItemType()) == true) goto L9;
        Integer r1 = r0.getItemType();
        ECHybridListItemType r2 = ECHybridListItemType.SHOP_MEMBER_CARD;
        int r3 = r2.getType();
        if (r1 != null) goto L16;
    L17:
        Integer r10 = r0.getItemType();
        int r11 = ECHybridListItemType.SHOP_MEMBER_CARD_SINGLE.getType();
        if (r10 == null) goto L23;
        if (r10.intValue() != r11) goto L23;
    L54:
        int r12 = ECHybridListItemType.SHOP_MEMBER_CARD_SINGLE.getType();
        int r13 = r2.getType();
        if (r5 == LayoutTypes.RECYCLER_VIEW_ITEM_SINGLE.getType()) goto L58;
        r12 = r13;
    L58:
        r0.setItemType(Integer.valueOf(r12));
    L23:
        Integer r14 = r0.getItemType();
        ECHybridListItemType r15 = ECHybridListItemType.SHOP_SLICE_PRODUCT_CARD;
        int r16 = r15.getType();
        if (r14 == null) goto L33;
        if (r14.intValue() != r16) goto L33;
        int r17 = ECHybridListItemType.SHOP_SLICE_PRODUCT_CARD_SINGLE.getType();
        int r18 = r15.getType();
        if (r5 == LayoutTypes.RECYCLER_VIEW_ITEM_SINGLE.getType()) goto L32;
        r17 = r18;
    L32:
        r0.setItemType(Integer.valueOf(r17));
    L33:
        Integer r19 = r0.getItemType();
        ECHybridListItemType r20 = ECHybridListItemType.SHOP_SLICE_PRODUCT_CARD_NEW;
        int r21 = r20.getType();
        if (r19 != null) goto L37;
    L38:
        Integer r22 = r0.getItemType();
        int r23 = ECHybridListItemType.SHOP_SLICE_PRODUCT_CARD_SINGLE_NEW.getType();
        if (r22 == null) goto L44;
        if (r22.intValue() != r23) goto L44;
    L49:
        int r24 = ECHybridListItemType.SHOP_SLICE_PRODUCT_CARD_SINGLE_NEW.getType();
        int r25 = r20.getType();
        if (r5 == LayoutTypes.RECYCLER_VIEW_ITEM_SINGLE.getType()) goto L53;
        r24 = r25;
    L53:
        r0.setItemType(Integer.valueOf(r24));
    L44:
        r0.setOriginItemType(r0.getItemType());
        if (r5 != LayoutTypes.RECYCLER_VIEW_ITEM_SINGLE.getType()) goto L47;
        int r26 = r6;
    L48:
        r0.setItemType(Integer.valueOf(r26));
        goto L6
    L47:
        r26 = r7;
        goto L48
    L37:
        if (r19.intValue() == r21) goto L49;
    L16:
        if (r1.intValue() == r3) goto L54;
    L9:
        String r27 = a(r0.getItemData(), r5);
        if (r27 == null) goto L6;
        r0.setItemData(r27);
        goto L6
    L82:
        return;
    }
}
