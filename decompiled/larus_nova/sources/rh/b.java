package rh;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<Map<String, Object>> f537768a = null;

    static {
        List r100 = CollectionsKt.listOf(new Pair[]{TuplesKt.to("product_line", 3), TuplesKt.to("extend_line_normal", 3), TuplesKt.to("product_line_fold_status_desc", 3), TuplesKt.to("order_list_head_bg", 1), TuplesKt.to("people_line", 3), TuplesKt.to("price_line", 3), TuplesKt.to("guess_you_like_title", 1), TuplesKt.to("button_line", 3), TuplesKt.to("product_line_more", 3), TuplesKt.to("order_list_tabbar", 1), TuplesKt.to("often_buy_shop", 1), TuplesKt.to("order_list_node_empty", 1), TuplesKt.to("newer_coupon", 0), TuplesKt.to("default_empty", 1), TuplesKt.to("shop_line", 3), TuplesKt.to("order_list_head_search", 1)});
        ArrayList r101 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r100, 10));
        Iterator r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        Pair r103 = (Pair) r102.next();
        r101.add(MapsKt.mapOf(new Pair[]{TuplesKt.to("name", r103.getFirst()), TuplesKt.to("url", "https://lf-webcast-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/10181/gecko/resource/ecommerce_order_list_component/" + ((String) r103.getFirst()) + "/main.json"), TuplesKt.to("num", r103.getSecond())}));
        goto L4
    L6:
        f537768a = r101;
    }
}
