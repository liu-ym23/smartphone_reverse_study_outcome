package pw0;

import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.recharge.RechargeDialogContext;
import com.bytedance.android.live.recharge.a0;
import com.bytedance.android.live.recharge.core.RechargeServices;
import com.bytedance.android.live.recharge.deal.Entrance;
import com.bytedance.android.live.recharge.deal.i;
import com.bytedance.android.live.recharge.jsbridge.RevenueRequestDiamondCouponInfoResultModel;
import com.bytedance.android.live.recharge.m0;
import com.bytedance.android.live.recharge.platform.service.h;
import com.bytedance.android.live.soloktv.SoloKtvContext;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Single;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes47.dex */
public final class f extends b<g, RevenueRequestDiamondCouponInfoResultModel> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RechargeDialogContext f530827a;

    public f(RechargeDialogContext r100) {
        Intrinsics.checkNotNullParameter(r100, "rechargeContext");
        this.f530827a = r100;
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r110, CallContext r111) {
        g r112 = (g) r110;
        Intrinsics.checkNotNullParameter(r112, "params");
        Intrinsics.checkNotNullParameter(r111, PerfLog.PARAM_KEY_CONTEXT_ID);
        Integer r113 = r112.b();
        Integer r100 = r112.d();
        if (r100 == null) goto L5;
        Long r101 = Long.valueOf(r100.intValue());
    L6:
        String r102 = r112.a();
        if (r102 != null) goto L9;
        r102 = "";
    L9:
        Integer r114 = r112.c();
        if (r114 == null) goto L12;
        int r115 = r114.intValue();
    L13:
        if (r113 == null) goto L26;
        if (r101 == null) goto L26;
        Map<Long, com.bytedance.android.live.recharge.platform.business.model.diamond.g> r103 = this.f530827a.getRepository().N.f64752a;
        Set<Long> r104 = r103.keySet();
        LinkedHashMap r116 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r104, 10)), 16));
        Iterator<T> r105 = r104.iterator();
    L18:
        if (r105.hasNext() == false) goto L25;
        Object r106 = r105.next();
        com.bytedance.android.live.recharge.platform.business.model.diamond.g r107 = r103.get(Long.valueOf(((Number) r106).longValue()));
        if (r107 == null) goto L23;
        String r108 = r107.getPreCalcInfo();
        if (r108 == null) goto L23;
    L24:
        r116.put(r106, r108);
    L23:
        r108 = "";
        goto L24
    L25:
        a0 r109 = this.f530827a.getRepository();
        int r117 = r113.intValue();
        long r118 = r101.longValue();
        r109.getClass();
        Intrinsics.checkNotNullParameter(r116, "preCalcInfo");
        Intrinsics.checkNotNullParameter(r102, "couponId");
        h r119 = com.bytedance.android.live.recharge.core.f.d(RechargeServices.b());
        i r120 = (i) r109.C.f64752a;
        Entrance r121 = Entrance.Recharge;
        r119.getClass();
        Intrinsics.checkNotNullParameter(r120, "original");
        Intrinsics.checkNotNullParameter(r121, SoloKtvContext.SOLO_PAGE_ENTRANCE);
        Intrinsics.checkNotNullParameter(r116, "preCalcInfo");
        Intrinsics.checkNotNullParameter(r102, "couponId");
        RxUtilKt.c(Single.defer(new com.bytedance.android.live.recharge.platform.service.g(new com.bytedance.android.live.recharge.platform.business.model.diamond.c(r121.getValue(), r117, r118, r116, new com.bytedance.android.live.recharge.platform.business.model.diamond.b(r102, r115)), r120, r117)).flatMap(new m0(r109)).compose(RxUtil.rxSchedulerHelper()).subscribe(new d(this, r113, r101), new e(this)), this.f530827a.getCd());
        return;
    L26:
        finishWithFailure();
        return;
    L12:
        r115 = 110;
        goto L13
    L5:
        r101 = null;
        goto L6
    }
}
