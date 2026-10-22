package tg5;

import android.content.Context;
import android.content.DialogInterface;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.ee.bear.contract.AccountService;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.facade.common.widget.recyclerview.LinearLayoutManagerWrapper;
import com.bytedance.ee.bear.list.u4;
import com.bytedance.ee.bear.middleground.feed.export.bean.panelv2.Notice;
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
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larksuite.component.universe_design.dialog.UDDialogBuilder;
import com.larksuite.component.universe_design.edittext.UDEditText;
import com.larksuite.component.universe_design.notice.UDNotice;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larksuite.framework.mvp.IView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public abstract class b implements p {
    public final Context a;
    public final View b;
    public final int c;
    public p.a d;
    public BaseInviteCollaboratorManageAdapter e;
    public q f;
    public Disposable g;
    public boolean h;
    public final boolean i;
    public final boolean j;

    public static final class a {
    }

    /* JADX INFO: renamed from: tg5.b$b, reason: collision with other inner class name */
    public static final class ViewOnClickListenerC0310b implements View.OnClickListener {
        public static final ViewOnClickListenerC0310b a = null;

        static {
            a = new ViewOnClickListenerC0310b();
        }

        public ViewOnClickListenerC0310b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            tt5.a.h("BaseInviteMemberManagerView", "rootView click");
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ b a;
        public final /* synthetic */ Throwable b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;

        public c(b r1, Throwable r2, String r3, String r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void a() {
            Context r0 = this.a.a;
            NetService.ServerErrorException r1 = this.b;
            String r2 = this.c;
            String r3 = this.d;
            int r4 = ui5.a.a;
            Intrinsics.checkNotNullParameter(r0, "context");
            Intrinsics.checkNotNullParameter(r1, "throwable");
            String r5 = "others";
            if (ax4.d.b(r1, 4114) == false) goto L5;
            String r6 = xo5.a.c(r0, 2131888245, "folderName", r1.getMsg());
        L138:
            Toast.showFailureText(r0, r6);
            PermissionAnalytic.j(r5, r2, r3, "invited_collaborate");
            return;
        L5:
            boolean r7 = false;
            if (ax4.d.b(r1, 870601) == false) goto L16;
            AccountService.Account r8 = ((h0) org.koin.java.a.c(h0.class, null, null, 6)).G2();
            if (r8 != null) goto L10;
        L12:
            if (r7 == false) goto L14;
            r6 = r0.getString(2131888230);
            goto L138
        L14:
            r6 = r0.getString(2131888231);
            goto L138
        L10:
            if (r8.isConsumer() != true) goto L12;
            r7 = true;
            goto L12
        L16:
            if (ax4.d.b(r1, 10004) == false) goto L19;
            r6 = r0.getString(2131888200);
            goto L138
        L19:
            if (ax4.d.b(r1, 10005) == false) goto L22;
            r6 = r0.getString(2131888235);
            goto L138
        L22:
            if (ax4.d.b(r1, 10014) == false) goto L25;
            r6 = r0.getString(2131887276);
            goto L138
        L25:
            if (ax4.d.b(r1, 10040) == false) goto L28;
            r6 = r0.getString(2131887146);
            goto L138
        L28:
            if ((r1 instanceof NetService.ServerErrorException) == false) goto L137;
            NetService.ServerErrorException r9 = r1;
            String r10 = r9.getJson();
            if (r10 != null) goto L32;
        L37:
            boolean r11 = false;
        L38:
            if (r11 == false) goto L137;
            InviteResult r12 = com.bytedance.ee.bear.middleground.permission.collaborator.invite.h.a(r9.getJson());
            InviteData r13 = r12.getData();
            if (r13 != null) goto L42;
        L44:
            boolean r14 = false;
        L45:
            if (r14 == false) goto L47;
            r6 = r0.getString(2131888235);
            goto L138
        L47:
            InviteData r15 = r12.getData();
            if (r15 != null) goto L50;
        L52:
            boolean r16 = false;
        L53:
            if (r16 == false) goto L55;
            r6 = r0.getString(2131888200);
            goto L138
        L55:
            InviteData r17 = r12.getData();
            if (r17 == null) goto L62;
            ArrayList<NotNotifyUserEntity> r18 = r17.blockUsers;
            if (r18 == null) goto L62;
            if ((!r18.isEmpty()) != true) goto L62;
            boolean r19 = true;
        L64:
            if (r19 == false) goto L66;
            r6 = xo5.a.c(r0, 2131888078, "userName", ui5.a.a(r12.getData().blockUsers));
            r5 = "block";
            goto L138
        L66:
            InviteData r20 = r12.getData();
            if (r20 == null) goto L73;
            ArrayList<NotNotifyUserEntity> r21 = r20.blockedUsers;
            if (r21 == null) goto L73;
            if ((!r21.isEmpty()) != true) goto L73;
            boolean r22 = true;
        L75:
            if (r22 == false) goto L77;
            r6 = r0.getString(2131888737);
            r5 = "blocked";
            goto L138
        L77:
            InviteData r23 = r12.getData();
            if (r23 != null) goto L80;
        L82:
            boolean r24 = false;
        L83:
            if (r24 == false) goto L85;
            r6 = r0.getString(2131888737);
            goto L138
        L85:
            InviteData r25 = r12.getData();
            if (r25 == null) goto L92;
            ArrayList<NotNotifyUserEntity> r26 = r25.privacyUsers;
            if (r26 == null) goto L92;
            if ((!r26.isEmpty()) != true) goto L92;
            boolean r27 = true;
        L93:
            if (r27 == false) goto L95;
            r6 = xo5.a.c(r0, 2131888127, "userName", ui5.a.a(r12.getData().privacyUsers));
            r5 = "privacy_setting";
            goto L138
        L95:
            InviteData r28 = r12.getData();
            if (r28 == null) goto L102;
            ArrayList<NotNotifyUserEntity> r29 = r28.limitUsers;
            if (r29 == null) goto L102;
            if ((!r29.isEmpty()) != true) goto L102;
            boolean r30 = true;
        L103:
            if (r30 == false) goto L109;
            String r31 = ui5.a.a(r12.getData().limitUsers);
            if (r12.getData().limitNum > 0) goto L107;
            int r32 = 20;
        L108:
            HashMap r33 = new HashMap();
            r33.put("userName", r31);
            r33.put("count", String.valueOf(r32));
            r6 = xo5.a.d(r0, 2131888091, r33);
            r5 = "more_then_limited";
            goto L138
        L107:
            r32 = r12.getData().limitNum;
            goto L108
        L109:
            InviteData r34 = r12.getData();
            if (r34 == null) goto L116;
            ArrayList<NotNotifyUserEntity> r35 = r34.phoneLimitUsers;
            if (r35 == null) goto L116;
            if ((!r35.isEmpty()) != true) goto L116;
            boolean r36 = true;
        L117:
            if (r36 == false) goto L119;
            r6 = xo5.a.c(r0, 2131888092, "userName", ui5.a.a(r12.getData().phoneLimitUsers));
            r5 = "phone_invite_limited";
            goto L138
        L119:
            InviteData r37 = r12.getData();
            if (r37 == null) goto L126;
            List<NotNotifyUserEntity> r38 = r37.notNotifyUsers;
            if (r38 == null) goto L126;
            if ((!r38.isEmpty()) != true) goto L126;
            boolean r39 = true;
        L127:
            if (r39 == false) goto L129;
            r6 = xo5.a.c(r0, 2131888101, "users", ui5.a.a(r12.getData().notNotifyUsers));
            r5 = "admin_setting";
            goto L138
        L129:
            InviteData r40 = r12.getData();
            if (r40 != null) goto L132;
        L134:
            if (r7 == false) goto L136;
            r6 = r0.getString(2131889100);
            goto L138
        L136:
            r6 = r0.getString(2131888198);
            goto L138
        L132:
            if (r40.emailExceedLimit != true) goto L134;
            r7 = true;
        L126:
            r39 = false;
        L116:
            r36 = false;
        L102:
            r30 = false;
        L92:
            r27 = false;
            goto L93
        L80:
            if (r23.blockedCode != 10022) goto L82;
            r24 = true;
        L73:
            r22 = false;
        L62:
            r19 = false;
            goto L64
        L50:
            if (r15.limitCodeByAdmin != 10004) goto L52;
            r16 = true;
            goto L53
        L42:
            if (r13.limitCode != 10005) goto L44;
            r14 = true;
            goto L45
        L32:
            if (r10.length() <= 0) goto L34;
            boolean r110 = true;
        L35:
            if (r110 != true) goto L37;
            r11 = true;
            goto L38
        L34:
            r110 = false;
        L137:
            r6 = r0.getString(2131888198);
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
        public final void onClick(DialogInterface r12, int r13) {
            String r14 = com.bytedance.ee.bear.middleground.permission.c.a;
            JSONObject r15 = new JSONObject();
            String r1 = com.bytedance.ee.bear.middleground.permission.c.f;
            int r2 = com.bytedance.ee.bear.middleground.permission.c.g;
            if (com.bytedance.ee.bear.middleground.permission.c.c == false) goto L5;
            String r3 = ThumbGlideUrl.SOURCE_VC;
        L6:
            com.bytedance.ee.bear.middleground.permission.c.a(r15, r1, r2, r3, com.bytedance.ee.bear.middleground.permission.c.h, com.bytedance.ee.bear.middleground.permission.c.d, com.bytedance.ee.bear.middleground.permission.c.e, com.bytedance.ee.bear.middleground.permission.c.a, com.bytedance.ee.bear.middleground.permission.c.b, com.bytedance.ee.bear.middleground.permission.c.i);
            r15.put("click", "known");
            r15.put("target", "none");
            com.bytedance.ee.bear.middleground.permission.c.c("ccm_permission_organization_excess_notice_click", r15);
            if (r12 == null) goto L10;
            r12.dismiss();
            return;
        L10:
            return;
        L5:
            r3 = "none";
            goto L6
        }
    }

    public static final class e implements UDToast.b {
        public final /* synthetic */ Ref.BooleanRef a;

        public e(Ref.BooleanRef r1) {
            this.a = r1;
        }

        public final void a(com.ss.android.lark.compose.foundation.toast.b r3) {
            Intrinsics.checkNotNullParameter(r3, Notice.CLICK_TYPE_TOAST);
            tt5.a.h("BaseInviteMemberManagerView", "click undo");
            Toast.showSuccessText(eu5.b.a, 2131888106);
            r3.cancel();
            this.a.element = true;
        }
    }

    public static final class f implements UDToast.c {
        public final /* synthetic */ Ref.BooleanRef a;
        public final /* synthetic */ b b;
        public final /* synthetic */ String c;

        public final void a() {
            tt5.a.h("BaseInviteMemberManagerView", "dismiss()...isUndoClick = " + this.a.element);
            if (this.a.element == true) goto L8;
            p.a r0 = this.b.d;
            if (r0 == null) goto L9;
            r0.D0(this.c);
            return;
        L9:
            return;
        }

        public f(Ref.BooleanRef r1, b r2, String r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class g extends t {
        public final /* synthetic */ b c;

        public g(b r1) {
            this.c = r1;
        }

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r2) {
            Context r3 = this.c.a;
            Toast.showText(r3, r3.getString(2131889836));
        }
    }

    static {
    }

    public int D() {
        return 2131888204;
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
        BaseInviteCollaboratorManageAdapter r0 = this.e;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("managerAdapter");
        return null;
    }

    @Override // tg5.p
    public final void N1() {
        Context r0 = this.a;
        Intrinsics.checkNotNullParameter(r0, "context");
        UDDialogBuilder r1 = new UDDialogBuilder(r0);
        r1.autoDismiss(true);
        r1.backgroundColor(2131100548);
        r1.messageTextColor(2131106622);
        r1.messageGravity(8388611);
        r1.message(2131889878);
        r1.titleColor(2131106622);
        r1.titleBold(true);
        r1.cancelOnTouchOutside(false);
        r1.gravity(17);
        r1.title(2131889877);
        r1.addActionButton(2131391777, 2131889879, new d());
        UDDialog r2 = r1.build();
        if (DialogLancet.shouldBlockDialogShow(r2) == false) goto L14;
        DialogLancet.handleBlockedDialogShow(r2);
    L7:
        String r3 = com.bytedance.ee.bear.middleground.permission.c.a;
        JSONObject r4 = new JSONObject();
        String r5 = com.bytedance.ee.bear.middleground.permission.c.f;
        int r6 = com.bytedance.ee.bear.middleground.permission.c.g;
        if (com.bytedance.ee.bear.middleground.permission.c.c == false) goto L10;
        String r7 = ThumbGlideUrl.SOURCE_VC;
    L11:
        com.bytedance.ee.bear.middleground.permission.c.a(r4, r5, r6, r7, com.bytedance.ee.bear.middleground.permission.c.h, com.bytedance.ee.bear.middleground.permission.c.d, com.bytedance.ee.bear.middleground.permission.c.e, com.bytedance.ee.bear.middleground.permission.c.a, com.bytedance.ee.bear.middleground.permission.c.b, com.bytedance.ee.bear.middleground.permission.c.i);
        com.bytedance.ee.bear.middleground.permission.c.c("ccm_permission_organization_excess_notice_view", r4);
        return;
    L10:
        r7 = "none";
        goto L11
    L14:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L13
    L6:
        DialogLancet.beforeDialogShow(r2);
        r2.show();
        DialogLancet.afterDialogShow(r2);
        goto L7
    }

    public final void T() {
        if (this.b.findViewById(2131363916).getVisibility() == 8) goto L6;
        this.b.findViewById(2131363916).setVisibility(8);
        return;
    }

    public final void Y() {
        if (this.b.findViewById(2131363917).getVisibility() == 8) goto L6;
        this.b.findViewById(2131363917).setVisibility(8);
        return;
    }

    public final void a0() {
        if (this.b.findViewById(2131363918).getVisibility() == 8) goto L6;
        this.b.findViewById(2131363918).setVisibility(8);
        return;
    }

    @Override // tg5.p
    public final boolean b8() {
        return this.b.findViewById(2131381033).isChecked();
    }

    public void create() {
        ((SpaceEditText) this.b.findViewById(2131381012)).setHint(this.a.getString(com.bytedance.ee.bear.middleground.permission.collaborator.invite.b.b(this.c, 2131888859, 2131888038)));
        h0();
        BaseInviteCollaboratorManageAdapter r0 = p();
        Intrinsics.checkNotNullParameter(r0, "<set-?>");
        this.e = r0;
        this.b.findViewById(2131392083).setLayoutManager(new LinearLayoutManagerWrapper(this.a));
        this.b.findViewById(2131392083).setAdapter(L());
        this.f = new q(this.a);
        this.b.findViewById(2131392083).addOnScrollListener(new BaseInviteMemberManagerView$initRecyclerView$1());
        this.g = vu5.b.a((TextView) this.b.findViewById(2131381012)).debounce(300, TimeUnit.MILLISECONDS, fo5.d.a()).observeOn(fo5.d.d()).subscribe(new tg5.g(this), h.a);
        ((ImageView) this.b.findViewById(2131388774)).setOnClickListener(new tg5.c(this));
        this.b.findViewById(2131381033).setOnCheckedChangeListener(new tg5.d(this));
        this.b.findViewById(2131367732).setOnCheckedChangeListener(new tg5.e(this));
        ((TextView) this.b.findViewById(2131375588)).setOnClickListener(new tg5.f(this));
    }

    public final void destroy() {
        q r0 = this.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("loadingDialog");
        r0 = null;
    L5:
        r0.a();
        Disposable r1 = this.g;
        boolean r2 = false;
        if (r1 != null) goto L8;
    L10:
        if (r2 == false) goto L15;
        Disposable r3 = this.g;
        if (r3 == null) goto L16;
        r3.dispose();
        return;
    L16:
        return;
    L15:
        return;
    L8:
        if (r1.isDisposed() == true) goto L10;
        r2 = true;
        goto L10
    }

    public final ArrayList<UserInfo> e() {
        p.a r0 = this.d;
        if (r0 == null) goto L7;
        ArrayList<UserInfo> r1 = r0.e();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return new ArrayList();
    }

    @Override // tg5.p
    public final String getNotes() {
        Editable r0 = ((SpaceEditText) this.b.findViewById(2131381012)).getText();
        if (r0 == null) goto L6;
        String r1 = r0.toString();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    public void h0() {
        this.b.setOnClickListener(ViewOnClickListenerC0310b.a);
        boolean r0 = h();
        this.b.findViewById(2131381033).setChecked(!r0);
        ((TextView) this.b.findViewById(2131375588)).setText(D());
        UDNotice r1 = this.b.findViewById(2131363916);
        UDNotice.Type r2 = UDNotice.Type.WARNING;
        r1.setType(r2);
        this.b.findViewById(2131363917).setType(r2);
        o0(!r0);
    }

    @Override // tg5.p
    public final void hideLoading() {
        q r0 = this.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("loadingDialog");
        r0 = null;
    L5:
        r0.a();
    }

    @Override // tg5.p
    public void o6() {
        String r0 = this.a.getString(2131888199);
        Toast.showSuccessText(this.a, r0);
    }

    @Override // tg5.p
    public final void showLoading() {
        q r0 = this.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("loadingDialog");
        r0 = null;
    L5:
        r0.e();
    }

    @Override // tg5.p
    public void A8() {
        Iterator<UserInfo> r0 = e().iterator();
        boolean r2 = false;
        boolean r3 = false;
        boolean r4 = false;
    L4:
        if (r0.hasNext() == false) goto L16;
        UserInfo r5 = r0.next();
        if (r5.getOwnerType() != 18) goto L9;
        r2 = true;
    L9:
        if (r5.isExternal() == false) goto L12;
        r3 = true;
    L12:
        if (r5.isExternal() == true) goto L4;
        if (r5.getOwnerType() != 2) goto L4;
        r4 = true;
        goto L4
    L16:
        tt5.a.h("BaseInviteMemberManagerView", "isContainsDep=" + r2 + ", isContainsExternal=" + r3 + ", isContainsInner=" + r4);
        if (b8() == false) goto L22;
        if (r2 == false) goto L22;
        this.b.findViewById(2131363916).setText(xo5.a.c(this.a, 2131887101, "bot", this.a.getString(com.bytedance.ee.bear.middleground.permission.collaborator.invite.b.a(this.c))));
        if (this.b.findViewById(2131363916).getVisibility() == 0) goto L23;
        this.b.findViewById(2131363916).setVisibility(0);
    L23:
        boolean r1 = this.j;
        if (r1 == false) goto L26;
    L29:
        if (r1 == false) goto L31;
    L34:
        Y();
        return;
    L31:
        if (this.i == true) goto L34;
        if (r4 == false) goto L34;
        u4 r6 = u4.a;
        Context r7 = this.a;
        int r8 = this.c;
        r6.getClass();
        String r9 = xo5.a.c(this.a, 2131888088, "doc_type", u4.a(r7, r8));
        Intrinsics.checkNotNull(r9);
        u0(r9);
        return;
    L26:
        if (this.i == false) goto L29;
        if (r3 == false) goto L29;
        u4 r10 = u4.a;
        Context r11 = this.a;
        int r12 = this.c;
        r10.getClass();
        String r13 = xo5.a.c(this.a, 2131888089, "doc_type", u4.a(r11, r12));
        Intrinsics.checkNotNull(r13);
        u0(r13);
        return;
    L22:
        T();
        goto L23
    }

    public final String C() {
        Iterator<UserInfo> r0 = e().iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        UserInfo r1 = r0.next();
        if (r1.getOwnerType() != 29) goto L4;
        return r1.getDisplayName();
    L9:
        return "";
    }

    public final boolean h() {
        Iterator<UserInfo> r0 = e().iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        if (r0.next().getOwnerType() != 18) goto L4;
        return true;
    L9:
        return false;
    }

    public final boolean k() {
        Iterator<UserInfo> r0 = e().iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        if (r0.next().getOwnerType() != 29) goto L4;
        return true;
    L9:
        return false;
    }

    public final boolean o() {
        if (hu5.a.d(e()) == false) goto L5;
        return false;
    L5:
        Iterator<UserInfo> r0 = e().iterator();
    L7:
        if (r0.hasNext() == false) goto L11;
        if (r0.next().getOwnerType() == 29) goto L7;
        return false;
    L11:
        return true;
    }

    public final int s() {
        Iterator<UserInfo> r0 = e().iterator();
        int r1 = 0;
    L4:
        if (r0.hasNext() == false) goto L8;
        if (r0.next().getOwnerType() != 29) goto L4;
        r1 = r1 + 1;
        goto L4
    L8:
        return r1;
    }

    public final HashMap<String, String> w() {
        Iterator<UserInfo> r0 = e().iterator();
        int r1 = 0;
        String r2 = "";
    L4:
        if (r0.hasNext() == false) goto L14;
        UserInfo r3 = r0.next();
        if (r3.getOwnerType() != 29) goto L4;
        r1 = r1 + 1;
        if (r1 != 1) goto L10;
        r2 = r3.getDisplayName();
        goto L4
    L10:
        if (r1 != 2) goto L4;
        r2 = r2 + ", " + r3.getDisplayName();
        goto L4
    L14:
        HashMap<String, String> r4 = new HashMap();
        r4.put("email", r2);
        r4.put("num", String.valueOf(r1));
        return r4;
    }

    public final void D0(boolean r4) {
        if (r4 == false) goto L4;
        int r0 = 2131887525;
    L5:
        ((TextView) this.b.findViewById(2131367736)).setText(r0);
        UDNotice r1 = this.b.findViewById(2131363918);
        if (r4 == false) goto L8;
        int r5 = 8;
    L9:
        r1.setVisibility(r5);
        return;
    L8:
        r5 = 0;
        goto L9
    L4:
        r0 = 2131887524;
        goto L5
    }

    @Override // tg5.p
    public final void F(ArrayList<UserInfo> r2) {
        Intrinsics.checkNotNullParameter(r2, "selectedUserList");
        L().setNewData(r2);
    }

    public final void O0(ArrayList<UserInfo> r8) {
        Intrinsics.checkNotNullParameter(r8, "selectedUserList");
        if (hu5.a.d(r8) == false) goto L5;
        boolean r0 = false;
    L14:
        if (r0 == false) goto L16;
        this.b.findViewById(2131381033).setEnabled(false);
        ((TextView) this.b.findViewById(2131381038)).setEnabled(false);
        this.b.findViewById(2131381035).setVisibility(0);
        this.b.findViewById(2131381035).setOnClickListener(new g(this));
        ((SpaceEditText) this.b.findViewById(2131381012)).setText("");
        t0(false);
        return;
    L16:
        ArrayList<UserInfo> r1 = e();
        if (hu5.a.d(r1) == true) goto L25;
        Iterator<UserInfo> r2 = r1.iterator();
    L21:
        if (r2.hasNext() == false) goto L25;
        if (r2.next().getOwnerType() != 29) goto L21;
        boolean r3 = true;
    L26:
        if (r3 == false) goto L28;
        this.b.findViewById(2131381033).setEnabled(false);
        ((TextView) this.b.findViewById(2131381038)).setEnabled(false);
        t0(true);
        this.b.findViewById(2131381035).setVisibility(0);
        this.b.findViewById(2131381035).setOnClickListener(new n(this));
        return;
    L28:
        this.b.findViewById(2131381033).setEnabled(true);
        ((TextView) this.b.findViewById(2131381038)).setEnabled(true);
        this.b.findViewById(2131381035).setVisibility(8);
        this.b.findViewById(2131381035).setOnClickListener(null);
        return;
    L25:
        r3 = false;
        goto L26
    L5:
        Iterator<T> r9 = r8.iterator();
        r0 = true;
    L7:
        if (r9.hasNext() == false) goto L14;
        UserInfo r4 = (UserInfo) r9.next();
        if (r4.getOwnerType() == 22) goto L7;
        if (r4.getOwnerType() == 30) goto L7;
        r0 = false;
        goto L7
    }

    public final String P(List<? extends NotNotifyUserEntity> r4) {
        HashMap r0 = new HashMap();
        r0.put("operate", this.a.getString(2131888199));
        r0.put("reason", this.a.getString(2131888049));
        r0.put("users", ui5.a.a(r4));
        return xo5.a.d(this.a, 2131888100, r0);
    }

    @Override // tg5.p
    public final void W0(List<? extends NotNotifyUserEntity> r2) {
        Intrinsics.checkNotNullParameter(r2, "notNotifyUsers");
        Toast.showSuccessText(this.a, P(r2));
    }

    @Override // tg5.p
    public final void h8(List<? extends NotNotifyUserEntity> r4) {
        Intrinsics.checkNotNullParameter(r4, "notPartnerTenantUser");
        int r0 = this.c;
        if (r0 != 0) goto L5;
        int r1 = 2131887296;
    L9:
        Context r2 = this.a;
        Toast.showText(r2, xo5.a.c(r2, r1, "collaborators", ui5.a.a(r4)));
        return;
    L5:
        if (r0 == 28) goto L7;
        r1 = com.bytedance.ee.bear.middleground.permission.collaborator.invite.b.b(r0, 2131888881, 2131887293);
        goto L9
    L7:
        r1 = 2131889111;
        goto L9
    }

    public void o0(boolean r3) {
        UDEditText r0 = (SpaceEditText) this.b.findViewById(2131381012);
        if (r3 == false) goto L5;
        int r4 = 0;
    L6:
        r0.setVisibility(r4);
        return;
    L5:
        r4 = 8;
        goto L6
    }

    @Override // tg5.p
    public final void r1(List<? extends NotNotifyUserEntity> r4) {
        Intrinsics.checkNotNullParameter(r4, "notPartnerTenantUser");
        int r0 = this.c;
        if (r0 != 0) goto L5;
        int r1 = 2131887294;
    L9:
        Context r2 = this.a;
        Toast.showText(r2, xo5.a.c(r2, r1, "collaborators", ui5.a.a(r4)));
        return;
    L5:
        if (r0 == 28) goto L7;
        r1 = com.bytedance.ee.bear.middleground.permission.collaborator.invite.b.b(r0, 2131888882, 2131887291);
        goto L9
    L7:
        r1 = 2131889115;
        goto L9
    }

    public final void setViewDelegate(IView.IViewDelegate r1) {
        this.d = (p.a) r1;
    }

    public final void t0(boolean r3) {
        this.b.findViewById(2131381033).setChecked(r3);
        o0(r3);
    }

    public final void u0(String r3) {
        this.b.findViewById(2131363917).setText(r3);
        if (this.b.findViewById(2131363917).getVisibility() == 0) goto L6;
        this.b.findViewById(2131363917).setVisibility(0);
        return;
    }

    @Override // tg5.p
    public final void w5(String r3) {
        Intrinsics.checkNotNullParameter(r3, "notificationId");
        B0(this.a.getString(2131888199), r3);
    }

    public final void B0(String r4, String r5) {
        Ref.BooleanRef r0 = new Ref.BooleanRef();
        UDToast.a r1 = UDToast.build(this.a);
        r1.g(r4);
        r1.d(Toast.getSuccessIcon());
        r1.b(2131888041, new e(r0));
        r1.f(new f(r0, this, r5));
        r1.h();
    }

    @Override // tg5.p
    public final void J7(List<? extends NotNotifyUserEntity> r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "notNotifyUsers");
        Intrinsics.checkNotNullParameter(r3, "notificationId");
        B0(P(r2), r3);
    }

    @Override // tg5.p
    public final void K5(String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "title");
        Intrinsics.checkNotNullParameter(r5, "desp");
        BearUDDialogBuilder r0 = new BearUDDialogBuilder(this.a);
        r0.i(r4);
        r0.f(r5);
        r0.b(2131391777, 2131887759, 2131105548, null);
        r0.a.style(2131951622);
        r0.h();
    }

    @Override // tg5.p
    public final void b2(Throwable r4, String r5, String r6) {
        Intrinsics.checkNotNullParameter(r4, "throwable");
        Intrinsics.checkNotNullParameter(r5, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r6, "module");
        ((com.bytedance.ee.bear.review.a) org.koin.java.a.c(com.bytedance.ee.bear.review.a.class, null, null, 6)).c(this.a, r4, new c(this, r4, r5, r6));
    }

    public b(Context r4, View r5, int r6, String r7) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "rootView");
        Intrinsics.checkNotNullParameter(r7, "creatorTenantId");
        this.a = r4;
        this.b = r5;
        this.c = r6;
        boolean r8 = true;
        this.h = true;
        AccountService.Account r9 = ((h0) org.koin.java.a.c(h0.class, null, null, 6)).G2();
        if (r9 == null) goto L6;
        String r10 = r9.tenantId;
        if (r10 == null) goto L6;
    L7:
        boolean r11 = TextUtils.equals(r10, r7);
        this.i = r11;
        if (r9 == null) goto L10;
        boolean r12 = r9.isConsumer();
    L11:
        this.j = r12;
        StringBuilder r1 = new StringBuilder("isSameTenant=");
        r1.append(r11);
        r1.append(", userTenantId is empty=");
        if (r10.length() == 0) goto L15;
        r8 = false;
    L15:
        r1.append(r8);
        r1.append(", isConsumer=");
        r1.append(r12);
        tt5.a.h("BaseInviteMemberManagerView", r1.toString());
        return;
    L10:
        r12 = false;
    L6:
        r10 = "";
        goto L7
    }
}
