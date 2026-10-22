package com.google.android.gms.common.stats;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.u;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes23.dex */
public class ConnectionTracker {

    /* JADX INFO: renamed from: zzb, reason: collision with root package name */
    private static final Object f274585zzb = null;

    @Nullable
    private static volatile ConnectionTracker zzc;

    /* JADX INFO: renamed from: zza, reason: collision with root package name */
    public final ConcurrentHashMap f274586zza;

    static {
        f274585zzb = new Object();
    }

    private static boolean zzd(ServiceConnection r100) {
        if ((r100 instanceof u) == true) goto L6;
        return true;
    L6:
        return false;
    }

    public static ConnectionTracker getInstance() {
        if (zzc != null) goto L14;
        Object r100 = f274585zzb;
        monitor-enter(r100);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (zzc != null) goto L9;
        zzc = new ConnectionTracker();     // Catch: Throwable -> L11
    L9:
        monitor-exit(r100);     // Catch: Throwable -> L11
    L14:
        ConnectionTracker r101 = zzc;
        Preconditions.checkNotNull(r101);
        return r101;
    }

    private ConnectionTracker() {
        this.f274586zza = new ConcurrentHashMap();
    }

    private static void zzb(Context r100, ServiceConnection r101) {
        r100.unbindService(r101);     // Catch: Throwable -> L4
        return;
    }

    public void unbindService(Context r100, ServiceConnection r101) {
        if (zzd(r101) == true) goto L5;
    L12:
        zzb(r100, r101);
        return;
    L5:
        if (this.f274586zza.containsKey(r101) == false) goto L12;
        zzb(r100, (ServiceConnection) this.f274586zza.get(r101));     // Catch: Throwable -> L9
        this.f274586zza.remove(r101);
        return;
    L9:
        th = move-exception;
        this.f274586zza.remove(r101);
        throw th;
    }

    public void unbindServiceSafe(Context r100, ServiceConnection r101) {
        unbindService(r100, r101);     // Catch: IllegalArgumentException -> L4
        return;
    }

    @ResultIgnorabilityUnspecified
    public boolean bindService(Context r110, Intent r111, ServiceConnection r112, int r113) {
        return zzc(r110, r110.getClass().getName(), r111, r112, r113, true, null);
    }

    private static final boolean zze(Context r100, Intent r101, ServiceConnection r102, int r103, @Nullable Executor r104) {
        if (r104 != null) goto L5;
        r104 = null;
    L5:
        if (PlatformVersion.isAtLeastQ() == false) goto L10;
        if (r104 == null) goto L10;
        return r100.bindService(r101, r103, r104, r102);
    L10:
        return r100.bindService(r101, r102, r103);
    }

    @ResultIgnorabilityUnspecified
    public final boolean zza(Context r100, String r110, Intent r111, ServiceConnection r112, int r113, @Nullable Executor r114) {
        return zzc(r100, r110, r111, r112, 4225, true, r114);
    }

    private final boolean zzc(Context r100, String r101, Intent r102, ServiceConnection r103, int r104, boolean r105, @Nullable Executor r106) {
        ComponentName r107 = r102.getComponent();
        if (r107 == null) goto L12;
        String r108 = r107.getPackageName();
        "com.google.android.gms".equals(r108);
        if ((Wrappers.packageManager(r100).getApplicationInfo(r108, 0).flags & 2097152) == 0) goto L12;
        return false;
    L12:
        if (zzd(r103) == false) goto L26;
        ServiceConnection r109 = (ServiceConnection) this.f274586zza.putIfAbsent(r103, r103);
        if (r109 == null) goto L27;
        if (r103 == r109) goto L27;
        String.format("Duplicate binding with the same ServiceConnection: %s, %s, %s.", new Object[]{r103, r101, r102.getAction()});
    L27:
        boolean r110 = zze(r100, r102, r103, r104, r106);     // Catch: Throwable -> L22
        if (r110 == true) goto L31;
        this.f274586zza.remove(r103, r103);
        return false;
    L31:
        return r110;
    L22:
        th = move-exception;
        this.f274586zza.remove(r103, r103);
        throw th;
    L26:
        return zze(r100, r102, r103, r104, r106);
    }
}
