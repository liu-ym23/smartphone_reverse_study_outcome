package com.obric.assistant.activation.presentation.runtime.manager;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class ObricListeningMainProcessManager$onHostWindowHidden$1$1 extends FunctionReferenceImpl implements Function0<Unit> {
    public ObricListeningMainProcessManager$onHostWindowHidden$1$1(Object r100) {
        super(0, r100, ObricListeningMainProcessManager.class, "onHostWindowHidden", "onHostWindowHidden()V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ((ObricListeningMainProcessManager) this.receiver).getClass();
        ObricListeningMainProcessManager.k(new w0());
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
