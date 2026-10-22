package com.bytedance.android.shopping.card_list.monitor.cache;

import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class CacheMonitor {
    public static final Map<String, CacheMonitor> d = null;
    public final gb3.a a;
    public final Lazy b;
    public final JSONObject c;

    public static final class a {
    }

    static {
        d = new LinkedHashMap();
    }

    public CacheMonitor(JSONObject r4) {
        this.c = r4;
        this.a = new gb3.a(r4.optString(PdpOpenThirdParam.KEY_PAGE_NAME), r4.optString("page_type"));
        this.b = LazyKt.lazy(new CacheMonitor$baseParamMap$2(this));
    }

    public static void b(CacheMonitor r6, String r7, String r8) {
        Map<? extends String, ? extends Object> r0 = MapsKt.emptyMap();
        Intrinsics.checkNotNullParameter(r7, "result");
        Intrinsics.checkNotNullParameter(r8, "newSourceType");
        Intrinsics.checkNotNullParameter(r0, "extra");
        gb3.a r2 = r6.a;
        Map<String, ? extends Object> r9 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("operate_type", "write"), TuplesKt.to("result", r7), TuplesKt.to("new_source_type", r8)});
        r9.putAll(r0);
        r9.putAll((Map) r6.b.getValue());
        Unit r10 = Unit.INSTANCE;
        r2.a("card_list_cache_operate", r9, null, null);
    }

    public static void a(CacheMonitor r6, String r7, String r8, String r9) {
        Map<? extends String, ? extends Object> r0 = MapsKt.emptyMap();
        r6.getClass();
        Intrinsics.checkNotNullParameter(r7, "result");
        Intrinsics.checkNotNullParameter(r8, "renderNewSourceType");
        Intrinsics.checkNotNullParameter(r9, "cachedNewSourceType");
        Intrinsics.checkNotNullParameter(r0, "extra");
        gb3.a r2 = r6.a;
        Map<String, ? extends Object> r10 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("operate_type", "read"), TuplesKt.to("result", r7), TuplesKt.to("reader_new_source_type", r8), TuplesKt.to("cached_new_source_type", r9)});
        r10.putAll(r0);
        r10.putAll((Map) r6.b.getValue());
        Unit r11 = Unit.INSTANCE;
        r2.a("card_list_cache_operate", r10, null, null);
    }
}
