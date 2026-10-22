package com.bytedance.android.shopping.feed.adapter;

import android.content.Context;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.imagex.ImageExtensionsKt;
import com.bytedance.android.ec.core.imagex.r;
import com.bytedance.android.ec.core.utils.g1;
import com.bytedance.android.ec.innerflow.jedi.JediBaseFragment;
import com.bytedance.android.ec.innerflow.jedi.JediBaseMultiTypeAdapter;
import com.bytedance.android.ec.innerflow.jedi.JediBaseRawAdapter;
import com.bytedance.android.ec.innerflow.jedi.LoadMoreRecyclerViewAdapter;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.inflowfeed.Promotion;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductBaseStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ec.sdk.helper.q;
import com.bytedance.android.shopping.anchorv3.AnchorV3Param;
import com.bytedance.android.shopping.anchorv3.repository.dto.InnerFlowPageStyleDTO;
import com.bytedance.android.shopping.anchorv3.repository.dto.PageStyle;
import com.bytedance.android.shopping.api.anchorv3.ECUIParam;
import com.bytedance.android.shopping.feed.fragment.ProductFeedContentFragment;
import com.bytedance.android.shopping.feed.resourcecard.viewholder.ResourceCardVH;
import com.bytedance.android.shopping.feed.view.c;
import com.bytedance.android.shopping.feed.view.i;
import com.bytedance.android.shopping.feed.viewholder.GuessULikeProductCardDetailVH;
import com.bytedance.android.shopping.feed.viewholder.MainProductCardDetailVH;
import com.bytedance.android.shopping.feed.viewmodel.ProductFeedViewModel;
import com.bytedance.android.shopping.feed.widget.BaseCardDetailView;
import com.bytedance.android.shopping.feed.widget.ProductFeedDividerView;
import com.bytedance.android.shopping.monitor.d;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.jedi.arch.IReceiver;
import com.bytedance.jedi.arch.ext.list.DiffableAdapter;
import com.bytedance.jedi.ext.adapter.JediViewHolder;
import com.bytedance.jedi.ext.adapter.multitype.ViewHolderFactoryManager;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001:\u0002\u0003\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/feed/adapter/ProductFeedAdapter;", "Lcom/bytedance/android/ec/innerflow/jedi/JediBaseMultiTypeAdapter;", "Lcom/bytedance/android/shopping/feed/adapter/ProductFeedAdapter$b;", "a", "b", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ProductFeedAdapter extends JediBaseMultiTypeAdapter<b<?>> {
    public final com.bytedance.android.shopping.feed.a<GuessULikeProductCardDetailVH> A;
    public final com.bytedance.android.shopping.feed.a<ResourceCardVH> B;
    public String C;
    public String D;
    public volatile boolean E;
    public volatile boolean F;
    public final ProductFeedViewModel G;
    public final RecyclerView H;
    public final JediBaseFragment I;
    public final Set<String> u;
    public final Set<String> v;
    public final int w;
    public List<? extends Object> x;
    public int y;
    public final Set<Integer> z;

    public static final class a {
    }

    public static final class b<T> {
        public int a;
        public T b;

        public b() {
        }
    }

    static {
    }

    public final String B2() {
        int r0 = ProductFeedDividerView.j;
        return ProductFeedDividerView.c.a(this.y);
    }

    public final void y2() {
        super/*com.bytedance.android.ec.innerflow.jedi.LoadMoreRecyclerViewAdapter*/.y2();
        int r2 = com.bytedance.android.shopping.extensions.b.b(0);
        int r1 = com.bytedance.android.shopping.extensions.b.b(0);
        ((LoadMoreRecyclerViewAdapter) this).i = 0;
        ((LoadMoreRecyclerViewAdapter) this).k = r2;
        ((LoadMoreRecyclerViewAdapter) this).j = 0;
        ((LoadMoreRecyclerViewAdapter) this).h = r1;
        showLoadMoreLoading();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void D2(View r3) {
        if ((r3 instanceof c) == false) goto L31;
        ViewParent r0 = r3.getParent();
        if ((r0 instanceof ViewGroup) == true) goto L7;
        r0 = null;
    L7:
        ViewGroup r1 = (ViewGroup) r0;
        if (r1 == null) goto L10;
        r1.removeView(r3);
    L10:
        HashMap<String, Queue<View>> r2 = i.a;
        Intrinsics.checkNotNullParameter(r3, FreqActions.ACTION_VIEW);
        if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()) != ThreadMethodProxy.currentThread()) goto L13;
        boolean r4 = true;
    L14:
        if (r4 == false) goto L29;
        if (r3.getParent() != null) goto L27;
        String r5 = r3.getClass().getName();
        HashMap<String, Queue<View>> r6 = i.a;
        if (r6.containsKey(r5) == true) goto L20;
        r6.put(r5, new LinkedList());
    L20:
        Queue<View> r7 = r6.get(r5);
        if (r7 != null) goto L23;
    L25:
        ((c) r3).a();
        goto L31
    L23:
        if (r7.contains(r3) == true) goto L25;
        r7.offer(r3);
        goto L25
    L27:
        throw new IllegalStateException("view parent must be null");
    L29:
        throw new IllegalStateException("only main thread can touch");
    L13:
        r4 = false;
    L31:
        if ((r3 instanceof ViewGroup) == false) goto L36;
        Iterator r8 = com.bytedance.commerce.base.view.b.a(r3).iterator();
    L34:
        if (r8.hasNext() == false) goto L38;
        D2((View) r8.next());
        goto L34
    L38:
        return;
    }

    public final void A2(com.bytedance.jedi.ext.adapter.multitype.c<JediViewHolder<? extends IReceiver, ?>> r4) {
        Intrinsics.checkNotNullParameter(r4, "registry");
        ViewHolderFactoryManager r5 = (ViewHolderFactoryManager) r4;
        com.bytedance.jedi.ext.adapter.multitype.c.a.a(r5, new ProductFeedAdapter$registerFactories$1(this), new ProductFeedAdapter$registerFactories$2(this), 2);
        com.bytedance.jedi.ext.adapter.multitype.c.a.a(r5, new ProductFeedAdapter$registerFactories$3(this), new ProductFeedAdapter$registerFactories$4(this), 2);
        com.bytedance.jedi.ext.adapter.multitype.c.a.a(r5, new ProductFeedAdapter$registerFactories$5(this), new ProductFeedAdapter$registerFactories$6(this), 2);
        com.bytedance.jedi.ext.adapter.multitype.c.a.a(r5, new ProductFeedAdapter$registerFactories$7(this), new ProductFeedAdapter$registerFactories$8(this), 2);
        com.bytedance.jedi.ext.adapter.multitype.c.a.a(r5, new ProductFeedAdapter$registerFactories$9(this), new ProductFeedAdapter$registerFactories$10(this), 2);
        com.bytedance.jedi.ext.adapter.multitype.c.a.a(r5, new ProductFeedAdapter$registerFactories$11(this), ProductFeedAdapter$registerFactories$12.INSTANCE, 2);
        com.bytedance.jedi.ext.adapter.multitype.c.a.a(r5, new ProductFeedAdapter$registerFactories$13(this), new ProductFeedAdapter$registerFactories$14(this), 2);
        com.bytedance.jedi.ext.adapter.multitype.c.a.a(r5, new ProductFeedAdapter$registerFactories$15(this), new ProductFeedAdapter$registerFactories$16(this), 2);
        com.bytedance.jedi.ext.adapter.multitype.c.a.a(r5, new ProductFeedAdapter$registerFactories$17(this), new ProductFeedAdapter$registerFactories$18(this), 2);
        com.bytedance.jedi.ext.adapter.multitype.c.a.a(r5, new ProductFeedAdapter$registerFactories$19(this), new ProductFeedAdapter$registerFactories$20(this), 2);
        com.bytedance.jedi.ext.adapter.multitype.c.a.a(r5, new ProductFeedAdapter$registerFactories$21(this), ProductFeedAdapter$registerFactories$22.INSTANCE, 2);
    }

    public final Object C2(int r4) {
        b r5 = (b) DiffableAdapter.DefaultImpls.getItem$default(this, r4, false, 2, null);
        if (r5 != null) goto L5;
        return null;
    L5:
        return r5.b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v4, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v4 */
    public final void E2(List<? extends Object> r9) {
        Intrinsics.checkNotNullParameter(r9, "list");
        this.x = r9;
        ArrayList r1 = new ArrayList();
        Iterator r10 = r9.iterator();
    L3:
        Integer r3 = null;
        if (r10.hasNext() == false) goto L23;
        Object r2 = r10.next();
        if (this.y == 2) goto L8;
    L20:
        boolean r4 = true;
    L21:
        if (r4 == false) goto L3;
        r1.add(r2);
        goto L3
    L8:
        if ((r2 instanceof rd3.a) == true) goto L10;
        Object r5 = null;
    L11:
        rd3.a r6 = (rd3.a) r5;
        if (r6 == null) goto L14;
        r3 = r6.getType();
    L14:
        if (r3 == null) goto L20;
        if (r3.intValue() != 23) goto L20;
        r4 = false;
        goto L21
    L10:
        r5 = r2;
        goto L11
    L23:
        ArrayList r11 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator r7 = r1.iterator();
    L25:
        if (r7.hasNext() == false) goto L34;
        ?? r8 = r7.next();
        b r12 = new b();
        if ((r8 instanceof rd3.a) == true) goto L29;
        ?? r13 = 0;
    L30:
        rd3.a r14 = (rd3.a) r13;
        if (r14 == null) goto L33;
        String r15 = B2();
        Intrinsics.checkNotNullParameter(r15, "<set-?>");
        r14.m = r15;
    L33:
        r12.b = r8;
        r12.a = this.y;
        r11.add(r12);
        goto L25
    L29:
        r13 = r8;
        goto L30
    L34:
        Intrinsics.checkNotNullParameter(r11, "list");
        DiffableAdapter.DefaultImpls.submitList(this, r11);
    }

    public final void F2(int r6) {
        G2(r6);
        if (r6 == 0) goto L8;
        if (r6 == 1) goto L7;
        if (r6 == 2) goto L7;
    L10:
        if (this.w != 1) goto L17;
        if (r6 != 0) goto L14;
        q.a.d("list_style_enable_tiny_card", 0);
        goto L17
    L14:
        if (r6 != 1) goto L17;
        q.a.d("list_style_enable_tiny_card", 1);
    L17:
        if (this.w == 2) goto L19;
        return;
    L19:
        if (r6 != 0) goto L21;
        q.a.d("list_style_enable_double_list_card", 0);
        return;
    L21:
        if (r6 != 2) goto L26;
        q.a.d("list_style_enable_double_list_card", 1);
        return;
    L26:
        return;
    L7:
        UIUtils.displayToast(this.H.getContext(), 2131913780);
        goto L10
    L8:
        UIUtils.displayToast(this.H.getContext(), 2131913779);
        goto L10
    }

    public final void G2(int r6) {
        this.y = r6;
        this.u.clear();
        this.v.clear();
        List<? extends Object> r0 = this.x;
        JediBaseFragment r1 = null;
        if (r0 == null) goto L13;
        Iterator<T> r2 = r0.iterator();
    L6:
        if (r2.hasNext() == false) goto L13;
        Object r3 = r2.next();
        if ((r3 instanceof rd3.a) == true) goto L10;
        r3 = null;
    L10:
        rd3.a r4 = (rd3.a) r3;
        if (r4 == null) goto L6;
        String r5 = B2();
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        r4.m = r5;
    L13:
        List<? extends Object> r7 = this.x;
        if (r7 == null) goto L17;
        E2(r7);
    L17:
        if (r6 != 1) goto L19;
        JediBaseFragment r8 = this.I;
        if ((r8 instanceof ProductFeedContentFragment) == true) goto L40;
        r8 = null;
    L40:
        ProductFeedContentFragment r9 = (ProductFeedContentFragment) r8;
        if (r9 == null) goto L57;
        com.bytedance.android.shopping.feed.adapter.b r10 = r9.A;
        if (r10 == null) goto L58;
        r10.c = false;
        r10.d.attachToRecyclerView(null);
        r10.e = false;
        r10.f = false;
        return;
    L58:
        return;
    L57:
        return;
    L19:
        if (r6 == 2) goto L29;
        JediBaseFragment r11 = this.I;
        if ((r11 instanceof ProductFeedContentFragment) == false) goto L24;
        r1 = r11;
    L24:
        ProductFeedContentFragment r12 = (ProductFeedContentFragment) r1;
        if (r12 == null) goto L51;
        com.bytedance.android.shopping.feed.adapter.b r13 = r12.A;
        if (r13 == null) goto L52;
        r13.c = true;
        return;
    L52:
        return;
    L51:
        return;
    L29:
        JediBaseFragment r14 = this.I;
        if ((r14 instanceof ProductFeedContentFragment) == true) goto L32;
        r14 = null;
    L32:
        ProductFeedContentFragment r15 = (ProductFeedContentFragment) r14;
        if (r15 == null) goto L54;
        com.bytedance.android.shopping.feed.adapter.b r16 = r15.A;
        if (r16 == null) goto L55;
        r16.c = false;
        r16.d.attachToRecyclerView(null);
        r16.e = false;
        r16.f = false;
        return;
    L55:
        return;
    }

    public final int getBasicItemViewType(int r2) {
        return ((JediBaseRawAdapter) this).s.b(r2);
    }

    public final void onViewRecycled(RecyclerView.ViewHolder r2) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        super/*androidx.recyclerview.widget.RecyclerView.Adapter*/.onViewRecycled(r2);
        if (ld3.b.b() == false) goto L6;
        D2(r2.itemView);
        return;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r14, int r15) {
        Intrinsics.checkNotNullParameter(r14, "holder");
        super/*com.bytedance.android.ec.core.jedi.RecyclerViewWithFooterAdapter*/.onBindViewHolder(r14, r15);
        int r0 = 0;
    L4:
        if (r0 > 1) goto L29;
        int r3 = r15 + r0;
        if (this.z.contains(Integer.valueOf(r3)) == true) goto L27;
        Object r2 = C2(r3);
        if ((r2 instanceof rd3.a) == true) goto L10;
        r2 = null;
    L10:
        rd3.a r4 = (rd3.a) r2;
        if (r4 == null) goto L26;
        Promotion r5 = r4.f();
        if (r5 == null) goto L26;
        PromotionProductStruct r6 = r5.getPromotionInfo();
        if (r6 == null) goto L26;
        PromotionProductBaseStruct r7 = r6.getBaseInfo();
        if (r7 == null) goto L26;
        List r8 = r7.getImages();
        if (r8 == null) goto L26;
        ECUrlModel r9 = (ECUrlModel) CollectionsKt.firstOrNull(r8);
        if (r9 == null) goto L26;
        String r10 = r9.getFirstUrl();
        if (r10 == null) goto L26;
        r r11 = new r("ec_goods_feed", "ec_goods_feed_banner");
        List<String> r12 = ld3.c.c();
        Intrinsics.checkNotNullParameter(r12, "$this$isHitExp");
        r11.g("ec_goods_feed_enable_preconnect", Integer.valueOf(1 ^ (r12.isEmpty() ? 1 : 0)));
        Unit r1 = Unit.INSTANCE;
        ImageExtensionsKt.B(r10, r11, null, null, null, null, null, false, 192);
    L26:
        this.z.add(Integer.valueOf(r3));
    L27:
        r0 = r0 + 1;
        goto L4
    L29:
        if ((r14 instanceof GuessULikeProductCardDetailVH) == true) goto L31;
        return;
    L31:
        if (this.G.getHasBindProductFeedGuessULike() == true) goto L38;
        this.G.setHasBindProductFeedGuessULike(true);
        d.f(this.G.getProductFeedGuessULikeMonitorName()).h();
        return;
    }

    public ProductFeedAdapter(ProductFeedViewModel r8, RecyclerView r9, JediBaseFragment r10) {
        Intrinsics.checkNotNullParameter(r8, "productViewModel");
        Intrinsics.checkNotNullParameter(r9, "recyclerView");
        Intrinsics.checkNotNullParameter(r10, "fragment");
        super(r10, new ProductFeedDiffer());
        this.G = r8;
        this.H = r9;
        this.I = r10;
        this.u = new LinkedHashSet();
        this.v = new LinkedHashSet();
        LinkedHashSet r11 = new LinkedHashSet();
        this.z = r11;
        com.bytedance.android.shopping.feed.a<GuessULikeProductCardDetailVH> r0 = new com.bytedance.android.shopping.feed.a(new ProductFeedAdapter$guessULikeIdleWork$1(this), 4);
        this.A = r0;
        com.bytedance.android.shopping.feed.a<ResourceCardVH> r1 = new com.bytedance.android.shopping.feed.a(new ProductFeedAdapter$resourceCardIdleWork$1(this), 1);
        this.B = r1;
        Context r12 = r9.getContext();
        setShowFooter(true);
        int r2 = com.bytedance.android.shopping.extensions.b.b(20);
        int r4 = com.bytedance.android.shopping.extensions.b.b(16);
        ((LoadMoreRecyclerViewAdapter) this).i = 0;
        ((LoadMoreRecyclerViewAdapter) this).k = r2;
        ((LoadMoreRecyclerViewAdapter) this).j = 0;
        ((LoadMoreRecyclerViewAdapter) this).h = r4;
        int r3 = g1.a;
        ((LoadMoreRecyclerViewAdapter) this).d = g1.a.a(r12, 2131100048);
        ((LoadMoreRecyclerViewAdapter) this).c = g1.a.a(r12, 2131100048);
        InnerFlowPageStyleDTO r5 = r8.getInnerFlowPageStyle();
        if (r5 == null) goto L7;
        PageStyle r6 = r5.getPageStyle();
        if (r6 == null) goto L7;
        String r7 = r6.getFeedShowAllDesc();
    L8:
        if (r7 != null) goto L10;
    L13:
        boolean r13 = true;
    L14:
        if (r13 == false) goto L19;
        String r14 = g1.a.c(r12, 2131913970, new Object[0]);
        TextView r15 = ((LoadMoreRecyclerViewAdapter) this).f;
        if (r15 == null) goto L18;
        r15.setText(r14);
    L18:
        ((LoadMoreRecyclerViewAdapter) this).e = r14;
    L23:
        resetLoadMoreState();
        q r16 = q.a;
        int r17 = r16.getInt("list_style_enable_tiny_card", -1);
        int r18 = r16.getInt("list_style_enable_double_list_card", -1);
        AnchorV3Param r19 = r8.m907getAnchorV3Param();
        if (r19 == null) goto L30;
        ECUIParam r20 = r19.getUiParam();
        if (r20 == null) goto L30;
        Integer r21 = r20.getShowInternalListStyle();
        if (r21 == null) goto L30;
        int r22 = r21.intValue();
    L31:
        this.w = r22;
        if (r22 != 1) goto L35;
        if (r17 != (-1)) goto L35;
    L37:
        G2(r22);
    L45:
        if (ld3.b.b() == true) goto L47;
    L52:
        r11.clear();
        this.C = "";
        this.D = "";
        this.E = true;
        this.F = true;
        return;
    L47:
        if (r0.c == true) goto L50;
        Looper.myQueue().addIdleHandler(r0.d);
        r0.c = true;
    L50:
        if (r1.c == true) goto L52;
        Looper.myQueue().addIdleHandler(r1.d);
        r1.c = true;
    L35:
        if (r22 != 2) goto L38;
        if (r18 == (-1)) goto L37;
    L38:
        if (r22 != 1) goto L40;
        if (r17 != 1) goto L40;
    L42:
        G2(r22);
    L40:
        if (r22 != 2) goto L43;
        if (r18 == 1) goto L42;
    L43:
        G2(0);
    L30:
        r22 = 0;
        goto L31
    L19:
        TextView r23 = ((LoadMoreRecyclerViewAdapter) this).f;
        if (r23 == null) goto L22;
        r23.setText(r7);
    L22:
        ((LoadMoreRecyclerViewAdapter) this).e = r7;
        goto L23
    L10:
        if (r7.length() == 0) goto L13;
        r13 = false;
    L7:
        r7 = null;
        goto L8
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r7, int r8, List<Object> r9) {
        Intrinsics.checkNotNullParameter(r7, "holder");
        Intrinsics.checkNotNullParameter(r9, "payloads");
        boolean r1 = true;
        View r2 = null;
        if ((!r9.isEmpty()) == false) goto L5;
        List<Object> r0 = r9;
    L6:
        boolean r3 = false;
        if (r0 == null) goto L72;
        Lazy r4 = ECAppInfoService.a;
        if (ECAppInfoService.k() == false) goto L28;
        Object r5 = ListProtector.get(r0, 0);
        if ((r5 instanceof Pair) == true) goto L13;
        r5 = null;
    L13:
        Pair r6 = (Pair) r5;
        if (r6 == null) goto L16;
        Object r10 = r6.getFirst();
    L18:
        if (Intrinsics.areEqual(r10, 1) == false) goto L28;
        if ((r7 instanceof MainProductCardDetailVH) == false) goto L28;
        View r11 = ((RecyclerView.ViewHolder) ((MainProductCardDetailVH) r7)).itemView;
        if ((r11 instanceof BaseCardDetailView) == true) goto L24;
        r11 = null;
    L24:
        BaseCardDetailView r12 = (BaseCardDetailView) r11;
        if (r12 == null) goto L27;
        r12.z.setVisibility(8);
    L27:
        boolean r13 = true;
    L29:
        Object r14 = ListProtector.get(r0, 0);
        if ((r14 instanceof Pair) == true) goto L32;
        r14 = null;
    L32:
        Pair r15 = (Pair) r14;
        if (r15 == null) goto L35;
        Object r16 = r15.getFirst();
    L37:
        if (Intrinsics.areEqual(r16, 2) == true) goto L39;
    L70:
        r1 = r13;
    L71:
        r3 = r1;
        goto L72
    L39:
        if ((r7 instanceof MainProductCardDetailVH) == false) goto L62;
        MainProductCardDetailVH r17 = (MainProductCardDetailVH) r7;
        rd3.a r18 = r17.m;
        if (r18 == null) goto L47;
        PromotionProductStruct r19 = (PromotionProductStruct) ((b) r17.getItem()).b;
        if (r19 == null) goto L45;
        String r20 = r19.getGoodPriceStripData();
    L46:
        r18.o = r20;
        goto L47
    L45:
        r20 = null;
    L47:
        rd3.a r21 = r17.m;
        if (r21 == null) goto L54;
        PromotionProductStruct r22 = (PromotionProductStruct) ((b) r17.getItem()).b;
        if (r22 == null) goto L52;
        Map<String, String> r23 = r22.getGoodPriceStripLogExtra();
    L53:
        r21.p = r23;
        goto L54
    L52:
        r23 = null;
    L54:
        View r24 = ((RecyclerView.ViewHolder) r17).itemView;
        if ((r24 instanceof BaseCardDetailView) == false) goto L58;
        r2 = r24;
    L58:
        BaseCardDetailView r25 = (BaseCardDetailView) r2;
        if (r25 == null) goto L71;
        r25.h(r17.m);
        goto L71
    L62:
        if ((r7 instanceof GuessULikeProductCardDetailVH) == false) goto L70;
        GuessULikeProductCardDetailVH r26 = (GuessULikeProductCardDetailVH) r7;
        View r27 = ((RecyclerView.ViewHolder) r26).itemView;
        if ((r27 instanceof BaseCardDetailView) == false) goto L67;
        r2 = r27;
    L67:
        BaseCardDetailView r28 = (BaseCardDetailView) r2;
        if (r28 == null) goto L71;
        r28.h(r26.m);
        goto L71
    L35:
        r16 = null;
        goto L37
    L16:
        r10 = null;
    L28:
        r13 = false;
    L72:
        if (r3 == true) goto L75;
        super/*com.bytedance.android.ec.innerflow.jedi.MultiTypeAdapter*/.onBindViewHolder(r7, r8, r9);
        onBindViewHolder(r7, r8);
        return;
    L75:
        return;
    L5:
        r0 = null;
        goto L6
    }
}
