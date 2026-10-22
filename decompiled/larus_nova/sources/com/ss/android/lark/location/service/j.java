package com.ss.android.lark.location.service;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.ss.android.lark.log.Log;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes36.dex */
public final class j implements LocationListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f431203a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ List<LocationListener> f431204b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Job f431205c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ WeakReference<c> f431206d;

    @Override // android.location.LocationListener
    public final void onLocationChanged(Location r210) {
        ArrayList r110 = new ArrayList();
        boolean r111 = false;
        Object[] r112 = {r210};
        f06.b r113 = new f06.b();
        g06.a r100 = ApiHookConfig.f245611b.get(100038);
        if (r100 == null) goto L5;
        f06.a[] r101 = r100.f479473i;
    L6:
        f06.a[] r102 = r101;
        int r103 = r102.length;
        int r104 = 0;
    L8:
        if (r104 >= r103) goto L15;
        f06.a r105 = r102[r104];
        int r114 = r104;
        int r115 = r103;
        f06.a[] r211 = r102;
        f06.d r106 = r105.preInvoke(100038, "com/ss/android/lark/location/service/LocationManagerWithTimeout$getLocationListener$1", "onLocationChanged", this, r112, "void", r113);     // Catch: Exception -> L35
        if (r106.f474982a == true) goto L12;
        r110.add(r105);     // Catch: Exception -> L35
        goto L14
    L12:
        CancellationException r107 = null;
    L17:
        if (r106.f474982a == false) goto L19;
        return;
    L19:
        Intrinsics.checkNotNullParameter(r210, "location");
        Log.i("LocationManager.WithTimeout", "LocationManager onLocationChanged called, isContinuous = " + this.f431203a);
        if (this.f431203a == true) goto L28;
        LocationManagerWithTimeout r108 = LocationManagerWithTimeout.f431193a;
        LocationManagerWithTimeout.b(this.f431204b);
        Job r109 = this.f431205c;
        if (r109 != null) goto L24;
    L26:
        if (r111 == false) goto L28;
        return;
    L24:
        if (r109.isActive() == true) goto L26;
        r111 = true;
    L28:
        Job r116 = this.f431205c;
        if (r116 == null) goto L31;
        Job.DefaultImpls.cancel$default(r116, r107, 1, r107);
    L31:
        c r117 = this.f431206d.get();
        if (r117 == null) goto L41;
        r117.a();
        return;
    L41:
        return;
    L14:
        r104 = r114 + 1;
        r103 = r115;
        r102 = r211;
        goto L8
    L15:
        r107 = null;
        r106 = new f06.d(false, null);
        goto L17
    L5:
        r101 = ApiHookConfig.f245613d;
        goto L6
    }

    @Override // android.location.LocationListener
    public final void onProviderDisabled(String r100) {
        Intrinsics.checkNotNullParameter(r100, "p");
        Log.i("LocationManager.WithTimeout", "onProviderDisabled called. provider:" + r100);
    }

    @Override // android.location.LocationListener
    public final void onProviderEnabled(String r100) {
        Intrinsics.checkNotNullParameter(r100, "p");
        Log.i("LocationManager.WithTimeout", "onProviderEnabled called. provider:" + r100);
    }

    public j(List r100, Job r101, WeakReference r102) {
        this.f431203a = false;
        this.f431204b = r100;
        this.f431205c = r101;
        this.f431206d = r102;
    }

    @Override // android.location.LocationListener
    public final void onStatusChanged(String r100, int r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "p");
        Intrinsics.checkNotNullParameter(r102, "extras");
        Log.i("LocationManager.WithTimeout", "onStatusChanged called. provider:" + r100 + ", status:" + r101 + ", extras:" + r102);
    }
}
