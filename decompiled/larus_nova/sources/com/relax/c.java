package com.relax;

import com.larus.apm.impl.protector.RunnableProtector;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes34.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Object f404622a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f404623b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ BackendWorker f404624c;

    @Override // java.lang.Runnable
    public final void run() {
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    L13:
        return;
    L3:
        if (this.f404624c.f404534a == null) goto L9;
        boolean r100 = ipa.c.f495326a;     // Catch: Throwable -> L6
        ByteBuffer r101 = ipa.c.b(this.f404622a);     // Catch: Throwable -> L6
        r101.flip();     // Catch: Throwable -> L6
        byte[] r102 = new byte[r101.remaining()];     // Catch: Throwable -> L6
        r101.get(r102);     // Catch: Throwable -> L6
        this.f404624c.f404534a.fireEvent(this.f404623b, r102);     // Catch: Throwable -> L6
        return;
    }

    public c(BackendWorker r100, Object r101, String r102) {
        this.f404624c = r100;
        this.f404622a = r101;
        this.f404623b = r102;
    }
}
