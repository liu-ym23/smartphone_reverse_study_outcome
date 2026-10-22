package com.huawei.nfc.sdk.service;

import android.os.Binder;
import android.os.Bundle;
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
public interface ICUPOnlinePayCallBackService extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.nfc.sdk.service.ICUPOnlinePayCallBackService";

    public class Default implements ICUPOnlinePayCallBackService {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.huawei.nfc.sdk.service.ICUPOnlinePayCallBackService
        public void onError(String r100, String r101) {
        }

        @Override // com.huawei.nfc.sdk.service.ICUPOnlinePayCallBackService
        public void onResult(Bundle r100) {
        }
    }

    public abstract class Stub extends Binder implements ICUPOnlinePayCallBackService {
        static final int TRANSACTION_onError = 2;
        static final int TRANSACTION_onResult = 1;

        class Proxy implements ICUPOnlinePayCallBackService {
            private IBinder mRemote;

            public Proxy(IBinder r100) {
                this.mRemote = r100;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return ICUPOnlinePayCallBackService.DESCRIPTOR;
            }

            @Override // com.huawei.nfc.sdk.service.ICUPOnlinePayCallBackService
            public void onError(String r100, String r101) {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(ICUPOnlinePayCallBackService.DESCRIPTOR);     // Catch: Throwable -> L6
                r102.writeString(r100);     // Catch: Throwable -> L6
                r102.writeString(r101);     // Catch: Throwable -> L6
                INVOKEINTERFACE_com_huawei_nfc_sdk_service_ICUPOnlinePayCallBackService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r102, r103, 0);     // Catch: Throwable -> L6
                r103.readException();     // Catch: Throwable -> L6
                r103.recycle();
                r102.recycle();
                return;
            L6:
                th = move-exception;
                r103.recycle();
                r102.recycle();
                throw th;
            }

            @Override // com.huawei.nfc.sdk.service.ICUPOnlinePayCallBackService
            public void onResult(Bundle r100) {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(ICUPOnlinePayCallBackService.DESCRIPTOR);     // Catch: Throwable -> L6
                _Parcel.access$100(r101, r100, 0);     // Catch: Throwable -> L6
                INVOKEINTERFACE_com_huawei_nfc_sdk_service_ICUPOnlinePayCallBackService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r101, r102, 0);     // Catch: Throwable -> L6
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

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_huawei_nfc_sdk_service_ICUPOnlinePayCallBackService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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
            attachInterface(this, ICUPOnlinePayCallBackService.DESCRIPTOR);
        }

        public static ICUPOnlinePayCallBackService asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(ICUPOnlinePayCallBackService.DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof ICUPOnlinePayCallBackService) == false) goto L12;
            return (ICUPOnlinePayCallBackService) r101;
        L12:
            return new Proxy(r100);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r100, Parcel r101, Parcel r102, int r103) {
            if (r100 <= 0) goto L8;
            if (r100 > 16777215) goto L8;
            r101.enforceInterface(ICUPOnlinePayCallBackService.DESCRIPTOR);
        L8:
            if (r100 != 1598968902) goto L11;
            r102.writeString(ICUPOnlinePayCallBackService.DESCRIPTOR);
            return true;
        L11:
            if (r100 != 1) goto L13;
            onResult((Bundle) _Parcel.access$000(r101, Bundle.CREATOR));
        L18:
            r102.writeNoException();
            return true;
        L13:
            if (r100 != 2) goto L15;
            onError(r101.readString(), r101.readString());
            goto L18
        L15:
            return super.onTransact(r100, r101, r102, r103);
        }
    }

    public class _Parcel {
        public _Parcel() {
        }

        public static /* synthetic */ Object access$000(Parcel r100, Parcelable.Creator r101) {
            return readTypedObject(r100, r101);
        }

        public static /* synthetic */ void access$100(Parcel r100, Parcelable r101, int r102) {
            writeTypedObject(r100, r101, r102);
        }

        private static Object readTypedObject(Parcel r100, Parcelable.Creator r101) {
            if (r100.readInt() != 0) goto L5;
            return null;
        L5:
            return r101.createFromParcel(r100);
        }

        private static void writeTypedObject(Parcel r100, Parcelable r101, int r102) {
            if (r101 == null) goto L5;
            r100.writeInt(1);
            r101.writeToParcel(r100, r102);
            return;
        L5:
            r100.writeInt(0);
        }
    }

    void onError(String r100, String r101);

    void onResult(Bundle r100);
}
