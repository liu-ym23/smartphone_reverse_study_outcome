package com.bytedance.flow_audio.impl.business.asr.core;

import com.bytedance.flow_audio.api.business.asr.session.FlowAsrSessionState;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class FlowAsrRuntimeFactory$create$audioUplinkController$1 extends FunctionReferenceImpl implements Function0<Boolean> {
    public FlowAsrRuntimeFactory$create$audioUplinkController$1(Object r100) {
        super(0, r100, com.bytedance.flow_audio.impl.business.asr.p.class, "canSendQueuedAudioFrames", "canSendQueuedAudioFrames()Z", 0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Boolean invoke() {
        FlowAsrSessionState r100 = ((com.bytedance.flow_audio.impl.business.asr.p) this.receiver).a();
        if (r100 != FlowAsrSessionState.RECORDING) goto L5;
    L10:
        boolean r101 = true;
    L12:
        return Boolean.valueOf(r101);
    L5:
        if (r100 == FlowAsrSessionState.STOPPING) goto L10;
        if (r100 == FlowAsrSessionState.RETRYING) goto L10;
        r101 = false;
        goto L12
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Boolean invoke() {
        return invoke();
    }
}
