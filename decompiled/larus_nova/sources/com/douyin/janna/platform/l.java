package com.douyin.janna.platform;

import com.douyin.janna.api.CapabilityType;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes22.dex */
public final class l implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VIVOProcessor f273628a;

    @Override // java.lang.Runnable
    public final void run() {
        this.f273628a.j();     // Catch: Throwable -> L6
        VIVOProcessor r100 = this.f273628a;     // Catch: Throwable -> L6
        if (r100.f273584m == null) goto L9;
        Set<CapabilityType> r101 = r100.f273605h;     // Catch: Throwable -> L6
        HashSet r102 = (HashSet) r101;     // Catch: Throwable -> L6
        r102.add(CapabilityType.SET_FPS);     // Catch: Throwable -> L6
        Set<CapabilityType> r103 = this.f273628a.f273605h;     // Catch: Throwable -> L6
        HashSet r104 = (HashSet) r103;     // Catch: Throwable -> L6
        r104.add(CapabilityType.CANCEL_FPS);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }

    public l(VIVOProcessor r100) {
        this.f273628a = r100;
    }
}
