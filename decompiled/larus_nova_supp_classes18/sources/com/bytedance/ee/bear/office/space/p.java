package com.bytedance.ee.bear.office.space;

import com.bytedance.ee.bear.office.export.space.OfficeSpaceTab;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class p implements Runnable {
    public final /* synthetic */ OfficeSpaceTabLayout a;
    public final /* synthetic */ OfficeSpaceTab b;

    public p(OfficeSpaceTabLayout r1, OfficeSpaceTab r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        OfficeSpaceTabLayout r0 = this.a;     // Catch: Throwable -> L4
        OfficeSpaceTab r1 = this.b;     // Catch: Throwable -> L4
        int r2 = OfficeSpaceTabLayout.k;     // Catch: Throwable -> L4
        r0.d(r1, false, false);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
