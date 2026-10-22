package com.obric.aiagent.flow.applog.idl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes4.dex */
public interface IFlowAppLogDataObserverIDL extends IInterface {

    /* JADX INFO: loaded from: classes32.dex */
    public static class Default implements IFlowAppLogDataObserverIDL {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogDataObserverIDL
        public void onIdLoaded(String r100, String r101, String r102) throws RemoteException {
        }

        @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogDataObserverIDL
        public void onRemoteIdGet(boolean r100, String r101, String r102, String r103, String r104, String r105, String r106) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IFlowAppLogDataObserverIDL {
        private static final String DESCRIPTOR = "com.obric.aiagent.flow.applog.idl.IFlowAppLogDataObserverIDL";
        static final int TRANSACTION_onIdLoaded = 1;
        static final int TRANSACTION_onRemoteIdGet = 2;

        public static class Proxy implements IFlowAppLogDataObserverIDL {
            public static IFlowAppLogDataObserverIDL sDefaultImpl;
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

            @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogDataObserverIDL
            public void onIdLoaded(String r100, String r101, String r102) throws RemoteException {
                Parcel r103 = Parcel.obtain();
                r103.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r103.writeString(r100);     // Catch: Throwable -> L12
                r103.writeString(r101);     // Catch: Throwable -> L12
                r103.writeString(r102);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_aiagent_flow_applog_idl_IFlowAppLogDataObserverIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r103, null, 1) == false) goto L6;
            L10:
                r103.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onIdLoaded(r100, r101, r102);     // Catch: Throwable -> L12
                r103.recycle();
                return;
            L12:
                th = move-exception;
                r103.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_obric_aiagent_flow_applog_idl_IFlowAppLogDataObserverIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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

            @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogDataObserverIDL
            public void onRemoteIdGet(boolean r110, String r111, String r112, String r113, String r114, String r115, String r116) throws RemoteException {
                Parcel r100 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L20
                if (r110 == false) goto L6;
                int r101 = 1;
            L7:
                r100.writeInt(r101);     // Catch: Throwable -> L20
                r100.writeString(r111);     // Catch: Throwable -> L20
                r100.writeString(r112);     // Catch: Throwable -> L20
                r100.writeString(r113);     // Catch: Throwable -> L20
                r100.writeString(r114);     // Catch: Throwable -> L20
                r100.writeString(r115);     // Catch: Throwable -> L20
                r100.writeString(r116);     // Catch: Throwable -> L20
            L18:
                th = th;
            L22:
                r100.recycle();
                throw th;
            L10:
                if (INVOKEINTERFACE_com_obric_aiagent_flow_applog_idl_IFlowAppLogDataObserverIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r100, null, 1) == false) goto L12;
            L16:
                r100.recycle();
                return;
            L12:
                if (Stub.getDefaultImpl() == null) goto L16;
                Stub.getDefaultImpl().onRemoteIdGet(r110, r111, r112, r113, r114, r115, r116);     // Catch: Throwable -> L18
                r100.recycle();
                return;
            L6:
                r101 = 0;
            L20:
                th = th;
                goto L22
            }
        }

        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IFlowAppLogDataObserverIDL getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static IFlowAppLogDataObserverIDL asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof IFlowAppLogDataObserverIDL) == false) goto L12;
            return (IFlowAppLogDataObserverIDL) r101;
        L12:
            return new Proxy(r100);
        }

        public static boolean setDefaultImpl(IFlowAppLogDataObserverIDL r100) {
            if (Proxy.sDefaultImpl != null) goto L10;
            if (r100 == null) goto L7;
            Proxy.sDefaultImpl = r100;
            return true;
        L7:
            return false;
        L10:
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        @Override // android.os.Binder
        public boolean onTransact(int r110, Parcel r111, Parcel r112, int r113) throws RemoteException {
            if (r110 != 1) goto L5;
            r111.enforceInterface(DESCRIPTOR);
            onIdLoaded(r111.readString(), r111.readString(), r111.readString());
            return true;
        L5:
            if (r110 != 2) goto L7;
            r111.enforceInterface(DESCRIPTOR);
            if (r111.readInt() == 0) goto L15;
            boolean r100 = true;
        L16:
            onRemoteIdGet(r100, r111.readString(), r111.readString(), r111.readString(), r111.readString(), r111.readString(), r111.readString());
            return true;
        L15:
            r100 = false;
            goto L16
        L7:
            if (r110 != 1598968902) goto L9;
            r112.writeString(DESCRIPTOR);
            return true;
        L9:
            return super.onTransact(r110, r111, r112, r113);
        }
    }

    void onIdLoaded(String r100, String r101, String r102) throws RemoteException;

    void onRemoteIdGet(boolean r100, String r101, String r102, String r103, String r104, String r105, String r106) throws RemoteException;
}
