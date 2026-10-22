package com.obric.memorydata.sdk.awareness;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes6.dex */
public interface IFeatureDurationListener extends IInterface {

    /* JADX INFO: loaded from: classes33.dex */
    public static class Default implements IFeatureDurationListener {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.memorydata.sdk.awareness.IFeatureDurationListener
        public void onTriggered(String r100, String r101, long r102) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IFeatureDurationListener {
        private static final String DESCRIPTOR = "com.obric.memorydata.sdk.awareness.IFeatureDurationListener";
        static final int TRANSACTION_onTriggered = 1;

        /* JADX INFO: loaded from: classes33.dex */
        public static class Proxy implements IFeatureDurationListener {
            public static IFeatureDurationListener sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public Proxy(IBinder r100) {
                this.mRemote = r100;
            }

            @Override // com.obric.memorydata.sdk.awareness.IFeatureDurationListener
            public void onTriggered(String r100, String r101, long r102) throws RemoteException {
                Parcel r103 = Parcel.obtain();
                Parcel r104 = Parcel.obtain();
                r103.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r103.writeString(r100);     // Catch: Throwable -> L13
                r103.writeString(r101);     // Catch: Throwable -> L13
                r103.writeLong(r102);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_memorydata_sdk_awareness_IFeatureDurationListener$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r103, r104, 0) == false) goto L6;
            L10:
                r104.readException();     // Catch: Throwable -> L13
                r104.recycle();
                r103.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onTriggered(r100, r101, r102);     // Catch: Throwable -> L13
                r104.recycle();
                r103.recycle();
                return;
            L13:
                th = move-exception;
                r104.recycle();
                r103.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_obric_memorydata_sdk_awareness_IFeatureDurationListener$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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

        public static IFeatureDurationListener getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static IFeatureDurationListener asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof IFeatureDurationListener) == false) goto L12;
            return (IFeatureDurationListener) r101;
        L12:
            return new Proxy(r100);
        }

        public static boolean setDefaultImpl(IFeatureDurationListener r100) {
            if (Proxy.sDefaultImpl != null) goto L7;
            if (r100 == null) goto L9;
            Proxy.sDefaultImpl = r100;
            return true;
        L9:
            return false;
        L7:
            return false;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r100, Parcel r101, Parcel r102, int r103) throws RemoteException {
            if (r100 != 1) goto L5;
            r101.enforceInterface(DESCRIPTOR);
            onTriggered(r101.readString(), r101.readString(), r101.readLong());
            r102.writeNoException();
            return true;
        L5:
            if (r100 != 1598968902) goto L7;
            r102.writeString(DESCRIPTOR);
            return true;
        L7:
            return super.onTransact(r100, r101, r102, r103);
        }
    }

    void onTriggered(String r100, String r101, long r102) throws RemoteException;
}
