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
public interface BinderISelectTemplateCallback extends IInterface {

    public static abstract class Stub extends Binder implements BinderISelectTemplateCallback {
        private static final String DESCRIPTOR = "com.bytedance.ee.bear.templates.dto.BinderISelectTemplateCallback";
        static final int TRANSACTION_onCancel_BOOLEAN = 2;
        static final int TRANSACTION_onError_INT = 3;
        static final int TRANSACTION_onPageView_INT_ERROR = 4;
        static final int TRANSACTION_onSelected_DECLARED_DECLARED_INT_DECLARED_ERROR = 1;
        static final int TRANSACTION_onTemplateCenterDestroy = 5;

        public static class Proxy implements BinderISelectTemplateCallback {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.bytedance.ee.bear.templates.dto.BinderISelectTemplateCallback
            public void onTemplateCenterDestroy() {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L5 RemoteException -> L7
                INVOKEINTERFACE_com_bytedance_ee_bear_templates_dto_BinderISelectTemplateCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 5, r100, r101, 0);     // Catch: Throwable -> L5 RemoteException -> L7
                r101.readException();     // Catch: Throwable -> L5 RemoteException -> L7
            L9:
                r101.recycle();
                r100.recycle();
                return;
            L5:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            L7:
                e = move-exception;
                e.printStackTrace();     // Catch: Throwable -> L5
                goto L9
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public Proxy(IBinder r100) {
                this.mRemote = r100;
            }

            @Override // com.bytedance.ee.bear.templates.dto.BinderISelectTemplateCallback
            public void onCancel(boolean r100) {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L9 RemoteException -> L11
                if (r100 == false) goto L6;
                int r103 = 1;
            L7:
                r101.writeInt(r103);     // Catch: Throwable -> L9 RemoteException -> L11
                INVOKEINTERFACE_com_bytedance_ee_bear_templates_dto_BinderISelectTemplateCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r101, r102, 0);     // Catch: Throwable -> L9 RemoteException -> L11
                r102.readException();     // Catch: Throwable -> L9 RemoteException -> L11
            L13:
                r102.recycle();
                r101.recycle();
                return;
            L6:
                r103 = 0;
            L9:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            L11:
                e = move-exception;
                e.printStackTrace();     // Catch: Throwable -> L9
                goto L13
            }

            @Override // com.bytedance.ee.bear.templates.dto.BinderISelectTemplateCallback
            public void onError(int r100) {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L5 RemoteException -> L7
                r101.writeInt(r100);     // Catch: Throwable -> L5 RemoteException -> L7
                INVOKEINTERFACE_com_bytedance_ee_bear_templates_dto_BinderISelectTemplateCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r101, r102, 0);     // Catch: Throwable -> L5 RemoteException -> L7
                r102.readException();     // Catch: Throwable -> L5 RemoteException -> L7
            L9:
                r102.recycle();
                r101.recycle();
                return;
            L7:
                e = move-exception;
                e.printStackTrace();     // Catch: Throwable -> L5
            L5:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.bytedance.ee.bear.templates.dto.BinderISelectTemplateCallback
            public void onPageView(int r100, BinderPageControl r101) {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L9 RemoteException -> L11
                r102.writeInt(r100);     // Catch: Throwable -> L9 RemoteException -> L11
                if (r101 == null) goto L6;
                IBinder r104 = r101.asBinder();     // Catch: Throwable -> L9 RemoteException -> L11
            L7:
                r102.writeStrongBinder(r104);     // Catch: Throwable -> L9 RemoteException -> L11
                INVOKEINTERFACE_com_bytedance_ee_bear_templates_dto_BinderISelectTemplateCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r102, r103, 0);     // Catch: Throwable -> L9 RemoteException -> L11
                r103.readException();     // Catch: Throwable -> L9 RemoteException -> L11
            L13:
                r103.recycle();
                r102.recycle();
                return;
            L6:
                r104 = null;
            L9:
                th = move-exception;
                r103.recycle();
                r102.recycle();
                throw th;
            L11:
                e = move-exception;
                e.printStackTrace();     // Catch: Throwable -> L9
                goto L13
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_bytedance_ee_bear_templates_dto_BinderISelectTemplateCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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

