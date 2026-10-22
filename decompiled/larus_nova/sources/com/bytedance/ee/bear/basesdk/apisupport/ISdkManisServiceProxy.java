package com.bytedance.ee.bear.basesdk.apisupport;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes15.dex */
public final class ISdkManisServiceProxy implements ISdkManisService, IInterface {
    public static final String DESCRIPTOR = "com.bytedance.ee.bear.basesdk.apisupport.ISdkManisService";
    public static final int TRANSACTION_checkAndInit = 1;
    private IBinder mRemote;

    public String getInterfaceDescriptor() {
        return DESCRIPTOR;
    }

    @Override // com.bytedance.ee.bear.basesdk.apisupport.ISdkManisService
    public void checkAndInit() {
        Parcel r100 = Parcel.obtain();
        Parcel r101 = Parcel.obtain();
        r100.writeInterfaceToken(DESCRIPTOR);     // Catch: Throwable -> L5 RemoteException -> L7
        INVOKEINTERFACE_com_bytedance_ee_bear_basesdk_apisupport_ISdkManisServiceProxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r100, r101, 0);     // Catch: Throwable -> L5 RemoteException -> L7
        r101.readException();     // Catch: Throwable -> L5 RemoteException -> L7
    L9:
        r101.recycle();
        r100.recycle();
        return;
    L5:
        th = move-exception;
        r101.recycle();
        r100.recycle();
        throw th;
    L7:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L5
        krc.b.b("ISdkManisServiceProxy", "call method checkAndInit throw RemoteException", e);     // Catch: Throwable -> L5
        goto L9
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.mRemote;
    }

    public ISdkManisServiceProxy(Context r100, IBinder r101) {
        this.mRemote = r101;
    }

    @Skip({"com.obric.assistant.interaction.impl.performance"})
    public static boolean INVOKEINTERFACE_com_bytedance_ee_bear_basesdk_apisupport_ISdkManisServiceProxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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
