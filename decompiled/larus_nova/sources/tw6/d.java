package tw6;

import com.ss.android.ugc.aweme.trade.goods.entity.PoiTripTradeSettingEntity;
import com.ss.android.ugc.aweme.trade.goods.entity.PreCacheConfig;
import com.ss.android.ugc.aweme.trade.goods.entity.TripGoodsDetailPreloadStrategy;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes21.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f547774a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f547775b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f547776c = null;

    static {
        PoiTripTradeSettingEntity r100 = uw6.a.f551949b;
        List r101 = null;
        if (r100 == null) goto L7;
        TripGoodsDetailPreloadStrategy r102 = r100.d();
        if (r102 == null) goto L7;
        String[] r103 = r102.b();
    L8:
        if (r100 == null) goto L12;
        TripGoodsDetailPreloadStrategy r104 = r100.d();
        if (r104 == null) goto L12;
        String[] r105 = r104.a();
    L13:
        f547774a = new c(r103, r105);
        PreCacheConfig r106 = sw6.a.f543719b;
        Integer r107 = r106.d();
        if (r107 == null) goto L16;
        int r108 = r107.intValue();
    L18:
        if ((r108 & 2) == 0) goto L20;
        boolean r109 = true;
    L21:
        if (r109 == true) goto L42;
        Integer r110 = r106.d();
        if (r110 == null) goto L25;
        int r111 = r110.intValue();
    L27:
        if ((r111 & 1) == 0) goto L29;
        boolean r112 = true;
    L30:
        if (r112 == true) goto L42;
        Integer r113 = r106.d();
        if (r113 == null) goto L34;
        int r114 = r113.intValue();
    L36:
        if ((r114 & 4) == 0) goto L38;
        boolean r115 = true;
    L39:
        if (r115 == true) goto L42;
        boolean r116 = false;
    L43:
        Integer r117 = r106.d();
        if (r117 == null) goto L46;
        int r118 = r117.intValue();
    L48:
        if ((r118 & 1) == 0) goto L50;
        boolean r119 = true;
    L51:
        Integer r120 = r106.d();
        if (r120 == null) goto L54;
        int r121 = r120.intValue();
    L56:
        if ((r121 & 2) == 0) goto L58;
        boolean r122 = true;
    L59:
        Integer r123 = r106.d();
        if (r123 == null) goto L62;
        int r124 = r123.intValue();
    L64:
        if ((r124 & 4) == 0) goto L66;
        boolean r125 = true;
    L67:
        List<String> r126 = r106.a();
        if (r126 == null) goto L71;
        List r127 = CollectionsKt.filterNotNull(r126);
        if (r127 == null) goto L71;
    L72:
        List r128 = r127;
        Integer r129 = r106.e();
        List<String> r130 = r106.c();
        if (r130 == null) goto L81;
        List r131 = CollectionsKt.filterNotNull(r130);
        if (r131 == null) goto L81;
        List r132 = r131;
        if (r132.isEmpty() == true) goto L80;
        r101 = r132;
    L80:
        r101 = r101;
    L81:
        f547775b = new b(r116, r119, r122, r125, r128, r129, r101, r106.b());
        if (r100 == null) goto L85;
        List<String> r133 = r100.b();
        if (r133 == null) goto L85;
    L86:
        List r134 = CollectionsKt.filterNotNull(r133);
        if (r100 == null) goto L90;
        List<String> r135 = r100.c();
        if (r135 == null) goto L90;
    L91:
        f547776c = new a(r134, CollectionsKt.filterNotNull(r135));
        return;
    L90:
        r135 = uw6.a.f551948a;
    L85:
        r133 = CollectionsKt.emptyList();
    L71:
        r127 = CollectionsKt.emptyList();
        goto L72
    L66:
        r125 = false;
        goto L67
    L62:
        r124 = 0;
        goto L64
    L58:
        r122 = false;
        goto L59
    L54:
        r121 = 0;
        goto L56
    L50:
        r119 = false;
        goto L51
    L46:
        r118 = 0;
        goto L48
    L38:
        r115 = false;
        goto L39
    L34:
        r114 = 0;
        goto L36
    L29:
        r112 = false;
        goto L30
    L25:
        r111 = 0;
    L42:
        r116 = true;
        goto L43
    L20:
        r109 = false;
        goto L21
    L16:
        r108 = 0;
    L12:
        r105 = null;
    L7:
        r103 = null;
        goto L8
    }
}
