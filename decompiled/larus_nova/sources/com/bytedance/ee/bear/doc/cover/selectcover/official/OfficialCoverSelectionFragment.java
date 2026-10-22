package com.bytedance.ee.bear.doc.cover.selectcover.official;

import android.content.res.Configuration;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.contract.i0;
import com.bytedance.ee.bear.doc.cover.CoverViewModel;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.ee.bear.l;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEmptyState;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larksuite.component.universe_design.emptystate.UDEmptyState;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import my4.d;
import my4.e;
import my4.f;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 ,2\u00020\u00012\u00020\u0002:\u0001,B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J&\u0010\u0019\u001a\u0004\u0018\u00010\n2\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u001a\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\n2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0010\u0010 \u001a\u00020\u00162\u0006\u0010!\u001a\u00020\nH\u0002J\u0018\u0010\"\u001a\u00020\u00162\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020$H\u0002J\b\u0010&\u001a\u00020\u0016H\u0002J\u0010\u0010'\u001a\u00020\u00162\u0006\u0010(\u001a\u00020)H\u0016J\b\u0010*\u001a\u00020\u0016H\u0002J\b\u0010+\u001a\u00020\u0016H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/bytedance/ee/bear/doc/cover/selectcover/official/OfficialCoverSelectionFragment;", "Lcom/bytedance/ee/bear/facade/common/BaseFragment;", "Lcom/bytedance/ee/bear/IFullScreenPage;", "<init>", "()V", "mDocViewModel", "Lcom/bytedance/ee/bear/document/DocViewModel;", "mCoverViewModel", "Lcom/bytedance/ee/bear/doc/cover/CoverViewModel;", "mLoadingView", "Landroid/view/View;", "mLoadFailedView", "mEmptyState", "Lcom/bytedance/ee/bear/widgets/universedesign/SpaceEmptyState;", "mCoverContainer", "mCoverSeriesRV", "Landroidx/recyclerview/widget/RecyclerView;", "mCoverSeriesAdapter", "Lcom/bytedance/ee/bear/doc/cover/selectcover/official/CoverSeriesAdapter;", "mDisposable", "Lio/reactivex/disposables/Disposable;", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "onViewCreated", "view", "initView", "rootView", "switchViewState", "isLoading", "", "isLoadFailed", "renderCoverData", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "fetchRemoteCoverData", "onDestroyView", "Companion", "docs-doc-impl-native_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficialCoverSelectionFragment extends BaseFragment implements l {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f217840m = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public DocViewModel f217841e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public CoverViewModel f217842f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f217843g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f217844h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public SpaceEmptyState f217845i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public View f217846j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public RecyclerView f217847k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public CoverSeriesAdapter f217848l;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OfficialCoverSelectionFragment f217849a;

        public b(OfficialCoverSelectionFragment r100) {
            this.f217849a = r100;
        }

        public final void a() {
            if (this.f217849a.isResumed() == true) goto L5;
            return;
        L5:
            View r100 = this.f217849a.getView();
            if (r100 == null) goto L8;
            int r101 = r100.getWidth();
        L9:
            tt5.a.h("DocCover_OfficialCoverSelectionFragment", "renderCoverData onConfigurationChanged post width=" + r101);
            CoverSeriesAdapter r102 = this.f217849a.f217848l;
            if (r102 != null) goto L12;
            return;
        L12:
            if (r102.f217832e <= 0) goto L33;
            CoverSeriesAdapter r103 = null;
            if (r102 != null) goto L17;
            Intrinsics.throwUninitializedPropertyAccessException("mCoverSeriesAdapter");
            r102 = null;
        L17:
            if (r102.f217832e == r101) goto L34;
            CoverSeriesAdapter r104 = this.f217849a.f217848l;
            if (r104 != null) goto L22;
            Intrinsics.throwUninitializedPropertyAccessException("mCoverSeriesAdapter");
            r104 = null;
        L22:
            if (r104.getItemCount() <= 0) goto L35;
            tt5.a.h("DocCover_OfficialCoverSelectionFragment", "onConfigurationChanged notifyDataSetChanged");
            CoverSeriesAdapter r105 = this.f217849a.f217848l;
            if (r105 != null) goto L26;
            Intrinsics.throwUninitializedPropertyAccessException("mCoverSeriesAdapter");
            r105 = null;
        L26:
            r105.f217832e = r101;
            tt5.a.h("CoverSeriesAdapter", "updateContainerWidth=" + r101);
            CoverSeriesAdapter r106 = this.f217849a.f217848l;
            if (r106 != null) goto L29;
            Intrinsics.throwUninitializedPropertyAccessException("mCoverSeriesAdapter");
        L30:
            r103.notifyDataSetChanged();
            return;
        L29:
            r103 = r106;
            goto L30
        L35:
            return;
        L34:
            return;
        L33:
            return;
        L8:
            r101 = 0;
            goto L9
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public OfficialCoverSelectionFragment() {
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
    }

    public static final void U90(OfficialCoverSelectionFragment r100) {
        r100.getClass();
        tt5.a.h("DocCover_OfficialCoverSelectionFragment", "fetchRemoteCoverData()...");
        r100.V90(true, false);
        CoverViewModel r101 = r100.f217842f;
        DocViewModel r102 = null;
        if (r101 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mCoverViewModel");
        r101 = null;
    L6:
        if (r101.isCoverDataNotExist() == false) goto L24;
        CoverViewModel r103 = r100.f217842f;
        if (r103 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mCoverViewModel");
        r103 = null;
    L11:
        if (r103.isRemoteLoading() == true) goto L25;
        CoverViewModel r104 = r100.f217842f;
        if (r104 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mCoverViewModel");
        r104 = null;
    L15:
        DocViewModel r105 = r100.f217841e;
        if (r105 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("mDocViewModel");
        r105 = null;
    L18:
        String r106 = r105.getToken();
        DocViewModel r107 = r100.f217841e;
        if (r107 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("mDocViewModel");
    L22:
        r104.fetchOfficialCoverData(r106, r102.getDocumentTypeValue(), new d(r100));
        return;
    L21:
        r102 = r107;
        goto L22
    L25:
        return;
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
        super.onConfigurationChanged(r100);
        View r101 = getView();
        if (r101 == null) goto L6;
        r101.post(new b(this));
        return;
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        this.f217841e = (DocViewModel) q.a(this, DocViewModel.class);
        this.f217842f = (CoverViewModel) q.a(this, CoverViewModel.class);
    }

    public final void V90(boolean r100, boolean r101) {
        View r102 = this.f217843g;
        View r103 = null;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mLoadingView");
        r102 = null;
    L5:
        int r104 = 0;
        if (r100 == false) goto L8;
        int r105 = 0;
    L9:
        r102.setVisibility(r105);
        View r106 = this.f217844h;
        if (r106 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mLoadFailedView");
        r106 = null;
    L12:
        if (r101 == false) goto L14;
        int r107 = 0;
    L15:
        r106.setVisibility(r107);
        View r108 = this.f217846j;
        if (r108 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("mCoverContainer");
    L19:
        if (r100 == true) goto L21;
        if (r101 == true) goto L21;
    L22:
        r103.setVisibility(r104);
        return;
    L21:
        r104 = 8;
        goto L22
    L18:
        r103 = r108;
        goto L19
    L14:
        r107 = 8;
        goto L15
    L8:
        r105 = 8;
        goto L9
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        this.f217843g = r100.findViewById(R.id.loading_layout);
        this.f217844h = r100.findViewById(R.id.load_failed_layout);
        this.f217846j = r100.findViewById(R.id.cover_container);
        RecyclerView r102 = (RecyclerView) r100.findViewById(R.id.cover_series_rv);
        this.f217847k = r102;
        CoverViewModel r103 = null;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mCoverSeriesRV");
        r102 = null;
    L5:
        r102.setLayoutManager(new LinearLayoutManager(getContext()));
        CoverSeriesAdapter r104 = new CoverSeriesAdapter();
        this.f217848l = r104;
        String r105 = ((i0) org.koin.java.a.c(i0.class, null, null, 6)).a();
        Intrinsics.checkNotNullParameter(r105, "language");
        r104.f217828a = r105;
        CoverSeriesAdapter r106 = this.f217848l;
        if (r106 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mCoverSeriesAdapter");
        r106 = null;
    L8:
        r106.f217831d = new e(this);
        RecyclerView r107 = this.f217847k;
        if (r107 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mCoverSeriesRV");
        r107 = null;
    L11:
        CoverSeriesAdapter r108 = this.f217848l;
        if (r108 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mCoverSeriesAdapter");
        r108 = null;
    L14:
        r107.setAdapter(r108);
        this.f217845i = (SpaceEmptyState) r100.findViewById(R.id.empty_state);
        String r109 = getString(R.string.CreationMobile_Docs_DocCover_UnableToLoad_Tooltip);
        String r110 = getString(R.string.CreationMobile_Docs_DocCover_ClickToReload_Button);
        SpannableString r111 = new SpannableString(r109 + r110);
        r111.setSpan(new UDEmptyState.b(new f(this)), r109.length(), r109.length() + r110.length(), 33);
        SpaceEmptyState r112 = this.f217845i;
        if (r112 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mEmptyState");
        r112 = null;
    L17:
        r112.setDesc(r111);
        CoverViewModel r113 = this.f217842f;
        if (r113 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("mCoverViewModel");
        r113 = null;
    L21:
        if (r113.isCoverDataNotExist() == false) goto L26;
        CoverViewModel r114 = this.f217842f;
        if (r114 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("mCoverViewModel");
        r114 = null;
    L25:
        r114.isEnterAnimationShowing().observe(this, new AnonymousClass1(this));
    L26:
        CoverViewModel r115 = this.f217842f;
        if (r115 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("mCoverViewModel");
    L30:
        r103.getCoverSeriesList().observe(this, new OfficialCoverSelectionFragment$renderCoverData$1(this));
        return;
    L29:
        r103 = r115;
        goto L30
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.doc_cover_official_selection_fragment, r101, false);
    }
}
