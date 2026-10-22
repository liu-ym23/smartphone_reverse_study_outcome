package com.lynx.debugrouter.app;

import java.util.Map;

/* JADX INFO: loaded from: classes32.dex */
public interface MessageHandler {
    String getName();

    MessageHandleResult handle(Map<String, String> r100);
}
