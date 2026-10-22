package com.obric.aiagent.assistant.idl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aiagent.assistant.idl.bean.DMStateInfo;
import com.obric.aiagent.assistant.idl.bean.DMTaskInfo;
import com.obric.aiagent.assistant.idl.bean.DMTaskState;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes4.dex */
public interface IAgentDMStateListenerIDL extends IInterface {

    /* JADX INFO: loaded from: classes32.dex */
    public static class Default implements IAgentDMStateListenerIDL {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentDMStateListenerIDL
        public void onDMStateChanged(DMStateInfo r100) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentDMStateListenerIDL
        public void onTaskAdded(DMTaskInfo r100) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentDMStateListenerIDL
        public void onTaskEnd(DMTaskInfo r100) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentDMStateListenerIDL
        public void onTaskStateChanged(DMTaskInfo r100, DMTaskState r101, DMTaskState r102) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IAgentDMStateListenerIDL {
        private static final String DESCRIPTOR = "com.obric.aiagent.assistant.idl.IAgentDMStateListenerIDL";
        static final int TRANSACTION_onDMStateChanged = 1;
        static final int TRANSACTION_onTaskAdded = 2;
        static final int TRANSACTION_onTaskEnd = 3;
        static final int TRANSACTION_onTaskStateChanged = 4;

        /* JADX INFO: loaded from: classes6.dex */
        public static class Proxy implements IAgentDMStateListenerIDL {
            public static IAgentDMStateListenerIDL sDefaultImpl;
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

            @Override // com.obric.aiagent.assistant.idl.IAgentDMStateListenerIDL
            public void onDMStateChanged(DMStateInfo r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r100 == null) goto L6;
                r101.writeInt(1);     // Catch: Throwable -> L16
                r100.writeToParcel(r101, 0);     // Catch: Throwable -> L16
            L8:
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IAgentDMStateListenerIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r101, null, 1) == false) goto L10;
            L14:
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().onDMStateChanged(r100);     // Catch: Throwable -> L16
                r101.recycle();
                return;
            L6:
                r101.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentDMStateListenerIDL
            public void onTaskAdded(DMTaskInfo r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r100 == null) goto L6;
                r101.writeInt(1);     // Catch: Throwable -> L16
                r100.writeToParcel(r101, 0);     // Catch: Throwable -> L16
            L8:
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IAgentDMStateListenerIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r101, null, 1) == false) goto L10;
            L14:
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().onTaskAdded(r100);     // Catch: Throwable -> L16
                r101.recycle();
                return;
            L6:
                r101.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentDMStateListenerIDL
            public void onTaskEnd(DMTaskInfo r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r100 == null) goto L6;
                r101.writeInt(1);     // Catch: Throwable -> L16
                r100.writeToParcel(r101, 0);     // Catch: Throwable -> L16
            L8:
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IAgentDMStateListenerIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r101, null, 1) == false) goto L10;
            L14:
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().onTaskEnd(r100);     // Catch: Throwable -> L16
                r101.recycle();
                return;
            L6:
                r101.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentDMStateListenerIDL
            public void onTaskStateChanged(DMTaskInfo r100, DMTaskState r101, DMTaskState r102) throws RemoteException {
                Parcel r103 = Parcel.obtain();
                r103.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L22
                if (r100 == null) goto L6;
                r103.writeInt(1);     // Catch: Throwable -> L22
                r100.writeToParcel(r103, 0);     // Catch: Throwable -> L22
            L7:
                if (r101 == null) goto L9;
                r103.writeInt(1);     // Catch: Throwable -> L22
                r101.writeToParcel(r103, 0);     // Catch: Throwable -> L22
            L10:
                if (r102 == null) goto L12;
                r103.writeInt(1);     // Catch: Throwable -> L22
                r102.writeToParcel(r103, 0);     // Catch: Throwable -> L22
            L14:
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IAgentDMStateListenerIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r103, null, 1) == false) goto L16;
            L20:
                r103.recycle();
                return;
            L16:
                if (Stub.getDefaultImpl() == null) goto L20;
                Stub.getDefaultImpl().onTaskStateChanged(r100, r101, r102);     // Catch: Throwable -> L22
                r103.recycle();
                return;
            L12:
                r103.writeInt(0);     // Catch: Throwable -> L22
                goto L14
            L9:
                r103.writeInt(0);     // Catch: Throwable -> L22
                goto L10
            L6:
                r103.writeInt(0);     // Catch: Throwable -> L22
            L22:
                th = move-exception;
                r103.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IAgentDMStateListenerIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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

        public static IAgentDMStateListenerIDL getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static IAgentDMStateListenerIDL asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof IAgentDMStateListenerIDL) == false) goto L12;
            return (IAgentDMStateListenerIDL) r101;
        L12:
            return new Proxy(r100);
        }

        public static boolean setDefaultImpl(IAgentDMStateListenerIDL r100) {
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
            DMStateInfo r104 = null;
            DMTaskState r105 = null;
            DMTaskInfo r106 = null;
            DMTaskInfo r107 = null;
            if (r100 != 1) goto L5;
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L42;
            r104 = DMStateInfo.CREATOR.createFromParcel(r101);
        L42:
            onDMStateChanged(r104);
            return true;
        L5:
            if (r100 != 2) goto L7;
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L37;
            r107 = DMTaskInfo.CREATOR.createFromParcel(r101);
        L37:
            onTaskAdded(r107);
            return true;
        L7:
            if (r100 != 3) goto L9;
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L32;
            r106 = DMTaskInfo.CREATOR.createFromParcel(r101);
        L32:
            onTaskEnd(r106);
            return true;
        L9:
            if (r100 != 4) goto L11;
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L19;
            DMTaskInfo r108 = DMTaskInfo.CREATOR.createFromParcel(r101);
        L21:
            if (r101.readInt() == 0) goto L23;
            DMTaskState r109 = DMTaskState.CREATOR.createFromParcel(r101);
        L25:
            if (r101.readInt() == 0) goto L27;
            r105 = DMTaskState.CREATOR.createFromParcel(r101);
        L27:
            onTaskStateChanged(r108, r109, r105);
            return true;
        L23:
            r109 = null;
            goto L25
        L19:
            r108 = null;
            goto L21
        L11:
            if (r100 != 1598968902) goto L13;
            r102.writeString(DESCRIPTOR);
            return true;
        L13:
            return super.onTransact(r100, r101, r102, r103);
        }
    }

    void onDMStateChanged(DMStateInfo r100) throws RemoteException;

    void onTaskAdded(DMTaskInfo r100) throws RemoteException;

    void onTaskEnd(DMTaskInfo r100) throws RemoteException;

    void onTaskStateChanged(DMTaskInfo r100, DMTaskState r101, DMTaskState r102) throws RemoteException;
}
