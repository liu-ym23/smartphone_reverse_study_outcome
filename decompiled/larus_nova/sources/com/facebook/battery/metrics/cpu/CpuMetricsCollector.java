package com.facebook.battery.metrics.cpu;

import android.os.StrictMode;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.facebook.battery.metrics.core.SystemMetrics;
import com.facebook.battery.metrics.core.SystemMetricsCollector;
import com.facebook.battery.metrics.core.SystemMetricsLogger;
import com.facebook.battery.metrics.core.Utilities;
import java.io.BufferedReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes22.dex */
public class CpuMetricsCollector extends SystemMetricsCollector<CpuMetrics> {
    protected static final long DEFAULT_CLOCK_TICKS_PER_SECOND = 100;
    private static final int PROC_CHILD_SYSTEM_TIME_FIELD = 16;
    private static final int PROC_CHILD_USER_TIME_FIELD = 15;
    private static final String PROC_STAT_FILE_PATH = "/proc/self/stat";
    private static final int PROC_SYSTEM_TIME_FIELD = 14;
    private static final int PROC_USER_TIME_FIELD = 13;
    private static final String TAG = "CpuMetricsCollector";
    private final ThreadLocal<CpuMetrics> mLastSnapshot;

    public static class Initializer {
        static final long CLOCK_TICKS_PER_SECOND = 0;

        private Initializer() {
        }

        static {
            CLOCK_TICKS_PER_SECOND = Sysconf.getScClkTck(100);
        }
    }

    @Override // com.facebook.battery.metrics.core.SystemMetricsCollector
    public CpuMetrics createMetrics() {
        return new CpuMetrics();
    }

    public CpuMetricsCollector() {
        this.mLastSnapshot = new ThreadLocal();
    }

    public String readProcFile() {
        StrictMode.ThreadPolicy r100 = StrictMode.allowThreadDiskReads();
        BufferedReader r101 = new BufferedReader(new PolarisFileReaderWrapper(PROC_STAT_FILE_PATH), 1024);     // Catch: Throwable -> L11 IOException -> L17
    L33:
        String r102 = r101.readLine();     // Catch: Throwable -> L8 IOException -> L10
        r101.close();     // Catch: IOException -> L22
    L6:
        StrictMode.setThreadPolicy(r100);
        return r102;
    L8:
        Throwable th10 = th;
    L13:
        if (r101 != null) goto L29;
    L15:
        StrictMode.setThreadPolicy(r100);
        throw th10;
    L29:
        r101.close();     // Catch: IOException -> L23
    L18:
        if (r101 != null) goto L27;
    L20:
        StrictMode.setThreadPolicy(r100);
        return null;
    L27:
        r101.close();     // Catch: IOException -> L24
    L17:
        r101 = null;
    L11:
        th = move-exception;
        r101 = null;
        th10 = th;
        goto L13
    }

    public static long getClockTicksPerSecond() {
        return Initializer.CLOCK_TICKS_PER_SECOND;
    }

    @Override // com.facebook.battery.metrics.core.SystemMetricsCollector
    public /* bridge */ /* synthetic */ SystemMetrics createMetrics() {
        return createMetrics();
    }

    private static double readFieldAsS(String r100) throws NumberFormatException {
        return (Long.parseLong(r100) * 1.0d) / getClockTicksPerSecond();
    }

    public boolean getSnapshot(CpuMetrics r100) {
        Utilities.checkNotNull(r100, "Null value passed to getSnapshot!");
        String r101 = readProcFile();
        if (r101 == null) goto L5;
        String[] r102 = r101.split(" ", 18);
    L7:
        if (r102 != null) goto L9;
    L31:
        return false;
    L9:
        if (r102.length < 17) goto L31;
        r100.userTimeS = readFieldAsS(r102[13]);     // Catch: NumberFormatException -> L29
        r100.systemTimeS = readFieldAsS(r102[14]);     // Catch: NumberFormatException -> L29
        r100.childUserTimeS = readFieldAsS(r102[15]);     // Catch: NumberFormatException -> L29
        r100.childSystemTimeS = readFieldAsS(r102[16]);     // Catch: NumberFormatException -> L29
        if (this.mLastSnapshot.get() != null) goto L16;
        this.mLastSnapshot.set(new CpuMetrics());
    L16:
        CpuMetrics r103 = this.mLastSnapshot.get();
        if (Double.compare(r100.userTimeS, r103.userTimeS) >= 0) goto L19;
    L27:
        SystemMetricsLogger.wtf(TAG, "Cpu Time Decreased from " + r103.toString() + " to " + r100.toString());
        return false;
    L19:
        if (Double.compare(r100.systemTimeS, r103.systemTimeS) < 0) goto L27;
        if (Double.compare(r100.childUserTimeS, r103.childUserTimeS) < 0) goto L27;
        if (Double.compare(r100.childSystemTimeS, r103.childSystemTimeS) < 0) goto L27;
        r103.set(r100);
        return true;
    L29:
        e = move-exception;
        SystemMetricsLogger.wtf(TAG, "Unable to parse CPU time field", e);
        goto L31
    L5:
        r102 = null;
        goto L7
    }

    @Override // com.facebook.battery.metrics.core.SystemMetricsCollector
    public /* bridge */ /* synthetic */ boolean getSnapshot(SystemMetrics r100) {
        return getSnapshot((CpuMetrics) r100);
    }
}
