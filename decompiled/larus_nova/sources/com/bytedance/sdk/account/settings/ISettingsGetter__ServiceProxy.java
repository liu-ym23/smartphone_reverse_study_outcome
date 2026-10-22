package com.bytedance.sdk.account.settings;

import com.bytedance.news.common.service.manager.IServiceProxy;
import java.util.Map;

/* JADX INFO: loaded from: classes22.dex */
public class ISettingsGetter__ServiceProxy implements IServiceProxy<ISettingsGetter> {
    public ISettingsGetter__ServiceProxy() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public ISettingsGetter newInstance() {
        return new SettingsGetterImpl();
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public /* bridge */ /* synthetic */ ISettingsGetter newInstance() {
        return newInstance();
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public void collectService(Map<String, String> r100) {
        r100.put("com.bytedance.sdk.account.settings.ISettingsGetter", "com.bytedance.sdk.account.settings.SettingsGetterImpl");
    }
}
