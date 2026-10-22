package com.bytedance.android.shopping.anchorv4.voavhs;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.bytedance.android.bst.api.config.PageConfig;
import com.bytedance.android.ec.core.anchorv3.PdpPerfOpt;
import com.bytedance.android.ec.opt.asynctask.n;
import com.bytedance.android.ec.opt.asynctask.r;
import com.bytedance.android.ec.opt.asynctask.t;
import com.bytedance.android.ec.opt.asynctask.w;
import com.bytedance.android.ec.opt.asynctask.x;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ecom.arch.slice.SlcContext;
import com.bytedance.android.ecom.arch.slice.action.ActionContext;
import com.bytedance.android.ecom.arch.slice.expr.SlcExprContext;
import com.bytedance.android.ecom.arch.slice.render.context.SlcRenderContext;
import com.bytedance.android.ecom.arch.slice.slices.SlcBaseViewHolder;
import com.bytedance.android.ecom.arch.slice.slices.group.SlcGroupViewHolder;
import com.bytedance.android.ecom.slice.ext.template.gecko.SlcGeckoTemplateMgr;
import com.bytedance.android.shopping.anchorv3.detail.StaggeredGridDoubleColumnDecoration;
import com.bytedance.android.shopping.anchorv3.detail.viewholder.AbsFullSpanVH;
import com.bytedance.android.shopping.anchorv4.components.ConfigPageAdapterComponent;
import com.bytedance.android.shopping.anchorv4.components.a0;
import com.bytedance.android.shopping.anchorv4.components.b0;
import com.bytedance.android.shopping.anchorv4.containers.page.PdContext;
import com.bytedance.android.shopping.anchorv4.data.AnchorV4DataManager;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.bytedance.android.shopping.anchorv4.experiment.PdpAB;
import com.bytedance.android.shopping.anchorv4.helper.JisooManager;
import com.bytedance.android.shopping.anchorv4.log.GULShowManager;
import com.bytedance.android.shopping.anchorv4.log.VisibleLogManager;
import com.bytedance.android.shopping.anchorv4.vm.AnchorV4VM;
import com.bytedance.android.shopping.anchorv4.voavhs.head.AnchorV4HeadVH;
import com.bytedance.android.shopping.anchorv4.voavhs.head.AnchorV4HeadView;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.AnchorV4HeadV2VH;
import com.bytedance.android.shopping.anchorv4.voavhs.jedi.AnchorJediSyncListDiffer;
import com.bytedance.android.shopping.jedi.JediBaseMultiTypeAdapter;
import com.bytedance.android.shopping.slice.SlcScaleProvider;
import com.bytedance.android.shopping.utils.LargeFontModeUtil;
import com.bytedance.android.shopping.utils.d0;
import com.bytedance.android.shopping.utils.y;
import com.bytedance.jedi.arch.IReceiver;
import com.bytedance.jedi.arch.ext.list.DiffableAdapter;
import com.bytedance.jedi.ext.adapter.JediListUpdateCallback;
import com.bytedance.jedi.ext.adapter.JediViewHolder;
import com.bytedance.jedi.ext.adapter.multitype.ViewHolderFactoryManager;
import com.bytedance.kmp.ec.yata.chain.core.EventChain;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u00042\u00020\u0005:\u0001\fR\u0017\u0010\u000b\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/AnchorV4Adapter;", "Lcom/bytedance/android/shopping/jedi/JediBaseMultiTypeAdapter;", "Lcom/bytedance/android/ecom/arch/slice/adapter/b;", "Lcom/bytedance/android/shopping/anchorv4/components/b0;", "Lcom/bytedance/android/ecom/arch/slice/adapter/d;", "Lcom/bytedance/android/shopping/anchorv4/vm/h;", "Landroidx/fragment/app/FragmentActivity;", "U", "Landroidx/fragment/app/FragmentActivity;", "getContext", "()Landroidx/fragment/app/FragmentActivity;", "context", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4Adapter extends JediBaseMultiTypeAdapter<com.bytedance.android.ecom.arch.slice.adapter.b> implements b0, com.bytedance.android.ecom.arch.slice.adapter.d, com.bytedance.android.shopping.anchorv4.vm.h {
    public static final /* synthetic */ int Z = 0;
    public final com.bytedance.android.ecom.arch.slice.adapter.e A;
    public final SlcContext B;
    public com.bytedance.android.ecom.arch.slice.adapter.e C;
    public int D;
    public final Lazy E;
    public final Lazy F;
    public final Lazy G;
    public final Lazy H;
    public final Lazy I;
    public final Lazy J;
    public final Lazy K;
    public Function1<? super RecyclerView.ViewHolder, Unit> L;
    public Function1<? super RecyclerView.ViewHolder, Unit> M;
    public boolean N;
    public boolean O;
    public final com.bytedance.jedi.ext.adapter.f<JediViewHolder<? extends IReceiver, ?>> P;
    public final f Q;
    public final LifecycleOwner R;
    public final com.bytedance.android.ec.core.async.b S;
    public final RecyclerView T;
    public final FragmentActivity U;
    public final VisibleLogManager V;
    public final GULShowManager W;
    public final FragmentManager X;
    public final AnchorV4VM Y;
    public final AnchorJediSyncListDiffer<com.bytedance.android.ecom.arch.slice.adapter.b> w;
    public volatile com.bytedance.android.shopping.api.mall.feed.d x;
    public final com.bytedance.android.ecom.slice.ext.template.gecko.c y;
    public final List<SlcGroupViewHolder> z;

    public static final class a {
    }

    public static final class b implements w {
        public final /* synthetic */ AnchorV4Adapter a;
        public final /* synthetic */ List b;

        public final com.bytedance.android.ec.opt.asynctask.k r() {
            r r0 = new r();
            r0.c = true;
            x r1 = r0.g;
            ((n) r1).b = true;
            return ((n) r1).c;
        }

        public final void run() {
            xh.a r0 = xh.c.a("Detail");
            String r1 = "originCount:" + this.a.getCurrentList().size() + "，itemCount:" + this.b.size() + " # run on thread-" + ThreadMethodProxy.currentThread().getName();
            xh.b r2 = new xh.b();
            r2.c("AnchorV4Adapter");
            r2.b("submitList");
            r2.a(r1);
            r0.f(3, r2);
        }

        public b(AnchorV4Adapter r1, List r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
    }

    public AnchorV4Adapter() {
        throw null;
    }

    public final void S2(float r1) {
    }

    public final void a2(boolean r1) {
    }

    public final boolean m(boolean r1, Function1<? super com.bytedance.android.ecom.arch.slice.g, Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "filter");
        return false;
    }

    @Override // com.bytedance.android.shopping.jedi.JediBaseMultiTypeAdapter
    public final int getBasicItemCount() {
        AnchorJediSyncListDiffer<com.bytedance.android.ecom.arch.slice.adapter.b> r0 = this.w;
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
        AnchorJediSyncListDiffer<com.bytedance.android.ecom.arch.slice.adapter.b> r0 = this.w;
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
        AnchorJediSyncListDiffer<com.bytedance.android.ecom.arch.slice.adapter.b> r0 = this.w;
        monitor-enter(r0);
        int r1 = r0.b.size();     // Catch: Throwable -> L7
        monitor-exit(r0);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public final List<com.bytedance.android.ecom.arch.slice.g> Z1() {
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

    public final FragmentActivity getContext() {
        return this.U;
    }

    public static final k C2(AnchorV4Adapter r0) {
        return (k) r0.G.getValue();
    }

    public static final AnchorV4Adapter$exposureService$2.a D2(AnchorV4Adapter r0) {
        return (AnchorV4Adapter$exposureService$2.a) r0.E.getValue();
    }

    @Override // com.bytedance.android.shopping.jedi.MultiTypeAdapter
    public final void B2(com.bytedance.jedi.ext.adapter.multitype.c<JediViewHolder<? extends IReceiver, ?>> r4) {
        Intrinsics.checkNotNullParameter(r4, "registry");
        ViewHolderFactoryManager r5 = (ViewHolderFactoryManager) r4;
        com.bytedance.jedi.ext.adapter.multitype.c.a.a(r5, new AnchorV4Adapter$registerFactories$1(this), new AnchorV4Adapter$registerFactories$2(this), 2);
        com.bytedance.jedi.ext.adapter.multitype.c.a.a(r5, new AnchorV4Adapter$registerFactories$3(this), new AnchorV4Adapter$registerFactories$4(this), 2);
        com.bytedance.jedi.ext.adapter.multitype.c.a.a(r5, new AnchorV4Adapter$registerFactories$5(this), new AnchorV4Adapter$registerFactories$6(this), 2);
        com.bytedance.jedi.ext.adapter.multitype.c.a.a(r5, new AnchorV4Adapter$registerFactories$7(this), new AnchorV4Adapter$registerFactories$8(this), 2);
        com.bytedance.jedi.ext.adapter.multitype.c.a.a(r5, new AnchorV4Adapter$registerFactories$9(this), new AnchorV4Adapter$registerFactories$10(this), 2);
        com.bytedance.jedi.ext.adapter.multitype.c.a.a(r5, new AnchorV4Adapter$registerFactories$11(this), new AnchorV4Adapter$registerFactories$12(this), 2);
        com.bytedance.jedi.ext.adapter.multitype.c.a.a(r5, new AnchorV4Adapter$registerFactories$13(this), new AnchorV4Adapter$registerFactories$14(this), 2);
        com.bytedance.jedi.ext.adapter.multitype.c.a.a(r5, new AnchorV4Adapter$registerFactories$15(this), new AnchorV4Adapter$registerFactories$16(this), 2);
        com.bytedance.jedi.ext.adapter.multitype.c.a.a(r5, new AnchorV4Adapter$registerFactories$17(this), new AnchorV4Adapter$registerFactories$18(this), 2);
        com.bytedance.jedi.ext.adapter.multitype.c.a.a(r5, new AnchorV4Adapter$registerFactories$19(this), new AnchorV4Adapter$registerFactories$20(this), 2);
        com.bytedance.jedi.ext.adapter.multitype.c.a.a(r5, new AnchorV4Adapter$registerFactories$21(this), new AnchorV4Adapter$registerFactories$22(this), 2);
        com.bytedance.jedi.ext.adapter.multitype.c.a.a(r5, new AnchorV4Adapter$registerFactories$23(this), new AnchorV4Adapter$registerFactories$24(this), 2);
        com.bytedance.jedi.ext.adapter.multitype.c.a.a(r5, new AnchorV4Adapter$registerFactories$25(this), new AnchorV4Adapter$registerFactories$26(this), 2);
        com.bytedance.jedi.ext.adapter.multitype.c.a.a(r5, new AnchorV4Adapter$registerFactories$27(this), new AnchorV4Adapter$registerFactories$28(this), 2);
        com.bytedance.jedi.ext.adapter.multitype.c.a.a(r5, new AnchorV4Adapter$registerFactories$29(this), new AnchorV4Adapter$registerFactories$30(this), 2);
        com.bytedance.jedi.ext.adapter.multitype.c.a.a(r5, new AnchorV4Adapter$registerFactories$31(this), new AnchorV4Adapter$registerFactories$32(this), 2);
        com.bytedance.jedi.ext.adapter.multitype.c.a.a(r5, new AnchorV4Adapter$registerFactories$33(this), new AnchorV4Adapter$registerFactories$34(this), 2);
        com.bytedance.jedi.ext.adapter.multitype.c.a.a(r5, new AnchorV4Adapter$registerFactories$35(this), new AnchorV4Adapter$registerFactories$36(this), 2);
        com.bytedance.jedi.ext.adapter.multitype.c.a.a(r5, new AnchorV4Adapter$registerFactories$37(this), new AnchorV4Adapter$registerFactories$38(this), 2);
        com.bytedance.jedi.ext.adapter.multitype.c.a.a(r5, new AnchorV4Adapter$registerFactories$39(this), new AnchorV4Adapter$registerFactories$40(this), 2);
        if (PdpAB.b == true) goto L5;
        com.bytedance.jedi.ext.adapter.multitype.c.a.a(r5, new AnchorV4Adapter$registerFactories$41(this), new AnchorV4Adapter$registerFactories$42(this), 2);
        com.bytedance.jedi.ext.adapter.multitype.c.a.a(r5, new AnchorV4Adapter$registerFactories$43(this), new AnchorV4Adapter$registerFactories$44(this), 2);
        com.bytedance.jedi.ext.adapter.multitype.c.a.a(r5, new AnchorV4Adapter$registerFactories$45(this), new AnchorV4Adapter$registerFactories$46(this), 2);
        return;
    L5:
        com.bytedance.jedi.ext.adapter.multitype.c.a.a(r5, new AnchorV4Adapter$registerFactories$47(this), new AnchorV4Adapter$registerFactories$48(this), 2);
    }

    public final void E2(Map r4) {
        Intrinsics.checkNotNullParameter(r4, "updateMap");
        SlcContext r0 = this.B;
        LinkedHashMap r1 = new LinkedHashMap();
        Map r2 = this.B.u0;
        if (r2 == null) goto L5;
        r1.putAll(r2);
    L5:
        r1.putAll(r4);
        Unit r5 = Unit.INSTANCE;
        r0.u0 = r1;
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
        h r8 = r7.config();
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

    public final com.bytedance.android.ecom.arch.slice.adapter.b G0(int r6) {
    L2:
        Object r0 = null;
        if (r6 < 0) goto L36;
        VOIdentifier r1 = (com.bytedance.android.ecom.arch.slice.adapter.b) CollectionsKt.getOrNull(getCurrentList(), r6);
        if ((r1 instanceof VOIdentifier) == false) goto L10;
        if (r1.canDock() == false) goto L35;
        return r1;
    L35:
        r6 = r6 - 1;
        goto L2
    L10:
        if ((r1 instanceof com.bytedance.android.ecom.arch.slice.slices.template.d) == false) goto L35;
        com.bytedance.android.ecom.arch.slice.slices.template.d r2 = (com.bytedance.android.ecom.arch.slice.slices.template.d) r1;
        Map r3 = r2.getConfig();
        if (r3 == null) goto L14;
        r0 = r3.get("scroll_id");
    L14:
        com.bytedance.android.shopping.anchorv4.topnav.e r4 = this.Y.getTopNavComponent();
        if (r4 == null) goto L25;
        List r5 = r4.getTabList();
        if (r5 == null) goto L25;
        Iterator r7 = r5.iterator();
    L20:
        if (r7.hasNext() == false) goto L25;
        if (Intrinsics.areEqual(((com.bytedance.android.shopping.anchorv4.topnav.i) r7.next()).a, r0) == false) goto L20;
        return r1;
    L25:
        if (Intrinsics.areEqual(r0, "id_detail") == false) goto L30;
        if (Intrinsics.areEqual(r2.getSliceId(), "std_detail_title") == false) goto L30;
        return r1;
    L30:
        if (Intrinsics.areEqual(r0, "id_comments") == true) goto L31;
        if (Intrinsics.areEqual(r0, "id_shop_recommend") == false) goto L35;
        return r1;
    L31:
        return r1;
    L36:
        return null;
    }

    public final void b2(boolean r5) {
        Iterator r0 = ((ArrayList) this.z).iterator();
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

    @Override // com.bytedance.android.shopping.jedi.MultiTypeAdapter
    public final int getBasicItemViewType(int r4) {
        com.bytedance.android.ecom.arch.slice.g r0 = (com.bytedance.android.ecom.arch.slice.adapter.b) DiffableAdapter.DefaultImpls.getItem$default(this, r4, false, 2, null);
        if ((r0 instanceof com.bytedance.android.ecom.arch.slice.g) == false) goto L12;
        com.bytedance.android.ecom.arch.slice.g r1 = r0;
        if (com.bytedance.android.shopping.extensions.k.c(r1.getViewType()) == false) goto L12;
        com.bytedance.android.ecom.arch.slice.adapter.e r5 = this.C;
        if (r5 != null) goto L10;
        r5 = this.A;
    L10:
        return r5.c(r1);
    L12:
        return this.P.b(r4);
    }

    @Override // com.bytedance.android.shopping.jedi.MultiTypeAdapter, com.bytedance.android.shopping.jedi.LoadMoreRecyclerViewAdapter
    public final void onAttachedToRecyclerView(RecyclerView r2) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        super.onAttachedToRecyclerView(r2);
        new PageConfig().setUseHighFrequencyDrawEvent(true);
        Unit r3 = Unit.INSTANCE;
        com.bytedance.android.bst.api.f.g().c();
    }

    @Override // com.bytedance.android.shopping.jedi.MultiTypeAdapter
    public final void onDetachedFromRecyclerView(RecyclerView r2) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        super.onDetachedFromRecyclerView(r2);
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
        super/*androidx.recyclerview.widget.RecyclerView.Adapter*/.onViewRecycled(r2);
        com.bytedance.android.ecom.arch.slice.adapter.e r0 = this.C;
        if (r0 != null) goto L5;
        r0 = this.A;
    L5:
        r0.d(r2);
    }

    @Override // com.bytedance.android.shopping.jedi.JediBaseMultiTypeAdapter
    public final void submitList(List<? extends com.bytedance.android.ecom.arch.slice.adapter.b> r3) {
        Intrinsics.checkNotNullParameter(r3, "list");
        t.b(new b(this, r3));
        Intrinsics.checkNotNullParameter(r3, "list");
        DiffableAdapter.DefaultImpls.submitList(this, r3);
    }

    @Override // com.bytedance.android.shopping.jedi.JediBaseMultiTypeAdapter, com.bytedance.android.shopping.jedi.MultiTypeAdapter
    public final Object A2(int r2, boolean r3) {
        return this.w.a(r2 + 0, true);
    }

    @Override // com.bytedance.android.shopping.jedi.JediBaseMultiTypeAdapter
    public final com.bytedance.android.ecom.arch.slice.adapter.b getItem(int r2, boolean r3) {
        return this.w.a(r2, r3);
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        com.bytedance.android.ecom.arch.slice.adapter.e r0 = this.C;
        if (r0 != null) goto L5;
        r0 = this.A;
    L5:
        SlcGroupViewHolder r1 = r0.b(this.B, r5, this.Q);
        if (r1 != null) goto L8;
        RecyclerView.ViewHolder r6 = super.onCreateViewHolder(r4, r5);
        if ((r6 instanceof AnchorV4HeadVH) == false) goto L19;
        AnchorV4HeadVH r7 = (AnchorV4HeadVH) r6;
        SlcRenderContext r2 = this.B;
        r7.getClass();
        Intrinsics.checkNotNullParameter(r2, "slcRenderContext");
        View r3 = ((RecyclerView.ViewHolder) r7).itemView;
        if (r3 == null) goto L17;
        ((AnchorV4HeadView) r3).setSlcRenderContext(r2);
        this.Y.configHeadViewAbility((com.bytedance.android.shopping.anchorv4.voavhs.head.k) r7.o.getValue());
    L21:
        return r6;
    L17:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.anchorv4.voavhs.head.AnchorV4HeadView");
    L19:
        if ((r6 instanceof AnchorV4HeadV2VH) == false) goto L21;
        AnchorV4HeadV2VH r8 = (AnchorV4HeadV2VH) r6;
        SlcContext r9 = this.B;
        r8.getClass();
        Intrinsics.checkNotNullParameter(r9, "slcRenderContext");
        r8.m.h.b = r9;
        this.Y.configHeadViewAbility(r8.n);
        goto L21
    L8:
        if ((r1 instanceof SlcGroupViewHolder) == false) goto L10;
        r1.g.setItemAnimator(null);
    L10:
        return r1;
    }

    @Override // com.bytedance.android.shopping.jedi.JediBaseMultiTypeAdapter
    public final void submitList(final List<? extends com.bytedance.android.ecom.arch.slice.adapter.b> r6, final Function0<Unit> r7) {
        Intrinsics.checkNotNullParameter(r6, "list");
        String r0 = this.Y.shareParams().b;
        if (r0 == null) goto L5;
        ((SlcRenderContext) this.B).h = MapsKt.hashMapOf(new Pair[]{TuplesKt.to("log_id", r0)});
        ((SlcRenderContext) this.B).i = r0;
    L5:
        int r1 = com.bytedance.android.shopping.utils.b.e;
        com.bytedance.android.shopping.utils.b.a.a("call submitList, listSize=" + r6.size());
        com.bytedance.android.ecom.arch.slice.render.util.h.a(new AnonymousClass2(this, r6, r7));
    }

    @Override // com.bytedance.android.shopping.jedi.MultiTypeAdapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r8, int r9, List<Object> r10) {
        Intrinsics.checkNotNullParameter(r8, "holder");
        Intrinsics.checkNotNullParameter(r10, "payloads");
        Object r2 = null;
        com.bytedance.android.ecom.arch.slice.g r1 = (com.bytedance.android.ecom.arch.slice.adapter.b) DiffableAdapter.DefaultImpls.getItem$default(this, r9, false, 2, null);
        boolean r3 = r1 instanceof com.bytedance.android.ecom.arch.slice.g;
        if (r3 == true) goto L5;
        com.bytedance.android.ecom.arch.slice.g r4 = null;
    L6:
        com.bytedance.android.ecom.arch.slice.g r5 = r4;
        if (r5 == null) goto L9;
        Object r6 = r5.getConfig("show_water_fall");
    L11:
        if ((r6 instanceof String) == true) goto L13;
        r6 = null;
    L13:
        boolean r7 = !com.bytedance.android.shopping.extensions.k.c((String) r6);
        com.bytedance.android.ecom.arch.slice.adapter.e r11 = this.C;
        if (r11 != null) goto L17;
        r11 = this.A;
    L17:
        if (r11.a(r8, r1, r9, r7) == true) goto L19;
        super.onBindViewHolder(r8, r9, r10);
    L54:
        if (this.N == false) goto L60;
        Function1<? super RecyclerView.ViewHolder, Unit> r12 = this.L;
        if (r12 == null) goto L58;
        Unit r13 = (Unit) r12.invoke(r8);
    L58:
        this.N = false;
    L60:
        if (this.Y.pageStatus().E == true) goto L62;
        return;
    L62:
        if (this.O == false) goto L69;
        Function1<? super RecyclerView.ViewHolder, Unit> r14 = this.M;
        if (r14 == null) goto L66;
        Unit r15 = (Unit) r14.invoke(r8);
    L66:
        this.O = false;
        return;
    L69:
        return;
    L19:
        if ((r8 instanceof SlcBaseViewHolder) == false) goto L54;
        if (r7 == true) goto L23;
        StaggeredGridDoubleColumnDecoration.a r16 = StaggeredGridDoubleColumnDecoration.g;
        View r17 = r8.itemView;
        r16.getClass();
        StaggeredGridDoubleColumnDecoration.a.b(r17, true);
    L23:
        if ((r8 instanceof SlcGroupViewHolder) == false) goto L37;
        if (r3 == false) goto L37;
        if (r3 == true) goto L27;
        com.bytedance.android.ecom.arch.slice.g r18 = null;
    L29:
        if (r18 == null) goto L37;
        Map r19 = r1.getSpecialStyle();
        if (r19 == null) goto L33;
        int r20 = r19.size();
    L34:
        if (r20 <= 0) goto L36;
        ((ArrayList) this.z).add(r8);
        goto L37
    L36:
        ((ArrayList) this.z).remove(r8);
        goto L37
    L33:
        r20 = 0;
        goto L34
    L27:
        r18 = r1;
    L37:
        Object r21 = r8.itemView.getTag(2131382095);
        if ((r21 instanceof com.bytedance.android.shopping.slice.a) == false) goto L42;
        r2 = r21;
    L42:
        if (((com.bytedance.android.shopping.slice.a) r2) != null) goto L47;
        com.bytedance.android.shopping.slice.a r22 = new com.bytedance.android.shopping.slice.a((SlcBaseViewHolder) r8);
        if (r1 == null) goto L46;
        this.V.b(r22, r1, 0);
    L46:
        r8.itemView.setTag(2131382095, r22);
    L47:
        SlcBaseViewHolder r23 = (SlcBaseViewHolder) r8;
        if (ECAppInfoService.e.i() == false) goto L54;
        cl.d r24 = com.bytedance.android.ec.sdk.helper.k.a();
        if (r24 == null) goto L54;
        r24.q();
        goto L54
    L9:
        r6 = null;
        goto L11
    L5:
        r4 = r1;
        goto L6
    }

    public AnchorV4Adapter(LifecycleOwner r8, ConfigPageAdapterComponent r9, RecyclerView r10, FragmentActivity r11, VisibleLogManager r12, GULShowManager r13, FragmentManager r14, AnchorV4VM r15) {
        AnchorV4Differ r0 = new AnchorV4Differ();
        Intrinsics.checkNotNullParameter(r8, "parent");
        Intrinsics.checkNotNullParameter(r9, "disposableScope");
        Intrinsics.checkNotNullParameter(r10, "recyclerView");
        Intrinsics.checkNotNullParameter(r11, "context");
        Intrinsics.checkNotNullParameter(r12, "visibleLogManager");
        Intrinsics.checkNotNullParameter(r13, "gulShowManager");
        Intrinsics.checkNotNullParameter(r0, "diffCallback");
        Intrinsics.checkNotNullParameter(r15, "anchorV4VM");
        super(r8, r0);
        this.R = r8;
        this.S = r9;
        this.T = r10;
        this.U = r11;
        this.V = r12;
        this.W = r13;
        this.X = r14;
        this.Y = r15;
        JediListUpdateCallback r16 = new JediListUpdateCallback(this, new AnchorV4Adapter$mAnchorDiffer$1(this));
        Intrinsics.checkNotNullParameter(r0, "mDiffCallback");
        this.w = new AnchorJediSyncListDiffer(r16, new com.bytedance.android.shopping.anchorv4.voavhs.jedi.a(r0));
        if (PdpPerfOpt.g() == false) goto L5;
        SlcGeckoTemplateMgr.l.getClass();
        com.bytedance.android.ecom.slice.ext.template.gecko.c r17 = SlcGeckoTemplateMgr.e(r11, "pdp");
    L6:
        this.y = r17;
        this.z = new ArrayList();
        com.bytedance.android.ecom.arch.slice.adapter.e r3 = new com.bytedance.android.ecom.arch.slice.adapter.e(1000);
        com.bytedance.android.shopping.anchorv4.voavhs.a r18 = new com.bytedance.android.shopping.anchorv4.voavhs.a(this);
        Intrinsics.checkNotNullParameter(r18, "listener");
        com.bytedance.android.ecom.arch.slice.adapter.f r19 = r3.c;
        r19.getClass();
        Intrinsics.checkNotNullParameter(r18, "listener");
        r19.a.add(r18);
        Unit r110 = Unit.INSTANCE;
        this.A = r3;
        if (r17 == null) goto L10;
        com.bytedance.android.ecom.arch.slice.expr.b r111 = r17.c();
        if (r111 == null) goto L10;
    L11:
        SlcExprContext r4 = new SlcExprContext(r111);
        ActionContext r2 = r15.getSlcActionCtx();
        if (JisooManager.d.a() == false) goto L14;
        j r112 = new j();
    L15:
        SlcContext r113 = new SlcContext(r11, r2, r3, r4, r112, new i(r10));
        if (PdpPerfOpt.h() == false) goto L18;
        ((SlcRenderContext) r113).v = 0;
    L18:
        ((SlcRenderContext) r113).b0 = new v73.a(r15);
        CommonMeta r114 = r15.commonMeta();
        if (r114 == null) goto L21;
        float r115 = h73.a.f(r114);
    L23:
        if (com.bytedance.android.shopping.anchorv4.experiment.h.e != 1) goto L25;
        boolean r116 = true;
    L26:
        if (r116 == true) goto L28;
    L31:
        Pair[] r20 = new Pair[4];
        r20[0] = TuplesKt.to("STATUS_BAR_HEIGHT", Integer.valueOf(com.bytedance.android.shopping.extensions.b.e(Integer.valueOf(d0.a()))));
        r20[1] = TuplesKt.to("NAVIGATION_BAR_VIEW_HEIGHT", 44);
        float r117 = LargeFontModeUtil.a();
        float r118 = 1.0f;
        if (r117 != 1.15f) goto L35;
        float r119 = 1.15f;
    L38:
        r20[2] = TuplesKt.to("FONT_SCALE_RATIO", Float.valueOf(r119));
        float r120 = LargeFontModeUtil.a();
        if (r120 != 1.15f) goto L42;
    L43:
        r118 = 1.15f;
    L44:
        r20[3] = TuplesKt.to("VIEW_SCALE_RATIO", Float.valueOf(r118));
        r113.p(MapsKt.mapOf(r20));
        if (r17 == null) goto L47;
        r113.o0 = r17;
        r17.b(r113);
    L48:
        ((SlcRenderContext) r113).o = new com.bytedance.android.shopping.anchorv4.voavhs.b(this);
        ((SlcRenderContext) r113).g = false;
        ((SlcRenderContext) r113).d = true;
        PdContext r21 = r15.getPdContext();
        if (r21 == null) goto L53;
        EventChain r22 = r21.l;
        if (r22 == null) goto L53;
        r113.o("eventChain", r22);
    L53:
        r113.o("pdp_service_for_slice", new c(this));
        this.B = r113;
        this.D = 100;
        this.E = LazyKt.lazy(new AnchorV4Adapter$exposureService$2(this));
        this.F = LazyKt.lazy(new AnchorV4Adapter$productDeleteTip$2(this));
        this.G = LazyKt.lazy(new AnchorV4Adapter$eventService$2(this));
        this.H = LazyKt.lazy(new AnchorV4Adapter$carDepend$2(this));
        this.I = LazyKt.lazy(new AnchorV4Adapter$receiveNoticeDepend$2(this));
        this.J = LazyKt.lazy(new AnchorV4Adapter$detailHeadDepend$2(this));
        this.K = LazyKt.lazy(new AnchorV4Adapter$gulDepend$2(this));
        r15.watchPageStatusChange(this);
        E2(MapsKt.mapOf(TuplesKt.to("is_small_mode", Boolean.valueOf(r15.pageStatus().z))));
        ((SlcRenderContext) r113).c0 = new SlcScaleProvider();
        this.N = true;
        this.O = true;
        this.P = this.u;
        this.Q = new f(r10, new d(this));
        return;
    L47:
        r113.v(true);
        goto L48
    L42:
        if (r120 != 1.3f) goto L44;
    L35:
        if (r117 != 1.3f) goto L37;
        r119 = 1.3f;
        goto L38
    L37:
        r119 = 1.0f;
        goto L38
    L28:
        if (r15.isInSplit() == false) goto L30;
        Resources r121 = Resources.getSystem();
        int r122 = WindowDisplayMetricsOverride.apply(r121, r121.getDisplayMetrics()).widthPixels;
        Resources r1 = Resources.getSystem();
        int r123 = RangesKt.coerceAtMost(r122, WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics()).heightPixels);
        int r5 = y.a;
        r115 = r115 * (r123 / y.e(null, Boolean.TRUE, 1));
    L30:
        com.bytedance.android.ecom.arch.slice.render.context.b.a r23 = com.bytedance.android.ecom.arch.slice.render.context.b.f;
        float r124 = LargeFontModeUtil.a();
        float r6 = LargeFontModeUtil.a();
        r23.getClass();
        ((SlcRenderContext) r113).f = com.bytedance.android.ecom.arch.slice.render.context.b.a.d(r115, r124, r6);
        goto L31
    L25:
        r116 = false;
        goto L26
    L21:
        r115 = 375.0f;
        goto L23
    L14:
        r112 = new com.bytedance.android.ecom.arch.slice.a();
    L10:
        com.bytedance.android.shopping.anchorv4.data.k r125 = AnchorV4DataManager.a;
        r111 = (com.bytedance.android.ecom.arch.slice.expr.b) AnchorV4DataManager.f.getValue();
        goto L11
    L5:
        r17 = null;
        goto L6
    }
}
