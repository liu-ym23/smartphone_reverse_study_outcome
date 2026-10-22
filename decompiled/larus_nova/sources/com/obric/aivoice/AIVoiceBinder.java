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
public interface AIVoiceBinder extends IInterface {

    public static class Default implements AIVoiceBinder {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.aivoice.AIVoiceBinder
        public void callVoice(Bundle r100, AIVoiceListener r101) throws RemoteException {
        }

        @Override // com.obric.aivoice.AIVoiceBinder
        public Bundle callVoiceSync(Bundle r100) throws RemoteException {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements AIVoiceBinder {
        private static final String DESCRIPTOR = "com.obric.aivoice.AIVoiceBinder";
        static final int TRANSACTION_callVoice = 2;
        static final int TRANSACTION_callVoiceSync = 1;

        public static class Proxy implements AIVoiceBinder {
            public static AIVoiceBinder sDefaultImpl;
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

            @Override // com.obric.aivoice.AIVoiceBinder
            public Bundle callVoiceSync(Bundle r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L21
                if (r100 == null) goto L6;
                r101.writeInt(1);     // Catch: Throwable -> L21
                r100.writeToParcel(r101, 0);     // Catch: Throwable -> L21
            L8:
                if (INVOKEINTERFACE_com_obric_aivoice_AIVoiceBinder$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r101, r102, 0) == false) goto L10;
            L14:
                r102.readException();     // Catch: Throwable -> L21
                if (r102.readInt() == 0) goto L18;
                Bundle r103 = (Bundle) Bundle.CREATOR.createFromParcel(r102);     // Catch: Throwable -> L21
            L19:
                r102.recycle();
                r101.recycle();
                return r103;
            L18:
                r103 = null;
                goto L19
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Bundle r104 = Stub.getDefaultImpl().callVoiceSync(r100);     // Catch: Throwable -> L21
                r102.recycle();
                r101.recycle();
                return r104;
            L6:
                r101.writeInt(0);     // Catch: Throwable -> L21
            L21:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.obric.aivoice.AIVoiceBinder
            public void callVoice(Bundle r100, AIVoiceListener r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L20
                if (r100 == null) goto L6;
                r102.writeInt(1);     // Catch: Throwable -> L20
                r100.writeToParcel(r102, 0);     // Catch: Throwable -> L20
            L7:
                if (r101 == null) goto L9;
                IBinder r104 = r101.asBinder();     // Catch: Throwable -> L20
            L10:
                r102.writeStrongBinder(r104);     // Catch: Throwable -> L20
                if (INVOKEINTERFACE_com_obric_aivoice_AIVoiceBinder$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r102, r103, 0) == false) goto L13;
            L17:
                r103.readException();     // Catch: Throwable -> L20
                r103.recycle();
                r102.recycle();
                return;
            L13:
                if (Stub.getDefaultImpl() == null) goto L17;
                Stub.getDefaultImpl().callVoice(r100, r101);     // Catch: Throwable -> L20
                r103.recycle();
                r102.recycle();
                return;
            L9:
                r104 = null;
                goto L10
            L6:
                r102.writeInt(0);     // Catch: Throwable -> L20
            L20:
                th = move-exception;
                r103.recycle();
                r102.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_obric_aivoice_AIVoiceBinder$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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

        public static AIVoiceBinder getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static AIVoiceBinder asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof AIVoiceBinder) == false) goto L12;
            return (AIVoiceBinder) r101;
        L12:
            return new Proxy(r100);
        }

        public static boolean setDefaultImpl(AIVoiceBinder r100) {
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
            Bundle r104 = null;
            if (r100 != 1) goto L5;
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L20;
            r104 = (Bundle) Bundle.CREATOR.createFromParcel(r101);
        L20:
            Bundle r105 = callVoiceSync(r104);
            r102.writeNoException();
            if (r105 == null) goto L23;
            r102.writeInt(1);
            r105.writeToParcel(r102, 1);
        L24:
            return true;
        L23:
            r102.writeInt(0);
            goto L24
        L5:
            if (r100 != 2) goto L7;
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L15;
            r104 = (Bundle) Bundle.CREATOR.createFromParcel(r101);
        L15:
            callVoice(r104, AIVoiceListener.Stub.asInterface(r101.readStrongBinder()));
            r102.writeNoException();
            return true;
        L7:
            if (r100 != 1598968902) goto L9;
            r102.writeString(DESCRIPTOR);
            return true;
        L9:
            return super.onTransact(r100, r101, r102, r103);
        }
    }

    void callVoice(Bundle r100, AIVoiceListener r101) throws RemoteException;

    Bundle callVoiceSync(Bundle r100) throws RemoteException;
}
