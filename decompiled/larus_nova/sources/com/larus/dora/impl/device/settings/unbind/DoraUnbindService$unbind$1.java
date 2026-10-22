package com.larus.dora.impl.device.settings.unbind;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.device.settings.unbind.DoraUnbindService", f = "DoraUnbindViewModel.kt", i = {0}, l = {122}, m = "unbind", n = {"device"}, s = {"L$0"})
public final class DoraUnbindService$unbind$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DoraUnbindService this$0;

    public DoraUnbindService$unbind$1(DoraUnbindService r100, Continuation<? super DoraUnbindService$unbind$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(this);
    }
}
