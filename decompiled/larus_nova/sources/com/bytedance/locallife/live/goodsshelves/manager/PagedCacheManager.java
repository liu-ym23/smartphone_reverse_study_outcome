package com.bytedance.locallife.live.goodsshelves.manager;

import android.content.Context;
import android.os.SystemClock;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.strategy.api.IStrategyService;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomLifeGrouponInfo;
import com.bytedance.ee.bear.unbundle.BenefitStore;
import com.bytedance.locallife.host.growth.ILifeUserGrowthService;
import com.bytedance.locallife.live.experiment.i0;
import com.bytedance.locallife.live.goodsshelves.bean.LiveGoodsShelvesCard;
import com.bytedance.locallife.live.goodsshelves.bean.LiveGoodsShelvesDSLPagingResponse;
import com.bytedance.locallife.live.goodsshelves.bean.LiveGoodsShelvesResponse;
import com.bytedance.locallife.live.goodsshelves.bean.j0;
import com.bytedance.locallife.live.lynx.LiveLocalLifeLynxView;
import com.bytedance.locallife.live.model.LiveLocalLifeRoomInfo;
import com.bytedance.locallife.live.util.LiveLifeSaaSUtil;
import com.bytedance.locallife.live.util.LiveLocalLifeUtil;
import com.bytedance.locallife.live.viewmodel.LiveLocalLifeViewModel;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import nv6.h0;
import org.greenrobot.eventbus.Subscribe;

/* JADX INFO: loaded from: classes21.dex */
public final class PagedCacheManager implements l {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final /* synthetic */ int f259655v = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f259656a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LiveGoodsShelvesResponse f259657b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f259658c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LiveLocalLifeLynxView f259659d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f259660e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f259661f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f259662g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f259663h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f259664i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f259665j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f259666k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f259667l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f259668m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public volatile String f259669n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Map<String, Function1<List<Map<String, Object>>, Unit>> f259670o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final List<Disposable> f259671p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Map<Integer, j0> f259672q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Map<Integer, Long> f259673r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Lazy f259674s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public j0 f259675t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Lazy f259676u;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.locallife.live.goodsshelves.manager.l
    public final void onDestroy() {
        this.f259668m = false;
        this.f259658c = false;
        Iterator r100 = ((ArrayList) this.f259671p).iterator();
    L4:
        if (r100.hasNext() == false) goto L8;
        Disposable r101 = (Disposable) r100.next();
        if (r101.isDisposed() == true) goto L4;
        r101.dispose();
        goto L4
    L8:
        vn6.b.c(this);
        a(null);
        this.f259661f = false;
        this.f259667l = true;
        this.f259663h = 300000;
        this.f259662g = 1000;
        com.bytedance.locallife.live.util.n.a("shelf_cache_clean", null);
    }

    public final boolean k() {
        if (LiveLifeSaaSUtil.B() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f259661f == false) goto L7;
        return true;
    }

    @Override // com.bytedance.locallife.live.goodsshelves.manager.l
    public final boolean b() {
        return this.f259658c;
    }

    @Override // com.bytedance.locallife.live.goodsshelves.manager.l
    public final LiveGoodsShelvesResponse e() {
        return this.f259657b;
    }

    @Override // com.bytedance.locallife.live.goodsshelves.manager.l
    public final String i() {
        return this.f259666k;
    }

    public PagedCacheManager(String r100) {
        Intrinsics.checkNotNullParameter(r100, "uniqueKey");
        this.f259656a = r100;
        this.f259660e = LazyKt.lazy(PagedCacheManager$liveLifeEngineHelper$2.INSTANCE);
        this.f259662g = 1000;
        this.f259663h = 300000;
        this.f259667l = true;
        this.f259669n = "";
        this.f259670o = new LinkedHashMap();
        this.f259671p = new ArrayList();
        this.f259672q = new LinkedHashMap();
        this.f259673r = new LinkedHashMap();
        this.f259674s = LazyKt.lazy(new PagedCacheManager$enterRoomRequestParams$2(this));
        this.f259676u = LazyKt.lazy(new PagedCacheManager$shelfDataUpdateJsb$2(this));
    }

    @Override // com.bytedance.locallife.live.goodsshelves.manager.l
    public final void a(LiveGoodsShelvesResponse r100) {
        this.f259657b = r100;
        if (r100 == null) goto L5;
        long r101 = SystemClock.elapsedRealtime();
    L6:
        this.f259664i = r101;
        if (r100 != null) goto L10;
        this.f259666k = null;
        return;
    L10:
        return;
    L5:
        r101 = 0;
        goto L6
    }

