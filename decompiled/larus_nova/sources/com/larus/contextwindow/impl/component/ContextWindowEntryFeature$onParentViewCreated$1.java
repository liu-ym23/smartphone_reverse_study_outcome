package com.larus.contextwindow.impl.component;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class ContextWindowEntryFeature$onParentViewCreated$1 extends FunctionReferenceImpl implements Function0<Unit> {
    public ContextWindowEntryFeature$onParentViewCreated$1(Object r100) {
        super(0, r100, ContextWindowEntryFeature.class, "refreshDecision", "refreshDecision()V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ContextWindowEntryFeature r100 = (ContextWindowEntryFeature) this.receiver;
        int r101 = ContextWindowEntryFeature.f330283z;
        r100.L2();
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
