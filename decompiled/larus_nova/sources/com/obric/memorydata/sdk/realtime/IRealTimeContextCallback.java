package com.obric.memorydata.sdk.realtime;

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
public interface IRealTimeContextCallback extends IInterface {

    /* JADX INFO: loaded from: classes33.dex */
    public static class Default implements IRealTimeContextCallback {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.memorydata.sdk.realtime.IRealTimeContextCallback
        public void updateActionContext(ActionContext r100) throws RemoteException {
        }

        @Override // com.obric.memorydata.sdk.realtime.IRealTimeContextCallback
        public void updateRealTimeContext(RealTimeContext r100, boolean r101) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IRealTimeContextCallback {
        private static final String DESCRIPTOR = "com.obric.memorydata.sdk.realtime.IRealTimeContextCallback";
        static final int TRANSACTION_updateActionContext = 2;
        static final int TRANSACTION_updateRealTimeContext = 1;

        /* JADX INFO: loaded from: classes33.dex */
        public static class Proxy implements IRealTimeContextCallback {
            public static IRealTimeContextCallback sDefaultImpl;
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

            @Override // com.obric.memorydata.sdk.realtime.IRealTimeContextCallback
            public void updateActionContext(ActionContext r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r100 == null) goto L6;
                r101.writeInt(1);     // Catch: Throwable -> L17
                r100.writeToParcel(r101, 0);     // Catch: Throwable -> L17
            L8:
                if (INVOKEINTERFACE_com_obric_memorydata_sdk_realtime_IRealTimeContextCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r101, r102, 0) == false) goto L10;
            L14:
                r102.readException();     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().updateActionContext(r100);     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return;
            L6:
                r101.writeInt(0);     // Catch: Throwable -> L17
            L17:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.obric.memorydata.sdk.realtime.IRealTimeContextCallback
            public void updateRealTimeContext(RealTimeContext r100, boolean r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L20
                if (r100 == null) goto L6;
                r102.writeInt(1);     // Catch: Throwable -> L20
                r100.writeToParcel(r102, 0);     // Catch: Throwable -> L20
            L7:
                if (r101 == false) goto L9;
                int r104 = 1;
            L10:
                r102.writeInt(r104);     // Catch: Throwable -> L20
                if (INVOKEINTERFACE_com_obric_memorydata_sdk_realtime_IRealTimeContextCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r102, r103, 0) == false) goto L13;
            L17:
                r103.readException();     // Catch: Throwable -> L20
                r103.recycle();
                r102.recycle();
                return;
            L13:
                if (Stub.getDefaultImpl() == null) goto L17;
                Stub.getDefaultImpl().updateRealTimeContext(r100, r101);     // Catch: Throwable -> L20
                r103.recycle();
                r102.recycle();
                return;
            L9:
                r104 = 0;
                goto L10
            L6:
                r102.writeInt(0);     // Catch: Throwable -> L20
            L20:
                th = move-exception;
                r103.recycle();
                r102.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_obric_memorydata_sdk_realtime_IRealTimeContextCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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

        public static IRealTimeContextCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static IRealTimeContextCallback asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof IRealTimeContextCallback) == false) goto L12;
            return (IRealTimeContextCallback) r101;
        L12:
            return new Proxy(r100);
        }

        public static boolean setDefaultImpl(IRealTimeContextCallback r100) {
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
            RealTimeContext r104 = null;
            ActionContext r105 = null;
            if (r100 != 1) goto L5;
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L21;
            r104 = RealTimeContext.CREATOR.createFromParcel(r101);
        L21:
            if (r101.readInt() == 0) goto L23;
            boolean r106 = true;
        L24:
            updateRealTimeContext(r104, r106);
            r102.writeNoException();
            return true;
        L23:
            r106 = false;
            goto L24
        L5:
            if (r100 != 2) goto L7;
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L15;
            r105 = ActionContext.CREATOR.createFromParcel(r101);
        L15:
            updateActionContext(r105);
            r102.writeNoException();
            return true;
        L7:
            if (r100 != 1598968902) goto L9;
            r102.writeString(DESCRIPTOR);
            return true;
        L9:
            return super.onTransact(r100, r101, r102, r103);
        }
    }

    void updateActionContext(ActionContext r100) throws RemoteException;

    void updateRealTimeContext(RealTimeContext r100, boolean r101) throws RemoteException;
}
