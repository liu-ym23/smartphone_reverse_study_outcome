package com.larus.dora.impl.core.wifi;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.core.wifi.DoraWifiLinkWrapper", f = "DoraWifiLinkWrapper.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {92, 787}, m = "connectLocked", n = {"scene", BdpAppEventConstant.PARAMS_STRATEGY_NAME, "owner", "onDisconnected", "scene", "owner", "onDisconnected", "wifiManager", "finalStrategy"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4"})
public final class DoraWifiLinkWrapper$connectLocked$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DoraWifiLinkWrapper this$0;

    public DoraWifiLinkWrapper$connectLocked$1(DoraWifiLinkWrapper r100, Continuation<? super DoraWifiLinkWrapper$connectLocked$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        DoraWifiLinkWrapper r101 = this.this$0;
        DoraWifiLinkWrapper r102 = DoraWifiLinkWrapper.f332292a;
        return r101.c(null, null, false, null, null, this);
    }
}
