package com.ss.android.lark.framework.assembly.rust.component.task;

import com.bytedance.lark.rustclient.internal.l;
import com.bytedance.lark.rustclient.internal.m;
import dagger.internal.Factory;
import javax.inject.Provider;
import jjb.a;

/* JADX INFO: loaded from: classes36.dex */
public final class MakeRustBackgroundOfflineTask_Factory implements Factory<a> {
    private final Provider<l> dispatcherProvider;
    private final Provider<m> registryProvider;

    @Override // javax.inject.Provider
    public a get() {
        return newInstance(this.registryProvider.get(), this.dispatcherProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public MakeRustBackgroundOfflineTask_Factory(Provider<m> r100, Provider<l> r101) {
        this.registryProvider = r100;
        this.dispatcherProvider = r101;
    }

    public static MakeRustBackgroundOfflineTask_Factory create(Provider<m> r100, Provider<l> r101) {
        return new MakeRustBackgroundOfflineTask_Factory(r100, r101);
    }

    public static a newInstance(m r100, l r101) {
        return new a(r100, r101);
    }
}
