package com.obric.assistant.activation.presentation.runtime.manager;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.activation.presentation.contract.gesture.ObricAiKeyGestureAction;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes32.dex */
public final /* synthetic */ class x0 implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ObricAiKeyGestureAction f385449a;

    public /* synthetic */ x0(ObricAiKeyGestureAction r100) {
        this.f385449a = r100;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        final ObricAiKeyGestureAction r100 = this.f385449a;
        ObricListeningMainProcessManager r101 = ObricListeningMainProcessManager.f385330a;
        Function0 r102 = new f1(r100);
        r101.getClass();
        if (ObricListeningMainProcessManager.c("AI key acknowledgement", r102) == false) goto L6;
        return Unit.INSTANCE;
    L6:
        if (ObricListeningMainProcessManager.f385335f == true) goto L9;
        FLogger.f375446a.i("ObricListeningMainPM", "ignore AI key acknowledgement without child owner, action=" + r100);
        return Unit.INSTANCE;
    L9:
        if (r100 != ObricAiKeyGestureAction.SINGLE_PRESS) goto L11;
    L13:
        ObricListeningMainProcessManager.g(new g1(r100));
        return Unit.INSTANCE;
    L11:
        if (r100 == ObricAiKeyGestureAction.DOUBLE_PRESS) goto L13;
        FLogger.f375446a.i("ObricListeningMainPM", "ignore non-terminal AI key acknowledgement, action=" + r100);
        return Unit.INSTANCE;
    }
}
