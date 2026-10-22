package com.unionpay.tsmservice.mi.mini;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes41.dex */
public interface ITsmCallback extends IInterface {

    public abstract class Stub extends Binder implements ITsmCallback {
        private static final String DESCRIPTOR = "com.unionpay.tsmservice.mi.mini.ITsmCallback";
        static final int TRANSACTION_onError = 2;
        static final int TRANSACTION_onResult = 1;

        final class a implements ITsmCallback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static ITsmCallback f462174a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private IBinder f462175b;

            public a(IBinder r100) {
                this.f462175b = r100;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f462175b;
            }

            @Override // com.unionpay.tsmservice.mi.mini.ITsmCallback
            public final void onError(String r100, String r101) {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r102.writeString(r100);     // Catch: Throwable -> L12
                r102.writeString(r101);     // Catch: Throwable -> L12
                if (INVOKEINTERFACE_com_unionpay_tsmservice_mi_mini_ITsmCallback$Stub$a_com_obric_assistant_interaction_impl_BinderLancet_transact(this.f462175b, 2, r102, r103, 0) == false) goto L6;
            L10:
                r103.readException();     // Catch: Throwable -> L12
            L8:
                r103.recycle();
                r102.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onError(r100, r101);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r103.recycle();
                r102.recycle();
                throw th;
            }

            @Override // com.unionpay.tsmservice.mi.mini.ITsmCallback
            public final void onResult(Bundle r100) {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r100 == null) goto L6;
                r101.writeInt(1);     // Catch: Throwable -> L16
                r100.writeToParcel(r101, 0);     // Catch: Throwable -> L16
            L8:
                if (INVOKEINTERFACE_com_unionpay_tsmservice_mi_mini_ITsmCallback$Stub$a_com_obric_assistant_interaction_impl_BinderLancet_transact(this.f462175b, 1, r101, r102, 0) == false) goto L10;
            L14:
                r102.readException();     // Catch: Throwable -> L16
            L12:
                r102.recycle();
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().onResult(r100);     // Catch: Throwable -> L16
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
            public static boolean INVOKEINTERFACE_com_unionpay_tsmservice_mi_mini_ITsmCallback$Stub$a_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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

        public static ITsmCallback asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof ITsmCallback) == false) goto L12;
            return (ITsmCallback) r101;
        L12:
            return new a(r100);
        }

        public static ITsmCallback getDefaultImpl() {
            return a.f462174a;
        }

        public static boolean setDefaultImpl(ITsmCallback r100) {
            if (a.f462174a != null) goto L10;
            if (r100 == null) goto L7;
            a.f462174a = r100;
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
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L18;
            Bundle r104 = (Bundle) Bundle.CREATOR.createFromParcel(r101);
        L19:
            onResult(r104);
        L13:
            r102.writeNoException();
            return true;
        L18:
            r104 = null;
            goto L19
        L5:
            if (r100 != 2) goto L7;
            r101.enforceInterface(DESCRIPTOR);
            onError(r101.readString(), r101.readString());
            goto L13
        L7:
            if (r100 != 1598968902) goto L9;
            r102.writeString(DESCRIPTOR);
            return true;
        L9:
            return super.onTransact(r100, r101, r102, r103);
        }
    }

    void onError(String r100, String r101);

    void onResult(Bundle r100);
}
