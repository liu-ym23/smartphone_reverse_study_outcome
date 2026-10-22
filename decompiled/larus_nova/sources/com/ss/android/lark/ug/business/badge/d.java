package com.ss.android.lark.ug.business.badge;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes38.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f444422a = null;

    static {
        f444422a = new d();
    }

    public d() {
    }

    public static void a() {
        StringBuilder r100 = new StringBuilder("badge data ready, waitingMapSize=");
        ConcurrentHashMap<String, b> r101 = BadgeManager.f444414e;
        r100.append(r101.size());
        Log.i("ug-badge", r100.toString());
        Iterator<Map.Entry<String, b>> r102 = r101.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        Map.Entry<String, b> r103 = r102.next();
        j r104 = BadgeManager.f444410a;
        BadgeManager.a(r103.getKey(), r103.getValue());
        goto L4
    L6:
        BadgeManager.f444414e.clear();
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
