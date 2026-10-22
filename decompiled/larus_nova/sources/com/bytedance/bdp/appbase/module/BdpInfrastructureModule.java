package com.bytedance.bdp.appbase.module;

import com.bytedance.bdp.appbase.context.service.base.AbsContextServiceFetcher;
import com.bytedance.bdp.appbase.exit.ExitReasonService;
import com.bytedance.bdp.appbase.request.contextservice.CpDownloadService;
import com.bytedance.bdp.appbase.request.contextservice.CpUploadService;
import com.bytedance.bdp.appbase.service.protocol.host.HostInfoService;
import k94.a;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u001b\u0010\u000b\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/bytedance/bdp/appbase/module/BdpInfrastructureModule;", "Lk94/a;", "Lcom/bytedance/bdp/appbase/context/service/base/AbsContextServiceFetcher;", "getContextServiceFetcher", "", "preloadClass", "Ll94/a;", "mContextServiceFetcher$delegate", "Lkotlin/Lazy;", "getMContextServiceFetcher", "()Ll94/a;", "mContextServiceFetcher", "<init>", "()V", "bdp-infrastructure_release"}, k = 1, mv = {1, 4, 0})
public final class BdpInfrastructureModule extends a {
    private final Lazy mContextServiceFetcher$delegate;

    private final l94.a getMContextServiceFetcher() {
        return (l94.a) this.mContextServiceFetcher$delegate.getValue();
    }

    @Override // k94.a
    public void preloadClass() {
        int r100 = l94.a.f508109c;
        l94.a.c(ExitReasonService.class.getName());     // Catch: Throwable -> L5
        l94.a.c(CpDownloadService.class.getName());     // Catch: Throwable -> L5
        l94.a.c(CpUploadService.class.getName());     // Catch: Throwable -> L5
        l94.a.c(HostInfoService.class.getName());     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
    }

    public BdpInfrastructureModule() {
        this.mContextServiceFetcher$delegate = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, BdpInfrastructureModule$mContextServiceFetcher$2.INSTANCE);
    }

    @Override // k94.a
    public AbsContextServiceFetcher getContextServiceFetcher() {
        return getMContextServiceFetcher();
    }
}
