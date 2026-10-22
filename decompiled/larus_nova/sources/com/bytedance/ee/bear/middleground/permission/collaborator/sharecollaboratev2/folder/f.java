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
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class f extends ih5.a<com.bytedance.ee.bear.middleground.permission.collaborator.sharecollaboratev2.folder.a> implements ej5.b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f233764h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f233765i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Fragment f233766j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public TextView f233767k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public TextView f233768l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f233769m;

    public static final class a extends t {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ f f233770c;

        public a(f r100) {
            this.f233770c = r100;
        }

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r100) {
            Toast.showFailureText(this.f233770c.getContext(), this.f233770c.getContext().getString(R.string.Doc_Wiki_SeverError));
        }
    }

    public static final class b extends t {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ f f233771c;

        public b(f r100) {
            this.f233771c = r100;
        }

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r100) {
            Toast.showFailureText(this.f233771c.getContext(), this.f233771c.getContext().getString(R.string.Doc_Wiki_SeverError));
        }
    }

    public static final class c extends t {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f233772c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ f f233773d;

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r100) {
            if (this.f233772c == false) goto L5;
            f.f(this.f233773d).b();
            return;
        L5:
            f r101 = this.f233773d;
            if (r101.f233769m == false) goto L10;
            Toast.showFailureText(r101.getContext(), this.f233773d.getContext().getString(R.string.CreationMobile_ECM_Permissions_NoExternalSharing_Toast));
            return;
        }

        public c(boolean r100, f r101) {
            this.f233772c = r100;
            this.f233773d = r101;
        }
    }

    public static final class d extends t {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f233774c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ f f233775d;

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r100) {
            if (this.f233774c == true) goto L5;
            f r101 = this.f233775d;
            if (r101.f233769m == false) goto L16;
            Toast.showFailureText(r101.getContext(), this.f233775d.getContext().getString(R.string.Doc_Permission_NoPermissionAccessCollaborators));
            return;
        L16:
            return;
        L5:
            if ((f.f(this.f233775d) instanceof ShareFolderMemberPresenter) == false) goto L14;
            com.bytedance.ee.bear.middleground.permission.collaborator.sharecollaboratev2.folder.a r102 = f.f(this.f233775d);
            Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type com.bytedance.ee.bear.middleground.permission.collaborator.sharecollaboratev2.folder.ShareFolderMemberPresenter");
            FolderPermSetInfo r103 = ((ShareFolderMemberPresenter) r102).d();
            com.bytedance.ee.bear.middleground.permission.collaborator.sharecollaboratev2.folder.a r104 = f.f(this.f233775d);
            Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type com.bytedance.ee.bear.middleground.permission.collaborator.sharecollaboratev2.folder.ShareFolderMemberPresenter");
            ShareUserInfoResult r105 = ((ShareFolderMemberPresenter) r104).f233746k;
            if (r105 != null) goto L9;
            r105 = new ShareUserInfoResult();
        L9:
            int r106 = ih5.f.f489867a;
            ih5.f.b(this.f233775d.getContext(), this.f233775d.getModule(), r103, r105, this.f233775d.getSourceFragment());
            return;
        }

        public d(boolean r100, f r101) {
            this.f233774c = r100;
            this.f233775d = r101;
        }
    }

    public static final class e implements ih5.c.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f233776a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ f f233777b;

        @Override // ih5.c.a
        public final void a(UserInfo r100) {
            Intrinsics.checkNotNullParameter(r100, "userInfo");
            if (this.f233776a == true) goto L5;
            return;
        L5:
            if ((f.f(this.f233777b) instanceof ShareFolderMemberPresenter) == false) goto L12;
            com.bytedance.ee.bear.middleground.permission.collaborator.sharecollaboratev2.folder.a r101 = f.f(this.f233777b);
            Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type com.bytedance.ee.bear.middleground.permission.collaborator.sharecollaboratev2.folder.ShareFolderMemberPresenter");
            FolderPermSetInfo r102 = ((ShareFolderMemberPresenter) r101).d();
            com.bytedance.ee.bear.middleground.permission.collaborator.sharecollaboratev2.folder.a r103 = f.f(this.f233777b);
            Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type com.bytedance.ee.bear.middleground.permission.collaborator.sharecollaboratev2.folder.ShareFolderMemberPresenter");
            ShareUserInfoResult r104 = ((ShareFolderMemberPresenter) r103).f233746k;
            if (r104 != null) goto L9;
            r104 = new ShareUserInfoResult();
        L9:
            int r105 = ih5.f.f489867a;
            ih5.f.b(this.f233777b.getContext(), this.f233777b.getModule(), r102, r104, this.f233777b.getSourceFragment());
            return;
        }

        public e(boolean r100, f r101) {
            this.f233776a = r100;
            this.f233777b = r101;
        }
    }

    public final TextView getInviteMemberTitleFromXml() {
        KeyEvent.Callback r100 = this.f233767k;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.inviteMemberTitle);
        this.f233767k = (TextView) r100;
    L6:
        return (TextView) r100;
    }

    public final TextView getManageMemberTitleFromXml() {
        KeyEvent.Callback r100 = this.f233768l;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.manageMemberTitle);
        this.f233768l = (TextView) r100;
    L6:
        return (TextView) r100;
    }

    @Override // ej5.b
    public final void s() {
        if (this.f233769m == false) goto L5;
        return;
    L5:
        getInputLayoutFromXml().setOnClickListener(new a(this));
        getMemberListLayoutFromXml().setOnClickListener(new b(this));
    }

    public final String getModule() {
        return this.f233765i;
    }

    public final Fragment getSourceFragment() {
        return this.f233766j;
    }

    public final String getToken() {
        return this.f233764h;
    }

    public static final /* synthetic */ com.bytedance.ee.bear.middleground.permission.collaborator.sharecollaboratev2.folder.a f(f r100) {
        return r100.getPresenter();
    }

    @Override // ih5.a, ih5.e
    public void setCollaborateEnable(boolean r100) {
        tt5.a.h("BaseShareMemberView", "setCollaborateEnable()...enable = " + r100);
        ih5.c r101 = getAdapter();
        r101.f489863b = Boolean.valueOf(r100);
        r101.a();
        if (r100 == false) goto L5;
        float r102 = 1.0f;
    L6:
        getInputLayoutFromXml().setAlpha(r102);
        getInviteMemberTitleFromXml().setAlpha(r102);
        getManageMemberTitleFromXml().setAlpha(r102);
        getMemberListLayoutFromXml().setAlpha(r102);
        getInputLayoutFromXml().setOnClickListener(new c(r100, this));
        getMemberListLayoutFromXml().setOnClickListener(new d(r100, this));
        getAdapter().f489862a = new e(r100, this);
        return;
    L5:
        r102 = 0.3f;
        goto L6
    }

    @Override // ej5.b
    public void setFolderPermSetInfo(FolderPermSetInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "folderPermSetInfo");
        tt5.a.h("BaseShareMemberView", "setPermissionInfo()...userPermission = " + r100.f234447j.f234425a.getPermissions());
        getPresenter().a(r100);
        this.f233769m = true;
        if (r100.f234447j.f234426b.lockState() == true) goto L5;
    L9:
        getLockBannerFromXml().setVisibility(8);
        return;
    L5:
        if (r100.b() == false) goto L9;
        if (r100.f234447j.f234425a.canManagerCollaborator() == false) goto L9;
        getLockBannerFromXml().o6(getContext().getString(R.string.CreationMobile_ECM_PermissionRestrictionDesc), r100.f234447j.f234426b.canUnLock(), new i(this));
    }

    public final void setInviteMemberTitleFromXml(TextView r100) {
        this.f233767k = r100;
    }

    public final void setManageMemberTitleFromXml(TextView r100) {
        this.f233768l = r100;
    }

    public f(FragmentActivity r110, int r111, String r112, String r113, String r114, FolderVersion r115, boolean r116, boolean r117, Fragment r210) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r112, "token");
        Intrinsics.checkNotNullParameter(r113, "spaceId");
        Intrinsics.checkNotNullParameter(r114, EventConstant.Key.MODULE);
        Intrinsics.checkNotNullParameter(r115, "version");
        super(r110, r111);
        this.f233764h = r112;
        this.f233765i = r114;
        this.f233766j = r210;
        setPresenter(new ShareFolderMemberPresenter(r110, r111, r112, r113, r115, r116, r114, this));
    }
}
