package com.bytedance.bdlocation.bridge;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public interface PlatformLoggerDelegate {
    Executor callbackExecutor();

    boolean isEnabled(int r1, String r2);

    void log(LogRecord r1);
}
