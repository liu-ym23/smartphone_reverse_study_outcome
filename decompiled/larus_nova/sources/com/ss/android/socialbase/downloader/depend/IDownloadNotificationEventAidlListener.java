package com.ss.android.socialbase.downloader.depend;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes38.dex */
public interface IDownloadNotificationEventAidlListener extends IInterface {

    public static class Default implements IDownloadNotificationEventAidlListener {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener
        public String getNotifyProcessName() throws RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener
        public boolean interceptAfterNotificationSuccess(boolean r100) throws RemoteException {
            return false;
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener
        public void onNotificationEvent(int r100, DownloadInfo r101, String r102, String r103) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IDownloadNotificationEventAidlListener {
        private static final String DESCRIPTOR = "com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener";
        static final int TRANSACTION_getNotifyProcessName = 3;
        static final int TRANSACTION_interceptAfterNotificationSuccess = 2;
        static final int TRANSACTION_onNotificationEvent = 1;

        public static class Proxy implements IDownloadNotificationEventAidlListener {
            public static IDownloadNotificationEventAidlListener sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener
            public String getNotifyProcessName() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_depend_IDownloadNotificationEventAidlListener$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L13
                String r102 = r101.readString();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r102;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                String r103 = Stub.getDefaultImpl().getNotifyProcessName();     // Catch: Throwable -> L13
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

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener
            public boolean interceptAfterNotificationSuccess(boolean r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L20
                boolean r103 = true;
                if (r100 == false) goto L6;
                int r104 = 1;
            L7:
                r101.writeInt(r104);     // Catch: Throwable -> L20
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_depend_IDownloadNotificationEventAidlListener$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r101, r102, 0) == false) goto L10;
            L14:
                r102.readException();     // Catch: Throwable -> L20
                if (r102.readInt() != 0) goto L18;
                r103 = false;
            L18:
                r102.recycle();
                r101.recycle();
                return r103;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                boolean r105 = Stub.getDefaultImpl().interceptAfterNotificationSuccess(r100);     // Catch: Throwable -> L20
                r102.recycle();
                r101.recycle();
                return r105;
            L6:
                r104 = 0;
            L20:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener
            public void onNotificationEvent(int r100, DownloadInfo r101, String r102, String r103) throws RemoteException {
                Parcel r104 = Parcel.obtain();
                Parcel r105 = Parcel.obtain();
                r104.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r104.writeInt(r100);     // Catch: Throwable -> L17
                if (r101 == null) goto L6;
                r104.writeInt(1);     // Catch: Throwable -> L17
                r101.writeToParcel(r104, 0);     // Catch: Throwable -> L17
            L7:
                r104.writeString(r102);     // Catch: Throwable -> L17
                r104.writeString(r103);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_depend_IDownloadNotificationEventAidlListener$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r104, r105, 0) == false) goto L10;
            L14:
                r105.readException();     // Catch: Throwable -> L17
                r105.recycle();
                r104.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().onNotificationEvent(r100, r101, r102, r103);     // Catch: Throwable -> L17
                r105.recycle();
                r104.recycle();
                return;
            L6:
                r104.writeInt(0);     // Catch: Throwable -> L17
            L17:
                th = move-exception;
                r105.recycle();
                r104.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_ss_android_socialbase_downloader_depend_IDownloadNotificationEventAidlListener$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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

        public static IDownloadNotificationEventAidlListener getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static IDownloadNotificationEventAidlListener asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof IDownloadNotificationEventAidlListener) == false) goto L12;
            return (IDownloadNotificationEventAidlListener) r101;
        L12:
            return new Proxy(r100);
        }

        public static boolean setDefaultImpl(IDownloadNotificationEventAidlListener r100) {
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
            int r104 = r101.readInt();
            if (r101.readInt() == 0) goto L25;
            DownloadInfo r105 = DownloadInfo.CREATOR.createFromParcel(r101);
        L26:
            onNotificationEvent(r104, r105, r101.readString(), r101.readString());
            r102.writeNoException();
            return true;
        L25:
            r105 = null;
            goto L26
        L5:
            if (r100 != 2) goto L7;
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L19;
            boolean r106 = true;
        L20:
            boolean r107 = interceptAfterNotificationSuccess(r106);
            r102.writeNoException();
            r102.writeInt(r107 ? 1 : 0);
            return true;
        L19:
            r106 = false;
            goto L20
        L7:
            if (r100 != 3) goto L9;
            r101.enforceInterface(DESCRIPTOR);
            String r108 = getNotifyProcessName();
            r102.writeNoException();
            r102.writeString(r108);
            return true;
        L9:
            if (r100 != 1598968902) goto L11;
            r102.writeString(DESCRIPTOR);
            return true;
        L11:
            return super.onTransact(r100, r101, r102, r103);
        }
    }

    String getNotifyProcessName() throws RemoteException;

    boolean interceptAfterNotificationSuccess(boolean r100) throws RemoteException;

    void onNotificationEvent(int r100, DownloadInfo r101, String r102, String r103) throws RemoteException;
}
