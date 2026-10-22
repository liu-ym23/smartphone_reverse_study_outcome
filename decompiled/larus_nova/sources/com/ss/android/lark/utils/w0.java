package com.ss.android.lark.utils;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes38.dex */
public final class w0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s0.c f444785a;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ w0 f444786a;

        @Override // java.lang.Runnable
        public final void run() {
            s0.c r100 = this.f444786a.f444785a;     // Catch: Throwable -> L9
            if (r100.f444776h != null) goto L5;
        L7:
            s0.c.b(this.f444786a.f444785a);     // Catch: Throwable -> L9
            return;
        L5:
            if (s0.c.a(r100) == false) goto L7;
            this.f444786a.f444785a.f444776h.run();     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L13;
            return;
        L13:
            throw th;
        }

        public a(w0 r100) {
            this.f444786a = r100;
        }
    }

    public final void a() {
        if (this.f444785a.f444770b == false) goto L5;
        return;
    L5:
        if (this.f444785a.f444771c == true) goto L16;
        this.f444785a.f444769a = true;
        s0.c r100 = this.f444785a;
        if (r100.f444776h != null) goto L10;
    L12:
        s0.c.b(this.f444785a);
        return;
    L10:
        if (s0.c.a(r100) == false) goto L12;
        this.f444785a.f444773e.e();
        ViewUtils.runOnUiThreadDelayed(new a(this), 100);
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

    public w0(s0.c r100) {
        this.f444785a = r100;
    }
}
