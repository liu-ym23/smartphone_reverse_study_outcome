package com.bytedance.crash.npth_repair.monitor;

import android.os.Build;
import com.bytedance.crash.npth_repair.NpthRepair;
import kh4.b;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class SignalMonitor {
    public static SignalMonitor b;
    public int a;

    private native int nDumpSignalMonitor(String r1);

    private native int nStartSignalMonitorWithSigType(int[] r1);

    private native void nStopSignalMonitor();

    public static SignalMonitor b() {
        if (b != null) goto L15;
        monitor-enter(SignalMonitor.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (b != null) goto L9;
        b = new SignalMonitor();     // Catch: Throwable -> L11
    L9:
        monitor-exit(SignalMonitor.class);     // Catch: Throwable -> L11
    L15:
        return b;
    }

    public SignalMonitor() {
        this.a = 1110;
    }

    public final synchronized int a(String r3) {
        monitor-enter(this);
        int r0 = this.a;     // Catch: Throwable -> L16
        if (r0 == 1111) goto L13;
        if (r0 == 1113) goto L13;
        monitor-exit(this);
        return -1;
    L13:
        this.a = 1114;     // Catch: Throwable -> L16
        int r4 = nDumpSignalMonitor(r3);     // Catch: Throwable -> L16
        monitor-exit(this);
        return r4;
    L16:
        th = move-exception;
        throw th;
    }

    public final synchronized int c(b r5) {
        monitor-enter(this);
        int r0 = this.a;     // Catch: Throwable -> L54
        if (r0 == 1110) goto L12;
        if (r0 == 1113) goto L12;
        monitor-exit(this);
        return -2;
    L12:
        boolean r1 = true;
        int r2 = 0;
        if (NpthRepair.c != 0) goto L15;
        boolean r3 = true;
    L16:
        if (r3 == true) goto L20;
        monitor-exit(this);
        return -1;
    L20:
        if (r5 != null) goto L22;
    L27:
        if (r1 == false) goto L47;
        int[] r4 = null;
        if (r5 != null) goto L57;
    L44:
        int r6 = nStartSignalMonitorWithSigType(r4);     // Catch: Throwable -> L46
    L48:
        if (r6 == 0) goto L50;
        this.a = 1112;     // Catch: Throwable -> L54
    L52:
        monitor-exit(this);
        return r6;
    L50:
        this.a = 1111;     // Catch: Throwable -> L54
    L46:
        r6 = -4;
        goto L48
    L57:
        if (r5.c != null) goto L60;
    L36:
        JSONArray r7 = null;
    L37:
        if (r7 == null) goto L44;
        if (r7.length() <= 0) goto L44;
        r4 = new int[r7.length()];     // Catch: Throwable -> L46
    L42:
        if (r2 >= r7.length()) goto L44;
        r4[r2] = r7.optInt(r2);     // Catch: Throwable -> L46
        r2 = r2 + 1;     // Catch: Throwable -> L46
        goto L42
    L60:
        r7 = new JSONArray(r5.c.optString("sigTypes"));     // Catch: JSONException -> L35 Throwable -> L46
    L47:
        r6 = -6;
        goto L48
    L22:
        if (b.a(r5.a, String.valueOf(Build.VERSION.SDK_INT)) == true) goto L24;
    L26:
        r1 = false;
        goto L27
    L24:
        if (b.a(r5.b, Build.BRAND) == false) goto L26;
    L15:
        r3 = false;
    L54:
        th = move-exception;
        throw th;
    }
}
