package com.bytedance.bdp.appbase.base.network;

import com.bytedance.bdp.bdpbase.manager.BdpManager;
import com.bytedance.bdp.serviceapi.defaults.network.BdpNetworkService;
import com.bytedance.bdp.serviceapi.defaults.network.BdpRequest;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import gb4.d;
import gb4.f;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 1, 18})
final class BdpNetworkEventHelper$mpNetMonitor$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ d $metric;
    final /* synthetic */ BdpRequest $request;
    final /* synthetic */ f $response;

    public BdpNetworkEventHelper$mpNetMonitor$1(f r100, BdpRequest r101, d r102) {
        this.$request = r101;
        this.$metric = r102;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ((BdpNetworkService) BdpManager.getInst().getService(BdpNetworkService.class)).j2();
        throw null;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
