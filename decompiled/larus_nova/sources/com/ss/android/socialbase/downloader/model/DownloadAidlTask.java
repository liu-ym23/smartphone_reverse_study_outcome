package com.ss.android.socialbase.downloader.model;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import com.ss.android.socialbase.downloader.depend.IDownloadAidlDepend;
import com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadAidlInterceptor;
import com.ss.android.socialbase.downloader.depend.IDownloadAidlListener;
import com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend;
import com.ss.android.socialbase.downloader.depend.IDownloadCompleteAidlHandler;
import com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler;
import com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler;
import com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener;
import com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes6.dex */
public interface DownloadAidlTask extends IInterface {

    /* JADX INFO: loaded from: classes38.dex */
    public static class Default implements DownloadAidlTask {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
        public IDownloadAidlDepend getDepend() throws RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
        public IDownloadDiskSpaceAidlHandler getDiskSpaceHandler() throws RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
        public IDownloadCompleteAidlHandler getDownloadCompleteAidlHandlerByIndex(int r100) throws RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
        public int getDownloadCompleteHandlerSize() throws RemoteException {
            return 0;
        }

        @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
        public DownloadInfo getDownloadInfo() throws RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
        public IDownloadAidlListener getDownloadListenerByHashCode(int r100, int r101) throws RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
        public int[] getDownloadListenerHashCodeLists(int r100) throws RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
        public IDownloadNotificationEventAidlListener getDownloadNotificationEventListener() throws RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
        public IDownloadAidlFileProvider getFileProvider() throws RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
        public IDownloadForbiddenAidlHandler getForbiddenHandler() throws RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
        public IDownloadAidlInterceptor getInterceptor() throws RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
        public IDownloadAidlMonitorDepend getMonitorDepend() throws RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
        public INotificationClickAidlCallback getNotificationClickCallback() throws RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
        public IDownloadAidlListener getSingleDownloadListener(int r100) throws RemoteException {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements DownloadAidlTask {
        private static final String DESCRIPTOR = "com.ss.android.socialbase.downloader.model.DownloadAidlTask";
        static final int TRANSACTION_getDepend = 8;
        static final int TRANSACTION_getDiskSpaceHandler = 10;
        static final int TRANSACTION_getDownloadCompleteAidlHandlerByIndex = 14;
        static final int TRANSACTION_getDownloadCompleteHandlerSize = 13;
        static final int TRANSACTION_getDownloadInfo = 1;
        static final int TRANSACTION_getDownloadListenerByHashCode = 3;
        static final int TRANSACTION_getDownloadListenerHashCodeLists = 2;
        static final int TRANSACTION_getDownloadNotificationEventListener = 5;
        static final int TRANSACTION_getFileProvider = 12;
        static final int TRANSACTION_getForbiddenHandler = 9;
        static final int TRANSACTION_getInterceptor = 7;
        static final int TRANSACTION_getMonitorDepend = 11;
        static final int TRANSACTION_getNotificationClickCallback = 6;
        static final int TRANSACTION_getSingleDownloadListener = 4;

        /* JADX INFO: loaded from: classes38.dex */
        public static class Proxy implements DownloadAidlTask {
            public static DownloadAidlTask sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
            public IDownloadAidlDepend getDepend() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_model_DownloadAidlTask$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 8, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L13
                IDownloadAidlDepend r102 = IDownloadAidlDepend.Stub.asInterface(r101.readStrongBinder());     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r102;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                IDownloadAidlDepend r103 = Stub.getDefaultImpl().getDepend();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r103;
            L13:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
            public IDownloadDiskSpaceAidlHandler getDiskSpaceHandler() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_model_DownloadAidlTask$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 10, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L13
                IDownloadDiskSpaceAidlHandler r102 = IDownloadDiskSpaceAidlHandler.Stub.asInterface(r101.readStrongBinder());     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r102;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                IDownloadDiskSpaceAidlHandler r103 = Stub.getDefaultImpl().getDiskSpaceHandler();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r103;
            L13:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
            public int getDownloadCompleteHandlerSize() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_model_DownloadAidlTask$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 13, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L13
                int r102 = r101.readInt();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r102;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r103 = Stub.getDefaultImpl().getDownloadCompleteHandlerSize();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r103;
            L13:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
            public DownloadInfo getDownloadInfo() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_model_DownloadAidlTask$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L17
                if (r101.readInt() == 0) goto L14;
                DownloadInfo r102 = DownloadInfo.CREATOR.createFromParcel(r101);     // Catch: Throwable -> L17
            L15:
                r101.recycle();
                r100.recycle();
                return r102;
            L14:
                r102 = null;
                goto L15
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                DownloadInfo r103 = Stub.getDefaultImpl().getDownloadInfo();     // Catch: Throwable -> L17
                r101.recycle();
                r100.recycle();
                return r103;
            L17:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
            public IDownloadNotificationEventAidlListener getDownloadNotificationEventListener() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_model_DownloadAidlTask$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 5, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L13
                IDownloadNotificationEventAidlListener r102 = IDownloadNotificationEventAidlListener.Stub.asInterface(r101.readStrongBinder());     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r102;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                IDownloadNotificationEventAidlListener r103 = Stub.getDefaultImpl().getDownloadNotificationEventListener();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r103;
            L13:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
            public IDownloadAidlFileProvider getFileProvider() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_model_DownloadAidlTask$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 12, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L13
                IDownloadAidlFileProvider r102 = IDownloadAidlFileProvider.Stub.asInterface(r101.readStrongBinder());     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r102;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                IDownloadAidlFileProvider r103 = Stub.getDefaultImpl().getFileProvider();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r103;
            L13:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
            public IDownloadForbiddenAidlHandler getForbiddenHandler() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_model_DownloadAidlTask$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 9, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L13
                IDownloadForbiddenAidlHandler r102 = IDownloadForbiddenAidlHandler.Stub.asInterface(r101.readStrongBinder());     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r102;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                IDownloadForbiddenAidlHandler r103 = Stub.getDefaultImpl().getForbiddenHandler();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r103;
            L13:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
            public IDownloadAidlInterceptor getInterceptor() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_model_DownloadAidlTask$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 7, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L13
                IDownloadAidlInterceptor r102 = IDownloadAidlInterceptor.Stub.asInterface(r101.readStrongBinder());     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r102;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                IDownloadAidlInterceptor r103 = Stub.getDefaultImpl().getInterceptor();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r103;
            L13:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
            public IDownloadAidlMonitorDepend getMonitorDepend() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_model_DownloadAidlTask$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 11, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L13
                IDownloadAidlMonitorDepend r102 = IDownloadAidlMonitorDepend.Stub.asInterface(r101.readStrongBinder());     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r102;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                IDownloadAidlMonitorDepend r103 = Stub.getDefaultImpl().getMonitorDepend();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r103;
            L13:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
            public INotificationClickAidlCallback getNotificationClickCallback() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_model_DownloadAidlTask$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 6, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L13
                INotificationClickAidlCallback r102 = INotificationClickAidlCallback.Stub.asInterface(r101.readStrongBinder());     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r102;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                INotificationClickAidlCallback r103 = Stub.getDefaultImpl().getNotificationClickCallback();     // Catch: Throwable -> L13
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

            @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
            public IDownloadCompleteAidlHandler getDownloadCompleteAidlHandlerByIndex(int r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r101.writeInt(r100);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_model_DownloadAidlTask$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 14, r101, r102, 0) == false) goto L6;
            L10:
                r102.readException();     // Catch: Throwable -> L13
                IDownloadCompleteAidlHandler r103 = IDownloadCompleteAidlHandler.Stub.asInterface(r102.readStrongBinder());     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return r103;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                IDownloadCompleteAidlHandler r104 = Stub.getDefaultImpl().getDownloadCompleteAidlHandlerByIndex(r100);     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return r104;
            L13:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
            public int[] getDownloadListenerHashCodeLists(int r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r101.writeInt(r100);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_model_DownloadAidlTask$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r101, r102, 0) == false) goto L6;
            L10:
                r102.readException();     // Catch: Throwable -> L13
                int[] r103 = r102.createIntArray();     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return r103;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int[] r104 = Stub.getDefaultImpl().getDownloadListenerHashCodeLists(r100);     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return r104;
            L13:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
            public IDownloadAidlListener getSingleDownloadListener(int r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r101.writeInt(r100);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_model_DownloadAidlTask$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r101, r102, 0) == false) goto L6;
            L10:
                r102.readException();     // Catch: Throwable -> L13
                IDownloadAidlListener r103 = IDownloadAidlListener.Stub.asInterface(r102.readStrongBinder());     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return r103;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                IDownloadAidlListener r104 = Stub.getDefaultImpl().getSingleDownloadListener(r100);     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return r104;
            L13:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
            public IDownloadAidlListener getDownloadListenerByHashCode(int r100, int r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r102.writeInt(r100);     // Catch: Throwable -> L13
                r102.writeInt(r101);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_model_DownloadAidlTask$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r102, r103, 0) == false) goto L6;
            L10:
                r103.readException();     // Catch: Throwable -> L13
                IDownloadAidlListener r104 = IDownloadAidlListener.Stub.asInterface(r103.readStrongBinder());     // Catch: Throwable -> L13
                r103.recycle();
                r102.recycle();
                return r104;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                IDownloadAidlListener r105 = Stub.getDefaultImpl().getDownloadListenerByHashCode(r100, r101);     // Catch: Throwable -> L13
                r103.recycle();
                r102.recycle();
                return r105;
            L13:
                th = move-exception;
                r103.recycle();
                r102.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_ss_android_socialbase_downloader_model_DownloadAidlTask$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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

