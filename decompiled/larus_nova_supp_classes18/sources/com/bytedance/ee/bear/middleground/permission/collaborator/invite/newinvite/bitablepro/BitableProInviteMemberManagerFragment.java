package com.bytedance.ee.bear.middleground.permission.collaborator.invite.newinvite.bitablepro;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.ViewModelProviders;
import cj5.c;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.ee.bear.middleground.permission.collaborator.search.InviteMemberViewModel;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sbb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 (2\u00020\u00012\u00020\u0002:\u0001(B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J&\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u001a\u0010!\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020\u001c2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0010\u0010#\u001a\u00020\u00182\u0006\u0010$\u001a\u00020\u001cH\u0002J\b\u0010%\u001a\u00020\u0018H\u0016J\b\u0010&\u001a\u00020\u0018H\u0016J\b\u0010'\u001a\u00020\u0018H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006)"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/collaborator/invite/newinvite/bitablepro/BitableProInviteMemberManagerFragment;", "Lcom/bytedance/ee/bear/facade/common/BaseFragment;", "Lcom/bytedance/ee/bear/middleground/permission/collaborator/invite/newinvite/bitablepro/BitableProInviteMemberManagerPresenter$Dependency;", "<init>", "()V", "mPresenter", "Lcom/bytedance/ee/bear/middleground/permission/collaborator/invite/newinvite/bitablepro/BitableProInviteMemberManagerPresenter;", ResourceData.KEY_TOKEN, "", ResourceData.KEY_TYPE, "", "ownerId", "originUsers", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/share/export/UserInfo;", "Lkotlin/collections/ArrayList;", "roleId", "delegate", "Lcom/bytedance/ee/bear/middleground_permission_export/model/api/IShareUIService$IInviteMemberDelegate;", "getDelegate", "()Lcom/bytedance/ee/bear/middleground_permission_export/model/api/IShareUIService$IInviteMemberDelegate;", "setDelegate", "(Lcom/bytedance/ee/bear/middleground_permission_export/model/api/IShareUIService$IInviteMemberDelegate;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "initMVP", "rootView", "onDestroyView", "back", "finish", "Companion", "middleground-permission_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableProInviteMemberManagerFragment extends BaseFragment implements com.bytedance.ee.bear.middleground.permission.collaborator.invite.newinvite.bitablepro.a.b {
    public static final /* synthetic */ int l = 0;
    public com.bytedance.ee.bear.middleground.permission.collaborator.invite.newinvite.bitablepro.a e;
    public String f;
    public int g;
    public String h;
    public ArrayList<UserInfo> i;
    public String j;
    public c.a k;

    public static final class a {
    }

    static {
    }

    public BitableProInviteMemberManagerFragment() {
        this.f = "";
        this.g = e.i.b;
        this.h = "";
        this.i = new ArrayList();
        this.j = "";
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.invite.newinvite.bitablepro.a.b
    public final void back() {
        if (getParentFragment() != null) goto L5;
        return;
    L5:
        if ((getParentFragment() instanceof dh5.a) == false) goto L9;
        dh5.a r0 = getParentFragment();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.bytedance.ee.bear.middleground.permission.collaborator.search.newsearch.ISearchUserActDependency");
        r0.back();
        return;
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.invite.newinvite.bitablepro.a.b
    public final void finish() {
        if (getParentFragment() != null) goto L5;
        return;
    L5:
        if ((getParentFragment() instanceof dh5.a) == false) goto L9;
        dh5.a r0 = getParentFragment();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.bytedance.ee.bear.middleground.permission.collaborator.search.newsearch.ISearchUserActDependency");
        r0.finish();
        return;
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
        com.bytedance.ee.bear.middleground.permission.collaborator.invite.newinvite.bitablepro.a r0 = this.e;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mPresenter");
        r0 = null;
    L5:
        r0.destroy();
    }

    public final void onCreate(Bundle r4) {
        super.onCreate(r4);
        Bundle r5 = getArguments();
        String r0 = "";
        if (r5 == null) goto L6;
        String r6 = r5.getString("extra_token", "");
        if (r6 == null) goto L6;
    L7:
        this.f = r6;
        Bundle r7 = getArguments();
        if (r7 == null) goto L10;
        int r8 = r7.getInt("extra_type", this.g);
    L11:
        this.g = r8;
        Bundle r9 = getArguments();
        if (r9 == null) goto L15;
        String r10 = r9.getString("extra_owner_id", "");
        if (r10 == null) goto L15;
    L16:
        this.h = r10;
        Bundle r11 = getArguments();
        if (r11 == null) goto L19;
        Serializable r12 = r11.getSerializable("extra_users");
    L20:
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type java.util.ArrayList<com.bytedance.ee.bear.share.export.UserInfo>");
        this.i = (ArrayList) r12;
        Bundle r13 = getArguments();
        if (r13 == null) goto L26;
        String r14 = r13.getString("extra_role_id", "");
        if (r14 == null) goto L26;
        r0 = r14;
    L26:
        this.j = r0;
        return;
    L19:
        r12 = null;
    L15:
        r10 = "";
        goto L16
    L10:
        r8 = this.g;
    L6:
        r6 = "";
        goto L7
    }

    public final void onViewCreated(View r9, Bundle r10) {
        Intrinsics.checkNotNullParameter(r9, "view");
        super.onViewCreated(r9, r10);
        com.bytedance.ee.bear.middleground.permission.collaborator.invite.newinvite.bitablepro.a r11 = new com.bytedance.ee.bear.middleground.permission.collaborator.invite.newinvite.bitablepro.a(new ug5.a(ViewModelProviders.of(requireActivity()).get(InviteMemberViewModel.class), this.f, this.j, this.i, this.k), new ug5.c(requireContext(), r9, this.g, this.h), this, this.f, this.k);
        this.e = r11;
        r11.create();
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131564184, r3, false);
    }
}
