package com.obric.cae.libs.location.geofence;

import android.content.ComponentName;
import android.location.Location;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import java.util.ArrayList;
import java.util.List;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes33.dex */
public interface IStarGeofenceManager extends IInterface {

    public static class Default implements IStarGeofenceManager {
        public Default() {
        }

        @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
        public byte addGeofence(StarGeofence r100) throws RemoteException {
            return 0;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
        public byte deleteGeofence(StarGeofence r100) throws RemoteException {
            return 0;
        }

        @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
        public byte deleteGeofenceById(String r100, String r101) throws RemoteException {
            return 0;
        }

        @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
        public StarGeofence findGeofenceById(String r100) throws RemoteException {
            return null;
        }

        @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
        public ComponentName getComponent(String r100) throws RemoteException {
            return null;
        }

        @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
        public String getVendorVersion() throws RemoteException {
            return null;
        }

        @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
        public boolean isStarGeofencesRecovered() throws RemoteException {
            return false;
        }

        @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
        public List<StarGeofence> listGeofences(String r100) throws RemoteException {
            return null;
        }

        @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
        public byte registerComponent(ComponentName r100) throws RemoteException {
            return 0;
        }

        @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
        public void registerGeofenceCallback(String r100, IStarGeofenceCallback r101) throws RemoteException {
        }

        @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
        public void sendDebugEvent(Location r100, int r101, StarGeofence r102) throws RemoteException {
        }

        @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
        public byte unregisterComponent(ComponentName r100) throws RemoteException {
            return 0;
        }

        @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
        public void unregisterGeofenceCallback(String r100, IStarGeofenceCallback r101) throws RemoteException {
        }

        @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
        public byte updateGeofence(StarGeofence r100) throws RemoteException {
            return 0;
        }
    }

    public static abstract class Stub extends Binder implements IStarGeofenceManager {
        private static final String DESCRIPTOR = "com.obric.cae.libs.location.geofence.IStarGeofenceManager";
        static final int TRANSACTION_addGeofence = 5;
        static final int TRANSACTION_deleteGeofence = 6;
        static final int TRANSACTION_deleteGeofenceById = 7;
        static final int TRANSACTION_findGeofenceById = 10;
        static final int TRANSACTION_getComponent = 3;
        static final int TRANSACTION_getVendorVersion = 1;
        static final int TRANSACTION_isStarGeofencesRecovered = 14;
        static final int TRANSACTION_listGeofences = 9;
        static final int TRANSACTION_registerComponent = 2;
        static final int TRANSACTION_registerGeofenceCallback = 12;
        static final int TRANSACTION_sendDebugEvent = 11;
        static final int TRANSACTION_unregisterComponent = 4;
        static final int TRANSACTION_unregisterGeofenceCallback = 13;
        static final int TRANSACTION_updateGeofence = 8;

        public static class Proxy implements IStarGeofenceManager {
            public static IStarGeofenceManager sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
            public String getVendorVersion() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_cae_libs_location_geofence_IStarGeofenceManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L13
                String r102 = r101.readString();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r102;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                String r103 = Stub.getDefaultImpl().getVendorVersion();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r103;
            L13:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
            public boolean isStarGeofencesRecovered() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                boolean r102 = false;
                if (INVOKEINTERFACE_com_obric_cae_libs_location_geofence_IStarGeofenceManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 14, r100, r101, 0) == false) goto L6;
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
                boolean r103 = Stub.getDefaultImpl().isStarGeofencesRecovered();     // Catch: Throwable -> L15
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

