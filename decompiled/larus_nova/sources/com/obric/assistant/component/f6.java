package com.obric.assistant.component;

import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final /* synthetic */ class f6 implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OrionInstructionComponent f388611a;

    public /* synthetic */ f6(OrionInstructionComponent r100) {
        this.f388611a = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r100) {
        OrionInstructionComponent r101 = this.f388611a;
        int r102 = OrionInstructionComponent.f388336p1;
        Intrinsics.checkNotNullParameter((ArrayList) r100, "it");
        r101.B4("window_custom_bar_actions_changed");
        return Unit.INSTANCE;
    }
}
