package com.ss.android.lark.officesdk.launcher;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes37.dex */
public final class OfficeSdkInitiatorFactory_Factory implements Factory<g> {
    private final Provider<com.ss.android.lark.app.initiator.d> mainProcessInitiatorProvider;

    @Override // javax.inject.Provider
    public g get() {
        return newInstance(this.mainProcessInitiatorProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public OfficeSdkInitiatorFactory_Factory(Provider<com.ss.android.lark.app.initiator.d> r100) {
        this.mainProcessInitiatorProvider = r100;
    }

    public static OfficeSdkInitiatorFactory_Factory create(Provider<com.ss.android.lark.app.initiator.d> r100) {
        return new OfficeSdkInitiatorFactory_Factory(r100);
    }

    public static g newInstance(com.ss.android.lark.app.initiator.d r100) {
        return new g(r100);
    }
}
