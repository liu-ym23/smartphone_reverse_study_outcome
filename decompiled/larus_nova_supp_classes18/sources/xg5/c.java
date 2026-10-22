package xg5;

import android.content.Context;
import android.view.View;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.contract.i0;
import com.bytedance.ee.bear.middleground.permission.PermissionAnalytic;
import com.bytedance.ee.bear.middleground.permission.collaborator.invite.BaseInviteCollaboratorManageAdapter;
import com.bytedance.ee.bear.middleground.permission.collaborator.invite.FolderInviteCollaboratorManageAdapter;
import com.bytedance.ee.bear.middleground_permission_export.model.permissionset.FolderPermSetInfo;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEditText;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c extends tg5.b {
    public final Context k;
    public final View l;
    public final FolderPermSetInfo m;
    public vi5.a n;

    public static final class a {
    }

    public static final class b implements BaseInviteCollaboratorManageAdapter.a {
        public final /* synthetic */ c a;
        public final /* synthetic */ FolderInviteCollaboratorManageAdapter b;

        public b(c r1, FolderInviteCollaboratorManageAdapter r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // com.bytedance.ee.bear.middleground.permission.collaborator.invite.BaseInviteCollaboratorManageAdapter.a
        public final void a(UserInfo r20, int r21) {
            c r3 = this.a;
            if (r3.n != null) goto L5;
            r3.n = new vi5.a(r3.k);
        L5:
            vi5.a r4 = this.a.n;
            if (r4 == null) goto L21;
            Intrinsics.checkNotNull(r20);
            FolderPermSetInfo r7 = this.a.m;
            String r8 = r7.c;
            int r9 = r7.getType();
            c r10 = this.a;
            FolderInviteCollaboratorManageAdapter r11 = this.b;
            boolean r14 = r10.m.j.a.canInviteFullAccess();
            boolean r12 = r10.m.j.a.canInviteEdit();
            boolean r15 = r10.m.j.a.canInviteView();
            if (r20.getPermission() != 3) goto L10;
            boolean r13 = true;
        L12:
            if (r20.getPermission() != 2) goto L14;
            boolean r16 = true;
        L16:
            if (r20.getPermission() != 1) goto L18;
            boolean r5 = true;
        L19:
            tt5.a.h("FolderInviteMemberManagerView", "canInviteFa: " + r14 + ", canUserEdit: " + r12 + ", isMemberFa: " + r13 + ", isMemberEdit: " + r16 + ", isMemberRead: " + r5);
            vi5.d r6 = new vi5.d(r10.k);
            r6.c(r10.m.b(), r14, r13, false, new d(r10, r11, r21, r20));
            r6.b(r16, r12, new e(r10, r11, r21, r20), true);
            vi5.d.d(r6, r5, r15, new f(r10, r11, r21, r20));
            r6.a(new g(r10, r11, r21, r20));
            r4.c(r20, r8, r9, r6.b);
            goto L21
        L18:
            r5 = false;
            goto L19
        L14:
            r16 = false;
            goto L16
        L10:
            r13 = false;
        L21:
            FolderPermSetInfo r2 = this.a.m;
            String[] r17 = PermissionAnalytic.a;
            Intrinsics.checkNotNullParameter(r2, "permSetInfo");
            HashMap r18 = new HashMap();
            if (r20 != null) goto L24;
        L26:
            boolean r19 = false;
        L27:
            if (r19 == true) goto L29;
            String r1 = "user";
        L30:
            r18.put("invite_collaborate_type", r1);
            PermissionAnalytic.m(r2, "click_edit_collaborate_perm", r18);
            return;
        L29:
            r1 = ThumbGlideUrl.SOURCE_CHAT;
            goto L30
        L24:
            if (r20.getOwnerType() != 2) goto L26;
            r19 = true;
            goto L27
        }
    }

    static {
    }

    @Override // tg5.b
    public final BaseInviteCollaboratorManageAdapter p() {
        FolderInviteCollaboratorManageAdapter r2 = new FolderInviteCollaboratorManageAdapter(((i0) org.koin.java.a.c(i0.class, null, null, 6)).c(), ((h0) org.koin.java.a.c(h0.class, null, null, 6)).G2());
        r2.c = new b(this, r2);
        return r2;
    }

    @Override // tg5.b
    public final void create() {
        super.create();
        ((SpaceEditText) this.l.findViewById(2131381012)).setHint(this.k.getString(2131889818));
    }

    @Override // tg5.b
    public final void h0() {
        super.h0();
        O0(e());
    }

    public c(Context r3, View r4, FolderPermSetInfo r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "view");
        Intrinsics.checkNotNullParameter(r5, "permSetInfo");
        super(r3, r4, r5.getType(), r5.i);
        this.k = r3;
        this.l = r4;
        this.m = r5;
    }
}
