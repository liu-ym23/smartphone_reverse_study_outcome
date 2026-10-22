package com.bytedance.ee.bear.document.associateddocs.view;

import android.content.Context;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class h implements Runnable {
    public final /* synthetic */ Context a;

    public h(Context r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String r0 = this.a.getResources().getQuantityString(2131755029, 1);     // Catch: Throwable -> L4
        Toast.showSuccessText(this.a, r0, 1);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
