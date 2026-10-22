package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.GravityCompat;
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
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larksuite.component.ui.dialog.LKUIDialog;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larksuite.framework.utils.KeyboardUtils;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
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

/* JADX INFO: loaded from: classes18.dex */
public final class WikiDialogs {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f242249n = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.ee.bear.bizwidget.d f242250a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public UDDialog f242251b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LKUIDialog f242252c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public UDDialog f242253d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public WikiCreateSelectPanelDialog f242254e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public UDDialog f242255f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public UDDialog f242256g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ApplyMoveWikiToSpaceFragment f242257h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ApplyMoveWikiToWikiFragment f242258i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public UDDialog f242259j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public SpaceEditText f242260k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public BaseMoreProvider f242261l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public WikiDeleteConfirmDialog f242262m;

    public static final class a {
        public static String a(boolean r100, String r101, Context r102) {
            if (com.bytedance.ee.bear.appsetting.c.a.f206237a.g("lark.scs.legalhold.delete") == false) goto L5;
            int r103 = 60;
        L6:
            String r104 = String.valueOf(r103);
            if (r100 == true) goto L9;
            Pair[] r105 = new Pair[2];
            if (r101 != null) goto L13;
            r101 = "";
        L13:
            r105[0] = TuplesKt.to("WikiSpaceName", r101);
            r105[1] = TuplesKt.to("num", r104);
            return xo5.a.d(r102, R.string.LarkCCM_NewCM_DeleteDocsToTrash_ContentPermanentlyDeletedInWikiSpace_DayVar_Desc, MapsKt.mapOf(r105));
        L9:
            return xo5.a.c(r102, R.string.LarkCCM_NewCM_DeletedItemsGoToTrash_DayVar_Desc, "num", r104);
        L5:
            r103 = 30;
            goto L6
        }
    }

    public interface b {
        void a();

        void b(SpaceInfo r100);

        void c(boolean r100);

        void d(SpaceInfo r100);

        void e();

        void f();

        void g(boolean r100);

        void h(boolean r100);

        void i();

        void onDismiss();
    }

    public static final class c implements UDToast.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View.OnClickListener f242263a;

        public c(View.OnClickListener r100) {
            this.f242263a = r100;
        }

