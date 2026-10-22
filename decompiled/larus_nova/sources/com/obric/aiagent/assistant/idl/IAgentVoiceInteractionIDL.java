package com.obric.aiagent.assistant.idl;

import android.app.assist.AssistContent;
import android.app.assist.AssistStructure;
import android.graphics.Bitmap;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aiagent.assistant.idl.bean.PersonalContextInfo;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes4.dex */
public interface IAgentVoiceInteractionIDL extends IInterface {

    /* JADX INFO: loaded from: classes6.dex */
    public static class Default implements IAgentVoiceInteractionIDL {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentVoiceInteractionIDL
        public PersonalContextInfo getUserRecentData() throws RemoteException {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentVoiceInteractionIDL
        public void onAsrEnd() throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentVoiceInteractionIDL
        public void onAsrStart(String r100) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentVoiceInteractionIDL
        public void onHandleAssist(AssistStructure r100, AssistContent r101) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentVoiceInteractionIDL
        public void onHandleScreenshot(Bitmap r100) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentVoiceInteractionIDL
        public void onHide() throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentVoiceInteractionIDL
        public void onQueryAudioFile(String r100, String r101) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentVoiceInteractionIDL
        public void onShow(Bundle r100) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentVoiceInteractionIDL
        public void onStartChatWindow(int r100) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IAgentVoiceInteractionIDL {
        private static final String DESCRIPTOR = "com.obric.aiagent.assistant.idl.IAgentVoiceInteractionIDL";
        static final int TRANSACTION_getUserRecentData = 8;
        static final int TRANSACTION_onAsrEnd = 7;
        static final int TRANSACTION_onAsrStart = 6;
        static final int TRANSACTION_onHandleAssist = 3;
        static final int TRANSACTION_onHandleScreenshot = 4;
        static final int TRANSACTION_onHide = 2;
        static final int TRANSACTION_onQueryAudioFile = 9;
        static final int TRANSACTION_onShow = 1;
        static final int TRANSACTION_onStartChatWindow = 5;

        public static class Proxy implements IAgentVoiceInteractionIDL {
            public static IAgentVoiceInteractionIDL sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentVoiceInteractionIDL
            public PersonalContextInfo getUserRecentData() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IAgentVoiceInteractionIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 8, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L17
                if (r101.readInt() == 0) goto L14;
                PersonalContextInfo r102 = PersonalContextInfo.CREATOR.createFromParcel(r101);     // Catch: Throwable -> L17
            L15:
                r101.recycle();
                r100.recycle();
                return r102;
            L14:
                r102 = null;
                goto L15
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                PersonalContextInfo r103 = Stub.getDefaultImpl().getUserRecentData();     // Catch: Throwable -> L17
                r101.recycle();
                r100.recycle();
                return r103;
            L17:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentVoiceInteractionIDL
            public void onAsrEnd() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IAgentVoiceInteractionIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 7, r100, null, 1) == false) goto L6;
            L10:
                r100.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onAsrEnd();     // Catch: Throwable -> L12
                r100.recycle();
                return;
            L12:
                th = move-exception;
                r100.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentVoiceInteractionIDL
            public void onHide() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IAgentVoiceInteractionIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r100, null, 1) == false) goto L6;
            L10:
                r100.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onHide();     // Catch: Throwable -> L12
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

