package com.bytedance.ee.bear.bitable.share.invitemember.manager;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.ee.bear.bitable.share.BitableSharePermSetInfo;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.ee.bear.middleground.permission.collaborator.search.InviteMemberViewModel;
import com.bytedance.ee.bear.share.export.UserInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ou4.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001e2\u00020\u00012\u00020\u0002:\u0001\u001eB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J&\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u001a\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u00122\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0010\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u0012H\u0002J\b\u0010\u001b\u001a\u00020\u000eH\u0016J\b\u0010\u001c\u001a\u00020\u000eH\u0016J\b\u0010\u001d\u001a\u00020\u000eH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/bytedance/ee/bear/bitable/share/invitemember/manager/BitableShareInviteMemberManagerFragment;", "Lcom/bytedance/ee/bear/facade/common/BaseFragment;", "Lcom/bytedance/ee/bear/bitable/share/invitemember/manager/BitableShareInviteMemberManagerPresenter$Dependency;", "<init>", "()V", "mPermSetInfo", "Lcom/bytedance/ee/bear/bitable/share/BitableSharePermSetInfo;", "mPresenter", "Lcom/bytedance/ee/bear/bitable/share/invitemember/manager/BitableShareInviteMemberManagerPresenter;", "ownerInfo", "Lcom/bytedance/ee/bear/share/export/UserInfo;", "fromSharePanel", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "initMVP", "rootView", "onDestroyView", "back", "finish", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableShareInviteMemberManagerFragment extends BaseFragment implements com.bytedance.ee.bear.bitable.share.invitemember.manager.a.b {
    public static final /* synthetic */ int i = 0;
    public BitableSharePermSetInfo e;
    public com.bytedance.ee.bear.bitable.share.invitemember.manager.a f;
    public UserInfo g;
    public boolean h;

    public static final class a {
    }

    static {
    }

    public BitableShareInviteMemberManagerFragment() {
        this.e = new BitableSharePermSetInfo(0, null, 63);
    }

    @Override // com.bytedance.ee.bear.bitable.share.invitemember.manager.a.b
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

    @Override // com.bytedance.ee.bear.bitable.share.invitemember.manager.a.b
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
        super.onDestroyView();
        com.bytedance.ee.bear.bitable.share.invitemember.manager.a r0 = this.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mPresenter");
        r0 = null;
    L5:
        r0.destroy();
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment
    public final void onCreate(Bundle r4) {
        super.onCreate(r4);
        Bundle r5 = getArguments();
        UserInfo r0 = null;
        boolean r1 = false;
        if (r5 == null) goto L6;
        BitableSharePermSetInfo r6 = (BitableSharePermSetInfo) r5.getParcelable("extra_perm_set_info");
        if (r6 == null) goto L6;
    L7:
        this.e = r6;
        Bundle r7 = getArguments();
        if (r7 == null) goto L10;
        r0 = (UserInfo) r7.getParcelable("extra_owner_info");
    L10:
        this.g = r0;
        Bundle r8 = getArguments();
        if (r8 == null) goto L13;
        r1 = r8.getBoolean("from_share_panel", false);
    L13:
        this.h = r1;
        return;
    L6:
        r6 = new BitableSharePermSetInfo(0, null, 63);
        goto L7
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment
    public final void onViewCreated(View r7, Bundle r8) {
        Intrinsics.checkNotNullParameter(r7, "view");
        super.onViewCreated(r7, r8);
        ou4.a r1 = new ou4.a(ViewModelProviders.of(requireActivity()).get(InviteMemberViewModel.class), this.e);
        Context r9 = requireContext();
        BitableSharePermSetInfo r0 = this.e;
        UserInfo r3 = this.g;
        if (r3 == null) goto L6;
        String r4 = r3.getTenantId();
        if (r4 == null) goto L6;
    L7:
        com.bytedance.ee.bear.bitable.share.invitemember.manager.a r10 = new com.bytedance.ee.bear.bitable.share.invitemember.manager.a(r1, new c(r9, r7, r0, r4), this, this.e, this.h);
        this.f = r10;
        r10.create();
        return;
    L6:
        r4 = "";
        goto L7
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131564184, r3, false);
    }
}
