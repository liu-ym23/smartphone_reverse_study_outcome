package com.obric.aiagent.assistant.idl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aiagent.assistant.idl.bean.RequestRestrictRule;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import java.util.Map;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes4.dex */
public interface IAgentNetworkIDL extends IInterface {

    /* JADX INFO: loaded from: classes6.dex */
    public static class Default implements IAgentNetworkIDL {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentNetworkIDL
        public void notifyRequestStatus(boolean r100, Map r101) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentNetworkIDL
        public void updateExcludeRules(RequestRestrictRule r100) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IAgentNetworkIDL {
        private static final String DESCRIPTOR = "com.obric.aiagent.assistant.idl.IAgentNetworkIDL";
        static final int TRANSACTION_notifyRequestStatus = 1;
        static final int TRANSACTION_updateExcludeRules = 2;

        public static class Proxy implements IAgentNetworkIDL {
            public static IAgentNetworkIDL sDefaultImpl;
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

            @Override // com.obric.aiagent.assistant.idl.IAgentNetworkIDL
            public void updateExcludeRules(RequestRestrictRule r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r100 == null) goto L6;
                r101.writeInt(1);     // Catch: Throwable -> L16
                r100.writeToParcel(r101, 0);     // Catch: Throwable -> L16
            L8:
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IAgentNetworkIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r101, null, 1) == false) goto L10;
            L14:
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().updateExcludeRules(r100);     // Catch: Throwable -> L16
                r101.recycle();
                return;
            L6:
                r101.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentNetworkIDL
            public void notifyRequestStatus(boolean r100, Map r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r100 == false) goto L6;
                int r103 = 1;
            L7:
                r102.writeInt(r103);     // Catch: Throwable -> L16
                r102.writeMap(r101);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IAgentNetworkIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r102, null, 1) == false) goto L10;
            L14:
                r102.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().notifyRequestStatus(r100, r101);     // Catch: Throwable -> L16
                r102.recycle();
                return;
            L6:
                r103 = 0;
            L16:
                th = move-exception;
                r102.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IAgentNetworkIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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

        public static IAgentNetworkIDL getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static IAgentNetworkIDL asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof IAgentNetworkIDL) == false) goto L12;
            return (IAgentNetworkIDL) r101;
        L12:
            return new Proxy(r100);
        }

        public static boolean setDefaultImpl(IAgentNetworkIDL r100) {
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
            if (r100 != 1) goto L5;
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L21;
            boolean r104 = true;
        L22:
            notifyRequestStatus(r104, r101.readHashMap(getClass().getClassLoader()));
            return true;
        L21:
            r104 = false;
            goto L22
        L5:
            if (r100 != 2) goto L7;
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L15;
            RequestRestrictRule r105 = RequestRestrictRule.CREATOR.createFromParcel(r101);
        L16:
            updateExcludeRules(r105);
            return true;
        L15:
            r105 = null;
            goto L16
        L7:
            if (r100 != 1598968902) goto L9;
            r102.writeString(DESCRIPTOR);
            return true;
        L9:
            return super.onTransact(r100, r101, r102, r103);
        }
    }

    void notifyRequestStatus(boolean r100, Map r101) throws RemoteException;

    void updateExcludeRules(RequestRestrictRule r100) throws RemoteException;
}
