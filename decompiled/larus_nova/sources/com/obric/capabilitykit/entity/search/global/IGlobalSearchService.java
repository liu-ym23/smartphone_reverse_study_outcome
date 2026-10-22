package com.obric.capabilitykit.entity.search.global;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import com.obric.capabilitykit.common.UtilsKt;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes33.dex */
public interface IGlobalSearchService extends IInterface {

    public static class Default implements IGlobalSearchService {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.capabilitykit.entity.search.global.IGlobalSearchService
        public void cancel(String r100) throws RemoteException {
        }

        @Override // com.obric.capabilitykit.entity.search.global.IGlobalSearchService
        public void startGlobalSearch(String r100, GlobalSearchRequest r101, IGlobalSearchCallback r102) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IGlobalSearchService {
        private static final String DESCRIPTOR = "com.obric.capabilitykit.entity.search.global.IGlobalSearchService";
        public static final int TRANSACTION_cancel = 2;
        public static final int TRANSACTION_startGlobalSearch = 1;

        public static class Proxy implements IGlobalSearchService {
            public static IGlobalSearchService sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder r100) {
                this.mRemote = r100;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.obric.capabilitykit.entity.search.global.IGlobalSearchService
            public void cancel(String r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r101.writeString(r100);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_capabilitykit_entity_search_global_IGlobalSearchService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r101, r102, 0) == false) goto L6;
            L10:
                r102.readException();     // Catch: Throwable -> L12
            L8:
                r102.recycle();
                r101.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().cancel(r100);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.obric.capabilitykit.entity.search.global.IGlobalSearchService
            public void startGlobalSearch(String r100, GlobalSearchRequest r101, IGlobalSearchCallback r102) throws RemoteException {
                Parcel r103 = Parcel.obtain();
                Parcel r104 = Parcel.obtain();
                r103.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L19
                r103.writeString(r100);     // Catch: Throwable -> L19
                if (r101 == null) goto L6;
                r103.writeInt(1);     // Catch: Throwable -> L19
                r101.writeToParcel(r103, 0);     // Catch: Throwable -> L19
            L7:
                if (r102 == null) goto L9;
                IBinder r105 = r102.asBinder();     // Catch: Throwable -> L19
            L10:
                r103.writeStrongBinder(r105);     // Catch: Throwable -> L19
                if (INVOKEINTERFACE_com_obric_capabilitykit_entity_search_global_IGlobalSearchService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r103, r104, 0) == false) goto L13;
            L17:
                r104.readException();     // Catch: Throwable -> L19
            L15:
                r104.recycle();
                r103.recycle();
                return;
            L13:
                if (Stub.getDefaultImpl() == null) goto L17;
                Stub.getDefaultImpl().startGlobalSearch(r100, r101, r102);     // Catch: Throwable -> L19
                goto L15
            L9:
                r105 = null;
                goto L10
            L6:
                r103.writeInt(0);     // Catch: Throwable -> L19
            L19:
                th = move-exception;
                r104.recycle();
                r103.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_obric_capabilitykit_entity_search_global_IGlobalSearchService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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

        public static IGlobalSearchService asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof IGlobalSearchService) == false) goto L12;
            return (IGlobalSearchService) r101;
        L12:
            return new Proxy(r100);
        }

        public static IGlobalSearchService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IGlobalSearchService r100) {
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
        public boolean onTransact(int r100, Parcel r101, Parcel r102, int r103) throws RemoteException {
            if (r100 != 1) goto L5;
            r101.enforceInterface(DESCRIPTOR);
            String r104 = r101.readString();
            if (r101.readInt() == 0) goto L16;
            GlobalSearchRequest.CREATOR.getClass();
            Intrinsics.checkNotNullParameter(r101, "parcel");
            GlobalSearchRequest r105 = (GlobalSearchRequest) GsonProtectorUtils.fromJson(UtilsKt.a(), r101.readString(), GlobalSearchRequest.class);
        L17:
            startGlobalSearch(r104, r105, IGlobalSearchCallback.Stub.asInterface(r101.readStrongBinder()));
        L18:
            r102.writeNoException();
            return true;
        L16:
            r105 = null;
            goto L17
        L5:
            if (r100 != 2) goto L7;
            r101.enforceInterface(DESCRIPTOR);
            cancel(r101.readString());
            goto L18
        L7:
            if (r100 != 1598968902) goto L9;
            r102.writeString(DESCRIPTOR);
            return true;
        L9:
            return super.onTransact(r100, r101, r102, r103);
        }
    }

    void cancel(String r100) throws RemoteException;

    void startGlobalSearch(String r100, GlobalSearchRequest r101, IGlobalSearchCallback r102) throws RemoteException;
}
