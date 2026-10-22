package com.bytedance.ies.bullet.prefetchv2;

import com.bytedance.ies.bullet.service.base.c1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f247562a = 0;

    static {
    }

    public static void a(n r100) {
        Intrinsics.checkNotNullParameter(r100, "info");
        s26.d r101 = s26.d.f540305c;
        com.bytedance.ies.bullet.service.base.r r102 = (com.bytedance.ies.bullet.service.base.r) s26.d.f540305c.d(r100.f247554a, com.bytedance.ies.bullet.service.base.r.class);
        if (r102 == null) goto L10;
        c1 r103 = new c1("bdx_monitor_prefetch_data", null, null, null, null, 254);
        r103.f247801k = r100.getIdentifier();
        JSONObject r104 = new JSONObject();
        r104.put("prefetch_api", r100.f247556c);
        if (r100.f247557d == false) goto L7;
        String r105 = "success";
    L8:
        r104.put("prefetch_state", r105);
        r104.put("prefetch_from", "bridge");
        r104.put("prefetch_cached", r100.f247558e);
        r104.put("prefetch_type", "v2");
        r104.put("prefetch_error", r100.f247559f);
        r104.put("prefetch_config_from", r100.f247561h);
        r103.f247794d = r104;
        JSONObject r106 = new JSONObject();
        r106.put("duration", r100.f247560g);
        r103.f247795e = r106;
        r102.S(r103);
        return;
    L7:
        r105 = "fail";
        goto L8
    }
}
