package com.obric.cae.libs.location.geofence;

import android.location.Location;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes33.dex */
public interface IStarGeofenceCallback extends IInterface {
    public static final int GEOFENCE_GEN_ALERT_GNSS_AVAILABLE = 2;
    public static final int GEOFENCE_GEN_ALERT_GNSS_UNAVAILABLE = 1;
    public static final int GEOFENCE_GEN_ALERT_OOS = 3;
    public static final int GEOFENCE_GEN_ALERT_TIME_INVALID = 4;

    public static class Default implements IStarGeofenceCallback {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.location.geofence.IStarGeofenceCallback
        public void onBreachReport(String r100, Location r101, int r102) throws RemoteException {
        }

        @Override // com.obric.cae.libs.location.geofence.IStarGeofenceCallback
        public void onGeofenceStatusReport(int r100, Location r101) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IStarGeofenceCallback {
        private static final String DESCRIPTOR = "com.obric.cae.libs.location.geofence.IStarGeofenceCallback";
        static final int TRANSACTION_onBreachReport = 1;
        static final int TRANSACTION_onGeofenceStatusReport = 2;

        public static class Proxy implements IStarGeofenceCallback {
            public static IStarGeofenceCallback sDefaultImpl;
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

            @Override // com.obric.cae.libs.location.geofence.IStarGeofenceCallback
            public void onGeofenceStatusReport(int r100, Location r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r102.writeInt(r100);     // Catch: Throwable -> L16
                if (r101 == null) goto L6;
                r102.writeInt(1);     // Catch: Throwable -> L16
                r101.writeToParcel(r102, 0);     // Catch: Throwable -> L16
            L8:
                if (INVOKEINTERFACE_com_obric_cae_libs_location_geofence_IStarGeofenceCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r102, null, 1) == false) goto L10;
            L14:
                r102.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().onGeofenceStatusReport(r100, r101);     // Catch: Throwable -> L16
                r102.recycle();
                return;
            L6:
                r102.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r102.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.geofence.IStarGeofenceCallback
            public void onBreachReport(String r100, Location r101, int r102) throws RemoteException {
                Parcel r103 = Parcel.obtain();
                r103.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r103.writeString(r100);     // Catch: Throwable -> L16
                if (r101 == null) goto L6;
                r103.writeInt(1);     // Catch: Throwable -> L16
                r101.writeToParcel(r103, 0);     // Catch: Throwable -> L16
            L7:
                r103.writeInt(r102);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_com_obric_cae_libs_location_geofence_IStarGeofenceCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r103, null, 1) == false) goto L10;
            L14:
                r103.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().onBreachReport(r100, r101, r102);     // Catch: Throwable -> L16
                r103.recycle();
                return;
            L6:
                r103.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r103.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_obric_cae_libs_location_geofence_IStarGeofenceCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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

        public static IStarGeofenceCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static IStarGeofenceCallback asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof IStarGeofenceCallback) == false) goto L12;
            return (IStarGeofenceCallback) r101;
        L12:
            return new Proxy(r100);
        }

        public static boolean setDefaultImpl(IStarGeofenceCallback r100) {
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
            Location r104 = null;
            if (r100 != 1) goto L5;
            r101.enforceInterface(DESCRIPTOR);
            String r105 = r101.readString();
            if (r101.readInt() == 0) goto L20;
            r104 = (Location) Location.CREATOR.createFromParcel(r101);
        L20:
            onBreachReport(r105, r104, r101.readInt());
            return true;
        L5:
            if (r100 != 2) goto L7;
            r101.enforceInterface(DESCRIPTOR);
            int r106 = r101.readInt();
            if (r101.readInt() == 0) goto L15;
            r104 = (Location) Location.CREATOR.createFromParcel(r101);
        L15:
            onGeofenceStatusReport(r106, r104);
            return true;
        L7:
            if (r100 != 1598968902) goto L9;
            r102.writeString(DESCRIPTOR);
            return true;
        L9:
            return super.onTransact(r100, r101, r102, r103);
        }
    }

    void onBreachReport(String r100, Location r101, int r102) throws RemoteException;

    void onGeofenceStatusReport(int r100, Location r101) throws RemoteException;
}
