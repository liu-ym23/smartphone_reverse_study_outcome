package com.bytedance.ee.bear.contract.drive.sdk.entity.open;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public interface BinderPermissionCallback extends IInterface {

    public static abstract class Stub extends Binder implements BinderPermissionCallback {
        private static final String DESCRIPTOR = "com.bytedance.ee.bear.contract.drive.sdk.entity.open.BinderPermissionCallback";
        static final int TRANSACTION_handlePermission_DECLARED = 1;

        public static class Proxy implements BinderPermissionCallback {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public Proxy(IBinder r1) {
                this.mRemote = r1;
            }

            @Override // com.bytedance.ee.bear.contract.drive.sdk.entity.open.BinderPermissionCallback
            public boolean handlePermission(String r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                boolean r2 = false;
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6 RemoteException -> L8
                r0.writeString(r5);     // Catch: Throwable -> L6 RemoteException -> L8
                INVOKEINTERFACE_com_bytedance_ee_bear_contract_drive_sdk_entity_open_BinderPermissionCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r0, r1, 0);     // Catch: Throwable -> L6 RemoteException -> L8
                r1.readException();     // Catch: Throwable -> L6 RemoteException -> L8
                if (r1.readInt() == 0) goto L10;
                r2 = true;
            L10:
                r1.recycle();
                r0.recycle();
                return r2;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            L8:
                e = move-exception;
                e.printStackTrace();     // Catch: Throwable -> L6
                goto L10
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_bytedance_ee_bear_contract_drive_sdk_entity_open_BinderPermissionCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r16, int r17, Parcel r18, Parcel r19, int r110) throws RemoteException {
                if (Looper.myLooper() != Looper.getMainLooper()) goto L5;
                long r2 = SystemClock.uptimeMillis();
                boolean r0 = r16.transact(r17, r18, r19, r110);     // Catch: Throwable -> L12
                long r8 = SystemClock.uptimeMillis() - r2;
                if (r8 < 100) goto L11;
                BinderPerformanceReporter.report(r8, r16.getClass().getName(), r17, r110, new Throwable("Slow main-thread Binder transaction"));
            L11:
                return r0;
            L12:
                th = move-exception;
                long r9 = SystemClock.uptimeMillis() - r2;
                if (r9 < 100) goto L22;
                if (r16 != null) goto L17;
                String r1 = "";
            L18:
                BinderPerformanceReporter.report(r9, r1, r17, r110, new Throwable("Slow main-thread Binder transaction"));
                throw th;
            L17:
                r1 = r16.getClass().getName();
                goto L18
            L22:
                throw th;
            L5:
                return r16.transact(r17, r18, r19, r110);
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // com.bytedance.ee.bear.contract.drive.sdk.entity.open.BinderPermissionCallback
        public abstract /* synthetic */ boolean handlePermission(String r1);

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static BinderPermissionCallback asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof BinderPermissionCallback) == false) goto L12;
            return (BinderPermissionCallback) r0;
        L12:
            return new Proxy(r2);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) throws RemoteException {
            if (r4 != 1) goto L5;
            r5.enforceInterface(DESCRIPTOR);
            boolean r8 = handlePermission(r5.readString());
            r6.writeNoException();
            r6.writeInt(r8 ? 1 : 0);
            return true;
        L5:
            if (r4 != 1598968902) goto L7;
            r6.writeString(DESCRIPTOR);
            return true;
        L7:
            return super.onTransact(r4, r5, r6, r7);
        }
    }

    /* synthetic */ boolean handlePermission(String r1);
}
