package com.bytedance.sdk.account.monitor.settings;

import com.bytedance.news.common.service.manager.IServiceProxy;
import com.bytedance.sdk.account.monitor.AccountMonitorDefaultConfigServiceImpl;
import java.util.Map;

/* JADX INFO: loaded from: classes22.dex */
public class IAccountMonitorDefaultConfigService__ServiceProxy implements IServiceProxy<IAccountMonitorDefaultConfigService> {
    public IAccountMonitorDefaultConfigService__ServiceProxy() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public IAccountMonitorDefaultConfigService newInstance() {
        return new AccountMonitorDefaultConfigServiceImpl();
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public /* bridge */ /* synthetic */ IAccountMonitorDefaultConfigService newInstance() {
        return newInstance();
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public void collectService(Map<String, String> r100) {
        r100.put("com.bytedance.sdk.account.monitor.settings.IAccountMonitorDefaultConfigService", "com.bytedance.sdk.account.monitor.AccountMonitorDefaultConfigServiceImpl");
    }
}
