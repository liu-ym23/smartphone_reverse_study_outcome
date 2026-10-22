package com.facebook.common.executors;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: classes22.dex */
public class UiThreadImmediateExecutorService extends HandlerExecutorServiceImpl {
    private static UiThreadImmediateExecutorService sInstance;

    private UiThreadImmediateExecutorService() {
        super(new Handler(Looper.getMainLooper()));
    }

    public static UiThreadImmediateExecutorService getInstance() {
        if (sInstance != null) goto L6;
        sInstance = new UiThreadImmediateExecutorService();
    L6:
        return sInstance;
    }

    @Override // com.facebook.common.executors.HandlerExecutorServiceImpl, java.util.concurrent.Executor
    public void execute(Runnable r100) {
        if (isHandlerThread() == false) goto L5;
        r100.run();
        return;
    L5:
        super.execute(r100);
    }
}
