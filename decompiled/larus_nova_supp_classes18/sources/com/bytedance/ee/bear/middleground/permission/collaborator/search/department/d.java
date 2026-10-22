package com.bytedance.ee.bear.middleground.permission.collaborator.search.department;

import android.content.Context;
import android.os.Parcelable;
import android.text.TextUtils;
import com.bytedance.ee.bear.middleground.permission.collaborator.invite.InviteMemberParams;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.larksuite.framework.mvp.BasePresenter;
import com.larksuite.framework.mvp.IView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d extends BasePresenter<ch5.e, e, e.a> implements dh5.c {
    public final Context a;
    public final ch5.e b;
    public final e c;
    public final b d;
    public final InviteMemberParams e;

    public final class a implements e.a {
        public final /* synthetic */ d a;

        @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.department.e.a
        public final void back() {
            this.a.d.onBack();
        }

        @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.department.e.a
        public final void onLoadMore() {
            d r0 = this.a;
            r0.b.q6(new ch5.d(r0));
        }

        public a(d r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.department.e.a
        public final void A5(VisibleTopUserInDep r2) {
            Intrinsics.checkNotNullParameter(r2, "visibleTopUserInDep");
            ch5.e r0 = this.a.b;
            r0.l(r0.Y6(r2));
        }

        @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.department.e.a
        public final void B8(VisibleDepartment r2) {
            Intrinsics.checkNotNullParameter(r2, "visibleDepartment");
            ch5.e r0 = this.a.b;
            r0.l(r0.K6(r2));
        }

        @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.department.e.a
        public final void C7(VisibleDepartment r2) {
            Intrinsics.checkNotNullParameter(r2, "visibleDepartment");
            this.a.H8(r2);
        }

        @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.department.e.a
        public final void Q1(VisibleDepartment r7) {
            Intrinsics.checkNotNullParameter(r7, "visibleDepartment");
            this.a.H8(r7);
            InviteMemberParams r8 = this.a.e;
            String r0 = r8.a;
            int r1 = r8.getType();
            InviteMemberParams r9 = this.a.e;
            String r2 = r9.d;
            boolean r3 = r9.i;
            String r10 = com.bytedance.ee.bear.middleground.permission.c.a;
            Intrinsics.checkNotNullParameter(r0, ResourceData.KEY_TOKEN);
            Intrinsics.checkNotNullParameter(r2, "subType");
            com.bytedance.ee.bear.middleground.permission.c.A(r0, r1, r2, r3, "next_level", "none");
        }

        @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.department.e.a
        public final void c6(VisibleDepartment r2) {
            Intrinsics.checkNotNullParameter(r2, "visibleDepartment");
            ch5.e r0 = this.a.b;
            r0.i(r0.K6(r2));
        }

        @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.department.e.a
        public final void p5(VisibleTopUserInDep r2) {
            Intrinsics.checkNotNullParameter(r2, "visibleTopUserInDep");
            ch5.e r0 = this.a.b;
            r0.i(r0.Y6(r2));
        }
    }

    public interface b {
        void onBack();
    }

    public static final class c implements ax4.e<Department> {
        public final /* synthetic */ d a;
        public final /* synthetic */ VisibleDepartment b;

        public final void onFailed(Throwable r1) {
            this.a.c.hideLoading();
        }

        public final void onSuccess(Object r5) {
            Department r6 = (Department) r5;
            Intrinsics.checkNotNullParameter(r6, "result");
            d r0 = this.a;
            VisibleDepartment r1 = this.b;
            r0.c.hideLoading();
            r0.c.d0(r6.getHasMore());
            if (r6.isEmpty() == false) goto L5;
            boolean r7 = TextUtils.equals(r1.a, "0");
            r0.c.J1(r7);
            return;
        L5:
            r0.c.g1();
            r0.c.I0(r6);
        }

        public c(d r1, VisibleDepartment r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public final IView.IViewDelegate createViewDelegate() {
        return new a(this);
    }

    public final void create() {
        super.create();
        this.c.g3(this.b.m0(), this.b.r6(), this.b.O1());
        this.b.registerChangeListener(this);
        Parcelable.Creator<VisibleDepartment> r0 = VisibleDepartment.CREATOR;
        H8(VisibleDepartment.a.a(this.a));
    }

    public final void destroy() {
        super.destroy();
        this.b.unregisterChangeListener(this);
    }

    public final void H8(VisibleDepartment r3) {
        this.c.showLoading();
        this.b.V7(r3, new c(this, r3));
    }

    @Override // dh5.c
    public final void W1(UserInfo r3) {
        Intrinsics.checkNotNullParameter(r3, "userInfo");
        if (r3.getOwnerType() != 18) goto L6;
        this.c.R7(this.b.M2(r3));
        return;
    L6:
        if (r3.getOwnerType() != 1) goto L8;
    L9:
        this.c.d4(this.b.u2(r3));
        return;
    L8:
        if (r3.getOwnerType() == 0) goto L9;
    }

    @Override // dh5.c
    public final void g8(UserInfo r3) {
        Intrinsics.checkNotNullParameter(r3, "userInfo");
        if (r3.getOwnerType() != 18) goto L6;
        this.c.Z6(this.b.M2(r3));
        return;
    L6:
        if (r3.getOwnerType() != 1) goto L8;
    L9:
        this.c.Q7(this.b.u2(r3));
        return;
    L8:
        if (r3.getOwnerType() == 0) goto L9;
    }

    public d(Context r2, com.bytedance.ee.bear.middleground.permission.collaborator.search.department.c r3, DepartmentView r4, b r5, InviteMemberParams r6) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "depModel");
        Intrinsics.checkNotNullParameter(r4, "depView");
        Intrinsics.checkNotNullParameter(r5, "dependency");
        Intrinsics.checkNotNullParameter(r6, "params");
        super(r3, r4);
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
