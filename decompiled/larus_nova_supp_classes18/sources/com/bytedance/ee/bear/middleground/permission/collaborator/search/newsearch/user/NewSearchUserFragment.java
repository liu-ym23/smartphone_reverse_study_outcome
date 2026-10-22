package com.bytedance.ee.bear.middleground.permission.collaborator.search.newsearch.user;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.ee.bear.middleground.permission.collaborator.invite.InviteMemberParams;
import com.bytedance.ee.bear.middleground.permission.collaborator.search.InviteMemberViewModel;
import com.bytedance.ee.bear.middleground.permission.collaborator.search.searchresult.SearchUserResultFragment;
import com.bytedance.ee.bear.middleground.permission.collaborator.search.topbar.TopbarFragment;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.larksuite.framework.utils.KeyboardUtils;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 &2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001&B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J&\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u001a\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u00162\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0010\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u0016H\u0002J\b\u0010\u001e\u001a\u00020\u0012H\u0016J\u0010\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020\u0012H\u0016J\b\u0010#\u001a\u00020\u0012H\u0016J\b\u0010$\u001a\u00020\u0012H\u0016J\b\u0010%\u001a\u00020\u0012H\u0002R\u001e\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/collaborator/search/newsearch/user/NewSearchUserFragment;", "Lcom/bytedance/ee/bear/facade/common/BaseFragment;", "Lcom/bytedance/ee/bear/middleground/permission/collaborator/search/topbar/KeywordChangeListener;", "Lcom/bytedance/ee/bear/middleground/permission/collaborator/search/newsearch/user/NewSearchUserPresenter$Dependency;", "<init>", "()V", "originUsers", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/share/export/UserInfo;", "Lkotlin/collections/ArrayList;", "topStickUsers", "presenter", "Lcom/bytedance/ee/bear/middleground/permission/collaborator/search/newsearch/user/NewSearchUserPresenter;", "searchUserResultFragment", "Landroidx/fragment/app/Fragment;", "inviteMemberParams", "Lcom/bytedance/ee/bear/middleground/permission/collaborator/invite/InviteMemberParams;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "initMVP", "onDestroyView", "onKeywordChange", "keyword", "", "jumpToSelectedUserGroup", "jumpToSelectedDep", "jumpToNextPage", "hideKeyboard", "Companion", "middleground-permission_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NewSearchUserFragment extends BaseFragment implements gh5.b, b.InterfaceC0099b {
    public static final /* synthetic */ int j = 0;
    public final ArrayList<UserInfo> e;
    public ArrayList<UserInfo> f;
    public b g;
    public SearchUserResultFragment h;
    public InviteMemberParams i;

    public static final class a {
    }

    static {
    }

    public NewSearchUserFragment() {
        this.e = new ArrayList();
        this.i = new InviteMemberParams(null, 0, null, null, null, false, false, false, false, false, false, false, null, null, false, false, false, false, false, false, false, null, 8388607);
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.newsearch.user.b.InterfaceC0099b
    public final void Az() {
        hideKeyboard();
        if (getParentFragment() != null) goto L5;
    L7:
        InviteMemberParams r0 = this.i;
        String r1 = r0.a;
        int r2 = r0.getType();
        InviteMemberParams r3 = this.i;
        String r4 = r3.d;
        boolean r5 = r3.i;
        String r6 = com.bytedance.ee.bear.middleground.permission.c.a;
        Intrinsics.checkNotNullParameter(r1, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r4, "subType");
        com.bytedance.ee.bear.middleground.permission.c.e(r1, r2, r4, r5, "organization", "ccm_permission_organization_authorize_view");
        return;
    L5:
        if ((getParentFragment() instanceof dh5.a) == false) goto L7;
        dh5.a r7 = getParentFragment();
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type com.bytedance.ee.bear.middleground.permission.collaborator.search.newsearch.ISearchUserActDependency");
        r7.bE();
        goto L7
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.newsearch.user.b.InterfaceC0099b
    public final void bk() {
        hideKeyboard();
        if (getParentFragment() != null) goto L5;
    L7:
        InviteMemberParams r0 = this.i;
        String r1 = r0.a;
        int r2 = r0.getType();
        InviteMemberParams r3 = this.i;
        String r4 = r3.d;
        boolean r5 = r3.i;
        String r6 = com.bytedance.ee.bear.middleground.permission.c.a;
        Intrinsics.checkNotNullParameter(r1, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r4, "subType");
        com.bytedance.ee.bear.middleground.permission.c.e(r1, r2, r4, r5, "dynamic_user_group", "ccm_permission_dynamic_user_group_authorize_view");
        return;
    L5:
        if ((getParentFragment() instanceof dh5.a) == false) goto L7;
        dh5.a r7 = getParentFragment();
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type com.bytedance.ee.bear.middleground.permission.collaborator.search.newsearch.ISearchUserActDependency");
        r7.qE();
        goto L7
    }

    public final void hideKeyboard() {
        View r0 = getView();
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        if (r1 == false) goto L10;
        KeyboardUtils.hideKeyboard(getContext(), getView());
        return;
    L10:
        return;
    L5:
        if (r0.requestFocus() != true) goto L7;
        r1 = true;
        goto L7
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
        b r0 = this.g;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("presenter");
        r0 = null;
    L5:
        r0.destroy();
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.newsearch.user.b.InterfaceC0099b
    public final void v1() {
        hideKeyboard();
        if (getParentFragment() != null) goto L5;
    L7:
        dh5.b r0 = ViewModelProviders.of(requireActivity()).get(InviteMemberViewModel.class);
        InviteMemberParams r1 = this.i;
        String r3 = r1.a;
        int r2 = r1.getType();
        InviteMemberParams r4 = this.i;
        String r6 = r4.d;
        boolean r11 = r4.i;
        ArrayList<UserInfo> r5 = r0.getSelected();
        String r12 = this.i.m;
        String r7 = com.bytedance.ee.bear.middleground.permission.c.a;
        Intrinsics.checkNotNullParameter(r3, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r6, "subType");
        Intrinsics.checkNotNullParameter(r5, "userInfoList");
        Intrinsics.checkNotNullParameter(r12, "target");
        JSONObject r14 = new JSONObject();
        if (com.bytedance.ee.bear.middleground.permission.c.c == false) goto L10;
        String r8 = ThumbGlideUrl.SOURCE_VC;
    L11:
        com.bytedance.ee.bear.middleground.permission.c.a(r14, r3, r2, r8, r6, com.bytedance.ee.bear.middleground.permission.c.d, com.bytedance.ee.bear.middleground.permission.c.e, com.bytedance.ee.bear.middleground.permission.c.a, com.bytedance.ee.bear.middleground.permission.c.b, r11);
        r14.put("click", "next");
        r14.put("num", r5.size());
        r14.put("target", r12);
        JSONArray r9 = new JSONArray();
        Iterator<UserInfo> r10 = r5.iterator();
    L13:
        if (r10.hasNext() == false) goto L15;
        UserInfo r13 = r10.next();
        JSONObject r15 = new JSONObject();
        r15.put("collaborate_type", r13.getOwnerType());
        r15.put("object_uid", du5.b.g(r13.getId()));
        r15.put("list_type", com.bytedance.ee.bear.middleground.permission.c.d(r2, r13.getPermission()));
        r9.put(r15);
        goto L13
    L15:
        r14.put("user_list", r9.toString());
        com.bytedance.ee.bear.middleground.permission.c.c("ccm_permission_add_collaborator_click", r14);
        return;
    L10:
        r8 = "none";
        goto L11
    L5:
        if ((getParentFragment() instanceof dh5.a) == false) goto L7;
        dh5.a r16 = getParentFragment();
        Intrinsics.checkNotNull(r16, "null cannot be cast to non-null type com.bytedance.ee.bear.middleground.permission.collaborator.search.newsearch.ISearchUserActDependency");
        r16.O50();
        goto L7
    }

    @Override // gh5.b
    public final void B2(String r5) {
        Intrinsics.checkNotNullParameter(r5, "keyword");
        SearchUserResultFragment r1 = this.h;
        b r3 = null;
        if (r1 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("searchUserResultFragment");
        r1 = null;
    L6:
        if ((r1 instanceof gh5.b) == false) goto L11;
        SearchUserResultFragment r2 = this.h;
        if (r2 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("searchUserResultFragment");
        r2 = null;
    L10:
        r2.B2(r5);
    L11:
        b r4 = this.g;
        if (r4 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("presenter");
    L15:
        r3.getClass();
        Intrinsics.checkNotNullParameter(r5, "keyword");
        if (r5.length() != 0) goto L18;
        boolean r6 = true;
    L19:
        if (r6 == false) goto L21;
        ((com.bytedance.ee.bear.middleground.permission.collaborator.search.newsearch.user.a) r3.getView()).Y0();
        return;
    L21:
        ((com.bytedance.ee.bear.middleground.permission.collaborator.search.newsearch.user.a) r3.getView()).s1();
        return;
    L18:
        r6 = false;
        goto L19
    L14:
        r3 = r4;
        goto L15
    }

    public final void onCreate(Bundle r27) {
        super.onCreate(r27);
        Bundle r1 = getArguments();
        ArrayList<UserInfo> r2 = null;
        if (r1 == null) goto L5;
        ArrayList r3 = r1.getParcelableArrayList("extra_origin_user");
    L6:
        if (r3 == null) goto L8;
        this.e.clear();
        this.e.addAll(r3);
    L8:
        Bundle r4 = getArguments();
        if (r4 == null) goto L11;
        r2 = r4.getParcelableArrayList("top_stick_users");
    L11:
        this.f = r2;
        Bundle r5 = getArguments();
        if (r5 == null) goto L15;
        InviteMemberParams r6 = (InviteMemberParams) r5.getParcelable("extra_params");
        if (r6 == null) goto L15;
    L16:
        this.i = r6;
        return;
    L15:
        r6 = new InviteMemberParams(null, 0, null, null, null, false, false, false, false, false, false, false, null, null, false, false, false, false, false, false, false, null, 8388607);
        goto L16
    L5:
        r3 = null;
        goto L6
    }

    public final void onViewCreated(View r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r8, "view");
        super.onViewCreated(r8, r9);
        if (Intrinsics.areEqual(this.i.e, ThumbGlideUrl.SOURCE_TEMPLATE) == false) goto L5;
        String r10 = getString(2131887979);
    L8:
        Intrinsics.checkNotNull(r10);
        int r0 = TopbarFragment.k;
        TopbarFragment r11 = TopbarFragment.a.a(r10, 0, this.i);
        FragmentTransaction r1 = getChildFragmentManager().beginTransaction();
        LandscapeRestrictionOperation r2 = LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD;
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r1, r11, r2, null, 2131382143) == true) goto L12;
        r1 = r1.add(2131382143, r11);
    L12:
        r1.commitAllowingStateLoss();
        int r12 = SearchUserResultFragment.k;
        this.h = SearchUserResultFragment.a.a(this.e, this.f, 0, this.i);
        FragmentTransaction r13 = getChildFragmentManager().beginTransaction();
        Fragment r3 = this.h;
        if (r3 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("searchUserResultFragment");
        r3 = null;
    L16:
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r13, r3, r2, null, 2131382138) == true) goto L19;
        r13 = r13.add(2131382138, r3);
    L19:
        r13.commitAllowingStateLoss();
        fh5.b r4 = new fh5.b(ViewModelProviders.of(requireActivity()).get(InviteMemberViewModel.class));
        c r5 = new c(r8, this.i.f);
        FragmentActivity r6 = requireActivity();
        InviteMemberParams r14 = this.i;
        b r15 = new b(r4, r5, this, r6, r14.g, r14.u);
        this.g = r15;
        r15.create();
        return;
    L5:
        r10 = this.i.n;
        if (r10 != null) goto L8;
        r10 = getString(2131888220);
        goto L8
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131564187, r3, false);
    }
}
