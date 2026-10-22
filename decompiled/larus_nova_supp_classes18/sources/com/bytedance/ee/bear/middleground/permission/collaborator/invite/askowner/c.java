package com.bytedance.ee.bear.middleground.permission.collaborator.invite.askowner;

import com.bytedance.ee.bear.middleground_permission_export.model.permissionset.DocPermSetInfo;
import com.bytedance.ee.bear.share.export.UserInfo;
import io.reactivex.Flowable;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c implements com.bytedance.ee.bear.middleground.permission.collaborator.invite.askowner.a {
    public final dh5.b a;
    public final DocPermSetInfo b;

    public static final class a {
    }

    static {
    }

    public final void create() {
        tt5.a.h("InviteMemberAskOwnerModel", "create()...");
        Iterator<T> r0 = this.a.getSelected().iterator();
    L4:
        if (r0.hasNext() == false) goto L14;
        UserInfo r1 = (UserInfo) r0.next();
        int r3 = 1;
        if (idb.f.a().isEnable("apaas.miaoda.migrate_to_ccm") == true) goto L8;
    L10:
        boolean r2 = false;
    L11:
        if (r2 == false) goto L13;
        r3 = 4;
    L13:
        r1.setPermission(r3);
        goto L4
    L8:
        if (sbb.g.a(this.b.getType()) == false) goto L10;
        r2 = true;
        goto L11
    }

    public final void destroy() {
        tt5.a.h("InviteMemberAskOwnerModel", "destroy()...");
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.invite.askowner.a
    public final ArrayList<UserInfo> getUsers() {
        return this.a.getSelected();
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.invite.askowner.a
    public final void V(UserInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "userInfo");
        this.a.removeUser(r2);
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.invite.askowner.a
    public final Flowable<AskOwnerHelper.AskOwnerSendResult> z0(String r4) {
        Intrinsics.checkNotNullParameter(r4, "notes");
        tt5.a.h("InviteMemberAskOwnerModel", "askOwner()...");
        ArrayList<UserInfo> r0 = this.a.getSelected();
        int r1 = AskOwnerHelper.a;
        DocPermSetInfo r2 = this.b;
        return AskOwnerHelper.a(r2.c, r2.getType(), r0, r4);
    }

    public c(dh5.b r2, DocPermSetInfo r3) {
        Intrinsics.checkNotNullParameter(r2, "selectedUserModel");
        Intrinsics.checkNotNullParameter(r3, "permSetInfo");
        this.a = r2;
        this.b = r3;
    }
}
