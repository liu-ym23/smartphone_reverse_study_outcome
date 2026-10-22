package com.larus.vesdk.impl.utils;

import com.ss.android.vesdk.algorithm.VEBachQRCodeResult;
import com.ss.android.vesdk.algorithm.VEScanResult;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes31.dex */
public final class d implements hic.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f375619a;

    public d(c r100) {
        this.f375619a = r100;
    }

    @Override // hic.c
    public final void onResult(List<VEScanResult> r100) {
        pq9.a r101 = this.f375619a.f375617a;
        String r102 = null;
        if (r100 == null) goto L5;
        VEScanResult r103 = (VEScanResult) CollectionsKt.firstOrNull(r100);
    L7:
        if ((r103 instanceof VEBachQRCodeResult) == false) goto L9;
        VEBachQRCodeResult r104 = (VEBachQRCodeResult) r103;
    L10:
        if (r104 == null) goto L12;
        r102 = r104.getResult();
    L12:
        r101.onResult(r102);
        return;
    L9:
        r104 = null;
        goto L10
    L5:
        r103 = null;
        goto L7
    }
}
