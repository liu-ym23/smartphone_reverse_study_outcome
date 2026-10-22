package com.bytedance.android.livesdk.log.filter;

import com.bytedance.common.utility.StringUtils;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class f extends a<am2.e> {
    public boolean c;

    public f() {
    }

    @Override // com.bytedance.android.livesdk.log.filter.a, com.bytedance.android.livesdk.log.filter.o
    public final void a(Map<String, String> r3) {
        super.a(r3);
        if (StringUtils.isEmpty(null) == true) goto L6;
        r3.put("task_id", null);
    L6:
        if (StringUtils.isEmpty(null) == true) goto L9;
        r3.put("activity_id", null);
        return;
    }

    @Override // com.bytedance.android.livesdk.log.filter.a, com.bytedance.android.livesdk.log.filter.o
    public final void setData(Object r2) {
        if (((am2.e) r2) == null) goto L7;
        this.c = "1".equals(null);
        return;
    }

    @Override // com.bytedance.android.livesdk.log.filter.a, com.bytedance.android.livesdk.log.filter.o
    public final void u(Map r2, Object r3) {
        am2.e r4 = (am2.e) r3;
        super.u(r2, r4);
        if (r4 != null) goto L6;
        return;
    L6:
        if (StringUtils.isEmpty(null) == true) goto L9;
        r2.put("task_id", null);
    L9:
        if (StringUtils.isEmpty(null) == true) goto L12;
        r2.put("activity_id", null);
        return;
    }
}
