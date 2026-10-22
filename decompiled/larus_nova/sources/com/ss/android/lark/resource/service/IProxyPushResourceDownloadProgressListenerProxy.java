package com.ss.android.lark.resource.service;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes37.dex */
public final class IProxyPushResourceDownloadProgressListenerProxy implements a, IInterface {
    public static final String DESCRIPTOR = "com.ss.android.lark.resource.service.IProxyPushResourceDownloadProgressListener";
    public static final int TRANSACTION_onPushDownloadProgress_String_int_long_long = 1;
    private IBinder mRemote;

    public String getInterfaceDescriptor() {
        return DESCRIPTOR;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.mRemote;
    }

    public IProxyPushResourceDownloadProgressListenerProxy(IBinder r100) {
        this.mRemote = r100;
    }

    @Override // qpc.b
    public void onPushDownloadProgress(String r100, int r101, long r102, long r103) {
        Parcel r104 = Parcel.obtain();
        Parcel r105 = Parcel.obtain();
        r104.writeInterfaceToken(DESCRIPTOR);     // Catch: Throwable -> L5 RemoteException -> L7
        r104.writeString(r100);     // Catch: Throwable -> L5 RemoteException -> L7
        r104.writeInt(r101);     // Catch: Throwable -> L5 RemoteException -> L7
        r104.writeLong(r102);     // Catch: Throwable -> L5 RemoteException -> L7
        r104.writeLong(r103);     // Catch: Throwable -> L5 RemoteException -> L7
        INVOKEINTERFACE_com_ss_android_lark_resource_service_IProxyPushResourceDownloadProgressListenerProxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r104, r105, 0);     // Catch: Throwable -> L5 RemoteException -> L7
        r105.readException();     // Catch: Throwable -> L5 RemoteException -> L7
    L9:
        r105.recycle();
        r104.recycle();
        return;
    L5:
        th = move-exception;
        r105.recycle();
        r104.recycle();
        throw th;
    L7:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L5
        goto L9
    }

    @Skip({"com.obric.assistant.interaction.impl.performance"})
    public static boolean INVOKEINTERFACE_com_ss_android_lark_resource_service_IProxyPushResourceDownloadProgressListenerProxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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
