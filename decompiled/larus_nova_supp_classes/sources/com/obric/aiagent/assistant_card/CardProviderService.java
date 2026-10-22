package com.obric.aiagent.assistant_card;

import com.volcengine.zeus.service.BaseProxyService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class CardProviderService extends BaseProxyService {
    @Override // com.volcengine.zeus.service.BaseProxyService
    public String getPluginName() {
        return "com.obric.aiagent.plugin";
    }

    @Override // com.volcengine.zeus.service.BaseProxyService
    public String getServiceClassName() {
        return "com.obric.aiagent.assistant_card.provider_core.service.CardProviderService";
    }

    public CardProviderService() {
    }
}
