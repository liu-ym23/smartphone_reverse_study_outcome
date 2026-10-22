package com.obric.memorydata.sdk.awareness;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes6.dex */
public interface IEventChangeListener extends IInterface {

    /* JADX INFO: loaded from: classes33.dex */
    public static class Default implements IEventChangeListener {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.memorydata.sdk.awareness.IEventChangeListener
        public void onEventChanged(String r100, Bundle r101) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IEventChangeListener {
        private static final String DESCRIPTOR = "com.obric.memorydata.sdk.awareness.IEventChangeListener";
        static final int TRANSACTION_onEventChanged = 1;

        /* JADX INFO: loaded from: classes33.dex */
        public static class Proxy implements IEventChangeListener {
            public static IEventChangeListener sDefaultImpl;
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

            @Override // com.obric.memorydata.sdk.awareness.IEventChangeListener
            public void onEventChanged(String r100, Bundle r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r102.writeString(r100);     // Catch: Throwable -> L17
                if (r101 == null) goto L6;
                r102.writeInt(1);     // Catch: Throwable -> L17
                r101.writeToParcel(r102, 0);     // Catch: Throwable -> L17
            L8:
                if (INVOKEINTERFACE_com_obric_memorydata_sdk_awareness_IEventChangeListener$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r102, r103, 0) == false) goto L10;
            L14:
                r103.readException();     // Catch: Throwable -> L17
                r103.recycle();
                r102.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().onEventChanged(r100, r101);     // Catch: Throwable -> L17
                r103.recycle();
                r102.recycle();
                return;
            L6:
                r102.writeInt(0);     // Catch: Throwable -> L17
            L17:
                th = move-exception;
                r103.recycle();
                r102.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_obric_memorydata_sdk_awareness_IEventChangeListener$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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

        public static IEventChangeListener getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static IEventChangeListener asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof IEventChangeListener) == false) goto L12;
            return (IEventChangeListener) r101;
        L12:
            return new Proxy(r100);
        }

        public static boolean setDefaultImpl(IEventChangeListener r100) {
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
            String r104 = r101.readString();
            if (r101.readInt() == 0) goto L13;
            Bundle r105 = (Bundle) Bundle.CREATOR.createFromParcel(r101);
        L14:
            onEventChanged(r104, r105);
            r102.writeNoException();
            return true;
        L13:
            r105 = null;
            goto L14
        L5:
            if (r100 != 1598968902) goto L7;
            r102.writeString(DESCRIPTOR);
            return true;
        L7:
            return super.onTransact(r100, r101, r102, r103);
        }
    }

    void onEventChanged(String r100, Bundle r101) throws RemoteException;
}
