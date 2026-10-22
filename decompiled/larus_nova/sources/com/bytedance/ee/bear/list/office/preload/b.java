package com.bytedance.ee.bear.list.office.preload;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Pair;
import mc5.u1;

/* JADX INFO: loaded from: classes18.dex */
public final class b implements OfficeSpaceDbPreloadWorker.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f229144a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ List<Pair<LiveData<List<u1>>, Observer<List<u1>>>> f229145b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f229146c;

    @Override // com.bytedance.ee.bear.list.office.preload.OfficeSpaceDbPreloadWorker.c
    public final void cancel() {
        this.f229144a.set(true);
        Iterator<T> r100 = this.f229145b.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        Pair r101 = (Pair) r100.next();
        ((LiveData) r101.component1()).removeObserver((Observer) r101.component2());
        goto L4
    L6:
        this.f229145b.clear();
        OfficeSpaceDbPreloadWorker.f229096a.removeCallbacksAndMessages(this.f229146c);
    }

    public b(AtomicBoolean r100, List<Pair<LiveData<List<u1>>, Observer<List<u1>>>> r101, String r102) {
        this.f229144a = r100;
        this.f229145b = r101;
        this.f229146c = r102;
    }
}
