package com.lynx.devtoolwrapper;

import com.lynx.react.bridge.Callback;

/* JADX INFO: loaded from: classes32.dex */
public interface LynxBaseInspectorOwner {
    void addCDPEventListener(String r100, CDPEventListener r101);

    void getConsoleObject(String r100, boolean r101, Callback r102);

    void invokeCDPFromSDK(String r100, CDPResultCallback r101);

    void registerGlobalPropsUpdatedObserver(GlobalPropsObserver r100);

    void reload(boolean r100);

    void reload(boolean r100, String r101, boolean r102, int r103);

    void removeCDPEventListener(String r100);

    void setDebugTag(String r100);

    void setLynxInspectorConsoleDelegate(Object r100);
}
