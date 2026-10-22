package com.obric.aiagent.flow.applog.idl;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import java.util.Map;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes4.dex */
public interface IFlowAppLogIDL extends IInterface {

    /* JADX INFO: loaded from: classes32.dex */
    public static class Default implements IFlowAppLogIDL {
        public Default() {
        }

        @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
        public void addDataObserver(IFlowAppLogDataObserverIDL r100) throws RemoteException {
        }

        @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
        public void addEventObserver(IFlowAppLogEventObserverIDL r100) throws RemoteException {
        }

        @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
        public void addSessionHook(IFlowAppLogSessionObserverIDL r100) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
        public void clearLaunchService() throws RemoteException {
        }

        @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
        public String getDid() throws RemoteException {
            return null;
        }

        @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
        public String getIid() throws RemoteException {
            return null;
        }

        @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
        public String getSsid() throws RemoteException {
            return null;
        }

        @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
        public String getUserID() throws RemoteException {
            return null;
        }

        @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
        public String getUserUniqueID() throws RemoteException {
            return null;
        }

        @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
        public void onEventV3(String r100) throws RemoteException {
        }

        @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
        public void onEventV3Bundle(String r100, Bundle r101) throws RemoteException {
        }

        @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
        public void onEventV3Json(String r100, String r101) throws RemoteException {
        }

        @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
        public void onPause() throws RemoteException {
        }

        @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
        public void onResume(String r100, int r101) throws RemoteException {
        }

        @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
        public void onStop() throws RemoteException {
        }

        @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
        public void removeDataObserver(IFlowAppLogDataObserverIDL r100) throws RemoteException {
        }

        @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
        public void removeEventObserver(IFlowAppLogEventObserverIDL r100) throws RemoteException {
        }

        @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
        public void removeSessionHook(IFlowAppLogSessionObserverIDL r100) throws RemoteException {
        }

        @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
        public void setHeaderInfo(Map r100) throws RemoteException {
        }

