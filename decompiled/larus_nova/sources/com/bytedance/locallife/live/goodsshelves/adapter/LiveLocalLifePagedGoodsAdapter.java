package com.bytedance.locallife.live.goodsshelves.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.dux.text.DuxTextView;
import com.bytedance.locallife.live.dsl.LiveLocalLifeDSLEngine;
import com.bytedance.locallife.live.dsl.h;
import com.bytedance.locallife.live.dsl.shelf.LiveLocalLifeShelfDSLEngine;
import com.bytedance.locallife.live.experiment.a0;
import com.bytedance.locallife.live.experiment.r0;
import com.bytedance.locallife.live.goodsshelves.bean.LiveGoodsShelvesCard;
import com.bytedance.locallife.live.goodsshelves.bean.LiveGoodsShelvesDSLPagingResponse;
import com.bytedance.locallife.live.goodsshelves.bean.LiveGoodsShelvesResponse;
import com.bytedance.locallife.live.goodsshelves.bean.LiveLocalLifeCardData;
import com.bytedance.locallife.live.goodsshelves.bean.i0;
import com.bytedance.locallife.live.goodsshelves.bean.l0;
import com.bytedance.locallife.live.goodsshelves.manager.GoodsShelfCardPreloadManager;
import com.bytedance.locallife.live.goodsshelves.manager.ShelfDefaultTabManager;
import com.bytedance.locallife.live.goodsshelves.manager.i;
import com.bytedance.locallife.live.goodsshelves.repository.GoodsShelvesRepository;
import com.bytedance.locallife.live.goodsshelves.repository.l;
import com.bytedance.locallife.live.goodsshelves.view.LiveLifeShelfBrandContainerView;
import com.bytedance.locallife.live.goodsshelves.view.LiveLifeShelfIndustryContainerView;
import com.bytedance.locallife.live.goodsshelves.view.LiveLifeShelfIndustryTagView;
import com.bytedance.locallife.live.goodsshelves.view.LiveLocalLifeShelfCardLynxView;
import com.bytedance.locallife.live.goodsshelves.view.PriorityWholeChildLayout;
import com.bytedance.locallife.live.goodsshelves.viewholder.LiveLocalLifeGoodsShelvesDslViewHolder;
import com.bytedance.locallife.live.goodsshelves.viewholder.LiveLocalLifeGoodsShelvesLynxNativeViewHolder;
import com.bytedance.locallife.live.goodsshelves.viewholder.LiveLocalLifeGoodsShelvesViewHolder;
import com.bytedance.locallife.live.goodsshelves.viewholder.LiveLocalLifeGoodsShelvesViewHolder2;
import com.bytedance.locallife.live.goodsshelves.viewholder.LiveLocalLifeLoadMoreViewHolder;
import com.bytedance.locallife.live.goodsshelves.viewmodel.LiveGoodsShelvesViewModel;
import com.bytedance.locallife.live.util.LiveLifeSaaSUtil;
import com.bytedance.locallife.live.util.j0;
import com.bytedance.locallife.live.util.w;
import com.bytedance.locallife.live.viewmodel.LiveLocalLifeViewModel;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.google.gson.Gson;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import df6.q;
import df6.u;
import ev6.d;
import ev6.e;
import ev6.f;
import ev6.g;
import ev6.n0;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import nv6.m;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/locallife/live/goodsshelves/adapter/LiveLocalLifePagedGoodsAdapter;", "Lcom/bytedance/locallife/live/goodsshelves/adapter/HeaderAndFooterRecyclerViewAdapter;", "Lcom/bytedance/locallife/live/goodsshelves/bean/b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
public final class LiveLocalLifePagedGoodsAdapter extends HeaderAndFooterRecyclerViewAdapter<com.bytedance.locallife.live.goodsshelves.bean.b, RecyclerView.ViewHolder> {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final LiveLocalLifePagedGoodsAdapter$Companion$DIFF_CALLBACK$1 f259536m = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<Unit> f259537c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<Unit> f259538d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LinearLayoutManager f259539e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public i f259540f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public LiveGoodsShelvesViewModel f259541g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f259542h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public FragmentActivity f259543i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f259544j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Function0<Unit> f259545k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f259546l;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f259547a;

