package com.ss.android.lark.utils;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes38.dex */
public final class x0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Object f444788a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ s0.c f444789b;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ x0 f444790a;

        @Override // java.lang.Runnable
        public final void run() {
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L11;
            return;
        L11:
            throw th;
        L3:
            if (s0.c.a(this.f444790a.f444789b) == false) goto L5;
            x0 r100 = this.f444790a;     // Catch: Throwable -> L7
            r100.f444789b.d(r100.f444788a);     // Catch: Throwable -> L7
        L5:
            s0.c.b(this.f444790a.f444789b);     // Catch: Throwable -> L7
        }

        public a(x0 r100) {
            this.f444790a = r100;
        }
    }

    public final void a() {
        if (this.f444789b.f444769a == false) goto L5;
        return;
    L5:
        if (this.f444789b.f444771c == true) goto L14;
        this.f444789b.f444770b = true;
        if (s0.c.a(this.f444789b) == false) goto L10;
        this.f444789b.f444773e.e();
        ViewUtils.runOnUiThreadDelayed(new a(this), 100);
        return;
    L10:
        s0.c.b(this.f444789b);
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

    public x0(s0.c r100, Object r101) {
        this.f444789b = r100;
        this.f444788a = r101;
    }
}
