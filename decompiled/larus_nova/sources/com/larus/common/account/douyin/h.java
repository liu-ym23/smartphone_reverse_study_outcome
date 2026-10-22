package com.larus.common.account.douyin;

import com.ss.android.ugc.quota.BDNetworkTagContextProviderAdapter;

/* JADX INFO: loaded from: classes27.dex */
public final class h extends BDNetworkTagContextProviderAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f326071a;

    @Override // com.ss.android.ugc.quota.BDNetworkTagContextProviderAdapter, com.ss.android.ugc.quota.IBDNetworkTagContextProvider
    public final int triggerType() {
        return !this.f326071a ? 1 : 0;
    }

    @Override // com.ss.android.ugc.quota.BDNetworkTagContextProviderAdapter, com.ss.android.ugc.quota.IBDNetworkTagContextProvider
    public final boolean markAsNewUser() {
        return super.markAsNewUser();
    }

    public h(boolean r100) {
        this.f326071a = r100;
    }
}