        public b(Function0<Unit> r100) {
            this.f259547a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f259547a.invoke();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.locallife.live.goodsshelves.adapter.LiveLocalLifePagedGoodsAdapter$Companion$DIFF_CALLBACK$1] */
    static {
        f259536m = new LiveLocalLifePagedGoodsAdapter$Companion$DIFF_CALLBACK$1();
    }

    public final String B2() {
        LiveGoodsShelvesViewModel r100 = this.f259541g;
        if (r100 == null) goto L9;
        LiveLocalLifeShelfDSLEngine r101 = r100.getDslCardEngine();
        if (r101 == null) goto L9;
        String r102 = r101.f259477j;
        if (r102 == null) goto L9;
        return r102;
    L9:
        return h.c();
    }

    public final LinearLayoutManager C2() {
        LinearLayoutManager r100 = this.f259539e;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
        return null;
    }

    @Override // com.bytedance.locallife.live.goodsshelves.adapter.HeaderAndFooterRecyclerViewAdapter
    public final void z2() {
        LiveGoodsShelvesViewModel r100 = this.f259541g;
        if (r100 == null) goto L6;
        r100.setRenderStartTime(SystemClock.elapsedRealtime());
    L6:
        this.f259537c.invoke();
        this.f259538d.invoke();
        Function0<Unit> r101 = this.f259545k;
        if (r101 == null) goto L12;
        if (r101 == null) goto L10;
        r101.invoke();
    L10:
        this.f259545k = null;
        return;
    }

    public final void A2(Function0<Unit> r100) {
        LiveGoodsShelvesViewModel r101 = this.f259541g;
        if (r101 == null) goto L16;
        MutableLiveData<WeakReference<RecyclerView>> r102 = r101.getCurrentShelfRecyclerView();
        if (r102 == null) goto L17;
        WeakReference<RecyclerView> r103 = r102.getValue();
        if (r103 == null) goto L18;
        RecyclerView r104 = r103.get();
        if (r104 != null) goto L12;
        return;
    L12:
        if (r104.isComputingLayout() == false) goto L14;
        r104.post(new b(r100));
        return;
    L14:
        r100.invoke();
        return;
    L18:
        return;
    L17:
        return;
    }

    public final void D2(boolean r100) {
        if (r100 == false) goto L4;
        A2(new LiveLocalLifePagedGoodsAdapter$onShowFooterChanged$1(this));
        return;
    L4:
        A2(new LiveLocalLifePagedGoodsAdapter$onShowFooterChanged$2(this));
    }

