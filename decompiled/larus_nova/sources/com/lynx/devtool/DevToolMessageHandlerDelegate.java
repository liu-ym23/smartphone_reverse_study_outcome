package com.lynx.devtool;

import com.lynx.devtoolwrapper.MessageHandler;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes32.dex */
public class DevToolMessageHandlerDelegate {
    private WeakReference<MessageHandler> handlerRef;

    public DevToolMessageHandlerDelegate(MessageHandler r100) {
        this.handlerRef = new WeakReference(r100);
    }

    public void onMessage(String r100) {
        MessageHandler r101 = this.handlerRef.get();
        if (r101 == null) goto L6;
        r101.onMessage(r100);
        return;
    }
}
