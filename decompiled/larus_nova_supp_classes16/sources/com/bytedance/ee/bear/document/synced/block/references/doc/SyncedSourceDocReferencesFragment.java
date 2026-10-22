package com.bytedance.ee.bear.document.synced.block.references.doc;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
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
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.utils.ContextsKt;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.android.dwarf.DwarfInjectPoint;
import e0c.l;
import java.util.ArrayList;
import java.util.HashMap;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@DwarfInjectPoint(parent = l.class)
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 (2\u00020\u00012\u00020\u0002:\u0001(B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J&\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u001a\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0010\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0010\u0010!\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020#H\u0002J\b\u0010$\u001a\u00020%H\u0016J\n\u0010&\u001a\u0004\u0018\u00010'H\u0016R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/bytedance/ee/bear/document/synced/block/references/doc/SyncedSourceDocReferencesFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/ss/android/lark/passportc/convention/view/UserScopeView;", "<init>", "()V", "routeService", "Lcom/bytedance/ee/bear/route/RouteService;", "getRouteService", "()Lcom/bytedance/ee/bear/route/RouteService;", "setRouteService", "(Lcom/bytedance/ee/bear/route/RouteService;)V", "spaceKitUrlHelper", "Lcom/bytedance/ee/bear/domain/container/ISpaceKitUrlHelper;", "getSpaceKitUrlHelper", "()Lcom/bytedance/ee/bear/domain/container/ISpaceKitUrlHelper;", "setSpaceKitUrlHelper", "(Lcom/bytedance/ee/bear/domain/container/ISpaceKitUrlHelper;)V", "viewModel", "Lcom/bytedance/ee/bear/document/synced/block/references/doc/SyncedSourceReferencesViewModel;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "reportItemClick", "item", "Lcom/bytedance/ee/bear/document/synced/block/references/entity/DocReferencesResult$References;", "loadData", "emptyView", "Lcom/bytedance/ee/bear/facade/common/empty/EmptyView;", "provideUserSession", "Lcom/ss/android/lark/passportc/entity/UserSession;", "getContext", "Landroid/content/Context;", "Companion", "docs-doc-impl-native_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SyncedSourceDocReferencesFragment extends Hilt_SyncedSourceDocReferencesFragment implements d0c.c {
    public static final /* synthetic */ int i = 0;

    @Inject
    public h f;

    @Inject
    public t45.c g;
    public SyncedSourceReferencesViewModel h;

    public static final class a {
    }

    public static final class b implements gqa.b {
        public final /* synthetic */ SyncedSourceDocReferencesFragment a;
        public final /* synthetic */ SyncedSourceDocReferencesAdapter b;

        public b(SyncedSourceDocReferencesFragment r1, SyncedSourceDocReferencesAdapter r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void O0(cqa.h r2) {
            Intrinsics.checkNotNullParameter(r2, "it");
            SyncedSourceReferencesViewModel r3 = this.a.h;
            if (r3 == null) goto L9;
            String r0 = this.b.c;
            if (r0 != null) goto L7;
            r0 = "";
        L7:
            r3.loadDocumentReferenceMore(r0);
            return;
        }
    }

    public static final class c implements EmptyView.a {
        public final /* synthetic */ SyncedSourceDocReferencesFragment a;
        public final /* synthetic */ EmptyView b;

        public c(SyncedSourceDocReferencesFragment r1, EmptyView r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // com.bytedance.ee.bear.facade.common.empty.EmptyView.a
        public final void onFailedRetry() {
            SyncedSourceDocReferencesFragment r0 = this.a;
            EmptyView r1 = this.b;
            Intrinsics.checkNotNull(r1);
            int r2 = SyncedSourceDocReferencesFragment.i;
            r0.U90(r1);
        }
    }

    public static final class d<T> implements Observer {
        public final /* synthetic */ EmptyView a;
        public final /* synthetic */ RecyclerView b;
        public final /* synthetic */ SyncedSourceDocReferencesAdapter c;
        public final /* synthetic */ SyncedSourceDocReferencesFragment d;
        public final /* synthetic */ SmartRefreshLayout e;

        public d(EmptyView r1, RecyclerView r2, SyncedSourceDocReferencesAdapter r3, SyncedSourceDocReferencesFragment r4, SmartRefreshLayout r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }

        public final void onChanged(Object r4) {
            DocReferencesResult r5 = (DocReferencesResult) r4;
            this.a.setVisibility(4);
            this.b.setAdapter(this.c);
            SyncedSourceDocReferencesAdapter r0 = this.c;
            ArrayList<DocReferencesResult.References> r1 = r5.getReferences();
            if (r1 != null) goto L5;
            r1 = new ArrayList();
        L5:
            SyncedSourceReferencesViewModel r2 = this.d.h;
            if (r2 == null) goto L8;
            r2.getNoPermissionCount();
        L8:
            r0.getClass();
            Intrinsics.checkNotNullParameter(r1, "data");
            r0.b = new ArrayList(r1);
            if (hu5.a.d(r1) == true) goto L11;
            r0.y2((DocReferencesResult.References) ListProtector.get(r1, r0.b.size() - 1));
        L11:
            r0.notifyDataSetChanged();
            this.e.g(r5.getHasMore());
        }
    }

    public static final class e<T> implements Observer {
        public final /* synthetic */ SmartRefreshLayout a;
        public final /* synthetic */ SyncedSourceDocReferencesAdapter b;
        public final /* synthetic */ SyncedSourceDocReferencesFragment c;

        public e(SmartRefreshLayout r1, SyncedSourceDocReferencesAdapter r2, SyncedSourceDocReferencesFragment r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void onChanged(Object r5) {
            DocReferencesResult r6 = (DocReferencesResult) r5;
            int r1 = 0;
            this.a.b(0, false);
            this.a.g(r6.getHasMore());
            SyncedSourceDocReferencesAdapter r0 = this.b;
            ArrayList<DocReferencesResult.References> r7 = r6.getReferences();
            if (r7 != null) goto L5;
            r7 = new ArrayList();
        L5:
            SyncedSourceReferencesViewModel r2 = this.c.h;
            if (r2 == null) goto L8;
            r1 = r2.getNoPermissionCount();
        L8:
            r0.getClass();
            Intrinsics.checkNotNullParameter(r7, "data");
            if (hu5.a.d(r7) == false) goto L11;
            return;
        L11:
            if (hu5.a.d(r0.b) == true) goto L20;
            r0.y2((DocReferencesResult.References) ListProtector.get(r7, r7.size() - 1));
            ArrayList<a45.a> r3 = r0.b;
            a45.a r4 = (a45.a) ListProtector.get(r3, r3.size() - 1);
            if ((r4 instanceof a45.b) == false) goto L16;
            ((a45.b) r4).a = r1;
            ArrayList<a45.a> r8 = r0.b;
            r8.addAll(r8.size() - 1, r7);
        L17:
            r0.notifyDataSetChanged();
            return;
        L16:
            r0.b.addAll(r7);
            goto L17
        }
    }

    public static final class f<T> implements Observer {
        public final /* synthetic */ EmptyView a;

        public f(EmptyView r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            Throwable r3 = (Throwable) r2;
            this.a.setVisibility(0);
            this.a.a();
        }
    }

    public static final class g implements SyncedSourceDocReferencesAdapter.b {
        public final /* synthetic */ SyncedSourceDocReferencesFragment a;

        public g(SyncedSourceDocReferencesFragment r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.document.synced.block.references.doc.SyncedSourceDocReferencesAdapter.b
        public final void a(DocReferencesResult.References r5) {
            Intrinsics.checkNotNullParameter(r5, "item");
            SyncedSourceReferencesMainFragment r1 = this.a.getParentFragment();     // Catch: Throwable -> L19
            if ((r5 instanceof DocReferencesResult.References) == true) goto L6;
        L17:
            tt5.a.d("SyncedSourceReferencesFragment", "param error");     // Catch: Throwable -> L19
            return;
        L6:
            if ((r1 instanceof SyncedSourceReferencesMainFragment) == false) goto L17;
            ((SyncedSourceRefVM) new ViewModelProvider(r1).get(SyncedSourceRefVM.class)).getLiveItemClick().setValue(r5.getUrl());     // Catch: Throwable -> L19
            if (k5.a(r5.getUrl(), r1.l) == true) goto L15;
            h r2 = this.a.f;     // Catch: Throwable -> L19
            if (r2 != null) goto L14;
            Intrinsics.throwUninitializedPropertyAccessException("routeService");     // Catch: Throwable -> L19
            r2 = null;
        L14:
            r2.u5(r5.getUrl());     // Catch: Throwable -> L19
            tt5.a.h("SyncedSourceReferencesFragment", "jump url");     // Catch: Throwable -> L19
        L16:
            SyncedSourceDocReferencesFragment.T90(this.a, r5);     // Catch: Throwable -> L19
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

    public final void afterUserOffline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void afterUserOnline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final /* synthetic */ Object generatedComponent() {
        return DwarfComponentProvider.-CC.$default$generatedComponent(this);
    }

    public final /* synthetic */ m getPassport() {
        return d0c.b.a(this);
    }

    public final void onUserOffline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void onUserOnline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final /* synthetic */ l provideComponent() {
        return d0c.b.b(this);
    }

    public final UserSession e9() {
        return PassportcConvention.b(this);
    }

    @Override // com.bytedance.ee.bear.document.synced.block.references.doc.Hilt_SyncedSourceDocReferencesFragment
    public Context getContext() {
        Context r0 = super.getContext();
        if (r0 != null) goto L7;
        return null;
    L7:
        return ContextsKt.findActivity(r0);
    }

    /* JADX INFO: renamed from: provideComponent, reason: collision with other method in class */
    public final /* bridge */ /* synthetic */ Object m269provideComponent() {
        return provideComponent();
    }

    public SyncedSourceDocReferencesFragment() {
    }

    public final void U90(EmptyView r3) {
        r3.setVisibility(0);
        r3.showLoading();
        Bundle r0 = getArguments();
        if (r0 == null) goto L5;
        ReferencesParams r1 = (ReferencesParams) r0.getParcelable("key_references_param");
    L6:
        if (r1 != null) goto L9;
        tt5.a.k("SyncedSourceReferencesFragment", "param is null");
        r3.showNoFound();
        return;
    L9:
        SyncedSourceReferencesViewModel r4 = this.h;
        if (r4 == null) goto L13;
        r4.loadDocumentReference(r1);
        return;
    L13:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public static final void T90(SyncedSourceDocReferencesFragment r4, DocReferencesResult.References r5) {
        r4.getClass();
        HashMap r6 = new HashMap();
        r6.put("click", "block_custom_action");
        r6.put("target", "none");
        HashMap r0 = new HashMap();
        r0.put("object_block_id", du5.b.g(r5.getObjId()));
        if (TextUtils.isEmpty(r5.getTagFirst()) == false) goto L5;
        String r2 = "Synced Block";
    L6:
        r0.put("object_block_type", r2);
        r0.put("object_sub_block_type", "none");
        r6.put("object_block_data", r0);
        if (TextUtils.isEmpty(r5.getTagFirst()) == false) goto L9;
        String r7 = "click_synced_source_reference_docs";
    L10:
        r6.put("action_type", r7);
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6)).n("ccm_doc_content_page_click", r6);
        return;
    L9:
        r7 = "click_synced_reference_source_docs";
        goto L10
    L5:
        r2 = "Synced Block’";
        goto L6
    }

    public final void onViewCreated(View r11, Bundle r12) {
        Intrinsics.checkNotNullParameter(r11, "view");
        super.onViewCreated(r11, r12);
        EmptyView r13 = (EmptyView) r11.findViewById(2131371607);
        boolean r0 = false;
        r13.setLoadViewMarginTop(0);
        RecyclerView r2 = r11.findViewById(2131387968);
        SmartRefreshLayout r6 = r11.findViewById(2131384141);
        r6.F(new LoadMoreFooter(r11.getContext()), -2);
        r2.setLayoutManager(new LinearLayoutManager(r11.getContext(), 1, false));
        SyncedSourceReferencesViewModel r14 = (SyncedSourceReferencesViewModel) new ViewModelProvider(this).get(SyncedSourceReferencesViewModel.class);
        this.h = r14;
        if (r14 == null) goto L9;
        Bundle r1 = getArguments();
        if (r1 == null) goto L7;
        BearUrl r3 = (BearUrl) r1.getParcelable("bear_url");
    L8:
        r14.setBearUrl(r3);
        goto L9
    L7:
        r3 = null;
    L9:
        SyncedSourceReferencesViewModel r16 = this.h;
        if (r16 == null) goto L17;
        Bundle r4 = getArguments();
        if (r4 != null) goto L14;
    L16:
        r16.setSyncLink(r0);
        goto L17
    L14:
        if (r4.getBoolean("key_is_sync_link") != true) goto L16;
        r0 = true;
    L17:
        SyncedSourceDocReferencesAdapter r17 = new SyncedSourceDocReferencesAdapter(new g(this));
        r6.i(new b(this, r17));
        r13.setOnRetryListener(new c(this, r13));
        SyncedSourceReferencesViewModel r5 = this.h;
        if (r5 == null) goto L22;
        MutableLiveData<DocReferencesResult> r7 = r5.getLiveInitLoadData();
        if (r7 == null) goto L22;
        r7.observe(getViewLifecycleOwner(), new d(r13, r2, r17, this, r6));
    L22:
        SyncedSourceReferencesViewModel r8 = this.h;
        if (r8 == null) goto L27;
        MutableLiveData<DocReferencesResult> r9 = r8.getLiveLoadMoreData();
        if (r9 == null) goto L27;
        r9.observe(getViewLifecycleOwner(), new e(r6, r17, this));
    L27:
        SyncedSourceReferencesViewModel r18 = this.h;
        if (r18 == null) goto L32;
        MutableLiveData<Throwable> r19 = r18.getLiveInitError();
        if (r19 == null) goto L32;
        r19.observe(getViewLifecycleOwner(), new f(r13));
    L32:
        Intrinsics.checkNotNull(r13);
        U90(r13);
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131560106, r3, false);
    }
}
