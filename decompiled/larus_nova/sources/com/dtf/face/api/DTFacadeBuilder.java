package com.dtf.face.api;

import android.content.Context;
import ls7.a;
import ls7.b;

/* JADX INFO: loaded from: classes22.dex */
public class DTFacadeBuilder {
    private static DTFacade s_instance;

    public DTFacadeBuilder() {
    }

    public static synchronized DTFacade create(Context r100) {
        monitor-enter(DTFacadeBuilder.class);
        if (r100 == null) goto L13;
        DTFacade r101 = s_instance;     // Catch: Throwable -> L14
        if (r101 != null) goto L8;
        s_instance = new DTFacade(r100);     // Catch: Throwable -> L14
    L9:
        DTFacade r102 = s_instance;     // Catch: Throwable -> L14
        monitor-exit(DTFacadeBuilder.class);
        return r102;
    L8:
        r101.updateContext(r100);     // Catch: Throwable -> L14
        goto L9
    L13:
        throw new RuntimeException("context Can't be null");     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    public static void setNetworkProxy(b r100) {
        a.f().f510544a = r100;
    }
}