    @Override // com.bytedance.locallife.live.goodsshelves.manager.l
    public final boolean c(int r110) {
        long r100 = SystemClock.elapsedRealtime();
        j0 r101 = (j0) ((LinkedHashMap) this.f259672q).get(Integer.valueOf(r110));
        Long r102 = (Long) ((LinkedHashMap) this.f259673r).get(Integer.valueOf(r110));
        if (r102 == null) goto L5;
        long r103 = r102.longValue();
    L6:
        List<LiveGoodsShelvesCard> r104 = null;
        if (r101 == null) goto L11;
        LiveGoodsShelvesDSLPagingResponse r105 = r101.f259606a;
        if (r105 == null) goto L11;
        LiveGoodsShelvesResponse r106 = r105.f259555e;
    L12:
        j0 r107 = this.f259675t;
        if (r107 == null) goto L17;
        LiveGoodsShelvesDSLPagingResponse r108 = r107.f259606a;
        if (r108 == null) goto L17;
        LiveGoodsShelvesResponse r109 = r108.f259555e;
    L18:
        if (r106 == null) goto L20;
        List<LiveGoodsShelvesCard> r111 = r106.getCard_list();
    L21:
        List<LiveGoodsShelvesCard> r112 = r111;
        if (r112 != null) goto L24;
    L27:
        boolean r113 = true;
    L28:
        if (r113 == false) goto L30;
    L31:
        if (r109 == null) goto L33;
        r104 = r109.getCard_list();
    L33:
        List<LiveGoodsShelvesCard> r114 = r104;
        if (r114 != null) goto L36;
    L39:
        boolean r115 = true;
    L40:
        if (r115 == true) goto L50;
        if (r109 != null) goto L43;
    L45:
        boolean r116 = false;
    L46:
        if (r116 == false) goto L50;
        if ((r100 - this.f259664i) > this.f259663h) goto L50;
        return true;
    L43:
        if (r109.getSelectedTabId() != r110) goto L45;
        r116 = true;
    L50:
        return false;
    L36:
        if (r114.isEmpty() == true) goto L39;
        r115 = false;
        goto L40
    L30:
        if ((r100 - r103) > this.f259663h) goto L31;
        return true;
    L24:
        if (r112.isEmpty() == true) goto L27;
        r113 = false;
        goto L28
    L20:
        r111 = null;
    L17:
        r109 = null;
    L11:
        r106 = null;
        goto L12
    L5:
        r103 = 0;
        goto L6
    }

    @Override // com.bytedance.locallife.live.goodsshelves.manager.l
    public final void f(nv6.c r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        if (Intrinsics.areEqual(r100.f520898a, BenefitStore.FROM_SERVER) == false) goto L6;
        this.f259661f = r100.b();
    L6:
        if (Intrinsics.areEqual(r100.f520898a, "virgo") == false) goto L36;
        this.f259663h = r100.a();
        this.f259662g = r100.c();
        return;
    L36:
        IStrategyService r101 = (IStrategyService) jc1.k.f(IStrategyService.class);     // Catch: Exception -> L20
        if (r101 == null) goto L15;
        LiveData r102 = IStrategyService.a.a(r101, "live_life_shelf_preload_strategy", 0, false, 12);     // Catch: Exception -> L20
        if (r102 == null) goto L15;
        Integer r103 = (Integer) r102.getValue();     // Catch: Exception -> L20
    L16:
        if (r103 == null) goto L21;
        int r104 = r103.intValue();     // Catch: Exception -> L20
    L23:
        if (r104 != (-1)) goto L26;
        this.f259661f = false;
    L26:
        if (r100.a() <= 0) goto L28;
        this.f259663h = r100.a();
    L28:
        if (r104 == 0) goto L30;
        if (r104 == (-1)) goto L34;
        this.f259662g = r104;
    L34:
        LiveLifeSaaSUtil.o().c();
        return;
    L30:
        if (r100.c() <= 1000) goto L34;
        this.f259662g = r100.c();
    L15:
        r103 = null;
    L21:
        r104 = 0;
        goto L23
    }

