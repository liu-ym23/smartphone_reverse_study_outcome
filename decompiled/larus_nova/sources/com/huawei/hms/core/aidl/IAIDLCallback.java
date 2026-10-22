package com.huawei.hms.core.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes23.dex */
public interface IAIDLCallback extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.hms.core.aidl.IAIDLCallback";

    public static abstract class Stub extends Binder implements IAIDLCallback {
        static final int TRANSACTION_call = 1;

        public static class a implements IAIDLCallback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f277135a;

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f277135a;
            }

            public a(IBinder r100) {
                this.f277135a = r100;
            }

            @Override // com.huawei.hms.core.aidl.IAIDLCallback
            public void call(DataBuffer r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(IAIDLCallback.DESCRIPTOR);     // Catch: Throwable -> L6
                a.a(r101, r100, 0);     // Catch: Throwable -> L6
                INVOKEINTERFACE_com_huawei_hms_core_aidl_IAIDLCallback$Stub$a_com_obric_assistant_interaction_impl_BinderLancet_transact(this.f277135a, 1, r101, null, 1);     // Catch: Throwable -> L6
                r101.recycle();
                return;
            L6:
                th = move-exception;
                r101.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_huawei_hms_core_aidl_IAIDLCallback$Stub$a_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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
            attachInterface(this, IAIDLCallback.DESCRIPTOR);
        }

        public static IAIDLCallback asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(IAIDLCallback.DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof IAIDLCallback) == false) goto L12;
            return (IAIDLCallback) r101;
        L12:
            return new a(r100);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r100, Parcel r101, Parcel r102, int r103) throws RemoteException {
            if (r100 < 1) goto L8;
            if (r100 > 16777215) goto L8;
            r101.enforceInterface(IAIDLCallback.DESCRIPTOR);
        L8:
            if (r100 == 1598968902) goto L14;
            if (r100 != 1) goto L11;
            call((DataBuffer) a.a(r101, DataBuffer.CREATOR));
            return true;
        L11:
            return super.onTransact(r100, r101, r102, r103);
        L14:
            r102.writeString(IAIDLCallback.DESCRIPTOR);
            return true;
        }
    }

    public static class a {
        public static /* synthetic */ Object a(Parcel r100, Parcelable.Creator r101) {
            return b(r100, r101);
        }

        private static <T> T b(Parcel r100, Parcelable.Creator<T> r101) {
            if (r100.readInt() != 0) goto L5;
            return null;
        L5:
            return r101.createFromParcel(r100);
        }

        public static /* synthetic */ void a(Parcel r100, Parcelable r101, int r102) {
            b(r100, r101, r102);
        }

        private static <T extends Parcelable> void b(Parcel r100, T r101, int r102) {
            if (r101 == null) goto L4;
            r100.writeInt(1);
            r101.writeToParcel(r100, r102);
            return;
        L4:
            r100.writeInt(0);
        }
    }

    void call(DataBuffer r100) throws RemoteException;
}
