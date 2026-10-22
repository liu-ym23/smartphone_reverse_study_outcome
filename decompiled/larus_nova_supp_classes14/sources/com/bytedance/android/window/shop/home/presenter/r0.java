package com.bytedance.android.window.shop.home.presenter;

import com.bytedance.android.btm.api.model.PageFinder;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.TimerTask;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class r0 extends TimerTask {
    public final /* synthetic */ String a;
    public final /* synthetic */ s0 b;

    public static final class a {
        public a() {
        }
    }

    public final void a() {
        int r0 = zq3.f.a;
        String r1 = this.a;
        t0 r2 = this.b.a;
        int r3 = t0.o;
        String r4 = zq3.f.c(r1, "a1.b7635.c366460.d75972", PageFinder.via(r2.y()), null);
        com.bytedance.android.ec.sdk.helper.p.a.f(this.b.a.u().c(), r4, new a());
    }

    @Override // java.util.TimerTask, java.lang.Runnable
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

    public r0(String r1, s0 r2) {
        this.a = r1;
        this.b = r2;
    }
}
