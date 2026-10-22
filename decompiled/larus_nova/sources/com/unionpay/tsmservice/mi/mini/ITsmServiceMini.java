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
public interface ITsmServiceMini extends IInterface {

    public abstract class Stub extends Binder implements ITsmServiceMini {

        final class a implements ITsmServiceMini {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static ITsmServiceMini f462178a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private IBinder f462179b;

            public a(IBinder r100) {
                this.f462179b = r100;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f462179b;
            }

            @Override // com.unionpay.tsmservice.mi.mini.ITsmServiceMini
            public final int commonInterface(String r100, String r101, ITsmCallback r102, ITsmProgressCallback r103) {
                Parcel r104 = Parcel.obtain();
                Parcel r105 = Parcel.obtain();
                r104.writeInterfaceToken("com.unionpay.tsmservice.mi.mini.ITsmServiceMini");     // Catch: Throwable -> L20
                r104.writeString(r100);     // Catch: Throwable -> L20
                r104.writeString(r101);     // Catch: Throwable -> L20
                IBinder r106 = null;
                if (r102 == null) goto L6;
                IBinder r107 = r102.asBinder();     // Catch: Throwable -> L20
            L7:
                r104.writeStrongBinder(r107);     // Catch: Throwable -> L20
                if (r103 == null) goto L10;
                r106 = r103.asBinder();     // Catch: Throwable -> L20
            L10:
                r104.writeStrongBinder(r106);     // Catch: Throwable -> L20
                if (INVOKEINTERFACE_com_unionpay_tsmservice_mi_mini_ITsmServiceMini$Stub$a_com_obric_assistant_interaction_impl_BinderLancet_transact(this.f462179b, 1, r104, r105, 0) == false) goto L13;
            L17:
                r105.readException();     // Catch: Throwable -> L20
                int r108 = r105.readInt();     // Catch: Throwable -> L20
                r105.recycle();
                r104.recycle();
                return r108;
            L13:
                if (Stub.getDefaultImpl() == null) goto L17;
                int r109 = Stub.getDefaultImpl().commonInterface(r100, r101, r102, r103);     // Catch: Throwable -> L20
                r105.recycle();
                r104.recycle();
                return r109;
            L6:
                r107 = null;
            L20:
                th = move-exception;
                r105.recycle();
                r104.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_unionpay_tsmservice_mi_mini_ITsmServiceMini$Stub$a_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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
            attachInterface(this, "com.unionpay.tsmservice.mi.mini.ITsmServiceMini");
        }

        public static ITsmServiceMini asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface("com.unionpay.tsmservice.mi.mini.ITsmServiceMini");
            if (r101 == null) goto L12;
            if ((r101 instanceof ITsmServiceMini) == false) goto L12;
            return (ITsmServiceMini) r101;
        L12:
            return new a(r100);
        }

        public static ITsmServiceMini getDefaultImpl() {
            return a.f462178a;
        }

        public static boolean setDefaultImpl(ITsmServiceMini r100) {
            if (a.f462178a != null) goto L10;
            if (r100 == null) goto L7;
            a.f462178a = r100;
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
            r101.enforceInterface("com.unionpay.tsmservice.mi.mini.ITsmServiceMini");
            int r104 = commonInterface(r101.readString(), r101.readString(), ITsmCallback.Stub.asInterface(r101.readStrongBinder()), ITsmProgressCallback.Stub.asInterface(r101.readStrongBinder()));
            r102.writeNoException();
            r102.writeInt(r104);
            return true;
        L5:
            if (r100 != 1598968902) goto L7;
            r102.writeString("com.unionpay.tsmservice.mi.mini.ITsmServiceMini");
            return true;
        L7:
            return super.onTransact(r100, r101, r102, r103);
        }
    }

    int commonInterface(String r100, String r101, ITsmCallback r102, ITsmProgressCallback r103);
}
