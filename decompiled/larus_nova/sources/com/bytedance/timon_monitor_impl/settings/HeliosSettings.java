package com.bytedance.timon_monitor_impl.settings;

import com.bytedance.timonbase.TMEnv;
import com.bytedance.timonbase.b;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import gz5.y;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;

/* JADX INFO: loaded from: classes3.dex */
public final class HeliosSettings {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f270764b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f270765c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public y f270766a;

    public static final class a {
    }

    static {
        f270764b = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, HeliosSettings$Companion$INSTANCE$2.INSTANCE);
        f270765c = LazyKt.lazy(HeliosSettings$Companion$DEFAULT_SETTINGS$2.INSTANCE);
    }

    public HeliosSettings() {
        a();
    }

    public final void a() {
        JsonObject r100 = com.bytedance.timonbase.config.a.a("monitor");
        if (r100 == null) goto L16;
        b.b("helios-config:", new Object[]{r100});
        y r101 = ((HeliosSettingsModelV2) new Gson().fromJson(r100, HeliosSettingsModelV2.class)).toModelV1();     // Catch: Exception -> L11
        this.f270766a = r101;     // Catch: Exception -> L11
        Object[] r102 = new Object[1];     // Catch: Exception -> L11
        if (r101 != null) goto L9;
        r101 = (y) f270765c.getValue();     // Catch: Exception -> L11
    L9:
        r102[0] = r101;     // Catch: Exception -> L11
        b.b("settingmodel:", r102);     // Catch: Exception -> L11
        return;
    L11:
        e = move-exception;
        if (TMEnv.f270767a == false) goto L20;
        throw e;
    L20:
        return;
    }
}
