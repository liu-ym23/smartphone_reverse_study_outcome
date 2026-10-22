package com.larus.audio;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class IFlowAsrClientService$startAsr$1 extends FunctionReferenceImpl implements Function2<String, y58.a, h68.e> {
    public IFlowAsrClientService$startAsr$1(Object r100) {
        super(2, r100, IFlowAsrClientService.class, "createAsrTask", "createAsrTask(Ljava/lang/String;Lcom/larus/audio/audiov3/config/task/sami/asr/AsrConfig;)Lcom/larus/audio/audiov3/task/asr/IAsrTask;", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final h68.e invoke2(String r100, y58.a r101) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        Intrinsics.checkNotNullParameter(r101, "p1");
        return ((IFlowAsrClientService) this.receiver).c(r100, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ h68.e invoke(String r100, y58.a r101) {
        return invoke2(r100, r101);
    }
}
