package com.obric.livecard.api;

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
public interface IIslandStatusCallback extends IInterface {

    /* JADX INFO: loaded from: classes33.dex */
    public static class Default implements IIslandStatusCallback {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.livecard.api.IIslandStatusCallback
        public long getId() throws RemoteException {
            return 0;
        }

        @Override // com.obric.livecard.api.IIslandStatusCallback
        public void keepAliveOnAOD(boolean r100) throws RemoteException {
        }

        @Override // com.obric.livecard.api.IIslandStatusCallback
        public void onIslandDialogueMode(boolean r100) throws RemoteException {
        }

        @Override // com.obric.livecard.api.IIslandStatusCallback
        public void onIslandExpand() throws RemoteException {
        }

        @Override // com.obric.livecard.api.IIslandStatusCallback
        public void onIslandStartActivity() throws RemoteException {
        }

        @Override // com.obric.livecard.api.IIslandStatusCallback
        public void onIslandWidthChange(int r100) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IIslandStatusCallback {
        private static final String DESCRIPTOR = "com.obric.livecard.api.IIslandStatusCallback";
        static final int TRANSACTION_getId = 2;
        static final int TRANSACTION_keepAliveOnAOD = 3;
        static final int TRANSACTION_onIslandDialogueMode = 6;
        static final int TRANSACTION_onIslandExpand = 1;
        static final int TRANSACTION_onIslandStartActivity = 4;
        static final int TRANSACTION_onIslandWidthChange = 5;

        /* JADX INFO: loaded from: classes33.dex */
        public static class Proxy implements IIslandStatusCallback {
            public static IIslandStatusCallback sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.obric.livecard.api.IIslandStatusCallback
            public long getId() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_livecard_api_IIslandStatusCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L13
                long r102 = r101.readLong();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r102;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                long r103 = Stub.getDefaultImpl().getId();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r103;
            L13:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.obric.livecard.api.IIslandStatusCallback
            public void onIslandExpand() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_livecard_api_IIslandStatusCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onIslandExpand();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return;
            L13:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.obric.livecard.api.IIslandStatusCallback
            public void onIslandStartActivity() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_livecard_api_IIslandStatusCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onIslandStartActivity();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return;
            L13:
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

            @Override // com.obric.livecard.api.IIslandStatusCallback
            public void keepAliveOnAOD(boolean r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r100 == false) goto L6;
                int r103 = 1;
            L7:
                r101.writeInt(r103);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_obric_livecard_api_IIslandStatusCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r101, r102, 0) == false) goto L10;
            L14:
                r102.readException();     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().keepAliveOnAOD(r100);     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return;
            L6:
                r103 = 0;
            L17:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.obric.livecard.api.IIslandStatusCallback
            public void onIslandDialogueMode(boolean r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r100 == false) goto L6;
                int r103 = 1;
            L7:
                r101.writeInt(r103);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_obric_livecard_api_IIslandStatusCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 6, r101, r102, 0) == false) goto L10;
            L14:
                r102.readException();     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().onIslandDialogueMode(r100);     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return;
            L6:
                r103 = 0;
            L17:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.obric.livecard.api.IIslandStatusCallback
            public void onIslandWidthChange(int r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r101.writeInt(r100);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_livecard_api_IIslandStatusCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 5, r101, r102, 0) == false) goto L6;
            L10:
                r102.readException();     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onIslandWidthChange(r100);     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return;
            L13:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_obric_livecard_api_IIslandStatusCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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

        public static IIslandStatusCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static IIslandStatusCallback asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof IIslandStatusCallback) == false) goto L12;
            return (IIslandStatusCallback) r101;
        L12:
            return new Proxy(r100);
        }

        public static boolean setDefaultImpl(IIslandStatusCallback r100) {
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
            if (r100 == 1598968902) goto L26;
            boolean r104 = false;
            switch(r100) {
                case 1: goto L24;
                case 2: goto L22;
                case 3: goto L17;
                case 4: goto L15;
                case 5: goto L13;
                case 6: goto L8;
                default: goto L7;
            };
        L8:
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L11;
            r104 = true;
        L11:
            onIslandDialogueMode(r104);
            r102.writeNoException();
            return true;
        L13:
            r101.enforceInterface(DESCRIPTOR);
            onIslandWidthChange(r101.readInt());
            r102.writeNoException();
            return true;
        L15:
            r101.enforceInterface(DESCRIPTOR);
            onIslandStartActivity();
            r102.writeNoException();
            return true;
        L17:
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L20;
            r104 = true;
        L20:
            keepAliveOnAOD(r104);
            r102.writeNoException();
            return true;
        L22:
            r101.enforceInterface(DESCRIPTOR);
            long r105 = getId();
            r102.writeNoException();
            r102.writeLong(r105);
            return true;
        L24:
            r101.enforceInterface(DESCRIPTOR);
            onIslandExpand();
            r102.writeNoException();
            return true;
        L7:
            return super.onTransact(r100, r101, r102, r103);
        L26:
            r102.writeString(DESCRIPTOR);
            return true;
        }
    }

    long getId() throws RemoteException;

    void keepAliveOnAOD(boolean r100) throws RemoteException;

    void onIslandDialogueMode(boolean r100) throws RemoteException;

    void onIslandExpand() throws RemoteException;

    void onIslandStartActivity() throws RemoteException;

    void onIslandWidthChange(int r100) throws RemoteException;
}
