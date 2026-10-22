package com.bytedance.caijing.sdk.biz.outerpay;

import com.bytedance.caijing.sdk.infra.base.api.env.CJHostService;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import ve4.a;

/* JADX INFO: loaded from: classes15.dex */
public final class CJOuterPay {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f202199a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f202200b = null;

    static {
        f202199a = LazyKt.lazy(CJOuterPay$logService$2.INSTANCE);
        f202200b = LazyKt.lazy(CJOuterPay$outerPayApiService$2.INSTANCE);
        new ConcurrentHashMap();
        AnonymousClass1 r100 = AnonymousClass1.INSTANCE;
        a.f554342a.getClass();
        CJHostService r101 = (CJHostService) a.a(CJHostService.class);
        if (r101 == null) goto L6;
        r101.getEnvController();
        return;
    }
}
