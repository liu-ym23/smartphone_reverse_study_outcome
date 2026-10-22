package com.bytedance.ies.bullet.service.base;

import com.bytedance.ies.bullet.service.base.api.LogLevel;
import java.util.Map;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes19.dex */
public final class h0 {
    public static final g0 a() {
        Map<String, Map<Class<?>, Object>> r100 = x26.a.f562251a;
        g0 r101 = (g0) x26.a.a(g0.class);
        if (r101 != null) goto L5;
        ExecutorService r102 = BulletLogger.f247763a;
        BulletLogger.k("getPreLoadV2Service fail", LogLevel.E, null, 4);
    L5:
        return r101;
    }
}
