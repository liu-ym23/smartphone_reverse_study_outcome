package com.ss.cast.plugin.dy.plugin;

import b56.a;

/* JADX INFO: loaded from: classes40.dex */
public interface IByteCastPlugin {
    boolean checkInitialized(boolean r100);

    boolean checkPluginInstalled(String r100);

    String getCurProcessPluginVer(String r100);

    void installPlugin(a r100);

    boolean isPluginLoaded(String r100);

    boolean needUpgradePlugin(String r100);

    void preload(String r100);
}
