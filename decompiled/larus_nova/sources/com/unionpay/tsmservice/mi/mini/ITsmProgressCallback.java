package com.unionpay.tsmservice.mi.mini;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes41.dex */
public interface ITsmProgressCallback extends IInterface {

    public abstract class Stub extends Binder implements ITsmProgressCallback {

        final class a implements ITsmProgressCallback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static ITsmProgressCallback f462176a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private IBinder f462177b;

            public a(IBinder r100) {
                this.f462177b = r100;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f462177b;
            }

            @Override // com.unionpay.tsmservice.mi.mini.ITsmProgressCallback
            public final void onProgress(int r100) {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken("com.unionpay.tsmservice.mi.mini.ITsmProgressCallback");     // Catch: Throwable -> L12
                r101.writeInt(r100);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_unionpay_tsmservice_mi_mini_ITsmProgressCallback$Stub$a_com_obric_assistant_interaction_impl_BinderLancet_transact(this.f462177b, 1, r101, r102, 0) == false) goto L6;
            L10:
                r102.readException();     // Catch: Throwable -> L12
            L8:
                r102.recycle();
                r101.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onProgress(r100);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_unionpay_tsmservice_mi_mini_ITsmProgressCallback$Stub$a_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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
            attachInterface(this, "com.unionpay.tsmservice.mi.mini.ITsmProgressCallback");
        }

        public static ITsmProgressCallback asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface("com.unionpay.tsmservice.mi.mini.ITsmProgressCallback");
            if (r101 == null) goto L12;
            if ((r101 instanceof ITsmProgressCallback) == false) goto L12;
            return (ITsmProgressCallback) r101;
        L12:
            return new a(r100);
        }

        public static ITsmProgressCallback getDefaultImpl() {
            return a.f462176a;
        }

        public static boolean setDefaultImpl(ITsmProgressCallback r100) {
            if (a.f462176a != null) goto L10;
            if (r100 == null) goto L7;
            a.f462176a = r100;
            return true;
        L7:
            return false;
        L10:
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r100, Parcel r101, Parcel r102, int r103) {
            if (r100 != 1) goto L5;
            r101.enforceInterface("com.unionpay.tsmservice.mi.mini.ITsmProgressCallback");
            onProgress(r101.readInt());
            r102.writeNoException();
            return true;
        L5:
            if (r100 != 1598968902) goto L7;
            r102.writeString("com.unionpay.tsmservice.mi.mini.ITsmProgressCallback");
            return true;
        L7:
            return super.onTransact(r100, r101, r102, r103);
        }
    }

    void onProgress(int r100);
}
