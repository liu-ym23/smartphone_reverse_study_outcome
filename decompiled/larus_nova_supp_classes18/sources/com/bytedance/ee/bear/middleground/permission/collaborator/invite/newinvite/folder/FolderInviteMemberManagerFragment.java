package com.bytedance.ee.bear.middleground.permission.collaborator.invite.newinvite.folder;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.ee.bear.middleground.permission.collaborator.search.InviteMemberViewModel;
import com.bytedance.ee.bear.middleground_permission_export.model.permissionset.FolderPermSetInfo;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.ss.android.lark.insets.WindowInsetsUtils;
import com.ss.android.lark.insets.f;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import xg5.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000  2\u00020\u00012\u00020\u0002:\u0001 B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J&\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u001a\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u00142\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0010\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u0014H\u0002J\b\u0010\u001d\u001a\u00020\u0010H\u0016J\b\u0010\u001e\u001a\u00020\u0010H\u0016J\b\u0010\u001f\u001a\u00020\u0010H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/collaborator/invite/newinvite/folder/FolderInviteMemberManagerFragment;", "Lcom/bytedance/ee/bear/facade/common/BaseFragment;", "Lcom/bytedance/ee/bear/middleground/permission/collaborator/invite/newinvite/folder/FolderInviteMemberManagerPresenter$Dependency;", "<init>", "()V", "permSetInfo", "Lcom/bytedance/ee/bear/middleground_permission_export/model/permissionset/FolderPermSetInfo;", "presenter", "Lcom/bytedance/ee/bear/middleground/permission/collaborator/invite/newinvite/folder/FolderInviteMemberManagerPresenter;", "module", "", "ownerInfo", "Lcom/bytedance/ee/bear/share/export/UserInfo;", "fromSharePanel", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "initFolderMVP", "rootView", "onDestroyView", "back", "finish", "Companion", "middleground-permission_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FolderInviteMemberManagerFragment extends BaseFragment implements com.bytedance.ee.bear.middleground.permission.collaborator.invite.newinvite.folder.a.b {
    public static final /* synthetic */ int i = 0;
    public FolderPermSetInfo e;
    public com.bytedance.ee.bear.middleground.permission.collaborator.invite.newinvite.folder.a f;
    public String g;
    public boolean h;

    public static final class a {
    }

    static {
    }

    public FolderInviteMemberManagerFragment() {
        this.e = new FolderPermSetInfo(0, null, null, 8191);
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.invite.newinvite.folder.a.b
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

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.invite.newinvite.folder.a.b
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
        com.bytedance.ee.bear.middleground.permission.collaborator.invite.newinvite.folder.a r0 = this.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("presenter");
        r0 = null;
    L5:
        r0.destroy();
    }

    public final void onCreate(Bundle r4) {
        super.onCreate(r4);
        Bundle r5 = getArguments();
        boolean r0 = false;
        if (r5 == null) goto L6;
        FolderPermSetInfo r6 = (FolderPermSetInfo) r5.getParcelable("extra_perm_set_info");
        if (r6 == null) goto L6;
    L7:
        this.e = r6;
        Bundle r7 = getArguments();
        String r1 = "";
        if (r7 == null) goto L13;
        String r8 = r7.getString("extra_module", "");
        if (r8 == null) goto L13;
        r1 = r8;
    L13:
        this.g = r1;
        Bundle r9 = getArguments();
        if (r9 == null) goto L16;
        UserInfo r10 = (UserInfo) r9.getParcelable("extra_owner_info");
    L16:
        Bundle r11 = getArguments();
        if (r11 == null) goto L19;
        r0 = r11.getBoolean("from_share_panel", false);
    L19:
        this.h = r0;
        return;
    L6:
        r6 = new FolderPermSetInfo(0, null, null, 8191);
        goto L7
    }

    public final void onViewCreated(View r9, Bundle r10) {
        Intrinsics.checkNotNullParameter(r9, "view");
        super.onViewCreated(r9, r10);
        f r11 = WindowInsetsUtils.b(this);
        r11.o(true);
        r11.f(true);
        r11.r(true);
        xg5.a r2 = new xg5.a(ViewModelProviders.of(requireActivity()).get(InviteMemberViewModel.class), this.e);
        c r3 = new c(requireContext(), r9, this.e);
        FragmentActivity r1 = requireActivity();
        FolderPermSetInfo r5 = this.e;
        String r12 = this.g;
        if (r12 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("module");
        r12 = null;
    L5:
        com.bytedance.ee.bear.middleground.permission.collaborator.invite.newinvite.folder.a r13 = new com.bytedance.ee.bear.middleground.permission.collaborator.invite.newinvite.folder.a(r1, r2, r3, this, r5, r12, this.h);
        this.f = r13;
        r13.create();
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131564184, r3, false);
    }
}
