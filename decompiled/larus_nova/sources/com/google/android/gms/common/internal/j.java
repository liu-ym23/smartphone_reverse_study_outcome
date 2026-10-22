package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;

/* JADX INFO: loaded from: classes23.dex */
public final class j implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f274544a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BaseGmsClient f274545b;

    public j(BaseGmsClient r100, int r101) {
        this.f274545b = r100;
        this.f274544a = r101;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName r100) {
        Object r101 = BaseGmsClient.zzd(this.f274545b);
        monitor-enter(r101);
        BaseGmsClient.zzh(this.f274545b, null);     // Catch: Throwable -> L8
        monitor-exit(r101);     // Catch: Throwable -> L8
        BaseGmsClient r102 = this.f274545b;
        int r103 = this.f274544a;
        Handler r104 = r102.f274494zzb;
        r104.sendMessage(r104.obtainMessage(6, r103, 1));
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName r100, IBinder r101) {
        BaseGmsClient r102 = this.f274545b;
        if (r101 != null) goto L6;
        BaseGmsClient.zzk(r102, 16);
        return;
    L6:
        Object r103 = BaseGmsClient.zzd(r102);
        monitor-enter(r103);
        BaseGmsClient r104 = this.f274545b;     // Catch: Throwable -> L18
        IInterface r105 = r101.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");     // Catch: Throwable -> L18
        if (r105 != null) goto L11;
    L13:
        IGmsServiceBroker r106 = new zzad(r101);     // Catch: Throwable -> L18
    L14:
        BaseGmsClient.zzh(r104, r106);     // Catch: Throwable -> L18
        monitor-exit(r103);     // Catch: Throwable -> L18
        this.f274545b.zzl(0, null, this.f274544a);
        return;
    L11:
        if ((r105 instanceof IGmsServiceBroker) == false) goto L13;
        r106 = (IGmsServiceBroker) r105;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    }
}
