package com.obric.cae.libs.useraware;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import com.obric.cae.libs.bluetooth.ISmartBluetoothEventCallback;
import java.util.List;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes33.dex */
public interface ICaeUserAware extends IInterface {
    public static final int ENTER_COMPANY_GEOFENCE_EVENT = 3;
    public static final int ENTER_HOME_GEOFENCE_EVENT = 1;
    public static final int EXIT_COMPANY_GEOFENCE_EVENT = 4;
    public static final int EXIT_HOEM_GEOFENCE_EVENT = 2;
    public static final int LEVEL1_MODEL_RESULT = 1;
    public static final int LEVEL2_MODEL_RESULT = 2;
    public static final int MASK_SCAN_AUDIO = 16;
    public static final int MASK_SCAN_BT = 2;
    public static final int MASK_SCAN_CELL = 4;
    public static final int MASK_SCAN_LOCATION = 8;
    public static final int MASK_SCAN_WIFI = 1;
    public static final int MASK_SENSOR_ACCELEROMETER = 32;
    public static final int MASK_SENSOR_GYROSCOPE = 128;
    public static final int MASK_SENSOR_LIGHT = 1024;
    public static final int MASK_SENSOR_LINEAR_ACCELERATION = 64;
    public static final int MASK_SENSOR_MAGNETIC_FIELD = 256;
    public static final int MASK_SENSOR_ORIENTATION = 8192;
    public static final int MASK_SENSOR_OUT_ELEVATOR = 4096;
    public static final int MASK_SENSOR_PRESSURE = 2048;
    public static final int MASK_SENSOR_PROXIMITY = 16384;
    public static final int MASK_SENSOR_ROTATION_MATRIX = 32768;
    public static final int MASK_SENSOR_STEP_COUNTER = 512;
    public static final int PREDICTED_ENTER_ROOM_EVENT = 1;
    public static final int PREDICTED_EXIT_ROOM_EVENT = 2;
    public static final String USER_AWARE_REPORT_HAR_FEEDBACK_INFO = "useraware_HAR_feedback_info";
    public static final String USER_AWARE_REPORT_HAR_STATE_INFO = "useraware_HAR_state_info";
    public static final String USER_AWARE_REPORT_NEAR_ELEVATOR_INFO = "useraware_near_elevator_info";
    public static final String USER_AWARE_REPORT_STAR_GEOFENCE_INFO = "useraware_star_geofence_info";
    public static final String USER_AWARE_REPORT_STAR_ZPP_INFO = "useraware_star_zpp_info";
    public static final String USER_AWARE_REPORT_USER_FEEDBACK_INFO = "useraware_user_feedback_info";
    public static final String USER_AWARE_REPORT_WIFI_CONNECT_INFO = "useraware_wifi_conn_info";
    public static final String USER_AWARE_REPORT_WIFI_PNO_STATS = "useraware_wifi_pno_stats";
    public static final String USER_AWARE_REPORT_WIFI_SCAN_COUNT = "useraware_wifi_scan_count";
    public static final String USER_AWARE_REPORT_WIFI_SCAN_INFO = "useraware_wifi_scan_info";

