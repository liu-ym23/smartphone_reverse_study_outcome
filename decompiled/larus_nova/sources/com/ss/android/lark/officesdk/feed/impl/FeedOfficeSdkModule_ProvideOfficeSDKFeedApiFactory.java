package com.ss.android.lark.officesdk.feed.impl;

import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes37.dex */
public final class FeedOfficeSdkModule_ProvideOfficeSDKFeedApiFactory implements Factory<qtb.b> {
    private final b module;

    @Override // javax.inject.Provider
    public qtb.b get() {
        return provideOfficeSDKFeedApi(this.module);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public FeedOfficeSdkModule_ProvideOfficeSDKFeedApiFactory(b r100) {
        this.module = r100;
    }

    public static FeedOfficeSdkModule_ProvideOfficeSDKFeedApiFactory create(b r100) {
        return new FeedOfficeSdkModule_ProvideOfficeSDKFeedApiFactory(r100);
    }

    public static qtb.b provideOfficeSDKFeedApi(b r100) {
        r100.getClass();
        return (qtb.b) Preconditions.checkNotNullFromProvides(new FlowFeedApiProxy());
    }
}
