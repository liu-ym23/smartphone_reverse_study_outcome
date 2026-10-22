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
import com.obric.capabilitykit.entity.EntityExtKt;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes33.dex */
public interface IGlobalSearchCallback extends IInterface {

    public static class Default implements IGlobalSearchCallback {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.capabilitykit.entity.search.global.IGlobalSearchCallback
        public void onAllCompleted() throws RemoteException {
        }

        @Override // com.obric.capabilitykit.entity.search.global.IGlobalSearchCallback
        public void onCompleted(int r100) throws RemoteException {
        }

        @Override // com.obric.capabilitykit.entity.search.global.IGlobalSearchCallback
        public void onError(int r100, int r101, String r102) throws RemoteException {
        }

        @Override // com.obric.capabilitykit.entity.search.global.IGlobalSearchCallback
        public void onSearchResult(GlobalSearchResult r100) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IGlobalSearchCallback {
        private static final String DESCRIPTOR = "com.obric.capabilitykit.entity.search.global.IGlobalSearchCallback";
        public static final int TRANSACTION_onAllCompleted = 3;
        public static final int TRANSACTION_onCompleted = 2;
        public static final int TRANSACTION_onError = 4;
        public static final int TRANSACTION_onSearchResult = 1;

        public static class Proxy implements IGlobalSearchCallback {
            public static IGlobalSearchCallback sDefaultImpl;
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

            @Override // com.obric.capabilitykit.entity.search.global.IGlobalSearchCallback
            public void onAllCompleted() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_capabilitykit_entity_search_global_IGlobalSearchCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L12
            L8:
                r101.recycle();
                r100.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onAllCompleted();     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.entity.search.global.IGlobalSearchCallback
            public void onCompleted(int r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r101.writeInt(r100);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_capabilitykit_entity_search_global_IGlobalSearchCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r101, r102, 0) == false) goto L6;
            L10:
                r102.readException();     // Catch: Throwable -> L12
            L8:
                r102.recycle();
                r101.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onCompleted(r100);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.entity.search.global.IGlobalSearchCallback
            public void onError(int r100, int r101, String r102) throws RemoteException {
                Parcel r103 = Parcel.obtain();
                Parcel r104 = Parcel.obtain();
                r103.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r103.writeInt(r100);     // Catch: Throwable -> L12
                r103.writeInt(r101);     // Catch: Throwable -> L12
                r103.writeString(r102);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_obric_capabilitykit_entity_search_global_IGlobalSearchCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r103, r104, 0) == false) goto L6;
            L10:
                r104.readException();     // Catch: Throwable -> L12
            L8:
                r104.recycle();
                r103.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onError(r100, r101, r102);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r104.recycle();
                r103.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.entity.search.global.IGlobalSearchCallback
            public void onSearchResult(GlobalSearchResult r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r100 == null) goto L6;
                r101.writeInt(1);     // Catch: Throwable -> L16
                r100.writeToParcel(r101, 0);     // Catch: Throwable -> L16
            L8:
                if (INVOKEINTERFACE_com_obric_capabilitykit_entity_search_global_IGlobalSearchCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r101, r102, 0) == false) goto L10;
            L14:
                r102.readException();     // Catch: Throwable -> L16
            L12:
                r102.recycle();
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().onSearchResult(r100);     // Catch: Throwable -> L16
                goto L12
            L6:
                r101.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_obric_capabilitykit_entity_search_global_IGlobalSearchCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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

        public static IGlobalSearchCallback asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof IGlobalSearchCallback) == false) goto L12;
            return (IGlobalSearchCallback) r101;
        L12:
            return new Proxy(r100);
        }

        public static IGlobalSearchCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IGlobalSearchCallback r100) {
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
            if (r100 == 1598968902) goto L23;
            if (r100 != 1) goto L6;
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L19;
            GlobalSearchResult.CREATOR.getClass();
            Intrinsics.checkNotNullParameter(r101, "parcel");
            GlobalSearchResult r104 = (GlobalSearchResult) GsonProtectorUtils.fromJson(EntityExtKt.a(), r101.readString(), GlobalSearchResult.class);
        L20:
            onSearchResult(r104);
        L21:
            r102.writeNoException();
            return true;
        L19:
            r104 = null;
            goto L20
        L6:
            if (r100 != 2) goto L8;
            r101.enforceInterface(DESCRIPTOR);
            onCompleted(r101.readInt());
            goto L21
        L8:
            if (r100 != 3) goto L10;
            r101.enforceInterface(DESCRIPTOR);
            onAllCompleted();
            goto L21
        L10:
            if (r100 != 4) goto L12;
            r101.enforceInterface(DESCRIPTOR);
            onError(r101.readInt(), r101.readInt(), r101.readString());
            goto L21
        L12:
            return super.onTransact(r100, r101, r102, r103);
        L23:
            r102.writeString(DESCRIPTOR);
            return true;
        }
    }

    void onAllCompleted() throws RemoteException;

    void onCompleted(int r100) throws RemoteException;

    void onError(int r100, int r101, String r102) throws RemoteException;

    void onSearchResult(GlobalSearchResult r100) throws RemoteException;
}
