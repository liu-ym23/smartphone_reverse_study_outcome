package com.ss.android.lark.dynamicconfig.manis;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import java.util.ArrayList;
import java.util.List;
import krc.b;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes35.dex */
public final class DynamicHostProxyProxy implements DynamicHostProxy, IInterface {
    public static final String DESCRIPTOR = "com.ss.android.lark.dynamicconfig.manis.DynamicHostProxy";
    public static final int TRANSACTION_getDocMainDomain = 3;
    public static final int TRANSACTION_getMainDomain = 1;
    public static final int TRANSACTION_getMainDomains = 2;
    private IBinder mRemote;

    public String getInterfaceDescriptor() {
        return DESCRIPTOR;
    }

    @Override // com.ss.android.lark.dynamicconfig.manis.DynamicHostProxy
    public String getDocMainDomain() {
        Parcel r100 = Parcel.obtain();
        Parcel r101 = Parcel.obtain();
        r100.writeInterfaceToken(DESCRIPTOR);     // Catch: Throwable -> L5 RemoteException -> L7
        INVOKEINTERFACE_com_ss_android_lark_dynamicconfig_manis_DynamicHostProxyProxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r100, r101, 0);     // Catch: Throwable -> L5 RemoteException -> L7
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
        b.b("DynamicHostProxyProxy", "call method getDocMainDomain throw RemoteException", e);     // Catch: Throwable -> L5
        r101.recycle();
        r100.recycle();
        r102 = null;
        goto L13
    }

    @Override // com.ss.android.lark.dynamicconfig.manis.DynamicHostProxy
    public String getMainDomain() {
        Parcel r100 = Parcel.obtain();
        Parcel r101 = Parcel.obtain();
        r100.writeInterfaceToken(DESCRIPTOR);     // Catch: Throwable -> L5 RemoteException -> L7
        INVOKEINTERFACE_com_ss_android_lark_dynamicconfig_manis_DynamicHostProxyProxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r100, r101, 0);     // Catch: Throwable -> L5 RemoteException -> L7
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
        b.b("DynamicHostProxyProxy", "call method getMainDomain throw RemoteException", e);     // Catch: Throwable -> L5
        r101.recycle();
        r100.recycle();
        r102 = null;
        goto L13
    }

    @Override // com.ss.android.lark.dynamicconfig.manis.DynamicHostProxy
    public List<String> getMainDomains() {
        Parcel r100 = Parcel.obtain();
        Parcel r101 = Parcel.obtain();
        r100.writeInterfaceToken(DESCRIPTOR);     // Catch: Throwable -> L5 RemoteException -> L7
        INVOKEINTERFACE_com_ss_android_lark_dynamicconfig_manis_DynamicHostProxyProxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r100, r101, 0);     // Catch: Throwable -> L5 RemoteException -> L7
        r101.readException();     // Catch: Throwable -> L5 RemoteException -> L7
        ArrayList r102 = r101.readArrayList(DynamicHostProxyProxy.class.getClassLoader());     // Catch: Throwable -> L5 RemoteException -> L7
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
        b.b("DynamicHostProxyProxy", "call method getMainDomains throw RemoteException", e);     // Catch: Throwable -> L5
        r101.recycle();
        r100.recycle();
        r102 = null;
        goto L13
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.mRemote;
    }

    public DynamicHostProxyProxy(Context r100, IBinder r101) {
        this.mRemote = r101;
    }

    @Skip({"com.obric.assistant.interaction.impl.performance"})
    public static boolean INVOKEINTERFACE_com_ss_android_lark_dynamicconfig_manis_DynamicHostProxyProxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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
