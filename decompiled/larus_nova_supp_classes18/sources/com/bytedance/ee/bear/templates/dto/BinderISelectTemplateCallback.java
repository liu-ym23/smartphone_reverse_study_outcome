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
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L5 RemoteException -> L7
                INVOKEINTERFACE_com_bytedance_ee_bear_templates_dto_BinderISelectTemplateCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 5, r0, r1, 0);     // Catch: Throwable -> L5 RemoteException -> L7
                r1.readException();     // Catch: Throwable -> L5 RemoteException -> L7
            L9:
                r1.recycle();
                r0.recycle();
                return;
            L5:
                th = move-exception;
                r1.recycle();
                r0.recycle();
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

            public Proxy(IBinder r1) {
                this.mRemote = r1;
            }

            @Override // com.bytedance.ee.bear.templates.dto.BinderISelectTemplateCallback
            public void onCancel(boolean r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L9 RemoteException -> L11
                if (r5 == false) goto L6;
                int r6 = 1;
            L7:
                r0.writeInt(r6);     // Catch: Throwable -> L9 RemoteException -> L11
                INVOKEINTERFACE_com_bytedance_ee_bear_templates_dto_BinderISelectTemplateCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r0, r1, 0);     // Catch: Throwable -> L9 RemoteException -> L11
                r1.readException();     // Catch: Throwable -> L9 RemoteException -> L11
            L13:
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r6 = 0;
            L9:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            L11:
                e = move-exception;
                e.printStackTrace();     // Catch: Throwable -> L9
                goto L13
            }

            @Override // com.bytedance.ee.bear.templates.dto.BinderISelectTemplateCallback
            public void onError(int r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L5 RemoteException -> L7
                r0.writeInt(r5);     // Catch: Throwable -> L5 RemoteException -> L7
                INVOKEINTERFACE_com_bytedance_ee_bear_templates_dto_BinderISelectTemplateCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r0, r1, 0);     // Catch: Throwable -> L5 RemoteException -> L7
                r1.readException();     // Catch: Throwable -> L5 RemoteException -> L7
            L9:
                r1.recycle();
                r0.recycle();
                return;
            L7:
                e = move-exception;
                e.printStackTrace();     // Catch: Throwable -> L5
            L5:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.bytedance.ee.bear.templates.dto.BinderISelectTemplateCallback
            public void onPageView(int r4, BinderPageControl r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L9 RemoteException -> L11
                r0.writeInt(r4);     // Catch: Throwable -> L9 RemoteException -> L11
                if (r5 == null) goto L6;
                IBinder r6 = r5.asBinder();     // Catch: Throwable -> L9 RemoteException -> L11
            L7:
                r0.writeStrongBinder(r6);     // Catch: Throwable -> L9 RemoteException -> L11
                INVOKEINTERFACE_com_bytedance_ee_bear_templates_dto_BinderISelectTemplateCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r0, r1, 0);     // Catch: Throwable -> L9 RemoteException -> L11
                r1.readException();     // Catch: Throwable -> L9 RemoteException -> L11
            L13:
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r6 = null;
            L9:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            L11:
                e = move-exception;
                e.printStackTrace();     // Catch: Throwable -> L9
                goto L13
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_bytedance_ee_bear_templates_dto_BinderISelectTemplateCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r15, int r16, Parcel r17, Parcel r18, int r19) throws RemoteException {
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

            @Override // com.bytedance.ee.bear.templates.dto.BinderISelectTemplateCallback
            public void onSelected(String r4, String r5, int r6, String r7, BinderICreateDocumentByTemplateCallback r8) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L9 RemoteException -> L11
                r0.writeString(r4);     // Catch: Throwable -> L9 RemoteException -> L11
                r0.writeString(r5);     // Catch: Throwable -> L9 RemoteException -> L11
                r0.writeInt(r6);     // Catch: Throwable -> L9 RemoteException -> L11
                r0.writeString(r7);     // Catch: Throwable -> L9 RemoteException -> L11
                if (r8 == null) goto L6;
                IBinder r9 = r8.asBinder();     // Catch: Throwable -> L9 RemoteException -> L11
            L7:
                r0.writeStrongBinder(r9);     // Catch: Throwable -> L9 RemoteException -> L11
                INVOKEINTERFACE_com_bytedance_ee_bear_templates_dto_BinderISelectTemplateCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r0, r1, 0);     // Catch: Throwable -> L9 RemoteException -> L11
                r1.readException();     // Catch: Throwable -> L9 RemoteException -> L11
            L13:
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r9 = null;
            L11:
                e = move-exception;
                e.printStackTrace();     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // com.bytedance.ee.bear.templates.dto.BinderISelectTemplateCallback
        public abstract /* synthetic */ void onCancel(boolean r1);

        @Override // com.bytedance.ee.bear.templates.dto.BinderISelectTemplateCallback
        public abstract /* synthetic */ void onError(int r1);

        @Override // com.bytedance.ee.bear.templates.dto.BinderISelectTemplateCallback
        public abstract /* synthetic */ void onPageView(int r1, BinderPageControl r2);

        @Override // com.bytedance.ee.bear.templates.dto.BinderISelectTemplateCallback
        public abstract /* synthetic */ void onSelected(String r1, String r2, int r3, String r4, BinderICreateDocumentByTemplateCallback r5);

        @Override // com.bytedance.ee.bear.templates.dto.BinderISelectTemplateCallback
        public abstract /* synthetic */ void onTemplateCenterDestroy();

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static BinderISelectTemplateCallback asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof BinderISelectTemplateCallback) == false) goto L12;
            return (BinderISelectTemplateCallback) r0;
        L12:
            return new Proxy(r2);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r9, Parcel r10, Parcel r11, int r12) throws RemoteException {
            if (r9 != 1) goto L5;
            r10.enforceInterface(DESCRIPTOR);
            onSelected(r10.readString(), r10.readString(), r10.readInt(), r10.readString(), BinderICreateDocumentByTemplateCallback.Stub.asInterface(r10.readStrongBinder()));
            r11.writeNoException();
            return true;
        L5:
            if (r9 != 2) goto L7;
            r10.enforceInterface(DESCRIPTOR);
            if (r10.readInt() != 0) goto L27;
            boolean r13 = false;
        L28:
            onCancel(r13);
            r11.writeNoException();
            return true;
        L27:
            r13 = true;
            goto L28
        L7:
            if (r9 != 3) goto L9;
            r10.enforceInterface(DESCRIPTOR);
            onError(r10.readInt());
            r11.writeNoException();
            return true;
        L9:
            if (r9 != 4) goto L11;
            r10.enforceInterface(DESCRIPTOR);
            onPageView(r10.readInt(), BinderPageControl.Stub.asInterface(r10.readStrongBinder()));
            r11.writeNoException();
            return true;
        L11:
            if (r9 != 5) goto L13;
            r10.enforceInterface(DESCRIPTOR);
            onTemplateCenterDestroy();
            r11.writeNoException();
            return true;
        L13:
            if (r9 != 1598968902) goto L15;
            r11.writeString(DESCRIPTOR);
            return true;
        L15:
            return super.onTransact(r9, r10, r11, r12);
        }
    }

    /* synthetic */ void onCancel(boolean r1);

    /* synthetic */ void onError(int r1);

    /* synthetic */ void onPageView(int r1, BinderPageControl r2);

    /* synthetic */ void onSelected(String r1, String r2, int r3, String r4, BinderICreateDocumentByTemplateCallback r5);

    /* synthetic */ void onTemplateCenterDestroy();
}
