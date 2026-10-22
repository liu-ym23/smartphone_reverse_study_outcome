package com.bytedance.ee.bear.middleground.permission.collaborator.search.department;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.ee.bear.contract.AccountService;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.ee.bear.middleground.permission.collaborator.invite.InviteMemberParams;
import com.bytedance.ee.bear.middleground.permission.collaborator.search.InviteMemberViewModel;
import com.bytedance.ee.bear.share.export.UserInfo;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001b2\u00020\u00012\u00020\u0002:\u0001\u001bB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J&\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u001a\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u00122\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0019\u001a\u00020\u000eH\u0016J\b\u0010\u001a\u001a\u00020\u000eH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u001e\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/collaborator/search/department/DepartmentFragment;", "Lcom/bytedance/ee/bear/facade/common/BaseFragment;", "Lcom/bytedance/ee/bear/middleground/permission/collaborator/search/department/DepartmentPresenter$Dependency;", "<init>", "()V", "depPresenter", "Lcom/bytedance/ee/bear/middleground/permission/collaborator/search/department/DepartmentPresenter;", "originUsers", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/share/export/UserInfo;", "Lkotlin/collections/ArrayList;", "params", "Lcom/bytedance/ee/bear/middleground/permission/collaborator/invite/InviteMemberParams;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "onDestroyView", "onBack", "Companion", "middleground-permission-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DepartmentFragment extends BaseFragment implements d.b {
    public static final /* synthetic */ int h = 0;
    public d e;
    public final ArrayList<UserInfo> f;
    public InviteMemberParams g;

    public static final class a {
    }

    static {
    }

    public DepartmentFragment() {
        this.f = new ArrayList();
        this.g = new InviteMemberParams(null, 0, null, null, null, false, false, false, false, false, false, false, null, null, false, false, false, false, false, false, false, null, 8388607);
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.department.d.b
    public final void onBack() {
        if (getParentFragment() == null) goto L10;
        Fragment r0 = getParentFragment();
        Intrinsics.checkNotNull(r0);
        if (r0.getParentFragment() == null) goto L11;
        Fragment r1 = getParentFragment();
        Intrinsics.checkNotNull(r1);
        if ((r1.getParentFragment() instanceof dh5.a) == false) goto L12;
        Fragment r2 = getParentFragment();
        Intrinsics.checkNotNull(r2);
        dh5.a r3 = r2.getParentFragment();
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.bytedance.ee.bear.middleground.permission.collaborator.search.newsearch.ISearchUserActDependency");
        r3.back();
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
        d r0 = this.e;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("depPresenter");
        r0 = null;
    L5:
        r0.destroy();
    }

    public final void onCreate(Bundle r27) {
        super.onCreate(r27);
        Bundle r1 = getArguments();
        if (r1 == null) goto L5;
        ArrayList r2 = r1.getParcelableArrayList("extra_origin_users");
    L6:
        if (r2 == null) goto L8;
        this.f.clear();
        this.f.addAll(r2);
    L8:
        Bundle r3 = getArguments();
        if (r3 == null) goto L12;
        InviteMemberParams r4 = (InviteMemberParams) r3.getParcelable("extra_params");
        if (r4 == null) goto L12;
    L13:
        this.g = r4;
        return;
    L12:
        r4 = new InviteMemberParams(null, 0, null, null, null, false, false, false, false, false, false, false, null, null, false, false, false, false, false, false, false, null, 8388607);
        goto L13
    L5:
        r2 = null;
        goto L6
    }

    public final void onViewCreated(View r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r8, "view");
        super.onViewCreated(r8, r9);
        AccountService.Account r10 = ((h0) org.koin.java.a.c(h0.class, null, null, 6)).G2();
        if (r10 == null) goto L6;
        String r11 = r10.uid;
        if (r11 == null) goto L6;
    L7:
        FragmentActivity r0 = getActivity();
        Intrinsics.checkNotNull(r0);
        dh5.b r1 = ViewModelProviders.of(r0).get(InviteMemberViewModel.class);
        Context r2 = getContext();
        Intrinsics.checkNotNull(r2);
        c r3 = new c(r2, r1, this.f, this.g);
        Context r4 = getContext();
        Intrinsics.checkNotNull(r4);
        DepartmentView r5 = new DepartmentView(r4, r8, r11, this.g.j);
        Context r6 = getContext();
        Intrinsics.checkNotNull(r6);
        d r12 = new d(r6, r3, r5, this, this.g);
        this.e = r12;
        r12.create();
        return;
    L6:
        r11 = "";
        goto L7
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131564181, r3, false);
    }
}
