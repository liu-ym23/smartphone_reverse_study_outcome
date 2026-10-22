package com.larus.network.quota;

import android.app.Application;
import com.larus.common.apphost.AppHost;
import com.ss.android.ugc.quota.IBDNetworkTagConfig;
import ghc.a;
import jm9.e;
import jm9.f;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/larus/network/quota/BDNetworkTagConfigImpl;", "Lcom/ss/android/ugc/quota/IBDNetworkTagConfig;", "<init>", "()V", "getApplication", "Landroid/app/Application;", "getTagDepend", "Lcom/ss/android/ugc/quota/IBDNetworkTagDepend;", "ttnet_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BDNetworkTagConfigImpl implements IBDNetworkTagConfig {
    public BDNetworkTagConfigImpl() {
    }

    @Override // com.ss.android.ugc.quota.IBDNetworkTagConfig
    public final a a() {
        int r100 = f.f499712a;
        Intrinsics.checkNotNullParameter("open", "lazyType");
        return new e();
    }

    @Override // com.ss.android.ugc.quota.IBDNetworkTagConfig
    public final Application getApplication() {
        return AppHost.f326268a.getApplication();
    }
}
