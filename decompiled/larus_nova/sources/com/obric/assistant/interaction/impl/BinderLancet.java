package com.obric.assistant.interaction.impl;

import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import me.ele.lancet.base.Origin;
import me.ele.lancet.base.This;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes33.dex */
public class BinderLancet {
    public BinderLancet() {
    }

    @Skip({"com.obric.assistant.interaction.impl.performance"})
    public boolean transact(int r110, Parcel r111, Parcel r112, int r210) throws RemoteException {
        String r100 = "";
        if (Looper.myLooper() != Looper.getMainLooper()) goto L5;
        Object r101 = This.get();
        long r102 = SystemClock.uptimeMillis();
        boolean r103 = ((Boolean) Origin.call()).booleanValue();     // Catch: Throwable -> L15
        long r113 = SystemClock.uptimeMillis() - r102;
        if (r113 < 100) goto L14;
        if (r101 == null) goto L13;
        r100 = r101.getClass().getName();
    L13:
        BinderPerformanceReporter.report(r113, r100, r110, r210, new Throwable("Slow main-thread Binder transaction"));
    L14:
        return r103;
    L15:
        th = move-exception;
        long r114 = SystemClock.uptimeMillis() - r102;
        if (r114 < 100) goto L22;
        if (r101 == null) goto L21;
        r100 = r101.getClass().getName();
    L21:
        BinderPerformanceReporter.report(r114, r100, r110, r210, new Throwable("Slow main-thread Binder transaction"));
    L22:
        throw th;
    L5:
        return ((Boolean) Origin.call()).booleanValue();
    }
}
