package com.ss.ttm.player;

/* JADX INFO: loaded from: classes40.dex */
public class TTPlayerPluginLoader {
    public static final int PLUGIN_INTERTRUST_DRM = 100;
    private static IPluginLoader mPluginLoader;

    public TTPlayerPluginLoader() {
    }

    public static ClassLoader loadPlugin(int r100) {
        IPluginLoader r101 = mPluginLoader;
        if (r101 != null) goto L5;
        return null;
    L5:
        return r101.loadPlugin(r100);
    }

    public static void setPluginLoader(IPluginLoader r100) {
        mPluginLoader = r100;
    }
}
