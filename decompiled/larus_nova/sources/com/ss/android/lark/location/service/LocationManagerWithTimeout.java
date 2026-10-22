package com.ss.android.lark.location.service;

import android.app.Application;
import android.location.LocationListener;
import android.location.LocationManager;
import androidx.core.content.ContextCompat;
import com.ss.android.lark.log.Log;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

/* JADX INFO: loaded from: classes36.dex */
public final class LocationManagerWithTimeout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LocationManagerWithTimeout f431193a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f431194b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f431195c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f431196d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f431197e = null;

    public LocationManagerWithTimeout() {
    }

    static {
        f431193a = new LocationManagerWithTimeout();
        f431194b = LazyKt.lazy(LocationManagerWithTimeout$dispatcher$2.INSTANCE);
        f431195c = LazyKt.lazy(LocationManagerWithTimeout$scope$2.INSTANCE);
        f431196d = LazyKt.lazy(LocationManagerWithTimeout$context$2.INSTANCE);
        f431197e = LazyKt.lazy(LocationManagerWithTimeout$locationManager$2.INSTANCE);
        new WeakHashMap();
    }

    public static final boolean a() {
        LocationManagerWithTimeout r100 = f431193a;
        if (ContextCompat.checkSelfPermission(r100.getContext(), "android.permission.ACCESS_FINE_LOCATION") != 0) goto L5;
    L7:
        return false;
    L5:
        if (ContextCompat.checkSelfPermission(r100.getContext(), "android.permission.ACCESS_COARSE_LOCATION") == 0) goto L7;
        return true;
    }

    public static final /* synthetic */ Application c() {
        return f431193a.getContext();
    }

    private final Application getContext() {
        return (Application) f431196d.getValue();
    }

    public static final void b(List r100) {
        LocationManagerWithTimeout r101 = f431193a;
        monitor-enter(r101);
        List r102 = r100;     // Catch: Throwable -> L32
        if (r102 != null) goto L7;
    L10:
        boolean r103 = true;
    L11:
        if (r103 == false) goto L14;
        monitor-exit(r101);
        return;
    L14:
        Iterator r104 = r100.iterator();     // Catch: Throwable -> L32
    L16:
        if (r104.hasNext() == false) goto L29;
        LocationListener r105 = (LocationListener) r104.next();     // Catch: Throwable -> L32
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L24
        LocationManager r107 = (LocationManager) f431197e.getValue();     // Catch: Throwable -> L24
        if (fna.g.d() == true) goto L21;
        r107.removeUpdates(r105);     // Catch: Throwable -> L24
    L22:
        Object r108 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L24
    L26:
        Throwable r109 = Result.m9452exceptionOrNullimpl(r108);     // Catch: Throwable -> L32
        if (r109 == null) goto L16;
        Log.e("LocationManager.WithTimeout", "locationManager.removeUpdates error", r109);     // Catch: Throwable -> L32
        goto L16
    L21:
        r107.removeUpdates(r105);     // Catch: Throwable -> L24
        nna.a.a(r105.hashCode());     // Catch: Throwable -> L24
        goto L22
    L24:
        th = move-exception;
        Result.Companion r110 = Result.Companion;     // Catch: Throwable -> L32
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L32
        goto L26
    L29:
        r100.clear();     // Catch: Throwable -> L32
        monitor-exit(r101);
        return;
    L7:
        if (r102.isEmpty() == true) goto L10;
        r103 = false;
    L32:
        th = move-exception;
        throw th;
    }
}
