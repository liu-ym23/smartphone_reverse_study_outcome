package com.bytedance.ee.bear.middleground.permission.collaborator.invite.sendlink;

import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.middleground.permission.collaborator.invite.BaseInviteCollaboratorManageAdapter;
import com.bytedance.ee.bear.share.export.UserInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class h implements BaseInviteCollaboratorManageAdapter.a {
    public final /* synthetic */ d a;

    public h(d r1) {
        this.a = r1;
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.invite.BaseInviteCollaboratorManageAdapter.a
    public final void a(UserInfo r3, int r4) {
        d r0 = this.a;
        RecyclerView.Adapter r1 = r0.f;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r1 = null;
    L5:
        r1.notifyItemRemoved(r4);
        a.InterfaceC0094a r2 = r0.d;
        if (r2 == null) goto L8;
        Intrinsics.checkNotNull(r3);
        r2.Y(r4, r3);
    L8:
        r0.h();
    }
}
