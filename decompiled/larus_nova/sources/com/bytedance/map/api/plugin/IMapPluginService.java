package com.bytedance.map.api.plugin;

import android.content.Context;

/* JADX INFO: loaded from: classes21.dex */
public interface IMapPluginService {
    String getPluginPackageName();

    void installPlugin(Context r100, String r101, boolean r102, MapPluginActionListener r103);

    boolean isPluginInstalled(String r100);

    boolean isPluginNeedUpgrade(String r100);

    boolean loadLocalPlugin(Context r100, String r101);
}
