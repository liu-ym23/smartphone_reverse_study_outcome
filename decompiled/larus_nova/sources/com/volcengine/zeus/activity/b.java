package com.volcengine.zeus.activity;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import com.volcengine.zeus.plugin.Plugin;

/* JADX INFO: loaded from: classes.dex */
public interface b {
    void finish();

    Application getApplication();

    Context getBaseContext();

    Intent getIntent();

    Plugin getPlugin();

    String getPluginPkgName();

    Window getWindow();

    void setPlugin(Plugin r100);

    void setTargetActivity(IPluginActivity r100);

    void zeusSuperAttachBaseContext(Context r100);

    void zeusSuperOnCreate(Bundle r100);

    void zeusSuperSetTheme(int r100);
}
