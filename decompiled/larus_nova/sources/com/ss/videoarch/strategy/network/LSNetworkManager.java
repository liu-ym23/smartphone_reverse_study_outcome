package com.ss.videoarch.strategy.network;

import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: classes38.dex */
public class LSNetworkManager {
    private static volatile LSNetworkManager sInstance;
    private LSSDKConfig mConfig;
    private ThreadPoolExecutor mCustomThreadPool;
    private HttpApi mHttpApi;
    private LSSettingsApi mSettingsApi;
    private final ThreadPoolApi mThreadPoolApi;

    public static LSNetworkManager inst() {
        if (sInstance != null) goto L15;
        monitor-enter(LSNetworkManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new LSNetworkManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(LSNetworkManager.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    public LSNetworkManager() {
        this.mThreadPoolApi = new ThreadPoolApi();
        init(new LSSDKConfig.Builder().build());
    }

    public ThreadPoolExecutor customThreadPool() {
        return this.mCustomThreadPool;
    }

    public LSSDKConfig getSDKConfig() {
        return this.mConfig;
    }

    public HttpApi httpApi() {
        return this.mHttpApi;
    }

    public LSSettingsApi settingsApi() {
        return this.mSettingsApi;
    }

    public ThreadPoolApi threadApi() {
        return this.mThreadPoolApi;
    }

    public void init(LSSDKConfig r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.mConfig = r100;
        HttpApi r101 = new HttpApi(r100);
        this.mHttpApi = r101;
        this.mSettingsApi = new LSSettingsApi(this.mThreadPoolApi, r101);
        this.mCustomThreadPool = r100.mCustomThreadPool;
        VeLSNetworkManagerImpl.getInstance().init(r100);
    }
}
