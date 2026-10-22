package com.larus.avlink;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class DoraRealtimeCallTracer$traceDelegate$1$1 extends FunctionReferenceImpl implements Function0<String> {
    public DoraRealtimeCallTracer$traceDelegate$1$1(Object r100) {
        super(0, r100, DoraRealtimeCallTracer.class, "getDoraScene", "getDoraScene()Ljava/lang/String;", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2() {
        DoraRealtimeCallTracer r100 = (DoraRealtimeCallTracer) this.receiver;
        int r101 = DoraRealtimeCallTracer.f291373u;
        return r100.z0();
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ String invoke() {
        return invoke2();
    }
}
