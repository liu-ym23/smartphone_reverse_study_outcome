package com.bytedance.android.shopping.mall.feed;

import com.bytedance.android.ec.hybrid.data.entity.ECHybridConfigDTO;
import com.bytedance.android.ec.hybrid.data.entity.ECHybridNetworkDTO;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class ECMallFeedComponent$configDTOCallback$1 implements com.bytedance.android.ec.hybrid.data.gecko.c {
    public final /* synthetic */ ECMallFeedComponent a;

    public ECMallFeedComponent$configDTOCallback$1(ECMallFeedComponent r1) {
        this.a = r1;
    }

    public final void b(Long r1, Map<String, ECHybridNetworkDTO> r2) {
        Intrinsics.checkNotNullParameter(r2, "apiConfigDTOMap");
        Intrinsics.checkNotNullParameter(r2, "apiConfigDTOMap");
    }

    public final void a(Throwable r1, final String r2, final Long r3) {
        t93.a.c(new ECMallFeedComponent$configDTOCallback$1$onConfigLoadError$1(this, r2, r3));
    }

    public final void c(final String r1, final Long r2, ECHybridConfigDTO r3, Map<String, ? extends Object> r4) {
        t93.a.c(new ECMallFeedComponent$configDTOCallback$1$onConfigLoadSuccess$1(this, r1, r2));
    }
}
