package com.bytedance.ee.bear.middleground.unbundle;

import com.bytedance.ee.bear.unbundle.BenefitManagerAPI;
import com.bytedance.ee.bear.unbundle.BenefitStore;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import javax.inject.Inject;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d implements BenefitManagerAPI {
    @Inject
    public d() {
    }

    @Override // com.bytedance.ee.bear.unbundle.BenefitManagerAPI
    public final void destroy() {
    }

    @Override // com.bytedance.ee.bear.unbundle.BenefitManagerAPI
    public final BenefitStore n1() {
        return new BenefitStore("", MapsKt.emptyMap(), "{}", null, false, 24, null);
    }

    @Override // com.bytedance.ee.bear.unbundle.BenefitManagerAPI
    public final BenefitStore R7(String r9, int r10) {
        Intrinsics.checkNotNullParameter(r9, ResourceData.KEY_TOKEN);
        return new BenefitStore("", MapsKt.emptyMap(), "{}", null, false, 24, null);
    }

    @Override // com.bytedance.ee.bear.unbundle.BenefitManagerAPI
    public final BenefitStore g7(String r9, int r10, BenefitManagerAPI.CacheType r11) {
        Intrinsics.checkNotNullParameter(r9, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r11, "cacheType");
        return new BenefitStore("", MapsKt.emptyMap(), "{}", null, false, 24, null);
    }

    @Override // com.bytedance.ee.bear.unbundle.BenefitManagerAPI
    public final Object d8(String r9, int r10, String r11, BenefitManagerAPI.CacheType r12, Continuation<? super BenefitStore> r13) {
        if (r11 != null) goto L6;
        r11 = "";
    L6:
        return new BenefitStore(r11, MapsKt.emptyMap(), "{}", null, false, 24, null);
    }
}
