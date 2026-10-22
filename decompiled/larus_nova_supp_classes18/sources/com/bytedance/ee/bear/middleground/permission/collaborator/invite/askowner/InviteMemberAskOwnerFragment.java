package com.bytedance.ee.bear.middleground.permission.collaborator.invite.askowner;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.ee.bear.middleground.permission.collaborator.search.InviteMemberViewModel;
import com.bytedance.ee.bear.middleground_permission_export.model.permissionset.DocPermSetInfo;
import com.bytedance.ee.bear.share.export.UserInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001f2\u00020\u00012\u00020\u0002:\u0001\u001fB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J&\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u001a\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u00132\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u001a\u001a\u00020\u000fH\u0016J\b\u0010\u001b\u001a\u00020\u000fH\u0016J\b\u0010\u001c\u001a\u00020\u000fH\u0016J\u0010\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u0013H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/collaborator/invite/askowner/InviteMemberAskOwnerFragment;", "Lcom/bytedance/ee/bear/facade/common/BaseFragment;", "Lcom/bytedance/ee/bear/middleground/permission/collaborator/invite/askowner/InviteMemberAskOwnerPresenter$Dependency;", "<init>", "()V", "permSetInfo", "Lcom/bytedance/ee/bear/middleground_permission_export/model/permissionset/DocPermSetInfo;", "ownerInfo", "Lcom/bytedance/ee/bear/share/export/UserInfo;", "module", "", "source", "presenter", "Lcom/bytedance/ee/bear/middleground/permission/collaborator/invite/askowner/InviteMemberAskOwnerPresenter;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "onDestroy", "back", "finish", "initMVP", "rootView", "Companion", "middleground-permission_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InviteMemberAskOwnerFragment extends BaseFragment implements d.b {
    public static final /* synthetic */ int j = 0;
    public DocPermSetInfo e;
    public UserInfo f;
    public String g;
    public String h;
    public d i;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.invite.askowner.d.b
    public final void back() {
        tt5.a.h("InviteMemberAskOwnerFragment", "back()...");
        if (getParentFragment() != null) goto L5;
        return;
    L5:
        if ((getParentFragment() instanceof dh5.a) == false) goto L9;
        dh5.a r0 = getParentFragment();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.bytedance.ee.bear.middleground.permission.collaborator.search.newsearch.ISearchUserActDependency");
        r0.back();
        return;
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.invite.askowner.d.b
    public final void finish() {
        tt5.a.h("InviteMemberAskOwnerFragment", "finish()...");
        if (getParentFragment() != null) goto L5;
        return;
    L5:
        if ((getParentFragment() instanceof dh5.a) == false) goto L9;
        dh5.a r0 = getParentFragment();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.bytedance.ee.bear.middleground.permission.collaborator.search.newsearch.ISearchUserActDependency");
        r0.finish();
        return;
    }

    public InviteMemberAskOwnerFragment() {
        this.e = new DocPermSetInfo(null, 0, null, false, null, null, null, false, false, false, 2047);
        this.f = new UserInfo();
    }

    public final void onDestroy() {
        super.onDestroy();
        tt5.a.h("InviteMemberAskOwnerFragment", "onDestroy()...");
        d r0 = this.i;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("presenter");
        r0 = null;
    L5:
        r0.destroy();
    }

    public final void onCreate(Bundle r13) {
        super.onCreate(r13);
        Bundle r14 = getArguments();
        if (r14 == null) goto L6;
        DocPermSetInfo r15 = (DocPermSetInfo) r14.getParcelable("extra_perm_set_info");
        if (r15 == null) goto L6;
    L7:
        this.e = r15;
        Bundle r16 = getArguments();
        if (r16 == null) goto L11;
        UserInfo r17 = (UserInfo) r16.getParcelable("extra_owner_info");
        if (r17 == null) goto L11;
    L12:
        this.f = r17;
        Bundle r18 = getArguments();
        String r0 = "";
        if (r18 == null) goto L16;
        String r19 = r18.getString("extra_source");
        if (r19 == null) goto L16;
    L17:
        this.h = r19;
        Bundle r110 = getArguments();
        if (r110 == null) goto L23;
        String r111 = r110.getString("permission_module");
        if (r111 == null) goto L23;
        r0 = r111;
    L23:
        this.g = r0;
        return;
    L16:
        r19 = "";
    L11:
        r17 = new UserInfo();
    L6:
        r15 = new DocPermSetInfo(null, 0, null, false, null, null, null, false, false, false, 2047);
        goto L7
    }

    public final void onViewCreated(View r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r10, "view");
        super.onViewCreated(r10, r11);
        tt5.a.h("InviteMemberAskOwnerFragment", "initMVP()...");
        FragmentActivity r12 = getActivity();
        Intrinsics.checkNotNull(r12);
        dh5.b r13 = ViewModelProviders.of(r12).get(InviteMemberViewModel.class);
        Context r0 = getContext();
        Intrinsics.checkNotNull(r0);
        InviteMemberAskOwnerView r1 = new InviteMemberAskOwnerView(r0, r10, this.e, this.f);
        c r2 = new c(r13, this.e);
        Context r3 = getContext();
        Intrinsics.checkNotNull(r3);
        String r14 = this.g;
        if (r14 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("module");
        String r5 = null;
    L6:
        String r15 = this.h;
        if (r15 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("source");
        String r6 = null;
    L10:
        d r16 = new d(r1, r2, r3, this, r5, r6, this.e, this.f);
        this.i = r16;
        r16.create();
        return;
    L9:
        r6 = r15;
        goto L10
    L5:
        r5 = r14;
        goto L6
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131564183, r3, false);
    }
}
