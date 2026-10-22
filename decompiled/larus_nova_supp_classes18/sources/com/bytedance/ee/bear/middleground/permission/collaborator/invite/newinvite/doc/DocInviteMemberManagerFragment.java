package com.bytedance.ee.bear.middleground.permission.collaborator.invite.newinvite.doc;

import android.content.Context;
import android.content.res.Configuration;
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
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.bytedance.ee.util.ui.l;
import com.ss.android.lark.insets.WindowInsetsUtils;
import com.ss.android.lark.insets.f;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vg5.g;
import wg5.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 '2\u00020\u00012\u00020\u0002:\u0001'B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J&\u0010\u0015\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u001a\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0010\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u0010H\u0002J\u0010\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u0010H\u0002J\u0010\u0010\u001f\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u0010H\u0002J\b\u0010 \u001a\u00020\u0012H\u0016J\b\u0010!\u001a\u00020\u0012H\u0016J\b\u0010\"\u001a\u00020\u0012H\u0016J\u0010\u0010#\u001a\u00020\u00122\u0006\u0010$\u001a\u00020%H\u0016J\u0010\u0010&\u001a\u00020\u00122\u0006\u0010$\u001a\u00020%H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/collaborator/invite/newinvite/doc/DocInviteMemberManagerFragment;", "Lcom/bytedance/ee/bear/facade/common/BaseFragment;", "Lcom/bytedance/ee/bear/middleground/permission/collaborator/invite/newinvite/doc/DocInviteMemberManagerPresenter$Dependency;", "<init>", "()V", "permSetInfo", "Lcom/bytedance/ee/bear/middleground_permission_export/model/permissionset/DocPermSetInfo;", "presenter", "Lcom/bytedance/ee/bear/middleground/permission/collaborator/invite/newinvite/doc/DocInviteMemberManagerPresenter;", "module", "", "ownerInfo", "Lcom/bytedance/ee/bear/share/export/UserInfo;", "fromSharePanel", "", "contentView", "Landroid/view/View;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "initMVP", "rootView", "initDocMVP", "initTemplateMVP", "onDestroyView", "back", "finish", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "adjustContentBackground", "Companion", "middleground-permission_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocInviteMemberManagerFragment extends BaseFragment implements com.bytedance.ee.bear.middleground.permission.collaborator.invite.newinvite.doc.a.b {
    public static final /* synthetic */ int k = 0;
    public DocPermSetInfo e;
    public com.bytedance.ee.bear.middleground.permission.collaborator.invite.newinvite.doc.a f;
    public String g;
    public UserInfo h;
    public boolean i;
    public View j;

    public static final class a {
    }

    static {
    }

    public DocInviteMemberManagerFragment() {
        this.e = new DocPermSetInfo(null, 0, null, false, null, null, null, false, false, false, 2047);
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.invite.newinvite.doc.a.b
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

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.invite.newinvite.doc.a.b
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
        com.bytedance.ee.bear.middleground.permission.collaborator.invite.newinvite.doc.a r0 = this.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("presenter");
        r0 = null;
    L5:
        r0.destroy();
    }

    public final void U90(Configuration r3) {
        View r0 = this.j;
        if (r0 == null) goto L12;
        int r4 = r3.orientation;
        if (2 != r4) goto L8;
        r0.setBackgroundResource(2131235325);
    L10:
        l.b(r0, 2131100548);
        return;
    L8:
        if (1 != r4) goto L10;
        r0.setBackgroundResource(2131235305);
        goto L10
    }

    public final void onConfigurationChanged(Configuration r2) {
        Intrinsics.checkNotNullParameter(r2, "newConfig");
        super/*androidx.fragment.app.Fragment*/.onConfigurationChanged(r2);
        U90(r2);
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
        String r0 = "";
        if (r16 == null) goto L13;
        String r17 = r16.getString("extra_module", "");
        if (r17 == null) goto L13;
        r0 = r17;
    L13:
        this.g = r0;
        Bundle r18 = getArguments();
        if (r18 == null) goto L16;
        UserInfo r19 = (UserInfo) r18.getParcelable("extra_owner_info");
    L17:
        this.h = r19;
        Bundle r110 = getArguments();
        boolean r1 = false;
        if (r110 == null) goto L20;
        r1 = r110.getBoolean("from_share_panel", false);
    L20:
        this.i = r1;
        return;
    L16:
        r19 = null;
    L6:
        r15 = new DocPermSetInfo(null, 0, null, false, null, null, null, false, false, false, 2047);
        goto L7
    }

    public final void onViewCreated(View r12, Bundle r13) {
        Intrinsics.checkNotNullParameter(r12, "view");
        super.onViewCreated(r12, r13);
        f r14 = WindowInsetsUtils.b(this);
        r14.o(true);
        r14.f(true);
        r14.r(true);
        String r15 = this.g;
        if (r15 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("module");
        r15 = null;
    L6:
        if (Intrinsics.areEqual(r15, ThumbGlideUrl.SOURCE_TEMPLATE) == false) goto L12;
        FragmentActivity r16 = getActivity();
        Intrinsics.checkNotNull(r16);
        wg5.a r4 = new wg5.a(ViewModelProviders.of(r16).get(InviteMemberViewModel.class), this.e);
        Context r17 = getContext();
        Intrinsics.checkNotNull(r17);
        b r5 = new b(r17, r12, this.e);
        FragmentActivity r3 = getActivity();
        Intrinsics.checkNotNull(r3);
        DocPermSetInfo r7 = this.e;
        String r18 = this.g;
        if (r18 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("module");
        String r8 = null;
    L11:
        com.bytedance.ee.bear.middleground.permission.collaborator.invite.newinvite.doc.a r19 = new com.bytedance.ee.bear.middleground.permission.collaborator.invite.newinvite.doc.a(r3, r4, r5, this, r7, r8, this.h, this.i);
        this.f = r19;
        r19.create();
        return;
    L10:
        r8 = r18;
        goto L11
    L12:
        FragmentActivity r110 = getActivity();
        Intrinsics.checkNotNull(r110);
        vg5.a r6 = new vg5.a(ViewModelProviders.of(r110).get(InviteMemberViewModel.class), this.e);
        Context r111 = getContext();
        Intrinsics.checkNotNull(r111);
        g r9 = new g(r111, r12, this.e);
        FragmentActivity r10 = getActivity();
        Intrinsics.checkNotNull(r10);
        DocPermSetInfo r11 = this.e;
        String r112 = this.g;
        if (r112 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("module");
        String r20 = null;
    L16:
        com.bytedance.ee.bear.middleground.permission.collaborator.invite.newinvite.doc.a r113 = new com.bytedance.ee.bear.middleground.permission.collaborator.invite.newinvite.doc.a(r10, r6, r9, this, r11, r20, this.h, this.i);
        this.f = r113;
        r113.create();
        return;
    L15:
        r20 = r112;
        goto L16
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        this.j = r2.inflate(2131564184, r3, false);
        U90(getResources().getConfiguration());
        return this.j;
    }
}
