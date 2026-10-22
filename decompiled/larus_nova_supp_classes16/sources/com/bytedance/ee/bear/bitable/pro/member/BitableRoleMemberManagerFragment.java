package com.bytedance.ee.bear.bitable.pro.member;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.BlockSimpleInfo;
import com.bytedance.ee.bear.bitable.pro.BaseBitableProFragment;
import com.bytedance.ee.bear.bitable.pro.BitableProViewModel;
import com.bytedance.ee.bear.bitable.pro.Role;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.facade.common.widget.recyclerview.LinearLayoutManagerWrapper;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.bytedance.ee.bear.widgets.t;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEmptyState;
import com.bytedance.ee.util.ui.l;
import com.larksuite.component.universe_design.toast.UDToast;
import io.reactivex.disposables.CompositeDisposable;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 K2\u00020\u0001:\u0001KB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u001c\u001a\u00020\u001dH\u0002J\u0012\u00105\u001a\u00020\u001d2\b\u00106\u001a\u0004\u0018\u000107H\u0016J\b\u00108\u001a\u00020\u001dH\u0002J&\u00109\u001a\u0004\u0018\u00010:2\u0006\u0010;\u001a\u00020<2\b\u0010=\u001a\u0004\u0018\u00010>2\b\u00106\u001a\u0004\u0018\u000107H\u0016J\u001a\u0010?\u001a\u00020\u001d2\u0006\u0010@\u001a\u00020:2\b\u00106\u001a\u0004\u0018\u000107H\u0016J\b\u0010A\u001a\u00020\u001dH\u0002J\b\u0010B\u001a\u00020\u001dH\u0002J\u0010\u0010C\u001a\u00020\u001d2\u0006\u0010D\u001a\u00020EH\u0002J\u0010\u0010F\u001a\u00020\u001d2\u0006\u0010D\u001a\u00020EH\u0002J\b\u0010G\u001a\u00020\u001dH\u0016J\b\u0010H\u001a\u00020.H\u0016J\b\u0010I\u001a\u00020JH\u0016R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u0004\u0018\u00010\u000b8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00118FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00178FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010$\u001a\u0016\u0012\u0004\u0012\u00020&\u0018\u00010%j\n\u0012\u0004\u0012\u00020&\u0018\u0001`'X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010/\u001a\u0002008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b1\u00102¨\u0006L"}, d2 = {"Lcom/bytedance/ee/bear/bitable/pro/member/BitableRoleMemberManagerFragment;", "Lcom/bytedance/ee/bear/bitable/pro/BaseBitableProFragment;", "<init>", "()V", "titleBarFromXml", "Lcom/bytedance/ee/bear/widgets/BaseTitleBar;", "getTitleBarFromXml", "()Lcom/bytedance/ee/bear/widgets/BaseTitleBar;", "setTitleBarFromXml", "(Lcom/bytedance/ee/bear/widgets/BaseTitleBar;)V", "memberRecyclerFromXml", "Landroidx/recyclerview/widget/RecyclerView;", "getMemberRecyclerFromXml", "()Landroidx/recyclerview/widget/RecyclerView;", "setMemberRecyclerFromXml", "(Landroidx/recyclerview/widget/RecyclerView;)V", "emptyStateViewFromXml", "Lcom/bytedance/ee/bear/widgets/universedesign/SpaceEmptyState;", "getEmptyStateViewFromXml", "()Lcom/bytedance/ee/bear/widgets/universedesign/SpaceEmptyState;", "setEmptyStateViewFromXml", "(Lcom/bytedance/ee/bear/widgets/universedesign/SpaceEmptyState;)V", "emptyLayoutFromXml", "Landroid/widget/LinearLayout;", "getEmptyLayoutFromXml", "()Landroid/widget/LinearLayout;", "setEmptyLayoutFromXml", "(Landroid/widget/LinearLayout;)V", "clearFromXmlViewCache", "", "role", "Lcom/bytedance/ee/bear/bitable/pro/Role;", "viewModel", "Lcom/bytedance/ee/bear/bitable/pro/BitableProViewModel;", "token", "", "tableList", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/BlockSimpleInfo;", "Lkotlin/collections/ArrayList;", "ownerId", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "adapter", "Lcom/bytedance/ee/bear/bitable/pro/member/BitableRoleMemberAdapter;", "isRemoteComputeUpgradeFg", "", "loadingDialog", "Lcom/bytedance/ee/bear/widgets/LoadingDialog;", "getLoadingDialog", "()Lcom/bytedance/ee/bear/widgets/LoadingDialog;", "loadingDialog$delegate", "Lkotlin/Lazy;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "parseArguments", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "triggerToInviteMember", "updateListStatus", "showRemoveDialog", "userInfo", "Lcom/bytedance/ee/bear/share/export/UserInfo;", "removeMember", "onDestroyView", "onBackPressed", "getStatusBarColorRes", "", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableRoleMemberManagerFragment extends BaseBitableProFragment {
    public static final /* synthetic */ int s = 0;
    public BaseTitleBar f;
    public RecyclerView g;
    public SpaceEmptyState h;
    public LinearLayout i;
    public Role j;
    public BitableProViewModel k;
    public String l;
    public ArrayList<BlockSimpleInfo> m;
    public String n;
    public final CompositeDisposable o;
    public BitableRoleMemberAdapter p;
    public final boolean q;
    public final Lazy r;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
        }
    }

    public static final class c extends BaseTitleBar.c {
        public final /* synthetic */ BitableRoleMemberManagerFragment k;

        public final void performAction(View r3) {
            Intrinsics.checkNotNullParameter(r3, "view");
            if (this.k.j.disableAddMembers() == false) goto L5;
            UDToast.show(this.k.requireContext(), 2131886190, 2131256189);
        L6:
            int r4 = com.bytedance.ee.bear.bitable.pro.d.a;
            JSONObject r5 = new JSONObject();
            r5.put("click", "add_collaborator_icon");
            r5.put("target", "ccm_permission_add_collaborator_view");
            com.bytedance.ee.bear.bitable.pro.d.b("ccm_bitable_premium_permission_manage_collaborator_click", r5);
            return;
        L5:
            BitableRoleMemberManagerFragment.V90(this.k);
            goto L6
        }

        public c(BitableRoleMemberManagerFragment r1, Drawable r2) {
            this.k = r1;
            super(r2);
        }
    }

    public static final class d extends t {
        public final /* synthetic */ BitableRoleMemberManagerFragment c;

        public d(BitableRoleMemberManagerFragment r1) {
            this.c = r1;
        }

        public final void a(View r3) {
            this.c.T90(2130772293);
            int r4 = com.bytedance.ee.bear.bitable.pro.d.a;
            JSONObject r5 = new JSONObject();
            r5.put("click", "back");
            r5.put("target", "none");
            com.bytedance.ee.bear.bitable.pro.d.b("ccm_bitable_premium_permission_manage_collaborator_click", r5);
        }
    }

    public static final class e<T> implements Observer {
        public final /* synthetic */ BitableRoleMemberManagerFragment a;

        public e(BitableRoleMemberManagerFragment r1) {
            this.a = r1;
        }

        public final void onChanged(Object r6) {
            ArrayList r7 = (ArrayList) r6;
            if (r7 == null) goto L23;
            BitableRoleMemberManagerFragment r0 = this.a;
            Iterator<T> r8 = r7.iterator();
        L5:
            BitableRoleMemberAdapter r2 = null;
            if (r8.hasNext() == false) goto L10;
            T r1 = r8.next();
            if (Intrinsics.areEqual(((Role) r1).getRoleId(), r0.j.getRoleId()) == false) goto L5;
        L11:
            Role r3 = r1;
            if (r3 != null) goto L14;
            r3 = this.a.j;
        L14:
            r0.j = r3;
            BitableRoleMemberAdapter r9 = this.a.p;
            if (r9 != null) goto L17;
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        L18:
            r2.setNewData(this.a.j.getMembers());
            this.a.Y90();
            return;
        L17:
            r2 = r9;
            goto L18
        L10:
            r1 = (T) null;
            goto L11
        }
    }

    public static final class f extends t {
        public final /* synthetic */ BitableRoleMemberManagerFragment c;

        public f(BitableRoleMemberManagerFragment r1) {
            this.c = r1;
        }

        public final void a(View r3) {
            BitableRoleMemberManagerFragment.V90(this.c);
            int r4 = com.bytedance.ee.bear.bitable.pro.d.a;
            JSONObject r5 = new JSONObject();
            r5.put("click", "add_collaborator_button");
            r5.put("target", "ccm_permission_add_collaborator_view");
            com.bytedance.ee.bear.bitable.pro.d.b("ccm_bitable_premium_permission_manage_collaborator_click", r5);
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.bitable.pro.BaseBitableProFragment
    public final int U90() {
        return 2131100548;
    }

    public BitableRoleMemberManagerFragment() {
        this.j = new Role(null, null, null, null, null, null, null, null, null, 0, false, 0, false, null, 16383, null);
        this.l = "";
        this.n = "";
        this.o = new CompositeDisposable();
        this.q = com.bytedance.ee.bear.appsetting.c.a.a.h("bitable.mobile.remote_compute.upgrade");
        this.r = LazyKt.lazy(new BitableRoleMemberManagerFragment$loadingDialog$2(this));
    }

    public final RecyclerView W90() {
        View r0 = this.g;
        if (r0 != null) goto L10;
        View r1 = getView();
        if (r1 == null) goto L7;
        r0 = r1.findViewById(2131379843);
    L8:
        this.g = (RecyclerView) r0;
        goto L10
    L7:
        r0 = null;
    L10:
        return (RecyclerView) r0;
    }

    public final BaseTitleBar X90() {
        View r0 = this.f;
        if (r0 != null) goto L10;
        View r1 = getView();
        if (r1 == null) goto L7;
        r0 = r1.findViewById(2131388775);
    L8:
        this.f = (BaseTitleBar) r0;
        goto L10
    L7:
        r0 = null;
    L10:
        return (BaseTitleBar) r0;
    }

    public final void Y90() {
        View r2 = null;
        if (this.j.getMembers().isEmpty() == false) goto L11;
        W90().setVisibility(8);
        View r0 = this.i;
        if (r0 != null) goto L10;
        View r1 = getView();
        if (r1 == null) goto L9;
        r2 = r1.findViewById(2131371559);
    L9:
        this.i = (LinearLayout) r2;
        r0 = r2;
    L10:
        ((LinearLayout) r0).setVisibility(0);
        return;
    L11:
        W90().setVisibility(0);
        View r3 = this.i;
        if (r3 != null) goto L17;
        View r4 = getView();
        if (r4 == null) goto L16;
        r2 = r4.findViewById(2131371559);
    L16:
        this.i = (LinearLayout) r2;
        r3 = r2;
    L17:
        ((LinearLayout) r3).setVisibility(8);
    }

    @Override // com.bytedance.ee.bear.bitable.pro.BaseBitableProFragment, com.bytedance.ee.bear.facade.common.BaseFragment, sa5.d
    public final boolean onBackPressed() {
        super.onBackPressed();
        return true;
    }

    @Override // com.bytedance.ee.bear.bitable.pro.BaseBitableProFragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.o.clear();
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
    }

    public static final void V90(BitableRoleMemberManagerFragment r12) {
        r12.getClass();
        BitableProViewModel r2 = null;
        cj5.c r3 = (cj5.c) org.koin.java.a.c(cj5.c.class, null, null, 6);
        FragmentActivity r4 = r12.getActivity();
        String r5 = r12.l;
        String r6 = r12.j.getRoleId();
        String r7 = r12.n;
        BitableProViewModel r0 = r12.k;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r0 = null;
    L5:
        String r8 = r0.getCreateTenantId();
        BitableProViewModel r1 = r12.k;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r1 = null;
    L8:
        boolean r9 = r1.isTemplate();
        ArrayList<UserInfo> r10 = r12.j.getMembers();
        BitableProViewModel r13 = r12.k;
        if (r13 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L12:
        r3.O0(r4, r5, r6, r7, r8, r9, r10, r2.getWikiUsers());
        return;
    L11:
        r2 = r13;
        goto L12
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment
    public final void onCreate(Bundle r4) {
        super.onCreate(r4);
        Bundle r5 = getArguments();
        String r0 = "";
        if (r5 == null) goto L6;
        String r6 = r5.getString("extra_token");
        if (r6 == null) goto L6;
    L7:
        this.l = r6;
        Bundle r7 = getArguments();
        if (r7 == null) goto L13;
        String r8 = r7.getString("extra_owner_id");
        if (r8 == null) goto L13;
        r0 = r8;
    L13:
        this.n = r0;
        Bundle r9 = getArguments();
        Object r1 = null;
        if (r9 == null) goto L16;
        Serializable r10 = r9.getSerializable("extra_table_list");
    L17:
        this.m = (ArrayList) r10;
        Bundle r11 = getArguments();
        if (r11 == null) goto L20;
        r1 = r11.getSerializable("extra_role");
    L20:
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type com.bytedance.ee.bear.bitable.pro.Role");
        this.j = (Role) r1;
        this.k = (BitableProViewModel) q.a(requireParentFragment(), BitableProViewModel.class);
        this.p = new BitableRoleMemberAdapter(this.j, AnonymousClass2.INSTANCE, new AnonymousClass3(this));
        return;
    L16:
        r10 = null;
    L6:
        r6 = "";
        goto L7
    }

    @Override // com.bytedance.ee.bear.bitable.pro.BaseBitableProFragment, com.bytedance.ee.bear.facade.common.BaseFragment
    public final void onViewCreated(View r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        super.onViewCreated(r4, r5);
        r4.setOnClickListener(b.a);
        if (this.j.disableAddMembers() == false) goto L5;
        X90().setActionIconTint(2131102416);
    L6:
        X90().a(new c(this, l.a(getContext(), 2131255097, 2131101926)), true);
        X90().setLeftClickListener(new d(this));
        W90().setLayoutManager(new LinearLayoutManagerWrapper(getContext()));
        RecyclerView r6 = W90();
        RecyclerView.Adapter r0 = this.p;
        View r1 = null;
        if (r0 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r0 = null;
    L9:
        r6.setAdapter(r0);
        BitableProViewModel r7 = this.k;
        if (r7 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r7 = null;
    L12:
        r7.getRoleListLiveData().observe(getViewLifecycleOwner(), new e(this));
        View r8 = this.h;
        if (r8 != null) goto L19;
        View r9 = getView();
        if (r9 == null) goto L17;
        r8 = r9.findViewById(2131371565);
    L18:
        this.h = (SpaceEmptyState) r8;
        goto L19
    L17:
        r8 = null;
    L19:
        ((SpaceEmptyState) r8).showPrimaryAction(true ^ this.j.disableAddMembers());
        View r10 = this.h;
        if (r10 != null) goto L25;
        View r11 = getView();
        if (r11 == null) goto L24;
        r1 = r11.findViewById(2131371565);
    L24:
        this.h = (SpaceEmptyState) r1;
        r10 = r1;
    L25:
        ((SpaceEmptyState) r10).setPrimaryClickListener(new f(this));
        Y90();
        int r12 = com.bytedance.ee.bear.bitable.pro.d.a;
        com.bytedance.ee.bear.bitable.pro.d.b("ccm_bitable_premium_permission_manage_collaborator_view", new JSONObject());
        return;
    L5:
        X90().setActionIconTint(2131102418);
        goto L6
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131559142, r3, false);
    }
}
