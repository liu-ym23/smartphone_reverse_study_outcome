package com.hihonor.mcs.system.diagnosis.core;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.hihonor.mcs.system.diagnosis.core.resource.IPowerUsageCallback;
import com.hihonor.mcs.system.diagnosis.core.status.DexoptStatus;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import java.util.ArrayList;
import java.util.List;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes23.dex */
public interface IDiagKitInterface extends IInterface {

    public static class Default implements IDiagKitInterface {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.hihonor.mcs.system.diagnosis.core.IDiagKitInterface
        public String getServiceVersion() {
            return null;
        }

        @Override // com.hihonor.mcs.system.diagnosis.core.IDiagKitInterface
        public void pushAarVersionToService(String r100) {
        }

        @Override // com.hihonor.mcs.system.diagnosis.core.IDiagKitInterface
        public List<DexoptStatus> queryDexoptStatus() {
            return null;
        }

        @Override // com.hihonor.mcs.system.diagnosis.core.IDiagKitInterface
        public void queryPowerUsage(long r100, long r101, IPowerUsageCallback r102) {
        }

        @Override // com.hihonor.mcs.system.diagnosis.core.IDiagKitInterface
        public void registerPerformancePayload(List<String> r100, ICallbackPayload r101) {
        }

        @Override // com.hihonor.mcs.system.diagnosis.core.IDiagKitInterface
        public void registerPowerThermalPayload(List<String> r100, ICallbackPayload r101) {
        }

        @Override // com.hihonor.mcs.system.diagnosis.core.IDiagKitInterface
        public void registerPressurePayload(List<String> r100, IPressureCallbackPayload r101) {
        }

        @Override // com.hihonor.mcs.system.diagnosis.core.IDiagKitInterface
        public void registerStabilityPayload(List<String> r100, ICallbackPayload r101) {
        }

        @Override // com.hihonor.mcs.system.diagnosis.core.IDiagKitInterface
        public void unregisterPerformancePayload(ICallbackPayload r100) {
        }

        @Override // com.hihonor.mcs.system.diagnosis.core.IDiagKitInterface
        public void unregisterPowerThermalPayload(ICallbackPayload r100) {
        }

        @Override // com.hihonor.mcs.system.diagnosis.core.IDiagKitInterface
        public void unregisterPressurePayload(IPressureCallbackPayload r100) {
        }

        @Override // com.hihonor.mcs.system.diagnosis.core.IDiagKitInterface
        public void unregisterStabilityPayload(ICallbackPayload r100) {
        }
    }

    public static abstract class Stub extends Binder implements IDiagKitInterface {
        private static final String DESCRIPTOR = "com.hihonor.mcs.system.diagnosis.core.IDiagKitInterface";
        static final int TRANSACTION_getServiceVersion = 9;
        static final int TRANSACTION_pushAarVersionToService = 10;
        static final int TRANSACTION_queryDexoptStatus = 12;
        static final int TRANSACTION_queryPowerUsage = 11;
        static final int TRANSACTION_registerPerformancePayload = 3;
        static final int TRANSACTION_registerPowerThermalPayload = 5;
        static final int TRANSACTION_registerPressurePayload = 7;
        static final int TRANSACTION_registerStabilityPayload = 1;
        static final int TRANSACTION_unregisterPerformancePayload = 4;
        static final int TRANSACTION_unregisterPowerThermalPayload = 6;
        static final int TRANSACTION_unregisterPressurePayload = 8;
        static final int TRANSACTION_unregisterStabilityPayload = 2;

        public static class Proxy implements IDiagKitInterface {
            public static IDiagKitInterface sDefaultImpl;
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

