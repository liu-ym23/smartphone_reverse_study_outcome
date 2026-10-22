package com.larus.uaigc.lynx;

import com.larus.common.apphost.AppHost;
import com.larus.common.pollingconfig.api.PollingConfigService;
import com.larus.utils.logger.FLogger;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: classes31.dex */
public final class LotteryPollingConfigProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f373487a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final MutableSharedFlow<s09.a> f373488b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f373489c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f373490d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f373491e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Lazy f373492f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Lazy f373493g = null;

    public static final class a<T> implements Comparator {
        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            return ComparisonsKt.compareValues(((hy9.g) r100).d(), ((hy9.g) r101).d());
        }
    }

    public static final class b<T> implements Comparator {
        public b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            return ComparisonsKt.compareValues(((hy9.g) r100).d(), ((hy9.g) r101).d());
        }
    }

    static {
        Lazy r100 = LazyKt.lazy(new c());
        f373487a = r100;
        f373488b = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        f373489c = LazyKt.lazy(new d());
        f373490d = LazyKt.lazy(new e());
        f373491e = LazyKt.lazy(new f());
        f373492f = LazyKt.lazy(new g());
        f373493g = LazyKt.lazy(new h());
        FLogger.f375446a.i("LotteryPollingConfigProvider", "initZLotteryGuideManager");
        PollingConfigService.f326423a.j((s09.b) r100.getValue());
    }

    public static hy9.b a(boolean r110) {
        List r100 = b(r110);
        if (r110 == false) goto L9;
        Long r111 = PollingConfigService.f326423a.c();
        if (r111 == null) goto L7;
        long r101 = r111.longValue();
    L8:
        Long r112 = Long.valueOf(r101);
    L10:
        Long r102 = r112;
        if (r102 != null) goto L14;
        FLogger.f375446a.e("LotteryPollingConfigProvider", "getCurHostReadState failed, curTimeMs is null");
        return new hy9.b(null, 31);
    L14:
        Iterator r103 = r100.iterator();
        int r104 = 0;
    L16:
        if (r103.hasNext() == false) goto L28;
        hy9.g r105 = (hy9.g) r103.next();
        if (r105.a() != null) goto L20;
    L24:
        boolean r106 = false;
    L25:
        if (r106 == true) goto L29;
        r104 = r104 + 1;
    L29:
        hy9.g r107 = (hy9.g) CollectionsKt.getOrNull(r100, r104);
        FLogger.f375446a.i("LotteryPollingConfigProvider", "[getCurHostReadState] roundList = " + r100.size() + ", curTimeMs = " + r102 + ", index = " + r104);
        if (r107 == null) goto L48;
        Integer r108 = r107.d();
        if (r108 == null) goto L35;
        int r109 = r108.intValue();
    L36:
        long r113 = r102.longValue();
        Long r114 = r107.c();
        if (r114 == null) goto L39;
        long r115 = r114.longValue();
    L41:
        if (r113 < r115) goto L43;
        boolean r116 = true;
    L45:
        return new hy9.b(true, r109, r116, r107, r102);
    L43:
        r116 = false;
        goto L45
    L39:
        r115 = 0;
        goto L41
    L35:
        r109 = r104 + 1;
        goto L36
    L48:
        return new hy9.b(r102, 15);
    L20:
        if (r105.b() == null) goto L24;
        Long r117 = r105.a();
        Intrinsics.checkNotNull(r117);
        long r118 = r117.longValue();
        Long r119 = r105.b();
        Intrinsics.checkNotNull(r119);
        if (RangesKt.until(r118, r119.longValue()).contains(r102.longValue()) == false) goto L24;
        r106 = true;
        goto L25
    L28:
        r104 = -1;
        goto L29
    L7:
        r101 = AppHost.f326268a.getAppClock().currentTimeMillis();
        goto L8
    L9:
        r112 = PollingConfigService.f326423a.c();
        goto L10
    }

    public static List b(boolean r100) {
        List r101 = null;
        if (r100 == false) goto L12;
        hy9.a r102 = (hy9.a) ((i1) f373491e.getValue()).getValue();
        if (r102 == null) goto L9;
        List<hy9.g> r103 = r102.a();
        if (r103 == null) goto L9;
        r101 = CollectionsKt.filterNotNull(r103);
    L9:
        if (r101 != null) goto L21;
        r101 = CollectionsKt.emptyList();
    L21:
        return CollectionsKt.sortedWith(r101, new a());
    L12:
        hy9.a r104 = (hy9.a) ((i1) f373490d.getValue()).getValue();
        if (r104 == null) goto L17;
        List<hy9.g> r105 = r104.a();
        if (r105 == null) goto L17;
        r101 = CollectionsKt.filterNotNull(r105);
    L17:
        if (r101 != null) goto L20;
        r101 = CollectionsKt.emptyList();
    L20:
        return CollectionsKt.sortedWith(r101, new b());
    }
}
