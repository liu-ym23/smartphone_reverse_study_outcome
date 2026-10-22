package com.obric.aiagent.executionengine.scheduler.impl;

import android.content.Intent;
import com.volcengine.zeus.service.BaseProxyService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class ScheduleService extends BaseProxyService {
    @Override // com.volcengine.zeus.service.BaseProxyService
    public String getPluginName() {
        return "com.obric.aiagent.plugin";
    }

    @Override // com.volcengine.zeus.service.BaseProxyService
    public String getServiceClassName() {
        return "com.obric.aiagent.executionengine.scheduler.impl.ScheduleServiceImpl";
    }

    public ScheduleService() {
    }

    @Override // com.volcengine.zeus.service.BaseProxyService, android.app.Service
    public int onStartCommand(Intent r1, int r2, int r3) {
        super.onStartCommand(r1, r2, r3);
        return 2;
    }
}