    @Override // com.bytedance.locallife.live.goodsshelves.adapter.HeaderAndFooterRecyclerViewAdapter
    public final int getBasicItemViewType(int r100) {
        boolean r101 = true;
        if (r100 <= (getItemCount() - 1)) goto L5;
        return 0;
    L5:
        com.bytedance.locallife.live.goodsshelves.bean.b r102 = getItem(r100);
        if (r102 != null) goto L8;
        return 0;
    L8:
        int r103 = 21;
        if (r0.a() == false) goto L12;
        return 21;
    L12:
        if (a0.a() == true) goto L14;
    L18:
        r101 = false;
    L19:
        if (r101 == true) goto L21;
    L23:
        this.f259544j = r103;
        return r103;
    L21:
        if (r102.f259586a.getCardDynamicType() < 2) goto L23;
        r103 = 8;
        goto L23
    L14:
        if (r102.f259588c == null) goto L18;
        boolean r104 = LiveLocalLifeDSLEngine.f259406a;
        if (LiveLocalLifeDSLEngine.b("live_life_shelf_item", B2()) == false) goto L18;
        goto L18
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final long getItemId(int r100) {
        PagedList<com.bytedance.locallife.live.goodsshelves.bean.b> r101 = getCurrentList();     // Catch: Exception -> L20
        if (r101 == null) goto L9;
        List<com.bytedance.locallife.live.goodsshelves.bean.b> r102 = r101.snapshot();     // Catch: Exception -> L20
        if (r102 == null) goto L9;
        com.bytedance.locallife.live.goodsshelves.bean.b r103 = (com.bytedance.locallife.live.goodsshelves.bean.b) ListProtector.get(r102, r100);     // Catch: Exception -> L20
        if (r103 == null) goto L9;
        LiveGoodsShelvesCard r104 = r103.f259586a;     // Catch: Exception -> L20
    L10:
        long r105 = 1;
        if (r104 == null) goto L15;
        String r106 = r104.getCardId();     // Catch: Exception -> L20
        if (r106 == null) goto L15;
        long r107 = CastLongProtector.parseLong(r106);     // Catch: Exception -> L20
    L16:
        if (r104 == null) goto L24;
        r105 = r104.getCloneFlag();     // Catch: Exception -> L20
    L24:
        return r107 * r105;
    L15:
        r107 = 1;
    L9:
        r104 = null;
    L21:
        return r100;
    }

    @Override // com.bytedance.locallife.live.goodsshelves.adapter.HeaderAndFooterRecyclerViewAdapter
    public final RecyclerView.ViewHolder onCreateFooterViewHolder(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        return new LiveLocalLifeLoadMoreViewHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.saas_poi_live_life_shelf_more, r100, false));
    }

    public LiveLocalLifePagedGoodsAdapter(Function0<Unit> r100, Function0<Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "checkShowListener");
        Intrinsics.checkNotNullParameter(r101, "onListNotifyChangeListener");
        super(f259536m);
        this.f259537c = r100;
        this.f259538d = r101;
        this.f259546l = LazyKt.lazy(LiveLocalLifePagedGoodsAdapter$nativeUIDataProcessor$2.INSTANCE);
        setHasStableIds(true);
    }

    public final void E2(LiveGoodsShelvesDSLPagingResponse r100, boolean r101) {
        PagedList<com.bytedance.locallife.live.goodsshelves.bean.b> r102 = null;
        if (r100 != null) goto L11;
        LiveGoodsShelvesViewModel r103 = this.f259541g;
        if (r103 == null) goto L9;
        LiveData<PagedList<com.bytedance.locallife.live.goodsshelves.bean.b>> r104 = r103.getLifeShelfPagedList();
        if (r104 == null) goto L9;
        r102 = r104.getValue();
    L9:
        submitList(r102);
        return;
    L11:
        LiveGoodsShelvesViewModel r105 = this.f259541g;
        boolean r106 = true;
        final int r107 = 0;
        if (r105 == null) goto L20;
        GoodsShelvesRepository r108 = r105.getGoodsShelvesRepository();
        if (r108 == null) goto L20;
        l r109 = r108.g();
        if (r109 == null) goto L20;
        if (r109.f259849p != 1) goto L20;
        boolean r110 = true;
    L21:
        if (r110 == false) goto L48;
        LiveGoodsShelvesViewModel r111 = this.f259541g;
        if (r111 == null) goto L31;
        GoodsShelvesRepository r112 = r111.getGoodsShelvesRepository();
        if (r112 == null) goto L31;
        l r113 = r112.g();
        if (r113 == null) goto L31;
        if (r113.f259840g != 3) goto L31;
    L32:
        if (r106 == true) goto L48;
        if (r101 == true) goto L48;
        if (C2().getItemCount() <= 0) goto L39;
        View r114 = C2().findViewByPosition(C2().findFirstVisibleItemPosition());
        if (r114 == null) goto L39;
        final int r115 = r114.getTop();
    L40:
        LiveGoodsShelvesViewModel r116 = this.f259541g;
        if (r116 == null) goto L47;
        com.bytedance.locallife.live.goodsshelves.bean.b r117 = r116.getCurrentFirstItem();
        if (r117 == null) goto L47;
        LiveGoodsShelvesCard r118 = r117.f259586a;
        if (r118 == null) goto L47;
        r107 = r118.getLocalOrder();
    L47:
        this.f259545k = new LiveLocalLifePagedGoodsAdapter$setListData$1(r107, this, r115);
    L39:
        r115 = 0;
    L31:
        r106 = false;
    L48:
        LiveGoodsShelvesViewModel r119 = this.f259541g;
        if (r119 == null) goto L53;
        LiveData<PagedList<com.bytedance.locallife.live.goodsshelves.bean.b>> r120 = r119.getLifeShelfPagedList();
        if (r120 == null) goto L53;
        r102 = r120.getValue();
    L53:
        submitList(r102);
        return;
    L20:
        r110 = false;
        goto L21
    }

    @Override // com.bytedance.locallife.live.goodsshelves.adapter.HeaderAndFooterRecyclerViewAdapter
    public final RecyclerView.ViewHolder onCreateBasicViewHolder(ViewGroup r110, int r111) {
        Intrinsics.checkNotNullParameter(r110, "parent");
        String r100 = "";
        if (r111 != 21) goto L20;
        LiveLocalLifeViewModel.Companion r112 = LiveLocalLifeViewModel.Companion;
        LiveGoodsShelvesViewModel r101 = this.f259541g;
        if (r101 == null) goto L10;
        String r102 = r101.getUniqueKey();
        if (r102 == null) goto L10;
        r100 = r102;
    L10:
        r112.getClass();
        LiveLocalLifeViewModel r113 = LiveLocalLifeViewModel.Companion.a(r100);
        if (r113 == null) goto L16;
        GoodsShelfCardPreloadManager r114 = r113.getShelfCardPreloadManager();
        if (r114 == null) goto L16;
        boolean r103 = GoodsShelfCardPreloadManager.d.f259651d;
        Context r104 = r110.getContext();
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type android.app.Activity");
        View r115 = r114.c(R.layout.saas_live_life_goods_shelves, (Activity) r104, r110);
        if (r115 == null) goto L16;
    L18:
        return new LiveLocalLifeGoodsShelvesViewHolder2(r115, this.f259537c, this.f259541g);
    L16:
        LayoutInflater r116 = LayoutInflater.from(r110.getContext());
        boolean r105 = GoodsShelfCardPreloadManager.d.f259651d;
        r115 = r116.inflate(R.layout.saas_live_life_goods_shelves, r110, false);
        goto L18
    L20:
        if (r111 != 7) goto L43;
        Context r106 = r110.getContext();
        LiveLocalLifeViewModel.Companion r117 = LiveLocalLifeViewModel.Companion;
        LiveGoodsShelvesViewModel r118 = this.f259541g;
        if (r118 == null) goto L25;
        String r119 = r118.getUniqueKey();
        if (r119 == null) goto L25;
    L26:
        r117.getClass();
        LiveLocalLifeViewModel r120 = LiveLocalLifeViewModel.Companion.a(r119);
        if (r120 == null) goto L32;
        GoodsShelfCardPreloadManager r121 = r120.getShelfCardPreloadManager();
        if (r121 == null) goto L32;
        LiveLocalLifeShelfCardLynxView r122 = r121.b(r106);
        if (r122 == null) goto L32;
    L41:
        return new LiveLocalLifeGoodsShelvesLynxNativeViewHolder(r122, this.f259537c, this.f259541g);
    L32:
        LiveGoodsShelvesViewModel r123 = this.f259541g;
        if (r123 == null) goto L38;
        String r124 = r123.getUniqueKey();
        if (r124 == null) goto L38;
        String r107 = r124;
    L39:
        r122 = new LiveLocalLifeShelfCardLynxView(r106, null, 0, r107, 6);
    L38:
        r107 = "";
    L25:
        r119 = "";
        goto L26
    L43:
        if (r111 != 8) goto L59;
        LiveLocalLifeViewModel.Companion r125 = LiveLocalLifeViewModel.Companion;
        LiveGoodsShelvesViewModel r108 = this.f259541g;
        if (r108 == null) goto L50;
        String r109 = r108.getUniqueKey();
        if (r109 == null) goto L50;
        r100 = r109;
    L50:
        r125.getClass();
        LiveLocalLifeViewModel r126 = LiveLocalLifeViewModel.Companion.a(r100);
        if (r126 == null) goto L56;
        GoodsShelfCardPreloadManager r127 = r126.getShelfCardPreloadManager();
        if (r127 == null) goto L56;
        iv6.a r128 = r127.a(B2());
        if (r128 == null) goto L56;
    L58:
        return new LiveLocalLifeGoodsShelvesDslViewHolder(r128, this.f259537c, this.f259541g);
    L56:
        r128 = new iv6.a(r110.getContext(), B2());
        goto L58
    L59:
        LiveLocalLifeViewModel.Companion r129 = LiveLocalLifeViewModel.Companion;
        LiveGoodsShelvesViewModel r130 = this.f259541g;
        if (r130 == null) goto L65;
        String r131 = r130.getUniqueKey();
        if (r131 == null) goto L65;
        r100 = r131;
    L65:
        r129.getClass();
        LiveLocalLifeViewModel r132 = LiveLocalLifeViewModel.Companion.a(r100);
        if (r132 == null) goto L71;
        GoodsShelfCardPreloadManager r133 = r132.getShelfCardPreloadManager();
        if (r133 == null) goto L71;
        boolean r134 = GoodsShelfCardPreloadManager.d.f259651d;
        Context r135 = r110.getContext();
        Intrinsics.checkNotNull(r135, "null cannot be cast to non-null type android.app.Activity");
        View r136 = r133.c(R.layout.saas_poi_item_live_goods_shelves, (Activity) r135, r110);
        if (r136 == null) goto L71;
    L73:
        return new LiveLocalLifeGoodsShelvesViewHolder(r136, true, this.f259541g);
    L71:
        LayoutInflater r137 = LayoutInflater.from(r110.getContext());
        boolean r138 = GoodsShelfCardPreloadManager.d.f259651d;
        r136 = r137.inflate(R.layout.saas_poi_item_live_goods_shelves, r110, false);
        goto L73
    }

    @Override // com.bytedance.locallife.live.goodsshelves.adapter.HeaderAndFooterRecyclerViewAdapter
    public final void y2(RecyclerView.ViewHolder r210, int r211, List<Object> r212) {
        Intrinsics.checkNotNullParameter(r210, "holder");
        boolean r100 = true;
        if (r211 <= (getItemCount() - 1)) goto L5;
        return;
    L5:
        com.bytedance.locallife.live.goodsshelves.bean.b r101 = getItem(r211);
        boolean r110 = false;
        if (r101 == null) goto L10;
        r101.f259590e = false;
    L10:
        if ((r210 instanceof LiveLocalLifeGoodsShelvesViewHolder) == false) goto L34;
        LiveLocalLifeGoodsShelvesViewHolder r111 = (LiveLocalLifeGoodsShelvesViewHolder) r210;
        if (r101 == null) goto L14;
        LiveGoodsShelvesCard r112 = r101.f259586a;
    L15:
        FragmentActivity r113 = this.f259543i;
        int r114 = this.f259542h;
        LiveGoodsShelvesViewModel r102 = this.f259541g;
        if (r102 == null) goto L20;
        m r103 = r102.getCurrentTabFilterData();
        if (r103 == null) goto L20;
        int r104 = r103.f520906a;
    L21:
        int r115 = r104;
        i r105 = this.f259540f;
        LiveGoodsShelvesViewModel r106 = this.f259541g;
        if (r106 == null) goto L32;
        MutableLiveData<LiveGoodsShelvesDSLPagingResponse> r107 = r106.getLiveGoodsShelfPagingResponse();
        if (r107 == null) goto L32;
        LiveGoodsShelvesDSLPagingResponse r108 = r107.getValue();
        if (r108 == null) goto L32;
        LiveGoodsShelvesResponse r109 = r108.f259555e;
        if (r109 == null) goto L32;
        Boolean r116 = r109.isTalentShowcase();
        if (r116 == null) goto L32;
        r110 = r116.booleanValue();
    L32:
        r111.U3(r112, r113, r114, r115, false, r105, Boolean.valueOf(r110));
        return;
    L20:
        r104 = ShelfDefaultTabManager.b();
        goto L21
    L14:
        r112 = null;
        goto L15
    L34:
        if ((r210 instanceof LiveLocalLifeGoodsShelvesViewHolder2) == false) goto L204;
        String r117 = "";
        if (r0.a() == true) goto L77;
        if (r101 == null) goto L39;
        d r118 = r101.f259589d;
    L40:
        if (r118 != null) goto L77;
        if (r101 == null) goto L43;
        LiveGoodsShelvesCard r119 = r101.f259586a;
    L44:
        if (r101 == null) goto L50;
        Map<String, Object> r120 = r101.f259587b;
        if (r120 == null) goto L50;
        Map<String, Object> r121 = w.d(r120, "card_data");
        if (r121 == null) goto L50;
        Map<String, Object> r122 = w.d(r121, "element");
    L51:
        Gson r123 = LiveLifeSaaSUtil.r();
        i0 r124 = (i0) r123.fromJson(r123.toJson(r122), i0.class);     // Catch: Exception -> L54
    L55:
        if (r124 != null) goto L57;
        return;
    L57:
        if (r119 == null) goto L59;
        LiveLocalLifeCardData r125 = r119.getCard_data();
    L60:
        if (r125 == null) goto L63;
        r125.setBffCardData(r124);
    L63:
        if (r119 == null) goto L77;
        LiveLocalLifeCardData r126 = r119.getCard_data();
        if (r126 == null) goto L77;
        i0 r127 = r126.getBffCardData();
        if (r127 == null) goto L77;
        com.bytedance.locallife.live.goodsshelves.processor.d r128 = (com.bytedance.locallife.live.goodsshelves.processor.d) this.f259546l.getValue();
        Pair[] r129 = new Pair[3];
        r129[0] = TuplesKt.to("local_order", Integer.valueOf(r119.getLocalOrder()));
        LiveGoodsShelvesViewModel r130 = this.f259541g;
        if (r130 == null) goto L72;
        String r131 = r130.getUniqueKey();
        if (r131 == null) goto L72;
    L73:
        r129[1] = TuplesKt.to("unique_key", r131);
        r129[2] = TuplesKt.to("is_top_explain", Integer.valueOf(Intrinsics.areEqual(r119.isTopShowing(), Boolean.TRUE) ? 1 : 0));
        HashMap r132 = MapsKt.hashMapOf(r129);
        l0 r133 = r119.getParsedFeConfig();
        if (r133 == null) goto L76;
        r132.put("fe_config", r133);
    L76:
        Unit r134 = Unit.INSTANCE;
        r101.f259589d = r128.b(r127, r132);
    L72:
        r131 = "";
        goto L73
    L59:
        r125 = null;
    L54:
        r124 = null;
    L50:
        r122 = null;
        goto L51
    L43:
        r119 = null;
        goto L44
    L39:
        r118 = null;
    L77:
        LiveLocalLifeGoodsShelvesViewHolder2 r135 = (LiveLocalLifeGoodsShelvesViewHolder2) r210;
        if (r101 == null) goto L80;
        d r136 = r101.f259589d;
    L81:
        if (r101 == null) goto L83;
        LiveGoodsShelvesCard r137 = r101.f259586a;
    L84:
        FragmentActivity r138 = this.f259543i;
        int r139 = this.f259542h;
        LiveGoodsShelvesViewModel r140 = this.f259541g;
        if (r140 == null) goto L89;
        m r141 = r140.getCurrentTabFilterData();
        if (r141 == null) goto L89;
        int r142 = r141.f520906a;
    L90:
        i r143 = this.f259540f;
        LiveGoodsShelvesViewModel r144 = this.f259541g;
        if (r144 == null) goto L101;
        MutableLiveData<LiveGoodsShelvesDSLPagingResponse> r145 = r144.getLiveGoodsShelfPagingResponse();
        if (r145 == null) goto L101;
        LiveGoodsShelvesDSLPagingResponse r146 = r145.getValue();
        if (r146 == null) goto L101;
        LiveGoodsShelvesResponse r147 = r146.f259555e;
        if (r147 == null) goto L101;
        Boolean r148 = r147.isTalentShowcase();
        if (r148 == null) goto L101;
        boolean r149 = r148.booleanValue();
    L102:
        d r150 = r136;
        r135.T3(r137, r138, r139, r142, r143, Boolean.valueOf(r149), r211);
        if (r150 == null) goto L124;
        d.a r151 = r150.f474288a;
        if (r151 == null) goto L124;
        float r152 = r151.f474292a;
        ViewGroup.LayoutParams r153 = r135.itemView.getLayoutParams();
        if ((r153 instanceof ViewGroup.MarginLayoutParams) == false) goto L109;
        ViewGroup.MarginLayoutParams r154 = (ViewGroup.MarginLayoutParams) r153;
    L111:
        if (r154 == null) goto L113;
        r154.height = (int) j0.b(r152);
        r154.setMargins(j0.c(8), 0, j0.c(8), (int) j0.b(r151.f474293b));
        r135.itemView.setLayoutParams(r154);
    L114:
        View r155 = r135.itemView;
        GradientDrawable r156 = new GradientDrawable();
        r156.setShape(0);
        r156.setColor(-1);
        r156.setCornerRadii(new float[]{j0.b(r151.f474296e), j0.b(r151.f474296e), j0.b(r151.f474297f), j0.b(r151.f474297f), j0.b(r151.f474299h), j0.b(r151.f474299h), j0.b(r151.f474298g), j0.b(r151.f474298g)});
        r155.setBackground(r156);
        float r157 = r151.f474294c;
        ViewGroup.LayoutParams r158 = r135.f260357o.getLayoutParams();
        if ((r158 instanceof ViewGroup.MarginLayoutParams) == false) goto L117;
        ViewGroup.MarginLayoutParams r159 = (ViewGroup.MarginLayoutParams) r158;
    L118:
        if (r159 == null) goto L122;
        int r160 = (int) j0.b(r157);
        if (r159.height == r160) goto L123;
        r159.height = r160;
        r135.f260357o.setLayoutParams(r159);
    L123:
        ViewGroup r161 = r135.f260357o;
        GradientDrawable r162 = new GradientDrawable();
        r162.setShape(0);
        r162.setColor(com.bytedance.locallife.live.util.b.a(r151.f474295d));
        r162.setCornerRadius(j0.b(12));
        r161.setBackground(r162);
        goto L124
    L122:
        r135.f260357o.setLayoutParams(new ViewGroup.MarginLayoutParams(-1, (int) j0.b(r157)));
        goto L123
    L117:
        r159 = null;
        goto L118
    L113:
        ViewGroup.MarginLayoutParams r163 = new ViewGroup.MarginLayoutParams(-1, (int) j0.b(r152));
        r163.setMargins(j0.c(8), 0, j0.c(8), (int) j0.b(r151.f474293b));
        r135.itemView.setLayoutParams(r163);
        goto L114
    L109:
        r154 = null;
    L124:
        if (r150 == null) goto L126;
        ev6.c r164 = r150.f474289b;
    L128:
        if (r164 == null) goto L170;
        ev6.c.a r165 = r164.f474275a;
        if (r165 != null) goto L132;
    L134:
        boolean r166 = false;
    L135:
        if (r166 == false) goto L169;
        com.bytedance.locallife.live.util.a.a(r135.f260356n, true);
        LiveLifeShelfBrandContainerView r167 = r135.f260356n;
        r167.getClass();
        Intrinsics.checkNotNullParameter(r164, "uiData");
        ev6.c.a r168 = r164.f474275a;
        float r169 = 0.0f;
        if (r168 == null) goto L144;
        float r170 = r168.f474280b;
        if (r170 != 0.0f) goto L141;
        boolean r171 = true;
    L142:
        if (r171 == true) goto L144;
        r167.setPadding(0, (int) j0.b(r170), 0, 0);
        goto L144
    L141:
        r171 = false;
    L144:
        f r172 = r164.f474276b;
        if (r172 == null) goto L162;
        Float r173 = r172.f474310b;
        if (r173 == null) goto L149;
        float r174 = r173.floatValue();
    L150:
        int r175 = (int) j0.b(r174);
        Float r176 = r172.f474311c;
        if (r176 == null) goto L153;
        r169 = r176.floatValue();
    L153:
        int r177 = (int) j0.b(r169);
        if (r175 == 0) goto L161;
        if (r177 == 0) goto L161;
        ViewGroup.LayoutParams r178 = r167.f260163a.getLayoutParams();
        if (r178 == null) goto L159;
        r178.width = r175;
        r178.height = r177;
    L160:
        r167.f260163a.setLayoutParams(r178);
        goto L161
    L159:
        r178 = new ViewGroup.MarginLayoutParams(r175, r177);
    L161:
        u r179 = q.e(r172.f474309a);
        r179.b("live_life_shelf_brand_icon");
        r179.f468294t = r167.f260163a;
        r179.c();
        goto L162
    L149:
        r174 = 0.0f;
    L162:
        n0 r180 = r164.f474277c;
        if (r180 == null) goto L165;
        r167.f260164b.setText(r180.f474392a);
    L165:
        n0 r181 = r164.f474278d;
        if (r181 == null) goto L168;
        com.bytedance.locallife.live.util.a.a(r167.f260165c, true);
        com.bytedance.locallife.live.util.a.a(r167.f260166d, true);
        r167.f260166d.setText(r181.f474392a);
    L171:
        if (r150 == null) goto L173;
        e r182 = r150.f474290c;
    L174:
        r135.b4(r182);
        if (r150 == null) goto L177;
        ev6.h r183 = r150.f474291d;
    L178:
        if (r183 == null) goto L201;
        ev6.h.a r184 = r183.f474319a;
        if (r184 != null) goto L182;
    L184:
        r100 = false;
    L185:
        com.bytedance.locallife.live.util.a.a(r135.f260359q, r100);
        if (r100 == false) goto L200;
        LiveLifeShelfIndustryContainerView r185 = r135.f260359q;
        r185.getClass();
        Intrinsics.checkNotNullParameter(r183, "uiData");
        r185.f260175d = r183;
        f r186 = r183.f474320b;
        if (r186 == null) goto L190;
        u r187 = q.e(r186.f474309a);
        r187.b("live_life_shelf_product_industry_icon");
        r187.f468294t = r185.f260172a;
        r187.c();
    L190:
        List<g> r188 = r183.f474321c;
        if (r188 == null) goto L196;
        r185.f260173b.removeAllViews();
        Iterator<T> r189 = r188.iterator();
    L194:
        if (r189.hasNext() == false) goto L196;
        g r190 = (g) r189.next();
        LiveLifeShelfIndustryTagView r191 = new LiveLifeShelfIndustryTagView(r185.getContext(), null, 6, 0);
        PriorityWholeChildLayout.PWCLayoutParams r192 = new PriorityWholeChildLayout.PWCLayoutParams(j0.c(40), j0.c(40));
        r192.setMargins(j0.c(8), 0, 0, 0);
        Intrinsics.checkNotNullParameter(r190, "uiData");
        u r193 = q.e(r190.f474315a.f474309a);
        r193.b("live_life_shelf_product_industry_tag_iv");
        r193.f468294t = r191.f260178a;
        r193.c();
        r191.f260179b.setText(r190.f474316b.f474392a);
        r185.f260173b.addView(r191, r192);
    L196:
        DuxTextView r194 = r185.f260174c;
        String r195 = r183.f474322d;
        if (r195 == null) goto L199;
        r117 = r195;
    L199:
        r194.setText(r117);
    L200:
        Unit r196 = Unit.INSTANCE;
    L202:
        if (r196 != null) goto L235;
        com.bytedance.locallife.live.util.a.a(r135.f260359q, false);
        return;
    L235:
        return;
    L182:
        if (r184.f474324a != true) goto L184;
    L201:
        r196 = null;
        goto L202
    L177:
        r183 = null;
        goto L178
    L173:
        r182 = null;
        goto L174
    L168:
        com.bytedance.locallife.live.util.a.a(r167.f260165c, false);
        com.bytedance.locallife.live.util.a.a(r167.f260166d, false);
        goto L171
    L169:
        com.bytedance.locallife.live.util.a.a(r135.f260356n, false);
        goto L171
    L132:
        if (r165.f474279a != true) goto L134;
        r166 = true;
        goto L135
    L170:
        com.bytedance.locallife.live.util.a.a(r135.f260356n, false);
        goto L171
    L126:
        r164 = null;
    L101:
        r149 = false;
    L89:
        r142 = 1;
        goto L90
    L83:
        r137 = null;
        goto L84
    L80:
        r136 = null;
        goto L81
    L204:
        LiveGoodsShelvesCard r197 = null;
        if ((r210 instanceof LiveLocalLifeGoodsShelvesDslViewHolder) == false) goto L237;
        LiveLocalLifeGoodsShelvesDslViewHolder r198 = (LiveLocalLifeGoodsShelvesDslViewHolder) r210;
        if (r101 == null) goto L209;
        Map<String, Object> r199 = r101.f259588c;
    L210:
        if (r101 == null) goto L212;
        r197 = r101.f259586a;
    L212:
        FragmentActivity r200 = this.f259543i;
        int r201 = this.f259542h;
        LiveGoodsShelvesViewModel r202 = this.f259541g;
        if (r202 == null) goto L217;
        m r203 = r202.getCurrentTabFilterData();
        if (r203 == null) goto L217;
        int r204 = r203.f520906a;
    L218:
        int r205 = r204;
        i r206 = this.f259540f;
        LiveGoodsShelvesViewModel r207 = this.f259541g;
        if (r207 == null) goto L229;
        MutableLiveData<LiveGoodsShelvesDSLPagingResponse> r208 = r207.getLiveGoodsShelfPagingResponse();
        if (r208 == null) goto L229;
        LiveGoodsShelvesDSLPagingResponse r209 = r208.getValue();
        if (r209 == null) goto L229;
        LiveGoodsShelvesResponse r213 = r209.f259555e;
        if (r213 == null) goto L229;
        Boolean r214 = r213.isTalentShowcase();
        if (r214 == null) goto L229;
        r110 = r214.booleanValue();
    L229:
        r198.a4(r199, r197, r211, r200, r201, r205, r206, Boolean.valueOf(r110));
        return;
    L217:
        r204 = ShelfDefaultTabManager.b();
        goto L218
    L209:
        r199 = null;
        goto L210
    }
}
