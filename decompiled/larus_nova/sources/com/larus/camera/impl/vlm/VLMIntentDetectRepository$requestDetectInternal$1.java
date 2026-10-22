package com.larus.camera.impl.vlm;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.vlm.VLMIntentDetectRepository", f = "VLMIntentDetectRepository.kt", i = {0, 1, 1}, l = {55, 60}, m = "requestDetectInternal", n = {com.bytedance.android.ec.core.event.a.KEY_TRACKER, com.bytedance.android.ec.core.event.a.KEY_TRACKER, "httpRequest"}, s = {"L$0", "L$0", "L$1"})
public final class VLMIntentDetectRepository$requestDetectInternal$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ VLMIntentDetectRepository this$0;

    public VLMIntentDetectRepository$requestDetectInternal$1(VLMIntentDetectRepository r100, Continuation<? super VLMIntentDetectRepository$requestDetectInternal$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        VLMIntentDetectRepository r101 = this.this$0;
        VLMIntentDetectRepository r102 = VLMIntentDetectRepository.f322806a;
        return r101.c(null, null, this);
    }
}
