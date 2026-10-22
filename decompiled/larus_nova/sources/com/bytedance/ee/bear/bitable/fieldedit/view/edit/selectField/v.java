package com.bytedance.ee.bear.bitable.fieldedit.view.edit.selectField;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes15.dex */
public final class v implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ StaticPropertyEditViewHolder f211639a;

    public v(StaticPropertyEditViewHolder r100) {
        this.f211639a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        StaticPropertyEditViewHolder r100 = this.f211639a;     // Catch: Throwable -> L4
        int r101 = StaticPropertyEditViewHolder.f211557t;     // Catch: Throwable -> L4
        r100.o();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
