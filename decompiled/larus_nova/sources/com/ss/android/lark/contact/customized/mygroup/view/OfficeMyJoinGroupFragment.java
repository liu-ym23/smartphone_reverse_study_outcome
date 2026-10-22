package com.ss.android.lark.contact.customized.mygroup.view;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewbinding.ViewBindings;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.lark.base.fragment.BaseFragment;
import com.ss.android.lark.contact.customized.common.OfficeContactUtils;
import com.ss.android.lark.contact.customized.common.view.ContactOfficeEmptyStateView;
import com.ss.android.lark.contact.customized.common.view.ContactOfficeTitleBar;
import com.ss.android.lark.contact.customized.databinding.ContactDbFragmentOfficeMyJoinGroupBinding;
import com.ss.android.lark.desktopmode.utils.DesktopUtil;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.widget.ChatWindowPtrLoadingHeader;
import com.ss.android.lark.widget.ptr.LKUIPtrClassicFrameLayout;
import com.ss.android.lark.widget.recyclerview.CommonRecyclerView;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import zdc.h;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 12\u00020\u0001:\u00011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0012\u001a\u00020\u00132\n\b\u0001\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J$\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u001a\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u00172\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u001e\u001a\u00020\u0013H\u0016J\u0010\u0010\u001f\u001a\u00020\u00132\u0006\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020\u0013H\u0002J\b\u0010#\u001a\u00020\u0013H\u0002J\b\u0010$\u001a\u00020\u0013H\u0002J\b\u0010%\u001a\u00020\u0013H\u0002J\b\u0010&\u001a\u00020\u0013H\u0002J\b\u0010'\u001a\u00020\u0013H\u0002J\b\u0010(\u001a\u00020\u0013H\u0002J\u0016\u0010)\u001a\u00020\u00132\f\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+H\u0002J\b\u0010-\u001a\u00020\u0013H\u0002J\u0010\u0010.\u001a\u00020\u00132\u0006\u0010/\u001a\u000200H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/ss/android/lark/contact/customized/mygroup/view/OfficeMyJoinGroupFragment;", "Lcom/ss/android/lark/base/fragment/BaseFragment;", "<init>", "()V", "configurationHandler", "Lcom/ss/android/lark/contact/impl/group/ConfigurationHandler;", "viewBinding", "Lcom/ss/android/lark/contact/customized/databinding/ContactDbFragmentOfficeMyJoinGroupBinding;", "viewModel", "Lcom/ss/android/lark/contact/customized/mygroup/view/OfficeMyJoinGroupViewModel;", "getViewModel", "()Lcom/ss/android/lark/contact/customized/mygroup/view/OfficeMyJoinGroupViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "skeletonScreen", "Lcom/ethanhua/skeleton/ViewSkeletonScreen;", "adapter", "Lcom/ss/android/lark/contact/customized/mygroup/view/OfficeMyGroupAdapter;", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "onViewCreated", "view", "onDestroyView", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "initObservers", "initView", "initTitleBar", "initList", "initPullToLoadMore", DyPayConstant.KEY_SHOW_LOADING, "hideLoading", "showGroups", "chats", "", "Lcom/ss/android/lark/chat/entity/chat/Chat;", "showError", "enterGroupChat", "chatId", "", "Companion", "contact-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeMyJoinGroupFragment extends BaseFragment {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f419302i = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public q9b.a f419303d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ContactDbFragmentOfficeMyJoinGroupBinding f419304e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f419305f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public lt7.d f419306g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public OfficeMyGroupAdapter f419307h;

    public static final class a {
    }

    public static final class b implements q9b.a.InterfaceC7301a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OfficeMyJoinGroupFragment f419308a;

        @Override // q9b.a.InterfaceC7301a
        public final void a() {
            OfficeMyGroupAdapter r100 = this.f419308a.f419307h;
            if (r100 == null) goto L6;
            r100.notifyDataSetChanged();
            return;
        }

        public b(OfficeMyJoinGroupFragment r100) {
            this.f419308a = r100;
        }
    }

    static {
    }

    public final OfficeMyJoinGroupViewModel S90() {
        return (OfficeMyJoinGroupViewModel) this.f419305f.getValue();
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragment, com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        Log.i("Contact_MyJoinGroupFrag", "onDestroyView");
        this.f419307h = null;
        this.f419306g = null;
        super.onDestroyView();
    }

    public OfficeMyJoinGroupFragment() {
        final Function0<Fragment> r100 = new OfficeMyJoinGroupFragment$special$$inlined$viewModels$default$1(this);
        this.f419305f = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(OfficeMyJoinGroupViewModel.class), new OfficeMyJoinGroupFragment$special$$inlined$viewModels$default$2(r100), new OfficeMyJoinGroupFragment$special$$inlined$viewModels$default$3(r100, this));
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
        super.onConfigurationChanged(r100);
        q9b.a r101 = this.f419303d;
        if (r101 == null) goto L6;
        r101.a(r100);
        return;
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragment, com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        Context r101 = getContext();
        if (r101 == null) goto L7;
        Resources r102 = r101.getResources();
        if (r102 == null) goto L7;
        Configuration r103 = r102.getConfiguration();
    L8:
        if (r103 == null) goto L11;
        q9b.a r104 = new q9b.a(r103);
        b r105 = new b(this);
        Intrinsics.checkNotNullParameter(r105, "onWindowChangedListener");
        r104.f532180b = r105;
        this.f419303d = r104;
        return;
    L11:
        return;
    L7:
        r103 = null;
        goto L8
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        S90().onPageViewCreated(SystemClock.elapsedRealtime());
        ContactDbFragmentOfficeMyJoinGroupBinding r102 = this.f419304e;
        ContactDbFragmentOfficeMyJoinGroupBinding r103 = null;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r102 = null;
    L5:
        r102.f419022f.setRightIcon(R.drawable.contact_db_icon_search);
        ContactDbFragmentOfficeMyJoinGroupBinding r104 = this.f419304e;
        if (r104 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r104 = null;
    L8:
        r104.f419022f.setLeftIconClickListener(new e(this));
        ContactDbFragmentOfficeMyJoinGroupBinding r105 = this.f419304e;
        if (r105 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r105 = null;
    L11:
        r105.f419022f.setRightIconClickListener(new f(this));
        Context r106 = getContext();
        if (r106 == null) goto L14;
        Lazy r107 = OfficeContactUtils.f418960a;
        OfficeContactUtils.e(this, UIUtils.getColor(r106, R.color.flow_ud_bg_base_1));
    L14:
        ContactDbFragmentOfficeMyJoinGroupBinding r108 = this.f419304e;
        if (r108 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r108 = null;
    L17:
        h.a(r108.f419021e);
        ContactDbFragmentOfficeMyJoinGroupBinding r109 = this.f419304e;
        if (r109 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r109 = null;
    L20:
        r109.f419021e.setLayoutManager(new LinearLayoutManager(requireContext()));
        OfficeMyGroupAdapter r110 = new OfficeMyGroupAdapter();
        r110.f419296b = new OfficeMyJoinGroupFragment$initList$1$1(this);
        this.f419307h = r110;
        ContactDbFragmentOfficeMyJoinGroupBinding r111 = this.f419304e;
        if (r111 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r111 = null;
    L23:
        r111.f419021e.setAdapter(this.f419307h);
        ContactDbFragmentOfficeMyJoinGroupBinding r112 = this.f419304e;
        if (r112 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r112 = null;
    L26:
        r112.f419021e.getContext();
        ContactDbFragmentOfficeMyJoinGroupBinding r113 = this.f419304e;
        if (r113 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r113 = null;
    L29:
        LKUIPtrClassicFrameLayout r114 = r113.f419020d;
        ContactDbFragmentOfficeMyJoinGroupBinding r115 = this.f419304e;
        if (r115 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r115 = null;
    L32:
        CommonRecyclerView r116 = r115.f419021e;
        int r117 = DesktopUtil.f420394a;
        ChatWindowPtrLoadingHeader r118 = new ChatWindowPtrLoadingHeader(requireContext());
        ContactDbFragmentOfficeMyJoinGroupBinding r119 = this.f419304e;
        if (r119 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r119 = null;
    L35:
        r119.f419020d.setKeepHeaderWhenRefresh(true);
        ContactDbFragmentOfficeMyJoinGroupBinding r120 = this.f419304e;
        if (r120 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r120 = null;
    L38:
        r120.f419020d.setFooterView(r118);
        ContactDbFragmentOfficeMyJoinGroupBinding r121 = this.f419304e;
        if (r121 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r121 = null;
    L41:
        r121.f419020d.addPtrUIHandler(r118);
        ContactDbFragmentOfficeMyJoinGroupBinding r122 = this.f419304e;
        if (r122 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r122 = null;
    L44:
        r122.f419020d.disableWhenHorizontalMove(true);
        ContactDbFragmentOfficeMyJoinGroupBinding r123 = this.f419304e;
        if (r123 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
    L48:
        r103.f419020d.setPtrHandler(new d(this));
        S90().getGroups().observe(getViewLifecycleOwner(), new com.ss.android.lark.contact.customized.mygroup.view.b(this));
        S90().getLoadMoreFinished().observe(getViewLifecycleOwner(), new c(this));
        S90().loadInitial();
        return;
    L47:
        r103 = r123;
        goto L48
    }

    @Override // com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r110) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r102 = r100.inflate(R.layout.contact_db_fragment_office_my_join_group, r101, false);
        int r103 = R.id.empty_layout;
        ContactOfficeEmptyStateView r104 = (ContactOfficeEmptyStateView) ViewBindings.findChildViewById(r102, R.id.empty_layout);
        if (r104 == null) goto L15;
        r103 = R.id.my_group_loading_layout;
        LinearLayout r105 = (LinearLayout) ViewBindings.findChildViewById(r102, R.id.my_group_loading_layout);
        if (r105 == null) goto L15;
        r103 = R.id.my_group_ptr_layout;
        LKUIPtrClassicFrameLayout r106 = (LKUIPtrClassicFrameLayout) ViewBindings.findChildViewById(r102, R.id.my_group_ptr_layout);
        if (r106 == null) goto L15;
        r103 = R.id.my_group_rv;
        CommonRecyclerView r107 = (CommonRecyclerView) ViewBindings.findChildViewById(r102, R.id.my_group_rv);
        if (r107 == null) goto L15;
        r103 = R.id.title_bar;
        ContactOfficeTitleBar r108 = (ContactOfficeTitleBar) ViewBindings.findChildViewById(r102, R.id.title_bar);
        if (r108 == null) goto L15;
        ContactDbFragmentOfficeMyJoinGroupBinding r109 = new ContactDbFragmentOfficeMyJoinGroupBinding((LinearLayout) r102, r104, r105, r106, r107, r108);
        this.f419304e = r109;
        return r109.f419017a;
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r102.getResources().getResourceName(r103)));
    }
}