        public static DownloadAidlTask getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static DownloadAidlTask asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof DownloadAidlTask) == false) goto L12;
            return (DownloadAidlTask) r101;
        L12:
            return new Proxy(r100);
        }

        public static boolean setDefaultImpl(DownloadAidlTask r100) {
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
            if (r100 == 1598968902) goto L72;
            IBinder r104 = null;
            switch(r100) {
                case 1: goto L67;
                case 2: goto L65;
                case 3: goto L60;
                case 4: goto L55;
                case 5: goto L50;
                case 6: goto L45;
                case 7: goto L40;
                case 8: goto L35;
                case 9: goto L30;
                case 10: goto L25;
                case 11: goto L20;
                case 12: goto L15;
                case 13: goto L13;
                case 14: goto L8;
                default: goto L7;
            };
        L8:
            r101.enforceInterface(DESCRIPTOR);
            IDownloadCompleteAidlHandler r105 = getDownloadCompleteAidlHandlerByIndex(r101.readInt());
            r102.writeNoException();
            if (r105 == null) goto L11;
            r104 = r105.asBinder();
        L11:
            r102.writeStrongBinder(r104);
            return true;
        L13:
            r101.enforceInterface(DESCRIPTOR);
            int r106 = getDownloadCompleteHandlerSize();
            r102.writeNoException();
            r102.writeInt(r106);
            return true;
        L15:
            r101.enforceInterface(DESCRIPTOR);
            IDownloadAidlFileProvider r107 = getFileProvider();
            r102.writeNoException();
            if (r107 == null) goto L18;
            r104 = r107.asBinder();
        L18:
            r102.writeStrongBinder(r104);
            return true;
        L20:
            r101.enforceInterface(DESCRIPTOR);
            IDownloadAidlMonitorDepend r108 = getMonitorDepend();
            r102.writeNoException();
            if (r108 == null) goto L23;
            r104 = r108.asBinder();
        L23:
            r102.writeStrongBinder(r104);
            return true;
        L25:
            r101.enforceInterface(DESCRIPTOR);
            IDownloadDiskSpaceAidlHandler r109 = getDiskSpaceHandler();
            r102.writeNoException();
            if (r109 == null) goto L28;
            r104 = r109.asBinder();
        L28:
            r102.writeStrongBinder(r104);
            return true;
        L30:
            r101.enforceInterface(DESCRIPTOR);
            IDownloadForbiddenAidlHandler r110 = getForbiddenHandler();
            r102.writeNoException();
            if (r110 == null) goto L33;
            r104 = r110.asBinder();
        L33:
            r102.writeStrongBinder(r104);
            return true;
        L35:
            r101.enforceInterface(DESCRIPTOR);
            IDownloadAidlDepend r111 = getDepend();
            r102.writeNoException();
            if (r111 == null) goto L38;
            r104 = r111.asBinder();
        L38:
            r102.writeStrongBinder(r104);
            return true;
        L40:
            r101.enforceInterface(DESCRIPTOR);
            IDownloadAidlInterceptor r112 = getInterceptor();
            r102.writeNoException();
            if (r112 == null) goto L43;
            r104 = r112.asBinder();
        L43:
            r102.writeStrongBinder(r104);
            return true;
        L45:
            r101.enforceInterface(DESCRIPTOR);
            INotificationClickAidlCallback r113 = getNotificationClickCallback();
            r102.writeNoException();
            if (r113 == null) goto L48;
            r104 = r113.asBinder();
        L48:
            r102.writeStrongBinder(r104);
            return true;
        L50:
            r101.enforceInterface(DESCRIPTOR);
            IDownloadNotificationEventAidlListener r114 = getDownloadNotificationEventListener();
            r102.writeNoException();
            if (r114 == null) goto L53;
            r104 = r114.asBinder();
        L53:
            r102.writeStrongBinder(r104);
            return true;
        L55:
            r101.enforceInterface(DESCRIPTOR);
            IDownloadAidlListener r115 = getSingleDownloadListener(r101.readInt());
            r102.writeNoException();
            if (r115 == null) goto L58;
            r104 = r115.asBinder();
        L58:
            r102.writeStrongBinder(r104);
            return true;
        L60:
            r101.enforceInterface(DESCRIPTOR);
            IDownloadAidlListener r116 = getDownloadListenerByHashCode(r101.readInt(), r101.readInt());
            r102.writeNoException();
            if (r116 == null) goto L63;
            r104 = r116.asBinder();
        L63:
            r102.writeStrongBinder(r104);
            return true;
        L65:
            r101.enforceInterface(DESCRIPTOR);
            int[] r117 = getDownloadListenerHashCodeLists(r101.readInt());
            r102.writeNoException();
            r102.writeIntArray(r117);
            return true;
        L67:
            r101.enforceInterface(DESCRIPTOR);
            DownloadInfo r118 = getDownloadInfo();
            r102.writeNoException();
            if (r118 == null) goto L70;
            r102.writeInt(1);
            r118.writeToParcel(r102, 1);
        L71:
            return true;
        L70:
            r102.writeInt(0);
            goto L71
        L7:
            return super.onTransact(r100, r101, r102, r103);
        L72:
            r102.writeString(DESCRIPTOR);
            return true;
        }
    }

    IDownloadAidlDepend getDepend() throws RemoteException;

    IDownloadDiskSpaceAidlHandler getDiskSpaceHandler() throws RemoteException;

    IDownloadCompleteAidlHandler getDownloadCompleteAidlHandlerByIndex(int r100) throws RemoteException;

    int getDownloadCompleteHandlerSize() throws RemoteException;

    DownloadInfo getDownloadInfo() throws RemoteException;

    IDownloadAidlListener getDownloadListenerByHashCode(int r100, int r101) throws RemoteException;

    int[] getDownloadListenerHashCodeLists(int r100) throws RemoteException;

    IDownloadNotificationEventAidlListener getDownloadNotificationEventListener() throws RemoteException;

    IDownloadAidlFileProvider getFileProvider() throws RemoteException;

    IDownloadForbiddenAidlHandler getForbiddenHandler() throws RemoteException;

    IDownloadAidlInterceptor getInterceptor() throws RemoteException;

    IDownloadAidlMonitorDepend getMonitorDepend() throws RemoteException;

    INotificationClickAidlCallback getNotificationClickCallback() throws RemoteException;

    IDownloadAidlListener getSingleDownloadListener(int r100) throws RemoteException;
}
