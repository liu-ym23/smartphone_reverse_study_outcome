package com.bytedance.dataplatform;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes3.dex */
public final class k implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f204320a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ij4.a f204321b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ij4.b f204322c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ i f204323d;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ k f204324a;

        @Override // java.lang.Runnable
        public final void run() {
            k r100 = this.f204324a;     // Catch: Throwable -> L4
            r100.f204323d.f204312h.b(r100.f204320a, r100.f204321b, r100.f204322c.f490067a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(k r100) {
            this.f204324a = r100;
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        w.a(new a(this));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public k(i r100, String r101, ij4.a r102, ij4.b r103) {
        this.f204323d = r100;
        this.f204320a = r101;
        this.f204321b = r102;
        this.f204322c = r103;
    }
}
