package com.bytedance.ee.bear.middleground.permission.collaborator.sharecollaboratev2.doc;

import android.app.Dialog;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.docshost.k;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.permission.permission.doc.DocUserPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.permissionset.DocPermSetInfo;
import com.bytedance.ee.bear.middleground_permission_export.model.share.ShareUserInfoResult;
import com.bytedance.ee.bear.share.export.BitableShareRoleMember;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.bytedance.ee.bear.widgets.t;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.larksuite.component.universe_design.dialog.UDDialogBuilder;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e extends ih5.a<ShareDocMemberPresenter> implements ej5.a {
    public final FragmentActivity h;
    public final Fragment i;
    public final int j;
    public final String k;
    public final String l;
    public final boolean m;
    public final boolean n;
    public final boolean o;
    public final Boolean p;
    public final Boolean q;
    public final Boolean r;
    public final ArrayList<BitableShareRoleMember> s;
    public TextView t;
    public TextView u;
    public DocPermSetInfo v;
    public IDocPublicPermission w;
    public ArrayList<UserInfo> x;
    public boolean y;
    public boolean z;

    public static final class a extends t {
        public final /* synthetic */ e c;

        public a(e r1) {
            this.c = r1;
        }

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r2) {
            FragmentActivity r3 = this.c.h;
            Toast.showFailureText(r3, r3.getString(2131888342));
        }
    }

    public static final class b extends t {
        public final /* synthetic */ e c;

        public b(e r1) {
            this.c = r1;
        }

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r2) {
            FragmentActivity r3 = this.c.h;
            Toast.showFailureText(r3, r3.getString(2131888342));
        }
    }

    public static final class c extends t {
        public final /* synthetic */ e c;

        public c(e r1) {
            this.c = r1;
        }

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r1) {
            e.f(this.c).b();
        }
    }

    public static final class d extends t {
        public final /* synthetic */ e c;

        public d(e r1) {
            this.c = r1;
        }

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r11) {
            int r12 = ih5.f.a;
            e r13 = this.c;
            FragmentActivity r0 = r13.h;
            String r1 = r13.l;
            DocPermSetInfo r14 = r13.v;
            if (r14 == null) goto L5;
            int r2 = r14.f.a.getPermissions();
        L6:
            DocPermSetInfo r3 = e.f(this.c).f();
            ShareUserInfoResult r15 = e.f(this.c).i;
            if (r15 != null) goto L9;
            r15 = new ShareUserInfoResult();
        L9:
            ShareUserInfoResult r4 = r15;
            e r16 = this.c;
            boolean r5 = r16.o;
            String r6 = r16.getTips();
            e r17 = this.c;
            ih5.f.a(r0, r1, r2, r3, r4, r5, r6, r17.q, Boolean.valueOf(r17.y), this.c.i);
            return;
        L5:
            r2 = 0;
            goto L6
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.middleground.permission.collaborator.sharecollaboratev2.doc.e$e, reason: collision with other inner class name */
    public static final class C0106e implements ih5.c.a {
        public final /* synthetic */ e a;

        public C0106e(e r1) {
            this.a = r1;
        }

        @Override // ih5.c.a
        public final void a(UserInfo r11) {
            Intrinsics.checkNotNullParameter(r11, "userInfo");
            int r12 = ih5.f.a;
            e r13 = this.a;
            FragmentActivity r0 = r13.h;
            String r1 = r13.l;
            DocPermSetInfo r14 = r13.v;
            if (r14 == null) goto L5;
            int r2 = r14.f.a.getPermissions();
        L6:
            DocPermSetInfo r3 = e.f(this.a).f();
            ShareUserInfoResult r15 = e.f(this.a).i;
            if (r15 != null) goto L9;
            r15 = new ShareUserInfoResult();
        L9:
            ShareUserInfoResult r4 = r15;
            e r16 = this.a;
            boolean r5 = r16.o;
            String r6 = r16.getTips();
            e r17 = this.a;
            ih5.f.a(r0, r1, r2, r3, r4, r5, r6, r17.q, Boolean.valueOf(r17.y), this.a.i);
            return;
        L5:
            r2 = 0;
            goto L6
        }
    }

    public static final class f implements View.OnClickListener {
        public final /* synthetic */ e a;

        public f(e r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            e.f(this.a).b();
        }
    }

    public static final class g implements View.OnClickListener {
        public final /* synthetic */ e a;

        public g(e r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            Toast.showFailureText(this.a.h, 2131888096);
        }
    }

    public static final class h implements ih5.c.a {
        public final /* synthetic */ e a;

        public h(e r1) {
            this.a = r1;
        }

        @Override // ih5.c.a
        public final void a(UserInfo r4) {
            Intrinsics.checkNotNullParameter(r4, "userInfo");
            if (r4.isOwner() == false) goto L9;
            k r0 = (k) org.koin.java.a.c(k.class, null, null, 6);
            String r5 = r4.getId();
            if (this.a.getType() != 28) goto L7;
            boolean r1 = true;
        L8:
            r0.a(r5, "", r1);
            return;
        L7:
            r1 = false;
            goto L8
        L9:
            Toast.showFailureText(this.a.h, 2131888096);
        }
    }

    public static final class i extends t {
        public final /* synthetic */ e c;

        public i(e r1) {
            this.c = r1;
        }

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r5) {
            com.bytedance.ee.bear.middleground.permission.c.V("restore", "ccm_permission_lock_restore_view");
            e r6 = this.c;
            if (r6.m == false) goto L5;
        L8:
            int r0 = 2131887521;
        L9:
            FragmentActivity r1 = r6.h;
            Intrinsics.checkNotNullParameter(r1, "context");
            UDDialogBuilder r2 = new UDDialogBuilder(r1);
            r2.autoDismiss(true);
            r2.title(2131887510);
            r2.message(r0);
            r2.messageGravity(8388611);
            com.bytedance.ee.bear.middleground.permission.collaborator.sharecollaboratev2.doc.f r3 = new com.bytedance.ee.bear.middleground.permission.collaborator.sharecollaboratev2.doc.f(r6);
            r2.addActionButton(new UDBaseDialogBuilder.ActionBuilder().actionResId(2131391777).text(2131887719).textColorRes(2131102089).onClickListener(r3));
            r2.addActionButton(2131391778, 2131887716, com.bytedance.ee.bear.middleground.permission.collaborator.sharecollaboratev2.doc.g.a);
            r2.animStyle(2131954061);
            Dialog r4 = r2.build();
            if (DialogLancet.shouldBlockDialogShow(r4) == false) goto L17;
            DialogLancet.handleBlockedDialogShow(r4);
        L14:
            ((zo5.b) org.koin.java.a.c(zo5.b.class, null, null, 6)).j(r6.k, r6.getType(), r4);
            com.bytedance.ee.bear.middleground.permission.c.Z();
            return;
        L17:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L16
        L13:
            DialogLancet.beforeDialogShow(r4);
            r4.show();
            DialogLancet.afterDialogShow(r4);
            goto L14
        L5:
            if (r6.n == true) goto L8;
            r0 = 2131887279;
            goto L9
        }
    }

    @Override // ej5.a
    public void setDivider(boolean r1) {
    }

    public final void g() {
        DocPermSetInfo r0 = this.v;
        if (r0 == null) goto L29;
        IDocPublicPermission r1 = this.w;
        if (r1 == null) goto L31;
        Intrinsics.checkNotNull(r1);
        r0.c(r1);
        if (r0.f.b.isLock() == true) goto L10;
    L27:
        getLockBannerFromXml().setVisibility(8);
        return;
    L10:
        if (this.m == true) goto L14;
        if (r0.a() == false) goto L27;
    L14:
        if (r0.f.a.canManageContainerCollaborator() == false) goto L27;
        DocPermSetInfo r2 = this.v;
        if (r2 != null) goto L18;
    L20:
        boolean r3 = false;
    L21:
        if (r3 == true) goto L27;
        if (this.m == false) goto L25;
        int r4 = 2131887514;
    L26:
        getLockBannerFromXml().o6(this.h.getString(r4), r0.f.b.canUnLock(), new i(this));
        return;
    L25:
        r4 = 2131887281;
        goto L26
    L18:
        if (r2.getType() != 44) goto L20;
        r3 = true;
        goto L21
    L31:
        return;
    }

    public final TextView getInviteMemberTitleFromXml() {
        KeyEvent.Callback r0 = this.u;
        if (r0 != null) goto L6;
        r0 = findViewById(2131375593);
        this.u = (TextView) r0;
    L6:
        return (TextView) r0;
    }

    public final TextView getManageMemberTitleFromXml() {
        KeyEvent.Callback r0 = this.t;
        if (r0 != null) goto L6;
        r0 = findViewById(2131379513);
        this.t = (TextView) r0;
    L6:
        return (TextView) r0;
    }

    public final String getTips() {
        Boolean r0 = this.q;
        Boolean r1 = Boolean.TRUE;
        if (Intrinsics.areEqual(r0, r1) == false) goto L45;
        String r2 = this.h.getString(2131886153);
        if (Intrinsics.areEqual(this.p, r1) == true) goto L7;
        return r2;
    L7:
        if (Intrinsics.areEqual(this.r, r1) == true) goto L59;
        ArrayList<UserInfo> r3 = this.x;
        if (r3 == null) goto L60;
        Iterator<T> r4 = r3.iterator();
    L12:
        if (r4.hasNext() == false) goto L61;
        UserInfo r5 = (UserInfo) r4.next();
        DocUserPermission.a r6 = DocUserPermission.Companion;
        int r7 = r5.getPermission();
        r6.getClass();
        if (DocUserPermission.a.a(r7) == true) goto L12;
        Intrinsics.checkNotNullParameter(r5, "user");
        ArrayList<BitableShareRoleMember> r8 = this.s;
        boolean r9 = false;
        if (r8 == null) goto L42;
        Iterator<T> r10 = r8.iterator();
    L19:
        if (r10.hasNext() == false) goto L42;
        BitableShareRoleMember r11 = (BitableShareRoleMember) r10.next();
        Intrinsics.checkNotNullParameter(r5, "user");
        Intrinsics.checkNotNullParameter(r11, "member");
        if (r5.isUserType() == false) goto L30;
        if (r11.isUserType() == false) goto L30;
        if (TextUtils.isEmpty(r5.getId()) == false) goto L27;
    L39:
        boolean r12 = false;
    L40:
        if (r12 == false) goto L19;
        r9 = true;
        goto L42
    L27:
        if (TextUtils.equals(r5.getId(), r11.getMemberId()) == false) goto L39;
    L38:
        r12 = true;
    L30:
        if (TextUtils.isEmpty(r5.getId()) == true) goto L39;
        if (TextUtils.equals(r5.getId(), r11.getMemberId()) == false) goto L39;
        int r13 = r5.getOwnerType();
        Integer r14 = r11.getMemberType();
        if (r14 == null) goto L39;
        if (r13 != r14.intValue()) goto L39;
    L42:
        if (r9 == true) goto L12;
        String r15 = r2 + '\n' + this.h.getString(2131886205);
        this.y = true;
        return r15;
    L61:
        return r2;
    L60:
        return r2;
    L59:
        return r2;
    L45:
        return null;
    }

    @Override // ih5.a
    public int getType() {
        return this.j;
    }

    public static final /* synthetic */ ShareDocMemberPresenter f(e r0) {
        return r0.getPresenter();
    }

    @Override // ih5.a, ih5.e
    public final void c(Throwable r4) {
        Intrinsics.checkNotNullParameter(r4, "throwable");
        int r0 = ax4.d.a(r4);
        getPresenter().g(true, r0);
        super.c(r4);
    }

    @Override // ej5.a
    public final void k2(Throwable r3) {
        Intrinsics.checkNotNullParameter(r3, "throwable");
        if (this.z == false) goto L5;
        return;
    L5:
        getPresenter().g(true, ax4.d.a(r3));
        getInputLayoutFromXml().setOnClickListener(new a(this));
        getMemberListLayoutFromXml().setOnClickListener(new b(this));
    }

    @Override // ih5.a, ih5.e
    public void setCollaborateEnable(boolean r3) {
        tt5.a.h("BaseShareMemberView", "setCollaborateEnable()...enable = " + r3);
        ih5.c r0 = getAdapter();
        r0.b = Boolean.valueOf(r3);
        r0.a();
        if (r3 == false) goto L5;
        getInputLayoutFromXml().setAlpha(1.0f);
        getMemberListLayoutFromXml().setAlpha(1.0f);
        getMemberListFromXml().setAlpha(1.0f);
        getInviteMemberTitleFromXml().setAlpha(1.0f);
        getInputLayoutFromXml().setOnClickListener(new c(this));
        getMemberListLayoutFromXml().setOnClickListener(new d(this));
        getAdapter().a = new C0106e(this);
        return;
    L5:
        getMemberListFromXml().setAlpha(1.0f);
        getMemberListLayoutFromXml().setAlpha(0.3f);
        getManageMemberTitleFromXml().setAlpha(1.0f);
        getInputLayoutFromXml().setAlpha(1.0f);
        getInviteMemberTitleFromXml().setAlpha(1.0f);
        getInputLayoutFromXml().setOnClickListener(new f(this));
        getMemberListLayoutFromXml().setOnClickListener(new g(this));
        getAdapter().a = new h(this);
    }

    @Override // ej5.a
    public void setDocPermSetInfo(DocPermSetInfo r5) {
        Intrinsics.checkNotNullParameter(r5, "docPermSetInfo");
        boolean r0 = true;
        this.z = true;
        this.v = r5;
        tt5.a.h("BaseShareMemberView", "setPermissionInfo()...userPermission = " + r5.f.a.getPermissions());
        ShareDocMemberPresenter r1 = getPresenter();
        r5.f.a.getPermissions();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r5, "permSetInfo");
        r1.j = r5;
        if (r1.k == null) goto L6;
        Intrinsics.checkNotNull(r5);
        IDocPublicPermission r2 = r1.k;
        Intrinsics.checkNotNull(r2);
        r5.c(r2);
    L6:
        if (r1.j == null) goto L15;
        r1.g(false, 0);
        ih5.e r3 = r1.g;
        DocPermSetInfo r4 = r1.j;
        if (r4 != null) goto L10;
    L12:
        r0 = false;
    L13:
        r3.setCollaborateEnable(r0);
        goto L15
    L10:
        if (r4.f.a.canManageCollaborator() != true) goto L12;
    L15:
        if (r5.j == false) goto L18;
        g();
        return;
    }

    public final void setInviteMemberTitleFromXml(TextView r1) {
        this.u = r1;
    }

    public final void setManageMemberTitleFromXml(TextView r1) {
        this.t = r1;
    }

    @Override // ej5.a
    public void setPublicPermission(IDocPublicPermission r3) {
        Intrinsics.checkNotNullParameter(r3, "publicPerm");
        this.w = r3;
        ShareDocMemberPresenter r0 = getPresenter();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r3, "publicPermission");
        r0.k = r3;
        DocPermSetInfo r1 = r0.j;
        if (r1 == null) goto L6;
        if (r3 == null) goto L6;
        Intrinsics.checkNotNull(r1);
        IDocPublicPermission r4 = r0.k;
        Intrinsics.checkNotNull(r4);
        r1.c(r4);
    L6:
        g();
    }

    @Override // ih5.a, ih5.e
    public final void d(ArrayList<UserInfo> r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "userInfos");
        super.d(r2, r3);
        this.x = r2;
    }

    public e(FragmentActivity r12, Fragment r13, int r14, String r15, String r16, String r17, boolean r18, boolean r19, boolean r20, Boolean r21, Boolean r22, Boolean r23, ArrayList r24) {
        Intrinsics.checkNotNullParameter(r12, "context");
        Intrinsics.checkNotNullParameter(r15, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r16, "docName");
        Intrinsics.checkNotNullParameter(r17, "module");
        super(r12, r14);
        this.h = r12;
        this.i = r13;
        this.j = r14;
        this.k = r15;
        this.l = r17;
        this.m = r18;
        this.n = r19;
        this.o = r20;
        this.p = r21;
        this.q = r22;
        this.r = r23;
        this.s = r24;
        setPresenter(new ShareDocMemberPresenter(r12, r13, getType(), r15, r17, r20, this));
        ShareDocMemberPresenter r0 = getPresenter();
        if (r0.c != 44) goto L5;
        r0.h.b(new ShareDocMemberPresenter$requestSyncedBlockMember$1(r0));
    L7:
        if (getType() != 44) goto L10;
        getManageMemberTitleFromXml().setText(r12.getString(2131888082));
        return;
    L10:
        return;
    L5:
        com.bytedance.ee.bear.middleground.permission.collaborator.sharecollaboratev2.doc.a r1 = r0.h;
        ShareDocMemberPresenter$requestMember$1 r3 = new ShareDocMemberPresenter$requestMember$1(r0);
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "callback");
        Disposable r2 = li5.c.c(r1.a, r1.b, new com.bytedance.ee.bear.middleground.permission.collaborator.sharecollaboratev2.doc.b(r1, r3), null);
        r1.c.add(r2);
        goto L7
    }
}
