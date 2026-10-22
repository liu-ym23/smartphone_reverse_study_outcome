package tg5;

import android.content.Context;
import android.content.DialogInterface;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.GravityCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.contract.AccountService$Account;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.facade.common.widget.recyclerview.LinearLayoutManagerWrapper;
import com.bytedance.ee.bear.list.u4;
import com.bytedance.ee.bear.middleground.permission.PermissionAnalytic;
import com.bytedance.ee.bear.middleground.permission.collaborator.NotNotifyUserEntity;
import com.bytedance.ee.bear.middleground.permission.collaborator.invite.BaseInviteCollaboratorManageAdapter;
import com.bytedance.ee.bear.middleground.permission.collaborator.invite.InviteData;
import com.bytedance.ee.bear.middleground.permission.collaborator.invite.InviteResult;
import com.bytedance.ee.bear.middleground.permission.collaborator.invite.newinvite.BaseInviteMemberManagerView$initRecyclerView$1;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.bytedance.ee.bear.widgets.dialog.BearUDDialogBuilder;
import com.bytedance.ee.bear.widgets.q;
import com.bytedance.ee.bear.widgets.t;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEditText;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larksuite.component.universe_design.dialog.UDDialogBuilder;
import com.larksuite.component.universe_design.notice.UDNotice;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larksuite.framework.mvp.IView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.lynx.tasm.LynxError;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
public abstract class b implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f545851a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f545852b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f545853c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public p.a f545854d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public BaseInviteCollaboratorManageAdapter f545855e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public q f545856f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Disposable f545857g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f545858h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f545859i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f545860j;

    public static final class a {
    }

    /* JADX INFO: renamed from: tg5.b$b, reason: collision with other inner class name */
    public static final class ViewOnClickListenerC7723b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ViewOnClickListenerC7723b f545861a = null;

        static {
            f545861a = new ViewOnClickListenerC7723b();
        }

        public ViewOnClickListenerC7723b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            tt5.a.h("BaseInviteMemberManagerView", "rootView click");
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f545862a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Throwable f545863b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f545864c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f545865d;

        public c(b r100, Throwable r101, String r102, String r103) {
            this.f545862a = r100;
            this.f545863b = r101;
            this.f545864c = r102;
            this.f545865d = r103;
        }

        public final void a() {
            Context r100 = this.f545862a.f545851a;
            Throwable r101 = this.f545863b;
            String r102 = this.f545864c;
            String r103 = this.f545865d;
            int r104 = ui5.a.f550206a;
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, LynxError.LYNX_THROWABLE);
            String r105 = "others";
            if (ax4.d.b(r101, 4114) == false) goto L5;
            String r106 = xo5.a.c(r100, R.string.Doc_Share_ShareForbidden, "folderName", ((NetService.ServerErrorException) r101).getMsg());
        L138:
            Toast.showFailureText(r100, r106);
            PermissionAnalytic.j(r105, r102, r103, "invited_collaborate");
            return;
        L5:
            boolean r107 = false;
            if (ax4.d.b(r101, 870601) == false) goto L16;
            AccountService$Account r108 = ((h0) org.koin.java.a.c(h0.class, null, null, 6)).G2();
            if (r108 != null) goto L10;
        L12:
            if (r107 == false) goto L14;
            r106 = r100.getString(R.string.Doc_Share_NotSupportEnterpriseUser);
            goto L138
        L14:
            r106 = r100.getString(R.string.Doc_Share_NotSupportExternalUser);
            goto L138
        L10:
            if (r108.isConsumer() != true) goto L12;
            r107 = true;
            goto L12
        L16:
            if (ax4.d.b(r101, 10004) == false) goto L19;
            r106 = r100.getString(R.string.Doc_Share_AdministratorCloseShare);
            goto L138
        L19:
            if (ax4.d.b(r101, 10005) == false) goto L22;
            r106 = r100.getString(R.string.Doc_Share_OwnerCloseShare);
            goto L138
        L22:
            if (ax4.d.b(r101, 10014) == false) goto L25;
            r106 = r100.getString(R.string.CreationMobile_ECM_MaxCollaboratorsToast);
            goto L138
        L25:
            if (ax4.d.b(r101, 10040) == false) goto L28;
            r106 = r100.getString(R.string.CreationMobile_DataUpgrade_Locked_toast);
            goto L138
        L28:
            if ((r101 instanceof NetService.ServerErrorException) == false) goto L137;
            NetService.ServerErrorException r109 = (NetService.ServerErrorException) r101;
            String r110 = r109.getJson();
            if (r110 != null) goto L32;
        L37:
            boolean r111 = false;
        L38:
            if (r111 == false) goto L137;
            InviteResult r112 = com.bytedance.ee.bear.middleground.permission.collaborator.invite.h.a(r109.getJson());
            InviteData r113 = r112.getData();
            if (r113 != null) goto L42;
        L44:
            boolean r114 = false;
        L45:
            if (r114 == false) goto L47;
            r106 = r100.getString(R.string.Doc_Share_OwnerCloseShare);
            goto L138
        L47:
            InviteData r115 = r112.getData();
            if (r115 != null) goto L50;
        L52:
            boolean r116 = false;
        L53:
            if (r116 == false) goto L55;
            r106 = r100.getString(R.string.Doc_Share_AdministratorCloseShare);
            goto L138
        L55:
            InviteData r117 = r112.getData();
            if (r117 == null) goto L62;
            ArrayList<NotNotifyUserEntity> r118 = r117.blockUsers;
            if (r118 == null) goto L62;
            if ((!r118.isEmpty()) != true) goto L62;
            boolean r119 = true;
        L64:
            if (r119 == false) goto L66;
            r106 = xo5.a.c(r100, R.string.Doc_Permission_BlockUnableInviteCollaboratorToast, "userName", ui5.a.a(r112.getData().blockUsers));
            r105 = "block";
            goto L138
        L66:
            InviteData r120 = r112.getData();
            if (r120 == null) goto L73;
            ArrayList<NotNotifyUserEntity> r121 = r120.blockedUsers;
            if (r121 == null) goto L73;
            if ((!r121.isEmpty()) != true) goto L73;
            boolean r122 = true;
        L75:
            if (r122 == false) goto L77;
            r106 = r100.getString(R.string.LarkCCM_BlockSettings_UnableToInvite_Toast);
            r105 = "blocked";
            goto L138
        L77:
            InviteData r123 = r112.getData();
            if (r123 != null) goto L80;
        L82:
            boolean r124 = false;
        L83:
            if (r124 == false) goto L85;
            r106 = r100.getString(R.string.LarkCCM_BlockSettings_UnableToInvite_Toast);
            goto L138
        L85:
            InviteData r125 = r112.getData();
            if (r125 == null) goto L92;
            ArrayList<NotNotifyUserEntity> r126 = r125.privacyUsers;
            if (r126 == null) goto L92;
            if ((!r126.isEmpty()) != true) goto L92;
            boolean r127 = true;
        L93:
            if (r127 == false) goto L95;
            r106 = xo5.a.c(r100, R.string.Doc_Permission_SettingInviteCollaboratorShareToast, "userName", ui5.a.a(r112.getData().privacyUsers));
            r105 = "privacy_setting";
            goto L138
        L95:
            InviteData r128 = r112.getData();
            if (r128 == null) goto L102;
            ArrayList<NotNotifyUserEntity> r129 = r128.limitUsers;
            if (r129 == null) goto L102;
            if ((!r129.isEmpty()) != true) goto L102;
            boolean r130 = true;
        L103:
            if (r130 == false) goto L109;
            String r131 = ui5.a.a(r112.getData().limitUsers);
            if (r112.getData().limitNum > 0) goto L107;
            int r132 = 20;
        L108:
            HashMap r133 = new HashMap();
            r133.put("userName", r131);
            r133.put("count", String.valueOf(r132));
            r106 = xo5.a.d(r100, R.string.Doc_Permission_MaxShareInvitationContactsToast, r133);
            r105 = "more_then_limited";
            goto L138
        L107:
            r132 = r112.getData().limitNum;
            goto L108
        L109:
            InviteData r134 = r112.getData();
            if (r134 == null) goto L116;
            ArrayList<NotNotifyUserEntity> r135 = r134.phoneLimitUsers;
            if (r135 == null) goto L116;
            if ((!r135.isEmpty()) != true) goto L116;
            boolean r136 = true;
        L117:
            if (r136 == false) goto L119;
            r106 = xo5.a.c(r100, R.string.Doc_Permission_MaxSharePhonenumberInvitationToast, "userName", ui5.a.a(r112.getData().phoneLimitUsers));
            r105 = "phone_invite_limited";
            goto L138
        L119:
            InviteData r137 = r112.getData();
            if (r137 == null) goto L126;
            List<NotNotifyUserEntity> r138 = r137.notNotifyUsers;
            if (r138 == null) goto L126;
            if ((!r138.isEmpty()) != true) goto L126;
            boolean r139 = true;
        L127:
            if (r139 == false) goto L129;
            r106 = xo5.a.c(r100, R.string.Doc_Permission_NotNotifyUser, "users", ui5.a.a(r112.getData().notNotifyUsers));
            r105 = "admin_setting";
            goto L138
        L129:
            InviteData r140 = r112.getData();
            if (r140 != null) goto L132;
        L134:
            if (r107 == false) goto L136;
            r106 = r100.getString(R.string.LarkCCM_Docs_InviteEmail_ReachLimitToday_Toast);
            goto L138
        L136:
            r106 = r100.getString(R.string.Doc_Share_AddCollaboratorFailed);
            goto L138
        L132:
            if (r140.emailExceedLimit != true) goto L134;
            r107 = true;
        L126:
            r139 = false;
        L116:
            r136 = false;
        L102:
            r130 = false;
        L92:
            r127 = false;
            goto L93
        L80:
            if (r123.blockedCode != 10022) goto L82;
            r124 = true;
        L73:
            r122 = false;
        L62:
            r119 = false;
            goto L64
        L50:
            if (r115.limitCodeByAdmin != 10004) goto L52;
            r116 = true;
            goto L53
        L42:
            if (r113.limitCode != 10005) goto L44;
            r114 = true;
            goto L45
        L32:
            if (r110.length() <= 0) goto L34;
            boolean r141 = true;
        L35:
            if (r141 != true) goto L37;
            r111 = true;
            goto L38
        L34:
            r141 = false;
        L137:
            r106 = r100.getString(R.string.Doc_Share_AddCollaboratorFailed);
            goto L138
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class d implements DialogInterface.OnClickListener {
        public d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r110, int r111) {
            String r112 = com.bytedance.ee.bear.middleground.permission.c.f233147a;
            JSONObject r113 = new JSONObject();
            String r100 = com.bytedance.ee.bear.middleground.permission.c.f233152f;
            int r101 = com.bytedance.ee.bear.middleground.permission.c.f233153g;
            if (com.bytedance.ee.bear.middleground.permission.c.f233149c == false) goto L5;
            String r102 = ThumbGlideUrl.SOURCE_VC;
        L6:
            com.bytedance.ee.bear.middleground.permission.c.a(r113, r100, r101, r102, com.bytedance.ee.bear.middleground.permission.c.f233154h, com.bytedance.ee.bear.middleground.permission.c.f233150d, com.bytedance.ee.bear.middleground.permission.c.f233151e, com.bytedance.ee.bear.middleground.permission.c.f233147a, com.bytedance.ee.bear.middleground.permission.c.f233148b, com.bytedance.ee.bear.middleground.permission.c.f233155i);
            r113.put("click", "known");
            r113.put(PickerReporterConstants.KEY.TARGET, "none");
            com.bytedance.ee.bear.middleground.permission.c.c("ccm_permission_organization_excess_notice_click", r113);
            if (r110 == null) goto L10;
            r110.dismiss();
            return;
        L10:
            return;
        L5:
            r102 = "none";
            goto L6
        }
    }

    public static final class e implements UDToast.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Ref.BooleanRef f545866a;

        public e(Ref.BooleanRef r100) {
            this.f545866a = r100;
        }

        @Override // com.larksuite.component.universe_design.toast.UDToast.b
        public final void a(com.ss.android.lark.compose.foundation.toast.b r100) {
            Intrinsics.checkNotNullParameter(r100, "toast");
            tt5.a.h("BaseInviteMemberManagerView", "click undo");
            Toast.showSuccessText(eu5.b.f474075a, R.string.Doc_Permission_PermissionsNotificationSuccessToast);
            r100.cancel();
            this.f545866a.element = true;
        }
    }

    public static final class f implements UDToast.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Ref.BooleanRef f545867a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f545868b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f545869c;

        @Override // com.larksuite.component.universe_design.toast.UDToast.c
        public final void a() {
            tt5.a.h("BaseInviteMemberManagerView", "dismiss()...isUndoClick = " + this.f545867a.element);
            if (this.f545867a.element == true) goto L8;
            p.a r100 = this.f545868b.f545854d;
            if (r100 == null) goto L9;
            r100.D0(this.f545869c);
            return;
        L9:
            return;
        }

        public f(Ref.BooleanRef r100, b r101, String r102) {
            this.f545867a = r100;
            this.f545868b = r101;
            this.f545869c = r102;
        }
    }

    public static final class g extends t {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ b f545870c;

        public g(b r100) {
            this.f545870c = r100;
        }

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r100) {
            Context r101 = this.f545870c.f545851a;
            Toast.showText(r101, r101.getString(R.string.LarkCCM_Workspace_AddUserGroup_CantSendInvite_Tooltip));
        }
    }

    static {
    }

    public int D() {
        return R.string.Doc_Share_CollaboratorInvite;
    }

    public boolean j0() {
        return false;
    }

    public abstract BaseInviteCollaboratorManageAdapter p();

    @Override // tg5.p
    public boolean u6() {
        return true;
    }

    public boolean x0() {
        return !(this instanceof ou4.c);
    }

    public final BaseInviteCollaboratorManageAdapter L() {
        BaseInviteCollaboratorManageAdapter r100 = this.f545855e;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("managerAdapter");
        return null;
    }

    @Override // tg5.p
    public final void N1() {
        Context r100 = this.f545851a;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        UDDialogBuilder r101 = new UDDialogBuilder(r100);
        r101.autoDismiss(true);
        r101.backgroundColor(R.color.bg_body);
        r101.messageTextColor(R.color.text_title);
        r101.messageGravity(GravityCompat.START);
        r101.message(R.string.LarkCCM_Workspace_InviteOrg_MuteNotice_Content_Popup);
        r101.titleColor(R.color.text_title);
        r101.titleBold(true);
        r101.cancelOnTouchOutside(false);
        r101.gravity(17);
        r101.title(R.string.LarkCCM_Workspace_InviteOrg_MuteNotice_Content_Header);
        r101.addActionButton(R.id.ud_dialog_btn_primary, R.string.LarkCCM_Workspace_InviteOrg_MuteNotice_GotIt_Button, new d());
        UDDialog r102 = r101.build();
        if (DialogLancet.shouldBlockDialogShow(r102) == false) goto L14;
        DialogLancet.handleBlockedDialogShow(r102);
    L7:
        String r103 = com.bytedance.ee.bear.middleground.permission.c.f233147a;
        JSONObject r104 = new JSONObject();
        String r105 = com.bytedance.ee.bear.middleground.permission.c.f233152f;
        int r106 = com.bytedance.ee.bear.middleground.permission.c.f233153g;
        if (com.bytedance.ee.bear.middleground.permission.c.f233149c == false) goto L10;
        String r107 = ThumbGlideUrl.SOURCE_VC;
    L11:
        com.bytedance.ee.bear.middleground.permission.c.a(r104, r105, r106, r107, com.bytedance.ee.bear.middleground.permission.c.f233154h, com.bytedance.ee.bear.middleground.permission.c.f233150d, com.bytedance.ee.bear.middleground.permission.c.f233151e, com.bytedance.ee.bear.middleground.permission.c.f233147a, com.bytedance.ee.bear.middleground.permission.c.f233148b, com.bytedance.ee.bear.middleground.permission.c.f233155i);
        com.bytedance.ee.bear.middleground.permission.c.c("ccm_permission_organization_excess_notice_view", r104);
        return;
    L10:
        r107 = "none";
        goto L11
    L14:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L13
    L6:
        DialogLancet.beforeDialogShow(r102);
        r102.show();
        DialogLancet.afterDialogShow(r102);
        goto L7
    }

    public final void T() {
        if (((UDNotice) this.f545852b.findViewById(R.id.bannerTipsLayout)).getVisibility() == 8) goto L6;
        ((UDNotice) this.f545852b.findViewById(R.id.bannerTipsLayout)).setVisibility(8);
        return;
    }

    public final void Y() {
        if (((UDNotice) this.f545852b.findViewById(R.id.bannerTipsLayout2)).getVisibility() == 8) goto L6;
        ((UDNotice) this.f545852b.findViewById(R.id.bannerTipsLayout2)).setVisibility(8);
        return;
    }

    public final void a0() {
        if (((UDNotice) this.f545852b.findViewById(R.id.bannerTipsLayout3)).getVisibility() == 8) goto L6;
        ((UDNotice) this.f545852b.findViewById(R.id.bannerTipsLayout3)).setVisibility(8);
        return;
    }

    @Override // tg5.p
    public final boolean b8() {
        return ((UDCheckBox) this.f545852b.findViewById(R.id.notificationCheckbox)).isChecked();
    }

    @Override // com.larksuite.framework.mvp.ILifecycle
    public void create() {
        ((SpaceEditText) this.f545852b.findViewById(R.id.notesInput)).setHint(this.f545851a.getString(com.bytedance.ee.bear.middleground.permission.collaborator.invite.b.b(this.f545853c, R.string.LarkCCM_ChatShare_AddNote_Placeholder, R.string.Doc_Permission_AddNotesDesc)));
        h0();
        BaseInviteCollaboratorManageAdapter r100 = p();
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f545855e = r100;
        ((RecyclerView) this.f545852b.findViewById(R.id.usersRv)).setLayoutManager(new LinearLayoutManagerWrapper(this.f545851a));
        ((RecyclerView) this.f545852b.findViewById(R.id.usersRv)).setAdapter(L());
        this.f545856f = new q(this.f545851a);
        ((RecyclerView) this.f545852b.findViewById(R.id.usersRv)).addOnScrollListener(new BaseInviteMemberManagerView$initRecyclerView$1());
        this.f545857g = vu5.b.a((TextView) this.f545852b.findViewById(R.id.notesInput)).debounce(300, TimeUnit.MILLISECONDS, fo5.d.a()).observeOn(fo5.d.d()).subscribe(new tg5.g(this), h.f545876a);
        ((ImageView) this.f545852b.findViewById(R.id.titleBackIcon)).setOnClickListener(new tg5.c(this));
        ((UDCheckBox) this.f545852b.findViewById(R.id.notificationCheckbox)).setOnCheckedChangeListener(new tg5.d(this));
        ((UDCheckBox) this.f545852b.findViewById(R.id.containerPermCheckBox)).setOnCheckedChangeListener(new tg5.e(this));
        ((TextView) this.f545852b.findViewById(R.id.inviteBtn)).setOnClickListener(new tg5.f(this));
    }

    @Override // com.larksuite.framework.mvp.ILifecycle
    public final void destroy() {
        q r100 = this.f545856f;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("loadingDialog");
        r100 = null;
    L5:
        r100.a();
        Disposable r101 = this.f545857g;
        boolean r102 = false;
        if (r101 != null) goto L8;
    L10:
        if (r102 == false) goto L15;
        Disposable r103 = this.f545857g;
        if (r103 == null) goto L16;
        r103.dispose();
        return;
    L16:
        return;
    L15:
        return;
    L8:
        if (r101.isDisposed() == true) goto L10;
        r102 = true;
        goto L10
    }

    public final ArrayList<UserInfo> e() {
        p.a r100 = this.f545854d;
        if (r100 == null) goto L7;
        ArrayList<UserInfo> r101 = r100.e();
        if (r101 == null) goto L7;
        return r101;
    L7:
        return new ArrayList();
    }

    @Override // tg5.p
    public final String getNotes() {
        Editable r100 = ((SpaceEditText) this.f545852b.findViewById(R.id.notesInput)).getText();
        if (r100 == null) goto L6;
        String r101 = r100.toString();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    public void h0() {
        this.f545852b.setOnClickListener(ViewOnClickListenerC7723b.f545861a);
        boolean r100 = h();
        ((UDCheckBox) this.f545852b.findViewById(R.id.notificationCheckbox)).setChecked(!r100);
        ((TextView) this.f545852b.findViewById(R.id.inviteBtn)).setText(D());
        UDNotice r101 = (UDNotice) this.f545852b.findViewById(R.id.bannerTipsLayout);
        UDNotice.Type r102 = UDNotice.Type.WARNING;
        r101.setType(r102);
        ((UDNotice) this.f545852b.findViewById(R.id.bannerTipsLayout2)).setType(r102);
        o0(!r100);
    }

    @Override // tg5.p
    public final void hideLoading() {
        q r100 = this.f545856f;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("loadingDialog");
        r100 = null;
    L5:
        r100.a();
    }

    @Override // tg5.p
    public void o6() {
        String r100 = this.f545851a.getString(R.string.Doc_Share_AddCollaboratorSuccessfully);
        Toast.showSuccessText(this.f545851a, r100);
    }

    @Override // tg5.p
    public final void showLoading() {
        q r100 = this.f545856f;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("loadingDialog");
        r100 = null;
    L5:
        r100.e();
    }

    @Override // tg5.p
    public void A8() {
        Iterator<UserInfo> r100 = e().iterator();
        boolean r101 = false;
        boolean r102 = false;
        boolean r103 = false;
    L4:
        if (r100.hasNext() == false) goto L16;
        UserInfo r104 = r100.next();
        if (r104.getOwnerType() != 18) goto L9;
        r101 = true;
    L9:
        if (r104.isExternal() == false) goto L12;
        r102 = true;
    L12:
        if (r104.isExternal() == true) goto L4;
        if (r104.getOwnerType() != 2) goto L4;
        r103 = true;
        goto L4
    L16:
        tt5.a.h("BaseInviteMemberManagerView", "isContainsDep=" + r101 + ", isContainsExternal=" + r102 + ", isContainsInner=" + r103);
        if (b8() == false) goto L22;
        if (r101 == false) goto L22;
        ((UDNotice) this.f545852b.findViewById(R.id.bannerTipsLayout)).setText(xo5.a.c(this.f545851a, R.string.CreatinoMobile_Minutes_share_notification, "bot", this.f545851a.getString(com.bytedance.ee.bear.middleground.permission.collaborator.invite.b.a(this.f545853c))));
        if (((UDNotice) this.f545852b.findViewById(R.id.bannerTipsLayout)).getVisibility() == 0) goto L23;
        ((UDNotice) this.f545852b.findViewById(R.id.bannerTipsLayout)).setVisibility(0);
    L23:
        boolean r105 = this.f545860j;
        if (r105 == false) goto L26;
    L29:
        if (r105 == false) goto L31;
    L34:
        Y();
        return;
    L31:
        if (this.f545859i == true) goto L34;
        if (r103 == false) goto L34;
        u4 r106 = u4.f229807a;
        Context r107 = this.f545851a;
        int r108 = this.f545853c;
        r106.getClass();
        String r109 = xo5.a.c(this.f545851a, R.string.Doc_Permission_ExternalOwnerShareTips, "doc_type", u4.a(r107, r108));
        Intrinsics.checkNotNull(r109);
        u0(r109);
        return;
    L26:
        if (this.f545859i == false) goto L29;
        if (r102 == false) goto L29;
        u4 r110 = u4.f229807a;
        Context r111 = this.f545851a;
        int r112 = this.f545853c;
        r110.getClass();
        String r113 = xo5.a.c(this.f545851a, R.string.Doc_Permission_ExternalUsersSendInvitationTips, "doc_type", u4.a(r111, r112));
        Intrinsics.checkNotNull(r113);
        u0(r113);
        return;
    L22:
        T();
        goto L23
    }

    public final String C() {
        Iterator<UserInfo> r100 = e().iterator();
    L4:
        if (r100.hasNext() == false) goto L9;
        UserInfo r101 = r100.next();
        if (r101.getOwnerType() != 29) goto L4;
        return r101.getDisplayName();
    L9:
        return "";
    }

    public final boolean h() {
        Iterator<UserInfo> r100 = e().iterator();
    L4:
        if (r100.hasNext() == false) goto L9;
        if (r100.next().getOwnerType() != 18) goto L4;
        return true;
    L9:
        return false;
    }

    public final boolean k() {
        Iterator<UserInfo> r100 = e().iterator();
    L4:
        if (r100.hasNext() == false) goto L9;
        if (r100.next().getOwnerType() != 29) goto L4;
        return true;
    L9:
        return false;
    }

    public final boolean o() {
        if (hu5.a.d(e()) == false) goto L5;
        return false;
    L5:
        Iterator<UserInfo> r100 = e().iterator();
    L7:
        if (r100.hasNext() == false) goto L11;
        if (r100.next().getOwnerType() == 29) goto L7;
        return false;
    L11:
        return true;
    }

    public final int s() {
        Iterator<UserInfo> r100 = e().iterator();
        int r101 = 0;
    L4:
        if (r100.hasNext() == false) goto L8;
        if (r100.next().getOwnerType() != 29) goto L4;
        r101 = r101 + 1;
        goto L4
    L8:
        return r101;
    }

    public final HashMap<String, String> w() {
        Iterator<UserInfo> r100 = e().iterator();
        int r101 = 0;
        String r102 = "";
    L4:
        if (r100.hasNext() == false) goto L14;
        UserInfo r103 = r100.next();
        if (r103.getOwnerType() != 29) goto L4;
        r101 = r101 + 1;
        if (r101 != 1) goto L10;
        r102 = r103.getDisplayName();
        goto L4
    L10:
        if (r101 != 2) goto L4;
        r102 = r102 + ", " + r103.getDisplayName();
        goto L4
    L14:
        HashMap<String, String> r104 = new HashMap();
        r104.put("email", r102);
        r104.put("num", String.valueOf(r101));
        return r104;
    }

    public final void D0(boolean r100) {
        if (r100 == false) goto L4;
        int r101 = R.string.CreationMobile_Wiki_SharePanel_AllowAccess_OnDesc;
    L5:
        ((TextView) this.f545852b.findViewById(R.id.containerPermTipsDesc)).setText(r101);
        UDNotice r102 = (UDNotice) this.f545852b.findViewById(R.id.bannerTipsLayout3);
        if (r100 == false) goto L8;
        int r103 = 8;
    L9:
        r102.setVisibility(r103);
        return;
    L8:
        r103 = 0;
        goto L9
    L4:
        r101 = R.string.CreationMobile_Wiki_SharePanel_AllowAccess_OffDesc;
        goto L5
    }

    @Override // tg5.p
    public final void F(ArrayList<UserInfo> r100) {
        Intrinsics.checkNotNullParameter(r100, "selectedUserList");
        L().setNewData(r100);
    }

    public final void O0(ArrayList<UserInfo> r100) {
        Intrinsics.checkNotNullParameter(r100, "selectedUserList");
        if (hu5.a.d(r100) == false) goto L5;
        boolean r101 = false;
    L14:
        if (r101 == false) goto L16;
        ((UDCheckBox) this.f545852b.findViewById(R.id.notificationCheckbox)).setEnabled(false);
        ((TextView) this.f545852b.findViewById(R.id.notificationTv)).setEnabled(false);
        this.f545852b.findViewById(R.id.notificationCheckboxWrapper).setVisibility(0);
        this.f545852b.findViewById(R.id.notificationCheckboxWrapper).setOnClickListener(new g(this));
        ((SpaceEditText) this.f545852b.findViewById(R.id.notesInput)).setText("");
        t0(false);
        return;
    L16:
        ArrayList<UserInfo> r102 = e();
        if (hu5.a.d(r102) == true) goto L25;
        Iterator<UserInfo> r103 = r102.iterator();
    L21:
        if (r103.hasNext() == false) goto L25;
        if (r103.next().getOwnerType() != 29) goto L21;
        boolean r104 = true;
    L26:
        if (r104 == false) goto L28;
        ((UDCheckBox) this.f545852b.findViewById(R.id.notificationCheckbox)).setEnabled(false);
        ((TextView) this.f545852b.findViewById(R.id.notificationTv)).setEnabled(false);
        t0(true);
        this.f545852b.findViewById(R.id.notificationCheckboxWrapper).setVisibility(0);
        this.f545852b.findViewById(R.id.notificationCheckboxWrapper).setOnClickListener(new n(this));
        return;
    L28:
        ((UDCheckBox) this.f545852b.findViewById(R.id.notificationCheckbox)).setEnabled(true);
        ((TextView) this.f545852b.findViewById(R.id.notificationTv)).setEnabled(true);
        this.f545852b.findViewById(R.id.notificationCheckboxWrapper).setVisibility(8);
        this.f545852b.findViewById(R.id.notificationCheckboxWrapper).setOnClickListener(null);
        return;
    L25:
        r104 = false;
        goto L26
    L5:
        Iterator<T> r105 = r100.iterator();
        r101 = true;
    L7:
        if (r105.hasNext() == false) goto L14;
        UserInfo r106 = (UserInfo) r105.next();
        if (r106.getOwnerType() == 22) goto L7;
        if (r106.getOwnerType() == 30) goto L7;
        r101 = false;
        goto L7
    }

    public final String P(List<? extends NotNotifyUserEntity> r100) {
        HashMap r101 = new HashMap();
        r101.put("operate", this.f545851a.getString(R.string.Doc_Share_AddCollaboratorSuccessfully));
        r101.put("reason", this.f545851a.getString(R.string.Doc_Permission_AdminSetting));
        r101.put("users", ui5.a.a(r100));
        return xo5.a.d(this.f545851a, R.string.Doc_Permission_NotNotifyTip, r101);
    }

    @Override // tg5.p
    public final void W0(List<? extends NotNotifyUserEntity> r100) {
        Intrinsics.checkNotNullParameter(r100, "notNotifyUsers");
        Toast.showSuccessText(this.f545851a, P(r100));
    }

    @Override // tg5.p
    public final void h8(List<? extends NotNotifyUserEntity> r100) {
        Intrinsics.checkNotNullParameter(r100, "notPartnerTenantUser");
        int r101 = this.f545853c;
        if (r101 != 0) goto L5;
        int r102 = R.string.CreationMobile_ECM_Security_Conflict_Confirm_Scenario9;
    L9:
        Context r103 = this.f545851a;
        Toast.showText(r103, xo5.a.c(r103, r102, "collaborators", ui5.a.a(r100)));
        return;
    L5:
        if (r101 == 28) goto L7;
        r102 = com.bytedance.ee.bear.middleground.permission.collaborator.invite.b.b(r101, R.string.LarkCCM_ChatShare_SecurityPolicyPartiallyInvitedCollaborators_Text, R.string.CreationMobile_ECM_Security_Conflict_Confirm_Scenario6);
        goto L9
    L7:
        r102 = R.string.LarkCCM_Docs_MagicShare_SomeMembersInvitedSuccessful_Toast;
        goto L9
    }

    public void o0(boolean r100) {
        SpaceEditText r101 = (SpaceEditText) this.f545852b.findViewById(R.id.notesInput);
        if (r100 == false) goto L5;
        int r102 = 0;
    L6:
        r101.setVisibility(r102);
        return;
    L5:
        r102 = 8;
        goto L6
    }

    @Override // tg5.p
    public final void r1(List<? extends NotNotifyUserEntity> r100) {
        Intrinsics.checkNotNullParameter(r100, "notPartnerTenantUser");
        int r101 = this.f545853c;
        if (r101 != 0) goto L5;
        int r102 = R.string.CreationMobile_ECM_Security_Conflict_Confirm_Scenario7;
    L9:
        Context r103 = this.f545851a;
        Toast.showText(r103, xo5.a.c(r103, r102, "collaborators", ui5.a.a(r100)));
        return;
    L5:
        if (r101 == 28) goto L7;
        r102 = com.bytedance.ee.bear.middleground.permission.collaborator.invite.b.b(r101, R.string.LarkCCM_ChatShare_SecurityPolicyUnableToInviteCollaborators_Text, R.string.CreationMobile_ECM_Security_Conflict_Confirm_Scenario4);
        goto L9
    L7:
        r102 = R.string.LarkCCM_Docs_MagicShare_UnableToShareContentWithMembers_Toast;
        goto L9
    }

    @Override // com.larksuite.framework.mvp.IView
    public final void setViewDelegate(IView.IViewDelegate r100) {
        this.f545854d = (p.a) r100;
    }

    public final void t0(boolean r100) {
        ((UDCheckBox) this.f545852b.findViewById(R.id.notificationCheckbox)).setChecked(r100);
        o0(r100);
    }

    public final void u0(String r100) {
        ((UDNotice) this.f545852b.findViewById(R.id.bannerTipsLayout2)).setText(r100);
        if (((UDNotice) this.f545852b.findViewById(R.id.bannerTipsLayout2)).getVisibility() == 0) goto L6;
        ((UDNotice) this.f545852b.findViewById(R.id.bannerTipsLayout2)).setVisibility(0);
        return;
    }

    @Override // tg5.p
    public final void w5(String r100) {
        Intrinsics.checkNotNullParameter(r100, "notificationId");
        B0(this.f545851a.getString(R.string.Doc_Share_AddCollaboratorSuccessfully), r100);
    }

    public final void B0(String r100, String r101) {
        Ref.BooleanRef r102 = new Ref.BooleanRef();
        UDToast.a r103 = UDToast.build(this.f545851a);
        r103.g(r100);
        r103.d(Toast.getSuccessIcon());
        r103.b(R.string.Doc_Permission_AddUserCancelNotice, new e(r102));
        r103.f(new f(r102, this, r101));
        r103.h();
    }

    @Override // tg5.p
    public final void J7(List<? extends NotNotifyUserEntity> r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "notNotifyUsers");
        Intrinsics.checkNotNullParameter(r101, "notificationId");
        B0(P(r100), r101);
    }

    @Override // tg5.p
    public final void K5(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "title");
        Intrinsics.checkNotNullParameter(r101, "desp");
        BearUDDialogBuilder r102 = new BearUDDialogBuilder(this.f545851a);
        r102.i(r100);
        r102.f(r101);
        r102.b(R.id.ud_dialog_btn_primary, R.string.Doc_Facade_GotIt, R.color.primary_fill_default, null);
        r102.f240192a.style(R.style.ActionSheetDialogStyle);
        r102.h();
    }

    @Override // tg5.p
    public final void b2(Throwable r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, LynxError.LYNX_THROWABLE);
        Intrinsics.checkNotNullParameter(r101, "token");
        Intrinsics.checkNotNullParameter(r102, EventConstant.Key.MODULE);
        ((com.bytedance.ee.bear.review.a) org.koin.java.a.c(com.bytedance.ee.bear.review.a.class, null, null, 6)).c(this.f545851a, r100, new c(this, r100, r101, r102));
    }

    public b(Context r100, View r101, int r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "rootView");
        Intrinsics.checkNotNullParameter(r103, "creatorTenantId");
        this.f545851a = r100;
        this.f545852b = r101;
        this.f545853c = r102;
        boolean r104 = true;
        this.f545858h = true;
        AccountService$Account r105 = ((h0) org.koin.java.a.c(h0.class, null, null, 6)).G2();
        if (r105 == null) goto L6;
        String r106 = r105.tenantId;
        if (r106 == null) goto L6;
    L7:
        boolean r107 = TextUtils.equals(r106, r103);
        this.f545859i = r107;
        if (r105 == null) goto L10;
        boolean r108 = r105.isConsumer();
    L11:
        this.f545860j = r108;
        StringBuilder r109 = new StringBuilder("isSameTenant=");
        r109.append(r107);
        r109.append(", userTenantId is empty=");
        if (r106.length() == 0) goto L15;
        r104 = false;
    L15:
        r109.append(r104);
        r109.append(", isConsumer=");
        r109.append(r108);
        tt5.a.h("BaseInviteMemberManagerView", r109.toString());
        return;
    L10:
        r108 = false;
    L6:
        r106 = "";
        goto L7
    }
}
