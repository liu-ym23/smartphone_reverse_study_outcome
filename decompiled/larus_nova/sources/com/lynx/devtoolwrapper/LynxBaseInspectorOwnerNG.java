package com.lynx.devtoolwrapper;

/* JADX INFO: loaded from: classes32.dex */
public interface LynxBaseInspectorOwnerNG extends LynxBaseInspectorOwner {
    void sendMessage(CustomizedMessage r100);

    void subscribeMessage(String r100, MessageHandler r101);

    void unsubscribeMessage(String r100);
}
