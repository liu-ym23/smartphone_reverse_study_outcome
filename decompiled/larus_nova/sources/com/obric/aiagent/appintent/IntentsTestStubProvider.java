package com.obric.aiagent.appintent;

import android.os.Bundle;
import com.volcengine.zeus.provider.BaseProxyProvider;

/* JADX INFO: loaded from: classes.dex */
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
    public Bundle call(String r100, String r101, Bundle r102) {
        return super.call(r100, r101, r102);
    }

    @Override // com.volcengine.zeus.provider.BaseProxyProvider, com.volcengine.zeus.provider.ContentProviderProxy, android.content.ContentProvider
    public Bundle call(String r100, String r101, String r102, Bundle r103) {
        return super.call(r100, r101, r102, r103);
    }
}
