package com.ss.android.socialbase.downloader.depend;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes38.dex */
public interface IDownloadAidlDepend extends IInterface {

    public static class Default implements IDownloadAidlDepend {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlDepend
        public void monitorLogSend(DownloadInfo r100, BaseException r101, int r102) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IDownloadAidlDepend {
        private static final String DESCRIPTOR = "com.ss.android.socialbase.downloader.depend.IDownloadAidlDepend";
        static final int TRANSACTION_monitorLogSend = 1;

        public static class Proxy implements IDownloadAidlDepend {
            public static IDownloadAidlDepend sDefaultImpl;
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

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlDepend
            public void monitorLogSend(DownloadInfo r100, BaseException r101, int r102) throws RemoteException {
                Parcel r103 = Parcel.obtain();
                Parcel r104 = Parcel.obtain();
                r103.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L20
                if (r100 == null) goto L6;
                r103.writeInt(1);     // Catch: Throwable -> L20
                r100.writeToParcel(r103, 0);     // Catch: Throwable -> L20
            L7:
                if (r101 == null) goto L9;
                r103.writeInt(1);     // Catch: Throwable -> L20
                r101.writeToParcel(r103, 0);     // Catch: Throwable -> L20
            L10:
                r103.writeInt(r102);     // Catch: Throwable -> L20
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_depend_IDownloadAidlDepend$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r103, r104, 0) == false) goto L13;
            L17:
                r104.readException();     // Catch: Throwable -> L20
                r104.recycle();
                r103.recycle();
                return;
            L13:
                if (Stub.getDefaultImpl() == null) goto L17;
                Stub.getDefaultImpl().monitorLogSend(r100, r101, r102);     // Catch: Throwable -> L20
                r104.recycle();
                r103.recycle();
                return;
            L9:
                r103.writeInt(0);     // Catch: Throwable -> L20
                goto L10
            L6:
                r103.writeInt(0);     // Catch: Throwable -> L20
            L20:
                th = move-exception;
                r104.recycle();
                r103.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_ss_android_socialbase_downloader_depend_IDownloadAidlDepend$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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

        public static IDownloadAidlDepend getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static IDownloadAidlDepend asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof IDownloadAidlDepend) == false) goto L12;
            return (IDownloadAidlDepend) r101;
        L12:
            return new Proxy(r100);
        }

        public static boolean setDefaultImpl(IDownloadAidlDepend r100) {
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
            BaseException r104 = null;
            if (r101.readInt() == 0) goto L13;
            DownloadInfo r105 = DownloadInfo.CREATOR.createFromParcel(r101);
        L15:
            if (r101.readInt() == 0) goto L17;
            r104 = BaseException.CREATOR.createFromParcel(r101);
        L17:
            monitorLogSend(r105, r104, r101.readInt());
            r102.writeNoException();
            return true;
        L13:
            r105 = null;
            goto L15
        L5:
            if (r100 != 1598968902) goto L7;
            r102.writeString(DESCRIPTOR);
            return true;
        L7:
            return super.onTransact(r100, r101, r102, r103);
        }
    }

    void monitorLogSend(DownloadInfo r100, BaseException r101, int r102) throws RemoteException;
}
