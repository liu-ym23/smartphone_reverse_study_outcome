package com.obric.aiagent.appintent;

import android.content.Intent;
import com.volcengine.zeus.service.BaseProxyService;

/* JADX INFO: loaded from: classes.dex */
public class CapabilityHandleService extends BaseProxyService {
    @Override // com.volcengine.zeus.service.BaseProxyService
    public String getPluginName() {
        return "com.obric.aiagent.plugin";
    }

    @Override // com.volcengine.zeus.service.BaseProxyService
    public String getServiceClassName() {
        return "com.obric.capabilitykit.CapabilityHandleService";
    }

    public CapabilityHandleService() {
    }

    @Override // com.volcengine.zeus.service.BaseProxyService, android.app.Service
    public int onStartCommand(Intent r100, int r101, int r102) {
        super.onStartCommand(r100, r101, r102);
        return 2;
    }
}