            @Override // com.hihonor.mcs.system.diagnosis.core.IDiagKitInterface
            public String getServiceVersion() {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_hihonor_mcs_system_diagnosis_core_IDiagKitInterface$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 9, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L13
                String r102 = r101.readString();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r102;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                String r103 = Stub.getDefaultImpl().getServiceVersion();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r103;
            L13:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.hihonor.mcs.system.diagnosis.core.IDiagKitInterface
            public void pushAarVersionToService(String r100) {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r101.writeString(r100);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_hihonor_mcs_system_diagnosis_core_IDiagKitInterface$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 10, r101, r102, 0) == false) goto L6;
            L10:
                r102.readException();     // Catch: Throwable -> L12
            L8:
                r102.recycle();
                r101.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().pushAarVersionToService(r100);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.hihonor.mcs.system.diagnosis.core.IDiagKitInterface
            public List<DexoptStatus> queryDexoptStatus() {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_hihonor_mcs_system_diagnosis_core_IDiagKitInterface$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 12, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L13
                ArrayList r102 = r101.createTypedArrayList(DexoptStatus.CREATOR);     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r102;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                List<DexoptStatus> r103 = Stub.getDefaultImpl().queryDexoptStatus();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r103;
            L13:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.hihonor.mcs.system.diagnosis.core.IDiagKitInterface
            public void queryPowerUsage(long r110, long r111, IPowerUsageCallback r112) {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r100.writeLong(r110);     // Catch: Throwable -> L16
                r100.writeLong(r111);     // Catch: Throwable -> L16
                if (r112 == null) goto L6;
                IBinder r102 = r112.asBinder();     // Catch: Throwable -> L16
            L7:
                r100.writeStrongBinder(r102);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_com_hihonor_mcs_system_diagnosis_core_IDiagKitInterface$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 11, r100, r101, 0) == false) goto L10;
            L14:
                r101.readException();     // Catch: Throwable -> L16
            L12:
                r101.recycle();
                r100.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().queryPowerUsage(r110, r111, r112);     // Catch: Throwable -> L16
                goto L12
            L6:
                r102 = null;
            L16:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.hihonor.mcs.system.diagnosis.core.IDiagKitInterface
            public void registerPerformancePayload(List<String> r100, ICallbackPayload r101) {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r102.writeStringList(r100);     // Catch: Throwable -> L16
                if (r101 == null) goto L6;
                IBinder r104 = r101.asBinder();     // Catch: Throwable -> L16
            L7:
                r102.writeStrongBinder(r104);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_com_hihonor_mcs_system_diagnosis_core_IDiagKitInterface$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r102, r103, 0) == false) goto L10;
            L14:
                r103.readException();     // Catch: Throwable -> L16
            L12:
                r103.recycle();
                r102.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().registerPerformancePayload(r100, r101);     // Catch: Throwable -> L16
                goto L12
            L6:
                r104 = null;
            L16:
                th = move-exception;
                r103.recycle();
                r102.recycle();
                throw th;
            }

