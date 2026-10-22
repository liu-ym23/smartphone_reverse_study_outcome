package com.tencent.qqmusic.third.api.contract;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import java.util.List;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes35.dex */
public interface IQQMusicApi extends IInterface {

    public static abstract class Stub extends Binder implements IQQMusicApi {
        private static final String DESCRIPTOR = "com.tencent.qqmusic.third.api.contract.IQQMusicApi";
        static final int TRANSACTION_execute = 1;
        static final int TRANSACTION_executeAsync = 2;
        static final int TRANSACTION_registerEventListener = 3;
        static final int TRANSACTION_unregisterEventListener = 4;

        public static class Proxy implements IQQMusicApi {
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

            @Override // com.tencent.qqmusic.third.api.contract.IQQMusicApi
            public Bundle execute(String r100, Bundle r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L14
                r102.writeString(r100);     // Catch: Throwable -> L14
                if (r101 == null) goto L6;
                r102.writeInt(1);     // Catch: Throwable -> L14
                r101.writeToParcel(r102, 0);     // Catch: Throwable -> L14
            L7:
                INVOKEINTERFACE_com_tencent_qqmusic_third_api_contract_IQQMusicApi$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r102, r103, 0);     // Catch: Throwable -> L14
                r103.readException();     // Catch: Throwable -> L14
                if (r103.readInt() == 0) goto L11;
                Bundle r104 = (Bundle) Bundle.CREATOR.createFromParcel(r103);     // Catch: Throwable -> L14
            L12:
                r103.recycle();
                r102.recycle();
                return r104;
            L11:
                r104 = null;
                goto L12
            L6:
                r102.writeInt(0);     // Catch: Throwable -> L14
            L14:
                th = move-exception;
                r103.recycle();
                r102.recycle();
                throw th;
            }

            @Override // com.tencent.qqmusic.third.api.contract.IQQMusicApi
            public Bundle registerEventListener(List<String> r100, IQQMusicApiEventListener r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r102.writeStringList(r100);     // Catch: Throwable -> L12
                Bundle r104 = null;
                if (r101 == null) goto L6;
                IBinder r105 = r101.asBinder();     // Catch: Throwable -> L12
            L7:
                r102.writeStrongBinder(r105);     // Catch: Throwable -> L12
                INVOKEINTERFACE_com_tencent_qqmusic_third_api_contract_IQQMusicApi$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r102, r103, 0);     // Catch: Throwable -> L12
                r103.readException();     // Catch: Throwable -> L12
                if (r103.readInt() == 0) goto L10;
                r104 = (Bundle) Bundle.CREATOR.createFromParcel(r103);     // Catch: Throwable -> L12
            L10:
                r103.recycle();
                r102.recycle();
                return r104;
            L6:
                r105 = null;
            L12:
                th = move-exception;
                r103.recycle();
                r102.recycle();
                throw th;
            }

