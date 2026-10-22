package com.bytedance.locallife.live.lynx.syncjsb;

import androidx.lifecycle.LiveData;
import com.bytedance.android.live.strategy.api.IStrategyService;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.locallife.live.util.w;
import java.util.HashMap;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class f extends a {
    @Override // com.bytedance.locallife.live.lynx.syncjsb.a
    public final String c() {
        return "getLiveStrategyData";
    }

    public f(String r100) {
        Intrinsics.checkNotNullParameter(r100, "uniqueKey");
        super(r100);
    }

    @Override // com.bytedance.locallife.live.lynx.syncjsb.a
    public final HashMap<String, Object> f(HashMap<String, Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        String r101 = w.f(r100, "strategy_key");
        if (r101 != null) goto L6;
        r101 = "";
    L6:
        if (r101.length() != 0) goto L8;
        boolean r102 = true;
    L9:
        if (r102 == true) goto L11;
        IStrategyService r103 = (IStrategyService) jc1.k.f(IStrategyService.class);
        if (r103 == null) goto L18;
        LiveData r104 = IStrategyService.a.a(r103, r101, 0, false, 12);
        if (r104 == null) goto L18;
        Integer r105 = (Integer) r104.getValue();
        if (r105 == null) goto L18;
    L20:
        return a.d(this, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(BdpAppEventConstant.PARAMS_STRATEGY_NAME, String.valueOf(r105.intValue()))}), 1);
    L18:
        r105 = 0;
        goto L20
    L11:
        return a.b("参数检验出错，keys为空");
    L8:
        r102 = false;
        goto L9
    }
}
