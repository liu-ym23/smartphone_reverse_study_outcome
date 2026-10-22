package com.volcengine.zeus.activity;

import android.content.Context;
import android.os.Bundle;
import com.volcengine.zeus.plugin.Plugin;

/* JADX INFO: loaded from: classes.dex */
public interface IPluginActivity {
    void _requestPermissions(String[] r100, int r101);

    void attachBaseContext(Context r100);

    String getPluginPkgName();

    void onCreate(Bundle r100);

    void setPluginProxyActivity(b r100, Plugin r101);

    void setProxyTheme2Plugin(int r100);
}
