package com.bytedance.ies.bullet.forest;

import com.bytedance.android.service.manager.pull.PullConfiguration;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class q extends com.bytedance.ies.bullet.service.sdk.e {

    public static final class a {
    }

    static {
    }

    @Override // t36.e
    public final String getName() {
        return "forest";
    }

    public q() {
    }

    @Override // t36.e
    public final boolean b(com.bytedance.ies.bullet.service.sdk.d r110) {
        Intrinsics.checkNotNullParameter(r110, "schemaData");
        LinkedHashMap r100 = (LinkedHashMap) r110.f248139p;
        String r101 = null;
        if (Intrinsics.areEqual(r100.get("enable_preload"), "main_ssr") == true) goto L7;
        r100 = null;
    L7:
        if (r100 == null) goto L9;
        r110.a("loader_name", new y36.p("forest"), false);
        r110.a("streaming_load", new y36.d(1), false);
        r110.a("enable_preload", new y36.p(PullConfiguration.PROCESS_NAME_MAIN), true);
    L9:
        LinkedHashMap r102 = (LinkedHashMap) r110.f248139p;
        String r103 = (String) r102.get("enable_preload");
        if (r103 != null) goto L13;
        r103 = "disable";
    L13:
        if ((!Intrinsics.areEqual(r103, "disable")) == true) goto L16;
        r102 = null;
    L16:
        if (r102 != null) goto L18;
    L29:
        String r104 = (String) ((LinkedHashMap) r110.f248139p).get("enable_preload");
        if (r104 != null) goto L32;
    L45:
        Map<String, Map<Class<?>, Object>> r105 = x26.a.f562251a;
        w26.g r106 = (w26.g) x26.a.a(w26.g.class);
        if (r106 == null) goto L57;
        com.bytedance.ies.bullet.base.settings.l r107 = (com.bytedance.ies.bullet.base.settings.l) r106.n0(com.bytedance.ies.bullet.base.settings.l.class);
        if (r107 == null) goto L57;
        if (Intrinsics.areEqual(((LinkedHashMap) r110.f248139p).get("loader_name"), "forest") == false) goto L57;
        String r108 = r107.d();
        if (Intrinsics.areEqual(r108, "concurrent") == false) goto L55;
        r101 = r108;
    L55:
        if (r101 == null) goto L57;
        r110.a("forest_buffer_mode", new y36.p(r101), false);
    L57:
        return true;
    L32:
        if (r104.length() <= 0) goto L34;
        boolean r109 = true;
    L35:
        if (r109 == true) goto L38;
        r104 = null;
    L38:
        if (r104 == null) goto L45;
        if ((!Intrinsics.areEqual(r104, "disable")) == true) goto L43;
        r104 = null;
    L43:
        if (r104 == null) goto L45;
        r110.a("forest_max_age", new y36.d(5), false);
        goto L45
    L34:
        r109 = false;
        goto L35
    L18:
        if (Intrinsics.areEqual(r102.get("append_common_params"), "1") == true) goto L23;
        int r111 = com.bytedance.ies.bullet.kit.resourceloader.loader.b.f246865a;
        if (com.bytedance.ies.bullet.kit.resourceloader.loader.b.d((String) r102.get("append_global_props")) == true) goto L23;
        boolean r112 = false;
    L24:
        if (r112 == true) goto L27;
        r102 = null;
    L27:
        if (r102 == null) goto L29;
        r110.a("delay_preload", new y36.d(1), false);
    L23:
        r112 = true;
        goto L24
    }
}
