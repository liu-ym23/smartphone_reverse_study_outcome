package com.ss.android.lark.framework.assembly.appcontext;

import com.ss.android.lark.appcontext.applifecycle.z;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes36.dex */
public final class InitAppLifecycleTask_Factory implements Factory<InitAppLifecycleTask> {
    private final Provider<z> dependencyProvider;

    @Override // javax.inject.Provider
    public InitAppLifecycleTask get() {
        return newInstance(this.dependencyProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public InitAppLifecycleTask_Factory(Provider<z> r100) {
        this.dependencyProvider = r100;
    }

    public static InitAppLifecycleTask_Factory create(Provider<z> r100) {
        return new InitAppLifecycleTask_Factory(r100);
    }

    public static InitAppLifecycleTask newInstance(z r100) {
        return new InitAppLifecycleTask(r100);
    }
}
