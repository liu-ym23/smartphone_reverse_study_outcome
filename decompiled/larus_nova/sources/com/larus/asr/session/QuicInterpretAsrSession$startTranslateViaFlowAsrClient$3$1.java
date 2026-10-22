package com.larus.asr.session;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class QuicInterpretAsrSession$startTranslateViaFlowAsrClient$3$1 extends FunctionReferenceImpl implements Function0<Integer> {
    public QuicInterpretAsrSession$startTranslateViaFlowAsrClient$3$1(Object r100) {
        super(0, r100, i1.class, "currentSpeakerMode", "currentSpeakerMode()I", 0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Integer invoke() {
        i1 r100 = (i1) this.receiver;
        int r101 = i1.f287873k;
        return Integer.valueOf(r100.b());
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Integer invoke() {
        return invoke();
    }
}
