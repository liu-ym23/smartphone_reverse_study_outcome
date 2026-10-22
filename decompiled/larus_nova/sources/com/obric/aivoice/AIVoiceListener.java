package com.obric.aivoice;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes32.dex */
public interface AIVoiceListener extends IInterface {

    public static class Default implements AIVoiceListener {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.aivoice.AIVoiceListener
        public int getVersion() throws RemoteException {
            return 0;
        }

        @Override // com.obric.aivoice.AIVoiceListener
        public int onAsrResponse(String r100, String r101) throws RemoteException {
            return 0;
        }

        @Override // com.obric.aivoice.AIVoiceListener
        public void onResult(Bundle r100) throws RemoteException {
        }

        @Override // com.obric.aivoice.AIVoiceListener
        public int onTtsResponse(String r100, byte[] r101, String r102) throws RemoteException {
            return 0;
        }
    }

    public static abstract class Stub extends Binder implements AIVoiceListener {
        private static final String DESCRIPTOR = "com.obric.aivoice.AIVoiceListener";
        static final int TRANSACTION_getVersion = 1;
        static final int TRANSACTION_onAsrResponse = 3;
        static final int TRANSACTION_onResult = 2;
        static final int TRANSACTION_onTtsResponse = 4;

        public static class Proxy implements AIVoiceListener {
            public static AIVoiceListener sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.obric.aivoice.AIVoiceListener
            public int getVersion() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_aivoice_AIVoiceListener$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L13
                int r102 = r101.readInt();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r102;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r103 = Stub.getDefaultImpl().getVersion();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r103;
            L13:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public Proxy(IBinder r100) {
                this.mRemote = r100;
            }

            @Override // com.obric.aivoice.AIVoiceListener
            public void onResult(Bundle r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r100 == null) goto L6;
                r101.writeInt(1);     // Catch: Throwable -> L17
                r100.writeToParcel(r101, 0);     // Catch: Throwable -> L17
            L8:
                if (INVOKEINTERFACE_com_obric_aivoice_AIVoiceListener$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r101, r102, 0) == false) goto L10;
            L14:
                r102.readException();     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().onResult(r100);     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return;
            L6:
                r101.writeInt(0);     // Catch: Throwable -> L17
            L17:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.obric.aivoice.AIVoiceListener
            public int onAsrResponse(String r100, String r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r102.writeString(r100);     // Catch: Throwable -> L13
                r102.writeString(r101);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_aivoice_AIVoiceListener$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r102, r103, 0) == false) goto L6;
            L10:
                r103.readException();     // Catch: Throwable -> L13
                int r104 = r103.readInt();     // Catch: Throwable -> L13
                r103.recycle();
                r102.recycle();
                return r104;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r105 = Stub.getDefaultImpl().onAsrResponse(r100, r101);     // Catch: Throwable -> L13
                r103.recycle();
                r102.recycle();
                return r105;
            L13:
                th = move-exception;
                r103.recycle();
                r102.recycle();
                throw th;
            }

            @Override // com.obric.aivoice.AIVoiceListener
            public int onTtsResponse(String r100, byte[] r101, String r102) throws RemoteException {
                Parcel r103 = Parcel.obtain();
                Parcel r104 = Parcel.obtain();
                r103.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r103.writeString(r100);     // Catch: Throwable -> L13
                r103.writeByteArray(r101);     // Catch: Throwable -> L13
                r103.writeString(r102);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_aivoice_AIVoiceListener$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r103, r104, 0) == false) goto L6;
            L10:
                r104.readException();     // Catch: Throwable -> L13
                int r105 = r104.readInt();     // Catch: Throwable -> L13
                r104.recycle();
                r103.recycle();
                return r105;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r106 = Stub.getDefaultImpl().onTtsResponse(r100, r101, r102);     // Catch: Throwable -> L13
                r104.recycle();
                r103.recycle();
                return r106;
            L13:
                th = move-exception;
                r104.recycle();
                r103.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_obric_aivoice_AIVoiceListener$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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
            attachInterface(this, DESCRIPTOR);
        }

        public static AIVoiceListener getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static AIVoiceListener asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof AIVoiceListener) == false) goto L12;
            return (AIVoiceListener) r101;
        L12:
            return new Proxy(r100);
        }

        public static boolean setDefaultImpl(AIVoiceListener r100) {
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
        public boolean onTransact(int r100, Parcel r101, Parcel r102, int r103) throws RemoteException {
            if (r100 != 1) goto L5;
            r101.enforceInterface(DESCRIPTOR);
            int r104 = getVersion();
            r102.writeNoException();
            r102.writeInt(r104);
            return true;
        L5:
            if (r100 != 2) goto L7;
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L23;
            Bundle r105 = (Bundle) Bundle.CREATOR.createFromParcel(r101);
        L24:
            onResult(r105);
            r102.writeNoException();
            return true;
        L23:
            r105 = null;
            goto L24
        L7:
            if (r100 != 3) goto L9;
            r101.enforceInterface(DESCRIPTOR);
            int r106 = onAsrResponse(r101.readString(), r101.readString());
            r102.writeNoException();
            r102.writeInt(r106);
            return true;
        L9:
            if (r100 != 4) goto L11;
            r101.enforceInterface(DESCRIPTOR);
            int r107 = onTtsResponse(r101.readString(), r101.createByteArray(), r101.readString());
            r102.writeNoException();
            r102.writeInt(r107);
            return true;
        L11:
            if (r100 != 1598968902) goto L13;
            r102.writeString(DESCRIPTOR);
            return true;
        L13:
            return super.onTransact(r100, r101, r102, r103);
        }
    }

    int getVersion() throws RemoteException;

    int onAsrResponse(String r100, String r101) throws RemoteException;

    void onResult(Bundle r100) throws RemoteException;

    int onTtsResponse(String r100, byte[] r101, String r102) throws RemoteException;
}
