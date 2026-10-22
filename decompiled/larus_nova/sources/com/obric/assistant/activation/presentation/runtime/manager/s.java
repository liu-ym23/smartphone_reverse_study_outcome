package com.obric.assistant.activation.presentation.runtime.manager;

import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes32.dex */
public final /* synthetic */ class s implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0 f385430a;

    public /* synthetic */ s(Function0 r100) {
        this.f385430a = r100;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        Function0<Unit> r100 = this.f385430a;
        ObricListeningChildCoordinator.f385300l = r100;
        FLogger r101 = FLogger.f375446a;
        StringBuilder r102 = new StringBuilder("ai_key_down_ready_to_dispatch_listener_changed: registered=");
        if (r100 == null) goto L5;
        boolean r103 = true;
    L6:
        r102.append(r103);
        r101.i("ObricListeningChildCoordinator", r102.toString());
        return Unit.INSTANCE;
    L5:
        r103 = false;
        goto L6
    }
}
