package com.bytedance.locallife.live.goodsshelves.manager;

import android.os.SystemClock;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.strategy.api.IStrategyService;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomLifeGrouponInfo;
import com.bytedance.ee.bear.unbundle.BenefitStore;
import com.bytedance.locallife.host.growth.ILifeUserGrowthService;
import com.bytedance.locallife.live.goodsshelves.bean.LiveGoodsShelvesCard;
import com.bytedance.locallife.live.goodsshelves.bean.LiveGoodsShelvesResponse;
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
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import org.greenrobot.eventbus.Subscribe;

/* JADX INFO: loaded from: classes21.dex */
public final class a implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f259692a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LiveGoodsShelvesResponse f259693b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f259694c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f259695d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f259696e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f259697f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f259698g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f259699h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f259700i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f259701j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final List<Disposable> f259702k;

    /* JADX INFO: renamed from: com.bytedance.locallife.live.goodsshelves.manager.a$a, reason: collision with other inner class name */
    public static final class C3671a {
    }

    static {
    }

    @Override // com.bytedance.locallife.live.goodsshelves.manager.l
    public final boolean b() {
        return false;
    }

    @Override // com.bytedance.locallife.live.goodsshelves.manager.l
    public final void onDestroy() {
        Iterator r100 = ((ArrayList) this.f259702k).iterator();
    L4:
        if (r100.hasNext() == false) goto L8;
        Disposable r101 = (Disposable) r100.next();
        if (r101.isDisposed() == true) goto L4;
        r101.dispose();
        goto L4
    L8:
        vn6.b.c(this);
        a(null);
        this.f259694c = false;
        this.f259700i = true;
        this.f259696e = 300000;
        this.f259695d = 1000;
        com.bytedance.locallife.live.util.n.a("shelf_cache_clean", null);
    }

    public final boolean k() {
        if (LiveLifeSaaSUtil.B() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f259694c == false) goto L7;
        return true;
    }

    @Override // com.bytedance.locallife.live.goodsshelves.manager.l
    public final LiveGoodsShelvesResponse e() {
        return this.f259693b;
    }

    @Override // com.bytedance.locallife.live.goodsshelves.manager.l
    public final String i() {
        return this.f259699h;
    }

    public a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "uniqueKey");
        this.f259692a = r100;
        this.f259695d = 1000;
        this.f259696e = 300000;
        this.f259700i = true;
        this.f259702k = new ArrayList();
    }

    @Override // com.bytedance.locallife.live.goodsshelves.manager.l
    public final void a(LiveGoodsShelvesResponse r100) {
        this.f259693b = r100;
        if (r100 == null) goto L5;
        long r101 = SystemClock.elapsedRealtime();
    L6:
        this.f259697f = r101;
        if (r100 != null) goto L10;
        this.f259699h = null;
        return;
    L10:
        return;
    L5:
        r101 = 0;
        goto L6
    }

    @Override // com.bytedance.locallife.live.goodsshelves.manager.l
    public final boolean c(int r100) {
        long r101 = SystemClock.elapsedRealtime();
        LiveGoodsShelvesResponse r102 = this.f259693b;
        if (r102 == null) goto L15;
        List<LiveGoodsShelvesCard> r103 = r102.getCard_list();
        if (r103 != null) goto L7;
    L9:
        boolean r104 = false;
    L10:
        if (r104 == true) goto L12;
        return false;
    L12:
        if ((r101 - this.f259697f) > this.f259696e) goto L17;
        return true;
    L17:
        return false;
    L7:
        if (r103.isEmpty() == true) goto L9;
        r104 = true;
        goto L10
    L15:
        return false;
    }

    @Override // com.bytedance.locallife.live.goodsshelves.manager.l
    public final void f(nv6.c r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        if (Intrinsics.areEqual(r100.f520898a, BenefitStore.FROM_SERVER) == false) goto L6;
        this.f259694c = r100.b();
    L6:
        if (Intrinsics.areEqual(r100.f520898a, "virgo") == false) goto L36;
        this.f259696e = r100.a();
        this.f259695d = r100.c();
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
        this.f259694c = false;
    L26:
        if (r100.a() <= 0) goto L28;
        this.f259696e = r100.a();
    L28:
        if (r104 == 0) goto L30;
        if (r104 == (-1)) goto L34;
        this.f259695d = r104;
    L34:
        LiveLifeSaaSUtil.o().c();
        return;
    L30:
        if (r100.c() <= 1000) goto L34;
        this.f259695d = r100.c();
    L15:
        r103 = null;
    L21:
        r104 = 0;
        goto L23
    }

    @Override // com.bytedance.locallife.live.goodsshelves.manager.l
    public final String g(int r100) {
        boolean r101 = true;
        if (c(1) == false) goto L5;
        return "1";
    L5:
        long r102 = SystemClock.elapsedRealtime();
        LiveGoodsShelvesResponse r103 = this.f259693b;
        if (r103 == null) goto L17;
        List<LiveGoodsShelvesCard> r104 = r103.getCard_list();
        if (r104 != null) goto L10;
    L12:
        boolean r105 = false;
    L13:
        if (r105 == false) goto L17;
        if ((r102 - this.f259697f) <= this.f259696e) goto L17;
    L18:
        if (r101 == false) goto L20;
        return "3";
    L20:
        return "2";
    L10:
        if (r104.isEmpty() == true) goto L12;
        r105 = true;
    L17:
        r101 = false;
        goto L18
    }

    @Override // com.bytedance.locallife.live.goodsshelves.manager.l
    public final void h(String r100) {
        this.f259699h = r100;
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
        com.bytedance.locallife.live.util.m r102 = com.bytedance.locallife.live.util.n.f260724a;
        LinkedHashMap r103 = new LinkedHashMap();
        r103.put("enable", String.valueOf(k()));
        boolean r104 = true;
        r103.put("status", String.valueOf(c(1)));
        Unit r105 = Unit.INSTANCE;
        com.bytedance.locallife.live.util.n.a("shelf_cache_preload", r103);
        if (k() == true) goto L5;
    L40:
        LiveLocalLifeViewModel.Companion.getClass();
        LiveLocalLifeViewModel r106 = LiveLocalLifeViewModel.Companion.a(r101);
        if (r106 == null) goto L47;
        qv6.g r107 = r106.getShelfPreloadTracker();
        if (r107 == null) goto L48;
        qv6.g.a(r107, LiveLifeSaaSUtil.B(), this.f259694c, c(1));
        return;
    L48:
        return;
    L47:
        return;
    L5:
        if (c(1) == true) goto L40;
        if (m(r101) == true) goto L40;
        LiveLocalLifeViewModel.Companion.getClass();
        LiveLocalLifeViewModel r108 = LiveLocalLifeViewModel.Companion.a(r101);
        if (r108 == null) goto L15;
        qv6.g r109 = r108.getShelfPreloadTracker();
        if (r109 == null) goto L15;
        if (r109.f534911c != null) goto L15;
        r109.f534911c = Boolean.TRUE;
        r109.f534912d = SystemClock.elapsedRealtime();
    L15:
        int r110 = 0;
        if (this.f259700i == false) goto L18;
        this.f259700i = false;
        l(this, "preload", r101);
    L19:
        if (r100 == null) goto L39;
        Object r111 = r100.get("rule_key");
        if ((r111 instanceof String) == false) goto L23;
        String r112 = (String) r111;
    L24:
        if (r112 != null) goto L27;
        r112 = "";
    L27:
        if (r112.length() > 0) goto L30;
        r104 = false;
    L30:
        if (r104 == false) goto L39;
        Object r113 = r100.get("random_time");
        if (r113 == null) goto L34;
        int r114 = sv6.a.a(r113);
    L35:
        Object r115 = r100.get("delay_time");
        if (r115 == null) goto L38;
        r110 = sv6.a.a(r115);
    L38:
        int r116 = com.bytedance.locallife.biz.mob.a.f256703c;
        LinkedHashMap r117 = new LinkedHashMap();
        r117.put("random_time", String.valueOf(r110 + r114));
        r117.put("rule_key", r112);
        com.bytedance.locallife.biz.mob.a.C3646a.c("live_life_shelf_preload_strategy", r117);
        goto L39
    L34:
        r114 = 1000;
        goto L35
    L23:
        r112 = null;
    L39:
        vn6.b.b(this);
        return;
    L18:
        l(this, "update", r101);
        goto L19
    }

    public static void l(a r110, String r111, String r112) {
        if (r110.f259701j == true) goto L81;
        Room r100 = LiveLocalLifeUtil.d(r112);
        boolean r101 = LiveLifeSaaSUtil.v().a();
        LinkedHashMap r102 = new LinkedHashMap();
        r102.put("source_type", "0");
        LiveLocalLifeViewModel.Companion.getClass();
        LiveLocalLifeViewModel r103 = LiveLocalLifeViewModel.Companion.a(r112);
        String r104 = null;
        if (r103 == null) goto L16;
        MutableLiveData<nv6.r> r105 = r103.getGroupPurchaseComponentInfo();
        if (r105 == null) goto L16;
        nv6.r r106 = r105.getValue();
        if (r106 == null) goto L16;
        nv6.t r107 = r106.d();
        if (r107 == null) goto L16;
        Long r108 = r107.a();
        if (r108 == null) goto L16;
        String r109 = r108.toString();
    L17:
        if (r100 == null) goto L23;
        RoomLifeGrouponInfo r113 = r100.lifeGrouponInfo;
        if (r113 == null) goto L23;
        Long r114 = r113.getAggCardId();
        if (r114 == null) goto L23;
        String r115 = r114.toString();
    L24:
        boolean r116 = false;
        if (r109 != null) goto L27;
    L30:
        boolean r117 = true;
    L31:
        if (r117 == false) goto L33;
        r109 = r115;
    L33:
        if (r109 != null) goto L35;
    L38:
        boolean r118 = true;
    L39:
        if (r118 == false) goto L41;
    L44:
        r116 = true;
    L45:
        if (r116 == true) goto L47;
    L49:
        long r119 = Random.Default.nextLong(r110.f259695d);
        if (r103 == null) goto L56;
        qv6.g r120 = r103.getShelfPreloadTracker();
        if (r120 == null) goto L56;
        if (r120.f534913e != null) goto L56;
        r120.f534913e = Long.valueOf(r119);
    L56:
        r102.put("from", "2");
        r102.put("scene", r111);
        LiveLocalLifeRoomInfo r121 = LiveLocalLifeUtil.e(r112);
        r102.put("enter_from_merge", r121.getEnterFromMerge());
        r102.put("enter_method", r121.getEnterMethod());
        r102.put("action_type", r121.getActionType());
        r102.put(LiveLocalLifeRoomInfo.SALE_CHANNEL, r121.getSaleChannel());
        if (r103 == null) goto L69;
        Map<Integer, Map<String, String>> r122 = r103.getRoomShelfRequestParams();
        if (r122 == null) goto L69;
        Map<String, String> r123 = r122.get(1);
        if (r123 == null) goto L69;
        LinkedHashMap r124 = new LinkedHashMap();
        Iterator<Map.Entry<String, String>> r125 = r123.entrySet().iterator();
    L64:
        if (r125.hasNext() == false) goto L68;
        Map.Entry<String, String> r126 = r125.next();
        if (com.bytedance.locallife.live.util.s.d(r126.getValue()) == false) goto L64;
        r124.put(r126.getKey(), r126.getValue());
        goto L64
    L68:
        r102.putAll(r124);
    L69:
        if (r103 == null) goto L72;
        r104 = r103.getTrafficLevel("2");
    L72:
        if (com.bytedance.locallife.live.util.s.d(r104) == false) goto L74;
        r102.put("traffic_level", r104);
    L74:
        Map<String, String> r127 = LiveLifeSaaSUtil.n().a(ILifeUserGrowthService.SaaSTraceBizTag.LIVE_SHELF);
        r110.f259698g = SystemClock.elapsedRealtime();
        ((ArrayList) r110.f259702k).add(Single.timer(r119, TimeUnit.MILLISECONDS).flatMap(new b(r110, r112, r109, r101 ? 1 : 0, r100, r102, r127)).map(new c(r110)).compose(d.f259711a).retry(v.f259753a.b().getTimes(), new e(r112, r110, r102)).subscribe(new f(r110, r112, r102), new g(r110, r102)));
        return;
    L47:
        if (com.bytedance.locallife.live.experiment.s.a() == true) goto L49;
        return;
    L41:
        if (Intrinsics.areEqual(r109, "null") == true) goto L44;
        if (Intrinsics.areEqual(r109, "0") == false) goto L45;
    L35:
        if (r109.length() == 0) goto L38;
        r118 = false;
        goto L39
    L27:
        if (r109.length() == 0) goto L30;
        r117 = false;
    L23:
        r115 = null;
    L16:
        r109 = null;
        goto L17
    }

    public static final void j(a r110, int r111, String r210, i r211, String r212) {
        if (r110.f259698g <= 0) goto L6;
        long r100 = SystemClock.elapsedRealtime() - r110.f259698g;
        qv6.c.f(r110.f259692a, r100, "fail", r111, r210, false, r211.f259723a, "live_shelf_preload", r212, null, null, null, null, 7680);
        r110.f259698g = 0;
        return;
    }
}
