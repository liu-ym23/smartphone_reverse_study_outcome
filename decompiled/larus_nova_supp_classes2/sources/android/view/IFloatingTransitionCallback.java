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
public interface IFloatingTransitionCallback extends IInterface {

    public static class Default implements IFloatingTransitionCallback {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // android.view.IFloatingTransitionCallback
        public boolean onHideTitleBar(SurfaceControl r1, Bundle r2) throws RemoteException {
            return false;
        }

        @Override // android.view.IFloatingTransitionCallback
        public void onTransitionCancelled() throws RemoteException {
        }

        @Override // android.view.IFloatingTransitionCallback
        public void onTransitionFinished() throws RemoteException {
        }

        @Override // android.view.IFloatingTransitionCallback
        public boolean onTransitionStart(SurfaceControl r1, SurfaceControl r2, Bundle r3) throws RemoteException {
            return false;
        }
    }

    public static abstract class Stub extends Binder implements IFloatingTransitionCallback {
        private static final String DESCRIPTOR = "android.view.IFloatingTransitionCallback";
        static final int TRANSACTION_onHideTitleBar = 2;
        static final int TRANSACTION_onTransitionCancelled = 3;
        static final int TRANSACTION_onTransitionFinished = 4;
        static final int TRANSACTION_onTransitionStart = 1;

        public static class Proxy implements IFloatingTransitionCallback {
            public static IFloatingTransitionCallback sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // android.view.IFloatingTransitionCallback
            public void onTransitionCancelled() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_android_view_IFloatingTransitionCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onTransitionCancelled();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.view.IFloatingTransitionCallback
            public void onTransitionFinished() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_android_view_IFloatingTransitionCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onTransitionFinished();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public Proxy(IBinder r1) {
                this.mRemote = r1;
            }

            @Override // android.view.IFloatingTransitionCallback
            public boolean onHideTitleBar(SurfaceControl r7, Bundle r8) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L23
                boolean r2 = true;
                if (r7 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L23
                r7.writeToParcel(r0, 0);     // Catch: Throwable -> L23
            L7:
                if (r8 == null) goto L9;
                r0.writeInt(1);     // Catch: Throwable -> L23
                r8.writeToParcel(r0, 0);     // Catch: Throwable -> L23
            L11:
                if (INVOKEINTERFACE_android_view_IFloatingTransitionCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r0, r1, 0) == false) goto L13;
            L17:
                r1.readException();     // Catch: Throwable -> L23
                if (r1.readInt() != 0) goto L21;
                r2 = false;
            L21:
                r1.recycle();
                r0.recycle();
                return r2;
            L13:
                if (Stub.getDefaultImpl() == null) goto L17;
                boolean r9 = Stub.getDefaultImpl().onHideTitleBar(r7, r8);     // Catch: Throwable -> L23
                r1.recycle();
                r0.recycle();
                return r9;
            L9:
                r0.writeInt(0);     // Catch: Throwable -> L23
                goto L11
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L23
            L23:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.view.IFloatingTransitionCallback
            public boolean onTransitionStart(SurfaceControl r6, SurfaceControl r7, Bundle r8) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L26
                boolean r2 = true;
                if (r6 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L26
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L26
            L7:
                if (r7 == null) goto L9;
                r0.writeInt(1);     // Catch: Throwable -> L26
                r7.writeToParcel(r0, 0);     // Catch: Throwable -> L26
            L10:
                if (r8 == null) goto L12;
                r0.writeInt(1);     // Catch: Throwable -> L26
                r8.writeToParcel(r0, 0);     // Catch: Throwable -> L26
            L14:
                if (INVOKEINTERFACE_android_view_IFloatingTransitionCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r0, r1, 0) == false) goto L16;
            L20:
                r1.readException();     // Catch: Throwable -> L26
                if (r1.readInt() != 0) goto L24;
                r2 = false;
            L24:
                r1.recycle();
                r0.recycle();
                return r2;
            L16:
                if (Stub.getDefaultImpl() == null) goto L20;
                boolean r9 = Stub.getDefaultImpl().onTransitionStart(r6, r7, r8);     // Catch: Throwable -> L26
                r1.recycle();
                r0.recycle();
                return r9;
            L12:
                r0.writeInt(0);     // Catch: Throwable -> L26
                goto L14
            L9:
                r0.writeInt(0);     // Catch: Throwable -> L26
                goto L10
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L26
            L26:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_android_view_IFloatingTransitionCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r15, int r16, Parcel r17, Parcel r18, int r19) throws RemoteException {
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

        public static IFloatingTransitionCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static IFloatingTransitionCallback asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof IFloatingTransitionCallback) == false) goto L12;
            return (IFloatingTransitionCallback) r0;
        L12:
            return new Proxy(r2);
        }

        public static boolean setDefaultImpl(IFloatingTransitionCallback r1) {
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
        public boolean onTransact(int r5, Parcel r6, Parcel r7, int r8) throws RemoteException {
            Bundle r0 = null;
            if (r5 != 1) goto L5;
            r6.enforceInterface(DESCRIPTOR);
            if (r6.readInt() == 0) goto L32;
            SurfaceControl r9 = (SurfaceControl) SurfaceControl.CREATOR.createFromParcel(r6);
        L34:
            if (r6.readInt() == 0) goto L36;
            SurfaceControl r10 = (SurfaceControl) SurfaceControl.CREATOR.createFromParcel(r6);
        L38:
            if (r6.readInt() == 0) goto L40;
            r0 = (Bundle) Bundle.CREATOR.createFromParcel(r6);
        L40:
            boolean r11 = onTransitionStart(r9, r10, r0);
            r7.writeNoException();
            r7.writeInt(r11 ? 1 : 0);
            return true;
        L36:
            r10 = null;
            goto L38
        L32:
            r9 = null;
            goto L34
        L5:
            if (r5 != 2) goto L7;
            r6.enforceInterface(DESCRIPTOR);
            if (r6.readInt() == 0) goto L23;
            SurfaceControl r12 = (SurfaceControl) SurfaceControl.CREATOR.createFromParcel(r6);
        L25:
            if (r6.readInt() == 0) goto L27;
            r0 = (Bundle) Bundle.CREATOR.createFromParcel(r6);
        L27:
            boolean r13 = onHideTitleBar(r12, r0);
            r7.writeNoException();
            r7.writeInt(r13 ? 1 : 0);
            return true;
        L23:
            r12 = null;
            goto L25
        L7:
            if (r5 != 3) goto L9;
            r6.enforceInterface(DESCRIPTOR);
            onTransitionCancelled();
            r7.writeNoException();
            return true;
        L9:
            if (r5 != 4) goto L11;
            r6.enforceInterface(DESCRIPTOR);
            onTransitionFinished();
            r7.writeNoException();
            return true;
        L11:
            if (r5 != 1598968902) goto L13;
            r7.writeString(DESCRIPTOR);
            return true;
        L13:
            return super.onTransact(r5, r6, r7, r8);
        }
    }

    boolean onHideTitleBar(SurfaceControl r1, Bundle r2) throws RemoteException;

    void onTransitionCancelled() throws RemoteException;

    void onTransitionFinished() throws RemoteException;

    boolean onTransitionStart(SurfaceControl r1, SurfaceControl r2, Bundle r3) throws RemoteException;
}
