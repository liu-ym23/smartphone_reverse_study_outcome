package com.larus.bmhome.chat.component.bottom.voice.service;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.voice.service.VoiceMixInputService", f = "VoiceMixInputService.kt", i = {0}, l = {166}, m = "configTextStream", n = {"textContext"}, s = {"L$0"})
final class VoiceMixInputService$configTextStream$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ VoiceMixInputService this$0;

    public VoiceMixInputService$configTextStream$1(VoiceMixInputService r100, Continuation<? super VoiceMixInputService$configTextStream$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return VoiceMixInputService.a(this.this$0, null, false, this);
    }
}
