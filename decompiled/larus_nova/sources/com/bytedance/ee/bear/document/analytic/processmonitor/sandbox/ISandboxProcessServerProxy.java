package com.bytedance.ee.bear.document.analytic.processmonitor.sandbox;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.bytedance.ee.bear.document.analytic.processmonitor.entity.CpuInfo;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import krc.b;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes16.dex */
public final class ISandboxProcessServerProxy implements ISandboxProcessServer, IInterface {
    public static final String DESCRIPTOR = "com.bytedance.ee.bear.document.analytic.processmonitor.sandbox.ISandboxProcessServer";
    public static final int TRANSACTION_getCurrentCpuRate_String_boolean = 2;
    public static final int TRANSACTION_getSandboxCPUTime = 1;
    public static final int TRANSACTION_getSandboxMemory = 3;
    private IBinder mRemote;

    public String getInterfaceDescriptor() {
        return DESCRIPTOR;
    }

    @Override // com.bytedance.ee.bear.document.analytic.processmonitor.sandbox.ISandboxProcessServer
    public long getSandboxCPUTime() {
        Parcel r100 = Parcel.obtain();
        Parcel r101 = Parcel.obtain();
        r100.writeInterfaceToken(DESCRIPTOR);     // Catch: Throwable -> L5 RemoteException -> L7
        INVOKEINTERFACE_com_bytedance_ee_bear_document_analytic_processmonitor_sandbox_ISandboxProcessServerProxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r100, r101, 0);     // Catch: Throwable -> L5 RemoteException -> L7
        r101.readException();     // Catch: Throwable -> L5 RemoteException -> L7
        long r102 = r101.readLong();     // Catch: Throwable -> L5 RemoteException -> L7
        r101.recycle();
        r100.recycle();
    L13:
        return r102;
    L5:
        th = move-exception;
        r101.recycle();
        r100.recycle();
        throw th;
    L7:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L5
        b.b("ISandboxProcessServerProxy", "call method getSandboxCPUTime throw RemoteException", e);     // Catch: Throwable -> L5
        r101.recycle();
        r100.recycle();
        r102 = 0;
        goto L13
    }

    @Override // com.bytedance.ee.bear.document.analytic.processmonitor.sandbox.ISandboxProcessServer
    public long getSandboxMemory() {
        Parcel r100 = Parcel.obtain();
        Parcel r101 = Parcel.obtain();
        r100.writeInterfaceToken(DESCRIPTOR);     // Catch: Throwable -> L5 RemoteException -> L7
        INVOKEINTERFACE_com_bytedance_ee_bear_document_analytic_processmonitor_sandbox_ISandboxProcessServerProxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r100, r101, 0);     // Catch: Throwable -> L5 RemoteException -> L7
        r101.readException();     // Catch: Throwable -> L5 RemoteException -> L7
        long r102 = r101.readLong();     // Catch: Throwable -> L5 RemoteException -> L7
        r101.recycle();
        r100.recycle();
    L13:
        return r102;
    L5:
        th = move-exception;
        r101.recycle();
        r100.recycle();
        throw th;
    L7:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L5
        b.b("ISandboxProcessServerProxy", "call method getSandboxMemory throw RemoteException", e);     // Catch: Throwable -> L5
        r101.recycle();
        r100.recycle();
        r102 = 0;
        goto L13
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.mRemote;
    }

    public ISandboxProcessServerProxy(Context r100, IBinder r101) {
        this.mRemote = r101;
    }

    @Override // com.bytedance.ee.bear.document.analytic.processmonitor.sandbox.ISandboxProcessServer
    public CpuInfo getCurrentCpuRate(String r100, boolean r101) {
        Parcel r102 = Parcel.obtain();
        Parcel r103 = Parcel.obtain();
        r102.writeInterfaceToken(DESCRIPTOR);     // Catch: Throwable -> L11 RemoteException -> L13
        r102.writeString(r100);     // Catch: Throwable -> L11 RemoteException -> L13
        if (r101 == false) goto L6;
        int r104 = 1;
    L7:
        r102.writeInt(r104);     // Catch: Throwable -> L11 RemoteException -> L13
        INVOKEINTERFACE_com_bytedance_ee_bear_document_analytic_processmonitor_sandbox_ISandboxProcessServerProxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r102, r103, 0);     // Catch: Throwable -> L11 RemoteException -> L13
        r103.readException();     // Catch: Throwable -> L11 RemoteException -> L13
        if (r103.readInt() == 0) goto L15;
        CpuInfo r105 = CpuInfo.CREATOR.createFromParcel(r103);     // Catch: Throwable -> L11 RemoteException -> L13
    L16:
        r103.recycle();
        r102.recycle();
        return r105;
    L15:
        r105 = null;
        goto L16
    L6:
        r104 = 0;
    L11:
        th = move-exception;
        r103.recycle();
        r102.recycle();
        throw th;
    L13:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L11
        b.b("ISandboxProcessServerProxy", "call method getCurrentCpuRate throw RemoteException", e);     // Catch: Throwable -> L11
        goto L15
    }

    @Skip({"com.obric.assistant.interaction.impl.performance"})
    public static boolean INVOKEINTERFACE_com_bytedance_ee_bear_document_analytic_processmonitor_sandbox_ISandboxProcessServerProxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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
