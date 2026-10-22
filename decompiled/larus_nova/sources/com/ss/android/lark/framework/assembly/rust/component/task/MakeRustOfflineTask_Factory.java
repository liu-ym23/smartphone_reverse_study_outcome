package com.ss.android.lark.framework.assembly.rust.component.task;

import com.bytedance.lark.rustclient.internal.l;
import com.bytedance.lark.rustclient.internal.m;
import com.bytedance.lark.sdk.refactor.n;
import dagger.internal.Factory;
import javax.inject.Provider;
import jjb.e;

/* JADX INFO: loaded from: classes36.dex */
public final class MakeRustOfflineTask_Factory implements Factory<e> {
    private final Provider<l> dispatcherProvider;
    private final Provider<m> registryProvider;
    private final Provider<n> rustSdkProvider;

    @Override // javax.inject.Provider
    public e get() {
        return newInstance(this.registryProvider.get(), this.dispatcherProvider.get(), this.rustSdkProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public MakeRustOfflineTask_Factory(Provider<m> r100, Provider<l> r101, Provider<n> r102) {
        this.registryProvider = r100;
        this.dispatcherProvider = r101;
        this.rustSdkProvider = r102;
    }

    public static MakeRustOfflineTask_Factory create(Provider<m> r100, Provider<l> r101, Provider<n> r102) {
        return new MakeRustOfflineTask_Factory(r100, r101, r102);
    }

    public static e newInstance(m r100, l r101, n r102) {
        return new e(r100, r101, r102);
    }
}
