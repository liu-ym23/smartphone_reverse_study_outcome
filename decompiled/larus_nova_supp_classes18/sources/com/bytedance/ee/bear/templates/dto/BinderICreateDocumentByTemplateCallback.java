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
public interface BinderICreateDocumentByTemplateCallback extends IInterface {

    public static abstract class Stub extends Binder implements BinderICreateDocumentByTemplateCallback {
        private static final String DESCRIPTOR = "com.bytedance.ee.bear.templates.dto.BinderICreateDocumentByTemplateCallback";
        static final int TRANSACTION_onResult_DECLARED = 1;

        public static class Proxy implements BinderICreateDocumentByTemplateCallback {
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

            @Override // com.bytedance.ee.bear.templates.dto.BinderICreateDocumentByTemplateCallback
            public void onResult(CustomCreateDocumentByTemplateResult r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L9 RemoteException -> L11
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L9 RemoteException -> L11
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L9 RemoteException -> L11
            L7:
                INVOKEINTERFACE_com_bytedance_ee_bear_templates_dto_BinderICreateDocumentByTemplateCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r0, r1, 0);     // Catch: Throwable -> L9 RemoteException -> L11
                r1.readException();     // Catch: Throwable -> L9 RemoteException -> L11
            L13:
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L9 RemoteException -> L11
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
            public static boolean INVOKEINTERFACE_com_bytedance_ee_bear_templates_dto_BinderICreateDocumentByTemplateCallback$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r15, int r16, Parcel r17, Parcel r18, int r19) throws RemoteException {
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

        @Override // com.bytedance.ee.bear.templates.dto.BinderICreateDocumentByTemplateCallback
        public abstract /* synthetic */ void onResult(CustomCreateDocumentByTemplateResult r1);

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static BinderICreateDocumentByTemplateCallback asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof BinderICreateDocumentByTemplateCallback) == false) goto L12;
            return (BinderICreateDocumentByTemplateCallback) r0;
        L12:
            return new Proxy(r2);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) throws RemoteException {
            if (r4 != 1) goto L5;
            r5.enforceInterface(DESCRIPTOR);
            if (r5.readInt() == 0) goto L13;
            CustomCreateDocumentByTemplateResult r8 = CustomCreateDocumentByTemplateResult.CREATOR.createFromParcel(r5);
        L14:
            onResult(r8);
            r6.writeNoException();
            return true;
        L13:
            r8 = null;
            goto L14
        L5:
            if (r4 != 1598968902) goto L7;
            r6.writeString(DESCRIPTOR);
            return true;
        L7:
            return super.onTransact(r4, r5, r6, r7);
        }
    }

    /* synthetic */ void onResult(CustomCreateDocumentByTemplateResult r1);
}
