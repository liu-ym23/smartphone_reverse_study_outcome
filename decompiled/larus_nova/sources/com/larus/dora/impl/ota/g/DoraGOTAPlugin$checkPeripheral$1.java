package com.larus.dora.impl.ota.g;

import com.bytedance.map.api.monitor.MapMonitorConst;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.ota.g.DoraGOTAPlugin", f = "DoraGOTAPlugin.kt", i = {0, 0, 0, 0, 1, 1, 1, 1}, l = {126, 184}, m = "checkPeripheral", n = {"responseWrapper", "packageInfo", "maxAttemptCount", MapMonitorConst.ATTEMPT, "responseWrapper", "packageInfo", "maxAttemptCount", MapMonitorConst.ATTEMPT}, s = {"L$0", "L$1", "I$0", "I$1", "L$0", "L$1", "I$0", "I$1"})
public final class DoraGOTAPlugin$checkPeripheral$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DoraGOTAPlugin this$0;

    public DoraGOTAPlugin$checkPeripheral$1(DoraGOTAPlugin r100, Continuation<? super DoraGOTAPlugin$checkPeripheral$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        DoraGOTAPlugin r101 = this.this$0;
        int r102 = DoraGOTAPlugin.f337516c;
        return r101.e(null, this);
    }
}
