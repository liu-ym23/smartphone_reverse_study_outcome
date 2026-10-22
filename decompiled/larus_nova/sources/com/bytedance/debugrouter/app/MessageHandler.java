package com.bytedance.debugrouter.app;

import java.util.Map;

/* JADX INFO: loaded from: classes15.dex */
public interface MessageHandler {
    String getName();

    MessageHandleResult handle(Map<String, String> r100);
}
