package com.bytedance.livesdk.ktvcommon.download.api;

import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(k = 3, mv = {1, 5, 1})
final /* synthetic */ class PlatformConfiguration$isInitialized$1 extends MutablePropertyReference0Impl {
    public PlatformConfiguration$isInitialized$1(f r100) {
        super(r100, f.class, PromotionProductPrivilegesStruct.SERVICES, "getServices()Lcom/bytedance/livesdk/ktvcommon/download/api/KtvDownloadPlatformService;", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
    public Object get() {
        ((f) this.receiver).getClass();
        return f.a();
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
    public void set(Object r100) {
        f r101 = (f) this.receiver;
        f.f255931a = (e) r100;
    }
}
