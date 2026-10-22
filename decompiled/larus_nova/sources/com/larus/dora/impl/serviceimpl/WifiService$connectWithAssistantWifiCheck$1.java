package com.larus.dora.impl.serviceimpl;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.dora.wlan.model.DoraWifiScene;
import java.util.Set;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.serviceimpl.WifiService", f = "WifiService.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3}, l = {173, 176, 182, 183}, m = "connectWithAssistantWifiCheck", n = {"scene", BdpAppEventConstant.PARAMS_STRATEGY_NAME, "useAssistantWifi", "hasRequestedAssistantWifi", "scene", BdpAppEventConstant.PARAMS_STRATEGY_NAME, "useAssistantWifi", "hasRequestedAssistantWifi", "scene", BdpAppEventConstant.PARAMS_STRATEGY_NAME, "result", "useAssistantWifi", "scene", "result", "useAssistantWifi"}, s = {"L$0", "L$1", "I$0", "Z$0", "L$0", "L$1", "I$0", "I$1", "L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "I$0"})
public final class WifiService$connectWithAssistantWifiCheck$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WifiService this$0;

    public WifiService$connectWithAssistantWifiCheck$1(WifiService r100, Continuation<? super WifiService$connectWithAssistantWifiCheck$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        WifiService r101 = this.this$0;
        Set<DoraWifiScene> r102 = WifiService.f337995a;
        return r101.i(null, null, this);
    }
}
