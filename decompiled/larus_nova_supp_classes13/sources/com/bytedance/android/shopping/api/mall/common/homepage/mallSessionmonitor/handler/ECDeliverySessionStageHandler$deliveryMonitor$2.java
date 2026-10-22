package com.bytedance.android.shopping.api.mall.common.homepage.mallSessionmonitor.handler;

import com.bytedance.android.shopping.api.mall.IECNativeHomeService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Ly93/b;", "invoke", "()Ly93/b;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class ECDeliverySessionStageHandler$deliveryMonitor$2 extends Lambda implements Function0<y93.b> {
    public static final ECDeliverySessionStageHandler$deliveryMonitor$2 INSTANCE = null;

    static {
        INSTANCE = new ECDeliverySessionStageHandler$deliveryMonitor$2();
    }

    public ECDeliverySessionStageHandler$deliveryMonitor$2() {
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final y93.b m191invoke() {
        IECNativeHomeService r0 = (IECNativeHomeService) ServiceManager.get().getService(IECNativeHomeService.class);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.a();
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return m191invoke();
    }
}
