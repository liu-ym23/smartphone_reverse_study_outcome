package com.bytedance.map.api.plugin;

import android.content.Context;

/* JADX INFO: loaded from: classes21.dex */
public interface IMapPluginSpiService {

    /* JADX INFO: renamed from: com.bytedance.map.api.plugin.IMapPluginSpiService$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$ensurePluginReady(IMapPluginSpiService r100, Context r101, MapPluginActionListener r102) {
            r100.ensurePluginReady(r101, true, r102);
        }
    }

    void ensurePluginReady(Context r100, MapPluginActionListener r101);

    void ensurePluginReady(Context r100, boolean r101, MapPluginActionListener r102);

    boolean isPluginReady();
}
