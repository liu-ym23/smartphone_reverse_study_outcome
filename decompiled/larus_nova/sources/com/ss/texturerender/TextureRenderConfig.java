package com.ss.texturerender;

/* JADX INFO: loaded from: classes40.dex */
public class TextureRenderConfig {
    private static final String TAG = "TR_TextureRenderConfig";
    private static ITextureRenderPluginLoader gPluginLoader;

    public TextureRenderConfig() {
    }

    public static String getValue(int r100) {
        if (r100 == 24) goto L6;
        return "";
    L6:
        return BuildConfig.VERSION_NAME;
    }

    public static ClassLoader getClassLoader(int r100) {
        ITextureRenderPluginLoader r101 = gPluginLoader;
        if (r101 != null) goto L5;
        return null;
    L5:
        return r101.loadPlugin(r100);
    }

    public static void setClassLoaderCallback(ITextureRenderPluginLoader r100) {
        TextureRenderLog.i(-1, TAG, "setClassLoaderCallback");
        gPluginLoader = r100;
    }
}
