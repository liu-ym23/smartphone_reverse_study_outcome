package com.obric.assistant.activation.presentation.runtime.manager;

import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes32.dex */
public final /* synthetic */ class w0 implements Function0 {
    public /* synthetic */ w0() {
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        ObricListeningMainProcessManager r100 = ObricListeningMainProcessManager.f385330a;
        ObricListeningMainProcessManager$onHostWindowHidden$1$1 r101 = new ObricListeningMainProcessManager$onHostWindowHidden$1$1(r100);
        r100.getClass();
        if (ObricListeningMainProcessManager.c("host Window hidden", r101) == false) goto L6;
        return Unit.INSTANCE;
    L6:
        if (ObricListeningMainProcessManager.f385335f == false) goto L11;
        if (ObricListeningMainProcessManager.f385345p == true) goto L11;
        FLogger.f375446a.i("ObricListeningMainPM", "finish child presentation after host Window hidden");
        ObricListeningMainProcessManager.h();
    L11:
        return Unit.INSTANCE;
    }
}
