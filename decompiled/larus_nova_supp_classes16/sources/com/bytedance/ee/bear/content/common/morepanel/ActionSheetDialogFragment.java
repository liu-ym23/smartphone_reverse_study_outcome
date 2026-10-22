package com.bytedance.ee.bear.content.common.morepanel;

import android.R;
import android.app.Dialog;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.ee.bear.bizwidget.dialogfragment.BaseDialogFragment;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.insets.WindowInsetsUtils;
import com.ss.android.lark.insets.f;
import com.suite.lark.component.navroute.forseti.ForsetiNavOptions;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class ActionSheetDialogFragment extends BaseDialogFragment {
    public static final /* synthetic */ int j = 0;
    public String h;
    public Bundle i;

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment
    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        Dialog r0 = getDialog();
        if (r0 != null) goto L5;
        Window r1 = null;
    L6:
        if (r1 == null) goto L9;
        WindowManager.LayoutParams r2 = r1.getAttributes();
        r2.width = -1;
        r2.height = -2;
        r2.gravity = 80;
        r1.setAttributes(r2);
        r1.setWindowAnimations(2131951620);
        r1.setBackgroundDrawableResource(R.color.transparent);
        TypedValue r3 = new TypedValue();
        getResources().getValue(2131168390, r3, true);
        r1.setDimAmount(r3.getFloat());
        return;
    L9:
        return;
    L5:
        r1 = r0.getWindow();
        goto L6
    }

    static {
    }

    public ActionSheetDialogFragment() {
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment
    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        Bundle r4 = getArguments();
        this.h = r4.getString("contentClass", "");
        this.i = r4.getBundle("contentArgs");
        aa0(2131100545);
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment
    public final void onViewCreated(View r5, Bundle r6) {
        super.onViewCreated(r5, r6);
        Bundle r7 = this.i;
        if (r7 == null) goto L7;
        int r8 = r7.getInt("maxWidth", 0);
        if (r8 <= 0) goto L7;
        r5.findViewById(2131393346).setMaxWidth(r8);
    L7:
        a r9 = Fragment.instantiate(getContext(), this.h, this.i);
        if ((r9 instanceof a) == false) goto L12;
        final a r10 = r9;
        r10.uC(new hw4.a(this));
        Dialog r2 = getDialog();
        if (r2 == null) goto L12;
        r2.setOnKeyListener(new hw4.b(r10));
    L12:
        FragmentTransaction r11 = getChildFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r11, r9, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, 2131393346) == true) goto L16;
        r11 = r11.replace(2131393346, r9);
    L16:
        r11.commitAllowingStateLoss();
        ((zo5.b) org.koin.java.a.a(zo5.b.class)).s(getDialog());
        f r12 = WindowInsetsUtils.b(this);
        r12.o(true);
        r12.c(false);
    }

    public static void ba0(FragmentActivity r3, Class r4, Bundle r5) {
        Bundle r0 = new Bundle();
        r0.putString("contentClass", r4.getName());
        r0.putBundle("contentArgs", r5);
        if (com.bytedance.ee.util.ui.b.a(r3) == false) goto L13;
        Fragment r6 = (ActionSheetDialogFragment) Fragment.instantiate(r3, ActionSheetDialogFragment.class.getName(), r0);
        FragmentManager r7 = r3.getSupportFragmentManager();
        String r8 = r4.getName();
        if ((r6 instanceof Fragment) == false) goto L7;
        Fragment r1 = r6;
    L8:
        LandscapeRestrictionOperation r2 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r1, r8, r2);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r7, r1, r2) == true) goto L19;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L15
    L12:
        r6.show(r7, r8);
        return;
    L19:
        return;
    L7:
        r1 = null;
        goto L8
    L13:
        tt5.a.e("ActionSheetDialogFrag", "show when activity not active", new IllegalStateException(), false);
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment
    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        return r2.inflate(2131560014, r3, false);
    }

    public static void ca0(FragmentActivity r2, Class r3, Bundle r4, View r5) {
        Bundle r0 = new Bundle();
        String r6 = r3.getName();
        r0.putString("contentClass", r6);
        r0.putBundle("contentArgs", r4);
        if (com.bytedance.ee.util.ui.b.a(r2) == false) goto L8;
        ActionSheetDialogFragment r7 = Fragment.instantiate(r2, ActionSheetDialogFragment.class.getName(), r0);
        if (ForsetiHelper.o() == false) goto L7;
        com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.f.g(r7, r2, ForsetiNavOptions.DestinationStyle.HALF_FLOAT, r5, r6);
        return;
    L7:
        com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.f.g(r7, r2, ForsetiNavOptions.DestinationStyle.HALF_FLOAT, null, r6);
        return;
    L8:
        tt5.a.e("ActionSheetDialogFrag", "show when activity not active", new IllegalStateException(), false);
    }
}
