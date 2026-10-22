package com.obric.assistant.interaction.impl.window.helpers;

import android.content.DialogInterface;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import me.ele.lancet.base.Origin;
import me.ele.lancet.base.This;

/* JADX INFO: loaded from: classes33.dex */
public class DialogFragmentLancet {
    public static volatile Throwable sLastShowStack;

    public DialogFragmentLancet() {
    }

    public void dismiss() {
        Origin.callVoid();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r100 = sLastShowStack;
        if (r100 == null) goto L11;
        com.bytedance.crash.d.d(r100, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public void dismissAllowingStateLoss() {
        Origin.callVoid();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r100 = sLastShowStack;
        if (r100 == null) goto L11;
        com.bytedance.crash.d.d(r100, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public void onStart() {
        Object r100 = This.get();
        if ((r100 instanceof DialogFragment) == false) goto L5;
        DialogFragment r101 = (DialogFragment) r100;
        PopupOrDialogVisibilityTracker.bindDialogFragment(r101);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(r101);
    L5:
        Origin.callVoid();
    }

    public void onDismiss(DialogInterface r100) {
        Object r101 = This.get();
        Origin.callVoid();     // Catch: Throwable -> L8
        if ((r101 instanceof DialogFragment) == false) goto L15;
        DialogFragment r102 = (DialogFragment) r101;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(r102.getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(r102);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(r102);
        return;
    L15:
        return;
    L8:
        th = move-exception;
        if ((r101 instanceof DialogFragment) == false) goto L12;
        DialogFragment r103 = (DialogFragment) r101;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(r103.getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(r103);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(r103);
    L12:
        throw th;
    }

    public int show(FragmentTransaction r100, String r101) {
        Object r102 = This.get();
        if ((r102 instanceof Fragment) == false) goto L5;
        Fragment r103 = (Fragment) r102;
    L6:
        LandscapeRestrictionOperation r104 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW_TRANSACTION;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r103, r101, r104);
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r100, r103, r104) == false) goto L14;
        return -1;
    L14:
        sLastShowStack = new Throwable();     // Catch: Exception -> L13
    L12:
        return ((Integer) Origin.call()).intValue();
    L5:
        r103 = null;
        goto L6
    }

    public void showNow(FragmentManager r100, String r101) {
        Object r102 = This.get();
        if ((r102 instanceof Fragment) == false) goto L5;
        Fragment r103 = (Fragment) r102;
    L6:
        LandscapeRestrictionOperation r104 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW_NOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r103, r101, r104);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r100, r103, r104) == false) goto L13;
        return;
    L13:
        sLastShowStack = new Throwable();     // Catch: Exception -> L12
    L10:
        Origin.callVoid();
        return;
    L5:
        r103 = null;
        goto L6
    }

    public void show(FragmentManager r100, String r101) {
        Object r102 = This.get();
        if ((r102 instanceof Fragment) == false) goto L5;
        Fragment r103 = (Fragment) r102;
    L6:
        LandscapeRestrictionOperation r104 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r103, r101, r104);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r100, r103, r104) == false) goto L13;
        return;
    L13:
        sLastShowStack = new Throwable();     // Catch: Exception -> L12
    L10:
        Origin.callVoid();
        return;
    L5:
        r103 = null;
        goto L6
    }
}