        @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
        public void setLaunchService(String r100) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IFlowAppLogIDL {
        private static final String DESCRIPTOR = "com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL";
        static final int TRANSACTION_addDataObserver = 9;
        static final int TRANSACTION_addEventObserver = 7;
        static final int TRANSACTION_addSessionHook = 5;
        static final int TRANSACTION_clearLaunchService = 15;
        static final int TRANSACTION_getDid = 16;
        static final int TRANSACTION_getIid = 17;
        static final int TRANSACTION_getSsid = 18;
        static final int TRANSACTION_getUserID = 20;
        static final int TRANSACTION_getUserUniqueID = 19;
        static final int TRANSACTION_onEventV3 = 2;
        static final int TRANSACTION_onEventV3Bundle = 4;
        static final int TRANSACTION_onEventV3Json = 3;
        static final int TRANSACTION_onPause = 12;
        static final int TRANSACTION_onResume = 11;
        static final int TRANSACTION_onStop = 13;
        static final int TRANSACTION_removeDataObserver = 10;
        static final int TRANSACTION_removeEventObserver = 8;
        static final int TRANSACTION_removeSessionHook = 6;
        static final int TRANSACTION_setHeaderInfo = 1;
        static final int TRANSACTION_setLaunchService = 14;

        /* JADX INFO: loaded from: classes6.dex */
        public static class Proxy implements IFlowAppLogIDL {
            public static IFlowAppLogIDL sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
            public void clearLaunchService() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_aiagent_flow_applog_idl_IFlowAppLogIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 15, r100, null, 1) == false) goto L6;
            L10:
                r100.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().clearLaunchService();     // Catch: Throwable -> L12
                r100.recycle();
                return;
            L12:
                th = move-exception;
                r100.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
            public String getDid() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_aiagent_flow_applog_idl_IFlowAppLogIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 16, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L13
                String r102 = r101.readString();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r102;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                String r103 = Stub.getDefaultImpl().getDid();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r103;
            L13:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
            public String getIid() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_aiagent_flow_applog_idl_IFlowAppLogIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 17, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L13
                String r102 = r101.readString();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r102;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                String r103 = Stub.getDefaultImpl().getIid();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r103;
            L13:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
            public String getSsid() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_aiagent_flow_applog_idl_IFlowAppLogIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 18, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L13
                String r102 = r101.readString();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r102;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                String r103 = Stub.getDefaultImpl().getSsid();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r103;
            L13:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
            public String getUserID() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_aiagent_flow_applog_idl_IFlowAppLogIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 20, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L13
                String r102 = r101.readString();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r102;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                String r103 = Stub.getDefaultImpl().getUserID();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r103;
            L13:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
            public String getUserUniqueID() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_aiagent_flow_applog_idl_IFlowAppLogIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 19, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L13
                String r102 = r101.readString();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r102;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                String r103 = Stub.getDefaultImpl().getUserUniqueID();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r103;
            L13:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
            public void onPause() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_aiagent_flow_applog_idl_IFlowAppLogIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 12, r100, null, 1) == false) goto L6;
            L10:
                r100.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onPause();     // Catch: Throwable -> L12
                r100.recycle();
                return;
            L12:
                th = move-exception;
                r100.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
            public void onStop() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_aiagent_flow_applog_idl_IFlowAppLogIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 13, r100, null, 1) == false) goto L6;
            L10:
                r100.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onStop();     // Catch: Throwable -> L12
                r100.recycle();
                return;
            L12:
                th = move-exception;
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

            @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
            public void addDataObserver(IFlowAppLogDataObserverIDL r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r100 == null) goto L6;
                IBinder r102 = r100.asBinder();     // Catch: Throwable -> L16
            L7:
                r101.writeStrongBinder(r102);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_com_obric_aiagent_flow_applog_idl_IFlowAppLogIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 9, r101, null, 1) == false) goto L10;
            L14:
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().addDataObserver(r100);     // Catch: Throwable -> L16
                r101.recycle();
                return;
            L6:
                r102 = null;
            L16:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
            public void addEventObserver(IFlowAppLogEventObserverIDL r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r100 == null) goto L6;
                IBinder r102 = r100.asBinder();     // Catch: Throwable -> L16
            L7:
                r101.writeStrongBinder(r102);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_com_obric_aiagent_flow_applog_idl_IFlowAppLogIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 7, r101, null, 1) == false) goto L10;
            L14:
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().addEventObserver(r100);     // Catch: Throwable -> L16
                r101.recycle();
                return;
            L6:
                r102 = null;
            L16:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
            public void addSessionHook(IFlowAppLogSessionObserverIDL r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r100 == null) goto L6;
                IBinder r102 = r100.asBinder();     // Catch: Throwable -> L16
            L7:
                r101.writeStrongBinder(r102);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_com_obric_aiagent_flow_applog_idl_IFlowAppLogIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 5, r101, null, 1) == false) goto L10;
            L14:
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().addSessionHook(r100);     // Catch: Throwable -> L16
                r101.recycle();
                return;
            L6:
                r102 = null;
            L16:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
            public void onEventV3(String r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r101.writeString(r100);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_aiagent_flow_applog_idl_IFlowAppLogIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r101, null, 1) == false) goto L6;
            L10:
                r101.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onEventV3(r100);     // Catch: Throwable -> L12
                r101.recycle();
                return;
            L12:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
            public void removeDataObserver(IFlowAppLogDataObserverIDL r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r100 == null) goto L6;
                IBinder r102 = r100.asBinder();     // Catch: Throwable -> L16
            L7:
                r101.writeStrongBinder(r102);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_com_obric_aiagent_flow_applog_idl_IFlowAppLogIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 10, r101, null, 1) == false) goto L10;
            L14:
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().removeDataObserver(r100);     // Catch: Throwable -> L16
                r101.recycle();
                return;
            L6:
                r102 = null;
            L16:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
            public void removeEventObserver(IFlowAppLogEventObserverIDL r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r100 == null) goto L6;
                IBinder r102 = r100.asBinder();     // Catch: Throwable -> L16
            L7:
                r101.writeStrongBinder(r102);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_com_obric_aiagent_flow_applog_idl_IFlowAppLogIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 8, r101, null, 1) == false) goto L10;
            L14:
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().removeEventObserver(r100);     // Catch: Throwable -> L16
                r101.recycle();
                return;
            L6:
                r102 = null;
            L16:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
            public void removeSessionHook(IFlowAppLogSessionObserverIDL r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r100 == null) goto L6;
                IBinder r102 = r100.asBinder();     // Catch: Throwable -> L16
            L7:
                r101.writeStrongBinder(r102);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_com_obric_aiagent_flow_applog_idl_IFlowAppLogIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 6, r101, null, 1) == false) goto L10;
            L14:
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().removeSessionHook(r100);     // Catch: Throwable -> L16
                r101.recycle();
                return;
            L6:
                r102 = null;
            L16:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
            public void setHeaderInfo(Map r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r101.writeMap(r100);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_aiagent_flow_applog_idl_IFlowAppLogIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r101, null, 1) == false) goto L6;
            L10:
                r101.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().setHeaderInfo(r100);     // Catch: Throwable -> L12
                r101.recycle();
                return;
            L12:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
            public void setLaunchService(String r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r101.writeString(r100);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_aiagent_flow_applog_idl_IFlowAppLogIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 14, r101, null, 1) == false) goto L6;
            L10:
                r101.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().setLaunchService(r100);     // Catch: Throwable -> L12
                r101.recycle();
                return;
            L12:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
            public void onEventV3Bundle(String r100, Bundle r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r102.writeString(r100);     // Catch: Throwable -> L16
                if (r101 == null) goto L6;
                r102.writeInt(1);     // Catch: Throwable -> L16
                r101.writeToParcel(r102, 0);     // Catch: Throwable -> L16
            L8:
                if (INVOKEINTERFACE_com_obric_aiagent_flow_applog_idl_IFlowAppLogIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r102, null, 1) == false) goto L10;
            L14:
                r102.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().onEventV3Bundle(r100, r101);     // Catch: Throwable -> L16
                r102.recycle();
                return;
            L6:
                r102.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r102.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
            public void onEventV3Json(String r100, String r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r102.writeString(r100);     // Catch: Throwable -> L12
                r102.writeString(r101);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_aiagent_flow_applog_idl_IFlowAppLogIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r102, null, 1) == false) goto L6;
            L10:
                r102.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onEventV3Json(r100, r101);     // Catch: Throwable -> L12
                r102.recycle();
                return;
            L12:
                th = move-exception;
                r102.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL
            public void onResume(String r100, int r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r102.writeString(r100);     // Catch: Throwable -> L12
                r102.writeInt(r101);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_aiagent_flow_applog_idl_IFlowAppLogIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 11, r102, null, 1) == false) goto L6;
            L10:
                r102.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onResume(r100, r101);     // Catch: Throwable -> L12
                r102.recycle();
                return;
            L12:
                th = move-exception;
                r102.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_obric_aiagent_flow_applog_idl_IFlowAppLogIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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

        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IFlowAppLogIDL getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static IFlowAppLogIDL asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof IFlowAppLogIDL) == false) goto L12;
            return (IFlowAppLogIDL) r101;
        L12:
            return new Proxy(r100);
        }

        public static boolean setDefaultImpl(IFlowAppLogIDL r100) {
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
        public boolean onTransact(int r100, Parcel r101, Parcel r102, int r103) throws RemoteException {
            if (r100 == 1598968902) goto L51;
            switch(r100) {
                case 1: goto L49;
                case 2: goto L47;
                case 3: goto L45;
                case 4: goto L39;
                case 5: goto L37;
                case 6: goto L35;
                case 7: goto L33;
                case 8: goto L31;
                case 9: goto L29;
                case 10: goto L27;
                case 11: goto L25;
                case 12: goto L23;
                case 13: goto L21;
                case 14: goto L19;
                case 15: goto L17;
                case 16: goto L15;
                case 17: goto L13;
                case 18: goto L11;
                case 19: goto L9;
                case 20: goto L7;
                default: goto L6;
            };
        L7:
            r101.enforceInterface(DESCRIPTOR);
            String r104 = getUserID();
            r102.writeNoException();
            r102.writeString(r104);
            return true;
        L9:
            r101.enforceInterface(DESCRIPTOR);
            String r105 = getUserUniqueID();
            r102.writeNoException();
            r102.writeString(r105);
            return true;
        L11:
            r101.enforceInterface(DESCRIPTOR);
            String r106 = getSsid();
            r102.writeNoException();
            r102.writeString(r106);
            return true;
        L13:
            r101.enforceInterface(DESCRIPTOR);
            String r107 = getIid();
            r102.writeNoException();
            r102.writeString(r107);
            return true;
        L15:
            r101.enforceInterface(DESCRIPTOR);
            String r108 = getDid();
            r102.writeNoException();
            r102.writeString(r108);
            return true;
        L17:
            r101.enforceInterface(DESCRIPTOR);
            clearLaunchService();
            return true;
        L19:
            r101.enforceInterface(DESCRIPTOR);
            setLaunchService(r101.readString());
            return true;
        L21:
            r101.enforceInterface(DESCRIPTOR);
            onStop();
            return true;
        L23:
            r101.enforceInterface(DESCRIPTOR);
            onPause();
            return true;
        L25:
            r101.enforceInterface(DESCRIPTOR);
            onResume(r101.readString(), r101.readInt());
            return true;
        L27:
            r101.enforceInterface(DESCRIPTOR);
            removeDataObserver(IFlowAppLogDataObserverIDL.Stub.asInterface(r101.readStrongBinder()));
            return true;
        L29:
            r101.enforceInterface(DESCRIPTOR);
            addDataObserver(IFlowAppLogDataObserverIDL.Stub.asInterface(r101.readStrongBinder()));
            return true;
        L31:
            r101.enforceInterface(DESCRIPTOR);
            removeEventObserver(IFlowAppLogEventObserverIDL.Stub.asInterface(r101.readStrongBinder()));
            return true;
        L33:
            r101.enforceInterface(DESCRIPTOR);
            addEventObserver(IFlowAppLogEventObserverIDL.Stub.asInterface(r101.readStrongBinder()));
            return true;
        L35:
            r101.enforceInterface(DESCRIPTOR);
            removeSessionHook(IFlowAppLogSessionObserverIDL.Stub.asInterface(r101.readStrongBinder()));
            return true;
        L37:
            r101.enforceInterface(DESCRIPTOR);
            addSessionHook(IFlowAppLogSessionObserverIDL.Stub.asInterface(r101.readStrongBinder()));
            return true;
        L39:
            r101.enforceInterface(DESCRIPTOR);
            String r109 = r101.readString();
            if (r101.readInt() == 0) goto L42;
            Bundle r110 = (Bundle) Bundle.CREATOR.createFromParcel(r101);
        L43:
            onEventV3Bundle(r109, r110);
            return true;
        L42:
            r110 = null;
            goto L43
        L45:
            r101.enforceInterface(DESCRIPTOR);
            onEventV3Json(r101.readString(), r101.readString());
            return true;
        L47:
            r101.enforceInterface(DESCRIPTOR);
            onEventV3(r101.readString());
            return true;
        L49:
            r101.enforceInterface(DESCRIPTOR);
            setHeaderInfo(r101.readHashMap(getClass().getClassLoader()));
            return true;
        L6:
            return super.onTransact(r100, r101, r102, r103);
        L51:
            r102.writeString(DESCRIPTOR);
            return true;
        }
    }

    void addDataObserver(IFlowAppLogDataObserverIDL r100) throws RemoteException;

    void addEventObserver(IFlowAppLogEventObserverIDL r100) throws RemoteException;

    void addSessionHook(IFlowAppLogSessionObserverIDL r100) throws RemoteException;

    void clearLaunchService() throws RemoteException;

    String getDid() throws RemoteException;

    String getIid() throws RemoteException;

    String getSsid() throws RemoteException;

    String getUserID() throws RemoteException;

    String getUserUniqueID() throws RemoteException;

    void onEventV3(String r100) throws RemoteException;

    void onEventV3Bundle(String r100, Bundle r101) throws RemoteException;

    void onEventV3Json(String r100, String r101) throws RemoteException;

    void onPause() throws RemoteException;

    void onResume(String r100, int r101) throws RemoteException;

    void onStop() throws RemoteException;

    void removeDataObserver(IFlowAppLogDataObserverIDL r100) throws RemoteException;

    void removeEventObserver(IFlowAppLogEventObserverIDL r100) throws RemoteException;

    void removeSessionHook(IFlowAppLogSessionObserverIDL r100) throws RemoteException;

    void setHeaderInfo(Map r100) throws RemoteException;

    void setLaunchService(String r100) throws RemoteException;
}
