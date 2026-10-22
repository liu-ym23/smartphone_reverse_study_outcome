package com.ss.android.vesdk;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes40.dex */
public final class c0 implements VELandMarkDetectListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VEEffect f455759a;

    public c0(g0 r100) {
        this.f455759a = r100;
    }

    @Override // com.ss.android.vesdk.VELandMarkDetectListener
    public final void onLandMark(boolean r100) {
        Iterator r101 = ((CopyOnWriteArrayList) this.f455759a.f455597i).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((VELandMarkDetectListener) r101.next()).onLandMark(r100);
        goto L4
    }
}
