package com.larus.larkfeed.impl.voice.service.asr;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class FlowVoiceAsrSession$prepare$1 extends FunctionReferenceImpl implements Function0<Unit> {
    public FlowVoiceAsrSession$prepare$1(Object r100) {
        super(0, r100, g.class, "cancelCompletionTimeout", "cancelCompletionTimeout()V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        g r100 = (g) this.receiver;
        int r101 = g.f355643k;
        Job r102 = r100.f355653j;
        if (r102 == null) goto L5;
        Job.DefaultImpls.cancel$default(r102, null, 1, null);
    L5:
        r100.f355653j = null;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
