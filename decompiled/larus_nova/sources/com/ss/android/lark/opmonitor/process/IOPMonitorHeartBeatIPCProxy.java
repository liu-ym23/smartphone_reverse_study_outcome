package com.ss.android.lark.opmonitor.process;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import com.ss.android.lark.opmonitor.api.IOPMonitorHeartBeatListenerStub;
import com.ss.android.lark.opmonitor.model.OPMonitorHeartBeatMonitorData;
import eyb.a;
import krc.b;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes37.dex */
public final class IOPMonitorHeartBeatIPCProxy implements a, IInterface {
    public static final String DESCRIPTOR = "com.ss.android.lark.opmonitor.process.IOPMonitorHeartBeatIPC";
    public static final int TRANSACTION_endHeartBeat_String = 2;
    public static final int TRANSACTION_registerHeartBeat_OPMonitorHeartBeatMonitorData_IOPMonitorHeartBeatListener = 1;
    public static final int TRANSACTION_setLarkStatus_boolean = 3;
    private IBinder mRemote;

    public String getInterfaceDescriptor() {
        return DESCRIPTOR;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.mRemote;
    }

    public void endHeartBeat(String r100) {
        Parcel r101 = Parcel.obtain();
        Parcel r102 = Parcel.obtain();
        r101.writeInterfaceToken(DESCRIPTOR);     // Catch: Throwable -> L5 RemoteException -> L7
        r101.writeString(r100);     // Catch: Throwable -> L5 RemoteException -> L7
        INVOKEINTERFACE_com_ss_android_lark_opmonitor_process_IOPMonitorHeartBeatIPCProxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r101, r102, 0);     // Catch: Throwable -> L5 RemoteException -> L7
        r102.readException();     // Catch: Throwable -> L5 RemoteException -> L7
    L9:
        r102.recycle();
        r101.recycle();
        return;
    L7:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L5
        b.b("IOPMonitorHeartBeatIPCProxy", "call method endHeartBeat throw RemoteException", e);     // Catch: Throwable -> L5
    L5:
        th = move-exception;
        r102.recycle();
        r101.recycle();
        throw th;
    }

    public void setLarkStatus(boolean r100) {
        Parcel r101 = Parcel.obtain();
        Parcel r102 = Parcel.obtain();
        r101.writeInterfaceToken(DESCRIPTOR);     // Catch: Throwable -> L9 RemoteException -> L11
        if (r100 == false) goto L6;
        int r103 = 1;
    L7:
        r101.writeInt(r103);     // Catch: Throwable -> L9 RemoteException -> L11
        INVOKEINTERFACE_com_ss_android_lark_opmonitor_process_IOPMonitorHeartBeatIPCProxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r101, r102, 0);     // Catch: Throwable -> L9 RemoteException -> L11
        r102.readException();     // Catch: Throwable -> L9 RemoteException -> L11
    L13:
        r102.recycle();
        r101.recycle();
        return;
    L6:
        r103 = 0;
    L9:
        th = move-exception;
        r102.recycle();
        r101.recycle();
        throw th;
    L11:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L9
        b.b("IOPMonitorHeartBeatIPCProxy", "call method setLarkStatus throw RemoteException", e);     // Catch: Throwable -> L9
        goto L13
    }

    public IOPMonitorHeartBeatIPCProxy(Context r100, IBinder r101) {
        this.mRemote = r101;
    }

    public void registerHeartBeat(OPMonitorHeartBeatMonitorData r100, byb.a r101) {
        Parcel r102 = Parcel.obtain();
        Parcel r103 = Parcel.obtain();
        r102.writeInterfaceToken(DESCRIPTOR);     // Catch: Throwable -> L12 RemoteException -> L14
        if (r100 == null) goto L6;
        r102.writeInt(1);     // Catch: Throwable -> L12 RemoteException -> L14
        r100.writeToParcel(r102, 0);     // Catch: Throwable -> L12 RemoteException -> L14
    L7:
        if (r101 == null) goto L9;
        r102.writeStrongBinder(new IOPMonitorHeartBeatListenerStub(r101).asBinder());     // Catch: Throwable -> L12 RemoteException -> L14
    L10:
        INVOKEINTERFACE_com_ss_android_lark_opmonitor_process_IOPMonitorHeartBeatIPCProxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r102, r103, 0);     // Catch: Throwable -> L12 RemoteException -> L14
        r103.readException();     // Catch: Throwable -> L12 RemoteException -> L14
    L16:
        r103.recycle();
        r102.recycle();
        return;
    L9:
        r102.writeStrongBinder(null);     // Catch: Throwable -> L12 RemoteException -> L14
        goto L10
    L6:
        r102.writeInt(0);     // Catch: Throwable -> L12 RemoteException -> L14
    L12:
        th = move-exception;
        r103.recycle();
        r102.recycle();
        throw th;
    L14:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L12
        b.b("IOPMonitorHeartBeatIPCProxy", "call method registerHeartBeat throw RemoteException", e);     // Catch: Throwable -> L12
        goto L16
    }

    @Skip({"com.obric.assistant.interaction.impl.performance"})
    public static boolean INVOKEINTERFACE_com_ss_android_lark_opmonitor_process_IOPMonitorHeartBeatIPCProxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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