            @Override // com.hihonor.mcs.system.diagnosis.core.IDiagKitInterface
            public void registerPowerThermalPayload(List<String> r100, ICallbackPayload r101) {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r102.writeStringList(r100);     // Catch: Throwable -> L16
                if (r101 == null) goto L6;
                IBinder r104 = r101.asBinder();     // Catch: Throwable -> L16
            L7:
                r102.writeStrongBinder(r104);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_com_hihonor_mcs_system_diagnosis_core_IDiagKitInterface$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 5, r102, r103, 0) == false) goto L10;
            L14:
                r103.readException();     // Catch: Throwable -> L16
            L12:
                r103.recycle();
                r102.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().registerPowerThermalPayload(r100, r101);     // Catch: Throwable -> L16
                goto L12
            L6:
                r104 = null;
            L16:
                th = move-exception;
                r103.recycle();
                r102.recycle();
                throw th;
            }

            @Override // com.hihonor.mcs.system.diagnosis.core.IDiagKitInterface
            public void registerPressurePayload(List<String> r100, IPressureCallbackPayload r101) {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r102.writeStringList(r100);     // Catch: Throwable -> L16
                if (r101 == null) goto L6;
                IBinder r104 = r101.asBinder();     // Catch: Throwable -> L16
            L7:
                r102.writeStrongBinder(r104);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_com_hihonor_mcs_system_diagnosis_core_IDiagKitInterface$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 7, r102, r103, 0) == false) goto L10;
            L14:
                r103.readException();     // Catch: Throwable -> L16
            L12:
                r103.recycle();
                r102.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().registerPressurePayload(r100, r101);     // Catch: Throwable -> L16
                goto L12
            L6:
                r104 = null;
            L16:
                th = move-exception;
                r103.recycle();
                r102.recycle();
                throw th;
            }

            @Override // com.hihonor.mcs.system.diagnosis.core.IDiagKitInterface
            public void registerStabilityPayload(List<String> r100, ICallbackPayload r101) {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r102.writeStringList(r100);     // Catch: Throwable -> L16
                if (r101 == null) goto L6;
                IBinder r104 = r101.asBinder();     // Catch: Throwable -> L16
            L7:
                r102.writeStrongBinder(r104);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_com_hihonor_mcs_system_diagnosis_core_IDiagKitInterface$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r102, r103, 0) == false) goto L10;
            L14:
                r103.readException();     // Catch: Throwable -> L16
            L12:
                r103.recycle();
                r102.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().registerStabilityPayload(r100, r101);     // Catch: Throwable -> L16
                goto L12
            L6:
                r104 = null;
            L16:
                th = move-exception;
                r103.recycle();
                r102.recycle();
                throw th;
            }

            @Override // com.hihonor.mcs.system.diagnosis.core.IDiagKitInterface
            public void unregisterPerformancePayload(ICallbackPayload r100) {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r100 == null) goto L6;
                IBinder r103 = r100.asBinder();     // Catch: Throwable -> L16
            L7:
                r101.writeStrongBinder(r103);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_com_hihonor_mcs_system_diagnosis_core_IDiagKitInterface$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r101, r102, 0) == false) goto L10;
            L14:
                r102.readException();     // Catch: Throwable -> L16
            L12:
                r102.recycle();
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().unregisterPerformancePayload(r100);     // Catch: Throwable -> L16
                goto L12
            L6:
                r103 = null;
            L16:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.hihonor.mcs.system.diagnosis.core.IDiagKitInterface
            public void unregisterPowerThermalPayload(ICallbackPayload r100) {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r100 == null) goto L6;
                IBinder r103 = r100.asBinder();     // Catch: Throwable -> L16
            L7:
                r101.writeStrongBinder(r103);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_com_hihonor_mcs_system_diagnosis_core_IDiagKitInterface$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 6, r101, r102, 0) == false) goto L10;
            L14:
                r102.readException();     // Catch: Throwable -> L16
            L12:
                r102.recycle();
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().unregisterPowerThermalPayload(r100);     // Catch: Throwable -> L16
                goto L12
            L6:
                r103 = null;
            L16:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.hihonor.mcs.system.diagnosis.core.IDiagKitInterface
            public void unregisterPressurePayload(IPressureCallbackPayload r100) {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r100 == null) goto L6;
                IBinder r103 = r100.asBinder();     // Catch: Throwable -> L16
            L7:
                r101.writeStrongBinder(r103);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_com_hihonor_mcs_system_diagnosis_core_IDiagKitInterface$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 8, r101, r102, 0) == false) goto L10;
            L14:
                r102.readException();     // Catch: Throwable -> L16
            L12:
                r102.recycle();
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().unregisterPressurePayload(r100);     // Catch: Throwable -> L16
                goto L12
            L6:
                r103 = null;
            L16:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.hihonor.mcs.system.diagnosis.core.IDiagKitInterface
            public void unregisterStabilityPayload(ICallbackPayload r100) {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r100 == null) goto L6;
                IBinder r103 = r100.asBinder();     // Catch: Throwable -> L16
            L7:
                r101.writeStrongBinder(r103);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_com_hihonor_mcs_system_diagnosis_core_IDiagKitInterface$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r101, r102, 0) == false) goto L10;
            L14:
                r102.readException();     // Catch: Throwable -> L16
            L12:
                r102.recycle();
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().unregisterStabilityPayload(r100);     // Catch: Throwable -> L16
                goto L12
            L6:
                r103 = null;
            L16:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_hihonor_mcs_system_diagnosis_core_IDiagKitInterface$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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

        public static IDiagKitInterface asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof IDiagKitInterface) == false) goto L12;
            return (IDiagKitInterface) r101;
        L12:
            return new Proxy(r100);
        }

        public static IDiagKitInterface getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IDiagKitInterface r100) {
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
        public boolean onTransact(int r100, Parcel r110, Parcel r111, int r112) {
            if (r100 == 1598968902) goto L31;
            switch(r100) {
                case 1: goto L29;
                case 2: goto L27;
                case 3: goto L25;
                case 4: goto L23;
                case 5: goto L21;
                case 6: goto L19;
                case 7: goto L17;
                case 8: goto L15;
                case 9: goto L13;
                case 10: goto L11;
                case 11: goto L9;
                case 12: goto L7;
                default: goto L6;
            };
        L7:
            r110.enforceInterface(DESCRIPTOR);
            List<DexoptStatus> r101 = queryDexoptStatus();
            r111.writeNoException();
            r111.writeTypedList(r101);
            return true;
        L9:
            r110.enforceInterface(DESCRIPTOR);
            queryPowerUsage(r110.readLong(), r110.readLong(), IPowerUsageCallback.Stub.asInterface(r110.readStrongBinder()));
            r111.writeNoException();
            return true;
        L11:
            r110.enforceInterface(DESCRIPTOR);
            pushAarVersionToService(r110.readString());
            r111.writeNoException();
            return true;
        L13:
            r110.enforceInterface(DESCRIPTOR);
            String r102 = getServiceVersion();
            r111.writeNoException();
            r111.writeString(r102);
            return true;
        L15:
            r110.enforceInterface(DESCRIPTOR);
            unregisterPressurePayload(IPressureCallbackPayload.Stub.asInterface(r110.readStrongBinder()));
            r111.writeNoException();
            return true;
        L17:
            r110.enforceInterface(DESCRIPTOR);
            registerPressurePayload(r110.createStringArrayList(), IPressureCallbackPayload.Stub.asInterface(r110.readStrongBinder()));
            r111.writeNoException();
            return true;
        L19:
            r110.enforceInterface(DESCRIPTOR);
            unregisterPowerThermalPayload(ICallbackPayload.Stub.asInterface(r110.readStrongBinder()));
            r111.writeNoException();
            return true;
        L21:
            r110.enforceInterface(DESCRIPTOR);
            registerPowerThermalPayload(r110.createStringArrayList(), ICallbackPayload.Stub.asInterface(r110.readStrongBinder()));
            r111.writeNoException();
            return true;
        L23:
            r110.enforceInterface(DESCRIPTOR);
            unregisterPerformancePayload(ICallbackPayload.Stub.asInterface(r110.readStrongBinder()));
            r111.writeNoException();
            return true;
        L25:
            r110.enforceInterface(DESCRIPTOR);
            registerPerformancePayload(r110.createStringArrayList(), ICallbackPayload.Stub.asInterface(r110.readStrongBinder()));
            r111.writeNoException();
            return true;
        L27:
            r110.enforceInterface(DESCRIPTOR);
            unregisterStabilityPayload(ICallbackPayload.Stub.asInterface(r110.readStrongBinder()));
            r111.writeNoException();
            return true;
        L29:
            r110.enforceInterface(DESCRIPTOR);
            registerStabilityPayload(r110.createStringArrayList(), ICallbackPayload.Stub.asInterface(r110.readStrongBinder()));
            r111.writeNoException();
            return true;
        L6:
            return super.onTransact(r100, r110, r111, r112);
        L31:
            r111.writeString(DESCRIPTOR);
            return true;
        }
    }

    String getServiceVersion();

    void pushAarVersionToService(String r100);

    List<DexoptStatus> queryDexoptStatus();

    void queryPowerUsage(long r100, long r101, IPowerUsageCallback r102);

    void registerPerformancePayload(List<String> r100, ICallbackPayload r101);

    void registerPowerThermalPayload(List<String> r100, ICallbackPayload r101);

    void registerPressurePayload(List<String> r100, IPressureCallbackPayload r101);

    void registerStabilityPayload(List<String> r100, ICallbackPayload r101);

    void unregisterPerformancePayload(ICallbackPayload r100);

    void unregisterPowerThermalPayload(ICallbackPayload r100);

    void unregisterPressurePayload(IPressureCallbackPayload r100);

    void unregisterStabilityPayload(ICallbackPayload r100);
}
