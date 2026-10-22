package com.volcengine.zeus.activity;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import com.volcengine.zeus.plugin.Plugin;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public interface b {
    void finish();

    Application getApplication();

    Context getBaseContext();

    Intent getIntent();

    Plugin getPlugin();

    String getPluginPkgName();

    Window getWindow();

    void setPlugin(Plugin r1);

    void setTargetActivity(IPluginActivity r1);

    void zeusSuperAttachBaseContext(Context r1);

    void zeusSuperOnCreate(Bundle r1);

    void zeusSuperSetTheme(int r1);
}
