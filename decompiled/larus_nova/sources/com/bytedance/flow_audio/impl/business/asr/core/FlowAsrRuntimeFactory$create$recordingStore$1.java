package com.bytedance.flow_audio.impl.business.asr.core;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class FlowAsrRuntimeFactory$create$recordingStore$1 extends FunctionReferenceImpl implements Function0<Long> {
    public FlowAsrRuntimeFactory$create$recordingStore$1(Object r100) {
        super(0, r100, FlowAsrRuntimeFactory.class, "nowMs", "nowMs()J", 0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Long invoke() {
        FlowAsrRuntimeFactory r100 = (FlowAsrRuntimeFactory) this.receiver;
        String r101 = FlowAsrRuntimeFactory.f243820h;
        r100.getClass();
        return Long.valueOf(fuc.a.a().a());
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Long invoke() {
        return invoke();
    }
}
