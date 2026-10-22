package com.larus.asr.session;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class QuicInterpretAsrSession$startTranslateViaFlowAsrClient$3$2 extends FunctionReferenceImpl implements Function2<byte[], JSONObject, Unit> {
    public QuicInterpretAsrSession$startTranslateViaFlowAsrClient$3$2(Object r100) {
        super(2, r100, i1.class, "onReceiveTranslatedAudio", "onReceiveTranslatedAudio([BLorg/json/JSONObject;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(byte[] r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        i1.a((i1) this.receiver, r100, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(byte[] r100, JSONObject r101) {
        invoke2(r100, r101);
        return Unit.INSTANCE;
    }
}
