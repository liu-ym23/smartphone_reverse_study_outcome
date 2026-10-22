package com.bytedance.common.jato.boost;

import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import java.io.BufferedReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes3.dex */
public class CpuFreqFetcher {
    private static int[] bigCoreNum = null;
    private static TreeMap<Long, LinkedList<Integer>> coreMap = null;
    private static volatile boolean sIsFetched = false;
    private static volatile boolean sIsWorked = false;
    private static long sMaxFreq = -1;
    private static int[] smallCoreNum;

    static {
        coreMap = new TreeMap();
        sIsFetched = false;
        sIsWorked = false;
    }

    public static synchronized boolean fetch() {
        monitor-enter(CpuFreqFetcher.class);
    L99:
        th = move-exception;
        throw th;
    L5:
        if (sIsFetched == false) goto L9;
        boolean r100 = sIsWorked;     // Catch: Throwable -> L99
        monitor-exit(CpuFreqFetcher.class);
        return r100;
    L9:
        boolean r101 = false;
        int r102 = 0;
        BufferedReader r103 = new BufferedReader(new PolarisFileReaderWrapper("/proc/cpuinfo"), 50);     // Catch: Throwable -> L90
        int r104 = 0;
    L110:
        String r105 = r103.readLine();     // Catch: Throwable -> L88
        if (r105 == null) goto L17;
        if (r105.startsWith("processor") == false) goto L110;
        r104 = r104 + 1;
        goto L110
    L17:
        r103.close();     // Catch: Throwable -> L103
        int r106 = 0;
        int r107 = 0;
    L19:
        if (r106 >= r104) goto L39;
        BufferedReader r108 = new BufferedReader(new PolarisFileReaderWrapper("/sys/devices/system/cpu/cpu" + r106 + "/cpufreq/scaling_available_frequencies"), 5);     // Catch: Throwable -> L30 Exception -> L102
        goto L33
    L114:
        String r109 = r108.readLine();     // Catch: Throwable -> L27 Exception -> L29
        String r110 = r109.substring(0, r109.length() - 1);     // Catch: Throwable -> L27 Exception -> L29
        r107 = r107 + 1;     // Catch: Throwable -> L27 Exception -> L29
        long r111 = Math.max(Long.parseLong(r110.substring(r110.lastIndexOf(" ") + 1)), Long.parseLong(r110.substring(0, r110.indexOf(" "))));     // Catch: Throwable -> L27 Exception -> L29
        sMaxFreq = Math.max(sMaxFreq, r111);     // Catch: Throwable -> L27 Exception -> L29
        LinkedList<Integer> r112 = coreMap.get(Long.valueOf(r111));     // Catch: Throwable -> L27 Exception -> L29
        if (r112 != null) goto L24;
        r112 = new LinkedList();     // Catch: Throwable -> L27 Exception -> L29
        coreMap.put(Long.valueOf(r111), r112);     // Catch: Throwable -> L27 Exception -> L29
    L24:
        r112.add(Integer.valueOf(r106));     // Catch: Throwable -> L27 Exception -> L29
        r108.close();     // Catch: Throwable -> L103
        r103 = r108;
    L34:
        r106 = r106 + 1;     // Catch: Throwable -> L103
        goto L19
    L29:
        r103 = r108;
    L27:
        th = th;
        r103 = r108;
    L35:
        r103.close();     // Catch: Throwable -> L103
        throw th;     // Catch: Throwable -> L103
    L30:
        th = th;
    L33:
        r103.close();     // Catch: Throwable -> L103
        goto L34
    L39:
        if (r107 >= 4) goto L43;
        sIsWorked = false;     // Catch: Throwable -> L99
        sIsFetched = true;     // Catch: Throwable -> L99
        monitor-exit(CpuFreqFetcher.class);
        return false;
    L43:
        LinkedList r113 = new LinkedList();     // Catch: Throwable -> L103
        LinkedList r114 = new LinkedList();     // Catch: Throwable -> L103
        if (r107 != 4) goto L58;
        Iterator<LinkedList<Integer>> r115 = coreMap.values().iterator();     // Catch: Throwable -> L87
        boolean r116 = true;
    L48:
        if (r115.hasNext() == false) goto L57;
        LinkedList<Integer> r117 = r115.next();     // Catch: Throwable -> L87
        if (r116 == true) goto L52;
        r114.addAll(r117);     // Catch: Throwable -> L87
    L56:
        r116 = false;
        goto L48
    L52:
        if (r117.size() != 2) goto L54;
        r113.addAll(r117);     // Catch: Throwable -> L87
    L54:
        boolean r118 = false;
    L106:
    L86:
        r101 = r118;
        goto L95
    L74:
        if (r118 == false) goto L84;
        smallCoreNum = new int[r113.size()];     // Catch: Throwable -> L86
        int r119 = 0;
    L77:
        if (r119 >= r113.size()) goto L79;
        smallCoreNum[r119] = ((Integer) r113.get(r119)).intValue();     // Catch: Throwable -> L86
        r119 = r119 + 1;     // Catch: Throwable -> L86
        goto L77
    L79:
        bigCoreNum = new int[r114.size()];     // Catch: Throwable -> L86
    L80:
        if (r102 >= r114.size()) goto L84;
        bigCoreNum[r102] = ((Integer) r114.get(r102)).intValue();     // Catch: Throwable -> L86
        r102 = r102 + 1;
    L84:
        sIsWorked = r118;     // Catch: Throwable -> L99
        sIsFetched = true;     // Catch: Throwable -> L99
    L97:
        monitor-exit(CpuFreqFetcher.class);
        return r118;
    L57:
        r118 = true;
        goto L106
    L58:
        Iterator<LinkedList<Integer>> r120 = coreMap.values().iterator();     // Catch: Throwable -> L87
        int r121 = r107 / 2;     // Catch: Throwable -> L87
        boolean r122 = true;
    L60:
        if (r120.hasNext() == false) goto L69;
        LinkedList<Integer> r123 = r120.next();     // Catch: Throwable -> L87
        if (r122 == false) goto L64;
        r113.addAll(r123);     // Catch: Throwable -> L87
    L66:
        if (r113.size() < r121) goto L60;
        r122 = false;
        goto L60
    L64:
        r114.addAll(r123);     // Catch: Throwable -> L87
        goto L66
    L69:
        if (r113.size() <= 2) goto L54;
        if (r114.size() > 2) goto L57;
    L87:
        r101 = true;
    L88:
        Throwable th10 = th;
    L92:
        if (r103 == null) goto L94;
        r103.close();     // Catch: Throwable -> L103
    L94:
        throw th10;     // Catch: Throwable -> L103
    L90:
        th = move-exception;
        r103 = null;
        th10 = th;
    L95:
        sIsWorked = r101;     // Catch: Throwable -> L99
        sIsFetched = true;     // Catch: Throwable -> L99
        r118 = r101;
        goto L97
    }

    public static int[] getBigCoreNum() {
        return bigCoreNum;
    }

    public static int[] getSmallCoreNum() {
        return smallCoreNum;
    }
}
