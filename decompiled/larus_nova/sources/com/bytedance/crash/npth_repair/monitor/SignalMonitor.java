package com.bytedance.crash.npth_repair.monitor;

import android.os.Build;
import com.bytedance.crash.npth_repair.NpthRepair;
import kh4.b;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: loaded from: classes.dex */
public class SignalMonitor {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static SignalMonitor f203321b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f203322a;

    private native int nDumpSignalMonitor(String r100);

    private native int nStartSignalMonitorWithSigType(int[] r100);

    private native void nStopSignalMonitor();

    public static SignalMonitor b() {
        if (f203321b != null) goto L15;
        monitor-enter(SignalMonitor.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f203321b != null) goto L9;
        f203321b = new SignalMonitor();     // Catch: Throwable -> L11
    L9:
        monitor-exit(SignalMonitor.class);     // Catch: Throwable -> L11
    L15:
        return f203321b;
    }

    public SignalMonitor() {
        this.f203322a = 1110;
    }

    public final synchronized int a(String r100) {
        monitor-enter(this);
        int r101 = this.f203322a;     // Catch: Throwable -> L16
        if (r101 == 1111) goto L13;
        if (r101 == 1113) goto L13;
        monitor-exit(this);
        return -1;
    L13:
        this.f203322a = 1114;     // Catch: Throwable -> L16
        int r102 = nDumpSignalMonitor(r100);     // Catch: Throwable -> L16
        monitor-exit(this);
        return r102;
    L16:
        th = move-exception;
        throw th;
    }

    public final synchronized int c(b r100) {
        monitor-enter(this);
        int r101 = this.f203322a;     // Catch: Throwable -> L54
        if (r101 == 1110) goto L12;
        if (r101 == 1113) goto L12;
        monitor-exit(this);
        return -2;
    L12:
        boolean r102 = true;
        int r103 = 0;
        if (NpthRepair.f203320c != 0) goto L15;
        boolean r104 = true;
    L16:
        if (r104 == true) goto L20;
        monitor-exit(this);
        return -1;
    L20:
        if (r100 != null) goto L22;
    L27:
        if (r102 == false) goto L47;
        int[] r105 = null;
        if (r100 != null) goto L57;
    L44:
        int r106 = nStartSignalMonitorWithSigType(r105);     // Catch: Throwable -> L46
    L48:
        if (r106 == 0) goto L50;
        this.f203322a = 1112;     // Catch: Throwable -> L54
    L52:
        monitor-exit(this);
        return r106;
    L50:
        this.f203322a = 1111;     // Catch: Throwable -> L54
    L46:
        r106 = -4;
        goto L48
    L57:
        if (r100.f503460c != null) goto L60;
    L36:
        JSONArray r107 = null;
    L37:
        if (r107 == null) goto L44;
        if (r107.length() <= 0) goto L44;
        r105 = new int[r107.length()];     // Catch: Throwable -> L46
    L42:
        if (r103 >= r107.length()) goto L44;
        r105[r103] = r107.optInt(r103);     // Catch: Throwable -> L46
        r103 = r103 + 1;     // Catch: Throwable -> L46
        goto L42
    L60:
        r107 = new JSONArray(r100.f503460c.optString("sigTypes"));     // Catch: JSONException -> L35 Throwable -> L46
    L47:
        r106 = -6;
        goto L48
    L22:
        if (b.a(r100.f503458a, String.valueOf(Build.VERSION.SDK_INT)) == true) goto L24;
    L26:
        r102 = false;
        goto L27
    L24:
        if (b.a(r100.f503459b, Build.BRAND) == false) goto L26;
    L15:
        r104 = false;
    L54:
        th = move-exception;
        throw th;
    }
}
