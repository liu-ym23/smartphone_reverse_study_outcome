package com.huawei.hms.utils;

import android.text.TextUtils;
import com.huawei.hms.support.log.HMSLog;
import java.sql.Timestamp;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes23.dex */
public class ResolutionFlagUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile ResolutionFlagUtil f277907a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<String, Long> f277908b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Object f277909c = null;

    static {
        f277908b = new ConcurrentHashMap();
        f277909c = new Object();
    }

    private void a() {
        long r100 = new Timestamp(System.currentTimeMillis()).getTime() - 10800000;
        Iterator<String> r101 = f277908b.keySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L14;
        String r102 = r101.next();
        Map<String, Long> r103 = f277908b;
        Long r104 = r103.get(r102);
        if (r104 == null) goto L13;
        if (r104.longValue() == 0) goto L13;
        if (r100 < r104.longValue()) goto L4;
        r103.remove(r102);
        HMSLog.i("ResolutionFlagUtil", "remove resolution flag because aging time: " + r102);
    L13:
        r103.remove(r102);
        HMSLog.i("ResolutionFlagUtil", "remove resolution flag because the data in this pair was abnormal: " + r102);
        goto L4
    }

    public static ResolutionFlagUtil getInstance() {
        if (f277907a != null) goto L5;
        Object r100 = f277909c;
        monitor-enter(r100);
    L14:
        th = move-exception;
        throw th;
    L9:
        if (f277907a != null) goto L11;
        f277907a = new ResolutionFlagUtil();     // Catch: Throwable -> L14
    L11:
        monitor-exit(r100);     // Catch: Throwable -> L14
        return f277907a;
    L5:
        return f277907a;
    }

    private ResolutionFlagUtil() {
    }

    public long getResolutionFlag(String r100) {
        if (r100 != null) goto L6;
        HMSLog.e("ResolutionFlagUtil", "transactionId is null");
        return 0;
    L6:
        Map<String, Long> r101 = f277908b;
        if (r101.get(r100) != null) goto L9;
        return 0;
    L9:
        return r101.get(r100).longValue();
    }

    public void removeResolutionFlag(String r100) {
        if (r100 != null) goto L6;
        HMSLog.e("ResolutionFlagUtil", "transactionId is null");
        return;
    L6:
        f277908b.remove(r100);
        HMSLog.i("ResolutionFlagUtil", "remove resolution flag");
    }

    private void a(String r100, long r101) {
        Map<String, Long> r102 = f277908b;
        monitor-enter(r102);
        a();     // Catch: Throwable -> L7
        r102.put(r100, Long.valueOf(r101));     // Catch: Throwable -> L7
        HMSLog.i("ResolutionFlagUtil", "save resolution flag");     // Catch: Throwable -> L7
        monitor-exit(r102);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void saveResolutionFlag(String r100, long r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L9:
        HMSLog.e("ResolutionFlagUtil", "saveResolutionFlag error, transactionId: " + r100 + ", timestamp: " + r101);
        return;
    L5:
        if (r101 == 0) goto L9;
        a(r100, r101);
    }
}
