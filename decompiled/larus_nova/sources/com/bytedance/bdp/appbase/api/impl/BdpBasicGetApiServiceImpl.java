package com.bytedance.bdp.appbase.api.impl;

import com.bytedance.bdp.bdpbase.core.IBasicGetApiService;
import com.bytedance.bdp.bdpbase.manager.BdpManager;
import com.bytedance.bdp.serviceapi.hostimpl.info.BdpInfoService;
import kotlin.Metadata;
import z17.a;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/bdp/appbase/api/impl/BdpBasicGetApiServiceImpl;", "Lcom/bytedance/bdp/bdpbase/core/IBasicGetApiService;", "<init>", "()V", "bdp-infrastructure_release"}, k = 1, mv = {1, 4, 0})
public final class BdpBasicGetApiServiceImpl implements IBasicGetApiService {
    public BdpBasicGetApiServiceImpl() {
    }

    @Override // com.bytedance.bdp.bdpbase.core.IBasicGetApiService
    public final boolean O1() {
        if (a.f569677a == null) goto L5;
    L14:
        a.f569677a.getClass();
        return "8663".equals(((BdpInfoService) BdpManager.getInst().getService(BdpInfoService.class)).getHostInfo().getAppId());
    L5:
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (a.f569677a != null) goto L9;
        a.f569677a = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
        goto L14
    }

    @Override // com.bytedance.bdp.bdpbase.core.IBasicGetApiService
    public final boolean a2() {
        if (a.f569677a == null) goto L5;
    L14:
        a.f569677a.getClass();
        return "2329".equals(((BdpInfoService) BdpManager.getInst().getService(BdpInfoService.class)).getHostInfo().getAppId());
    L5:
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (a.f569677a != null) goto L9;
        a.f569677a = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
        goto L14
    }
}
