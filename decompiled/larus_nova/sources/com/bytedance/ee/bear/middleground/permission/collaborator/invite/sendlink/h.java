package com.bytedance.ee.bear.middleground.permission.collaborator.invite.sendlink;

import com.bytedance.ee.bear.middleground.permission.collaborator.invite.BaseInviteCollaboratorManageAdapter;
import com.bytedance.ee.bear.share.export.UserInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class h implements BaseInviteCollaboratorManageAdapter.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f233383a;

    public h(d r100) {
        this.f233383a = r100;
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.invite.BaseInviteCollaboratorManageAdapter.a
    public final void a(UserInfo r100, int r101) {
        d r102 = this.f233383a;
        InviteMemberSendLinkAdapter r103 = r102.f233379f;
        if (r103 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r103 = null;
    L5:
        r103.notifyItemRemoved(r101);
        a.InterfaceC3341a r104 = r102.f233377d;
        if (r104 == null) goto L8;
        Intrinsics.checkNotNull(r100);
        r104.Y(r101, r100);
    L8:
        r102.h();
    }
}
