package com.ss.android.lark.dynamicconfig.interfaces;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import krc.b;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes35.dex */
public final class IDynamicManisServiceProxy implements IDynamicManisService, IInterface {
    public static final String DESCRIPTOR = "com.ss.android.lark.dynamicconfig.interfaces.IDynamicManisService";
    public static final int TRANSACTION_getDynamicDomain_String = 1;
    private IBinder mRemote;

    public String getInterfaceDescriptor() {
        return DESCRIPTOR;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.mRemote;
    }

    @Override // com.ss.android.lark.dynamicconfig.interfaces.IDynamicManisService
    public String getDynamicDomain(String r100) {
        Parcel r101 = Parcel.obtain();
        Parcel r102 = Parcel.obtain();
        r101.writeInterfaceToken(DESCRIPTOR);     // Catch: Throwable -> L5 RemoteException -> L7
        r101.writeString(r100);     // Catch: Throwable -> L5 RemoteException -> L7
        INVOKEINTERFACE_com_ss_android_lark_dynamicconfig_interfaces_IDynamicManisServiceProxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r101, r102, 0);     // Catch: Throwable -> L5 RemoteException -> L7
        r102.readException();     // Catch: Throwable -> L5 RemoteException -> L7
        String r103 = r102.readString();     // Catch: Throwable -> L5 RemoteException -> L7
        r102.recycle();
        r101.recycle();
    L13:
        return r103;
    L5:
        th = move-exception;
        r102.recycle();
        r101.recycle();
        throw th;
    L7:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L5
        b.b("IDynamicManisServiceProxy", "call method getDynamicDomain throw RemoteException", e);     // Catch: Throwable -> L5
        r102.recycle();
        r101.recycle();
        r103 = null;
        goto L13
    }

    public IDynamicManisServiceProxy(Context r100, IBinder r101) {
        this.mRemote = r101;
    }

    @Skip({"com.obric.assistant.interaction.impl.performance"})
    public static boolean INVOKEINTERFACE_com_ss_android_lark_dynamicconfig_interfaces_IDynamicManisServiceProxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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
