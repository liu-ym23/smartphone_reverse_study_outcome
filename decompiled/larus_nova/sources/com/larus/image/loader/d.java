package com.larus.image.loader;

import com.facebook.net.FrescoTTNetFetcher;

/* JADX INFO: loaded from: classes4.dex */
public final class d implements FrescoTTNetFetcher.FetcherInterceptorProvider {
    public d() {
    }

    @Override // com.facebook.net.FrescoTTNetFetcher.FetcherInterceptorProvider
    public final FrescoTTNetFetcher.FetcherInterceptor getInterceptor() {
        return DefaultRenewInterceptor.f350947a;
    }
}
