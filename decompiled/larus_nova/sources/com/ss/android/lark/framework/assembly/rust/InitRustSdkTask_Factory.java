package com.ss.android.lark.framework.assembly.rust;

import com.ss.android.lark.rustinfrabridge.appstatesync.service.IAppStateSyncService;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes36.dex */
public final class InitRustSdkTask_Factory implements Factory<InitRustSdkTask> {
    private final Provider<IAppStateSyncService> appStateSyncServiceProvider;
    private final Provider<com.bytedance.lark.sdk.refactor.n> rustSDKProvider;

    @Override // javax.inject.Provider
    public InitRustSdkTask get() {
        return newInstance(this.rustSDKProvider, this.appStateSyncServiceProvider);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public InitRustSdkTask_Factory(Provider<com.bytedance.lark.sdk.refactor.n> r100, Provider<IAppStateSyncService> r101) {
        this.rustSDKProvider = r100;
        this.appStateSyncServiceProvider = r101;
    }

    public static InitRustSdkTask_Factory create(Provider<com.bytedance.lark.sdk.refactor.n> r100, Provider<IAppStateSyncService> r101) {
        return new InitRustSdkTask_Factory(r100, r101);
    }

    public static InitRustSdkTask newInstance(Provider<com.bytedance.lark.sdk.refactor.n> r100, Provider<IAppStateSyncService> r101) {
        return new InitRustSdkTask(r100, r101);
    }
}
