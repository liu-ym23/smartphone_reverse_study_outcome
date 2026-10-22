package com.bytedance.android.livesdk.log.filter;

import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class l0 extends a<am2.w> {
    public am2.w c;

    public l0() {
    }

    @Override // com.bytedance.android.livesdk.log.filter.a, com.bytedance.android.livesdk.log.filter.o
    public final void a(Map<String, String> r5) {
        super.a(r5);
        am2.w r0 = this.c;
        if (r0 == null) goto L21;
        LiveMode r1 = r0.a;
        LiveMode r2 = LiveMode.MEDIA;
        String r3 = null;
        if (r1 != r2) goto L7;
        String r4 = "media";
    L8:
        if (r4 == null) goto L25;
        if (r5 == null) goto L12;
        r5.put("live_type", r4);
    L12:
        am2.w r6 = this.c;
        if (r6 != null) goto L15;
        return;
    L15:
        if (r6.a != r2) goto L17;
        r3 = r6.b;
    L17:
        if (r3 == null) goto L23;
        if (r5 == null) goto L24;
        r5.put("live_status", r3);
        return;
    L24:
        return;
    L23:
        return;
    L25:
        return;
    L7:
        r4 = null;
        goto L8
    }

    @Override // com.bytedance.android.livesdk.log.filter.a, com.bytedance.android.livesdk.log.filter.o
    public final void setData(Object r1) {
        this.c = (am2.w) r1;
    }
}
