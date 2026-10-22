package com.ss.android.socialbase.downloader.depend;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes38.dex */
public interface IDownloadDiskSpaceAidlHandler extends IInterface {

    public static class Default implements IDownloadDiskSpaceAidlHandler {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler
        public boolean cleanUpDisk(long r100, long r101, IDownloadDiskSpaceAidlCallback r102) throws RemoteException {
            return false;
        }
    }

    public static abstract class Stub extends Binder implements IDownloadDiskSpaceAidlHandler {
        private static final String DESCRIPTOR = "com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler";
        static final int TRANSACTION_cleanUpDisk = 1;

        public static class Proxy implements IDownloadDiskSpaceAidlHandler {
            public static IDownloadDiskSpaceAidlHandler sDefaultImpl;
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

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler
            public boolean cleanUpDisk(long r110, long r111, IDownloadDiskSpaceAidlCallback r112) throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L19
                r100.writeLong(r110);     // Catch: Throwable -> L19
                r100.writeLong(r111);     // Catch: Throwable -> L19
                if (r112 == null) goto L6;
                IBinder r102 = r112.asBinder();     // Catch: Throwable -> L19
            L7:
                r100.writeStrongBinder(r102);     // Catch: Throwable -> L19
                boolean r103 = false;
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_depend_IDownloadDiskSpaceAidlHandler$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r100, r101, 0) == false) goto L10;
            L14:
                r101.readException();     // Catch: Throwable -> L19
                if (r101.readInt() == 0) goto L17;
                r103 = true;
            L17:
                r101.recycle();
                r100.recycle();
                return r103;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                boolean r104 = Stub.getDefaultImpl().cleanUpDisk(r110, r111, r112);     // Catch: Throwable -> L19
                r101.recycle();
                r100.recycle();
                return r104;
            L6:
                r102 = null;
            L19:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_ss_android_socialbase_downloader_depend_IDownloadDiskSpaceAidlHandler$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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

        public static IDownloadDiskSpaceAidlHandler getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static IDownloadDiskSpaceAidlHandler asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof IDownloadDiskSpaceAidlHandler) == false) goto L12;
            return (IDownloadDiskSpaceAidlHandler) r101;
        L12:
            return new Proxy(r100);
        }

        public static boolean setDefaultImpl(IDownloadDiskSpaceAidlHandler r100) {
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
            boolean r102 = cleanUpDisk(r101.readLong(), r101.readLong(), IDownloadDiskSpaceAidlCallback.Stub.asInterface(r101.readStrongBinder()));
            r110.writeNoException();
            r110.writeInt(r102 ? 1 : 0);
            return true;
        L5:
            if (r100 != 1598968902) goto L7;
            r110.writeString(DESCRIPTOR);
            return true;
        L7:
            return super.onTransact(r100, r101, r110, r111);
        }
    }

    boolean cleanUpDisk(long r100, long r101, IDownloadDiskSpaceAidlCallback r102) throws RemoteException;
}
