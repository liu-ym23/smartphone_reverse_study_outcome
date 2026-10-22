package nl3;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(Throwable r3, String r4) {
        if (r3 != null) goto L5;
        if (r4 != null) goto L5;
        return;
    L5:
        if (r3 == null) goto L17;
        Throwable r1 = r3;
    L11:
        if (r4 != null) goto L13;
        r4 = String.valueOf(r3);     // Catch: Throwable -> L7
    L13:
        ECExceptionMonitor.d("yata_sdk_monitor", r1, "yata_sdk_exception:".concat(r4));     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        ECExceptionMonitor.f(th, "yata_sdk_exception:");
        return;
    L17:
        r1 = new Throwable(r4);     // Catch: Throwable -> L7
        goto L11
    }
}
