package com.ss.android.lark.framework.assembly.rust;

import com.ss.android.lark.rustinfrabridge.appstatesync.service.IAppStateSyncService;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes36.dex */
public final class InitImSdkTask_Factory implements Factory<InitImSdkTask> {
    private final Provider<IAppStateSyncService> appStateSyncServiceProvider;
    private final Provider<epb.a> deviceIdApiProvider;
    private final Provider<c3c.d.b> perfBoostDispatcherProvider;
    private final Provider<c3c.d.InterfaceC0400d> preloadDependencyProvider;
    private final Provider<com.bytedance.lark.sdk.refactor.n> rustSDKProvider;

    @Override // javax.inject.Provider
    public InitImSdkTask get() {
        return newInstance(this.appStateSyncServiceProvider, this.rustSDKProvider, this.perfBoostDispatcherProvider, this.preloadDependencyProvider, this.deviceIdApiProvider);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public InitImSdkTask_Factory(Provider<IAppStateSyncService> r100, Provider<com.bytedance.lark.sdk.refactor.n> r101, Provider<c3c.d.b> r102, Provider<c3c.d.InterfaceC0400d> r103, Provider<epb.a> r104) {
        this.appStateSyncServiceProvider = r100;
        this.rustSDKProvider = r101;
        this.perfBoostDispatcherProvider = r102;
        this.preloadDependencyProvider = r103;
        this.deviceIdApiProvider = r104;
    }

    public static InitImSdkTask_Factory create(Provider<IAppStateSyncService> r100, Provider<com.bytedance.lark.sdk.refactor.n> r101, Provider<c3c.d.b> r102, Provider<c3c.d.InterfaceC0400d> r110, Provider<epb.a> r111) {
        return new InitImSdkTask_Factory(r100, r101, r102, r110, r111);
    }

    public static InitImSdkTask newInstance(Provider<IAppStateSyncService> r100, Provider<com.bytedance.lark.sdk.refactor.n> r101, Provider<c3c.d.b> r102, Provider<c3c.d.InterfaceC0400d> r110, Provider<epb.a> r111) {
        return new InitImSdkTask(r100, r101, r102, r110, r111);
    }
}
