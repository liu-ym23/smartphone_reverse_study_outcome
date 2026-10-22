package com.obric.cae.libs.location.poi;

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
public interface IStarAoiBoardManager extends IInterface {

    public static class Default implements IStarAoiBoardManager {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.location.poi.IStarAoiBoardManager
        public AoiBoard findAoiBoardByPoiId(String r100) throws RemoteException {
            return null;
        }

        @Override // com.obric.cae.libs.location.poi.IStarAoiBoardManager
        public boolean isAoiBoardsRecovered() throws RemoteException {
            return false;
        }

        @Override // com.obric.cae.libs.location.poi.IStarAoiBoardManager
        public List<AoiBoard> listAllAoiBoards() throws RemoteException {
            return null;
        }

        @Override // com.obric.cae.libs.location.poi.IStarAoiBoardManager
        public List<AoiBoard> listAoiBoardsByType(int r100) throws RemoteException {
            return null;
        }

        @Override // com.obric.cae.libs.location.poi.IStarAoiBoardManager
        public void registerAoiBoardCallback(IStarAoiBoardCallback r100) throws RemoteException {
        }

        @Override // com.obric.cae.libs.location.poi.IStarAoiBoardManager
        public void unregisterAoiBoardCallback() throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IStarAoiBoardManager {
        private static final String DESCRIPTOR = "com.obric.cae.libs.location.poi.IStarAoiBoardManager";
        static final int TRANSACTION_findAoiBoardByPoiId = 5;
        static final int TRANSACTION_isAoiBoardsRecovered = 6;
        static final int TRANSACTION_listAllAoiBoards = 3;
        static final int TRANSACTION_listAoiBoardsByType = 4;
        static final int TRANSACTION_registerAoiBoardCallback = 1;
        static final int TRANSACTION_unregisterAoiBoardCallback = 2;

        public static class Proxy implements IStarAoiBoardManager {
            public static IStarAoiBoardManager sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.obric.cae.libs.location.poi.IStarAoiBoardManager
            public boolean isAoiBoardsRecovered() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                boolean r102 = false;
                if (INVOKEINTERFACE_com_obric_cae_libs_location_poi_IStarAoiBoardManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 6, r100, r101, 0) == false) goto L6;
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
                boolean r103 = Stub.getDefaultImpl().isAoiBoardsRecovered();     // Catch: Throwable -> L15
                r101.recycle();
                r100.recycle();
                return r103;
            L15:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.poi.IStarAoiBoardManager
            public List<AoiBoard> listAllAoiBoards() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_cae_libs_location_poi_IStarAoiBoardManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L13
                ArrayList r102 = r101.createTypedArrayList(AoiBoard.CREATOR);     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r102;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                List<AoiBoard> r103 = Stub.getDefaultImpl().listAllAoiBoards();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r103;
            L13:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.poi.IStarAoiBoardManager
            public void unregisterAoiBoardCallback() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_cae_libs_location_poi_IStarAoiBoardManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r100, null, 1) == false) goto L6;
            L10:
                r100.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().unregisterAoiBoardCallback();     // Catch: Throwable -> L12
                r100.recycle();
                return;
            L12:
                th = move-exception;
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

            @Override // com.obric.cae.libs.location.poi.IStarAoiBoardManager
            public AoiBoard findAoiBoardByPoiId(String r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r101.writeString(r100);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_obric_cae_libs_location_poi_IStarAoiBoardManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 5, r101, r102, 0) == false) goto L6;
            L10:
                r102.readException();     // Catch: Throwable -> L17
                if (r102.readInt() == 0) goto L14;
                AoiBoard r103 = AoiBoard.CREATOR.createFromParcel(r102);     // Catch: Throwable -> L17
            L15:
                r102.recycle();
                r101.recycle();
                return r103;
            L14:
                r103 = null;
                goto L15
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                AoiBoard r104 = Stub.getDefaultImpl().findAoiBoardByPoiId(r100);     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return r104;
            L17:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.poi.IStarAoiBoardManager
            public List<AoiBoard> listAoiBoardsByType(int r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r101.writeInt(r100);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_cae_libs_location_poi_IStarAoiBoardManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r101, r102, 0) == false) goto L6;
            L10:
                r102.readException();     // Catch: Throwable -> L13
                ArrayList r103 = r102.createTypedArrayList(AoiBoard.CREATOR);     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return r103;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                List<AoiBoard> r104 = Stub.getDefaultImpl().listAoiBoardsByType(r100);     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return r104;
            L13:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.obric.cae.libs.location.poi.IStarAoiBoardManager
            public void registerAoiBoardCallback(IStarAoiBoardCallback r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r100 == null) goto L6;
                IBinder r102 = r100.asBinder();     // Catch: Throwable -> L16
            L7:
                r101.writeStrongBinder(r102);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_com_obric_cae_libs_location_poi_IStarAoiBoardManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r101, null, 1) == false) goto L10;
            L14:
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().registerAoiBoardCallback(r100);     // Catch: Throwable -> L16
                r101.recycle();
                return;
            L6:
                r102 = null;
            L16:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_obric_cae_libs_location_poi_IStarAoiBoardManager$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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

        public static IStarAoiBoardManager getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static IStarAoiBoardManager asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof IStarAoiBoardManager) == false) goto L12;
            return (IStarAoiBoardManager) r101;
        L12:
            return new Proxy(r100);
        }

        public static boolean setDefaultImpl(IStarAoiBoardManager r100) {
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
            if (r100 == 1598968902) goto L22;
            switch(r100) {
                case 1: goto L20;
                case 2: goto L18;
                case 3: goto L16;
                case 4: goto L14;
                case 5: goto L9;
                case 6: goto L7;
                default: goto L6;
            };
        L7:
            r101.enforceInterface(DESCRIPTOR);
            boolean r104 = isAoiBoardsRecovered();
            r102.writeNoException();
            r102.writeInt(r104 ? 1 : 0);
            return true;
        L9:
            r101.enforceInterface(DESCRIPTOR);
            AoiBoard r105 = findAoiBoardByPoiId(r101.readString());
            r102.writeNoException();
            if (r105 == null) goto L12;
            r102.writeInt(1);
            r105.writeToParcel(r102, 1);
        L13:
            return true;
        L12:
            r102.writeInt(0);
            goto L13
        L14:
            r101.enforceInterface(DESCRIPTOR);
            List<AoiBoard> r106 = listAoiBoardsByType(r101.readInt());
            r102.writeNoException();
            r102.writeTypedList(r106);
            return true;
        L16:
            r101.enforceInterface(DESCRIPTOR);
            List<AoiBoard> r107 = listAllAoiBoards();
            r102.writeNoException();
            r102.writeTypedList(r107);
            return true;
        L18:
            r101.enforceInterface(DESCRIPTOR);
            unregisterAoiBoardCallback();
            return true;
        L20:
            r101.enforceInterface(DESCRIPTOR);
            registerAoiBoardCallback(IStarAoiBoardCallback.Stub.asInterface(r101.readStrongBinder()));
            return true;
        L6:
            return super.onTransact(r100, r101, r102, r103);
        L22:
            r102.writeString(DESCRIPTOR);
            return true;
        }
    }

    AoiBoard findAoiBoardByPoiId(String r100) throws RemoteException;

    boolean isAoiBoardsRecovered() throws RemoteException;

    List<AoiBoard> listAllAoiBoards() throws RemoteException;

    List<AoiBoard> listAoiBoardsByType(int r100) throws RemoteException;

    void registerAoiBoardCallback(IStarAoiBoardCallback r100) throws RemoteException;

    void unregisterAoiBoardCallback() throws RemoteException;
}
