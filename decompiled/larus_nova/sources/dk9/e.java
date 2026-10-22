package dk9;

import com.ss.android.ugc.quota.BDNetworkTagContextProviderAdapter;

/* JADX INFO: loaded from: classes30.dex */
public final class e extends BDNetworkTagContextProviderAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f469047a;

    public e() {
        this.f469047a = true;
    }

    @Override // com.ss.android.ugc.quota.BDNetworkTagContextProviderAdapter, com.ss.android.ugc.quota.IBDNetworkTagContextProvider
    public final int triggerType() {
        return !this.f469047a ? 1 : 0;
    }

    @Override // com.ss.android.ugc.quota.BDNetworkTagContextProviderAdapter, com.ss.android.ugc.quota.IBDNetworkTagContextProvider
    public final boolean markAsNewUser() {
        return super.markAsNewUser();
    }
}
