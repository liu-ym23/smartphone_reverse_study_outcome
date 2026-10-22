package com.ss.android.lark.ug.business.badge;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes38.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f444421a = null;

    static {
        f444421a = new c();
    }

    public c() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        Iterator r100 = ((LinkedHashMap) BadgeManager.f444413d).entrySet().iterator();     // Catch: Throwable -> L7
    L4:
        if (r100.hasNext() == false) goto L16;
        Map.Entry r101 = (Map.Entry) r100.next();     // Catch: Throwable -> L7
        j r102 = BadgeManager.f444410a;     // Catch: Throwable -> L7
        BadgeManager.a((String) r101.getKey(), (b) r101.getValue());     // Catch: Throwable -> L7
        goto L4
    L16:
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }
}