            @Override // com.bytedance.ee.bear.templates.dto.BinderISelectTemplateCallback
            public void onSelected(String r100, String r101, int r102, String r103, BinderICreateDocumentByTemplateCallback r104) {
                Parcel r105 = Parcel.obtain();
                Parcel r106 = Parcel.obtain();
                r105.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L9 RemoteException -> L11
                r105.writeString(r100);     // Catch: Throwable -> L9 RemoteException -> L11
                r105.writeString(r101);     // Catch: Throwable -> L9 RemoteException -> L11
                r105.writeInt(r102);     // Catch: Throwable -> L9 RemoteException -> L11
                r105.writeString(r103);     // Catch: Throwable -> L9 RemoteException -> L11
                if (r104 == null) goto L6;
                IBinder r107 = r104.asBinder();     // Catch: Throwable -> L9 RemoteException -> L11
            L7:
                r105.writeStrongBinder(r107);     // Catch: Throwable -> L9 RemoteException -> L11
                INVOKEINTERFACE_com_bytedance_ee_bear_templates_dto_BinderISelectTemplateCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r105, r106, 0);     // Catch: Throwable -> L9 RemoteException -> L11
                r106.readException();     // Catch: Throwable -> L9 RemoteException -> L11
            L13:
                r106.recycle();
                r105.recycle();
                return;
            L6:
                r107 = null;
            L11:
                e = move-exception;
                e.printStackTrace();     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                r106.recycle();
                r105.recycle();
                throw th;
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public abstract /* synthetic */ void onCancel(boolean r100);

        public abstract /* synthetic */ void onError(int r100);

        public abstract /* synthetic */ void onPageView(int r100, BinderPageControl r101);

        public abstract /* synthetic */ void onSelected(String r100, String r101, int r102, String r103, BinderICreateDocumentByTemplateCallback r104);

        public abstract /* synthetic */ void onTemplateCenterDestroy();

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static BinderISelectTemplateCallback asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof BinderISelectTemplateCallback) == false) goto L12;
            return (BinderISelectTemplateCallback) r101;
        L12:
            return new Proxy(r100);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r100, Parcel r110, Parcel r111, int r112) throws RemoteException {
            if (r100 != 1) goto L5;
            r110.enforceInterface(DESCRIPTOR);
            onSelected(r110.readString(), r110.readString(), r110.readInt(), r110.readString(), BinderICreateDocumentByTemplateCallback.Stub.asInterface(r110.readStrongBinder()));
            r111.writeNoException();
            return true;
        L5:
            if (r100 != 2) goto L7;
            r110.enforceInterface(DESCRIPTOR);
            if (r110.readInt() != 0) goto L27;
            boolean r101 = false;
        L28:
            onCancel(r101);
            r111.writeNoException();
            return true;
        L27:
            r101 = true;
            goto L28
        L7:
            if (r100 != 3) goto L9;
            r110.enforceInterface(DESCRIPTOR);
            onError(r110.readInt());
            r111.writeNoException();
            return true;
        L9:
            if (r100 != 4) goto L11;
            r110.enforceInterface(DESCRIPTOR);
            onPageView(r110.readInt(), BinderPageControl.Stub.asInterface(r110.readStrongBinder()));
            r111.writeNoException();
            return true;
        L11:
            if (r100 != 5) goto L13;
            r110.enforceInterface(DESCRIPTOR);
            onTemplateCenterDestroy();
            r111.writeNoException();
            return true;
        L13:
            if (r100 != 1598968902) goto L15;
            r111.writeString(DESCRIPTOR);
            return true;
        L15:
            return super.onTransact(r100, r110, r111, r112);
        }
    }

    /* synthetic */ void onCancel(boolean r100);

    /* synthetic */ void onError(int r100);

    /* synthetic */ void onPageView(int r100, BinderPageControl r101);

    /* synthetic */ void onSelected(String r100, String r101, int r102, String r103, BinderICreateDocumentByTemplateCallback r104);

    /* synthetic */ void onTemplateCenterDestroy();
}
