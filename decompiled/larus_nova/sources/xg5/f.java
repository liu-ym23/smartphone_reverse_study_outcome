package xg5;

import android.view.View;
import com.bytedance.ee.bear.middleground.permission.collaborator.invite.FolderInviteCollaboratorManageAdapter;
import com.bytedance.ee.bear.share.export.UserInfo;

/* JADX INFO: loaded from: classes18.dex */
public final class f implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f563785a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FolderInviteCollaboratorManageAdapter f563786b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f563787c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ UserInfo f563788d;

    public f(c r100, FolderInviteCollaboratorManageAdapter r101, int r102, UserInfo r103) {
        this.f563785a = r100;
        this.f563786b = r101;
        this.f563787c = r102;
        this.f563788d = r103;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        c r101 = this.f563785a;
        FolderInviteCollaboratorManageAdapter r102 = this.f563786b;
        int r103 = this.f563787c;
        UserInfo r104 = this.f563788d;
        r101.getClass();
        tt5.a.h("FolderInviteMemberManagerView", "onReadClick()...pos = " + r103);
        r104.setPermission(1);
        r102.notifyItemChanged(r103);
        vi5.a r105 = r101.f563774n;
        if (r105 == null) goto L6;
        r105.b();
        return;
    }
}