        @Override // com.larksuite.component.universe_design.toast.UDToast.b
        public final void a(com.ss.android.lark.compose.foundation.toast.b r100) {
            Intrinsics.checkNotNullParameter(r100, "toast");
            if (com.bytedance.ee.util.ui.h.a(500) == false) goto L6;
            r100.cancel();
            this.f242263a.onClick(null);
            return;
        }
    }

    public static final class d implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WikiDeleteConfirmDialog.b f242264a;

        public d(WikiDeleteConfirmDialog.b r100) {
            this.f242264a = r100;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r100, int r101) {
            this.f242264a.b();
        }
    }

    public static final class e implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WikiDeleteConfirmDialog.b f242265a;

        public e(WikiDeleteConfirmDialog.b r100) {
            this.f242265a = r100;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r100, int r101) {
            this.f242265a.onCancel();
        }
    }

    public static final class f implements gp5.a.InterfaceC6049a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ gp5.a.InterfaceC6049a f242266a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f242267b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ WikiDialogs f242268c;

        @Override // gp5.a.InterfaceC6049a
        public final void a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "text");
            this.f242266a.a(r100);
            KeyboardUtils.hideKeyboard(ContextsKt.findActivity(this.f242267b), this.f242268c.f242260k);
        }

        public f(gp5.a.InterfaceC6049a r100, Context r101, WikiDialogs r102) {
            this.f242266a = r100;
            this.f242267b = r101;
            this.f242268c = r102;
        }
    }

    public static final class g implements gp5.a.InterfaceC6049a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f242269a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ WikiDialogs f242270b;

        @Override // gp5.a.InterfaceC6049a
        public final void a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "text");
            KeyboardUtils.hideKeyboard(ContextsKt.findActivity(this.f242269a), this.f242270b.f242260k);
        }

        public g(Context r100, WikiDialogs r101) {
            this.f242269a = r100;
            this.f242270b = r101;
        }
    }

    public static final class h implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View.OnClickListener f242271a;

        public h(View.OnClickListener r100) {
            this.f242271a = r100;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r100, int r101) {
            this.f242271a.onClick(null);
        }
    }

    public static final class i implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View.OnClickListener f242272a;

        public i(View.OnClickListener r100) {
            this.f242272a = r100;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r100, int r101) {
            this.f242272a.onClick(null);
        }
    }

    static {
    }

    public WikiDialogs() {
    }

    public final void c() {
        UDDialog r100 = this.f242251b;
        if (r100 != null) goto L5;
    L7:
        LKUIDialog r101 = this.f242252c;
        if (r101 != null) goto L10;
    L28:
        UDDialog r102 = this.f242253d;
        if (r102 != null) goto L31;
    L33:
        UDDialog r103 = this.f242255f;
        if (r103 != null) goto L36;
    L38:
        ApplyMoveWikiToSpaceFragment r104 = this.f242257h;
        boolean r105 = false;
        if (r104 == null) goto L51;
        Dialog r106 = r104.getDialog();
        if (r106 == null) goto L43;
        boolean r107 = r106.isShowing();
    L44:
        if (r107 == false) goto L51;
        r104.dismissAllowingStateLoss();     // Catch: Exception -> L47
    L47:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r108 = DialogFragmentLancet.sLastShowStack;
        if (r108 == null) goto L51;
        com.bytedance.crash.d.d(r108, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L51
    L43:
        r107 = false;
    L51:
        ApplyMoveWikiToWikiFragment r109 = this.f242258i;
        if (r109 == null) goto L64;
        Dialog r110 = r109.getDialog();
        if (r110 == null) goto L56;
        boolean r111 = r110.isShowing();
    L57:
        if (r111 == false) goto L64;
        r109.dismissAllowingStateLoss();     // Catch: Exception -> L60
    L60:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r112 = DialogFragmentLancet.sLastShowStack;
        if (r112 == null) goto L64;
        com.bytedance.crash.d.d(r112, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L64
    L56:
        r111 = false;
    L64:
        UDDialog r113 = this.f242256g;
        if (r113 != null) goto L67;
    L69:
        UDDialog r114 = this.f242259j;
        if (r114 != null) goto L72;
    L90:
        BaseMoreProvider r115 = this.f242261l;
        if (r115 == null) goto L93;
        r115.c();
    L93:
        WikiDeleteConfirmDialog r116 = this.f242262m;
        if (r116 == null) goto L120;
        Dialog r117 = r116.getDialog();
        if (r117 != null) goto L98;
    L100:
        if (r105 == false) goto L121;
        r116.dismissAllowingStateLoss();     // Catch: Exception -> L103
        return;
    L103:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r118 = DialogFragmentLancet.sLastShowStack;
        if (r118 == null) goto L122;
        com.bytedance.crash.d.d(r118, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L122:
        return;
    L121:
        return;
    L98:
        if (r117.isShowing() != true) goto L100;
        r105 = true;
        goto L100
    L120:
        return;
    L72:
        if (r114.isShowing() == false) goto L90;
        Handler r119 = DialogLancet.resolveDialogHandler(r114);
        if (r119 != null) goto L76;
    L78:
        DialogLancet.beforeDialogDismiss(r114);
        r114.dismiss();     // Catch: Throwable -> L81 Exception -> L83
    L87:
        DialogLancet.afterDialogDismiss(r114);
        goto L90
    L81:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r114);
        throw th;
    L83:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L81
        Throwable r120 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L81
        if (r120 == null) goto L87;
        com.bytedance.crash.d.d(r120, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L81
        goto L87
    L76:
        if (Looper.myLooper() == r119.getLooper()) goto L78;
        r119.post(DialogLancet.createDismissRunnable(r114));
        goto L90
    L67:
        if (r113.isShowing() == false) goto L69;
        a(r113);
        goto L69
    L36:
        if (r103.isShowing() == false) goto L38;
        a(r103);
        goto L38
    L31:
        if (r102.isShowing() == false) goto L33;
        a(r102);
        goto L33
    L10:
        if (r101.isShowing() == false) goto L28;
        Handler r121 = DialogLancet.resolveDialogHandler(r101);
        if (r121 != null) goto L14;
    L16:
        DialogLancet.beforeDialogDismiss(r101);
        r101.dismiss();     // Catch: Throwable -> L19 Exception -> L21
    L25:
        DialogLancet.afterDialogDismiss(r101);
        goto L28
    L21:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L19
        Throwable r122 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L19
        if (r122 == null) goto L25;
        com.bytedance.crash.d.d(r122, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r101);
        throw th;
    L14:
        if (Looper.myLooper() == r121.getLooper()) goto L16;
        r121.post(DialogLancet.createDismissRunnable(r101));
        goto L28
    L5:
        if (r100.isShowing() == false) goto L7;
        a(r100);
        goto L7
    }

    public final void d() {
        com.bytedance.ee.bear.bizwidget.d r100 = this.f242250a;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.f216368b == false) goto L9;
        r100.a();
        return;
    }

    public static void a(UDDialog r100) {
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r100);
        r100.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L17:
        DialogLancet.afterDialogDismiss(r100);
        return;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r102 == null) goto L17;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L5:
        if (Looper.myLooper() == r101.getLooper()) goto L8;
        r101.post(DialogLancet.createDismissRunnable(r100));
    }

    public static void b(UDDialog r100) {
        if (DialogLancet.shouldBlockDialogShow(r100) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(r100);
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L7:
        DialogLancet.beforeDialogShow(r100);
        r100.show();
        DialogLancet.afterDialogShow(r100);
    }

    public final void e(com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.a r100) {
        Intrinsics.checkNotNullParameter(r100, "errInfo");
        Throwable r101 = r100.f242402c;
        if (com.bytedance.ee.bear.contract.k0.c(r101) == false) goto L6;
        return;
    L6:
        if (tp5.b.a(r101) != 233525002) goto L8;
    L27:
        i(tp5.b.a(r101), r100.getContext());
        return;
    L8:
        if (tp5.b.a(r101) == 233525007) goto L27;
        if (tp5.b.a(r101) != 900099011) goto L13;
        return;
    L13:
        int r102 = rq5.a.f538926a;
        boolean r103 = r101 instanceof NetService.ServerErrorException;
        if (r103 == true) goto L16;
    L18:
        boolean r104 = false;
    L19:
        if (r104 == false) goto L26;
        if (r103 == false) goto L29;
        int r105 = com.bytedance.ee.bear.wikiv2.wikitreev2.applydelete.a.f241375a;
        FragmentActivity r106 = r100.getContext();
        if (r106 == null) goto L24;
        FragmentManager r107 = r106.getSupportFragmentManager();
    L25:
        com.bytedance.ee.bear.wikiv2.wikitreev2.applydelete.a.a(r107, ((NetService.ServerErrorException) r101).getData(), r100.f242403d, r100.f242404e, r100.f242405f);
        return;
    L24:
        r107 = null;
        goto L25
    L29:
        return;
    L26:
        FragmentActivity r108 = r100.getContext();
        Map<String, Integer> r109 = com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.q.f242003a;
        j(r108, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.q.c(r100.f242401b, r101, r100.f242406g));
        return;
    L16:
        if (tp5.b.b(r101, 233525003) == false) goto L18;
        r104 = true;
        goto L19
    }

    public static void j(Context r100, int r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r101 == (-1)) goto L8;
        Toast.showFailureText(r100, r100.getResources().getString(r101), 0);
        return;
    }

    public final void f(com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.e r100, Fragment r101) {
        Intrinsics.checkNotNullParameter(r100, "param");
        c();
        int r102 = ApplyMoveWikiToSpaceFragment.f241600r;
        Intrinsics.checkNotNullParameter(r100, "param");
        ApplyMoveWikiToSpaceFragment r103 = new ApplyMoveWikiToSpaceFragment();
        Bundle r104 = new Bundle();
        r104.putSerializable("extra_user", r100.f242455b);
        r104.putString("extra_wiki_token", r100.f242456c);
        r104.putString("extra_space_folder_token", r100.f242457d);
        r104.putBoolean("extra_move_to_owner_space", r100.f242458e);
        r104.putInt("extra_apply_type", r100.f242459f.getType());
        r103.setArguments(r104);
        if (ForsetiHelper.s(r101) == true) goto L5;
    L15:
        FragmentManager r105 = r100.f242454a;
        LandscapeRestrictionOperation r106 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r103, "ApplyMoveWikiToSpaceFragment", r106);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r105, r103, r106) == false) goto L23;
    L20:
        this.f242257h = r103;
        return;
    L23:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L22
    L19:
        r103.show(r105, "ApplyMoveWikiToSpaceFragment");
        goto L20
    L5:
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.g("ccm.mobile.enable_dialog_commit_allowing_stateloss") == false) goto L15;
        FragmentManager r107 = r100.f242454a;
        Intrinsics.checkNotNullParameter(r103, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r107, "manager");
        Field r108 = DialogFragment.class.getDeclaredField("mDismissed");     // Catch: Exception -> L13
        r108.setAccessible(true);     // Catch: Exception -> L13
        r108.set(r103, Boolean.FALSE);     // Catch: Exception -> L13
        Field r109 = DialogFragment.class.getDeclaredField("mShownByMe");     // Catch: Exception -> L13
        r109.setAccessible(true);     // Catch: Exception -> L13
        r109.set(r103, Boolean.TRUE);     // Catch: Exception -> L13
        FragmentTransaction r110 = r107.beginTransaction();     // Catch: Exception -> L13
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r110, r103, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, "ApplyMoveWikiToSpaceFragment", 0) == true) goto L11;
        r110 = r110.add(r103, "ApplyMoveWikiToSpaceFragment");     // Catch: Exception -> L13
    L11:
        r110.commitAllowingStateLoss();     // Catch: Exception -> L13
    L13:
        e = move-exception;
        tt5.a.e("ApplyMoveWikiToSpaceFragment", "show error:", e, false);
        goto L20
    }

    public final void i(int r100, Context r101) {
        c();
        if (r100 != 233525002) goto L5;
        int r102 = R.string.LarkCCM_Workspace_DeletePageFail_NoPerm;
    L9:
        if (r101 == null) goto L19;
        com.larksuite.component.ui.dialog.d r103 = new com.larksuite.component.ui.dialog.d(r101);
        r103.f284132c.backgroundColor(R.color.bg_body);
        r103.f284132c.messageTextColor(R.color.text_title);
        r103.f284132c.messageGravity(GravityCompat.START);
        r103.f284132c.message(r102);
        r103.j(R.string.LarkCCM_Workspace_DeletePage_Failed_Title);
        r103.f284132c.titleColor(R.color.text_title);
        r103.f284132c.titleBold(true);
        r103.f284132c.cancelOnTouchOutside(false);
        r103.f284132c.maskAlpha(0.3f);
        r103.e(17);
        m r104 = new m();
        UDBaseDialogBuilder.ActionBuilder r105 = new UDBaseDialogBuilder.ActionBuilder();
        r105.actionResId(com.larksuite.component.ui.dialog.d.f284129e.get(R.id.lkui_dialog_btn_right, R.id.lkui_dialog_btn_right));
        r105.text(R.string.LarkCCM_Workspace_DeletePage_GotIt_Button);
        r105.text(null);
        r105.textSize(0);
        r105.textColorRes(R.color.primary_fill_default);
        r105.textColor(0);
        r105.bgColorRes(0);
        r105.bgDrawableRes(0);
        r105.onClickListener(r104);
        r103.f284132c.addActionButton(r105);
        LKUIDialog r106 = r103.c();
        this.f242252c = r106;
        if (DialogLancet.shouldBlockDialogShow(r106) == false) goto L17;
        DialogLancet.handleBlockedDialogShow(r106);
        return;
    L17:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L16
    L14:
        DialogLancet.beforeDialogShow(r106);
        r106.show();
        DialogLancet.afterDialogShow(r106);
        return;
    L19:
        return;
    L5:
        if (r100 == 233525007) goto L7;
        r102 = 0;
        goto L9
    L7:
        r102 = R.string.LarkCCM_Workspace_DeletePageFail_OverLimit;
        goto L9
    }

    public final void m(Context r100, int r101) {
        if (r101 == (-1)) goto L15;
        if (r100 != null) goto L7;
        return;
    L7:
        if (this.f242250a != null) goto L9;
        this.f242250a = new com.bytedance.ee.bear.bizwidget.d(r100);
    L9:
        com.bytedance.ee.bear.bizwidget.d r102 = this.f242250a;
        if (r102 != null) goto L12;
        return;
    L12:
        if (r102.f216368b == true) goto L17;
        r102.f216371e = r101;
        r102.b();
        return;
    L17:
        return;
    }

    public final void o(com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r100, WikNodePerm r101) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r101, "wikiPerm");
        BaseMoreProvider r102 = this.f242261l;
        if ((r102 instanceof WikiTreeMoreProvider) == false) goto L6;
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeMoreProvider");
        WikiTreeMoreProvider r103 = (WikiTreeMoreProvider) r102;
        r103.getClass();
        Intrinsics.checkNotNullParameter(r101, "wikiPerm");
        tt5.a.h("WikiTreeMoreProvider", "notifyNodePermChanged.");
        r103.f242346n = r101;
        r103.g();
        return;
    }

    public static void g(Context r100, int r101, View.OnClickListener r102) {
        Intrinsics.checkNotNullParameter(r102, "listener");
        if (r100 == null) goto L6;
        UDToast.a r103 = UDToast.build(r100);
        r103.d(Toast.getSuccessIcon());
        r103.g(r100.getString(r101));
        r103.b(R.string.CreationMobile_Wiki_ClickToView_Toast, new c(r102));
        r103.h();
        return;
    }

    public final void k(Context r100, String r101, gp5.a.InterfaceC6049a r102) {
        Intrinsics.checkNotNullParameter(r102, "listener");
        c();
        if (r100 == null) goto L19;
        gp5.a r103 = new gp5.a(r100).title(R.string.Doc_Facade_Rename);
        if (r101 != null) goto L7;
        r101 = "";
    L7:
        r103.e(r101);
        r103.f(R.string.Doc_More_RenameSheetPlaceholder);
        r103.a(R.string.Doc_Facade_Ok);
        f r104 = new f(r102, r100, this);
        Intrinsics.checkNotNullParameter(r104, "value");
        r103.f482030r = r104;
        r103.c();
        g r105 = new g(r100, this);
        Intrinsics.checkNotNullParameter(r105, "value");
        r103.f482031s = r105;
        this.f242259j = r103.build();
        ((zo5.b) org.koin.java.a.c(zo5.b.class, null, null, 6)).s(this.f242259j);
        UDDialog r106 = this.f242259j;
        if (r106 != null) goto L10;
    L14:
        this.f242260k = r103.g();
        return;
    L10:
        if (DialogLancet.shouldBlockDialogShow(r106) == false) goto L17;
        DialogLancet.handleBlockedDialogShow(r106);
        goto L14
    L17:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L16
    L13:
        DialogLancet.beforeDialogShow(r106);
        r106.show();
        DialogLancet.afterDialogShow(r106);
        goto L14
    }

    public final void n(Context r100, boolean r101, View.OnClickListener r102, View.OnClickListener r103) {
        Intrinsics.checkNotNullParameter(r102, "confirm");
        Intrinsics.checkNotNullParameter(r103, "cancel");
        c();
        if (qc5.a.h() == false) goto L5;
        int r104 = R.string.LarkCCM_NewCM_Drive_MoveToMyFoldersInDrive_Title_Mobile;
    L6:
        if (r100 == null) goto L15;
        fp5.a r105 = new fp5.a(r100).messageTextColor(R.color.text_title).messageGravity(GravityCompat.START).message(r104);
        if (r101 == false) goto L10;
        String r106 = r100.getString(R.string.CreationMobile_Wiki_MoveToSpace_MoveTips_NoticeSubpage);
    L11:
        Intrinsics.checkNotNull(r106);
        r105.b(r106);
        fp5.a r107 = r105.title(R.string.CreationMobile_Wiki_MoveToSpace_MoveTips_Title).titleColor(R.color.text_title).titleBold(true).cancelOnTouchOutside(false).maskAlpha(0.3f).gravity(17);
        r107.f478274e = false;
        UDDialog r108 = r107.addActionButton(new UDBaseDialogBuilder.ActionBuilder().actionResId(R.id.ud_dialog_btn_primary).text(R.string.Doc_Facade_Confirm).onClickListener(new h(r102)).textColorRes(R.color.primary_fill_default)).addActionButton(new UDBaseDialogBuilder.ActionBuilder().actionResId(R.id.ud_dialog_btn_secondary).text(R.string.Doc_Wiki_Cancel).onClickListener(new i(r103)).textColorRes(R.color.text_title)).build();
        this.f242255f = r108;
        if (r108 == null) goto L16;
        b(r108);
        return;
    L16:
        return;
    L10:
        r106 = "";
        goto L11
    L15:
        return;
    L5:
        r104 = R.string.CreationMobile_Wiki_MoveToSpace_MoveTips_Subtitle;
        goto L6
    }

    public final void h(Context r100, TreeNode r101, WikNodePerm r102, WikiDeleteConfirmDialog.b r103, boolean r104, String r110) {
        Intrinsics.checkNotNullParameter(r103, "delegate");
        if (r100 == null) goto L48;
        if (r101 == null) goto L51;
        c();
        if (TextUtils.isEmpty(r101.title) == false) goto L9;
        String r105 = com.bytedance.ee.bear.list.t0.e(r100, r101.obj_type);
    L10:
        String r106 = null;
        final WikiDeleteConfirmDialog r107 = null;
        if (r101.getNodeType() != WikNodeType.LEAF.getValue()) goto L13;
    L26:
        String r108 = "";
        if (r101.isShortcut() == false) goto L33;
        String r109 = r100.getResources().getString(R.string.LarkCCM_NewCM_DeleteShortcutToTrash_DeleteOrNot_Title);
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.g("lark.scs.legalhold.delete") == false) goto L31;
        int r111 = 60;
    L32:
        String r112 = xo5.a.c(r100, R.string.LarkCCM_NewCM_DeleteShortcutToTrash_OriginalDocNotAffectedOnceDeleted_DayVar_Desc, "num", String.valueOf(r111));
    L41:
        fp5.a r113 = new fp5.a(r100).messageTextColor(R.color.text_title).messageGravity(GravityCompat.START).message(r112);
        r113.b(r108);
        fp5.a r114 = r113.title(r109).titleColor(R.color.text_title).titleBold(true).cancelOnTouchOutside(false).maskAlpha(0.3f).gravity(17);
        r114.f478274e = false;
        UDDialog r115 = r114.addActionButton(new UDBaseDialogBuilder.ActionBuilder().actionResId(R.id.ud_dialog_btn_primary).text(R.string.CreationMobile_Wiki_Permission_Remove_Toast).onClickListener(new d(r103)).textColorRes(R.color.function_danger_fill_default)).addActionButton(new UDBaseDialogBuilder.ActionBuilder().actionResId(R.id.ud_dialog_btn_secondary).text(R.string.Doc_Wiki_Cancel).onClickListener(new e(r103)).textColorRes(R.color.text_title)).build();
        this.f242251b = r115;
        if (r115 == null) goto L50;
        b(r115);
        return;
    L50:
        return;
    L31:
        r111 = 30;
        goto L32
    L33:
        WikiDetailInfo r116 = r101.detail_info;
        if (r116 == null) goto L36;
        r106 = r116.owner_id;
    L36:
        boolean r117 = t4.a(r106);
        String r118 = xo5.a.c(r100, R.string.CreationMobile_ECM_DeleteConfirmTitle, "doc_name", r105);
        String r119 = a.a(r104, r110, r100);
        if (r117 == true) goto L40;
        r108 = r100.getString(R.string.LarkCCM_NewCM_DeleteDocsToTrash_PageOwnerNotifiedOnceDeleted_Desc);
        Intrinsics.checkNotNull(r108);
    L40:
        r109 = r118;
        r112 = r119;
        goto L41
    L13:
        if (r101.isShortcut() == true) goto L26;
        int r120 = WikiDeleteConfirmDialog.f242439o;
        Activity r121 = ContextsKt.findActivity(r100);
        if ((r121 instanceof FragmentActivity) == false) goto L17;
        FragmentActivity r122 = (FragmentActivity) r121;
    L18:
        if (r122 == null) goto L25;
        tt5.a.h("WikiDeleteConfirmDialog", "WikiDeleteConfirmDialog.show");
        final WikiDeleteConfirmDialog.ParamsViewModel r123 = (WikiDeleteConfirmDialog.ParamsViewModel) new ViewModelProvider(r122).get(WikiDeleteConfirmDialog.ParamsViewModel.class);
        r123.setDelegate(r103);
        r123.setNodePerm(r102);
        r123.setMyLib(r104);
        r123.setSpaceName(r110);
        r107 = new WikiDeleteConfirmDialog();
        r107.getLifecycle().addObserver(new WikiDeleteConfirmDialog$Companion$show$1(r123, r107));
        FragmentManager r124 = r122.getSupportFragmentManager();
        LandscapeRestrictionOperation r125 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r107, "WikiDeleteConfirmDialog", r125);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r124, r107, r125) == true) goto L25;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L45
    L24:
        r107.show(r124, "WikiDeleteConfirmDialog");
    L25:
        this.f242262m = r107;
        return;
    L17:
        r122 = null;
        goto L18
    L9:
        r105 = r101.title;
        goto L10
    L51:
        return;
    }

    public final void l(FragmentActivity r100, TreeNode r110, SpaceInfo r111, final b r112, BaseMoreProvider r113, Fragment r114, View r115) {
        if (r100 == null) goto L17;
        if (r110 == null) goto L18;
        if (r111 == null) goto L19;
        if (r113 != null) goto L8;
        return;
    L8:
        if (r110.secret_key_delete == false) goto L11;
        j(r100, R.string.CreationDoc_Docs_KeyInvalidCanNotOperate);
        return;
    L11:
        c();
        Function0<Unit> r116 = new WikiDialogs$showItemMoreDialog$1(r112, this);
        int r117 = com.bytedance.ee.bear.more.protocol3.extension.v.f234849l;
        r113.j(null, r116);
        if (ForsetiHelper.o() == false) goto L14;
        ((com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6)).z(r100, r113, r114, r115, -1, ForsetiNavOptions.DestinationStyle.HALF_FLOAT, true);
    L15:
        this.f242261l = r113;
        return;
    L14:
        ((com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6)).O(r100, r113);
        goto L15
    L19:
        return;
    L18:
        return;
    }
}
