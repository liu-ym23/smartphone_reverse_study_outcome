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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
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
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken(DESCRIPTOR);     // Catch: Throwable -> L5 RemoteException -> L7
        INVOKEINTERFACE_com_bytedance_ee_bear_document_analytic_processmonitor_sandbox_ISandboxProcessServerProxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r0, r1, 0);     // Catch: Throwable -> L5 RemoteException -> L7
        r1.readException();     // Catch: Throwable -> L5 RemoteException -> L7
        long r2 = r1.readLong();     // Catch: Throwable -> L5 RemoteException -> L7
        r1.recycle();
        r0.recycle();
    L13:
        return r2;
    L5:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    L7:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L5
        b.b("ISandboxProcessServerProxy", "call method getSandboxCPUTime throw RemoteException", e);     // Catch: Throwable -> L5
        r1.recycle();
        r0.recycle();
        r2 = 0;
        goto L13
    }

    @Override // com.bytedance.ee.bear.document.analytic.processmonitor.sandbox.ISandboxProcessServer
    public long getSandboxMemory() {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken(DESCRIPTOR);     // Catch: Throwable -> L5 RemoteException -> L7
        INVOKEINTERFACE_com_bytedance_ee_bear_document_analytic_processmonitor_sandbox_ISandboxProcessServerProxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r0, r1, 0);     // Catch: Throwable -> L5 RemoteException -> L7
        r1.readException();     // Catch: Throwable -> L5 RemoteException -> L7
        long r2 = r1.readLong();     // Catch: Throwable -> L5 RemoteException -> L7
        r1.recycle();
        r0.recycle();
    L13:
        return r2;
    L5:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    L7:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L5
        b.b("ISandboxProcessServerProxy", "call method getSandboxMemory throw RemoteException", e);     // Catch: Throwable -> L5
        r1.recycle();
        r0.recycle();
        r2 = 0;
        goto L13
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.mRemote;
    }

    public ISandboxProcessServerProxy(Context r1, IBinder r2) {
        this.mRemote = r2;
    }

    @Override // com.bytedance.ee.bear.document.analytic.processmonitor.sandbox.ISandboxProcessServer
    public CpuInfo getCurrentCpuRate(String r4, boolean r5) {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken(DESCRIPTOR);     // Catch: Throwable -> L11 RemoteException -> L13
        r0.writeString(r4);     // Catch: Throwable -> L11 RemoteException -> L13
        if (r5 == false) goto L6;
        int r6 = 1;
    L7:
        r0.writeInt(r6);     // Catch: Throwable -> L11 RemoteException -> L13
        INVOKEINTERFACE_com_bytedance_ee_bear_document_analytic_processmonitor_sandbox_ISandboxProcessServerProxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r0, r1, 0);     // Catch: Throwable -> L11 RemoteException -> L13
        r1.readException();     // Catch: Throwable -> L11 RemoteException -> L13
        if (r1.readInt() == 0) goto L15;
        CpuInfo r7 = CpuInfo.CREATOR.createFromParcel(r1);     // Catch: Throwable -> L11 RemoteException -> L13
    L16:
        r1.recycle();
        r0.recycle();
        return r7;
    L15:
        r7 = null;
        goto L16
    L6:
        r6 = 0;
    L11:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    L13:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L11
        b.b("ISandboxProcessServerProxy", "call method getCurrentCpuRate throw RemoteException", e);     // Catch: Throwable -> L11
        goto L15
    }

    @Skip({"com.obric.assistant.interaction.impl.performance"})
    public static boolean INVOKEINTERFACE_com_bytedance_ee_bear_document_analytic_processmonitor_sandbox_ISandboxProcessServerProxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r16, int r17, Parcel r18, Parcel r19, int r110) throws RemoteException {
        if (Looper.myLooper() != Looper.getMainLooper()) goto L5;
        long r2 = SystemClock.uptimeMillis();
        boolean r0 = r16.transact(r17, r18, r19, r110);     // Catch: Throwable -> L12
        long r8 = SystemClock.uptimeMillis() - r2;
        if (r8 < 100) goto L11;
        BinderPerformanceReporter.report(r8, r16.getClass().getName(), r17, r110, new Throwable("Slow main-thread Binder transaction"));
    L11:
        return r0;
    L12:
        th = move-exception;
        long r9 = SystemClock.uptimeMillis() - r2;
        if (r9 < 100) goto L22;
        if (r16 != null) goto L17;
        String r1 = "";
    L18:
        BinderPerformanceReporter.report(r9, r1, r17, r110, new Throwable("Slow main-thread Binder transaction"));
        throw th;
    L17:
        r1 = r16.getClass().getName();
        goto L18
    L22:
        throw th;
    L5:
        return r16.transact(r17, r18, r19, r110);
    }
}
