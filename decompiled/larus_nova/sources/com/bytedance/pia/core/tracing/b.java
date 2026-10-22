package com.bytedance.pia.core.tracing;

import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes21.dex */
public final /* synthetic */ class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f266344a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d.b f266345b;

    public /* synthetic */ b(d r100, b47.d r101) {
        this.f266344a = r100;
        this.f266345b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        d r100 = this.f266344a;
        d.b r101 = this.f266345b;
        Iterator r102 = ((CopyOnWriteArrayList) r100.f266350a).iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        r101.accept((d.a) r102.next());
        if (r101.isFinished() == false) goto L4;
    L8:
        if (r101.isFinished() == true) goto L14;
        ((HashSet) r100.f266351b).add(r101);
        return;
    }
}
