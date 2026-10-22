package com.obric.cae.libs.location;

import android.location.Address;
import android.location.Location;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import com.obric.cae.libs.location.geofence.IStarGeofenceManager;
import com.obric.cae.libs.location.poi.IStarAoiBoardManager;
import java.util.Map;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes33.dex */
public interface IStarLocationService extends IInterface {
    public static final int CITY_LISTEN_LEVEL1 = 1;
    public static final int CITY_LISTEN_LEVEL2 = 2;
    public static final int CITY_LISTEN_LEVEL3 = 3;
    public static final int CITY_LISTEN_LEVEL4 = 4;
    public static final int DIRECTION_TYPE_DRIVING = 2;
    public static final int DIRECTION_TYPE_RIDING = 4;
    public static final int DIRECTION_TYPE_TRANSIT = 1;
    public static final int DIRECTION_TYPE_WALKING = 3;

    public static class Default implements IStarLocationService {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.location.IStarLocationService
        public Address getCurCityInfo() throws RemoteException {
            return null;
        }

        @Override // com.obric.cae.libs.location.IStarLocationService
        public Location getLocationFromBdGeo() throws RemoteException {
            return null;
        }

        @Override // com.obric.cae.libs.location.IStarLocationService
        public Location getLocationFromZpp() throws RemoteException {
            return null;
        }

        @Override // com.obric.cae.libs.location.IStarLocationService
        public IStarAoiBoardManager getStarAoiBoardManager() throws RemoteException {
            return null;
        }

        @Override // com.obric.cae.libs.location.IStarLocationService
        public IStarGeofenceManager getStarGeofenceManager() throws RemoteException {
            return null;
        }

        @Override // com.obric.cae.libs.location.IStarLocationService
        public String getStarVersion() throws RemoteException {
            return null;
        }

        @Override // com.obric.cae.libs.location.IStarLocationService
        public void registerCityCallback(int r100, IStarLocationCityCallback r101) throws RemoteException {
        }

        @Override // com.obric.cae.libs.location.IStarLocationService
        public void runIndoorCheck(long r100) throws RemoteException {
        }

        @Override // com.obric.cae.libs.location.IStarLocationService
        public Bundle searchDirectionFromBmap(double r100, double r101, double r102, double r103, byte r104, byte r110, Map r111, int r112) throws RemoteException {
            return null;
        }

        @Override // com.obric.cae.libs.location.IStarLocationService
        public Bundle searchDirectionFromBmapByAddress(double r100, double r101, String r102, byte r103, byte r104, Map r105, int r106) throws RemoteException {
            return null;
        }

        @Override // com.obric.cae.libs.location.IStarLocationService
        public String searchPoiTextFromBd(String r100, int r101, int r102, String r103, String r104) throws RemoteException {
            return null;
        }

