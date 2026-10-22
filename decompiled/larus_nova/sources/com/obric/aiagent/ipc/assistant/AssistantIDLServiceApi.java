package com.obric.aiagent.ipc.assistant;

import com.volcengine.zeus.service.BaseProxyService;

/* JADX INFO: loaded from: classes.dex */
public class AssistantIDLServiceApi extends BaseProxyService {
    @Override // com.volcengine.zeus.service.BaseProxyService
    public String getPluginName() {
        return "com.obric.aiagent.plugin";
    }

    @Override // com.volcengine.zeus.service.BaseProxyService
    public String getServiceClassName() {
        return "com.obric.aiagent.ipc.assistant.AssistantIDLService";
    }

    public AssistantIDLServiceApi() {
    }
}
