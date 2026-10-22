package com.bytedance.android.shopping.mall.feed;

import com.bytedance.android.ec.hybrid.list.ECHybridListEngine;
import com.bytedance.android.ec.hybrid.list.view.ECHybridRecyclerView;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class j0 implements Runnable {
    public final /* synthetic */ ECMallFeed a;

    public static final class a implements Runnable {
        public final /* synthetic */ j0 a;

        public a(j0 r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Iterator r0 = ((ArrayList) this.a.a.k1).iterator();     // Catch: Throwable -> L7
        L4:
            if (r0.hasNext() == false) goto L16;
            ((e93.e) r0.next()).onRefreshEnd();     // Catch: Throwable -> L7
            goto L4
        L16:
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L11;
            return;
        L11:
            throw th;
        }
    }

    public j0(ECMallFeed r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ECHybridListEngine r0 = this.a.J;     // Catch: Throwable -> L15
        if (r0 == null) goto L7;
        ECHybridRecyclerView r1 = r0.b;     // Catch: Throwable -> L15
        if (r1 == null) goto L7;
        r1.m0();     // Catch: Throwable -> L15
    L7:
        ECMallFeed r2 = this.a;     // Catch: Throwable -> L15
        if (r2.p0 == false) goto L18;
        ECHybridListEngine r3 = r2.J;     // Catch: Throwable -> L15
        if (r3 == null) goto L22;
        ECHybridRecyclerView r4 = r3.b;     // Catch: Throwable -> L15
        if (r4 == null) goto L23;
        r4.post(new a(this));     // Catch: Throwable -> L15
        return;
    L23:
        return;
    L22:
        return;
    L18:
        return;
    L15:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L24;
        throw th;
    }
}
