package com.bytedance.android.livesdk.live_cache_pool;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livehostapi.business.IHostBusiness;
import com.bytedance.android.livesdkapi.service.ILiveCachePoolService;
import jc1.k;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/live_cache_pool/LiveCachePoolManagerService;", "Lcom/bytedance/android/livesdkapi/service/ILiveCachePoolService;", "()V", "init", "", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveCachePoolManagerService implements ILiveCachePoolService {
    public void init() {
        ALogger.i("LiveCachePool", "service init()");
    }

    public LiveCachePoolManagerService() {
        ALogger.i("LiveCachePool", "service instance init");
        IHostBusiness r0 = k.f(IHostBusiness.class);     // Catch: Exception -> L7
        if (r0 == null) goto L12;
        r0.loadLiveCachePool(false);     // Catch: Exception -> L7
        return;
    L12:
        return;
    L7:
        e = move-exception;
        ALogger.e("LiveCachePool", "try init LiveCachePoolService failed with e= " + e);
    }
}
