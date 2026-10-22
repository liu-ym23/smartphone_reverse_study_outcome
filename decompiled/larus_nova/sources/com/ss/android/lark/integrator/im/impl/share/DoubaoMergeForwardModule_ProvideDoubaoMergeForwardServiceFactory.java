package com.ss.android.lark.integrator.im.impl.share;

import cnb.a;
import cnb.b;
import com.ss.android.lark.biz.im.api.r;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes36.dex */
public final class DoubaoMergeForwardModule_ProvideDoubaoMergeForwardServiceFactory implements Factory<r> {
    private final b module;

    @Override // javax.inject.Provider
    public r get() {
        return provideDoubaoMergeForwardService(this.module);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public DoubaoMergeForwardModule_ProvideDoubaoMergeForwardServiceFactory(b r100) {
        this.module = r100;
    }

    public static DoubaoMergeForwardModule_ProvideDoubaoMergeForwardServiceFactory create(b r100) {
        return new DoubaoMergeForwardModule_ProvideDoubaoMergeForwardServiceFactory(r100);
    }

    public static r provideDoubaoMergeForwardService(b r100) {
        r100.getClass();
        Object r101 = (r) OfficeSDKManager.getHostGlobalService(r.class);
        if (r101 != null) goto L6;
        r101 = new a();
    L6:
        return (r) Preconditions.checkNotNullFromProvides(r101);
    }
}
