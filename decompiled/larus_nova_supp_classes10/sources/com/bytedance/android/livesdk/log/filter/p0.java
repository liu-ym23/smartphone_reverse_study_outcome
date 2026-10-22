package com.bytedance.android.livesdk.log.filter;

import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class p0 extends a<am2.z> {
    public p0() {
    }

    @Override // com.bytedance.android.livesdk.log.filter.a, com.bytedance.android.livesdk.log.filter.o
    public final void u(Map r2, Object r3) {
        am2.z r4 = (am2.z) r3;
        super.u(r2, r4);
        if (r4 != null) goto L6;
        return;
    L6:
        if (r2.containsKey("_staging_flag") == false) goto L9;
        r2.remove("_staging_flag");
        return;
    }
}
