package com.bytedance.android.shopping.card_list.monitor;

import com.bytedance.android.shopping.card_list.monitor.cache.CacheMonitor;
import com.bytedance.android.shopping.card_list.monitor.firstScreen.CardListYataFirstScreenDurationMonitor;
import com.bytedance.android.shopping.card_list.monitor.fps.CardListYataFpsMonitor;
import com.bytedance.android.shopping.card_list.monitor.success_rate.CardListSuccessRateMonitor;
import com.bytedance.kmp.ec.yata.common.perf.d;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class CardListYataMonitorManager {
    public static final Map<String, CardListYataMonitorManager> k = null;
    public final Lazy a;
    public final Lazy b;
    public final Lazy c;
    public CardListYataFirstScreenDurationMonitor d;
    public com.bytedance.android.shopping.card_list.monitor.error.a e;
    public CardListYataFpsMonitor f;
    public CardListSuccessRateMonitor g;
    public d h;
    public CacheMonitor i;
    public final JSONObject j;

    public static final class a {
        public static CardListYataMonitorManager a(String r1) {
            return (CardListYataMonitorManager) ((LinkedHashMap) CardListYataMonitorManager.k).get(r1);
        }
    }

    static {
        k = new LinkedHashMap();
    }

    public CardListYataMonitorManager(JSONObject r1) {
        this.j = r1;
        this.a = LazyKt.lazy(new CardListYataMonitorManager$pageName$2(this));
        this.b = LazyKt.lazy(new CardListYataMonitorManager$previousPage$2(this));
        this.c = LazyKt.lazy(new CardListYataMonitorManager$sessionId$2(this));
    }
}
