package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.product;

import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.bytedance.android.bst.api.config.PageConfig;
import com.bytedance.android.ecom.arch.slice.slices.SlcBaseViewHolder;
import com.bytedance.android.ecom.arch.slice.slices.group.SlcGroupViewHolder;
import com.bytedance.android.shopping.anchorv3.detail.viewholder.AbsFullSpanVH;
import com.bytedance.android.shopping.anchorv3.widget.BasePdpRecyclerView;
import com.bytedance.android.shopping.anchorv4.components.a0;
import com.bytedance.android.shopping.anchorv4.components.b0;
import com.bytedance.android.shopping.anchorv4.experiment.PdpAB;
import com.bytedance.android.shopping.anchorv4.topnav.TopNavVO;
import com.bytedance.android.shopping.anchorv4.voavhs.VOIdentifier;
import com.bytedance.android.shopping.anchorv4.voavhs.jedi.AnchorJediSyncListDiffer;
import com.bytedance.android.shopping.jedi.JediBaseMultiTypeAdapter;
import com.bytedance.android.shopping.prepurchase.business.pdp.repository.PdpDataStore;
import com.bytedance.jedi.arch.IReceiver;
import com.bytedance.jedi.arch.ext.list.DiffableAdapter;
import com.bytedance.jedi.ext.adapter.JediListUpdateCallback;
import com.bytedance.jedi.ext.adapter.JediViewHolder;
import com.bytedance.jedi.ext.adapter.multitype.ViewHolderFactoryManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003R\u001b\u0010\t\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/prepurchase/business/pdp/components/layer/product/ProductDetailInfoAdapter;", "Lcom/bytedance/android/shopping/jedi/JediBaseMultiTypeAdapter;", "Lcom/bytedance/android/ecom/arch/slice/adapter/b;", "Lcom/bytedance/android/shopping/anchorv4/components/b0;", "Landroidx/fragment/app/FragmentActivity;", "B", "Lkotlin/Lazy;", "getContext", "()Landroidx/fragment/app/FragmentActivity;", "context", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ProductDetailInfoAdapter extends JediBaseMultiTypeAdapter<com.bytedance.android.ecom.arch.slice.adapter.b> implements b0 {
    public static final /* synthetic */ int R = 0;
    public final Lazy A;
    public final Lazy B;
    public final Lazy C;
    public final Lazy D;
    public final Lazy E;
    public final Lazy F;
    public final AnchorJediSyncListDiffer<com.bytedance.android.ecom.arch.slice.adapter.b> G;
    public final com.bytedance.jedi.ext.adapter.f<JediViewHolder<? extends IReceiver, ?>> H;
    public final Set<String> I;
    public List<com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.g> J;
    public final LifecycleOwner K;
    public com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.slice.e L;
    public final com.bytedance.android.shopping.prepurchase.arch.container.c<com.bytedance.android.shopping.prepurchase.business.pdp.e, PdpDataStore> M;
    public final com.bytedance.android.shopping.prepurchase.arch.container.component.j N;
    public final com.bytedance.android.shopping.anchorv4.voavhs.lynx.d O;
    public final RecyclerView P;
    public final com.bytedance.android.ec.core.async.b Q;
    public Function0<Unit> w;
    public final Set<SlcGroupViewHolder> x;
    public Boolean y;
    public final Lazy z;

    public ProductDetailInfoAdapter() {
        throw null;
    }

    private final FragmentActivity getContext() {
        return (FragmentActivity) this.B.getValue();
    }

    @Override // com.bytedance.android.shopping.jedi.JediBaseMultiTypeAdapter
    public final int getBasicItemCount() {
        AnchorJediSyncListDiffer<com.bytedance.android.ecom.arch.slice.adapter.b> r0 = this.G;
        monitor-enter(r0);
        int r1 = r0.b.size();     // Catch: Throwable -> L8
        monitor-exit(r0);
        return r1 + 0;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.android.shopping.jedi.JediBaseMultiTypeAdapter
    public final List<com.bytedance.android.ecom.arch.slice.adapter.b> getCurrentList() {
        AnchorJediSyncListDiffer<com.bytedance.android.ecom.arch.slice.adapter.b> r0 = this.G;
        monitor-enter(r0);
        List<? extends com.bytedance.android.ecom.arch.slice.adapter.b> r1 = r0.b;     // Catch: Throwable -> L7
        monitor-exit(r0);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.android.shopping.jedi.JediBaseMultiTypeAdapter, com.bytedance.android.shopping.jedi.LoadMoreRecyclerViewAdapter
    public final int getItemCount() {
        AnchorJediSyncListDiffer<com.bytedance.android.ecom.arch.slice.adapter.b> r0 = this.G;
        monitor-enter(r0);
        int r1 = r0.b.size();     // Catch: Throwable -> L7
        monitor-exit(r0);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public final List<com.bytedance.android.ecom.arch.slice.g> E2() {
        List<com.bytedance.android.ecom.arch.slice.adapter.b> r0 = getCurrentList();
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        Object r3 = r2.next();
        if ((r3 instanceof com.bytedance.android.ecom.arch.slice.g) == false) goto L4;
        r1.add(r3);
        goto L4
    L8:
        return r1;
    }

    public static final /* synthetic */ FragmentActivity C2(ProductDetailInfoAdapter r0) {
        return r0.getContext();
    }

    public static final ug3.b D2(ProductDetailInfoAdapter r0) {
        return (ug3.b) r0.z.getValue();
    }

    @Override // com.bytedance.android.shopping.jedi.MultiTypeAdapter
    public final void B2(com.bytedance.jedi.ext.adapter.multitype.c<JediViewHolder<? extends IReceiver, ?>> r4) {
        Intrinsics.checkNotNullParameter(r4, "registry");
        ViewHolderFactoryManager r5 = (ViewHolderFactoryManager) r4;
        com.bytedance.jedi.ext.adapter.multitype.c.a.a(r5, new ProductDetailInfoAdapter$registerFactories$1(this), new ProductDetailInfoAdapter$registerFactories$2(this), 2);
        com.bytedance.jedi.ext.adapter.multitype.c.a.a(r5, new ProductDetailInfoAdapter$registerFactories$3(this), new ProductDetailInfoAdapter$registerFactories$4(this), 2);
        com.bytedance.jedi.ext.adapter.multitype.c.a.a(r5, new ProductDetailInfoAdapter$registerFactories$5(this), new ProductDetailInfoAdapter$registerFactories$6(this), 2);
        com.bytedance.jedi.ext.adapter.multitype.c.a.a(r5, new ProductDetailInfoAdapter$registerFactories$7(this), new ProductDetailInfoAdapter$registerFactories$8(this), 2);
        com.bytedance.jedi.ext.adapter.multitype.c.a.a(r5, new ProductDetailInfoAdapter$registerFactories$9(this), new ProductDetailInfoAdapter$registerFactories$10(this), 2);
        com.bytedance.jedi.ext.adapter.multitype.c.a.a(r5, new ProductDetailInfoAdapter$registerFactories$11(this), new ProductDetailInfoAdapter$registerFactories$12(this), 2);
        com.bytedance.jedi.ext.adapter.multitype.c.a.a(r5, new ProductDetailInfoAdapter$registerFactories$13(this), new ProductDetailInfoAdapter$registerFactories$14(this), 2);
        com.bytedance.jedi.ext.adapter.multitype.c.a.a(r5, new ProductDetailInfoAdapter$registerFactories$15(this), new ProductDetailInfoAdapter$registerFactories$16(this), 2);
        com.bytedance.jedi.ext.adapter.multitype.c.a.a(r5, new ProductDetailInfoAdapter$registerFactories$17(this), new ProductDetailInfoAdapter$registerFactories$18(this), 2);
        com.bytedance.jedi.ext.adapter.multitype.c.a.a(r5, new ProductDetailInfoAdapter$registerFactories$19(this), new ProductDetailInfoAdapter$registerFactories$20(this), 2);
        com.bytedance.jedi.ext.adapter.multitype.c.a.a(r5, new ProductDetailInfoAdapter$registerFactories$21(this), new ProductDetailInfoAdapter$registerFactories$22(this), 2);
        com.bytedance.jedi.ext.adapter.multitype.c.a.a(r5, new ProductDetailInfoAdapter$registerFactories$23(this), new ProductDetailInfoAdapter$registerFactories$24(this), 2);
        com.bytedance.jedi.ext.adapter.multitype.c.a.a(r5, new ProductDetailInfoAdapter$registerFactories$25(this), new ProductDetailInfoAdapter$registerFactories$26(this), 2);
        if (PdpAB.b == true) goto L5;
        com.bytedance.jedi.ext.adapter.multitype.c.a.a(r5, new ProductDetailInfoAdapter$registerFactories$27(this), new ProductDetailInfoAdapter$registerFactories$28(this), 2);
        com.bytedance.jedi.ext.adapter.multitype.c.a.a(r5, new ProductDetailInfoAdapter$registerFactories$29(this), new ProductDetailInfoAdapter$registerFactories$30(this), 2);
        com.bytedance.jedi.ext.adapter.multitype.c.a.a(r5, new ProductDetailInfoAdapter$registerFactories$31(this), new ProductDetailInfoAdapter$registerFactories$32(this), 2);
    L5:
        com.bytedance.jedi.ext.adapter.multitype.c.a.a(r5, ProductDetailInfoAdapter$registerFactories$33.INSTANCE, new ProductDetailInfoAdapter$registerFactories$34(this), 2);
    }

    public final a0 F0(String r10) {
        Intrinsics.checkNotNullParameter(r10, "componentId");
        Iterator<T> r0 = getCurrentList().iterator();
        Object r1 = null;
        int r2 = 0;
        a0 r4 = null;
        int r3 = 0;
    L4:
        if (r0.hasNext() == false) goto L40;
        Object r5 = r0.next();
        int r6 = r3 + 1;
        if (r3 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        VOIdentifier r7 = (com.bytedance.android.ecom.arch.slice.adapter.b) r5;
        if ((r7 instanceof VOIdentifier) == false) goto L18;
        com.bytedance.android.shopping.anchorv4.voavhs.h r8 = r7.config();
        if (Intrinsics.areEqual(r8.a, r10) == true) goto L13;
        if (Intrinsics.areEqual(r8.a, "id_unified_tips") == false) goto L38;
        r4 = new a0(r3, r8.b);
    L38:
        r3 = r6;
        goto L4
    L13:
        return new a0(r3, r8.b);
    L18:
        if ((r7 instanceof com.bytedance.android.ecom.arch.slice.slices.template.d) == false) goto L38;
        Map r9 = ((com.bytedance.android.ecom.arch.slice.slices.template.d) r7).getConfig();
        if (r9 == null) goto L22;
        Object r11 = r9.get("scroll_id");
    L24:
        if (Intrinsics.areEqual(String.valueOf(r11), r10) == false) goto L38;
        if (r9 == null) goto L28;
        Object r12 = r9.get("scroll_amount");
    L30:
        if ((r12 instanceof Number) == false) goto L33;
        r1 = r12;
    L33:
        Number r13 = (Number) r1;
        if (r13 == null) goto L37;
        r2 = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r13.intValue()));
    L37:
        return new a0(r3, r2);
    L28:
        r12 = null;
        goto L30
    L22:
        r11 = null;
        goto L24
    L40:
        if (Intrinsics.areEqual(r10, "id_detail") == false) goto L42;
        return r4;
    L42:
        return null;
    }

    public final void F2(boolean r5) {
        this.y = Boolean.valueOf(r5);
        Iterator<T> r0 = this.x.iterator();
    L4:
        if (r0.hasNext() == false) goto L12;
        SlcGroupViewHolder r1 = (SlcGroupViewHolder) r0.next();
        if (r5 == false) goto L8;
        String r2 = "full_screen";
    L9:
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "specialKey");
        com.bytedance.android.ecom.arch.slice.g r3 = r1.c;
        if (r3 == null) goto L4;
        r1.T3(r3, r2);
        goto L4
    L8:
        r2 = "half_screen";
        goto L9
    }

    public final com.bytedance.android.ecom.arch.slice.adapter.b G0(int r6) {
    L2:
        List<com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.g> r0 = null;
        if (r6 < 0) goto L41;
        VOIdentifier r1 = (com.bytedance.android.ecom.arch.slice.adapter.b) CollectionsKt.getOrNull(getCurrentList(), r6);
        if ((r1 instanceof VOIdentifier) == false) goto L10;
        if (r1.canDock() == false) goto L40;
        return r1;
    L40:
        r6 = r6 - 1;
        goto L2
    L10:
        if ((r1 instanceof com.bytedance.android.ecom.arch.slice.slices.template.d) == false) goto L40;
        com.bytedance.android.ecom.arch.slice.slices.template.d r2 = (com.bytedance.android.ecom.arch.slice.slices.template.d) r1;
        Map r3 = r2.getConfig();
        if (r3 == null) goto L14;
        Object r4 = r3.get("scroll_id");
    L16:
        if (this.J != null) goto L21;
        TopNavVO r5 = (TopNavVO) ((com.bytedance.android.shopping.prepurchase.arch.container.state.e) this.M.d().getData().e.getValue()).a();
        if (r5 == null) goto L20;
        r0 = r5.getTabList();
    L20:
        this.J = r0;
    L21:
        List<com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.g> r7 = this.J;
        if (r7 == null) goto L30;
        Iterator<T> r8 = r7.iterator();
    L25:
        if (r8.hasNext() == false) goto L30;
        if (Intrinsics.areEqual(((com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.g) r8.next()).a, r4) == false) goto L25;
        return r1;
    L30:
        if (Intrinsics.areEqual(r4, "id_detail") == false) goto L35;
        if (Intrinsics.areEqual(r2.getSliceId(), "std_detail_title") == false) goto L35;
        return r1;
    L35:
        if (Intrinsics.areEqual(r4, "id_comments") == true) goto L36;
        if (Intrinsics.areEqual(r4, "id_shop_recommend") == false) goto L40;
        return r1;
    L36:
        return r1;
    L14:
        r4 = null;
        goto L16
    L41:
        return null;
    }

    @Override // com.bytedance.android.shopping.jedi.MultiTypeAdapter
    public final int getBasicItemViewType(int r4) {
        com.bytedance.android.ecom.arch.slice.adapter.b r0 = (com.bytedance.android.ecom.arch.slice.adapter.b) DiffableAdapter.DefaultImpls.getItem$default(this, r4, false, 2, null);
        Integer r1 = this.L.b(r0);
        if (r1 == null) goto L7;
        return r1.intValue();
    L7:
        return this.H.b(r4);
    }

    @Override // com.bytedance.android.shopping.jedi.MultiTypeAdapter, com.bytedance.android.shopping.jedi.LoadMoreRecyclerViewAdapter
    public final void onAttachedToRecyclerView(RecyclerView r2) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        super.onAttachedToRecyclerView(r2);
        getContext();
        new PageConfig().setUseHighFrequencyDrawEvent(true);
        Unit r3 = Unit.INSTANCE;
        com.bytedance.android.bst.api.f.g().c();
    }

    @Override // com.bytedance.android.shopping.jedi.MultiTypeAdapter
    public final void onDetachedFromRecyclerView(RecyclerView r2) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        super.onDetachedFromRecyclerView(r2);
        getContext();
        new PageConfig().setUseHighFrequencyDrawEvent(false);
        Unit r3 = Unit.INSTANCE;
        com.bytedance.android.bst.api.f.g().c();
    }

    @Override // com.bytedance.android.shopping.jedi.LoadMoreRecyclerViewAdapter
    public final void onViewAttachedToWindow(RecyclerView.ViewHolder r2) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        super.onViewAttachedToWindow(r2);
        if ((r2 instanceof AbsFullSpanVH) == false) goto L11;
        ViewGroup.LayoutParams r3 = ((RecyclerView.ViewHolder) ((AbsFullSpanVH) r2)).itemView.getLayoutParams();
        if ((r3 instanceof StaggeredGridLayoutManager.LayoutParams) == true) goto L7;
        r3 = null;
    L7:
        StaggeredGridLayoutManager.LayoutParams r4 = (StaggeredGridLayoutManager.LayoutParams) r3;
        if (r4 == null) goto L12;
        r4.setFullSpan(true);
        return;
    L12:
        return;
    }

    public final void onViewRecycled(RecyclerView.ViewHolder r2) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        if ((r2 instanceof SlcGroupViewHolder) == false) goto L5;
        this.x.remove(r2);
    L5:
        super/*androidx.recyclerview.widget.RecyclerView.Adapter*/.onViewRecycled(r2);
        this.L.c(r2);
    }

    @Override // com.bytedance.android.shopping.jedi.JediBaseMultiTypeAdapter, com.bytedance.android.shopping.jedi.MultiTypeAdapter
    public final Object A2(int r2, boolean r3) {
        return this.G.a(r2 + 0, true);
    }

    @Override // com.bytedance.android.shopping.jedi.JediBaseMultiTypeAdapter
    public final com.bytedance.android.ecom.arch.slice.adapter.b getItem(int r2, boolean r3) {
        return this.G.a(r2, r3);
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        SlcBaseViewHolder r0 = this.L.a(r2, r3);
        if (r0 == null) goto L6;
        return r0;
    L6:
        return super.onCreateViewHolder(r2, r3);
    }

    @Override // com.bytedance.android.shopping.jedi.JediBaseMultiTypeAdapter
    public final void submitList(final List<? extends com.bytedance.android.ecom.arch.slice.adapter.b> r2, final Function0<Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "list");
        com.bytedance.android.ecom.arch.slice.render.util.h.a(new AnonymousClass1(this, r2, r3));
    }

    @Override // com.bytedance.android.shopping.jedi.MultiTypeAdapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r6, int r7, List<Object> r8) {
        Intrinsics.checkNotNullParameter(r6, "holder");
        Intrinsics.checkNotNullParameter(r8, "payloads");
        int r0 = 0;
        com.bytedance.android.ecom.arch.slice.g r2 = null;
        com.bytedance.android.ecom.arch.slice.g r1 = (com.bytedance.android.ecom.arch.slice.adapter.b) DiffableAdapter.DefaultImpls.getItem$default(this, r7, false, 2, null);
        boolean r3 = r6 instanceof SlcGroupViewHolder;
        if (r3 == false) goto L18;
        boolean r4 = r1 instanceof com.bytedance.android.ecom.arch.slice.g;
        if (r4 == false) goto L18;
        if (r4 == false) goto L10;
        r2 = r1;
    L10:
        if (r2 == null) goto L18;
        Map r5 = r1.getSpecialStyle();
        if (r5 == null) goto L14;
        r0 = r5.size();
    L14:
        if (r0 <= 0) goto L16;
        this.x.add(r6);
        goto L18
    L16:
        this.x.remove(r6);
    L18:
        if (this.L.d(r6, r1, r7) == true) goto L20;
        super.onBindViewHolder(r6, r7, r8);
    L20:
        if (r3 == true) goto L22;
    L32:
        Function0<Unit> r9 = this.w;
        if (r9 == null) goto L36;
        Unit r10 = (Unit) r9.invoke();
        return;
    L36:
        return;
    L22:
        if (this.x.contains(r6) == false) goto L32;
        Boolean r11 = this.y;
        if (r11 == null) goto L32;
        SlcGroupViewHolder r12 = (SlcGroupViewHolder) r6;
        if (r11.booleanValue() == false) goto L28;
        String r13 = "full_screen";
    L29:
        r12.getClass();
        Intrinsics.checkNotNullParameter(r13, "specialKey");
        com.bytedance.android.ecom.arch.slice.g r14 = r12.c;
        if (r14 == null) goto L32;
        r12.T3(r14, r13);
        goto L32
    L28:
        r13 = "half_screen";
        goto L29
    }

    public ProductDetailInfoAdapter(LifecycleOwner r3, com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.slice.e r4, com.bytedance.android.shopping.prepurchase.arch.container.c r5, com.bytedance.android.shopping.prepurchase.arch.container.component.j r6, ug3.c r7, BasePdpRecyclerView r8, com.bytedance.android.ec.core.async.b r9) {
        MainFeedDiffer r0 = new MainFeedDiffer();
        Intrinsics.checkNotNullParameter(r3, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r4, "sliceItemAdapter");
        Intrinsics.checkNotNullParameter(r5, "pageContext");
        Intrinsics.checkNotNullParameter(r6, "serviceRegistry");
        Intrinsics.checkNotNullParameter(r7, "exposureService");
        Intrinsics.checkNotNullParameter(r8, "recyclerView");
        Intrinsics.checkNotNullParameter(r9, "disposable");
        Intrinsics.checkNotNullParameter(r0, "diffCallback");
        super(r3, r0);
        this.K = r3;
        this.L = r4;
        this.M = r5;
        this.N = r6;
        this.O = r7;
        this.P = r8;
        this.Q = r9;
        this.x = new LinkedHashSet();
        this.z = LazyKt.lazy(new ProductDetailInfoAdapter$eventService$2(this));
        this.A = LazyKt.lazy(ProductDetailInfoAdapter$deleteProductTipDepend$2.INSTANCE);
        this.B = LazyKt.lazy(new ProductDetailInfoAdapter$context$2(this));
        this.C = LazyKt.lazy(new ProductDetailInfoAdapter$detailHeadDepend$2(this));
        this.D = LazyKt.lazy(new ProductDetailInfoAdapter$gulVHDepend$2(this));
        this.E = LazyKt.lazy(new ProductDetailInfoAdapter$carDepend$2(this));
        this.F = LazyKt.lazy(new ProductDetailInfoAdapter$receivingNoticeDepend$2(this));
        JediListUpdateCallback r10 = new JediListUpdateCallback(this, new ProductDetailInfoAdapter$mAnchorDiffer$1(this));
        Intrinsics.checkNotNullParameter(r0, "mDiffCallback");
        this.G = new AnchorJediSyncListDiffer(r10, new com.bytedance.android.shopping.anchorv4.voavhs.jedi.a(r0));
        this.H = this.u;
        this.I = new LinkedHashSet();
    }
}
