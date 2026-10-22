package com.bytedance.ee.bear.middleground.unbundle;

import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.ee.bear.unbundle.BenefitManagerAPI;
import com.bytedance.ee.bear.unbundle.BenefitStore;
import javax.inject.Inject;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class d implements BenefitManagerAPI {
    @Inject
    public d() {
    }

    @Override // com.bytedance.ee.bear.unbundle.BenefitManagerAPI
    public final void destroy() {
    }

    @Override // com.bytedance.ee.bear.unbundle.BenefitManagerAPI
    public final BenefitStore n1() {
        return new BenefitStore("", MapsKt.emptyMap(), SliceInitService.DEFAULT_SWITCH, null, false, 24, null);
    }

    @Override // com.bytedance.ee.bear.unbundle.BenefitManagerAPI
    public final BenefitStore R7(String r100, int r110) {
        Intrinsics.checkNotNullParameter(r100, "token");
        return new BenefitStore("", MapsKt.emptyMap(), SliceInitService.DEFAULT_SWITCH, null, false, 24, null);
    }

    @Override // com.bytedance.ee.bear.unbundle.BenefitManagerAPI
    public final BenefitStore g7(String r100, int r110, BenefitManagerAPI.CacheType r111) {
        Intrinsics.checkNotNullParameter(r100, "token");
        Intrinsics.checkNotNullParameter(r111, "cacheType");
        return new BenefitStore("", MapsKt.emptyMap(), SliceInitService.DEFAULT_SWITCH, null, false, 24, null);
    }

    @Override // com.bytedance.ee.bear.unbundle.BenefitManagerAPI
    public final Object d8(String r100, int r110, String r111, BenefitManagerAPI.CacheType r112, Continuation<? super BenefitStore> r113) {
        if (r111 != null) goto L6;
        r111 = "";
    L6:
        return new BenefitStore(r111, MapsKt.emptyMap(), SliceInitService.DEFAULT_SWITCH, null, false, 24, null);
    }
}
