package com.bytedance.ug.sdk.yz.wrapper;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Process;
import wo7.b;

/* JADX INFO: loaded from: classes22.dex */
public class KillApplicationReceiver extends BroadcastReceiver {
    public KillApplicationReceiver() {
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r100, Intent r101) {
        if (b.f560527d != null) goto L15;
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (b.f560527d != null) goto L9;
        b.f560527d = new b(r100);     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
    L15:
        if (b.f560527d.f560530c.f560526b == true) goto L22;
        return;
    L22:
        Process.killProcess(Process.myPid());     // Catch: Throwable -> L19
        return;
    }
}
