package com.bytedance.ee.bear.drive.config.strategy;

import com.bytedance.ee.bear.contract.offline.OfflineDoc;
import com.bytedance.ee.bear.drive.cache.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c extends i {
    @Override // com.bytedance.ee.bear.drive.config.strategy.i, com.bytedance.ee.bear.drive.config.strategy.d
    public final String c(String r1) {
        return r1;
    }

    @Override // com.bytedance.ee.bear.drive.config.strategy.i, com.bytedance.ee.bear.drive.config.strategy.d
    public final String getPreviewFileSourceType() {
        return "5";
    }

    @Override // com.bytedance.ee.bear.drive.config.strategy.i, com.bytedance.ee.bear.drive.config.strategy.d
    public final String i(w75.a r3) {
        if ((r3 instanceof f85.a) == false) goto L5;
        String r0 = ((f85.a.C0229a) ((f85.a) r3).a).p;
    L7:
        return t.c(r3) + OfflineDoc.DASH_DELIMITER + r0;
    L5:
        tt5.a.k("PreviewFileDownloadStrategy", "getCacheKey() dataVersion is null");
        r0 = "";
        goto L7
    }

    public c(g85.b r1, com.bytedance.ee.bear.contract.j r2, q75.a r3) {
        super(r1, r2, r3);
    }
}
