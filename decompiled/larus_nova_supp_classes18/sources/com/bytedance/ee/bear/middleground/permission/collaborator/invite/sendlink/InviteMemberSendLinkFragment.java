package com.bytedance.ee.bear.middleground.permission.collaborator.invite.sendlink;

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
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001d2\u00020\u00012\u00020\u0002:\u0001\u001dB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J&\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u001a\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00102\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0017\u001a\u00020\fH\u0016J\b\u0010\u0018\u001a\u00020\fH\u0016J\b\u0010\u0019\u001a\u00020\fH\u0016J\b\u0010\u001a\u001a\u00020\fH\u0016J\u0010\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u0010H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/collaborator/invite/sendlink/InviteMemberSendLinkFragment;", "Lcom/bytedance/ee/bear/facade/common/BaseFragment;", "Lcom/bytedance/ee/bear/middleground/permission/collaborator/invite/sendlink/InviteMemberSendLinkPresenter$Dependency;", "<init>", "()V", "permSetInfo", "Lcom/bytedance/ee/bear/middleground_permission_export/model/permissionset/DocPermSetInfo;", "module", "", "presenter", "Lcom/bytedance/ee/bear/middleground/permission/collaborator/invite/sendlink/InviteMemberSendLinkPresenter;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "onDestroy", "back", "finish", "askOwner", "initMVP", "rootView", "Companion", "middleground-permission_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InviteMemberSendLinkFragment extends BaseFragment implements c.b {
    public static final /* synthetic */ int h = 0;
    public DocPermSetInfo e;
    public String f;
    public c g;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.invite.sendlink.c.b
    public final void Hr() {
        tt5.a.h("InviteMemberSendLinkFragment", "askOwner()...");
        if (getParentFragment() != null) goto L5;
        return;
    L5:
        if ((getParentFragment() instanceof dh5.a) == false) goto L9;
        dh5.a r0 = getParentFragment();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.bytedance.ee.bear.middleground.permission.collaborator.search.newsearch.ISearchUserActDependency");
        r0.jD();
        return;
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.invite.sendlink.c.b
    public final void back() {
        tt5.a.h("InviteMemberSendLinkFragment", "back()...");
        if (getParentFragment() != null) goto L5;
        return;
    L5:
        if ((getParentFragment() instanceof dh5.a) == false) goto L9;
        dh5.a r0 = getParentFragment();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.bytedance.ee.bear.middleground.permission.collaborator.search.newsearch.ISearchUserActDependency");
        r0.back();
        return;
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.invite.sendlink.c.b
    public final void finish() {
        tt5.a.h("InviteMemberSendLinkFragment", "finish()...");
        if (getParentFragment() != null) goto L5;
        return;
    L5:
        if ((getParentFragment() instanceof dh5.a) == false) goto L9;
        dh5.a r0 = getParentFragment();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.bytedance.ee.bear.middleground.permission.collaborator.search.newsearch.ISearchUserActDependency");
        r0.finish();
        return;
    }

    public InviteMemberSendLinkFragment() {
        this.e = new DocPermSetInfo(null, 0, null, false, null, null, null, false, false, false, 2047);
    }

    public final void onDestroy() {
        super.onDestroy();
        tt5.a.h("InviteMemberSendLinkFragment", "onDestroy()...");
        c r0 = this.g;
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
        String r17 = r16.getString("permission_module");
        if (r17 == null) goto L11;
    L12:
        this.f = r17;
        return;
    L11:
        r17 = "";
    L6:
        r15 = new DocPermSetInfo(null, 0, null, false, null, null, null, false, false, false, 2047);
        goto L7
    }

    public final void onViewCreated(View r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r8, "view");
        super.onViewCreated(r8, r9);
        tt5.a.h("InviteMemberSendLinkFragment", "initMVP()...");
        FragmentActivity r10 = getActivity();
        Intrinsics.checkNotNull(r10);
        dh5.b r11 = ViewModelProviders.of(r10).get(InviteMemberViewModel.class);
        Context r0 = getContext();
        Intrinsics.checkNotNull(r0);
        d r1 = new d(r0, r8, this.e.getType());
        b r2 = new b(r11, this.e);
        Context r3 = getContext();
        Intrinsics.checkNotNull(r3);
        DocPermSetInfo r5 = this.e;
        String r12 = this.f;
        if (r12 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("module");
        r12 = null;
    L5:
        c r13 = new c(r1, r2, r3, this, r5, r12);
        this.g = r13;
        r13.create();
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131564185, r3, false);
    }
}