    @Override // com.bytedance.locallife.live.goodsshelves.manager.l
    public final String g(int r110) {
        if (c(r110) == false) goto L5;
        return "1";
    L5:
        long r100 = SystemClock.elapsedRealtime();
        j0 r101 = (j0) ((LinkedHashMap) this.f259672q).get(Integer.valueOf(r110));
        Long r102 = (Long) ((LinkedHashMap) this.f259673r).get(Integer.valueOf(r110));
        if (r102 == null) goto L8;
        long r103 = r102.longValue();
    L9:
        List<LiveGoodsShelvesCard> r104 = null;
        if (r101 == null) goto L14;
        LiveGoodsShelvesDSLPagingResponse r105 = r101.f259606a;
        if (r105 == null) goto L14;
        LiveGoodsShelvesResponse r106 = r105.f259555e;
    L15:
        j0 r107 = this.f259675t;
        if (r107 == null) goto L20;
        LiveGoodsShelvesDSLPagingResponse r108 = r107.f259606a;
        if (r108 == null) goto L20;
        LiveGoodsShelvesResponse r109 = r108.f259555e;
    L21:
        if (r106 == null) goto L23;
        List<LiveGoodsShelvesCard> r111 = r106.getCard_list();
    L24:
        List<LiveGoodsShelvesCard> r112 = r111;
        boolean r113 = false;
        if (r112 != null) goto L27;
    L30:
        boolean r114 = true;
    L31:
        if (r114 == false) goto L33;
    L34:
        if (r109 == null) goto L36;
        r104 = r109.getCard_list();
    L36:
        List<LiveGoodsShelvesCard> r115 = r104;
        if (r115 != null) goto L39;
    L42:
        boolean r116 = true;
    L43:
        if (r116 == true) goto L53;
        if (r109 != null) goto L46;
    L48:
        boolean r117 = false;
    L49:
        if (r117 == false) goto L53;
        if ((r100 - this.f259664i) <= this.f259663h) goto L53;
    L52:
        r113 = true;
        goto L53
    L46:
        if (r109.getSelectedTabId() != r110) goto L48;
        r117 = true;
    L53:
        if (r113 == false) goto L55;
        return "3";
    L55:
        return "2";
    L39:
        if (r115.isEmpty() == true) goto L42;
        r116 = false;
        goto L43
    L33:
        if ((r100 - r103) > this.f259663h) goto L52;
    L27:
        if (r112.isEmpty() == true) goto L30;
        r114 = false;
        goto L31
    L23:
        r111 = null;
    L20:
        r109 = null;
    L14:
        r106 = null;
        goto L15
    L8:
        r103 = 0;
        goto L9
    }

    @Override // com.bytedance.locallife.live.goodsshelves.manager.l
    public final void h(String r100) {
        this.f259666k = r100;
    }

    public final boolean m(String r100) {
        LiveLocalLifeViewModel.Companion.getClass();
        LiveLocalLifeViewModel r101 = LiveLocalLifeViewModel.Companion.a(r100);
        if (r101 != null) goto L5;
    L7:
        return false;
    L5:
        if (r101.getShelvesIsOpening() != true) goto L7;
        return true;
    }

    @Subscribe
    public final void onReceiveWidgetRemoveEvent(fv6.a r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        LiveLocalLifeViewModel.Companion r101 = LiveLocalLifeViewModel.Companion;
        String r102 = r100.f478960a;
        r101.getClass();
        LiveLocalLifeViewModel r103 = LiveLocalLifeViewModel.Companion.a(r102);
        if (r103 == null) goto L7;
        boolean r104 = true;
        if (r103.isPreview() != true) goto L7;
    L8:
        if (r104 == false) goto L10;
        return;
    L10:
        LiveLifeSaaSUtil.o().b();
        return;
    L7:
        r104 = false;
        goto L8
    }

