package com.google.android.gms.internal.common;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes23.dex */
public class zza implements IInterface {

    /* JADX INFO: renamed from: zza, reason: collision with root package name */
    private final IBinder f274652zza;

    /* JADX INFO: renamed from: zzb, reason: collision with root package name */
    private final String f274653zzb;

    public zza(IBinder r100, String r101) {
        this.f274652zza = r100;
        this.f274653zzb = r101;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f274652zza;
    }

    public final Parcel zza() {
        Parcel r100 = Parcel.obtain();
        r100.writeInterfaceToken(this.f274653zzb);
        return r100;
    }

    public final Parcel zzB(int r100, Parcel r101) throws RemoteException {
        Parcel r102 = Parcel.obtain();
        INVOKEINTERFACE_com_google_android_gms_internal_common_zza_com_obric_assistant_interaction_impl_BinderLancet_transact(this.f274652zza, r100, r101, r102, 0);     // Catch: Throwable -> L6 RuntimeException -> L8
        r102.readException();     // Catch: Throwable -> L6 RuntimeException -> L8
        r101.recycle();
        return r102;
    L6:
        th = move-exception;
        r101.recycle();
        throw th;
    L8:
        e = move-exception;
        r102.recycle();     // Catch: Throwable -> L6
        throw e;     // Catch: Throwable -> L6
    }

    public final void zzC(int r100, Parcel r101) throws RemoteException {
        Parcel r102 = Parcel.obtain();
        INVOKEINTERFACE_com_google_android_gms_internal_common_zza_com_obric_assistant_interaction_impl_BinderLancet_transact(this.f274652zza, 1, r101, r102, 0);     // Catch: Throwable -> L6
        r102.readException();     // Catch: Throwable -> L6
        r101.recycle();
        r102.recycle();
        return;
    L6:
        th = move-exception;
        r101.recycle();
        r102.recycle();
        throw th;
    }

    public final void zzD(int r100, Parcel r101) throws RemoteException {
        INVOKEINTERFACE_com_google_android_gms_internal_common_zza_com_obric_assistant_interaction_impl_BinderLancet_transact(this.f274652zza, 2, r101, null, 1);     // Catch: Throwable -> L5
        r101.recycle();
        return;
    L5:
        th = move-exception;
        r101.recycle();
        throw th;
    }

    @Skip({"com.obric.assistant.interaction.impl.performance"})
    public static boolean INVOKEINTERFACE_com_google_android_gms_internal_common_zza_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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
