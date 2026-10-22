package com.bytedance.ee.bear.widgets;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public abstract class t implements View.OnClickListener {
    public long a;
    public final long b;

    public abstract void a(View r1);

    public t() {
        this.b = 200;
    }

    public t(long r3) {
        this.b = 200;
        this.b = r3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r6) {
        long r0 = System.currentTimeMillis();
        long r2 = r0 - this.a;
        this.a = r0;
        if (r2 <= this.b) goto L5;
        a(r6);
        return;
    L5:
        com.ss.android.lark.officesdk.utils.di.j.f("SafeClickListener", "So fast click , ignored !");
    }
}
