package com.obric.memorydata.sdk.awareness;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import com.obric.memorydata.sdk.MemoryResponse;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes6.dex */
public interface IContextAwarenessService extends IInterface {

    /* JADX INFO: loaded from: classes33.dex */
    public static class Default implements IContextAwarenessService {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.memorydata.sdk.awareness.IContextAwarenessService
        public MemoryResponse getFeature(String r100) throws RemoteException {
            return null;
        }

        @Override // com.obric.memorydata.sdk.awareness.IContextAwarenessService
        public MemoryResponse getGeoFenceStatus(String r100) throws RemoteException {
            return null;
        }

        @Override // com.obric.memorydata.sdk.awareness.IContextAwarenessService
        public MemoryResponse getLocation(String r100) throws RemoteException {
            return null;
        }

        @Override // com.obric.memorydata.sdk.awareness.IContextAwarenessService
        public MemoryResponse registerEvent(String r100, IEventChangeListener r101) throws RemoteException {
            return null;
        }

        @Override // com.obric.memorydata.sdk.awareness.IContextAwarenessService
        public MemoryResponse registerFeature(String r100, IFeatureChangeListener r101) throws RemoteException {
            return null;
        }

        @Override // com.obric.memorydata.sdk.awareness.IContextAwarenessService
        public MemoryResponse registerFeatureDuration(String r100, String r101, long r102, boolean r103, IFeatureDurationListener r104) throws RemoteException {
            return null;
        }

        @Override // com.obric.memorydata.sdk.awareness.IContextAwarenessService
        public MemoryResponse setLocation(String r100, double r101, double r102, String r103, String r104) throws RemoteException {
            return null;
        }

        @Override // com.obric.memorydata.sdk.awareness.IContextAwarenessService
        public MemoryResponse unregisterFeature(String r100, IFeatureChangeListener r101) throws RemoteException {
            return null;
        }

