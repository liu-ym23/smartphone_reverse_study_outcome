package com.bytedance.crash.util;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes3.dex */
public final class n implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o f203415a;

    public n() {
        this.f203415a = o.f203416a;
    }

    public final void a() {
        this.f203415a.getClass();
        PolarisFileWrapper r100 = com.bytedance.crash.i.d();     // Catch: Throwable -> L8
        if (new PolarisFileWrapper(r100, "crash.deleted").exists() == true) goto L11;
        h.b(new PolarisFileWrapper(r100, "RuntimeContext"));     // Catch: Throwable -> L8
        h.b(new PolarisFileWrapper(r100, "ProcessTrack"));     // Catch: Throwable -> L8
        h.b(new PolarisFileWrapper(r100, "TrackInfo"));     // Catch: Throwable -> L8
        h.b(new PolarisFileWrapper(r100, "CrashCommonLog"));     // Catch: Throwable -> L8
        h.b(new PolarisFileWrapper(r100, "CrashLogJava"));     // Catch: Throwable -> L8
        h.b(new PolarisFileWrapper(r100, "CrashLogNative"));     // Catch: Throwable -> L8
        h.b(new PolarisFileWrapper(r100, "procanr"));     // Catch: Throwable -> L8
        h.b(new PolarisFileWrapper(r100, "configCrash"));     // Catch: Throwable -> L8
        new PolarisFileWrapper(r100, "crash.deleted").createNewFile();     // Catch: Throwable -> L8
        return;
    L11:
        return;
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
