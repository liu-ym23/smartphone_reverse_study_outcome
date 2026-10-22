package com.bytedance.ee.bear.document.print;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes16.dex */
public final class o implements ut5.a<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PrintMinutesOptionSelector f221194a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f221195b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ oj5.c f221196c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Function1<String, Unit> f221197d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f221198e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f221199f;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PrintMinutesOptionSelector f221200a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f221201b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ oj5.c f221202c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Function1<String, Unit> f221203d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f221204e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f221205f;

        /* JADX WARN: Multi-variable type inference failed */
        public a(PrintMinutesOptionSelector r100, long r101, oj5.c r102, Function1<? super String, Unit> r103, Function0<Unit> r104, Function0<Unit> r105) {
            this.f221200a = r100;
            this.f221201b = r101;
            this.f221202c = r102;
            this.f221203d = r103;
            this.f221204e = r104;
            this.f221205f = r105;
        }

        @Override // java.lang.Runnable
        public final void run() {
            PrintMinutesOptionSelector r100 = this.f221200a;     // Catch: Throwable -> L7
            long r101 = this.f221201b;     // Catch: Throwable -> L7
            int r102 = PrintMinutesOptionSelector.f221126e;     // Catch: Throwable -> L7
            if (r100.f(r101) == false) goto L10;
            this.f221200a.h(this.f221201b, this.f221202c, false, this.f221203d, this.f221204e, this.f221205f);     // Catch: Throwable -> L7
            return;
        L10:
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L14;
            throw th;
        }
    }

    @Override // ut5.a
    public final void onResult(Boolean r110) {
        Boolean r100 = r110;
        PrintMinutesOptionSelector r101 = this.f221194a;
        r101.f221127a.runOnUiThread(new p(r101, this.f221195b, this.f221196c, r100, this.f221197d, this.f221198e, this.f221199f));
    }

    @Override // ut5.a
    public final void onError(int r100, Throwable r110) {
        StringBuilder r101 = new StringBuilder("validate transcript print option failed, code=");
        r101.append(r100);
        r101.append(", type=");
        if (r110 == null) goto L5;
        String r102 = r110.getClass().getSimpleName();
    L6:
        r101.append(r102);
        tt5.a.k("PrintMinutesOptionSelector", r101.toString());
        PrintMinutesOptionSelector r103 = this.f221194a;
        r103.f221127a.runOnUiThread(new a(r103, this.f221195b, this.f221196c, this.f221197d, this.f221198e, this.f221199f));
        return;
    L5:
        r102 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public o(PrintMinutesOptionSelector r100, long r101, oj5.c r102, Function1<? super String, Unit> r103, Function0<Unit> r104, Function0<Unit> r105) {
        this.f221194a = r100;
        this.f221195b = r101;
        this.f221196c = r102;
        this.f221197d = r103;
        this.f221198e = r104;
        this.f221199f = r105;
    }
}
