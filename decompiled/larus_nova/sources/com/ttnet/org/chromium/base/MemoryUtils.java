package com.ttnet.org.chromium.base;

import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import java.io.BufferedReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes41.dex */
public class MemoryUtils {
    private static String TAG;
    private static boolean sInitialized;
    private static String sMemoryInfoPath;
    private static final Object sMemoryLock = null;
    private static String sTotalMemoryGB;

    public MemoryUtils() {
    }

    static {
        TAG = "MemoryUtils";
        sMemoryInfoPath = "/proc/meminfo";
        sTotalMemoryGB = "unknown";
        sMemoryLock = new Object();
    }

    private static void fetchTotalMemory() {
        Pattern r100 = PatternProtector.compile("^MemTotal:\\s+([0-9]+) kB$");
        BufferedReader r101 = null;
        long r102 = 0;
        PolarisFileReaderWrapper r103 = new PolarisFileReaderWrapper(sMemoryInfoPath);     // Catch: Throwable -> L32 Exception -> L34
        BufferedReader r104 = new BufferedReader(r103);     // Catch: Exception -> L65 Throwable -> L49
    L82:
        String r105 = r104.readLine();     // Catch: Throwable -> L29 Exception -> L31
        if (r105 == null) goto L67;
        Matcher r106 = r100.matcher(r105);     // Catch: Throwable -> L29 Exception -> L31
        if (r106.find() == false) goto L82;
        long r110 = Long.parseLong(r106.group(1));     // Catch: Throwable -> L29 Exception -> L31
    L12:
        if (r110 <= 1024) goto L86;
        r102 = r110;
        goto L67
    L86:
    L17:
        r101 = r104;
        r102 = r110;
    L15:
        th = th;
        r101 = r104;
        r102 = r110;
    L50:
        if (r101 != null) goto L71;
    L52:
        if (r103 == null) goto L54;
        r103.close();     // Catch: Exception -> L63
    L54:
        Object r107 = sMemoryLock;
        monitor-enter(r107);
        sTotalMemoryGB = String.valueOf((int) Math.ceil((r102 * 1.0d) / 1048576.0d));     // Catch: Throwable -> L60
        monitor-exit(r107);     // Catch: Throwable -> L60
        throw th;
    L60:
        th = move-exception;
        throw th;
    L71:
        r101.close();     // Catch: Exception -> L63
    L67:
        r104.close();     // Catch: Exception -> L64
        r103.close();     // Catch: Exception -> L64
    L20:
        Object r108 = sMemoryLock;
        monitor-enter(r108);
        sTotalMemoryGB = String.valueOf((int) Math.ceil((r102 * 1.0d) / 1048576.0d));     // Catch: Throwable -> L26
        monitor-exit(r108);     // Catch: Throwable -> L26
        return;
    L26:
        th = move-exception;
        throw th;
    L31:
        r101 = r104;
    L29:
        th = th;
        r101 = r104;
    L49:
        th = th;
    L35:
        if (r101 != null) goto L75;
    L38:
        if (r103 == null) goto L40;
        r103.close();     // Catch: Exception -> L66
    L40:
        Object r109 = sMemoryLock;
        monitor-enter(r109);
        sTotalMemoryGB = String.valueOf((int) Math.ceil((r102 * 1.0d) / 1048576.0d));     // Catch: Throwable -> L46
        monitor-exit(r109);     // Catch: Throwable -> L46
        return;
    L46:
        th = move-exception;
        throw th;
    L75:
        r101.close();     // Catch: Exception -> L66
        goto L38
    L34:
        r103 = null;
    L32:
        th = th;
        r103 = null;
        goto L50
    }

    public static String getTotalMemoryGB() {
        Object r100 = sMemoryLock;
        monitor-enter(r100);
        String r101 = sTotalMemoryGB;     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    public static boolean initialize() {
        if (sInitialized == false) goto L5;
        return true;
    L5:
        fetchTotalMemory();
        sInitialized = true;
        return true;
    }
}
