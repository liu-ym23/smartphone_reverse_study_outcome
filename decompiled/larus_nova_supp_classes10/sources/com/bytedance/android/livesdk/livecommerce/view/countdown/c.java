package com.bytedance.android.livesdk.livecommerce.view.countdown;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.bytedance.android.livesdk.livecommerce.utils.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c implements e.a {
    public boolean a;
    public boolean b;
    public final e c;
    public final q83.a d;

    public final synchronized void a() {
        monitor-enter(this);
        this.a = true;     // Catch: Throwable -> L7
        this.b = false;     // Catch: Throwable -> L7
        this.c.removeMessages(1);     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final synchronized boolean b() {
        monitor-enter(this);
        boolean r0 = this.b;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized void c() {
        monitor-enter(this);
        this.a = false;     // Catch: Throwable -> L7
        this.b = true;     // Catch: Throwable -> L7
        e r1 = this.c;     // Catch: Throwable -> L7
        r1.sendMessage(r1.obtainMessage(1));     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public c(q83.a r3) {
        this.a = false;
        this.b = false;
        this.c = new e(Looper.getMainLooper(), this);
        this.d = r3;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.view.countdown.e.a
    public final void handleMsg(Message r7) {
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L4:
        if (this.a == true) goto L15;
        Handler r8 = k.a;     // Catch: Throwable -> L17
        long r0 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L17
        q83.a r9 = this.d;     // Catch: Throwable -> L17
        if (r9 == null) goto L8;
        r9.onTick(r0);     // Catch: Throwable -> L17
    L8:
        long r2 = 1000 - (SystemClock.elapsedRealtime() - r0);     // Catch: Throwable -> L17
    L10:
        if (r2 >= 0) goto L12;
        r2 = r2 + 1000;     // Catch: Throwable -> L17
        goto L10
    L12:
        e r10 = this.c;     // Catch: Throwable -> L17
        r10.sendMessageDelayed(r10.obtainMessage(1), r2);     // Catch: Throwable -> L17
        monitor-exit(this);     // Catch: Throwable -> L17
        return;
    L15:
        monitor-exit(this);     // Catch: Throwable -> L17
    }
}
