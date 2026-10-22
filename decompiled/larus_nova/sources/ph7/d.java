package ph7;

import com.bytedance.timonbase.TMInjection;
import com.bytedance.timonbase.report.TMDataCollector;
import com.google.gson.JsonObject;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static c f529300a;

    public static c a() {
        JsonObject r100 = com.bytedance.timonbase.config.a.a("scene_config");     // Catch: Exception -> L4
        return (c) TMInjection.a().fromJson(r100, c.class);
    L4:
        e = move-exception;
        TMDataCollector.f270828e.g("", e, "getSenseConfig failed", MapsKt.emptyMap(), false);
        return null;
    }

    static {
    }
}
