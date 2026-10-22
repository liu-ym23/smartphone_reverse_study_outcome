package com.bytedance.android.livesdk.log.filter;

import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class g0 extends a<y> {
    public String c;

    public g0() {
        this.c = "";
    }

    @Override // com.bytedance.android.livesdk.log.filter.a, com.bytedance.android.livesdk.log.filter.o
    public final void a(Map<String, String> r3) {
        super.a(r3);
        if (r3 == null) goto L6;
        String r4 = r3.put("function_type", this.c);
        return;
    }

    @Override // com.bytedance.android.livesdk.log.filter.a, com.bytedance.android.livesdk.log.filter.o
    public final void setData(Object r2) {
        y r3 = (y) r2;
        if (r3 == null) goto L12;
        int r4 = r3.a;
        if (r4 != 5) goto L7;
        this.c = "fm";
        return;
    L7:
        if (r4 != 9) goto L14;
        this.c = "multi_ktv";
        return;
    L14:
        return;
    }
}
