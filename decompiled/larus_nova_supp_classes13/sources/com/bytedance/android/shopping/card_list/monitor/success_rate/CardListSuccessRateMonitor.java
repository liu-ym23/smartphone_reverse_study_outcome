package com.bytedance.android.shopping.card_list.monitor.success_rate;

import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class CardListSuccessRateMonitor {
    public static final Map<String, CardListSuccessRateMonitor> g = null;
    public boolean a;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;
    public final JSONObject f;

    public static final class a {
    }

    public final Map<String, String> a() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("EVENT_PAGE_TECHNOLOGY", "YATA_Android"), TuplesKt.to(PdpOpenThirdParam.KEY_PAGE_NAME, (String) this.b.getValue()), TuplesKt.to("previous_page", (String) this.c.getValue()), TuplesKt.to("session_id", (String) this.d.getValue()), TuplesKt.to("page_type", this.f.optString("page_type")), TuplesKt.to("status", String.valueOf(0))});
    }

    static {
        g = new LinkedHashMap();
    }

    public CardListSuccessRateMonitor(JSONObject r1) {
        this.f = r1;
        this.b = LazyKt.lazy(new CardListSuccessRateMonitor$pageName$2(this));
        this.c = LazyKt.lazy(new CardListSuccessRateMonitor$previousPage$2(this));
        this.d = LazyKt.lazy(new CardListSuccessRateMonitor$sessionId$2(this));
        this.e = LazyKt.lazy(new CardListSuccessRateMonitor$bizType$2(this));
    }
}