        @Override // com.obric.cae.libs.location.IStarLocationService
        public void unregisterCityCallback() throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IStarLocationService {
        private static final String DESCRIPTOR = "com.obric.cae.libs.location.IStarLocationService";
        static final int TRANSACTION_getCurCityInfo = 12;
        static final int TRANSACTION_getLocationFromBdGeo = 4;
        static final int TRANSACTION_getLocationFromZpp = 3;
        static final int TRANSACTION_getStarAoiBoardManager = 11;
        static final int TRANSACTION_getStarGeofenceManager = 2;
        static final int TRANSACTION_getStarVersion = 1;
        static final int TRANSACTION_registerCityCallback = 7;
        static final int TRANSACTION_runIndoorCheck = 6;
        static final int TRANSACTION_searchDirectionFromBmap = 9;
        static final int TRANSACTION_searchDirectionFromBmapByAddress = 10;
        static final int TRANSACTION_searchPoiTextFromBd = 5;
        static final int TRANSACTION_unregisterCityCallback = 8;

        public static class Proxy implements IStarLocationService {
            public static IStarLocationService sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.obric.cae.libs.location.IStarLocationService
            public Address getCurCityInfo() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_obric_cae_libs_location_IStarLocationService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 12, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L17
                if (r101.readInt() == 0) goto L14;
                Address r102 = (Address) Address.CREATOR.createFromParcel(r101);     // Catch: Throwable -> L17
            L15:
                r101.recycle();
                r100.recycle();
                return r102;
            L14:
                r102 = null;
                goto L15
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Address r103 = Stub.getDefaultImpl().getCurCityInfo();     // Catch: Throwable -> L17
                r101.recycle();
                r100.recycle();
                return r103;
            L17:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.IStarLocationService
            public Location getLocationFromBdGeo() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_obric_cae_libs_location_IStarLocationService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L17
                if (r101.readInt() == 0) goto L14;
                Location r102 = (Location) Location.CREATOR.createFromParcel(r101);     // Catch: Throwable -> L17
            L15:
                r101.recycle();
                r100.recycle();
                return r102;
            L14:
                r102 = null;
                goto L15
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Location r103 = Stub.getDefaultImpl().getLocationFromBdGeo();     // Catch: Throwable -> L17
                r101.recycle();
                r100.recycle();
                return r103;
            L17:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.IStarLocationService
            public Location getLocationFromZpp() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_obric_cae_libs_location_IStarLocationService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L17
                if (r101.readInt() == 0) goto L14;
                Location r102 = (Location) Location.CREATOR.createFromParcel(r101);     // Catch: Throwable -> L17
            L15:
                r101.recycle();
                r100.recycle();
                return r102;
            L14:
                r102 = null;
                goto L15
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Location r103 = Stub.getDefaultImpl().getLocationFromZpp();     // Catch: Throwable -> L17
                r101.recycle();
                r100.recycle();
                return r103;
            L17:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.IStarLocationService
            public IStarAoiBoardManager getStarAoiBoardManager() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_cae_libs_location_IStarLocationService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 11, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L13
                IStarAoiBoardManager r102 = IStarAoiBoardManager.Stub.asInterface(r101.readStrongBinder());     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r102;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                IStarAoiBoardManager r103 = Stub.getDefaultImpl().getStarAoiBoardManager();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r103;
            L13:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.IStarLocationService
            public IStarGeofenceManager getStarGeofenceManager() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_cae_libs_location_IStarLocationService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L13
                IStarGeofenceManager r102 = IStarGeofenceManager.Stub.asInterface(r101.readStrongBinder());     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r102;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                IStarGeofenceManager r103 = Stub.getDefaultImpl().getStarGeofenceManager();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r103;
            L13:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.IStarLocationService
            public String getStarVersion() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_cae_libs_location_IStarLocationService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L13
                String r102 = r101.readString();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r102;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                String r103 = Stub.getDefaultImpl().getStarVersion();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r103;
            L13:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.IStarLocationService
            public void unregisterCityCallback() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_cae_libs_location_IStarLocationService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 8, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().unregisterCityCallback();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return;
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

            @Override // com.obric.cae.libs.location.IStarLocationService
            public void runIndoorCheck(long r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r101.writeLong(r100);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_cae_libs_location_IStarLocationService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 6, r101, r102, 0) == false) goto L6;
            L10:
                r102.readException();     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().runIndoorCheck(r100);     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return;
            L13:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.IStarLocationService
            public void registerCityCallback(int r100, IStarLocationCityCallback r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r102.writeInt(r100);     // Catch: Throwable -> L17
                if (r101 == null) goto L6;
                IBinder r104 = r101.asBinder();     // Catch: Throwable -> L17
            L7:
                r102.writeStrongBinder(r104);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_obric_cae_libs_location_IStarLocationService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 7, r102, r103, 0) == false) goto L10;
            L14:
                r103.readException();     // Catch: Throwable -> L17
                r103.recycle();
                r102.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().registerCityCallback(r100, r101);     // Catch: Throwable -> L17
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

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_obric_cae_libs_location_IStarLocationService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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

