package com.xiaomi.push.service;

import android.content.SharedPreferences;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/* JADX INFO: loaded from: classes41.dex */
public class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Object f464363a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static Map<String, Queue<String>> f1153a;

    static {
        f464363a = new Object();
        f1153a = new HashMap();
    }

    public static boolean a(XMPushService r100, String r101, String r102) {
        Object r103 = f464363a;
        monitor-enter(r103);
        SharedPreferences r104 = r100.getSharedPreferences("push_message_ids", 0);     // Catch: Throwable -> L21
        Queue r105 = f1153a.get(r101);     // Catch: Throwable -> L21
        if (r105 != null) goto L11;
        String[] r106 = r104.getString(r101, "").split(",");     // Catch: Throwable -> L21
        LinkedList r107 = new LinkedList();     // Catch: Throwable -> L21
        int r108 = r106.length;     // Catch: Throwable -> L21
        int r109 = 0;
    L7:
        if (r109 >= r108) goto L9;
        r107.add(r106[r109]);     // Catch: Throwable -> L21
        r109 = r109 + 1;     // Catch: Throwable -> L21
        goto L7
    L9:
        f1153a.put(r101, r107);     // Catch: Throwable -> L21
        r105 = r107;
    L11:
        if (r105.contains(r102) == false) goto L15;
        monitor-exit(r103);     // Catch: Throwable -> L21
        return true;
    L15:
        r105.add(r102);     // Catch: Throwable -> L21
        if (r105.size() <= 25) goto L18;
        r105.poll();     // Catch: Throwable -> L21
    L18:
        String r110 = com.xiaomi.push.ba.a(r105, ",");     // Catch: Throwable -> L21
        SharedPreferences.Editor r111 = r104.edit();     // Catch: Throwable -> L21
        r111.putString(r101, r110);     // Catch: Throwable -> L21
        r111.commit();     // Catch: Throwable -> L21
        monitor-exit(r103);     // Catch: Throwable -> L21
        return false;
    L21:
        th = move-exception;
        throw th;
    }
}
