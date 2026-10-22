package android.view;

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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public interface IFloatingTransitionSession extends IInterface {

    public static class Default implements IFloatingTransitionSession {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // android.view.IFloatingTransitionSession
        public void notifyFloatingTransitionFinished(IBinder r1) throws RemoteException {
        }

        @Override // android.view.IFloatingTransitionSession
        public void notifyFloatingTransitionLaunch(IBinder r1) throws RemoteException {
        }

        @Override // android.view.IFloatingTransitionSession
        public boolean registerTitleBar(IBinder r1, IFloatingTransitionCallback r2, IFloatingTransitionStateProvider r3) throws RemoteException {
            return false;
        }

        @Override // android.view.IFloatingTransitionSession
        public void unregisterTitleBar(IBinder r1) throws RemoteException {
        }

        @Override // android.view.IFloatingTransitionSession
        public void updateState(IBinder r1, Bundle r2) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IFloatingTransitionSession {
        private static final String DESCRIPTOR = "android.view.IFloatingTransitionSession";
        static final int TRANSACTION_notifyFloatingTransitionFinished = 5;
        static final int TRANSACTION_notifyFloatingTransitionLaunch = 4;
        static final int TRANSACTION_registerTitleBar = 1;
        static final int TRANSACTION_unregisterTitleBar = 2;
        static final int TRANSACTION_updateState = 3;

        public static class Proxy implements IFloatingTransitionSession {
            public static IFloatingTransitionSession sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public Proxy(IBinder r1) {
                this.mRemote = r1;
            }

            @Override // android.view.IFloatingTransitionSession
            public void notifyFloatingTransitionFinished(IBinder r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeStrongBinder(r6);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_android_view_IFloatingTransitionSession$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 5, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().notifyFloatingTransitionFinished(r6);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.view.IFloatingTransitionSession
            public void notifyFloatingTransitionLaunch(IBinder r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeStrongBinder(r6);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_android_view_IFloatingTransitionSession$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().notifyFloatingTransitionLaunch(r6);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.view.IFloatingTransitionSession
            public void unregisterTitleBar(IBinder r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeStrongBinder(r6);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_android_view_IFloatingTransitionSession$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().unregisterTitleBar(r6);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.view.IFloatingTransitionSession
            public void updateState(IBinder r6, Bundle r7) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r0.writeStrongBinder(r6);     // Catch: Throwable -> L17
                if (r7 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L17
                r7.writeToParcel(r0, 0);     // Catch: Throwable -> L17
            L8:
                if (INVOKEINTERFACE_android_view_IFloatingTransitionSession$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().updateState(r6, r7);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L17
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.view.IFloatingTransitionSession
            public boolean registerTitleBar(IBinder r6, IFloatingTransitionCallback r7, IFloatingTransitionStateProvider r8) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L22
                r0.writeStrongBinder(r6);     // Catch: Throwable -> L22
                IBinder r2 = null;
                if (r7 == null) goto L6;
                IBinder r3 = r7.asBinder();     // Catch: Throwable -> L22
            L7:
                r0.writeStrongBinder(r3);     // Catch: Throwable -> L22
                if (r8 == null) goto L10;
                r2 = r8.asBinder();     // Catch: Throwable -> L22
            L10:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L22
                boolean r4 = false;
                if (INVOKEINTERFACE_android_view_IFloatingTransitionSession$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r0, r1, 0) == false) goto L13;
            L17:
                r1.readException();     // Catch: Throwable -> L22
                if (r1.readInt() == 0) goto L20;
                r4 = true;
            L20:
                r1.recycle();
                r0.recycle();
                return r4;
            L13:
                if (Stub.getDefaultImpl() == null) goto L17;
                boolean r9 = Stub.getDefaultImpl().registerTitleBar(r6, r7, r8);     // Catch: Throwable -> L22
                r1.recycle();
                r0.recycle();
                return r9;
            L6:
                r3 = null;
            L22:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_android_view_IFloatingTransitionSession$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r15, int r16, Parcel r17, Parcel r18, int r19) throws RemoteException {
                if (Looper.myLooper() != Looper.getMainLooper()) goto L5;
                long r2 = SystemClock.uptimeMillis();
                boolean r0 = r15.transact(r16, r17, r18, r19);     // Catch: Throwable -> L12
                long r8 = SystemClock.uptimeMillis() - r2;
                if (r8 < 100) goto L11;
                BinderPerformanceReporter.report(r8, r15.getClass().getName(), r16, r19, new Throwable("Slow main-thread Binder transaction"));
            L11:
                return r0;
            L12:
                th = move-exception;
                long r9 = SystemClock.uptimeMillis() - r2;
                if (r9 < 100) goto L22;
                if (r15 != null) goto L17;
                String r1 = "";
            L18:
                BinderPerformanceReporter.report(r9, r1, r16, r19, new Throwable("Slow main-thread Binder transaction"));
                throw th;
            L17:
                r1 = r15.getClass().getName();
                goto L18
            L22:
                throw th;
            L5:
                return r15.transact(r16, r17, r18, r19);
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IFloatingTransitionSession getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static IFloatingTransitionSession asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof IFloatingTransitionSession) == false) goto L12;
            return (IFloatingTransitionSession) r0;
        L12:
            return new Proxy(r2);
        }

        public static boolean setDefaultImpl(IFloatingTransitionSession r1) {
            if (Proxy.sDefaultImpl != null) goto L10;
            if (r1 == null) goto L7;
            Proxy.sDefaultImpl = r1;
            return true;
        L7:
            return false;
        L10:
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) throws RemoteException {
            if (r4 != 1) goto L5;
            r5.enforceInterface(DESCRIPTOR);
            boolean r8 = registerTitleBar(r5.readStrongBinder(), IFloatingTransitionCallback.Stub.asInterface(r5.readStrongBinder()), IFloatingTransitionStateProvider.Stub.asInterface(r5.readStrongBinder()));
            r6.writeNoException();
            r6.writeInt(r8 ? 1 : 0);
            return true;
        L5:
            if (r4 != 2) goto L7;
            r5.enforceInterface(DESCRIPTOR);
            unregisterTitleBar(r5.readStrongBinder());
            r6.writeNoException();
            return true;
        L7:
            if (r4 != 3) goto L9;
            r5.enforceInterface(DESCRIPTOR);
            IBinder r9 = r5.readStrongBinder();
            if (r5.readInt() == 0) goto L25;
            Bundle r10 = (Bundle) Bundle.CREATOR.createFromParcel(r5);
        L26:
            updateState(r9, r10);
            r6.writeNoException();
            return true;
        L25:
            r10 = null;
            goto L26
        L9:
            if (r4 != 4) goto L11;
            r5.enforceInterface(DESCRIPTOR);
            notifyFloatingTransitionLaunch(r5.readStrongBinder());
            r6.writeNoException();
            return true;
        L11:
            if (r4 != 5) goto L13;
            r5.enforceInterface(DESCRIPTOR);
            notifyFloatingTransitionFinished(r5.readStrongBinder());
            r6.writeNoException();
            return true;
        L13:
            if (r4 != 1598968902) goto L15;
            r6.writeString(DESCRIPTOR);
            return true;
        L15:
            return super.onTransact(r4, r5, r6, r7);
        }
    }

    void notifyFloatingTransitionFinished(IBinder r1) throws RemoteException;

    void notifyFloatingTransitionLaunch(IBinder r1) throws RemoteException;

    boolean registerTitleBar(IBinder r1, IFloatingTransitionCallback r2, IFloatingTransitionStateProvider r3) throws RemoteException;

    void unregisterTitleBar(IBinder r1) throws RemoteException;

    void updateState(IBinder r1, Bundle r2) throws RemoteException;
}
