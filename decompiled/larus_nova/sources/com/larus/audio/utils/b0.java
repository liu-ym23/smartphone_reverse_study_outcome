package com.larus.audio.utils;

import com.ss.android.ugc.quota.BDNetworkTagContextProviderAdapter;

/* JADX INFO: loaded from: classes4.dex */
public final class b0 extends BDNetworkTagContextProviderAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f290018a;

    @Override // com.ss.android.ugc.quota.BDNetworkTagContextProviderAdapter, com.ss.android.ugc.quota.IBDNetworkTagContextProvider
    public final int triggerType() {
        return !this.f290018a ? 1 : 0;
    }

    @Override // com.ss.android.ugc.quota.BDNetworkTagContextProviderAdapter, com.ss.android.ugc.quota.IBDNetworkTagContextProvider
    public final boolean markAsNewUser() {
        return super.markAsNewUser();
    }

    public b0(boolean r100) {
        this.f290018a = r100;
    }
}
