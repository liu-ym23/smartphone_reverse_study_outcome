package com.bytedance.android.shopping.mall.homepage.tools;

import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import com.bytedance.android.ec.hybrid.monitor.HybridAppInfoService;
import com.bytedance.android.shopping.api.mall.IECMallHostService;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class DataEngineMap {
    public static final Map<String, DataEngineWrapper> a = null;

    public static final class a implements IECMallHostService.a {
        public a() {
        }
    }

    static {
        a = new LinkedHashMap();
        Lazy r0 = HybridAppInfoService.a;
        if (HybridAppInfoService.l() == false) goto L9;
        IHybridHostService r1 = com.bytedance.android.ec.hybrid.a.h();
        if (r1 == null) goto L9;
        yj.s r2 = r1.getIHybridHostUserService();
        if (r2 == null) goto L9;
        LazyKt.lazy(DataEngineMap$UserChangeListener$releaseEnable$2.INSTANCE);
        r2.d();
    L9:
        Set r3 = kk.c.a;
        AnonymousClass1 r4 = AnonymousClass1.INSTANCE;
        Intrinsics.checkNotNullParameter("DataEngineMap#registerGeckoChangedListener", "key");
        Intrinsics.checkNotNullParameter(r4, "action");
        Set r5 = kk.c.a;
        if (r5.contains("DataEngineMap#registerGeckoChangedListener") == true) goto L13;
        r5.add("DataEngineMap#registerGeckoChangedListener");
        Single.fromCallable(new kk.b(r4)).subscribeOn(Schedulers.io()).observeOn(Schedulers.io()).subscribe();
        return;
    }

    public static DataEngineWrapper a(String r4) {
        Intrinsics.checkNotNullParameter(r4, "key");
        Lazy r0 = ECMallLogUtil.a;
        com.bytedance.android.ec.hybrid.log.mall.o.b r1 = com.bytedance.android.ec.hybrid.log.mall.o.b.b;
        ECMallLogUtil.c(r1, "DataEngineMap#getDataEngineWrapper(), key = ".concat(r4));
        Map<String, DataEngineWrapper> r2 = a;
        if (r2.containsKey(r4) == false) goto L6;
        Object r5 = ((LinkedHashMap) r2).get(r4);
        Intrinsics.checkNotNull(r5);
        return (DataEngineWrapper) r5;
    L6:
        DataEngineWrapper r3 = new DataEngineWrapper();
        ECMallLogUtil.c(r1, "DataEngineMap#getDataEngineWrapper(), generate new instance, key = ".concat(r4));
        r2.put(r4, r3);
        return r3;
    }
}
