package com.ss.android.lark.audit_provider;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import com.ss.android.lark.audit.db.AuditDBData;
import java.util.ArrayList;
import java.util.List;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes34.dex */
public final class IDataIPCServiceProxy implements IDataIPCService, IInterface {
    public static final String DESCRIPTOR = "com.ss.android.lark.audit_provider.IDataIPCService";
    public static final int TRANSACTION_deleteAuditData_String_List__AuditDBData = 3;
    public static final int TRANSACTION_queryAuditData_String_int = 2;
    public static final int TRANSACTION_recordAuditData_String_String = 1;
    private IBinder mRemote;

    public String getInterfaceDescriptor() {
        return DESCRIPTOR;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.mRemote;
    }

    public IDataIPCServiceProxy(Context r100, IBinder r101) {
        this.mRemote = r101;
    }

    @Override // com.ss.android.lark.audit_provider.IDataIPCService, gwa.g.a
    public void deleteAuditData(String r100, List<AuditDBData> r101) {
        Parcel r102 = Parcel.obtain();
        Parcel r103 = Parcel.obtain();
        r102.writeInterfaceToken(DESCRIPTOR);     // Catch: Throwable -> L5 RemoteException -> L7
        r102.writeString(r100);     // Catch: Throwable -> L5 RemoteException -> L7
        r102.writeList(r101);     // Catch: Throwable -> L5 RemoteException -> L7
        INVOKEINTERFACE_com_ss_android_lark_audit_provider_IDataIPCServiceProxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r102, r103, 0);     // Catch: Throwable -> L5 RemoteException -> L7
        r103.readException();     // Catch: Throwable -> L5 RemoteException -> L7
    L9:
        r103.recycle();
        r102.recycle();
        return;
    L7:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L5
        krc.b.b("IDataIPCServiceProxy", "call method deleteAuditData throw RemoteException", e);     // Catch: Throwable -> L5
    L5:
        th = move-exception;
        r103.recycle();
        r102.recycle();
        throw th;
    }

    @Override // com.ss.android.lark.audit_provider.IDataIPCService, gwa.g.a
    public List<AuditDBData> queryAuditData(String r100, int r101) {
        Parcel r102 = Parcel.obtain();
        Parcel r103 = Parcel.obtain();
        r102.writeInterfaceToken(DESCRIPTOR);     // Catch: Throwable -> L5 RemoteException -> L7
        r102.writeString(r100);     // Catch: Throwable -> L5 RemoteException -> L7
        r102.writeInt(r101);     // Catch: Throwable -> L5 RemoteException -> L7
        INVOKEINTERFACE_com_ss_android_lark_audit_provider_IDataIPCServiceProxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r102, r103, 0);     // Catch: Throwable -> L5 RemoteException -> L7
        r103.readException();     // Catch: Throwable -> L5 RemoteException -> L7
        ArrayList r104 = r103.readArrayList(IDataIPCServiceProxy.class.getClassLoader());     // Catch: Throwable -> L5 RemoteException -> L7
        r103.recycle();
        r102.recycle();
        return r104;
    L7:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L5
        krc.b.b("IDataIPCServiceProxy", "call method queryAuditData throw RemoteException", e);     // Catch: Throwable -> L5
        r103.recycle();
        r102.recycle();
        return null;
    L5:
        th = move-exception;
        r103.recycle();
        r102.recycle();
        throw th;
    }

    @Override // com.ss.android.lark.audit_provider.IDataIPCService, gwa.g.a
    public void recordAuditData(String r100, String r101) {
        Parcel r102 = Parcel.obtain();
        Parcel r103 = Parcel.obtain();
        r102.writeInterfaceToken(DESCRIPTOR);     // Catch: Throwable -> L5 RemoteException -> L7
        r102.writeString(r100);     // Catch: Throwable -> L5 RemoteException -> L7
        r102.writeString(r101);     // Catch: Throwable -> L5 RemoteException -> L7
        INVOKEINTERFACE_com_ss_android_lark_audit_provider_IDataIPCServiceProxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r102, r103, 0);     // Catch: Throwable -> L5 RemoteException -> L7
        r103.readException();     // Catch: Throwable -> L5 RemoteException -> L7
    L9:
        r103.recycle();
        r102.recycle();
        return;
    L7:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L5
        krc.b.b("IDataIPCServiceProxy", "call method recordAuditData throw RemoteException", e);     // Catch: Throwable -> L5
    L5:
        th = move-exception;
        r103.recycle();
        r102.recycle();
        throw th;
    }

    @Skip({"com.obric.assistant.interaction.impl.performance"})
    public static boolean INVOKEINTERFACE_com_ss_android_lark_audit_provider_IDataIPCServiceProxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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
