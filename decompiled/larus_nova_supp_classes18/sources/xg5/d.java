package xg5;

import android.view.View;
import com.bytedance.ee.bear.middleground.permission.collaborator.invite.FolderInviteCollaboratorManageAdapter;
import com.bytedance.ee.bear.share.export.UserInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d implements View.OnClickListener {
    public final /* synthetic */ c a;
    public final /* synthetic */ FolderInviteCollaboratorManageAdapter b;
    public final /* synthetic */ int c;
    public final /* synthetic */ UserInfo d;

    public d(c r1, FolderInviteCollaboratorManageAdapter r2, int r3, UserInfo r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r6) {
        c r7 = this.a;
        FolderInviteCollaboratorManageAdapter r0 = this.b;
        int r1 = this.c;
        UserInfo r2 = this.d;
        r7.getClass();
        tt5.a.h("FolderInviteMemberManagerView", "onFaClick()...pos = " + r1);
        r2.setPermission(3);
        r0.notifyItemChanged(r1);
        vi5.a r8 = r7.n;
        if (r8 == null) goto L6;
        r8.b();
        return;
    }
}
