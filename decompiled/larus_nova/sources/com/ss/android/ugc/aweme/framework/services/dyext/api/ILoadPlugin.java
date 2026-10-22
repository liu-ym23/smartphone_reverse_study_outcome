package com.ss.android.ugc.aweme.framework.services.dyext.api;

import android.os.Handler;
import com.ss.android.ugc.aweme.framework.services.dyext.LoadPluginFuture;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u001c\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u000b"}, d2 = {"Lcom/ss/android/ugc/aweme/framework/services/dyext/api/ILoadPlugin;", "", "isReady", "", "pluginPackageName", "", "loadPlugin", "Lcom/ss/android/ugc/aweme/framework/services/dyext/LoadPluginFuture;", "callHandler", "Landroid/os/Handler;", "loadPluginIfInstalled", "dy-ext-spi_release"}, k = 1, mv = {1, 1, 15})
public interface ILoadPlugin {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 15})
    public static final class DefaultImpls {
        public static /* synthetic */ LoadPluginFuture loadPlugin$default(ILoadPlugin r100, String r101, Handler r102, int r103, Object r104) {
            if (r104 != null) goto L9;
            if ((r103 & 2) == 0) goto L7;
            r102 = null;
        L7:
            return r100.loadPlugin(r101, r102);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadPlugin");
        }
    }

    boolean isReady(String r100);

    LoadPluginFuture loadPlugin(String r100, Handler r101);

    boolean loadPluginIfInstalled(String r100);
}
