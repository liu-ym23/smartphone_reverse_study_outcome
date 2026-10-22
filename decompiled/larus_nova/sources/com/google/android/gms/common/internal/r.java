package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import android.os.StrictMode;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.PlatformVersion;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes23.dex */
public final class r implements ServiceConnection, u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f274554a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f274555b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f274556c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public IBinder f274557d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final q f274558e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ComponentName f274559f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ t f274560g;

    @Override // android.content.ServiceConnection
    public final void onBindingDied(ComponentName r100) {
        onServiceDisconnected(r100);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName r100) {
        HashMap r101 = this.f274560g.f274562c;
        monitor-enter(r101);
        this.f274560g.f274564e.removeMessages(1, this.f274558e);     // Catch: Throwable -> L11
        this.f274557d = null;     // Catch: Throwable -> L11
        this.f274559f = r100;     // Catch: Throwable -> L11
        Iterator r102 = ((HashMap) this.f274554a).values().iterator();     // Catch: Throwable -> L11
    L6:
        if (r102.hasNext() == false) goto L8;
        ((ServiceConnection) r102.next()).onServiceDisconnected(r100);     // Catch: Throwable -> L11
        goto L6
    L8:
        this.f274555b = 2;     // Catch: Throwable -> L11
        monitor-exit(r101);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public r(t r100, q r101) {
        this.f274560g = r100;
        this.f274558e = r101;
        this.f274554a = new HashMap();
        this.f274555b = 2;
    }

    public final void a(String r110, Executor r111) {
        this.f274555b = 3;
        StrictMode.VmPolicy r100 = StrictMode.getVmPolicy();
        if (PlatformVersion.isAtLeastS() == false) goto L16;
        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder(r100).permitUnsafeIntentLaunch().build());
    L16:
        t r101 = this.f274560g;     // Catch: Throwable -> L12
        ConnectionTracker r102 = r101.f274565f;     // Catch: Throwable -> L12
        Context r103 = r101.f274563d;     // Catch: Throwable -> L12
        boolean r112 = r102.zza(r103, r110, this.f274558e.a(r103), this, 4225, r111);     // Catch: Throwable -> L12
        this.f274556c = r112;     // Catch: Throwable -> L12
        if (r112 == false) goto L8;
        Message r113 = this.f274560g.f274564e.obtainMessage(1, this.f274558e);     // Catch: Throwable -> L12
        this.f274560g.f274564e.sendMessageDelayed(r113, this.f274560g.f274567h);     // Catch: Throwable -> L12
    L10:
        StrictMode.setVmPolicy(r100);
        return;
    L8:
        this.f274555b = 2;     // Catch: Throwable -> L12
        t r114 = this.f274560g;     // Catch: IllegalArgumentException -> L15 Throwable -> L12
        r114.f274565f.unbindService(r114.f274563d, this);     // Catch: IllegalArgumentException -> L15 Throwable -> L12
    L12:
        th = move-exception;
        StrictMode.setVmPolicy(r100);
        throw th;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName r100, IBinder r101) {
        HashMap r102 = this.f274560g.f274562c;
        monitor-enter(r102);
        this.f274560g.f274564e.removeMessages(1, this.f274558e);     // Catch: Throwable -> L11
        this.f274557d = r101;     // Catch: Throwable -> L11
        this.f274559f = r100;     // Catch: Throwable -> L11
        Iterator r103 = ((HashMap) this.f274554a).values().iterator();     // Catch: Throwable -> L11
    L6:
        if (r103.hasNext() == false) goto L8;
        ((ServiceConnection) r103.next()).onServiceConnected(r100, r101);     // Catch: Throwable -> L11
        goto L6
    L8:
        this.f274555b = 1;     // Catch: Throwable -> L11
        monitor-exit(r102);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }
}
