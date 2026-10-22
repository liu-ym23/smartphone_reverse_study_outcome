package com.bytedance.bdp.bdpplatform.service.log;

import com.bytedance.bdp.serviceapi.defaults.log.BdpLogService;

/* JADX INFO: loaded from: classes3.dex */
public class BdpLogServiceImpl implements BdpLogService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f201382a;

    @Override // com.bytedance.bdp.serviceapi.defaults.log.BdpLogService
    public final void d(String r100, String r101) {
    }

    @Override // com.bytedance.bdp.serviceapi.defaults.log.BdpLogService
    public final void e(String r100, String r101) {
    }

    @Override // com.bytedance.bdp.serviceapi.defaults.log.BdpLogService
    public final void i(String r100, String r101) {
    }

    @Override // com.bytedance.bdp.serviceapi.defaults.log.BdpLogService
    public final void isEnabled() {
        this.f201382a = true;
    }

    @Override // com.bytedance.bdp.serviceapi.defaults.log.BdpLogService
    public final void q1() {
        if (this.f201382a == true) goto L5;
        return;
    }

    public BdpLogServiceImpl() {
        this.f201382a = true;
    }
}
