package com.ss.android.lark.officesdk.feed.impl;

import com.bytedance.lark.rustclient.api.l;
import com.bytedance.lark.sdk.refactor.n;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes37.dex */
public final class FeedOfficeSdkServiceImpl_Factory implements Factory<FeedOfficeSdkServiceImpl> {
    private final Provider<l> rustClientProvider;
    private final Provider<n> rustSdkProvider;
    private final Provider<String> userIdProvider;

    @Override // javax.inject.Provider
    public FeedOfficeSdkServiceImpl get() {
        return newInstance(this.userIdProvider.get(), this.rustSdkProvider.get(), this.rustClientProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public FeedOfficeSdkServiceImpl_Factory(Provider<String> r100, Provider<n> r101, Provider<l> r102) {
        this.userIdProvider = r100;
        this.rustSdkProvider = r101;
        this.rustClientProvider = r102;
    }

    public static FeedOfficeSdkServiceImpl_Factory create(Provider<String> r100, Provider<n> r101, Provider<l> r102) {
        return new FeedOfficeSdkServiceImpl_Factory(r100, r101, r102);
    }

    public static FeedOfficeSdkServiceImpl newInstance(String r100, n r101, l r102) {
        return new FeedOfficeSdkServiceImpl(r100, r101, r102);
    }
}
