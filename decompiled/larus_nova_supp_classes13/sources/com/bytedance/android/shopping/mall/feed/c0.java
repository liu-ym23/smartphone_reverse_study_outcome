package com.bytedance.android.shopping.mall.feed;

import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import com.bytedance.android.shopping.mall.homepage.tools.DataEngineWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Lazy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c0 extends com.bytedance.android.shopping.api.mall.common.tools.o {
    public final /* synthetic */ ECMallFeed c;

    public static final class a implements Runnable {
        public final /* synthetic */ c0 a;

        public a(c0 r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Lazy r0 = ECMallLogUtil.a;     // Catch: Throwable -> L7
            ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.m.b.b, "gecko update failed");     // Catch: Throwable -> L7
            ECMallFeed r1 = this.a.c;     // Catch: Throwable -> L7
            if (r1.H == true) goto L10;
            r1.G();     // Catch: Throwable -> L7
            return;
        L10:
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L14;
            throw th;
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ c0 a;

        public b(c0 r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Lazy r0 = ECMallLogUtil.a;     // Catch: Throwable -> L7
            ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.m.b.b, "gecko update success");     // Catch: Throwable -> L7
            ECMallFeed r1 = this.a.c;     // Catch: Throwable -> L7
            if (r1.H == true) goto L10;
            r1.G();     // Catch: Throwable -> L7
            return;
        L10:
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L14;
            throw th;
        }
    }

    @Override // com.bytedance.android.shopping.api.mall.common.tools.o
    public final void a() {
        DataEngineWrapper r0 = this.c.C1;
        if (r0 == null) goto L7;
        y93.a r1 = r0.b;
        if (r1 == null) goto L7;
        Long r2 = r1.e();
    L8:
        if (r2 != null) goto L12;
        DataEngineWrapper r3 = this.c.C1;
        if (r3 == null) goto L12;
        r3.l(System.currentTimeMillis(), 2);
    L12:
        this.c.i.post(new a(this));
        return;
    L7:
        r2 = null;
        goto L8
    }

    @Override // com.bytedance.android.shopping.api.mall.common.tools.o
    public final void b() {
        DataEngineWrapper r0 = this.c.C1;
        if (r0 == null) goto L7;
        y93.a r1 = r0.b;
        if (r1 == null) goto L7;
        Long r2 = r1.e();
    L8:
        if (r2 != null) goto L12;
        DataEngineWrapper r3 = this.c.C1;
        if (r3 == null) goto L12;
        r3.l(System.currentTimeMillis(), 1);
    L12:
        this.c.i.post(new b(this));
        return;
    L7:
        r2 = null;
        goto L8
    }

    public c0(ECMallFeed r1, String r2, String r3) {
        this.c = r1;
        super(r2, r3);
    }
}
