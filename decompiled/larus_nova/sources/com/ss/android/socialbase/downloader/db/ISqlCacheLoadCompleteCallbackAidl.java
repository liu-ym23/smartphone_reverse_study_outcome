package com.ss.android.socialbase.downloader.db;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes5.dex */
public interface ISqlCacheLoadCompleteCallbackAidl extends IInterface {

    /* JADX INFO: loaded from: classes38.dex */
    public static class Default implements ISqlCacheLoadCompleteCallbackAidl {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.db.ISqlCacheLoadCompleteCallbackAidl
        public void callback(Map r100, List r101, Map r102, boolean r103) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements ISqlCacheLoadCompleteCallbackAidl {
        private static final String DESCRIPTOR = "com.ss.android.socialbase.downloader.db.ISqlCacheLoadCompleteCallbackAidl";
        static final int TRANSACTION_callback = 1;

        public static class Proxy implements ISqlCacheLoadCompleteCallbackAidl {
            public static ISqlCacheLoadCompleteCallbackAidl sDefaultImpl;
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

            @Override // com.ss.android.socialbase.downloader.db.ISqlCacheLoadCompleteCallbackAidl
            public void callback(Map r100, List r101, Map r102, boolean r103) throws RemoteException {
                Parcel r104 = Parcel.obtain();
                Parcel r105 = Parcel.obtain();
                r104.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r104.writeMap(r100);     // Catch: Throwable -> L17
                r104.writeList(r101);     // Catch: Throwable -> L17
                r104.writeMap(r102);     // Catch: Throwable -> L17
                if (r103 == false) goto L6;
                int r106 = 1;
            L7:
                r104.writeInt(r106);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_db_ISqlCacheLoadCompleteCallbackAidl$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r104, r105, 0) == false) goto L10;
            L14:
                r105.readException();     // Catch: Throwable -> L17
                r105.recycle();
                r104.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().callback(r100, r101, r102, r103);     // Catch: Throwable -> L17
                r105.recycle();
                r104.recycle();
                return;
            L6:
                r106 = 0;
            L17:
                th = move-exception;
                r105.recycle();
                r104.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_ss_android_socialbase_downloader_db_ISqlCacheLoadCompleteCallbackAidl$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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

        public static ISqlCacheLoadCompleteCallbackAidl getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static ISqlCacheLoadCompleteCallbackAidl asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof ISqlCacheLoadCompleteCallbackAidl) == false) goto L12;
            return (ISqlCacheLoadCompleteCallbackAidl) r101;
        L12:
            return new Proxy(r100);
        }

        public static boolean setDefaultImpl(ISqlCacheLoadCompleteCallbackAidl r100) {
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
            ClassLoader r104 = getClass().getClassLoader();
            HashMap r105 = r101.readHashMap(r104);
            ArrayList r106 = r101.readArrayList(r104);
            HashMap r107 = r101.readHashMap(r104);
            if (r101.readInt() == 0) goto L13;
            boolean r108 = true;
        L14:
            callback(r105, r106, r107, r108);
            r102.writeNoException();
            return true;
        L13:
            r108 = false;
            goto L14
        L5:
            if (r100 != 1598968902) goto L7;
            r102.writeString(DESCRIPTOR);
            return true;
        L7:
            return super.onTransact(r100, r101, r102, r103);
        }
    }

    void callback(Map r100, List r101, Map r102, boolean r103) throws RemoteException;
}
