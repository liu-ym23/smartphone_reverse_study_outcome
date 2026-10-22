package com.bytedance.android.window.shop.widget;

import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.window.base.product.lynxcard.ECLynxCardEvent;
import com.bytedance.android.window.shop.eventcard.windowability.WindowAnchorAbility;
import com.bytedance.android.window.shop.holder.ShopWindowItemHolder;
import com.bytedance.android.window.shop.holder.WindowHotsaleLoadMoreHolder;
import com.bytedance.android.window.shop.holder.WindowLynxHolder;
import com.bytedance.android.window.shop.holder.footer.FooterStatus;
import com.bytedance.android.window.shop.holder.footer.WindowFooterHolder;
import com.bytedance.android.window.shop.home.tab.common.WindowConstDef;
import com.bytedance.android.window.shop.repository.tab.entity.WindowLayoutType;
import com.bytedance.android.window.shop.repository.tab.entity.e0;
import com.bytedance.android.window.shop.repository.tab.entity.g0;
import com.bytedance.android.window.shop.repository.tab.entity.i0;
import com.bytedance.android.window.shop.repository.tab.entity.m0;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002j\u0002`\u00040\u00012\u00020\u00052\u00020\u0006:\u0001\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/window/shop/widget/WindowTypeSeparatedAdapter;", "Lcom/bytedance/android/window/shop/widget/WindowRecyclerViewWithHeaderAndFooterAdapterV2;", "Lcom/bytedance/android/window/shop/holder/ShopWindowItemHolder;", "Lcom/bytedance/android/window/shop/repository/tab/entity/f;", "Lcom/bytedance/android/window/shop/holder/ShopWindowHolder;", "Lfq3/b;", "Landroidx/lifecycle/LifecycleEventObserver;", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowTypeSeparatedAdapter extends WindowRecyclerViewWithHeaderAndFooterAdapterV2<ShopWindowItemHolder<? extends com.bytedance.android.window.shop.repository.tab.entity.f>> implements fq3.b, LifecycleEventObserver {
    public static final fo.a<WindowLayoutType> t = null;
    public static final fo.a<Boolean> u = null;
    public final List<Runnable> c;
    public final com.bytedance.android.window.shop.widget.holderprocessor.c d;
    public final gr3.e e;
    public final gr3.e f;
    public WindowLayoutType g;
    public final List<com.bytedance.android.window.shop.repository.tab.entity.f> h;
    public final LinkedHashMap<Integer, com.bytedance.android.window.shop.repository.tab.entity.f> i;
    public WindowFooterHolder j;
    public final fo.b k;
    public RecyclerView l;
    public FooterStatus m;
    public final Map<ECLynxCardEvent, j> n;
    public final Fragment o;
    public final List<Integer> p;
    public final Function1<Integer, Unit> q;
    public final Function0<Unit> r;
    public final boolean s;

    /* JADX INFO: renamed from: com.bytedance.android.window.shop.widget.WindowTypeSeparatedAdapter$1, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public static final AnonymousClass1 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass1();
        }

        public AnonymousClass1() {
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m968invoke() {
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            m968invoke();
            return Unit.INSTANCE;
        }
    }

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ WindowTypeSeparatedAdapter a;
        public final /* synthetic */ WindowAnchorAbility b;

        public b(WindowTypeSeparatedAdapter r1, WindowAnchorAbility r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.B2(this.b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ WindowTypeSeparatedAdapter a;

        public c(WindowTypeSeparatedAdapter r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            RecyclerView r0 = this.a.l;     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            r0.invalidateItemDecorations();     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    static {
        t = new fo.a("discover_product_tab_layout", new WindowLayoutType[0]);
        new fo.a("show_coupon_skeleton", new Boolean[0]);
        u = new fo.a("show_sort_skeleton", new Boolean[0]);
    }

    public final void A2() {
        Iterator r0 = ((ArrayList) this.h).iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        Object r1 = r0.next();
        if (((com.bytedance.android.window.shop.repository.tab.entity.f) r1).i != 2508) goto L8;
        boolean r2 = true;
    L9:
        if (r2 == false) goto L4;
    L12:
        com.bytedance.android.window.shop.repository.tab.entity.f r3 = (com.bytedance.android.window.shop.repository.tab.entity.f) r1;
        if (r3 != null) goto L15;
        return;
    L15:
        int r4 = ((ArrayList) this.h).indexOf(r3);
        if ((-1) != r4) goto L18;
        return;
    L18:
        ListProtector.remove(this.h, r4);
        notifyItemRemoved(r4);
        return;
    L8:
        r2 = false;
        goto L9
    L11:
        r1 = null;
        goto L12
    }

    public final void H2() {
        int r0 = ((ArrayList) this.h).size();
        Iterator r1 = ((ArrayList) this.h).iterator();
        int r3 = 0;
    L3:
        int r5 = -1;
        if (r1.hasNext() == false) goto L9;
        if ((((com.bytedance.android.window.shop.repository.tab.entity.f) r1.next()) instanceof e0) == true) goto L10;
        r3 = r3 + 1;
    L10:
        if ((-1) != r3) goto L19;
        Iterator r2 = ((ArrayList) this.h).iterator();
        int r4 = 0;
    L13:
        if (r2.hasNext() == false) goto L18;
        if ((((com.bytedance.android.window.shop.repository.tab.entity.f) r2.next()) instanceof i0) == true) goto L16;
        r4 = r4 + 1;
        goto L13
    L16:
        r5 = r4;
    L18:
        r3 = r5;
    L19:
        List<com.bytedance.android.window.shop.repository.tab.entity.f> r6 = this.h;
        ArrayList r7 = new ArrayList();
        Iterator r8 = ((ArrayList) r6).iterator();
        int r9 = 0;
    L21:
        if (r8.hasNext() == false) goto L32;
        Object r10 = r8.next();
        int r11 = r9 + 1;
        if (r9 >= 0) goto L25;
        CollectionsKt.throwIndexOverflow();
    L25:
        com.bytedance.android.window.shop.repository.tab.entity.f r12 = (com.bytedance.android.window.shop.repository.tab.entity.f) r10;
        if (r9 > r3) goto L28;
        boolean r13 = true;
    L29:
        if (r13 == false) goto L31;
        r7.add(r10);
    L31:
        r9 = r11;
        goto L21
    L28:
        r13 = false;
        goto L29
    L32:
        ((ArrayList) this.h).clear();
        ((ArrayList) this.h).addAll(r7);
        notifyItemRangeRemoved(((ArrayList) this.h).size(), r0 - ((ArrayList) this.h).size());
        return;
    L9:
        r3 = -1;
        goto L10
    }

    @Override // fq3.b
    public final void clear() {
        ((ArrayList) this.h).clear();
    }

    @Override // com.bytedance.android.window.shop.widget.WindowRecyclerViewWithHeaderAndFooterAdapterV2
    public final int getBasicItemCount() {
        return ((ArrayList) this.h).size();
    }

    public final void B2(WindowAnchorAbility r7) {
        Intrinsics.checkNotNullParameter(r7, "anchorAbility");
        if (this.o.getLifecycle().getCurrentState().compareTo(Lifecycle.State.RESUMED) >= 0) goto L7;
        ((ArrayList) this.c).add(new b(this, r7));
        return;
    L7:
        if ((!StringsKt.isBlank(r7.a)) == false) goto L16;
        Iterator r0 = ((ArrayList) this.h).iterator();
        int r3 = 0;
    L10:
        if (r0.hasNext() == false) goto L15;
        if (Intrinsics.areEqual(com.bytedance.android.window.shop.repository.tab.entity.s.a((com.bytedance.android.window.shop.repository.tab.entity.f) r0.next()), r7.a) == true) goto L17;
        r3 = r3 + 1;
    L17:
        int r1 = ((ArrayList) this.h).size();
        if (r3 < 0) goto L49;
        if (r1 <= r3) goto L51;
        int r2 = w.a[r7.c.ordinal()];
        if (r2 != 1) goto L24;
        C2(r3, r7.d);
    L43:
        RecyclerView r8 = this.l;
        if (r8 == null) goto L50;
        r8.post(new c(this));
        return;
    L50:
        return;
    L24:
        if (r2 != 2) goto L26;
        C2(r3 + 1, r7.d);
        goto L43
    L26:
        if (r2 == 3) goto L38;
        if (r2 != 4) goto L43;
        if (r7.d.isEmpty() == false) goto L33;
        return;
    L33:
        List<? extends com.bytedance.android.window.shop.repository.tab.entity.f> r9 = CollectionsKt.toMutableList(r7.d);
        com.bytedance.android.window.shop.repository.tab.entity.n r4 = new com.bytedance.android.window.shop.repository.tab.entity.n((com.bytedance.android.window.shop.repository.tab.entity.f) ListProtector.remove(r9, 0), (com.bytedance.android.window.shop.repository.tab.entity.f) ListProtector.get(this.h, r3));
        com.bytedance.android.window.shop.repository.tab.entity.f r5 = (com.bytedance.android.window.shop.repository.tab.entity.f) ListProtector.get(this.h, r3);
        if ((true ^ r9.isEmpty()) == false) goto L36;
        C2(r3, r9);
    L36:
        z2(r5, CollectionsKt.listOf(r4));
        goto L43
    L38:
        if (r7.d.isEmpty() == false) goto L40;
        return;
    L40:
        List<? extends com.bytedance.android.window.shop.repository.tab.entity.f> r10 = CollectionsKt.toMutableList(r7.d);
        ListProtector.add(r10, 0, new com.bytedance.android.window.shop.repository.tab.entity.n((com.bytedance.android.window.shop.repository.tab.entity.f) ListProtector.get(this.h, r3), (com.bytedance.android.window.shop.repository.tab.entity.f) ListProtector.remove(r10, 0)));
        z2((com.bytedance.android.window.shop.repository.tab.entity.f) ListProtector.get(this.h, r3), r10);
        goto L43
    L51:
        return;
    L49:
        return;
    L15:
        r3 = -1;
        goto L17
    L16:
        r3 = r7.b;
        goto L17
    }

    public final synchronized void D2(List<? extends com.bytedance.android.window.shop.repository.tab.entity.f> r2) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r2, "list");     // Catch: Throwable -> L6
        C2(((ArrayList) this.h).size(), r2);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final void E2(FooterStatus r2) {
        Intrinsics.checkNotNullParameter(r2, "footerStatus");
        this.m = r2;
        WindowFooterHolder r0 = this.j;
        if (r0 == null) goto L6;
        r0.u4(r2);
        return;
    }

    public final void F2(g0 r6) {
        Intrinsics.checkNotNullParameter(r6, "vo");
        Iterator r0 = ((ArrayList) this.h).iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        Object r1 = r0.next();
        if (((com.bytedance.android.window.shop.repository.tab.entity.f) r1).i != 2508) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == false) goto L4;
    L13:
        if (((com.bytedance.android.window.shop.repository.tab.entity.f) r1) == null) goto L15;
        return;
    L15:
        ((ArrayList) this.h).add(r6);
        notifyItemChanged(((ArrayList) this.h).size() - 1);
        return;
    L8:
        r3 = false;
        goto L9
    L11:
        r1 = null;
        goto L13
    }

    public final void G2(WindowLayoutType r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (r3 == this.g) goto L9;
        this.g = r3;
        fo.b r0 = this.k;
        fo.a<WindowLayoutType> r1 = WindowConstDef.a;
        r0.b(WindowConstDef.a, r3);
        r0.b(t, this.g);
        return;
    }

    @Override // fq3.b
    public final void add(Object r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        ArrayList r0 = (ArrayList) this.h;
        r0.add((com.bytedance.android.window.shop.repository.tab.entity.f) r2);
    }

    @Override // com.bytedance.android.window.shop.widget.WindowRecyclerViewWithHeaderAndFooterAdapterV2
    public final int getBasicItemViewType(int r9) {
        com.bytedance.android.window.shop.repository.tab.entity.f r10 = (com.bytedance.android.window.shop.repository.tab.entity.f) ListProtector.get(this.h, r9);
        WindowLayoutType r0 = this.g;
        if (r0 != null) goto L5;
    L7:
        Intrinsics.checkNotNullParameter(r10, "$this$markAsFullSpan");
        r10.f.d(m0.d, Boolean.TRUE);
    L8:
        IntRange r1 = gr3.f.a;
        Intrinsics.checkNotNullParameter(r10, "vo");
        String r2 = r10.c;
        boolean r3 = false;
        if (r2 == null) goto L14;
        gr3.f.a r4 = gr3.f.b;
        int r5 = r10.i;
        r4.getClass();
        Intrinsics.checkNotNullParameter(r2, "uniqueId");
        String r6 = r2 + r5;
        Integer r7 = r4.a.get(r6);
        if (r7 == null) goto L13;
        int r8 = r7.intValue();
    L19:
        Intrinsics.checkNotNullParameter(r10, "$this$isFullSpan");
        Boolean r11 = (Boolean) r10.f.a(m0.d);
        if (r11 == null) goto L22;
        r3 = r11.booleanValue();
    L22:
        if (r3 == false) goto L24;
        int r12 = com.bytedance.android.window.shop.b.a;
        return 1073741824 | r8;
    L24:
        int r13 = com.bytedance.android.window.shop.b.a;
        return (-1073741825) & r8;
    L13:
        int r14 = r4.e.getAndIncrement();
        r4.a.put(r6, Integer.valueOf(r14));
        r4.d.put(Integer.valueOf(r14), Integer.valueOf(r5));
        r8 = r14;
        goto L19
    L14:
        gr3.f.a r15 = gr3.f.b;
        int r16 = r10.i;
        Intrinsics.checkNotNullParameter(r10, "$this$isFullSpan");
        Boolean r17 = (Boolean) r10.f.a(m0.d);
        if (r17 == null) goto L17;
        boolean r18 = r17.booleanValue();
    L18:
        r8 = r15.a(r16, r18);
        goto L19
    L17:
        r18 = false;
        goto L18
    L5:
        if (r0.isDoubleColumn() != true) goto L7;
        Intrinsics.checkNotNullParameter(r10, "$this$cancelFullSpan");
        r10.f.d(m0.d, Boolean.FALSE);
        goto L8
    }

    @Override // fq3.b
    public final Object getItem(int r2) {
        return ListProtector.get(this.h, r2);
    }

    @Override // com.bytedance.android.window.shop.widget.WindowRecyclerViewWithHeaderAndFooterAdapterV2
    public final void onAttachedToRecyclerView(RecyclerView r2) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        super.onAttachedToRecyclerView(r2);
        this.l = r2;
    }

    @Override // com.bytedance.android.window.shop.widget.WindowRecyclerViewWithHeaderAndFooterAdapterV2
    public final void onBindFooterViewHolder(RecyclerView.ViewHolder r3) {
        ShopWindowItemHolder r4 = (ShopWindowItemHolder) r3;
        Intrinsics.checkNotNullParameter(r4, "holder");
        com.bytedance.android.window.shop.repository.tab.entity.j r0 = com.bytedance.android.window.shop.repository.tab.entity.j.j;
        r4.getClass();
        Intrinsics.checkNotNullParameter(r0, "vo");
        r4.q4(r0);
        FooterStatus r1 = this.m;
        if (r1 != null) goto L5;
        return;
    L5:
        if ((r4 instanceof WindowFooterHolder) == true) goto L7;
        r4 = null;
    L7:
        WindowFooterHolder r5 = (WindowFooterHolder) r4;
        if (r5 == null) goto L12;
        r5.u4(r1);
        return;
    }

    @Override // com.bytedance.android.window.shop.widget.WindowRecyclerViewWithHeaderAndFooterAdapterV2
    public final RecyclerView.ViewHolder onCreateFooterViewHolder(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        WindowFooterHolder r0 = new WindowFooterHolder(r2.getContext());
        this.j = r0;
        return r0;
    }

    public final void onDetachedFromRecyclerView(RecyclerView r2) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        this.l = null;
        super.onDetachedFromRecyclerView(r2);
    }

    public final void onViewRecycled(RecyclerView.ViewHolder r2) {
        ShopWindowItemHolder r3 = (ShopWindowItemHolder) r2;
        Intrinsics.checkNotNullParameter(r3, "holder");
        super.onViewRecycled(r3);
        r3.t4();
    }

    @Override // fq3.b
    public final void remove(Object r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        List<com.bytedance.android.window.shop.repository.tab.entity.f> r0 = this.h;
        if (r0 == null) goto L7;
        TypeIntrinsics.asMutableCollection(r0).remove(r2);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
    }

    @Override // com.bytedance.android.window.shop.widget.WindowRecyclerViewWithHeaderAndFooterAdapterV2
    public final boolean y2(RecyclerView.ViewHolder r2) {
        ShopWindowItemHolder r3 = (ShopWindowItemHolder) r2;
        Intrinsics.checkNotNullParameter(r3, "holder");
        return r3.s4();
    }

    public final void C2(int r8, List<? extends com.bytedance.android.window.shop.repository.tab.entity.f> r9) {
        if (r8 >= 0) goto L4;
        return;
    L4:
        ArrayList r0 = new ArrayList();
        Iterator<T> r10 = r9.iterator();
        int r1 = 0;
    L6:
        if (r10.hasNext() == false) goto L15;
        Object r2 = r10.next();
        int r3 = r1 + 1;
        if (r1 >= 0) goto L10;
        CollectionsKt.throwIndexOverflow();
    L10:
        com.bytedance.android.window.shop.repository.tab.entity.f r4 = (com.bytedance.android.window.shop.repository.tab.entity.f) r2;
        List<Integer> r5 = this.p;
        int r6 = com.bytedance.android.window.shop.b.a;
        if (r5.contains(Integer.valueOf(r4.i & (-1073741825))) == false) goto L13;
        this.i.put(Integer.valueOf(r1 + r8), r4);
    L14:
        r1 = r3;
        goto L6
    L13:
        r0.add(r4);
        goto L14
    L15:
        ((ArrayList) this.h).addAll(r8, r0);
        if (r8 != 0) goto L18;
        notifyItemRangeChanged(r8, ((ArrayList) this.h).size());
        return;
    L18:
        notifyItemRangeInserted(r8, r0.size());
    }

    @Override // com.bytedance.android.window.shop.widget.WindowRecyclerViewWithHeaderAndFooterAdapterV2
    public final void onBindBasicViewHolder(RecyclerView.ViewHolder r3, int r4) {
        ShopWindowItemHolder<? extends com.bytedance.android.window.shop.repository.tab.entity.f> r5 = (ShopWindowItemHolder) r3;
        Intrinsics.checkNotNullParameter(r5, "holder");
        com.bytedance.android.window.shop.repository.tab.entity.f r0 = (com.bytedance.android.window.shop.repository.tab.entity.f) ListProtector.get(this.h, r4);
        this.f.a(r5, r0, r4);
        Intrinsics.checkNotNullParameter(r0, "vo");
        r5.q4(r0);
        this.e.a(r5, r0, r4);
    }

    @Override // com.bytedance.android.window.shop.widget.WindowRecyclerViewWithHeaderAndFooterAdapterV2
    public final RecyclerView.ViewHolder onCreateBasicViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        int r5 = com.bytedance.android.window.shop.b.a;
        int r6 = (r4 & (-1073741825)) & (-1073741825);
        Integer r0 = gr3.f.b.d.get(Integer.valueOf(r6));
        if (r0 == null) goto L5;
        r6 = r0.intValue();
    L5:
        int r7 = r6 & (-1073741825);
        if (com.bytedance.android.window.shop.holder.factory.c.d.contains((-1073741825) & r7) == false) goto L9;
        int r8 = com.bytedance.android.window.shop.holder.factory.b.a;
        return com.bytedance.android.window.shop.holder.factory.b.a(this.o, r7, this.k, new WindowTypeSeparatedAdapter$onCreateBasicViewHolder$holder$1(this));
    L9:
        if (com.bytedance.android.window.shop.repository.tab.datasource.mapping.g.a(r7) == false) goto L11;
        int r9 = com.bytedance.android.window.shop.holder.factory.h.a;
        Fragment r10 = this.o;
        boolean r11 = this.s;
        WindowTypeSeparatedAdapter$onCreateBasicViewHolder$holder$2 r1 = new WindowTypeSeparatedAdapter$onCreateBasicViewHolder$holder$2(this);
        Intrinsics.checkNotNullParameter(r10, "fragment");
        Intrinsics.checkNotNullParameter(r1, "callback");
        return new WindowLynxHolder(r10, r1, r11);
    L11:
        ShopWindowItemHolder<? extends com.bytedance.android.window.shop.repository.tab.entity.f> r12 = com.bytedance.android.window.shop.holder.factory.i.b.a(r7, this.o, this.k);
        if ((r12 instanceof WindowHotsaleLoadMoreHolder) == false) goto L17;
        x r2 = new x(this, r12);
        ((WindowHotsaleLoadMoreHolder) r12).v = r2;
        return r12;
    L17:
        return r12;
    }

    public final void onStateChanged(LifecycleOwner r2, Lifecycle.Event r3) {
        Intrinsics.checkNotNullParameter(r2, "source");
        Intrinsics.checkNotNullParameter(r3, "event");
        if (r2.getLifecycle().getCurrentState().compareTo(Lifecycle.State.RESUMED) < 0) goto L11;
        Iterator<T> r4 = this.c.iterator();
    L6:
        if (r4.hasNext() == false) goto L8;
        ((Runnable) r4.next()).run();
        goto L6
    L8:
        ((ArrayList) this.c).clear();
        return;
    }

    public final void z2(com.bytedance.android.window.shop.repository.tab.entity.f r3, List<? extends com.bytedance.android.window.shop.repository.tab.entity.f> r4) {
        Intrinsics.checkNotNullParameter(r3, "targetVO");
        Intrinsics.checkNotNullParameter(r4, "list");
        if (r4.isEmpty() == false) goto L5;
        return;
    L5:
        int r5 = ((ArrayList) this.h).indexOf(r3);
        if (r5 >= 0) goto L8;
        return;
    L8:
        ListProtector.set(this.h, r5, ListProtector.get(r4, 0));
        if (r4.size() <= 1) goto L11;
        C2(r5 + 1, CollectionsKt.drop(r4, 1));
    L11:
        notifyItemChanged(r5);
    }

    public /* synthetic */ WindowTypeSeparatedAdapter(Fragment r7, List r8, Function1 r9, Function0 r10) {
        this(r7, r8, r9, r10, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public WindowTypeSeparatedAdapter(Fragment r5, List<Integer> r6, Function1<? super Integer, Unit> r7, Function0<Unit> r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r5, "fragment");
        Intrinsics.checkNotNullParameter(r6, "dataBufferItemTypes");
        Intrinsics.checkNotNullParameter(r7, "bindCallback");
        Intrinsics.checkNotNullParameter(r8, "playTriggerCallback");
        this.o = r5;
        this.p = r6;
        this.q = r7;
        this.r = r8;
        this.s = r9;
        r5.getLifecycle().addObserver(this);
        this.c = new ArrayList();
        com.bytedance.android.window.shop.widget.holderprocessor.c r10 = new com.bytedance.android.window.shop.widget.holderprocessor.c();
        this.d = r10;
        gr3.e r11 = new gr3.e();
        gr3.d[] r12 = {new z(this), new com.bytedance.android.window.shop.widget.holderprocessor.i(), new com.bytedance.android.window.shop.widget.holderprocessor.f(new WindowTypeSeparatedAdapter$preparePostProcessors$1(this), r8), r10.d};
        Intrinsics.checkNotNullParameter(r12, "processors");
        CollectionsKt.addAll(r11.a, r12);
        Unit r13 = Unit.INSTANCE;
        this.e = r11;
        gr3.e r14 = new gr3.e();
        gr3.d[] r15 = {r10.c, new com.bytedance.android.window.shop.widget.holderprocessor.e(new WindowTypeSeparatedAdapter$preparePreProcessors$1(this), new WindowTypeSeparatedAdapter$preparePreProcessors$2(this)), new com.bytedance.android.window.shop.widget.holderprocessor.b()};
        Intrinsics.checkNotNullParameter(r15, "processors");
        CollectionsKt.addAll(r14.a, r15);
        this.f = r14;
        this.g = WindowLayoutType.DOUBLECOLUMN;
        this.h = new ArrayList();
        this.i = new LinkedHashMap();
        fo.b r16 = new fo.b();
        r16.b(WindowConstDef.a, this.g);
        r16.b(t, this.g);
        this.k = r16;
        int r17 = i.a;
        FallbackStrategy r18 = FallbackStrategy.REPLACE;
        WindowTypeSeparatedAdapter$removeExecutor$1 r19 = new WindowTypeSeparatedAdapter$removeExecutor$1(this);
        WindowTypeSeparatedAdapter$removeExecutor$2 r20 = WindowTypeSeparatedAdapter$removeExecutor$2.INSTANCE;
        Intrinsics.checkNotNullParameter(r18, "strategy");
        int r21 = h.a[r18.ordinal()];
        if (r21 == 1) goto L8;
        if (r21 != 2) goto L7;
        Intrinsics.checkNotNull(r19);
        Object r22 = new f(r19);
    L9:
        this.n = MapsKt.mapOf(new Pair[]{TuplesKt.to(ECLynxCardEvent.FAILED, r22), TuplesKt.to(ECLynxCardEvent.TIMEOUT, r22)});
        return;
    L7:
        throw new NoWhenBranchMatchedException();
    L8:
        Intrinsics.checkNotNull(r20);
        r22 = new g(r20);
        goto L9
    }
}
