package com.obric.aiagent.interaction.provider;

import android.os.Bundle;
import com.volcengine.zeus.provider.BaseProxyProvider;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class HybridAbilityProvider extends BaseProxyProvider {
    @Override // com.volcengine.zeus.provider.BaseProxyProvider
    public String getPluginName() {
        return "com.obric.aiagent.plugin";
    }

    @Override // com.volcengine.zeus.provider.ContentProviderProxy, android.content.ContentProvider
    public boolean onCreate() {
        return super.onCreate();
    }

    public HybridAbilityProvider() {
    }

    @Override // com.volcengine.zeus.provider.BaseProxyProvider, com.volcengine.zeus.provider.ContentProviderProxy, android.content.ContentProvider
    public Bundle call(String r100, String r101, Bundle r102) {
        Objects.toString(r102);
        return super.call(r100, r101, r102);
    }

    @Override // com.volcengine.zeus.provider.BaseProxyProvider, com.volcengine.zeus.provider.ContentProviderProxy, android.content.ContentProvider
    public Bundle call(String r100, String r101, String r102, Bundle r103) {
        Objects.toString(r103);
        return super.call(r100, r101, r102, r103);
    }
}
