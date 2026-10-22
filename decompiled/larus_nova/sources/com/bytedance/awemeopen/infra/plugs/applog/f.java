package com.bytedance.awemeopen.infra.plugs.applog;

import com.bytedance.awemeopen.servicesapi.log.AoLogService;

/* JADX INFO: loaded from: classes46.dex */
public final class f {
    public static void a(String r100, Object r101) {
        if (r101 != null) goto L4;
        r101 = "null";
    L4:
        int r102 = j64.b.f497514a;
        ((AoLogService) j64.b.a(AoLogService.class)).e(r100, r101.toString());
    }
}
