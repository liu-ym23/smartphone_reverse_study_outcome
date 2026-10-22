package com.ss.android.lark.security.compliance.infra.util;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes38.dex */
public final class ILogMonitorServiceProxy implements ILogMonitorService, IInterface {
    public static final String DESCRIPTOR = "com.ss.android.lark.security.compliance.infra.util.ILogMonitorService";
    public static final int TRANSACTION_getMsgId = 2;
    public static final int TRANSACTION_getTraceId = 1;
    private IBinder mRemote;

    public String getInterfaceDescriptor() {
        return DESCRIPTOR;
    }

    @Override // com.ss.android.lark.security.compliance.infra.util.ILogMonitorService
    public int getMsgId() {
        Parcel r100 = Parcel.obtain();
        Parcel r101 = Parcel.obtain();
        int r102 = 0;
        r100.writeInterfaceToken(DESCRIPTOR);     // Catch: Throwable -> L5 RemoteException -> L7
        INVOKEINTERFACE_com_ss_android_lark_security_compliance_infra_util_ILogMonitorServiceProxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r100, r101, 0);     // Catch: Throwable -> L5 RemoteException -> L7
        r101.readException();     // Catch: Throwable -> L5 RemoteException -> L7
        r102 = r101.readInt();     // Catch: Throwable -> L5 RemoteException -> L7
    L9:
        r101.recycle();
        r100.recycle();
        return r102;
    L7:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L5
        krc.b.b("ILogMonitorServiceProxy", "call method getMsgId throw RemoteException", e);     // Catch: Throwable -> L5
    L5:
        th = move-exception;
        r101.recycle();
        r100.recycle();
        throw th;
    }

    @Override // com.ss.android.lark.security.compliance.infra.util.ILogMonitorService
    public String getTraceId() {
        Parcel r100 = Parcel.obtain();
        Parcel r101 = Parcel.obtain();
        r100.writeInterfaceToken(DESCRIPTOR);     // Catch: Throwable -> L5 RemoteException -> L7
        INVOKEINTERFACE_com_ss_android_lark_security_compliance_infra_util_ILogMonitorServiceProxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r100, r101, 0);     // Catch: Throwable -> L5 RemoteException -> L7
        r101.readException();     // Catch: Throwable -> L5 RemoteException -> L7
        String r102 = r101.readString();     // Catch: Throwable -> L5 RemoteException -> L7
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
        krc.b.b("ILogMonitorServiceProxy", "call method getTraceId throw RemoteException", e);     // Catch: Throwable -> L5
        r101.recycle();
        r100.recycle();
        r102 = null;
        goto L13
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.mRemote;
    }

    public ILogMonitorServiceProxy(Context r100, IBinder r101) {
        this.mRemote = r101;
    }

    @Skip({"com.obric.assistant.interaction.impl.performance"})
    public static boolean INVOKEINTERFACE_com_ss_android_lark_security_compliance_infra_util_ILogMonitorServiceProxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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