            @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
            public byte addGeofence(StarGeofence r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r100 == null) goto L6;
                r101.writeInt(1);     // Catch: Throwable -> L17
                r100.writeToParcel(r101, 0);     // Catch: Throwable -> L17
            L8:
                if (INVOKEINTERFACE_com_obric_cae_libs_location_geofence_IStarGeofenceManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 5, r101, r102, 0) == false) goto L10;
            L14:
                r102.readException();     // Catch: Throwable -> L17
                byte r103 = r102.readByte();     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return r103;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                byte r104 = Stub.getDefaultImpl().addGeofence(r100);     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return r104;
            L6:
                r101.writeInt(0);     // Catch: Throwable -> L17
            L17:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
            public byte deleteGeofence(StarGeofence r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r100 == null) goto L6;
                r101.writeInt(1);     // Catch: Throwable -> L17
                r100.writeToParcel(r101, 0);     // Catch: Throwable -> L17
            L8:
                if (INVOKEINTERFACE_com_obric_cae_libs_location_geofence_IStarGeofenceManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 6, r101, r102, 0) == false) goto L10;
            L14:
                r102.readException();     // Catch: Throwable -> L17
                byte r103 = r102.readByte();     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return r103;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                byte r104 = Stub.getDefaultImpl().deleteGeofence(r100);     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return r104;
            L6:
                r101.writeInt(0);     // Catch: Throwable -> L17
            L17:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
            public StarGeofence findGeofenceById(String r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r101.writeString(r100);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_obric_cae_libs_location_geofence_IStarGeofenceManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 10, r101, r102, 0) == false) goto L6;
            L10:
                r102.readException();     // Catch: Throwable -> L17
                if (r102.readInt() == 0) goto L14;
                StarGeofence r103 = StarGeofence.CREATOR.createFromParcel(r102);     // Catch: Throwable -> L17
            L15:
                r102.recycle();
                r101.recycle();
                return r103;
            L14:
                r103 = null;
                goto L15
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                StarGeofence r104 = Stub.getDefaultImpl().findGeofenceById(r100);     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return r104;
            L17:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
            public ComponentName getComponent(String r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r101.writeString(r100);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_obric_cae_libs_location_geofence_IStarGeofenceManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r101, r102, 0) == false) goto L6;
            L10:
                r102.readException();     // Catch: Throwable -> L17
                if (r102.readInt() == 0) goto L14;
                ComponentName r103 = (ComponentName) ComponentName.CREATOR.createFromParcel(r102);     // Catch: Throwable -> L17
            L15:
                r102.recycle();
                r101.recycle();
                return r103;
            L14:
                r103 = null;
                goto L15
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                ComponentName r104 = Stub.getDefaultImpl().getComponent(r100);     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return r104;
            L17:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
            public List<StarGeofence> listGeofences(String r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r101.writeString(r100);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_cae_libs_location_geofence_IStarGeofenceManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 9, r101, r102, 0) == false) goto L6;
            L10:
                r102.readException();     // Catch: Throwable -> L13
                ArrayList r103 = r102.createTypedArrayList(StarGeofence.CREATOR);     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return r103;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                List<StarGeofence> r104 = Stub.getDefaultImpl().listGeofences(r100);     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return r104;
            L13:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
            public byte registerComponent(ComponentName r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r100 == null) goto L6;
                r101.writeInt(1);     // Catch: Throwable -> L17
                r100.writeToParcel(r101, 0);     // Catch: Throwable -> L17
            L8:
                if (INVOKEINTERFACE_com_obric_cae_libs_location_geofence_IStarGeofenceManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r101, r102, 0) == false) goto L10;
            L14:
                r102.readException();     // Catch: Throwable -> L17
                byte r103 = r102.readByte();     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return r103;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                byte r104 = Stub.getDefaultImpl().registerComponent(r100);     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return r104;
            L6:
                r101.writeInt(0);     // Catch: Throwable -> L17
            L17:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
            public byte unregisterComponent(ComponentName r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r100 == null) goto L6;
                r101.writeInt(1);     // Catch: Throwable -> L17
                r100.writeToParcel(r101, 0);     // Catch: Throwable -> L17
            L8:
                if (INVOKEINTERFACE_com_obric_cae_libs_location_geofence_IStarGeofenceManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r101, r102, 0) == false) goto L10;
            L14:
                r102.readException();     // Catch: Throwable -> L17
                byte r103 = r102.readByte();     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return r103;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                byte r104 = Stub.getDefaultImpl().unregisterComponent(r100);     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return r104;
            L6:
                r101.writeInt(0);     // Catch: Throwable -> L17
            L17:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
            public byte updateGeofence(StarGeofence r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L19
                if (r100 == null) goto L6;
                r101.writeInt(1);     // Catch: Throwable -> L19
                r100.writeToParcel(r101, 0);     // Catch: Throwable -> L19
            L8:
                if (INVOKEINTERFACE_com_obric_cae_libs_location_geofence_IStarGeofenceManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 8, r101, r102, 0) == false) goto L10;
            L14:
                r102.readException();     // Catch: Throwable -> L19
                byte r103 = r102.readByte();     // Catch: Throwable -> L19
                if (r102.readInt() == 0) goto L17;
                r100.readFromParcel(r102);     // Catch: Throwable -> L19
            L17:
                r102.recycle();
                r101.recycle();
                return r103;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                byte r104 = Stub.getDefaultImpl().updateGeofence(r100);     // Catch: Throwable -> L19
                r102.recycle();
                r101.recycle();
                return r104;
            L6:
                r101.writeInt(0);     // Catch: Throwable -> L19
            L19:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
            public byte deleteGeofenceById(String r100, String r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r102.writeString(r100);     // Catch: Throwable -> L13
                r102.writeString(r101);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_cae_libs_location_geofence_IStarGeofenceManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 7, r102, r103, 0) == false) goto L6;
            L10:
                r103.readException();     // Catch: Throwable -> L13
                byte r104 = r103.readByte();     // Catch: Throwable -> L13
                r103.recycle();
                r102.recycle();
                return r104;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                byte r105 = Stub.getDefaultImpl().deleteGeofenceById(r100, r101);     // Catch: Throwable -> L13
                r103.recycle();
                r102.recycle();
                return r105;
            L13:
                th = move-exception;
                r103.recycle();
                r102.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
            public void registerGeofenceCallback(String r100, IStarGeofenceCallback r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r102.writeString(r100);     // Catch: Throwable -> L17
                if (r101 == null) goto L6;
                IBinder r104 = r101.asBinder();     // Catch: Throwable -> L17
            L7:
                r102.writeStrongBinder(r104);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_obric_cae_libs_location_geofence_IStarGeofenceManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 12, r102, r103, 0) == false) goto L10;
            L14:
                r103.readException();     // Catch: Throwable -> L17
                r103.recycle();
                r102.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().registerGeofenceCallback(r100, r101);     // Catch: Throwable -> L17
                r103.recycle();
                r102.recycle();
                return;
            L6:
                r104 = null;
            L17:
                th = move-exception;
                r103.recycle();
                r102.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
            public void unregisterGeofenceCallback(String r100, IStarGeofenceCallback r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r102.writeString(r100);     // Catch: Throwable -> L17
                if (r101 == null) goto L6;
                IBinder r104 = r101.asBinder();     // Catch: Throwable -> L17
            L7:
                r102.writeStrongBinder(r104);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_obric_cae_libs_location_geofence_IStarGeofenceManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 13, r102, r103, 0) == false) goto L10;
            L14:
                r103.readException();     // Catch: Throwable -> L17
                r103.recycle();
                r102.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().unregisterGeofenceCallback(r100, r101);     // Catch: Throwable -> L17
                r103.recycle();
                r102.recycle();
                return;
            L6:
                r104 = null;
            L17:
                th = move-exception;
                r103.recycle();
                r102.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.geofence.IStarGeofenceManager
            public void sendDebugEvent(Location r100, int r101, StarGeofence r102) throws RemoteException {
                Parcel r103 = Parcel.obtain();
                Parcel r104 = Parcel.obtain();
                r103.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L23
                if (r100 == null) goto L6;
                r103.writeInt(1);     // Catch: Throwable -> L23
                r100.writeToParcel(r103, 0);     // Catch: Throwable -> L23
            L7:
                r103.writeInt(r101);     // Catch: Throwable -> L23
                if (r102 == null) goto L10;
                r103.writeInt(1);     // Catch: Throwable -> L23
                r102.writeToParcel(r103, 0);     // Catch: Throwable -> L23
            L12:
                if (INVOKEINTERFACE_com_obric_cae_libs_location_geofence_IStarGeofenceManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 11, r103, r104, 0) == false) goto L14;
            L18:
                r104.readException();     // Catch: Throwable -> L23
                if (r104.readInt() == 0) goto L21;
                r102.readFromParcel(r104);     // Catch: Throwable -> L23
            L21:
                r104.recycle();
                r103.recycle();
                return;
            L14:
                if (Stub.getDefaultImpl() == null) goto L18;
                Stub.getDefaultImpl().sendDebugEvent(r100, r101, r102);     // Catch: Throwable -> L23
                r104.recycle();
                r103.recycle();
                return;
            L10:
                r103.writeInt(0);     // Catch: Throwable -> L23
                goto L12
            L6:
                r103.writeInt(0);     // Catch: Throwable -> L23
            L23:
                th = move-exception;
                r104.recycle();
                r103.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_obric_cae_libs_location_geofence_IStarGeofenceManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IStarGeofenceManager getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static IStarGeofenceManager asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof IStarGeofenceManager) == false) goto L12;
            return (IStarGeofenceManager) r101;
        L12:
            return new Proxy(r100);
        }

        public static boolean setDefaultImpl(IStarGeofenceManager r100) {
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
            if (r100 == 1598968902) goto L70;
            ComponentName r104 = null;
            StarGeofence r105 = null;
            StarGeofence r106 = null;
            StarGeofence r107 = null;
            StarGeofence r108 = null;
            ComponentName r109 = null;
            switch(r100) {
                case 1: goto L68;
                case 2: goto L63;
                case 3: goto L58;
                case 4: goto L53;
                case 5: goto L48;
                case 6: goto L43;
                case 7: goto L41;
                case 8: goto L33;
                case 9: goto L31;
                case 10: goto L26;
                case 11: goto L14;
                case 12: goto L12;
                case 13: goto L10;
                case 14: goto L8;
                default: goto L7;
            };
        L8:
            r101.enforceInterface(DESCRIPTOR);
            boolean r110 = isStarGeofencesRecovered();
            r102.writeNoException();
            r102.writeInt(r110 ? 1 : 0);
            return true;
        L10:
            r101.enforceInterface(DESCRIPTOR);
            unregisterGeofenceCallback(r101.readString(), IStarGeofenceCallback.Stub.asInterface(r101.readStrongBinder()));
            r102.writeNoException();
            return true;
        L12:
            r101.enforceInterface(DESCRIPTOR);
            registerGeofenceCallback(r101.readString(), IStarGeofenceCallback.Stub.asInterface(r101.readStrongBinder()));
            r102.writeNoException();
            return true;
        L14:
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L17;
            Location r111 = (Location) Location.CREATOR.createFromParcel(r101);
        L18:
            int r112 = r101.readInt();
            if (r101.readInt() == 0) goto L21;
            r105 = StarGeofence.CREATOR.createFromParcel(r101);
        L21:
            sendDebugEvent(r111, r112, r105);
            r102.writeNoException();
            if (r105 == null) goto L24;
            r102.writeInt(1);
            r105.writeToParcel(r102, 1);
        L25:
            return true;
        L24:
            r102.writeInt(0);
            goto L25
        L17:
            r111 = null;
            goto L18
        L26:
            r101.enforceInterface(DESCRIPTOR);
            StarGeofence r113 = findGeofenceById(r101.readString());
            r102.writeNoException();
            if (r113 == null) goto L29;
            r102.writeInt(1);
            r113.writeToParcel(r102, 1);
        L30:
            return true;
        L29:
            r102.writeInt(0);
            goto L30
        L31:
            r101.enforceInterface(DESCRIPTOR);
            List<StarGeofence> r114 = listGeofences(r101.readString());
            r102.writeNoException();
            r102.writeTypedList(r114);
            return true;
        L33:
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L36;
            r106 = StarGeofence.CREATOR.createFromParcel(r101);
        L36:
            byte r115 = updateGeofence(r106);
            r102.writeNoException();
            r102.writeByte(r115);
            if (r106 == null) goto L39;
            r102.writeInt(1);
            r106.writeToParcel(r102, 1);
        L40:
            return true;
        L39:
            r102.writeInt(0);
            goto L40
        L41:
            r101.enforceInterface(DESCRIPTOR);
            byte r116 = deleteGeofenceById(r101.readString(), r101.readString());
            r102.writeNoException();
            r102.writeByte(r116);
            return true;
        L43:
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L46;
            r107 = StarGeofence.CREATOR.createFromParcel(r101);
        L46:
            byte r117 = deleteGeofence(r107);
            r102.writeNoException();
            r102.writeByte(r117);
            return true;
        L48:
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L51;
            r108 = StarGeofence.CREATOR.createFromParcel(r101);
        L51:
            byte r118 = addGeofence(r108);
            r102.writeNoException();
            r102.writeByte(r118);
            return true;
        L53:
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L56;
            r109 = (ComponentName) ComponentName.CREATOR.createFromParcel(r101);
        L56:
            byte r119 = unregisterComponent(r109);
            r102.writeNoException();
            r102.writeByte(r119);
            return true;
        L58:
            r101.enforceInterface(DESCRIPTOR);
            ComponentName r120 = getComponent(r101.readString());
            r102.writeNoException();
            if (r120 == null) goto L61;
            r102.writeInt(1);
            r120.writeToParcel(r102, 1);
        L62:
            return true;
        L61:
            r102.writeInt(0);
            goto L62
        L63:
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L66;
            r104 = (ComponentName) ComponentName.CREATOR.createFromParcel(r101);
        L66:
            byte r121 = registerComponent(r104);
            r102.writeNoException();
            r102.writeByte(r121);
            return true;
        L68:
            r101.enforceInterface(DESCRIPTOR);
            String r122 = getVendorVersion();
            r102.writeNoException();
            r102.writeString(r122);
            return true;
        L7:
            return super.onTransact(r100, r101, r102, r103);
        L70:
            r102.writeString(DESCRIPTOR);
            return true;
        }
    }

    byte addGeofence(StarGeofence r100) throws RemoteException;

    byte deleteGeofence(StarGeofence r100) throws RemoteException;

    byte deleteGeofenceById(String r100, String r101) throws RemoteException;

    StarGeofence findGeofenceById(String r100) throws RemoteException;

    ComponentName getComponent(String r100) throws RemoteException;

    String getVendorVersion() throws RemoteException;

    boolean isStarGeofencesRecovered() throws RemoteException;

    List<StarGeofence> listGeofences(String r100) throws RemoteException;

    byte registerComponent(ComponentName r100) throws RemoteException;

    void registerGeofenceCallback(String r100, IStarGeofenceCallback r101) throws RemoteException;

    void sendDebugEvent(Location r100, int r101, StarGeofence r102) throws RemoteException;

    byte unregisterComponent(ComponentName r100) throws RemoteException;

    void unregisterGeofenceCallback(String r100, IStarGeofenceCallback r101) throws RemoteException;

    byte updateGeofence(StarGeofence r100) throws RemoteException;
}
