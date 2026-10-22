package com.bytedance.badger.x;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;

/* JADX INFO: loaded from: classes47.dex */
public final class n implements ServiceConnection {
    public n() {
    }

    @Override // android.content.ServiceConnection
    public final void onNullBinding(ComponentName r100) {
        com.bytedance.badger.e.b("DeviceFp1", "service# Sorter onNullBinding");
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName r100, IBinder r101) {
        p.f199394a = C.a(r101);
        ThreadMethodProxy.start(new PthreadThreadV2(new l(), "ce/badger/x/b"));
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName r100) {
        p.f199394a = null;
        p.f199396c = false;
        com.bytedance.badger.e.b("DeviceFp1", "service# disconnect");
    }
}
