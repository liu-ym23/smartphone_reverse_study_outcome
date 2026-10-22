package com.ss.android.ugc.aweme.framework.services.dyext;

import android.os.Handler;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.aweme.framework.services.dyext.api.ILoadPlugin;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u001c\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0007\u001a\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\b"}, d2 = {"loadPlugin", "Lcom/ss/android/ugc/aweme/framework/services/dyext/LoadPluginFuture;", "pluginPackageName", "", "callHandler", "Landroid/os/Handler;", "loadPluginIfInstalled", "", "dy-ext-spi_release"}, k = 5, mv = {1, 1, 15}, xs = "com/ss/android/ugc/aweme/framework/services/dyext/ServiceManagerExt")
final /* synthetic */ class ServiceManagerExt__LoadPluginCallerKt {
    public static final LoadPluginFuture loadPlugin(String r100) {
        return ServiceManagerExt.loadPlugin$default(r100, null, 2, null);
    }

    public static final boolean loadPluginIfInstalled(String r100) {
        return ((ILoadPlugin) ServiceManager.get().getService(ILoadPlugin.class)).loadPluginIfInstalled(r100);
    }

    public static final LoadPluginFuture loadPlugin(String r100, Handler r101) {
        return ((ILoadPlugin) ServiceManager.get().getService(ILoadPlugin.class)).loadPlugin(r100, r101);
    }

    public static /* synthetic */ LoadPluginFuture loadPlugin$default(String r100, Handler r101, int r102, Object r103) {
        if ((r102 & 2) == 0) goto L6;
        r101 = null;
    L6:
        return ServiceManagerExt.loadPlugin(r100, r101);
    }
}
