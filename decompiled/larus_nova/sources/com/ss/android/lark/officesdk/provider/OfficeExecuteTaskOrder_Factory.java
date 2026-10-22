package com.ss.android.lark.officesdk.provider;

import dagger.internal.Factory;
import java.util.Set;
import javax.inject.Provider;
import nwb.b;
import nwb.f;

/* JADX INFO: loaded from: classes37.dex */
public final class OfficeExecuteTaskOrder_Factory implements Factory<f> {
    private final Provider<Set<b>> taskOrderInjectorsProvider;

    @Override // javax.inject.Provider
    public f get() {
        return newInstance(this.taskOrderInjectorsProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public OfficeExecuteTaskOrder_Factory(Provider<Set<b>> r100) {
        this.taskOrderInjectorsProvider = r100;
    }

    public static OfficeExecuteTaskOrder_Factory create(Provider<Set<b>> r100) {
        return new OfficeExecuteTaskOrder_Factory(r100);
    }

    public static f newInstance(Set<b> r100) {
        return new f(r100);
    }
}
