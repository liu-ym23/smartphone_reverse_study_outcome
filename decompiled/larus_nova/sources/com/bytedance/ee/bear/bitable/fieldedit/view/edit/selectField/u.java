package com.bytedance.ee.bear.bitable.fieldedit.view.edit.selectField;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes15.dex */
public final class u implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ StaticPropertyEditViewHolder.SelectOptionAdapter.SelectOptionViewHolder f211638a;

    public u(StaticPropertyEditViewHolder.SelectOptionAdapter.SelectOptionViewHolder r100) {
        this.f211638a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        rcb.c.h(this.f211638a.f211570c, null);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
