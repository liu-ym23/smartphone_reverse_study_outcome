package com.bytedance.android.shopping.sku.common.monitor.fps;

import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.monitor.MonitorScenes;
import com.bytedance.android.ec.model.sku.SkuParams;
import com.bytedance.android.shopping.sku.common.monitor.error.SkuRunCatchExtKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class SkuYataFpsMonitor {
    public final MonitorScenes a;
    public final Lazy b;
    public final SkuParams c;
    public final JSONObject d;

    public final void b() {
        SkuRunCatchExtKt.a(this.c.getMonitorId(), "SkuYataFpsMonitor", new SkuYataFpsMonitor$stop$1(this));
    }

    public final void a(final RecyclerView r3) {
        SkuRunCatchExtKt.a(this.c.getMonitorId(), "SkuYataFpsMonitor", new SkuYataFpsMonitor$start$1(this, r3));
    }

    public SkuYataFpsMonitor(SkuParams r2, JSONObject r3) {
        Intrinsics.checkNotNullParameter(r2, "skuParams");
        Intrinsics.checkNotNullParameter(r3, "baseCategory");
        this.c = r2;
        this.d = r3;
        this.a = MonitorScenes.FPS_SCENE_YATA_SKU;
        this.b = LazyKt.lazy(new SkuYataFpsMonitor$fpsTracker$2(this));
    }
}
