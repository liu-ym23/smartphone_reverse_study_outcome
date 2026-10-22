package com.bytedance.lynx.webview.glue;

import com.bytedance.lynx.webview.glue.sdk113.ITTWebPluginManagersdk113;

/* JADX INFO: loaded from: classes21.dex */
public interface ITTWebPluginManager extends ITTWebPluginManagersdk113 {

    public interface Listener extends ITTWebPluginManagersdk113.Listenersdk113 {
    }

    void registerListener(Listener r100);

    void unregisterListener(Listener r100);
}
