package com.bytedance.lynx.webview.glue.sdk113;

import android.os.Bundle;

/* JADX INFO: loaded from: classes21.dex */
public interface ITTWebPluginManagersdk113 {

    public interface Listenersdk113 {
        boolean onInfo(int r100, String r101, Bundle r102);
    }

    void destroyPreCreatePlugin(int r100);

    boolean execute(String r100, Bundle r101);

    int getMaxAllowPreCreate();

    int preCreatePlugin(String r100, String r101);

    void registerListener(Object r100);

    void setMaxAllowPreCreate(int r100);

    void unregisterListener(Object r100);
}
