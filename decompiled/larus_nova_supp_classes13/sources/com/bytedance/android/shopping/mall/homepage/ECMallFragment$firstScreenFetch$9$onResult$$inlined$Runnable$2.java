package com.bytedance.android.shopping.mall.homepage;

import android.os.Build;
import android.os.Message;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import com.bytedance.android.shopping.mall.homepage.tools.DataEngineWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Lazy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class ECMallFragment$firstScreenFetch$9$onResult$$inlined$Runnable$2 implements Runnable {
    public final /* synthetic */ ECMallFragment$firstScreenFetch$9 a;
    public final /* synthetic */ Runnable b;

    public static final class a implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ ECMallFragment$firstScreenFetch$9$onResult$$inlined$Runnable$2 b;

        public a(String r1, ECMallFragment$firstScreenFetch$9$onResult$$inlined$Runnable$2 r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.b.a.d.e.l(this.a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public ECMallFragment$firstScreenFetch$9$onResult$$inlined$Runnable$2(ECMallFragment$firstScreenFetch$9 r1, ECMallFragment$firstScreenFetch$9$onResult$$inlined$Runnable$1 r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        int r0 = s93.c.a;
        Object r1 = 0;
        IHybridHostService r2 = com.bytedance.android.ec.hybrid.a.h();
        if (r2 == null) goto L10;
        yj.g r3 = r2.getHostAB();
        if (r3 == null) goto L10;
        Object r4 = r3.a("ec_mall_first_screen_render_opt", r1);
        if (r4 == null) goto L10;
        r1 = r4;
    L10:
        Lazy r5 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.c.a.b, "Key : ec_mall_first_screen_render_opt, Value: " + r1);
        if (((Number) r1).intValue() != 1) goto L16;
        Message r6 = Message.obtain(this.a.d.P1, this.b);
        if (Build.VERSION.SDK_INT < 22) goto L15;
        r6.setAsynchronous(true);
    L15:
        this.a.d.P1.sendMessageAtFrontOfQueue(r6);
        return;
    L16:
        final long r7 = System.currentTimeMillis();
        this.a.d.P1.postAtFrontOfQueue(this.b);
        DataEngineWrapper r8 = this.a.d.L0;
        if (r8 == null) goto L20;
        r8.L(new ECMallFragment$firstScreenFetch$9$onResult$$inlined$Runnable$2$lambda$1(r7));
    L20:
        if (this.a.d.N == null) goto L22;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.k.e.b, "PopupRenderOpt, invoke in postFirstScreenDataRunnable, timestamp = " + System.currentTimeMillis());
    L22:
        Runnable r9 = this.a.d.N;
        if (r9 == null) goto L26;
        r9.run();
    L26:
        if (this.a.d.Ca0() == true) goto L28;
        return;
    L28:
        if (this.a.b == false) goto L41;
        ECMallFragment$firstScreenFetch$9 r10 = this.a;
        final String r11 = r10.a;
        if (r11 != null) goto L33;
        return;
    L33:
        if (r10.d.na0() == null) goto L35;
        this.a.d.P1.postAtFrontOfQueue(new a(r11, this));
    L36:
        this.a.b = false;
        return;
    L35:
        this.a.d.X = new ECMallFragment$firstScreenFetch$9$onResult$$inlined$Runnable$2$lambda$3(r11, this);
        goto L36
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