        @Override // com.obric.memorydata.sdk.awareness.IContextAwarenessService
        public MemoryResponse unregisterFeatureDuration(String r100, String r101, long r102, boolean r103, IFeatureDurationListener r104) throws RemoteException {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IContextAwarenessService {
        private static final String DESCRIPTOR = "com.obric.memorydata.sdk.awareness.IContextAwarenessService";
        static final int TRANSACTION_getFeature = 1;
        static final int TRANSACTION_getGeoFenceStatus = 9;
        static final int TRANSACTION_getLocation = 4;
        static final int TRANSACTION_registerEvent = 5;
        static final int TRANSACTION_registerFeature = 2;
        static final int TRANSACTION_registerFeatureDuration = 6;
        static final int TRANSACTION_setLocation = 8;
        static final int TRANSACTION_unregisterFeature = 3;
        static final int TRANSACTION_unregisterFeatureDuration = 7;

        public static class Proxy implements IContextAwarenessService {
            public static IContextAwarenessService sDefaultImpl;
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

            @Override // com.obric.memorydata.sdk.awareness.IContextAwarenessService
            public MemoryResponse getFeature(String r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                r101.writeString(r100);     // Catch: Throwable -> L15
                if (INVOKEINTERFACE_com_obric_memorydata_sdk_awareness_IContextAwarenessService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r101, r102, 0) == false) goto L6;
            L10:
                r102.readException();     // Catch: Throwable -> L15
                if (r102.readInt() == 0) goto L14;
                MemoryResponse.CREATOR.getClass();     // Catch: Throwable -> L15
                MemoryResponse r103 = MemoryResponse.a.a(r102);     // Catch: Throwable -> L15
            L8:
                r102.recycle();
                r101.recycle();
                return r103;
            L14:
                r103 = null;
                goto L8
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r103 = Stub.getDefaultImpl().getFeature(r100);     // Catch: Throwable -> L15
            L15:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.obric.memorydata.sdk.awareness.IContextAwarenessService
            public MemoryResponse getGeoFenceStatus(String r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                r101.writeString(r100);     // Catch: Throwable -> L15
                if (INVOKEINTERFACE_com_obric_memorydata_sdk_awareness_IContextAwarenessService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 9, r101, r102, 0) == false) goto L6;
            L10:
                r102.readException();     // Catch: Throwable -> L15
                if (r102.readInt() == 0) goto L14;
                MemoryResponse.CREATOR.getClass();     // Catch: Throwable -> L15
                MemoryResponse r103 = MemoryResponse.a.a(r102);     // Catch: Throwable -> L15
            L8:
                r102.recycle();
                r101.recycle();
                return r103;
            L14:
                r103 = null;
                goto L8
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r103 = Stub.getDefaultImpl().getGeoFenceStatus(r100);     // Catch: Throwable -> L15
            L15:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.obric.memorydata.sdk.awareness.IContextAwarenessService
            public MemoryResponse getLocation(String r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                r101.writeString(r100);     // Catch: Throwable -> L15
                if (INVOKEINTERFACE_com_obric_memorydata_sdk_awareness_IContextAwarenessService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r101, r102, 0) == false) goto L6;
            L10:
                r102.readException();     // Catch: Throwable -> L15
                if (r102.readInt() == 0) goto L14;
                MemoryResponse.CREATOR.getClass();     // Catch: Throwable -> L15
                MemoryResponse r103 = MemoryResponse.a.a(r102);     // Catch: Throwable -> L15
            L8:
                r102.recycle();
                r101.recycle();
                return r103;
            L14:
                r103 = null;
                goto L8
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r103 = Stub.getDefaultImpl().getLocation(r100);     // Catch: Throwable -> L15
            L15:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.obric.memorydata.sdk.awareness.IContextAwarenessService
            public MemoryResponse registerEvent(String r100, IEventChangeListener r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L19
                r102.writeString(r100);     // Catch: Throwable -> L19
                MemoryResponse r104 = null;
                if (r101 == null) goto L6;
                IBinder r105 = r101.asBinder();     // Catch: Throwable -> L19
            L7:
                r102.writeStrongBinder(r105);     // Catch: Throwable -> L19
                if (INVOKEINTERFACE_com_obric_memorydata_sdk_awareness_IContextAwarenessService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 5, r102, r103, 0) == false) goto L10;
            L14:
                r103.readException();     // Catch: Throwable -> L19
                if (r103.readInt() == 0) goto L17;
                MemoryResponse.CREATOR.getClass();     // Catch: Throwable -> L19
                r104 = MemoryResponse.a.a(r103);     // Catch: Throwable -> L19
            L17:
                r103.recycle();
                r102.recycle();
                return r104;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                MemoryResponse r106 = Stub.getDefaultImpl().registerEvent(r100, r101);     // Catch: Throwable -> L19
                r103.recycle();
                r102.recycle();
                return r106;
            L6:
                r105 = null;
            L19:
                th = move-exception;
                r103.recycle();
                r102.recycle();
                throw th;
            }

            @Override // com.obric.memorydata.sdk.awareness.IContextAwarenessService
            public MemoryResponse registerFeature(String r100, IFeatureChangeListener r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L19
                r102.writeString(r100);     // Catch: Throwable -> L19
                MemoryResponse r104 = null;
                if (r101 == null) goto L6;
                IBinder r105 = r101.asBinder();     // Catch: Throwable -> L19
            L7:
                r102.writeStrongBinder(r105);     // Catch: Throwable -> L19
                if (INVOKEINTERFACE_com_obric_memorydata_sdk_awareness_IContextAwarenessService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r102, r103, 0) == false) goto L10;
            L14:
                r103.readException();     // Catch: Throwable -> L19
                if (r103.readInt() == 0) goto L17;
                MemoryResponse.CREATOR.getClass();     // Catch: Throwable -> L19
                r104 = MemoryResponse.a.a(r103);     // Catch: Throwable -> L19
            L17:
                r103.recycle();
                r102.recycle();
                return r104;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                MemoryResponse r106 = Stub.getDefaultImpl().registerFeature(r100, r101);     // Catch: Throwable -> L19
                r103.recycle();
                r102.recycle();
                return r106;
            L6:
                r105 = null;
            L19:
                th = move-exception;
                r103.recycle();
                r102.recycle();
                throw th;
            }

            @Override // com.obric.memorydata.sdk.awareness.IContextAwarenessService
            public MemoryResponse unregisterFeature(String r100, IFeatureChangeListener r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L19
                r102.writeString(r100);     // Catch: Throwable -> L19
                MemoryResponse r104 = null;
                if (r101 == null) goto L6;
                IBinder r105 = r101.asBinder();     // Catch: Throwable -> L19
            L7:
                r102.writeStrongBinder(r105);     // Catch: Throwable -> L19
                if (INVOKEINTERFACE_com_obric_memorydata_sdk_awareness_IContextAwarenessService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r102, r103, 0) == false) goto L10;
            L14:
                r103.readException();     // Catch: Throwable -> L19
                if (r103.readInt() == 0) goto L17;
                MemoryResponse.CREATOR.getClass();     // Catch: Throwable -> L19
                r104 = MemoryResponse.a.a(r103);     // Catch: Throwable -> L19
            L17:
                r103.recycle();
                r102.recycle();
                return r104;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                MemoryResponse r106 = Stub.getDefaultImpl().unregisterFeature(r100, r101);     // Catch: Throwable -> L19
                r103.recycle();
                r102.recycle();
                return r106;
            L6:
                r105 = null;
            L19:
                th = move-exception;
                r103.recycle();
                r102.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_obric_memorydata_sdk_awareness_IContextAwarenessService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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

            @Override // com.obric.memorydata.sdk.awareness.IContextAwarenessService
            public MemoryResponse registerFeatureDuration(String r110, String r111, long r112, boolean r113, IFeatureDurationListener r114) throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L28
                r100.writeString(r110);     // Catch: Throwable -> L28
                r100.writeString(r111);     // Catch: Throwable -> L28
                r100.writeLong(r112);     // Catch: Throwable -> L28
                if (r113 == false) goto L6;
                int r102 = 1;
            L7:
                r100.writeInt(r102);     // Catch: Throwable -> L28
                MemoryResponse r103 = null;
                if (r114 == null) goto L10;
                IBinder r104 = r114.asBinder();     // Catch: Throwable -> L28
            L11:
                r100.writeStrongBinder(r104);     // Catch: Throwable -> L28
            L24:
                th = th;
            L30:
                r101.recycle();
                r100.recycle();
                throw th;
            L14:
                if (INVOKEINTERFACE_com_obric_memorydata_sdk_awareness_IContextAwarenessService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 6, r100, r101, 0) == false) goto L16;
            L20:
                r101.readException();     // Catch: Throwable -> L24
                if (r101.readInt() == 0) goto L26;
                MemoryResponse.CREATOR.getClass();     // Catch: Throwable -> L24
                r103 = MemoryResponse.a.a(r101);     // Catch: Throwable -> L24
            L26:
                r101.recycle();
                r100.recycle();
                return r103;
            L16:
                if (Stub.getDefaultImpl() == null) goto L20;
                MemoryResponse r105 = Stub.getDefaultImpl().registerFeatureDuration(r110, r111, r112, r113, r114);     // Catch: Throwable -> L24
                r101.recycle();
                r100.recycle();
                return r105;
            L10:
                r104 = null;
                goto L11
            L6:
                r102 = 0;
            L28:
                th = th;
                goto L30
            }

