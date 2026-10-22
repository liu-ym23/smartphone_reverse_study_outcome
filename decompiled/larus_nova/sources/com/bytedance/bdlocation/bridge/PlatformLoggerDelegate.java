package com.bytedance.bdlocation.bridge;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes10.dex */
public interface PlatformLoggerDelegate {
    Executor callbackExecutor();

    boolean isEnabled(int r100, String r101);

    void log(LogRecord r100);
}
