package com.huawei.hms.framework.common;

import android.content.Context;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes23.dex */
public class AssetsUtil {
    private static final ExecutorService EXECUTOR_SERVICE = null;
    private static final int GET_SP_TIMEOUT = 5;
    private static final String TAG = "AssetsUtil";
    private static final String THREAD_NAME = "AssetsUtil_Operate";

    public AssetsUtil() {
    }

    static {
        EXECUTOR_SERVICE = ExecutorsUtils.newSingleThreadExecutor(THREAD_NAME);
    }

    public static String[] list(final Context r100, final String r101) {
        if (r100 != null) goto L6;
        Logger.w(TAG, "context is null");
        return new String[0];
    L6:
        FutureTask r102 = new FutureTask(new AnonymousClass1(r100, r101));
        EXECUTOR_SERVICE.execute(r102);
        String[] r103 = (String[]) r102.get(5, TimeUnit.SECONDS);     // Catch: Throwable -> L10 Exception -> L12 TimeoutException -> L15 ExecutionException -> L18 InterruptedException -> L22
        r102.cancel(true);
        return r103;
    L10:
        th = move-exception;
        r102.cancel(true);
        throw th;
    L15:
        Logger.w(TAG, "get local config files from sp task timed out");     // Catch: Throwable -> L10
        String[] r104 = new String[0];     // Catch: Throwable -> L10
        r102.cancel(true);
        return r104;
    L12:
        Logger.w(TAG, "get local config files from sp task occur unknown Exception");     // Catch: Throwable -> L10
        String[] r105 = new String[0];     // Catch: Throwable -> L10
        r102.cancel(true);
        return r105;
    L22:
        e = move-exception;
        Logger.w(TAG, "get local config files from sp task interrupted", e);     // Catch: Throwable -> L10
        String[] r106 = new String[0];     // Catch: Throwable -> L10
        r102.cancel(true);
        return r106;
    L18:
        e = move-exception;
        Logger.w(TAG, "get local config files from sp task failed", e);     // Catch: Throwable -> L10
        String[] r107 = new String[0];     // Catch: Throwable -> L10
        r102.cancel(true);
        return r107;
    }

    public static InputStream open(Context r100, String r101) throws IOException {
        if (r100 != null) goto L12;
        Logger.w(TAG, "context is null");
        return null;
    L12:
        return r100.getAssets().open(r101);
    L9:
        e = move-exception;
        Logger.e(TAG, "AssetManager has been destroyed", e);
        return null;
    }
}
