package com.larus.dora.impl.serviceimpl;

import com.bytedance.dora.wlan.model.DoraWifiScene;
import java.util.Set;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.serviceimpl.WifiService", f = "WifiService.kt", i = {0, 0}, l = {242}, m = "waitAssistantWifiEnabledForScene", n = {"scene", "index"}, s = {"L$0", "I$2"})
public final class WifiService$waitAssistantWifiEnabledForScene$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WifiService this$0;

    public WifiService$waitAssistantWifiEnabledForScene$1(WifiService r100, Continuation<? super WifiService$waitAssistantWifiEnabledForScene$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        WifiService r101 = this.this$0;
        Set<DoraWifiScene> r102 = WifiService.f337995a;
        return r101.n(null, this);
    }
}
