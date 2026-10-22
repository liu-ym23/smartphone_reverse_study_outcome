package com.bytedance.bdinstall;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes8.dex */
public final class l0 extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f199716a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ i0.d f199717b;

    public l0(i0.d r100) {
        this.f199717b = r100;
        this.f199716a = true;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r100, Intent r101) {
        if (this.f199716a == false) goto L6;
        this.f199716a = false;
        return;
    L6:
        if (r101 != null) goto L10;
        t.a("intent is null when receive net change event");
        return;
    L10:
        if (r101.getBooleanExtra("noConnectivity", false) == false) goto L14;
        t.a("no connectivity");
        return;
    L14:
        if (i84.j.a(this.f199717b.f199670c) == false) goto L23;
        i0.d r102 = this.f199717b;
        monitor-enter(r102);
        m0 r103 = new m0(r102);     // Catch: Throwable -> L20
        v.e(v.a(v.f199800d), r103);     // Catch: Throwable -> L20
        monitor-exit(r102);
        return;
    L20:
        th = move-exception;
        throw th;
    }
}
