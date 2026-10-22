package com.bytedance.kmp.livesdk.gift.platform.dialog.datalayer;

import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.l2;
import com.bytedance.android.livesdk.gift.model.w1;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKt_androidKt;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfoBase;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IVSGiftPanel;
import com.bytedance.platform.aio.settings.GiftPanelOptSettingsKt;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.JsonAdapter;
import defpackage.m0;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.subjects.BehaviorSubject;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kc6.y;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes19.dex */
public final class f implements com.bytedance.android.scope.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Long> f252280a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<Integer, Integer> f252281b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<Integer, Integer> f252282c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final BehaviorSubject<u> f252283d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.bytedance.revenue.platform.api.core.rx.b f252284e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, BehaviorSubject<kc6.t>> f252285f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public List<? extends l2> f252286g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final CompositeDisposable f252287h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile boolean f252288i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile boolean f252289j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final sc6.b f252290k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final yz0.g f252291l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final com.bytedance.android.live.recharge.i f252292m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final jy0.a f252293n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final i12.c f252294o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final com.bytedance.android.livesdk.gift.platform.business.effect.assets.j f252295p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final sc6.c f252296q;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
        ReadOnlyProperty r100 = m12.b.f511585l;
        KProperty<?>[] r101 = m12.b.f511574a;
        if (((Boolean) r100.getValue(null, r101[10])).booleanValue() == true) goto L5;
    L7:
        com.bytedance.revenue.platform.api.core.rx.f.a(this.f252290k.j6(true, 3).subscribe(new g(this)), this.f252287h);
        if (((Boolean) r100.getValue(null, r101[10])).booleanValue() == false) goto L10;
        com.bytedance.revenue.platform.api.core.rx.f.a(this.f252296q.al().subscribe(new h(this)), this.f252287h);
    L10:
        this.f252288i = true;
        return;
    L5:
        if (GiftPanelOptSettingsKt.a() == false) goto L7;
        com.bytedance.revenue.platform.api.core.rx.f.a(this.f252290k.j6(true, 3).skip(1).subscribe(new i(this)), this.f252287h);
        com.bytedance.revenue.platform.api.core.rx.f.a(this.f252296q.al().subscribe(new j(this)), this.f252287h);
        goto L10
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
        this.f252287h.clear();
    }

    public static final boolean a(f r100, h1 r101) {
        List<Long> r102 = r100.f252280a;
        ArrayList r103 = (ArrayList) r102;
        if (r103.contains(Long.valueOf(r101.getId())) == false) goto L24;
        Iterator<T> r104 = r101.getAssetIds().iterator();
        boolean r105 = true;
    L7:
        if (r104.hasNext() == false) goto L13;
        long r106 = ((Number) r104.next()).longValue();
        if (r101.getOptionalAssetIds().contains(Long.valueOf(r106)) == true) goto L7;
        if (r100.f252295p.g1(r106) == true) goto L7;
        r105 = false;
        goto L7
    L13:
        if (r105 == true) goto L23;
        return false;
    L23:
        return true;
    L24:
        return true;
    }

    public static final kc6.o c(final f r210, final List r211) {
        jy0.a r100 = r210.f252293n;
        StringBuilder r101 = new StringBuilder();
        r101.append(r211);
        r101.append(' ');
        r101.append(r211.size());
        r100.M3("yz-GiftListShowDataStore mapToDialogInfo", r101.toString(), null);
        ReadOnlyProperty r102 = m12.b.f511577d;
        KProperty<?>[] r103 = m12.b.f511574a;
        final List r110 = (List) r102.getValue(null, r103[2]);
        final List r111 = (List) m12.b.f511579f.getValue(null, r103[4]);
        final boolean r112 = GiftPanelOptSettingsKt.a();
        Class<?> r104 = ((JsonAdapter) kc6.o.class.getAnnotation(JsonAdapter.class)).value();
        ConcurrentHashMap<Class<?>, Constructor<? extends SerializableObjectJsonAdapterBase>> r105 = vh7.b.f554981a;
        Constructor r106 = r105.get(r104);
        int r107 = 0;
        if (r106 != null) goto L12;
        r106 = r104.getConstructor(new Class[0]);
        if (r106 == null) goto L11;
        Constructor<? extends SerializableObjectJsonAdapterBase> r108 = r105.putIfAbsent(r104, (Constructor<? extends SerializableObjectJsonAdapterBase>) r106);
        if (r108 == null) goto L12;
        r106 = r108;
        goto L12
    L11:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L12:
        Object r109 = ((SerializableObjectJsonAdapterBase) r106.newInstance(new Object[0])).createInstance();
        if (r109 == null) goto L59;
        kc6.o r113 = (kc6.o) r109;
        ArrayList r114 = new ArrayList();
        Iterator r115 = r211.iterator();
    L16:
        if (r115.hasNext() == false) goto L20;
        Object r116 = r115.next();
        if (((w1) r116).getDisplay() == false) goto L16;
        r114.add(r116);
        goto L16
    L20:
        ArrayList r117 = new ArrayList();
        Iterator r118 = r114.iterator();
    L22:
        if (r118.hasNext() == false) goto L29;
        Object r119 = r118.next();
        if (((w1) r119).getPageType() == 16) goto L26;
        boolean r120 = true;
    L27:
        if (r120 == false) goto L22;
        r117.add(r119);
        goto L22
    L26:
        r120 = false;
        goto L27
    L29:
        ArrayList r121 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r117, 10));
        Iterator r212 = r117.iterator();
    L31:
        if (r212.hasNext() == false) goto L56;
        Object r122 = r212.next();
        int r213 = r107 + 1;
        if (r107 >= 0) goto L35;
        CollectionsKt.throwIndexOverflow();
    L35:
        w1 r123 = (w1) r122;
        r210.f252281b.put(Integer.valueOf(r123.getPageType()), Integer.valueOf(r107));
        r210.f252282c.put(Integer.valueOf(r107), Integer.valueOf(r123.getPageType()));
        if (r123.getPageType() != 5) goto L46;
        yz0.g r124 = r210.f252291l;
        if (r124 == null) goto L44;
        IRoomBase r125 = r124.getRoom();
        if (r125 == null) goto L44;
        Long r126 = IRoomKt_androidKt.getPlatform(r125);
        if (r126 == null) goto L44;
        long r127 = r126.longValue();
    L45:
        kc6.r r128 = m0.b(r127, r123, r210.f252286g, r210.f252292m.getCoinCurrency(), r110, r111, r112, new GiftListShowDataStore$mapToDialogInfo$$inlined$also$lambda$1(r210, r211, r110, r111, r112));
        kc6.o r129 = r113;
        ArrayList r130 = r121;
    L55:
        r130.add(r128);
        r121 = r130;
        r113 = r129;
        r107 = r213;
    L44:
        r127 = 0;
        goto L45
    L46:
        ArrayList r131 = r121;
        kc6.o r132 = r113;
        yz0.g r133 = r210.f252291l;
        if (r133 == null) goto L53;
        IRoomBase r134 = r133.getRoom();
        if (r134 == null) goto L53;
        Long r135 = IRoomKt_androidKt.getPlatform(r134);
        if (r135 == null) goto L53;
        long r136 = r135.longValue();
    L54:
        r130 = r131;
        r129 = r132;
        r128 = m0.b(r136, r123, null, r210.f252292m.getCoinCurrency(), r110, r111, r112, new GiftListShowDataStore$mapToDialogInfo$$inlined$also$lambda$2(r210, r211, r110, r111, r112));
    L53:
        r136 = 0;
        goto L54
    L56:
        kc6.o r137 = r113;
        r137.Q5(r121);
        r137.j6(r210.f252294o.f487944d);
        return r137;
    L59:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.kmp.livesdk.gift.platform.aio.model.GiftDialogInfo");
    }

    public f(sc6.b r100, yz0.g r101, com.bytedance.android.live.recharge.i r102, jy0.a r103, i12.c r104, com.bytedance.android.livesdk.gift.platform.business.effect.assets.j r105, sc6.c r106) {
        Intrinsics.checkNotNullParameter(r100, "giftListRepository");
        Intrinsics.checkNotNullParameter(r101, "coreRoomDataService");
        Intrinsics.checkNotNullParameter(r102, "walletService");
        Intrinsics.checkNotNullParameter(r103, "logService");
        Intrinsics.checkNotNullParameter(r104, "giftLocationInfo");
        Intrinsics.checkNotNullParameter(r105, "assetService");
        Intrinsics.checkNotNullParameter(r106, "propListRoomRepository");
        this.f252290k = r100;
        this.f252291l = r101;
        this.f252292m = r102;
        this.f252293n = r103;
        this.f252294o = r104;
        this.f252295p = r105;
        this.f252296q = r106;
        py.k r107 = null;
        List r108 = (List) m12.b.f511580g.getValue(null, m12.b.f511574a[5]);
        ArrayList r109 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r108, 10));
        Iterator r110 = r108.iterator();
    L4:
        if (r110.hasNext() == false) goto L6;
        r109.add(Long.valueOf(((Number) r110.next()).intValue()));
        goto L4
    L6:
        this.f252280a = r109;
        this.f252281b = new LinkedHashMap();
        this.f252282c = new LinkedHashMap();
        int r111 = com.bytedance.revenue.platform.api.core.rx.c.f267509a;
        AtomicInteger r112 = u.f252334c;
        Class<?> r113 = ((JsonAdapter) kc6.o.class.getAnnotation(JsonAdapter.class)).value();
        ConcurrentHashMap<Class<?>, Constructor<? extends SerializableObjectJsonAdapterBase>> r114 = vh7.b.f554981a;
        Constructor r115 = r114.get(r113);
        if (r115 != null) goto L16;
        r115 = r113.getConstructor(new Class[0]);
        if (r115 == null) goto L15;
        Constructor<? extends SerializableObjectJsonAdapterBase> r116 = r114.putIfAbsent(r113, (Constructor<? extends SerializableObjectJsonAdapterBase>) r115);
        if (r116 == null) goto L16;
        r115 = r116;
        goto L16
    L15:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L16:
        Object r117 = ((SerializableObjectJsonAdapterBase) r115.newInstance(new Object[0])).createInstance();
        if (r117 == null) goto L37;
        this.f252283d = BehaviorSubject.createDefault(u.a.a((kc6.o) r117));
        IEpisodeExtraInfoBase r118 = this.f252291l.getRoom().getEpisodeExtra();
        if (r118 == null) goto L21;
        IVSGiftPanel r119 = r118.getVSGiftPanel();
    L23:
        if (r119 == null) goto L25;
        py.k r120 = r119.getSelectedImage();
    L26:
        if (r119 == null) goto L28;
        py.k r121 = r119.getBackgroundTop();
    L29:
        if (r119 == null) goto L31;
        py.k r122 = r119.getBackgroundBottom();
    L32:
        if (r119 == null) goto L34;
        r107 = r119.getTopTitle();
    L34:
        this.f252284e = new com.bytedance.revenue.platform.api.core.rx.b(BehaviorSubject.createDefault(new y(r120, r121, r122, r107)));
        this.f252285f = new LinkedHashMap();
        this.f252287h = new CompositeDisposable();
        return;
    L31:
        r122 = null;
        goto L32
    L28:
        r121 = null;
        goto L29
    L25:
        r120 = null;
        goto L26
    L21:
        r119 = null;
        goto L23
    L37:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.kmp.livesdk.gift.platform.aio.model.GiftDialogInfo");
    }
}
