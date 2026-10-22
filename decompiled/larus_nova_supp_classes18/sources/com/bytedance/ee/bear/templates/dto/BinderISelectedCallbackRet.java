package com.bytedance.ee.bear.templates.dto;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public interface BinderISelectedCallbackRet extends IInterface {

    public static abstract class Stub extends Binder implements BinderISelectedCallbackRet {
        private static final String DESCRIPTOR = "com.bytedance.ee.bear.templates.dto.BinderISelectedCallbackRet";
        static final int TRANSACTION_close = 1;
        static final int TRANSACTION_success = 2;
        static final int TRANSACTION_toastTip = 4;
        static final int TRANSACTION_url = 3;

        public static class Proxy implements BinderISelectedCallbackRet {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.bytedance.ee.bear.templates.dto.BinderISelectedCallbackRet
            public boolean close() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                boolean r2 = false;
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6 RemoteException -> L8
                INVOKEINTERFACE_com_bytedance_ee_bear_templates_dto_BinderISelectedCallbackRet$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r0, r1, 0);     // Catch: Throwable -> L6 RemoteException -> L8
                r1.readException();     // Catch: Throwable -> L6 RemoteException -> L8
                if (r1.readInt() == 0) goto L10;
                r2 = true;
            L10:
                r1.recycle();
                r0.recycle();
                return r2;
            L8:
                e = move-exception;
                e.printStackTrace();     // Catch: Throwable -> L6
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.bytedance.ee.bear.templates.dto.BinderISelectedCallbackRet
            public boolean success() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                boolean r2 = false;
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6 RemoteException -> L8
                INVOKEINTERFACE_com_bytedance_ee_bear_templates_dto_BinderISelectedCallbackRet$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r0, r1, 0);     // Catch: Throwable -> L6 RemoteException -> L8
                r1.readException();     // Catch: Throwable -> L6 RemoteException -> L8
                if (r1.readInt() == 0) goto L10;
                r2 = true;
            L10:
                r1.recycle();
                r0.recycle();
                return r2;
            L8:
                e = move-exception;
                e.printStackTrace();     // Catch: Throwable -> L6
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.bytedance.ee.bear.templates.dto.BinderISelectedCallbackRet
            public String toastTip() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L5 RemoteException -> L7
                INVOKEINTERFACE_com_bytedance_ee_bear_templates_dto_BinderISelectedCallbackRet$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r0, r1, 0);     // Catch: Throwable -> L5 RemoteException -> L7
                r1.readException();     // Catch: Throwable -> L5 RemoteException -> L7
                String r2 = r1.readString();     // Catch: Throwable -> L5 RemoteException -> L7
                r1.recycle();
                r0.recycle();
            L13:
                return r2;
            L5:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            L7:
                e = move-exception;
                e.printStackTrace();     // Catch: Throwable -> L5
                r1.recycle();
                r0.recycle();
                r2 = null;
                goto L13
            }

            @Override // com.bytedance.ee.bear.templates.dto.BinderISelectedCallbackRet
            public String url() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L5 RemoteException -> L7
                INVOKEINTERFACE_com_bytedance_ee_bear_templates_dto_BinderISelectedCallbackRet$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r0, r1, 0);     // Catch: Throwable -> L5 RemoteException -> L7
                r1.readException();     // Catch: Throwable -> L5 RemoteException -> L7
                String r2 = r1.readString();     // Catch: Throwable -> L5 RemoteException -> L7
                r1.recycle();
                r0.recycle();
            L13:
                return r2;
            L5:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            L7:
                e = move-exception;
                e.printStackTrace();     // Catch: Throwable -> L5
                r1.recycle();
                r0.recycle();
                r2 = null;
                goto L13
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public Proxy(IBinder r1) {
                this.mRemote = r1;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_bytedance_ee_bear_templates_dto_BinderISelectedCallbackRet$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r15, int r16, Parcel r17, Parcel r18, int r19) throws RemoteException {
                if (Looper.myLooper() != Looper.getMainLooper()) goto L5;
                long r2 = SystemClock.uptimeMillis();
                boolean r0 = r15.transact(r16, r17, r18, r19);     // Catch: Throwable -> L12
                long r8 = SystemClock.uptimeMillis() - r2;
                if (r8 < 100) goto L11;
                BinderPerformanceReporter.report(r8, r15.getClass().getName(), r16, r19, new Throwable("Slow main-thread Binder transaction"));
            L11:
                return r0;
            L12:
                th = move-exception;
                long r9 = SystemClock.uptimeMillis() - r2;
                if (r9 < 100) goto L22;
                if (r15 != null) goto L17;
                String r1 = "";
            L18:
                BinderPerformanceReporter.report(r9, r1, r16, r19, new Throwable("Slow main-thread Binder transaction"));
                throw th;
            L17:
                r1 = r15.getClass().getName();
                goto L18
            L22:
                throw th;
            L5:
                return r15.transact(r16, r17, r18, r19);
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // com.bytedance.ee.bear.templates.dto.BinderISelectedCallbackRet
        public abstract /* synthetic */ boolean close();

        @Override // com.bytedance.ee.bear.templates.dto.BinderISelectedCallbackRet
        public abstract /* synthetic */ boolean success();

        @Override // com.bytedance.ee.bear.templates.dto.BinderISelectedCallbackRet
        public abstract /* synthetic */ String toastTip();

        @Override // com.bytedance.ee.bear.templates.dto.BinderISelectedCallbackRet
        public abstract /* synthetic */ String url();

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static BinderISelectedCallbackRet asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof BinderISelectedCallbackRet) == false) goto L12;
            return (BinderISelectedCallbackRet) r0;
        L12:
            return new Proxy(r2);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) throws RemoteException {
            if (r4 != 1) goto L5;
            r5.enforceInterface(DESCRIPTOR);
            boolean r8 = close();
            r6.writeNoException();
            r6.writeInt(r8 ? 1 : 0);
            return true;
        L5:
            if (r4 != 2) goto L7;
            r5.enforceInterface(DESCRIPTOR);
            boolean r9 = success();
            r6.writeNoException();
            r6.writeInt(r9 ? 1 : 0);
            return true;
        L7:
            if (r4 != 3) goto L9;
            r5.enforceInterface(DESCRIPTOR);
            String r10 = url();
            r6.writeNoException();
            r6.writeString(r10);
            return true;
        L9:
            if (r4 != 4) goto L11;
            r5.enforceInterface(DESCRIPTOR);
            String r11 = toastTip();
            r6.writeNoException();
            r6.writeString(r11);
            return true;
        L11:
            if (r4 != 1598968902) goto L13;
            r6.writeString(DESCRIPTOR);
            return true;
        L13:
            return super.onTransact(r4, r5, r6, r7);
        }
    }

    /* synthetic */ boolean close();

    /* synthetic */ boolean success();

    /* synthetic */ String toastTip();

    /* synthetic */ String url();
}
