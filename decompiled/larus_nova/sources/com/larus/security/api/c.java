package com.larus.security.api;

import com.ss.android.ugc.quota.BDNetworkTagContextProviderAdapter;

/* JADX INFO: loaded from: classes31.dex */
public final class c extends BDNetworkTagContextProviderAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f367854a;

    public c() {
        this.f367854a = true;
    }

    @Override // com.ss.android.ugc.quota.BDNetworkTagContextProviderAdapter, com.ss.android.ugc.quota.IBDNetworkTagContextProvider
    public final int triggerType() {
        return !this.f367854a ? 1 : 0;
    }
}
