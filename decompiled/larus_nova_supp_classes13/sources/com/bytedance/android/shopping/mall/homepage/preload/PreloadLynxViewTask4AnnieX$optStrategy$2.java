package com.bytedance.android.shopping.mall.homepage.preload;

import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class PreloadLynxViewTask4AnnieX$optStrategy$2 extends Lambda implements Function0<Integer> {
    public static final PreloadLynxViewTask4AnnieX$optStrategy$2 INSTANCE = null;

    static {
        INSTANCE = new PreloadLynxViewTask4AnnieX$optStrategy$2();
    }

    public PreloadLynxViewTask4AnnieX$optStrategy$2() {
        super(0);
    }

    public final int invoke() {
        int r0 = s93.c.a;
        Object r1 = 0;
        IHybridHostService r2 = com.bytedance.android.ec.hybrid.a.h();
        if (r2 == null) goto L10;
        yj.g r3 = r2.getHostAB();
        if (r3 == null) goto L10;
        Object r4 = r3.a("ec_mall_preload_lynx_view_opt", r1);
        if (r4 == null) goto L10;
        r1 = r4;
    L10:
        Lazy r5 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.c.a.b, "Key : ec_mall_preload_lynx_view_opt, Value: " + r1);
        return ((Number) r1).intValue();
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m1423invoke() {
        return Integer.valueOf(invoke());
    }
}
