package com.bytedance.ee.bear.middleground.permission.collaborator.search.topbar;

import com.bytedance.ee.bear.middleground.permission.PermissionAnalytic;
import com.bytedance.ee.bear.middleground.permission.collaborator.invite.InviteMemberParams;
import com.bytedance.ee.bear.middleground_permission_export.model.permissionset.DocPermSetInfo;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.larksuite.framework.mvp.BasePresenter;
import com.larksuite.framework.mvp.IView;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b extends BasePresenter<gh5.a, com.bytedance.ee.bear.middleground.permission.collaborator.search.topbar.a, com.bytedance.ee.bear.middleground.permission.collaborator.search.topbar.a.InterfaceC0101a> implements dh5.c {
    public final gh5.a a;
    public final com.bytedance.ee.bear.middleground.permission.collaborator.search.topbar.a b;
    public final a c;
    public final gh5.b d;
    public final InviteMemberParams e;
    public final int f;

    public interface a {
        void onBack();
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.middleground.permission.collaborator.search.topbar.b$b, reason: collision with other inner class name */
    public final class C0102b implements com.bytedance.ee.bear.middleground.permission.collaborator.search.topbar.a.InterfaceC0101a {
        public final /* synthetic */ b a;

        @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.topbar.a.InterfaceC0101a
        public final void D2() {
            InviteMemberParams r0 = this.a.e;
            String r2 = r0.a;
            int r3 = r0.getType();
            InviteMemberParams r1 = this.a.e;
            String r5 = r1.d;
            boolean r10 = r1.i;
            String r4 = com.bytedance.ee.bear.middleground.permission.c.a;
            Intrinsics.checkNotNullParameter(r2, ResourceData.KEY_TOKEN);
            Intrinsics.checkNotNullParameter(r5, "subType");
            JSONObject r6 = new JSONObject();
            if (com.bytedance.ee.bear.middleground.permission.c.c == false) goto L5;
            String r7 = ThumbGlideUrl.SOURCE_VC;
        L6:
            com.bytedance.ee.bear.middleground.permission.c.a(r6, r2, r3, r7, r5, com.bytedance.ee.bear.middleground.permission.c.d, com.bytedance.ee.bear.middleground.permission.c.e, com.bytedance.ee.bear.middleground.permission.c.a, com.bytedance.ee.bear.middleground.permission.c.b, r10);
            r6.put("click", "delete");
            r6.put("target", "none");
            com.bytedance.ee.bear.middleground.permission.c.c("ccm_permission_search_collaborator_click", r6);
            return;
        L5:
            r7 = "none";
            goto L6
        }

        @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.topbar.a.InterfaceC0101a
        public final void X5() {
            b r0 = this.a;
            int r1 = r0.f;
            if (r1 != 0) goto L10;
            InviteMemberParams r2 = r0.e;
            String r5 = r2.a;
            int r6 = r2.getType();
            InviteMemberParams r3 = this.a.e;
            String r8 = r3.d;
            boolean r13 = r3.i;
            String r4 = com.bytedance.ee.bear.middleground.permission.c.a;
            Intrinsics.checkNotNullParameter(r5, ResourceData.KEY_TOKEN);
            Intrinsics.checkNotNullParameter(r8, "subType");
            JSONObject r7 = new JSONObject();
            if (com.bytedance.ee.bear.middleground.permission.c.c == false) goto L7;
            String r9 = ThumbGlideUrl.SOURCE_VC;
        L8:
            com.bytedance.ee.bear.middleground.permission.c.a(r7, r5, r6, r9, r8, com.bytedance.ee.bear.middleground.permission.c.d, com.bytedance.ee.bear.middleground.permission.c.e, com.bytedance.ee.bear.middleground.permission.c.a, com.bytedance.ee.bear.middleground.permission.c.b, r13);
            r7.put("click", "close");
            r7.put("target", "none");
            com.bytedance.ee.bear.middleground.permission.c.c("ccm_permission_add_collaborator_click", r7);
        L15:
            this.a.c.onBack();
            return;
        L7:
            r9 = "none";
            goto L8
        L10:
            if (r1 != 1) goto L13;
            InviteMemberParams r10 = r0.e;
            String r11 = r10.a;
            int r12 = r10.getType();
            InviteMemberParams r14 = this.a.e;
            String r15 = r14.d;
            boolean r16 = r14.i;
            String r17 = com.bytedance.ee.bear.middleground.permission.c.a;
            Intrinsics.checkNotNullParameter(r11, ResourceData.KEY_TOKEN);
            Intrinsics.checkNotNullParameter(r15, "subType");
            com.bytedance.ee.bear.middleground.permission.c.A(r11, r12, r15, r16, "back", "none");
            goto L15
        L13:
            if (r1 != 2) goto L15;
            InviteMemberParams r18 = r0.e;
            String r19 = r18.a;
            int r20 = r18.getType();
            InviteMemberParams r21 = this.a.e;
            String r22 = r21.d;
            boolean r23 = r21.i;
            String r24 = com.bytedance.ee.bear.middleground.permission.c.a;
            Intrinsics.checkNotNullParameter(r19, ResourceData.KEY_TOKEN);
            Intrinsics.checkNotNullParameter(r22, "subType");
            com.bytedance.ee.bear.middleground.permission.c.a0(r19, r20, r22, r23, "back", "none");
            goto L15
        }

        @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.topbar.a.InterfaceC0101a
        public final void p() {
            b r0 = this.a;
            int r1 = r0.f;
            if (r1 != 0) goto L6;
            InviteMemberParams r2 = r0.e;
            String r4 = r2.a;
            int r5 = r2.getType();
            InviteMemberParams r3 = this.a.e;
            String r6 = r3.d;
            boolean r7 = r3.i;
            String r8 = com.bytedance.ee.bear.middleground.permission.c.a;
            Intrinsics.checkNotNullParameter(r4, ResourceData.KEY_TOKEN);
            Intrinsics.checkNotNullParameter(r6, "subType");
            com.bytedance.ee.bear.middleground.permission.c.e(r4, r5, r6, r7, ThumbGlideUrl.SOURCE_SEARCH, "none");
            return;
        L6:
            if (r1 != 1) goto L9;
            InviteMemberParams r9 = r0.e;
            String r10 = r9.a;
            int r11 = r9.getType();
            InviteMemberParams r12 = this.a.e;
            String r13 = r12.d;
            boolean r14 = r12.i;
            String r15 = com.bytedance.ee.bear.middleground.permission.c.a;
            Intrinsics.checkNotNullParameter(r10, ResourceData.KEY_TOKEN);
            Intrinsics.checkNotNullParameter(r13, "subType");
            com.bytedance.ee.bear.middleground.permission.c.A(r10, r11, r13, r14, ThumbGlideUrl.SOURCE_SEARCH, "ccm_permission_organization_authorize_search_view");
            return;
        L9:
            if (r1 != 2) goto L14;
            InviteMemberParams r16 = r0.e;
            String r17 = r16.a;
            int r18 = r16.getType();
            InviteMemberParams r19 = this.a.e;
            String r20 = r19.d;
            boolean r21 = r19.i;
            String r22 = com.bytedance.ee.bear.middleground.permission.c.a;
            Intrinsics.checkNotNullParameter(r17, ResourceData.KEY_TOKEN);
            Intrinsics.checkNotNullParameter(r20, "subType");
            com.bytedance.ee.bear.middleground.permission.c.a0(r17, r18, r20, r21, ThumbGlideUrl.SOURCE_SEARCH, "ccm_permission_dynamic_user_group_authorize_search_view");
            return;
        }

        public C0102b(b r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.topbar.a.InterfaceC0101a
        public final void B2(String r2) {
            Intrinsics.checkNotNullParameter(r2, "keyword");
            gh5.b r0 = this.a.d;
            if (r0 == null) goto L6;
            r0.B2(r2);
            return;
        }

        @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.topbar.a.InterfaceC0101a
        public final void C2(boolean r14) {
            this.a.getClass();
            if (r14 == false) goto L6;
            DocPermSetInfo r15 = new DocPermSetInfo(null, 0, null, false, null, null, null, false, false, false, 2047);
            String[] r0 = PermissionAnalytic.a;
            Intrinsics.checkNotNullParameter(r15, "permSetInfo");
            Intrinsics.checkNotNullParameter("click_invite_search_bar", "eventName");
            PermissionAnalytic.l(r15, "click_invite_search_bar", null);
            return;
        }

        @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.topbar.a.InterfaceC0101a
        public final void O3(UserInfo r2) {
            Intrinsics.checkNotNullParameter(r2, "userInfo");
            this.a.a.i(r2);
        }
    }

    public final IView.IViewDelegate createViewDelegate() {
        return new C0102b(this);
    }

    public final void create() {
        super.create();
        this.a.registerChangeListener(this);
        if (this.a.C1().size() <= 0) goto L11;
        ArrayList<UserInfo> r0 = new ArrayList();
        Iterator<T> r1 = this.a.C1().iterator();
    L6:
        if (r1.hasNext() == false) goto L8;
        r0.add((UserInfo) r1.next());
        goto L6
    L8:
        this.b.R0(r0);
        this.b.P5();
        return;
    }

    public final void destroy() {
        super.destroy();
        this.a.unregisterChangeListener(this);
    }

    @Override // dh5.c
    public final void W1(UserInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "userInfo");
        if (this.a.C1().size() != 0) goto L5;
        this.b.X6();
    L5:
        this.b.W(r2);
    }

    @Override // dh5.c
    public final void g8(UserInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "userInfo");
        if (this.a.C1().size() <= 0) goto L5;
        this.b.P5();
    L5:
        this.b.u5(r2);
    }

    public b(gh5.c r2, c r3, a r4, gh5.b r5, InviteMemberParams r6, int r7) {
        Intrinsics.checkNotNullParameter(r2, "topbarModel");
        Intrinsics.checkNotNullParameter(r3, "topbarView");
        Intrinsics.checkNotNullParameter(r4, "dependency");
        Intrinsics.checkNotNullParameter(r6, "params");
        super(r2, r3);
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
