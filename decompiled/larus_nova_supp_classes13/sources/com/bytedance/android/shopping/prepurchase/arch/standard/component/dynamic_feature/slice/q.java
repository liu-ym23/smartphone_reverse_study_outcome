package com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.slice;

import com.bytedance.android.shopping.anchorv4.dto.meta.PageMeta;
import com.bytedance.android.shopping.anchorv4.dto.meta.PageMetaMappedMap;
import com.bytedance.android.shopping.prepurchase.business.pdp.repository.PdpDataStore;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class q implements ng3.a {
    public final com.bytedance.android.shopping.prepurchase.arch.container.c<com.bytedance.android.shopping.prepurchase.business.pdp.e, PdpDataStore> a;

    @Override // ng3.a
    public final Map<String, Object> b() {
        return new PageMetaMappedMap((PageMeta) this.a.d().getData().b.a());
    }

    public q(com.bytedance.android.shopping.prepurchase.arch.container.c<com.bytedance.android.shopping.prepurchase.business.pdp.e, PdpDataStore> r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = r2;
    }
}
