package com.bytedance.ee.bear.list.office.preload;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Pair;
import mc5.u1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b implements OfficeSpaceDbPreloadWorker.c {
    public final /* synthetic */ AtomicBoolean a;
    public final /* synthetic */ List<Pair<LiveData<List<u1>>, Observer<List<u1>>>> b;
    public final /* synthetic */ String c;

    @Override // com.bytedance.ee.bear.list.office.preload.OfficeSpaceDbPreloadWorker.c
    public final void cancel() {
        this.a.set(true);
        Iterator<T> r0 = this.b.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        Pair r1 = (Pair) r0.next();
        ((LiveData) r1.component1()).removeObserver((Observer) r1.component2());
        goto L4
    L6:
        this.b.clear();
        OfficeSpaceDbPreloadWorker.a.removeCallbacksAndMessages(this.c);
    }

    public b(AtomicBoolean r1, List<Pair<LiveData<List<u1>>, Observer<List<u1>>>> r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
