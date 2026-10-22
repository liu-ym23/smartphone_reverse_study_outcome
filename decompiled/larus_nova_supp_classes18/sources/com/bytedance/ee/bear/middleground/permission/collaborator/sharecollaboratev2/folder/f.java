package com.bytedance.ee.bear.middleground.permission.collaborator.sharecollaboratev2.folder;

import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.bytedance.ee.bear.middleground_permission_export.model.permissionset.FolderPermSetInfo;
import com.bytedance.ee.bear.middleground_permission_export.model.share.ShareUserInfoResult;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.bytedance.ee.bear.widgets.t;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f extends ih5.a<com.bytedance.ee.bear.middleground.permission.collaborator.sharecollaboratev2.folder.a> implements ej5.b {
    public final String h;
    public final String i;
    public final Fragment j;
    public TextView k;
    public TextView l;
    public boolean m;

    public static final class a extends t {
        public final /* synthetic */ f c;

        public a(f r1) {
            this.c = r1;
        }

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r3) {
            Toast.showFailureText(this.c.getContext(), this.c.getContext().getString(2131888342));
        }
    }

    public static final class b extends t {
        public final /* synthetic */ f c;

        public b(f r1) {
            this.c = r1;
        }

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r3) {
            Toast.showFailureText(this.c.getContext(), this.c.getContext().getString(2131888342));
        }
    }

    public static final class c extends t {
        public final /* synthetic */ boolean c;
        public final /* synthetic */ f d;

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r3) {
            if (this.c == false) goto L5;
            f.f(this.d).b();
            return;
        L5:
            f r4 = this.d;
            if (r4.m == false) goto L10;
            Toast.showFailureText(r4.getContext(), this.d.getContext().getString(2131887283));
            return;
        }

        public c(boolean r1, f r2) {
            this.c = r1;
            this.d = r2;
        }
    }

    public static final class d extends t {
        public final /* synthetic */ boolean c;
        public final /* synthetic */ f d;

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r5) {
            if (this.c == true) goto L5;
            f r6 = this.d;
            if (r6.m == false) goto L16;
            Toast.showFailureText(r6.getContext(), this.d.getContext().getString(2131888096));
            return;
        L16:
            return;
        L5:
            if ((f.f(this.d) instanceof ShareFolderMemberPresenter) == false) goto L14;
            com.bytedance.ee.bear.middleground.permission.collaborator.sharecollaboratev2.folder.a r7 = f.f(this.d);
            Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type com.bytedance.ee.bear.middleground.permission.collaborator.sharecollaboratev2.folder.ShareFolderMemberPresenter");
            FolderPermSetInfo r8 = ((ShareFolderMemberPresenter) r7).d();
            com.bytedance.ee.bear.middleground.permission.collaborator.sharecollaboratev2.folder.a r1 = f.f(this.d);
            Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type com.bytedance.ee.bear.middleground.permission.collaborator.sharecollaboratev2.folder.ShareFolderMemberPresenter");
            ShareUserInfoResult r0 = ((ShareFolderMemberPresenter) r1).k;
            if (r0 != null) goto L9;
            r0 = new ShareUserInfoResult();
        L9:
            int r2 = ih5.f.a;
            ih5.f.b(this.d.getContext(), this.d.getModule(), r8, r0, this.d.getSourceFragment());
            return;
        }

        public d(boolean r1, f r2) {
            this.c = r1;
            this.d = r2;
        }
    }

    public static final class e implements ih5.c.a {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ f b;

        @Override // ih5.c.a
        public final void a(UserInfo r5) {
            Intrinsics.checkNotNullParameter(r5, "userInfo");
            if (this.a == true) goto L5;
            return;
        L5:
            if ((f.f(this.b) instanceof ShareFolderMemberPresenter) == false) goto L12;
            com.bytedance.ee.bear.middleground.permission.collaborator.sharecollaboratev2.folder.a r6 = f.f(this.b);
            Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type com.bytedance.ee.bear.middleground.permission.collaborator.sharecollaboratev2.folder.ShareFolderMemberPresenter");
            FolderPermSetInfo r7 = ((ShareFolderMemberPresenter) r6).d();
            com.bytedance.ee.bear.middleground.permission.collaborator.sharecollaboratev2.folder.a r1 = f.f(this.b);
            Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type com.bytedance.ee.bear.middleground.permission.collaborator.sharecollaboratev2.folder.ShareFolderMemberPresenter");
            ShareUserInfoResult r0 = ((ShareFolderMemberPresenter) r1).k;
            if (r0 != null) goto L9;
            r0 = new ShareUserInfoResult();
        L9:
            int r2 = ih5.f.a;
            ih5.f.b(this.b.getContext(), this.b.getModule(), r7, r0, this.b.getSourceFragment());
            return;
        }

        public e(boolean r1, f r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public final TextView getInviteMemberTitleFromXml() {
        KeyEvent.Callback r0 = this.k;
        if (r0 != null) goto L6;
        r0 = findViewById(2131375593);
        this.k = (TextView) r0;
    L6:
        return (TextView) r0;
    }

    public final TextView getManageMemberTitleFromXml() {
        KeyEvent.Callback r0 = this.l;
        if (r0 != null) goto L6;
        r0 = findViewById(2131379513);
        this.l = (TextView) r0;
    L6:
        return (TextView) r0;
    }

    @Override // ej5.b
    public final void s() {
        if (this.m == false) goto L5;
        return;
    L5:
        getInputLayoutFromXml().setOnClickListener(new a(this));
        getMemberListLayoutFromXml().setOnClickListener(new b(this));
    }

    public final String getModule() {
        return this.i;
    }

    public final Fragment getSourceFragment() {
        return this.j;
    }

    public final String getToken() {
        return this.h;
    }

    public static final /* synthetic */ com.bytedance.ee.bear.middleground.permission.collaborator.sharecollaboratev2.folder.a f(f r0) {
        return r0.getPresenter();
    }

    @Override // ih5.a, ih5.e
    public void setCollaborateEnable(boolean r3) {
        tt5.a.h("BaseShareMemberView", "setCollaborateEnable()...enable = " + r3);
        ih5.c r0 = getAdapter();
        r0.b = Boolean.valueOf(r3);
        r0.a();
        if (r3 == false) goto L5;
        float r1 = 1.0f;
    L6:
        getInputLayoutFromXml().setAlpha(r1);
        getInviteMemberTitleFromXml().setAlpha(r1);
        getManageMemberTitleFromXml().setAlpha(r1);
        getMemberListLayoutFromXml().setAlpha(r1);
        getInputLayoutFromXml().setOnClickListener(new c(r3, this));
        getMemberListLayoutFromXml().setOnClickListener(new d(r3, this));
        getAdapter().a = new e(r3, this);
        return;
    L5:
        r1 = 0.3f;
        goto L6
    }

    @Override // ej5.b
    public void setFolderPermSetInfo(FolderPermSetInfo r4) {
        Intrinsics.checkNotNullParameter(r4, "folderPermSetInfo");
        tt5.a.h("BaseShareMemberView", "setPermissionInfo()...userPermission = " + r4.j.a.getPermissions());
        getPresenter().a(r4);
        this.m = true;
        if (r4.j.b.lockState() == true) goto L5;
    L9:
        getLockBannerFromXml().setVisibility(8);
        return;
    L5:
        if (r4.b() == false) goto L9;
        if (r4.j.a.canManagerCollaborator() == false) goto L9;
        getLockBannerFromXml().o6(getContext().getString(2131887281), r4.j.b.canUnLock(), new i(this));
    }

    public final void setInviteMemberTitleFromXml(TextView r1) {
        this.k = r1;
    }

    public final void setManageMemberTitleFromXml(TextView r1) {
        this.l = r1;
    }

    public f(FragmentActivity r12, int r13, String r14, String r15, String r16, FolderVersion r17, boolean r18, boolean r19, Fragment r20) {
        Intrinsics.checkNotNullParameter(r12, "context");
        Intrinsics.checkNotNullParameter(r14, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r15, "spaceId");
        Intrinsics.checkNotNullParameter(r16, "module");
        Intrinsics.checkNotNullParameter(r17, "version");
        super(r12, r13);
        this.h = r14;
        this.i = r16;
        this.j = r20;
        setPresenter(new ShareFolderMemberPresenter(r12, r13, r14, r15, r17, r18, r16, this));
    }
}