            @Override // com.obric.memorydata.sdk.awareness.IContextAwarenessService
            public MemoryResponse setLocation(String r110, double r111, double r112, String r113, String r210) throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L19
                r100.writeString(r110);     // Catch: Throwable -> L19
                r100.writeDouble(r111);     // Catch: Throwable -> L19
                r100.writeDouble(r112);     // Catch: Throwable -> L19
                r100.writeString(r113);     // Catch: Throwable -> L19
                r100.writeString(r210);     // Catch: Throwable -> L19
            L16:
                th = th;
            L21:
                r101.recycle();
                r100.recycle();
                throw th;
            L6:
                if (INVOKEINTERFACE_com_obric_memorydata_sdk_awareness_IContextAwarenessService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 8, r100, r101, 0) == false) goto L8;
            L12:
                r101.readException();     // Catch: Throwable -> L16
                if (r101.readInt() == 0) goto L18;
                MemoryResponse.CREATOR.getClass();     // Catch: Throwable -> L16
                MemoryResponse r102 = MemoryResponse.a.a(r101);     // Catch: Throwable -> L16
            L10:
                r101.recycle();
                r100.recycle();
                return r102;
            L18:
                r102 = null;
                goto L10
            L8:
                if (Stub.getDefaultImpl() == null) goto L12;
                r102 = Stub.getDefaultImpl().setLocation(r110, r111, r112, r113, r210);     // Catch: Throwable -> L16
            L19:
                th = th;
                goto L21
            }

            @Override // com.obric.memorydata.sdk.awareness.IContextAwarenessService
            public MemoryResponse unregisterFeatureDuration(String r110, String r111, long r112, boolean r113, IFeatureDurationListener r114) throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L28
                r100.writeString(r110);     // Catch: Throwable -> L28
                r100.writeString(r111);     // Catch: Throwable -> L28
                r100.writeLong(r112);     // Catch: Throwable -> L28
                if (r113 == false) goto L6;
                int r102 = 1;
            L7:
                r100.writeInt(r102);     // Catch: Throwable -> L28
                MemoryResponse r103 = null;
                if (r114 == null) goto L10;
                IBinder r104 = r114.asBinder();     // Catch: Throwable -> L28
            L11:
                r100.writeStrongBinder(r104);     // Catch: Throwable -> L28
            L24:
                th = th;
            L30:
                r101.recycle();
                r100.recycle();
                throw th;
            L14:
                if (INVOKEINTERFACE_com_obric_memorydata_sdk_awareness_IContextAwarenessService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 7, r100, r101, 0) == false) goto L16;
            L20:
                r101.readException();     // Catch: Throwable -> L24
                if (r101.readInt() == 0) goto L26;
                MemoryResponse.CREATOR.getClass();     // Catch: Throwable -> L24
                r103 = MemoryResponse.a.a(r101);     // Catch: Throwable -> L24
            L26:
                r101.recycle();
                r100.recycle();
                return r103;
            L16:
                if (Stub.getDefaultImpl() == null) goto L20;
                MemoryResponse r105 = Stub.getDefaultImpl().unregisterFeatureDuration(r110, r111, r112, r113, r114);     // Catch: Throwable -> L24
                r101.recycle();
                r100.recycle();
                return r105;
            L10:
                r104 = null;
                goto L11
            L6:
                r102 = 0;
            L28:
                th = th;
                goto L30
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IContextAwarenessService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static IContextAwarenessService asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof IContextAwarenessService) == false) goto L12;
            return (IContextAwarenessService) r101;
        L12:
            return new Proxy(r100);
        }

        public static boolean setDefaultImpl(IContextAwarenessService r100) {
            if (Proxy.sDefaultImpl != null) goto L7;
            if (r100 == null) goto L9;
            Proxy.sDefaultImpl = r100;
            return true;
        L9:
            return false;
        L7:
            return false;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r110, Parcel r111, Parcel r112, int r113) throws RemoteException {
            if (r110 != 1598968902) goto L5;
            r112.writeString(DESCRIPTOR);
            return true;
        L5:
            switch(r110) {
                case 1: goto L56;
                case 2: goto L51;
                case 3: goto L46;
                case 4: goto L41;
                case 5: goto L36;
                case 6: goto L27;
                case 7: goto L18;
                case 8: goto L13;
                case 9: goto L8;
                default: goto L7;
            };
        L8:
            r111.enforceInterface(DESCRIPTOR);
            MemoryResponse r114 = getGeoFenceStatus(r111.readString());
            r112.writeNoException();
            if (r114 == null) goto L11;
            r112.writeInt(1);
            r114.writeToParcel(r112, 1);
        L12:
            return true;
        L11:
            r112.writeInt(0);
            goto L12
        L13:
            r111.enforceInterface(DESCRIPTOR);
            MemoryResponse r115 = setLocation(r111.readString(), r111.readDouble(), r111.readDouble(), r111.readString(), r111.readString());
            r112.writeNoException();
            if (r115 == null) goto L16;
            r112.writeInt(1);
            r115.writeToParcel(r112, 1);
        L17:
            return true;
        L16:
            r112.writeInt(0);
            goto L17
        L18:
            r111.enforceInterface(DESCRIPTOR);
            String r100 = r111.readString();
            String r101 = r111.readString();
            long r102 = r111.readLong();
            if (r111.readInt() == 0) goto L21;
            boolean r103 = true;
        L22:
            MemoryResponse r116 = unregisterFeatureDuration(r100, r101, r102, r103, IFeatureDurationListener.Stub.asInterface(r111.readStrongBinder()));
            r112.writeNoException();
            if (r116 == null) goto L25;
            r112.writeInt(1);
            r116.writeToParcel(r112, 1);
        L26:
            return true;
        L25:
            r112.writeInt(0);
            goto L26
        L21:
            r103 = false;
            goto L22
        L27:
            r111.enforceInterface(DESCRIPTOR);
            String r104 = r111.readString();
            String r105 = r111.readString();
            long r106 = r111.readLong();
            if (r111.readInt() == 0) goto L30;
            boolean r107 = true;
        L31:
            MemoryResponse r117 = registerFeatureDuration(r104, r105, r106, r107, IFeatureDurationListener.Stub.asInterface(r111.readStrongBinder()));
            r112.writeNoException();
            if (r117 == null) goto L34;
            r112.writeInt(1);
            r117.writeToParcel(r112, 1);
        L35:
            return true;
        L34:
            r112.writeInt(0);
            goto L35
        L30:
            r107 = false;
            goto L31
        L36:
            r111.enforceInterface(DESCRIPTOR);
            MemoryResponse r118 = registerEvent(r111.readString(), IEventChangeListener.Stub.asInterface(r111.readStrongBinder()));
            r112.writeNoException();
            if (r118 == null) goto L39;
            r112.writeInt(1);
            r118.writeToParcel(r112, 1);
        L40:
            return true;
        L39:
            r112.writeInt(0);
            goto L40
        L41:
            r111.enforceInterface(DESCRIPTOR);
            MemoryResponse r119 = getLocation(r111.readString());
            r112.writeNoException();
            if (r119 == null) goto L44;
            r112.writeInt(1);
            r119.writeToParcel(r112, 1);
        L45:
            return true;
        L44:
            r112.writeInt(0);
            goto L45
        L46:
            r111.enforceInterface(DESCRIPTOR);
            MemoryResponse r120 = unregisterFeature(r111.readString(), IFeatureChangeListener.Stub.asInterface(r111.readStrongBinder()));
            r112.writeNoException();
            if (r120 == null) goto L49;
            r112.writeInt(1);
            r120.writeToParcel(r112, 1);
        L50:
            return true;
        L49:
            r112.writeInt(0);
            goto L50
        L51:
            r111.enforceInterface(DESCRIPTOR);
            MemoryResponse r121 = registerFeature(r111.readString(), IFeatureChangeListener.Stub.asInterface(r111.readStrongBinder()));
            r112.writeNoException();
            if (r121 == null) goto L54;
            r112.writeInt(1);
            r121.writeToParcel(r112, 1);
        L55:
            return true;
        L54:
            r112.writeInt(0);
            goto L55
        L56:
            r111.enforceInterface(DESCRIPTOR);
            MemoryResponse r122 = getFeature(r111.readString());
            r112.writeNoException();
            if (r122 == null) goto L59;
            r112.writeInt(1);
            r122.writeToParcel(r112, 1);
        L60:
            return true;
        L59:
            r112.writeInt(0);
            goto L60
        L7:
            return super.onTransact(r110, r111, r112, r113);
        }
    }

    MemoryResponse getFeature(String r100) throws RemoteException;

    MemoryResponse getGeoFenceStatus(String r100) throws RemoteException;

    MemoryResponse getLocation(String r100) throws RemoteException;

    MemoryResponse registerEvent(String r100, IEventChangeListener r101) throws RemoteException;

    MemoryResponse registerFeature(String r100, IFeatureChangeListener r101) throws RemoteException;

    MemoryResponse registerFeatureDuration(String r100, String r101, long r102, boolean r103, IFeatureDurationListener r104) throws RemoteException;

    MemoryResponse setLocation(String r100, double r101, double r102, String r103, String r104) throws RemoteException;

    MemoryResponse unregisterFeature(String r100, IFeatureChangeListener r101) throws RemoteException;

    MemoryResponse unregisterFeatureDuration(String r100, String r101, long r102, boolean r103, IFeatureDurationListener r104) throws RemoteException;
}
