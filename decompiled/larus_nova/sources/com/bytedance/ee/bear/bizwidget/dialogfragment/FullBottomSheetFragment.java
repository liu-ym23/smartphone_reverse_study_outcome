package com.bytedance.ee.bear.bizwidget.dialogfragment;

import android.app.Dialog;
import android.content.res.Configuration;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsSheetDialogFragment;
import com.bytedance.ee.bear.wikiv2.wikitreev2.panel.WikiTreePanelDialog;
import com.bytedance.ee.util.ui.n;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0010H\u0016J\b\u0010\u0017\u001a\u00020\u0010H\u0004J\b\u0010\u0018\u001a\u00020\u0010H\u0004R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ee/bear/bizwidget/dialogfragment/FullBottomSheetFragment;", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/antiscreenshots/BaseAntiScreenshotsSheetDialogFragment;", "<init>", "()V", "behavior", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "Landroid/widget/FrameLayout;", "getBehavior", "()Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "setBehavior", "(Lcom/google/android/material/bottomsheet/BottomSheetBehavior;)V", "TAG", "", "getTheme", "", WidgetCostModule.TYPE_ON_START, "", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "isSupportScreenLandscape", "", "adjustWindowParams", "setTransparentDim", "setFixContents", "framework-biz-widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class FullBottomSheetFragment extends BaseAntiScreenshotsSheetDialogFragment {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public BottomSheetBehavior<FrameLayout> f216397i;

    @Override // androidx.fragment.app.DialogFragment
    public final int getTheme() {
        return R.style.BearTransparentBottomSheetStyle;
    }

    public final void Z90() {
        if ((this instanceof WikiTreePanelDialog) == false) goto L14;
        Dialog r100 = getDialog();
        if (r100 == null) goto L15;
        Window r101 = r100.getWindow();
        if (r101 == null) goto L16;
        WindowManager.LayoutParams r102 = r101.getAttributes();
        if (cu5.c.e(getActivity()) == false) goto L11;
        r102.width = (int) (n.q(getActivity()) * 0.7f);
        r102.height = n.p(getActivity()) - this.f216408g;
    L12:
        r101.setAttributes(r102);
        return;
    L11:
        r102.width = -1;
        r102.height = -1;
        goto L12
    L16:
        return;
    L15:
        return;
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        View r100 = b.a(getDialog());
        CoordinatorLayout.LayoutParams r101 = null;
        if ((r100 instanceof FrameLayout) == false) goto L5;
        FrameLayout r102 = (FrameLayout) r100;
    L6:
        if (r102 == null) goto L12;
        ViewGroup.LayoutParams r103 = r102.getLayoutParams();
        if ((r103 instanceof CoordinatorLayout.LayoutParams) == false) goto L10;
        r101 = (CoordinatorLayout.LayoutParams) r103;
    L10:
        if (r101 == null) goto L12;
        ((ViewGroup.MarginLayoutParams) r101).height = n.t();
        r102.setLayoutParams(r101);
    L12:
        this.f216397i = b.c(getDialog());
        Z90();
        return;
    L5:
        r102 = null;
        goto L6
    }

    public FullBottomSheetFragment() {
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
        super.onConfigurationChanged(r100);
        Z90();
    }
}