    public static class Default implements ICaeUserAware {
        public Default() {
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAware
        public void addBssidsToAvoidRomingScan(List<String> r100) throws RemoteException {
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAware
        public void addHomeWifiBssids(List<String> r100) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAware
        public void clearHomeWifiBssids() throws RemoteException {
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAware
        public HarMonitorParams getHarMonitorParams() throws RemoteException {
            return null;
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAware
        public void notifyGeofenceChanged(int r100) throws RemoteException {
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAware
        public void notifyHarEvent(HarEventData r100) throws RemoteException {
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAware
        public void notifyLearningSuccess(boolean r100) throws RemoteException {
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAware
        public void notifyRoomChangedPredicted(int r100) throws RemoteException {
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAware
        public void registerCallback(ICaeUserAwareCallback r100) throws RemoteException {
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAware
        public void registerSmartBluetoothEvent(ISmartBluetoothEventCallback r100) throws RemoteException {
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAware
        public void setHarMonitorParams(HarMonitorParams r100) throws RemoteException {
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAware
        public void setHarState(int r100, long r101, int r102) throws RemoteException {
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAware
        public void setLevel2DataCollection(List<HarLevel2DataReq> r100, int r101, HarLevel2DataResp r102) throws RemoteException {
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAware
        public void setWifiRssiTriggerThresholds(int r100, int r101, int r102, int r103, int r104) throws RemoteException {
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAware
        public void unregisterCallback(ICaeUserAwareCallback r100) throws RemoteException {
        }

        @Override // com.obric.cae.libs.useraware.ICaeUserAware
        public void unregisterSmartBluetoothEvent(ISmartBluetoothEventCallback r100) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements ICaeUserAware {
        private static final String DESCRIPTOR = "com.obric.cae.libs.useraware.ICaeUserAware";
        static final int TRANSACTION_addBssidsToAvoidRomingScan = 7;
        static final int TRANSACTION_addHomeWifiBssids = 3;
        static final int TRANSACTION_clearHomeWifiBssids = 4;
        static final int TRANSACTION_getHarMonitorParams = 13;
        static final int TRANSACTION_notifyGeofenceChanged = 6;
        static final int TRANSACTION_notifyHarEvent = 14;
        static final int TRANSACTION_notifyLearningSuccess = 16;
        static final int TRANSACTION_notifyRoomChangedPredicted = 5;
        static final int TRANSACTION_registerCallback = 1;
        static final int TRANSACTION_registerSmartBluetoothEvent = 10;
        static final int TRANSACTION_setHarMonitorParams = 12;
        static final int TRANSACTION_setHarState = 8;
        static final int TRANSACTION_setLevel2DataCollection = 9;
        static final int TRANSACTION_setWifiRssiTriggerThresholds = 15;
        static final int TRANSACTION_unregisterCallback = 2;
        static final int TRANSACTION_unregisterSmartBluetoothEvent = 11;

        public static class Proxy implements ICaeUserAware {
            public static ICaeUserAware sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.obric.cae.libs.useraware.ICaeUserAware
            public void clearHomeWifiBssids() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_cae_libs_useraware_ICaeUserAware$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().clearHomeWifiBssids();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return;
            L13:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.useraware.ICaeUserAware
            public HarMonitorParams getHarMonitorParams() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_obric_cae_libs_useraware_ICaeUserAware$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 13, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L17
                if (r101.readInt() == 0) goto L14;
                HarMonitorParams r102 = HarMonitorParams.CREATOR.createFromParcel(r101);     // Catch: Throwable -> L17
            L15:
                r101.recycle();
                r100.recycle();
                return r102;
            L14:
                r102 = null;
                goto L15
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                HarMonitorParams r103 = Stub.getDefaultImpl().getHarMonitorParams();     // Catch: Throwable -> L17
                r101.recycle();
                r100.recycle();
                return r103;
            L17:
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

            @Override // com.obric.cae.libs.useraware.ICaeUserAware
            public void addBssidsToAvoidRomingScan(List<String> r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r101.writeStringList(r100);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_cae_libs_useraware_ICaeUserAware$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 7, r101, r102, 0) == false) goto L6;
            L10:
                r102.readException();     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().addBssidsToAvoidRomingScan(r100);     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return;
            L13:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.useraware.ICaeUserAware
            public void addHomeWifiBssids(List<String> r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r101.writeStringList(r100);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_cae_libs_useraware_ICaeUserAware$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r101, r102, 0) == false) goto L6;
            L10:
                r102.readException();     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().addHomeWifiBssids(r100);     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return;
            L13:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.useraware.ICaeUserAware
            public void notifyGeofenceChanged(int r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r101.writeInt(r100);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_cae_libs_useraware_ICaeUserAware$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 6, r101, r102, 0) == false) goto L6;
            L10:
                r102.readException();     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().notifyGeofenceChanged(r100);     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return;
            L13:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.useraware.ICaeUserAware
            public void notifyHarEvent(HarEventData r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r100 == null) goto L6;
                r101.writeInt(1);     // Catch: Throwable -> L17
                r100.writeToParcel(r101, 0);     // Catch: Throwable -> L17
            L8:
                if (INVOKEINTERFACE_com_obric_cae_libs_useraware_ICaeUserAware$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 14, r101, r102, 0) == false) goto L10;
            L14:
                r102.readException();     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().notifyHarEvent(r100);     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return;
            L6:
                r101.writeInt(0);     // Catch: Throwable -> L17
            L17:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.useraware.ICaeUserAware
            public void notifyLearningSuccess(boolean r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r101.writeInt(r100 ? 1 : 0);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_cae_libs_useraware_ICaeUserAware$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 16, r101, r102, 0) == false) goto L6;
            L10:
                r102.readException();     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().notifyLearningSuccess(r100);     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return;
            L13:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.useraware.ICaeUserAware
            public void notifyRoomChangedPredicted(int r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r101.writeInt(r100);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_cae_libs_useraware_ICaeUserAware$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 5, r101, r102, 0) == false) goto L6;
            L10:
                r102.readException();     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().notifyRoomChangedPredicted(r100);     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return;
            L13:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.useraware.ICaeUserAware
            public void registerCallback(ICaeUserAwareCallback r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r100 == null) goto L6;
                IBinder r103 = r100.asBinder();     // Catch: Throwable -> L17
            L7:
                r101.writeStrongBinder(r103);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_obric_cae_libs_useraware_ICaeUserAware$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r101, r102, 0) == false) goto L10;
            L14:
                r102.readException();     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().registerCallback(r100);     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return;
            L6:
                r103 = null;
            L17:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.useraware.ICaeUserAware
            public void registerSmartBluetoothEvent(ISmartBluetoothEventCallback r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r100 == null) goto L6;
                IBinder r103 = r100.asBinder();     // Catch: Throwable -> L17
            L7:
                r101.writeStrongBinder(r103);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_obric_cae_libs_useraware_ICaeUserAware$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 10, r101, r102, 0) == false) goto L10;
            L14:
                r102.readException();     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().registerSmartBluetoothEvent(r100);     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return;
            L6:
                r103 = null;
            L17:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.useraware.ICaeUserAware
            public void setHarMonitorParams(HarMonitorParams r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r100 == null) goto L6;
                r101.writeInt(1);     // Catch: Throwable -> L17
                r100.writeToParcel(r101, 0);     // Catch: Throwable -> L17
            L8:
                if (INVOKEINTERFACE_com_obric_cae_libs_useraware_ICaeUserAware$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 12, r101, r102, 0) == false) goto L10;
            L14:
                r102.readException();     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().setHarMonitorParams(r100);     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return;
            L6:
                r101.writeInt(0);     // Catch: Throwable -> L17
            L17:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.useraware.ICaeUserAware
            public void unregisterCallback(ICaeUserAwareCallback r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r100 == null) goto L6;
                IBinder r103 = r100.asBinder();     // Catch: Throwable -> L17
            L7:
                r101.writeStrongBinder(r103);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_obric_cae_libs_useraware_ICaeUserAware$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r101, r102, 0) == false) goto L10;
            L14:
                r102.readException();     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().unregisterCallback(r100);     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return;
            L6:
                r103 = null;
            L17:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.useraware.ICaeUserAware
            public void unregisterSmartBluetoothEvent(ISmartBluetoothEventCallback r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r100 == null) goto L6;
                IBinder r103 = r100.asBinder();     // Catch: Throwable -> L17
            L7:
                r101.writeStrongBinder(r103);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_obric_cae_libs_useraware_ICaeUserAware$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 11, r101, r102, 0) == false) goto L10;
            L14:
                r102.readException();     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().unregisterSmartBluetoothEvent(r100);     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return;
            L6:
                r103 = null;
            L17:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.useraware.ICaeUserAware
            public void setHarState(int r100, long r101, int r102) throws RemoteException {
                Parcel r103 = Parcel.obtain();
                Parcel r104 = Parcel.obtain();
                r103.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r103.writeInt(r100);     // Catch: Throwable -> L13
                r103.writeLong(r101);     // Catch: Throwable -> L13
                r103.writeInt(r102);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_cae_libs_useraware_ICaeUserAware$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 8, r103, r104, 0) == false) goto L6;
            L10:
                r104.readException();     // Catch: Throwable -> L13
                r104.recycle();
                r103.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().setHarState(r100, r101, r102);     // Catch: Throwable -> L13
                r104.recycle();
                r103.recycle();
                return;
            L13:
                th = move-exception;
                r104.recycle();
                r103.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.useraware.ICaeUserAware
            public void setLevel2DataCollection(List<HarLevel2DataReq> r100, int r101, HarLevel2DataResp r102) throws RemoteException {
                Parcel r103 = Parcel.obtain();
                Parcel r104 = Parcel.obtain();
                r103.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r103.writeTypedList(r100);     // Catch: Throwable -> L17
                r103.writeInt(r101);     // Catch: Throwable -> L17
                if (r102 == null) goto L6;
                IBinder r105 = r102.asBinder();     // Catch: Throwable -> L17
            L7:
                r103.writeStrongBinder(r105);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_obric_cae_libs_useraware_ICaeUserAware$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 9, r103, r104, 0) == false) goto L10;
            L14:
                r104.readException();     // Catch: Throwable -> L17
                r104.recycle();
                r103.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().setLevel2DataCollection(r100, r101, r102);     // Catch: Throwable -> L17
                r104.recycle();
                r103.recycle();
                return;
            L6:
                r105 = null;
            L17:
                th = move-exception;
                r104.recycle();
                r103.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_obric_cae_libs_useraware_ICaeUserAware$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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

