package com.bytedance.sdk.bridge.api;

import com.bytedance.news.common.service.manager.IServiceProxy;
import com.ivy.ivykit.plugin.impl.jsb.auth.LegacyBridgeService;
import java.util.Map;

/* JADX INFO: loaded from: classes22.dex */
public class BridgeService__ServiceProxy implements IServiceProxy<BridgeService> {
    public BridgeService__ServiceProxy() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public BridgeService newInstance() {
        return new LegacyBridgeService();
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public /* bridge */ /* synthetic */ BridgeService newInstance() {
        return newInstance();
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public void collectService(Map<String, String> r100) {
        r100.put("com.bytedance.sdk.bridge.api.BridgeService", "com.ivy.ivykit.plugin.impl.jsb.auth.LegacyBridgeService");
    }
}
