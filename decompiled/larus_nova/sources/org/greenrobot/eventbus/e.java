package org.greenrobot.eventbus;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;

/* JADX INFO: loaded from: classes42.dex */
public final class e extends Handler implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f525803a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final EventBus f525804b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f525805c;

    @Override // android.os.Handler
    public final void handleMessage(Message r100) {
        long r101 = SystemClock.uptimeMillis();     // Catch: Throwable -> L25
        String r102 = EventBus.TAG;     // Catch: Throwable -> L25
    L4:
        j r103 = this.f525803a.b();     // Catch: Throwable -> L25
        if (r103 != null) goto L17;
        monitor-enter(this);     // Catch: Throwable -> L25
        r103 = this.f525803a.b();     // Catch: Throwable -> L14
        if (r103 == null) goto L9;
        monitor-exit(this);     // Catch: Throwable -> L14
        goto L17
    L9:
        monitor-exit(this);     // Catch: Throwable -> L14
        this.f525805c = false;
        return;
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L25
    L17:
        this.f525804b.invokeSubscriber(r103);     // Catch: Throwable -> L25
        if ((SystemClock.uptimeMillis() - r101) < 10) goto L4;
        if (sendMessage(obtainMessage()) == false) goto L24;
        this.f525805c = true;
        return;
    L24:
        throw new EventBusException("Could not send handler message");     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        this.f525805c = false;
        throw th;
    }

    public e(EventBus r100, Looper r101) {
        super(r101);
        this.f525804b = r100;
        this.f525803a = new k();
    }

    @Override // org.greenrobot.eventbus.l
    public final void a(o r100, Object r101) {
        j r102 = j.a(r100, r101);
        monitor-enter(this);
        this.f525803a.a(r102);     // Catch: Throwable -> L13
        if (this.f525805c == true) goto L11;
        this.f525805c = true;     // Catch: Throwable -> L13
        if (sendMessage(obtainMessage()) == true) goto L11;
        throw new EventBusException("Could not send handler message");     // Catch: Throwable -> L13
    L11:
        monitor-exit(this);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    }
}
