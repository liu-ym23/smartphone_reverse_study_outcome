package com.bytedance.ee.bear.bizwidget.dialogfragment;

import android.app.Dialog;
import android.content.res.Configuration;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.WindowManager;
import com.bytedance.ee.bear.document.pageedit.AddMemberFragment;
import com.bytedance.ee.util.ui.n;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\u0007H\u0002J\u001a\u0010\f\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0005H\u0014J\b\u0010\u0010\u001a\u00020\u0005H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ee/bear/bizwidget/dialogfragment/OrientationBaseDialogFragment;", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/BaseDialogFragment;", "<init>", "()V", "isNewStart", "", "onStart", "", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "adjustWindowParams", "adjustWindowHeight", "attributes", "Landroid/view/WindowManager$LayoutParams;", "isLandscape", "isSupportScreenLandscape", "framework-biz-widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class OrientationBaseDialogFragment extends BaseDialogFragment {
    public boolean h;

    public void ba0(WindowManager.LayoutParams r1, boolean r2) {
    }

    public boolean da0() {
        return this instanceof AddMemberFragment;
    }

    public OrientationBaseDialogFragment() {
        this.h = true;
    }

    private final void ca0() {
        if (da0() == true) goto L5;
        return;
    L5:
        Dialog r0 = getDialog();
        WindowInsetsController r1 = null;
        if (r0 == null) goto L8;
        Window r2 = r0.getWindow();
    L9:
        if (r0 == null) goto L32;
        if (r2 == null) goto L33;
        WindowManager.LayoutParams r3 = r2.getAttributes();
        int r4 = Build.VERSION.SDK_INT;
        if (r4 < 30) goto L20;
        View r5 = r2.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L18;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r6 = ThreadMethodProxy.currentThread();
        if (r6 == com.larus.home.impl.utils.c.a) goto L18;
        com.larus.home.impl.utils.c.a(r6, "getDecorView");
    L18:
        r1 = r5.getWindowInsetsController();
    L20:
        if (cu5.c.e(getActivity()) == false) goto L26;
        r2.setFlags(1024, 1024);
        r2.setGravity(1);
        if (r1 == null) goto L25;
        if (r4 < 30) goto L25;
        r1.hide(WindowInsets.Type.statusBars());
    L25:
        r3.width = (int) (n.q(getActivity()) * 0.7f);
        ba0(r3, true);
    L30:
        r2.setAttributes(r3);
        return;
    L26:
        if (r1 == null) goto L29;
        if (r4 < 30) goto L29;
        r1.show(WindowInsets.Type.statusBars());
    L29:
        r3.width = -1;
        ba0(r3, false);
        goto L30
    L33:
        return;
    L32:
        return;
    L8:
        r2 = null;
        goto L9
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment
    public void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        if (this.h == false) goto L6;
        this.h = false;
        ca0();
        return;
    }

    public final void onConfigurationChanged(Configuration r2) {
        Intrinsics.checkNotNullParameter(r2, "newConfig");
        super/*androidx.fragment.app.Fragment*/.onConfigurationChanged(r2);
        ca0();
    }
}
