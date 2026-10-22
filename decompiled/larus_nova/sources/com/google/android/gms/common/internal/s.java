package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.os.Handler;
import android.os.Message;
import java.util.HashMap;

/* JADX INFO: loaded from: classes23.dex */
public final class s implements Handler.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ t f274561a;

    public /* synthetic */ s(t r100) {
        this.f274561a = r100;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message r100) {
        int r101 = r100.what;
        if (r101 == 0) goto L23;
        if (r101 == 1) goto L6;
        return false;
    L6:
        HashMap r102 = this.f274561a.f274562c;
        monitor-enter(r102);
        q r103 = (q) r100.obj;     // Catch: Throwable -> L20
        r r104 = (r) this.f274561a.f274562c.get(r103);     // Catch: Throwable -> L20
        if (r104 != null) goto L11;
    L18:
        monitor-exit(r102);     // Catch: Throwable -> L20
        return true;
    L11:
        if (r104.f274555b != 3) goto L18;
        String.valueOf(r103);     // Catch: Throwable -> L20
        new Exception();     // Catch: Throwable -> L20
        ComponentName r105 = r104.f274559f;     // Catch: Throwable -> L20
        if (r105 != null) goto L15;
        r105 = r103.f274552c;     // Catch: Throwable -> L20
    L15:
        if (r105 != null) goto L17;
        String r106 = r103.f274551b;     // Catch: Throwable -> L20
        Preconditions.checkNotNull(r106);     // Catch: Throwable -> L20
        r105 = new ComponentName(r106, "unknown");     // Catch: Throwable -> L20
    L17:
        r104.onServiceDisconnected(r105);     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        throw th;
    L23:
        HashMap r107 = this.f274561a.f274562c;
        monitor-enter(r107);
        q r108 = (q) r100.obj;     // Catch: Throwable -> L33
        r r109 = (r) this.f274561a.f274562c.get(r108);     // Catch: Throwable -> L33
        if (r109 != null) goto L28;
    L35:
        monitor-exit(r107);     // Catch: Throwable -> L33
        return true;
    L28:
        if (((HashMap) r109.f274554a).isEmpty() == false) goto L35;
        if (r109.f274556c == false) goto L32;
        q r110 = r109.f274558e;     // Catch: Throwable -> L33
        r109.f274560g.f274564e.removeMessages(1, r110);     // Catch: Throwable -> L33
        t r111 = r109.f274560g;     // Catch: Throwable -> L33
        r111.f274565f.unbindService(r111.f274563d, r109);     // Catch: Throwable -> L33
        r109.f274556c = false;     // Catch: Throwable -> L33
        r109.f274555b = 2;     // Catch: Throwable -> L33
    L32:
        this.f274561a.f274562c.remove(r108);     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        throw th;
    }
}
