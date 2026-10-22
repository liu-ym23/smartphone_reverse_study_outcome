package com.bytedance.ee.bear.docs;

import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;
import tz4.b;
import x05.a;

/* JADX INFO: loaded from: classes16.dex */
public final class DocsHistoryDomainModule_ProvideDocsHistoryDomainDependencyFactory implements Factory<a> {
    private final b module;
    private final Provider<String> uidProvider;

    @Override // javax.inject.Provider
    public a get() {
        return provideDocsHistoryDomainDependency(this.module, this.uidProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public DocsHistoryDomainModule_ProvideDocsHistoryDomainDependencyFactory(b r100, Provider<String> r101) {
        this.module = r100;
        this.uidProvider = r101;
    }

    public static DocsHistoryDomainModule_ProvideDocsHistoryDomainDependencyFactory create(b r100, Provider<String> r101) {
        return new DocsHistoryDomainModule_ProvideDocsHistoryDomainDependencyFactory(r100, r101);
    }

    public static a provideDocsHistoryDomainDependency(b r100, String r101) {
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "uid");
        Object r102 = (a) OfficeSDKManager.getHostUserService(r101, a.class);
        if (r102 != null) goto L6;
        r102 = new tz4.a();
    L6:
        return (a) Preconditions.checkNotNullFromProvides(r102);
    }
}
