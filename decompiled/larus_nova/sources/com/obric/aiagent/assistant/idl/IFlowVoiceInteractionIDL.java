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
import com.obric.eventkit.eventstaskmanager.AppEvent;
import java.util.Map;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes4.dex */
public interface IFlowVoiceInteractionIDL extends IInterface {

    /* JADX INFO: loaded from: classes32.dex */
    public static class Default implements IFlowVoiceInteractionIDL {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowVoiceInteractionIDL
        public boolean closeContinuousTalk() throws RemoteException {
            return false;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowVoiceInteractionIDL
        public boolean isInRealtimeCalling() throws RemoteException {
            return false;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowVoiceInteractionIDL
        public boolean isInteractionSessionStateListening() throws RemoteException {
            return false;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowVoiceInteractionIDL
        public void readContent(String r100) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowVoiceInteractionIDL
        public void readContentByMessage(IMMessage r100) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowVoiceInteractionIDL
        public void replayMessageTts(String r100) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowVoiceInteractionIDL
        public void requireSyncData(IFlowSyncDataResultIDL r100) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowVoiceInteractionIDL
        public boolean tryInterruptAssistant(AppEvent r100) throws RemoteException {
            return false;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowVoiceInteractionIDL
        public void tryOpenClickTalk(int r100) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowVoiceInteractionIDL
        public boolean tryOpenMicToRecording(AppEvent r100) throws RemoteException {
            return false;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowVoiceInteractionIDL
        public void updateIntentExt(Map r100) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowVoiceInteractionIDL
        public void updateScreenshotForAsr(String r100) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowVoiceInteractionIDL
        public void wakeupAssistant(String r100) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IFlowVoiceInteractionIDL {
        private static final String DESCRIPTOR = "com.obric.aiagent.assistant.idl.IFlowVoiceInteractionIDL";
        static final int TRANSACTION_closeContinuousTalk = 13;
        static final int TRANSACTION_isInRealtimeCalling = 5;
        static final int TRANSACTION_isInteractionSessionStateListening = 12;
        static final int TRANSACTION_readContent = 4;
        static final int TRANSACTION_readContentByMessage = 6;
        static final int TRANSACTION_replayMessageTts = 3;
        static final int TRANSACTION_requireSyncData = 2;
        static final int TRANSACTION_tryInterruptAssistant = 8;
        static final int TRANSACTION_tryOpenClickTalk = 7;
        static final int TRANSACTION_tryOpenMicToRecording = 9;
        static final int TRANSACTION_updateIntentExt = 11;
        static final int TRANSACTION_updateScreenshotForAsr = 10;
        static final int TRANSACTION_wakeupAssistant = 1;

        /* JADX INFO: loaded from: classes6.dex */
        public static class Proxy implements IFlowVoiceInteractionIDL {
            public static IFlowVoiceInteractionIDL sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowVoiceInteractionIDL
            public boolean closeContinuousTalk() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                boolean r102 = false;
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowVoiceInteractionIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 13, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L15
                if (r101.readInt() == 0) goto L13;
                r102 = true;
            L13:
                r101.recycle();
                r100.recycle();
                return r102;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                boolean r103 = Stub.getDefaultImpl().closeContinuousTalk();     // Catch: Throwable -> L15
                r101.recycle();
                r100.recycle();
                return r103;
            L15:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowVoiceInteractionIDL
            public boolean isInRealtimeCalling() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                boolean r102 = false;
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowVoiceInteractionIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 5, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L15
                if (r101.readInt() == 0) goto L13;
                r102 = true;
            L13:
                r101.recycle();
                r100.recycle();
                return r102;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                boolean r103 = Stub.getDefaultImpl().isInRealtimeCalling();     // Catch: Throwable -> L15
                r101.recycle();
                r100.recycle();
                return r103;
            L15:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowVoiceInteractionIDL
            public boolean isInteractionSessionStateListening() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                boolean r102 = false;
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowVoiceInteractionIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 12, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L15
                if (r101.readInt() == 0) goto L13;
                r102 = true;
            L13:
                r101.recycle();
                r100.recycle();
                return r102;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                boolean r103 = Stub.getDefaultImpl().isInteractionSessionStateListening();     // Catch: Throwable -> L15
                r101.recycle();
                r100.recycle();
                return r103;
            L15:
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

            @Override // com.obric.aiagent.assistant.idl.IFlowVoiceInteractionIDL
            public void readContent(String r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r101.writeString(r100);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowVoiceInteractionIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r101, null, 1) == false) goto L6;
            L10:
                r101.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().readContent(r100);     // Catch: Throwable -> L12
                r101.recycle();
                return;
            L12:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowVoiceInteractionIDL
            public void readContentByMessage(IMMessage r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r100 == null) goto L6;
                r101.writeInt(1);     // Catch: Throwable -> L16
                r100.writeToParcel(r101, 0);     // Catch: Throwable -> L16
            L8:
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowVoiceInteractionIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 6, r101, null, 1) == false) goto L10;
            L14:
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().readContentByMessage(r100);     // Catch: Throwable -> L16
                r101.recycle();
                return;
            L6:
                r101.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowVoiceInteractionIDL
            public void replayMessageTts(String r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r101.writeString(r100);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowVoiceInteractionIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r101, null, 1) == false) goto L6;
            L10:
                r101.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().replayMessageTts(r100);     // Catch: Throwable -> L12
                r101.recycle();
                return;
            L12:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowVoiceInteractionIDL
            public void requireSyncData(IFlowSyncDataResultIDL r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r100 == null) goto L6;
                IBinder r102 = r100.asBinder();     // Catch: Throwable -> L16
            L7:
                r101.writeStrongBinder(r102);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowVoiceInteractionIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r101, null, 1) == false) goto L10;
            L14:
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().requireSyncData(r100);     // Catch: Throwable -> L16
                r101.recycle();
                return;
            L6:
                r102 = null;
            L16:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowVoiceInteractionIDL
            public boolean tryInterruptAssistant(AppEvent r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L20
                boolean r103 = true;
                if (r100 == null) goto L6;
                r101.writeInt(1);     // Catch: Throwable -> L20
                r100.writeToParcel(r101, 0);     // Catch: Throwable -> L20
            L8:
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowVoiceInteractionIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 8, r101, r102, 0) == false) goto L10;
            L14:
                r102.readException();     // Catch: Throwable -> L20
                if (r102.readInt() != 0) goto L18;
                r103 = false;
            L18:
                r102.recycle();
                r101.recycle();
                return r103;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                boolean r104 = Stub.getDefaultImpl().tryInterruptAssistant(r100);     // Catch: Throwable -> L20
                r102.recycle();
                r101.recycle();
                return r104;
            L6:
                r101.writeInt(0);     // Catch: Throwable -> L20
            L20:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowVoiceInteractionIDL
            public void tryOpenClickTalk(int r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r101.writeInt(r100);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowVoiceInteractionIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 7, r101, null, 1) == false) goto L6;
            L10:
                r101.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().tryOpenClickTalk(r100);     // Catch: Throwable -> L12
                r101.recycle();
                return;
            L12:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowVoiceInteractionIDL
            public boolean tryOpenMicToRecording(AppEvent r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L20
                boolean r103 = true;
                if (r100 == null) goto L6;
                r101.writeInt(1);     // Catch: Throwable -> L20
                r100.writeToParcel(r101, 0);     // Catch: Throwable -> L20
            L8:
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowVoiceInteractionIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 9, r101, r102, 0) == false) goto L10;
            L14:
                r102.readException();     // Catch: Throwable -> L20
                if (r102.readInt() != 0) goto L18;
                r103 = false;
            L18:
                r102.recycle();
                r101.recycle();
                return r103;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                boolean r104 = Stub.getDefaultImpl().tryOpenMicToRecording(r100);     // Catch: Throwable -> L20
                r102.recycle();
                r101.recycle();
                return r104;
            L6:
                r101.writeInt(0);     // Catch: Throwable -> L20
            L20:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowVoiceInteractionIDL
            public void updateIntentExt(Map r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r101.writeMap(r100);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowVoiceInteractionIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 11, r101, null, 1) == false) goto L6;
            L10:
                r101.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().updateIntentExt(r100);     // Catch: Throwable -> L12
                r101.recycle();
                return;
            L12:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowVoiceInteractionIDL
            public void updateScreenshotForAsr(String r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r101.writeString(r100);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowVoiceInteractionIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 10, r101, null, 1) == false) goto L6;
            L10:
                r101.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().updateScreenshotForAsr(r100);     // Catch: Throwable -> L12
                r101.recycle();
                return;
            L12:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowVoiceInteractionIDL
            public void wakeupAssistant(String r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r101.writeString(r100);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowVoiceInteractionIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r101, null, 1) == false) goto L6;
            L10:
                r101.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().wakeupAssistant(r100);     // Catch: Throwable -> L12
                r101.recycle();
                return;
            L12:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowVoiceInteractionIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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

        public static IFlowVoiceInteractionIDL getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static IFlowVoiceInteractionIDL asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof IFlowVoiceInteractionIDL) == false) goto L12;
            return (IFlowVoiceInteractionIDL) r101;
        L12:
            return new Proxy(r100);
        }

        public static boolean setDefaultImpl(IFlowVoiceInteractionIDL r100) {
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
            if (r100 == 1598968902) goto L43;
            IMMessage r104 = null;
            AppEvent r105 = null;
            AppEvent r106 = null;
            switch(r100) {
                case 1: goto L41;
                case 2: goto L39;
                case 3: goto L37;
                case 4: goto L35;
                case 5: goto L33;
                case 6: goto L28;
                case 7: goto L26;
                case 8: goto L21;
                case 9: goto L16;
                case 10: goto L14;
                case 11: goto L12;
                case 12: goto L10;
                case 13: goto L8;
                default: goto L7;
            };
        L8:
            r101.enforceInterface(DESCRIPTOR);
            boolean r107 = closeContinuousTalk();
            r102.writeNoException();
            r102.writeInt(r107 ? 1 : 0);
            return true;
        L10:
            r101.enforceInterface(DESCRIPTOR);
            boolean r108 = isInteractionSessionStateListening();
            r102.writeNoException();
            r102.writeInt(r108 ? 1 : 0);
            return true;
        L12:
            r101.enforceInterface(DESCRIPTOR);
            updateIntentExt(r101.readHashMap(getClass().getClassLoader()));
            return true;
        L14:
            r101.enforceInterface(DESCRIPTOR);
            updateScreenshotForAsr(r101.readString());
            return true;
        L16:
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L19;
            r105 = AppEvent.CREATOR.createFromParcel(r101);
        L19:
            boolean r109 = tryOpenMicToRecording(r105);
            r102.writeNoException();
            r102.writeInt(r109 ? 1 : 0);
            return true;
        L21:
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L24;
            r106 = AppEvent.CREATOR.createFromParcel(r101);
        L24:
            boolean r110 = tryInterruptAssistant(r106);
            r102.writeNoException();
            r102.writeInt(r110 ? 1 : 0);
            return true;
        L26:
            r101.enforceInterface(DESCRIPTOR);
            tryOpenClickTalk(r101.readInt());
            return true;
        L28:
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L31;
            r104 = IMMessage.CREATOR.createFromParcel(r101);
        L31:
            readContentByMessage(r104);
            return true;
        L33:
            r101.enforceInterface(DESCRIPTOR);
            boolean r111 = isInRealtimeCalling();
            r102.writeNoException();
            r102.writeInt(r111 ? 1 : 0);
            return true;
        L35:
            r101.enforceInterface(DESCRIPTOR);
            readContent(r101.readString());
            return true;
        L37:
            r101.enforceInterface(DESCRIPTOR);
            replayMessageTts(r101.readString());
            return true;
        L39:
            r101.enforceInterface(DESCRIPTOR);
            requireSyncData(IFlowSyncDataResultIDL.Stub.asInterface(r101.readStrongBinder()));
            return true;
        L41:
            r101.enforceInterface(DESCRIPTOR);
            wakeupAssistant(r101.readString());
            return true;
        L7:
            return super.onTransact(r100, r101, r102, r103);
        L43:
            r102.writeString(DESCRIPTOR);
            return true;
        }
    }

    boolean closeContinuousTalk() throws RemoteException;

    boolean isInRealtimeCalling() throws RemoteException;

    boolean isInteractionSessionStateListening() throws RemoteException;

    void readContent(String r100) throws RemoteException;

    void readContentByMessage(IMMessage r100) throws RemoteException;

    void replayMessageTts(String r100) throws RemoteException;

    void requireSyncData(IFlowSyncDataResultIDL r100) throws RemoteException;

    boolean tryInterruptAssistant(AppEvent r100) throws RemoteException;

    void tryOpenClickTalk(int r100) throws RemoteException;

    boolean tryOpenMicToRecording(AppEvent r100) throws RemoteException;

    void updateIntentExt(Map r100) throws RemoteException;

    void updateScreenshotForAsr(String r100) throws RemoteException;

    void wakeupAssistant(String r100) throws RemoteException;
}
