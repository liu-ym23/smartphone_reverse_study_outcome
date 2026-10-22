package com.bytedance.bdinstall;

import android.text.TextUtils;
import j74.a;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class s0 {
    public final Object a;
    public volatile boolean b;
    public final AtomicBoolean c;
    public final ThreadLocal<Boolean> d;
    public volatile boolean e;
    public volatile boolean f;

    public s0() {
        this.a = new Object();
        this.b = false;
        this.c = new AtomicBoolean(false);
        this.d = new ThreadLocal();
        this.e = false;
        this.f = false;
    }

    public final void a(boolean r2) {
        if (r2 == false) goto L4;
        this.d.set(Boolean.valueOf(r2));
        return;
    L4:
        this.d.remove();
    }

    public final void b(boolean r2) {
        this.f = r2;
        if (r2 == false) goto L5;
        this.d.set(Boolean.valueOf(r2));
        return;
    L5:
        this.d.remove();
        this.e = true;
        t.a("tryWaitingForInstallFinishWithOldWay finish because request finished");
    }

    public final void c(Integer r4) {
        if (this.c.compareAndSet(false, true) == false) goto L18;
        t.a("start register install event");
        String r5 = String.valueOf(r4);
        a r0 = i.a;
        k r6 = k.k(r5);
        r6.c(false, new a(this));
        n0 r7 = r6.j();
        if (r7 != null) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(r7.a) == false) goto L9;
        return;
    L9:
        if (TextUtils.isEmpty(r7.b) == true) goto L23;
        Object r8 = this.a;
        monitor-enter(r8);
        this.b = true;     // Catch: Throwable -> L15
        this.a.notifyAll();     // Catch: Throwable -> L15
        monitor-exit(r8);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        throw th;
    L23:
        return;
    }
}
