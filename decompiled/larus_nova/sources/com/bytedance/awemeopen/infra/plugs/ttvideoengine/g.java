package com.bytedance.awemeopen.infra.plugs.ttvideoengine;

import com.bytedance.awemeopen.servicesapi.log.AoLogService;

/* JADX INFO: loaded from: classes46.dex */
public final class g {
    public static void a(Object r100) {
        if (r100 != null) goto L4;
        r100 = "null";
    L4:
        int r101 = j64.b.f497514a;
        ((AoLogService) j64.b.a(AoLogService.class)).i("AoTTVideoEnginePlayer", r100.toString());
    }

    public static void b(Object r100) {
        if (r100 != null) goto L4;
        r100 = "null";
    L4:
        int r101 = j64.b.f497514a;
        ((AoLogService) j64.b.a(AoLogService.class)).w("preload_log", r100.toString());
    }
}
