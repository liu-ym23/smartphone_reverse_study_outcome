package com.bytedance.ee.bear.document.print;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class o implements ut5.a<Boolean> {
    public final /* synthetic */ PrintMinutesOptionSelector a;
    public final /* synthetic */ long b;
    public final /* synthetic */ oj5.c c;
    public final /* synthetic */ Function1<String, Unit> d;
    public final /* synthetic */ Function0<Unit> e;
    public final /* synthetic */ Function0<Unit> f;

    public static final class a implements Runnable {
        public final /* synthetic */ PrintMinutesOptionSelector a;
        public final /* synthetic */ long b;
        public final /* synthetic */ oj5.c c;
        public final /* synthetic */ Function1<String, Unit> d;
        public final /* synthetic */ Function0<Unit> e;
        public final /* synthetic */ Function0<Unit> f;

        /* JADX WARN: Multi-variable type inference failed */
        public a(PrintMinutesOptionSelector r1, long r2, oj5.c r4, Function1<? super String, Unit> r5, Function0<Unit> r6, Function0<Unit> r7) {
            this.a = r1;
            this.b = r2;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
        }

        @Override // java.lang.Runnable
        public final void run() {
            PrintMinutesOptionSelector r0 = this.a;     // Catch: Throwable -> L7
            long r1 = this.b;     // Catch: Throwable -> L7
            int r3 = PrintMinutesOptionSelector.e;     // Catch: Throwable -> L7
            if (r0.f(r1) == false) goto L10;
            this.a.h(this.b, this.c, false, this.d, this.e, this.f);     // Catch: Throwable -> L7
            return;
        L10:
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L14;
            throw th;
        }
    }

    public final void onResult(Object r11) {
        Boolean r5 = (Boolean) r11;
        PrintMinutesOptionSelector r1 = this.a;
        r1.a.runOnUiThread(new p(r1, this.b, this.c, r5, this.d, this.e, this.f));
    }

    public final void onError(int r9, Throwable r10) {
        StringBuilder r0 = new StringBuilder("validate transcript print option failed, code=");
        r0.append(r9);
        r0.append(", type=");
        if (r10 == null) goto L5;
        String r11 = r10.getClass().getSimpleName();
    L6:
        r0.append(r11);
        tt5.a.k("PrintMinutesOptionSelector", r0.toString());
        PrintMinutesOptionSelector r1 = this.a;
        r1.a.runOnUiThread(new a(r1, this.b, this.c, this.d, this.e, this.f));
        return;
    L5:
        r11 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public o(PrintMinutesOptionSelector r1, long r2, oj5.c r4, Function1<? super String, Unit> r5, Function0<Unit> r6, Function0<Unit> r7) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
