package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.Looper;
import com.google.android.gms.common.stats.ConnectionTracker;
import java.util.HashMap;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes23.dex */
public final class t extends a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap f274562c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Context f274563d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile com.google.android.gms.internal.common.l f274564e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ConnectionTracker f274565f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f274566g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f274567h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile Executor f274568i;

    public t(Context r100, Looper r101) {
        this.f274562c = new HashMap();
        s r102 = new s(this);
        this.f274563d = r100.getApplicationContext();
        this.f274564e = new com.google.android.gms.internal.common.l(r101, r102);
        this.f274565f = ConnectionTracker.getInstance();
        this.f274566g = 5000;
        this.f274567h = 300000;
        this.f274568i = null;
    }

    @Override // com.google.android.gms.common.internal.a
    public final void a(q r100, ServiceConnection r101) {
        Preconditions.checkNotNull(r101, "ServiceConnection must not be null");
        HashMap r102 = this.f274562c;
        monitor-enter(r102);
        r r103 = (r) this.f274562c.get(r100);     // Catch: Throwable -> L13
        if (r103 == null) goto L18;
        if (((HashMap) r103.f274554a).containsKey(r101) == false) goto L16;
        ((HashMap) r103.f274554a).remove(r101);     // Catch: Throwable -> L13
        if (((HashMap) r103.f274554a).isEmpty() == false) goto L11;
        this.f274564e.sendMessageDelayed(this.f274564e.obtainMessage(0, r100), this.f274566g);     // Catch: Throwable -> L13
    L11:
        monitor-exit(r102);     // Catch: Throwable -> L13
        return;
    L16:
        throw new IllegalStateException("Trying to unbind a GmsServiceConnection  that was not bound before.  config=" + r100.toString());     // Catch: Throwable -> L13
    L18:
        throw new IllegalStateException("Nonexistent connection status for service config: " + r100.toString());     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    @Override // com.google.android.gms.common.internal.a
    public final boolean b(q r100, ServiceConnection r101, String r102, Executor r103) {
        Preconditions.checkNotNull(r101, "ServiceConnection must not be null");
        HashMap r104 = this.f274562c;
        monitor-enter(r104);
        r r105 = (r) this.f274562c.get(r100);     // Catch: Throwable -> L9
        if (r103 != null) goto L7;
        r103 = this.f274568i;     // Catch: Throwable -> L9
    L7:
        if (r105 != null) goto L11;
        r105 = new r(this, r100);     // Catch: Throwable -> L9
        ((HashMap) r105.f274554a).put(r101, r101);     // Catch: Throwable -> L9
        r105.a(r102, r103);     // Catch: Throwable -> L9
        this.f274562c.put(r100, r105);     // Catch: Throwable -> L9
    L20:
        boolean r106 = r105.f274556c;     // Catch: Throwable -> L9
        monitor-exit(r104);     // Catch: Throwable -> L9
        return r106;
    L11:
        this.f274564e.removeMessages(0, r100);     // Catch: Throwable -> L9
        if (((HashMap) r105.f274554a).containsKey(r101) == true) goto L24;
        ((HashMap) r105.f274554a).put(r101, r101);     // Catch: Throwable -> L9
        int r107 = r105.f274555b;     // Catch: Throwable -> L9
        if (r107 != 1) goto L16;
        r101.onServiceConnected(r105.f274559f, r105.f274557d);     // Catch: Throwable -> L9
        goto L20
    L16:
        if (r107 != 2) goto L20;
        r105.a(r102, r103);     // Catch: Throwable -> L9
        goto L20
    L24:
        throw new IllegalStateException("Trying to bind a GmsServiceConnection that was already connected before.  config=" + r100.toString());     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }
}
