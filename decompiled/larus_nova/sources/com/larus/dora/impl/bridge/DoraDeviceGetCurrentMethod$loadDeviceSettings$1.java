package com.larus.dora.impl.bridge;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.bridge.DoraDeviceGetCurrentMethod", f = "DoraDeviceGetCurrentMethod.kt", i = {0, 0, 0, 1, 1, 1, 1, 1, 1, 1}, l = {209, 223}, m = "loadDeviceSettings", n = {"adapter", "deviceKey", "requestedExtraInfo", "adapter", "deviceKey", "requestedExtraInfo", "isAdaptationEnable", "cueToneVolumeRaw", "shouldUpdateCache", "requestedCachedExtraInfo"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6"})
final class DoraDeviceGetCurrentMethod$loadDeviceSettings$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ m this$0;

    public DoraDeviceGetCurrentMethod$loadDeviceSettings$1(m r100, Continuation<? super DoraDeviceGetCurrentMethod$loadDeviceSettings$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return m.a(this.this$0, null, null, null, this);
    }
}
