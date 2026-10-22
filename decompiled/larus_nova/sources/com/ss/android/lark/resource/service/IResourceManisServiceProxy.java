package com.ss.android.lark.resource.service;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import com.suite.lark.platform.service.resourcerepository.api.Resource;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes37.dex */
public final class IResourceManisServiceProxy implements IResourceManisService, IInterface {
    public static final String DESCRIPTOR = "com.ss.android.lark.resource.service.IResourceManisService";
    public static final int TRANSACTION_getAvatarPath_String_String_int_float = 3;
    public static final int TRANSACTION_getEncryptImage_String_String_String_String_String_boolean = 1;
    public static final int TRANSACTION_getEncryptImage_String_String_String_String_String_boolean_int = 2;
    private IBinder mRemote;

    public String getInterfaceDescriptor() {
        return DESCRIPTOR;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.mRemote;
    }

    public IResourceManisServiceProxy(Context r100, IBinder r101) {
        this.mRemote = r101;
    }

    @Override // com.ss.android.lark.resource.service.IResourceManisService
    public String getAvatarPath(String r100, String r101, int r102, float r103) {
        Parcel r104 = Parcel.obtain();
        Parcel r105 = Parcel.obtain();
        r104.writeInterfaceToken(DESCRIPTOR);     // Catch: Throwable -> L5 RemoteException -> L7
        r104.writeString(r100);     // Catch: Throwable -> L5 RemoteException -> L7
        r104.writeString(r101);     // Catch: Throwable -> L5 RemoteException -> L7
        r104.writeInt(r102);     // Catch: Throwable -> L5 RemoteException -> L7
        r104.writeFloat(r103);     // Catch: Throwable -> L5 RemoteException -> L7
        INVOKEINTERFACE_com_ss_android_lark_resource_service_IResourceManisServiceProxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r104, r105, 0);     // Catch: Throwable -> L5 RemoteException -> L7
        r105.readException();     // Catch: Throwable -> L5 RemoteException -> L7
        String r106 = r105.readString();     // Catch: Throwable -> L5 RemoteException -> L7
        r105.recycle();
        r104.recycle();
        return r106;
    L7:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L5
        krc.b.b("IResourceManisServiceProxy", "call method getAvatarPath throw RemoteException", e);     // Catch: Throwable -> L5
        r105.recycle();
        r104.recycle();
        return null;
    L5:
        th = move-exception;
        r105.recycle();
        r104.recycle();
        throw th;
    }

    @Skip({"com.obric.assistant.interaction.impl.performance"})
    public static boolean INVOKEINTERFACE_com_ss_android_lark_resource_service_IResourceManisServiceProxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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

    @Override // com.ss.android.lark.resource.service.IResourceManisService
    public Resource getEncryptImage(String r100, String r101, String r102, String r103, String r104, boolean r105) {
        Parcel r106 = Parcel.obtain();
        Parcel r107 = Parcel.obtain();
        r106.writeInterfaceToken(DESCRIPTOR);     // Catch: Throwable -> L11 RemoteException -> L13
        r106.writeString(r100);     // Catch: Throwable -> L11 RemoteException -> L13
        r106.writeString(r101);     // Catch: Throwable -> L11 RemoteException -> L13
        r106.writeString(r102);     // Catch: Throwable -> L11 RemoteException -> L13
        r106.writeString(r103);     // Catch: Throwable -> L11 RemoteException -> L13
        r106.writeString(r104);     // Catch: Throwable -> L11 RemoteException -> L13
        if (r105 == false) goto L6;
        int r108 = 1;
    L7:
        r106.writeInt(r108);     // Catch: Throwable -> L11 RemoteException -> L13
        INVOKEINTERFACE_com_ss_android_lark_resource_service_IResourceManisServiceProxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r106, r107, 0);     // Catch: Throwable -> L11 RemoteException -> L13
        r107.readException();     // Catch: Throwable -> L11 RemoteException -> L13
        if (r107.readInt() == 0) goto L15;
        Resource r109 = Resource.CREATOR.createFromParcel(r107);     // Catch: Throwable -> L11 RemoteException -> L13
    L16:
        r107.recycle();
        r106.recycle();
        return r109;
    L15:
        r109 = null;
        goto L16
    L6:
        r108 = 0;
    L13:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L11
        krc.b.b("IResourceManisServiceProxy", "call method getEncryptImage throw RemoteException", e);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        r107.recycle();
        r106.recycle();
        throw th;
    }

    @Override // com.ss.android.lark.resource.service.IResourceManisService
    public Resource getEncryptImage(String r100, String r101, String r102, String r103, String r104, boolean r105, int r110) {
        Parcel r106 = Parcel.obtain();
        Parcel r107 = Parcel.obtain();
        r106.writeInterfaceToken(DESCRIPTOR);     // Catch: Throwable -> L11 RemoteException -> L13
        r106.writeString(r100);     // Catch: Throwable -> L11 RemoteException -> L13
        r106.writeString(r101);     // Catch: Throwable -> L11 RemoteException -> L13
        r106.writeString(r102);     // Catch: Throwable -> L11 RemoteException -> L13
        r106.writeString(r103);     // Catch: Throwable -> L11 RemoteException -> L13
        r106.writeString(r104);     // Catch: Throwable -> L11 RemoteException -> L13
        if (r105 == false) goto L6;
        int r108 = 1;
    L7:
        r106.writeInt(r108);     // Catch: Throwable -> L11 RemoteException -> L13
        r106.writeInt(r110);     // Catch: Throwable -> L11 RemoteException -> L13
        INVOKEINTERFACE_com_ss_android_lark_resource_service_IResourceManisServiceProxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r106, r107, 0);     // Catch: Throwable -> L11 RemoteException -> L13
        r107.readException();     // Catch: Throwable -> L11 RemoteException -> L13
        if (r107.readInt() == 0) goto L15;
        Resource r109 = Resource.CREATOR.createFromParcel(r107);     // Catch: Throwable -> L11 RemoteException -> L13
    L16:
        r107.recycle();
        r106.recycle();
        return r109;
    L15:
        r109 = null;
        goto L16
    L6:
        r108 = 0;
    L11:
        th = move-exception;
        r107.recycle();
        r106.recycle();
        throw th;
    L13:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L11
        krc.b.b("IResourceManisServiceProxy", "call method getEncryptImage throw RemoteException", e);     // Catch: Throwable -> L11
        goto L15
    }
}
