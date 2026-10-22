package com.bytedance.ee.bear.middleground.permission.collaborator.invite.askowner;

import com.bytedance.ee.bear.middleground.permission.collaborator.invite.BaseInviteCollaboratorManageAdapter;
import com.bytedance.ee.bear.middleground.permission.permission.doc.DocUserPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.permissionset.DocPermSetInfo;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class n implements BaseInviteCollaboratorManageAdapter.a {
    public final /* synthetic */ InviteMemberAskOwnerView a;

    public n(InviteMemberAskOwnerView r1) {
        this.a = r1;
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.invite.BaseInviteCollaboratorManageAdapter.a
    public final void a(UserInfo r13, int r14) {
        InviteMemberAskOwnerView r0 = this.a;
        r0.i = r14;
        if (r0.h != null) goto L5;
        r0.h = new vi5.a(r0.getContext());
    L5:
        vi5.a r15 = r0.h;
        if (r15 == null) goto L26;
        Intrinsics.checkNotNull(r13);
        DocPermSetInfo r2 = r0.c;
        String r3 = r2.c;
        int r4 = r2.getType();
        Intrinsics.checkNotNullParameter(r13, "userInfo");
        boolean r6 = false;
        if (r0.c.getType() != 125) goto L13;
        tt5.a.h("InviteMemberAskOwnerView", "stage=role_options, obj_type=125, role_domain=bit, requested_role=1");
        vi5.d r5 = new vi5.d(r0.a);
        if (r13.getPermission() != 1) goto L12;
        r6 = true;
    L12:
        vi5.d.d(r5, r6, true, new f(r0, r13));
        r5.a(new g(r0, r13));
        ArrayList<vi5.c> r1 = r5.b;
    L25:
        r15.c(r13, r3, r4, r1);
        goto L26
    L13:
        DocUserPermission.a r7 = DocUserPermission.Companion;
        int r8 = r13.getPermission();
        r7.getClass();
        if ((r8 & 4) == 0) goto L16;
        boolean r9 = true;
    L17:
        vi5.d r10 = new vi5.d(r0.a);
        if (idb.f.a().isEnable("apaas.miaoda.migrate_to_ccm") == true) goto L20;
    L22:
        if (r6 == true) goto L24;
        vi5.d.d(r10, !r9, true, new h(r0, r13));
    L24:
        r10.b(r9, true, new i(r0, r13), true);
        r10.a(new j(r0, r13));
        r1 = r10.b;
        goto L25
    L20:
        if (sbb.g.a(r0.c.getType()) == false) goto L22;
        r6 = true;
        goto L22
    L16:
        r9 = false;
    L26:
        Intrinsics.checkNotNull(r13);
        String r16 = com.bytedance.ee.bear.middleground.permission.c.a;
        Intrinsics.checkNotNullParameter(r13, "userInfo");
        JSONObject r17 = new JSONObject();
        String r11 = com.bytedance.ee.bear.middleground.permission.c.f;
        int r12 = com.bytedance.ee.bear.middleground.permission.c.g;
        if (com.bytedance.ee.bear.middleground.permission.c.c == false) goto L29;
        String r18 = ThumbGlideUrl.SOURCE_VC;
    L30:
        com.bytedance.ee.bear.middleground.permission.c.a(r17, r11, r12, r18, com.bytedance.ee.bear.middleground.permission.c.h, com.bytedance.ee.bear.middleground.permission.c.d, com.bytedance.ee.bear.middleground.permission.c.e, com.bytedance.ee.bear.middleground.permission.c.a, com.bytedance.ee.bear.middleground.permission.c.b, com.bytedance.ee.bear.middleground.permission.c.i);
        r17.put("collaborate_type", r13.getOwnerType());
        r17.put("object_uid", du5.b.g(r13.getId()));
        r17.put("list_type", com.bytedance.ee.bear.middleground.permission.c.d(com.bytedance.ee.bear.middleground.permission.c.g, r13.getPermission()));
        com.bytedance.ee.bear.middleground.permission.c.c("ccm_permission_share_ask_owner_type_view", r17);
        return;
    L29:
        r18 = "none";
        goto L30
    }
}
