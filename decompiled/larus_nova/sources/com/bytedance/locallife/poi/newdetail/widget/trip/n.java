package com.bytedance.locallife.poi.newdetail.widget.trip;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes21.dex */
public final class n implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TripPoiHeadVideoViewHolder f263691a;

    public n(TripPoiHeadVideoViewHolder r100) {
        this.f263691a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        TripPoiHeadVideoViewHolder r100 = this.f263691a;     // Catch: Throwable -> L4
        int r101 = TripPoiHeadVideoViewHolder.f263617z;     // Catch: Throwable -> L4
        r100.g4();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
