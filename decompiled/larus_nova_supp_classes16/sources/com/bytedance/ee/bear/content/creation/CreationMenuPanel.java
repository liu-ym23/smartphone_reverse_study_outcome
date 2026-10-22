package com.bytedance.ee.bear.content.creation;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.crash.d;
import com.bytedance.ee.bear.bizwidget.dialogfragment.BaseDialogFragment;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.f;
import com.bytedance.ee.bear.content.creation.mvp.SelectCreationMenuFragment;
import com.bytedance.ee.bear.content.creation.mvp.SelectCreationMenuItem;
import com.bytedance.ee.bear.content.creation.mvp.e;
import com.bytedance.ee.bear.widgets.t;
import com.bytedance.ee.util.ui.n;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.suite.lark.component.navroute.forseti.ForsetiNavOptions;
import iw4.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class CreationMenuPanel extends BaseDialogFragment {
    public static final /* synthetic */ int k = 0;
    public boolean h;
    public boolean i;
    public long j;

    public class a extends t {
        public final /* synthetic */ CreationMenuPanel c;

        public a(CreationMenuPanel r1) {
            this.c = r1;
        }

        public final void a(View r2) {
            this.c.dismissAllowingStateLoss();     // Catch: Exception -> L5
        L9:
            CreationMenuPanel r3 = this.c;
            int r0 = CreationMenuPanel.k;
            r3.ea0();
            return;
        L5:
            e = move-exception;
            d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r4 = DialogFragmentLancet.sLastShowStack;
            if (r4 == null) goto L9;
            d.d(r4, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            goto L9
        }
    }

    public class b extends t {
        public final /* synthetic */ CreationMenuPanel c;

        public b(CreationMenuPanel r1) {
            this.c = r1;
        }

        public final void a(View r2) {
            this.c.dismissAllowingStateLoss();     // Catch: Exception -> L5
        L9:
            CreationMenuPanel r3 = this.c;
            int r0 = CreationMenuPanel.k;
            r3.ea0();
            return;
        L5:
            e = move-exception;
            d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r4 = DialogFragmentLancet.sLastShowStack;
            if (r4 == null) goto L9;
            d.d(r4, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            goto L9
        }
    }

    public final void da0() {
    L11:
        th = move-exception;
        tt5.a.f("CreationMenuPanel", th, false);
        iu5.d.a("CreationMenuPanel_dismissIgnoreErr()", th);
        return;
    L4:
        if (isAdded() == true) goto L17;
        tt5.a.d("CreationMenuPanel", "fragment is not add");     // Catch: Throwable -> L11
    L19:
        return;
    L17:
        super.dismissAllowingStateLoss();     // Catch: Exception -> L7 Throwable -> L11
    L7:
        e = move-exception;
        d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r1 = DialogFragmentLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r1 == null) goto L19;
        d.d(r1, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L19
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment
    public final void dismissAllowingStateLoss() {
        Dialog r0 = getDialog();
        if (r0 != null) goto L5;
    L9:
        Dialog r1 = getDialog();
        if (r1 != null) goto L12;
    L18:
        boolean r2 = false;
    L19:
        if (r2 == false) goto L23;
        da0();
        return;
    L23:
        return;
    L12:
        if (r1.getWindow() == null) goto L18;
        if (ba0(r1.getWindow()).getVisibility() != 8) goto L16;
    L17:
        r2 = true;
        goto L19
    L16:
        if (ba0(r1.getWindow()).getVisibility() != 4) goto L18;
    L5:
        if (r0.isShowing() == false) goto L9;
        if (getView() == null) goto L9;
        getView().animate().y(n.t()).withEndAction(new c(this)).setDuration(250).start();
    }

    public final void ea0() {
        Fragment r0 = getChildFragmentManager().findFragmentById(2131393346);
        if ((r0 instanceof SelectCreationMenuFragment) == false) goto L8;
        e r1 = ((SelectCreationMenuFragment) r0).f;
        if (r1 == null) goto L9;
        SelectCreationMenuViewModel r2 = r1.b;
        iw4.b.a r3 = new iw4.b.a();
        r3.a = SelectCreationMenuItem.ItemType.CANCEL;
        r3.b = r1.d;
        r3.c = r1.c;
        r3.d = r1.e;
        r3.e = r1.f;
        r3.f = r1.h;
        r3.g = r1.i;
        r3.h = r1.k;
        r2.setOnClickCreationMenuItem(new iw4.b(r3));
        return;
    L9:
        return;
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment
    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        final Dialog r0 = getDialog();
        if (r0 != null) goto L5;
    L9:
        super.onStart();
        if (r0 != null) goto L12;
        Window r1 = null;
    L13:
        if (r1 == null) goto L15;
        WindowManager.LayoutParams r2 = r1.getAttributes();
        r2.width = -1;
        r2.height = -2;
        r2.gravity = 80;
        r1.setAttributes(r2);
    L15:
        Z90(0);
        return;
    L12:
        r1 = r0.getWindow();
        goto L13
    L5:
        if (this.h == true) goto L9;
        if (getView() == null) goto L9;
        this.h = true;
        final View r3 = getView();
        r3.post(new iw4.d(this, r3, r0));
        goto L9
    }

    public CreationMenuPanel() {
    }

    public static View ba0(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    public static void ca0(CreationMenuPanel r3, FragmentManager r4) {
        if ((r3 instanceof Fragment) == false) goto L5;
        CreationMenuPanel r0 = r3;
    L6:
        LandscapeRestrictionOperation r1 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r0, "CreationMenuPanel", r1);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r4, r0, r1) == false) goto L13;
        return;
    L13:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
    L10:
        r3.show(r4, "CreationMenuPanel");
        return;
    L5:
        r0 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment
    public final void onViewCreated(View r6, Bundle r7) {
        super.onViewCreated(r6, r7);
        if (getArguments() != null) goto L12;
        tt5.a.d("CreationMenuPanel", "args is null !!!");
        dismissAllowingStateLoss();     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r8 = DialogFragmentLancet.sLastShowStack;
        if (r8 == null) goto L29;
        d.d(r8, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L29:
        return;
    L12:
        Fragment r9 = Fragment.instantiate(getContext(), SelectCreationMenuFragment.class.getName(), getArguments());
        this.i = getArguments().getBoolean("report_click_cancel", false);
        tt5.a.h("CreationMenuPanel", "onViewCreated()...reportClickCancel = " + this.i);
        FragmentTransaction r1 = getChildFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r1, r9, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, 2131393346) == true) goto L16;
        r1 = r1.replace(2131393346, r9);
    L16:
        r1.commitAllowingStateLoss();
        View r10 = r6.findViewById(2131366973);
        if (r10 == null) goto L19;
        r10.setOnClickListener(new a(this));
    L19:
        View r11 = r6.findViewById(2131382380);
        if (r11 == null) goto L22;
        r11.setOnClickListener(new b(this));
    L22:
        Dialog r12 = getDialog();
        if (r12 != null) goto L25;
        tt5.a.d("CreationMenuPanel", "addWatermark()... dialog == null");
        return;
    L25:
        ((zo5.b) org.koin.java.a.a(zo5.b.class)).s(r12);
    }

    public static CreationMenuPanel fa0(final FragmentActivity r10, Bundle r11, View r12) {
        final CreationMenuPanel r13 = Fragment.instantiate(r10, CreationMenuPanel.class.getName(), r11);
        r13.setStyle(0, 2131953441);
        if (ForsetiHelper.t(r10) == true) goto L5;
    L9:
        ca0(r13, r10.getSupportFragmentManager());
    L10:
        return r13;
    L5:
        if (ForsetiHelper.o() == false) goto L9;
        if (ForsetiHelper.q(r10) == false) goto L9;
        f.f(r13, r10, ForsetiNavOptions.DestinationStyle.HALF_FLOAT, false, r12, -2, "CreationMenuPanel", null, false, new iw4.e(r13, r10));
        goto L10
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment
    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        if (ForsetiHelper.s(this) == false) goto L11;
        if (ForsetiHelper.o() == false) goto L11;
        if (ForsetiHelper.q(getActivity()) == false) goto L11;
        return r2.inflate(2131560014, r3, false);
    L11:
        return r2.inflate(2131559936, r3, false);
    }
}
