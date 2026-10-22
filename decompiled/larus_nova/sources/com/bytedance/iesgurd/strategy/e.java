package com.bytedance.iesgurd.strategy;

import android.content.Context;
import com.bytedance.geckox.AppSettingsManager;
import com.bytedance.geckox.GeckoGlobalConfig;
import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.iesgurd.settings.GlobalSettingsManager;
import com.bytedance.iesgurd.settings.SettingsExtra;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile String f250861a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Context f250862b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static GeckoGlobalConfig f250863c;

    public static final class a extends dz5.a<Object> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function0 f250864b;

        @Override // dz5.a
        public final int b() {
            return 7;
        }

        @Override // dz5.a
        public final void a() {
            GeckoLogger.d("[gecko probe] delay task execute");
            this.f250864b.invoke();
        }

        public a(Function0 r100) {
            this.f250864b = r100;
        }
    }

    static {
    }

    public static boolean a(String r100, Function0 r101) {
        AppSettingsManager.IGeckoAppSettings r102 = AppSettingsManager.b.f245071a.b();
        if (r102 != null) goto L5;
    L7:
        boolean r103 = false;
    L9:
        if (r103 == true) goto L12;
        b("before_random_error_not_enable", r100, null);
        return false;
    L12:
        SettingsExtra r104 = GlobalSettingsManager.f250843k;
        if (r104 == null) goto L30;
        SettingsExtra.ProbeInfo r105 = r104.getProbeInfo();
        if (r105 == null) goto L30;
        if (r105.getProbeThreshold() > 0) goto L19;
        r105.setProbeThreshold(60);
    L19:
        int r106 = Random.Default.nextInt(0, r105.getProbeThreshold());
        long r107 = System.currentTimeMillis();
        GeckoGlobalConfig r108 = f250863c;
        if (r108 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("config");
    L22:
        int r109 = (int) ((r107 - r108.getAppColdStartTime()) / ((long) 1000));
        if ((r109 + r106) >= 60) goto L25;
        b("before_random_error_delay_too_short", r100, "delay: " + r106 + ", duration: " + r109);
        r106 = 60 - r109;
    L25:
        int r110 = ry5.a.f539908a;
        b("before_random", r100, "delay: " + r106 + ", duration: " + r109);
        StringBuilder r111 = new StringBuilder("[gecko probe] request delay:");
        r111.append(r106);
        r111.append('s');
        GeckoLogger.d(r111.toString());
        dz5.c r112 = dz5.c.a.f470586a;
        a r113 = new a(r101);
        long r114 = ((long) r106) * 1000;
        dz5.b r115 = r112.f470585a;
        if (r114 >= 0) goto L28;
        r115.getClass();
    L29:
        return true;
    L28:
        r115.b(r113, r114, 0);
    L30:
        b("before_random_error_no_extra", r100, null);
        return false;
    L5:
        if (r102.isProbeEnable() != true) goto L7;
        r103 = true;
        goto L9
    }

    public static void b(String r100, String r101, String r102) {
        JSONObject r103 = new JSONObject();     // Catch: Throwable -> L7
        r103.put("event_type", r100);     // Catch: Throwable -> L7
        r103.put("probe", r101);     // Catch: Throwable -> L7
        if (r102 == null) goto L5;
        r103.put("extra", r102);     // Catch: Throwable -> L7
    L5:
        y86.a.c("geckosdk_probe_debug_stats", r103);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        GeckoLogger.w("uploadProbeEvent error: " + th.getMessage(), th);
    }
}
