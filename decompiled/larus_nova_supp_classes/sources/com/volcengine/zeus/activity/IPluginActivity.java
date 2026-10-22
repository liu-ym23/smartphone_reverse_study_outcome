package com.volcengine.zeus.activity;

import android.content.Context;
import android.os.Bundle;
import com.volcengine.zeus.plugin.Plugin;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public interface IPluginActivity {
    void _requestPermissions(String[] r1, int r2);

    void attachBaseContext(Context r1);

    String getPluginPkgName();

    void onCreate(Bundle r1);

    void setPluginProxyActivity(b r1, Plugin r2);

    void setProxyTheme2Plugin(int r1);
}
