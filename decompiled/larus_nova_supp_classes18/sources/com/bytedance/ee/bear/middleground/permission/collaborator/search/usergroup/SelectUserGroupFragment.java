package com.bytedance.ee.bear.middleground.permission.collaborator.search.usergroup;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.ee.bear.facade.common.widget.MainViewPager;
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
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 $2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001$B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J&\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u001a\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u00162\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0010\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u0016H\u0002J\u0010\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020\u0012H\u0016J\b\u0010#\u001a\u00020\u0012H\u0016R\u001e\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/collaborator/search/usergroup/SelectUserGroupFragment;", "Lcom/bytedance/ee/bear/facade/common/BaseFragment;", "Lcom/bytedance/ee/bear/middleground/permission/collaborator/search/topbar/KeywordChangeListener;", "Lcom/bytedance/ee/bear/middleground/permission/collaborator/search/usergroup/SelectUserGroupPresenter$Dependency;", "<init>", "()V", "originUsers", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/share/export/UserInfo;", "Lkotlin/collections/ArrayList;", "params", "Lcom/bytedance/ee/bear/middleground/permission/collaborator/invite/InviteMemberParams;", "userGroupFragment", "Landroidx/fragment/app/Fragment;", "searchFragment", "presenter", "Lcom/bytedance/ee/bear/middleground/permission/collaborator/search/usergroup/SelectUserGroupPresenter;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "initMVP", "rootView", "onKeywordChange", "keyword", "", "jumpToNextPage", "onDestroyView", "Companion", "middleground-permission_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SelectUserGroupFragment extends BaseFragment implements gh5.b, c.a {
    public static final /* synthetic */ int j = 0;
    public final ArrayList<UserInfo> e;
    public InviteMemberParams f;
    public UserGroupFragment g;
    public SearchUserResultFragment h;
    public c i;

    public static final class a {
    }

    static {
    }

    public SelectUserGroupFragment() {
        this.e = new ArrayList();
        this.f = new InviteMemberParams(null, 0, null, null, null, false, false, false, false, false, false, false, null, null, false, false, false, false, false, false, false, null, 8388607);
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
        c r0 = this.i;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("presenter");
        r0 = null;
    L5:
        r0.destroy();
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.usergroup.c.a
    public final void v1() {
        View r0 = getView();
        if (r0 == null) goto L7;
        boolean r1 = true;
        if (r0.requestFocus() != true) goto L7;
    L8:
        if (r1 == false) goto L11;
        KeyboardUtils.hideKeyboard(getContext(), getView());
    L11:
        if (getParentFragment() != null) goto L13;
    L15:
        dh5.b r2 = ViewModelProviders.of(requireActivity()).get(InviteMemberViewModel.class);
        InviteMemberParams r3 = this.f;
        String r4 = r3.a;
        int r5 = r3.getType();
        InviteMemberParams r6 = this.f;
        String r7 = r6.d;
        boolean r11 = r6.i;
        ArrayList<UserInfo> r8 = r2.getSelected();
        String r12 = this.f.m;
        String r9 = com.bytedance.ee.bear.middleground.permission.c.a;
        Intrinsics.checkNotNullParameter(r4, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r7, "subType");
        Intrinsics.checkNotNullParameter(r8, "userInfoList");
        Intrinsics.checkNotNullParameter(r12, "target");
        JSONObject r14 = new JSONObject();
        if (com.bytedance.ee.bear.middleground.permission.c.c == false) goto L18;
        String r10 = ThumbGlideUrl.SOURCE_VC;
    L19:
        com.bytedance.ee.bear.middleground.permission.c.a(r14, r4, r5, r10, r7, com.bytedance.ee.bear.middleground.permission.c.d, com.bytedance.ee.bear.middleground.permission.c.e, com.bytedance.ee.bear.middleground.permission.c.a, com.bytedance.ee.bear.middleground.permission.c.b, r11);
        r14.put("click", "next");
        r14.put("target", r12);
        JSONArray r13 = new JSONArray();
        Iterator<UserInfo> r15 = r8.iterator();
    L21:
        if (r15.hasNext() == false) goto L23;
        UserInfo r16 = r15.next();
        JSONObject r17 = new JSONObject();
        r17.put("collaborate_type", r16.getOwnerType());
        r17.put("object_uid", du5.b.g(r16.getId()));
        r17.put("list_type", com.bytedance.ee.bear.middleground.permission.c.d(r5, r16.getPermission()));
        r13.put(r17);
        goto L21
    L23:
        r14.put("user_list", r13.toString());
        com.bytedance.ee.bear.middleground.permission.c.c("ccm_permission_dynamic_user_group_authorize_click", r14);
        return;
    L18:
        r10 = "none";
        goto L19
    L13:
        if ((getParentFragment() instanceof dh5.a) == false) goto L15;
        dh5.a r18 = getParentFragment();
        Intrinsics.checkNotNull(r18, "null cannot be cast to non-null type com.bytedance.ee.bear.middleground.permission.collaborator.search.newsearch.ISearchUserActDependency");
        r18.O50();
    L7:
        r1 = false;
        goto L8
    }

    @Override // gh5.b
    public final void B2(String r7) {
        Intrinsics.checkNotNullParameter(r7, "keyword");
        View r0 = getView();
        SearchUserResultFragment r2 = null;
        if (r0 == null) goto L5;
        MainViewPager r1 = r0.findViewById(2131382144);
    L6:
        boolean r3 = false;
        if (r1 != null) goto L9;
    L11:
        boolean r4 = false;
    L13:
        if (r7.length() != 0) goto L15;
        boolean r5 = true;
    L16:
        if (r5 == false) goto L25;
        if (r4 == true) goto L25;
        View r6 = getView();
        if (r6 == null) goto L21;
        MainViewPager r8 = (MainViewPager) r6.findViewById(2131382144);
    L22:
        if (r8 == null) goto L35;
        r8.setCurrentItem(0);
    L35:
        SearchUserResultFragment r9 = this.h;
        if (r9 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("searchFragment");
        r9 = null;
    L39:
        if ((r9 instanceof gh5.b) == false) goto L46;
        SearchUserResultFragment r10 = this.h;
        if (r10 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("searchFragment");
    L44:
        r2.B2(r7);
        return;
    L43:
        r2 = r10;
        goto L44
    L46:
        return;
    L21:
        r8 = null;
    L25:
        if (r7.length() <= 0) goto L27;
        r3 = true;
    L27:
        if (r3 == false) goto L35;
        if (r4 == false) goto L35;
        View r11 = getView();
        if (r11 == null) goto L32;
        MainViewPager r12 = (MainViewPager) r11.findViewById(2131382144);
    L33:
        if (r12 == null) goto L35;
        r12.setCurrentItem(1);
        goto L35
    L32:
        r12 = null;
        goto L33
    L15:
        r5 = false;
        goto L16
    L9:
        if (r1.getCurrentItem() != 0) goto L11;
        r4 = true;
        goto L13
    L5:
        r1 = null;
        goto L6
    }

    public final void onCreate(Bundle r27) {
        super.onCreate(r27);
        Bundle r1 = getArguments();
        if (r1 == null) goto L5;
        ArrayList r2 = r1.getParcelableArrayList("extra_origin_user");
    L6:
        if (r2 == null) goto L8;
        this.e.clear();
        this.e.addAll(r2);
    L8:
        Bundle r3 = getArguments();
        if (r3 == null) goto L12;
        InviteMemberParams r4 = (InviteMemberParams) r3.getParcelable("extra_params");
        if (r4 == null) goto L12;
    L13:
        this.f = r4;
        return;
    L12:
        r4 = new InviteMemberParams(null, 0, null, null, null, false, false, false, false, false, false, false, null, null, false, false, false, false, false, false, false, null, 8388607);
        goto L13
    L5:
        r2 = null;
        goto L6
    }

    public final void onViewCreated(View r14, Bundle r15) {
        Intrinsics.checkNotNullParameter(r14, "view");
        super.onViewCreated(r14, r15);
        String r16 = getString(2131887245);
        int r0 = TopbarFragment.k;
        TopbarFragment r17 = TopbarFragment.a.a(r16, 2, this.f);
        FragmentTransaction r1 = getChildFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r1, r17, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, null, 2131382149) == true) goto L6;
        r1 = r1.add(2131382149, r17);
    L6:
        r1.commitAllowingStateLoss();
        int r18 = UserGroupFragment.h;
        ArrayList<UserInfo> r19 = this.e;
        InviteMemberParams r2 = this.f;
        Intrinsics.checkNotNullParameter(r19, "userInfoList");
        Intrinsics.checkNotNullParameter(r2, "params");
        Bundle r3 = new Bundle();
        r3.putParcelableArrayList("extra_origin_users", r19);
        r3.putParcelable("extra_params", r2);
        UserGroupFragment r110 = new UserGroupFragment();
        r110.setArguments(r3);
        this.g = r110;
        int r111 = SearchUserResultFragment.k;
        this.h = SearchUserResultFragment.a.a(this.e, null, 2, this.f);
        MainViewPager r4 = r14.findViewById(2131382144);
        final FragmentManager r5 = getChildFragmentManager();
        r4.setAdapter(new AnonymousClass1(this, r5));
        r14.findViewById(2131382144).setCurrentItem(0);
        c r112 = new c(new hh5.d(ViewModelProviders.of(requireActivity()).get(InviteMemberViewModel.class)), new e(r14), this, requireContext());
        this.i = r112;
        r112.create();
        InviteMemberParams r113 = this.f;
        String r6 = r113.a;
        int r7 = r113.getType();
        InviteMemberParams r114 = this.f;
        String r8 = r114.d;
        boolean r9 = r114.i;
        String r115 = com.bytedance.ee.bear.middleground.permission.c.a;
        Intrinsics.checkNotNullParameter(r6, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r8, "subType");
        JSONObject r10 = new JSONObject();
        if (com.bytedance.ee.bear.middleground.permission.c.c == false) goto L9;
        String r11 = ThumbGlideUrl.SOURCE_VC;
    L10:
        com.bytedance.ee.bear.middleground.permission.c.a(r10, r6, r7, r11, r8, com.bytedance.ee.bear.middleground.permission.c.d, com.bytedance.ee.bear.middleground.permission.c.e, com.bytedance.ee.bear.middleground.permission.c.a, com.bytedance.ee.bear.middleground.permission.c.b, r9);
        com.bytedance.ee.bear.middleground.permission.c.c("ccm_permission_dynamic_user_group_authorize_view", r10);
        InviteMemberParams r12 = this.f;
        String r13 = r12.a;
        int r20 = r12.getType();
        InviteMemberParams r21 = this.f;
        String r22 = r21.d;
        boolean r116 = r21.i;
        Intrinsics.checkNotNullParameter(r13, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r22, "subType");
        JSONObject r117 = new JSONObject();
        if (com.bytedance.ee.bear.middleground.permission.c.c == false) goto L13;
        String r23 = ThumbGlideUrl.SOURCE_VC;
    L14:
        com.bytedance.ee.bear.middleground.permission.c.a(r117, r13, r20, r23, r22, com.bytedance.ee.bear.middleground.permission.c.d, com.bytedance.ee.bear.middleground.permission.c.e, com.bytedance.ee.bear.middleground.permission.c.a, com.bytedance.ee.bear.middleground.permission.c.b, r116);
        r117.put("user_group", "True");
        com.bytedance.ee.bear.middleground.permission.c.c("ccm_permission_add_collaborator_group_view", r117);
        return;
    L13:
        r23 = "none";
        goto L14
    L9:
        r11 = "none";
        goto L10
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131564191, r3, false);
    }
}
