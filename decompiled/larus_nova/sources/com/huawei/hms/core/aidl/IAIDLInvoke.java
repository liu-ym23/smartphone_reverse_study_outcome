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
public interface IAIDLInvoke extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.hms.core.aidl.IAIDLInvoke";

    public static abstract class Stub extends Binder implements IAIDLInvoke {

        public static class a implements IAIDLInvoke {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f277136a;

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f277136a;
            }

            public a(IBinder r100) {
                this.f277136a = r100;
            }

            @Override // com.huawei.hms.core.aidl.IAIDLInvoke
            public void syncCall(DataBuffer r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(IAIDLInvoke.DESCRIPTOR);     // Catch: Throwable -> L6
                a.a(r101, r100, 0);     // Catch: Throwable -> L6
                INVOKEINTERFACE_com_huawei_hms_core_aidl_IAIDLInvoke$Stub$a_com_obric_assistant_interaction_impl_BinderLancet_transact(this.f277136a, 1, r101, r102, 0);     // Catch: Throwable -> L6
                r102.readException();     // Catch: Throwable -> L6
                r102.recycle();
                r101.recycle();
                return;
            L6:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.huawei.hms.core.aidl.IAIDLInvoke
            public void asyncCall(DataBuffer r100, IAIDLCallback r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                r102.writeInterfaceToken(IAIDLInvoke.DESCRIPTOR);     // Catch: Throwable -> L6
                a.a(r102, r100, 0);     // Catch: Throwable -> L6
                r102.writeStrongInterface(r101);     // Catch: Throwable -> L6
                INVOKEINTERFACE_com_huawei_hms_core_aidl_IAIDLInvoke$Stub$a_com_obric_assistant_interaction_impl_BinderLancet_transact(this.f277136a, 2, r102, null, 1);     // Catch: Throwable -> L6
                r102.recycle();
                return;
            L6:
                th = move-exception;
                r102.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_huawei_hms_core_aidl_IAIDLInvoke$Stub$a_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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
            attachInterface(this, IAIDLInvoke.DESCRIPTOR);
        }

        public static IAIDLInvoke asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(IAIDLInvoke.DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof IAIDLInvoke) == false) goto L12;
            return (IAIDLInvoke) r101;
        L12:
            return new a(r100);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r100, Parcel r101, Parcel r102, int r103) throws RemoteException {
            if (r100 < 1) goto L8;
            if (r100 > 16777215) goto L8;
            r101.enforceInterface(IAIDLInvoke.DESCRIPTOR);
        L8:
            if (r100 == 1598968902) goto L17;
            if (r100 != 1) goto L11;
            syncCall((DataBuffer) a.a(r101, DataBuffer.CREATOR));
            r102.writeNoException();
        L16:
            return true;
        L11:
            if (r100 != 2) goto L13;
            asyncCall((DataBuffer) a.a(r101, DataBuffer.CREATOR), IAIDLCallback.Stub.asInterface(r101.readStrongBinder()));
            goto L16
        L13:
            return super.onTransact(r100, r101, r102, r103);
        L17:
            r102.writeString(IAIDLInvoke.DESCRIPTOR);
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

    void asyncCall(DataBuffer r100, IAIDLCallback r101) throws RemoteException;

    void syncCall(DataBuffer r100) throws RemoteException;
}
