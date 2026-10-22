package com.lynx.canvas;

/* JADX INFO: loaded from: classes32.dex */
public abstract class KryptonPluginLoaderService extends KryptonService {

    public interface Callback {
        void onFinish(boolean r100, String r101);
    }

    public abstract ClassLoader getClassLoader(String r100);

    public abstract String getPluginPath(String r100);

    public abstract void loadPluginAsync(String r100, Callback r101);

    public abstract boolean loadPluginSync(String r100);

    public KryptonPluginLoaderService() {
    }
}
