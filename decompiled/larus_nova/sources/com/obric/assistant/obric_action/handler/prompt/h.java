package com.obric.assistant.obric_action.handler.prompt;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.larus.common_ui.dialog.f0;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes33.dex */
public final class h {
    public static final f0 c(FragmentActivity r100) {
        return new f0(null, Integer.valueOf(ContextCompat.getColor(r100, R.color.larus_primary_50)), null, 5);
    }

    public static final Object a(FragmentActivity r100, Function2 r101, ContinuationImpl r102) {
        kotlinx.coroutines.j r103 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r102), 1);
        r103.C();
        Ref.BooleanRef r104 = new Ref.BooleanRef();
        DialogFragment r105 = (DialogFragment) r101.invoke(new PromptDialogActionHandlersKt$awaitPromptDialog$2$dialog$1(r104, r103), new PromptDialogActionHandlersKt$awaitPromptDialog$2$dialog$2(r104, r103));
        r103.i(new f(r105));
        FragmentManager r106 = r100.getSupportFragmentManager();
        String r107 = "ObricActionPromptDialog-" + r105.hashCode();
        Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L18
        if (r106.isStateSaved() == false) goto L10;
        FragmentTransaction r109 = r106.beginTransaction();     // Catch: Throwable -> L18
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r109, r105, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, r107, 0) == true) goto L9;
        r109 = r109.add(r105, r107);     // Catch: Throwable -> L18
    L9:
        Object r110 = Integer.valueOf(r109.commitAllowingStateLoss());     // Catch: Throwable -> L18
    L16:
        Object r111 = Result.m9449constructorimpl(r110);     // Catch: Throwable -> L18
    L20:
        Throwable r112 = Result.m9452exceptionOrNullimpl(r111);
        if (r112 == null) goto L24;
        FLogger.f375446a.e("ObricActionPromptDialog", "show prompt dialog failed: " + r112);
    L24:
        if (Result.m9456isSuccessimpl(r111) == true) goto L26;
        b(r104, r103, new j("dismissed", 14));
    L26:
        Object r113 = r103.B();
        if (r113 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L29;
        DebugProbesKt.probeCoroutineSuspended(r102);
    L29:
        return r113;
    L10:
        LandscapeRestrictionOperation r114 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;     // Catch: Throwable -> L18
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r105, r107, r114);     // Catch: Throwable -> L18
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r106, r105, r114) == false) goto L33;
    L15:
        r110 = Unit.INSTANCE;     // Catch: Throwable -> L18
        goto L16
    L33:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L30 Throwable -> L18
    L14:
        r105.show(r106, r107);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        Result.Companion r115 = Result.Companion;
        r111 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L20
    }

    public static final void b(Ref.BooleanRef r100, kotlinx.coroutines.i r101, j r102) {
        if (r100.element == false) goto L5;
        return;
    L5:
        if (r101.isActive() == false) goto L9;
        r100.element = true;
        r101.resumeWith(Result.m9449constructorimpl(r102));
        return;
    }
}
