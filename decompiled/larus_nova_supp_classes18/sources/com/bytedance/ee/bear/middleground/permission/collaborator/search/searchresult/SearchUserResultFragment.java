package com.bytedance.ee.bear.middleground.permission.collaborator.search.searchresult;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.ee.bear.middleground.permission.collaborator.invite.InviteMemberParams;
import com.bytedance.ee.bear.middleground.permission.collaborator.search.InviteMemberViewModel;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import io.reactivex.Flowable;
import java.util.ArrayList;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 $2\u00020\u00012\u00020\u0002:\u0001$B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J&\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u001a\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020\u00192\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010 \u001a\u00020\u0015H\u0016J\u0010\u0010!\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020#H\u0016R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/collaborator/search/searchresult/SearchUserResultFragment;", "Lcom/bytedance/ee/bear/facade/common/BaseFragment;", "Lcom/bytedance/ee/bear/middleground/permission/collaborator/search/topbar/KeywordChangeListener;", "<init>", "()V", "originUsers", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/share/export/UserInfo;", "Lkotlin/collections/ArrayList;", "topStickUsers", "searchUserPresenter", "Lcom/bytedance/ee/bear/middleground/permission/collaborator/search/searchresult/SearchUserResultPresenter;", "from", "", "params", "Lcom/bytedance/ee/bear/middleground/permission/collaborator/invite/InviteMemberParams;", "hasReport", "", "viewModel", "Lcom/bytedance/ee/bear/middleground/permission/collaborator/search/InviteMemberViewModel;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "onDestroyView", "onKeywordChange", "keyword", "", "Companion", "middleground-permission_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SearchUserResultFragment extends BaseFragment implements gh5.b {
    public static final /* synthetic */ int k = 0;
    public final ArrayList<UserInfo> e;
    public ArrayList<UserInfo> f;
    public s g;
    public int h;
    public InviteMemberParams i;
    public InviteMemberViewModel j;

    public static final class a {
        public static SearchUserResultFragment a(ArrayList r2, ArrayList r3, int r4, InviteMemberParams r5) {
            Intrinsics.checkNotNullParameter(r2, "userInfoList");
            Intrinsics.checkNotNullParameter(r5, "params");
            Bundle r0 = new Bundle();
            r0.putParcelableArrayList("extra_origin_users", r2);
            r0.putParcelableArrayList("top_stick_users", r3);
            r0.putInt("extra_from", r4);
            r0.putParcelable("extra_params", r5);
            SearchUserResultFragment r6 = new SearchUserResultFragment();
            r6.setArguments(r0);
            return r6;
        }
    }

    static {
    }

    public SearchUserResultFragment() {
        this.e = new ArrayList();
        this.i = new InviteMemberParams(null, 0, null, null, null, false, false, false, false, false, false, false, null, null, false, false, false, false, false, false, false, null, 8388607);
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
        s r0 = this.g;
        if (r0 == null) goto L6;
        r0.destroy();
        return;
    }

    @Override // gh5.b
    public final void B2(String r18) {
        Intrinsics.checkNotNullParameter(r18, "keyword");
        s r3 = this.g;
        boolean r4 = false;
        if (r3 == null) goto L23;
        Intrinsics.checkNotNullParameter(r18, "keyword");
        tt5.a.h("SearchUserResultPresenter", "search()...keyword = " + du5.b.g(r18));
        r3.I8();
        ((b) r3.getView()).showLoading();
        if (r3.b.h == false) goto L20;
        EmailRegularConfig r0 = (EmailRegularConfig) com.bytedance.ee.bear.appsetting.c.a.a.c(EmailRegularConfig.KEY, EmailRegularConfig.class, new EmailRegularConfig());
        if (TextUtils.isEmpty(r0.getEmail_reg()) == true) goto L9;
        String r1 = r0.getEmail_reg();
        tt5.a.h("SearchUserResultPresenter", "isEmail()...emailRegular = " + r1);
    L47:
    L15:
        e = move-exception;
        tt5.a.d("SearchUserResultPresenter", "isEmail()...error = " + e);
    L17:
        boolean r2 = false;
    L18:
        if (r2 == false) goto L20;
        Flowable<String> r5 = ((com.bytedance.ee.bear.middleground.permission.collaborator.search.searchresult.a) r3.getModel()).Z5(r18);
    L21:
        r3.c = Flowable.zip(((com.bytedance.ee.bear.middleground.permission.collaborator.search.searchresult.a) r3.getModel()).R1(r18), r5, new v(r3, r18)).subscribe(new w(r3), new x(r3));
        goto L23
    L11:
        if (TextUtils.isEmpty(r18) == true) goto L17;
        if (Pattern.matches(r1, r18) == false) goto L17;
        r2 = true;
        goto L18
    L9:
        r1 = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$";
    L20:
        r5 = Flowable.just("");
        Intrinsics.checkNotNull(r5);
    L23:
        if (r18.length() <= 0) goto L25;
        r4 = true;
    L25:
        if (r4 == false) goto L49;
        int r6 = this.h;
        if (r6 != 1) goto L34;
        InviteMemberParams r7 = this.i;
        String r8 = r7.a;
        int r9 = r7.getType();
        InviteMemberParams r10 = this.i;
        String r11 = r10.d;
        boolean r12 = r10.i;
        String r13 = com.bytedance.ee.bear.middleground.permission.c.a;
        Intrinsics.checkNotNullParameter(r8, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r11, "subType");
        JSONObject r14 = new JSONObject();
        if (com.bytedance.ee.bear.middleground.permission.c.c == false) goto L31;
        String r15 = ThumbGlideUrl.SOURCE_VC;
    L32:
        com.bytedance.ee.bear.middleground.permission.c.a(r14, r8, r9, r15, r11, com.bytedance.ee.bear.middleground.permission.c.d, com.bytedance.ee.bear.middleground.permission.c.e, com.bytedance.ee.bear.middleground.permission.c.a, com.bytedance.ee.bear.middleground.permission.c.b, r12);
        com.bytedance.ee.bear.middleground.permission.c.c("ccm_permission_organization_authorize_search_view", r14);
        return;
    L31:
        r15 = "none";
        goto L32
    L34:
        if (r6 != 2) goto L40;
        InviteMemberParams r16 = this.i;
        String r17 = r16.a;
        int r19 = r16.getType();
        InviteMemberParams r20 = this.i;
        String r110 = r20.d;
        boolean r21 = r20.i;
        String r22 = com.bytedance.ee.bear.middleground.permission.c.a;
        Intrinsics.checkNotNullParameter(r17, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r110, "subType");
        JSONObject r23 = new JSONObject();
        if (com.bytedance.ee.bear.middleground.permission.c.c == false) goto L38;
        String r111 = ThumbGlideUrl.SOURCE_VC;
    L39:
        com.bytedance.ee.bear.middleground.permission.c.a(r23, r17, r19, r111, r110, com.bytedance.ee.bear.middleground.permission.c.d, com.bytedance.ee.bear.middleground.permission.c.e, com.bytedance.ee.bear.middleground.permission.c.a, com.bytedance.ee.bear.middleground.permission.c.b, r21);
        com.bytedance.ee.bear.middleground.permission.c.c("ccm_permission_dynamic_user_group_authorize_search_view", r23);
        return;
    L38:
        r111 = "none";
        goto L39
    L40:
        if (r6 != 0) goto L52;
        InviteMemberParams r24 = this.i;
        String r25 = r24.a;
        int r26 = r24.getType();
        InviteMemberParams r27 = this.i;
        String r112 = r27.d;
        boolean r28 = r27.i;
        String r29 = com.bytedance.ee.bear.middleground.permission.c.a;
        Intrinsics.checkNotNullParameter(r25, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r112, "subType");
        JSONObject r30 = new JSONObject();
        if (com.bytedance.ee.bear.middleground.permission.c.c == false) goto L44;
        String r113 = ThumbGlideUrl.SOURCE_VC;
    L45:
        com.bytedance.ee.bear.middleground.permission.c.a(r30, r25, r26, r113, r112, com.bytedance.ee.bear.middleground.permission.c.d, com.bytedance.ee.bear.middleground.permission.c.e, com.bytedance.ee.bear.middleground.permission.c.a, com.bytedance.ee.bear.middleground.permission.c.b, r28);
        com.bytedance.ee.bear.middleground.permission.c.c("ccm_permission_search_collaborator_view", r30);
        return;
    L44:
        r113 = "none";
        goto L45
    L52:
        return;
    }

    public final void onCreate(Bundle r27) {
        super.onCreate(r27);
        Bundle r1 = getArguments();
        ArrayList<UserInfo> r2 = null;
        if (r1 == null) goto L5;
        ArrayList r3 = r1.getParcelableArrayList("extra_origin_users");
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
        int r6 = 0;
        if (r5 == null) goto L14;
        r6 = r5.getInt("extra_from", 0);
    L14:
        this.h = r6;
        Bundle r7 = getArguments();
        if (r7 == null) goto L18;
        InviteMemberParams r8 = (InviteMemberParams) r7.getParcelable("extra_params");
        if (r8 == null) goto L18;
    L19:
        this.i = r8;
        this.j = (InviteMemberViewModel) ViewModelProviders.of(requireActivity()).get(InviteMemberViewModel.class);
        return;
    L18:
        r8 = new InviteMemberParams(null, 0, null, null, null, false, false, false, false, false, false, false, null, null, false, false, false, false, false, false, false, null, 8388607);
        goto L19
    L5:
        r3 = null;
        goto L6
    }

    public final void onViewCreated(View r11, Bundle r12) {
        Intrinsics.checkNotNullParameter(r11, "view");
        super.onViewCreated(r11, r12);
        dh5.b r13 = ViewModelProviders.of(requireActivity()).get(InviteMemberViewModel.class);
        s r14 = new s(new m(requireContext(), r13, this.i, this.f), new y(requireContext(), r11, this.e, this.i, this.j), this, this.i);
        this.g = r14;
        r14.create();
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131564188, r3, false);
    }
}
