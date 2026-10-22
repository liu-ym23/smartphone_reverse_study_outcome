package com.bytedance.awemeopen.infra.plugs.applog;

import com.bytedance.applog.AppLog;
import com.bytedance.awemeopen.servicesapi.context.AoHostService;
import com.bytedance.bdinstall.Level;

/* JADX INFO: loaded from: classes46.dex */
public final class d implements c {
    public d() {
    }

    @Override // com.bytedance.awemeopen.infra.plugs.applog.c
    public final String k(String r100) {
        int r101 = j64.b.f497514a;
        return AppLog.addNetCommonParams(((AoHostService) j64.b.a(AoHostService.class)).getHostApplication(), r100, false, Level.L0);
    }
}
