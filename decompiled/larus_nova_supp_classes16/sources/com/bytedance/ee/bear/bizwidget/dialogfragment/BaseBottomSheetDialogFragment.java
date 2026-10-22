package com.bytedance.ee.bear.bizwidget.dialogfragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.WindowManager;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsSheetDialogFragment;
import com.bytedance.ee.bear.bizwidget.shareview.ShareItemModel;
import com.bytedance.ee.bear.doc.minutes.PlaySpeedBottomSheet;
import com.bytedance.ee.util.ui.n;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class BaseBottomSheetDialogFragment extends BaseAntiScreenshotsSheetDialogFragment {
    public static final int j = 0;
    public boolean i;

    public void Z90(WindowManager.LayoutParams r1, boolean r2) {
    }

    public boolean ba0() {
        return this instanceof PlaySpeedBottomSheet;
    }

    static {
        j = n.d(11);
    }

    public BaseBottomSheetDialogFragment() {
        this.i = true;
        tt5.a.h("BaseBottomSheetDialogFragment", getClass().getSimpleName().concat(" constructor"));
    }

    private void aa0() {
        if (ba0() == true) goto L5;
        return;
    L5:
        Dialog r0 = getDialog();
        if (r0 != null) goto L8;
        return;
    L8:
        if (r0.getWindow() == null) goto L32;
        Window r1 = r0.getWindow();
        WindowManager.LayoutParams r2 = r1.getAttributes();
        int r3 = Build.VERSION.SDK_INT;
        if (r3 < 30) goto L17;
        View r4 = r1.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L16;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r5 = ThreadMethodProxy.currentThread();
        if (r5 == com.larus.home.impl.utils.c.a) goto L16;
        com.larus.home.impl.utils.c.a(r5, "getDecorView");
    L16:
        WindowInsetsController r6 = r4.getWindowInsetsController();
    L19:
        if (cu5.c.e(getActivity()) == false) goto L25;
        r1.setFlags(1024, 1024);
        r1.setGravity(1);
        if (r6 == null) goto L24;
        if (r3 < 30) goto L24;
        r6.hide(WindowInsets.Type.statusBars());
    L24:
        r2.width = (int) (n.q(getActivity()) * 0.7f);
        Z90(r2, true);
    L29:
        r1.setAttributes(r2);
        return;
    L25:
        if (r6 == null) goto L28;
        if (r3 < 30) goto L28;
        r6.show(WindowInsets.Type.statusBars());
    L28:
        r2.width = -1;
        Z90(r2, false);
        goto L29
    L17:
        r6 = null;
        goto L19
    }

    public int getTheme() {
        if (getContext() != null) goto L5;
        return 2131952029;
    L5:
        if (ku5.c.k(getContext()) == false) goto L10;
        return 2131952037;
    L10:
        return 2131952029;
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsSheetDialogFragment
    public void onDestroy() {
        super.onDestroy();
        tt5.a.h("BaseBottomSheetDialogFragment", getClass().getSimpleName().concat(" onDestroy"));
    }

    public void onDetach() {
        super/*androidx.fragment.app.DialogFragment*/.onDetach();
        tt5.a.h("BaseBottomSheetDialogFragment", getClass().getSimpleName().concat(" onDetach"));
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsSheetDialogFragment
    public void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        if (this.i == false) goto L5;
        this.i = false;
        aa0();
    L5:
        ca0(2131108712);
    }

    public final void ca0(int r3) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 <= 29) goto L5;
    L11:
        Y90(r3);
        return;
    L5:
        if (r0 < 26) goto L11;
        if (getDialog() != null) goto L9;
        return;
    L9:
        if (getDialog().getWindow() == null) goto L14;
        getDialog().getWindow().addFlags(ShareItemModel.SRC_TINT_UNDEFINED);
        getDialog().getWindow().clearFlags(134217728);
        getDialog().getWindow().setNavigationBarColor(n.h(getContext(), r3));
        return;
    }

    public void onConfigurationChanged(Configuration r1) {
        super/*androidx.fragment.app.Fragment*/.onConfigurationChanged(r1);
        aa0();
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsSheetDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatBottomSheetDialogFragment
    public void onCreate(Bundle r2) {
        super.onCreate(r2);
        tt5.a.h("BaseBottomSheetDialogFragment", getClass().getSimpleName().concat(" onCreate"));
    }

    public Dialog onCreateDialog(Bundle r1) {
        return super.onCreateDialog(r1);
    }

    public void onDismiss(DialogInterface r2) {
        super/*androidx.fragment.app.DialogFragment*/.onDismiss(r2);     // Catch: Throwable -> L5
        this.i = true;     // Catch: Throwable -> L5
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L5:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    public void show(FragmentManager r3, String r4) {
        if (r3.isStateSaved() == false) goto L7;
        tt5.a.h("BaseDialogFragment", "manager.isStateSaved()");
        return;
    L7:
        if (r3.findFragmentByTag(r4) == null) goto L10;
        tt5.a.h("BaseDialogFragment", "fragment already show");
        return;
    L10:
        LandscapeRestrictionOperation r0 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(this, r4, r0);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, this, r0) == true) goto L19;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L16
    L14:
        super/*androidx.fragment.app.DialogFragment*/.show(r3, r4);
        return;
    }
}
