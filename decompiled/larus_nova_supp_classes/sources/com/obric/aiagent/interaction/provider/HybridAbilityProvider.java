package com.obric.aiagent.interaction.provider;

import android.os.Bundle;
import com.volcengine.zeus.provider.BaseProxyProvider;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
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
    public Bundle call(String r2, String r3, Bundle r4) {
        Objects.toString(r4);
        return super.call(r2, r3, r4);
    }

    @Override // com.volcengine.zeus.provider.BaseProxyProvider, com.volcengine.zeus.provider.ContentProviderProxy, android.content.ContentProvider
    public Bundle call(String r2, String r3, String r4, Bundle r5) {
        Objects.toString(r5);
        return super.call(r2, r3, r4, r5);
    }
}
