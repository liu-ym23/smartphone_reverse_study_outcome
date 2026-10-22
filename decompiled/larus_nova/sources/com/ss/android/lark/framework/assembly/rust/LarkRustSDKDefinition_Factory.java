package com.ss.android.lark.framework.assembly.rust;

import dagger.internal.Factory;
import java.util.Set;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes36.dex */
public final class LarkRustSDKDefinition_Factory implements Factory<o> {
    private final Provider<Set<te6.b>> observersProvider;
    private final Provider<x> onlineResponseObserverInternalProvider;

    @Override // javax.inject.Provider
    public o get() {
        o r100 = newInstance(this.observersProvider.get());
        r100.f425705c = this.onlineResponseObserverInternalProvider.get();
        return r100;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public static o newInstance(Set<te6.b> r100) {
        return new o(r100);
    }

    public LarkRustSDKDefinition_Factory(Provider<Set<te6.b>> r100, Provider<x> r101) {
        this.observersProvider = r100;
        this.onlineResponseObserverInternalProvider = r101;
    }

    public static LarkRustSDKDefinition_Factory create(Provider<Set<te6.b>> r100, Provider<x> r101) {
        return new LarkRustSDKDefinition_Factory(r100, r101);
    }
}