            @Override // com.tencent.qqmusic.third.api.contract.IQQMusicApi
            public Bundle unregisterEventListener(List<String> r100, IQQMusicApiEventListener r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r102.writeStringList(r100);     // Catch: Throwable -> L12
                Bundle r104 = null;
                if (r101 == null) goto L6;
                IBinder r105 = r101.asBinder();     // Catch: Throwable -> L12
            L7:
                r102.writeStrongBinder(r105);     // Catch: Throwable -> L12
                INVOKEINTERFACE_com_tencent_qqmusic_third_api_contract_IQQMusicApi$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r102, r103, 0);     // Catch: Throwable -> L12
                r103.readException();     // Catch: Throwable -> L12
                if (r103.readInt() == 0) goto L10;
                r104 = (Bundle) Bundle.CREATOR.createFromParcel(r103);     // Catch: Throwable -> L12
            L10:
                r103.recycle();
                r102.recycle();
                return r104;
            L6:
                r105 = null;
            L12:
                th = move-exception;
                r103.recycle();
                r102.recycle();
                throw th;
            }

            @Override // com.tencent.qqmusic.third.api.contract.IQQMusicApi
            public void executeAsync(String r100, Bundle r101, IQQMusicApiCallback r102) throws RemoteException {
                Parcel r103 = Parcel.obtain();
                r103.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L14
                r103.writeString(r100);     // Catch: Throwable -> L14
                if (r101 == null) goto L6;
                r103.writeInt(1);     // Catch: Throwable -> L14
                r101.writeToParcel(r103, 0);     // Catch: Throwable -> L14
            L8:
                if (r102 == null) goto L10;
                IBinder r104 = r102.asBinder();     // Catch: Throwable -> L14
            L11:
                r103.writeStrongBinder(r104);     // Catch: Throwable -> L14
                INVOKEINTERFACE_com_tencent_qqmusic_third_api_contract_IQQMusicApi$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r103, null, 1);     // Catch: Throwable -> L14
                r103.recycle();
                return;
            L10:
                r104 = null;
                goto L11
            L6:
                r103.writeInt(0);     // Catch: Throwable -> L14
            L14:
                th = move-exception;
                r103.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_tencent_qqmusic_third_api_contract_IQQMusicApi$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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

        public static IQQMusicApi asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof IQQMusicApi) == false) goto L12;
            return (IQQMusicApi) r101;
        L12:
            return new Proxy(r100);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r100, Parcel r101, Parcel r102, int r103) throws RemoteException {
            Bundle r104 = null;
            if (r100 != 1) goto L5;
            r101.enforceInterface(DESCRIPTOR);
            String r105 = r101.readString();
            if (r101.readInt() == 0) goto L34;
            r104 = (Bundle) Bundle.CREATOR.createFromParcel(r101);
        L34:
            Bundle r106 = execute(r105, r104);
            r102.writeNoException();
            if (r106 == null) goto L37;
            r102.writeInt(1);
            r106.writeToParcel(r102, 1);
        L38:
            return true;
        L37:
            r102.writeInt(0);
            goto L38
        L5:
            if (r100 != 2) goto L7;
            r101.enforceInterface(DESCRIPTOR);
            String r107 = r101.readString();
            if (r101.readInt() == 0) goto L29;
            r104 = (Bundle) Bundle.CREATOR.createFromParcel(r101);
        L29:
            executeAsync(r107, r104, IQQMusicApiCallback.Stub.asInterface(r101.readStrongBinder()));
            return true;
        L7:
            if (r100 != 3) goto L9;
            r101.enforceInterface(DESCRIPTOR);
            Bundle r108 = registerEventListener(r101.createStringArrayList(), IQQMusicApiEventListener.Stub.asInterface(r101.readStrongBinder()));
            r102.writeNoException();
            if (r108 == null) goto L24;
            r102.writeInt(1);
            r108.writeToParcel(r102, 1);
        L25:
            return true;
        L24:
            r102.writeInt(0);
            goto L25
        L9:
            if (r100 != 4) goto L11;
            r101.enforceInterface(DESCRIPTOR);
            Bundle r109 = unregisterEventListener(r101.createStringArrayList(), IQQMusicApiEventListener.Stub.asInterface(r101.readStrongBinder()));
            r102.writeNoException();
            if (r109 == null) goto L19;
            r102.writeInt(1);
            r109.writeToParcel(r102, 1);
        L20:
            return true;
        L19:
            r102.writeInt(0);
            goto L20
        L11:
            if (r100 != 1598968902) goto L13;
            r102.writeString(DESCRIPTOR);
            return true;
        L13:
            return super.onTransact(r100, r101, r102, r103);
        }
    }

    Bundle execute(String r100, Bundle r101) throws RemoteException;

    void executeAsync(String r100, Bundle r101, IQQMusicApiCallback r102) throws RemoteException;

    Bundle registerEventListener(List<String> r100, IQQMusicApiEventListener r101) throws RemoteException;

    Bundle unregisterEventListener(List<String> r100, IQQMusicApiEventListener r101) throws RemoteException;
}
