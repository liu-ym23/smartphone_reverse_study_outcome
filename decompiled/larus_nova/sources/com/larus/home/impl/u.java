package com.larus.home.impl;

import android.util.Pair;
import com.ss.android.ugc.quota.BDNetworkTagContextProviderAdapter;
import com.ss.android.ugc.quota.BDNetworkTagManager;

/* JADX INFO: loaded from: classes29.dex */
public final class u implements z1a.h {

    public static final class a extends BDNetworkTagContextProviderAdapter {
        @Override // com.ss.android.ugc.quota.BDNetworkTagContextProviderAdapter, com.ss.android.ugc.quota.IBDNetworkTagContextProvider
        public final int triggerType() {
            return 0;
        }

        public a() {
        }
    }

    public u() {
    }

    @Override // z1a.h
    public final Pair<String, String> getRequestTagHeader() {
        return BDNetworkTagManager.getInstance().buildBDNetworkTag(new a());
    }
}
