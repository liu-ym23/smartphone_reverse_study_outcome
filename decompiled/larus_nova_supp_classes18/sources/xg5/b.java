package xg5;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.middleground.permission.PermissionAnalytic;
import com.bytedance.ee.bear.middleground.permission.collaborator.NotNotifyUserEntity;
import com.bytedance.ee.bear.middleground.permission.collaborator.invite.InviteResult;
import com.bytedance.ee.bear.middleground_permission_export.model.permissionset.FolderPermSetInfo;
import com.bytedance.ee.bear.share.export.UserInfo;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b implements ax4.e<InviteResult> {
    public final /* synthetic */ com.bytedance.ee.bear.middleground.permission.collaborator.invite.newinvite.folder.a a;

    public b(com.bytedance.ee.bear.middleground.permission.collaborator.invite.newinvite.folder.a r1) {
        this.a = r1;
    }

    public final void onFailed(Throwable r9) {
        Intrinsics.checkNotNullParameter(r9, "throwable");
        com.bytedance.ee.bear.middleground.permission.collaborator.invite.newinvite.folder.a r1 = this.a;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r9, "throwable");
        r1.c.hideLoading();
        int r2 = ui5.a.a;
        Intrinsics.checkNotNullParameter(r9, "throwable");
        if ((r9 instanceof NetService.ServerErrorException) == true) goto L27;
        ArrayList<NotNotifyUserEntity> r3 = new ArrayList();
    L9:
        int r4 = ui5.a.a;
        Intrinsics.checkNotNullParameter(r9, "throwable");
    L14:
        e = move-exception;
        tt5.a.d("NotNotifyOperator", "isFolderInviteCac()...error = " + e);
    L16:
        boolean r0 = false;
    L17:
        if (r0 == false) goto L20;
        r1.c.K5(r1.a.getString(2131889849), r1.a.getString(2131889842));
    L25:
        ArrayList<UserInfo> r5 = r1.b.e();
        FolderPermSetInfo r6 = r1.e;
        PermissionAnalytic.o(r5, r6.c, r6.getType(), r1.c.b8(), r9);
        return;
    L20:
        if ((!r3.isEmpty()) == true) goto L22;
    L24:
        r1.c.b2(r9, r1.e.c, r1.f);
        goto L25
    L22:
        if (ax4.d.b(r9, 4) == false) goto L24;
        r1.c.r1(r3);
        goto L25
    L11:
        if ((r9 instanceof NetService.ServerErrorException) == false) goto L16;
        tt5.a.h("NotNotifyOperator", "isFolderInviteCac()...code = " + ((NetService.ServerErrorException) r9).getCode());     // Catch: Exception -> L14
        JSONObject r7 = new JSONObject(((NetService.ServerErrorException) r9).getData());     // Catch: Exception -> L14
        r0 = !com.bytedance.ee.bear.middleground.permission.collaborator.invite.a.b(2002, r7.optJSONObject("fail_map"), r7.optJSONObject("user_map")).isEmpty();
        goto L17
    L27:
        tt5.a.h("NotNotifyOperator", "isNotPartnerTenantUsers()...code = " + ((NetService.ServerErrorException) r9).getCode());     // Catch: Exception -> L6
        JSONObject r8 = new JSONObject(((NetService.ServerErrorException) r9).getData());     // Catch: Exception -> L6
        r3 = com.bytedance.ee.bear.middleground.permission.collaborator.invite.a.b(10043, r8.optJSONObject("fail_map"), r8.optJSONObject("user_map"));     // Catch: Exception -> L6
    L6:
        e = move-exception;
        tt5.a.d("NotNotifyOperator", "isNotPartnerTenantUsers()...error = " + e);
        r3 = new ArrayList();
        goto L9
    }

    public final void onSuccess(Object r9) {
        InviteResult r10 = (InviteResult) r9;
        Intrinsics.checkNotNullParameter(r10, "result");
        com.bytedance.ee.bear.middleground.permission.collaborator.invite.newinvite.folder.a r1 = this.a;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r10, "result");
        r1.c.hideLoading();
        ArrayList<UserInfo> r2 = r1.b.e();
        FolderPermSetInfo r0 = r1.e;
        PermissionAnalytic.n(r2, r0.c, r0.getType(), r1.c.b8(), String.valueOf(r10.getCode()), r10.getMsg());
        if (r10.getData() == null) goto L5;
        ((rc5.a) org.koin.java.a.c(rc5.a.class, null, null, 6)).v(r1.e.c);
    L5:
        boolean r4 = true;
        if (r10.getData() == null) goto L11;
        if (r10.getData().limitCodeByConditionControl != 2002) goto L11;
        r1.c.K5(r1.a.getString(2131889849), r1.a.getString(2131889841));
    L22:
        if (r1.e.b() == false) goto L25;
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa().j(0);
    L32:
        if (r1.g == false) goto L34;
        ((com.bytedance.ee.bear.share.export.a) org.koin.java.a.c(com.bytedance.ee.bear.share.export.a.class, null, null, 6)).X9();
    L34:
        com.bytedance.ee.bear.middleground.permission.collaborator.invite.newinvite.folder.a.b r11 = r1.d;
        if (r11 == null) goto L38;
        r11.finish();
        return;
    L38:
        return;
    L25:
        if (r1.e.k.length() == 0) goto L28;
        r4 = false;
    L28:
        if (r4 == false) goto L30;
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa().j(0);
        goto L32
    L30:
        tt5.a.b("InviteMemberManagerPresenter", "updatememberChange is null!");
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa().j(0);
    L11:
        if (r10.getData() == null) goto L16;
        if ((!r10.getNotNotifyUsers().isEmpty()) == false) goto L16;
        r1.c.W0(r10.getNotNotifyUsers());
    L16:
        if (r10.getData() != null) goto L18;
    L20:
        r1.c.o6();
        goto L22
    L18:
        if ((!r10.getNotPartnerTenantUser().isEmpty()) == false) goto L20;
        r1.c.h8(r10.getNotPartnerTenantUser());
        goto L22
    }
}
