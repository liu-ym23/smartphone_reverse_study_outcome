package x74;

import com.ss.android.ugc.quota.BDNetworkTagContextProviderAdapter;

/* JADX INFO: loaded from: classes8.dex */
public final class a extends BDNetworkTagContextProviderAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f562821a;

    @Override // com.ss.android.ugc.quota.BDNetworkTagContextProviderAdapter, com.ss.android.ugc.quota.IBDNetworkTagContextProvider
    public final int triggerType() {
        return 0;
    }

    @Override // com.ss.android.ugc.quota.BDNetworkTagContextProviderAdapter, com.ss.android.ugc.quota.IBDNetworkTagContextProvider
    public final boolean markAsNewUser() {
        return !this.f562821a;
    }

    public a(boolean r100) {
        this.f562821a = r100;
    }
}
