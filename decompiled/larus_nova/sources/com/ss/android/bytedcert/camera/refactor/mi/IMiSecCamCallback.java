package com.ss.android.bytedcert.camera.refactor.mi;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes34.dex */
public interface IMiSecCamCallback extends IInterface {
    public static final String DESCRIPTOR = "com.xiaomi.trustservice.secmedia.IMiSecCamCallback";

    public static abstract class Stub extends Binder implements IMiSecCamCallback {
        static final int TRANSACTION_onFrameCallback = 1;

        public static class Proxy implements IMiSecCamCallback {
            private final IBinder mRemote;

            public String getInterfaceDescriptor() {
                return IMiSecCamCallback.DESCRIPTOR;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public Proxy(IBinder r100) {
                this.mRemote = r100;
            }

            @Override // com.ss.android.bytedcert.camera.refactor.mi.IMiSecCamCallback
            public void onFrameCallback(byte[] r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(IMiSecCamCallback.DESCRIPTOR);     // Catch: Throwable -> L6
                r101.writeByteArray(r100);     // Catch: Throwable -> L6
                INVOKEINTERFACE_com_ss_android_bytedcert_camera_refactor_mi_IMiSecCamCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r101, r102, 0);     // Catch: Throwable -> L6
                r102.readException();     // Catch: Throwable -> L6
                r102.readByteArray(r100);     // Catch: Throwable -> L6
                r102.recycle();
                r101.recycle();
                return;
            L6:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_ss_android_bytedcert_camera_refactor_mi_IMiSecCamCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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
            attachInterface(this, IMiSecCamCallback.DESCRIPTOR);
        }

        public static IMiSecCamCallback asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(IMiSecCamCallback.DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof IMiSecCamCallback) == false) goto L12;
            return (IMiSecCamCallback) r101;
        L12:
            return new Proxy(r100);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r100, Parcel r101, Parcel r102, int r103) throws RemoteException {
            if (r100 >= 1) goto L5;
        L7:
            if (r100 != 1) goto L9;
            byte[] r104 = r101.createByteArray();
            onFrameCallback(r104);
            r102.writeNoException();
            r102.writeByteArray(r104);
            return true;
        L9:
            if (r100 != 1598968902) goto L11;
            r102.writeString(IMiSecCamCallback.DESCRIPTOR);
            return true;
        L11:
            return super.onTransact(r100, r101, r102, r103);
        L5:
            if (r100 > 16777215) goto L7;
            r101.enforceInterface(IMiSecCamCallback.DESCRIPTOR);
            goto L7
        }
    }

    void onFrameCallback(byte[] r100) throws RemoteException;
}
