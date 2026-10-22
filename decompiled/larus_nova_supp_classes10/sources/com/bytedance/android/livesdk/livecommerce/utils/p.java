package com.bytedance.android.livesdk.livecommerce.utils;

import com.bytedance.android.ec.core.utils.ECLiveEntranceMonitor;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class p {
    public static boolean a;
    public static boolean b;
    public static String c;
    public static boolean d;
    public static final a e = null;

    public static final class a implements Runnable {
        public a() {
        }

        public static void a() {
            if (p.a == true) goto L5;
            ECLiveEntranceMonitor.trace("Cart not visible; isAnchor=" + p.d + " isFirstLoad=" + p.b, "ECLiveCartStateChecker", true);
            new com.bytedance.android.livesdk.livecommerce.event.p(p.d, p.b, p.c).k();
            return;
        L5:
            new com.bytedance.android.livesdk.livecommerce.event.q(p.d, p.b).k();
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

    static {
        b = true;
        e = new a();
    }
}
