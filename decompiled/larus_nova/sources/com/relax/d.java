package com.relax;

import com.larus.apm.impl.protector.RunnableProtector;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes34.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f404625a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ RelaxEventListener f404626b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ BackendWorker f404627c;

    public class a implements RelaxEventListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f404628a;

        public a(d r100) {
            this.f404628a = r100;
        }

        @Override // com.relax.RelaxEventListener
        public final void invoke(Object r100) {
            Object r101 = ipa.c.a((ByteBuffer) r100);
            this.f404628a.f404626b.invoke(r101);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        BackendWorkerJNI r100 = this.f404627c.f404534a;     // Catch: Throwable -> L6
        if (r100 == null) goto L9;
        r100.addEventListener(this.f404625a, new a(this), this.f404626b);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }

    public d(BackendWorker r100, String r101, RelaxEventListener r102) {
        this.f404627c = r100;
        this.f404625a = r101;
        this.f404626b = r102;
    }
}
