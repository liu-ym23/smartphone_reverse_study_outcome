package com.facebook.common.executors;

import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes22.dex */
public interface HandlerExecutorService extends ScheduledExecutorService {
    boolean isHandlerThread();

    void quit();
}
