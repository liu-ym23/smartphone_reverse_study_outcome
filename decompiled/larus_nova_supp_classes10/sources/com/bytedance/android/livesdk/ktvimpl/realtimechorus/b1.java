package com.bytedance.android.livesdk.ktvimpl.realtimechorus;

import android.app.Activity;
import android.content.Context;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b1 implements Runnable {
    public final /* synthetic */ RealTimeChorusOperateView a;

    public b1(RealTimeChorusOperateView r1) {
        this.a = r1;
    }

    public final void a() {
        Context r1 = this.a.getContext();
        if (r1 == null) goto L7;
        c90.a.a r0 = new c90.a.a((Activity) r1);
        r0.f = true;
        r0.a(s1.B(2131918486));
        r0.m = ColorProtector.parseColor("#ffffff");
        r0.b = false;
        r0.e = 5000;
        r0.a = ColorProtector.parseColor("#393B44");
        r0.r = false;
        new c90.a(r0).i(this.a.f, 48, true);
        com.bytedance.android.livesdk.sharedpref.e r2 = com.bytedance.android.livesdk.sharedpref.c.W;
        Boolean r3 = Boolean.TRUE;
        r2.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r2, r3);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
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
