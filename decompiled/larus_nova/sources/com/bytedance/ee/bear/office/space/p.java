package com.bytedance.ee.bear.office.space;

import com.bytedance.ee.bear.office.export.space.OfficeSpaceTab;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes18.dex */
public final class p implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OfficeSpaceTabLayout f236126a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ OfficeSpaceTab f236127b;

    public p(OfficeSpaceTabLayout r100, OfficeSpaceTab r101) {
        this.f236126a = r100;
        this.f236127b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        OfficeSpaceTabLayout r100 = this.f236126a;     // Catch: Throwable -> L4
        OfficeSpaceTab r101 = this.f236127b;     // Catch: Throwable -> L4
        int r102 = OfficeSpaceTabLayout.f236079k;     // Catch: Throwable -> L4
        r100.d(r101, false, false);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
