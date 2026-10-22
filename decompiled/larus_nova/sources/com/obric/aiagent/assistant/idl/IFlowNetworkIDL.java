package com.obric.aiagent.assistant.idl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aiagent.assistant.idl.bean.OPushEvent;
import com.obric.aiagent.assistant.idl.bean.ObricConditionalTaskSweepRequest;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes4.dex */
public interface IFlowNetworkIDL extends IInterface {

    /* JADX INFO: loaded from: classes32.dex */
    public static class Default implements IFlowNetworkIDL {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
        public void clearOmniTasks(Map r100, IFlowNetworkResultCallbackIDL r101) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
        public void createConditionalTask(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107, String r108, String r110, String r111, String r112, String r113, String r114, Map r115, IFlowNetworkResultCallbackIDL r116) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
        public void deleteConditionalTask(String r100, Map r101, IFlowNetworkResultCallbackIDL r102) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
        public int getCurrentNetworkStatus() throws RemoteException {
            return 0;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
        public void notifyStopComplexTaskByHttp(long r100) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
        public void notifyStopComplexTaskByHttpWithScene(long r100, String r101) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
        public void notifyStopOmniTaskByHttp(String r100, Map r101, IFlowNetworkResultCallbackIDL r102) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
        public void notifyUserOperateQueue(String r100, IFlowNetworkResultCallbackIDL r101) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
        public void sendIntentResultForAsyncNotifyByHttp(List<OPushEvent> r100, boolean r101, IFlowNetworkResultCallbackIDL r102) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
        public void sendIntentResultForCompensationByHttp(List<OPushEvent> r100, boolean r101, IFlowNetworkResultCallbackIDL r102) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
        public void sendNormalRouterByHttp(String r100, String r101, IFlowNetworkResultCallbackIDL r102) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
        public void sendReplyAskUserByHttp(String r100, String r101, String r102, Map r103, IFlowNetworkResultCallbackIDL r104) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
        public void sweepConditionalTask(ObricConditionalTaskSweepRequest r100, IFlowNetworkResultCallbackIDL r101) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
        public void uploadOmniDataFeedbackByHttp(String r100, String r101, int r102, String r103, String r104, String r105, String r106, String r107, String r108, String r110, String r111, List<String> r112, String r113, String r114, IFlowNetworkResultCallbackIDL r115) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
        public void uploadOmniDataFeedbackByHttpV2(String r100, String r101, int r102, String r103, String r104, String r105, String r106, String r107, String r108, String r110, String r111, List<String> r112, String r113, String r114, boolean r115, IFlowNetworkResultCallbackIDL r116) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
        public void uploadOmniScreenshotByHttp(String r100, String r101, int r102, String r103, String r104, String r105, String r106, List<String> r107, String r108, String r110, IFlowNetworkResultCallbackIDL r111) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
        public void uploadOmniScreenshotByHttpV2(String r100, String r101, int r102, String r103, String r104, String r105, String r106, List<String> r107, String r108, String r110, boolean r111, IFlowNetworkResultCallbackIDL r112) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
        public void uploadUserTakeOverByHttp(String r100, String r101, String r102, long r103, Map r104, IFlowNetworkResultCallbackIDL r105) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IFlowNetworkIDL {
        private static final String DESCRIPTOR = "com.obric.aiagent.assistant.idl.IFlowNetworkIDL";
        static final int TRANSACTION_clearOmniTasks = 11;
        static final int TRANSACTION_createConditionalTask = 13;
        static final int TRANSACTION_deleteConditionalTask = 15;
        static final int TRANSACTION_getCurrentNetworkStatus = 6;
        static final int TRANSACTION_notifyStopComplexTaskByHttp = 5;
        static final int TRANSACTION_notifyStopComplexTaskByHttpWithScene = 12;
        static final int TRANSACTION_notifyStopOmniTaskByHttp = 10;
        static final int TRANSACTION_notifyUserOperateQueue = 9;
        static final int TRANSACTION_sendIntentResultForAsyncNotifyByHttp = 2;
        static final int TRANSACTION_sendIntentResultForCompensationByHttp = 1;
        static final int TRANSACTION_sendNormalRouterByHttp = 3;
        static final int TRANSACTION_sendReplyAskUserByHttp = 4;
        static final int TRANSACTION_sweepConditionalTask = 14;
        static final int TRANSACTION_uploadOmniDataFeedbackByHttp = 16;
        static final int TRANSACTION_uploadOmniDataFeedbackByHttpV2 = 18;
        static final int TRANSACTION_uploadOmniScreenshotByHttp = 8;
        static final int TRANSACTION_uploadOmniScreenshotByHttpV2 = 17;
        static final int TRANSACTION_uploadUserTakeOverByHttp = 7;

        /* JADX INFO: loaded from: classes6.dex */
        public static class Proxy implements IFlowNetworkIDL {
            public static IFlowNetworkIDL sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
            public int getCurrentNetworkStatus() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowNetworkIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 6, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L13
                int r102 = r101.readInt();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r102;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r103 = Stub.getDefaultImpl().getCurrentNetworkStatus();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r103;
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

            @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
            public void notifyStopComplexTaskByHttp(long r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r101.writeLong(r100);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowNetworkIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 5, r101, null, 1) == false) goto L6;
            L10:
                r101.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().notifyStopComplexTaskByHttp(r100);     // Catch: Throwable -> L12
                r101.recycle();
                return;
            L12:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
            public void clearOmniTasks(Map r100, IFlowNetworkResultCallbackIDL r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r102.writeMap(r100);     // Catch: Throwable -> L16
                if (r101 == null) goto L6;
                IBinder r103 = r101.asBinder();     // Catch: Throwable -> L16
            L7:
                r102.writeStrongBinder(r103);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowNetworkIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 11, r102, null, 1) == false) goto L10;
            L14:
                r102.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().clearOmniTasks(r100, r101);     // Catch: Throwable -> L16
                r102.recycle();
                return;
            L6:
                r103 = null;
            L16:
                th = move-exception;
                r102.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
            public void notifyStopComplexTaskByHttpWithScene(long r100, String r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r102.writeLong(r100);     // Catch: Throwable -> L12
                r102.writeString(r101);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowNetworkIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 12, r102, null, 1) == false) goto L6;
            L10:
                r102.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().notifyStopComplexTaskByHttpWithScene(r100, r101);     // Catch: Throwable -> L12
                r102.recycle();
                return;
            L12:
                th = move-exception;
                r102.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
            public void notifyUserOperateQueue(String r100, IFlowNetworkResultCallbackIDL r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r102.writeString(r100);     // Catch: Throwable -> L16
                if (r101 == null) goto L6;
                IBinder r103 = r101.asBinder();     // Catch: Throwable -> L16
            L7:
                r102.writeStrongBinder(r103);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowNetworkIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 9, r102, null, 1) == false) goto L10;
            L14:
                r102.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().notifyUserOperateQueue(r100, r101);     // Catch: Throwable -> L16
                r102.recycle();
                return;
            L6:
                r103 = null;
            L16:
                th = move-exception;
                r102.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
            public void sweepConditionalTask(ObricConditionalTaskSweepRequest r100, IFlowNetworkResultCallbackIDL r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L20
                if (r100 == null) goto L6;
                r102.writeInt(1);     // Catch: Throwable -> L20
                r100.writeToParcel(r102, 0);     // Catch: Throwable -> L20
            L8:
                if (r101 == null) goto L10;
                IBinder r103 = r101.asBinder();     // Catch: Throwable -> L20
            L11:
                r102.writeStrongBinder(r103);     // Catch: Throwable -> L20
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowNetworkIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 14, r102, null, 1) == false) goto L14;
            L18:
                r102.recycle();
                return;
            L14:
                if (Stub.getDefaultImpl() == null) goto L18;
                Stub.getDefaultImpl().sweepConditionalTask(r100, r101);     // Catch: Throwable -> L20
                r102.recycle();
                return;
            L10:
                r103 = null;
                goto L11
            L6:
                r102.writeInt(0);     // Catch: Throwable -> L20
            L20:
                th = move-exception;
                r102.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
            public void deleteConditionalTask(String r100, Map r101, IFlowNetworkResultCallbackIDL r102) throws RemoteException {
                Parcel r103 = Parcel.obtain();
                r103.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r103.writeString(r100);     // Catch: Throwable -> L16
                r103.writeMap(r101);     // Catch: Throwable -> L16
                if (r102 == null) goto L6;
                IBinder r104 = r102.asBinder();     // Catch: Throwable -> L16
            L7:
                r103.writeStrongBinder(r104);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowNetworkIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 15, r103, null, 1) == false) goto L10;
            L14:
                r103.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().deleteConditionalTask(r100, r101, r102);     // Catch: Throwable -> L16
                r103.recycle();
                return;
            L6:
                r104 = null;
            L16:
                th = move-exception;
                r103.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
            public void notifyStopOmniTaskByHttp(String r100, Map r101, IFlowNetworkResultCallbackIDL r102) throws RemoteException {
                Parcel r103 = Parcel.obtain();
                r103.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r103.writeString(r100);     // Catch: Throwable -> L16
                r103.writeMap(r101);     // Catch: Throwable -> L16
                if (r102 == null) goto L6;
                IBinder r104 = r102.asBinder();     // Catch: Throwable -> L16
            L7:
                r103.writeStrongBinder(r104);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowNetworkIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 10, r103, null, 1) == false) goto L10;
            L14:
                r103.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().notifyStopOmniTaskByHttp(r100, r101, r102);     // Catch: Throwable -> L16
                r103.recycle();
                return;
            L6:
                r104 = null;
            L16:
                th = move-exception;
                r103.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
            public void sendIntentResultForAsyncNotifyByHttp(List<OPushEvent> r100, boolean r101, IFlowNetworkResultCallbackIDL r102) throws RemoteException {
                Parcel r103 = Parcel.obtain();
                r103.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L20
                r103.writeTypedList(r100);     // Catch: Throwable -> L20
                if (r101 == false) goto L6;
                int r104 = 1;
            L7:
                r103.writeInt(r104);     // Catch: Throwable -> L20
                if (r102 == null) goto L10;
                IBinder r105 = r102.asBinder();     // Catch: Throwable -> L20
            L11:
                r103.writeStrongBinder(r105);     // Catch: Throwable -> L20
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowNetworkIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r103, null, 1) == false) goto L14;
            L18:
                r103.recycle();
                return;
            L14:
                if (Stub.getDefaultImpl() == null) goto L18;
                Stub.getDefaultImpl().sendIntentResultForAsyncNotifyByHttp(r100, r101, r102);     // Catch: Throwable -> L20
                r103.recycle();
                return;
            L10:
                r105 = null;
                goto L11
            L6:
                r104 = 0;
            L20:
                th = move-exception;
                r103.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
            public void sendIntentResultForCompensationByHttp(List<OPushEvent> r100, boolean r101, IFlowNetworkResultCallbackIDL r102) throws RemoteException {
                Parcel r103 = Parcel.obtain();
                r103.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L20
                r103.writeTypedList(r100);     // Catch: Throwable -> L20
                if (r101 == false) goto L6;
                int r104 = 1;
            L7:
                r103.writeInt(r104);     // Catch: Throwable -> L20
                if (r102 == null) goto L10;
                IBinder r105 = r102.asBinder();     // Catch: Throwable -> L20
            L11:
                r103.writeStrongBinder(r105);     // Catch: Throwable -> L20
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowNetworkIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r103, null, 1) == false) goto L14;
            L18:
                r103.recycle();
                return;
            L14:
                if (Stub.getDefaultImpl() == null) goto L18;
                Stub.getDefaultImpl().sendIntentResultForCompensationByHttp(r100, r101, r102);     // Catch: Throwable -> L20
                r103.recycle();
                return;
            L10:
                r105 = null;
                goto L11
            L6:
                r104 = 0;
            L20:
                th = move-exception;
                r103.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
            public void sendNormalRouterByHttp(String r100, String r101, IFlowNetworkResultCallbackIDL r102) throws RemoteException {
                Parcel r103 = Parcel.obtain();
                r103.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r103.writeString(r100);     // Catch: Throwable -> L16
                r103.writeString(r101);     // Catch: Throwable -> L16
                if (r102 == null) goto L6;
                IBinder r104 = r102.asBinder();     // Catch: Throwable -> L16
            L7:
                r103.writeStrongBinder(r104);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowNetworkIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r103, null, 1) == false) goto L10;
            L14:
                r103.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().sendNormalRouterByHttp(r100, r101, r102);     // Catch: Throwable -> L16
                r103.recycle();
                return;
            L6:
                r104 = null;
            L16:
                th = move-exception;
                r103.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowNetworkIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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

            @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
            public void sendReplyAskUserByHttp(String r100, String r110, String r111, Map r112, IFlowNetworkResultCallbackIDL r113) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r101.writeString(r100);     // Catch: Throwable -> L16
                r101.writeString(r110);     // Catch: Throwable -> L16
                r101.writeString(r111);     // Catch: Throwable -> L16
                r101.writeMap(r112);     // Catch: Throwable -> L16
                if (r113 == null) goto L6;
                IBinder r102 = r113.asBinder();     // Catch: Throwable -> L16
            L7:
                r101.writeStrongBinder(r102);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowNetworkIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r101, null, 1) == false) goto L10;
            L14:
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().sendReplyAskUserByHttp(r100, r110, r111, r112, r113);     // Catch: Throwable -> L16
                r101.recycle();
                return;
            L6:
                r102 = null;
            L16:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
            public void uploadUserTakeOverByHttp(String r110, String r111, String r112, long r113, Map r114, IFlowNetworkResultCallbackIDL r115) throws RemoteException {
                Parcel r100 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L20
                r100.writeString(r110);     // Catch: Throwable -> L20
                r100.writeString(r111);     // Catch: Throwable -> L20
                r100.writeString(r112);     // Catch: Throwable -> L20
                r100.writeLong(r113);     // Catch: Throwable -> L20
                r100.writeMap(r114);     // Catch: Throwable -> L20
                if (r115 == null) goto L6;
                IBinder r101 = r115.asBinder();     // Catch: Throwable -> L20
            L7:
                r100.writeStrongBinder(r101);     // Catch: Throwable -> L20
            L18:
                th = th;
            L22:
                r100.recycle();
                throw th;
            L10:
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowNetworkIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 7, r100, null, 1) == false) goto L12;
            L16:
                r100.recycle();
                return;
            L12:
                if (Stub.getDefaultImpl() == null) goto L16;
                Stub.getDefaultImpl().uploadUserTakeOverByHttp(r110, r111, r112, r113, r114, r115);     // Catch: Throwable -> L18
                r100.recycle();
                return;
            L6:
                r101 = null;
            L20:
                th = th;
                goto L22
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
            public void uploadOmniScreenshotByHttp(String r110, String r111, int r112, String r210, String r211, String r212, String r213, List<String> r214, String r215, String r216, IFlowNetworkResultCallbackIDL r217) throws RemoteException {
                Parcel r100 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L20
                r100.writeString(r110);     // Catch: Throwable -> L20
                r100.writeString(r111);     // Catch: Throwable -> L20
                r100.writeInt(r112);     // Catch: Throwable -> L20
                r100.writeString(r210);     // Catch: Throwable -> L20
                r100.writeString(r211);     // Catch: Throwable -> L20
                r100.writeString(r212);     // Catch: Throwable -> L20
                r100.writeString(r213);     // Catch: Throwable -> L20
                r100.writeStringList(r214);     // Catch: Throwable -> L20
                r100.writeString(r215);     // Catch: Throwable -> L20
                r100.writeString(r216);     // Catch: Throwable -> L20
                if (r217 == null) goto L6;
                IBinder r101 = r217.asBinder();     // Catch: Throwable -> L20
            L7:
                r100.writeStrongBinder(r101);     // Catch: Throwable -> L20
            L18:
                th = th;
            L22:
                r100.recycle();
                throw th;
            L10:
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowNetworkIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 8, r100, null, 1) == false) goto L12;
            L16:
                r100.recycle();
                return;
            L12:
                if (Stub.getDefaultImpl() == null) goto L16;
                Stub.getDefaultImpl().uploadOmniScreenshotByHttp(r110, r111, r112, r210, r211, r212, r213, r214, r215, r216, r217);     // Catch: Throwable -> L18
                r100.recycle();
                return;
            L6:
                r101 = null;
            L20:
                th = th;
                goto L22
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
            public void uploadOmniScreenshotByHttpV2(String r110, String r111, int r112, String r210, String r211, String r212, String r213, List<String> r214, String r215, String r216, boolean r217, IFlowNetworkResultCallbackIDL r218) throws RemoteException {
                Parcel r100 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L24
                r100.writeString(r110);     // Catch: Throwable -> L24
                r100.writeString(r111);     // Catch: Throwable -> L24
                r100.writeInt(r112);     // Catch: Throwable -> L24
                r100.writeString(r210);     // Catch: Throwable -> L24
                r100.writeString(r211);     // Catch: Throwable -> L24
                r100.writeString(r212);     // Catch: Throwable -> L24
                r100.writeString(r213);     // Catch: Throwable -> L24
                r100.writeStringList(r214);     // Catch: Throwable -> L24
                r100.writeString(r215);     // Catch: Throwable -> L24
                r100.writeString(r216);     // Catch: Throwable -> L24
                if (r217 == false) goto L6;
                int r101 = 1;
            L7:
                r100.writeInt(r101);     // Catch: Throwable -> L24
                if (r218 == null) goto L10;
                IBinder r113 = r218.asBinder();     // Catch: Throwable -> L24
            L11:
                r100.writeStrongBinder(r113);     // Catch: Throwable -> L24
            L22:
                th = th;
            L26:
                r100.recycle();
                throw th;
            L14:
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowNetworkIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 17, r100, null, 1) == false) goto L16;
            L20:
                r100.recycle();
                return;
            L16:
                if (Stub.getDefaultImpl() == null) goto L20;
                Stub.getDefaultImpl().uploadOmniScreenshotByHttpV2(r110, r111, r112, r210, r211, r212, r213, r214, r215, r216, r217, r218);     // Catch: Throwable -> L22
                r100.recycle();
                return;
            L10:
                r113 = null;
                goto L11
            L6:
                r101 = 0;
            L24:
                th = th;
                goto L26
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
            public void uploadOmniDataFeedbackByHttp(String r110, String r210, int r211, String r212, String r213, String r214, String r215, String r216, String r217, String r218, String r219, List<String> r310, String r311, String r312, IFlowNetworkResultCallbackIDL r313) throws RemoteException {
                Parcel r100 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r100.writeString(r110);     // Catch: Throwable -> L16
                r100.writeString(r210);     // Catch: Throwable -> L16
                r100.writeInt(r211);     // Catch: Throwable -> L16
                r100.writeString(r212);     // Catch: Throwable -> L16
                r100.writeString(r213);     // Catch: Throwable -> L16
                r100.writeString(r214);     // Catch: Throwable -> L16
                r100.writeString(r215);     // Catch: Throwable -> L16
                r100.writeString(r216);     // Catch: Throwable -> L16
                r100.writeString(r217);     // Catch: Throwable -> L16
                r100.writeString(r218);     // Catch: Throwable -> L16
                r100.writeString(r219);     // Catch: Throwable -> L16
                r100.writeStringList(r310);     // Catch: Throwable -> L16
                r100.writeString(r311);     // Catch: Throwable -> L16
                r100.writeString(r312);     // Catch: Throwable -> L16
                if (r313 == null) goto L6;
                IBinder r101 = r313.asBinder();     // Catch: Throwable -> L16
            L7:
                r100.writeStrongBinder(r101);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowNetworkIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 16, r100, null, 1) == false) goto L10;
            L14:
                r100.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().uploadOmniDataFeedbackByHttp(r110, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312, r313);     // Catch: Throwable -> L16
                r100.recycle();
                return;
            L6:
                r101 = null;
            L16:
                th = move-exception;
                r100.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
            public void createConditionalTask(String r210, String r211, String r212, String r213, String r214, String r215, String r216, String r217, String r218, String r219, String r310, String r311, String r312, String r313, Map r314, IFlowNetworkResultCallbackIDL r315) throws RemoteException {
                Parcel r100 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r100.writeString(r210);     // Catch: Throwable -> L16
                r100.writeString(r211);     // Catch: Throwable -> L16
                r100.writeString(r212);     // Catch: Throwable -> L16
                r100.writeString(r213);     // Catch: Throwable -> L16
                r100.writeString(r214);     // Catch: Throwable -> L16
                r100.writeString(r215);     // Catch: Throwable -> L16
                r100.writeString(r216);     // Catch: Throwable -> L16
                r100.writeString(r217);     // Catch: Throwable -> L16
                r100.writeString(r218);     // Catch: Throwable -> L16
                r100.writeString(r219);     // Catch: Throwable -> L16
                r100.writeString(r310);     // Catch: Throwable -> L16
                r100.writeString(r311);     // Catch: Throwable -> L16
                r100.writeString(r312);     // Catch: Throwable -> L16
                r100.writeString(r313);     // Catch: Throwable -> L16
                r100.writeMap(r314);     // Catch: Throwable -> L16
                if (r315 == null) goto L6;
                IBinder r101 = r315.asBinder();     // Catch: Throwable -> L16
            L7:
                r100.writeStrongBinder(r101);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowNetworkIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 13, r100, null, 1) == false) goto L10;
            L14:
                r100.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().createConditionalTask(r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312, r313, r314, r315);     // Catch: Throwable -> L16
                r100.recycle();
                return;
            L6:
                r101 = null;
            L16:
                th = move-exception;
                r100.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowNetworkIDL
            public void uploadOmniDataFeedbackByHttpV2(String r210, String r211, int r212, String r213, String r214, String r215, String r216, String r217, String r218, String r219, String r310, List<String> r311, String r312, String r313, boolean r314, IFlowNetworkResultCallbackIDL r315) throws RemoteException {
                Parcel r100 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L20
                r100.writeString(r210);     // Catch: Throwable -> L20
                r100.writeString(r211);     // Catch: Throwable -> L20
                r100.writeInt(r212);     // Catch: Throwable -> L20
                r100.writeString(r213);     // Catch: Throwable -> L20
                r100.writeString(r214);     // Catch: Throwable -> L20
                r100.writeString(r215);     // Catch: Throwable -> L20
                r100.writeString(r216);     // Catch: Throwable -> L20
                r100.writeString(r217);     // Catch: Throwable -> L20
                r100.writeString(r218);     // Catch: Throwable -> L20
                r100.writeString(r219);     // Catch: Throwable -> L20
                r100.writeString(r310);     // Catch: Throwable -> L20
                r100.writeStringList(r311);     // Catch: Throwable -> L20
                r100.writeString(r312);     // Catch: Throwable -> L20
                r100.writeString(r313);     // Catch: Throwable -> L20
                if (r314 == false) goto L6;
                int r101 = 1;
            L7:
                r100.writeInt(r101);     // Catch: Throwable -> L20
                if (r315 == null) goto L10;
                IBinder r102 = r315.asBinder();     // Catch: Throwable -> L20
            L11:
                r100.writeStrongBinder(r102);     // Catch: Throwable -> L20
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowNetworkIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 18, r100, null, 1) == false) goto L14;
            L18:
                r100.recycle();
                return;
            L14:
                if (Stub.getDefaultImpl() == null) goto L18;
                Stub.getDefaultImpl().uploadOmniDataFeedbackByHttpV2(r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312, r313, r314, r315);     // Catch: Throwable -> L20
                r100.recycle();
                return;
            L10:
                r102 = null;
                goto L11
            L6:
                r101 = 0;
            L20:
                th = move-exception;
                r100.recycle();
                throw th;
            }
        }

        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IFlowNetworkIDL getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static IFlowNetworkIDL asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof IFlowNetworkIDL) == false) goto L12;
            return (IFlowNetworkIDL) r101;
        L12:
            return new Proxy(r100);
        }

        public static boolean setDefaultImpl(IFlowNetworkIDL r100) {
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
        public boolean onTransact(int r210, Parcel r211, Parcel r212, int r213) throws RemoteException {
            if (r210 == 1598968902) goto L62;
            boolean r100 = false;
            switch(r210) {
                case 1: goto L57;
                case 2: goto L52;
                case 3: goto L50;
                case 4: goto L48;
                case 5: goto L46;
                case 6: goto L44;
                case 7: goto L42;
                case 8: goto L40;
                case 9: goto L38;
                case 10: goto L36;
                case 11: goto L34;
                case 12: goto L32;
                case 13: goto L30;
                case 14: goto L24;
                case 15: goto L22;
                case 16: goto L20;
                case 17: goto L14;
                case 18: goto L8;
                default: goto L7;
            };
        L8:
            r211.enforceInterface(DESCRIPTOR);
            String r101 = r211.readString();
            String r102 = r211.readString();
            int r103 = r211.readInt();
            String r104 = r211.readString();
            String r105 = r211.readString();
            String r106 = r211.readString();
            String r107 = r211.readString();
            String r108 = r211.readString();
            String r110 = r211.readString();
            String r111 = r211.readString();
            String r112 = r211.readString();
            ArrayList<String> r113 = r211.createStringArrayList();
            String r114 = r211.readString();
            String r115 = r211.readString();
            if (r211.readInt() == 0) goto L11;
            boolean r214 = true;
        L12:
            boolean r116 = r214;
            uploadOmniDataFeedbackByHttpV2(r101, r102, r103, r104, r105, r106, r107, r108, r110, r111, r112, r113, r114, r115, r116, IFlowNetworkResultCallbackIDL.Stub.asInterface(r211.readStrongBinder()));
            return true;
        L11:
            r214 = false;
            goto L12
        L14:
            r211.enforceInterface(DESCRIPTOR);
            String r109 = r211.readString();
            String r117 = r211.readString();
            int r118 = r211.readInt();
            String r119 = r211.readString();
            String r120 = r211.readString();
            String r121 = r211.readString();
            String r122 = r211.readString();
            ArrayList<String> r123 = r211.createStringArrayList();
            String r124 = r211.readString();
            String r125 = r211.readString();
            if (r211.readInt() == 0) goto L17;
            boolean r126 = true;
        L18:
            boolean r127 = r126;
            uploadOmniScreenshotByHttpV2(r109, r117, r118, r119, r120, r121, r122, r123, r124, r125, r127, IFlowNetworkResultCallbackIDL.Stub.asInterface(r211.readStrongBinder()));
            return true;
        L17:
            r126 = false;
            goto L18
        L20:
            r211.enforceInterface(DESCRIPTOR);
            uploadOmniDataFeedbackByHttp(r211.readString(), r211.readString(), r211.readInt(), r211.readString(), r211.readString(), r211.readString(), r211.readString(), r211.readString(), r211.readString(), r211.readString(), r211.readString(), r211.createStringArrayList(), r211.readString(), r211.readString(), IFlowNetworkResultCallbackIDL.Stub.asInterface(r211.readStrongBinder()));
            return true;
        L22:
            r211.enforceInterface(DESCRIPTOR);
            deleteConditionalTask(r211.readString(), r211.readHashMap(getClass().getClassLoader()), IFlowNetworkResultCallbackIDL.Stub.asInterface(r211.readStrongBinder()));
            return true;
        L24:
            r211.enforceInterface(DESCRIPTOR);
            if (r211.readInt() == 0) goto L27;
            ObricConditionalTaskSweepRequest r128 = ObricConditionalTaskSweepRequest.CREATOR.createFromParcel(r211);
        L28:
            sweepConditionalTask(r128, IFlowNetworkResultCallbackIDL.Stub.asInterface(r211.readStrongBinder()));
            return true;
        L27:
            r128 = null;
            goto L28
        L30:
            r211.enforceInterface(DESCRIPTOR);
            createConditionalTask(r211.readString(), r211.readString(), r211.readString(), r211.readString(), r211.readString(), r211.readString(), r211.readString(), r211.readString(), r211.readString(), r211.readString(), r211.readString(), r211.readString(), r211.readString(), r211.readString(), r211.readHashMap(getClass().getClassLoader()), IFlowNetworkResultCallbackIDL.Stub.asInterface(r211.readStrongBinder()));
            return true;
        L32:
            r211.enforceInterface(DESCRIPTOR);
            notifyStopComplexTaskByHttpWithScene(r211.readLong(), r211.readString());
            return true;
        L34:
            r211.enforceInterface(DESCRIPTOR);
            clearOmniTasks(r211.readHashMap(getClass().getClassLoader()), IFlowNetworkResultCallbackIDL.Stub.asInterface(r211.readStrongBinder()));
            return true;
        L36:
            r211.enforceInterface(DESCRIPTOR);
            notifyStopOmniTaskByHttp(r211.readString(), r211.readHashMap(getClass().getClassLoader()), IFlowNetworkResultCallbackIDL.Stub.asInterface(r211.readStrongBinder()));
            return true;
        L38:
            r211.enforceInterface(DESCRIPTOR);
            notifyUserOperateQueue(r211.readString(), IFlowNetworkResultCallbackIDL.Stub.asInterface(r211.readStrongBinder()));
            return true;
        L40:
            r211.enforceInterface(DESCRIPTOR);
            uploadOmniScreenshotByHttp(r211.readString(), r211.readString(), r211.readInt(), r211.readString(), r211.readString(), r211.readString(), r211.readString(), r211.createStringArrayList(), r211.readString(), r211.readString(), IFlowNetworkResultCallbackIDL.Stub.asInterface(r211.readStrongBinder()));
            return true;
        L42:
            r211.enforceInterface(DESCRIPTOR);
            uploadUserTakeOverByHttp(r211.readString(), r211.readString(), r211.readString(), r211.readLong(), r211.readHashMap(getClass().getClassLoader()), IFlowNetworkResultCallbackIDL.Stub.asInterface(r211.readStrongBinder()));
            return true;
        L44:
            r211.enforceInterface(DESCRIPTOR);
            int r129 = getCurrentNetworkStatus();
            r212.writeNoException();
            r212.writeInt(r129);
            return true;
        L46:
            r211.enforceInterface(DESCRIPTOR);
            notifyStopComplexTaskByHttp(r211.readLong());
            return true;
        L48:
            r211.enforceInterface(DESCRIPTOR);
            sendReplyAskUserByHttp(r211.readString(), r211.readString(), r211.readString(), r211.readHashMap(getClass().getClassLoader()), IFlowNetworkResultCallbackIDL.Stub.asInterface(r211.readStrongBinder()));
            return true;
        L50:
            r211.enforceInterface(DESCRIPTOR);
            sendNormalRouterByHttp(r211.readString(), r211.readString(), IFlowNetworkResultCallbackIDL.Stub.asInterface(r211.readStrongBinder()));
            return true;
        L52:
            r211.enforceInterface(DESCRIPTOR);
            ArrayList r130 = r211.createTypedArrayList(OPushEvent.CREATOR);
            if (r211.readInt() == 0) goto L55;
            r100 = true;
        L55:
            sendIntentResultForAsyncNotifyByHttp(r130, r100, IFlowNetworkResultCallbackIDL.Stub.asInterface(r211.readStrongBinder()));
            return true;
        L57:
            r211.enforceInterface(DESCRIPTOR);
            ArrayList r131 = r211.createTypedArrayList(OPushEvent.CREATOR);
            if (r211.readInt() == 0) goto L60;
            r100 = true;
        L60:
            sendIntentResultForCompensationByHttp(r131, r100, IFlowNetworkResultCallbackIDL.Stub.asInterface(r211.readStrongBinder()));
            return true;
        L7:
            return super.onTransact(r210, r211, r212, r213);
        L62:
            r212.writeString(DESCRIPTOR);
            return true;
        }
    }

    void clearOmniTasks(Map r100, IFlowNetworkResultCallbackIDL r101) throws RemoteException;

    void createConditionalTask(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107, String r108, String r110, String r111, String r112, String r113, String r114, Map r115, IFlowNetworkResultCallbackIDL r116) throws RemoteException;

    void deleteConditionalTask(String r100, Map r101, IFlowNetworkResultCallbackIDL r102) throws RemoteException;

    int getCurrentNetworkStatus() throws RemoteException;

    void notifyStopComplexTaskByHttp(long r100) throws RemoteException;

    void notifyStopComplexTaskByHttpWithScene(long r100, String r101) throws RemoteException;

    void notifyStopOmniTaskByHttp(String r100, Map r101, IFlowNetworkResultCallbackIDL r102) throws RemoteException;

    void notifyUserOperateQueue(String r100, IFlowNetworkResultCallbackIDL r101) throws RemoteException;

    void sendIntentResultForAsyncNotifyByHttp(List<OPushEvent> r100, boolean r101, IFlowNetworkResultCallbackIDL r102) throws RemoteException;

    void sendIntentResultForCompensationByHttp(List<OPushEvent> r100, boolean r101, IFlowNetworkResultCallbackIDL r102) throws RemoteException;

    void sendNormalRouterByHttp(String r100, String r101, IFlowNetworkResultCallbackIDL r102) throws RemoteException;

    void sendReplyAskUserByHttp(String r100, String r101, String r102, Map r103, IFlowNetworkResultCallbackIDL r104) throws RemoteException;

    void sweepConditionalTask(ObricConditionalTaskSweepRequest r100, IFlowNetworkResultCallbackIDL r101) throws RemoteException;

    void uploadOmniDataFeedbackByHttp(String r100, String r101, int r102, String r103, String r104, String r105, String r106, String r107, String r108, String r110, String r111, List<String> r112, String r113, String r114, IFlowNetworkResultCallbackIDL r115) throws RemoteException;

    void uploadOmniDataFeedbackByHttpV2(String r100, String r101, int r102, String r103, String r104, String r105, String r106, String r107, String r108, String r110, String r111, List<String> r112, String r113, String r114, boolean r115, IFlowNetworkResultCallbackIDL r116) throws RemoteException;

    void uploadOmniScreenshotByHttp(String r100, String r101, int r102, String r103, String r104, String r105, String r106, List<String> r107, String r108, String r110, IFlowNetworkResultCallbackIDL r111) throws RemoteException;

    void uploadOmniScreenshotByHttpV2(String r100, String r101, int r102, String r103, String r104, String r105, String r106, List<String> r107, String r108, String r110, boolean r111, IFlowNetworkResultCallbackIDL r112) throws RemoteException;

    void uploadUserTakeOverByHttp(String r100, String r101, String r102, long r103, Map r104, IFlowNetworkResultCallbackIDL r105) throws RemoteException;
}
