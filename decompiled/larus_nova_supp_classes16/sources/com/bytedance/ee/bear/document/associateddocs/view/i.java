package com.bytedance.ee.bear.document.associateddocs.view;

import android.content.Context;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class i implements Runnable {
    public final /* synthetic */ Context a;

    public i(Context r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String r0 = this.a.getText(2131888947).toString();     // Catch: Throwable -> L4
        Toast.showFailureText(this.a, r0, 1);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
