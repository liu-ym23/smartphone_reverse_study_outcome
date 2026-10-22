package com.obric.aiagent.assistant.idl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aiagent.assistant.idl.bean.OTaskTimeoutConfig;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes4.dex */
public interface IFlowAppIntentIDL extends IInterface {
    public static final String ACTION_BAR_KEY_FILE_PERCEIVE = "obric_document_perception";
    public static final String ACTION_BAR_KEY_IM_PERCEIVE = "obric_im_perception";
    public static final String ACTION_BAR_KEY_PHOTO_PERCEIVE = "obric_photo_perception";
    public static final String ACTION_BAR_KEY_SCREEN_SHOT = "obric_screen_qa";
    public static final String ACTION_BAR_KEY_VIDEO_PERCEIVE = "obric_video_perception";
    public static final String ACTION_BAR_KEY_WEB_PERCEIVE = "obric_web_perception";
    public static final String PARAM_APPLET_ID = "appletId";
    public static final String PERMISSION_BACKGROUND_LOCATION = "BACKGROUND_LOCATION";
    public static final String PERMISSION_CALENDAR = "calendar";
    public static final String PERMISSION_LOCATION = "location";
    public static final String PERMISSION_NOTIFICATION = "notification";

    /* JADX INFO: loaded from: classes32.dex */
    public static class Default implements IFlowAppIntentIDL {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowAppIntentIDL
        public boolean checkPermission(String r100, boolean r101, long r102) throws RemoteException {
            return false;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowAppIntentIDL
        public long currentTimeMillis() throws RemoteException {
            return 0;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowAppIntentIDL
        public void getLocation(IFlowGetLocationCallbackIDL r100) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowAppIntentIDL
        public OTaskTimeoutConfig getObricTaskTimeoutConfig() throws RemoteException {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowAppIntentIDL
        public String getUserId() throws RemoteException {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowAppIntentIDL
        public boolean isDoraConnected() throws RemoteException {
            return false;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowAppIntentIDL
        public boolean isEnterpriseAccount() throws RemoteException {
            return false;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowAppIntentIDL
        public boolean isLogin() throws RemoteException {
            return false;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowAppIntentIDL
        public void jumpDoraPage() throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowAppIntentIDL
        public boolean openMiniApp(String r100) throws RemoteException {
            return false;
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowAppIntentIDL
        public void setAppIntentActive(boolean r100) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowAppIntentIDL
        public void stopComplexTask(String r100) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IFlowAppIntentIDL
        public boolean syncAppletData(String r100) throws RemoteException {
            return false;
        }
    }

    public static abstract class Stub extends Binder implements IFlowAppIntentIDL {
        private static final String DESCRIPTOR = "com.obric.aiagent.assistant.idl.IFlowAppIntentIDL";
        static final int TRANSACTION_checkPermission = 2;
        static final int TRANSACTION_currentTimeMillis = 9;
        static final int TRANSACTION_getLocation = 11;
        static final int TRANSACTION_getObricTaskTimeoutConfig = 6;
        static final int TRANSACTION_getUserId = 10;
        static final int TRANSACTION_isDoraConnected = 7;
        static final int TRANSACTION_isEnterpriseAccount = 5;
        static final int TRANSACTION_isLogin = 4;
        static final int TRANSACTION_jumpDoraPage = 8;
        static final int TRANSACTION_openMiniApp = 12;
        static final int TRANSACTION_setAppIntentActive = 1;
        static final int TRANSACTION_stopComplexTask = 3;
        static final int TRANSACTION_syncAppletData = 13;

        /* JADX INFO: loaded from: classes6.dex */
        public static class Proxy implements IFlowAppIntentIDL {
            public static IFlowAppIntentIDL sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowAppIntentIDL
            public long currentTimeMillis() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowAppIntentIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 9, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L13
                long r102 = r101.readLong();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r102;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                long r103 = Stub.getDefaultImpl().currentTimeMillis();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r103;
            L13:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowAppIntentIDL
            public OTaskTimeoutConfig getObricTaskTimeoutConfig() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowAppIntentIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 6, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L17
                if (r101.readInt() == 0) goto L14;
                OTaskTimeoutConfig r102 = OTaskTimeoutConfig.CREATOR.createFromParcel(r101);     // Catch: Throwable -> L17
            L15:
                r101.recycle();
                r100.recycle();
                return r102;
            L14:
                r102 = null;
                goto L15
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                OTaskTimeoutConfig r103 = Stub.getDefaultImpl().getObricTaskTimeoutConfig();     // Catch: Throwable -> L17
                r101.recycle();
                r100.recycle();
                return r103;
            L17:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowAppIntentIDL
            public String getUserId() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowAppIntentIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 10, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L13
                String r102 = r101.readString();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r102;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                String r103 = Stub.getDefaultImpl().getUserId();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r103;
            L13:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowAppIntentIDL
            public boolean isDoraConnected() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                boolean r102 = false;
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowAppIntentIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 7, r100, r101, 0) == false) goto L6;
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
                boolean r103 = Stub.getDefaultImpl().isDoraConnected();     // Catch: Throwable -> L15
                r101.recycle();
                r100.recycle();
                return r103;
            L15:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowAppIntentIDL
            public boolean isEnterpriseAccount() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                boolean r102 = false;
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowAppIntentIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 5, r100, r101, 0) == false) goto L6;
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
                boolean r103 = Stub.getDefaultImpl().isEnterpriseAccount();     // Catch: Throwable -> L15
                r101.recycle();
                r100.recycle();
                return r103;
            L15:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowAppIntentIDL
            public boolean isLogin() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                boolean r102 = false;
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowAppIntentIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r100, r101, 0) == false) goto L6;
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
                boolean r103 = Stub.getDefaultImpl().isLogin();     // Catch: Throwable -> L15
                r101.recycle();
                r100.recycle();
                return r103;
            L15:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowAppIntentIDL
            public void jumpDoraPage() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowAppIntentIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 8, r100, null, 1) == false) goto L6;
            L10:
                r100.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().jumpDoraPage();     // Catch: Throwable -> L12
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

            @Override // com.obric.aiagent.assistant.idl.IFlowAppIntentIDL
            public void getLocation(IFlowGetLocationCallbackIDL r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r100 == null) goto L6;
                IBinder r102 = r100.asBinder();     // Catch: Throwable -> L16
            L7:
                r101.writeStrongBinder(r102);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowAppIntentIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 11, r101, null, 1) == false) goto L10;
            L14:
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().getLocation(r100);     // Catch: Throwable -> L16
                r101.recycle();
                return;
            L6:
                r102 = null;
            L16:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowAppIntentIDL
            public boolean openMiniApp(String r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                r101.writeString(r100);     // Catch: Throwable -> L15
                boolean r103 = false;
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowAppIntentIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 12, r101, r102, 0) == false) goto L6;
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
                boolean r104 = Stub.getDefaultImpl().openMiniApp(r100);     // Catch: Throwable -> L15
                r102.recycle();
                r101.recycle();
                return r104;
            L15:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowAppIntentIDL
            public void setAppIntentActive(boolean r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r100 == false) goto L6;
                int r102 = 1;
            L7:
                r101.writeInt(r102);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowAppIntentIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r101, null, 1) == false) goto L10;
            L14:
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().setAppIntentActive(r100);     // Catch: Throwable -> L16
                r101.recycle();
                return;
            L6:
                r102 = 0;
            L16:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowAppIntentIDL
            public void stopComplexTask(String r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r101.writeString(r100);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowAppIntentIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r101, null, 1) == false) goto L6;
            L10:
                r101.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().stopComplexTask(r100);     // Catch: Throwable -> L12
                r101.recycle();
                return;
            L12:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowAppIntentIDL
            public boolean syncAppletData(String r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                r101.writeString(r100);     // Catch: Throwable -> L15
                boolean r103 = false;
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowAppIntentIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 13, r101, r102, 0) == false) goto L6;
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
                boolean r104 = Stub.getDefaultImpl().syncAppletData(r100);     // Catch: Throwable -> L15
                r102.recycle();
                r101.recycle();
                return r104;
            L15:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IFlowAppIntentIDL
            public boolean checkPermission(String r100, boolean r101, long r102) throws RemoteException {
                Parcel r103 = Parcel.obtain();
                Parcel r104 = Parcel.obtain();
                r103.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L20
                r103.writeString(r100);     // Catch: Throwable -> L20
                boolean r105 = true;
                if (r101 == false) goto L6;
                int r106 = 1;
            L7:
                r103.writeInt(r106);     // Catch: Throwable -> L20
                r103.writeLong(r102);     // Catch: Throwable -> L20
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowAppIntentIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r103, r104, 0) == false) goto L10;
            L14:
                r104.readException();     // Catch: Throwable -> L20
                if (r104.readInt() != 0) goto L18;
                r105 = false;
            L18:
                r104.recycle();
                r103.recycle();
                return r105;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                boolean r107 = Stub.getDefaultImpl().checkPermission(r100, r101, r102);     // Catch: Throwable -> L20
                r104.recycle();
                r103.recycle();
                return r107;
            L6:
                r106 = 0;
            L20:
                th = move-exception;
                r104.recycle();
                r103.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowAppIntentIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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

        public static IFlowAppIntentIDL getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static IFlowAppIntentIDL asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof IFlowAppIntentIDL) == false) goto L12;
            return (IFlowAppIntentIDL) r101;
        L12:
            return new Proxy(r100);
        }

        public static boolean setDefaultImpl(IFlowAppIntentIDL r100) {
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
            boolean r104 = false;
            switch(r100) {
                case 1: goto L38;
                case 2: goto L33;
                case 3: goto L31;
                case 4: goto L29;
                case 5: goto L27;
                case 6: goto L22;
                case 7: goto L20;
                case 8: goto L18;
                case 9: goto L16;
                case 10: goto L14;
                case 11: goto L12;
                case 12: goto L10;
                case 13: goto L8;
                default: goto L7;
            };
        L8:
            r101.enforceInterface(DESCRIPTOR);
            boolean r105 = syncAppletData(r101.readString());
            r102.writeNoException();
            r102.writeInt(r105 ? 1 : 0);
            return true;
        L10:
            r101.enforceInterface(DESCRIPTOR);
            boolean r106 = openMiniApp(r101.readString());
            r102.writeNoException();
            r102.writeInt(r106 ? 1 : 0);
            return true;
        L12:
            r101.enforceInterface(DESCRIPTOR);
            getLocation(IFlowGetLocationCallbackIDL.Stub.asInterface(r101.readStrongBinder()));
            return true;
        L14:
            r101.enforceInterface(DESCRIPTOR);
            String r107 = getUserId();
            r102.writeNoException();
            r102.writeString(r107);
            return true;
        L16:
            r101.enforceInterface(DESCRIPTOR);
            long r108 = currentTimeMillis();
            r102.writeNoException();
            r102.writeLong(r108);
            return true;
        L18:
            r101.enforceInterface(DESCRIPTOR);
            jumpDoraPage();
            return true;
        L20:
            r101.enforceInterface(DESCRIPTOR);
            boolean r109 = isDoraConnected();
            r102.writeNoException();
            r102.writeInt(r109 ? 1 : 0);
            return true;
        L22:
            r101.enforceInterface(DESCRIPTOR);
            OTaskTimeoutConfig r110 = getObricTaskTimeoutConfig();
            r102.writeNoException();
            if (r110 == null) goto L25;
            r102.writeInt(1);
            r110.writeToParcel(r102, 1);
        L26:
            return true;
        L25:
            r102.writeInt(0);
            goto L26
        L27:
            r101.enforceInterface(DESCRIPTOR);
            boolean r111 = isEnterpriseAccount();
            r102.writeNoException();
            r102.writeInt(r111 ? 1 : 0);
            return true;
        L29:
            r101.enforceInterface(DESCRIPTOR);
            boolean r112 = isLogin();
            r102.writeNoException();
            r102.writeInt(r112 ? 1 : 0);
            return true;
        L31:
            r101.enforceInterface(DESCRIPTOR);
            stopComplexTask(r101.readString());
            return true;
        L33:
            r101.enforceInterface(DESCRIPTOR);
            String r113 = r101.readString();
            if (r101.readInt() == 0) goto L36;
            r104 = true;
        L36:
            boolean r114 = checkPermission(r113, r104, r101.readLong());
            r102.writeNoException();
            r102.writeInt(r114 ? 1 : 0);
            return true;
        L38:
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L41;
            r104 = true;
        L41:
            setAppIntentActive(r104);
            return true;
        L7:
            return super.onTransact(r100, r101, r102, r103);
        L43:
            r102.writeString(DESCRIPTOR);
            return true;
        }
    }

    boolean checkPermission(String r100, boolean r101, long r102) throws RemoteException;

    long currentTimeMillis() throws RemoteException;

    void getLocation(IFlowGetLocationCallbackIDL r100) throws RemoteException;

    OTaskTimeoutConfig getObricTaskTimeoutConfig() throws RemoteException;

    String getUserId() throws RemoteException;

    boolean isDoraConnected() throws RemoteException;

    boolean isEnterpriseAccount() throws RemoteException;

    boolean isLogin() throws RemoteException;

    void jumpDoraPage() throws RemoteException;

    boolean openMiniApp(String r100) throws RemoteException;

    void setAppIntentActive(boolean r100) throws RemoteException;

    void stopComplexTask(String r100) throws RemoteException;

    boolean syncAppletData(String r100) throws RemoteException;
}
