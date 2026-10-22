package com.bytedance.bdp.appbase.base.monitor;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public final class d {
    public static void a(String r100, String r101) {
        com.bytedance.bdp.appbase.base.event.d r102 = new com.bytedance.bdp.appbase.base.event.d(null);
        long r103 = System.currentTimeMillis();
        com.bytedance.bdp.appbase.base.event.c.f r104 = new com.bytedance.bdp.appbase.base.event.c.f();
        r104.a("crash_type", "ensure");
        r104.a(BdpAppEventConstant.PARAMS_EXC_PLACE, "threadpool-exception");
        r104.a(BdpAppEventConstant.PARAMS_EXC_FILENAME, r100);
        r104.a(BdpAppEventConstant.PARAMS_EXC_METHODNAME, r101);
        if (r104.f200559a != null) goto L5;
        r104.f200559a = new JSONObject();
    L5:
        com.bytedance.bdp.appbase.base.event.c.b(r104.f200559a, null);
        new com.bytedance.bdp.appbase.base.event.c(r103, BdpAppEventConstant.EVENT_MP_EXCEPTION_CATCH_EVENT, new com.bytedance.bdp.appbase.base.event.c.g[]{r102, null, null, r104, null}).a();
    }
}
