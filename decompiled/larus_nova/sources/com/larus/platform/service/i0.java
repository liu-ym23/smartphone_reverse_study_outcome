package com.larus.platform.service;

import com.larus.platform.api.ISdkDouyinAuth;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;

/* JADX INFO: loaded from: classes31.dex */
public final class i0 {
    static {
    }

    public static ISdkDouyinAuth a() {
        return (ISdkDouyinAuth) ServiceManager.get().getService(ISdkDouyinAuth.class);
    }
}
