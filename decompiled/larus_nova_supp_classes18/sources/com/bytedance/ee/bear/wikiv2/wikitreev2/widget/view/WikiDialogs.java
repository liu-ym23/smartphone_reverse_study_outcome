package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.route.parcelable.WikNodePerm;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.list.t4;
import com.bytedance.ee.bear.middleground.feed.export.bean.DocFeed$Value$Result;
import com.bytedance.ee.bear.middleground.feed.export.bean.panelv2.Notice;
import com.bytedance.ee.bear.more.protocol3.extension.BaseMoreProvider;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEditText;
import com.bytedance.ee.bear.wikiv2.create.WikiCreateSelectPanelDialog;
import com.bytedance.ee.bear.wikiv2.wikitreev2.move.apply.ApplyMoveWikiToSpaceFragment;
import com.bytedance.ee.bear.wikiv2.wikitreev2.move.apply.ApplyMoveWikiToWikiFragment;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.SpaceInfo;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.WikNodeType;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.WikiDetailInfo;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.dialog.WikiDeleteConfirmDialog;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.dialog.WikiDeleteConfirmDialog$Companion$show$1;
import com.larksuite.component.ui.dialog.LKUIDialog;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larksuite.framework.utils.KeyboardUtils;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.utils.ContextsKt;
import com.suite.lark.component.navroute.forseti.ForsetiNavOptions;
import java.lang.reflect.Field;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class WikiDialogs {
    public static final /* synthetic */ int n = 0;
    public com.bytedance.ee.bear.bizwidget.d a;
    public UDDialog b;
    public LKUIDialog c;
    public UDDialog d;
    public WikiCreateSelectPanelDialog e;
    public UDDialog f;
    public UDDialog g;
    public ApplyMoveWikiToSpaceFragment h;
    public ApplyMoveWikiToWikiFragment i;
    public UDDialog j;
    public SpaceEditText k;
    public BaseMoreProvider l;
    public WikiDeleteConfirmDialog m;

    public static final class a {
        public static String a(boolean r3, String r4, Context r5) {
            if (com.bytedance.ee.bear.appsetting.c.a.a.g("lark.scs.legalhold.delete") == false) goto L5;
            int r0 = 60;
        L6:
            String r1 = String.valueOf(r0);
            if (r3 == true) goto L9;
            Pair[] r6 = new Pair[2];
            if (r4 != null) goto L13;
            r4 = "";
        L13:
            r6[0] = TuplesKt.to("WikiSpaceName", r4);
            r6[1] = TuplesKt.to("num", r1);
            return xo5.a.d(r5, 2131889581, MapsKt.mapOf(r6));
        L9:
            return xo5.a.c(r5, 2131889588, "num", r1);
        L5:
            r0 = 30;
            goto L6
        }
    }

    public interface b {
        void a();

        void b(SpaceInfo r1);

        void c(boolean r1);

        void d(SpaceInfo r1);

        void e();

        void f();

        void g(boolean r1);

        void h(boolean r1);

        void i();

        void onDismiss();
    }

    public static final class c implements UDToast.b {
        public final /* synthetic */ View.OnClickListener a;

        public c(View.OnClickListener r1) {
            this.a = r1;
        }

        public final void a(com.ss.android.lark.compose.foundation.toast.b r3) {
            Intrinsics.checkNotNullParameter(r3, Notice.CLICK_TYPE_TOAST);
            if (com.bytedance.ee.util.ui.h.a(500) == false) goto L6;
            r3.cancel();
            this.a.onClick(null);
            return;
        }
    }

    public static final class d implements DialogInterface.OnClickListener {
        public final /* synthetic */ WikiDeleteConfirmDialog.b a;

        public d(WikiDeleteConfirmDialog.b r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r1, int r2) {
            this.a.b();
        }
    }

    public static final class e implements DialogInterface.OnClickListener {
        public final /* synthetic */ WikiDeleteConfirmDialog.b a;

        public e(WikiDeleteConfirmDialog.b r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r1, int r2) {
            this.a.onCancel();
        }
    }

    public static final class f implements gp5.a.InterfaceC0236a {
        public final /* synthetic */ gp5.a.InterfaceC0236a a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ WikiDialogs c;

        @Override // gp5.a.InterfaceC0236a
        public final void a(String r2) {
            Intrinsics.checkNotNullParameter(r2, "text");
            this.a.a(r2);
            KeyboardUtils.hideKeyboard(ContextsKt.findActivity(this.b), this.c.k);
        }

        public f(gp5.a.InterfaceC0236a r1, Context r2, WikiDialogs r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class g implements gp5.a.InterfaceC0236a {
        public final /* synthetic */ Context a;
        public final /* synthetic */ WikiDialogs b;

        @Override // gp5.a.InterfaceC0236a
        public final void a(String r2) {
            Intrinsics.checkNotNullParameter(r2, "text");
            KeyboardUtils.hideKeyboard(ContextsKt.findActivity(this.a), this.b.k);
        }

        public g(Context r1, WikiDialogs r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class h implements DialogInterface.OnClickListener {
        public final /* synthetic */ View.OnClickListener a;

        public h(View.OnClickListener r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r1, int r2) {
            this.a.onClick(null);
        }
    }

    public static final class i implements DialogInterface.OnClickListener {
        public final /* synthetic */ View.OnClickListener a;

        public i(View.OnClickListener r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r1, int r2) {
            this.a.onClick(null);
        }
    }

    static {
    }

    public WikiDialogs() {
    }

    public final void c() {
        UDDialog r0 = this.b;
        if (r0 != null) goto L5;
    L7:
        LKUIDialog r1 = this.c;
        if (r1 != null) goto L10;
    L28:
        UDDialog r2 = this.d;
        if (r2 != null) goto L31;
    L33:
        UDDialog r3 = this.f;
        if (r3 != null) goto L36;
    L38:
        ApplyMoveWikiToSpaceFragment r4 = this.h;
        boolean r5 = false;
        if (r4 == null) goto L51;
        Dialog r6 = r4.getDialog();
        if (r6 == null) goto L43;
        boolean r7 = r6.isShowing();
    L44:
        if (r7 == false) goto L51;
        r4.dismissAllowingStateLoss();     // Catch: Exception -> L47
    L47:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r8 = DialogFragmentLancet.sLastShowStack;
        if (r8 == null) goto L51;
        com.bytedance.crash.d.d(r8, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L51
    L43:
        r7 = false;
    L51:
        ApplyMoveWikiToWikiFragment r9 = this.i;
        if (r9 == null) goto L64;
        Dialog r10 = r9.getDialog();
        if (r10 == null) goto L56;
        boolean r11 = r10.isShowing();
    L57:
        if (r11 == false) goto L64;
        r9.dismissAllowingStateLoss();     // Catch: Exception -> L60
    L60:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r12 = DialogFragmentLancet.sLastShowStack;
        if (r12 == null) goto L64;
        com.bytedance.crash.d.d(r12, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L64
    L56:
        r11 = false;
    L64:
        UDDialog r13 = this.g;
        if (r13 != null) goto L67;
    L69:
        UDDialog r14 = this.j;
        if (r14 != null) goto L72;
    L90:
        BaseMoreProvider r15 = this.l;
        if (r15 == null) goto L93;
        r15.c();
    L93:
        WikiDeleteConfirmDialog r16 = this.m;
        if (r16 == null) goto L120;
        Dialog r17 = r16.getDialog();
        if (r17 != null) goto L98;
    L100:
        if (r5 == false) goto L121;
        r16.dismissAllowingStateLoss();     // Catch: Exception -> L103
        return;
    L103:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r18 = DialogFragmentLancet.sLastShowStack;
        if (r18 == null) goto L122;
        com.bytedance.crash.d.d(r18, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L122:
        return;
    L121:
        return;
    L98:
        if (r17.isShowing() != true) goto L100;
        r5 = true;
        goto L100
    L120:
        return;
    L72:
        if (r14.isShowing() == false) goto L90;
        Handler r19 = DialogLancet.resolveDialogHandler(r14);
        if (r19 != null) goto L76;
    L78:
        DialogLancet.beforeDialogDismiss(r14);
        r14.dismiss();     // Catch: Throwable -> L81 Exception -> L83
    L87:
        DialogLancet.afterDialogDismiss(r14);
        goto L90
    L81:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r14);
        throw th;
    L83:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L81
        Throwable r20 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L81
        if (r20 == null) goto L87;
        com.bytedance.crash.d.d(r20, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L81
        goto L87
    L76:
        if (Looper.myLooper() == r19.getLooper()) goto L78;
        r19.post(DialogLancet.createDismissRunnable(r14));
        goto L90
    L67:
        if (r13.isShowing() == false) goto L69;
        a(r13);
        goto L69
    L36:
        if (r3.isShowing() == false) goto L38;
        a(r3);
        goto L38
    L31:
        if (r2.isShowing() == false) goto L33;
        a(r2);
        goto L33
    L10:
        if (r1.isShowing() == false) goto L28;
        Handler r21 = DialogLancet.resolveDialogHandler(r1);
        if (r21 != null) goto L14;
    L16:
        DialogLancet.beforeDialogDismiss(r1);
        r1.dismiss();     // Catch: Throwable -> L19 Exception -> L21
    L25:
        DialogLancet.afterDialogDismiss(r1);
        goto L28
    L21:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L19
        Throwable r22 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L19
        if (r22 == null) goto L25;
        com.bytedance.crash.d.d(r22, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r1);
        throw th;
    L14:
        if (Looper.myLooper() == r21.getLooper()) goto L16;
        r21.post(DialogLancet.createDismissRunnable(r1));
        goto L28
    L5:
        if (r0.isShowing() == false) goto L7;
        a(r0);
        goto L7
    }

    public final void d() {
        com.bytedance.ee.bear.bizwidget.d r0 = this.a;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.b == false) goto L9;
        r0.a();
        return;
    }

    public static void a(UDDialog r3) {
        Handler r0 = DialogLancet.resolveDialogHandler(r3);
        if (r0 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r3);
        r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L17:
        DialogLancet.afterDialogDismiss(r3);
        return;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r1 == null) goto L17;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r3));
    }

    public static void b(UDDialog r1) {
        if (DialogLancet.shouldBlockDialogShow(r1) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(r1);
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L7:
        DialogLancet.beforeDialogShow(r1);
        r1.show();
        DialogLancet.afterDialogShow(r1);
    }

    public final void e(com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.a r5) {
        Intrinsics.checkNotNullParameter(r5, "errInfo");
        NetService.ServerErrorException r0 = r5.c;
        if (com.bytedance.ee.bear.contract.k0.c(r0) == false) goto L6;
        return;
    L6:
        if (tp5.b.a(r0) != 233525002) goto L8;
    L27:
        i(tp5.b.a(r0), r5.getContext());
        return;
    L8:
        if (tp5.b.a(r0) == 233525007) goto L27;
        if (tp5.b.a(r0) != 900099011) goto L13;
        return;
    L13:
        int r1 = rq5.a.a;
        boolean r2 = r0 instanceof NetService.ServerErrorException;
        if (r2 == true) goto L16;
    L18:
        boolean r3 = false;
    L19:
        if (r3 == false) goto L26;
        if (r2 == false) goto L29;
        int r4 = com.bytedance.ee.bear.wikiv2.wikitreev2.applydelete.a.a;
        FragmentActivity r6 = r5.getContext();
        if (r6 == null) goto L24;
        FragmentManager r7 = r6.getSupportFragmentManager();
    L25:
        com.bytedance.ee.bear.wikiv2.wikitreev2.applydelete.a.a(r7, r0.getData(), r5.d, r5.e, r5.f);
        return;
    L24:
        r7 = null;
        goto L25
    L29:
        return;
    L26:
        FragmentActivity r8 = r5.getContext();
        Map<String, Integer> r9 = com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.q.a;
        j(r8, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.q.c(r5.b, r0, r5.g));
        return;
    L16:
        if (tp5.b.b(r0, 233525003) == false) goto L18;
        r3 = true;
        goto L19
    }

    public static void j(Context r1, int r2) {
        if (r1 != null) goto L4;
        return;
    L4:
        if (r2 == (-1)) goto L8;
        Toast.showFailureText(r1, r1.getResources().getString(r2), 0);
        return;
    }

    public final void f(com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.e r7, Fragment r8) {
        Intrinsics.checkNotNullParameter(r7, "param");
        c();
        int r1 = ApplyMoveWikiToSpaceFragment.r;
        Intrinsics.checkNotNullParameter(r7, "param");
        ApplyMoveWikiToSpaceFragment r0 = new ApplyMoveWikiToSpaceFragment();
        Bundle r2 = new Bundle();
        r2.putSerializable("extra_user", r7.b);
        r2.putString("extra_wiki_token", r7.c);
        r2.putString("extra_space_folder_token", r7.d);
        r2.putBoolean("extra_move_to_owner_space", r7.e);
        r2.putInt("extra_apply_type", r7.f.getType());
        r0.setArguments(r2);
        if (ForsetiHelper.s(r8) == true) goto L5;
    L15:
        FragmentManager r9 = r7.a;
        LandscapeRestrictionOperation r10 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r0, "ApplyMoveWikiToSpaceFragment", r10);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r9, r0, r10) == false) goto L23;
    L20:
        this.h = r0;
        return;
    L23:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L22
    L19:
        r0.show(r9, "ApplyMoveWikiToSpaceFragment");
        goto L20
    L5:
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.mobile.enable_dialog_commit_allowing_stateloss") == false) goto L15;
        FragmentManager r11 = r7.a;
        Intrinsics.checkNotNullParameter(r0, "fragment");
        Intrinsics.checkNotNullParameter(r11, "manager");
        Field r3 = DialogFragment.class.getDeclaredField("mDismissed");     // Catch: Exception -> L13
        r3.setAccessible(true);     // Catch: Exception -> L13
        r3.set(r0, Boolean.FALSE);     // Catch: Exception -> L13
        Field r4 = DialogFragment.class.getDeclaredField("mShownByMe");     // Catch: Exception -> L13
        r4.setAccessible(true);     // Catch: Exception -> L13
        r4.set(r0, Boolean.TRUE);     // Catch: Exception -> L13
        FragmentTransaction r12 = r11.beginTransaction();     // Catch: Exception -> L13
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r12, r0, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, "ApplyMoveWikiToSpaceFragment", 0) == true) goto L11;
        r12 = r12.add(r0, "ApplyMoveWikiToSpaceFragment");     // Catch: Exception -> L13
    L11:
        r12.commitAllowingStateLoss();     // Catch: Exception -> L13
    L13:
        e = move-exception;
        tt5.a.e("ApplyMoveWikiToSpaceFragment", "show error:", e, false);
        goto L20
    }

    public final void i(int r5, Context r6) {
        c();
        if (r5 != 233525002) goto L5;
        int r7 = 2131889854;
    L9:
        if (r6 == null) goto L19;
        com.larksuite.component.ui.dialog.d r0 = new com.larksuite.component.ui.dialog.d(r6);
        r0.c.backgroundColor(2131100548);
        r0.c.messageTextColor(2131106622);
        r0.c.messageGravity(8388611);
        r0.c.message(r7);
        r0.j(2131889861);
        r0.c.titleColor(2131106622);
        r0.c.titleBold(true);
        r0.c.cancelOnTouchOutside(false);
        r0.c.maskAlpha(0.3f);
        r0.e(17);
        m r8 = new m();
        UDBaseDialogBuilder.ActionBuilder r9 = new UDBaseDialogBuilder.ActionBuilder();
        r9.actionResId(com.larksuite.component.ui.dialog.d.e.get(2131378551, 2131378551));
        r9.text(2131889862);
        r9.text(null);
        r9.textSize(0);
        r9.textColorRes(2131105548);
        r9.textColor(0);
        r9.bgColorRes(0);
        r9.bgDrawableRes(0);
        r9.onClickListener(r8);
        r0.c.addActionButton(r9);
        LKUIDialog r10 = r0.c();
        this.c = r10;
        if (DialogLancet.shouldBlockDialogShow(r10) == false) goto L17;
        DialogLancet.handleBlockedDialogShow(r10);
        return;
    L17:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L16
    L14:
        DialogLancet.beforeDialogShow(r10);
        r10.show();
        DialogLancet.afterDialogShow(r10);
        return;
    L19:
        return;
    L5:
        if (r5 == 233525007) goto L7;
        r7 = 0;
        goto L9
    L7:
        r7 = 2131889855;
        goto L9
    }

    public final void m(Context r2, int r3) {
        if (r3 == (-1)) goto L15;
        if (r2 != null) goto L7;
        return;
    L7:
        if (this.a != null) goto L9;
        this.a = new com.bytedance.ee.bear.bizwidget.d(r2);
    L9:
        com.bytedance.ee.bear.bizwidget.d r4 = this.a;
        if (r4 != null) goto L12;
        return;
    L12:
        if (r4.b == true) goto L17;
        r4.e = r3;
        r4.b();
        return;
    L17:
        return;
    }

    public final void o(com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r3, WikNodePerm r4) {
        Intrinsics.checkNotNullParameter(r3, "target");
        Intrinsics.checkNotNullParameter(r4, "wikiPerm");
        BaseMoreProvider r0 = this.l;
        if ((r0 instanceof WikiTreeMoreProvider) == false) goto L6;
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeMoreProvider");
        WikiTreeMoreProvider r1 = (WikiTreeMoreProvider) r0;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r4, "wikiPerm");
        tt5.a.h("WikiTreeMoreProvider", "notifyNodePermChanged.");
        r1.n = r4;
        r1.g();
        return;
    }

    public static void g(Context r2, int r3, View.OnClickListener r4) {
        Intrinsics.checkNotNullParameter(r4, "listener");
        if (r2 == null) goto L6;
        UDToast.a r0 = UDToast.build(r2);
        r0.d(Toast.getSuccessIcon());
        r0.g(r2.getString(r3));
        r0.b(2131887465, new c(r4));
        r0.h();
        return;
    }

    public final void k(Context r3, String r4, gp5.a.InterfaceC0236a r5) {
        Intrinsics.checkNotNullParameter(r5, "listener");
        c();
        if (r3 == null) goto L19;
        gp5.a r0 = (gp5.a) new gp5.a(r3).title(2131887814);
        if (r4 != null) goto L7;
        r4 = "";
    L7:
        r0.e(r4);
        r0.f(2131888029);
        r0.a(2131887800);
        f r6 = new f(r5, r3, this);
        Intrinsics.checkNotNullParameter(r6, "value");
        r0.r = r6;
        r0.c();
        g r7 = new g(r3, this);
        Intrinsics.checkNotNullParameter(r7, "value");
        r0.s = r7;
        this.j = r0.build();
        ((zo5.b) org.koin.java.a.c(zo5.b.class, null, null, 6)).s(this.j);
        UDDialog r8 = this.j;
        if (r8 != null) goto L10;
    L14:
        this.k = r0.g();
        return;
    L10:
        if (DialogLancet.shouldBlockDialogShow(r8) == false) goto L17;
        DialogLancet.handleBlockedDialogShow(r8);
        goto L14
    L17:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L16
    L13:
        DialogLancet.beforeDialogShow(r8);
        r8.show();
        DialogLancet.afterDialogShow(r8);
        goto L14
    }

    public final void n(Context r5, boolean r6, View.OnClickListener r7, View.OnClickListener r8) {
        Intrinsics.checkNotNullParameter(r7, "confirm");
        Intrinsics.checkNotNullParameter(r8, DocFeed$Value$Result.CANCEL);
        c();
        if (qc5.a.h() == false) goto L5;
        int r0 = 2131889591;
    L6:
        if (r5 == null) goto L15;
        fp5.a r1 = (fp5.a) ((fp5.a) ((fp5.a) new fp5.a(r5).messageTextColor(2131106622)).messageGravity(8388611)).message(r0);
        if (r6 == false) goto L10;
        String r9 = r5.getString(2131887489);
    L11:
        Intrinsics.checkNotNull(r9);
        r1.b(r9);
        fp5.a r10 = (fp5.a) ((fp5.a) ((fp5.a) ((fp5.a) ((fp5.a) ((fp5.a) r1.title(2131887491)).titleColor(2131106622)).titleBold(true)).cancelOnTouchOutside(false)).maskAlpha(0.3f)).gravity(17);
        r10.e = false;
        UDDialog r11 = ((fp5.a) ((fp5.a) r10.addActionButton(new UDBaseDialogBuilder.ActionBuilder().actionResId(2131391777).text(2131887719).onClickListener(new h(r7)).textColorRes(2131105548))).addActionButton(new UDBaseDialogBuilder.ActionBuilder().actionResId(2131391778).text(2131888316).onClickListener(new i(r8)).textColorRes(2131106622))).build();
        this.f = r11;
        if (r11 == null) goto L16;
        b(r11);
        return;
    L16:
        return;
    L10:
        r9 = "";
        goto L11
    L15:
        return;
    L5:
        r0 = 2131887490;
        goto L6
    }

    public final void h(Context r5, TreeNode r6, WikNodePerm r7, WikiDeleteConfirmDialog.b r8, boolean r9, String r10) {
        Intrinsics.checkNotNullParameter(r8, "delegate");
        if (r5 == null) goto L48;
        if (r6 == null) goto L51;
        c();
        if (TextUtils.isEmpty(r6.title) == false) goto L9;
        String r0 = com.bytedance.ee.bear.list.t0.e(r5, r6.obj_type);
    L10:
        String r3 = null;
        final WikiDeleteConfirmDialog r4 = null;
        if (r6.getNodeType() != WikNodeType.LEAF.getValue()) goto L13;
    L26:
        String r1 = "";
        if (r6.isShortcut() == false) goto L33;
        String r11 = r5.getResources().getString(2131889586);
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("lark.scs.legalhold.delete") == false) goto L31;
        int r12 = 60;
    L32:
        String r13 = xo5.a.c(r5, 2131889587, "num", String.valueOf(r12));
    L41:
        fp5.a r14 = (fp5.a) ((fp5.a) ((fp5.a) new fp5.a(r5).messageTextColor(2131106622)).messageGravity(8388611)).message(r13);
        r14.b(r1);
        fp5.a r15 = (fp5.a) ((fp5.a) ((fp5.a) ((fp5.a) ((fp5.a) ((fp5.a) r14.title(r11)).titleColor(2131106622)).titleBold(true)).cancelOnTouchOutside(false)).maskAlpha(0.3f)).gravity(17);
        r15.e = false;
        UDDialog r16 = ((fp5.a) ((fp5.a) r15.addActionButton(new UDBaseDialogBuilder.ActionBuilder().actionResId(2131391777).text(2131887520).onClickListener(new d(r8)).textColorRes(2131102093))).addActionButton(new UDBaseDialogBuilder.ActionBuilder().actionResId(2131391778).text(2131888316).onClickListener(new e(r8)).textColorRes(2131106622))).build();
        this.b = r16;
        if (r16 == null) goto L50;
        b(r16);
        return;
    L50:
        return;
    L31:
        r12 = 30;
        goto L32
    L33:
        WikiDetailInfo r17 = r6.detail_info;
        if (r17 == null) goto L36;
        r3 = r17.owner_id;
    L36:
        boolean r18 = t4.a(r3);
        String r19 = xo5.a.c(r5, 2131887252, "doc_name", r0);
        String r20 = a.a(r9, r10, r5);
        if (r18 == true) goto L40;
        r1 = r5.getString(2131889583);
        Intrinsics.checkNotNull(r1);
    L40:
        r11 = r19;
        r13 = r20;
        goto L41
    L13:
        if (r6.isShortcut() == true) goto L26;
        int r21 = WikiDeleteConfirmDialog.o;
        FragmentActivity r22 = ContextsKt.findActivity(r5);
        if ((r22 instanceof FragmentActivity) == false) goto L17;
        FragmentActivity r23 = r22;
    L18:
        if (r23 == null) goto L25;
        tt5.a.h("WikiDeleteConfirmDialog", "WikiDeleteConfirmDialog.show");
        final WikiDeleteConfirmDialog.ParamsViewModel r24 = (WikiDeleteConfirmDialog.ParamsViewModel) new ViewModelProvider(r23).get(WikiDeleteConfirmDialog.ParamsViewModel.class);
        r24.setDelegate(r8);
        r24.setNodePerm(r7);
        r24.setMyLib(r9);
        r24.setSpaceName(r10);
        r4 = new WikiDeleteConfirmDialog();
        r4.getLifecycle().addObserver(new WikiDeleteConfirmDialog$Companion$show$1(r24, r4));
        FragmentManager r25 = r23.getSupportFragmentManager();
        LandscapeRestrictionOperation r26 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r4, "WikiDeleteConfirmDialog", r26);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r25, r4, r26) == true) goto L25;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L45
    L24:
        r4.show(r25, "WikiDeleteConfirmDialog");
    L25:
        this.m = r4;
        return;
    L17:
        r23 = null;
        goto L18
    L9:
        r0 = r6.title;
        goto L10
    L51:
        return;
    }

    public final void l(FragmentActivity r9, TreeNode r10, SpaceInfo r11, final b r12, BaseMoreProvider r13, Fragment r14, View r15) {
        if (r9 == null) goto L17;
        if (r10 == null) goto L18;
        if (r11 == null) goto L19;
        if (r13 != null) goto L8;
        return;
    L8:
        if (r10.secret_key_delete == false) goto L11;
        j(r9, 2131887104);
        return;
    L11:
        c();
        Function0<Unit> r16 = new WikiDialogs$showItemMoreDialog$1(r12, this);
        int r17 = com.bytedance.ee.bear.more.protocol3.extension.v.l;
        r13.j(null, r16);
        if (ForsetiHelper.o() == false) goto L14;
        ((com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6)).z(r9, r13, r14, r15, -1, ForsetiNavOptions.DestinationStyle.HALF_FLOAT, true);
    L15:
        this.l = r13;
        return;
    L14:
        ((com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6)).O(r9, r13);
        goto L15
    L19:
        return;
    L18:
        return;
    }
}
