package com.obric.assistant.activation.presentation.runtime.session.dispatch;

import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class InteractionSessionEventDispatcher$init$1 extends FunctionReferenceImpl implements Function0<Unit> {
    public InteractionSessionEventDispatcher$init$1(Object r100) {
        super(0, r100, InteractionSessionEventDispatcher.class, "onAiKeyDownReadyToDispatch", "onAiKeyDownReadyToDispatch()V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        InteractionSessionEventDispatcher r100 = (InteractionSessionEventDispatcher) this.receiver;
        InteractionSessionEventDispatcher r101 = InteractionSessionEventDispatcher.f385541a;
        monitor-enter(r100);
        a.b<InteractionSessionEventDispatcher.a> r102 = InteractionSessionEventDispatcher.f385542b.g();     // Catch: Throwable -> L7
        FLogger.f375446a.i("InteractionSessionED", "ai_key_down_ready: released=" + r102.f385555a.size() + " activeSessionId=" + InteractionSessionEventDispatcher.f385543c);     // Catch: Throwable -> L7
        InteractionSessionEventDispatcher.b("ai_key_down_ready", null, r102);     // Catch: Throwable -> L7
        monitor-exit(r100);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
