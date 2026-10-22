package com.obric.aiagent.appintent;

import android.os.Bundle;
import com.volcengine.zeus.provider.BaseProxyProvider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class IntentsTestStubProvider extends BaseProxyProvider {
    @Override // com.volcengine.zeus.provider.BaseProxyProvider
    public final String getPluginName() {
        return "com.obric.aiagent.plugin";
    }

    @Override // com.volcengine.zeus.provider.ContentProviderProxy, android.content.ContentProvider
    public final boolean onCreate() {
        return super.onCreate();
    }

    public IntentsTestStubProvider() {
    }

    @Override // com.volcengine.zeus.provider.BaseProxyProvider, com.volcengine.zeus.provider.ContentProviderProxy, android.content.ContentProvider
    public Bundle call(String r1, String r2, Bundle r3) {
        return super.call(r1, r2, r3);
    }

    @Override // com.volcengine.zeus.provider.BaseProxyProvider, com.volcengine.zeus.provider.ContentProviderProxy, android.content.ContentProvider
    public Bundle call(String r1, String r2, String r3, Bundle r4) {
        return super.call(r1, r2, r3, r4);
    }
}
