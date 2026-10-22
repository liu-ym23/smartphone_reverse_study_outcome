package com.bytedance.ee.bear.document.synced.block.references.doc;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ee.bear.document.k5;
import com.bytedance.ee.bear.document.synced.block.references.entity.DocReferencesResult;
import com.bytedance.ee.bear.document.synced.block.references.entity.ReferencesParams;
import com.bytedance.ee.bear.document.synced.block.references.main.SyncedSourceRefVM;
import com.bytedance.ee.bear.document.synced.block.references.main.SyncedSourceReferencesMainFragment;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.facade.common.empty.EmptyView;
import com.bytedance.ee.bear.facade.common.widget.recyclerview.LoadMoreFooter;
import com.bytedance.ee.bear.route.h;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.ContextsKt;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.android.dwarf.DwarfInjectPoint;
import e0c.l;
import java.util.ArrayList;
import java.util.HashMap;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@DwarfInjectPoint(parent = l.class)
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 (2\u00020\u00012\u00020\u0002:\u0001(B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J&\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u001a\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0010\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0010\u0010!\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020#H\u0002J\b\u0010$\u001a\u00020%H\u0016J\n\u0010&\u001a\u0004\u0018\u00010'H\u0016R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/bytedance/ee/bear/document/synced/block/references/doc/SyncedSourceDocReferencesFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/ss/android/lark/passportc/convention/view/UserScopeView;", "<init>", "()V", "routeService", "Lcom/bytedance/ee/bear/route/RouteService;", "getRouteService", "()Lcom/bytedance/ee/bear/route/RouteService;", "setRouteService", "(Lcom/bytedance/ee/bear/route/RouteService;)V", "spaceKitUrlHelper", "Lcom/bytedance/ee/bear/domain/container/ISpaceKitUrlHelper;", "getSpaceKitUrlHelper", "()Lcom/bytedance/ee/bear/domain/container/ISpaceKitUrlHelper;", "setSpaceKitUrlHelper", "(Lcom/bytedance/ee/bear/domain/container/ISpaceKitUrlHelper;)V", "viewModel", "Lcom/bytedance/ee/bear/document/synced/block/references/doc/SyncedSourceReferencesViewModel;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "reportItemClick", MapController.ITEM_LAYER_TAG, "Lcom/bytedance/ee/bear/document/synced/block/references/entity/DocReferencesResult$References;", "loadData", "emptyView", "Lcom/bytedance/ee/bear/facade/common/empty/EmptyView;", "provideUserSession", "Lcom/ss/android/lark/passportc/entity/UserSession;", "getContext", "Landroid/content/Context;", "Companion", "docs-doc-impl-native_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SyncedSourceDocReferencesFragment extends Hilt_SyncedSourceDocReferencesFragment implements d0c.c {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f221928i = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Inject
    public h f221929f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Inject
    public t45.c f221930g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public SyncedSourceReferencesViewModel f221931h;

    public static final class a {
    }

    public static final class b implements gqa.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SyncedSourceDocReferencesFragment f221932a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SyncedSourceDocReferencesAdapter f221933b;

        public b(SyncedSourceDocReferencesFragment r100, SyncedSourceDocReferencesAdapter r101) {
            this.f221932a = r100;
            this.f221933b = r101;
        }

        @Override // gqa.b
        public final void O0(cqa.h r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            SyncedSourceReferencesViewModel r101 = this.f221932a.f221931h;
            if (r101 == null) goto L9;
            String r102 = this.f221933b.f221921c;
            if (r102 != null) goto L7;
            r102 = "";
        L7:
            r101.loadDocumentReferenceMore(r102);
            return;
        }
    }

    public static final class c implements EmptyView.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SyncedSourceDocReferencesFragment f221934a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ EmptyView f221935b;

        public c(SyncedSourceDocReferencesFragment r100, EmptyView r101) {
            this.f221934a = r100;
            this.f221935b = r101;
        }

        @Override // com.bytedance.ee.bear.facade.common.empty.EmptyView.a
        public final void onFailedRetry() {
            SyncedSourceDocReferencesFragment r100 = this.f221934a;
            EmptyView r101 = this.f221935b;
            Intrinsics.checkNotNull(r101);
            int r102 = SyncedSourceDocReferencesFragment.f221928i;
            r100.U90(r101);
        }
    }

    public static final class d<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ EmptyView f221936a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ RecyclerView f221937b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ SyncedSourceDocReferencesAdapter f221938c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ SyncedSourceDocReferencesFragment f221939d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ SmartRefreshLayout f221940e;

        public d(EmptyView r100, RecyclerView r101, SyncedSourceDocReferencesAdapter r102, SyncedSourceDocReferencesFragment r103, SmartRefreshLayout r104) {
            this.f221936a = r100;
            this.f221937b = r101;
            this.f221938c = r102;
            this.f221939d = r103;
            this.f221940e = r104;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            DocReferencesResult r101 = (DocReferencesResult) r100;
            this.f221936a.setVisibility(4);
            this.f221937b.setAdapter(this.f221938c);
            SyncedSourceDocReferencesAdapter r102 = this.f221938c;
            ArrayList<DocReferencesResult.References> r103 = r101.getReferences();
            if (r103 != null) goto L5;
            r103 = new ArrayList();
        L5:
            SyncedSourceReferencesViewModel r104 = this.f221939d.f221931h;
            if (r104 == null) goto L8;
            r104.getNoPermissionCount();
        L8:
            r102.getClass();
            Intrinsics.checkNotNullParameter(r103, "data");
            r102.f221920b = new ArrayList(r103);
            if (hu5.a.d(r103) == true) goto L11;
            r102.y2((DocReferencesResult.References) ListProtector.get(r103, r102.f221920b.size() - 1));
        L11:
            r102.notifyDataSetChanged();
            this.f221940e.g(r101.getHasMore());
        }
    }

    public static final class e<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SmartRefreshLayout f221941a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SyncedSourceDocReferencesAdapter f221942b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ SyncedSourceDocReferencesFragment f221943c;

        public e(SmartRefreshLayout r100, SyncedSourceDocReferencesAdapter r101, SyncedSourceDocReferencesFragment r102) {
            this.f221941a = r100;
            this.f221942b = r101;
            this.f221943c = r102;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            DocReferencesResult r101 = (DocReferencesResult) r100;
            int r102 = 0;
            this.f221941a.b(0, false);
            this.f221941a.g(r101.getHasMore());
            SyncedSourceDocReferencesAdapter r103 = this.f221942b;
            ArrayList<DocReferencesResult.References> r104 = r101.getReferences();
            if (r104 != null) goto L5;
            r104 = new ArrayList();
        L5:
            SyncedSourceReferencesViewModel r105 = this.f221943c.f221931h;
            if (r105 == null) goto L8;
            r102 = r105.getNoPermissionCount();
        L8:
            r103.getClass();
            Intrinsics.checkNotNullParameter(r104, "data");
            if (hu5.a.d(r104) == false) goto L11;
            return;
        L11:
            if (hu5.a.d(r103.f221920b) == true) goto L20;
            r103.y2((DocReferencesResult.References) ListProtector.get(r104, r104.size() - 1));
            ArrayList<a45.a> r106 = r103.f221920b;
            a45.a r107 = (a45.a) ListProtector.get(r106, r106.size() - 1);
            if ((r107 instanceof a45.b) == false) goto L16;
            ((a45.b) r107).f1765a = r102;
            ArrayList<a45.a> r108 = r103.f221920b;
            r108.addAll(r108.size() - 1, r104);
        L17:
            r103.notifyDataSetChanged();
            return;
        L16:
            r103.f221920b.addAll(r104);
            goto L17
        }
    }

    public static final class f<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ EmptyView f221944a;

        public f(EmptyView r100) {
            this.f221944a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Throwable r101 = (Throwable) r100;
            this.f221944a.setVisibility(0);
            this.f221944a.a();
        }
    }

    public static final class g implements SyncedSourceDocReferencesAdapter.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SyncedSourceDocReferencesFragment f221945a;

        public g(SyncedSourceDocReferencesFragment r100) {
            this.f221945a = r100;
        }

        @Override // com.bytedance.ee.bear.document.synced.block.references.doc.SyncedSourceDocReferencesAdapter.b
        public final void a(DocReferencesResult.References r100) {
            Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
            Fragment r101 = this.f221945a.getParentFragment();     // Catch: Throwable -> L19
            if ((r100 instanceof DocReferencesResult.References) == true) goto L6;
        L17:
            tt5.a.d("SyncedSourceReferencesFragment", "param error");     // Catch: Throwable -> L19
            return;
        L6:
            if ((r101 instanceof SyncedSourceReferencesMainFragment) == false) goto L17;
            ((SyncedSourceRefVM) new ViewModelProvider(r101).get(SyncedSourceRefVM.class)).getLiveItemClick().setValue(r100.getUrl());     // Catch: Throwable -> L19
            if (k5.a(r100.getUrl(), ((SyncedSourceReferencesMainFragment) r101).f221956l) == true) goto L15;
            h r102 = this.f221945a.f221929f;     // Catch: Throwable -> L19
            if (r102 != null) goto L14;
            Intrinsics.throwUninitializedPropertyAccessException("routeService");     // Catch: Throwable -> L19
            r102 = null;
        L14:
            r102.u5(r100.getUrl());     // Catch: Throwable -> L19
            tt5.a.h("SyncedSourceReferencesFragment", "jump url");     // Catch: Throwable -> L19
        L16:
            SyncedSourceDocReferencesFragment.T90(this.f221945a, r100);     // Catch: Throwable -> L19
            return;
        L15:
            tt5.a.h("SyncedSourceReferencesFragment", "jump with url fragment");     // Catch: Throwable -> L19
        L19:
            th = move-exception;
            tt5.a.f("SyncedSourceReferencesFragment", th, false);
        }
    }

    static {
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void afterUserOffline(f0c.h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void afterUserOnline(f0c.h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // dagger.hilt.android.dwarf.DwarfComponentProvider, dagger.hilt.internal.GeneratedComponentManager
    public final /* synthetic */ Object generatedComponent() {
        return DwarfComponentProvider.CC.$default$generatedComponent(this);
    }

    @Override // com.ss.android.lark.passportc.api.r
    public final /* synthetic */ m getPassport() {
        return d0c.b.a(this);
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void onUserOffline(f0c.h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void onUserOnline(f0c.h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // d0c.c, dagger.hilt.android.dwarf.DwarfComponentProvider
    public final /* synthetic */ l provideComponent() {
        return d0c.b.b(this);
    }

    @Override // d0c.c
    public final UserSession e9() {
        return PassportcConvention.b(this);
    }

    @Override // com.bytedance.ee.bear.document.synced.block.references.doc.Hilt_SyncedSourceDocReferencesFragment, androidx.fragment.app.Fragment
    public Context getContext() {
        Context r100 = super.getContext();
        if (r100 != null) goto L7;
        return null;
    L7:
        return ContextsKt.findActivity(r100);
    }

    @Override // dagger.hilt.android.dwarf.DwarfComponentProvider
    public final /* bridge */ /* synthetic */ Object provideComponent() {
        return provideComponent();
    }

    public SyncedSourceDocReferencesFragment() {
    }

    public final void U90(EmptyView r100) {
        r100.setVisibility(0);
        r100.showLoading();
        Bundle r101 = getArguments();
        if (r101 == null) goto L5;
        ReferencesParams r102 = (ReferencesParams) r101.getParcelable("key_references_param");
    L6:
        if (r102 != null) goto L9;
        tt5.a.k("SyncedSourceReferencesFragment", "param is null");
        r100.showNoFound();
        return;
    L9:
        SyncedSourceReferencesViewModel r103 = this.f221931h;
        if (r103 == null) goto L13;
        r103.loadDocumentReference(r102);
        return;
    L13:
        return;
    L5:
        r102 = null;
        goto L6
    }

    public static final void T90(SyncedSourceDocReferencesFragment r100, DocReferencesResult.References r101) {
        r100.getClass();
        HashMap r102 = new HashMap();
        r102.put("click", "block_custom_action");
        r102.put(PickerReporterConstants.KEY.TARGET, "none");
        HashMap r103 = new HashMap();
        r103.put("object_block_id", du5.b.g(r101.getObjId()));
        if (TextUtils.isEmpty(r101.getTagFirst()) == false) goto L5;
        String r104 = "Synced Block";
    L6:
        r103.put("object_block_type", r104);
        r103.put("object_sub_block_type", "none");
        r102.put("object_block_data", r103);
        if (TextUtils.isEmpty(r101.getTagFirst()) == false) goto L9;
        String r105 = "click_synced_source_reference_docs";
    L10:
        r102.put("action_type", r105);
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6)).n("ccm_doc_content_page_click", r102);
        return;
    L9:
        r105 = "click_synced_reference_source_docs";
        goto L10
    L5:
        r104 = "Synced Block’";
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r110, Bundle r111) {
        Intrinsics.checkNotNullParameter(r110, "view");
        super.onViewCreated(r110, r111);
        EmptyView r112 = (EmptyView) r110.findViewById(R.id.empty_view);
        boolean r100 = false;
        r112.setLoadViewMarginTop(0);
        RecyclerView r101 = (RecyclerView) r110.findViewById(R.id.synced_source_doc_rv);
        SmartRefreshLayout r102 = (SmartRefreshLayout) r110.findViewById(R.id.refresh_layout);
        r102.F(new LoadMoreFooter(r110.getContext()), -2);
        r101.setLayoutManager(new LinearLayoutManager(r110.getContext(), 1, false));
        SyncedSourceReferencesViewModel r113 = (SyncedSourceReferencesViewModel) new ViewModelProvider(this).get(SyncedSourceReferencesViewModel.class);
        this.f221931h = r113;
        if (r113 == null) goto L9;
        Bundle r103 = getArguments();
        if (r103 == null) goto L7;
        BearUrl r104 = (BearUrl) r103.getParcelable("bear_url");
    L8:
        r113.setBearUrl(r104);
        goto L9
    L7:
        r104 = null;
    L9:
        SyncedSourceReferencesViewModel r114 = this.f221931h;
        if (r114 == null) goto L17;
        Bundle r105 = getArguments();
        if (r105 != null) goto L14;
    L16:
        r114.setSyncLink(r100);
        goto L17
    L14:
        if (r105.getBoolean("key_is_sync_link") != true) goto L16;
        r100 = true;
    L17:
        SyncedSourceDocReferencesAdapter r115 = new SyncedSourceDocReferencesAdapter(new g(this));
        r102.i(new b(this, r115));
        r112.setOnRetryListener(new c(this, r112));
        SyncedSourceReferencesViewModel r106 = this.f221931h;
        if (r106 == null) goto L22;
        MutableLiveData<DocReferencesResult> r107 = r106.getLiveInitLoadData();
        if (r107 == null) goto L22;
        r107.observe(getViewLifecycleOwner(), new d(r112, r101, r115, this, r102));
    L22:
        SyncedSourceReferencesViewModel r108 = this.f221931h;
        if (r108 == null) goto L27;
        MutableLiveData<DocReferencesResult> r109 = r108.getLiveLoadMoreData();
        if (r109 == null) goto L27;
        r109.observe(getViewLifecycleOwner(), new e(r102, r115, this));
    L27:
        SyncedSourceReferencesViewModel r116 = this.f221931h;
        if (r116 == null) goto L32;
        MutableLiveData<Throwable> r117 = r116.getLiveInitError();
        if (r117 == null) goto L32;
        r117.observe(getViewLifecycleOwner(), new f(r112));
    L32:
        Intrinsics.checkNotNull(r112);
        U90(r112);
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.doc_synced_source_doc_references, r101, false);
    }
}
