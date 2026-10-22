package com.suite.lark.platform.feature.forward.doubao.assembly;

import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes36.dex */
public final class DoubaoForwardProtocalModule_ProvideDoubaoForwardProtocalFactory implements Factory<mpc.e> {
    private final b module;

    @Override // javax.inject.Provider
    public mpc.e get() {
        return provideDoubaoForwardProtocal(this.module);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public DoubaoForwardProtocalModule_ProvideDoubaoForwardProtocalFactory(b r100) {
        this.module = r100;
    }

    public static DoubaoForwardProtocalModule_ProvideDoubaoForwardProtocalFactory create(b r100) {
        return new DoubaoForwardProtocalModule_ProvideDoubaoForwardProtocalFactory(r100);
    }

    public static mpc.e provideDoubaoForwardProtocal(b r100) {
        r100.getClass();
        Object r101 = (mpc.e) OfficeSDKManager.getHostGlobalService(mpc.e.class);
        if (r101 != null) goto L6;
        r101 = new c();
    L6:
        return (mpc.e) Preconditions.checkNotNullFromProvides(r101);
    }
}
