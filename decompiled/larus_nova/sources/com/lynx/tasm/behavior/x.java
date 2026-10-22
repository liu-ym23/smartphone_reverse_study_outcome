package com.lynx.tasm.behavior;

import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.tasm.core.JSProxy;

/* JADX INFO: loaded from: classes32.dex */
public final class x implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f383215a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f383216b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ JavaOnlyMap f383217c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ d0 f383218d;

    @Override // java.lang.Runnable
    public final void run() {
        JSProxy r100 = this.f383218d.f382003x.get();     // Catch: Throwable -> L6
        if (r100 == null) goto L9;
        r100.c(this.f383215a, this.f383216b, this.f383217c);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }

    public x(d0 r100, int r101, int r102, JavaOnlyMap r103) {
        this.f383218d = r100;
        this.f383215a = r101;
        this.f383216b = r102;
        this.f383217c = r103;
    }
}
