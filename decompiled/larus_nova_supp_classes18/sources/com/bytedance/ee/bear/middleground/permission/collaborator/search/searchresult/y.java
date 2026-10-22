package com.bytedance.ee.bear.middleground.permission.collaborator.search.searchresult;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.contract.i0;
import com.bytedance.ee.bear.facade.common.widget.recyclerview.LinearLayoutManagerWrapper;
import com.bytedance.ee.bear.facade.common.widget.recyclerview.LoadMoreFooter;
import com.bytedance.ee.bear.middleground.permission.collaborator.invite.InviteMemberParams;
import com.bytedance.ee.bear.middleground.permission.collaborator.invite.existmember.Member;
import com.bytedance.ee.bear.middleground.permission.collaborator.search.InviteMemberViewModel;
import com.bytedance.ee.bear.middleground.permission.collaborator.search.SearchUserResult;
import com.bytedance.ee.bear.middleground.permission.external.AdjustExternalResult;
import com.bytedance.ee.bear.middleground.permission.external.SceneType;
import com.bytedance.ee.bear.middleground.permission.permission.doc.DocPublicPermission;
import com.bytedance.ee.bear.middleground.permission.secret.SecretApprovalDefModel;
import com.bytedance.ee.bear.secret.SecretApprovalInstanceModel;
import com.bytedance.ee.bear.secret.SecretLevel;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.larksuite.framework.mvp.IView;
import io.reactivex.disposables.Disposable;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class y implements b, gqa.b, th5.a {
    public final Context a;
    public final View b;
    public final ArrayList<UserInfo> c;
    public final InviteMemberParams d;
    public final InviteMemberViewModel e;
    public b.a f;
    public SearchUserResultAdapter g;

    public static final class a {
    }

    static {
    }

    public final void create() {
        SearchUserResultAdapter r0 = new SearchUserResultAdapter(this.a, ((i0) org.koin.java.a.c(i0.class, null, null, 6)).c(), ((h0) org.koin.java.a.c(h0.class, null, null, 6)).G2(), this.d, this.e);
        this.g = r0;
        ArrayList<UserInfo> r3 = this.c;
        ((ArrayList) r0.d).clear();
        if (r3 != null) goto L5;
    L7:
        SearchUserResultAdapter r1 = this.g;
        if (r1 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("searchUserAdapter");
        r1 = null;
    L10:
        r1.isUseEmpty(true);
        SearchUserResultAdapter r2 = this.g;
        if (r2 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("searchUserAdapter");
        r2 = null;
    L13:
        TextView r4 = new TextView(this.a);
        r4.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        r4.setGravity(17);
        r4.setTextSize(18.0f);
        r4.setTextColor(this.a.getResources().getColor(2131103456));
        r4.setText(2131888232);
        r2.setEmptyView(r4);
        SearchUserResultAdapter r5 = this.g;
        if (r5 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("searchUserAdapter");
        r5 = null;
    L16:
        r5.g = new z(this);
        RecyclerView r6 = this.b.findViewById(2131382134);
        RecyclerView.Adapter r7 = this.g;
        if (r7 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("searchUserAdapter");
        r7 = null;
    L19:
        r6.setAdapter(r7);
        this.b.findViewById(2131382134).setLayoutManager(new LinearLayoutManagerWrapper(this.a));
        this.b.findViewById(2131382134).addOnScrollListener(new SearchUserResultView$initRecyclerView$2());
        this.b.findViewById(2131382137).F(new LoadMoreFooter(this.a), -2);
        this.b.findViewById(2131382137).i(this);
        d0(false);
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa().getClass();
        jg5.j.j = new WeakReference(this);
        return;
    L5:
        if (r3.size() <= 0) goto L7;
        ((ArrayList) r0.d).addAll(r3);
        goto L7
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.searchresult.b
    public final void d6() {
        this.b.findViewById(2131382137).s();
    }

    public final void destroy() {
        SearchUserResultAdapter r0 = this.g;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("searchUserAdapter");
        r0 = null;
    L5:
        Disposable r2 = r0.l;
        if (r2 != null) goto L8;
    L10:
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa().getClass();
        jg5.j.j = null;
        return;
    L8:
        if (r2.isDisposed() == true) goto L10;
        r0.l.dispose();
        goto L10
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.searchresult.b
    public final void hideLoading() {
        this.b.findViewById(2131382137).setVisibility(0);
        this.b.findViewById(2131382135).cancelAnimation();
        this.b.findViewById(2131382135).setVisibility(8);
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.searchresult.b
    public final void showLoading() {
        this.b.findViewById(2131382137).setVisibility(8);
        this.b.findViewById(2131382135).setVisibility(0);
        this.b.findViewById(2131382135).playAnimation();
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.searchresult.b
    public final void F4(SearchUserResult r6) {
        Intrinsics.checkNotNullParameter(r6, "result");
        SearchUserResultAdapter r0 = this.g;
        SearchUserResultAdapter r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("searchUserAdapter");
        r0 = null;
    L5:
        List<Member> r3 = r6.existMembers;
        ((ArrayList) r0.f).clear();
        if (hu5.a.f(r3) == false) goto L8;
        ((ArrayList) r0.f).addAll(r3);
    L8:
        SearchUserResultAdapter r2 = this.g;
        if (r2 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("searchUserAdapter");
    L12:
        r1.setNewData(r6.list);
        return;
    L11:
        r1 = r2;
        goto L12
    }

    public final void O0(cqa.h r2) {
        Intrinsics.checkNotNullParameter(r2, "refreshlayout");
        b.a r3 = this.f;
        if (r3 == null) goto L6;
        r3.onLoadMore();
        return;
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.searchresult.b
    public final void d0(boolean r3) {
        this.b.findViewById(2131382137).s();
        this.b.findViewById(2131382137).g(r3);
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.searchresult.b
    public final void i(UserInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "userInfo");
        SearchUserResultAdapter r0 = this.g;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("searchUserAdapter");
        r0 = null;
    L5:
        r0.H2(r2);
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.searchresult.b
    public final void l(UserInfo r3) {
        Intrinsics.checkNotNullParameter(r3, "userInfo");
        SearchUserResultAdapter r0 = this.g;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("searchUserAdapter");
        r0 = null;
    L6:
        if (((ArrayList) r0.e).contains(r3) == true) goto L9;
        ((ArrayList) r0.e).add(r3);
        r0.notifyDataSetChanged();
        return;
    }

    @Override // th5.a
    public final void rU(int r5) {
        SearchUserResultAdapter r0 = this.g;
        DocPublicPermission r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("searchUserAdapter");
        r0 = null;
    L5:
        r0.getClass();
        tt5.a.h("SearchUserResultAdapter", "onAdjustExternalFinished()...result = " + r5);
        if (r5 == AdjustExternalResult.SUCCESS.getValue()) goto L8;
        return;
    L8:
        if (r0.j != null) goto L11;
        tt5.a.h("SearchUserResultAdapter", "mAdjustExternalParams is null.");
        return;
    L11:
        if (r0.i.getDocPermSetInfo() != null) goto L13;
    L15:
        SceneType r6 = r0.j.e;
        if (r6 != SceneType.INVITE_EXTERNAL_MEMBER) goto L21;
        r0.h.p = true;
        if (r1 == null) goto L25;
        r1.setExternalAccessEntity(1);
    L25:
        r0.notifyDataSetChanged();
        SearchUserResultAdapter.SearchUserViewHolder r7 = r0.m;
        if (r7 == null) goto L33;
        UserInfo r2 = r0.n;
        if (r2 == null) goto L34;
        r0.G2(r7, r2, true);
        return;
    L34:
        return;
    L33:
        return;
    L21:
        if (r6 != SceneType.INVITE_EXTERNAL_PARTNER_TENANT_MEMBER) goto L25;
        r0.h.r = true;
        if (r1 == null) goto L25;
        r1.setExternalAccessEntity(3);
        goto L25
    L13:
        if ((r0.i.getDocPermSetInfo().f.b instanceof DocPublicPermission) == false) goto L15;
        r1 = (DocPublicPermission) r0.i.getDocPermSetInfo().f.b;
        goto L15
    }

    public final void setViewDelegate(IView.IViewDelegate r1) {
        this.f = (b.a) r1;
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.searchresult.b
    public final void v4(ArrayList<UserInfo> r4) {
        Intrinsics.checkNotNullParameter(r4, "userInfos");
        RecyclerView.Adapter r0 = this.g;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("searchUserAdapter");
        r0 = null;
    L5:
        r0.getClass();
        if (r4.isEmpty() == true) goto L21;
        Iterator<UserInfo> r5 = r4.iterator();
    L10:
        if (r5.hasNext() == false) goto L14;
        UserInfo r1 = r5.next();
        if (((ArrayList) r0.e).contains(r1) == true) goto L10;
        ((ArrayList) r0.e).add(r1);
        goto L10
    L14:
        r0.notifyDataSetChanged();
        return;
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.searchresult.b
    public final void y6(SearchUserResult r6) {
        Intrinsics.checkNotNullParameter(r6, "result");
        SearchUserResultAdapter r0 = this.g;
        SearchUserResultAdapter r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("searchUserAdapter");
        r0 = null;
    L5:
        List<Member> r3 = r6.existMembers;
        r0.getClass();
        if (hu5.a.f(r3) == false) goto L8;
        ((ArrayList) r0.f).addAll(r3);
    L8:
        SearchUserResultAdapter r2 = this.g;
        if (r2 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("searchUserAdapter");
    L12:
        ArrayList<UserInfo> r7 = r6.list;
        r1.getClass();
        if (r7 != null) goto L15;
        return;
    L15:
        if (r7.size() <= 0) goto L19;
        r1.getData().addAll(r7);
        r1.notifyDataSetChanged();
        return;
    L19:
        return;
    L11:
        r1 = r2;
        goto L12
    }

    public y(Context r2, View r3, ArrayList<UserInfo> r4, InviteMemberParams r5, InviteMemberViewModel r6) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "rootView");
        Intrinsics.checkNotNullParameter(r4, "originUsers");
        Intrinsics.checkNotNullParameter(r5, "params");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }

    @Override // th5.a
    public final void QQ(qe5.e.c r12, qe5.e.b r13, SecretApprovalInstanceModel r14, SecretApprovalDefModel r15, SecretLevel r16, SecretLevel r17) {
        Intrinsics.checkNotNullParameter(r14, "secretApprovalInstanceModel");
        Intrinsics.checkNotNullParameter(r15, "secretApprovalDefModel");
        Intrinsics.checkNotNullParameter(r16, "targetSecretLevel");
        Intrinsics.checkNotNullParameter(r17, "originSecretLevel");
        tt5.a.h("SearchUserResultView", "notifyShowSecLabelResubmitApprovalDialog()...");
        if ((this.a instanceof FragmentActivity) == false) goto L6;
        ((cj5.c) org.koin.java.a.c(cj5.c.class, null, null, 6)).l5((FragmentActivity) this.a, this.d.getType(), r12, r13, r14, r15, r16, r17);
        return;
    }

    @Override // th5.a
    public final void sJ(String r16, int r17, String r18, String r19, int r20, String r21, String r22, SecretLevel r23, SecretApprovalDefModel r24, Map<String, ? extends Serializable> r25, SecretLevel r26) {
        Intrinsics.checkNotNullParameter(r16, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r18, "secLabelId");
        Intrinsics.checkNotNullParameter(r19, "secLabelName");
        Intrinsics.checkNotNullParameter(r21, "applyTips");
        Intrinsics.checkNotNullParameter(r22, WikiFolderPushPlugin.WIKI_TOKEN);
        Intrinsics.checkNotNullParameter(r23, "oldSecretLevel");
        Intrinsics.checkNotNullParameter(r24, "defModel");
        tt5.a.h("SearchUserResultView", "notifyShowSecretApprovalDialog()...");
        if ((this.a instanceof FragmentActivity) == false) goto L6;
        ((cj5.c) org.koin.java.a.c(cj5.c.class, null, null, 6)).ad((FragmentActivity) this.a, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26);
        return;
    }
}
