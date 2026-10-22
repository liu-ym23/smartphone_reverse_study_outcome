package com.bytedance.ee.bear.bizwidget.dialogfragment;

import android.content.Context;
import android.view.Window;
import androidx.core.graphics.ColorUtils;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment;
import com.bytedance.ee.bear.bizwidget.shareview.ShareItemModel;
import com.larksuite.framework.utils.UIUtils;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class BaseDialogFragment extends BaseAntiScreenshotsDialogFragment {
    public BaseDialogFragment() {
    }

    public final void Z90(int r3) {
        if (getDialog() != null) goto L5;
        return;
    L5:
        if (getDialog().getWindow() == null) goto L9;
        bp5.c.f(getDialog().getWindow(), r3, false);
        return;
    }

    public final void aa0(int r7) {
        Context r0 = getContext();
        if (r0 == null) goto L13;
        int r1 = UIUtils.getColor(r0, r7);
        if (ColorUtils.calculateContrast(-1, r1) <= 3.0d) goto L8;
        Z90(r1);
        goto L13
    L8:
        if (getDialog() == null) goto L13;
        if (getDialog().getWindow() == null) goto L13;
        bp5.c.f(getDialog().getWindow(), r1, true);
    L13:
        Context r2 = getContext();
        if (r2 != null) goto L17;
        return;
    L17:
        if (getDialog() != null) goto L19;
        return;
    L19:
        if (getDialog().getWindow() == null) goto L23;
        Window r3 = getDialog().getWindow();
        r3.addFlags(ShareItemModel.SRC_TINT_UNDEFINED);
        r3.clearFlags(134217728);
        r3.setNavigationBarColor(UIUtils.getColor(r2, r7));
        return;
    }

    public final void show(FragmentManager r3, String r4) {
        setStyle(0, 2131953441);
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
        super.show(r3, r4);
        return;
    }
}
