package com.ss.android.lark.contact.customized.externalcontact.view;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.ConcatAdapter;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.lark.base.fragment.BaseFragment;
import com.ss.android.lark.contact.base.common_ui.IndexBar;
import com.ss.android.lark.contact.base.contact_list.view.IndexRecyclerViewAdapter;
import com.ss.android.lark.contact.customized.OfficeContactPageUtils;
import com.ss.android.lark.contact.customized.common.view.ContactOfficeEmptyStateView;
import com.ss.android.lark.contact.customized.databinding.ContactDbFragmentOfficeContactPageLayoutBinding;
import com.ss.android.lark.contact.customized.externalinvite.OfficeInviteExternalActivity;
import com.ss.android.lark.desktopmode.utils.DesktopUtil;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.ChatWindowPtrLoadingHeader;
import com.ss.android.lark.widget.ptr.LKUIPtrClassicFrameLayout;
import com.ss.android.lark.widget.recyclerview.CommonRecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u0091\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001&\b\u0007\u0018\u0000 U2\u00020\u0001:\u0001UB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\u001a\u00100\u001a\u0002012\u0006\u00102\u001a\u00020)2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\b\u00103\u001a\u000201H\u0002J\b\u00104\u001a\u000201H\u0002J\b\u00105\u001a\u000201H\u0002J\b\u00106\u001a\u000201H\u0002J\b\u00107\u001a\u000201H\u0002J\b\u00108\u001a\u000201H\u0002J\u0016\u00109\u001a\u0002012\f\u0010:\u001a\b\u0012\u0004\u0012\u00020<0;H\u0002J\u0016\u0010=\u001a\u0002012\f\u0010:\u001a\b\u0012\u0004\u0012\u00020>0;H\u0002J\b\u0010?\u001a\u000201H\u0002J\b\u0010@\u001a\u000201H\u0002J\b\u0010A\u001a\u000201H\u0002J\b\u0010B\u001a\u000201H\u0002J\b\u0010C\u001a\u000201H\u0002J\b\u0010D\u001a\u000201H\u0002J\b\u0010E\u001a\u000201H\u0002J\b\u0010F\u001a\u000201H\u0002J\b\u0010G\u001a\u000201H\u0002J\f\u0010H\u001a\u0006\u0012\u0002\b\u00030\u001dH\u0002J\b\u0010I\u001a\u00020JH\u0002J\u001c\u0010K\u001a\u0002012\u0012\u0010L\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020<0;0MH\u0002J\u001c\u0010N\u001a\u0002012\u0012\u0010L\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020>0;0MH\u0002J<\u0010O\u001a\u000201\"\u0004\b\u0000\u0010P2\u0012\u0010L\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002HP0;0M2\u0018\u0010Q\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002HP0;\u0012\u0004\u0012\u0002010RH\u0002J\u0014\u0010S\u001a\u0002012\n\u0010:\u001a\u0006\u0012\u0002\b\u00030;H\u0002J\b\u0010T\u001a\u000201H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\f\u0010\u000eR\u001b\u0010\u0010\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u0010\u0010\u000eR\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0017\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u000b\u001a\u0004\b\u0017\u0010\u000eR\u001b\u0010\u0019\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u000b\u001a\u0004\b\u001a\u0010\u000eR\u0014\u0010\u001c\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u00020&X\u0082\u0004¢\u0006\u0004\n\u0002\u0010'¨\u0006V"}, d2 = {"Lcom/ss/android/lark/contact/customized/externalcontact/view/OfficeExternalContactFragment;", "Lcom/ss/android/lark/base/fragment/BaseFragment;", "<init>", "()V", "viewBinding", "Lcom/ss/android/lark/contact/customized/databinding/ContactDbFragmentOfficeContactPageLayoutBinding;", "viewModel", "Lcom/ss/android/lark/contact/customized/externalcontact/view/OfficeExternalContactViewModel;", "getViewModel", "()Lcom/ss/android/lark/contact/customized/externalcontact/view/OfficeExternalContactViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "isExternalContactScene", "", "()Z", "isExternalContactScene$delegate", "isSidebarExperiment", "isSidebarExperiment$delegate", "from", "", "getFrom", "()Ljava/lang/String;", "from$delegate", "isEnterpriseAccount", "isEnterpriseAccount$delegate", "shouldLoadEnterpriseData", "getShouldLoadEnterpriseData", "shouldLoadEnterpriseData$delegate", "activePageDelegate", "Lcom/ss/android/lark/contact/customized/externalcontact/view/list/OfficeContactPageDelegate;", "skeletonScreen", "Lcom/ethanhua/skeleton/ViewSkeletonScreen;", "isScrollForbidden", "currentBadgeCount", "", "currentNewFriendSubtitle", "selfUserId", "forbiddenScrollItemListener", "com/ss/android/lark/contact/customized/externalcontact/view/OfficeExternalContactFragment$forbiddenScrollItemListener$1", "Lcom/ss/android/lark/contact/customized/externalcontact/view/OfficeExternalContactFragment$forbiddenScrollItemListener$1;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "initView", "initData", "initViewModel", "initPulltoRefresh", "initExternalContactView", "initIndexBar", "showDoubaoContacts", "items", "", "Lcom/ss/android/lark/officesdk/contact/api/model/OfficeBaseContactItemModel;", "showEnterpriseContacts", "Lcom/ss/android/lark/officesdk/contact/api/model/OfficeSubordinateItem;", "showExternalContactView", "updateStateLayoutIfNeeded", DyPayConstant.KEY_SHOW_LOADING, "hideLoading", "forbidItemsScroll", "allowItemsScroll", "showExternalContactEmptyView", "showErrorView", "hideErrorView", "createPageDelegate", "buildHeaderConfig", "Lcom/ss/android/lark/contact/customized/externalcontact/view/list/OfficeContactHeaderConfig;", "handlePersonalStateChanged", "state", "Lcom/ss/android/lark/contact/customized/common/model/StatefulModel;", "handleEnterpriseStateChanged", "handleStateChanged", ExifInterface.GPS_DIRECTION_TRUE, "onSuccess", "Lkotlin/Function1;", "submitPageItems", "onDestroyView", "Companion", "contact-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeExternalContactFragment extends BaseFragment {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final /* synthetic */ int f419163r = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ContactDbFragmentOfficeContactPageLayoutBinding f419164d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f419165e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f419166f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f419167g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f419168h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f419169i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f419170j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public com.ss.android.lark.contact.customized.externalcontact.view.list.a<?> f419171k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public lt7.d f419172l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f419173m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f419174n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f419175o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f419176p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final OfficeExternalContactFragment$forbiddenScrollItemListener$1 f419177q;

    public static final class a {
        public static OfficeExternalContactFragment a(boolean r100, boolean r101, String r102) {
            Intrinsics.checkNotNullParameter(r102, "from");
            OfficeExternalContactFragment r103 = new OfficeExternalContactFragment();
            Bundle r104 = new Bundle();
            r104.putBoolean("arg_is_external_contact_scene", r100);
            r104.putBoolean("arg_is_sidebar_experiment", r101);
            r104.putString("from", r102);
            r103.setArguments(r104);
            return r103;
        }
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OfficeExternalContactFragment f419178a;

        public b(OfficeExternalContactFragment r100) {
            this.f419178a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            Context r101 = this.f419178a.getContext();
            if (r101 == null) goto L6;
            com.ss.android.lark.contact.customized.common.b.a("contact", "contact");
            Lazy r102 = OfficeContactPageUtils.f418959a;
            Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
            int r103 = OfficeInviteExternalActivity.f419261a;
            OfficeInviteExternalActivity.a.a(r101, "contact");
            return;
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f419179a = null;

        static {
            f419179a = new c();
        }

        public c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
        }
    }

    static {
    }

    public final boolean W90() {
        return ((Boolean) this.f419170j.getValue()).booleanValue();
    }

    public final OfficeExternalContactViewModel X90() {
        return (OfficeExternalContactViewModel) this.f419165e.getValue();
    }

    public final boolean Z90() {
        return ((Boolean) this.f419169i.getValue()).booleanValue();
    }

    public final boolean aa0() {
        return ((Boolean) this.f419166f.getValue()).booleanValue();
    }

    public final void ba0() {
        ContactDbFragmentOfficeContactPageLayoutBinding r100 = this.f419164d;
        ContactDbFragmentOfficeContactPageLayoutBinding r101 = null;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r100 = null;
    L5:
        r100.f419014g.setEmptyIcon(R.drawable.contact_db_icon_load_empty);
        ContactDbFragmentOfficeContactPageLayoutBinding r102 = this.f419164d;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r102 = null;
    L8:
        r102.f419014g.setEmptyText(UIHelper.getString(R.string.LarkIM_Friend_NoContacts_EmptyState));
        boolean r103 = Z90();
        ContactDbFragmentOfficeContactPageLayoutBinding r104 = this.f419164d;
        if (r104 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r104 = null;
    L11:
        r104.f419014g.setHideActionButton(r103);
        if (r103 == false) goto L17;
        ContactDbFragmentOfficeContactPageLayoutBinding r105 = this.f419164d;
        if (r105 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r105 = null;
    L16:
        r105.f419014g.setOnActionClickListener(null);
    L24:
        ContactDbFragmentOfficeContactPageLayoutBinding r106 = this.f419164d;
        if (r106 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r106 = null;
    L27:
        r106.f419014g.setOnClickListener(c.f419179a);
        da0(CollectionsKt.emptyList());
        ContactDbFragmentOfficeContactPageLayoutBinding r107 = this.f419164d;
        if (r107 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r107 = null;
    L30:
        r107.f419013f.setVisibility(0);
        ContactDbFragmentOfficeContactPageLayoutBinding r108 = this.f419164d;
        if (r108 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r108 = null;
    L33:
        r108.f419014g.setVisibility(0);
        ContactDbFragmentOfficeContactPageLayoutBinding r109 = this.f419164d;
        if (r109 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
    L37:
        r101.f419010c.setVisibility(8);
        ea0();
        return;
    L36:
        r101 = r109;
        goto L37
    L17:
        ContactDbFragmentOfficeContactPageLayoutBinding r110 = this.f419164d;
        if (r110 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r110 = null;
    L20:
        r110.f419014g.setEmptyActionText(UIHelper.getString(R.string.LarkIM_Friend_NoContactsAdd_Button));
        ContactDbFragmentOfficeContactPageLayoutBinding r111 = this.f419164d;
        if (r111 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r111 = null;
    L23:
        r111.f419014g.setOnActionClickListener(new b(this));
        goto L24
    }

    public final void ca0() {
        ContactDbFragmentOfficeContactPageLayoutBinding r100 = this.f419164d;
        ContactDbFragmentOfficeContactPageLayoutBinding r101 = null;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r100 = null;
    L6:
        if (r100.f419011d.getVisibility() == 0) goto L11;
        ContactDbFragmentOfficeContactPageLayoutBinding r102 = this.f419164d;
        if (r102 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r102 = null;
    L10:
        r102.f419011d.setVisibility(0);
    L11:
        ContactDbFragmentOfficeContactPageLayoutBinding r103 = this.f419164d;
        if (r103 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r103 = null;
    L14:
        r103.f419013f.setVisibility(8);
        ContactDbFragmentOfficeContactPageLayoutBinding r104 = this.f419164d;
        if (r104 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
    L18:
        r101.f419014g.setVisibility(8);
        return;
    L17:
        r101 = r104;
        goto L18
    }

    public final void ea0() {
        Log.i("Contact_ExtContactFrag", "updateStateLayoutIfNeeded");
        ContactDbFragmentOfficeContactPageLayoutBinding r100 = this.f419164d;
        ContactDbFragmentOfficeContactPageLayoutBinding r101 = null;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r100 = null;
    L5:
        FrameLayout r102 = r100.f419013f;
        if (r102.getVisibility() == 0) goto L8;
        return;
    L8:
        ContactDbFragmentOfficeContactPageLayoutBinding r103 = this.f419164d;
        if (r103 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
    L12:
        CommonRecyclerView r104 = r101.f419012e;
        int r105 = (r104.getHeight() - r104.getPaddingTop()) - r104.getPaddingBottom();
        if (r105 > 0) goto L15;
        return;
    L15:
        com.ss.android.lark.contact.customized.externalcontact.view.list.a<?> r106 = this.f419171k;
        if (r106 == null) goto L18;
        int r107 = r106.f(r104);
    L19:
        if (r107 > 0) goto L21;
        return;
    L21:
        ViewGroup.LayoutParams r108 = r102.getLayoutParams();
        int r109 = RangesKt.coerceAtLeast(r105 - r107, 0);
        Log.i("Contact_ExtContactFrag", "newHeight: " + r109);
        if (r108 != null) goto L24;
        return;
    L24:
        if (r108.height == r109) goto L28;
        r108.height = r109;
        r102.setLayoutParams(r108);
        return;
    L28:
        return;
    L18:
        r107 = 0;
        goto L19
    L11:
        r101 = r103;
        goto L12
    }

    public final void hideLoading() {
        ContactDbFragmentOfficeContactPageLayoutBinding r100 = this.f419164d;
        ContactDbFragmentOfficeContactPageLayoutBinding r101 = null;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r100 = null;
    L5:
        r100.f419010c.setVisibility(8);
        ContactDbFragmentOfficeContactPageLayoutBinding r102 = this.f419164d;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
    L9:
        r101.f419013f.setVisibility(8);
        lt7.d r103 = this.f419172l;
        if (r103 == null) goto L13;
        r103.a();
        return;
    L13:
        return;
    L8:
        r101 = r102;
        goto L9
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragment, com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        Log.i("Contact_ExtContactFrag", "onDestroyView");
        this.f419171k = null;
        super.onDestroyView();
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [com.ss.android.lark.contact.customized.externalcontact.view.OfficeExternalContactFragment$forbiddenScrollItemListener$1] */
    public OfficeExternalContactFragment() {
        final Function0<Fragment> r100 = new OfficeExternalContactFragment$special$$inlined$viewModels$default$1(this);
        this.f419165e = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(OfficeExternalContactViewModel.class), new OfficeExternalContactFragment$special$$inlined$viewModels$default$2(r100), new OfficeExternalContactFragment$special$$inlined$viewModels$default$3(r100, this));
        LazyThreadSafetyMode r101 = LazyThreadSafetyMode.NONE;
        this.f419166f = LazyKt.lazy(r101, new OfficeExternalContactFragment$isExternalContactScene$2(this));
        this.f419167g = LazyKt.lazy(r101, new OfficeExternalContactFragment$isSidebarExperiment$2(this));
        this.f419168h = LazyKt.lazy(r101, new OfficeExternalContactFragment$from$2(this));
        this.f419169i = LazyKt.lazy(r101, OfficeExternalContactFragment$isEnterpriseAccount$2.INSTANCE);
        this.f419170j = LazyKt.lazy(r101, new OfficeExternalContactFragment$shouldLoadEnterpriseData$2(this));
        this.f419175o = "";
        this.f419176p = "";
        this.f419177q = new OfficeExternalContactFragment$forbiddenScrollItemListener$1();
    }

    public final l9b.a V90() {
        boolean r100 = false;
        if (aa0() == true) goto L5;
        boolean r101 = ((Boolean) this.f419167g.getValue()).booleanValue();
        Integer r102 = Integer.valueOf(this.f419174n);
        if (r102.intValue() <= 0) goto L9;
        r100 = true;
    L9:
        String r103 = null;
        if (r100 == true) goto L13;
        r102 = null;
    L13:
        if (r102 == null) goto L15;
        r103 = r102.toString();
    L15:
        if (r103 != null) goto L17;
        String r104 = "";
    L19:
        return new l9b.a(r101, r104, this.f419175o, true, Z90(), Z90(), new OfficeExternalContactFragment$buildHeaderConfig$2(this), new OfficeExternalContactFragment$buildHeaderConfig$3(this), new OfficeExternalContactFragment$buildHeaderConfig$4(this), new OfficeExternalContactFragment$buildHeaderConfig$5(this));
    L17:
        r104 = r103;
        goto L19
    L5:
        return new l9b.a(0);
    }

    public static final void S90(OfficeExternalContactFragment r100) {
        r100.getClass();
        Log.i("Contact_ExtContactFrag", "allowItemsScroll=" + r100.f419173m);
        if (r100.f419173m == false) goto L10;
        ContactDbFragmentOfficeContactPageLayoutBinding r101 = r100.f419164d;
        if (r101 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r101 = null;
    L8:
        r101.f419012e.removeOnItemTouchListener(r100.f419177q);
        r100.f419173m = false;
        return;
    }

    public static final void T90(OfficeExternalContactFragment r100) {
        Log.i("Contact_ExtContactFrag", "forbidItemsScroll=" + r100.f419173m);
        if (r100.f419173m == true) goto L10;
        ContactDbFragmentOfficeContactPageLayoutBinding r101 = r100.f419164d;
        if (r101 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r101 = null;
    L8:
        r101.f419012e.addOnItemTouchListener(r100.f419177q);
        r100.f419173m = true;
        return;
    }

    public static final /* synthetic */ Context U90(OfficeExternalContactFragment r100) {
        return r100.mContext;
    }

    public final void da0(List<?> r100) {
        com.ss.android.lark.contact.customized.externalcontact.view.list.a<?> r101 = this.f419171k;
        if (r101 == null) goto L6;
        Intrinsics.checkNotNullParameter(r100, "items");
        r101.g(r100);
        return;
    }

    public final <T> void Y90(i9b.a<? extends List<? extends T>> r100, Function1<? super List<? extends T>, Unit> r101) {
        ContactDbFragmentOfficeContactPageLayoutBinding r102 = null;
        if ((r100 instanceof i9b.a.b) == false) goto L25;
        Log.i("Contact_ExtContactFrag", "state=Loading");
        if (this.f419172l != null) goto L10;
        ContactDbFragmentOfficeContactPageLayoutBinding r103 = this.f419164d;
        if (r103 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r103 = null;
    L9:
        lt7.d.a r104 = new lt7.d.a(r103.f419010c);
        r104.f510707b = R.layout.contact_db_contact_list_skeleton;
        r104.a(R.color.ud_N500);
        r104.f510708c = UIUtils.canShowSkeleton();
        this.f419172l = r104.b();
    L10:
        ContactDbFragmentOfficeContactPageLayoutBinding r105 = this.f419164d;
        if (r105 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r105 = null;
    L13:
        r105.f419010c.setVisibility(0);
        ContactDbFragmentOfficeContactPageLayoutBinding r106 = this.f419164d;
        if (r106 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r106 = null;
    L16:
        r106.f419013f.setVisibility(0);
        ContactDbFragmentOfficeContactPageLayoutBinding r107 = this.f419164d;
        if (r107 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
    L20:
        r102.f419014g.setVisibility(8);
        lt7.d r108 = this.f419172l;
        if (r108 == null) goto L23;
        r108.b();
    L23:
        ea0();
        return;
    L19:
        r102 = r107;
        goto L20
    L25:
        if ((r100 instanceof i9b.a.c) == false) goto L41;
        hideLoading();
        ContactDbFragmentOfficeContactPageLayoutBinding r109 = this.f419164d;
        if (r109 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r109 = null;
    L29:
        r109.f419011d.refreshComplete();
        i9b.a.c r110 = (i9b.a.c) r100;
        if (((List) r110.f488829a).isEmpty() == false) goto L32;
        Log.i("Contact_ExtContactFrag", "state=Success(empty)");
        ba0();
        return;
    L32:
        Log.i("Contact_ExtContactFrag", "state=Success(size=" + ((List) r110.f488829a).size() + ')');
        ContactDbFragmentOfficeContactPageLayoutBinding r111 = this.f419164d;
        if (r111 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r111 = null;
    L35:
        r111.f419013f.setVisibility(8);
        ContactDbFragmentOfficeContactPageLayoutBinding r112 = this.f419164d;
        if (r112 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
    L39:
        r102.f419014g.setVisibility(8);
        r101.invoke(r110.f488829a);
        return;
    L38:
        r102 = r112;
        goto L39
    L41:
        if ((r100 instanceof i9b.a.C6245a) == false) goto L70;
        Log.i("Contact_ExtContactFrag", "state=Error(message=" + ((i9b.a.C6245a) r100).f488827a + ')');
        hideLoading();
        ContactDbFragmentOfficeContactPageLayoutBinding r113 = this.f419164d;
        if (r113 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r113 = null;
    L45:
        r113.f419014g.setEmptyIcon(R.drawable.contact_db_icon_load_failed);
        ContactDbFragmentOfficeContactPageLayoutBinding r114 = this.f419164d;
        if (r114 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r114 = null;
    L48:
        r114.f419014g.setEmptyText(UIHelper.getString(R.string.LarkIM_Common_LoadFailed_EmptyState));
        ContactDbFragmentOfficeContactPageLayoutBinding r115 = this.f419164d;
        if (r115 != null) goto L51;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r115 = null;
    L51:
        r115.f419014g.setEmptyActionText(UIHelper.getString(R.string.LarkIM_Common_Retry_Button));
        ContactDbFragmentOfficeContactPageLayoutBinding r116 = this.f419164d;
        if (r116 != null) goto L54;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r116 = null;
    L54:
        r116.f419014g.setOnActionClickListener(new l(this));
        ContactDbFragmentOfficeContactPageLayoutBinding r117 = this.f419164d;
        if (r117 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r117 = null;
    L57:
        r117.f419014g.setOnClickListener(m.f419232a);
        ContactDbFragmentOfficeContactPageLayoutBinding r118 = this.f419164d;
        if (r118 != null) goto L60;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r118 = null;
    L60:
        r118.f419013f.setVisibility(0);
        ContactDbFragmentOfficeContactPageLayoutBinding r119 = this.f419164d;
        if (r119 != null) goto L63;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r119 = null;
    L63:
        r119.f419014g.setVisibility(0);
        ContactDbFragmentOfficeContactPageLayoutBinding r120 = this.f419164d;
        if (r120 != null) goto L66;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
    L67:
        r102.f419010c.setVisibility(8);
        ea0();
        return;
    L66:
        r102 = r120;
        goto L67
    L70:
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Type inference failed for: r11v12, types: [com.ss.android.lark.contact.customized.externalcontact.view.OfficeExternalContactFragment$initExternalContactView$actionHandler$1, java.lang.Object] */
    @Override // com.ss.android.lark.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r110, Bundle r111) {
        Intrinsics.checkNotNullParameter(r110, "view");
        super.onViewCreated(r110, r111);
        Log.i("Contact_ExtContactFrag", "init isExternalContactScene=" + aa0() + " isEnterpriseAccount=" + Z90() + " isSidebarExperiment=" + ((Boolean) this.f419167g.getValue()).booleanValue() + " from=" + ((String) this.f419168h.getValue()));
        X90().onPageViewCreated(SystemClock.elapsedRealtime());
        ChatWindowPtrLoadingHeader r112 = new ChatWindowPtrLoadingHeader(this.mContext);
        ContactDbFragmentOfficeContactPageLayoutBinding r100 = this.f419164d;
        ContactDbFragmentOfficeContactPageLayoutBinding r101 = null;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r100 = null;
    L5:
        boolean r102 = true;
        r100.f419011d.setKeepHeaderWhenRefresh(true);
        ContactDbFragmentOfficeContactPageLayoutBinding r103 = this.f419164d;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r103 = null;
    L8:
        r103.f419011d.setFooterView(r112);
        ContactDbFragmentOfficeContactPageLayoutBinding r104 = this.f419164d;
        if (r104 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r104 = null;
    L11:
        r104.f419011d.addPtrUIHandler(r112);
        ContactDbFragmentOfficeContactPageLayoutBinding r113 = this.f419164d;
        if (r113 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r113 = null;
    L14:
        r113.f419011d.disableWhenHorizontalMove(true);
        ContactDbFragmentOfficeContactPageLayoutBinding r114 = this.f419164d;
        if (r114 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r114 = null;
    L17:
        r114.f419011d.setPtrHandler(new f(this));
        LinearLayoutManager r115 = new LinearLayoutManager(this.mContext, 1, false);
        ContactDbFragmentOfficeContactPageLayoutBinding r105 = this.f419164d;
        if (r105 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r105 = null;
    L20:
        r105.f419012e.setLayoutManager(r115);
        ?? r116 = new OfficeExternalContactFragment$initExternalContactView$actionHandler$1(this);
        if (aa0() == false) goto L24;
        com.ss.android.lark.contact.customized.externalcontact.view.list.a<?> r106 = new com.ss.android.lark.contact.customized.externalcontact.view.list.l();
    L27:
        this.f419171k = r106;
        l9b.a r107 = V90();
        com.ss.android.lark.contact.customized.externalcontact.view.list.a<?> r108 = this.f419171k;
        if (r108 == null) goto L131;
        Intrinsics.checkNotNullParameter(r116, "actionHandler");
        Intrinsics.checkNotNullParameter(r107, "headerConfig");
        IndexRecyclerViewAdapter r109 = r108.d();
        r108.f419222b = r109;
        if (r109 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("listAdapter");
        r109 = null;
    L32:
        r108.a(r109, r116);
        r108.f419221a = r108.c(r107);
        ArrayList r117 = new ArrayList();
        RecyclerView.Adapter<? extends RecyclerView.ViewHolder> r118 = r108.f419221a;
        if (r118 == null) goto L35;
        r117.add(r118);
    L35:
        IndexRecyclerViewAdapter<? extends RecyclerView.ViewHolder, ?> r119 = r108.f419222b;
        if (r119 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("listAdapter");
        r119 = null;
    L38:
        r117.add(r119);
        ConcatAdapter r120 = new ConcatAdapter(r117);
        DefaultItemAnimator r121 = new OfficeExternalContactFragment$initExternalContactView$defaultItemAnimator$1(this);
        r121.setSupportsChangeAnimations(false);
        ContactDbFragmentOfficeContactPageLayoutBinding r122 = this.f419164d;
        if (r122 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r122 = null;
    L41:
        r122.f419012e.setItemAnimator(r121);
        ContactDbFragmentOfficeContactPageLayoutBinding r123 = this.f419164d;
        if (r123 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r123 = null;
    L44:
        r123.f419012e.setAdapter(r120);
        getContext();
        ContactDbFragmentOfficeContactPageLayoutBinding r124 = this.f419164d;
        if (r124 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r124 = null;
    L47:
        LKUIPtrClassicFrameLayout r125 = r124.f419011d;
        ContactDbFragmentOfficeContactPageLayoutBinding r126 = this.f419164d;
        if (r126 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r126 = null;
    L50:
        CommonRecyclerView r127 = r126.f419012e;
        int r128 = DesktopUtil.f420394a;
        ContactDbFragmentOfficeContactPageLayoutBinding r129 = this.f419164d;
        if (r129 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r129 = null;
    L53:
        r129.f419012e.addOnLayoutChangeListener(new e(this));
        com.ss.android.lark.contact.customized.externalcontact.view.list.a<?> r130 = this.f419171k;
        if (r130 == null) goto L59;
        IndexRecyclerViewAdapter<? extends RecyclerView.ViewHolder, ?> r131 = r130.e();
        if (r131 == null) goto L59;
        r131.f418628c = !W90();
    L59:
        if (W90() == false) goto L68;
        ContactDbFragmentOfficeContactPageLayoutBinding r132 = this.f419164d;
        if (r132 != null) goto L63;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r132 = null;
    L63:
        r132.f419015h.setVisibility(8);
        ContactDbFragmentOfficeContactPageLayoutBinding r133 = this.f419164d;
        if (r133 != null) goto L66;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
    L67:
        r101.f419016i.setVisibility(8);
    L113:
        if (W90() == false) goto L115;
        X90().getEnterpriseContacts().observe(getViewLifecycleOwner(), new g(this));
    L116:
        X90().getOpenProfile().observe(getViewLifecycleOwner(), new i(this));
        if (aa0() == true) goto L119;
        X90().getSelfCardHeader().observe(getViewLifecycleOwner(), new j(this));
        X90().getNewFriendBadge().observe(getViewLifecycleOwner(), new k(this));
    L119:
        OfficeExternalContactViewModel r134 = X90();
        boolean r135 = W90();
        boolean r136 = aa0();
        if (((Boolean) this.f419167g.getValue()).booleanValue() == true) goto L122;
    L124:
        r102 = false;
    L125:
        r134.init(r135, r136, r102);
        if (aa0() == true) goto L128;
        int r137 = com.ss.android.lark.contact.customized.common.b.f418964a;
        com.ss.android.lark.contact.customized.common.b.c("contact", (String) this.f419168h.getValue());
    L128:
        X90().fetchData(W90());
        return;
    L122:
        if (aa0() == true) goto L124;
    L115:
        X90().getDoubaoContacts().observe(getViewLifecycleOwner(), new h(this));
        goto L116
    L66:
        r101 = r133;
        goto L67
    L68:
        ContactDbFragmentOfficeContactPageLayoutBinding r138 = this.f419164d;
        if (r138 != null) goto L71;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r138 = null;
    L71:
        final u r139 = new u(r138.f419008a);
        com.ss.android.lark.contact.customized.externalcontact.view.list.a<?> r140 = this.f419171k;
        if (r140 == null) goto L74;
        final IndexRecyclerViewAdapter<? extends RecyclerView.ViewHolder, ?> r141 = r140.e();
    L75:
        if (r141 != null) goto L77;
        Log.w("Contact_ExtContactFrag", "initIndexBar skipped because active index adapter is null");
        goto L113
    L77:
        ContactDbFragmentOfficeContactPageLayoutBinding r142 = this.f419164d;
        if (r142 != null) goto L80;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r142 = null;
    L80:
        final CommonRecyclerView r143 = r142.f419012e;
        RecyclerView.Adapter r144 = r143.getAdapter();
        if ((r144 instanceof ConcatAdapter) == false) goto L90;
        Iterator<? extends RecyclerView.Adapter<? extends RecyclerView.ViewHolder>> r145 = ((ConcatAdapter) r144).getAdapters().iterator();
        int r146 = 0;
    L85:
        if (r145.hasNext() == false) goto L90;
        RecyclerView.Adapter<? extends RecyclerView.ViewHolder> r147 = r145.next();
        if (r147 == r141) goto L91;
        r146 = r146 + r147.getItemCount();
    L91:
        View r148 = r139.f419254d;
        if (r148 == null) goto L94;
        r148.setOnClickListener(new p(r139, r143));
    L94:
        r139.f419253c.setOnTouchingLetterChangedListener(new s(r139, r141, r146, r143));
        r139.a(r141.f418627b);
        r141.A2(new q(r139, r141));
        r143.addOnScrollListener(new t(r139, r146, r141));
        o r149 = new o();
        Map<Integer, String> r150 = r141.f418627b;
        ContactDbFragmentOfficeContactPageLayoutBinding r151 = this.f419164d;
        if (r151 != null) goto L97;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
    L98:
        CommonRecyclerView r152 = r101.f419012e;
        Context r153 = r152.getContext();
        int r154 = o.b(r152);
        Map<Integer, String> r155 = OfficeFloatingBarItemDecoration.i(r150, r154);
        Integer r156 = Integer.valueOf(UIHelper.dp2px(38.0f));
        Integer r157 = Integer.valueOf(r154);
        Integer r158 = 0;
        Integer r159 = Integer.valueOf(UIUtils.getColor(r153, R.color.flow_ud_neutral_50));
        Float r160 = Float.valueOf(UIHelper.sp2px(13.0f));
        if (r157 != null) goto L101;
        int r161 = 0;
    L102:
        OfficeFloatingBarItemDecoration r162 = new OfficeFloatingBarItemDecoration(r153, r155, r161);
        if (r159 == null) goto L105;
        r162.f419186b.setColor(r159.intValue());
    L105:
        if (r160 == null) goto L107;
        r162.f419186b.setTextSize(r160.floatValue());
    L107:
        if (r158 == null) goto L109;
        r162.f419191g = r158.intValue();
    L109:
        if (r156 == null) goto L111;
        r162.f419188d = r156.intValue();
    L111:
        r149.f419235a = r162;
        r152.addItemDecoration(r162);
        o.a(r152).A2(new n(r149, r152));
        goto L113
    L101:
        r161 = r157.intValue();
        goto L102
    L97:
        r101 = r151;
    L90:
        r146 = 0;
        goto L91
    L74:
        r141 = null;
        goto L75
    L131:
        throw new IllegalArgumentException("Required value was null.".toString());
    L24:
        if (Z90() == false) goto L26;
        r106 = new com.ss.android.lark.contact.customized.externalcontact.view.list.h();
        goto L27
    L26:
        r106 = new com.ss.android.lark.contact.customized.externalcontact.view.list.j();
        goto L27
    }

    @Override // com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r110, ViewGroup r111, Bundle r112) {
        Intrinsics.checkNotNullParameter(r110, "inflater");
        super.onCreateView(r110, r111, r112);
        View r113 = r110.inflate(R.layout.contact_db_fragment_office_contact_page_layout, r111, false);
        int r114 = R.id.external_contact_content_layout;
        FrameLayout r100 = (FrameLayout) ViewBindings.findChildViewById(r113, R.id.external_contact_content_layout);
        if (r100 == null) goto L25;
        r114 = R.id.external_contact_loading_layout;
        LinearLayout r101 = (LinearLayout) ViewBindings.findChildViewById(r113, R.id.external_contact_loading_layout);
        if (r101 == null) goto L25;
        r114 = R.id.external_contact_ptr_layout;
        LKUIPtrClassicFrameLayout r102 = (LKUIPtrClassicFrameLayout) ViewBindings.findChildViewById(r113, R.id.external_contact_ptr_layout);
        if (r102 == null) goto L25;
        r114 = R.id.external_contact_rv;
        CommonRecyclerView r103 = (CommonRecyclerView) ViewBindings.findChildViewById(r113, R.id.external_contact_rv);
        if (r103 == null) goto L25;
        r114 = R.id.external_contact_state_layout;
        FrameLayout r104 = (FrameLayout) ViewBindings.findChildViewById(r113, R.id.external_contact_state_layout);
        if (r104 == null) goto L25;
        r114 = R.id.external_contact_state_view;
        ContactOfficeEmptyStateView r105 = (ContactOfficeEmptyStateView) ViewBindings.findChildViewById(r113, R.id.external_contact_state_view);
        if (r105 == null) goto L25;
        r114 = R.id.index_bar;
        if (((IndexBar) ViewBindings.findChildViewById(r113, R.id.index_bar)) == null) goto L25;
        r114 = R.id.index_bar_layout;
        FrameLayout r106 = (FrameLayout) ViewBindings.findChildViewById(r113, R.id.index_bar_layout);
        if (r106 == null) goto L25;
        r114 = R.id.index_bar_search;
        if (((ImageView) ViewBindings.findChildViewById(r113, R.id.index_bar_search)) == null) goto L25;
        r114 = R.id.index_bar_tip;
        TextView r107 = (TextView) ViewBindings.findChildViewById(r113, R.id.index_bar_tip);
        if (r107 == null) goto L25;
        RelativeLayout r115 = (RelativeLayout) r113;
        this.f419164d = new ContactDbFragmentOfficeContactPageLayoutBinding(r115, r100, r101, r102, r103, r104, r105, r106, r107);
        return r115;
    L25:
        throw new NullPointerException("Missing required view with ID: ".concat(r113.getResources().getResourceName(r114)));
    }
}
