package com.obric.capabilitykit.common;

import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import com.obric.capabilitykit.common.execution.fileaccess.IUriFileReceiver;
import com.obric.capabilitykit.common.intent.IntentResult;
import java.util.Map;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes6.dex */
public interface ICapabilityManager extends IInterface {

    /* JADX INFO: loaded from: classes33.dex */
    public static class Default implements ICapabilityManager {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.capabilitykit.common.ICapabilityManager
        public void finishFloatingActivity(long r100) throws RemoteException {
        }

        @Override // com.obric.capabilitykit.common.ICapabilityManager
        public PendingIntent getFloatingPendingIntent(long r100, Intent r101, FloatingIntentParams r102) throws RemoteException {
            return null;
        }

        @Override // com.obric.capabilitykit.common.ICapabilityManager
        public int getVersion() throws RemoteException {
            return 0;
        }

        @Override // com.obric.capabilitykit.common.ICapabilityManager
        public void hideIntentResultCard(long r100) throws RemoteException {
        }

        @Override // com.obric.capabilitykit.common.ICapabilityManager
        public boolean isCardViewVisible(long r100) throws RemoteException {
            return false;
        }

        @Override // com.obric.capabilitykit.common.ICapabilityManager
        public boolean isKeyguardReallyLocked() throws RemoteException {
            return false;
        }

        @Override // com.obric.capabilitykit.common.ICapabilityManager
        public void registerFunction(String r100) throws RemoteException {
        }

        @Override // com.obric.capabilitykit.common.ICapabilityManager
        public void registerIntent(String r100, String r101, String r102) throws RemoteException {
        }

        @Override // com.obric.capabilitykit.common.ICapabilityManager
        public void registerResultCallback(IErrorCodeCallback r100) throws RemoteException {
        }

        @Override // com.obric.capabilitykit.common.ICapabilityManager
        public void requestCloseFile(String r100, Uri r101) throws RemoteException {
        }

        @Override // com.obric.capabilitykit.common.ICapabilityManager
        public boolean requestOpenFile(IUriFileReceiver r100, Uri r101, String r102) throws RemoteException {
            return false;
        }

        @Override // com.obric.capabilitykit.common.ICapabilityManager
        public void requestStateChanged(String r100, TaskStateInfo r101, ITaskStateChangeCallback r102, long r103) throws RemoteException {
        }

        @Override // com.obric.capabilitykit.common.ICapabilityManager
        public void sendActionExecuteResult(String r100) throws RemoteException {
        }

        @Override // com.obric.capabilitykit.common.ICapabilityManager
        public void sendIntentExecutionResult(IntentResult r100, String r101) throws RemoteException {
        }

        @Override // com.obric.capabilitykit.common.ICapabilityManager
        public void unregisterFunction(String r100) throws RemoteException {
        }

        @Override // com.obric.capabilitykit.common.ICapabilityManager
        public void unregisterIntent(String r100, String r101) throws RemoteException {
        }

        @Override // com.obric.capabilitykit.common.ICapabilityManager
        public void unregisterResultCallback(IErrorCodeCallback r100) throws RemoteException {
        }