            @Override // com.obric.cae.libs.useraware.ICaeUserAware
            public void setWifiRssiTriggerThresholds(int r110, int r111, int r112, int r113, int r114) throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r100.writeInt(r110);     // Catch: Throwable -> L13
                r100.writeInt(r111);     // Catch: Throwable -> L13
                r100.writeInt(r112);     // Catch: Throwable -> L13
                r100.writeInt(r113);     // Catch: Throwable -> L13
                r100.writeInt(r114);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_cae_libs_useraware_ICaeUserAware$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 15, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().setWifiRssiTriggerThresholds(r110, r111, r112, r113, r114);     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return;
            L13:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ICaeUserAware getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static ICaeUserAware asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof ICaeUserAware) == false) goto L12;
            return (ICaeUserAware) r101;
        L12:
            return new Proxy(r100);
        }

        public static boolean setDefaultImpl(ICaeUserAware r100) {
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
            if (r100 == 1598968902) goto L52;
            boolean r101 = false;
            HarMonitorParams r102 = null;
            HarEventData r103 = null;
            switch(r100) {
                case 1: goto L50;
                case 2: goto L48;
                case 3: goto L46;
                case 4: goto L44;
                case 5: goto L42;
                case 6: goto L40;
                case 7: goto L38;
                case 8: goto L36;
                case 9: goto L34;
                case 10: goto L32;
                case 11: goto L30;
                case 12: goto L25;
                case 13: goto L20;
                case 14: goto L15;
                case 15: goto L13;
                case 16: goto L8;
                default: goto L7;
            };
        L8:
            r110.enforceInterface(DESCRIPTOR);
            if (r110.readInt() == 0) goto L11;
            r101 = true;
        L11:
            notifyLearningSuccess(r101);
            r111.writeNoException();
            return true;
        L13:
            r110.enforceInterface(DESCRIPTOR);
            setWifiRssiTriggerThresholds(r110.readInt(), r110.readInt(), r110.readInt(), r110.readInt(), r110.readInt());
            r111.writeNoException();
            return true;
        L15:
            r110.enforceInterface(DESCRIPTOR);
            if (r110.readInt() == 0) goto L18;
            r103 = HarEventData.CREATOR.createFromParcel(r110);
        L18:
            notifyHarEvent(r103);
            r111.writeNoException();
            return true;
        L20:
            r110.enforceInterface(DESCRIPTOR);
            HarMonitorParams r104 = getHarMonitorParams();
            r111.writeNoException();
            if (r104 == null) goto L23;
            r111.writeInt(1);
            r104.writeToParcel(r111, 1);
        L24:
            return true;
        L23:
            r111.writeInt(0);
            goto L24
        L25:
            r110.enforceInterface(DESCRIPTOR);
            if (r110.readInt() == 0) goto L28;
            r102 = HarMonitorParams.CREATOR.createFromParcel(r110);
        L28:
            setHarMonitorParams(r102);
            r111.writeNoException();
            return true;
        L30:
            r110.enforceInterface(DESCRIPTOR);
            unregisterSmartBluetoothEvent(ISmartBluetoothEventCallback.Stub.asInterface(r110.readStrongBinder()));
            r111.writeNoException();
            return true;
        L32:
            r110.enforceInterface(DESCRIPTOR);
            registerSmartBluetoothEvent(ISmartBluetoothEventCallback.Stub.asInterface(r110.readStrongBinder()));
            r111.writeNoException();
            return true;
        L34:
            r110.enforceInterface(DESCRIPTOR);
            setLevel2DataCollection(r110.createTypedArrayList(HarLevel2DataReq.CREATOR), r110.readInt(), HarLevel2DataResp.Stub.asInterface(r110.readStrongBinder()));
            r111.writeNoException();
            return true;
        L36:
            r110.enforceInterface(DESCRIPTOR);
            setHarState(r110.readInt(), r110.readLong(), r110.readInt());
            r111.writeNoException();
            return true;
        L38:
            r110.enforceInterface(DESCRIPTOR);
            addBssidsToAvoidRomingScan(r110.createStringArrayList());
            r111.writeNoException();
            return true;
        L40:
            r110.enforceInterface(DESCRIPTOR);
            notifyGeofenceChanged(r110.readInt());
            r111.writeNoException();
            return true;
        L42:
            r110.enforceInterface(DESCRIPTOR);
            notifyRoomChangedPredicted(r110.readInt());
            r111.writeNoException();
            return true;
        L44:
            r110.enforceInterface(DESCRIPTOR);
            clearHomeWifiBssids();
            r111.writeNoException();
            return true;
        L46:
            r110.enforceInterface(DESCRIPTOR);
            addHomeWifiBssids(r110.createStringArrayList());
            r111.writeNoException();
            return true;
        L48:
            r110.enforceInterface(DESCRIPTOR);
            unregisterCallback(ICaeUserAwareCallback.Stub.asInterface(r110.readStrongBinder()));
            r111.writeNoException();
            return true;
        L50:
            r110.enforceInterface(DESCRIPTOR);
            registerCallback(ICaeUserAwareCallback.Stub.asInterface(r110.readStrongBinder()));
            r111.writeNoException();
            return true;
        L7:
            return super.onTransact(r100, r110, r111, r112);
        L52:
            r111.writeString(DESCRIPTOR);
            return true;
        }
    }

    void addBssidsToAvoidRomingScan(List<String> r100) throws RemoteException;

    void addHomeWifiBssids(List<String> r100) throws RemoteException;

    void clearHomeWifiBssids() throws RemoteException;

    HarMonitorParams getHarMonitorParams() throws RemoteException;

    void notifyGeofenceChanged(int r100) throws RemoteException;

    void notifyHarEvent(HarEventData r100) throws RemoteException;

    void notifyLearningSuccess(boolean r100) throws RemoteException;

    void notifyRoomChangedPredicted(int r100) throws RemoteException;

    void registerCallback(ICaeUserAwareCallback r100) throws RemoteException;

    void registerSmartBluetoothEvent(ISmartBluetoothEventCallback r100) throws RemoteException;

    void setHarMonitorParams(HarMonitorParams r100) throws RemoteException;

    void setHarState(int r100, long r101, int r102) throws RemoteException;

    void setLevel2DataCollection(List<HarLevel2DataReq> r100, int r101, HarLevel2DataResp r102) throws RemoteException;

    void setWifiRssiTriggerThresholds(int r100, int r101, int r102, int r103, int r104) throws RemoteException;

    void unregisterCallback(ICaeUserAwareCallback r100) throws RemoteException;

    void unregisterSmartBluetoothEvent(ISmartBluetoothEventCallback r100) throws RemoteException;
}
