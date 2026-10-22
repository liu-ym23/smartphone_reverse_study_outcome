package com.ss.android.ugc.aweme.live.plugin;

import android.app.Application;
import android.content.Context;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.aweme.live.IHostPlatformPluginService;

/* JADX INFO: loaded from: classes40.dex */
public class LivePluginApplication extends Application {
    public LivePluginApplication() {
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
    }

    @Override // android.content.ContextWrapper
    public void attachBaseContext(Context r100) {
        super.attachBaseContext(r100);
        if (ServiceManager.get().getService(IHostPlatformPluginService.class) == null) goto L6;
        ((IHostPlatformPluginService) ServiceManager.get().getService(IHostPlatformPluginService.class)).updateMultiDexInstalled(this);
        return;
    }
}
