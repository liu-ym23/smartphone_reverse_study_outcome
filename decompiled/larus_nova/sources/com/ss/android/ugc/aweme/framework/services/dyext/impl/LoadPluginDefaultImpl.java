package com.ss.android.ugc.aweme.framework.services.dyext.impl;

import android.os.Handler;
import com.ss.android.ugc.aweme.framework.services.dyext.LoadPluginFuture;
import com.ss.android.ugc.aweme.framework.services.dyext.api.ILoadPlugin;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001a\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\f"}, d2 = {"Lcom/ss/android/ugc/aweme/framework/services/dyext/impl/LoadPluginDefaultImpl;", "Lcom/ss/android/ugc/aweme/framework/services/dyext/api/ILoadPlugin;", "()V", "isReady", "", "pluginPackageName", "", "loadPlugin", "Lcom/ss/android/ugc/aweme/framework/services/dyext/LoadPluginFuture;", "callHandler", "Landroid/os/Handler;", "loadPluginIfInstalled", "dy-ext-spi_release"}, k = 1, mv = {1, 1, 15})
public final class LoadPluginDefaultImpl implements ILoadPlugin {
    public LoadPluginDefaultImpl() {
    }

    @Override // com.ss.android.ugc.aweme.framework.services.dyext.api.ILoadPlugin
    public boolean isReady(String r100) {
        return true;
    }

    @Override // com.ss.android.ugc.aweme.framework.services.dyext.api.ILoadPlugin
    public boolean loadPluginIfInstalled(String r100) {
        return true;
    }

    @Override // com.ss.android.ugc.aweme.framework.services.dyext.api.ILoadPlugin
    public LoadPluginFuture loadPlugin(String r100, Handler r101) {
        return new ImmediateLoadPluginFutureImpl();
    }
}
