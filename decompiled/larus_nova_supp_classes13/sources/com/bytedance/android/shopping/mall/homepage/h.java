package com.bytedance.android.shopping.mall.homepage;

import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import com.bytedance.android.shopping.mall.homepage.tools.DataEngineWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Lazy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class h extends com.bytedance.android.shopping.api.mall.common.tools.o {
    public final /* synthetic */ ECMallFragment c;

    public static final class a implements Runnable {
        public final /* synthetic */ h a;

        public a(h r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Lazy r0 = ECMallLogUtil.a;     // Catch: Throwable -> L7
            ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.m.b.b, "gecko update failed");     // Catch: Throwable -> L7
            ECMallFragment r1 = this.a.c;     // Catch: Throwable -> L7
            if (r1.g2 == true) goto L10;
            r1.ta0();     // Catch: Throwable -> L7
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
        public final /* synthetic */ h a;

        public b(h r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Lazy r0 = ECMallLogUtil.a;     // Catch: Throwable -> L7
            ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.m.b.b, "gecko update success");     // Catch: Throwable -> L7
            ECMallFragment r1 = this.a.c;     // Catch: Throwable -> L7
            if (r1.g2 == true) goto L10;
            r1.ta0();     // Catch: Throwable -> L7
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
        DataEngineWrapper r0 = this.c.L0;
        if (r0 == null) goto L5;
        r0.l(System.currentTimeMillis(), 2);
    L5:
        this.c.Q1.post(new a(this));
    }

    @Override // com.bytedance.android.shopping.api.mall.common.tools.o
    public final void b() {
        DataEngineWrapper r0 = this.c.L0;
        if (r0 == null) goto L5;
        r0.l(System.currentTimeMillis(), 1);
    L5:
        this.c.Q1.post(new b(this));
    }

    public h(ECMallFragment r1, String r2, String r3) {
        this.c = r1;
        super(r2, r3);
    }
}
