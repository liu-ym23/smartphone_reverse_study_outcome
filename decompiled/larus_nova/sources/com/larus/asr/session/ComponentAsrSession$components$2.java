package com.larus.asr.session;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class ComponentAsrSession$components$2 extends FunctionReferenceImpl implements Function0<com.larus.asr.session.component.d0> {
    public ComponentAsrSession$components$2(Object r100) {
        super(0, r100, ComponentAsrSession.class, "createComponents", "createComponents()Lcom/larus/asr/session/component/AsrSessionComponents;", 0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final com.larus.asr.session.component.d0 invoke() {
        return ((ComponentAsrSession) this.receiver).b();
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ com.larus.asr.session.component.d0 invoke() {
        return invoke();
    }
}
