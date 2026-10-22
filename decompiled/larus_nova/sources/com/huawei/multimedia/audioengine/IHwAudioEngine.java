package com.huawei.multimedia.audioengine;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import java.util.ArrayList;
import java.util.List;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes23.dex */
public interface IHwAudioEngine extends IInterface {

    public static abstract class Stub extends Binder implements IHwAudioEngine {
        private static final String DESCRIPTOR = "com.huawei.multimedia.audioengine.IHwAudioEngine";
        static final int TRANSACTION_getSupportedFeatures = 1;
        static final int TRANSACTION_init = 3;
        static final int TRANSACTION_isFeatureSupported = 2;

        public static class Proxy implements IHwAudioEngine {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.huawei.multimedia.audioengine.IHwAudioEngine
            public List getSupportedFeatures() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                INVOKEINTERFACE_com_huawei_multimedia_audioengine_IHwAudioEngine$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r100, r101, 0);     // Catch: Throwable -> L6
                r101.readException();     // Catch: Throwable -> L6
                ArrayList r102 = r101.readArrayList(getClass().getClassLoader());     // Catch: Throwable -> L6
                r101.recycle();
                r100.recycle();
                return r102;
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

            @Override // com.huawei.multimedia.audioengine.IHwAudioEngine
            public boolean isFeatureSupported(int r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                r101.writeInt(r100);     // Catch: Throwable -> L8
                boolean r103 = false;
                INVOKEINTERFACE_com_huawei_multimedia_audioengine_IHwAudioEngine$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r101, r102, 0);     // Catch: Throwable -> L8
                r102.readException();     // Catch: Throwable -> L8
                if (r102.readInt() == 0) goto L6;
                r103 = true;
            L6:
                r102.recycle();
                r101.recycle();
                return r103;
            L8:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.huawei.multimedia.audioengine.IHwAudioEngine
            public void init(String r100, String r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                r102.writeString(r100);     // Catch: Throwable -> L6
                r102.writeString(r101);     // Catch: Throwable -> L6
                INVOKEINTERFACE_com_huawei_multimedia_audioengine_IHwAudioEngine$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r102, r103, 0);     // Catch: Throwable -> L6
                r103.readException();     // Catch: Throwable -> L6
                r103.recycle();
                r102.recycle();
                return;
            L6:
                th = move-exception;
                r103.recycle();
                r102.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_huawei_multimedia_audioengine_IHwAudioEngine$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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
            attachInterface(this, DESCRIPTOR);
        }

        public static IHwAudioEngine asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof IHwAudioEngine) == false) goto L12;
            return (IHwAudioEngine) r101;
        L12:
            return new Proxy(r100);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r100, Parcel r101, Parcel r102, int r103) throws RemoteException {
            if (r100 != 1) goto L5;
            r101.enforceInterface(DESCRIPTOR);
            List r104 = getSupportedFeatures();
            r102.writeNoException();
            r102.writeList(r104);
            return true;
        L5:
            if (r100 != 2) goto L7;
            r101.enforceInterface(DESCRIPTOR);
            boolean r105 = isFeatureSupported(r101.readInt());
            r102.writeNoException();
            r102.writeInt(r105 ? 1 : 0);
            return true;
        L7:
            if (r100 != 3) goto L9;
            r101.enforceInterface(DESCRIPTOR);
            init(r101.readString(), r101.readString());
            r102.writeNoException();
            return true;
        L9:
            if (r100 != 1598968902) goto L11;
            r102.writeString(DESCRIPTOR);
            return true;
        L11:
            return super.onTransact(r100, r101, r102, r103);
        }
    }

    List getSupportedFeatures() throws RemoteException;

    void init(String r100, String r101) throws RemoteException;

    boolean isFeatureSupported(int r100) throws RemoteException;
}
