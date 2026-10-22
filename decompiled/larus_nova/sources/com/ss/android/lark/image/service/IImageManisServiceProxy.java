package com.ss.android.lark.image.service;

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
public final class IImageManisServiceProxy implements IImageManisService, IInterface {
    public static final String DESCRIPTOR = "com.ss.android.lark.image.service.IImageManisService";
    public static final int TRANSACTION_uploadEncryptImage_String_boolean_boolean_UploadEncryptImageCallback = 1;
    private IBinder mRemote;

    public String getInterfaceDescriptor() {
        return DESCRIPTOR;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.mRemote;
    }

    public IImageManisServiceProxy(Context r100, IBinder r101) {
        this.mRemote = r101;
    }

    @Override // com.ss.android.lark.image.service.IImageManisService
    public void uploadEncryptImage(String r100, boolean r101, boolean r102, IImageManisService.a r103) {
        Parcel r104 = Parcel.obtain();
        Parcel r105 = Parcel.obtain();
        r104.writeInterfaceToken(DESCRIPTOR);     // Catch: Throwable -> L17 RemoteException -> L19
        r104.writeString(r100);     // Catch: Throwable -> L17 RemoteException -> L19
        if (r101 == false) goto L6;
        int r106 = 1;
    L7:
        r104.writeInt(r106);     // Catch: Throwable -> L17 RemoteException -> L19
        if (r102 == false) goto L10;
        int r107 = 1;
    L11:
        r104.writeInt(r107);     // Catch: Throwable -> L17 RemoteException -> L19
        if (r103 == null) goto L14;
        r104.writeStrongBinder(new UploadEncryptImageCallbackStub(r103).asBinder());     // Catch: Throwable -> L17 RemoteException -> L19
    L15:
        INVOKEINTERFACE_com_ss_android_lark_image_service_IImageManisServiceProxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r104, r105, 0);     // Catch: Throwable -> L17 RemoteException -> L19
        r105.readException();     // Catch: Throwable -> L17 RemoteException -> L19
    L21:
        r105.recycle();
        r104.recycle();
        return;
    L14:
        r104.writeStrongBinder(null);     // Catch: Throwable -> L17 RemoteException -> L19
        goto L15
    L10:
        r107 = 0;
        goto L11
    L6:
        r106 = 0;
    L19:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L17
        b.b("IImageManisServiceProxy", "call method uploadEncryptImage throw RemoteException", e);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        r105.recycle();
        r104.recycle();
        throw th;
    }

    @Skip({"com.obric.assistant.interaction.impl.performance"})
    public static boolean INVOKEINTERFACE_com_ss_android_lark_image_service_IImageManisServiceProxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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
