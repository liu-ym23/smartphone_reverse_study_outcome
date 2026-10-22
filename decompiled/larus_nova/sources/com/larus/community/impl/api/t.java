package com.larus.community.impl.api;

import android.util.Pair;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.intercept.Interceptor;
import com.ss.android.ugc.quota.BDNetworkTagContextProviderAdapter;
import com.ss.android.ugc.quota.BDNetworkTagManager;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes4.dex */
public final class t implements Interceptor {

    public static final class a extends BDNetworkTagContextProviderAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ t f328830a;

        @Override // com.ss.android.ugc.quota.BDNetworkTagContextProviderAdapter, com.ss.android.ugc.quota.IBDNetworkTagContextProvider
        public final int triggerType() {
            this.f328830a.getClass();
            return 0;
        }

        @Override // com.ss.android.ugc.quota.BDNetworkTagContextProviderAdapter, com.ss.android.ugc.quota.IBDNetworkTagContextProvider
        public final boolean markAsNewUser() {
            return super.markAsNewUser();
        }

        public a(t r100) {
            this.f328830a = r100;
        }
    }

    public t() {
    }

    @Override // com.bytedance.retrofit2.intercept.Interceptor
    public final SsResponse<?> intercept(Interceptor.Chain r100) {
        Pair<String, String> r101 = BDNetworkTagManager.getInstance().buildBDNetworkTag(new a(this));
        if (r100 == null) goto L9;
        Request r102 = r100.request();
        if (r102 == null) goto L11;
        Request.Builder r103 = r102.newBuilder();
        List<Header> r104 = CollectionsKt.toMutableList(r102.getHeaders());
        r104.add(new Header((String) r101.first, (String) r101.second));
        r103.headers(r104);
        return r100.proceed(r103.build());
    L11:
        return null;
    L9:
        return null;
    }
}
