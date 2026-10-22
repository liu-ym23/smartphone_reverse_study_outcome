package com.obric.capabilitykit.common;

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
public interface ICapabilitySchedule extends IInterface {

    /* JADX INFO: loaded from: classes33.dex */
    public static class Default implements ICapabilitySchedule {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.capabilitykit.common.ICapabilitySchedule
        public void dispatchServerActions(String r100, boolean r101) throws RemoteException {
        }

        @Override // com.obric.capabilitykit.common.ICapabilitySchedule
        public void queryAppIntents(String r100, IQueryAppIntentsCallback r101) throws RemoteException {
        }

        @Override // com.obric.capabilitykit.common.ICapabilitySchedule
        public void registerActionsResultReceiver(ICapabilityFeedbackReceiver r100) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements ICapabilitySchedule {
        private static final String DESCRIPTOR = "com.obric.capabilitykit.common.ICapabilitySchedule";
        public static final int TRANSACTION_dispatchServerActions = 1;
        public static final int TRANSACTION_queryAppIntents = 3;
        public static final int TRANSACTION_registerActionsResultReceiver = 2;

        public static class Proxy implements ICapabilitySchedule {
            public static ICapabilitySchedule sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder r100) {
                this.mRemote = r100;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.obric.capabilitykit.common.ICapabilitySchedule
            public void dispatchServerActions(String r100, boolean r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r102.writeString(r100);     // Catch: Throwable -> L12
                r102.writeInt(r101 ? 1 : 0);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_capabilitykit_common_ICapabilitySchedule$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r102, r103, 0) == false) goto L6;
            L10:
                r103.readException();     // Catch: Throwable -> L12
            L8:
                r103.recycle();
                r102.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().dispatchServerActions(r100, r101);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r103.recycle();
                r102.recycle();
                throw th;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.obric.capabilitykit.common.ICapabilitySchedule
            public void queryAppIntents(String r100, IQueryAppIntentsCallback r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r102.writeString(r100);     // Catch: Throwable -> L16
                if (r101 == null) goto L6;
                IBinder r104 = r101.asBinder();     // Catch: Throwable -> L16
            L7:
                r102.writeStrongBinder(r104);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_com_obric_capabilitykit_common_ICapabilitySchedule$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r102, r103, 0) == false) goto L10;
            L14:
                r103.readException();     // Catch: Throwable -> L16
            L12:
                r103.recycle();
                r102.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().queryAppIntents(r100, r101);     // Catch: Throwable -> L16
                goto L12
            L6:
                r104 = null;
            L16:
                th = move-exception;
                r103.recycle();
                r102.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilitySchedule
            public void registerActionsResultReceiver(ICapabilityFeedbackReceiver r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r100 == null) goto L6;
                IBinder r103 = r100.asBinder();     // Catch: Throwable -> L16
            L7:
                r101.writeStrongBinder(r103);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_com_obric_capabilitykit_common_ICapabilitySchedule$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r101, r102, 0) == false) goto L10;
            L14:
                r102.readException();     // Catch: Throwable -> L16
            L12:
                r102.recycle();
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().registerActionsResultReceiver(r100);     // Catch: Throwable -> L16
                goto L12
            L6:
                r103 = null;
            L16:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_obric_capabilitykit_common_ICapabilitySchedule$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ICapabilitySchedule asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof ICapabilitySchedule) == false) goto L12;
            return (ICapabilitySchedule) r101;
        L12:
            return new Proxy(r100);
        }

        public static ICapabilitySchedule getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(ICapabilitySchedule r100) {
            if (Proxy.sDefaultImpl != null) goto L7;
            if (r100 == null) goto L9;
            Proxy.sDefaultImpl = r100;
            return true;
        L9:
            return false;
        L7:
            return false;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r100, Parcel r101, Parcel r102, int r103) throws RemoteException {
            if (r100 != 1) goto L5;
            r101.enforceInterface(DESCRIPTOR);
            String r104 = r101.readString();
            if (r101.readInt() == 0) goto L21;
            boolean r105 = true;
        L22:
            dispatchServerActions(r104, r105);
        L15:
            r102.writeNoException();
            return true;
        L21:
            r105 = false;
            goto L22
        L5:
            if (r100 != 2) goto L7;
            r101.enforceInterface(DESCRIPTOR);
            registerActionsResultReceiver(ICapabilityFeedbackReceiver.Stub.asInterface(r101.readStrongBinder()));
            goto L15
        L7:
            if (r100 != 3) goto L9;
            r101.enforceInterface(DESCRIPTOR);
            queryAppIntents(r101.readString(), IQueryAppIntentsCallback.Stub.asInterface(r101.readStrongBinder()));
            goto L15
        L9:
            if (r100 != 1598968902) goto L11;
            r102.writeString(DESCRIPTOR);
            return true;
        L11:
            return super.onTransact(r100, r101, r102, r103);
        }
    }

    void dispatchServerActions(String r100, boolean r101) throws RemoteException;

    void queryAppIntents(String r100, IQueryAppIntentsCallback r101) throws RemoteException;

    void registerActionsResultReceiver(ICapabilityFeedbackReceiver r100) throws RemoteException;
}
