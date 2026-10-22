package com.hihonor.mcs.system.diagnosis.core;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes23.dex */
public interface ICallbackPayload extends IInterface {

    public static class Default implements ICallbackPayload {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.hihonor.mcs.system.diagnosis.core.ICallbackPayload
        public void receivePayloadData(CallbackPayload r100, IDoPlayloadComplete r101) {
        }
    }

    public static abstract class Stub extends Binder implements ICallbackPayload {
        private static final String DESCRIPTOR = "com.hihonor.mcs.system.diagnosis.core.ICallbackPayload";
        static final int TRANSACTION_receivePayloadData = 1;

        public static class Proxy implements ICallbackPayload {
            public static ICallbackPayload sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder r100) {
                this.mRemote = r100;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.hihonor.mcs.system.diagnosis.core.ICallbackPayload
            public void receivePayloadData(CallbackPayload r100, IDoPlayloadComplete r101) {
                Parcel r102 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L20
                if (r100 == null) goto L6;
                r102.writeInt(1);     // Catch: Throwable -> L20
                r100.writeToParcel(r102, 0);     // Catch: Throwable -> L20
            L8:
                if (r101 == null) goto L10;
                IBinder r103 = r101.asBinder();     // Catch: Throwable -> L20
            L11:
                r102.writeStrongBinder(r103);     // Catch: Throwable -> L20
                if (INVOKEINTERFACE_com_hihonor_mcs_system_diagnosis_core_ICallbackPayload$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r102, null, 1) == false) goto L14;
            L18:
                r102.recycle();
                return;
            L14:
                if (Stub.getDefaultImpl() == null) goto L18;
                Stub.getDefaultImpl().receivePayloadData(r100, r101);     // Catch: Throwable -> L20
                r102.recycle();
                return;
            L10:
                r103 = null;
                goto L11
            L6:
                r102.writeInt(0);     // Catch: Throwable -> L20
            L20:
                th = move-exception;
                r102.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_hihonor_mcs_system_diagnosis_core_ICallbackPayload$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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

        public static ICallbackPayload asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof ICallbackPayload) == false) goto L12;
            return (ICallbackPayload) r101;
        L12:
            return new Proxy(r100);
        }

        public static ICallbackPayload getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(ICallbackPayload r100) {
            if (Proxy.sDefaultImpl != null) goto L7;
            if (r100 == null) goto L9;
            Proxy.sDefaultImpl = r100;
            return true;
        L9:
            return false;
        L7:
            return false;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r100, Parcel r101, Parcel r102, int r103) {
            if (r100 != 1) goto L5;
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L13;
            CallbackPayload r104 = CallbackPayload.CREATOR.createFromParcel(r101);
        L14:
            receivePayloadData(r104, IDoPlayloadComplete.Stub.asInterface(r101.readStrongBinder()));
            return true;
        L13:
            r104 = null;
            goto L14
        L5:
            if (r100 != 1598968902) goto L7;
            r102.writeString(DESCRIPTOR);
            return true;
        L7:
            return super.onTransact(r100, r101, r102, r103);
        }
    }

    void receivePayloadData(CallbackPayload r100, IDoPlayloadComplete r101);
}
