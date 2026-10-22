package com.volcengine.zeus;

import android.app.Application;
import android.content.Context;
import com.volcengine.zeus.plugin.Plugin;

/* JADX INFO: loaded from: classes.dex */
public class ZeusApplication extends PluginContext {
    Application mHostApplication;

    public void onCreate() {
    }

    public ZeusApplication() {
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context r100) {
        super.attachBaseContext(r100);
    }

    public void attach(Plugin r100, Application r101) {
        this.mPlugin = r100;
        this.mHostApplication = r101;
        attachBaseContext(r101);
    }
}
