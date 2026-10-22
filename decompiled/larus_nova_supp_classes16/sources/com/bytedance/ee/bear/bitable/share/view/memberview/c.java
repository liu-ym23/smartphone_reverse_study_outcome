package com.bytedance.ee.bear.bitable.share.view.memberview;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c implements Runnable {
    public final /* synthetic */ long a;
    public final /* synthetic */ Long b;
    public final /* synthetic */ Integer c;
    public final /* synthetic */ Integer d;
    public final /* synthetic */ Boolean e;
    public final /* synthetic */ Integer f;
    public final /* synthetic */ Boolean g;
    public final /* synthetic */ boolean h;

    public c(long r1, Long r3, Integer r4, Integer r5, Boolean r6, Integer r7, Boolean r8, boolean r9) {
        this.a = r1;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
    }

    public final void a() {
        long r0 = System.currentTimeMillis();
        int r6 = (int) (this.a - this.b.longValue());
        int r7 = (int) (r0 - this.a);
        int r4 = this.c.intValue();
        int r5 = this.d.intValue();
        int r8 = this.c.intValue() + this.d.intValue();
        int r9 = ((this.c.intValue() + this.d.intValue()) + r6) + r7;
        Boolean r1 = this.e;
        if (r1 == null) goto L5;
        boolean r11 = r1.booleanValue();
    L6:
        com.bytedance.ee.bear.middleground.permission.c.C(r4, r5, r6, r7, r8, r9, "bitable_share_form", r11, this.f.intValue(), this.g.booleanValue());
        boolean r2 = !this.h;
        Boolean r3 = this.e;
        if (r3 == null) goto L9;
        boolean r10 = r3.booleanValue();
    L10:
        com.bytedance.ee.bear.middleground.permission.c.B(r2, "bitable_share_form", r10, this.f.intValue(), this.g.booleanValue(), 0);
        return;
    L9:
        r10 = false;
        goto L10
    L5:
        r11 = false;
        goto L6
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
