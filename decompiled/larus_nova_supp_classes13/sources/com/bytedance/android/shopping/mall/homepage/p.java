package com.bytedance.android.shopping.mall.homepage;

import com.bytedance.android.shopping.mall.homepage.tools.u;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class p implements Runnable {
    public final /* synthetic */ ECMallFragment a;
    public final /* synthetic */ List b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ boolean d;
    public final /* synthetic */ Function1 e;

    public static final class a implements Runnable {
        public final /* synthetic */ p a;

        public a(p r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            p r0 = this.a;     // Catch: Throwable -> L4
            ECMallFragment r1 = r0.a;     // Catch: Throwable -> L4
            List<String> r2 = r0.b;     // Catch: Throwable -> L4
            boolean r3 = r0.c;     // Catch: Throwable -> L4
            boolean r4 = r0.d;     // Catch: Throwable -> L4
            Map<String, ? extends Object> r5 = MapsKt.mapOf(TuplesKt.to("skip_reset_params", Boolean.TRUE));     // Catch: Throwable -> L4
            Function1<? super Boolean, Unit> r6 = this.a.e;     // Catch: Throwable -> L4
            int r7 = ECMallFragment.h4;     // Catch: Throwable -> L4
            r1.Ja0(r2, r3, r4, r5, r6);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ p a;

        public b(p r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            p r0 = this.a;     // Catch: Throwable -> L4
            ECMallFragment r1 = r0.a;     // Catch: Throwable -> L4
            List<String> r2 = r0.b;     // Catch: Throwable -> L4
            boolean r3 = r0.c;     // Catch: Throwable -> L4
            boolean r4 = r0.d;     // Catch: Throwable -> L4
            Function1<? super Boolean, Unit> r6 = r0.e;     // Catch: Throwable -> L4
            int r5 = ECMallFragment.h4;     // Catch: Throwable -> L4
            r1.Ja0(r2, r3, r4, null, r6);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public p(ECMallFragment r1, List r2, boolean r3, boolean r4, Function1 r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    public final void a() {
        int r0 = u.a;
        this.a.getClass();
        if (u.a(new LinkedHashMap()) == false) goto L5;
        this.a.P1.post(new a(this));
        return;
    L5:
        this.a.P1.post(new b(this));
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
