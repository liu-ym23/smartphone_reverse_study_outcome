package com.bytedance.ee.bear.docs;

import com.bytedance.ee.bear.init.b;
import com.ss.android.lark.passportc.api.m;
import dagger.internal.Factory;
import javax.inject.Provider;
import s45.f;
import t45.c;
import x05.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class UserDocsSdkImpl_Factory implements Factory<UserDocsSdkImpl> {
    private final Provider<a> docsHistoryDomainDependencyProvider;
    private final Provider<f> domainConfigParserProvider;
    private final Provider<com.bytedance.ee.bear.init.a> officeCCMGlobalInitProvider;
    private final Provider<b> officeCCMUserInitProvider;
    private final Provider<m> passportUserServiceProvider;
    private final Provider<c> spaceKitUrlHelperProvider;

    public UserDocsSdkImpl get() {
        return newInstance((m) this.passportUserServiceProvider.get(), (com.bytedance.ee.bear.init.a) this.officeCCMGlobalInitProvider.get(), (b) this.officeCCMUserInitProvider.get(), (f) this.domainConfigParserProvider.get(), (c) this.spaceKitUrlHelperProvider.get(), (a) this.docsHistoryDomainDependencyProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m164get() {
        return get();
    }

    public UserDocsSdkImpl_Factory(Provider<m> r1, Provider<com.bytedance.ee.bear.init.a> r2, Provider<b> r3, Provider<f> r4, Provider<c> r5, Provider<a> r6) {
        this.passportUserServiceProvider = r1;
        this.officeCCMGlobalInitProvider = r2;
        this.officeCCMUserInitProvider = r3;
        this.domainConfigParserProvider = r4;
        this.spaceKitUrlHelperProvider = r5;
        this.docsHistoryDomainDependencyProvider = r6;
    }

    public static UserDocsSdkImpl_Factory create(Provider<m> r8, Provider<com.bytedance.ee.bear.init.a> r9, Provider<b> r10, Provider<f> r11, Provider<c> r12, Provider<a> r13) {
        return new UserDocsSdkImpl_Factory(r8, r9, r10, r11, r12, r13);
    }

    public static UserDocsSdkImpl newInstance(m r8, com.bytedance.ee.bear.init.a r9, b r10, f r11, c r12, a r13) {
        return new UserDocsSdkImpl(r8, r9, r10, r11, r12, r13);
    }
}
