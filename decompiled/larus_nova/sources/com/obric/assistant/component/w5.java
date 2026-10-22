package com.obric.assistant.component;

import com.obric.assistant.state.api.multitask.ForegroundInteractionPhase;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final /* synthetic */ class w5 implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OrionChatWindowComponent f388988a;

    public /* synthetic */ w5(OrionChatWindowComponent r100) {
        this.f388988a = r100;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object r100, Object r101) {
        OrionChatWindowComponent r102 = this.f388988a;
        ForegroundInteractionPhase r103 = (ForegroundInteractionPhase) r101;
        int r104 = OrionChatWindowComponent.T;
        Intrinsics.checkNotNullParameter((String) r100, "it");
        Intrinsics.checkNotNullParameter(r103, "state");
        r102.E3(r103);
        return Unit.INSTANCE;
    }
}