    @Override // com.bytedance.locallife.live.goodsshelves.manager.l
    public final void d(Map<String, ? extends Object> r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "uniqueKey");
        j0 r102 = this.f259675t;
        if (r102 == null) goto L9;
        LiveGoodsShelvesDSLPagingResponse r103 = r102.f259606a;
        if (r103 == null) goto L9;
        LiveGoodsShelvesResponse r104 = r103.f259555e;
        if (r104 == null) goto L9;
        int r105 = r104.getSelectedTabId();
    L10:
        com.bytedance.locallife.live.util.m r106 = com.bytedance.locallife.live.util.n.f260724a;
        LinkedHashMap r107 = new LinkedHashMap();
        r107.put("enable", String.valueOf(k()));
        r107.put("tab_id", String.valueOf(r105));
        r107.put("status", String.valueOf(c(r105)));
        Unit r108 = Unit.INSTANCE;
        com.bytedance.locallife.live.util.n.a("shelf_cache_preload", r107);
        if (k() == true) goto L13;
    L59:
        LiveLocalLifeViewModel.Companion.getClass();
        LiveLocalLifeViewModel r109 = LiveLocalLifeViewModel.Companion.a(r101);
        if (r109 == null) goto L66;
        qv6.g r110 = r109.getShelfPreloadTracker();
        if (r110 == null) goto L67;
        qv6.g.a(r110, LiveLifeSaaSUtil.B(), this.f259661f, c(r105));
        return;
    L67:
        return;
    L66:
        return;
    L13:
        if (c(r105) == true) goto L59;
        if (m(r101) == true) goto L59;
        LiveLocalLifeViewModel.Companion.getClass();
        LiveLocalLifeViewModel r111 = LiveLocalLifeViewModel.Companion.a(r101);
        if (r111 == null) goto L23;
        qv6.g r112 = r111.getShelfPreloadTracker();
        if (r112 == null) goto L23;
        if (r112.f534911c != null) goto L23;
        r112.f534911c = Boolean.TRUE;
        r112.f534912d = SystemClock.elapsedRealtime();
    L23:
        int r113 = 0;
        if (this.f259667l == false) goto L37;
        this.f259667l = false;
        if (i0.a() == false) goto L36;
        LiveLocalLifeViewModel r114 = LiveLocalLifeViewModel.Companion.a(r101);
        if (r114 == null) goto L36;
        kv6.e r115 = r114.getLynxViewPreloadManager();
        if (r115 == null) goto L36;
        Context r116 = com.bytedance.locallife.live.util.o.a(r101);
        if (r116 != null) goto L35;
        r116 = LiveLifeSaaSUtil.p();
    L35:
        r115.e(r116);
    L36:
        l(this, "preload", r101);
    L38:
        if (r100 == null) goto L58;
        Object r117 = r100.get("rule_key");
        if ((r117 instanceof String) == false) goto L42;
        String r118 = (String) r117;
    L43:
        if (r118 != null) goto L46;
        r118 = "";
    L46:
        if (r118.length() <= 0) goto L48;
        boolean r119 = true;
    L49:
        if (r119 == false) goto L58;
        Object r120 = r100.get("random_time");
        if (r120 == null) goto L53;
        int r121 = sv6.a.a(r120);
    L54:
        Object r122 = r100.get("delay_time");
        if (r122 == null) goto L57;
        r113 = sv6.a.a(r122);
    L57:
        int r123 = com.bytedance.locallife.biz.mob.a.f256703c;
        LinkedHashMap r124 = new LinkedHashMap();
        r124.put("random_time", String.valueOf(r113 + r121));
        r124.put("rule_key", r118);
        com.bytedance.locallife.biz.mob.a.C3646a.c("live_life_shelf_preload_strategy", r124);
        goto L58
    L53:
        r121 = 1000;
        goto L54
    L48:
        r119 = false;
        goto L49
    L42:
        r118 = null;
    L58:
        vn6.b.b(this);
        return;
    L37:
        l(this, "update", r101);
    L9:
        r105 = ShelfDefaultTabManager.b();
        goto L10
    }

    public static void l(PagedCacheManager r110, String r111, String r112) {
        if (r110.f259668m == true) goto L109;
        Room r100 = LiveLocalLifeUtil.d(r112);
        boolean r101 = LiveLifeSaaSUtil.v().a();
        LinkedHashMap r113 = new LinkedHashMap();
        Map r102 = (Map) r110.f259674s.getValue();
        if (r102 == null) goto L13;
        Iterator r103 = r102.entrySet().iterator();
    L9:
        if (r103.hasNext() == false) goto L13;
        Map.Entry r104 = (Map.Entry) r103.next();
        String r105 = (String) r104.getKey();
        Object r106 = r104.getValue();
        if (r106 == null) goto L9;
        r113.put(r105, r106.toString());
    L13:
        LiveLocalLifeViewModel.Companion.getClass();
        LiveLocalLifeViewModel r107 = LiveLocalLifeViewModel.Companion.a(r112);
        String r108 = null;
        if (r107 == null) goto L20;
        MutableLiveData<h0> r109 = r107.getPackConfig();
        if (r109 == null) goto L20;
        h0 r114 = r109.getValue();
        if (r114 == null) goto L20;
        Map<String, String> r115 = r114.a();
    L21:
        if (r115 == null) goto L28;
        Iterator<Map.Entry<String, String>> r116 = r115.entrySet().iterator();
    L24:
        if (r116.hasNext() == false) goto L28;
        Map.Entry<String, String> r117 = r116.next();
        String r118 = r117.getKey();
        String r119 = r117.getValue();
        if (r119 == null) goto L24;
        r113.put(r118, r119);
    L28:
        r113.put("source_type", "0");
        LiveLocalLifeViewModel.Companion.getClass();
        LiveLocalLifeViewModel r120 = LiveLocalLifeViewModel.Companion.a(r112);
        if (r120 == null) goto L39;
        MutableLiveData<nv6.r> r121 = r120.getGroupPurchaseComponentInfo();
        if (r121 == null) goto L39;
        nv6.r r122 = r121.getValue();
        if (r122 == null) goto L39;
        nv6.t r123 = r122.d();
        if (r123 == null) goto L39;
        Long r124 = r123.a();
        if (r124 == null) goto L39;
        String r125 = r124.toString();
    L40:
        if (r100 == null) goto L46;
        RoomLifeGrouponInfo r126 = r100.lifeGrouponInfo;
        if (r126 == null) goto L46;
        Long r127 = r126.getAggCardId();
        if (r127 == null) goto L46;
        r108 = r127.toString();
    L46:
        boolean r128 = false;
        if (r125 != null) goto L49;
    L52:
        boolean r129 = true;
    L53:
        if (r129 == false) goto L55;
        String r130 = r108;
    L56:
        if (r130 != null) goto L58;
    L61:
        boolean r131 = true;
    L62:
        if (r131 == false) goto L64;
    L67:
        r128 = true;
    L68:
        if (r128 == true) goto L70;
    L72:
        long r132 = Random.Default.nextLong(r110.f259662g);
        LiveLocalLifeViewModel r133 = LiveLocalLifeViewModel.Companion.a(r112);
        if (r133 == null) goto L79;
        qv6.g r134 = r133.getShelfPreloadTracker();
        if (r134 == null) goto L79;
        if (r134.f534913e != null) goto L79;
        r134.f534913e = Long.valueOf(r132);
    L79:
        r113.put("from", "2");
        r113.put("scene", r111);
        LiveLocalLifeRoomInfo r135 = LiveLocalLifeUtil.e(r112);
        r113.put("enter_from_merge", r135.getEnterFromMerge());
        r113.put("enter_method", r135.getEnterMethod());
        r113.put("action_type", r135.getActionType());
        r113.put(LiveLocalLifeRoomInfo.SALE_CHANNEL, r135.getSaleChannel());
        LiveLocalLifeViewModel r136 = LiveLocalLifeViewModel.Companion.a(r112);
        if (r136 == null) goto L92;
        Map<Integer, Map<String, String>> r137 = r136.getRoomShelfRequestParams();
        if (r137 == null) goto L92;
        Map<String, String> r138 = r137.get(1);
        if (r138 == null) goto L92;
        LinkedHashMap r139 = new LinkedHashMap();
        Iterator<Map.Entry<String, String>> r140 = r138.entrySet().iterator();
    L87:
        if (r140.hasNext() == false) goto L91;
        Map.Entry<String, String> r141 = r140.next();
        if (com.bytedance.locallife.live.util.s.d(r141.getValue()) == false) goto L87;
        r139.put(r141.getKey(), r141.getValue());
        goto L87
    L91:
        r113.putAll(r139);
    L92:
        Map<String, String> r142 = LiveLifeSaaSUtil.n().a(ILifeUserGrowthService.SaaSTraceBizTag.LIVE_SHELF);
        r110.f259665j = SystemClock.elapsedRealtime();
        int r143 = ShelfDefaultTabManager.b();
        ((ArrayList) r110.f259671p).add(Single.timer(r132, TimeUnit.MILLISECONDS).flatMap(new o(r110, r112, r143, r130, r101 ? 1 : 0, r100, r113, r142)).map(new p(r110)).compose(q.f259741a).retry(v.f259753a.b().getTimes(), new r(r112, r110, r113)).subscribe(new s(r110, r112, r111, r143, r113), new t(r110, r113)));
        return;
    L70:
        if (com.bytedance.locallife.live.experiment.s.a() == true) goto L72;
        return;
    L64:
        if (Intrinsics.areEqual(r130, "null") == true) goto L67;
        if (Intrinsics.areEqual(r130, "0") == false) goto L68;
    L58:
        if (r130.length() == 0) goto L61;
        r131 = false;
        goto L62
    L55:
        r130 = r125;
        goto L56
    L49:
        if (r125.length() == 0) goto L52;
        r129 = false;
    L39:
        r125 = null;
    L20:
        r115 = null;
        goto L21
    }

    public static final void j(PagedCacheManager r110, int r111, String r210, i r211, String r212) {
        if (r110.f259665j <= 0) goto L6;
        long r100 = SystemClock.elapsedRealtime() - r110.f259665j;
        qv6.c.f(r110.f259656a, r100, "fail", r111, r210, false, r211.f259723a, "live_shelf_preload", r212, null, null, null, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("random_time", String.valueOf(r110.f259662g))}), 3584);
        r110.f259665j = 0;
        return;
    }
}
