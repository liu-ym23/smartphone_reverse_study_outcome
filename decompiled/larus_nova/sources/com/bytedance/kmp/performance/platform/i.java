package com.bytedance.kmp.performance.platform;

import android.os.Process;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.BufferedReader;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes19.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Integer> f252787a = null;

    static {
        f252787a = new ConcurrentHashMap();
    }

    public static final x a() {
        BufferedReader r100 = new BufferedReader(new PolarisFileReaderWrapper("/proc/" + Process.myPid() + "/stat"));     // Catch: Exception -> L38
        String r101 = r100.readLine();     // Catch: Throwable -> L33
        if (r101 != null) goto L9;
        x r102 = new x(0, 0, 0, 0);     // Catch: Throwable -> L33
        CloseableKt.closeFinally(r100, null);     // Catch: Exception -> L38
        return r102;
    L9:
        List<String> r103 = new Regex("\\s+").split(r101, 0);     // Catch: Throwable -> L33
        if (r103.size() < 24) goto L30;
        Long r104 = StringsKt.toLongOrNull(r103.get(13));     // Catch: Throwable -> L33
        if (r104 == null) goto L14;
        long r105 = r104.longValue();     // Catch: Throwable -> L33
    L15:
        Long r106 = StringsKt.toLongOrNull(r103.get(14));     // Catch: Throwable -> L33
        if (r106 == null) goto L18;
        long r107 = r106.longValue();     // Catch: Throwable -> L33
    L19:
        Long r108 = StringsKt.toLongOrNull(r103.get(15));     // Catch: Throwable -> L33
        if (r108 == null) goto L22;
        long r110 = r108.longValue();     // Catch: Throwable -> L33
    L23:
        Long r109 = StringsKt.toLongOrNull(r103.get(16));     // Catch: Throwable -> L33
        if (r109 == null) goto L26;
        long r111 = r109.longValue();     // Catch: Throwable -> L33
    L27:
        x r112 = new x(r105, r107, r110, r111);     // Catch: Throwable -> L33
        CloseableKt.closeFinally(r100, null);     // Catch: Exception -> L38
        return r112;
    L26:
        r111 = 0;
        goto L27
    L22:
        r110 = 0;
        goto L23
    L18:
        r107 = 0;
        goto L19
    L14:
        r105 = 0;
        goto L15
    L30:
        x r113 = new x(0, 0, 0, 0);     // Catch: Throwable -> L33
        CloseableKt.closeFinally(r100, null);     // Catch: Exception -> L38
        return r113;
    L33:
        th = move-exception;
        throw th;     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        CloseableKt.closeFinally(r100, th);     // Catch: Exception -> L38
        throw th;     // Catch: Exception -> L38
    L39:
        return new x(0, 0, 0, 0);
    }

    public static final j b() {
        PolarisFileWrapper r100 = new PolarisFileWrapper("/sys/devices/system/cpu/cpufreq");     // Catch: Exception -> L78
        if (r100.exists() == false) goto L113;
        if (r100.isDirectory() == false) goto L113;
        File[] r101 = r100.listFiles();     // Catch: Exception -> L78
        if (r101 == null) goto L112;
        int r102 = 1;
        int r103 = 0;
        if (r101.length != 0) goto L12;
        boolean r104 = true;
    L13:
        if (r104 == true) goto L112;
        Iterator r105 = ArrayIteratorKt.iterator(r101);     // Catch: Exception -> L78
        long r106 = 0;
        long r110 = 0;
    L17:
        if (r105.hasNext() == false) goto L74;
        File r107 = (File) r105.next();     // Catch: Exception -> L78
        if (r107 == null) goto L17;
        ConcurrentHashMap<String, Integer> r108 = f252787a;     // Catch: Exception -> L78
        if (r108.get(r107.getName()) != null) goto L44;
        PolarisFileWrapper r109 = new PolarisFileWrapper(r107, "affected_cpus");     // Catch: Exception -> L78
        if (r109.exists() == false) goto L17;
        BufferedReader r111 = new BufferedReader(new PolarisFileReaderWrapper(r109), 50);     // Catch: Exception -> L78
        String r112 = r111.readLine();     // Catch: Throwable -> L37
        if (r112 == null) goto L32;
        int r113 = StringsKt.split$default(r112, new String[]{" "}, false, 0, 6, null).size();     // Catch: Throwable -> L37
        if (r113 <= 0) goto L33;
        r108.put(r107.getName(), Integer.valueOf(r113));     // Catch: Throwable -> L37
    L33:
        Unit r114 = Unit.INSTANCE;     // Catch: Throwable -> L37
        CloseableKt.closeFinally(r111, null);     // Catch: Exception -> L78
        if (r113 == 0) goto L17;
    L45:
        PolarisFileWrapper r115 = new PolarisFileWrapper(r107, "stats/time_in_state");     // Catch: Exception -> L78
        if (r115.exists() == false) goto L17;
        BufferedReader r116 = new BufferedReader(new PolarisFileReaderWrapper(r115), 50);     // Catch: Exception -> L78
    L87:
        String r117 = r116.readLine();     // Catch: Throwable -> L67
        if (r117 == null) goto L64;
        if (r117.length() != 0) goto L54;
        boolean r118 = true;
    L55:
        if (r118 == true) goto L64;
        Intrinsics.checkNotNull(r117);     // Catch: Throwable -> L67
        List<String> r119 = new Regex("\\s+").split(r117, r103);     // Catch: Throwable -> L67
        if (r119.size() != 2) goto L87;
        long r120 = Long.parseLong(r119.get(r103));     // Catch: Throwable -> L67
        long r121 = Long.parseLong(r119.get(r102)) * ((long) r113);     // Catch: Throwable -> L67
        r106 = r106 + r121;     // Catch: Throwable -> L67
        if (r120 > 300000) goto L63;
        r110 = r110 + r121;     // Catch: Throwable -> L67
    L63:
        r102 = 1;
        r103 = 0;
        goto L87
    L54:
        r118 = false;
    L64:
        Unit r122 = Unit.INSTANCE;     // Catch: Throwable -> L67
        CloseableKt.closeFinally(r116, null);     // Catch: Exception -> L78
        r102 = 1;
        r103 = 0;
        goto L17
    L67:
        th = move-exception;
        throw th;     // Catch: Throwable -> L70
    L70:
        th = move-exception;
        CloseableKt.closeFinally(r116, th);     // Catch: Exception -> L78
        throw th;     // Catch: Exception -> L78
    L32:
        r113 = 0;
        goto L33
    L37:
        th = move-exception;
        throw th;     // Catch: Throwable -> L40
    L40:
        th = move-exception;
        CloseableKt.closeFinally(r111, th);     // Catch: Exception -> L78
        throw th;     // Catch: Exception -> L78
    L44:
        Integer r123 = r108.get(r107.getName());     // Catch: Exception -> L78
        Intrinsics.checkNotNull(r123);     // Catch: Exception -> L78
        r113 = r123.intValue();     // Catch: Exception -> L78
        goto L45
    L74:
        double r124 = r106;
        long r125 = (long) (0.05d * r124);     // Catch: Exception -> L78
        return new j((long) (0.3d * r124), r125, (long) (0.2d * r124), r110, (long) (r124 * 0.1d), r125, r125);
    L12:
        r104 = false;
    L112:
        return new j(0, 0, 0, 0, 0, 0, 0);
    L113:
        return new j(0, 0, 0, 0, 0, 0, 0);
    L79:
        return new j(0, 0, 0, 0, 0, 0, 0);
    }
}
