package com.ss.android.lark.contact.customized.newcontact.view;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewbinding.ViewBindings;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.base.fragment.BaseFragment;
import com.ss.android.lark.contact.base.dependency.ContactBaseModuleDependency;
import com.ss.android.lark.contact.base.statistics.ContactHitPoint;
import com.ss.android.lark.contact.customized.OfficeContactPageUtils;
import com.ss.android.lark.contact.customized.common.OfficeContactUtils;
import com.ss.android.lark.contact.customized.common.view.ContactOfficeEmptyStateView;
import com.ss.android.lark.contact.customized.common.view.ContactOfficeTitleBar;
import com.ss.android.lark.contact.customized.databinding.ContactDbFragmentOfficeNewContactBinding;
import com.ss.android.lark.contact.customized.externalinvite.OfficeInviteExternalActivity;
import com.ss.android.lark.contact.customized.newcontact.viewmodel.OfficeNewContactViewModel;
import com.ss.android.lark.desktopmode.utils.DesktopUtil;
import com.ss.android.lark.dynamicconfig.interfaces.IFeatureSwitchService$FeatureKey;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.ChatWindowPtrLoadingHeader;
import com.ss.android.lark.widget.ptr.LKUIPtrClassicFrameLayout;
import com.ss.android.lark.widget.recyclerview.CommonRecyclerView;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000G\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006*\u0001\u000f\b\u0007\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u001a\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u001c\u001a\u00020\u001aH\u0002J\b\u0010\u001d\u001a\u00020\u001aH\u0002J\b\u0010\u001e\u001a\u00020\u001aH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010¨\u0006 "}, d2 = {"Lcom/ss/android/lark/contact/customized/newcontact/view/OfficeNewContactFragment;", "Lcom/ss/android/lark/base/fragment/BaseFragment;", "<init>", "()V", "viewBinding", "Lcom/ss/android/lark/contact/customized/databinding/ContactDbFragmentOfficeNewContactBinding;", "newContactView", "Lcom/ss/android/lark/contact/customized/newcontact/view/OfficeNewContactView;", "viewModel", "Lcom/ss/android/lark/contact/customized/newcontact/viewmodel/OfficeNewContactViewModel;", "getViewModel", "()Lcom/ss/android/lark/contact/customized/newcontact/viewmodel/OfficeNewContactViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "viewDependency", "com/ss/android/lark/contact/customized/newcontact/view/OfficeNewContactFragment$viewDependency$1", "Lcom/ss/android/lark/contact/customized/newcontact/view/OfficeNewContactFragment$viewDependency$1;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "initView", "initViewModel", "onDestroyView", "Companion", "contact-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeNewContactFragment extends BaseFragment {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f419362h = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ContactDbFragmentOfficeNewContactBinding f419363d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public l f419364e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f419365f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final b f419366g;

    public static final class a {
    }

    public static final class b implements l.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OfficeNewContactFragment f419367a;

        @Override // com.ss.android.lark.contact.customized.newcontact.view.l.b
        public final void A() {
            OfficeNewContactFragment r100 = this.f419367a;
            int r101 = OfficeNewContactFragment.f419362h;
            r100.S90().loadInitial();
        }

        @Override // com.ss.android.lark.contact.customized.newcontact.view.l.b
        public final void y() {
            this.f419367a.finish();
        }

        @Override // com.ss.android.lark.contact.customized.newcontact.view.l.b
        public final void z() {
            FragmentActivity r100 = this.f419367a.getActivity();
            if (r100 != null) goto L5;
            return;
        L5:
            com.ss.android.lark.contact.customized.common.b.a("contact_application", "contact_application");
            Lazy r101 = OfficeContactPageUtils.f418959a;
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            int r102 = OfficeInviteExternalActivity.f419261a;
            OfficeInviteExternalActivity.a.a(r100, "contact_application");
        }

        public b(OfficeNewContactFragment r100) {
            this.f419367a = r100;
        }

        @Override // com.ss.android.lark.contact.customized.newcontact.view.l.b
        public final void J(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "userId");
            Intrinsics.checkNotNullParameter(r101, "chatApplicationId");
            FragmentActivity r102 = this.f419367a.getActivity();
            if (r102 != null) goto L5;
            return;
        L5:
            ContactBaseModuleDependency.f418857b.startNewContactProfilePage(r102, r100, r101);
        }
    }

    static {
    }

    public final OfficeNewContactViewModel S90() {
        return (OfficeNewContactViewModel) this.f419365f.getValue();
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragment, com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        Log.i("Contact_NewContactFrag", "onDestroyView");
        l r100 = this.f419364e;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("newContactView");
        r100 = null;
    L5:
        r100.f419385d = null;
        r100.f419386e = null;
        r100.f419384c = null;
        r100.f419387f = null;
        super.onDestroyView();
    }

    public OfficeNewContactFragment() {
        final Function0<Fragment> r100 = new OfficeNewContactFragment$special$$inlined$viewModels$default$1(this);
        this.f419365f = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(OfficeNewContactViewModel.class), new OfficeNewContactFragment$special$$inlined$viewModels$default$2(r100), new OfficeNewContactFragment$special$$inlined$viewModels$default$3(r100, this));
        this.f419366g = new b(this);
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        S90().onPageViewCreated(SystemClock.elapsedRealtime());
        ContactDbFragmentOfficeNewContactBinding r102 = this.f419363d;
        String r103 = null;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r102 = null;
    L5:
        l r104 = new l(r102, this.f419366g);
        this.f419364e = r104;
        r104.f419386e = r104.f419382a.f419026d.getContext();
        r104.f419382a.f419029g.setRightIcon(R.drawable.ud_icon_member_add_outlined);
        r104.f419382a.f419029g.setLeftIconClickListener(new o(r104));
        int r105 = com.ss.android.lark.contact.base.service.a.f418904a;
        Intrinsics.checkNotNullParameter("invite.external.enable", "featureName");
        int r106 = 0;
        boolean r107 = FeatureGatingModule.getFeatureGatingService().isCurrentEnable("invite.external.enable", false);
        Intrinsics.checkNotNullParameter("invite.union.enable", "featureName");
        boolean r108 = FeatureGatingModule.getFeatureGatingService().isCurrentEnable("invite.union.enable", false);
        Intrinsics.checkNotNullParameter(IFeatureSwitchService$FeatureKey.SUITE_TO_C_ENABLE, "featureName");
        boolean r109 = FeatureGatingModule.getFeatureGatingService().isCurrentEnable(IFeatureSwitchService$FeatureKey.SUITE_TO_C_ENABLE, false);
        if (r108 == false) goto L10;
        if (r107 == true) goto L9;
        if (r109 == false) goto L10;
    L9:
        boolean r110 = true;
    L11:
        View r111 = r104.f419382a.f419029g.findViewById(R.id.iv_right_icon);
        if (r111 == null) goto L17;
        if (r110 == true) goto L16;
        r106 = 8;
    L16:
        r111.setVisibility(r106);
    L17:
        if (r110 == false) goto L19;
        r104.f419382a.f419029g.setRightIconClickListener(new p(r104));
    L20:
        Context r112 = r104.f419386e;
        if (r112 == null) goto L24;
        ChatWindowPtrLoadingHeader r113 = new ChatWindowPtrLoadingHeader(r112);
        r104.f419382a.f419025c.setKeepHeaderWhenRefresh(true);
        r104.f419382a.f419025c.setFooterView(r113);
        r104.f419382a.f419025c.addPtrUIHandler(r113);
        r104.f419382a.f419025c.disableWhenHorizontalMove(true);
        r104.f419382a.f419025c.setPtrHandler(new m(r104));
    L24:
        zdc.h.a(r104.f419382a.f419026d);
        r104.f419382a.f419026d.setLayoutManager(new LinearLayoutManager(r104.f419386e));
        if (r104.f419385d != null) goto L27;
        r104.f419385d = new OfficeNewContactAdapter();
    L27:
        OfficeNewContactAdapter r114 = r104.f419385d;
        if (r114 == null) goto L30;
        n r115 = new n(r104);
        Intrinsics.checkNotNullParameter(r115, "listener");
        r114.f419356b = r115;
    L30:
        r104.f419382a.f419026d.setAdapter(r104.f419385d);
        LKUIPtrClassicFrameLayout r116 = r104.f419382a.f419025c;
        int r117 = DesktopUtil.f420394a;
        l r118 = this.f419364e;
        if (r118 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("newContactView");
        r118 = null;
    L33:
        f r119 = new f(this);
        r118.getClass();
        Intrinsics.checkNotNullParameter(r119, "viewDelegate");
        r118.f419384c = r119;
        S90().getFriendRequests().observe(getViewLifecycleOwner(), new g(this));
        S90().getUpdateFriendRequests().observe(getViewLifecycleOwner(), new h(this));
        S90().getLoadMoreFinished().observe(getViewLifecycleOwner(), new i(this));
        S90().getRemoveFriendRequest().observe(getViewLifecycleOwner(), new j(this));
        S90().getOpenProfile().observe(getViewLifecycleOwner(), new k(this));
        Lazy r120 = ContactHitPoint.f418947a;
        JSONObject r121 = new JSONObject();
        r121.put("member_type", ContactHitPoint.a());
        Statistics.sendEvent("contact_new_view", r121);
        int r122 = com.ss.android.lark.contact.customized.common.b.f418964a;
        Bundle r123 = getArguments();
        if (r123 == null) goto L36;
        r103 = r123.getString("from");
    L36:
        if (r103 != null) goto L38;
        r103 = "";
    L38:
        com.ss.android.lark.contact.customized.common.b.c("contact_application", r103);
        S90().loadInitial();
        Context r124 = getContext();
        if (r124 == null) goto L42;
        Lazy r125 = OfficeContactUtils.f418960a;
        OfficeContactUtils.e(this, UIUtils.getColor(r124, R.color.flow_ud_bg_base_1));
        return;
    L42:
        return;
    L19:
        r104.f419382a.f419029g.setRightIconClickListener(q.f419393a);
    L10:
        r110 = false;
        goto L11
    }

    @Override // com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r110, Bundle r111) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r101 = r100.inflate(R.layout.contact_db_fragment_office_new_contact, r110, false);
        int r112 = R.id.new_contact_loading_layout;
        LinearLayout r102 = (LinearLayout) ViewBindings.findChildViewById(r101, R.id.new_contact_loading_layout);
        if (r102 == null) goto L17;
        r112 = R.id.new_contact_ptr_layout;
        LKUIPtrClassicFrameLayout r103 = (LKUIPtrClassicFrameLayout) ViewBindings.findChildViewById(r101, R.id.new_contact_ptr_layout);
        if (r103 == null) goto L17;
        r112 = R.id.new_contact_rv;
        CommonRecyclerView r104 = (CommonRecyclerView) ViewBindings.findChildViewById(r101, R.id.new_contact_rv);
        if (r104 == null) goto L17;
        r112 = R.id.new_contact_state_layout;
        FrameLayout r105 = (FrameLayout) ViewBindings.findChildViewById(r101, R.id.new_contact_state_layout);
        if (r105 == null) goto L17;
        r112 = R.id.new_contact_state_view;
        ContactOfficeEmptyStateView r106 = (ContactOfficeEmptyStateView) ViewBindings.findChildViewById(r101, R.id.new_contact_state_view);
        if (r106 == null) goto L17;
        r112 = R.id.title_bar;
        ContactOfficeTitleBar r107 = (ContactOfficeTitleBar) ViewBindings.findChildViewById(r101, R.id.title_bar);
        if (r107 == null) goto L17;
        ContactDbFragmentOfficeNewContactBinding r113 = new ContactDbFragmentOfficeNewContactBinding((LinearLayout) r101, r102, r103, r104, r105, r106, r107);
        this.f419363d = r113;
        return r113.f419023a;
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(r101.getResources().getResourceName(r112)));
    }
}
