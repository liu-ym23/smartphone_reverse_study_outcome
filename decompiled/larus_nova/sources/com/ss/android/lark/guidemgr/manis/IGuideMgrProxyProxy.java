package com.ss.android.lark.guidemgr.manis;

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

/* JADX INFO: loaded from: classes36.dex */
public final class IGuideMgrProxyProxy implements IGuideMgrProxy, IInterface {
    public static final String DESCRIPTOR = "com.ss.android.lark.guidemgr.manis.IGuideMgrProxy";
    public static final int TRANSACTION_fetchFromMainProcess = 2;
    public static final int TRANSACTION_onGuideChanged_String = 4;
    public static final int TRANSACTION_registerOnGuideChangeListener_OnGuideChangeListener = 3;
    public static final int TRANSACTION_report_String = 1;
    private IBinder mRemote;

    public String getInterfaceDescriptor() {
        return DESCRIPTOR;
    }

    @Override // com.ss.android.lark.guidemgr.manis.IGuideMgrProxy
    public void fetchFromMainProcess() {
        Parcel r100 = Parcel.obtain();
        Parcel r101 = Parcel.obtain();
        r100.writeInterfaceToken(DESCRIPTOR);     // Catch: Throwable -> L5 RemoteException -> L7
        INVOKEINTERFACE_com_ss_android_lark_guidemgr_manis_IGuideMgrProxyProxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r100, r101, 0);     // Catch: Throwable -> L5 RemoteException -> L7
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
        b.b("IGuideMgrProxyProxy", "call method fetchFromMainProcess throw RemoteException", e);     // Catch: Throwable -> L5
        goto L9
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.mRemote;
    }

    @Override // com.ss.android.lark.guidemgr.manis.IGuideMgrProxy
    public void onGuideChanged(String r100) {
        Parcel r101 = Parcel.obtain();
        Parcel r102 = Parcel.obtain();
        r101.writeInterfaceToken(DESCRIPTOR);     // Catch: Throwable -> L5 RemoteException -> L7
        r101.writeString(r100);     // Catch: Throwable -> L5 RemoteException -> L7
        INVOKEINTERFACE_com_ss_android_lark_guidemgr_manis_IGuideMgrProxyProxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r101, r102, 0);     // Catch: Throwable -> L5 RemoteException -> L7
        r102.readException();     // Catch: Throwable -> L5 RemoteException -> L7
    L9:
        r102.recycle();
        r101.recycle();
        return;
    L7:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L5
        b.b("IGuideMgrProxyProxy", "call method onGuideChanged throw RemoteException", e);     // Catch: Throwable -> L5
    L5:
        th = move-exception;
        r102.recycle();
        r101.recycle();
        throw th;
    }

    @Override // com.ss.android.lark.guidemgr.manis.IGuideMgrProxy
    public void registerOnGuideChangeListener(IGuideMgrProxy.a r100) {
        Parcel r101 = Parcel.obtain();
        Parcel r102 = Parcel.obtain();
        r101.writeInterfaceToken(DESCRIPTOR);     // Catch: Throwable -> L9 RemoteException -> L11
        if (r100 == null) goto L6;
        r101.writeStrongBinder(new OnGuideChangeListenerStub(r100).asBinder());     // Catch: Throwable -> L9 RemoteException -> L11
    L7:
        INVOKEINTERFACE_com_ss_android_lark_guidemgr_manis_IGuideMgrProxyProxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r101, r102, 0);     // Catch: Throwable -> L9 RemoteException -> L11
        r102.readException();     // Catch: Throwable -> L9 RemoteException -> L11
    L13:
        r102.recycle();
        r101.recycle();
        return;
    L6:
        r101.writeStrongBinder(null);     // Catch: Throwable -> L9 RemoteException -> L11
    L11:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L9
        b.b("IGuideMgrProxyProxy", "call method registerOnGuideChangeListener throw RemoteException", e);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        r102.recycle();
        r101.recycle();
        throw th;
    }

    @Override // com.ss.android.lark.guidemgr.manis.IGuideMgrProxy
    public boolean report(String r100) {
        Parcel r101 = Parcel.obtain();
        Parcel r102 = Parcel.obtain();
        boolean r103 = false;
        r101.writeInterfaceToken(DESCRIPTOR);     // Catch: Throwable -> L6 RemoteException -> L8
        r101.writeString(r100);     // Catch: Throwable -> L6 RemoteException -> L8
        INVOKEINTERFACE_com_ss_android_lark_guidemgr_manis_IGuideMgrProxyProxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r101, r102, 0);     // Catch: Throwable -> L6 RemoteException -> L8
        r102.readException();     // Catch: Throwable -> L6 RemoteException -> L8
        if (r102.readInt() == 0) goto L10;
        r103 = true;
    L10:
        r102.recycle();
        r101.recycle();
        return r103;
    L6:
        th = move-exception;
        r102.recycle();
        r101.recycle();
        throw th;
    L8:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L6
        b.b("IGuideMgrProxyProxy", "call method report throw RemoteException", e);     // Catch: Throwable -> L6
        goto L10
    }

    public IGuideMgrProxyProxy(Context r100, IBinder r101) {
        this.mRemote = r101;
    }

    @Skip({"com.obric.assistant.interaction.impl.performance"})
    public static boolean INVOKEINTERFACE_com_ss_android_lark_guidemgr_manis_IGuideMgrProxyProxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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
