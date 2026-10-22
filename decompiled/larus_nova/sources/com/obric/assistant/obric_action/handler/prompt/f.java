package com.obric.assistant.obric_action.handler.prompt;

import androidx.fragment.app.DialogFragment;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes33.dex */
public final class f implements Function1<Throwable, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DialogFragment f390499a;

    public f(DialogFragment r100) {
        this.f390499a = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Throwable r100) {
        DialogFragment r101 = this.f390499a;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L12
        r101.dismissAllowingStateLoss();     // Catch: Exception -> L6 Throwable -> L12
    L10:
        Object r103 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L12
    L14:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 == null) goto L18;
        FLogger.f375446a.e("ObricActionPromptDialog", "dismiss prompt dialog failed: " + r104);
    L18:
        return Unit.INSTANCE;
    L6:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");     // Catch: Throwable -> L12
        Throwable r105 = DialogFragmentLancet.sLastShowStack;     // Catch: Throwable -> L12
        if (r105 == null) goto L10;
        com.bytedance.crash.d.d(r105, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L14
    }
}
