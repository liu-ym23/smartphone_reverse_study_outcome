package com.obric.assistant.settings.autogui;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class ObricRiskPreferenceFragment$adapter$2$1 extends FunctionReferenceImpl implements Function1<u0, Unit> {
    public ObricRiskPreferenceFragment$adapter$2$1(Object r100) {
        super(1, r100, ObricRiskPreferenceViewModel.class, "onRiskPreferenceSelected", "onRiskPreferenceSelected(Lcom/obric/assistant/settings/autogui/RiskPreferenceItemUiModel;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(u0 r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        ((ObricRiskPreferenceViewModel) this.receiver).onRiskPreferenceSelected(r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(u0 r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
