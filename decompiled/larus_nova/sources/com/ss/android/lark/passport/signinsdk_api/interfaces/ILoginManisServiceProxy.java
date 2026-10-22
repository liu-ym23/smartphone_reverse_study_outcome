package com.ss.android.lark.passport.signinsdk_api.interfaces;

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

/* JADX INFO: loaded from: classes37.dex */
public final class ILoginManisServiceProxy implements ILoginManisService, IInterface {
    public static final String DESCRIPTOR = "com.ss.android.lark.passport.signinsdk_api.interfaces.ILoginManisService";
    public static final int TRANSACTION_switchLoginTenantUser_String_ISwitchUserCallback = 1;
    private IBinder mRemote;

    public String getInterfaceDescriptor() {
        return DESCRIPTOR;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.mRemote;
    }

    public ILoginManisServiceProxy(Context r100, IBinder r101) {
        this.mRemote = r101;
    }

    @Override // com.ss.android.lark.passport.signinsdk_api.interfaces.ILoginManisService
    public void switchLoginTenantUser(String r100, ILoginManisService.a r101) {
        Parcel r102 = Parcel.obtain();
        Parcel r103 = Parcel.obtain();
        r102.writeInterfaceToken(DESCRIPTOR);     // Catch: Throwable -> L9 RemoteException -> L11
        r102.writeString(r100);     // Catch: Throwable -> L9 RemoteException -> L11
        if (r101 == null) goto L6;
        r102.writeStrongBinder(new ISwitchUserCallbackStub(r101).asBinder());     // Catch: Throwable -> L9 RemoteException -> L11
    L7:
        INVOKEINTERFACE_com_ss_android_lark_passport_signinsdk_api_interfaces_ILoginManisServiceProxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r102, r103, 0);     // Catch: Throwable -> L9 RemoteException -> L11
        r103.readException();     // Catch: Throwable -> L9 RemoteException -> L11
    L13:
        r103.recycle();
        r102.recycle();
        return;
    L6:
        r102.writeStrongBinder(null);     // Catch: Throwable -> L9 RemoteException -> L11
    L11:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L9
        b.b("ILoginManisServiceProxy", "call method switchLoginTenantUser throw RemoteException", e);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        r103.recycle();
        r102.recycle();
        throw th;
    }

    @Skip({"com.obric.assistant.interaction.impl.performance"})
    public static boolean INVOKEINTERFACE_com_ss_android_lark_passport_signinsdk_api_interfaces_ILoginManisServiceProxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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
