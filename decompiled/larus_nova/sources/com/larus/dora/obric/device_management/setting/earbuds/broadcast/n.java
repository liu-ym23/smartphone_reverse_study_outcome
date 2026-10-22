package com.larus.dora.obric.device_management.setting.earbuds.broadcast;

import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes27.dex */
public final class n<T> implements FlowCollector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DoraObricEarbudsAddRuleInputSheet f339908a;

    public n(DoraObricEarbudsAddRuleInputSheet r100) {
        this.f339908a = r100;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object r100, Continuation r101) {
        Unit r102 = (Unit) r100;
        this.f339908a.dismissAllowingStateLoss();     // Catch: Exception -> L5
    L10:
        return Unit.INSTANCE;
    L5:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r103 = DialogFragmentLancet.sLastShowStack;
        if (r103 == null) goto L10;
        com.bytedance.crash.d.d(r103, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L10
    }
}
