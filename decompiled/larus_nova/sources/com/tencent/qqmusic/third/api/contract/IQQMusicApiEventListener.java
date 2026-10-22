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
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes35.dex */
public interface IQQMusicApiEventListener extends IInterface {

    public static abstract class Stub extends Binder implements IQQMusicApiEventListener {
        private static final String DESCRIPTOR = "com.tencent.qqmusic.third.api.contract.IQQMusicApiEventListener";
        static final int TRANSACTION_onEvent = 1;

        public static class Proxy implements IQQMusicApiEventListener {
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

            @Override // com.tencent.qqmusic.third.api.contract.IQQMusicApiEventListener
            public void onEvent(String r100, Bundle r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L10
                r102.writeString(r100);     // Catch: Throwable -> L10
                if (r101 == null) goto L6;
                r102.writeInt(1);     // Catch: Throwable -> L10
                r101.writeToParcel(r102, 0);     // Catch: Throwable -> L10
            L7:
                INVOKEINTERFACE_com_tencent_qqmusic_third_api_contract_IQQMusicApiEventListener$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r102, null, 1);     // Catch: Throwable -> L10
                r102.recycle();
                return;
            L6:
                r102.writeInt(0);     // Catch: Throwable -> L10
            L10:
                th = move-exception;
                r102.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_tencent_qqmusic_third_api_contract_IQQMusicApiEventListener$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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

        public static IQQMusicApiEventListener asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof IQQMusicApiEventListener) == false) goto L12;
            return (IQQMusicApiEventListener) r101;
        L12:
            return new Proxy(r100);
        }

        @Override // android.os.Binder
        public boolean onTransact(int r100, Parcel r101, Parcel r102, int r103) throws RemoteException {
            if (r100 != 1) goto L5;
            r101.enforceInterface(DESCRIPTOR);
            String r104 = r101.readString();
            if (r101.readInt() == 0) goto L13;
            Bundle r105 = (Bundle) Bundle.CREATOR.createFromParcel(r101);
        L14:
            onEvent(r104, r105);
            return true;
        L13:
            r105 = null;
            goto L14
        L5:
            if (r100 != 1598968902) goto L7;
            r102.writeString(DESCRIPTOR);
            return true;
        L7:
            return super.onTransact(r100, r101, r102, r103);
        }
    }

    void onEvent(String r100, Bundle r101) throws RemoteException;
}
