package com.larus.showcase.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.bmhome.utils.LoadMoreManager;
import com.larus.common_ui.widget.concat_adapter.ConcatAdapter;
import com.larus.nova.R;
import com.larus.showcase.impl.databinding.LarusFragmentCaseListBinding;
import com.larus.showcase.impl.databinding.LarusPageCaseErrorBinding;
import com.larus.showcase.impl.databinding.LarusPageCaseLoadingSkeletonBinding;
import com.larus.utils.e1;
import com.larus.utils.i0;
import com.larus.utils.logger.FLogger;
import com.larus.utils.u;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import v19.y6;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0015\u0018\u0000 /2\u00020\u0001:\u0001/B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0005H\u0002J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0005H\u0002J\u0012\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J&\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u001a\u0010#\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020\u001e2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010%\u001a\u00020\u001aH\u0002J\b\u0010&\u001a\u00020\u001aH\u0002J\b\u0010'\u001a\u00020\u001aH\u0016J\n\u0010(\u001a\u0004\u0018\u00010\rH\u0002J\n\u0010)\u001a\u0004\u0018\u00010*H\u0002J\b\u0010+\u001a\u00020\u001aH\u0002J\b\u0010,\u001a\u00020\u001aH\u0002J\b\u0010-\u001a\u00020\u001aH\u0002J\b\u0010.\u001a\u00020\u001aH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0016¨\u00060"}, d2 = {"Lcom/larus/showcase/view/CaseListFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "tag", "", "binding", "Lcom/larus/showcase/impl/databinding/LarusFragmentCaseListBinding;", "loadMoreManager", "Lcom/larus/bmhome/utils/LoadMoreManager;", "viewModel", "Lcom/larus/showcase/view/CaseViewModel;", "listAdapter", "Lcom/larus/showcase/view/CaseListAdapter;", "needReloadCaseList", "", "isFromRecommend", "()Z", "setFromRecommend", "(Z)V", "caseListCallback", "com/larus/showcase/view/CaseListFragment$caseListCallback$1", "Lcom/larus/showcase/view/CaseListFragment$caseListCallback$1;", "getPageTitle", "getPreviousPage", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "onViewCreated", "view", "initView", "preFetchCurrentMessages", "onResume", "getCaseListAdapter", "getRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "initData", "observeData", "resetReloadStatue", LiveCommonConstants.REASON_ON_DEDTROY, "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CaseListFragment extends Fragment {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f369279j = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f369280d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LarusFragmentCaseListBinding f369281e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public LoadMoreManager f369282f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final CaseViewModel f369283g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public CaseListAdapter f369284h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final CaseListFragment$caseListCallback$1 f369285i;

    public static final class a {
    }

    public static final class b implements LoadMoreManager.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CaseListFragment f369286a;

        public b(CaseListFragment r100) {
            this.f369286a = r100;
        }

        @Override // com.larus.bmhome.utils.LoadMoreManager.b
        public final View a(FrameLayout r100) {
            Intrinsics.checkNotNullParameter(r100, "parent");
            return LayoutInflater.from(this.f369286a.getContext()).inflate(R.layout.larus_item_loadmore_loading, r100, false);
        }

        @Override // com.larus.bmhome.utils.LoadMoreManager.b
        public final View b(FrameLayout r100) {
            Intrinsics.checkNotNullParameter(r100, "parent");
            return LayoutInflater.from(this.f369286a.getContext()).inflate(R.layout.larus_item_loadmore_error, r100, false);
        }

        @Override // com.larus.bmhome.utils.LoadMoreManager.b
        public final View c(FrameLayout r100) {
            Intrinsics.checkNotNullParameter(r100, "parent");
            return LayoutInflater.from(this.f369286a.getContext()).inflate(R.layout.larus_empty_loadmore_end, r100, false);
        }
    }

    static {
    }

    public final CaseListAdapter S90() {
        LarusFragmentCaseListBinding r100 = this.f369281e;
        if (r100 == null) goto L5;
        RecyclerView r101 = r100.f369263d;
    L6:
        if (r101 == null) goto L8;
        RecyclerView.Adapter r102 = r101.getAdapter();
    L10:
        if ((r102 instanceof ConcatAdapter) == false) goto L12;
        ConcatAdapter r103 = (ConcatAdapter) r102;
    L13:
        if (r103 == null) goto L23;
        List<? extends RecyclerView.Adapter<? extends RecyclerView.ViewHolder>> r104 = r103.getAdapters();
        if (r104 == null) goto L23;
        Iterator<T> r105 = r104.iterator();
    L18:
        if (r105.hasNext() == false) goto L23;
        RecyclerView.Adapter r106 = (RecyclerView.Adapter) r105.next();
        if ((r106 instanceof CaseListAdapter) == false) goto L18;
        return (CaseListAdapter) r106;
    L23:
        return null;
    L12:
        r103 = null;
        goto L13
    L8:
        r102 = null;
        goto L10
    L5:
        r101 = null;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.larus.showcase.view.CaseListFragment$caseListCallback$1] */
    public CaseListFragment() {
        this.f369280d = "CaseListFragment" + hashCode();
        this.f369283g = new CaseViewModel();
        this.f369285i = new CaseListFragment$caseListCallback$1(this);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        FLogger.f375446a.i(this.f369280d, "[onResume], needReloadCaseList = false");
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        Context r101 = getContext();
        if (r101 != null) goto L5;
        return;
    L5:
        this.f369282f = new LoadMoreManager(r101, new com.larus.showcase.view.a(this), new b(this));
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r110, Bundle r111) {
        Intrinsics.checkNotNullParameter(r110, "view");
        super.onViewCreated(r110, r111);
        FLogger r112 = FLogger.f375446a;
        r112.i(this.f369280d, "[initView]");
        LarusFragmentCaseListBinding r113 = this.f369281e;
        if (r113 == null) goto L11;
        RecyclerView r100 = r113.f369263d;
        if (r100 == null) goto L11;
        r100.setLayoutManager(new LinearLayoutManager(r100.getContext()));
        r100.setItemAnimator(null);
        CaseListAdapter r114 = new CaseListAdapter(this.f369285i);
        this.f369284h = r114;
        LoadMoreManager r101 = this.f369282f;
        if (r101 == null) goto L9;
        ConcatAdapter r115 = r101.d(r100, r114);
    L10:
        boolean r116 = r115 instanceof ConcatAdapter;
        r100.setItemViewCacheSize(20);
        r100.addItemDecoration(new CaseListFragment$initView$1$2());
        r100.addOnScrollListener(new CaseListFragment$initView$1$3(this));
        y6.d(r100, null, null, null, new com.larus.showcase.view.b(this), 15);
        goto L11
    L9:
        r115 = null;
    L11:
        LarusFragmentCaseListBinding r117 = this.f369281e;
        if (r117 == null) goto L20;
        ConstraintLayout r118 = r117.f369266g;
        if (r118 == null) goto L20;
        ViewGroup.LayoutParams r102 = r118.getLayoutParams();
        if (r102 == null) goto L19;
        ViewGroup.MarginLayoutParams r103 = (ViewGroup.MarginLayoutParams) r102;
        i0.f375410a.getClass();
        r103.topMargin = i0.g();
        r118.setLayoutParams(r103);
        goto L20
    L19:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L20:
        LarusFragmentCaseListBinding r119 = this.f369281e;
        if (r119 == null) goto L29;
        RecyclerView r120 = r119.f369263d;
        if (r120 == null) goto L29;
        FragmentActivity r104 = getActivity();
        if (r104 == null) goto L27;
        int r105 = u.b(r104);
    L28:
        int r106 = r120.getPaddingStart();
        int r107 = r120.getPaddingTop();
        int r108 = r120.getPaddingEnd();
        r112.i("updatePaddingRelative", "view:" + r120.getClass().getSimpleName() + ",source:needAdaptNavigationBarPadding,start:" + r106 + ",top:" + r107 + ",end:" + r108 + ",bottom:" + r105);
        r120.setPaddingRelative(r106, r107, r108, r105);
        goto L29
    L27:
        r105 = 0;
    L29:
        LarusFragmentCaseListBinding r121 = this.f369281e;
        if (r121 == null) goto L34;
        ImageView r122 = r121.f369261b;
        if (r122 == null) goto L34;
        e1.d(r122, new c(this));
    L34:
        LarusFragmentCaseListBinding r123 = this.f369281e;
        if (r123 == null) goto L47;
        AppCompatTextView r124 = r123.f369265f;
        if (r124 == null) goto L47;
        Bundle r109 = getArguments();
        if (r109 == null) goto L42;
        String r125 = r109.getString("case_title");
        if (r125 == null) goto L42;
    L46:
        r124.setText(r125);
    L42:
        Context r126 = getContext();
        if (r126 == null) goto L45;
        r125 = r126.getString(R.string.larus_showcase_title_cn);
        goto L46
    L45:
        r125 = null;
    L47:
        r112.i(this.f369280d, "[initData]");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new CaseListFragment$observeData$1(this, null), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new CaseListFragment$observeData$2(this, null), 3, null);
        CaseViewModel r127 = this.f369283g;
        if (r127 == null) goto L51;
        r127.queryCaseList();
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r110, Bundle r111) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        FLogger.f375446a.i(this.f369280d, "[onCreateView]");
        View r101 = r100.inflate(R.layout.larus_fragment_case_list, r110, false);
        int r112 = R.id.back_icon;
        ImageView r102 = (ImageView) ViewBindings.findChildViewById(r101, R.id.back_icon);
        if (r102 == null) goto L23;
        r112 = R.id.case_error;
        View r103 = ViewBindings.findChildViewById(r101, R.id.case_error);
        if (r103 == null) goto L23;
        int r113 = R.id.profile_info_error_icon;
        if (((AppCompatImageView) ViewBindings.findChildViewById(r103, R.id.profile_info_error_icon)) == null) goto L21;
        r113 = R.id.profile_info_error_text;
        if (((AppCompatTextView) ViewBindings.findChildViewById(r103, R.id.profile_info_error_text)) == null) goto L21;
        LarusPageCaseErrorBinding r104 = new LarusPageCaseErrorBinding((ConstraintLayout) r103);
        r112 = R.id.case_list;
        RecyclerView r105 = (RecyclerView) ViewBindings.findChildViewById(r101, R.id.case_list);
        if (r105 == null) goto L23;
        r112 = R.id.case_loading;
        View r106 = ViewBindings.findChildViewById(r101, R.id.case_loading);
        if (r106 == null) goto L23;
        LarusPageCaseLoadingSkeletonBinding r107 = new LarusPageCaseLoadingSkeletonBinding((ConstraintLayout) r106);
        r112 = R.id.title;
        AppCompatTextView r108 = (AppCompatTextView) ViewBindings.findChildViewById(r101, R.id.title);
        if (r108 == null) goto L23;
        r112 = R.id.top_bar;
        ConstraintLayout r109 = (ConstraintLayout) ViewBindings.findChildViewById(r101, R.id.top_bar);
        if (r109 == null) goto L23;
        ConstraintLayout r114 = (ConstraintLayout) r101;
        this.f369281e = new LarusFragmentCaseListBinding(r114, r102, r104, r105, r107, r108, r109);
        return r114;
    L21:
        throw new NullPointerException("Missing required view with ID: ".concat(r103.getResources().getResourceName(r113)));
    L23:
        throw new NullPointerException("Missing required view with ID: ".concat(r101.getResources().getResourceName(r112)));
    }
}
