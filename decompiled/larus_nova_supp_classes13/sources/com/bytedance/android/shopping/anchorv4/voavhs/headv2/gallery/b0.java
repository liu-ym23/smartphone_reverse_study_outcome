package com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery;

import androidx.recyclerview.widget.RecyclerView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b0 implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ t b;

    public b0(int r1, t r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        t r0 = this.b;     // Catch: Throwable -> L6
        RecyclerView r1 = r0.b;     // Catch: Throwable -> L6
        if (r1 == null) goto L9;
        t.b(r0, this.a, r1);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
