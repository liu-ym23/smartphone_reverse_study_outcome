package com.obric.aiagent.assistant.idl;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aiagent.assistant.idl.bean.OSkill;
import com.obric.aiagent.assistant.idl.bean.OSkillManagerConfig;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import java.util.ArrayList;
import java.util.List;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes4.dex */
public interface IAgentSkillManagerIDL extends IInterface {

    /* JADX INFO: loaded from: classes6.dex */
    public static class Default implements IAgentSkillManagerIDL {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentSkillManagerIDL
        public long getSkillListVersion() throws RemoteException {
            return 0;
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentSkillManagerIDL
        public OSkillManagerConfig getSkillManagerConfig() throws RemoteException {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentSkillManagerIDL
        public String getSkillManagerStatus(String r100) throws RemoteException {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentSkillManagerIDL
        public List<OSkill> listSkills() throws RemoteException {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentSkillManagerIDL
        public void registerSkillObserver(IAgentSkillManagerObserverIDL r100) throws RemoteException {
        }

        @Override // com.obric.aiagent.assistant.idl.IAgentSkillManagerIDL
        public boolean setSkillManagerConfigValues(Bundle r100) throws RemoteException {
            return false;
        }
    }

    public static abstract class Stub extends Binder implements IAgentSkillManagerIDL {
        private static final String DESCRIPTOR = "com.obric.aiagent.assistant.idl.IAgentSkillManagerIDL";
        static final int TRANSACTION_getSkillListVersion = 2;
        static final int TRANSACTION_getSkillManagerConfig = 7;
        static final int TRANSACTION_getSkillManagerStatus = 9;
        static final int TRANSACTION_listSkills = 1;
        static final int TRANSACTION_registerSkillObserver = 3;
        static final int TRANSACTION_setSkillManagerConfigValues = 8;

        public static class Proxy implements IAgentSkillManagerIDL {
            public static IAgentSkillManagerIDL sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentSkillManagerIDL
            public long getSkillListVersion() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IAgentSkillManagerIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L13
                long r102 = r101.readLong();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r102;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                long r103 = Stub.getDefaultImpl().getSkillListVersion();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r103;
            L13:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentSkillManagerIDL
            public OSkillManagerConfig getSkillManagerConfig() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IAgentSkillManagerIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 7, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L17
                if (r101.readInt() == 0) goto L14;
                OSkillManagerConfig r102 = OSkillManagerConfig.CREATOR.createFromParcel(r101);     // Catch: Throwable -> L17
            L15:
                r101.recycle();
                r100.recycle();
                return r102;
            L14:
                r102 = null;
                goto L15
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                OSkillManagerConfig r103 = Stub.getDefaultImpl().getSkillManagerConfig();     // Catch: Throwable -> L17
                r101.recycle();
                r100.recycle();
                return r103;
            L17:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentSkillManagerIDL
            public List<OSkill> listSkills() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IAgentSkillManagerIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L13
                ArrayList r102 = r101.createTypedArrayList(OSkill.CREATOR);     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r102;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                List<OSkill> r103 = Stub.getDefaultImpl().listSkills();     // Catch: Throwable -> L13
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

            @Override // com.obric.aiagent.assistant.idl.IAgentSkillManagerIDL
            public String getSkillManagerStatus(String r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r101.writeString(r100);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IAgentSkillManagerIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 9, r101, r102, 0) == false) goto L6;
            L10:
                r102.readException();     // Catch: Throwable -> L13
                String r103 = r102.readString();     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return r103;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                String r104 = Stub.getDefaultImpl().getSkillManagerStatus(r100);     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return r104;
            L13:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentSkillManagerIDL
            public void registerSkillObserver(IAgentSkillManagerObserverIDL r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r100 == null) goto L6;
                IBinder r102 = r100.asBinder();     // Catch: Throwable -> L16
            L7:
                r101.writeStrongBinder(r102);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IAgentSkillManagerIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r101, null, 1) == false) goto L10;
            L14:
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().registerSkillObserver(r100);     // Catch: Throwable -> L16
                r101.recycle();
                return;
            L6:
                r102 = null;
            L16:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Override // com.obric.aiagent.assistant.idl.IAgentSkillManagerIDL
            public boolean setSkillManagerConfigValues(Bundle r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L20
                boolean r103 = true;
                if (r100 == null) goto L6;
                r101.writeInt(1);     // Catch: Throwable -> L20
                r100.writeToParcel(r101, 0);     // Catch: Throwable -> L20
            L8:
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IAgentSkillManagerIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 8, r101, r102, 0) == false) goto L10;
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
                boolean r104 = Stub.getDefaultImpl().setSkillManagerConfigValues(r100);     // Catch: Throwable -> L20
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

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IAgentSkillManagerIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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

        public static IAgentSkillManagerIDL getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static IAgentSkillManagerIDL asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof IAgentSkillManagerIDL) == false) goto L12;
            return (IAgentSkillManagerIDL) r101;
        L12:
            return new Proxy(r100);
        }

        public static boolean setDefaultImpl(IAgentSkillManagerIDL r100) {
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
            List<OSkill> r104 = listSkills();
            r102.writeNoException();
            r102.writeTypedList(r104);
            return true;
        L5:
            if (r100 != 2) goto L7;
            r101.enforceInterface(DESCRIPTOR);
            long r105 = getSkillListVersion();
            r102.writeNoException();
            r102.writeLong(r105);
            return true;
        L7:
            if (r100 != 3) goto L9;
            r101.enforceInterface(DESCRIPTOR);
            registerSkillObserver(IAgentSkillManagerObserverIDL.Stub.asInterface(r101.readStrongBinder()));
            return true;
        L9:
            if (r100 != 7) goto L11;
            r101.enforceInterface(DESCRIPTOR);
            OSkillManagerConfig r106 = getSkillManagerConfig();
            r102.writeNoException();
            if (r106 == null) goto L31;
            r102.writeInt(1);
            r106.writeToParcel(r102, 1);
        L32:
            return true;
        L31:
            r102.writeInt(0);
            goto L32
        L11:
            if (r100 != 8) goto L13;
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L25;
            Bundle r107 = (Bundle) Bundle.CREATOR.createFromParcel(r101);
        L26:
            boolean r108 = setSkillManagerConfigValues(r107);
            r102.writeNoException();
            r102.writeInt(r108 ? 1 : 0);
            return true;
        L25:
            r107 = null;
            goto L26
        L13:
            if (r100 != 9) goto L15;
            r101.enforceInterface(DESCRIPTOR);
            String r109 = getSkillManagerStatus(r101.readString());
            r102.writeNoException();
            r102.writeString(r109);
            return true;
        L15:
            if (r100 != 1598968902) goto L17;
            r102.writeString(DESCRIPTOR);
            return true;
        L17:
            return super.onTransact(r100, r101, r102, r103);
        }
    }

    long getSkillListVersion() throws RemoteException;

    OSkillManagerConfig getSkillManagerConfig() throws RemoteException;

    String getSkillManagerStatus(String r100) throws RemoteException;

    List<OSkill> listSkills() throws RemoteException;

    void registerSkillObserver(IAgentSkillManagerObserverIDL r100) throws RemoteException;

    boolean setSkillManagerConfigValues(Bundle r100) throws RemoteException;
}
