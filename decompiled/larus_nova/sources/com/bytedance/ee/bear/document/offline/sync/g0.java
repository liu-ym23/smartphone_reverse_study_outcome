package com.bytedance.ee.bear.document.offline.sync;

import com.bytedance.ee.bear.contract.offline.OfflineDoc;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes16.dex */
public final class g0 implements q25.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h0 f220588a;

    public g0(h0 r100) {
        this.f220588a = r100;
    }

    @Override // q25.f
    public final void a(OfflineDoc r100) {
        tt5.a.h("PreloadManager", "onTaskSuccess, id = " + r100.getReqId());
        q25.f r101 = d(r100);
        if (r101 == null) goto L6;
        r101.a(r100);
        return;
    }

    @Override // q25.f
    public final void c(OfflineDoc r100) {
        tt5.a.h("PreloadManager", "onTaskStart, id = " + r100.getReqId());
        q25.f r101 = d(r100);
        if (r101 == null) goto L6;
        r101.c(r100);
        return;
    }

    public final q25.f d(OfflineDoc r100) {
        if (r100.getReqId() == null) goto L8;
        String r101 = r100.getReqId().split("_")[0];
        WeakReference r102 = (WeakReference) ((ConcurrentHashMap) this.f220588a.f220602h).get(r101);
        if (r102 != null) goto L7;
        return null;
    L7:
        return (q25.f) r102.get();
    L8:
        return null;
    }

    @Override // q25.f
    public final void b(OfflineDoc r100, int r101) {
        tt5.a.h("PreloadManager", "onTaskSuccess, code = " + r101 + ", id = " + r100.getReqId());
        q25.f r102 = d(r100);
        if (r102 == null) goto L6;
        r102.b(r100, r101);
        return;
    }
}
