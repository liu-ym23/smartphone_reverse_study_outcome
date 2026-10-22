package com.xiaomi.push.service;

import android.os.SystemClock;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes41.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<String, Long> f464309a = null;

    static {
        f464309a = new HashMap();
    }

    private static void a() {
        long r100 = SystemClock.elapsedRealtime();
        Map<String, Long> r101 = f464309a;
        ArrayList r102 = new ArrayList(r101.size());
        Iterator<Map.Entry<String, Long>> r103 = r101.entrySet().iterator();
    L4:
        if (r103.hasNext() == false) goto L8;
        Map.Entry<String, Long> r104 = r103.next();
        if ((r100 - r104.getValue().longValue()) <= 60000) goto L4;
        r102.add(r104.getKey());
        goto L4
    L8:
        Iterator r105 = r102.iterator();
    L10:
        if (r105.hasNext() == false) goto L12;
        String r106 = (String) r105.next();
        f464309a.remove(r106);
        goto L10
    }

    public static boolean a(byte[] r100, String r101) {
        boolean r102 = false;
        if (r100 != null) goto L5;
    L22:
        return r102;
    L5:
        if (r100.length <= 0) goto L22;
        if (TextUtils.isEmpty(r101) == true) goto L22;
        String r103 = com.xiaomi.push.ba.a(r100);
        if (TextUtils.isEmpty(r103) == true) goto L22;
        Map<String, Long> r104 = f464309a;
        monitor-enter(r104);
    L19:
        th = move-exception;
        throw th;
    L13:
        if (r104.get(r103 + r101) == null) goto L15;
        r102 = true;
    L16:
        a();     // Catch: Throwable -> L19
        monitor-exit(r104);     // Catch: Throwable -> L19
        goto L22
    L15:
        r104.put(r103 + r101, Long.valueOf(SystemClock.elapsedRealtime()));     // Catch: Throwable -> L19
        goto L16
    }
}
