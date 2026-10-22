package com.ss.android.push_common_lib;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import java.util.List;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes38.dex */
public interface ICrossProcessAIDL extends IInterface {

    public static class Default implements ICrossProcessAIDL {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.ss.android.push_common_lib.ICrossProcessAIDL
        public String invoke(String r100, String r101, List r102) throws RemoteException {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements ICrossProcessAIDL {
        private static final String DESCRIPTOR = "com.ss.android.push_common_lib.ICrossProcessAIDL";
        static final int TRANSACTION_invoke = 1;

        public static class Proxy implements ICrossProcessAIDL {
            public static ICrossProcessAIDL sDefaultImpl;
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

            @Override // com.ss.android.push_common_lib.ICrossProcessAIDL
            public String invoke(String r100, String r101, List r102) throws RemoteException {
                Parcel r103 = Parcel.obtain();
                Parcel r104 = Parcel.obtain();
                r103.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r103.writeString(r100);     // Catch: Throwable -> L13
                r103.writeString(r101);     // Catch: Throwable -> L13
                r103.writeList(r102);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_ss_android_push_common_lib_ICrossProcessAIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r103, r104, 0) == false) goto L6;
            L10:
                r104.readException();     // Catch: Throwable -> L13
                String r105 = r104.readString();     // Catch: Throwable -> L13
                r104.recycle();
                r103.recycle();
                return r105;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                String r106 = Stub.getDefaultImpl().invoke(r100, r101, r102);     // Catch: Throwable -> L13
                r104.recycle();
                r103.recycle();
                return r106;
            L13:
                th = move-exception;
                r104.recycle();
                r103.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_ss_android_push_common_lib_ICrossProcessAIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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

        public static ICrossProcessAIDL getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static ICrossProcessAIDL asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof ICrossProcessAIDL) == false) goto L12;
            return (ICrossProcessAIDL) r101;
        L12:
            return new Proxy(r100);
        }

        public static boolean setDefaultImpl(ICrossProcessAIDL r100) {
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
            String r104 = invoke(r101.readString(), r101.readString(), r101.readArrayList(getClass().getClassLoader()));
            r102.writeNoException();
            r102.writeString(r104);
            return true;
        L5:
            if (r100 != 1598968902) goto L7;
            r102.writeString(DESCRIPTOR);
            return true;
        L7:
            return super.onTransact(r100, r101, r102, r103);
        }
    }

    String invoke(String r100, String r101, List r102) throws RemoteException;
}
