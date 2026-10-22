package com.bytedance.ee.bear.document.offline.sync;

import com.bytedance.ee.bear.contract.offline.OfflineDoc;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class g0 implements q25.f {
    public final /* synthetic */ h0 a;

    public g0(h0 r1) {
        this.a = r1;
    }

    @Override // q25.f
    public final void a(OfflineDoc r3) {
        tt5.a.h("PreloadManager", "onTaskSuccess, id = " + r3.getReqId());
        q25.f r0 = d(r3);
        if (r0 == null) goto L6;
        r0.a(r3);
        return;
    }

    @Override // q25.f
    public final void c(OfflineDoc r3) {
        tt5.a.h("PreloadManager", "onTaskStart, id = " + r3.getReqId());
        q25.f r0 = d(r3);
        if (r0 == null) goto L6;
        r0.c(r3);
        return;
    }

    public final q25.f d(OfflineDoc r2) {
        if (r2.getReqId() == null) goto L8;
        String r3 = r2.getReqId().split(OfflineDoc.DASH_DELIMITER)[0];
        WeakReference r4 = (WeakReference) ((ConcurrentHashMap) this.a.h).get(r3);
        if (r4 != null) goto L7;
        return null;
    L7:
        return (q25.f) r4.get();
    L8:
        return null;
    }

    @Override // q25.f
    public final void b(OfflineDoc r3, int r4) {
        tt5.a.h("PreloadManager", "onTaskSuccess, code = " + r4 + ", id = " + r3.getReqId());
        q25.f r0 = d(r3);
        if (r0 == null) goto L6;
        r0.b(r3, r4);
        return;
    }
}
