package com.obric.assistant.component;

import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class i6 implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OrionInstructionComponent f388649a;

    public /* synthetic */ i6(OrionInstructionComponent r100) {
        this.f388649a = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r100) {
        OrionInstructionComponent r101 = this.f388649a;
        boolean r102 = ((Boolean) r100).booleanValue();
        int r103 = OrionInstructionComponent.f388336p1;
        FLogger.f375446a.i("OrionExtraComponent", "onSpeakerVisibleChanged, mockSpeakerVisible: " + r102);
        r101.T = r102;
        r101.l4();
        laa.m r104 = (laa.m) r101.C.getValue();
        if (r104 == null) goto L6;
        r104.rT(r102);
    L6:
        return Unit.INSTANCE;
    }
}
