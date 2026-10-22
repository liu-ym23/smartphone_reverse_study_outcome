package com.google.android.gms.common;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes23.dex */
public class BlockingServiceConnection implements ServiceConnection {

    /* JADX INFO: renamed from: zza, reason: collision with root package name */
    boolean f274451zza;

    /* JADX INFO: renamed from: zzb, reason: collision with root package name */
    private final BlockingQueue f274452zzb;

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName r100) {
    }

    @ResultIgnorabilityUnspecified
    public IBinder getService() throws InterruptedException {
        Preconditions.checkNotMainThread("BlockingServiceConnection.getService() called on main thread");
        if (this.f274451zza == true) goto L7;
        this.f274451zza = true;
        return (IBinder) this.f274452zzb.take();
    L7:
        throw new IllegalStateException("Cannot call get on this connection more than once");
    }

    public BlockingServiceConnection() {
        this.f274451zza = false;
        this.f274452zzb = new LinkedBlockingQueue();
    }

    @ResultIgnorabilityUnspecified
    public IBinder getServiceWithTimeout(long r100, TimeUnit r101) throws InterruptedException, TimeoutException {
        Preconditions.checkNotMainThread("BlockingServiceConnection.getServiceWithTimeout() called on main thread");
        if (this.f274451zza == true) goto L10;
        this.f274451zza = true;
        IBinder r102 = (IBinder) this.f274452zzb.poll(r100, r101);
        if (r102 == null) goto L8;
        return r102;
    L8:
        throw new TimeoutException("Timed out waiting for the service connection");
    L10:
        throw new IllegalStateException("Cannot call get on this connection more than once");
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName r100, IBinder r101) {
        this.f274452zzb.add(r101);
    }
}
