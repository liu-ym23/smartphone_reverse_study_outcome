package xg5;

import android.view.View;
import com.bytedance.ee.bear.middleground.permission.collaborator.invite.FolderInviteCollaboratorManageAdapter;
import com.bytedance.ee.bear.share.export.UserInfo;

/* JADX INFO: loaded from: classes18.dex */
public final class e implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f563781a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FolderInviteCollaboratorManageAdapter f563782b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f563783c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ UserInfo f563784d;

    public e(c r100, FolderInviteCollaboratorManageAdapter r101, int r102, UserInfo r103) {
        this.f563781a = r100;
        this.f563782b = r101;
        this.f563783c = r102;
        this.f563784d = r103;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        c r101 = this.f563781a;
        FolderInviteCollaboratorManageAdapter r102 = this.f563782b;
        int r103 = this.f563783c;
        UserInfo r104 = this.f563784d;
        r101.getClass();
        tt5.a.h("FolderInviteMemberManagerView", "onEditClick()...pos = " + r103);
        r104.setPermission(2);
        r102.notifyItemChanged(r103);
        vi5.a r105 = r101.f563774n;
        if (r105 == null) goto L6;
        r105.b();
        return;
    }
}
