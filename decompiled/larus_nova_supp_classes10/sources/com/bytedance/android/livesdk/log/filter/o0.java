package com.bytedance.android.livesdk.log.filter;

import com.bytedance.common.utility.StringUtils;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class o0 extends a<am2.y> {
    public o0() {
    }

    @Override // com.bytedance.android.livesdk.log.filter.a, com.bytedance.android.livesdk.log.filter.o
    public final void a(Map<String, String> r1) {
        super.a(r1);
    }

    @Override // com.bytedance.android.livesdk.log.filter.a, com.bytedance.android.livesdk.log.filter.o
    public final void setData(Object r3) {
        if (((am2.y) r3) == null) goto L11;
        Map<String, String> r4 = this.b;
        if (StringUtils.equal(null, "pop_card") == false) goto L8;
        r4.put("is_popcard", "1");
        return;
    L8:
        r4.remove("is_popcard");
        return;
    }
}
