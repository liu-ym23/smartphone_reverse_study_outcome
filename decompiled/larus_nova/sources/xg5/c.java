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
import com.bytedance.ee.bear.widgets.universedesign.SpaceEditText;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class c extends tg5.b {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Context f563771k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final View f563772l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final FolderPermSetInfo f563773m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public vi5.a f563774n;

    public static final class a {
    }

    public static final class b implements BaseInviteCollaboratorManageAdapter.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f563775a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ FolderInviteCollaboratorManageAdapter f563776b;

        public b(c r100, FolderInviteCollaboratorManageAdapter r101) {
            this.f563775a = r100;
            this.f563776b = r101;
        }

        @Override // com.bytedance.ee.bear.middleground.permission.collaborator.invite.BaseInviteCollaboratorManageAdapter.a
        public final void a(UserInfo r210, int r211) {
            c r100 = this.f563775a;
            if (r100.f563774n != null) goto L5;
            r100.f563774n = new vi5.a(r100.f563771k);
        L5:
            vi5.a r101 = this.f563775a.f563774n;
            if (r101 == null) goto L21;
            Intrinsics.checkNotNull(r210);
            FolderPermSetInfo r102 = this.f563775a.f563773m;
            String r103 = r102.f234440c;
            int r104 = r102.getType();
            c r105 = this.f563775a;
            FolderInviteCollaboratorManageAdapter r110 = this.f563776b;
            boolean r111 = r105.f563773m.f234447j.f234425a.canInviteFullAccess();
            boolean r112 = r105.f563773m.f234447j.f234425a.canInviteEdit();
            boolean r113 = r105.f563773m.f234447j.f234425a.canInviteView();
            if (r210.getPermission() != 3) goto L10;
            boolean r114 = true;
        L12:
            if (r210.getPermission() != 2) goto L14;
            boolean r115 = true;
        L16:
            if (r210.getPermission() != 1) goto L18;
            boolean r106 = true;
        L19:
            tt5.a.h("FolderInviteMemberManagerView", "canInviteFa: " + r111 + ", canUserEdit: " + r112 + ", isMemberFa: " + r114 + ", isMemberEdit: " + r115 + ", isMemberRead: " + r106);
            vi5.d r107 = new vi5.d(r105.f563771k);
            r107.c(r105.f563773m.b(), r111, r114, false, new d(r105, r110, r211, r210));
            r107.b(r115, r112, new e(r105, r110, r211, r210), true);
            vi5.d.d(r107, r106, r113, new f(r105, r110, r211, r210));
            r107.a(new g(r105, r110, r211, r210));
            r101.c(r210, r103, r104, r107.f555344b);
            goto L21
        L18:
            r106 = false;
            goto L19
        L14:
            r115 = false;
            goto L16
        L10:
            r114 = false;
        L21:
            FolderPermSetInfo r108 = this.f563775a.f563773m;
            String[] r109 = PermissionAnalytic.f232823a;
            Intrinsics.checkNotNullParameter(r108, "permSetInfo");
            HashMap r116 = new HashMap();
            if (r210 != null) goto L24;
        L26:
            boolean r117 = false;
        L27:
            if (r117 == true) goto L29;
            String r118 = "user";
        L30:
            r116.put("invite_collaborate_type", r118);
            PermissionAnalytic.m(r108, "click_edit_collaborate_perm", r116);
            return;
        L29:
            r118 = "chat";
            goto L30
        L24:
            if (r210.getOwnerType() != 2) goto L26;
            r117 = true;
            goto L27
        }
    }

    static {
    }

    @Override // tg5.b
    public final BaseInviteCollaboratorManageAdapter p() {
        FolderInviteCollaboratorManageAdapter r100 = new FolderInviteCollaboratorManageAdapter(((i0) org.koin.java.a.c(i0.class, null, null, 6)).c(), ((h0) org.koin.java.a.c(h0.class, null, null, 6)).G2());
        r100.f233164c = new b(this, r100);
        return r100;
    }

    @Override // tg5.b, com.larksuite.framework.mvp.ILifecycle
    public final void create() {
        super.create();
        ((SpaceEditText) this.f563772l.findViewById(R.id.notesInput)).setHint(this.f563771k.getString(R.string.LarkCCM_Wiki_Move_ReqPermission_Context));
    }

    @Override // tg5.b
    public final void h0() {
        super.h0();
        O0(e());
    }

    public c(Context r100, View r101, FolderPermSetInfo r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r102, "permSetInfo");
        super(r100, r101, r102.getType(), r102.f234446i);
        this.f563771k = r100;
        this.f563772l = r101;
        this.f563773m = r102;
    }
}