            @Override // com.obric.aiagent.assistant.idl.IAgentVoiceInteractionIDL
            public void onAsrStart(String r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r101.writeString(r100);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IAgentVoiceInteractionIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 6, r101, null, 1) == false) goto L6;
            L10:
                r101.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onAsrStart(r100);     // Catch: Throwable -> L12
                r101.recycle();
                return;
            L12:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentVoiceInteractionIDL
            public void onHandleScreenshot(Bitmap r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r100 == null) goto L6;
                r101.writeInt(1);     // Catch: Throwable -> L16
                r100.writeToParcel(r101, 0);     // Catch: Throwable -> L16
            L8:
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IAgentVoiceInteractionIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r101, null, 1) == false) goto L10;
            L14:
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().onHandleScreenshot(r100);     // Catch: Throwable -> L16
                r101.recycle();
                return;
            L6:
                r101.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentVoiceInteractionIDL
            public void onShow(Bundle r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r100 == null) goto L6;
                r101.writeInt(1);     // Catch: Throwable -> L16
                r100.writeToParcel(r101, 0);     // Catch: Throwable -> L16
            L8:
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IAgentVoiceInteractionIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r101, null, 1) == false) goto L10;
            L14:
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().onShow(r100);     // Catch: Throwable -> L16
                r101.recycle();
                return;
            L6:
                r101.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentVoiceInteractionIDL
            public void onStartChatWindow(int r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r101.writeInt(r100);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IAgentVoiceInteractionIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 5, r101, null, 1) == false) goto L6;
            L10:
                r101.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onStartChatWindow(r100);     // Catch: Throwable -> L12
                r101.recycle();
                return;
            L12:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentVoiceInteractionIDL
            public void onHandleAssist(AssistStructure r100, AssistContent r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L19
                if (r100 == null) goto L6;
                r102.writeInt(1);     // Catch: Throwable -> L19
                r100.writeToParcel(r102, 0);     // Catch: Throwable -> L19
            L7:
                if (r101 == null) goto L9;
                r102.writeInt(1);     // Catch: Throwable -> L19
                r101.writeToParcel(r102, 0);     // Catch: Throwable -> L19
            L11:
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IAgentVoiceInteractionIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r102, null, 1) == false) goto L13;
            L17:
                r102.recycle();
                return;
            L13:
                if (Stub.getDefaultImpl() == null) goto L17;
                Stub.getDefaultImpl().onHandleAssist(r100, r101);     // Catch: Throwable -> L19
                r102.recycle();
                return;
            L9:
                r102.writeInt(0);     // Catch: Throwable -> L19
                goto L11
            L6:
                r102.writeInt(0);     // Catch: Throwable -> L19
            L19:
                th = move-exception;
                r102.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentVoiceInteractionIDL
            public void onQueryAudioFile(String r100, String r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r102.writeString(r100);     // Catch: Throwable -> L12
                r102.writeString(r101);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IAgentVoiceInteractionIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 9, r102, null, 1) == false) goto L6;
            L10:
                r102.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onQueryAudioFile(r100, r101);     // Catch: Throwable -> L12
                r102.recycle();
                return;
            L12:
                th = move-exception;
                r102.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IAgentVoiceInteractionIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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

        public static IAgentVoiceInteractionIDL getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static IAgentVoiceInteractionIDL asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof IAgentVoiceInteractionIDL) == false) goto L12;
            return (IAgentVoiceInteractionIDL) r101;
        L12:
            return new Proxy(r100);
        }

        public static boolean setDefaultImpl(IAgentVoiceInteractionIDL r100) {
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
            if (r100 == 1598968902) goto L42;
            Bundle r104 = null;
            Bitmap r105 = null;
            AssistContent r106 = null;
            switch(r100) {
                case 1: goto L37;
                case 2: goto L35;
                case 3: goto L26;
                case 4: goto L21;
                case 5: goto L19;
                case 6: goto L17;
                case 7: goto L15;
                case 8: goto L10;
                case 9: goto L8;
                default: goto L7;
            };
        L8:
            r101.enforceInterface(DESCRIPTOR);
            onQueryAudioFile(r101.readString(), r101.readString());
            return true;
        L10:
            r101.enforceInterface(DESCRIPTOR);
            PersonalContextInfo r107 = getUserRecentData();
            r102.writeNoException();
            if (r107 == null) goto L13;
            r102.writeInt(1);
            r107.writeToParcel(r102, 1);
        L14:
            return true;
        L13:
            r102.writeInt(0);
            goto L14
        L15:
            r101.enforceInterface(DESCRIPTOR);
            onAsrEnd();
            return true;
        L17:
            r101.enforceInterface(DESCRIPTOR);
            onAsrStart(r101.readString());
            return true;
        L19:
            r101.enforceInterface(DESCRIPTOR);
            onStartChatWindow(r101.readInt());
            return true;
        L21:
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L24;
            r105 = (Bitmap) Bitmap.CREATOR.createFromParcel(r101);
        L24:
            onHandleScreenshot(r105);
            return true;
        L26:
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L29;
            AssistStructure r108 = (AssistStructure) AssistStructure.CREATOR.createFromParcel(r101);
        L31:
            if (r101.readInt() == 0) goto L33;
            r106 = (AssistContent) AssistContent.CREATOR.createFromParcel(r101);
        L33:
            onHandleAssist(r108, r106);
            return true;
        L29:
            r108 = null;
            goto L31
        L35:
            r101.enforceInterface(DESCRIPTOR);
            onHide();
            return true;
        L37:
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L40;
            r104 = (Bundle) Bundle.CREATOR.createFromParcel(r101);
        L40:
            onShow(r104);
            return true;
        L7:
            return super.onTransact(r100, r101, r102, r103);
        L42:
            r102.writeString(DESCRIPTOR);
            return true;
        }
    }

    PersonalContextInfo getUserRecentData() throws RemoteException;

    void onAsrEnd() throws RemoteException;

    void onAsrStart(String r100) throws RemoteException;

    void onHandleAssist(AssistStructure r100, AssistContent r101) throws RemoteException;

    void onHandleScreenshot(Bitmap r100) throws RemoteException;

    void onHide() throws RemoteException;

    void onQueryAudioFile(String r100, String r101) throws RemoteException;

    void onShow(Bundle r100) throws RemoteException;

    void onStartChatWindow(int r100) throws RemoteException;
}
