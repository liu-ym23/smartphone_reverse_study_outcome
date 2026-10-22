package com.bytedance.android.shopping.store.slicecard;

import com.bytedance.android.ec.store.setting.k;
import com.bytedance.android.shopping.store.settings.ECShopABSettings;
import com.bytedance.android.shopping.store.slicecard.dto.ShopSliceItemConfig;
import com.bytedance.android.shopping.store.slicecard.dto.SliceTemplate;
import com.bytedance.android.shopping.store.slicecard.dto.SliceTemplateType;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ShopSlcTemplateManager {
    public static final com.bytedance.android.ec.store.setting.j a = null;
    public static final List<String> b = null;
    public static final List<String> c = null;
    public static final List<String> d = null;
    public static final List<String> e = null;
    public static final List<String> f = null;
    public static final List<String> g = null;
    public static final Lazy h = null;
    public static final ConcurrentHashMap<String, ShopSliceItemConfig> i = null;

    static {
        a = new com.bytedance.android.ec.store.setting.j(CollectionsKt.listOf(new k[]{new k("shop_product_col2", 4, "https://lf-webcast-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/10181/gecko/resource/ecom_shop_slice_template/shop_product_col2/main.json"), new k("shop_product_col1", 4, "https://lf-webcast-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/10181/gecko/resource/ecom_shop_slice_template/shop_product_col1/main.json"), new k("shop_profile_ordinary", 1, "https://lf-webcast-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/10181/gecko/resource/ecom_shop_slice_template/shop_profile_ordinary/main.json"), new k("shop_profile_flagship", 1, "https://lf-webcast-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/10181/gecko/resource/ecom_shop_slice_template/shop_profile_flagship/main.json"), new k("shop_profile_brand", 1, "https://lf-webcast-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/10181/gecko/resource/ecom_shop_slice_template/shop_profile_brand/main.json"), new k("shop_profile_abnormal", 1, "https://lf-webcast-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/10181/gecko/resource/ecom_shop_slice_template/shop_profile_abnormal/main.json"), new k("shop_profile_brand_concise", 1, "https://lf-webcast-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/10181/gecko/resource/ecom_shop_slice_template/shop_profile_brand_concise/main.json"), new k("card_pack_shop_product_col1", 4, "https://lf-webcast-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/10181/gecko/resource/ecom_shop_slice_template/shop_product_col1_v2/main.json"), new k("card_pack_shop_product_col2", 4, "https://lf-webcast-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/10181/gecko/resource/ecom_shop_slice_template/shop_product_col2_v2/main.json"), new k("shop_product_clothing", 5, "https://lf-webcast-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/10181/gecko/resource/ecom_shop_slice_template/shop_product_clothing/main.json"), new k("shop_product_filter", 1, "https://lf-webcast-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/10181/gecko/resource/ecom_shop_slice_template/shop_product_filter/main.json")}));
        b = CollectionsKt.listOf(new String[]{"shop_product_col1", "shop_product_col2"});
        c = CollectionsKt.listOf(new String[]{"card_pack_shop_product_col1", "card_pack_shop_product_col2", "shop_product_clothing"});
        d = CollectionsKt.listOf("shop_product_filter");
        e = CollectionsKt.listOf(new String[]{"shop_profile_flagship", "shop_profile_ordinary", "shop_profile_brand", "shop_profile_abnormal"});
        f = CollectionsKt.listOf("shop_top_bar");
        g = CollectionsKt.listOf("shop_profile_brand_concise");
        h = LazyKt.lazy(ShopSlcTemplateManager$templateSetting$2.INSTANCE);
        i = new ConcurrentHashMap();
    }

    public static SliceTemplate a(SliceItemType r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "itemType");
        Object r2 = null;
        Integer r3 = null;
        if (ECShopABSettings.getEC_SHOP_CARD_PACK_FORCE_LOCAL() != 1) goto L45;
        ShopSliceItemConfig r7 = i.get(r5.getType());
        if (r7 == null) goto L20;
        Iterator<T> r8 = r7.getTemplates().iterator();
    L8:
        if (r8.hasNext() == false) goto L18;
        Object r0 = r8.next();
        Integer r4 = ((SliceTemplate) r0).getSpanSize();
        if (r4 != null) goto L13;
    L15:
        boolean r9 = false;
    L16:
        if (r9 == false) goto L8;
    L19:
        SliceTemplate r1 = (SliceTemplate) r0;
    L21:
        SliceTemplate r10 = new SliceTemplate();
        if (r1 == null) goto L24;
        String r11 = r1.getName();
    L25:
        r10.setName(r11);
        if (r1 == null) goto L28;
        String r12 = r1.getUrl();
    L29:
        r10.setUrl(r12);
        if (r1 == null) goto L32;
        String r13 = r1.getVersion();
    L33:
        r10.setVersion(r13);
        if (r1 == null) goto L36;
        int r14 = r1.getType();
    L37:
        r10.setType(r14);
        if (r1 == null) goto L40;
        r3 = r1.getSpanSize();
    L40:
        r10.setSpanSize(r3);
        if (r1 == null) goto L43;
        double r15 = r1.getPredictHeight();
    L44:
        r10.setPredictHeight(r15);
        return r10;
    L43:
        r15 = 0.0d;
        goto L44
    L36:
        r14 = SliceTemplateType.GECKO.getType();
        goto L37
    L32:
        r13 = null;
        goto L33
    L28:
        r12 = null;
        goto L29
    L24:
        r11 = null;
        goto L25
    L13:
        if (r4.intValue() != r6) goto L15;
        r9 = true;
        goto L16
    L18:
        r0 = null;
        goto L19
    L20:
        r1 = null;
        goto L21
    L45:
        ShopSliceItemConfig r16 = i.get(r5.getType());
        if (r16 == null) goto L72;
        Iterator<T> r17 = r16.getTemplates().iterator();
    L49:
        if (r17.hasNext() == false) goto L60;
        Object r18 = r17.next();
        Integer r19 = ((SliceTemplate) r18).getSpanSize();
        if (r19 != null) goto L54;
    L56:
        boolean r20 = false;
    L57:
        if (r20 == false) goto L49;
        r2 = r18;
        goto L60
    L54:
        if (r19.intValue() != r6) goto L56;
        r20 = true;
    L60:
        return (SliceTemplate) r2;
    L72:
        return null;
    }
}
