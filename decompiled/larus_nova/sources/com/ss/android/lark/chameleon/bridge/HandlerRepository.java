package com.ss.android.lark.chameleon.bridge;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes35.dex */
public class HandlerRepository {
    public Map<String, BridgeHandler> handlers;

    public HandlerRepository() {
        this.handlers = new ConcurrentHashMap();
    }
}
