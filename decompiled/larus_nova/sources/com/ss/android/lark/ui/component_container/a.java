package com.ss.android.lark.ui.component_container;

import android.R;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.base.fragment.BaseFragment;
import com.ss.android.lark.desktopmode.app.DesktopCompatFragment;
import com.ss.android.lark.desktopmode.base.FragmentParams;
import com.ss.android.lark.forsetiutils.ForsetiFGHelpers;
import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class a {
    public static final boolean e(FragmentActivity r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Fragment r101 = r100.getSupportFragmentManager().findFragmentByTag("ResponsiveBaseFragment");
        if ((r101 instanceof ResponsiveBaseFragment) == false) goto L5;
        ResponsiveBaseFragment r102 = (ResponsiveBaseFragment) r101;
    L6:
        if (r102 == null) goto L8;
        return true;
    L8:
        return false;
    L5:
        r102 = null;
        goto L6
    }

    public static final void c(FragmentActivity r100, Intent r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Fragment r102 = r100.getSupportFragmentManager().findFragmentByTag("ResponsiveBaseFragment");
        if ((r102 instanceof ResponsiveBaseFragment) == false) goto L5;
        ResponsiveBaseFragment r103 = (ResponsiveBaseFragment) r102;
    L6:
        StringBuilder r104 = new StringBuilder("detachToContainer containerFragment is null: ");
        if (r103 != null) goto L9;
        boolean r105 = true;
    L10:
        r104.append(r105);
        Log.i("ResponsiveBaseFragment", r104.toString());
        if (r103 == null) goto L13;
        r103.S90(r101);
        return;
    L13:
        if (r101 == null) goto L15;
        r100.setResult(-1, r101);
    L15:
        r100.finish();
        return;
    L9:
        r105 = false;
        goto L10
    L5:
        r103 = null;
        goto L6
    }

    public static final <T extends FragmentParams> void d(DesktopCompatFragment<T> r100, Intent r101) {
        StringBuilder r102 = new StringBuilder("goBackInResponsiveComponent intent is null: ");
        if (r101 != null) goto L5;
        boolean r103 = true;
    L6:
        r102.append(r103);
        Log.i("ResponsiveBaseFragment", r102.toString());
        if (r100 != null) goto L10;
        return;
    L10:
        if (ForsetiFGHelpers.d() == true) goto L13;
        r100.finish();
        return;
    L13:
        FragmentActivity r104 = r100.getActivity();
        if (r104 == null) goto L17;
        c(r104, r101);
        return;
    L17:
        return;
    L5:
        r103 = false;
        goto L6
    }

    public static final ResponsiveBaseFragment a(Fragment r100, FragmentActivity r101, String r102, ResponsiveContainerOptions r103) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "activity");
        Intrinsics.checkNotNullParameter(r103, "options");
        Log.i("ResponsiveBaseFragment", "attachToContainer to responsive container sourceFragment : " + r100.getClass().getName() + "}options : " + r103);
        ResponsiveBaseFragment r104 = new ResponsiveBaseFragment();
        FragmentTransaction r105 = r101.getSupportFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r105, r104, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, "ResponsiveBaseFragment", R.id.content) == true) goto L6;
        r105 = r105.add(R.id.content, r104, "ResponsiveBaseFragment");
    L6:
        r105.commitAllowingStateLoss();
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r103, "options");
        r104.f444580g = r100;
        r104.f444581h = r102;
        r104.f444584k = r103.getInsetsCompat();
        r104.f444585l = r103.getSwipeToDismissEnabled();
        r104.f444586m = r103.getBackgroundStrategy();
        r104.f444588o = r103.getEnableDynamicBackground();
        return r104;
    }

    public static final ResponsiveBaseFragment b(BaseFragment r100, FragmentActivity r101, String r102, Boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "activity");
        ResponsiveContainerOptions.a r104 = new ResponsiveContainerOptions.a();
        if (r103 == null) goto L5;
        boolean r105 = r103.booleanValue();
    L6:
        r104.f444599a = r105;
        return a(r100, r101, r102, r104.a());
    L5:
        r105 = true;
        goto L6
    }
}