            @Override // com.obric.cae.libs.location.IStarLocationService
            public String searchPoiTextFromBd(String r110, int r111, int r112, String r113, String r114) throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r100.writeString(r110);     // Catch: Throwable -> L13
                r100.writeInt(r111);     // Catch: Throwable -> L13
                r100.writeInt(r112);     // Catch: Throwable -> L13
                r100.writeString(r113);     // Catch: Throwable -> L13
                r100.writeString(r114);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_cae_libs_location_IStarLocationService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 5, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L13
                String r115 = r101.readString();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r115;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                String r116 = Stub.getDefaultImpl().searchPoiTextFromBd(r110, r111, r112, r113, r114);     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r116;
            L13:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.IStarLocationService
            public Bundle searchDirectionFromBmapByAddress(double r110, double r111, String r210, byte r211, byte r212, Map r213, int r214) throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L21
                r100.writeDouble(r110);     // Catch: Throwable -> L21
                r100.writeDouble(r111);     // Catch: Throwable -> L21
                r100.writeString(r210);     // Catch: Throwable -> L21
                r100.writeByte(r211);     // Catch: Throwable -> L21
                r100.writeByte(r212);     // Catch: Throwable -> L21
                r100.writeMap(r213);     // Catch: Throwable -> L21
                r100.writeInt(r214);     // Catch: Throwable -> L21
            L19:
                th = th;
            L23:
                r101.recycle();
                r100.recycle();
                throw th;
            L6:
                if (INVOKEINTERFACE_com_obric_cae_libs_location_IStarLocationService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 10, r100, r101, 0) == false) goto L8;
            L12:
                r101.readException();     // Catch: Throwable -> L19
                if (r101.readInt() == 0) goto L16;
                Bundle r102 = (Bundle) Bundle.CREATOR.createFromParcel(r101);     // Catch: Throwable -> L19
            L17:
                r101.recycle();
                r100.recycle();
                return r102;
            L16:
                r102 = null;
                goto L17
            L8:
                if (Stub.getDefaultImpl() == null) goto L12;
                Bundle r103 = Stub.getDefaultImpl().searchDirectionFromBmapByAddress(r110, r111, r210, r211, r212, r213, r214);     // Catch: Throwable -> L19
                r101.recycle();
                r100.recycle();
                return r103;
            L21:
                th = th;
                goto L23
            }

            @Override // com.obric.cae.libs.location.IStarLocationService
            public Bundle searchDirectionFromBmap(double r110, double r111, double r210, double r211, byte r212, byte r213, Map r214, int r215) throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r100.writeDouble(r110);     // Catch: Throwable -> L17
                r100.writeDouble(r111);     // Catch: Throwable -> L17
                r100.writeDouble(r210);     // Catch: Throwable -> L17
                r100.writeDouble(r211);     // Catch: Throwable -> L17
                r100.writeByte(r212);     // Catch: Throwable -> L17
                r100.writeByte(r213);     // Catch: Throwable -> L17
                r100.writeMap(r214);     // Catch: Throwable -> L17
                r100.writeInt(r215);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_obric_cae_libs_location_IStarLocationService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 9, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L17
                if (r101.readInt() == 0) goto L14;
                Bundle r102 = (Bundle) Bundle.CREATOR.createFromParcel(r101);     // Catch: Throwable -> L17
            L15:
                r101.recycle();
                r100.recycle();
                return r102;
            L14:
                r102 = null;
                goto L15
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Bundle r103 = Stub.getDefaultImpl().searchDirectionFromBmap(r110, r111, r210, r211, r212, r213, r214, r215);     // Catch: Throwable -> L17
                r101.recycle();
                r100.recycle();
                return r103;
            L17:
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

        public static IStarLocationService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static IStarLocationService asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof IStarLocationService) == false) goto L12;
            return (IStarLocationService) r101;
        L12:
            return new Proxy(r100);
        }

        public static boolean setDefaultImpl(IStarLocationService r100) {
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
        public boolean onTransact(int r110, Parcel r210, Parcel r211, int r212) throws RemoteException {
            if (r110 == 1598968902) goto L53;
            IBinder r100 = null;
            switch(r110) {
                case 1: goto L51;
                case 2: goto L46;
                case 3: goto L41;
                case 4: goto L36;
                case 5: goto L34;
                case 6: goto L32;
                case 7: goto L30;
                case 8: goto L28;
                case 9: goto L23;
                case 10: goto L18;
                case 11: goto L13;
                case 12: goto L8;
                default: goto L7;
            };
        L8:
            r210.enforceInterface(DESCRIPTOR);
            Address r101 = getCurCityInfo();
            r211.writeNoException();
            if (r101 == null) goto L11;
            r211.writeInt(1);
            r101.writeToParcel(r211, 1);
        L12:
            return true;
        L11:
            r211.writeInt(0);
            goto L12
        L13:
            r210.enforceInterface(DESCRIPTOR);
            IStarAoiBoardManager r102 = getStarAoiBoardManager();
            r211.writeNoException();
            if (r102 == null) goto L16;
            r100 = r102.asBinder();
        L16:
            r211.writeStrongBinder(r100);
            return true;
        L18:
            r210.enforceInterface(DESCRIPTOR);
            Bundle r103 = searchDirectionFromBmapByAddress(r210.readDouble(), r210.readDouble(), r210.readString(), r210.readByte(), r210.readByte(), r210.readHashMap(getClass().getClassLoader()), r210.readInt());
            r211.writeNoException();
            if (r103 == null) goto L21;
            r211.writeInt(1);
            r103.writeToParcel(r211, 1);
        L22:
            return true;
        L21:
            r211.writeInt(0);
            goto L22
        L23:
            r210.enforceInterface(DESCRIPTOR);
            Bundle r104 = searchDirectionFromBmap(r210.readDouble(), r210.readDouble(), r210.readDouble(), r210.readDouble(), r210.readByte(), r210.readByte(), r210.readHashMap(getClass().getClassLoader()), r210.readInt());
            r211.writeNoException();
            if (r104 == null) goto L26;
            r211.writeInt(1);
            r104.writeToParcel(r211, 1);
        L27:
            return true;
        L26:
            r211.writeInt(0);
            goto L27
        L28:
            r210.enforceInterface(DESCRIPTOR);
            unregisterCityCallback();
            r211.writeNoException();
            return true;
        L30:
            r210.enforceInterface(DESCRIPTOR);
            registerCityCallback(r210.readInt(), IStarLocationCityCallback.Stub.asInterface(r210.readStrongBinder()));
            r211.writeNoException();
            return true;
        L32:
            r210.enforceInterface(DESCRIPTOR);
            runIndoorCheck(r210.readLong());
            r211.writeNoException();
            return true;
        L34:
            r210.enforceInterface(DESCRIPTOR);
            String r105 = searchPoiTextFromBd(r210.readString(), r210.readInt(), r210.readInt(), r210.readString(), r210.readString());
            r211.writeNoException();
            r211.writeString(r105);
            return true;
        L36:
            r210.enforceInterface(DESCRIPTOR);
            Location r106 = getLocationFromBdGeo();
            r211.writeNoException();
            if (r106 == null) goto L39;
            r211.writeInt(1);
            r106.writeToParcel(r211, 1);
        L40:
            return true;
        L39:
            r211.writeInt(0);
            goto L40
        L41:
            r210.enforceInterface(DESCRIPTOR);
            Location r107 = getLocationFromZpp();
            r211.writeNoException();
            if (r107 == null) goto L44;
            r211.writeInt(1);
            r107.writeToParcel(r211, 1);
        L45:
            return true;
        L44:
            r211.writeInt(0);
            goto L45
        L46:
            r210.enforceInterface(DESCRIPTOR);
            IStarGeofenceManager r108 = getStarGeofenceManager();
            r211.writeNoException();
            if (r108 == null) goto L49;
            r100 = r108.asBinder();
        L49:
            r211.writeStrongBinder(r100);
            return true;
        L51:
            r210.enforceInterface(DESCRIPTOR);
            String r109 = getStarVersion();
            r211.writeNoException();
            r211.writeString(r109);
            return true;
        L7:
            return super.onTransact(r110, r210, r211, r212);
        L53:
            r211.writeString(DESCRIPTOR);
            return true;
        }
    }

    Address getCurCityInfo() throws RemoteException;

    Location getLocationFromBdGeo() throws RemoteException;

    Location getLocationFromZpp() throws RemoteException;

    IStarAoiBoardManager getStarAoiBoardManager() throws RemoteException;

    IStarGeofenceManager getStarGeofenceManager() throws RemoteException;

    String getStarVersion() throws RemoteException;

    void registerCityCallback(int r100, IStarLocationCityCallback r101) throws RemoteException;

    void runIndoorCheck(long r100) throws RemoteException;

    Bundle searchDirectionFromBmap(double r100, double r101, double r102, double r103, byte r104, byte r110, Map r111, int r112) throws RemoteException;

    Bundle searchDirectionFromBmapByAddress(double r100, double r101, String r102, byte r103, byte r104, Map r105, int r106) throws RemoteException;

    String searchPoiTextFromBd(String r100, int r101, int r102, String r103, String r104) throws RemoteException;

    void unregisterCityCallback() throws RemoteException;
}
