package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes23.dex */
final class zzad implements IGmsServiceBroker {

    /* JADX INFO: renamed from: zza, reason: collision with root package name */
    private final IBinder f274572zza;

    public zzad(IBinder r100) {
        this.f274572zza = r100;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f274572zza;
    }

    @Override // com.google.android.gms.common.internal.IGmsServiceBroker
    public final void getService(IGmsCallbacks r100, GetServiceRequest r101) throws RemoteException {
        Parcel r102 = Parcel.obtain();
        Parcel r103 = Parcel.obtain();
        r102.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");     // Catch: Throwable -> L14
        if (r100 == null) goto L6;
        IBinder r104 = r100.asBinder();     // Catch: Throwable -> L14
    L7:
        r102.writeStrongBinder(r104);     // Catch: Throwable -> L14
        if (r101 == null) goto L10;
        r102.writeInt(1);     // Catch: Throwable -> L14
        p.a(r101, r102, 0);     // Catch: Throwable -> L14
    L11:
        INVOKEINTERFACE_com_google_android_gms_common_internal_zzad_com_obric_assistant_interaction_impl_BinderLancet_transact(this.f274572zza, 46, r102, r103, 0);     // Catch: Throwable -> L14
        r103.readException();     // Catch: Throwable -> L14
        r103.recycle();
        r102.recycle();
        return;
    L10:
        r102.writeInt(0);     // Catch: Throwable -> L14
        goto L11
    L6:
        r104 = null;
    L14:
        th = move-exception;
        r103.recycle();
        r102.recycle();
        throw th;
    }

    @Skip({"com.obric.assistant.interaction.impl.performance"})
    public static boolean INVOKEINTERFACE_com_google_android_gms_common_internal_zzad_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
        if (Looper.myLooper() != Looper.getMainLooper()) goto L5;
        long r100 = SystemClock.uptimeMillis();
        boolean r101 = r110.transact(r111, r112, r113, r114);     // Catch: Throwable -> L12
        long r102 = SystemClock.uptimeMillis() - r100;
        if (r102 < 100) goto L11;
        BinderPerformanceReporter.report(r102, r110.getClass().getName(), r111, r114, new Throwable("Slow main-thread Binder transaction"));
    L11:
        return r101;
    L12:
        th = move-exception;
        long r103 = SystemClock.uptimeMillis() - r100;
        if (r103 < 100) goto L22;
        if (r110 != null) goto L17;
        String r104 = "";
    L18:
        BinderPerformanceReporter.report(r103, r104, r111, r114, new Throwable("Slow main-thread Binder transaction"));
        throw th;
    L17:
        r104 = r110.getClass().getName();
        goto L18
    L22:
        throw th;
    L5:
        return r110.transact(r111, r112, r113, r114);
    }
}
