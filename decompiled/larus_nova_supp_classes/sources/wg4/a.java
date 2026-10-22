package wg4;

import com.bytedance.crash.CrashType;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class a {
    public static b a;
    public static final HashMap<String, a> b = null;

    public static class b {
        public final PolarisFileWrapper a;
        public final c b;
        public final d c;

        public b(String r2, c r3, d r4) {
            this.a = new PolarisFileWrapper(r2);
            this.b = r3;
            this.c = r4;
        }
    }

    static {
        b = new HashMap();
    }

    public static boolean a() {
        if (a == null) goto L5;
        return true;
    L5:
        return false;
    }

    public static void b(String r2, long r3, long r5, CrashType r7) {
        HashMap<String, a> r0 = b;
        monitor-enter(r0);
        a r1 = r0.get(r2 + r3);     // Catch: Throwable -> L12
        if (r1 != null) goto L7;
        r0.put(r2 + r3, new a(r2, r5, r7));     // Catch: Throwable -> L12
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L7:
        ((ArrayList) r1.b).add(Long.valueOf(r5));     // Catch: Throwable -> L12
        if (r7 != CrashType.LAUNCH) goto L10;
        r1.c = true;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }
}
