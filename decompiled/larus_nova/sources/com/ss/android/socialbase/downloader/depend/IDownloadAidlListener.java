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

/* JADX INFO: loaded from: classes6.dex */
public interface IDownloadAidlListener extends IInterface {

    /* JADX INFO: loaded from: classes38.dex */
    public static class Default implements IDownloadAidlListener {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlListener
        public int getOriginHashCode() throws RemoteException {
            return 0;
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlListener
        public void onCanceled(DownloadInfo r100) throws RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlListener
        public void onFailed(DownloadInfo r100, BaseException r101) throws RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlListener
        public void onFirstStart(DownloadInfo r100) throws RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlListener
        public void onFirstSuccess(DownloadInfo r100) throws RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlListener
        public void onPause(DownloadInfo r100) throws RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlListener
        public void onPrepare(DownloadInfo r100) throws RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlListener
        public void onProgress(DownloadInfo r100) throws RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlListener
        public void onRetry(DownloadInfo r100, BaseException r101) throws RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlListener
        public void onRetryDelay(DownloadInfo r100, BaseException r101) throws RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlListener
        public void onStart(DownloadInfo r100) throws RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlListener
        public void onSuccessed(DownloadInfo r100) throws RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlListener
        public void onWaitingDownloadCompleteHandler(DownloadInfo r100) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IDownloadAidlListener {
        private static final String DESCRIPTOR = "com.ss.android.socialbase.downloader.depend.IDownloadAidlListener";
        static final int TRANSACTION_getOriginHashCode = 1;
        static final int TRANSACTION_onCanceled = 8;
        static final int TRANSACTION_onFailed = 7;
        static final int TRANSACTION_onFirstStart = 9;
        static final int TRANSACTION_onFirstSuccess = 10;
        static final int TRANSACTION_onPause = 5;
        static final int TRANSACTION_onPrepare = 2;
        static final int TRANSACTION_onProgress = 4;
        static final int TRANSACTION_onRetry = 11;
        static final int TRANSACTION_onRetryDelay = 12;
        static final int TRANSACTION_onStart = 3;
        static final int TRANSACTION_onSuccessed = 6;
        static final int TRANSACTION_onWaitingDownloadCompleteHandler = 13;

        /* JADX INFO: loaded from: classes38.dex */
        public static class Proxy implements IDownloadAidlListener {
            public static IDownloadAidlListener sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlListener
            public int getOriginHashCode() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_depend_IDownloadAidlListener$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L13
                int r102 = r101.readInt();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r102;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r103 = Stub.getDefaultImpl().getOriginHashCode();     // Catch: Throwable -> L13
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

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlListener
            public void onCanceled(DownloadInfo r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r100 == null) goto L6;
                r101.writeInt(1);     // Catch: Throwable -> L17
                r100.writeToParcel(r101, 0);     // Catch: Throwable -> L17
            L8:
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_depend_IDownloadAidlListener$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 8, r101, r102, 0) == false) goto L10;
            L14:
                r102.readException();     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().onCanceled(r100);     // Catch: Throwable -> L17
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

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlListener
            public void onFirstStart(DownloadInfo r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r100 == null) goto L6;
                r101.writeInt(1);     // Catch: Throwable -> L17
                r100.writeToParcel(r101, 0);     // Catch: Throwable -> L17
            L8:
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_depend_IDownloadAidlListener$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 9, r101, r102, 0) == false) goto L10;
            L14:
                r102.readException();     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().onFirstStart(r100);     // Catch: Throwable -> L17
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

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlListener
            public void onFirstSuccess(DownloadInfo r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r100 == null) goto L6;
                r101.writeInt(1);     // Catch: Throwable -> L17
                r100.writeToParcel(r101, 0);     // Catch: Throwable -> L17
            L8:
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_depend_IDownloadAidlListener$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 10, r101, r102, 0) == false) goto L10;
            L14:
                r102.readException();     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().onFirstSuccess(r100);     // Catch: Throwable -> L17
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

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlListener
            public void onPause(DownloadInfo r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r100 == null) goto L6;
                r101.writeInt(1);     // Catch: Throwable -> L17
                r100.writeToParcel(r101, 0);     // Catch: Throwable -> L17
            L8:
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_depend_IDownloadAidlListener$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 5, r101, r102, 0) == false) goto L10;
            L14:
                r102.readException();     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().onPause(r100);     // Catch: Throwable -> L17
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

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlListener
            public void onPrepare(DownloadInfo r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r100 == null) goto L6;
                r101.writeInt(1);     // Catch: Throwable -> L17
                r100.writeToParcel(r101, 0);     // Catch: Throwable -> L17
            L8:
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_depend_IDownloadAidlListener$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r101, r102, 0) == false) goto L10;
            L14:
                r102.readException();     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().onPrepare(r100);     // Catch: Throwable -> L17
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

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlListener
            public void onProgress(DownloadInfo r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r100 == null) goto L6;
                r101.writeInt(1);     // Catch: Throwable -> L17
                r100.writeToParcel(r101, 0);     // Catch: Throwable -> L17
            L8:
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_depend_IDownloadAidlListener$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r101, r102, 0) == false) goto L10;
            L14:
                r102.readException();     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().onProgress(r100);     // Catch: Throwable -> L17
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

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlListener
            public void onStart(DownloadInfo r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r100 == null) goto L6;
                r101.writeInt(1);     // Catch: Throwable -> L17
                r100.writeToParcel(r101, 0);     // Catch: Throwable -> L17
            L8:
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_depend_IDownloadAidlListener$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r101, r102, 0) == false) goto L10;
            L14:
                r102.readException();     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().onStart(r100);     // Catch: Throwable -> L17
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

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlListener
            public void onSuccessed(DownloadInfo r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r100 == null) goto L6;
                r101.writeInt(1);     // Catch: Throwable -> L17
                r100.writeToParcel(r101, 0);     // Catch: Throwable -> L17
            L8:
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_depend_IDownloadAidlListener$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 6, r101, r102, 0) == false) goto L10;
            L14:
                r102.readException();     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().onSuccessed(r100);     // Catch: Throwable -> L17
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

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlListener
            public void onWaitingDownloadCompleteHandler(DownloadInfo r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r100 == null) goto L6;
                r101.writeInt(1);     // Catch: Throwable -> L17
                r100.writeToParcel(r101, 0);     // Catch: Throwable -> L17
            L8:
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_depend_IDownloadAidlListener$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 13, r101, r102, 0) == false) goto L10;
            L14:
                r102.readException();     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().onWaitingDownloadCompleteHandler(r100);     // Catch: Throwable -> L17
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

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlListener
            public void onFailed(DownloadInfo r100, BaseException r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L20
                if (r100 == null) goto L6;
                r102.writeInt(1);     // Catch: Throwable -> L20
                r100.writeToParcel(r102, 0);     // Catch: Throwable -> L20
            L7:
                if (r101 == null) goto L9;
                r102.writeInt(1);     // Catch: Throwable -> L20
                r101.writeToParcel(r102, 0);     // Catch: Throwable -> L20
            L11:
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_depend_IDownloadAidlListener$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 7, r102, r103, 0) == false) goto L13;
            L17:
                r103.readException();     // Catch: Throwable -> L20
                r103.recycle();
                r102.recycle();
                return;
            L13:
                if (Stub.getDefaultImpl() == null) goto L17;
                Stub.getDefaultImpl().onFailed(r100, r101);     // Catch: Throwable -> L20
                r103.recycle();
                r102.recycle();
                return;
            L9:
                r102.writeInt(0);     // Catch: Throwable -> L20
                goto L11
            L6:
                r102.writeInt(0);     // Catch: Throwable -> L20
            L20:
                th = move-exception;
                r103.recycle();
                r102.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlListener
            public void onRetry(DownloadInfo r100, BaseException r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L20
                if (r100 == null) goto L6;
                r102.writeInt(1);     // Catch: Throwable -> L20
                r100.writeToParcel(r102, 0);     // Catch: Throwable -> L20
            L7:
                if (r101 == null) goto L9;
                r102.writeInt(1);     // Catch: Throwable -> L20
                r101.writeToParcel(r102, 0);     // Catch: Throwable -> L20
            L11:
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_depend_IDownloadAidlListener$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 11, r102, r103, 0) == false) goto L13;
            L17:
                r103.readException();     // Catch: Throwable -> L20
                r103.recycle();
                r102.recycle();
                return;
            L13:
                if (Stub.getDefaultImpl() == null) goto L17;
                Stub.getDefaultImpl().onRetry(r100, r101);     // Catch: Throwable -> L20
                r103.recycle();
                r102.recycle();
                return;
            L9:
                r102.writeInt(0);     // Catch: Throwable -> L20
                goto L11
            L6:
                r102.writeInt(0);     // Catch: Throwable -> L20
            L20:
                th = move-exception;
                r103.recycle();
                r102.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlListener
            public void onRetryDelay(DownloadInfo r100, BaseException r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L20
                if (r100 == null) goto L6;
                r102.writeInt(1);     // Catch: Throwable -> L20
                r100.writeToParcel(r102, 0);     // Catch: Throwable -> L20
            L7:
                if (r101 == null) goto L9;
                r102.writeInt(1);     // Catch: Throwable -> L20
                r101.writeToParcel(r102, 0);     // Catch: Throwable -> L20
            L11:
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_depend_IDownloadAidlListener$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 12, r102, r103, 0) == false) goto L13;
            L17:
                r103.readException();     // Catch: Throwable -> L20
                r103.recycle();
                r102.recycle();
                return;
            L13:
                if (Stub.getDefaultImpl() == null) goto L17;
                Stub.getDefaultImpl().onRetryDelay(r100, r101);     // Catch: Throwable -> L20
                r103.recycle();
                r102.recycle();
                return;
            L9:
                r102.writeInt(0);     // Catch: Throwable -> L20
                goto L11
            L6:
                r102.writeInt(0);     // Catch: Throwable -> L20
            L20:
                th = move-exception;
                r103.recycle();
                r102.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_ss_android_socialbase_downloader_depend_IDownloadAidlListener$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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

        public static IDownloadAidlListener getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static IDownloadAidlListener asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof IDownloadAidlListener) == false) goto L12;
            return (IDownloadAidlListener) r101;
        L12:
            return new Proxy(r100);
        }

        public static boolean setDefaultImpl(IDownloadAidlListener r100) {
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
            if (r100 == 1598968902) goto L82;
            DownloadInfo r104 = null;
            DownloadInfo r105 = null;
            BaseException r106 = null;
            BaseException r107 = null;
            DownloadInfo r108 = null;
            DownloadInfo r109 = null;
            DownloadInfo r110 = null;
            BaseException r111 = null;
            DownloadInfo r112 = null;
            DownloadInfo r113 = null;
            DownloadInfo r114 = null;
            DownloadInfo r115 = null;
            switch(r100) {
                case 1: goto L80;
                case 2: goto L75;
                case 3: goto L70;
                case 4: goto L65;
                case 5: goto L60;
                case 6: goto L55;
                case 7: goto L46;
                case 8: goto L41;
                case 9: goto L36;
                case 10: goto L31;
                case 11: goto L22;
                case 12: goto L13;
                case 13: goto L8;
                default: goto L7;
            };
        L8:
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L11;
            r105 = DownloadInfo.CREATOR.createFromParcel(r101);
        L11:
            onWaitingDownloadCompleteHandler(r105);
            r102.writeNoException();
            return true;
        L13:
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L16;
            DownloadInfo r116 = DownloadInfo.CREATOR.createFromParcel(r101);
        L18:
            if (r101.readInt() == 0) goto L20;
            r106 = BaseException.CREATOR.createFromParcel(r101);
        L20:
            onRetryDelay(r116, r106);
            r102.writeNoException();
            return true;
        L16:
            r116 = null;
            goto L18
        L22:
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L25;
            DownloadInfo r117 = DownloadInfo.CREATOR.createFromParcel(r101);
        L27:
            if (r101.readInt() == 0) goto L29;
            r107 = BaseException.CREATOR.createFromParcel(r101);
        L29:
            onRetry(r117, r107);
            r102.writeNoException();
            return true;
        L25:
            r117 = null;
            goto L27
        L31:
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L34;
            r108 = DownloadInfo.CREATOR.createFromParcel(r101);
        L34:
            onFirstSuccess(r108);
            r102.writeNoException();
            return true;
        L36:
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L39;
            r109 = DownloadInfo.CREATOR.createFromParcel(r101);
        L39:
            onFirstStart(r109);
            r102.writeNoException();
            return true;
        L41:
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L44;
            r110 = DownloadInfo.CREATOR.createFromParcel(r101);
        L44:
            onCanceled(r110);
            r102.writeNoException();
            return true;
        L46:
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L49;
            DownloadInfo r118 = DownloadInfo.CREATOR.createFromParcel(r101);
        L51:
            if (r101.readInt() == 0) goto L53;
            r111 = BaseException.CREATOR.createFromParcel(r101);
        L53:
            onFailed(r118, r111);
            r102.writeNoException();
            return true;
        L49:
            r118 = null;
            goto L51
        L55:
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L58;
            r112 = DownloadInfo.CREATOR.createFromParcel(r101);
        L58:
            onSuccessed(r112);
            r102.writeNoException();
            return true;
        L60:
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L63;
            r113 = DownloadInfo.CREATOR.createFromParcel(r101);
        L63:
            onPause(r113);
            r102.writeNoException();
            return true;
        L65:
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L68;
            r114 = DownloadInfo.CREATOR.createFromParcel(r101);
        L68:
            onProgress(r114);
            r102.writeNoException();
            return true;
        L70:
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L73;
            r115 = DownloadInfo.CREATOR.createFromParcel(r101);
        L73:
            onStart(r115);
            r102.writeNoException();
            return true;
        L75:
            r101.enforceInterface(DESCRIPTOR);
            if (r101.readInt() == 0) goto L78;
            r104 = DownloadInfo.CREATOR.createFromParcel(r101);
        L78:
            onPrepare(r104);
            r102.writeNoException();
            return true;
        L80:
            r101.enforceInterface(DESCRIPTOR);
            int r119 = getOriginHashCode();
            r102.writeNoException();
            r102.writeInt(r119);
            return true;
        L7:
            return super.onTransact(r100, r101, r102, r103);
        L82:
            r102.writeString(DESCRIPTOR);
            return true;
        }
    }

    int getOriginHashCode() throws RemoteException;

    void onCanceled(DownloadInfo r100) throws RemoteException;

    void onFailed(DownloadInfo r100, BaseException r101) throws RemoteException;

    void onFirstStart(DownloadInfo r100) throws RemoteException;

    void onFirstSuccess(DownloadInfo r100) throws RemoteException;

    void onPause(DownloadInfo r100) throws RemoteException;

    void onPrepare(DownloadInfo r100) throws RemoteException;

    void onProgress(DownloadInfo r100) throws RemoteException;

    void onRetry(DownloadInfo r100, BaseException r101) throws RemoteException;

    void onRetryDelay(DownloadInfo r100, BaseException r101) throws RemoteException;

    void onStart(DownloadInfo r100) throws RemoteException;

    void onSuccessed(DownloadInfo r100) throws RemoteException;

    void onWaitingDownloadCompleteHandler(DownloadInfo r100) throws RemoteException;
}
