package com.bytedance.ee.bear.share;

import android.app.Dialog;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.share.export.SharePanelState;
import com.bytedance.ee.bear.share.export.ShareParams;
import com.bytedance.ee.bear.share.newshare.BaseShareFragment;
import com.bytedance.ee.bear.share.newshare.ShareDocFragment;
import com.bytedance.ee.bear.share.newshare.ShareFolderFragment;
import com.bytedance.ee.bear.share.newshare.ShareFragmentExtend;
import com.bytedance.ee.bear.share.newshare.c0;
import com.bytedance.ee.bear.share.newshare.extension.BaseShareProvider;
import com.bytedance.ee.bear.share.view.ShareNewFragment;
import com.bytedance.ee.bear.share.view.ShareViewModel;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f implements com.bytedance.ee.bear.share.export.a {
    public static BaseShareFragment b;
    public c0 a;

    public f() {
    }

    @Override // com.bytedance.ee.bear.share.export.a
    public final void X9() {
        c0 r0 = this.a;
        if (r0 == null) goto L6;
        r0.f().a();
    L6:
        if (b == null) goto L18;
        tt5.a.h("ShareApiImpl", "dismissShareFragment()...");
        b.dismissAllowingStateLoss();     // Catch: Exception -> L10
    L14:
        b = null;
        return;
    L10:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r1 = DialogFragmentLancet.sLastShowStack;
        if (r1 == null) goto L14;
        com.bytedance.crash.d.d(r1, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L14
    }

    @Override // com.bytedance.ee.bear.share.export.a
    public final e Y9() {
        return new e();
    }

    @Override // com.bytedance.ee.bear.share.export.a
    public final void ba() {
        c0 r0 = this.a;
        if (r0 == null) goto L6;
        r0.getClass();
    L6:
        if (b == null) goto L14;
        tt5.a.h("ShareApiImpl", "hideShareFragment()...");
        BaseShareFragment r1 = b;
        if (r1.xa0() == false) goto L15;
        Dialog r2 = r1.getDialog();
        if (r2 == null) goto L12;
        r2.hide();
    L12:
        r1.pa0().H9(r1, SharePanelState.NOT_SHOW, r1.ga0());
        return;
    L15:
        return;
    }

    @Override // com.bytedance.ee.bear.share.export.a
    public final void ca() {
        c0 r0 = this.a;
        if (r0 == null) goto L5;
        r0.j();
    L5:
        BaseShareFragment r1 = b;
        if (r1 == null) goto L9;
        r1.Pa0();
        return;
    }

    @Override // com.bytedance.ee.bear.share.export.a
    public final com.bytedance.ee.bear.share.notification.a da() {
        return new com.bytedance.ee.bear.share.notification.a();
    }

    @Override // com.bytedance.ee.bear.share.export.a
    public final void ja() {
        c0 r0 = this.a;
        if (r0 == null) goto L8;
        if (r0.f().isShowing() == true) goto L8;
        r0.f().e();
    L8:
        if (b == null) goto L23;
        tt5.a.h("ShareApiImpl", "showShareFragment()...");
        BaseShareFragment r1 = b;
        if (r1.xa0() == true) goto L24;
        Dialog r2 = r1.getDialog();
        if (r2 != null) goto L14;
    L18:
        r1.pa0().H9(r1, SharePanelState.SHOWING, r1.ga0());
        return;
    L14:
        if (DialogLancet.shouldBlockDialogShow(r2) == false) goto L21;
        DialogLancet.handleBlockedDialogShow(r2);
        goto L18
    L21:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L20
    L17:
        DialogLancet.beforeDialogShow(r2);
        r2.show();
        DialogLancet.afterDialogShow(r2);
        goto L18
    L24:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.share.export.a
    public final ShareFolderFragment Z9(ShareParams r5) {
        int r0 = ShareFolderFragment.C;
        Intrinsics.checkNotNullParameter(r5, "params");
        Bundle r1 = new Bundle();
        r1.putSerializable("extra_params", r5);
        long r2 = System.currentTimeMillis();
        r1.putLong("analytics_open_time_t1_start", r2);
        r1.putLong("analytics_open_time_t1_end", r2);
        String r3 = ShareFolderFragment.class.getName();
        Fragment r4 = Fragment.instantiate(r5.getActivity(), r3, r1);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type com.bytedance.ee.bear.share.newshare.ShareFolderFragment");
        Fragment r6 = (ShareFolderFragment) r4;
        FragmentManager r7 = r5.getActivity().getSupportFragmentManager();
        if ((r6 instanceof Fragment) == false) goto L5;
        Fragment r8 = r6;
    L6:
        LandscapeRestrictionOperation r9 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r8, r3, r9);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r7, r8, r9) == false) goto L13;
    L11:
        return r6;
    L13:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
    L10:
        r6.show(r7, r3);
        goto L11
    L5:
        r8 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.share.export.a
    public final mm5.a fa(com.bytedance.ee.bear.share.export.h r2) {
        return new mm5.a(r2);
    }

    @Override // com.bytedance.ee.bear.share.export.a
    public final void ga(DialogFragment r1) {
        b = (BaseShareFragment) r1;
    }

    @Override // com.bytedance.ee.bear.share.export.a
    public final void ia(c0 r1) {
        this.a = r1;
    }

    @Override // com.bytedance.ee.bear.share.export.a
    public final void ea(String r5, String r6) {
        String[] r0 = ShareAnalytic.a;
        HashMap r1 = new HashMap();
        r1.put("source", "innerpage");
        if (r5 != null) goto L5;
        String r2 = "";
    L6:
        r1.put("module", r2);
        r1.put("action", "share");
        if (r5 != null) goto L9;
        r5 = "";
    L9:
        r1.put("file_type", r5);
        r1.put("file_id", du5.b.g(r6));
        ((com.bytedance.ee.bear.contract.d) ShareAnalytic.b.getValue()).v("client_content_management", r1);
        return;
    L5:
        r2 = r5;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.share.export.a
    public final ShareDocFragment aa(ShareParams r7, Bundle r8, com.bytedance.ee.bear.document.share.a.a r9) {
        com.bytedance.ee.bear.share.export.h r0 = ShareDocFragment.U;
        Intrinsics.checkNotNullParameter(r7, "params");
        if (r8 != null) goto L5;
    L7:
        Bundle r1 = new Bundle();
        r1.putSerializable("extra_params", r7);
        if (r8 == null) goto L10;
        r1.putBundle("extra_reminder_binder", r8);
    L10:
        long r2 = System.currentTimeMillis();
        if (r8 == null) goto L15;
        boolean r5 = true;
        if (r8.containsKey("analytics_open_time_t1_start") != true) goto L15;
    L16:
        if (r5 == false) goto L18;
        long r4 = r8.getLong("analytics_open_time_t1_start");
    L19:
        r1.putLong("analytics_open_time_t1_start", r4);
        r1.putLong("analytics_open_time_t1_end", r2);
        ShareDocFragment.U = r9;
        String r10 = ShareDocFragment.class.getName();
        Fragment r11 = Fragment.instantiate(r7.getActivity(), r10, r1);
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type com.bytedance.ee.bear.share.newshare.ShareDocFragment");
        Fragment r12 = (ShareDocFragment) r11;
        if (r7.getActivity().getSupportFragmentManager().isDestroyed() == true) goto L30;
        FragmentManager r13 = r7.getActivity().getSupportFragmentManager();
        if ((r12 instanceof Fragment) == false) goto L24;
        Fragment r3 = r12;
    L25:
        LandscapeRestrictionOperation r6 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r3, r10, r6);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r13, r3, r6) == true) goto L30;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L31
    L29:
        r12.show(r13, r10);
        goto L30
    L24:
        r3 = null;
    L30:
        return r12;
    L18:
        r4 = r2;
    L15:
        r5 = false;
        goto L16
    L5:
        if (r8.getClassLoader() != null) goto L7;
        r8.setClassLoader(ShareDocFragment.a.class.getClassLoader());
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.share.export.a
    public final ShareNewFragment ha(ShareParams r10, Bundle r11, BaseShareProvider r12) {
        int r0 = ShareNewFragment.p;
        Intrinsics.checkNotNullParameter(r10, "params");
        if (r11 != null) goto L5;
    L7:
        Bundle r1 = new Bundle();
        r1.putSerializable("extra_params", r10);
        if (r11 == null) goto L10;
        r1.putBundle("extra_reminder_binder", r11);
    L10:
        long r2 = System.currentTimeMillis();
        if (r11 == null) goto L15;
        boolean r5 = true;
        if (r11.containsKey("analytics_open_time_t1_start") != true) goto L15;
    L16:
        if (r5 == false) goto L18;
        long r4 = r11.getLong("analytics_open_time_t1_start");
    L19:
        r1.putLong("analytics_open_time_t1_start", r4);
        r1.putLong("analytics_open_time_t1_end", r2);
        String r13 = ShareNewFragment.class.getName();
        Fragment r3 = Fragment.instantiate(r10.getActivity(), r13, r1);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.bytedance.ee.bear.share.view.ShareNewFragment");
        Fragment r6 = (ShareNewFragment) r3;
        if (r10.getActivity().getSupportFragmentManager().isDestroyed() == true) goto L35;
        if (ForsetiHelper.s(r10.getSourceFragment()) == true) goto L24;
    L25:
        FragmentManager r7 = r10.getActivity().getSupportFragmentManager();
        if ((r6 instanceof Fragment) == false) goto L28;
        Fragment r8 = r6;
    L29:
        LandscapeRestrictionOperation r9 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r8, r13, r9);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r7, r8, r9) == true) goto L35;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L40
    L33:
        r6.show(r7, r13);
        goto L35
    L28:
        r8 = null;
        goto L29
    L24:
        if (com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.f.e(r6, r10.getSourceFragment(), null, false, 0, false, 62) == false) goto L25;
    L35:
        if (ForsetiHelper.s(r10.getSourceFragment()) == false) goto L37;
        ShareViewModel r14 = new ShareViewModel();
    L38:
        r14.init(r12);
        r6.getClass();
        Intrinsics.checkNotNullParameter(r14, "viewModel");
        r6.m = r14;
        return r6;
    L37:
        r14 = (ShareViewModel) ViewModelProviders.of(r10.getActivity()).get(ShareViewModel.class);
        goto L38
    L18:
        r4 = r2;
    L15:
        r5 = false;
        goto L16
    L5:
        if (r11.getClassLoader() != null) goto L7;
        r11.setClassLoader(ShareNewFragment.a.class.getClassLoader());
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.share.export.a
    public final ShareFragmentExtend ka(ShareParams r9, Bundle r10, com.bytedance.ee.bear.bitable.share.sharepanel.a r11, com.bytedance.ee.bear.bitable.share.sharepanel.a r12) {
        int r0 = ShareFragmentExtend.C;
        Intrinsics.checkNotNullParameter(r9, "params");
        if (r10.getClassLoader() != null) goto L5;
        r10.setClassLoader(ClassLoader.getSystemClassLoader());
    L5:
        Bundle r1 = new Bundle();
        r1.putSerializable("extra_params", r9);
        long r2 = System.currentTimeMillis();
        if (r10.containsKey("analytics_open_time_t1_start") == false) goto L8;
        r2 = r10.getLong("analytics_open_time_t1_start");
    L8:
        r1.putLong("analytics_open_time_t1_start", r2);
        r1.putLong("analytics_open_time_t1_end", r2);
        String r13 = ShareFragmentExtend.class.getName();
        Fragment r14 = Fragment.instantiate(r9.getActivity(), r13, r1);
        Intrinsics.checkNotNull(r14, "null cannot be cast to non-null type com.bytedance.ee.bear.share.newshare.ShareFragmentExtend");
        Fragment r15 = (ShareFragmentExtend) r14;
        String r3 = ShareNewFragment.class.getName();
        if (r9.getActivity().getSupportFragmentManager().isDestroyed() == false) goto L11;
    L24:
        r15.getClass();
        Intrinsics.checkNotNullParameter(r11, "shareFragmentDelegate");
        r15.A = r11;
        Intrinsics.checkNotNullParameter(r12, "shareActionDelegate");
        r15.B = r12;
        return r15;
    L11:
        if (ForsetiHelper.s(r9.getSourceFragment()) == true) goto L13;
    L15:
        FragmentManager r16 = r9.getActivity().getSupportFragmentManager();
        if ((r15 instanceof Fragment) == false) goto L18;
        Fragment r4 = r15;
    L19:
        LandscapeRestrictionOperation r5 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r4, r3, r5);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r16, r4, r5) == true) goto L24;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L26
    L23:
        r15.show(r16, r3);
        goto L24
    L18:
        r4 = null;
        goto L19
    L13:
        if (com.bytedance.ee.bear.appsetting.c.a.a.h("ccm.bitable.big_screen_panel_adaptation") == false) goto L15;
        com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.f.e(r15, r9.getSourceFragment(), null, false, 0, false, 62);
        goto L24
    }
}
