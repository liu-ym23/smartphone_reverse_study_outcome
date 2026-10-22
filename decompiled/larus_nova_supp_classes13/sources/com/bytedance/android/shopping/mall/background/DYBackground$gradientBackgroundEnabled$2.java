package com.bytedance.android.shopping.mall.background;

import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import com.bytedance.android.shopping.api.mall.homepage.ECMallBackgroundGradientConfig;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import yj.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class DYBackground$gradientBackgroundEnabled$2 extends Lambda implements Function0<Boolean> {
    public static final DYBackground$gradientBackgroundEnabled$2 INSTANCE = null;

    static {
        INSTANCE = new DYBackground$gradientBackgroundEnabled$2();
    }

    public DYBackground$gradientBackgroundEnabled$2() {
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final boolean m965invoke() {
        int r0 = s93.c.a;
        Object r1 = Boolean.FALSE;
        IHybridHostService r2 = com.bytedance.android.ec.hybrid.a.h();
        if (r2 == null) goto L10;
        g r3 = r2.getHostAB();
        if (r3 == null) goto L10;
        Object r4 = r3.a(ECMallBackgroundGradientConfig.ENABLE_KEY, r1);
        if (r4 == null) goto L10;
        r1 = r4;
    L10:
        Lazy r5 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.c.a.b, "Key : ec_mall_gradient_background_enable, Value: " + r1);
        return ((Boolean) r1).booleanValue();
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return Boolean.valueOf(m965invoke());
    }
}
