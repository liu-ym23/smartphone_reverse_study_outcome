package com.obric.aiagent.assistant.idl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aiagent.assistant.idl.bean.IMMessage;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import java.util.List;
import java.util.Map;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes4.dex */
public interface IFlowMessageIDL extends IInterface {
    public static final int MESSAGE_EVENT_ALL = 31;
    public static final int MESSAGE_EVENT_INSERT = 16;
    public static final int MESSAGE_EVENT_LEGACY_ALL = 15;
    public static final int MESSAGE_EVENT_RECEIVE = 2;
    public static final int MESSAGE_EVENT_REGEN = 8;
    public static final int MESSAGE_EVENT_SEND = 1;
    public static final int MESSAGE_EVENT_UPDATE = 4;

    /* JADX INFO: loaded from: classes32.dex */
    public static class Default implements IFlowMessageIDL {
        public Default() {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
        public void addMessage(IMMessage r100, String r101, String r102) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
        public void appendMessageExt(String r100, Map r101) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
        public void deleteMessage(String r100, IFlowDeleteMessageCallbackIDL r101) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
        public void deleteRemoteResource(List<String> r100) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
        public void fetchLatestMessages(int r100, IFlowFindMessagesCallbackIDL r101) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
        public void findAnswersbyQueryId(String r100, IFlowFindMessagesCallbackIDL r101) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
        public void findMessagebyId(String r100, IFlowFindMessageCallbackIDL r101) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
        public String generateLocalMessageId() throws RemoteException {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
        public void getMainTxtContentForMessage(String r100, IFlowMessageMainTextBlockCallbackIDL r101) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
        public String getMainTxtContentFromMessage(IMMessage r100) throws RemoteException {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
        public void imageXUpload(String r100, IImageXUploadCallbackIDL r101) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
        public boolean isConversationTtsEnabled(String r100) throws RemoteException {
            return false;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
        public void isMessageLocalInterrupted(String r100, IFlowIsMessageInterruptedCallbackIDL r101) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
        public void notifySemanticUserEditEvent(String r100, String r101, Map r102, IFlowSemanticEditCallbackIDL r103) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
        public void notifySemanticUserEditEventWithIdentifier(String r100, String r101, String r102, Map r103, IFlowSemanticEditCallbackIDL r104) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
        public void notifySemanticUserEditEventWithUri(String r100, String r101, String r102, Map r103, IFlowSemanticEditCallbackIDL r104) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
        public void refreshLatestMessages(String r100, int r101) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
        public void registerCallback(IFlowMessageCallbackIDL r100) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
        public void registerCallbackWithEvents(IFlowMessageCallbackIDL r100, int r101) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
        public void registerSendMessageExtCallback(IFlowSendMessageExtCallbackIDL r100) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
        public void registerStreamObserver(IFlowStreamObserverIDL r100) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
        public void retryFetchMessage(IMMessage r100) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
        public void sendMessage(String r100, String r101, String r102, String r103) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
        public void sendMessageWithExtra(String r100, String r101, String r102, String r103, Map r104) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
        public void unregisterCallback(IFlowMessageCallbackIDL r100) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
        public void unregisterSendMessageExtCallback(IFlowSendMessageExtCallbackIDL r100) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
        public void unregisterStreamObserver(IFlowStreamObserverIDL r100) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
        public void updateMessageExt(String r100, Map r101) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
        public void updateMutableMessageContent(String r100, String r101) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
        public void updateMutableWidgetRenderData(String r100, String r101, String r102) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
        public void uploadImage(String r100, String r101, IImageXUploadCallbackIDL r102) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IFlowMessageIDL {
        private static final String DESCRIPTOR = "com.obric.aiagent.assistant.idl.IFlowMessageIDL";
        static final int TRANSACTION_addMessage = 5;
        static final int TRANSACTION_appendMessageExt = 3;
        static final int TRANSACTION_deleteMessage = 6;
        static final int TRANSACTION_deleteRemoteResource = 16;
        static final int TRANSACTION_fetchLatestMessages = 25;
        static final int TRANSACTION_findAnswersbyQueryId = 28;
        static final int TRANSACTION_findMessagebyId = 7;
        static final int TRANSACTION_generateLocalMessageId = 4;
        static final int TRANSACTION_getMainTxtContentForMessage = 26;
        static final int TRANSACTION_getMainTxtContentFromMessage = 27;
        static final int TRANSACTION_imageXUpload = 10;
        static final int TRANSACTION_isConversationTtsEnabled = 20;
        static final int TRANSACTION_isMessageLocalInterrupted = 15;
        static final int TRANSACTION_notifySemanticUserEditEvent = 11;
        static final int TRANSACTION_notifySemanticUserEditEventWithIdentifier = 12;
        static final int TRANSACTION_notifySemanticUserEditEventWithUri = 13;
        static final int TRANSACTION_refreshLatestMessages = 24;
        static final int TRANSACTION_registerCallback = 1;
        static final int TRANSACTION_registerCallbackWithEvents = 30;
        static final int TRANSACTION_registerSendMessageExtCallback = 8;
        static final int TRANSACTION_registerStreamObserver = 18;
        static final int TRANSACTION_retryFetchMessage = 23;
        static final int TRANSACTION_sendMessage = 14;
        static final int TRANSACTION_sendMessageWithExtra = 21;
        static final int TRANSACTION_unregisterCallback = 2;
        static final int TRANSACTION_unregisterSendMessageExtCallback = 9;
        static final int TRANSACTION_unregisterStreamObserver = 19;
        static final int TRANSACTION_updateMessageExt = 22;
        static final int TRANSACTION_updateMutableMessageContent = 29;
        static final int TRANSACTION_updateMutableWidgetRenderData = 31;
        static final int TRANSACTION_uploadImage = 17;

        /* JADX INFO: loaded from: classes6.dex */
        public static class Proxy implements IFlowMessageIDL {
            public static IFlowMessageIDL sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
            public String generateLocalMessageId() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowMessageIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L13
                String r102 = r101.readString();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r102;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                String r103 = Stub.getDefaultImpl().generateLocalMessageId();     // Catch: Throwable -> L13
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

            @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
            public void deleteRemoteResource(List<String> r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r101.writeStringList(r100);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowMessageIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 16, r101, null, 1) == false) goto L6;
            L10:
                r101.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().deleteRemoteResource(r100);     // Catch: Throwable -> L12
                r101.recycle();
                return;
            L12:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
            public String getMainTxtContentFromMessage(IMMessage r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r100 == null) goto L6;
                r101.writeInt(1);     // Catch: Throwable -> L17
                r100.writeToParcel(r101, 0);     // Catch: Throwable -> L17
            L8:
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowMessageIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 27, r101, r102, 0) == false) goto L10;
            L14:
                r102.readException();     // Catch: Throwable -> L17
                String r103 = r102.readString();     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return r103;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                String r104 = Stub.getDefaultImpl().getMainTxtContentFromMessage(r100);     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return r104;
            L6:
                r101.writeInt(0);     // Catch: Throwable -> L17
            L17:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
            public boolean isConversationTtsEnabled(String r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                r101.writeString(r100);     // Catch: Throwable -> L15
                boolean r103 = false;
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowMessageIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 20, r101, r102, 0) == false) goto L6;
            L10:
                r102.readException();     // Catch: Throwable -> L15
                if (r102.readInt() == 0) goto L13;
                r103 = true;
            L13:
                r102.recycle();
                r101.recycle();
                return r103;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                boolean r104 = Stub.getDefaultImpl().isConversationTtsEnabled(r100);     // Catch: Throwable -> L15
                r102.recycle();
                r101.recycle();
                return r104;
            L15:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
            public void registerCallback(IFlowMessageCallbackIDL r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r100 == null) goto L6;
                IBinder r102 = r100.asBinder();     // Catch: Throwable -> L16
            L7:
                r101.writeStrongBinder(r102);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowMessageIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r101, null, 1) == false) goto L10;
            L14:
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().registerCallback(r100);     // Catch: Throwable -> L16
                r101.recycle();
                return;
            L6:
                r102 = null;
            L16:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
            public void registerSendMessageExtCallback(IFlowSendMessageExtCallbackIDL r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r100 == null) goto L6;
                IBinder r102 = r100.asBinder();     // Catch: Throwable -> L16
            L7:
                r101.writeStrongBinder(r102);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowMessageIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 8, r101, null, 1) == false) goto L10;
            L14:
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().registerSendMessageExtCallback(r100);     // Catch: Throwable -> L16
                r101.recycle();
                return;
            L6:
                r102 = null;
            L16:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
            public void registerStreamObserver(IFlowStreamObserverIDL r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r100 == null) goto L6;
                IBinder r102 = r100.asBinder();     // Catch: Throwable -> L16
            L7:
                r101.writeStrongBinder(r102);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowMessageIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 18, r101, null, 1) == false) goto L10;
            L14:
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().registerStreamObserver(r100);     // Catch: Throwable -> L16
                r101.recycle();
                return;
            L6:
                r102 = null;
            L16:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
            public void retryFetchMessage(IMMessage r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r100 == null) goto L6;
                r101.writeInt(1);     // Catch: Throwable -> L16
                r100.writeToParcel(r101, 0);     // Catch: Throwable -> L16
            L8:
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowMessageIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 23, r101, null, 1) == false) goto L10;
            L14:
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().retryFetchMessage(r100);     // Catch: Throwable -> L16
                r101.recycle();
                return;
            L6:
                r101.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
            public void unregisterCallback(IFlowMessageCallbackIDL r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r100 == null) goto L6;
                IBinder r102 = r100.asBinder();     // Catch: Throwable -> L16
            L7:
                r101.writeStrongBinder(r102);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowMessageIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r101, null, 1) == false) goto L10;
            L14:
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().unregisterCallback(r100);     // Catch: Throwable -> L16
                r101.recycle();
                return;
            L6:
                r102 = null;
            L16:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
            public void unregisterSendMessageExtCallback(IFlowSendMessageExtCallbackIDL r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r100 == null) goto L6;
                IBinder r102 = r100.asBinder();     // Catch: Throwable -> L16
            L7:
                r101.writeStrongBinder(r102);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowMessageIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 9, r101, null, 1) == false) goto L10;
            L14:
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().unregisterSendMessageExtCallback(r100);     // Catch: Throwable -> L16
                r101.recycle();
                return;
            L6:
                r102 = null;
            L16:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
            public void unregisterStreamObserver(IFlowStreamObserverIDL r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r100 == null) goto L6;
                IBinder r102 = r100.asBinder();     // Catch: Throwable -> L16
            L7:
                r101.writeStrongBinder(r102);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowMessageIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 19, r101, null, 1) == false) goto L10;
            L14:
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().unregisterStreamObserver(r100);     // Catch: Throwable -> L16
                r101.recycle();
                return;
            L6:
                r102 = null;
            L16:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
            public void appendMessageExt(String r100, Map r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r102.writeString(r100);     // Catch: Throwable -> L12
                r102.writeMap(r101);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowMessageIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r102, null, 1) == false) goto L6;
            L10:
                r102.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().appendMessageExt(r100, r101);     // Catch: Throwable -> L12
                r102.recycle();
                return;
            L12:
                th = move-exception;
                r102.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
            public void deleteMessage(String r100, IFlowDeleteMessageCallbackIDL r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r102.writeString(r100);     // Catch: Throwable -> L16
                if (r101 == null) goto L6;
                IBinder r103 = r101.asBinder();     // Catch: Throwable -> L16
            L7:
                r102.writeStrongBinder(r103);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowMessageIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 6, r102, null, 1) == false) goto L10;
            L14:
                r102.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().deleteMessage(r100, r101);     // Catch: Throwable -> L16
                r102.recycle();
                return;
            L6:
                r103 = null;
            L16:
                th = move-exception;
                r102.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
            public void fetchLatestMessages(int r100, IFlowFindMessagesCallbackIDL r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r102.writeInt(r100);     // Catch: Throwable -> L16
                if (r101 == null) goto L6;
                IBinder r103 = r101.asBinder();     // Catch: Throwable -> L16
            L7:
                r102.writeStrongBinder(r103);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowMessageIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 25, r102, null, 1) == false) goto L10;
            L14:
                r102.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().fetchLatestMessages(r100, r101);     // Catch: Throwable -> L16
                r102.recycle();
                return;
            L6:
                r103 = null;
            L16:
                th = move-exception;
                r102.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
            public void findAnswersbyQueryId(String r100, IFlowFindMessagesCallbackIDL r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r102.writeString(r100);     // Catch: Throwable -> L16
                if (r101 == null) goto L6;
                IBinder r103 = r101.asBinder();     // Catch: Throwable -> L16
            L7:
                r102.writeStrongBinder(r103);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowMessageIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 28, r102, null, 1) == false) goto L10;
            L14:
                r102.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().findAnswersbyQueryId(r100, r101);     // Catch: Throwable -> L16
                r102.recycle();
                return;
            L6:
                r103 = null;
            L16:
                th = move-exception;
                r102.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
            public void findMessagebyId(String r100, IFlowFindMessageCallbackIDL r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r102.writeString(r100);     // Catch: Throwable -> L16
                if (r101 == null) goto L6;
                IBinder r103 = r101.asBinder();     // Catch: Throwable -> L16
            L7:
                r102.writeStrongBinder(r103);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowMessageIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 7, r102, null, 1) == false) goto L10;
            L14:
                r102.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().findMessagebyId(r100, r101);     // Catch: Throwable -> L16
                r102.recycle();
                return;
            L6:
                r103 = null;
            L16:
                th = move-exception;
                r102.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
            public void getMainTxtContentForMessage(String r100, IFlowMessageMainTextBlockCallbackIDL r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r102.writeString(r100);     // Catch: Throwable -> L16
                if (r101 == null) goto L6;
                IBinder r103 = r101.asBinder();     // Catch: Throwable -> L16
            L7:
                r102.writeStrongBinder(r103);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowMessageIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 26, r102, null, 1) == false) goto L10;
            L14:
                r102.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().getMainTxtContentForMessage(r100, r101);     // Catch: Throwable -> L16
                r102.recycle();
                return;
            L6:
                r103 = null;
            L16:
                th = move-exception;
                r102.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
            public void imageXUpload(String r100, IImageXUploadCallbackIDL r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r102.writeString(r100);     // Catch: Throwable -> L16
                if (r101 == null) goto L6;
                IBinder r103 = r101.asBinder();     // Catch: Throwable -> L16
            L7:
                r102.writeStrongBinder(r103);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowMessageIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 10, r102, null, 1) == false) goto L10;
            L14:
                r102.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().imageXUpload(r100, r101);     // Catch: Throwable -> L16
                r102.recycle();
                return;
            L6:
                r103 = null;
            L16:
                th = move-exception;
                r102.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
            public void isMessageLocalInterrupted(String r100, IFlowIsMessageInterruptedCallbackIDL r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r102.writeString(r100);     // Catch: Throwable -> L16
                if (r101 == null) goto L6;
                IBinder r103 = r101.asBinder();     // Catch: Throwable -> L16
            L7:
                r102.writeStrongBinder(r103);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowMessageIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 15, r102, null, 1) == false) goto L10;
            L14:
                r102.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().isMessageLocalInterrupted(r100, r101);     // Catch: Throwable -> L16
                r102.recycle();
                return;
            L6:
                r103 = null;
            L16:
                th = move-exception;
                r102.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
            public void refreshLatestMessages(String r100, int r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r102.writeString(r100);     // Catch: Throwable -> L12
                r102.writeInt(r101);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowMessageIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 24, r102, null, 1) == false) goto L6;
            L10:
                r102.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().refreshLatestMessages(r100, r101);     // Catch: Throwable -> L12
                r102.recycle();
                return;
            L12:
                th = move-exception;
                r102.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
            public void registerCallbackWithEvents(IFlowMessageCallbackIDL r100, int r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r100 == null) goto L6;
                IBinder r103 = r100.asBinder();     // Catch: Throwable -> L16
            L7:
                r102.writeStrongBinder(r103);     // Catch: Throwable -> L16
                r102.writeInt(r101);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowMessageIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 30, r102, null, 1) == false) goto L10;
            L14:
                r102.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().registerCallbackWithEvents(r100, r101);     // Catch: Throwable -> L16
                r102.recycle();
                return;
            L6:
                r103 = null;
            L16:
                th = move-exception;
                r102.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
            public void updateMessageExt(String r100, Map r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r102.writeString(r100);     // Catch: Throwable -> L12
                r102.writeMap(r101);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowMessageIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 22, r102, null, 1) == false) goto L6;
            L10:
                r102.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().updateMessageExt(r100, r101);     // Catch: Throwable -> L12
                r102.recycle();
                return;
            L12:
                th = move-exception;
                r102.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
            public void updateMutableMessageContent(String r100, String r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r102.writeString(r100);     // Catch: Throwable -> L12
                r102.writeString(r101);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowMessageIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 29, r102, null, 1) == false) goto L6;
            L10:
                r102.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().updateMutableMessageContent(r100, r101);     // Catch: Throwable -> L12
                r102.recycle();
                return;
            L12:
                th = move-exception;
                r102.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
            public void addMessage(IMMessage r100, String r101, String r102) throws RemoteException {
                Parcel r103 = Parcel.obtain();
                r103.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r100 == null) goto L6;
                r103.writeInt(1);     // Catch: Throwable -> L16
                r100.writeToParcel(r103, 0);     // Catch: Throwable -> L16
            L7:
                r103.writeString(r101);     // Catch: Throwable -> L16
                r103.writeString(r102);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowMessageIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 5, r103, null, 1) == false) goto L10;
            L14:
                r103.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().addMessage(r100, r101, r102);     // Catch: Throwable -> L16
                r103.recycle();
                return;
            L6:
                r103.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r103.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
            public void updateMutableWidgetRenderData(String r100, String r101, String r102) throws RemoteException {
                Parcel r103 = Parcel.obtain();
                r103.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r103.writeString(r100);     // Catch: Throwable -> L12
                r103.writeString(r101);     // Catch: Throwable -> L12
                r103.writeString(r102);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowMessageIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 31, r103, null, 1) == false) goto L6;
            L10:
                r103.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().updateMutableWidgetRenderData(r100, r101, r102);     // Catch: Throwable -> L12
                r103.recycle();
                return;
            L12:
                th = move-exception;
                r103.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
            public void uploadImage(String r100, String r101, IImageXUploadCallbackIDL r102) throws RemoteException {
                Parcel r103 = Parcel.obtain();
                r103.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r103.writeString(r100);     // Catch: Throwable -> L16
                r103.writeString(r101);     // Catch: Throwable -> L16
                if (r102 == null) goto L6;
                IBinder r104 = r102.asBinder();     // Catch: Throwable -> L16
            L7:
                r103.writeStrongBinder(r104);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowMessageIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 17, r103, null, 1) == false) goto L10;
            L14:
                r103.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().uploadImage(r100, r101, r102);     // Catch: Throwable -> L16
                r103.recycle();
                return;
            L6:
                r104 = null;
            L16:
                th = move-exception;
                r103.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
            public void notifySemanticUserEditEvent(String r100, String r101, Map r102, IFlowSemanticEditCallbackIDL r103) throws RemoteException {
                Parcel r104 = Parcel.obtain();
                r104.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r104.writeString(r100);     // Catch: Throwable -> L16
                r104.writeString(r101);     // Catch: Throwable -> L16
                r104.writeMap(r102);     // Catch: Throwable -> L16
                if (r103 == null) goto L6;
                IBinder r105 = r103.asBinder();     // Catch: Throwable -> L16
            L7:
                r104.writeStrongBinder(r105);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowMessageIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 11, r104, null, 1) == false) goto L10;
            L14:
                r104.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().notifySemanticUserEditEvent(r100, r101, r102, r103);     // Catch: Throwable -> L16
                r104.recycle();
                return;
            L6:
                r105 = null;
            L16:
                th = move-exception;
                r104.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
            public void sendMessage(String r100, String r101, String r102, String r103) throws RemoteException {
                Parcel r104 = Parcel.obtain();
                r104.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r104.writeString(r100);     // Catch: Throwable -> L12
                r104.writeString(r101);     // Catch: Throwable -> L12
                r104.writeString(r102);     // Catch: Throwable -> L12
                r104.writeString(r103);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowMessageIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 14, r104, null, 1) == false) goto L6;
            L10:
                r104.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().sendMessage(r100, r101, r102, r103);     // Catch: Throwable -> L12
                r104.recycle();
                return;
            L12:
                th = move-exception;
                r104.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowMessageIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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

            @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
            public void notifySemanticUserEditEventWithIdentifier(String r100, String r110, String r111, Map r112, IFlowSemanticEditCallbackIDL r113) throws RemoteException {
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
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowMessageIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 12, r101, null, 1) == false) goto L10;
            L14:
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().notifySemanticUserEditEventWithIdentifier(r100, r110, r111, r112, r113);     // Catch: Throwable -> L16
                r101.recycle();
                return;
            L6:
                r102 = null;
            L16:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
            public void notifySemanticUserEditEventWithUri(String r100, String r110, String r111, Map r112, IFlowSemanticEditCallbackIDL r113) throws RemoteException {
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
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowMessageIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 13, r101, null, 1) == false) goto L10;
            L14:
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().notifySemanticUserEditEventWithUri(r100, r110, r111, r112, r113);     // Catch: Throwable -> L16
                r101.recycle();
                return;
            L6:
                r102 = null;
            L16:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowMessageIDL
            public void sendMessageWithExtra(String r100, String r110, String r111, String r112, Map r113) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r101.writeString(r100);     // Catch: Throwable -> L12
                r101.writeString(r110);     // Catch: Throwable -> L12
                r101.writeString(r111);     // Catch: Throwable -> L12
                r101.writeString(r112);     // Catch: Throwable -> L12
                r101.writeMap(r113);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowMessageIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 21, r101, null, 1) == false) goto L6;
            L10:
                r101.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().sendMessageWithExtra(r100, r110, r111, r112, r113);     // Catch: Throwable -> L12
                r101.recycle();
                return;
            L12:
                th = move-exception;
                r101.recycle();
                throw th;
            }
        }

        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IFlowMessageIDL getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static IFlowMessageIDL asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof IFlowMessageIDL) == false) goto L12;
            return (IFlowMessageIDL) r101;
        L12:
            return new Proxy(r100);
        }

        public static boolean setDefaultImpl(IFlowMessageIDL r100) {
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
        public boolean onTransact(int r100, Parcel r110, Parcel r111, int r112) throws RemoteException {
            if (r100 == 1598968902) goto L79;
            IMMessage r101 = null;
            switch(r100) {
                case 1: goto L77;
                case 2: goto L75;
                case 3: goto L73;
                case 4: goto L71;
                case 5: goto L66;
                case 6: goto L64;
                case 7: goto L62;
                case 8: goto L60;
                case 9: goto L58;
                case 10: goto L56;
                case 11: goto L54;
                case 12: goto L52;
                case 13: goto L50;
                case 14: goto L48;
                case 15: goto L46;
                case 16: goto L44;
                case 17: goto L42;
                case 18: goto L40;
                case 19: goto L38;
                case 20: goto L36;
                case 21: goto L34;
                case 22: goto L32;
                case 23: goto L27;
                case 24: goto L25;
                case 25: goto L23;
                case 26: goto L21;
                case 27: goto L16;
                case 28: goto L14;
                case 29: goto L12;
                case 30: goto L10;
                case 31: goto L8;
                default: goto L7;
            };
        L8:
            r110.enforceInterface(DESCRIPTOR);
            updateMutableWidgetRenderData(r110.readString(), r110.readString(), r110.readString());
            return true;
        L10:
            r110.enforceInterface(DESCRIPTOR);
            registerCallbackWithEvents(IFlowMessageCallbackIDL.Stub.asInterface(r110.readStrongBinder()), r110.readInt());
            return true;
        L12:
            r110.enforceInterface(DESCRIPTOR);
            updateMutableMessageContent(r110.readString(), r110.readString());
            return true;
        L14:
            r110.enforceInterface(DESCRIPTOR);
            findAnswersbyQueryId(r110.readString(), IFlowFindMessagesCallbackIDL.Stub.asInterface(r110.readStrongBinder()));
            return true;
        L16:
            r110.enforceInterface(DESCRIPTOR);
            if (r110.readInt() == 0) goto L19;
            r101 = IMMessage.CREATOR.createFromParcel(r110);
        L19:
            String r102 = getMainTxtContentFromMessage(r101);
            r111.writeNoException();
            r111.writeString(r102);
            return true;
        L21:
            r110.enforceInterface(DESCRIPTOR);
            getMainTxtContentForMessage(r110.readString(), IFlowMessageMainTextBlockCallbackIDL.Stub.asInterface(r110.readStrongBinder()));
            return true;
        L23:
            r110.enforceInterface(DESCRIPTOR);
            fetchLatestMessages(r110.readInt(), IFlowFindMessagesCallbackIDL.Stub.asInterface(r110.readStrongBinder()));
            return true;
        L25:
            r110.enforceInterface(DESCRIPTOR);
            refreshLatestMessages(r110.readString(), r110.readInt());
            return true;
        L27:
            r110.enforceInterface(DESCRIPTOR);
            if (r110.readInt() == 0) goto L30;
            r101 = IMMessage.CREATOR.createFromParcel(r110);
        L30:
            retryFetchMessage(r101);
            return true;
        L32:
            r110.enforceInterface(DESCRIPTOR);
            updateMessageExt(r110.readString(), r110.readHashMap(getClass().getClassLoader()));
            return true;
        L34:
            r110.enforceInterface(DESCRIPTOR);
            sendMessageWithExtra(r110.readString(), r110.readString(), r110.readString(), r110.readString(), r110.readHashMap(getClass().getClassLoader()));
            return true;
        L36:
            r110.enforceInterface(DESCRIPTOR);
            boolean r103 = isConversationTtsEnabled(r110.readString());
            r111.writeNoException();
            r111.writeInt(r103 ? 1 : 0);
            return true;
        L38:
            r110.enforceInterface(DESCRIPTOR);
            unregisterStreamObserver(IFlowStreamObserverIDL.Stub.asInterface(r110.readStrongBinder()));
            return true;
        L40:
            r110.enforceInterface(DESCRIPTOR);
            registerStreamObserver(IFlowStreamObserverIDL.Stub.asInterface(r110.readStrongBinder()));
            return true;
        L42:
            r110.enforceInterface(DESCRIPTOR);
            uploadImage(r110.readString(), r110.readString(), IImageXUploadCallbackIDL.Stub.asInterface(r110.readStrongBinder()));
            return true;
        L44:
            r110.enforceInterface(DESCRIPTOR);
            deleteRemoteResource(r110.createStringArrayList());
            return true;
        L46:
            r110.enforceInterface(DESCRIPTOR);
            isMessageLocalInterrupted(r110.readString(), IFlowIsMessageInterruptedCallbackIDL.Stub.asInterface(r110.readStrongBinder()));
            return true;
        L48:
            r110.enforceInterface(DESCRIPTOR);
            sendMessage(r110.readString(), r110.readString(), r110.readString(), r110.readString());
            return true;
        L50:
            r110.enforceInterface(DESCRIPTOR);
            notifySemanticUserEditEventWithUri(r110.readString(), r110.readString(), r110.readString(), r110.readHashMap(getClass().getClassLoader()), IFlowSemanticEditCallbackIDL.Stub.asInterface(r110.readStrongBinder()));
            return true;
        L52:
            r110.enforceInterface(DESCRIPTOR);
            notifySemanticUserEditEventWithIdentifier(r110.readString(), r110.readString(), r110.readString(), r110.readHashMap(getClass().getClassLoader()), IFlowSemanticEditCallbackIDL.Stub.asInterface(r110.readStrongBinder()));
            return true;
        L54:
            r110.enforceInterface(DESCRIPTOR);
            notifySemanticUserEditEvent(r110.readString(), r110.readString(), r110.readHashMap(getClass().getClassLoader()), IFlowSemanticEditCallbackIDL.Stub.asInterface(r110.readStrongBinder()));
            return true;
        L56:
            r110.enforceInterface(DESCRIPTOR);
            imageXUpload(r110.readString(), IImageXUploadCallbackIDL.Stub.asInterface(r110.readStrongBinder()));
            return true;
        L58:
            r110.enforceInterface(DESCRIPTOR);
            unregisterSendMessageExtCallback(IFlowSendMessageExtCallbackIDL.Stub.asInterface(r110.readStrongBinder()));
            return true;
        L60:
            r110.enforceInterface(DESCRIPTOR);
            registerSendMessageExtCallback(IFlowSendMessageExtCallbackIDL.Stub.asInterface(r110.readStrongBinder()));
            return true;
        L62:
            r110.enforceInterface(DESCRIPTOR);
            findMessagebyId(r110.readString(), IFlowFindMessageCallbackIDL.Stub.asInterface(r110.readStrongBinder()));
            return true;
        L64:
            r110.enforceInterface(DESCRIPTOR);
            deleteMessage(r110.readString(), IFlowDeleteMessageCallbackIDL.Stub.asInterface(r110.readStrongBinder()));
            return true;
        L66:
            r110.enforceInterface(DESCRIPTOR);
            if (r110.readInt() == 0) goto L69;
            r101 = IMMessage.CREATOR.createFromParcel(r110);
        L69:
            addMessage(r101, r110.readString(), r110.readString());
            return true;
        L71:
            r110.enforceInterface(DESCRIPTOR);
            String r104 = generateLocalMessageId();
            r111.writeNoException();
            r111.writeString(r104);
            return true;
        L73:
            r110.enforceInterface(DESCRIPTOR);
            appendMessageExt(r110.readString(), r110.readHashMap(getClass().getClassLoader()));
            return true;
        L75:
            r110.enforceInterface(DESCRIPTOR);
            unregisterCallback(IFlowMessageCallbackIDL.Stub.asInterface(r110.readStrongBinder()));
            return true;
        L77:
            r110.enforceInterface(DESCRIPTOR);
            registerCallback(IFlowMessageCallbackIDL.Stub.asInterface(r110.readStrongBinder()));
            return true;
        L7:
            return super.onTransact(r100, r110, r111, r112);
        L79:
            r111.writeString(DESCRIPTOR);
            return true;
        }
    }

    void addMessage(IMMessage r100, String r101, String r102) throws RemoteException;

    void appendMessageExt(String r100, Map r101) throws RemoteException;

    void deleteMessage(String r100, IFlowDeleteMessageCallbackIDL r101) throws RemoteException;

    void deleteRemoteResource(List<String> r100) throws RemoteException;

    void fetchLatestMessages(int r100, IFlowFindMessagesCallbackIDL r101) throws RemoteException;

    void findAnswersbyQueryId(String r100, IFlowFindMessagesCallbackIDL r101) throws RemoteException;

    void findMessagebyId(String r100, IFlowFindMessageCallbackIDL r101) throws RemoteException;

    String generateLocalMessageId() throws RemoteException;

    void getMainTxtContentForMessage(String r100, IFlowMessageMainTextBlockCallbackIDL r101) throws RemoteException;

    String getMainTxtContentFromMessage(IMMessage r100) throws RemoteException;

    void imageXUpload(String r100, IImageXUploadCallbackIDL r101) throws RemoteException;

    boolean isConversationTtsEnabled(String r100) throws RemoteException;

    void isMessageLocalInterrupted(String r100, IFlowIsMessageInterruptedCallbackIDL r101) throws RemoteException;

    void notifySemanticUserEditEvent(String r100, String r101, Map r102, IFlowSemanticEditCallbackIDL r103) throws RemoteException;

    void notifySemanticUserEditEventWithIdentifier(String r100, String r101, String r102, Map r103, IFlowSemanticEditCallbackIDL r104) throws RemoteException;

    void notifySemanticUserEditEventWithUri(String r100, String r101, String r102, Map r103, IFlowSemanticEditCallbackIDL r104) throws RemoteException;

    void refreshLatestMessages(String r100, int r101) throws RemoteException;

    void registerCallback(IFlowMessageCallbackIDL r100) throws RemoteException;

    void registerCallbackWithEvents(IFlowMessageCallbackIDL r100, int r101) throws RemoteException;

    void registerSendMessageExtCallback(IFlowSendMessageExtCallbackIDL r100) throws RemoteException;

    void registerStreamObserver(IFlowStreamObserverIDL r100) throws RemoteException;

    void retryFetchMessage(IMMessage r100) throws RemoteException;

    void sendMessage(String r100, String r101, String r102, String r103) throws RemoteException;

    void sendMessageWithExtra(String r100, String r101, String r102, String r103, Map r104) throws RemoteException;

    void unregisterCallback(IFlowMessageCallbackIDL r100) throws RemoteException;

    void unregisterSendMessageExtCallback(IFlowSendMessageExtCallbackIDL r100) throws RemoteException;

    void unregisterStreamObserver(IFlowStreamObserverIDL r100) throws RemoteException;

    void updateMessageExt(String r100, Map r101) throws RemoteException;

    void updateMutableMessageContent(String r100, String r101) throws RemoteException;

    void updateMutableWidgetRenderData(String r100, String r101, String r102) throws RemoteException;

    void uploadImage(String r100, String r101, IImageXUploadCallbackIDL r102) throws RemoteException;
}
