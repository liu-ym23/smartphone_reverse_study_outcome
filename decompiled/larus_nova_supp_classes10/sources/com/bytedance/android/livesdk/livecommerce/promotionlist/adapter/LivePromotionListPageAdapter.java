package com.bytedance.android.livesdk.livecommerce.promotionlist.adapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import cf.s;
import com.bytedance.android.bst.api.f;
import com.bytedance.android.ec.common.api.UpdateLocalViewType;
import com.bytedance.android.ec.common.api.jump.model.g;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.base.paging.PageListLoadStatus;
import com.bytedance.android.livesdk.livecommerce.iron.ui.j;
import com.bytedance.android.livesdk.livecommerce.iron.viewbinder.IronPromotionItemViewHolder;
import com.bytedance.android.livesdk.livecommerce.iron.widgets.PromotionLinearLayoutManager;
import com.bytedance.android.livesdk.livecommerce.iron.widgets.PromotionRecyclerView;
import com.bytedance.android.livesdk.livecommerce.largemode.model.ComponentLargeModeConfig;
import com.bytedance.android.livesdk.livecommerce.multitype.e;
import com.bytedance.android.livesdk.livecommerce.network.response.PromotionCategory;
import com.bytedance.android.livesdk.livecommerce.promotion.card.UpdateType;
import com.bytedance.android.livesdk.livecommerce.promotionlist.LivePromotionListParams;
import com.bytedance.android.livesdk.livecommerce.promotionlist.base.LivePromotionListFooterView;
import com.bytedance.android.livesdk.livecommerce.promotionlist.base.LivePromotionListScene;
import com.bytedance.android.livesdk.livecommerce.promotionlist.base.RecyclerViewWithHeaderAndFooterAdapter;
import com.bytedance.android.livesdk.livecommerce.promotionlist.model.LivePromotionPageRoomInfo;
import com.bytedance.android.livesdk.livecommerce.promotionlist.presenter.q;
import com.bytedance.android.livesdk.livecommerce.promotionlist.presenter.r;
import com.bytedance.android.livesdk.livecommerce.promotionlist.viewholder.LivePromotionItemViewHolder;
import com.bytedance.android.livesdk.livecommerce.promotionlist.viewholder.LivePromotionListFooterViewHolder;
import com.bytedance.android.livesdk.livecommerce.promotionlist.viewholder.LivePromotionListHeaderViewHolder;
import com.bytedance.android.livesdk.livecommerce.promotionlist.viewholder.LivePromotionListHeaderWrapperView;
import com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.LivePromotionListViewModel;
import com.bytedance.android.livesdk.livecommerce.room.api.ControllerExtensionsKt;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.skin.ECLiveListSkinUIHelper;
import com.bytedance.android.livesdk.livecommerce.skin.h;
import com.bytedance.android.livesdk.livecommerce.skin.i;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty1;
import mj2.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/promotionlist/adapter/LivePromotionListPageAdapter;", "Lcom/bytedance/android/livesdk/livecommerce/promotionlist/base/RecyclerViewWithHeaderAndFooterAdapter;", "Lmj2/c;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "a", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LivePromotionListPageAdapter extends RecyclerViewWithHeaderAndFooterAdapter<c, RecyclerView.ViewHolder> {
    public static final /* synthetic */ int z = 0;
    public final Set<String> e;
    public final Set<String> f;
    public final Set<String> g;
    public AdapterDataObserverProxy h;
    public PageListLoadStatus i;
    public PageListLoadStatus j;
    public boolean k;
    public boolean l;
    public boolean m;
    public boolean n;
    public boolean o;
    public boolean p;
    public final LifecycleOwner q;
    public final LivePromotionListViewModel r;
    public final j s;
    public final RecyclerView t;
    public final PromotionLinearLayoutManager u;
    public final il.a v;
    public final s w;
    public final cf.j x;
    public final e y;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.promotionlist.adapter.LivePromotionListPageAdapter$3, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    final /* synthetic */ class AnonymousClass3 extends PropertyReference1Impl {
        public static final KProperty1 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass3();
        }

        public AnonymousClass3() {
            super(com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.c.class, "listBannerInfo", "getListBannerInfo()Lcom/bytedance/android/livesdk/livecommerce/network/response/ECPromotionList$ListBanner;", 0);
        }

        public Object get(Object r1) {
            return ((com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.c) r1).f;
        }
    }

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ Function0 a;

        public b(Function0 r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.invoke();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.promotionlist.adapter.LivePromotionListPageAdapter$registerAdapterDataObserver$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
    public static final /* synthetic */ class C02931 extends FunctionReferenceImpl implements Function0<Integer> {
        public C02931(LivePromotionListPageAdapter r8) {
            super(0, r8, LivePromotionListPageAdapter.class, "getHeaderCount", "getHeaderCount()I", 0);
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m980invoke() {
            return Integer.valueOf(invoke());
        }

        public final int invoke() {
            return ((LivePromotionListPageAdapter) ((CallableReference) this).receiver).c ? 1 : 0;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.promotionlist.adapter.LivePromotionListPageAdapter$registerAdapterDataObserver$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "p1", "", "p2", "invoke"}, k = 3, mv = {1, 4, 3})
    public static final /* synthetic */ class C02942 extends FunctionReferenceImpl implements Function2<Integer, Integer, Unit> {
        public C02942(LivePromotionListPageAdapter r8) {
            super(2, r8, LivePromotionListPageAdapter.class, "onItemRangeInserted", "onItemRangeInserted(II)V", 0);
        }

        public final void invoke(int r6, int r7) {
            LivePromotionListPageAdapter r0 = (LivePromotionListPageAdapter) ((CallableReference) this).receiver;
            if (r6 == 1) goto L5;
            int r3 = LivePromotionListPageAdapter.z;
        L9:
            if (r6 != r0.c) goto L22;
            if (r0.getItemCount() != ((r0.c ? 1 : 0) + r7)) goto L22;
            if (r0.p == false) goto L22;
            if (ECLiveABUtils.INSTANCE.getENABLE_FIX_LIST_SCROLL_BOTTOM() == false) goto L18;
            if (r7 != 0) goto L18;
            return;
        L18:
            r0.p = false;
            if (true == r0.b) goto L29;
            r0.b = true;
            r0.H2(true);
            return;
        L29:
            return;
        L22:
            if (r6 == ((r0.getItemCount() - 1) - r7)) goto L24;
            return;
        L24:
            if (r0.o == false) goto L32;
            r0.o = false;
            if (r0.b == false) goto L33;
            r0.b = false;
            r0.H2(false);
            return;
        L33:
            return;
        L32:
            return;
        L5:
            if (r0.k == false) goto L9;
            r0.k = false;
            r0.J2(false);
            goto L9
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            invoke(((Number) r1).intValue(), ((Number) r2).intValue());
            return Unit.INSTANCE;
        }
    }

    static {
    }

    public final void C2() {
        RecyclerView r0 = this.t;
        f.g().d(r0, 2131370502);
        RecyclerView r1 = this.t;
        f.g().d(r1, 2131370503);
        this.e.clear();
        this.f.clear();
        this.g.clear();
        il.a r2 = this.v;
        List r3 = CollectionsKt.listOf(new String[]{"livesdk_show_product", "livesdk_show_product_info"});
        r2.getClass();
        Intrinsics.checkNotNullParameter(r3, "keyList");
        Iterator r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        String r5 = (String) r4.next();
        r2.a.remove(r5);
        goto L4
    }

    public final h E2() {
        if (ECLiveABUtils.INSTANCE.getEC_LIVE_SUPPORT_SKIN_LINKMIC().booleanValue() == false) goto L8;
        com.bytedance.android.livesdk.livecommerce.skin.e r0 = this.r.getListLayoutHelper();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.a();
    L8:
        RoomContextController r1 = this.r.getRoomContextController();
        LivePromotionListParams r2 = this.r.getListParams();
        if (r2 == null) goto L11;
        String r3 = r2.getRoomId();
    L12:
        com.bytedance.android.livesdk.livecommerce.skin.a r4 = ControllerExtensionsKt.c(r1, r3).A().r.H;
        if (r4 != null) goto L15;
        return null;
    L15:
        return r4.b;
    L11:
        r3 = null;
        goto L12
    }

    public final i F2() {
        if (ECLiveABUtils.INSTANCE.getEC_LIVE_SUPPORT_SKIN_LINKMIC().booleanValue() == false) goto L8;
        com.bytedance.android.livesdk.livecommerce.skin.f r0 = this.r.getListSkinHelper();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.b();
    L8:
        RoomContextController r1 = this.r.getRoomContextController();
        LivePromotionListParams r2 = this.r.getListParams();
        if (r2 == null) goto L11;
        String r3 = r2.getRoomId();
    L12:
        ECLiveListSkinUIHelper r4 = ControllerExtensionsKt.c(r1, r3).A().r.G;
        if (r4 != null) goto L15;
        return null;
    L15:
        return r4.b;
    L11:
        r3 = null;
        goto L12
    }

    public static final com.bytedance.android.livesdk.livecommerce.largemode.b B2(LivePromotionListPageAdapter r1) {
        RoomContextController r0 = r1.r.getRoomContextController();
        LivePromotionListParams r2 = r1.r.getListParams();
        if (r2 == null) goto L5;
        String r3 = r2.getRoomId();
    L7:
        return ControllerExtensionsKt.c(r0, r3).A().t.L();
    L5:
        r3 = null;
        goto L7
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotionlist.base.RecyclerViewWithHeaderAndFooterAdapter
    public final void A2(RecyclerView.ViewHolder r8) {
        Intrinsics.checkNotNullParameter(r8, "holder");
        LivePromotionListHeaderViewHolder r1 = (LivePromotionListHeaderViewHolder) r8;
        boolean r2 = this.n;
        PromotionCategory.a r3 = PromotionCategory.Companion;
        PromotionCategory r4 = this.r.getCurrentCategory();
        if (r4 == null) goto L5;
        String r5 = r4.getUniqueIndex();
    L6:
        r3.getClass();
        r1.T3(r2, G2(PromotionCategory.a.b(r5)), this.q, this.i, this.r);
        Intrinsics.checkNotNullParameter(r8, "holder");
        return;
    L5:
        r5 = null;
        goto L6
    }

    public final void D2(Function0<Unit> r3) {
        if (this.t.isComputingLayout() == false) goto L5;
        this.t.post(new b(r3));
        return;
    L5:
        r3.invoke();
    }

    public final boolean G2(boolean r3) {
        mj2.a r0 = ECLiveABUtils.INSTANCE.getECOM_LIVE_PROMOTION_LIST_HINT_HAR_OPT_CONFIG();
        if (this.l == true) goto L5;
    L14:
        return false;
    L5:
        if (this.m == true) goto L14;
        if (r0.b() == false) goto L14;
        if (r0.a() == 0) goto L13;
        if (r3 == false) goto L14;
        if (r0.a() != 2) goto L14;
    L13:
        return true;
    }

    public final void H2(boolean r1) {
        if (r1 == false) goto L4;
        D2(new LivePromotionListPageAdapter$onShowFooterChanged$1(this));
        return;
    L4:
        D2(new LivePromotionListPageAdapter$onShowFooterChanged$2(this));
    }

    public final void I2(boolean r1) {
        if (r1 == false) goto L4;
        D2(new LivePromotionListPageAdapter$onShowHeaderChanged$1(this));
        return;
    L4:
        D2(new LivePromotionListPageAdapter$onShowHeaderChanged$2(this));
    }

    public final void J2(boolean r2) {
        if (this.u.a == true) goto L20;
        if (r2 == false) goto L9;
        if (true == this.c) goto L21;
        this.c = true;
        I2(true);
        return;
    L21:
        return;
    L9:
        if (this.n == true) goto L23;
        PromotionCategory.a r3 = PromotionCategory.Companion;
        PromotionCategory r0 = this.r.getCurrentCategory();
        if (r0 == null) goto L13;
        String r1 = r0.getUniqueIndex();
    L14:
        r3.getClass();
        if (G2(PromotionCategory.a.b(r1)) == false) goto L17;
        return;
    L17:
        if (this.c == false) goto L25;
        this.c = false;
        I2(false);
        return;
    L25:
        return;
    L13:
        r1 = null;
        goto L14
    L23:
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotionlist.base.RecyclerViewWithHeaderAndFooterAdapter
    public final void onBindFooterViewHolder(RecyclerView.ViewHolder r4) {
        Intrinsics.checkNotNullParameter(r4, "holder");
        ((LivePromotionListFooterViewHolder) r4).T3(this.q, this.j, this.r);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotionlist.base.RecyclerViewWithHeaderAndFooterAdapter
    public final RecyclerView.ViewHolder onCreateFooterViewHolder(ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        LivePromotionListFooterViewHolder r0 = new LivePromotionListFooterViewHolder(r4, this.s, this.q);
        Object r5 = ((RecyclerView.ViewHolder) r0).itemView;
        if ((r5 instanceof LivePromotionListFooterView) == true) goto L5;
        r5 = null;
    L5:
        LivePromotionListFooterView r6 = (LivePromotionListFooterView) r5;
        if (r6 == null) goto L8;
        r6.setRecyclerView(this.t);
    L8:
        return r0;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotionlist.base.RecyclerViewWithHeaderAndFooterAdapter
    public final RecyclerView.ViewHolder onCreateHeaderViewHolder(ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        return new LivePromotionListHeaderViewHolder(new LivePromotionListHeaderWrapperView(r4.getContext(), null, 0));
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotionlist.base.RecyclerViewWithHeaderAndFooterAdapter
    public final void onViewAttachedToWindow(RecyclerView.ViewHolder r5) {
        Intrinsics.checkNotNullParameter(r5, "holder");
        super.onViewAttachedToWindow(r5);
        this.t.getRecycledViewPool().setMaxRecycledViews(r5.getItemViewType(), 10);
        final ql.a r1 = null;
        if ((r5 instanceof LivePromotionItemViewHolder) == true) goto L5;
        r5 = null;
    L5:
        LivePromotionItemViewHolder r6 = (LivePromotionItemViewHolder) r5;
        if (r6 == null) goto L15;
        g r7 = r6.Y0();
        if (r7 == null) goto L10;
        r1 = r7.a;
    L10:
        if (r1 != null) goto L12;
        return;
    L12:
        if (r1.isOnTopExplaining() != true) goto L17;
        final String r3 = "livesdk_show_product_explaining";
        this.v.c("livesdk_show_product_explaining", r1.getPromotionId(), new LivePromotionListPageAdapter$logShowProductExplaining$1(this, r3, r1));
        return;
    L17:
        return;
    }

    public final void onViewRecycled(RecyclerView.ViewHolder r2) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        super/*androidx.recyclerview.widget.RecyclerView.Adapter*/.onViewRecycled(r2);
        if ((r2 instanceof LivePromotionItemViewHolder) == false) goto L6;
        ((LivePromotionItemViewHolder) r2).release();
        return;
    L6:
        if ((r2 instanceof IronPromotionItemViewHolder) == false) goto L8;
        ((IronPromotionItemViewHolder) r2).getClass();
        throw null;
    L8:
        if ((r2 instanceof com.bytedance.android.livesdk.livecommerce.promotionlist.viewholder.a) == false) goto L14;
        ((com.bytedance.android.livesdk.livecommerce.promotionlist.viewholder.a) r2).doClear();
        return;
    }

    public final void registerAdapterDataObserver(RecyclerView.AdapterDataObserver r4) {
        Intrinsics.checkNotNullParameter(r4, "observer");
        AdapterDataObserverProxy r0 = new AdapterDataObserverProxy(r4, new C02931(this), new C02942(this));
        super/*androidx.recyclerview.widget.RecyclerView.Adapter*/.registerAdapterDataObserver(r0);
        Unit r5 = Unit.INSTANCE;
        this.h = r0;
    }

    public final void unregisterAdapterDataObserver(RecyclerView.AdapterDataObserver r2) {
        Intrinsics.checkNotNullParameter(r2, "observer");
        AdapterDataObserverProxy r3 = this.h;
        if (r3 == null) goto L11;
        super/*androidx.recyclerview.widget.RecyclerView.Adapter*/.unregisterAdapterDataObserver(r3);     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotionlist.base.RecyclerViewWithHeaderAndFooterAdapter
    public final RecyclerView.ViewHolder onCreateBasicViewHolder(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        com.bytedance.android.livesdk.livecommerce.promotion.card.b r6 = sg2.s.d.Da(r4, this.r.createLivePromotionCardArgument(this.w, this.x), true);
        int r7 = com.bytedance.android.livesdk.livecommerce.promotionlist.viewholder.b.a;
        LivePromotionListScene r8 = this.r.getListScene();
        this.r.getBuyButtonStyle();
        com.bytedance.android.livesdk.livecommerce.promotionlist.viewholder.b.a(r6, r8, F2(), E2(), new LivePromotionListPageAdapter$onCreateBasicViewHolder$$inlined$also$lambda$1(this));
        Unit r9 = Unit.INSTANCE;
        return new LivePromotionItemViewHolder(r6);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotionlist.base.RecyclerViewWithHeaderAndFooterAdapter
    public final void z2(final RecyclerView.ViewHolder r7, int r8, final List<Object> r9) {
        Intrinsics.checkNotNullParameter(r7, "holder");
        final Ref.ObjectRef r0 = new Ref.ObjectRef();
        Object r1 = null;
        r0.element = null;
        c r10 = (c) getItem(r8);
        if (r10 == null) goto L10;
        gi2.a r2 = this.r.safeGetPromotionListParams();
        if (r2 == null) goto L7;
        g r11 = (g) r2.buildParams(Reflection.getOrCreateKotlinClass(g.class), new g.a(r10.a));
    L8:
        r0.element = r11;
        goto L10
    L7:
        r11 = null;
    L10:
        if ((r7 instanceof LivePromotionItemViewHolder) == true) goto L12;
        RecyclerView.ViewHolder r12 = null;
    L14:
        if (((LivePromotionItemViewHolder) r12) == null) goto L48;
        if (r9 == null) goto L17;
        Object r13 = CollectionsKt.firstOrNull(r9);
    L19:
        if ((r13 instanceof UpdateLocalViewType) == false) goto L22;
        r1 = r13;
    L22:
        UpdateLocalViewType r3 = (UpdateLocalViewType) r1;
        if (r3 != null) goto L25;
        r3 = UpdateLocalViewType.UPDATE_ALL;
    L25:
        g r14 = (g) r0.element;
        if (r14 == null) goto L37;
        LivePromotionItemViewHolder r4 = (LivePromotionItemViewHolder) r7;
        Intrinsics.checkNotNullParameter(r3, "$this$convert");
        switch(com.bytedance.android.livesdk.livecommerce.promotion.card.c.a[r3.ordinal()]) {
            case 1: goto L35;
            case 2: goto L35;
            case 3: goto L34;
            case 4: goto L33;
            case 5: goto L32;
            case 6: goto L31;
            default: goto L30;
        };
    L31:
        UpdateType r5 = UpdateType.UPDATE_BUTTON_INFO;
    L36:
        r4.A1(r14, r5);
        goto L37
    L32:
        r5 = UpdateType.UPDATE_EXPOSE;
        goto L36
    L33:
        r5 = UpdateType.HOT_ATMOSPHERE;
        goto L36
    L34:
        r5 = UpdateType.VIEW_RECYCLED;
        goto L36
    L35:
        r5 = UpdateType.UPDATE_ALL;
        goto L36
    L30:
        throw new NoWhenBranchMatchedException();
    L37:
        LivePromotionPageRoomInfo r15 = this.r.getRoomInfo();
        if (r15 != null) goto L40;
    L44:
        e r16 = this.y;
        if (r16 == null) goto L49;
        r16.a();
        return;
    L49:
        return;
    L40:
        if (r15.getRoomType() != 2) goto L44;
        int r17 = com.bytedance.android.livesdk.livecommerce.promotionlist.viewholder.b.a;
        com.bytedance.android.livesdk.livecommerce.promotion.card.b r18 = ((LivePromotionItemViewHolder) r7).a;
        LivePromotionListScene r6 = this.r.getListScene();
        this.r.getBuyButtonStyle();
        i r19 = F2();
        h r20 = E2();
        Function1<String, ComponentLargeModeConfig> r21 = new LivePromotionListPageAdapter$onBindBasicViewHolder$$inlined$also$lambda$1(this, r9, r0, r7);
        g r22 = (g) r0.element;
        com.bytedance.android.livesdk.livecommerce.promotionlist.viewholder.b.a(r18, r6, r19, r20, r21);
        if (this.r.getListScene() != LivePromotionListScene.INSTANT_RETAIL_FUSION) goto L44;
        View r23 = r7.itemView;
        r23.setPadding(r23.getPaddingLeft(), UtilityKotlinExtentionsKt.d(2), r23.getPaddingRight(), UtilityKotlinExtentionsKt.d(2));
        goto L44
    L17:
        r13 = null;
        goto L19
    L48:
        return;
    L12:
        r12 = r7;
        goto L14
    }

    public LivePromotionListPageAdapter(LifecycleOwner r1, LivePromotionListViewModel r2, com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.subviewmodel.a r3, PromotionRecyclerView r4, PromotionLinearLayoutManager r5, di2.b r6, il.a r7, q r8, r r9, com.bytedance.android.livesdk.livecommerce.promotionlist.presenter.s r10) {
        Intrinsics.checkNotNullParameter(r1, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r2, "vm");
        Intrinsics.checkNotNullParameter(r3, "footerViewModel");
        Intrinsics.checkNotNullParameter(r4, "recyclerView");
        Intrinsics.checkNotNullParameter(r5, "layoutManager");
        Intrinsics.checkNotNullParameter(r7, "eventMap");
        Intrinsics.checkNotNullParameter(r8, "promotionListItemBtmHandler");
        Intrinsics.checkNotNullParameter(r9, "itemRefreshHandler");
        super(new LivePromotionItemDiffCallback());
        this.q = r1;
        this.r = r2;
        this.s = r3;
        this.t = r4;
        this.u = r5;
        this.v = r7;
        this.w = r8;
        this.x = r9;
        this.y = r10;
        this.e = new LinkedHashSet();
        this.f = new LinkedHashSet();
        this.g = new LinkedHashSet();
        PromotionCategory.a r11 = PromotionCategory.Companion;
        PromotionCategory r12 = r2.getCurrentCategory();
        if (r12 == null) goto L5;
        String r13 = r12.getUniqueIndex();
    L6:
        r11.getClass();
        if (G2(PromotionCategory.a.b(r13)) == false) goto L12;
        if (true == this.c) goto L14;
        this.c = true;
        I2(true);
    L14:
        com.bytedance.android.ec.core.arch.event.c.c(r2, r1, Reflection.getOrCreateKotlinClass(com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.m.class), new AnonymousClass1(this));
        com.bytedance.android.ec.core.arch.event.c.c(r2, r1, Reflection.getOrCreateKotlinClass(com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.l.class), new AnonymousClass2(this));
        if (ECLiveABUtils.INSTANCE.getECOM_LIVE_PROMOTION_LIST_HINT_HAR_OPT_CONFIG().b() == false) goto L18;
        com.bytedance.android.ec.core.arch.state.c.a(r2, r1, AnonymousClass3.INSTANCE, new AnonymousClass4(this));
        com.bytedance.android.ec.core.arch.event.c.c(r2, r1, Reflection.getOrCreateKotlinClass(com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.e0.class), new AnonymousClass5(this));
        com.bytedance.android.ec.core.arch.event.c.c(r2, r1, Reflection.getOrCreateKotlinClass(com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.h.class), new AnonymousClass6(this));
        return;
    L18:
        return;
    L12:
        if (this.c == false) goto L14;
        this.c = false;
        I2(false);
        goto L14
    L5:
        r13 = null;
        goto L6
    }
}
