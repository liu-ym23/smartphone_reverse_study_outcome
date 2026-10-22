package com.obric.cae.libs.statusreport;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes33.dex */
public interface ILinkLayerQualityListener extends IInterface {

    public static class Default implements ILinkLayerQualityListener {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.cae.libs.statusreport.ILinkLayerQualityListener
        public void onAverLinkLayerLevelChanged(LinkLayerQuality r100) throws RemoteException {
        }

        @Override // com.obric.cae.libs.statusreport.ILinkLayerQualityListener
        public void onLinkLayerLevelChanged(LinkLayerQuality r100) throws RemoteException {
        }

        @Override // com.obric.cae.libs.statusreport.ILinkLayerQualityListener
        public void onLinkLayerQualityChanged(LinkLayerQuality r100) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements ILinkLayerQualityListener {
        private static final String DESCRIPTOR = "com.obric.cae.libs.statusreport.ILinkLayerQualityListener";
        static final int TRANSACTION_onAverLinkLayerLevelChanged = 3;
        static final int TRANSACTION_onLinkLayerLevelChanged = 2;
        static final int TRANSACTION_onLinkLayerQualityChanged = 1;

        public static class Proxy implements ILinkLayerQualityListener {
            public static ILinkLayerQualityListener sDefaultImpl;
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

            @Override // com.obric.cae.libs.statusreport.ILinkLayerQualityListener
            public void onAverLinkLayerLevelChanged(LinkLayerQuality r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r100 == null) goto L6;
                r101.writeInt(1);     // Catch: Throwable -> L17
                r100.writeToParcel(r101, 0);     // Catch: Throwable -> L17
            L8:
                if (INVOKEINTERFACE_com_obric_cae_libs_statusreport_ILinkLayerQualityListener$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r101, r102, 0) == false) goto L10;
            L14:
                r102.readException();     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().onAverLinkLayerLevelChanged(r100);     // Catch: Throwable -> L17
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

            @Override // com.obric.cae.libs.statusreport.ILinkLayerQualityListener
            public void onLinkLayerLevelChanged(LinkLayerQuality r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r100 == null) goto L6;
                r101.writeInt(1);     // Catch: Throwable -> L17
                r100.writeToParcel(r101, 0);     // Catch: Throwable -> L17
            L8:
                if (INVOKEINTERFACE_com_obric_cae_libs_statusreport_ILinkLayerQualityListener$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r101, r102, 0) == false) goto L10;
            L14:
                r102.readException();     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().onLinkLayerLevelChanged(r100);     // Catch: Throwable -> L17
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

            @Override // com.obric.cae.libs.statusreport.ILinkLayerQualityListener
            public void onLinkLayerQualityChanged(LinkLayerQuality r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r100 == null) goto L6;
                r101.writeInt(1);     // Catch: Throwable -> L17
                r100.writeToParcel(r101, 0);     // Catch: Throwable -> L17
            L8:
                if (INVOKEINTERFACE_com_obric_cae_libs_statusreport_ILinkLayerQualityListener$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r101, r102, 0) == false) goto L10;
            L14:
                r102.readException();     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().onLinkLayerQualityChanged(r100);     // Catch: Throwable -> L17
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

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_obric_cae_libs_statusreport_ILinkLayerQualityListener$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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

        public static ILinkLayerQualityListener getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static ILinkLayerQualityListener asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof ILinkLayerQualityListener) == false) goto L12;
            return (ILinkLayerQualityListener) r101;
        L12:
            return new Proxy(r100);
        }

        public static boolean setDefaultImpl(ILinkLayerQualityListener r100) {
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
            LinkLayerQuality r104 = null;
            if (r100 != 1) goto L5;
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L27;
            r104 = LinkLayerQuality.CREATOR.createFromParcel(r101);
        L27:
            onLinkLayerQualityChanged(r104);
            r102.writeNoException();
            return true;
        L5:
            if (r100 != 2) goto L7;
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L22;
            r104 = LinkLayerQuality.CREATOR.createFromParcel(r101);
        L22:
            onLinkLayerLevelChanged(r104);
            r102.writeNoException();
            return true;
        L7:
            if (r100 != 3) goto L9;
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L17;
            r104 = LinkLayerQuality.CREATOR.createFromParcel(r101);
        L17:
            onAverLinkLayerLevelChanged(r104);
            r102.writeNoException();
            return true;
        L9:
            if (r100 != 1598968902) goto L11;
            r102.writeString(DESCRIPTOR);
            return true;
        L11:
            return super.onTransact(r100, r101, r102, r103);
        }
    }

    void onAverLinkLayerLevelChanged(LinkLayerQuality r100) throws RemoteException;

    void onLinkLayerLevelChanged(LinkLayerQuality r100) throws RemoteException;

    void onLinkLayerQualityChanged(LinkLayerQuality r100) throws RemoteException;
}
