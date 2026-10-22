package com.bytedance.android.tools.superkv;

import android.os.Process;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b {
    public static boolean a;
    public static j b;

    public static class a implements j {
        public a() {
        }

        @Override // com.bytedance.android.tools.superkv.j
        public final void onLog(int r1, String r2) {
            if (r1 != 1) goto L5;
            boolean r3 = b.a;
            return;
        L5:
            if (r1 != 2) goto L7;
            boolean r4 = b.a;
            return;
        L7:
            if (r1 == 3) goto L9;
            boolean r5 = b.a;
            return;
        L9:
            boolean r6 = b.a;
        }

        @Override // com.bytedance.android.tools.superkv.j
        public final void onLog(int r1, String r2, Throwable r3) {
            boolean r4 = b.a;
        }
    }

    static {
        Process.myPid();
        a = false;
        b = new a();
    }

    public static void a(String r2) {
        b.onLog(3, c(r2));
    }

    public static String c(String r2) {
        return "@Thread: {" + Process.myPid() + "," + ThreadMethodProxy.currentThread().getName() + "}, msg: " + r2;
    }

    public static void e(Throwable r1) {
        if (a == true) goto L11;
        if (r1.getMessage() != null) goto L7;
        String r0 = "No message.";
    L8:
        b(r0, r1);
        return;
    L7:
        r0 = r1.getMessage();
        goto L8
    L11:
        throw new KVException(r1);
    }

    public static void b(String r2, Throwable r3) {
        b.onLog(3, c(r2), r3);
    }

    public static void d(String r1, Throwable r2) {
        if (a == true) goto L7;
        b(r1, r2);
        return;
    L7:
        throw new KVException(r1, r2);
    }
}
