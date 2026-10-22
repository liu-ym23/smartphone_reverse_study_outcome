package com.ss.android.lark.passport_user.ipc;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import com.ss.android.lark.passport.signinsdk_api.account.User;
import java.util.ArrayList;
import java.util.List;
import krc.b;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes37.dex */
public final class IUserListStorageServiceByIPCProxy implements IUserListStorageServiceByIPC, IInterface {
    public static final String DESCRIPTOR = "com.ss.android.lark.passport_user.ipc.IUserListStorageServiceByIPC";
    public static final int TRANSACTION_getForegroundUser = 2;
    public static final int TRANSACTION_getUsers = 1;
    private IBinder mRemote;

    public String getInterfaceDescriptor() {
        return DESCRIPTOR;
    }

    @Override // com.ss.android.lark.passport_user.ipc.IUserListStorageServiceByIPC
    public User getForegroundUser() {
        Parcel r100 = Parcel.obtain();
        Parcel r101 = Parcel.obtain();
        r100.writeInterfaceToken(DESCRIPTOR);     // Catch: Throwable -> L7 RemoteException -> L9
        INVOKEINTERFACE_com_ss_android_lark_passport_user_ipc_IUserListStorageServiceByIPCProxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r100, r101, 0);     // Catch: Throwable -> L7 RemoteException -> L9
        r101.readException();     // Catch: Throwable -> L7 RemoteException -> L9
        if (r101.readInt() == 0) goto L11;
        User r102 = User.CREATOR.createFromParcel(r101);     // Catch: Throwable -> L7 RemoteException -> L9
    L12:
        r101.recycle();
        r100.recycle();
        return r102;
    L11:
        r102 = null;
    L7:
        th = move-exception;
        r101.recycle();
        r100.recycle();
        throw th;
    L9:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L7
        b.b("IUserListStorageServiceByIPCProxy", "call method getForegroundUser throw RemoteException", e);     // Catch: Throwable -> L7
        goto L11
    }

    @Override // com.ss.android.lark.passport_user.ipc.IUserListStorageServiceByIPC
    public List<User> getUsers() {
        Parcel r100 = Parcel.obtain();
        Parcel r101 = Parcel.obtain();
        r100.writeInterfaceToken(DESCRIPTOR);     // Catch: Throwable -> L5 RemoteException -> L7
        INVOKEINTERFACE_com_ss_android_lark_passport_user_ipc_IUserListStorageServiceByIPCProxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r100, r101, 0);     // Catch: Throwable -> L5 RemoteException -> L7
        r101.readException();     // Catch: Throwable -> L5 RemoteException -> L7
        ArrayList r102 = r101.readArrayList(IUserListStorageServiceByIPCProxy.class.getClassLoader());     // Catch: Throwable -> L5 RemoteException -> L7
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
        b.b("IUserListStorageServiceByIPCProxy", "call method getUsers throw RemoteException", e);     // Catch: Throwable -> L5
        r101.recycle();
        r100.recycle();
        r102 = null;
        goto L13
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.mRemote;
    }

    public IUserListStorageServiceByIPCProxy(Context r100, IBinder r101) {
        this.mRemote = r101;
    }

    @Skip({"com.obric.assistant.interaction.impl.performance"})
    public static boolean INVOKEINTERFACE_com_ss_android_lark_passport_user_ipc_IUserListStorageServiceByIPCProxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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
