package com.bytedance.android.shopping.mall.impl;

import com.bytedance.android.shopping.api.mall.common.homepage.pagecard.monitor.MallDeliveryMonitor;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/bytedance/android/shopping/api/mall/common/homepage/pagecard/monitor/MallDeliveryMonitor;", "invoke"}, k = 3, mv = {1, 4, 3})
final class MallHomePageServiceImpl$deliveryMonitor$2 extends Lambda implements Function0<MallDeliveryMonitor> {
    public static final MallHomePageServiceImpl$deliveryMonitor$2 INSTANCE = null;

    static {
        INSTANCE = new MallHomePageServiceImpl$deliveryMonitor$2();
    }

    public MallHomePageServiceImpl$deliveryMonitor$2() {
        super(0);
    }

    public final MallDeliveryMonitor invoke() {
        return new MallDeliveryMonitor();
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m1476invoke() {
        return invoke();
    }
}
