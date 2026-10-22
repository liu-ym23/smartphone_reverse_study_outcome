package com.bytedance.salamander.anniex;

import com.bytedance.keva.Keva;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes20.dex */
public final class SLHybridSettingsManager {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f267913e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f267914a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.anniex.bd.foundation.impl.r f267915b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SLHybridSettingsFetcher f267916c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public c6 f267917d;

    public static final class a {
    }

    static {
    }

    public final void b() {
        com.bytedance.anniex.bd.foundation.impl.a.f190139a.c("SLHybridSettingsManager", "SLHybridSettingsManager loopUpdate start.");
        final Function1<Object, Unit> r100 = new SLHybridSettingsManager$loopUpdate$handleResponse$1(this);
        final Function1<JSONObject, Unit> r101 = new SLHybridSettingsManager$loopUpdate$consume$1(this, r100);
        SLHybridSettingsFetcher r102 = this.f267916c;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("settingsFetcher");
        r102 = null;
    L5:
        r102.a(new SLHybridSettingsManager$loopUpdate$1(r101), new SLHybridSettingsManager$loopUpdate$2(this));
    }

    public SLHybridSettingsManager(a6 r100) {
        Intrinsics.checkNotNullParameter(r100, "settingsConfig");
        this.f267915b = new com.bytedance.anniex.bd.foundation.impl.r("salamander_anniex");
        this.f267917d = new c6();
        this.f267916c = new SLHybridSettingsFetcher(r100);
        if (this.f267914a == true) goto L7;
        this.f267914a = true;
        com.bytedance.anniex.bd.foundation.impl.a.f190139a.c("SLHybridSettingsManager", "SLHybridSettingsManager init start.");
        d8.f268040b.a(new SLHybridSettingsManager$checkAndStart$1(this));
        return;
    }

    public final void c(long r100) {
        com.bytedance.anniex.bd.foundation.impl.a.f190139a.c("SLHybridSettingsManager", "SLHybridSettingsManager scheduleUpdate after " + r100 + " seconds.");
        d8 r101 = d8.f268040b;
        Function1<Boolean, Object> r102 = new SLHybridSettingsManager$scheduleUpdate$1(this);
        int r103 = com.bytedance.rts.foundation.e.f267578a;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "workLoad");
        int r104 = com.bytedance.salamander.adapter.r.f267796a;
        com.bytedance.salamander.adapter.i r105 = r101.f268041a;
        Intrinsics.checkNotNull(r105);
        com.bytedance.salamander.adapter.r.a.a(r102, r105, r100);
    }

    public static final void a(SLHybridSettingsManager r100, JSONObject r101) {
        com.bytedance.anniex.bd.foundation.impl.r r102 = r100.f267915b;
        int r103 = com.bytedance.rts.foundation.c.f267576a;
        int r104 = com.bytedance.rts.foundation.b.f267575a;
        long r105 = (long) (System.currentTimeMillis() / ((double) 1000));
        r102.getClass();
        Intrinsics.checkNotNullParameter("sl_monitor_last_fetch_time", "key");
        Keva r106 = r102.f190153a;
        if (r106 == null) goto L5;
        r106.storeLong("sl_monitor_last_fetch_time", r105);
    L5:
        r100.f267915b.a("sl_monitor_hybrid_settings", com.bytedance.anniex.bd.foundation.impl.o.a(r101));
    }
}
