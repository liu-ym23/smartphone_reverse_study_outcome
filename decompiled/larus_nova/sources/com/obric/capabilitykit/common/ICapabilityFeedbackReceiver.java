package com.obric.capabilitykit.common;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import com.obric.capabilitykit.common.execution.JobResult;
import com.obric.capabilitykit.common.intent.IntentResult;
import java.util.Map;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes6.dex */
public interface ICapabilityFeedbackReceiver extends IInterface {

    /* JADX INFO: loaded from: classes33.dex */
    public static class Default implements ICapabilityFeedbackReceiver {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.capabilitykit.common.ICapabilityFeedbackReceiver
        public boolean isCardViewVisible(long r100) throws RemoteException {
            return false;
        }

        @Override // com.obric.capabilitykit.common.ICapabilityFeedbackReceiver
        public boolean isKeyguardReallyLocked() throws RemoteException {
            return false;
        }

        @Override // com.obric.capabilitykit.common.ICapabilityFeedbackReceiver
        public void onActionResultRecv(String r100, String r101, boolean r102) throws RemoteException {
        }

        @Override // com.obric.capabilitykit.common.ICapabilityFeedbackReceiver
        public void onFinishFloatingActivity(long r100) throws RemoteException {
        }

        @Override // com.obric.capabilitykit.common.ICapabilityFeedbackReceiver
        public void onHideIntentResultCard(long r100) throws RemoteException {
        }

        @Override // com.obric.capabilitykit.common.ICapabilityFeedbackReceiver
        public void onJobResultRecv(String r100, String r101, boolean r102, JobResult r103) throws RemoteException {
        }

        @Override // com.obric.capabilitykit.common.ICapabilityFeedbackReceiver
        public void onUpdateIntentResult(long r100, IntentResult r101, boolean r102, Map r103) throws RemoteException {
        }

