package com.bytedance.ee.bear.bitable.infoarch.nativeview.common.list;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes15.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseRecordViewAdapterPartial<Object> f213366a;

    public e(BaseRecordViewAdapterPartial<Object> r100) {
        this.f213366a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        BaseRecordViewAdapterPartial<Object> r100 = this.f213366a;     // Catch: Throwable -> L6
        if (r100.f213331f == false) goto L9;
        r100.f213331f = false;     // Catch: Throwable -> L6
        BaseRecordViewAdapterPartial.Q2(r100, true, 2);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
