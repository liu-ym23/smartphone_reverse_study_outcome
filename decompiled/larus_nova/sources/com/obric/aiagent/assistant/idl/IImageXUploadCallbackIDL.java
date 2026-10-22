package com.obric.aiagent.assistant.idl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes6.dex */
public interface IImageXUploadCallbackIDL extends IInterface {

    /* JADX INFO: loaded from: classes32.dex */
    public static class Default implements IImageXUploadCallbackIDL {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.aiagent.assistant.idl.IImageXUploadCallbackIDL
        public void onResult(boolean r100, String r101, String r102, String r103, String r104) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IImageXUploadCallbackIDL {
        private static final String DESCRIPTOR = "com.obric.aiagent.assistant.idl.IImageXUploadCallbackIDL";
        static final int TRANSACTION_onResult = 1;

        /* JADX INFO: loaded from: classes32.dex */
        public static class Proxy implements IImageXUploadCallbackIDL {
            public static IImageXUploadCallbackIDL sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public Proxy(IBinder r100) {
                this.mRemote = r100;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IImageXUploadCallbackIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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

            @Override // com.obric.aiagent.assistant.idl.IImageXUploadCallbackIDL
            public void onResult(boolean r100, String r110, String r111, String r112, String r113) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r100 == false) goto L6;
                int r102 = 1;
            L7:
                r101.writeInt(r102);     // Catch: Throwable -> L16
                r101.writeString(r110);     // Catch: Throwable -> L16
                r101.writeString(r111);     // Catch: Throwable -> L16
                r101.writeString(r112);     // Catch: Throwable -> L16
                r101.writeString(r113);     // Catch: Throwable -> L16
                if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IImageXUploadCallbackIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r101, null, 1) == false) goto L10;
            L14:
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().onResult(r100, r110, r111, r112, r113);     // Catch: Throwable -> L16
                r101.recycle();
                return;
            L6:
                r102 = 0;
            L16:
                th = move-exception;
                r101.recycle();
                throw th;
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IImageXUploadCallbackIDL getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static IImageXUploadCallbackIDL asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof IImageXUploadCallbackIDL) == false) goto L12;
            return (IImageXUploadCallbackIDL) r101;
        L12:
            return new Proxy(r100);
        }

        public static boolean setDefaultImpl(IImageXUploadCallbackIDL r100) {
            if (Proxy.sDefaultImpl != null) goto L10;
            if (r100 == null) goto L7;
            Proxy.sDefaultImpl = r100;
            return true;
        L7:
            return false;
        L10:
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        @Override // android.os.Binder
        public boolean onTransact(int r100, Parcel r101, Parcel r110, int r111) throws RemoteException {
            if (r100 != 1) goto L5;
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L13;
            boolean r102 = true;
        L14:
            onResult(r102, r101.readString(), r101.readString(), r101.readString(), r101.readString());
            return true;
        L13:
            r102 = false;
            goto L14
        L5:
            if (r100 != 1598968902) goto L7;
            r110.writeString(DESCRIPTOR);
            return true;
        L7:
            return super.onTransact(r100, r101, r110, r111);
        }
    }

    void onResult(boolean r100, String r101, String r102, String r103, String r104) throws RemoteException;
}
