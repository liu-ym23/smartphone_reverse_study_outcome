package com.obric.memorydata.plugin_api.stub.provider;

import android.os.Bundle;
import com.obric.memorydata.plugin_api.MemoryPluginActiveState;
import com.volcengine.zeus.provider.BaseProxyProvider;

/* JADX INFO: loaded from: classes5.dex */
public class MemoryBaseProxyProvider extends BaseProxyProvider {
    @Override // com.volcengine.zeus.provider.BaseProxyProvider
    public final String getPluginName() {
        return "com.obric.memorydata.plugin";
    }

    public MemoryBaseProxyProvider() {
    }

    @Override // com.volcengine.zeus.provider.BaseProxyProvider, com.volcengine.zeus.provider.ContentProviderProxy, android.content.ContentProvider
    public Bundle call(String r100, String r101, Bundle r102) {
        MemoryPluginActiveState.onEnter();
        Bundle r103 = super.call(r100, r101, r102);     // Catch: Throwable -> L6
        MemoryPluginActiveState.onExit();
        return r103;
    L6:
        th = move-exception;
        MemoryPluginActiveState.onExit();
        throw th;
    }

    @Override // com.volcengine.zeus.provider.BaseProxyProvider, com.volcengine.zeus.provider.ContentProviderProxy, android.content.ContentProvider
    public Bundle call(String r100, String r101, String r102, Bundle r103) {
        MemoryPluginActiveState.onEnter();
        Bundle r104 = super.call(r100, r101, r102, r103);     // Catch: Throwable -> L6
        MemoryPluginActiveState.onExit();
        return r104;
    L6:
        th = move-exception;
        MemoryPluginActiveState.onExit();
        throw th;
    }
}
