package com.bytedance.android.shopping.collect.monitor.fps;

import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.monitor.MonitorScenes;
import com.bytedance.android.shopping.collect.monitor.error.CollectRunCatchExtKt;
import com.bytedance.android.shopping.collect.repo.model.CollectParams;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class CollectYataFpsMonitor {
    public final MonitorScenes a;
    public final Lazy b;
    public final CollectParams c;
    public final JSONObject d;

    public final void a(final RecyclerView r3) {
        CollectRunCatchExtKt.a(this.c.getMonitorId(), "CollectYataFpsMonitor", new CollectYataFpsMonitor$start$1(this, r3));
    }

    public CollectYataFpsMonitor(CollectParams r2, JSONObject r3) {
        Intrinsics.checkNotNullParameter(r2, "collectParams");
        Intrinsics.checkNotNullParameter(r3, "baseCategory");
        this.c = r2;
        this.d = r3;
        this.a = MonitorScenes.FPS_SCENE_COLLECT;
        this.b = LazyKt.lazy(new CollectYataFpsMonitor$fpsTracker$2(this));
    }
}
