package com.bytedance.ee.bear.list.office.preload;

import android.content.Context;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c implements Runnable {
    public final /* synthetic */ Context a;
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;

    public c(Context r1, int r2, int r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Toast.showText(this.a, "OfficeSpace DB preload success: tabs=" + this.b + ", size=" + this.c);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
