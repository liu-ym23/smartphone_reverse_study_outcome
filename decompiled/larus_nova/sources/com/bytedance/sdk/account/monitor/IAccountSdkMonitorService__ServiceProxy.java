package com.bytedance.sdk.account.monitor;

import com.bytedance.news.common.service.manager.IServiceProxy;
import java.util.Map;

/* JADX INFO: loaded from: classes22.dex */
public class IAccountSdkMonitorService__ServiceProxy implements IServiceProxy<IAccountSdkMonitorService> {
    public IAccountSdkMonitorService__ServiceProxy() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public IAccountSdkMonitorService newInstance() {
        return new AccountSdkMonitorServiceImpl();
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public /* bridge */ /* synthetic */ IAccountSdkMonitorService newInstance() {
        return newInstance();
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public void collectService(Map<String, String> r100) {
        r100.put("com.bytedance.sdk.account.monitor.IAccountSdkMonitorService", "com.bytedance.sdk.account.monitor.AccountSdkMonitorServiceImpl");
    }
}
