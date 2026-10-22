package com.bytedance.debugrouter.app;

/* JADX INFO: loaded from: classes15.dex */
public class DebugRouterEventSender {
    public DebugRouterEventSender() {
    }

    public static void send(String r100, MessageHandleResult r101) {
        com.lynx.debugrouter.app.DebugRouterEventSender.send(r100, new com.lynx.debugrouter.app.MessageHandleResult(r101.getCode(), r101.getMessage(), r101.getData()));
    }
}
