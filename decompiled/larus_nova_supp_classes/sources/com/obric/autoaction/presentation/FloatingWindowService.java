package com.obric.autoaction.presentation;

import com.volcengine.zeus.service.BaseProxyService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class FloatingWindowService extends BaseProxyService {
    @Override // com.volcengine.zeus.service.BaseProxyService
    public String getPluginName() {
        return "com.obric.aiagent.plugin";
    }

    @Override // com.volcengine.zeus.service.BaseProxyService
    public String getServiceClassName() {
        return "com.obric.autoaction.presentation.FloatingWindowServiceImpl";
    }

    public FloatingWindowService() {
    }
}
