package com.bytedance.ee.bear.bitable.card.view.cell.url;

import com.bytedance.ee.bear.bitable.card.view.cell.text.BitableSpaceEditText;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes15.dex */
public final class o implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BitableSpaceEditText f208328a;

    public o(BitableSpaceEditText r100) {
        this.f208328a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f208328a.requestFocus();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