        @Override // com.obric.capabilitykit.common.ICapabilityManager
        public void updateIntentResult(IntentResult r100, long r101, boolean r102, Map r103) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements ICapabilityManager {
        private static final String DESCRIPTOR = "com.obric.capabilitykit.common.ICapabilityManager";
        public static final int TRANSACTION_finishFloatingActivity = 14;
        public static final int TRANSACTION_getFloatingPendingIntent = 16;
        public static final int TRANSACTION_getVersion = 1;
        public static final int TRANSACTION_hideIntentResultCard = 9;
        public static final int TRANSACTION_isCardViewVisible = 15;
        public static final int TRANSACTION_isKeyguardReallyLocked = 17;
        public static final int TRANSACTION_registerFunction = 2;
        public static final int TRANSACTION_registerIntent = 4;
        public static final int TRANSACTION_registerResultCallback = 10;
        public static final int TRANSACTION_requestCloseFile = 13;
        public static final int TRANSACTION_requestOpenFile = 12;
        public static final int TRANSACTION_requestStateChanged = 18;
        public static final int TRANSACTION_sendActionExecuteResult = 7;
        public static final int TRANSACTION_sendIntentExecutionResult = 6;
        public static final int TRANSACTION_unregisterFunction = 3;
        public static final int TRANSACTION_unregisterIntent = 5;
        public static final int TRANSACTION_unregisterResultCallback = 11;
        public static final int TRANSACTION_updateIntentResult = 8;

        public static class Proxy implements ICapabilityManager {
            public static ICapabilityManager sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder r100) {
                this.mRemote = r100;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityManager
            public void finishFloatingActivity(long r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r101.writeLong(r100);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_capabilitykit_common_ICapabilityManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 14, r101, null, 1) == false) goto L6;
            L10:
                r101.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().finishFloatingActivity(r100);     // Catch: Throwable -> L12
                r101.recycle();
                return;
            L12:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityManager
            public PendingIntent getFloatingPendingIntent(long r100, Intent r101, FloatingIntentParams r102) throws RemoteException {
                Parcel r103 = Parcel.obtain();
                Parcel r104 = Parcel.obtain();
                r103.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L22
                r103.writeLong(r100);     // Catch: Throwable -> L22
                if (r101 == null) goto L6;
                r103.writeInt(1);     // Catch: Throwable -> L22
                r101.writeToParcel(r103, 0);     // Catch: Throwable -> L22
            L7:
                if (r102 == null) goto L9;
                r103.writeInt(1);     // Catch: Throwable -> L22
                r102.writeToParcel(r103, 0);     // Catch: Throwable -> L22
            L11:
                if (INVOKEINTERFACE_com_obric_capabilitykit_common_ICapabilityManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 16, r103, r104, 0) == false) goto L13;
            L17:
                r104.readException();     // Catch: Throwable -> L22
                if (r104.readInt() == 0) goto L21;
                PendingIntent r105 = (PendingIntent) PendingIntent.CREATOR.createFromParcel(r104);     // Catch: Throwable -> L22
            L15:
                r104.recycle();
                r103.recycle();
                return r105;
            L21:
                r105 = null;
                goto L15
            L13:
                if (Stub.getDefaultImpl() == null) goto L17;
                r105 = Stub.getDefaultImpl().getFloatingPendingIntent(r100, r101, r102);     // Catch: Throwable -> L22
                goto L15
            L9:
                r103.writeInt(0);     // Catch: Throwable -> L22
                goto L11
            L6:
                r103.writeInt(0);     // Catch: Throwable -> L22
            L22:
                th = move-exception;
                r104.recycle();
                r103.recycle();
                throw th;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityManager
            public int getVersion() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_capabilitykit_common_ICapabilityManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L12
                int r102 = r101.readInt();     // Catch: Throwable -> L12
            L8:
                r101.recycle();
                r100.recycle();
                return r102;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r102 = Stub.getDefaultImpl().getVersion();     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityManager
            public void hideIntentResultCard(long r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r101.writeLong(r100);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_capabilitykit_common_ICapabilityManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 9, r101, null, 1) == false) goto L6;
            L10:
                r101.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().hideIntentResultCard(r100);     // Catch: Throwable -> L12
                r101.recycle();
                return;
            L12:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityManager
            public boolean isCardViewVisible(long r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                r101.writeLong(r100);     // Catch: Throwable -> L15
                boolean r103 = false;
                if (INVOKEINTERFACE_com_obric_capabilitykit_common_ICapabilityManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 15, r101, r102, 0) == false) goto L6;
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
                boolean r104 = Stub.getDefaultImpl().isCardViewVisible(r100);     // Catch: Throwable -> L15
                r102.recycle();
                r101.recycle();
                return r104;
            L15:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityManager
            public boolean isKeyguardReallyLocked() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                boolean r102 = false;
                if (INVOKEINTERFACE_com_obric_capabilitykit_common_ICapabilityManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 17, r100, r101, 0) == false) goto L6;
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
                boolean r103 = Stub.getDefaultImpl().isKeyguardReallyLocked();     // Catch: Throwable -> L15
                r101.recycle();
                r100.recycle();
                return r103;
            L15:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityManager
            public void registerFunction(String r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r101.writeString(r100);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_capabilitykit_common_ICapabilityManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r101, r102, 0) == false) goto L6;
            L10:
                r102.readException();     // Catch: Throwable -> L12
            L8:
                r102.recycle();
                r101.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().registerFunction(r100);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityManager
            public void registerIntent(String r100, String r101, String r102) throws RemoteException {
                Parcel r103 = Parcel.obtain();
                Parcel r104 = Parcel.obtain();
                r103.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r103.writeString(r100);     // Catch: Throwable -> L12
                r103.writeString(r101);     // Catch: Throwable -> L12
                r103.writeString(r102);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_capabilitykit_common_ICapabilityManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r103, r104, 0) == false) goto L6;
            L10:
                r104.readException();     // Catch: Throwable -> L12
            L8:
                r104.recycle();
                r103.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().registerIntent(r100, r101, r102);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r104.recycle();
                r103.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityManager
            public void registerResultCallback(IErrorCodeCallback r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r100 == null) goto L6;
                IBinder r102 = r100.asBinder();     // Catch: Throwable -> L16
            L7:
                r101.writeStrongBinder(r102);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_com_obric_capabilitykit_common_ICapabilityManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 10, r101, null, 1) == false) goto L10;
            L14:
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().registerResultCallback(r100);     // Catch: Throwable -> L16
                r101.recycle();
                return;
            L6:
                r102 = null;
            L16:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityManager
            public void requestCloseFile(String r100, Uri r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r102.writeString(r100);     // Catch: Throwable -> L16
                if (r101 == null) goto L6;
                r102.writeInt(1);     // Catch: Throwable -> L16
                r101.writeToParcel(r102, 0);     // Catch: Throwable -> L16
            L8:
                if (INVOKEINTERFACE_com_obric_capabilitykit_common_ICapabilityManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 13, r102, null, 1) == false) goto L10;
            L14:
                r102.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().requestCloseFile(r100, r101);     // Catch: Throwable -> L16
                r102.recycle();
                return;
            L6:
                r102.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r102.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityManager
            public boolean requestOpenFile(IUriFileReceiver r100, Uri r101, String r102) throws RemoteException {
                Parcel r103 = Parcel.obtain();
                Parcel r104 = Parcel.obtain();
                r103.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L24
                if (r100 == null) goto L6;
                IBinder r105 = r100.asBinder();     // Catch: Throwable -> L24
            L7:
                r103.writeStrongBinder(r105);     // Catch: Throwable -> L24
                boolean r106 = true;
                if (r101 == null) goto L10;
                r103.writeInt(1);     // Catch: Throwable -> L24
                r101.writeToParcel(r103, 0);     // Catch: Throwable -> L24
            L11:
                r103.writeString(r102);     // Catch: Throwable -> L24
                if (INVOKEINTERFACE_com_obric_capabilitykit_common_ICapabilityManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 12, r103, r104, 0) == false) goto L14;
            L18:
                r104.readException();     // Catch: Throwable -> L24
                if (r104.readInt() != 0) goto L22;
                r106 = false;
            L22:
                r104.recycle();
                r103.recycle();
                return r106;
            L14:
                if (Stub.getDefaultImpl() == null) goto L18;
                boolean r107 = Stub.getDefaultImpl().requestOpenFile(r100, r101, r102);     // Catch: Throwable -> L24
                r104.recycle();
                r103.recycle();
                return r107;
            L10:
                r103.writeInt(0);     // Catch: Throwable -> L24
                goto L11
            L6:
                r105 = null;
            L24:
                th = move-exception;
                r104.recycle();
                r103.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityManager
            public void requestStateChanged(String r100, TaskStateInfo r110, ITaskStateChangeCallback r111, long r112) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L20
                r101.writeString(r100);     // Catch: Throwable -> L20
                if (r110 == null) goto L6;
                r101.writeInt(1);     // Catch: Throwable -> L20
                r110.writeToParcel(r101, 0);     // Catch: Throwable -> L20
            L8:
                if (r111 == null) goto L10;
                IBinder r102 = r111.asBinder();     // Catch: Throwable -> L20
            L11:
                r101.writeStrongBinder(r102);     // Catch: Throwable -> L20
                r101.writeLong(r112);     // Catch: Throwable -> L20
                if (INVOKEINTERFACE_com_obric_capabilitykit_common_ICapabilityManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 18, r101, null, 1) == false) goto L14;
            L18:
                r101.recycle();
                return;
            L14:
                if (Stub.getDefaultImpl() == null) goto L18;
                Stub.getDefaultImpl().requestStateChanged(r100, r110, r111, r112);     // Catch: Throwable -> L20
                r101.recycle();
                return;
            L10:
                r102 = null;
                goto L11
            L6:
                r101.writeInt(0);     // Catch: Throwable -> L20
            L20:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityManager
            public void sendActionExecuteResult(String r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r101.writeString(r100);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_capabilitykit_common_ICapabilityManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 7, r101, null, 1) == false) goto L6;
            L10:
                r101.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().sendActionExecuteResult(r100);     // Catch: Throwable -> L12
                r101.recycle();
                return;
            L12:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityManager
            public void sendIntentExecutionResult(IntentResult r100, String r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r100 == null) goto L6;
                r102.writeInt(1);     // Catch: Throwable -> L16
                r100.writeToParcel(r102, 0);     // Catch: Throwable -> L16
            L7:
                r102.writeString(r101);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_com_obric_capabilitykit_common_ICapabilityManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 6, r102, null, 1) == false) goto L10;
            L14:
                r102.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().sendIntentExecutionResult(r100, r101);     // Catch: Throwable -> L16
                r102.recycle();
                return;
            L6:
                r102.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r102.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityManager
            public void unregisterFunction(String r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r101.writeString(r100);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_capabilitykit_common_ICapabilityManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r101, r102, 0) == false) goto L6;
            L10:
                r102.readException();     // Catch: Throwable -> L12
            L8:
                r102.recycle();
                r101.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().unregisterFunction(r100);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityManager
            public void unregisterIntent(String r100, String r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r102.writeString(r100);     // Catch: Throwable -> L12
                r102.writeString(r101);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_capabilitykit_common_ICapabilityManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 5, r102, r103, 0) == false) goto L6;
            L10:
                r103.readException();     // Catch: Throwable -> L12
            L8:
                r103.recycle();
                r102.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().unregisterIntent(r100, r101);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r103.recycle();
                r102.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityManager
            public void unregisterResultCallback(IErrorCodeCallback r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r100 == null) goto L6;
                IBinder r102 = r100.asBinder();     // Catch: Throwable -> L16
            L7:
                r101.writeStrongBinder(r102);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_com_obric_capabilitykit_common_ICapabilityManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 11, r101, null, 1) == false) goto L10;
            L14:
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().unregisterResultCallback(r100);     // Catch: Throwable -> L16
                r101.recycle();
                return;
            L6:
                r102 = null;
            L16:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityManager
            public void updateIntentResult(IntentResult r100, long r110, boolean r111, Map r112) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r100 == null) goto L6;
                r101.writeInt(1);     // Catch: Throwable -> L16
                r100.writeToParcel(r101, 0);     // Catch: Throwable -> L16
            L7:
                r101.writeLong(r110);     // Catch: Throwable -> L16
                r101.writeInt(r111 ? 1 : 0);     // Catch: Throwable -> L16
                r101.writeMap(r112);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_com_obric_capabilitykit_common_ICapabilityManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 8, r101, null, 1) == false) goto L10;
            L14:
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().updateIntentResult(r100, r110, r111, r112);     // Catch: Throwable -> L16
                r101.recycle();
                return;
            L6:
                r101.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_obric_capabilitykit_common_ICapabilityManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ICapabilityManager asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof ICapabilityManager) == false) goto L12;
            return (ICapabilityManager) r101;
        L12:
            return new Proxy(r100);
        }

        public static ICapabilityManager getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(ICapabilityManager r100) {
            if (Proxy.sDefaultImpl != null) goto L7;
            if (r100 == null) goto L9;
            Proxy.sDefaultImpl = r100;
            return true;
        L9:
            return false;
        L7:
            return false;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r110, Parcel r111, Parcel r112, int r113) throws RemoteException {
            if (r110 == 1598968902) goto L73;
            IntentResult r100 = null;
            TaskStateInfo r101 = null;
            FloatingIntentParams r102 = null;
            Uri r103 = null;
            Uri r104 = null;
            IntentResult r105 = null;
            switch(r110) {
                case 1: goto L71;
                case 2: goto L69;
                case 3: goto L67;
                case 4: goto L65;
                case 5: goto L63;
                case 6: goto L58;
                case 7: goto L56;
                case 8: goto L47;
                case 9: goto L45;
                case 10: goto L43;
                case 11: goto L41;
                case 12: goto L36;
                case 13: goto L31;
                case 14: goto L29;
                case 15: goto L27;
                case 16: goto L15;
                case 17: goto L13;
                case 18: goto L8;
                default: goto L7;
            };
        L8:
            r111.enforceInterface(DESCRIPTOR);
            String r106 = r111.readString();
            if (r111.readInt() == 0) goto L11;
            r101 = TaskStateInfo.CREATOR.createFromParcel(r111);
        L11:
            requestStateChanged(r106, r101, ITaskStateChangeCallback.Stub.asInterface(r111.readStrongBinder()), r111.readLong());
            return true;
        L13:
            r111.enforceInterface(DESCRIPTOR);
            boolean r114 = isKeyguardReallyLocked();
            r112.writeNoException();
            r112.writeInt(r114 ? 1 : 0);
            return true;
        L15:
            r111.enforceInterface(DESCRIPTOR);
            long r107 = r111.readLong();
            if (r111.readInt() == 0) goto L18;
            Intent r115 = (Intent) Intent.CREATOR.createFromParcel(r111);
        L20:
            if (r111.readInt() == 0) goto L22;
            FloatingIntentParams.CREATOR.getClass();
            r102 = FloatingIntentParams.a.a(r111);
        L22:
            PendingIntent r116 = getFloatingPendingIntent(r107, r115, r102);
            r112.writeNoException();
            if (r116 == null) goto L25;
            r112.writeInt(1);
            r116.writeToParcel(r112, 1);
        L26:
            return true;
        L25:
            r112.writeInt(0);
            goto L26
        L18:
            r115 = null;
            goto L20
        L27:
            r111.enforceInterface(DESCRIPTOR);
            boolean r117 = isCardViewVisible(r111.readLong());
            r112.writeNoException();
            r112.writeInt(r117 ? 1 : 0);
            return true;
        L29:
            r111.enforceInterface(DESCRIPTOR);
            finishFloatingActivity(r111.readLong());
            return true;
        L31:
            r111.enforceInterface(DESCRIPTOR);
            String r118 = r111.readString();
            if (r111.readInt() == 0) goto L34;
            r103 = (Uri) Uri.CREATOR.createFromParcel(r111);
        L34:
            requestCloseFile(r118, r103);
            return true;
        L36:
            r111.enforceInterface(DESCRIPTOR);
            IUriFileReceiver r119 = IUriFileReceiver.Stub.asInterface(r111.readStrongBinder());
            if (r111.readInt() == 0) goto L39;
            r104 = (Uri) Uri.CREATOR.createFromParcel(r111);
        L39:
            boolean r120 = requestOpenFile(r119, r104, r111.readString());
            r112.writeNoException();
            r112.writeInt(r120 ? 1 : 0);
            return true;
        L41:
            r111.enforceInterface(DESCRIPTOR);
            unregisterResultCallback(IErrorCodeCallback.Stub.asInterface(r111.readStrongBinder()));
            return true;
        L43:
            r111.enforceInterface(DESCRIPTOR);
            registerResultCallback(IErrorCodeCallback.Stub.asInterface(r111.readStrongBinder()));
            return true;
        L45:
            r111.enforceInterface(DESCRIPTOR);
            hideIntentResultCard(r111.readLong());
            return true;
        L47:
            r111.enforceInterface(DESCRIPTOR);
            if (r111.readInt() == 0) goto L50;
            IntentResult.CREATOR.getClass();
            r105 = IntentResult.b.b(r111);
        L50:
            IntentResult r108 = r105;
            long r109 = r111.readLong();
            if (r111.readInt() == 0) goto L53;
            boolean r121 = true;
        L54:
            updateIntentResult(r108, r109, r121, r111.readHashMap(getClass().getClassLoader()));
            return true;
        L53:
            r121 = false;
            goto L54
        L56:
            r111.enforceInterface(DESCRIPTOR);
            sendActionExecuteResult(r111.readString());
            return true;
        L58:
            r111.enforceInterface(DESCRIPTOR);
            if (r111.readInt() == 0) goto L61;
            IntentResult.CREATOR.getClass();
            r100 = IntentResult.b.b(r111);
        L61:
            sendIntentExecutionResult(r100, r111.readString());
            return true;
        L63:
            r111.enforceInterface(DESCRIPTOR);
            unregisterIntent(r111.readString(), r111.readString());
            r112.writeNoException();
            return true;
        L65:
            r111.enforceInterface(DESCRIPTOR);
            registerIntent(r111.readString(), r111.readString(), r111.readString());
            r112.writeNoException();
            return true;
        L67:
            r111.enforceInterface(DESCRIPTOR);
            unregisterFunction(r111.readString());
            r112.writeNoException();
            return true;
        L69:
            r111.enforceInterface(DESCRIPTOR);
            registerFunction(r111.readString());
            r112.writeNoException();
            return true;
        L71:
            r111.enforceInterface(DESCRIPTOR);
            int r122 = getVersion();
            r112.writeNoException();
            r112.writeInt(r122);
            return true;
        L7:
            return super.onTransact(r110, r111, r112, r113);
        L73:
            r112.writeString(DESCRIPTOR);
            return true;
        }
    }

    void finishFloatingActivity(long r100) throws RemoteException;

    PendingIntent getFloatingPendingIntent(long r100, Intent r101, FloatingIntentParams r102) throws RemoteException;

    int getVersion() throws RemoteException;

    void hideIntentResultCard(long r100) throws RemoteException;

    boolean isCardViewVisible(long r100) throws RemoteException;

    boolean isKeyguardReallyLocked() throws RemoteException;

    void registerFunction(String r100) throws RemoteException;

    void registerIntent(String r100, String r101, String r102) throws RemoteException;

    void registerResultCallback(IErrorCodeCallback r100) throws RemoteException;

    void requestCloseFile(String r100, Uri r101) throws RemoteException;

    boolean requestOpenFile(IUriFileReceiver r100, Uri r101, String r102) throws RemoteException;

    void requestStateChanged(String r100, TaskStateInfo r101, ITaskStateChangeCallback r102, long r103) throws RemoteException;

    void sendActionExecuteResult(String r100) throws RemoteException;

    void sendIntentExecutionResult(IntentResult r100, String r101) throws RemoteException;

    void unregisterFunction(String r100) throws RemoteException;

    void unregisterIntent(String r100, String r101) throws RemoteException;

    void unregisterResultCallback(IErrorCodeCallback r100) throws RemoteException;

    void updateIntentResult(IntentResult r100, long r101, boolean r102, Map r103) throws RemoteException;
}
