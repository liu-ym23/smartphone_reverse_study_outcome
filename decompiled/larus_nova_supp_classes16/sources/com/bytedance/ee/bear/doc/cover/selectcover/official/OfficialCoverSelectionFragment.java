package com.bytedance.ee.bear.doc.cover.selectcover.official;

import android.content.res.Configuration;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.contract.i0;
import com.bytedance.ee.bear.doc.cover.CoverViewModel;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.ee.bear.l;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEmptyState;
import com.larksuite.component.universe_design.emptystate.UDEmptyState;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import my4.d;
import my4.e;
import my4.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 ,2\u00020\u00012\u00020\u0002:\u0001,B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J&\u0010\u0019\u001a\u0004\u0018\u00010\n2\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u001a\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\n2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0010\u0010 \u001a\u00020\u00162\u0006\u0010!\u001a\u00020\nH\u0002J\u0018\u0010\"\u001a\u00020\u00162\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020$H\u0002J\b\u0010&\u001a\u00020\u0016H\u0002J\u0010\u0010'\u001a\u00020\u00162\u0006\u0010(\u001a\u00020)H\u0016J\b\u0010*\u001a\u00020\u0016H\u0002J\b\u0010+\u001a\u00020\u0016H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/bytedance/ee/bear/doc/cover/selectcover/official/OfficialCoverSelectionFragment;", "Lcom/bytedance/ee/bear/facade/common/BaseFragment;", "Lcom/bytedance/ee/bear/IFullScreenPage;", "<init>", "()V", "mDocViewModel", "Lcom/bytedance/ee/bear/document/DocViewModel;", "mCoverViewModel", "Lcom/bytedance/ee/bear/doc/cover/CoverViewModel;", "mLoadingView", "Landroid/view/View;", "mLoadFailedView", "mEmptyState", "Lcom/bytedance/ee/bear/widgets/universedesign/SpaceEmptyState;", "mCoverContainer", "mCoverSeriesRV", "Landroidx/recyclerview/widget/RecyclerView;", "mCoverSeriesAdapter", "Lcom/bytedance/ee/bear/doc/cover/selectcover/official/CoverSeriesAdapter;", "mDisposable", "Lio/reactivex/disposables/Disposable;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "initView", "rootView", "switchViewState", "isLoading", "", "isLoadFailed", "renderCoverData", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "fetchRemoteCoverData", "onDestroyView", "Companion", "docs-doc-impl-native_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficialCoverSelectionFragment extends BaseFragment implements l {
    public static final /* synthetic */ int m = 0;
    public DocViewModel e;
    public CoverViewModel f;
    public View g;
    public View h;
    public SpaceEmptyState i;
    public View j;
    public RecyclerView k;
    public CoverSeriesAdapter l;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ OfficialCoverSelectionFragment a;

        public b(OfficialCoverSelectionFragment r1) {
            this.a = r1;
        }

        public final void a() {
            if (this.a.isResumed() == true) goto L5;
            return;
        L5:
            View r0 = this.a.getView();
            if (r0 == null) goto L8;
            int r1 = r0.getWidth();
        L9:
            tt5.a.h("DocCover_OfficialCoverSelectionFragment", "renderCoverData onConfigurationChanged post width=" + r1);
            CoverSeriesAdapter r2 = this.a.l;
            if (r2 != null) goto L12;
            return;
        L12:
            if (r2.e <= 0) goto L33;
            CoverSeriesAdapter r3 = null;
            if (r2 != null) goto L17;
            Intrinsics.throwUninitializedPropertyAccessException("mCoverSeriesAdapter");
            r2 = null;
        L17:
            if (r2.e == r1) goto L34;
            CoverSeriesAdapter r4 = this.a.l;
            if (r4 != null) goto L22;
            Intrinsics.throwUninitializedPropertyAccessException("mCoverSeriesAdapter");
            r4 = null;
        L22:
            if (r4.getItemCount() <= 0) goto L35;
            tt5.a.h("DocCover_OfficialCoverSelectionFragment", "onConfigurationChanged notifyDataSetChanged");
            CoverSeriesAdapter r5 = this.a.l;
            if (r5 != null) goto L26;
            Intrinsics.throwUninitializedPropertyAccessException("mCoverSeriesAdapter");
            r5 = null;
        L26:
            r5.e = r1;
            tt5.a.h("CoverSeriesAdapter", "updateContainerWidth=" + r1);
            CoverSeriesAdapter r6 = this.a.l;
            if (r6 != null) goto L29;
            Intrinsics.throwUninitializedPropertyAccessException("mCoverSeriesAdapter");
        L30:
            r3.notifyDataSetChanged();
            return;
        L29:
            r3 = r6;
            goto L30
        L35:
            return;
        L34:
            return;
        L33:
            return;
        L8:
            r1 = 0;
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

    public final void onDestroyView() {
        super.onDestroyView();
    }

    public static final void U90(OfficialCoverSelectionFragment r5) {
        r5.getClass();
        tt5.a.h("DocCover_OfficialCoverSelectionFragment", "fetchRemoteCoverData()...");
        r5.V90(true, false);
        CoverViewModel r0 = r5.f;
        DocViewModel r2 = null;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mCoverViewModel");
        r0 = null;
    L6:
        if (r0.isCoverDataNotExist() == false) goto L24;
        CoverViewModel r1 = r5.f;
        if (r1 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mCoverViewModel");
        r1 = null;
    L11:
        if (r1.isRemoteLoading() == true) goto L25;
        CoverViewModel r3 = r5.f;
        if (r3 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mCoverViewModel");
        r3 = null;
    L15:
        DocViewModel r4 = r5.e;
        if (r4 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("mDocViewModel");
        r4 = null;
    L18:
        String r6 = r4.getToken();
        DocViewModel r7 = r5.e;
        if (r7 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("mDocViewModel");
    L22:
        r3.fetchOfficialCoverData(r6, r2.getDocumentTypeValue(), new d(r5));
        return;
    L21:
        r2 = r7;
        goto L22
    L25:
        return;
    }

    public final void onConfigurationChanged(Configuration r2) {
        Intrinsics.checkNotNullParameter(r2, "newConfig");
        super.onConfigurationChanged(r2);
        View r3 = getView();
        if (r3 == null) goto L6;
        r3.post(new b(this));
        return;
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment
    public final void onCreate(Bundle r1) {
        super.onCreate(r1);
        this.e = (DocViewModel) q.a(this, DocViewModel.class);
        this.f = (CoverViewModel) q.a(this, CoverViewModel.class);
    }

    public final void V90(boolean r6, boolean r7) {
        View r0 = this.g;
        View r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mLoadingView");
        r0 = null;
    L5:
        int r2 = 0;
        if (r6 == false) goto L8;
        int r4 = 0;
    L9:
        r0.setVisibility(r4);
        View r3 = this.h;
        if (r3 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mLoadFailedView");
        r3 = null;
    L12:
        if (r7 == false) goto L14;
        int r5 = 0;
    L15:
        r3.setVisibility(r5);
        View r8 = this.j;
        if (r8 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("mCoverContainer");
    L19:
        if (r6 == true) goto L21;
        if (r7 == true) goto L21;
    L22:
        r1.setVisibility(r2);
        return;
    L21:
        r2 = 8;
        goto L22
    L18:
        r1 = r8;
        goto L19
    L14:
        r5 = 8;
        goto L15
    L8:
        r4 = 8;
        goto L9
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment
    public final void onViewCreated(View r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r5, "view");
        super.onViewCreated(r5, r6);
        this.g = r5.findViewById(2131379045);
        this.h = r5.findViewById(2131378945);
        this.j = r5.findViewById(2131368150);
        RecyclerView r7 = r5.findViewById(2131368168);
        this.k = r7;
        CoverViewModel r0 = null;
        if (r7 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mCoverSeriesRV");
        r7 = null;
    L5:
        r7.setLayoutManager(new LinearLayoutManager(getContext()));
        CoverSeriesAdapter r8 = new CoverSeriesAdapter();
        this.l = r8;
        String r2 = ((i0) org.koin.java.a.c(i0.class, null, null, 6)).a();
        Intrinsics.checkNotNullParameter(r2, "language");
        r8.a = r2;
        CoverSeriesAdapter r9 = this.l;
        if (r9 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mCoverSeriesAdapter");
        r9 = null;
    L8:
        r9.d = new e(this);
        RecyclerView r10 = this.k;
        if (r10 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mCoverSeriesRV");
        r10 = null;
    L11:
        CoverSeriesAdapter r1 = this.l;
        if (r1 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mCoverSeriesAdapter");
        r1 = null;
    L14:
        r10.setAdapter(r1);
        this.i = r5.findViewById(2131371597);
        String r11 = getString(2131887181);
        String r12 = getString(2131887172);
        SpannableString r3 = new SpannableString(r11 + r12);
        r3.setSpan(new UDEmptyState.b(new f(this)), r11.length(), r11.length() + r12.length(), 33);
        UDEmptyState r13 = this.i;
        if (r13 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mEmptyState");
        r13 = null;
    L17:
        r13.setDesc(r3);
        CoverViewModel r14 = this.f;
        if (r14 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("mCoverViewModel");
        r14 = null;
    L21:
        if (r14.isCoverDataNotExist() == false) goto L26;
        CoverViewModel r16 = this.f;
        if (r16 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("mCoverViewModel");
        r16 = null;
    L25:
        r16.isEnterAnimationShowing().observe(this, new AnonymousClass1(this));
    L26:
        CoverViewModel r17 = this.f;
        if (r17 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("mCoverViewModel");
    L30:
        r0.getCoverSeriesList().observe(this, new OfficialCoverSelectionFragment$renderCoverData$1(this));
        return;
    L29:
        r0 = r17;
        goto L30
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131560075, r3, false);
    }
}
