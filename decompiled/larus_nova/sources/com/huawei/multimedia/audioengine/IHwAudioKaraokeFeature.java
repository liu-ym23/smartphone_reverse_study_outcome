package com.huawei.multimedia.audioengine;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes23.dex */
public interface IHwAudioKaraokeFeature extends IInterface {

    public static abstract class Stub extends Binder implements IHwAudioKaraokeFeature {
        private static final String DESCRIPTOR = "com.huawei.multimedia.audioengine.IHwAudioKaraokeFeature";
        static final int TRANSACTION_enableKaraokeFeature = 2;
        static final int TRANSACTION_getKaraokeLatency = 3;
        static final int TRANSACTION_init = 5;
        static final int TRANSACTION_isKaraokeFeatureSupport = 1;
        static final int TRANSACTION_setParameter = 4;

        public static class Proxy implements IHwAudioKaraokeFeature {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.huawei.multimedia.audioengine.IHwAudioKaraokeFeature
            public int getKaraokeLatency() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                INVOKEINTERFACE_com_huawei_multimedia_audioengine_IHwAudioKaraokeFeature$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r100, r101, 0);     // Catch: Throwable -> L6
                r101.readException();     // Catch: Throwable -> L6
                int r102 = r101.readInt();     // Catch: Throwable -> L6
                r101.recycle();
                r100.recycle();
                return r102;
            L6:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.huawei.multimedia.audioengine.IHwAudioKaraokeFeature
            public boolean isKaraokeFeatureSupport() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L8
                boolean r102 = false;
                INVOKEINTERFACE_com_huawei_multimedia_audioengine_IHwAudioKaraokeFeature$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r100, r101, 0);     // Catch: Throwable -> L8
                r101.readException();     // Catch: Throwable -> L8
                if (r101.readInt() == 0) goto L6;
                r102 = true;
            L6:
                r101.recycle();
                r100.recycle();
                return r102;
            L8:
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

            @Override // com.huawei.multimedia.audioengine.IHwAudioKaraokeFeature
            public int enableKaraokeFeature(boolean r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                if (r100 == false) goto L6;
                int r103 = 1;
            L7:
                r101.writeInt(r103);     // Catch: Throwable -> L10
                INVOKEINTERFACE_com_huawei_multimedia_audioengine_IHwAudioKaraokeFeature$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r101, r102, 0);     // Catch: Throwable -> L10
                r102.readException();     // Catch: Throwable -> L10
                int r104 = r102.readInt();     // Catch: Throwable -> L10
                r102.recycle();
                r101.recycle();
                return r104;
            L6:
                r103 = 0;
            L10:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.huawei.multimedia.audioengine.IHwAudioKaraokeFeature
            public void init(String r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                r101.writeString(r100);     // Catch: Throwable -> L6
                INVOKEINTERFACE_com_huawei_multimedia_audioengine_IHwAudioKaraokeFeature$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 5, r101, r102, 0);     // Catch: Throwable -> L6
                r102.readException();     // Catch: Throwable -> L6
                r102.recycle();
                r101.recycle();
                return;
            L6:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.huawei.multimedia.audioengine.IHwAudioKaraokeFeature
            public int setParameter(String r100, int r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                r102.writeString(r100);     // Catch: Throwable -> L6
                r102.writeInt(r101);     // Catch: Throwable -> L6
                INVOKEINTERFACE_com_huawei_multimedia_audioengine_IHwAudioKaraokeFeature$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r102, r103, 0);     // Catch: Throwable -> L6
                r103.readException();     // Catch: Throwable -> L6
                int r104 = r103.readInt();     // Catch: Throwable -> L6
                r103.recycle();
                r102.recycle();
                return r104;
            L6:
                th = move-exception;
                r103.recycle();
                r102.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_huawei_multimedia_audioengine_IHwAudioKaraokeFeature$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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

        public static IHwAudioKaraokeFeature asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof IHwAudioKaraokeFeature) == false) goto L12;
            return (IHwAudioKaraokeFeature) r101;
        L12:
            return new Proxy(r100);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r100, Parcel r101, Parcel r102, int r103) throws RemoteException {
            if (r100 != 1) goto L5;
            r101.enforceInterface(DESCRIPTOR);
            boolean r104 = isKaraokeFeatureSupport();
            r102.writeNoException();
            r102.writeInt(r104 ? 1 : 0);
            return true;
        L5:
            if (r100 != 2) goto L7;
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L27;
            boolean r105 = true;
        L28:
            int r106 = enableKaraokeFeature(r105);
            r102.writeNoException();
            r102.writeInt(r106);
            return true;
        L27:
            r105 = false;
            goto L28
        L7:
            if (r100 != 3) goto L9;
            r101.enforceInterface(DESCRIPTOR);
            int r107 = getKaraokeLatency();
            r102.writeNoException();
            r102.writeInt(r107);
            return true;
        L9:
            if (r100 != 4) goto L11;
            r101.enforceInterface(DESCRIPTOR);
            int r108 = setParameter(r101.readString(), r101.readInt());
            r102.writeNoException();
            r102.writeInt(r108);
            return true;
        L11:
            if (r100 != 5) goto L13;
            r101.enforceInterface(DESCRIPTOR);
            init(r101.readString());
            r102.writeNoException();
            return true;
        L13:
            if (r100 != 1598968902) goto L15;
            r102.writeString(DESCRIPTOR);
            return true;
        L15:
            return super.onTransact(r100, r101, r102, r103);
        }
    }

    int enableKaraokeFeature(boolean r100) throws RemoteException;

    int getKaraokeLatency() throws RemoteException;

    void init(String r100) throws RemoteException;

    boolean isKaraokeFeatureSupport() throws RemoteException;

    int setParameter(String r100, int r101) throws RemoteException;
}
