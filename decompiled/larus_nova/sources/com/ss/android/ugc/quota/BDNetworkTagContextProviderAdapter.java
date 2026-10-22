package com.ss.android.ugc.quota;

import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class BDNetworkTagContextProviderAdapter implements IBDNetworkTagContextProvider {
    public BDNetworkTagContextProviderAdapter() {
    }

    @Override // com.ss.android.ugc.quota.IBDNetworkTagContextProvider
    public Map<String, Object> extra() {
        return null;
    }

    @Override // com.ss.android.ugc.quota.IBDNetworkTagContextProvider
    public int triggerType() {
        return 1;
    }

    @Override // com.ss.android.ugc.quota.IBDNetworkTagContextProvider
    public int launchType() {
        int r100 = BDNetworkTagManager.getInstance().currentLaunchType();
        if (r100 != (-999)) goto L5;
    L14:
        return r100;
    L5:
        if (r100 == (-1)) goto L14;
        if (r100 == 0) goto L14;
        if (r100 == 1) goto L14;
        if (r100 == 2) goto L14;
        throw new IllegalStateException("BDNetworkTagManager#updateLaunchType should be called while launch type changed");
    }

    @Override // com.ss.android.ugc.quota.IBDNetworkTagContextProvider
    public boolean markAsNewUser() {
        return BDNetworkTagManager.getInstance().isFirstInstallLaunch();
    }
}
