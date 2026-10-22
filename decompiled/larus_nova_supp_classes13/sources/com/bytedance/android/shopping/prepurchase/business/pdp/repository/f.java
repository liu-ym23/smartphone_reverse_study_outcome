package com.bytedance.android.shopping.prepurchase.business.pdp.repository;

import com.bytedance.android.ec.model.ECCacheMonitorStruct;
import com.bytedance.android.shopping.anchorv3.repository.api.PdpPackRequestParam;
import com.bytedance.android.shopping.anchorv4.data.AnchorV4DataManager;
import com.bytedance.android.shopping.anchorv4.dto.PackResponseDTO;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class f implements d {
    public PackResponseDTO a;
    public final String b;

    public f(String r2) {
        Intrinsics.checkNotNullParameter(r2, "cacheKey");
        this.b = r2;
    }

    @Override // com.bytedance.android.shopping.prepurchase.business.pdp.repository.d
    public final void a(PackResponseDTO r4) {
        Intrinsics.checkNotNullParameter(r4, "dTO");
        if (r4.isFirstChunk() == false) goto L5;
    L6:
        this.a = r4;
    L8:
        if (r4.hasMultipleChunks() == true) goto L10;
    L11:
        com.bytedance.android.shopping.anchorv4.data.k r5 = AnchorV4DataManager.a;
        PdpPackRequestParam r6 = AnchorV4DataManager.k(this.b);
        ECCacheMonitorStruct r0 = com.bytedance.android.shopping.anchorv4.experiment.b.a;
        if (com.bytedance.android.shopping.anchorv4.experiment.b.a(Boolean.valueOf(AnchorV4DataManager.l(r6))) == false) goto L28;
        if (r6 == null) goto L29;
        PackResponseDTO r1 = this.a;
        if (r1 != null) goto L17;
        return;
    L17:
        if (r1.isForbidCache() == true) goto L31;
        PackResponseDTO r2 = this.a;
        if (r2 == null) goto L21;
        PackResponseDTO r3 = e73.f.b(r2);
    L22:
        if (r3 == null) goto L24;
        r3.setTimestamp(System.currentTimeMillis());
    L24:
        if (r3 == null) goto L32;
        AnchorV4DataManager.a.c(r6, r3);
        return;
    L32:
        return;
    L21:
        r3 = null;
        goto L22
    L31:
        return;
    L29:
        return;
    L28:
        return;
    L10:
        if (r4.isLastChunk() == true) goto L11;
        return;
    L5:
        if (r4.hasMultipleChunks() == true) goto L8;
        goto L6
    }
}
