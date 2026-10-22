package sw6;

import com.bytedance.locallife.biz.common.utils.HostServiceUtilsKt;
import com.ss.android.ugc.aweme.trade.goods.entity.PoiTripTradeSettingEntity;
import com.ss.android.ugc.aweme.trade.goods.entity.PreCacheConfig;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes21.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PreCacheConfig f543718a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final PreCacheConfig f543719b = null;

    static {
        boolean r100 = false;
        f543718a = new PreCacheConfig(0, CollectionsKt.emptyList());
        Object r101 = null;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L23
        PreCacheConfig r103 = (PreCacheConfig) HostServiceUtilsKt.y().a("trip_goods_detail_precache", PreCacheConfig.class, null);     // Catch: Throwable -> L23
        if (r103 == null) goto L20;
        Integer r104 = r103.d();     // Catch: Throwable -> L23
        if (r104 == null) goto L8;
        int r105 = r104.intValue();     // Catch: Throwable -> L23
    L10:
        if (r105 >= 1) goto L21;
        List<String> r106 = r103.a();     // Catch: Throwable -> L23
        if (r106 != null) goto L14;
    L16:
        if (r100 == false) goto L21;
        PoiTripTradeSettingEntity r107 = uw6.a.f551949b;     // Catch: Throwable -> L23
        if (r107 == null) goto L20;
        r103 = r107.a();     // Catch: Throwable -> L23
        goto L21
    L14:
        if (r106.isEmpty() != true) goto L16;
        r100 = true;
    L21:
        Object r108 = Result.m9449constructorimpl(r103);     // Catch: Throwable -> L23
    L26:
        if (Result.m9455isFailureimpl(r108) == true) goto L29;
        r101 = r108;
    L29:
        PreCacheConfig r109 = (PreCacheConfig) r101;
        if (r109 != null) goto L32;
        r109 = f543718a;
    L32:
        f543719b = r109;
        return;
    L8:
        r105 = 0;
    L20:
        r103 = null;
    L23:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L26
    }
}
