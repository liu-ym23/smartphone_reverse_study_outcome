package nl3;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;

/* JADX INFO: loaded from: classes14.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f519545a = 0;

    static {
    }

    public static void a(Throwable r100, String r101) {
        if (r100 != null) goto L5;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r100 == null) goto L17;
        Throwable r102 = r100;
    L11:
        if (r101 != null) goto L13;
        r101 = String.valueOf(r100);     // Catch: Throwable -> L7
    L13:
        ECExceptionMonitor.d("yata_sdk_monitor", r102, "yata_sdk_exception:".concat(r101));     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        ECExceptionMonitor.f(th, "yata_sdk_exception:");
        return;
    L17:
        r102 = new Throwable(r101);     // Catch: Throwable -> L7
        goto L11
    }
}
