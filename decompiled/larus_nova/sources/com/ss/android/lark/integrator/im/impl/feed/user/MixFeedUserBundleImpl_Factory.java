package com.ss.android.lark.integrator.im.impl.feed.user;

import com.bytedance.lark.rustclient.api.l;
import com.ss.android.lark.feed.shared.page.t;
import com.ss.android.lark.feed.shared.page.u;
import com.ss.android.lark.flow.feed.data.a;
import com.ss.android.lark.passportc.api.m;
import dagger.internal.Factory;
import javax.inject.Provider;
import vmb.b;

/* JADX INFO: loaded from: classes36.dex */
public final class MixFeedUserBundleImpl_Factory implements Factory<b> {
    private final Provider<a> doubaoFeedMigrateStatusProvider;
    private final Provider<t> feedItemsViewModelFactoryProvider;
    private final Provider<u> feedSidebarItemsViewModelFactoryProvider;
    private final Provider<m> passportProvider;
    private final Provider<l> rustClientProvider;

    @Override // javax.inject.Provider
    public b get() {
        return newInstance(this.passportProvider.get(), this.rustClientProvider.get(), this.feedItemsViewModelFactoryProvider.get(), this.feedSidebarItemsViewModelFactoryProvider.get(), this.doubaoFeedMigrateStatusProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public MixFeedUserBundleImpl_Factory(Provider<m> r100, Provider<l> r101, Provider<t> r102, Provider<u> r103, Provider<a> r104) {
        this.passportProvider = r100;
        this.rustClientProvider = r101;
        this.feedItemsViewModelFactoryProvider = r102;
        this.feedSidebarItemsViewModelFactoryProvider = r103;
        this.doubaoFeedMigrateStatusProvider = r104;
    }

    public static MixFeedUserBundleImpl_Factory create(Provider<m> r100, Provider<l> r101, Provider<t> r102, Provider<u> r110, Provider<a> r111) {
        return new MixFeedUserBundleImpl_Factory(r100, r101, r102, r110, r111);
    }

    public static b newInstance(m r100, l r101, t r102, u r110, a r111) {
        return new b(r100, r101, r102, r110, r111);
    }
}
