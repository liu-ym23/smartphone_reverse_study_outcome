package com.volcengine.zeus;

import android.app.Application;
import android.content.Context;
import com.volcengine.zeus.plugin.Plugin;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class ZeusApplication extends PluginContext {
    Application mHostApplication;

    public void onCreate() {
    }

    public ZeusApplication() {
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context r1) {
        super.attachBaseContext(r1);
    }

    public void attach(Plugin r1, Application r2) {
        this.mPlugin = r1;
        this.mHostApplication = r2;
        attachBaseContext(r2);
    }
}