        @Override // com.obric.capabilitykit.common.ICapabilityFeedbackReceiver
        public void onUpdateIntentResultWithRequest(String r100, IntentResult r101, boolean r102, Map r103) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements ICapabilityFeedbackReceiver {
        private static final String DESCRIPTOR = "com.obric.capabilitykit.common.ICapabilityFeedbackReceiver";
        public static final int TRANSACTION_isCardViewVisible = 6;
        public static final int TRANSACTION_isKeyguardReallyLocked = 7;
        public static final int TRANSACTION_onActionResultRecv = 1;
        public static final int TRANSACTION_onFinishFloatingActivity = 5;
        public static final int TRANSACTION_onHideIntentResultCard = 3;
        public static final int TRANSACTION_onJobResultRecv = 4;
        public static final int TRANSACTION_onUpdateIntentResult = 2;
        public static final int TRANSACTION_onUpdateIntentResultWithRequest = 8;

        public static class Proxy implements ICapabilityFeedbackReceiver {
            public static ICapabilityFeedbackReceiver sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder r100) {
                this.mRemote = r100;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityFeedbackReceiver
            public boolean isCardViewVisible(long r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                r101.writeLong(r100);     // Catch: Throwable -> L15
                boolean r103 = false;
                if (INVOKEINTERFACE_com_obric_capabilitykit_common_ICapabilityFeedbackReceiver$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 6, r101, r102, 0) == false) goto L6;
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

            @Override // com.obric.capabilitykit.common.ICapabilityFeedbackReceiver
            public boolean isKeyguardReallyLocked() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                boolean r102 = false;
                if (INVOKEINTERFACE_com_obric_capabilitykit_common_ICapabilityFeedbackReceiver$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 7, r100, r101, 0) == false) goto L6;
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

            @Override // com.obric.capabilitykit.common.ICapabilityFeedbackReceiver
            public void onActionResultRecv(String r100, String r101, boolean r102) throws RemoteException {
                Parcel r103 = Parcel.obtain();
                r103.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r103.writeString(r100);     // Catch: Throwable -> L12
                r103.writeString(r101);     // Catch: Throwable -> L12
                r103.writeInt(r102 ? 1 : 0);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_capabilitykit_common_ICapabilityFeedbackReceiver$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r103, null, 1) == false) goto L6;
            L10:
                r103.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onActionResultRecv(r100, r101, r102);     // Catch: Throwable -> L12
                r103.recycle();
                return;
            L12:
                th = move-exception;
                r103.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityFeedbackReceiver
            public void onFinishFloatingActivity(long r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r101.writeLong(r100);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_capabilitykit_common_ICapabilityFeedbackReceiver$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 5, r101, null, 1) == false) goto L6;
            L10:
                r101.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onFinishFloatingActivity(r100);     // Catch: Throwable -> L12
                r101.recycle();
                return;
            L12:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityFeedbackReceiver
            public void onHideIntentResultCard(long r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r101.writeLong(r100);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_capabilitykit_common_ICapabilityFeedbackReceiver$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r101, null, 1) == false) goto L6;
            L10:
                r101.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onHideIntentResultCard(r100);     // Catch: Throwable -> L12
                r101.recycle();
                return;
            L12:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityFeedbackReceiver
            public void onJobResultRecv(String r100, String r101, boolean r102, JobResult r103) throws RemoteException {
                Parcel r104 = Parcel.obtain();
                r104.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r104.writeString(r100);     // Catch: Throwable -> L16
                r104.writeString(r101);     // Catch: Throwable -> L16
                r104.writeInt(r102 ? 1 : 0);     // Catch: Throwable -> L16
                if (r103 == null) goto L6;
                r104.writeInt(1);     // Catch: Throwable -> L16
                r103.writeToParcel(r104, 0);     // Catch: Throwable -> L16
            L8:
                if (INVOKEINTERFACE_com_obric_capabilitykit_common_ICapabilityFeedbackReceiver$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r104, null, 1) == false) goto L10;
            L14:
                r104.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().onJobResultRecv(r100, r101, r102, r103);     // Catch: Throwable -> L16
                r104.recycle();
                return;
            L6:
                r104.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r104.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityFeedbackReceiver
            public void onUpdateIntentResult(long r100, IntentResult r110, boolean r111, Map r112) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r101.writeLong(r100);     // Catch: Throwable -> L16
                if (r110 == null) goto L6;
                r101.writeInt(1);     // Catch: Throwable -> L16
                r110.writeToParcel(r101, 0);     // Catch: Throwable -> L16
            L7:
                r101.writeInt(r111 ? 1 : 0);     // Catch: Throwable -> L16
                r101.writeMap(r112);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_com_obric_capabilitykit_common_ICapabilityFeedbackReceiver$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r101, null, 1) == false) goto L10;
            L14:
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().onUpdateIntentResult(r100, r110, r111, r112);     // Catch: Throwable -> L16
                r101.recycle();
                return;
            L6:
                r101.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.common.ICapabilityFeedbackReceiver
            public void onUpdateIntentResultWithRequest(String r100, IntentResult r101, boolean r102, Map r103) throws RemoteException {
                Parcel r104 = Parcel.obtain();
                r104.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r104.writeString(r100);     // Catch: Throwable -> L16
                if (r101 == null) goto L6;
                r104.writeInt(1);     // Catch: Throwable -> L16
                r101.writeToParcel(r104, 0);     // Catch: Throwable -> L16
            L7:
                r104.writeInt(r102 ? 1 : 0);     // Catch: Throwable -> L16
                r104.writeMap(r103);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_com_obric_capabilitykit_common_ICapabilityFeedbackReceiver$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 8, r104, null, 1) == false) goto L10;
            L14:
                r104.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().onUpdateIntentResultWithRequest(r100, r101, r102, r103);     // Catch: Throwable -> L16
                r104.recycle();
                return;
            L6:
                r104.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r104.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_obric_capabilitykit_common_ICapabilityFeedbackReceiver$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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

        public static ICapabilityFeedbackReceiver asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof ICapabilityFeedbackReceiver) == false) goto L12;
            return (ICapabilityFeedbackReceiver) r101;
        L12:
            return new Proxy(r100);
        }

        public static ICapabilityFeedbackReceiver getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(ICapabilityFeedbackReceiver r100) {
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
        public boolean onTransact(int r100, Parcel r110, Parcel r111, int r112) throws RemoteException {
            if (r100 == 1598968902) goto L46;
            boolean r101 = false;
            IntentResult r102 = null;
            IntentResult r103 = null;
            JobResult r104 = null;
            switch(r100) {
                case 1: goto L41;
                case 2: goto L32;
                case 3: goto L30;
                case 4: goto L22;
                case 5: goto L20;
                case 6: goto L18;
                case 7: goto L16;
                case 8: goto L8;
                default: goto L7;
            };
        L8:
            r110.enforceInterface(DESCRIPTOR);
            String r105 = r110.readString();
            if (r110.readInt() == 0) goto L12;
            IntentResult.CREATOR.getClass();
            r103 = IntentResult.b.b(r110);
        L12:
            if (r110.readInt() == 0) goto L14;
            r101 = true;
        L14:
            onUpdateIntentResultWithRequest(r105, r103, r101, r110.readHashMap(getClass().getClassLoader()));
            return true;
        L16:
            r110.enforceInterface(DESCRIPTOR);
            boolean r106 = isKeyguardReallyLocked();
            r111.writeNoException();
            r111.writeInt(r106 ? 1 : 0);
            return true;
        L18:
            r110.enforceInterface(DESCRIPTOR);
            boolean r107 = isCardViewVisible(r110.readLong());
            r111.writeNoException();
            r111.writeInt(r107 ? 1 : 0);
            return true;
        L20:
            r110.enforceInterface(DESCRIPTOR);
            onFinishFloatingActivity(r110.readLong());
            return true;
        L22:
            r110.enforceInterface(DESCRIPTOR);
            String r108 = r110.readString();
            String r113 = r110.readString();
            if (r110.readInt() == 0) goto L26;
            r101 = true;
        L26:
            if (r110.readInt() == 0) goto L28;
            r104 = JobResult.CREATOR.createFromParcel(r110);
        L28:
            onJobResultRecv(r108, r113, r101, r104);
            return true;
        L30:
            r110.enforceInterface(DESCRIPTOR);
            onHideIntentResultCard(r110.readLong());
            return true;
        L32:
            r110.enforceInterface(DESCRIPTOR);
            long r114 = r110.readLong();
            if (r110.readInt() == 0) goto L35;
            IntentResult.CREATOR.getClass();
            r102 = IntentResult.b.b(r110);
        L35:
            IntentResult r109 = r102;
            if (r110.readInt() == 0) goto L38;
            boolean r115 = true;
        L39:
            onUpdateIntentResult(r114, r109, r115, r110.readHashMap(getClass().getClassLoader()));
            return true;
        L38:
            r115 = false;
            goto L39
        L41:
            r110.enforceInterface(DESCRIPTOR);
            String r116 = r110.readString();
            String r117 = r110.readString();
            if (r110.readInt() == 0) goto L44;
            r101 = true;
        L44:
            onActionResultRecv(r116, r117, r101);
            return true;
        L7:
            return super.onTransact(r100, r110, r111, r112);
        L46:
            r111.writeString(DESCRIPTOR);
            return true;
        }
    }

    boolean isCardViewVisible(long r100) throws RemoteException;

    boolean isKeyguardReallyLocked() throws RemoteException;

    void onActionResultRecv(String r100, String r101, boolean r102) throws RemoteException;

    void onFinishFloatingActivity(long r100) throws RemoteException;

    void onHideIntentResultCard(long r100) throws RemoteException;

    void onJobResultRecv(String r100, String r101, boolean r102, JobResult r103) throws RemoteException;

    void onUpdateIntentResult(long r100, IntentResult r101, boolean r102, Map r103) throws RemoteException;

    void onUpdateIntentResultWithRequest(String r100, IntentResult r101, boolean r102, Map r103) throws RemoteException;
}
