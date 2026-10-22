package com.bytedance.ee.bear.docs;

import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;
import tz4.b;
import x05.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class DocsHistoryDomainModule_ProvideDocsHistoryDomainDependencyFactory implements Factory<a> {
    private final b module;
    private final Provider<String> uidProvider;

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public a m162get() {
        return provideDocsHistoryDomainDependency(this.module, (String) this.uidProvider.get());
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m162get();
    }

    public DocsHistoryDomainModule_ProvideDocsHistoryDomainDependencyFactory(b r1, Provider<String> r2) {
        this.module = r1;
        this.uidProvider = r2;
    }

    public static DocsHistoryDomainModule_ProvideDocsHistoryDomainDependencyFactory create(b r1, Provider<String> r2) {
        return new DocsHistoryDomainModule_ProvideDocsHistoryDomainDependencyFactory(r1, r2);
    }

    public static a provideDocsHistoryDomainDependency(b r0, String r1) {
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "uid");
        Object r2 = (a) OfficeSDKManager.getHostUserService(r1, a.class);
        if (r2 != null) goto L6;
        r2 = new tz4.a();
    L6:
        return (a) Preconditions.checkNotNullFromProvides(r2);
    }
}
