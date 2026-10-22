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

/* JADX INFO: loaded from: classes18.dex */
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
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                boolean r102 = false;
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6 RemoteException -> L8
                INVOKEINTERFACE_com_bytedance_ee_bear_templates_dto_BinderISelectedCallbackRet$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r100, r101, 0);     // Catch: Throwable -> L6 RemoteException -> L8
                r101.readException();     // Catch: Throwable -> L6 RemoteException -> L8
                if (r101.readInt() == 0) goto L10;
                r102 = true;
            L10:
                r101.recycle();
                r100.recycle();
                return r102;
            L8:
                e = move-exception;
                e.printStackTrace();     // Catch: Throwable -> L6
            L6:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.bytedance.ee.bear.templates.dto.BinderISelectedCallbackRet
            public boolean success() {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                boolean r102 = false;
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6 RemoteException -> L8
                INVOKEINTERFACE_com_bytedance_ee_bear_templates_dto_BinderISelectedCallbackRet$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r100, r101, 0);     // Catch: Throwable -> L6 RemoteException -> L8
                r101.readException();     // Catch: Throwable -> L6 RemoteException -> L8
                if (r101.readInt() == 0) goto L10;
                r102 = true;
            L10:
                r101.recycle();
                r100.recycle();
                return r102;
            L8:
                e = move-exception;
                e.printStackTrace();     // Catch: Throwable -> L6
            L6:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.bytedance.ee.bear.templates.dto.BinderISelectedCallbackRet
            public String toastTip() {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L5 RemoteException -> L7
                INVOKEINTERFACE_com_bytedance_ee_bear_templates_dto_BinderISelectedCallbackRet$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r100, r101, 0);     // Catch: Throwable -> L5 RemoteException -> L7
                r101.readException();     // Catch: Throwable -> L5 RemoteException -> L7
                String r102 = r101.readString();     // Catch: Throwable -> L5 RemoteException -> L7
                r101.recycle();
                r100.recycle();
            L13:
                return r102;
            L5:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            L7:
                e = move-exception;
                e.printStackTrace();     // Catch: Throwable -> L5
                r101.recycle();
                r100.recycle();
                r102 = null;
                goto L13
            }

            @Override // com.bytedance.ee.bear.templates.dto.BinderISelectedCallbackRet
            public String url() {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L5 RemoteException -> L7
                INVOKEINTERFACE_com_bytedance_ee_bear_templates_dto_BinderISelectedCallbackRet$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r100, r101, 0);     // Catch: Throwable -> L5 RemoteException -> L7
                r101.readException();     // Catch: Throwable -> L5 RemoteException -> L7
                String r102 = r101.readString();     // Catch: Throwable -> L5 RemoteException -> L7
                r101.recycle();
                r100.recycle();
            L13:
                return r102;
            L5:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            L7:
                e = move-exception;
                e.printStackTrace();     // Catch: Throwable -> L5
                r101.recycle();
                r100.recycle();
                r102 = null;
                goto L13
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public Proxy(IBinder r100) {
                this.mRemote = r100;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_bytedance_ee_bear_templates_dto_BinderISelectedCallbackRet$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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

        public static BinderISelectedCallbackRet asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof BinderISelectedCallbackRet) == false) goto L12;
            return (BinderISelectedCallbackRet) r101;
        L12:
            return new Proxy(r100);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r100, Parcel r101, Parcel r102, int r103) throws RemoteException {
            if (r100 != 1) goto L5;
            r101.enforceInterface(DESCRIPTOR);
            boolean r104 = close();
            r102.writeNoException();
            r102.writeInt(r104 ? 1 : 0);
            return true;
        L5:
            if (r100 != 2) goto L7;
            r101.enforceInterface(DESCRIPTOR);
            boolean r105 = success();
            r102.writeNoException();
            r102.writeInt(r105 ? 1 : 0);
            return true;
        L7:
            if (r100 != 3) goto L9;
            r101.enforceInterface(DESCRIPTOR);
            String r106 = url();
            r102.writeNoException();
            r102.writeString(r106);
            return true;
        L9:
            if (r100 != 4) goto L11;
            r101.enforceInterface(DESCRIPTOR);
            String r107 = toastTip();
            r102.writeNoException();
            r102.writeString(r107);
            return true;
        L11:
            if (r100 != 1598968902) goto L13;
            r102.writeString(DESCRIPTOR);
            return true;
        L13:
            return super.onTransact(r100, r101, r102, r103);
        }
    }

    /* synthetic */ boolean close();

    /* synthetic */ boolean success();

    /* synthetic */ String toastTip();

    /* synthetic */ String url();
}
