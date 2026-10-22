package ni4;

import com.bytedance.creativex.mediaimport.repository.api.IFolderItem;
import com.bytedance.creativex.mediaimport.repository.internal.main.CategoryItemInternal;
import com.bytedance.creativex.mediaimport.repository.internal.main.FolderItemInternal;
import com.bytedance.creativex.mediaimport.repository.internal.main.GroupItemInternal;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import io.reactivex.Observable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class n extends a<IFolderItem, Map<ki4.a0, ? extends Class<? extends ki4.m>>> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a0<ki4.r> f519302e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ki4.n f519303f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ki4.d f519304g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ki4.i f519305h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Map<ki4.a, FolderItemInternal> f519306i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Map<ki4.a0, ki4.c> f519307j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ReentrantLock f519308k;

    @Override // thc.c
    public final boolean hasNext() {
        return this.f519302e.hasNext();
    }

    public final void i() {
        this.f519308k.lock();
        Iterator<T> r100 = this.f519306i.values().iterator();
    L4:
        if (r100.hasNext() == false) goto L18;
        FolderItemInternal r101 = (FolderItemInternal) r100.next();
        Iterator r102 = ((ConcurrentHashMap) this.f519307j).entrySet().iterator();
    L7:
        if (r102.hasNext() == false) goto L4;
        Map.Entry r103 = (Map.Entry) r102.next();
        ki4.a0 r104 = (ki4.a0) r103.getKey();
        ki4.c r105 = (ki4.c) r103.getValue();
        CategoryItemInternal r106 = (CategoryItemInternal) ((LinkedHashMap) r101.f203635c).get(r104);
        if (r106 == null) goto L7;
        List<? extends ki4.r> r107 = CollectionsKt.toList(r106.f203629d);
        Intrinsics.checkNotNullParameter(r107, "<set-?>");
        r106.f203630e = r107;
        Map<Class<? extends ki4.m>, Map<ki4.b, GroupItemInternal>> r108 = r106.f203628c;
        LinkedHashMap r109 = (LinkedHashMap) r108;
        Map r110 = (Map) r109.get(r105.f503617a);
        if (r110 == null) goto L7;
        Collection r111 = r110.values();
        if (r111 == null) goto L7;
        Iterator r112 = r111.iterator();
    L16:
        if (r112.hasNext() == false) goto L7;
        GroupItemInternal r113 = (GroupItemInternal) r112.next();
        List<? extends ki4.r> r114 = CollectionsKt.toList(r113.f203638c);
        Intrinsics.checkNotNullParameter(r114, "<set-?>");
        r113.f203639d = r114;
        goto L16
    L18:
        this.f519308k.unlock();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ki4.j
    public final void b(Object r210) {
        Map r100 = (Map) r210;
        Intrinsics.checkNotNullParameter(r100, "regroupParam");
        this.f519308k.lock();
        LinkedHashMap r101 = new LinkedHashMap();
        List<ki4.z> r102 = this.f519304g.c();
        ArrayList r110 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator<T> r103 = r102.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        r110.add(((ki4.z) r103.next()).a());
        goto L4
    L6:
        Iterator r111 = r100.entrySet().iterator();
    L8:
        if (r111.hasNext() == false) goto L34;
        Map.Entry r104 = (Map.Entry) r111.next();
        ki4.a0 r112 = (ki4.a0) r104.getKey();
        Class<? extends ki4.m> r113 = (Class) r104.getValue();
        if (r110.contains(r112) == false) goto L33;
        ki4.c r105 = (ki4.c) ((ConcurrentHashMap) this.f519307j).get(r112);
        if (r105 == null) goto L33;
        Intrinsics.checkNotNullParameter(r113, "<set-?>");
        r105.f503617a = r113;
        if (r105.f503618b.contains(r113) == true) goto L33;
        r105.f503618b.add(r113);
        Iterator<T> r114 = this.f519306i.values().iterator();
    L17:
        if (r114.hasNext() == false) goto L33;
        FolderItemInternal r106 = (FolderItemInternal) r114.next();
        ki4.a r115 = new ki4.a(r106.f203633a, r106.f203634b);
        CategoryItemInternal r107 = (CategoryItemInternal) ((LinkedHashMap) r106.f203635c).get(r112);
        if (r107 == null) goto L31;
        ki4.n r108 = this.f519303f;
        Function4 r109 = new k();
        Intrinsics.checkNotNullParameter(r107, "<this>");
        Intrinsics.checkNotNullParameter(r112, "categoryType");
        Intrinsics.checkNotNullParameter(r113, "regroupStrategyClazz");
        Intrinsics.checkNotNullParameter(r108, "groupStrategyProvider");
        Intrinsics.checkNotNullParameter(r101, "changedGroups");
        Intrinsics.checkNotNullParameter(r109, "mapKeyGenerator");
        List r116 = CollectionsKt.toList(r107.f203629d);
        ki4.m r117 = r108.a(r113);
        Comparator<ki4.b> r118 = r117.getComparator();
        if (r118 == null) goto L25;
        Map<ki4.b, GroupItemInternal> r119 = MapsKt.sortedMapOf(r118, new Pair[0]);
        if (r119 == null) goto L25;
    L26:
        final Map<ki4.b, GroupItemInternal> r120 = r119;
        Iterator r121 = r116.iterator();
    L28:
        if (r121.hasNext() == false) goto L30;
        ArrayList r211 = r110;
        Map<ki4.b, GroupItemInternal> r122 = r120;
        Function4 r123 = r109;
        Iterator r124 = r111;
        m0.a((ki4.r) r121.next(), r117, new g0(r120), r113, r115, r112, r101, r123);
        r120 = r122;
        r107 = r107;
        r109 = r123;
        r111 = r124;
        r115 = r115;
        r110 = r211;
        goto L28
    L30:
        ArrayList r212 = r110;
        Iterator r125 = r111;
        Map<Class<? extends ki4.m>, Map<ki4.b, GroupItemInternal>> r126 = r107.f203628c;
        r126.put(r113, r120);
    L32:
        r110 = r212;
        r111 = r125;
    L25:
        r119 = new LinkedHashMap();
        goto L26
    L31:
        r212 = r110;
        r125 = r111;
    L33:
        r110 = r110;
        r111 = r111;
        goto L8
    L34:
        Iterator r127 = r101.entrySet().iterator();
    L36:
        if (r127.hasNext() == false) goto L42;
        Map.Entry r128 = (Map.Entry) r127.next();
        n0 r129 = (n0) r128.getKey();
        GroupItemInternal r130 = (GroupItemInternal) r128.getValue();
        ki4.a0 r131 = (ki4.a0) r129.f519310b;
        ki4.b r132 = (ki4.b) r129.f519312d;
        Class<? extends ki4.m> r133 = (Class) r100.get(r131);
        if (r133 == null) goto L36;
        Comparator<ki4.r> r134 = this.f519303f.a(r133).b(r132);
        if (r134 == null) goto L36;
        CollectionsKt.sortWith(r130.f203638c, r134);
        goto L36
    L42:
        this.f519308k.unlock();
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [ni4.l] */
    @Override // com.bytedance.jedi.model.fetcher.AbstractFetcher
    public final Observable g(Object r100) {
        Pair r101 = (Pair) r100;
        Intrinsics.checkNotNullParameter(r101, HiAnalyticsConstant.Direction.REQUEST);
        int r102 = ((Number) r101.component1()).intValue();
        final ki4.b0 r103 = (ki4.b0) r101.component2();
        if (r103.f503616b == true) goto L5;
        i();
        return Observable.just(TuplesKt.to(new ki4.b0(r103.f503615a, r103.f503616b), TuplesKt.to(CollectionsKt.toList(this.f519306i.values()), Unit.INSTANCE)));
    L5:
        Observable<List<ki4.r>> r104 = this.f519302e.a(new ki4.d0(r103.f503615a, r102)).toObservable();
        final ?? r105 = new l(this, r103);
        return r104.map(new m(r105));
    }

    @Override // com.ss.android.ugc.tools.repository.internal.fetcher.a
    public final boolean h(ki4.b0 r100, ki4.b0 r101) {
        ki4.b0 r102 = r100;
        ki4.b0 r103 = r101;
        Intrinsics.checkNotNullParameter(r102, BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY);
        Intrinsics.checkNotNullParameter(r103, "b");
        return Intrinsics.areEqual(r102, r103);
    }

    public n(j r100, ki4.n r101, qi4.b r102, ki4.i r103, Map r104) {
        ki4.b0 r105 = ki4.c0.f503620b;
        Intrinsics.checkNotNullParameter(r100, "broadcastSource");
        Intrinsics.checkNotNullParameter(r101, "groupStrategyProvider");
        Intrinsics.checkNotNullParameter(r102, "categoryStrategy");
        Intrinsics.checkNotNullParameter(r103, "folderStrategy");
        Intrinsics.checkNotNullParameter(r104, "processorProvider");
        Intrinsics.checkNotNullParameter(r105, "startCursor");
        super(r100, r104, r105);
        this.f519302e = r100;
        this.f519303f = r101;
        this.f519304g = r102;
        this.f519305h = r103;
        Comparator<ki4.a> r106 = r103.getComparator();
        if (r106 == null) goto L7;
        Map<ki4.a, FolderItemInternal> r107 = MapsKt.sortedMapOf(r106, new Pair[0]);
        if (r107 == null) goto L7;
    L8:
        this.f519306i = r107;
        ConcurrentHashMap r108 = new ConcurrentHashMap();
        List<ki4.z> r109 = r102.c();
        ArrayList r110 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r109, 10));
        Iterator<T> r111 = r109.iterator();
    L10:
        if (r111.hasNext() == false) goto L12;
        r110.add(((ki4.z) r111.next()).a());
        goto L10
    L12:
        Iterator r112 = r110.iterator();
    L14:
        if (r112.hasNext() == false) goto L16;
        ki4.a0 r113 = (ki4.a0) r112.next();
        Class<? extends ki4.m> r114 = this.f519304g.d().invoke(r113);
        r108.put(r113, new ki4.c(r114, CollectionsKt.mutableListOf(new Class[]{r114})));
        goto L14
    L16:
        this.f519307j = r108;
        this.f519308k = new ReentrantLock();
        return;
    L7:
        r107 = new LinkedHashMap();
        goto L8
    }
}
