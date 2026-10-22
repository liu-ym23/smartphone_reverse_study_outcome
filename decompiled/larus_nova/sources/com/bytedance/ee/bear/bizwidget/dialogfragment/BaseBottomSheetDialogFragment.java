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
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsSheetDialogFragment;
import com.bytedance.ee.bear.doc.minutes.PlaySpeedBottomSheet;
import com.bytedance.ee.util.ui.n;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: classes16.dex */
public class BaseBottomSheetDialogFragment extends BaseAntiScreenshotsSheetDialogFragment {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f216377j = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f216378i;

    public void Z90(WindowManager.LayoutParams r100, boolean r101) {
    }

    public boolean ba0() {
        return this instanceof PlaySpeedBottomSheet;
    }

    static {
        f216377j = n.d(11);
    }

    public BaseBottomSheetDialogFragment() {
        this.f216378i = true;
        tt5.a.h("BaseBottomSheetDialogFragment", getClass().getSimpleName().concat(" constructor"));
    }

    private void aa0() {
        if (ba0() == true) goto L5;
        return;
    L5:
        Dialog r100 = getDialog();
        if (r100 != null) goto L8;
        return;
    L8:
        if (r100.getWindow() == null) goto L32;
        Window r101 = r100.getWindow();
        WindowManager.LayoutParams r102 = r101.getAttributes();
        int r103 = Build.VERSION.SDK_INT;
        if (r103 < 30) goto L17;
        View r104 = r101.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L16;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r105 = ThreadMethodProxy.currentThread();
        if (r105 == com.larus.home.impl.utils.c.f346341a) goto L16;
        com.larus.home.impl.utils.c.a(r105, "getDecorView");
    L16:
        WindowInsetsController r106 = r104.getWindowInsetsController();
    L19:
        if (cu5.c.e(getActivity()) == false) goto L25;
        r101.setFlags(1024, 1024);
        r101.setGravity(1);
        if (r106 == null) goto L24;
        if (r103 < 30) goto L24;
        r106.hide(WindowInsets.Type.statusBars());
    L24:
        r102.width = (int) (n.q(getActivity()) * 0.7f);
        Z90(r102, true);
    L29:
        r101.setAttributes(r102);
        return;
    L25:
        if (r106 == null) goto L28;
        if (r103 < 30) goto L28;
        r106.show(WindowInsets.Type.statusBars());
    L28:
        r102.width = -1;
        Z90(r102, false);
        goto L29
    L17:
        r106 = null;
        goto L19
    }

    @Override // androidx.fragment.app.DialogFragment
    public int getTheme() {
        if (getContext() != null) goto L5;
        return R.style.CustomBottomSheetDialog;
    L5:
        if (ku5.c.k(getContext()) == false) goto L10;
        return R.style.CustomPadBottomSheetDialog;
    L10:
        return R.style.CustomBottomSheetDialog;
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsSheetDialogFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        tt5.a.h("BaseBottomSheetDialogFragment", getClass().getSimpleName().concat(" onDestroy"));
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        tt5.a.h("BaseBottomSheetDialogFragment", getClass().getSimpleName().concat(" onDetach"));
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        if (this.f216378i == false) goto L5;
        this.f216378i = false;
        aa0();
    L5:
        ca0(R.color.ud_N100);
    }

    public final void ca0(int r100) {
        int r101 = Build.VERSION.SDK_INT;
        if (r101 <= 29) goto L5;
    L11:
        Y90(r100);
        return;
    L5:
        if (r101 < 26) goto L11;
        if (getDialog() != null) goto L9;
        return;
    L9:
        if (getDialog().getWindow() == null) goto L14;
        getDialog().getWindow().addFlags(Integer.MIN_VALUE);
        getDialog().getWindow().clearFlags(AMapEngineUtils.HALF_MAX_P20_WIDTH);
        getDialog().getWindow().setNavigationBarColor(n.h(getContext(), r100));
        return;
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration r100) {
        super.onConfigurationChanged(r100);
        aa0();
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsSheetDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r100) {
        super.onCreate(r100);
        tt5.a.h("BaseBottomSheetDialogFragment", getClass().getSimpleName().concat(" onCreate"));
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle r100) {
        return super.onCreateDialog(r100);
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface r100) {
        super.onDismiss(r100);     // Catch: Throwable -> L5
        this.f216378i = true;     // Catch: Throwable -> L5
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

    @Override // androidx.fragment.app.DialogFragment
    public void show(FragmentManager r100, String r101) {
        if (r100.isStateSaved() == false) goto L7;
        tt5.a.h("BaseDialogFragment", "manager.isStateSaved()");
        return;
    L7:
        if (r100.findFragmentByTag(r101) == null) goto L10;
        tt5.a.h("BaseDialogFragment", "fragment already show");
        return;
    L10:
        LandscapeRestrictionOperation r102 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(this, r101, r102);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r100, this, r102) == true) goto L19;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L16
    L14:
        super.show(r100, r101);
        return;
    }
}
