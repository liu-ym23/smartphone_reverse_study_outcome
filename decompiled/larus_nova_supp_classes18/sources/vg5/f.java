package vg5;

import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.i0;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.permission.PermissionAnalytic;
import com.bytedance.ee.bear.middleground.permission.collaborator.NotNotifyUserEntity;
import com.bytedance.ee.bear.middleground.permission.collaborator.invite.InviteResult;
import com.bytedance.ee.bear.middleground.permission.collaborator.invite.askowner.panel.AskOwnerPanel;
import com.bytedance.ee.bear.middleground.permission.permission.doc.DocPermissionAction;
import com.bytedance.ee.bear.middleground_permission_export.model.permissionset.DocPermSetInfo;
import com.bytedance.ee.bear.share.export.UserInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f implements ax4.e<InviteResult> {
    public final /* synthetic */ com.bytedance.ee.bear.middleground.permission.collaborator.invite.newinvite.doc.a a;

    public f(com.bytedance.ee.bear.middleground.permission.collaborator.invite.newinvite.doc.a r1) {
        this.a = r1;
    }

    public final void onFailed(Throwable r14) {
        Intrinsics.checkNotNullParameter(r14, "throwable");
        com.bytedance.ee.bear.middleground.permission.collaborator.invite.newinvite.doc.a r1 = this.a;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r14, "throwable");
        r1.c.hideLoading();
        ArrayList r8 = new ArrayList();
        Iterator<T> r2 = r1.b.e().iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        UserInfo r3 = (UserInfo) r2.next();
        if (r3.isExternal() == false) goto L4;
        r8.add(r3);
        goto L4
    L8:
        int r4 = ui5.a.a;
        Intrinsics.checkNotNullParameter(r14, "throwable");
        boolean r5 = r14 instanceof NetService.ServerErrorException;
        if (r5 == true) goto L106;
        ArrayList<NotNotifyUserEntity> r6 = new ArrayList();
    L15:
        int r7 = ui5.a.a;
        Intrinsics.checkNotNullParameter(r14, "throwable");
        if (r5 == true) goto L101;
        ArrayList<NotNotifyUserEntity> r10 = new ArrayList();
    L25:
        int r11 = ui5.a.a;
        Intrinsics.checkNotNullParameter(r14, "throwable");
        if (r5 == true) goto L104;
        ArrayList<NotNotifyUserEntity> r9 = new ArrayList();
    L35:
        int r12 = ui5.a.a;
        Intrinsics.checkNotNullParameter(r14, "throwable");
        if (r5 == true) goto L108;
    L41:
        int r13 = 0;
    L43:
        if (r13 != 0) goto L45;
        boolean r15 = true;
    L47:
        if ((!r10.isEmpty()) == false) goto L52;
        if (r15 == false) goto L50;
        r1.c.K5(r1.a.getString(2131889849), r1.a.getString(2131889842));
    L98:
        ArrayList<UserInfo> r0 = r1.b.e();
        DocPermSetInfo r16 = r1.e;
        PermissionAnalytic.o(r0, r16.c, r16.getType(), r1.c.b8(), r14);
        return;
    L50:
        r1.c.K5(r1.a.getString(2131889849), r1.a.getString(2131889841));
        goto L98
    L52:
        if ((!r9.isEmpty()) == false) goto L58;
        String r17 = r1.a.getString(2131889849);
        if (r15 == false) goto L56;
        String r18 = r1.a.getString(2131888960);
    L57:
        Intrinsics.checkNotNull(r18);
        r1.c.K5(r17, r18);
        goto L98
    L56:
        r18 = r1.a.getString(2131888962);
        goto L57
    L58:
        int r19 = ui5.a.a;
        Intrinsics.checkNotNullParameter(r14, "throwable");
        if (ax4.d.b(r14, 10005) == false) goto L93;
        boolean r20 = r1.e.d;
        tt5.a.h("InviteMemberManagerPresenter", "adminCanCross=" + r1.e.f.b.adminCanCross() + ", isOwner=" + r1.e.b() + ",externalAccess=" + r1.e.f.b.externalAccess() + ",inviteExternal = " + r1.e.f.b.inviteExternal() + ", isWiki2 = " + r20);
        if (r1.e.f.b.adminCanCross() == true) goto L63;
    L70:
        boolean r21 = false;
    L71:
        if (r21 == false) goto L93;
        if ((!r8.isEmpty()) == false) goto L93;
        com.bytedance.ee.bear.middleground.permission.collaborator.invite.newinvite.doc.a.I8();
        com.bytedance.ee.bear.middleground.permission.collaborator.invite.newinvite.doc.a.b r22 = r1.d;
        if (r22 == null) goto L77;
        r22.finish();
    L77:
        r1.H8(false);
        tt5.a.h("InviteMemberManagerPresenter", "showAskOwner()...");
        UserInfo r23 = r1.g;
        if (r23 == null) goto L83;
        String r24 = r23.getId();
        if (r24 == null) goto L83;
        String r25 = r24;
    L84:
        Locale r26 = ((i0) org.koin.java.a.c(i0.class, null, null, 6)).c();
        UserInfo r27 = r1.g;
        if (r27 == null) goto L90;
        String r28 = r27.getDisplayName(r26);
        if (r28 == null) goto L90;
        String r29 = r28;
    L91:
        int r30 = AskOwnerPanel.r;
        FragmentActivity r31 = r1.a;
        DocPermSetInfo r32 = r1.e;
        AskOwnerPanel.a.a(r31, r32.c, r32.getType(), r25, r29, r8, 1, r1.f, r1.e.e.getSubType(), r1.e.d);
    L90:
        r29 = "";
    L83:
        r25 = "";
        goto L84
    L63:
        if (r1.e.b() == true) goto L70;
        if (r1.e.f.b.externalAccess() == true) goto L67;
    L68:
        if (r20 == true) goto L70;
        r21 = true;
        goto L71
    L67:
        if (r1.e.f.b.inviteExternal() == true) goto L70;
    L93:
        if ((!r6.isEmpty()) == true) goto L95;
    L97:
        r1.c.b2(r14, r1.e.c, r1.f);
        goto L98
    L95:
        if (ax4.d.b(r14, 4) == false) goto L97;
        r1.c.r1(r6);
        goto L98
    L45:
        r15 = false;
        goto L47
    L108:
        tt5.a.h("NotNotifyOperator", "getDocCacSucessCount()...code = " + ((NetService.ServerErrorException) r14).getCode());     // Catch: Exception -> L39
        r13 = new JSONObject(((NetService.ServerErrorException) r14).getData()).optInt("success_count");     // Catch: Exception -> L39
    L39:
        e = move-exception;
        tt5.a.d("NotNotifyOperator", "getDocCacSucessCount()...error = " + e);
        goto L41
    L104:
        tt5.a.h("NotNotifyOperator", "getDocInviteCacUsers()...code = " + ((NetService.ServerErrorException) r14).getCode());     // Catch: Exception -> L32
        JSONObject r33 = new JSONObject(((NetService.ServerErrorException) r14).getData());     // Catch: Exception -> L32
        JSONObject r34 = r33.optJSONObject("user_map");     // Catch: Exception -> L32
        if (r34 != null) goto L30;
        r9 = com.bytedance.ee.bear.middleground.permission.collaborator.invite.a.c(DocPermissionAction.ERROR_DLP_INNER_SHARE_DETECTED_CODE, r33.optJSONObject("failCode_collaborator_map"));     // Catch: Exception -> L32
    L103:
        goto L35
    L30:
        r9 = com.bytedance.ee.bear.middleground.permission.collaborator.invite.a.d(DocPermissionAction.ERROR_DLP_INNER_SHARE_DETECTED_CODE, r33.optJSONObject("failCode_collaborator_map"), r34);     // Catch: Exception -> L32
    L32:
        e = move-exception;
        tt5.a.d("NotNotifyOperator", "isNotPartnerTenantUsers()...error = " + e);
        r9 = new ArrayList();
        goto L35
    L101:
        tt5.a.h("NotNotifyOperator", "getDocInviteCacUsers()...code = " + ((NetService.ServerErrorException) r14).getCode());     // Catch: Exception -> L22
        JSONObject r110 = new JSONObject(((NetService.ServerErrorException) r14).getData());     // Catch: Exception -> L22
        JSONObject r111 = r110.optJSONObject("user_map");     // Catch: Exception -> L22
        if (r111 != null) goto L20;
        r10 = com.bytedance.ee.bear.middleground.permission.collaborator.invite.a.c(2002, r110.optJSONObject("failCode_collaborator_map"));     // Catch: Exception -> L22
    L100:
        goto L25
    L20:
        r10 = com.bytedance.ee.bear.middleground.permission.collaborator.invite.a.d(2002, r110.optJSONObject("failCode_collaborator_map"), r111);     // Catch: Exception -> L22
    L22:
        e = move-exception;
        tt5.a.d("NotNotifyOperator", "isNotPartnerTenantUsers()...error = " + e);
        r10 = new ArrayList();
        goto L25
    L106:
        tt5.a.h("NotNotifyOperator", "isNotPartnerTenantUsers()...code = " + ((NetService.ServerErrorException) r14).getCode());     // Catch: Exception -> L12
        JSONObject r35 = new JSONObject(((NetService.ServerErrorException) r14).getData());     // Catch: Exception -> L12
        r6 = com.bytedance.ee.bear.middleground.permission.collaborator.invite.a.d(10043, r35.optJSONObject("block_user_map"), r35.optJSONObject("user_map"));     // Catch: Exception -> L12
    L12:
        e = move-exception;
        tt5.a.d("NotNotifyOperator", "isNotPartnerTenantUsers()...error = " + e);
        r6 = new ArrayList();
        goto L15
    }

    public final void onSuccess(Object r9) {
        InviteResult r10 = (InviteResult) r9;
        Intrinsics.checkNotNullParameter(r10, "result");
        com.bytedance.ee.bear.middleground.permission.collaborator.invite.newinvite.doc.a r1 = this.a;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r10, "result");
        r1.c.hideLoading();
        ArrayList<UserInfo> r2 = r1.b.e();
        DocPermSetInfo r0 = r1.e;
        PermissionAnalytic.n(r2, r0.c, r0.getType(), r1.c.b8(), String.valueOf(r10.getCode()), r10.getMsg());
        boolean r3 = false;
        if (r10.getData() == null) goto L14;
        if ((!r10.getConditionDenyUser().isEmpty()) == false) goto L14;
        if (r10.getData().getSuccessCount() != 0) goto L9;
        boolean r4 = true;
    L10:
        if (r4 == false) goto L12;
        r1.c.K5(r1.a.getString(2131889849), r1.a.getString(2131889842));
    L26:
        boolean r5 = false;
    L29:
        if (r10.getData() == null) goto L34;
        if (r10.getData().notNotifyOrg == false) goto L34;
        r1.c.N1();
        r3 = true;
    L34:
        if (r10.getData() == null) goto L42;
        if ((!r10.getNotNotifyUsers().isEmpty()) == false) goto L42;
        if (TextUtils.isEmpty(r10.getNotificationId()) == false) goto L40;
        r1.c.W0(r10.getNotNotifyUsers());
    L59:
        com.bytedance.ee.bear.middleground.permission.collaborator.invite.newinvite.doc.a.I8();
        r1.H8(r3);
        com.bytedance.ee.bear.middleground.permission.collaborator.invite.newinvite.doc.a.b r11 = r1.d;
        if (r11 == null) goto L63;
        r11.finish();
        return;
    L63:
        return;
    L40:
        r1.c.J7(r10.getNotNotifyUsers(), r10.getNotificationId());
    L42:
        if (r10.getData() == null) goto L47;
        if ((true ^ r10.getNotPartnerTenantUser().isEmpty()) == false) goto L47;
        r1.c.h8(r10.getNotPartnerTenantUser());
    L47:
        if (r10.getData() != null) goto L49;
    L51:
        if (r5 == false) goto L59;
        if (r1.c.b8() == true) goto L55;
    L58:
        r1.c.o6();
        goto L59
    L55:
        if (TextUtils.isEmpty(r10.getNotificationId()) == true) goto L58;
        r1.c.w5(r10.getNotificationId());
        goto L59
    L49:
        if (r10.getData().emailExceedLimit == false) goto L51;
        FragmentActivity r12 = r1.a;
        Toast.showFailureText(r12, r12.getString(2131889100));
        goto L59
    L12:
        r1.c.K5(r1.a.getString(2131889849), r1.a.getString(2131889841));
        goto L26
    L9:
        r4 = false;
    L14:
        if (r10.getData() != null) goto L16;
    L27:
        r5 = true;
        goto L29
    L16:
        if ((!r10.getDlpControlUser().isEmpty()) == false) goto L27;
        if (r10.getData().getSuccessCount() != 0) goto L20;
        boolean r6 = true;
    L21:
        String r7 = r1.a.getString(2131889849);
        if (r6 == false) goto L24;
        String r8 = r1.a.getString(2131888960);
    L25:
        Intrinsics.checkNotNull(r8);
        r1.c.K5(r7, r8);
        goto L26
    L24:
        r8 = r1.a.getString(2131888962);
        goto L25
    L20:
        r6 = false;
        goto L21
    }
}
