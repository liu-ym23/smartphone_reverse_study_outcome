package com.bytedance.android.shopping.mall.homepage;

import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Lazy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class ECMallFragment$firstScreenFetch$9$onResult$1 implements Runnable {
    public volatile boolean a;
    public final /* synthetic */ ECMallFragment$firstScreenFetch$9 b;
    public final /* synthetic */ String c;

    public static final class a implements Runnable {
        public final /* synthetic */ ECMallFragment$firstScreenFetch$9$onResult$1 a;

        public a(ECMallFragment$firstScreenFetch$9$onResult$1 r1) {
            this.a = r1;
        }

        public final void a() {
            if (this.a.a == false) goto L5;
            return;
        L5:
            Lazy r0 = ECMallLogUtil.a;
            com.bytedance.android.ec.hybrid.log.mall.k.e r1 = com.bytedance.android.ec.hybrid.log.mall.k.e.b;
            ECMallLogUtil.c(r1, "PopupRenderOpt, render popup start with post, timestamp = " + System.currentTimeMillis());
            this.a.a = true;
            this.a.b.d.N = null;
            this.a.b.b = false;
            ECMallFragment$firstScreenFetch$9$onResult$1 r2 = this.a;
            r2.b.d.e.l(r2.c);
            ECMallLogUtil.c(r1, "PopupRenderOpt, render popup end with post, timestamp = " + System.currentTimeMillis());
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

    public final void a() {
        Lazy r0 = ECMallLogUtil.a;
        com.bytedance.android.ec.hybrid.log.mall.k.e r1 = com.bytedance.android.ec.hybrid.log.mall.k.e.b;
        ECMallLogUtil.c(r1, "PopupRenderOpt, renderPopupRunnable#run(), timestamp = " + System.currentTimeMillis());
        ECMallFragment r2 = this.b.d;
        int r3 = ECMallFragment.h4;
        if (r2.na0() == null) goto L6;
        this.b.d.P1.postAtFrontOfQueue(new a(this));
        return;
    L6:
        if (this.a == false) goto L8;
        return;
    L8:
        ECMallLogUtil.c(r1, "PopupRenderOpt, render popup start with callback, timestamp = " + System.currentTimeMillis());
        this.a = true;
        this.b.d.N = null;
        this.b.b = false;
        this.b.d.X = new ECMallFragment$firstScreenFetch$9$onResult$1$run$2(this);
        ECMallLogUtil.c(r1, "PopupRenderOpt, render popup end with callback, timestamp = " + System.currentTimeMillis());
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

    public ECMallFragment$firstScreenFetch$9$onResult$1(ECMallFragment$firstScreenFetch$9 r1, String r2) {
        this.b = r1;
        this.c = r2;
    }
}
