package com.bytedance.ee.bear.middleground.permission.collaborator.search.department;

import android.content.Context;
import android.os.Parcelable;
import android.text.TextUtils;
import com.bytedance.ee.bear.middleground.permission.collaborator.invite.InviteMemberParams;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.larksuite.framework.mvp.BasePresenter;
import com.larksuite.framework.mvp.IView;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class d extends BasePresenter<ch5.e, e, e.a> implements dh5.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f233468a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ch5.e f233469b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e f233470c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f233471d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final InviteMemberParams f233472e;

    public final class a implements e.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f233473a;

        @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.department.e.a
        public final void back() {
            this.f233473a.f233471d.onBack();
        }

        @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.department.e.a
        public final void onLoadMore() {
            d r100 = this.f233473a;
            r100.f233469b.q6(new ch5.d(r100));
        }

        public a(d r100) {
            this.f233473a = r100;
        }

        @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.department.e.a
        public final void A5(VisibleTopUserInDep r100) {
            Intrinsics.checkNotNullParameter(r100, "visibleTopUserInDep");
            ch5.e r101 = this.f233473a.f233469b;
            r101.l(r101.Y6(r100));
        }

        @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.department.e.a
        public final void B8(VisibleDepartment r100) {
            Intrinsics.checkNotNullParameter(r100, "visibleDepartment");
            ch5.e r101 = this.f233473a.f233469b;
            r101.l(r101.K6(r100));
        }

        @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.department.e.a
        public final void C7(VisibleDepartment r100) {
            Intrinsics.checkNotNullParameter(r100, "visibleDepartment");
            this.f233473a.H8(r100);
        }

        @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.department.e.a
        public final void Q1(VisibleDepartment r100) {
            Intrinsics.checkNotNullParameter(r100, "visibleDepartment");
            this.f233473a.H8(r100);
            InviteMemberParams r101 = this.f233473a.f233472e;
            String r102 = r101.f233166a;
            int r103 = r101.getType();
            InviteMemberParams r104 = this.f233473a.f233472e;
            String r105 = r104.f233169d;
            boolean r106 = r104.f233174i;
            String r107 = com.bytedance.ee.bear.middleground.permission.c.f233147a;
            Intrinsics.checkNotNullParameter(r102, "token");
            Intrinsics.checkNotNullParameter(r105, "subType");
            com.bytedance.ee.bear.middleground.permission.c.A(r102, r103, r105, r106, PickerReporterConstants.VALUE.CLICK.NEXT_DEPARTMENT_LEVEL, "none");
        }

        @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.department.e.a
        public final void c6(VisibleDepartment r100) {
            Intrinsics.checkNotNullParameter(r100, "visibleDepartment");
            ch5.e r101 = this.f233473a.f233469b;
            r101.i(r101.K6(r100));
        }

        @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.department.e.a
        public final void p5(VisibleTopUserInDep r100) {
            Intrinsics.checkNotNullParameter(r100, "visibleTopUserInDep");
            ch5.e r101 = this.f233473a.f233469b;
            r101.i(r101.Y6(r100));
        }
    }

    public interface b {
        void onBack();
    }

    public static final class c implements ax4.e<Department> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f233474a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ VisibleDepartment f233475b;

        @Override // ax4.e
        public final void onFailed(Throwable r100) {
            this.f233474a.f233470c.hideLoading();
        }

        @Override // ax4.e
        public final void onSuccess(Department r100) {
            Department r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "result");
            d r102 = this.f233474a;
            VisibleDepartment r103 = this.f233475b;
            r102.f233470c.hideLoading();
            r102.f233470c.d0(r101.getHasMore());
            if (r101.isEmpty() == false) goto L5;
            boolean r104 = TextUtils.equals(r103.f233444a, "0");
            r102.f233470c.J1(r104);
            return;
        L5:
            r102.f233470c.g1();
            r102.f233470c.I0(r101);
        }

        public c(d r100, VisibleDepartment r101) {
            this.f233474a = r100;
            this.f233475b = r101;
        }
    }

    @Override // com.larksuite.framework.mvp.BasePresenter
    public final IView.IViewDelegate createViewDelegate() {
        return new a(this);
    }

    @Override // com.larksuite.framework.mvp.BasePresenter, com.larksuite.framework.mvp.ILifecycle
    public final void create() {
        super.create();
        this.f233470c.g3(this.f233469b.m0(), this.f233469b.r6(), this.f233469b.O1());
        this.f233469b.registerChangeListener(this);
        Parcelable.Creator<VisibleDepartment> r100 = VisibleDepartment.CREATOR;
        H8(VisibleDepartment.a.a(this.f233468a));
    }

    @Override // com.larksuite.framework.mvp.BasePresenter, com.larksuite.framework.mvp.ILifecycle
    public final void destroy() {
        super.destroy();
        this.f233469b.unregisterChangeListener(this);
    }

    public final void H8(VisibleDepartment r100) {
        this.f233470c.showLoading();
        this.f233469b.V7(r100, new c(this, r100));
    }

    @Override // dh5.c
    public final void W1(UserInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "userInfo");
        if (r100.getOwnerType() != 18) goto L6;
        this.f233470c.R7(this.f233469b.M2(r100));
        return;
    L6:
        if (r100.getOwnerType() != 1) goto L8;
    L9:
        this.f233470c.d4(this.f233469b.u2(r100));
        return;
    L8:
        if (r100.getOwnerType() == 0) goto L9;
    }

    @Override // dh5.c
    public final void g8(UserInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "userInfo");
        if (r100.getOwnerType() != 18) goto L6;
        this.f233470c.Z6(this.f233469b.M2(r100));
        return;
    L6:
        if (r100.getOwnerType() != 1) goto L8;
    L9:
        this.f233470c.Q7(this.f233469b.u2(r100));
        return;
    L8:
        if (r100.getOwnerType() == 0) goto L9;
    }

    public d(Context r100, com.bytedance.ee.bear.middleground.permission.collaborator.search.department.c r101, DepartmentView r102, b r103, InviteMemberParams r104) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "depModel");
        Intrinsics.checkNotNullParameter(r102, "depView");
        Intrinsics.checkNotNullParameter(r103, "dependency");
        Intrinsics.checkNotNullParameter(r104, "params");
        super(r101, r102);
        this.f233468a = r100;
        this.f233469b = r101;
        this.f233470c = r102;
        this.f233471d = r103;
        this.f233472e = r104;
    }
}
