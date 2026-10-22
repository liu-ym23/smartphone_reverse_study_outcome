package xg5;

import android.view.View;
import com.bytedance.ee.bear.middleground.permission.collaborator.invite.FolderInviteCollaboratorManageAdapter;
import com.bytedance.ee.bear.share.export.UserInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import tg5.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g implements View.OnClickListener {
    public final /* synthetic */ c a;
    public final /* synthetic */ FolderInviteCollaboratorManageAdapter b;
    public final /* synthetic */ int c;
    public final /* synthetic */ UserInfo d;

    public g(c r1, FolderInviteCollaboratorManageAdapter r2, int r3, UserInfo r4) {
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
        tt5.a.h("FolderInviteMemberManagerView", "onRemoveClick()...pos = " + r1);
        p.a r3 = r7.d;
        if (r3 == null) goto L5;
        r3.W(r2);
    L5:
        r0.notifyItemRemoved(r1);
        if (hu5.a.f(r7.L().getData()) == false) goto L8;
        List r4 = r7.L().getData();
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type java.util.ArrayList<com.bytedance.ee.bear.share.export.UserInfo>");
        r7.O0((ArrayList) r4);
    L8:
        vi5.a r8 = r7.n;
        if (r8 == null) goto L12;
        r8.b();
        return;
    }
}
