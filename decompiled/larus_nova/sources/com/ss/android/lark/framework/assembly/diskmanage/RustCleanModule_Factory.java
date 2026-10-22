package com.ss.android.lark.framework.assembly.diskmanage;

import com.bytedance.lark.rustclient.api.h;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes36.dex */
public final class RustCleanModule_Factory implements Factory<RustCleanModule> {
    private final Provider<h> rustClientProvider;

    @Override // javax.inject.Provider
    public RustCleanModule get() {
        return newInstance(this.rustClientProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public RustCleanModule_Factory(Provider<h> r100) {
        this.rustClientProvider = r100;
    }

    public static RustCleanModule_Factory create(Provider<h> r100) {
        return new RustCleanModule_Factory(r100);
    }

    public static RustCleanModule newInstance(h r100) {
        return new RustCleanModule(r100);
    }
}
