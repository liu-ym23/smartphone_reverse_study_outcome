package com.bytedance.ee.bear.middleground.permission.collaborator.search.usergroup;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.facade.common.widget.BearLottieView;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.larksuite.framework.mvp.IView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class UserGroupView implements b, UserGroupAdapter.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f233655a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f233656b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f233657c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f233658d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public UserGroupAdapter f233659e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public b.a f233660f;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f233661a = null;

        static {
            f233661a = new a();
        }

        public a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
        }
    }

    @Override // com.larksuite.framework.mvp.ILifecycle
    public final void destroy() {
    }

    @Override // com.larksuite.framework.mvp.ILifecycle
    public final void create() {
        this.f233659e = new UserGroupAdapter(this.f233657c, this.f233658d);
        RecyclerView r100 = (RecyclerView) this.f233656b.findViewById(R.id.permGroupList);
        UserGroupAdapter r101 = this.f233659e;
        UserGroupAdapter r102 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r101 = null;
    L5:
        r100.setAdapter(r101);
        ((RecyclerView) this.f233656b.findViewById(R.id.permGroupList)).setLayoutManager(new LinearLayoutManager(this.f233655a));
        UserGroupAdapter r103 = this.f233659e;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L9:
        r102.getClass();
        Intrinsics.checkNotNullParameter(this, "listener");
        r102.f233649e = this;
        ((RecyclerView) this.f233656b.findViewById(R.id.permGroupList)).addOnScrollListener(new AnonymousClass1());
        this.f233656b.setOnClickListener(a.f233661a);
        return;
    L8:
        r102 = r103;
        goto L9
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.usergroup.b
    public final void hideLoading() {
        ((BearLottieView) this.f233656b.findViewById(R.id.permGroupLoading)).cancelAnimation();
        ((BearLottieView) this.f233656b.findViewById(R.id.permGroupLoading)).setVisibility(8);
        ((RecyclerView) this.f233656b.findViewById(R.id.permGroupList)).setVisibility(0);
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.usergroup.b
    public final void showLoading() {
        ((RecyclerView) this.f233656b.findViewById(R.id.permGroupList)).setVisibility(8);
        ((BearLottieView) this.f233656b.findViewById(R.id.permGroupLoading)).playAnimation();
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.usergroup.b
    public final void E0(UserGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "userGroup");
        UserGroupAdapter r101 = this.f233659e;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r101 = null;
    L5:
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "userGroup");
        if (r101.f233647c.contains(r100) == false) goto L9;
        r101.f233647c.remove(r100);
        r101.notifyDataSetChanged();
        return;
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.usergroup.b
    public final void Y2(GetUserGroupResult r100) {
        Intrinsics.checkNotNullParameter(r100, "visibleUserGroups");
        UserGroupAdapter r101 = this.f233659e;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r101 = null;
    L5:
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "visibleUserGroup");
        r101.f233646b = r100;
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.usergroup.b
    public final void a1(UserGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "userGroup");
        UserGroupAdapter r101 = this.f233659e;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r101 = null;
    L5:
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "userGroup");
        if (r101.f233647c.contains(r100) == true) goto L9;
        r101.f233647c.add(r100);
        r101.notifyDataSetChanged();
        return;
    }

    @Override // com.larksuite.framework.mvp.IView
    public final void setViewDelegate(IView.IViewDelegate r100) {
        this.f233660f = (b.a) r100;
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.usergroup.UserGroupAdapter.b
    public final void h(UserGroup r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "userGroup");
        if (r101 == false) goto L7;
        b.a r102 = this.f233660f;
        if (r102 == null) goto L11;
        r102.S1(r100);
        return;
    L11:
        return;
    L7:
        b.a r103 = this.f233660f;
        if (r103 == null) goto L13;
        r103.z8(r100);
        return;
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.usergroup.b
    public final void n3(ArrayList<UserInfo> r100, ArrayList<UserGroup> r101) {
        Intrinsics.checkNotNullParameter(r100, "originUsers");
        Intrinsics.checkNotNullParameter(r101, "selectedUserGroups");
        UserGroupAdapter r102 = this.f233659e;
        UserGroupAdapter r103 = null;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r102 = null;
    L5:
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "originUsers");
        r102.f233648d.clear();
        r102.f233648d.addAll(r100);
        UserGroupAdapter r104 = this.f233659e;
        if (r104 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L9:
        r103.getClass();
        Intrinsics.checkNotNullParameter(r101, "selectedUserGroups");
        r103.f233647c.clear();
        r103.f233647c.addAll(r101);
        return;
    L8:
        r103 = r104;
        goto L9
    }

    public UserGroupView(Context r100, View r101, String r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "rootView");
        Intrinsics.checkNotNullParameter(r102, "uid");
        this.f233655a = r100;
        this.f233656b = r101;
        this.f233657c = r102;
        this.f233658d = r103;
    }
}
