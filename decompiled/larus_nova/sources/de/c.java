package de;

import am3.g;
import am3.h;
import com.bytedance.android.ec.adapter.api.message.model.TraceTimeMetric;

/* JADX INFO: loaded from: classes43.dex */
public final class c implements am3.c<TraceTimeMetric> {
    public c() {
    }

    public static TraceTimeMetric a(g r100) throws Exception {
        TraceTimeMetric r101 = new TraceTimeMetric();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L18;
        if (r103 != 1) goto L8;
        r101.opTimestamp = r100.j();
        goto L3
    L8:
        if (r103 != 2) goto L10;
        r101.producerDuration = r100.j();
        goto L3
    L10:
        if (r103 != 3) goto L12;
        r101.consumerDuration = r100.j();
        goto L3
    L12:
        if (r103 != 4) goto L13;
        r101.msgSendTimestamp = r100.j();
        goto L3
    L13:
        h.e(r100);
        goto L3
    L18:
        r100.d(r102);
        return r101;
    }

    @Override // am3.c
    public final TraceTimeMetric decode(g r100) throws Exception {
        return a(r100);
    }
}
