package com.bytedance.android.livesdk.livecommerce.largemode;

import android.util.LruCache;
import com.bytedance.android.livesdk.livecommerce.largemode.model.ComponentLargeModeConfig;
import com.bytedance.android.livesdk.livecommerce.largemode.model.LargeModeConfig;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class ECLiveLargeModeConfigHelper {
    public static final Lazy a = null;
    public static final Lazy b = null;
    public static final Map<String, Map<String, LargeModeConfig>> c = null;
    public static final LruCache<String, Map<String, Map<String, ComponentLargeModeConfig>>> d = null;

    static {
        a = LazyKt.lazy(ECLiveLargeModeConfigHelper$scaleLevel$2.INSTANCE);
        b = LazyKt.lazy(ECLiveLargeModeConfigHelper$SETTINGS_LARGE_MODE_CONFIG_VALUE$2.INSTANCE);
        Pair[] r2 = {TuplesKt.to("PromotionCard", ki2.b.a), TuplesKt.to("ExplainCard", ii2.b.a), TuplesKt.to("List", ji2.b.a)};
        LargeModeConfig r3 = ki2.a.a;
        LargeModeConfig r10 = ii2.a.a;
        LargeModeConfig r11 = ji2.a.a;
        c = MapsKt.mapOf(new Pair[]{TuplesKt.to("1.0", MapsKt.mapOf(r2)), TuplesKt.to("1.15", MapsKt.mapOf(new Pair[]{TuplesKt.to("PromotionCard", r3), TuplesKt.to("ExplainCard", r10), TuplesKt.to("List", r11)})), TuplesKt.to("1.3", MapsKt.mapOf(new Pair[]{TuplesKt.to("PromotionCard", r3), TuplesKt.to("ExplainCard", r10), TuplesKt.to("List", r11)}))});
        d = new LruCache(2);
    }
}
