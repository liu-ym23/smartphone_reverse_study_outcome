package com.bytedance.android.shopping.store.router.hybridpage.slice;

import android.content.Context;
import com.bytedance.android.ec.store.setting.j;
import com.bytedance.android.ec.store.setting.k;
import com.bytedance.android.ecom.slice.ext.template.gecko.SlcGeckoTemplateMgr;
import com.bytedance.android.shopping.store.slicecard.dto.ShopSliceItemConfig;
import com.bytedance.android.shopping.store.slicecard.dto.SliceTemplate;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class HybridPageSlcTemplateManager {
    public static final List<k> a = null;
    public static final List<String> b = null;
    public static final List<String> c = null;
    public static final List<String> d = null;
    public static final ConcurrentHashMap<String, ShopSliceItemConfig> e = null;

    static {
        a = CollectionsKt.toMutableList(new j(CollectionsKt.listOf(new k[]{new k("shop_search_result_page", 1, "https://lf-webcast-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/10181/gecko/resource/ecom_shop_slice_template/shop_search_result_page/main.json"), new k("cate_second_page", 1, "https://lf-webcast-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/10181/gecko/resource/ecom_shop_slice_template/cate_second_page/main.json"), new k("card_pack_shop_product_col1", 4, "https://lf-webcast-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/10181/gecko/resource/ecom_shop_slice_template/shop_product_col1_v2/main.json"), new k("card_pack_shop_product_col2", 4, "https://lf-webcast-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/10181/gecko/resource/ecom_shop_slice_template/shop_product_col2_v2/main.json"), new k("shop_product_clothing", 5, "https://lf-webcast-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/10181/gecko/resource/ecom_shop_slice_template/shop_product_clothing/main.json")})).a());
        b = CollectionsKt.listOf("shop_search_result_page");
        c = CollectionsKt.listOf("cate_second_page");
        d = CollectionsKt.listOf(new String[]{"card_pack_shop_product_col1", "card_pack_shop_product_col2", "shop_product_clothing"});
        e = new ConcurrentHashMap();
    }

    public static void b(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        SlcGeckoTemplateMgr.f(SlcGeckoTemplateMgr.l, "hybrid_page", "ecom_shop_slice_template", wh.a.b(r4), HybridPageSlcTemplateManager$preloadTemplate$1.INSTANCE);
    }

    public static SliceTemplate a(String r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "itemType");
        ShopSliceItemConfig r6 = e.get(r4);
        Object r0 = null;
        if (r6 == null) goto L25;
        Iterator<T> r1 = r6.getTemplates().iterator();
    L6:
        if (r1.hasNext() == false) goto L16;
        Object r2 = r1.next();
        Integer r3 = ((SliceTemplate) r2).getSpanSize();
        if (r3 != null) goto L11;
    L13:
        boolean r7 = false;
    L14:
        if (r7 == false) goto L6;
        r0 = r2;
        goto L16
    L11:
        if (r3.intValue() != r5) goto L13;
        r7 = true;
    L16:
        SliceTemplate r8 = (SliceTemplate) r0;
        if (r8 == null) goto L19;
        return r8;
    L19:
        return (SliceTemplate) CollectionsKt.firstOrNull(r6.getTemplates());
    L25:
        return null;
    }
}
