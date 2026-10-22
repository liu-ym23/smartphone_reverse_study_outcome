package qg;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<Map<String, Object>> f532859a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, Integer> f532860b = null;

    static {
        int r110 = 3;
        List r100 = CollectionsKt.listOf(new Pair[]{TuplesKt.to("collection_card", 6), TuplesKt.to("collection_footer", 1), TuplesKt.to("collection_header", 1), TuplesKt.to("collection_sort_panel", 1), TuplesKt.to("collection_empty", 0), TuplesKt.to("collection_max_notice", 0)});
        ArrayList r111 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r100, 10));
        Iterator r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        Pair r112 = (Pair) r101.next();
        Pair[] r113 = new Pair[r110];
        r113[0] = TuplesKt.to("name", r112.getFirst());
        r113[1] = TuplesKt.to("url", "https://lf-webcast-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/10181/gecko/resource/ecom_collect_card_template/" + ((String) r112.getFirst()) + "/main.json");
        r113[2] = TuplesKt.to("num", r112.getSecond());
        r111.add(MapsKt.mapOf(r113));
        r110 = 3;
        goto L4
    L6:
        f532859a = r111;
        LinkedHashMap r102 = new LinkedHashMap();
        r102.put("collection_card", 6);
        r102.put("collection_footer", 1);
        r102.put("collection_header", 1);
        r102.put("collection_sort_panel", 1);
        r102.put("collection_empty", 0);
        r102.put("collection_max_notice", 0);
        f532860b = MapsKt.toMap(r102);
    }
}
