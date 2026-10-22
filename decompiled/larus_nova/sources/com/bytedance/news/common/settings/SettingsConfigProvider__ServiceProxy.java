package com.bytedance.news.common.settings;

import com.bytedance.news.common.service.manager.IServiceProxy;
import com.larus.settings.SettingsConfigProviderImpl;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public class SettingsConfigProvider__ServiceProxy implements IServiceProxy<SettingsConfigProvider> {
    public SettingsConfigProvider__ServiceProxy() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public SettingsConfigProvider newInstance() {
        return new SettingsConfigProviderImpl();
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public /* bridge */ /* synthetic */ SettingsConfigProvider newInstance() {
        return newInstance();
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public void collectService(Map<String, String> r100) {
        r100.put("com.bytedance.news.common.settings.SettingsConfigProvider", "com.larus.settings.SettingsConfigProviderImpl");
    }
}
