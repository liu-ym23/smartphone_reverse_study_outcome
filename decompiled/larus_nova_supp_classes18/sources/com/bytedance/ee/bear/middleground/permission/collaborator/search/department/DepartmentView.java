package com.bytedance.ee.bear.middleground.permission.collaborator.search.department;

import android.content.Context;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.facade.common.widget.recyclerview.LoadMoreFooter;
import com.bytedance.ee.bear.pathnavigationview.PathNavigationAdapter;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEmptyState;
import com.larksuite.framework.mvp.IView;
import cqa.h;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class DepartmentView implements e, kl5.b<VisibleDepartment>, DepartmentAdapter.b, gqa.b {
    public final Context a;
    public final View b;
    public final String c;
    public final boolean d;
    public PathNavigationAdapter<VisibleDepartment> e;
    public DepartmentAdapter f;
    public e.a g;

    public static final class a implements View.OnClickListener {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
        }
    }

    public final void destroy() {
    }

    public final void create() {
        this.e = new PathNavigationAdapter();
        RecyclerView r0 = this.b.findViewById(2131382114);
        RecyclerView.Adapter r2 = this.e;
        DepartmentAdapter r4 = null;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("navigationAdapter");
        r2 = null;
    L5:
        r0.setAdapter(r2);
        this.b.findViewById(2131382114).setLayoutManager(new LinearLayoutManager(this.a, 0, false));
        PathNavigationAdapter<VisibleDepartment> r1 = this.e;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("navigationAdapter");
        r1 = null;
    L8:
        r1.getClass();
        Intrinsics.checkNotNullParameter(this, "listener");
        r1.a = this;
        PathNavigationAdapter<VisibleDepartment> r3 = this.e;
        if (r3 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("navigationAdapter");
        r3 = null;
    L11:
        Parcelable.Creator<VisibleDepartment> r5 = VisibleDepartment.CREATOR;
        Context r6 = this.a;
        Intrinsics.checkNotNullParameter(r6, "context");
        r3.addData(new VisibleDepartment("root_contact", r6.getString(2131888086), ""));
        PathNavigationAdapter<VisibleDepartment> r7 = this.e;
        if (r7 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("navigationAdapter");
        r7 = null;
    L14:
        r7.addData(VisibleDepartment.a.a(this.a));
        this.f = new DepartmentAdapter(this.c, this.d);
        RecyclerView r8 = this.b.findViewById(2131382109);
        DepartmentAdapter r9 = this.f;
        if (r9 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("depAdapter");
        r9 = null;
    L17:
        r8.setAdapter(r9);
        this.b.findViewById(2131382109).setLayoutManager(new LinearLayoutManager(this.a));
        DepartmentAdapter r10 = this.f;
        if (r10 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("depAdapter");
    L21:
        r4.getClass();
        Intrinsics.checkNotNullParameter(this, "listener");
        r4.h = this;
        this.b.findViewById(2131382109).addOnScrollListener(new AnonymousClass1());
        this.b.findViewById(2131382115).F(new LoadMoreFooter(this.a), -2);
        this.b.findViewById(2131382115).i(this);
        d0(false);
        this.b.setOnClickListener(a.a);
        return;
    L20:
        r4 = r10;
        goto L21
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.department.e
    public final void g1() {
        this.b.findViewById(2131382115).setVisibility(0);
        ((SpaceEmptyState) this.b.findViewById(2131382108)).setVisibility(8);
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.department.e
    public final void hideLoading() {
        this.b.findViewById(2131382110).cancelAnimation();
        this.b.findViewById(2131382110).setVisibility(8);
        this.b.findViewById(2131382109).setVisibility(0);
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.department.e
    public final void showLoading() {
        this.b.findViewById(2131382109).setVisibility(8);
        this.b.findViewById(2131382110).setVisibility(0);
        this.b.findViewById(2131382110).playAnimation();
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.department.e
    public final void t7() {
        this.b.findViewById(2131382115).s();
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.department.e
    public final void I0(Department r3) {
        Intrinsics.checkNotNullParameter(r3, "department");
        DepartmentAdapter r0 = this.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("depAdapter");
        r0 = null;
    L5:
        r0.getClass();
        Intrinsics.checkNotNullParameter(r3, "newDepartment");
        r0.c.getVisibleDepartments().clear();
        r0.c.getVisibleTopUserInDep().clear();
        r0.g.clear();
        r0.z2(r3);
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.department.e
    public final void J1(boolean r4) {
        this.b.findViewById(2131382115).setVisibility(8);
        ((SpaceEmptyState) this.b.findViewById(2131382108)).setVisibility(0);
        if (r4 == false) goto L5;
        int r5 = 2131888111;
    L6:
        ((SpaceEmptyState) this.b.findViewById(2131382108)).setDesc(this.a.getString(r5));
        return;
    L5:
        r5 = 2131888094;
        goto L6
    }

    public final void O0(h r2) {
        Intrinsics.checkNotNullParameter(r2, "refreshlayout");
        e.a r3 = this.g;
        if (r3 == null) goto L6;
        r3.onLoadMore();
        return;
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.department.e
    public final void Q7(VisibleTopUserInDep r3) {
        Intrinsics.checkNotNullParameter(r3, "visibleTopUserInDep");
        DepartmentAdapter r0 = this.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("depAdapter");
        r0 = null;
    L5:
        r0.getClass();
        Intrinsics.checkNotNullParameter(r3, "topUser");
        if (r0.e.contains(r3) == true) goto L9;
        r0.e.add(r3);
        r0.notifyDataSetChanged();
        return;
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.department.e
    public final void R7(VisibleDepartment r3) {
        Intrinsics.checkNotNullParameter(r3, "visibleDepartment");
        DepartmentAdapter r1 = this.f;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("depAdapter");
        r1 = null;
    L5:
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "visibleDepartment");
        if (r1.d.contains(r3) == false) goto L9;
        r1.d.remove(r3);
        r1.notifyDataSetChanged();
        return;
    }

    @Override // kl5.b
    public final void T(kl5.a r3) {
        VisibleDepartment r4 = (VisibleDepartment) r3;
        Intrinsics.checkNotNullParameter(r4, "node");
        this.b.findViewById(2131382115).s();
        if (TextUtils.equals(r4.a, "root_contact") == false) goto L7;
        e.a r5 = this.g;
        if (r5 == null) goto L11;
        r5.back();
        return;
    L11:
        return;
    L7:
        e.a r0 = this.g;
        if (r0 == null) goto L13;
        r0.C7(r4);
        return;
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.department.e
    public final void X0(Department r2) {
        Intrinsics.checkNotNullParameter(r2, "department");
        DepartmentAdapter r0 = this.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("depAdapter");
        r0 = null;
    L5:
        r0.z2(r2);
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.department.e
    public final void Z6(VisibleDepartment r3) {
        Intrinsics.checkNotNullParameter(r3, "visibleDepartment");
        DepartmentAdapter r0 = this.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("depAdapter");
        r0 = null;
    L5:
        r0.getClass();
        Intrinsics.checkNotNullParameter(r3, "dep");
        if (r0.d.contains(r3) == true) goto L9;
        r0.d.add(r3);
        r0.notifyDataSetChanged();
        return;
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.department.e
    public final void d0(boolean r3) {
        this.b.findViewById(2131382115).s();
        this.b.findViewById(2131382115).g(r3);
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.department.e
    public final void d4(VisibleTopUserInDep r3) {
        Intrinsics.checkNotNullParameter(r3, "visibleTopUserInDep");
        DepartmentAdapter r1 = this.f;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("depAdapter");
        r1 = null;
    L5:
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "visibleTopUserInDep");
        if (r1.e.contains(r3) == false) goto L9;
        r1.e.remove(r3);
        r1.notifyDataSetChanged();
        return;
    }

    public final void setViewDelegate(IView.IViewDelegate r1) {
        this.g = (e.a) r1;
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.department.DepartmentAdapter.b
    public final void D(VisibleDepartment r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "department");
        if (r3 == false) goto L7;
        e.a r4 = this.g;
        if (r4 == null) goto L11;
        r4.B8(r2);
        return;
    L11:
        return;
    L7:
        e.a r5 = this.g;
        if (r5 == null) goto L13;
        r5.c6(r2);
        return;
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.department.DepartmentAdapter.b
    public final void P(VisibleDepartment r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "visibleDepartment");
        if (r4 == false) goto L5;
        Context r5 = this.a;
        Toast.showText(r5, r5.getString(2131888087));
        return;
    L5:
        e.a r6 = this.g;
        if (r6 == null) goto L8;
        r6.Q1(r3);
    L8:
        PathNavigationAdapter<VisibleDepartment> r7 = this.e;
        PathNavigationAdapter<VisibleDepartment> r0 = null;
        if (r7 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("navigationAdapter");
        r7 = null;
    L11:
        r7.addData(r3);
        RecyclerView.Adapter r8 = this.e;
        if (r8 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("navigationAdapter");
        r8 = null;
    L14:
        r8.notifyDataSetChanged();
        RecyclerView r9 = this.b.findViewById(2131382114);
        PathNavigationAdapter<VisibleDepartment> r10 = this.e;
        if (r10 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("navigationAdapter");
    L18:
        r9.smoothScrollToPosition(r0.getData().size() - 1);
        return;
    L17:
        r0 = r10;
        goto L18
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.department.DepartmentAdapter.b
    public final void k(VisibleTopUserInDep r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "topUserInDep");
        if (r3 == false) goto L7;
        e.a r4 = this.g;
        if (r4 == null) goto L11;
        r4.A5(r2);
        return;
    L11:
        return;
    L7:
        e.a r5 = this.g;
        if (r5 == null) goto L13;
        r5.p5(r2);
        return;
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.department.e
    public final void g3(ArrayList<UserInfo> r5, ArrayList<VisibleDepartment> r6, ArrayList<VisibleTopUserInDep> r7) {
        Intrinsics.checkNotNullParameter(r5, "originUsers");
        Intrinsics.checkNotNullParameter(r6, "selectedDeps");
        Intrinsics.checkNotNullParameter(r7, "selectedTopUsers");
        DepartmentAdapter r3 = this.f;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("depAdapter");
        r3 = null;
    L5:
        r3.getClass();
        Intrinsics.checkNotNullParameter(r5, "originUsers");
        Intrinsics.checkNotNullParameter(r6, "selectedDeps");
        Intrinsics.checkNotNullParameter(r7, "selectedTopUsers");
        r3.f.clear();
        if ((!r5.isEmpty()) == false) goto L8;
        r3.f.addAll(r5);
    L8:
        r3.d.clear();
        if ((!r6.isEmpty()) == false) goto L11;
        r3.d.addAll(r6);
    L11:
        r3.e.clear();
        if ((!r7.isEmpty()) == false) goto L15;
        r3.e.addAll(r7);
        return;
    }

    public DepartmentView(Context r2, View r3, String r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "rootView");
        Intrinsics.checkNotNullParameter(r4, "uid");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
