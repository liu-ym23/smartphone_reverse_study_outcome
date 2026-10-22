package com.ss.ttvideoengine;

import com.ss.ttm.player.TTPlayerPluginLoader;
import com.ss.ttvideoengine.net.TTVNetClient;
import java.util.HashMap;

/* JADX INFO: loaded from: classes34.dex */
public class TTVideoEngineConfig {
    public static final int PLUGIN_TYPE_INTERTRUST_DRM = 100;
    public static final int PLUGIN_TYPE_PLAYER_2_0_COM_SS_TTM = 200;
    public static final int PLUGIN_TYPE_PLAYER_2_0_COM_SS_TTMPLUGIN = 201;
    public static final int PLUGIN_TYPE_PLAYER_3_0_CN_ORG_MEDIAKIT = 300;
    private static HashMap<Integer, ClassLoader> gClassLoaderMap = null;
    public static TTVNetClient gNetClient = null;
    private static IEnginePluginLoader gPluginLoader = null;
    public static boolean openPerformanceUtils = false;
    private static PlayerCreateErrorListener sPlayerCreateErrorListener = null;
    public static int setEGLBitDepth = 8;
    public static long setSurfaceTimeoutForCreated = Long.MIN_VALUE;
    public static long setSurfaceTimeoutForDestroy = Long.MIN_VALUE;

    public TTVideoEngineConfig() {
    }

    public static PlayerCreateErrorListener getPlayerCreateErrorListener() {
        return sPlayerCreateErrorListener;
    }

    public static ClassLoader getClassLoader(int r100) {
        HashMap<Integer, ClassLoader> r101 = gClassLoaderMap;
        if (r101 == null) goto L7;
        ClassLoader r102 = r101.get(Integer.valueOf(r100));
        if (r102 == null) goto L7;
        return r102;
    L7:
        IEnginePluginLoader r103 = gPluginLoader;
        if (r103 != null) goto L10;
        return null;
    L10:
        return r103.loadPlugin(r100);
    }

    public static void setClassLoderCallback(IEnginePluginLoader r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        TTPlayerPluginLoader.setPluginLoader(new AnonymousClass1());
        gPluginLoader = r100;
    }

    public static void setPlayerCreateErrorListener(PlayerCreateErrorListener r100) {
        sPlayerCreateErrorListener = r100;
    }

    public static void setClassLoader(int r100, ClassLoader r101) {
        if (gClassLoaderMap != null) goto L5;
        gClassLoaderMap = new HashMap();
        TTPlayerPluginLoader.setPluginLoader(new AnonymousClass2());
    L5:
        gClassLoaderMap.put(Integer.valueOf(r100), r101);
    }
}
