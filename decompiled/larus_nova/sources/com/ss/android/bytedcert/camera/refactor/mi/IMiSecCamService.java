package com.ss.android.bytedcert.camera.refactor.mi;

import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes34.dex */
public interface IMiSecCamService extends IInterface {
    public static final String DESCRIPTOR = "com.xiaomi.trustservice.secmedia.IMiSecCamService";

    public static abstract class Stub extends Binder implements IMiSecCamService {
        static final int TRANSACTION_closeMiSecCam = 2;
        static final int TRANSACTION_openMiSecCam = 1;

        public static class Proxy implements IMiSecCamService {
            private final IBinder mRemote;

            public String getInterfaceDescriptor() {
                return IMiSecCamService.DESCRIPTOR;
            }

            @Override // com.ss.android.bytedcert.camera.refactor.mi.IMiSecCamService
            public void closeMiSecCam() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(IMiSecCamService.DESCRIPTOR);     // Catch: Throwable -> L6
                INVOKEINTERFACE_com_ss_android_bytedcert_camera_refactor_mi_IMiSecCamService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r100, r101, 0);     // Catch: Throwable -> L6
                r101.readException();     // Catch: Throwable -> L6
                r101.recycle();
                r100.recycle();
                return;
            L6:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public Proxy(IBinder r100) {
                this.mRemote = r100;
            }

            @Override // com.ss.android.bytedcert.camera.refactor.mi.IMiSecCamService
            public int openMiSecCam(IMiSecCamCallback r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(IMiSecCamService.DESCRIPTOR);     // Catch: Throwable -> L10
                if (Build.VERSION.SDK_INT < 29) goto L6;
                r101.writeStrongInterface(r100);     // Catch: Throwable -> L10
            L7:
                INVOKEINTERFACE_com_ss_android_bytedcert_camera_refactor_mi_IMiSecCamService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r101, r102, 0);     // Catch: Throwable -> L10
                r102.readException();     // Catch: Throwable -> L10
                int r103 = r102.readInt();     // Catch: Throwable -> L10
                r102.recycle();
                r101.recycle();
                return r103;
            L6:
                r101.writeStrongBinder(r100.asBinder());     // Catch: Throwable -> L10
            L10:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_ss_android_bytedcert_camera_refactor_mi_IMiSecCamService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, IMiSecCamService.DESCRIPTOR);
        }

        public static IMiSecCamService asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(IMiSecCamService.DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof IMiSecCamService) == false) goto L12;
            return (IMiSecCamService) r101;
        L12:
            return new Proxy(r100);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r100, Parcel r101, Parcel r102, int r103) throws RemoteException {
            if (r100 >= 1) goto L5;
        L7:
            if (r100 != 1) goto L9;
            int r104 = openMiSecCam(IMiSecCamCallback.Stub.asInterface(r101.readStrongBinder()));
            r102.writeNoException();
            r102.writeInt(r104);
            return true;
        L9:
            if (r100 != 2) goto L11;
            closeMiSecCam();
            r102.writeNoException();
            return true;
        L11:
            if (r100 != 1598968902) goto L13;
            r102.writeString(IMiSecCamService.DESCRIPTOR);
            return true;
        L13:
            return super.onTransact(r100, r101, r102, r103);
        L5:
            if (r100 > 16777215) goto L7;
            r101.enforceInterface(IMiSecCamService.DESCRIPTOR);
            goto L7
        }
    }

    void closeMiSecCam() throws RemoteException;

    int openMiSecCam(IMiSecCamCallback r100) throws RemoteException;
}
