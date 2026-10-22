package com.bytedance.pia.core.tracing;

import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes21.dex */
public final /* synthetic */ class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f266346a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d.a f266347b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f266348c;

    public /* synthetic */ c(d r100, d.a r101, boolean r102) {
        this.f266346a = r100;
        this.f266347b = r101;
        this.f266348c = r102;
    }

    @Override // java.lang.Runnable
    public final void run() {
        d r100 = this.f266346a;
        d.a r101 = this.f266347b;
        boolean r102 = this.f266348c;
        r100.getClass();
        if (r101.f266353a == true) goto L19;
        r101.f266353a = true;
        if (r102 == true) goto L13;
        Iterator r103 = ((CopyOnWriteArrayList) r100.f266350a).iterator();
    L9:
        if (r103.hasNext() == false) goto L13;
        if (((d.a) r103.next()).name != r101.name) goto L9;
        return;
    L13:
        ((CopyOnWriteArrayList) r100.f266350a).add(r101);
        Iterator r104 = ((HashSet) r100.f266351b).iterator();
    L15:
        if (r104.hasNext() == false) goto L29;
        d.b r105 = (d.b) r104.next();
        r105.accept(r101);
        if (r105.isFinished() == false) goto L15;
        r104.remove();
        goto L15
    L29:
        return;
    }
}
