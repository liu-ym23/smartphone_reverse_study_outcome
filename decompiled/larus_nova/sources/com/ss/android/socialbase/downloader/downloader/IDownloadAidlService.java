package com.ss.android.socialbase.downloader.downloader;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadAidlListener;
import com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener;
import com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback;
import com.ss.android.socialbase.downloader.depend.ProcessAidlCallback;
import com.ss.android.socialbase.downloader.model.DownloadAidlTask;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.List;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes5.dex */
public interface IDownloadAidlService extends IInterface {

    /* JADX INFO: loaded from: classes38.dex */
    public static class Default implements IDownloadAidlService {
        public Default() {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public void addDownloadListener(int r100, int r101, IDownloadAidlListener r102, int r103, boolean r104) throws RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public void addDownloadListener1(int r100, int r101, IDownloadAidlListener r102, int r103, boolean r104, boolean r105) throws RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public void addProcessCallback(ProcessAidlCallback r100) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public boolean canResume(int r100) throws RemoteException {
            return false;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public void cancel(int r100, boolean r101) throws RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public void clearData() throws RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public void clearDownloadData(int r100, boolean r101, boolean r102) throws RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public void dispatchProcessCallback(int r100, int r101) throws RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public List<DownloadInfo> getAllDownloadInfo() throws RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public long getCurBytes(int r100) throws RemoteException {
            return 0;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public IDownloadAidlFileProvider getDownloadFileUriProvider(int r100) throws RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public int getDownloadId(String r100, String r101) throws RemoteException {
            return 0;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public DownloadInfo getDownloadInfo(int r100) throws RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public DownloadInfo getDownloadInfoByUrlAndPath(String r100, String r101) throws RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public List<DownloadInfo> getDownloadInfoList(String r100) throws RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public List<DownloadInfo> getDownloadInfosByFileExtension(String r100) throws RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public List<DownloadInfo> getDownloadInfosByFilters(String r100, String r101) throws RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public List<DownloadInfo> getDownloadInfosByMonitorScene(List<String> r100) throws RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public IDownloadNotificationEventAidlListener getDownloadNotificationEventListener(int r100) throws RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public int getDownloadWithIndependentProcessStatus(int r100) throws RemoteException {
            return 0;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public List<DownloadInfo> getDownloadingDownloadInfosWithMimeType(String r100) throws RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public INotificationClickAidlCallback getNotificationClickCallback(int r100) throws RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public int getStatus(int r100) throws RemoteException {
            return 0;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public List<DownloadInfo> getSuccessedDownloadInfosWithMimeType(String r100) throws RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public List<DownloadInfo> getUnCompletedDownloadInfosWithMimeType(String r100) throws RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public boolean isDownloadCacheSyncSuccess() throws RemoteException {
            return false;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public boolean isDownloadSuccessAndFileNotExist(DownloadInfo r100) throws RemoteException {
            return false;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public boolean isDownloading(int r100) throws RemoteException {
            return false;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public boolean isHttpServiceInit() throws RemoteException {
            return false;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public void pause(int r100, boolean r101) throws RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public void pauseAll() throws RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public boolean removeDownloadInfo(int r100) throws RemoteException {
            return false;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public void removeDownloadListener(int r100, int r101, IDownloadAidlListener r102, int r103, boolean r104) throws RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public boolean removeDownloadTaskData(int r100) throws RemoteException {
            return false;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public void resetDownloadData(int r100, boolean r101) throws RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public void restart(int r100) throws RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public void restartAllFailedDownloadTasks(List<String> r100) throws RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public void restartAllPauseReserveOnWifiDownloadTasks(List<String> r100) throws RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public void resume(int r100) throws RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public void setDownloadNotificationEventListener(int r100, IDownloadNotificationEventAidlListener r101) throws RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public void setDownloadWithIndependentProcessStatus(int r100, boolean r101) throws RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public void setLogLevel(int r100) throws RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public void setThrottleNetSpeed(int r100, long r101, int r102) throws RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public void syncDownloadInfoFromOtherCache(int r100) throws RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public void tryDownload(DownloadAidlTask r100) throws RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
        public boolean updateDownloadInfo(DownloadInfo r100) throws RemoteException {
            return false;
        }
    }

    public static abstract class Stub extends Binder implements IDownloadAidlService {
        private static final String DESCRIPTOR = "com.ss.android.socialbase.downloader.downloader.IDownloadAidlService";
        static final int TRANSACTION_addDownloadListener = 26;
        static final int TRANSACTION_addDownloadListener1 = 27;
        static final int TRANSACTION_addProcessCallback = 40;
        static final int TRANSACTION_canResume = 4;
        static final int TRANSACTION_cancel = 3;
        static final int TRANSACTION_clearData = 38;
        static final int TRANSACTION_clearDownloadData = 23;
        static final int TRANSACTION_dispatchProcessCallback = 41;
        static final int TRANSACTION_getAllDownloadInfo = 18;
        static final int TRANSACTION_getCurBytes = 8;
        static final int TRANSACTION_getDownloadFileUriProvider = 45;
        static final int TRANSACTION_getDownloadId = 13;
        static final int TRANSACTION_getDownloadInfo = 11;
        static final int TRANSACTION_getDownloadInfoByUrlAndPath = 14;
        static final int TRANSACTION_getDownloadInfoList = 12;
        static final int TRANSACTION_getDownloadInfosByFileExtension = 17;
        static final int TRANSACTION_getDownloadInfosByFilters = 19;
        static final int TRANSACTION_getDownloadInfosByMonitorScene = 20;
        static final int TRANSACTION_getDownloadNotificationEventListener = 42;
        static final int TRANSACTION_getDownloadWithIndependentProcessStatus = 34;
        static final int TRANSACTION_getDownloadingDownloadInfosWithMimeType = 16;
        static final int TRANSACTION_getNotificationClickCallback = 43;
        static final int TRANSACTION_getStatus = 9;
        static final int TRANSACTION_getSuccessedDownloadInfosWithMimeType = 15;
        static final int TRANSACTION_getUnCompletedDownloadInfosWithMimeType = 30;
        static final int TRANSACTION_isDownloadCacheSyncSuccess = 32;
        static final int TRANSACTION_isDownloadSuccessAndFileNotExist = 28;
        static final int TRANSACTION_isDownloading = 10;
        static final int TRANSACTION_isHttpServiceInit = 29;
        static final int TRANSACTION_pause = 2;
        static final int TRANSACTION_pauseAll = 7;
        static final int TRANSACTION_removeDownloadInfo = 36;
        static final int TRANSACTION_removeDownloadListener = 25;
        static final int TRANSACTION_removeDownloadTaskData = 37;
        static final int TRANSACTION_resetDownloadData = 24;
        static final int TRANSACTION_restart = 6;
        static final int TRANSACTION_restartAllFailedDownloadTasks = 21;
        static final int TRANSACTION_restartAllPauseReserveOnWifiDownloadTasks = 22;
        static final int TRANSACTION_resume = 5;
        static final int TRANSACTION_setDownloadNotificationEventListener = 44;
        static final int TRANSACTION_setDownloadWithIndependentProcessStatus = 33;
        static final int TRANSACTION_setLogLevel = 31;
        static final int TRANSACTION_setThrottleNetSpeed = 46;
        static final int TRANSACTION_syncDownloadInfoFromOtherCache = 39;
        static final int TRANSACTION_tryDownload = 1;
        static final int TRANSACTION_updateDownloadInfo = 35;

        public static class Proxy implements IDownloadAidlService {
            public static IDownloadAidlService sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void clearData() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_downloader_IDownloadAidlService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 38, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().clearData();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return;
            L13:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public List<DownloadInfo> getAllDownloadInfo() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_downloader_IDownloadAidlService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 18, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L13
                ArrayList r102 = r101.createTypedArrayList(DownloadInfo.CREATOR);     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r102;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                List<DownloadInfo> r103 = Stub.getDefaultImpl().getAllDownloadInfo();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return r103;
            L13:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public boolean isDownloadCacheSyncSuccess() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                boolean r102 = false;
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_downloader_IDownloadAidlService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 32, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L15
                if (r101.readInt() == 0) goto L13;
                r102 = true;
            L13:
                r101.recycle();
                r100.recycle();
                return r102;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                boolean r103 = Stub.getDefaultImpl().isDownloadCacheSyncSuccess();     // Catch: Throwable -> L15
                r101.recycle();
                r100.recycle();
                return r103;
            L15:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public boolean isHttpServiceInit() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                boolean r102 = false;
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_downloader_IDownloadAidlService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 29, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L15
                if (r101.readInt() == 0) goto L13;
                r102 = true;
            L13:
                r101.recycle();
                r100.recycle();
                return r102;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                boolean r103 = Stub.getDefaultImpl().isHttpServiceInit();     // Catch: Throwable -> L15
                r101.recycle();
                r100.recycle();
                return r103;
            L15:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void pauseAll() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_downloader_IDownloadAidlService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 7, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().pauseAll();     // Catch: Throwable -> L13
                r101.recycle();
                r100.recycle();
                return;
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

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void addProcessCallback(ProcessAidlCallback r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r100 == null) goto L6;
                IBinder r103 = r100.asBinder();     // Catch: Throwable -> L17
            L7:
                r101.writeStrongBinder(r103);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_downloader_IDownloadAidlService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 40, r101, r102, 0) == false) goto L10;
            L14:
                r102.readException();     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().addProcessCallback(r100);     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return;
            L6:
                r103 = null;
            L17:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public boolean canResume(int r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                r101.writeInt(r100);     // Catch: Throwable -> L15
                boolean r103 = false;
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_downloader_IDownloadAidlService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r101, r102, 0) == false) goto L6;
            L10:
                r102.readException();     // Catch: Throwable -> L15
                if (r102.readInt() == 0) goto L13;
                r103 = true;
            L13:
                r102.recycle();
                r101.recycle();
                return r103;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                boolean r104 = Stub.getDefaultImpl().canResume(r100);     // Catch: Throwable -> L15
                r102.recycle();
                r101.recycle();
                return r104;
            L15:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public long getCurBytes(int r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r101.writeInt(r100);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_downloader_IDownloadAidlService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 8, r101, r102, 0) == false) goto L6;
            L10:
                r102.readException();     // Catch: Throwable -> L13
                long r103 = r102.readLong();     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return r103;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                long r104 = Stub.getDefaultImpl().getCurBytes(r100);     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return r104;
            L13:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public IDownloadAidlFileProvider getDownloadFileUriProvider(int r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r101.writeInt(r100);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_downloader_IDownloadAidlService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 45, r101, r102, 0) == false) goto L6;
            L10:
                r102.readException();     // Catch: Throwable -> L13
                IDownloadAidlFileProvider r103 = IDownloadAidlFileProvider.Stub.asInterface(r102.readStrongBinder());     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return r103;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                IDownloadAidlFileProvider r104 = Stub.getDefaultImpl().getDownloadFileUriProvider(r100);     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return r104;
            L13:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public DownloadInfo getDownloadInfo(int r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r101.writeInt(r100);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_downloader_IDownloadAidlService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 11, r101, r102, 0) == false) goto L6;
            L10:
                r102.readException();     // Catch: Throwable -> L17
                if (r102.readInt() == 0) goto L14;
                DownloadInfo r103 = DownloadInfo.CREATOR.createFromParcel(r102);     // Catch: Throwable -> L17
            L15:
                r102.recycle();
                r101.recycle();
                return r103;
            L14:
                r103 = null;
                goto L15
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                DownloadInfo r104 = Stub.getDefaultImpl().getDownloadInfo(r100);     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return r104;
            L17:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public List<DownloadInfo> getDownloadInfoList(String r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r101.writeString(r100);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_downloader_IDownloadAidlService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 12, r101, r102, 0) == false) goto L6;
            L10:
                r102.readException();     // Catch: Throwable -> L13
                ArrayList r103 = r102.createTypedArrayList(DownloadInfo.CREATOR);     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return r103;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                List<DownloadInfo> r104 = Stub.getDefaultImpl().getDownloadInfoList(r100);     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return r104;
            L13:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public List<DownloadInfo> getDownloadInfosByFileExtension(String r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r101.writeString(r100);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_downloader_IDownloadAidlService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 17, r101, r102, 0) == false) goto L6;
            L10:
                r102.readException();     // Catch: Throwable -> L13
                ArrayList r103 = r102.createTypedArrayList(DownloadInfo.CREATOR);     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return r103;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                List<DownloadInfo> r104 = Stub.getDefaultImpl().getDownloadInfosByFileExtension(r100);     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return r104;
            L13:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public List<DownloadInfo> getDownloadInfosByMonitorScene(List<String> r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r101.writeStringList(r100);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_downloader_IDownloadAidlService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 20, r101, r102, 0) == false) goto L6;
            L10:
                r102.readException();     // Catch: Throwable -> L13
                ArrayList r103 = r102.createTypedArrayList(DownloadInfo.CREATOR);     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return r103;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                List<DownloadInfo> r104 = Stub.getDefaultImpl().getDownloadInfosByMonitorScene(r100);     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return r104;
            L13:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public IDownloadNotificationEventAidlListener getDownloadNotificationEventListener(int r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r101.writeInt(r100);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_downloader_IDownloadAidlService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 42, r101, r102, 0) == false) goto L6;
            L10:
                r102.readException();     // Catch: Throwable -> L13
                IDownloadNotificationEventAidlListener r103 = IDownloadNotificationEventAidlListener.Stub.asInterface(r102.readStrongBinder());     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return r103;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                IDownloadNotificationEventAidlListener r104 = Stub.getDefaultImpl().getDownloadNotificationEventListener(r100);     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return r104;
            L13:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public int getDownloadWithIndependentProcessStatus(int r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r101.writeInt(r100);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_downloader_IDownloadAidlService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 34, r101, r102, 0) == false) goto L6;
            L10:
                r102.readException();     // Catch: Throwable -> L13
                int r103 = r102.readInt();     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return r103;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r104 = Stub.getDefaultImpl().getDownloadWithIndependentProcessStatus(r100);     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return r104;
            L13:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public List<DownloadInfo> getDownloadingDownloadInfosWithMimeType(String r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r101.writeString(r100);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_downloader_IDownloadAidlService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 16, r101, r102, 0) == false) goto L6;
            L10:
                r102.readException();     // Catch: Throwable -> L13
                ArrayList r103 = r102.createTypedArrayList(DownloadInfo.CREATOR);     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return r103;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                List<DownloadInfo> r104 = Stub.getDefaultImpl().getDownloadingDownloadInfosWithMimeType(r100);     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return r104;
            L13:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public INotificationClickAidlCallback getNotificationClickCallback(int r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r101.writeInt(r100);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_downloader_IDownloadAidlService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 43, r101, r102, 0) == false) goto L6;
            L10:
                r102.readException();     // Catch: Throwable -> L13
                INotificationClickAidlCallback r103 = INotificationClickAidlCallback.Stub.asInterface(r102.readStrongBinder());     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return r103;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                INotificationClickAidlCallback r104 = Stub.getDefaultImpl().getNotificationClickCallback(r100);     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return r104;
            L13:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public int getStatus(int r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r101.writeInt(r100);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_downloader_IDownloadAidlService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 9, r101, r102, 0) == false) goto L6;
            L10:
                r102.readException();     // Catch: Throwable -> L13
                int r103 = r102.readInt();     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return r103;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r104 = Stub.getDefaultImpl().getStatus(r100);     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return r104;
            L13:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public List<DownloadInfo> getSuccessedDownloadInfosWithMimeType(String r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r101.writeString(r100);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_downloader_IDownloadAidlService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 15, r101, r102, 0) == false) goto L6;
            L10:
                r102.readException();     // Catch: Throwable -> L13
                ArrayList r103 = r102.createTypedArrayList(DownloadInfo.CREATOR);     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return r103;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                List<DownloadInfo> r104 = Stub.getDefaultImpl().getSuccessedDownloadInfosWithMimeType(r100);     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return r104;
            L13:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public List<DownloadInfo> getUnCompletedDownloadInfosWithMimeType(String r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r101.writeString(r100);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_downloader_IDownloadAidlService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 30, r101, r102, 0) == false) goto L6;
            L10:
                r102.readException();     // Catch: Throwable -> L13
                ArrayList r103 = r102.createTypedArrayList(DownloadInfo.CREATOR);     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return r103;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                List<DownloadInfo> r104 = Stub.getDefaultImpl().getUnCompletedDownloadInfosWithMimeType(r100);     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return r104;
            L13:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public boolean isDownloadSuccessAndFileNotExist(DownloadInfo r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L20
                boolean r103 = true;
                if (r100 == null) goto L6;
                r101.writeInt(1);     // Catch: Throwable -> L20
                r100.writeToParcel(r101, 0);     // Catch: Throwable -> L20
            L8:
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_downloader_IDownloadAidlService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 28, r101, r102, 0) == false) goto L10;
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
                boolean r104 = Stub.getDefaultImpl().isDownloadSuccessAndFileNotExist(r100);     // Catch: Throwable -> L20
                r102.recycle();
                r101.recycle();
                return r104;
            L6:
                r101.writeInt(0);     // Catch: Throwable -> L20
            L20:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public boolean isDownloading(int r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                r101.writeInt(r100);     // Catch: Throwable -> L15
                boolean r103 = false;
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_downloader_IDownloadAidlService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 10, r101, r102, 0) == false) goto L6;
            L10:
                r102.readException();     // Catch: Throwable -> L15
                if (r102.readInt() == 0) goto L13;
                r103 = true;
            L13:
                r102.recycle();
                r101.recycle();
                return r103;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                boolean r104 = Stub.getDefaultImpl().isDownloading(r100);     // Catch: Throwable -> L15
                r102.recycle();
                r101.recycle();
                return r104;
            L15:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public boolean removeDownloadInfo(int r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                r101.writeInt(r100);     // Catch: Throwable -> L15
                boolean r103 = false;
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_downloader_IDownloadAidlService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 36, r101, r102, 0) == false) goto L6;
            L10:
                r102.readException();     // Catch: Throwable -> L15
                if (r102.readInt() == 0) goto L13;
                r103 = true;
            L13:
                r102.recycle();
                r101.recycle();
                return r103;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                boolean r104 = Stub.getDefaultImpl().removeDownloadInfo(r100);     // Catch: Throwable -> L15
                r102.recycle();
                r101.recycle();
                return r104;
            L15:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public boolean removeDownloadTaskData(int r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                r101.writeInt(r100);     // Catch: Throwable -> L15
                boolean r103 = false;
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_downloader_IDownloadAidlService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 37, r101, r102, 0) == false) goto L6;
            L10:
                r102.readException();     // Catch: Throwable -> L15
                if (r102.readInt() == 0) goto L13;
                r103 = true;
            L13:
                r102.recycle();
                r101.recycle();
                return r103;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                boolean r104 = Stub.getDefaultImpl().removeDownloadTaskData(r100);     // Catch: Throwable -> L15
                r102.recycle();
                r101.recycle();
                return r104;
            L15:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void restart(int r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r101.writeInt(r100);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_downloader_IDownloadAidlService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 6, r101, r102, 0) == false) goto L6;
            L10:
                r102.readException();     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().restart(r100);     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return;
            L13:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void restartAllFailedDownloadTasks(List<String> r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r101.writeStringList(r100);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_downloader_IDownloadAidlService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 21, r101, r102, 0) == false) goto L6;
            L10:
                r102.readException();     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().restartAllFailedDownloadTasks(r100);     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return;
            L13:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void restartAllPauseReserveOnWifiDownloadTasks(List<String> r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r101.writeStringList(r100);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_downloader_IDownloadAidlService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 22, r101, r102, 0) == false) goto L6;
            L10:
                r102.readException();     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().restartAllPauseReserveOnWifiDownloadTasks(r100);     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return;
            L13:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void resume(int r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r101.writeInt(r100);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_downloader_IDownloadAidlService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 5, r101, r102, 0) == false) goto L6;
            L10:
                r102.readException();     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().resume(r100);     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return;
            L13:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void setLogLevel(int r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r101.writeInt(r100);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_downloader_IDownloadAidlService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 31, r101, r102, 0) == false) goto L6;
            L10:
                r102.readException();     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().setLogLevel(r100);     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return;
            L13:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void syncDownloadInfoFromOtherCache(int r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r101.writeInt(r100);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_downloader_IDownloadAidlService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 39, r101, r102, 0) == false) goto L6;
            L10:
                r102.readException();     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().syncDownloadInfoFromOtherCache(r100);     // Catch: Throwable -> L13
                r102.recycle();
                r101.recycle();
                return;
            L13:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void tryDownload(DownloadAidlTask r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r100 == null) goto L6;
                IBinder r103 = r100.asBinder();     // Catch: Throwable -> L17
            L7:
                r101.writeStrongBinder(r103);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_downloader_IDownloadAidlService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r101, r102, 0) == false) goto L10;
            L14:
                r102.readException();     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().tryDownload(r100);     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return;
            L6:
                r103 = null;
            L17:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public boolean updateDownloadInfo(DownloadInfo r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L20
                boolean r103 = true;
                if (r100 == null) goto L6;
                r101.writeInt(1);     // Catch: Throwable -> L20
                r100.writeToParcel(r101, 0);     // Catch: Throwable -> L20
            L8:
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_downloader_IDownloadAidlService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 35, r101, r102, 0) == false) goto L10;
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
                boolean r104 = Stub.getDefaultImpl().updateDownloadInfo(r100);     // Catch: Throwable -> L20
                r102.recycle();
                r101.recycle();
                return r104;
            L6:
                r101.writeInt(0);     // Catch: Throwable -> L20
            L20:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void cancel(int r100, boolean r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r102.writeInt(r100);     // Catch: Throwable -> L17
                if (r101 == false) goto L6;
                int r104 = 1;
            L7:
                r102.writeInt(r104);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_downloader_IDownloadAidlService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r102, r103, 0) == false) goto L10;
            L14:
                r103.readException();     // Catch: Throwable -> L17
                r103.recycle();
                r102.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().cancel(r100, r101);     // Catch: Throwable -> L17
                r103.recycle();
                r102.recycle();
                return;
            L6:
                r104 = 0;
            L17:
                th = move-exception;
                r103.recycle();
                r102.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void dispatchProcessCallback(int r100, int r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r102.writeInt(r100);     // Catch: Throwable -> L13
                r102.writeInt(r101);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_downloader_IDownloadAidlService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 41, r102, r103, 0) == false) goto L6;
            L10:
                r103.readException();     // Catch: Throwable -> L13
                r103.recycle();
                r102.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().dispatchProcessCallback(r100, r101);     // Catch: Throwable -> L13
                r103.recycle();
                r102.recycle();
                return;
            L13:
                th = move-exception;
                r103.recycle();
                r102.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public int getDownloadId(String r100, String r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r102.writeString(r100);     // Catch: Throwable -> L13
                r102.writeString(r101);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_downloader_IDownloadAidlService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 13, r102, r103, 0) == false) goto L6;
            L10:
                r103.readException();     // Catch: Throwable -> L13
                int r104 = r103.readInt();     // Catch: Throwable -> L13
                r103.recycle();
                r102.recycle();
                return r104;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                int r105 = Stub.getDefaultImpl().getDownloadId(r100, r101);     // Catch: Throwable -> L13
                r103.recycle();
                r102.recycle();
                return r105;
            L13:
                th = move-exception;
                r103.recycle();
                r102.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public DownloadInfo getDownloadInfoByUrlAndPath(String r100, String r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r102.writeString(r100);     // Catch: Throwable -> L17
                r102.writeString(r101);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_downloader_IDownloadAidlService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 14, r102, r103, 0) == false) goto L6;
            L10:
                r103.readException();     // Catch: Throwable -> L17
                if (r103.readInt() == 0) goto L14;
                DownloadInfo r104 = DownloadInfo.CREATOR.createFromParcel(r103);     // Catch: Throwable -> L17
            L15:
                r103.recycle();
                r102.recycle();
                return r104;
            L14:
                r104 = null;
                goto L15
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                DownloadInfo r105 = Stub.getDefaultImpl().getDownloadInfoByUrlAndPath(r100, r101);     // Catch: Throwable -> L17
                r103.recycle();
                r102.recycle();
                return r105;
            L17:
                th = move-exception;
                r103.recycle();
                r102.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public List<DownloadInfo> getDownloadInfosByFilters(String r100, String r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r102.writeString(r100);     // Catch: Throwable -> L13
                r102.writeString(r101);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_downloader_IDownloadAidlService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 19, r102, r103, 0) == false) goto L6;
            L10:
                r103.readException();     // Catch: Throwable -> L13
                ArrayList r104 = r103.createTypedArrayList(DownloadInfo.CREATOR);     // Catch: Throwable -> L13
                r103.recycle();
                r102.recycle();
                return r104;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                List<DownloadInfo> r105 = Stub.getDefaultImpl().getDownloadInfosByFilters(r100, r101);     // Catch: Throwable -> L13
                r103.recycle();
                r102.recycle();
                return r105;
            L13:
                th = move-exception;
                r103.recycle();
                r102.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void pause(int r100, boolean r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r102.writeInt(r100);     // Catch: Throwable -> L17
                if (r101 == false) goto L6;
                int r104 = 1;
            L7:
                r102.writeInt(r104);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_downloader_IDownloadAidlService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r102, r103, 0) == false) goto L10;
            L14:
                r103.readException();     // Catch: Throwable -> L17
                r103.recycle();
                r102.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().pause(r100, r101);     // Catch: Throwable -> L17
                r103.recycle();
                r102.recycle();
                return;
            L6:
                r104 = 0;
            L17:
                th = move-exception;
                r103.recycle();
                r102.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void resetDownloadData(int r100, boolean r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r102.writeInt(r100);     // Catch: Throwable -> L17
                if (r101 == false) goto L6;
                int r104 = 1;
            L7:
                r102.writeInt(r104);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_downloader_IDownloadAidlService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 24, r102, r103, 0) == false) goto L10;
            L14:
                r103.readException();     // Catch: Throwable -> L17
                r103.recycle();
                r102.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().resetDownloadData(r100, r101);     // Catch: Throwable -> L17
                r103.recycle();
                r102.recycle();
                return;
            L6:
                r104 = 0;
            L17:
                th = move-exception;
                r103.recycle();
                r102.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void setDownloadNotificationEventListener(int r100, IDownloadNotificationEventAidlListener r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r102.writeInt(r100);     // Catch: Throwable -> L17
                if (r101 == null) goto L6;
                IBinder r104 = r101.asBinder();     // Catch: Throwable -> L17
            L7:
                r102.writeStrongBinder(r104);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_downloader_IDownloadAidlService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 44, r102, r103, 0) == false) goto L10;
            L14:
                r103.readException();     // Catch: Throwable -> L17
                r103.recycle();
                r102.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().setDownloadNotificationEventListener(r100, r101);     // Catch: Throwable -> L17
                r103.recycle();
                r102.recycle();
                return;
            L6:
                r104 = null;
            L17:
                th = move-exception;
                r103.recycle();
                r102.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void setDownloadWithIndependentProcessStatus(int r100, boolean r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r102.writeInt(r100);     // Catch: Throwable -> L17
                if (r101 == false) goto L6;
                int r104 = 1;
            L7:
                r102.writeInt(r104);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_downloader_IDownloadAidlService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 33, r102, r103, 0) == false) goto L10;
            L14:
                r103.readException();     // Catch: Throwable -> L17
                r103.recycle();
                r102.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().setDownloadWithIndependentProcessStatus(r100, r101);     // Catch: Throwable -> L17
                r103.recycle();
                r102.recycle();
                return;
            L6:
                r104 = 0;
            L17:
                th = move-exception;
                r103.recycle();
                r102.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void clearDownloadData(int r100, boolean r101, boolean r102) throws RemoteException {
                Parcel r103 = Parcel.obtain();
                Parcel r104 = Parcel.obtain();
                r103.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L21
                r103.writeInt(r100);     // Catch: Throwable -> L21
                int r105 = 1;
                if (r101 == false) goto L6;
                int r106 = 1;
            L7:
                r103.writeInt(r106);     // Catch: Throwable -> L21
                if (r102 == true) goto L11;
                r105 = 0;
            L11:
                r103.writeInt(r105);     // Catch: Throwable -> L21
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_downloader_IDownloadAidlService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 23, r103, r104, 0) == false) goto L14;
            L18:
                r104.readException();     // Catch: Throwable -> L21
                r104.recycle();
                r103.recycle();
                return;
            L14:
                if (Stub.getDefaultImpl() == null) goto L18;
                Stub.getDefaultImpl().clearDownloadData(r100, r101, r102);     // Catch: Throwable -> L21
                r104.recycle();
                r103.recycle();
                return;
            L6:
                r106 = 0;
            L21:
                th = move-exception;
                r104.recycle();
                r103.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void setThrottleNetSpeed(int r100, long r101, int r102) throws RemoteException {
                Parcel r103 = Parcel.obtain();
                Parcel r104 = Parcel.obtain();
                r103.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r103.writeInt(r100);     // Catch: Throwable -> L13
                r103.writeLong(r101);     // Catch: Throwable -> L13
                r103.writeInt(r102);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_downloader_IDownloadAidlService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 46, r103, r104, 0) == false) goto L6;
            L10:
                r104.readException();     // Catch: Throwable -> L13
                r104.recycle();
                r103.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().setThrottleNetSpeed(r100, r101, r102);     // Catch: Throwable -> L13
                r104.recycle();
                r103.recycle();
                return;
            L13:
                th = move-exception;
                r104.recycle();
                r103.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_ss_android_socialbase_downloader_downloader_IDownloadAidlService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void addDownloadListener(int r110, int r111, IDownloadAidlListener r112, int r113, boolean r114) throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L21
                r100.writeInt(r110);     // Catch: Throwable -> L21
                r100.writeInt(r111);     // Catch: Throwable -> L21
                if (r112 == null) goto L6;
                IBinder r102 = r112.asBinder();     // Catch: Throwable -> L21
            L7:
                r100.writeStrongBinder(r102);     // Catch: Throwable -> L21
                r100.writeInt(r113);     // Catch: Throwable -> L21
                if (r114 == false) goto L10;
                int r103 = 1;
            L11:
                r100.writeInt(r103);     // Catch: Throwable -> L21
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_downloader_IDownloadAidlService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 26, r100, r101, 0) == false) goto L14;
            L18:
                r101.readException();     // Catch: Throwable -> L21
                r101.recycle();
                r100.recycle();
                return;
            L14:
                if (Stub.getDefaultImpl() == null) goto L18;
                Stub.getDefaultImpl().addDownloadListener(r110, r111, r112, r113, r114);     // Catch: Throwable -> L21
                r101.recycle();
                r100.recycle();
                return;
            L10:
                r103 = 0;
                goto L11
            L6:
                r102 = null;
            L21:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void removeDownloadListener(int r110, int r111, IDownloadAidlListener r112, int r113, boolean r114) throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L21
                r100.writeInt(r110);     // Catch: Throwable -> L21
                r100.writeInt(r111);     // Catch: Throwable -> L21
                if (r112 == null) goto L6;
                IBinder r102 = r112.asBinder();     // Catch: Throwable -> L21
            L7:
                r100.writeStrongBinder(r102);     // Catch: Throwable -> L21
                r100.writeInt(r113);     // Catch: Throwable -> L21
                if (r114 == false) goto L10;
                int r103 = 1;
            L11:
                r100.writeInt(r103);     // Catch: Throwable -> L21
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_downloader_IDownloadAidlService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 25, r100, r101, 0) == false) goto L14;
            L18:
                r101.readException();     // Catch: Throwable -> L21
                r101.recycle();
                r100.recycle();
                return;
            L14:
                if (Stub.getDefaultImpl() == null) goto L18;
                Stub.getDefaultImpl().removeDownloadListener(r110, r111, r112, r113, r114);     // Catch: Throwable -> L21
                r101.recycle();
                r100.recycle();
                return;
            L10:
                r103 = 0;
                goto L11
            L6:
                r102 = null;
            L21:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public void addDownloadListener1(int r110, int r111, IDownloadAidlListener r112, int r113, boolean r114, boolean r115) throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L29
                r100.writeInt(r110);     // Catch: Throwable -> L29
                r100.writeInt(r111);     // Catch: Throwable -> L29
                if (r112 == null) goto L6;
                IBinder r102 = r112.asBinder();     // Catch: Throwable -> L29
            L7:
                r100.writeStrongBinder(r102);     // Catch: Throwable -> L29
                r100.writeInt(r113);     // Catch: Throwable -> L29
                int r103 = 1;
                if (r114 == false) goto L10;
                int r104 = 1;
            L11:
                r100.writeInt(r104);     // Catch: Throwable -> L29
                if (r115 == true) goto L15;
                r103 = 0;
            L15:
                r100.writeInt(r103);     // Catch: Throwable -> L29
            L27:
                th = th;
            L31:
                r101.recycle();
                r100.recycle();
                throw th;
            L18:
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_downloader_IDownloadAidlService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 27, r100, r101, 0) == false) goto L20;
            L24:
                r101.readException();     // Catch: Throwable -> L27
                r101.recycle();
                r100.recycle();
                return;
            L20:
                if (Stub.getDefaultImpl() == null) goto L24;
                Stub.getDefaultImpl().addDownloadListener1(r110, r111, r112, r113, r114, r115);     // Catch: Throwable -> L27
                r101.recycle();
                r100.recycle();
                return;
            L10:
                r104 = 0;
                goto L11
            L6:
                r102 = null;
            L29:
                th = th;
                goto L31
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IDownloadAidlService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static IDownloadAidlService asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof IDownloadAidlService) == false) goto L12;
            return (IDownloadAidlService) r101;
        L12:
            return new Proxy(r100);
        }

        public static boolean setDefaultImpl(IDownloadAidlService r100) {
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
        public boolean onTransact(int r110, Parcel r111, Parcel r112, int r113) throws RemoteException {
            if (r110 == 1598968902) goto L156;
            DownloadInfo r100 = null;
            IBinder r101 = null;
            IBinder r102 = null;
            IBinder r103 = null;
            DownloadInfo r104 = null;
            boolean r105 = false;
            switch(r110) {
                case 1: goto L154;
                case 2: goto L149;
                case 3: goto L144;
                case 4: goto L142;
                case 5: goto L140;
                case 6: goto L138;
                case 7: goto L136;
                case 8: goto L134;
                case 9: goto L132;
                case 10: goto L130;
                case 11: goto L125;
                case 12: goto L123;
                case 13: goto L121;
                case 14: goto L116;
                case 15: goto L114;
                case 16: goto L112;
                case 17: goto L110;
                case 18: goto L108;
                case 19: goto L106;
                case 20: goto L104;
                case 21: goto L102;
                case 22: goto L100;
                case 23: goto L91;
                case 24: goto L86;
                case 25: goto L80;
                case 26: goto L74;
                case 27: goto L64;
                case 28: goto L59;
                case 29: goto L57;
                case 30: goto L55;
                case 31: goto L53;
                case 32: goto L51;
                case 33: goto L46;
                case 34: goto L44;
                case 35: goto L39;
                case 36: goto L37;
                case 37: goto L35;
                case 38: goto L33;
                case 39: goto L31;
                case 40: goto L29;
                case 41: goto L27;
                case 42: goto L22;
                case 43: goto L17;
                case 44: goto L15;
                case 45: goto L10;
                case 46: goto L8;
                default: goto L7;
            };
        L8:
            r111.enforceInterface(DESCRIPTOR);
            setThrottleNetSpeed(r111.readInt(), r111.readLong(), r111.readInt());
            r112.writeNoException();
            return true;
        L10:
            r111.enforceInterface(DESCRIPTOR);
            IDownloadAidlFileProvider r106 = getDownloadFileUriProvider(r111.readInt());
            r112.writeNoException();
            if (r106 == null) goto L13;
            r101 = r106.asBinder();
        L13:
            r112.writeStrongBinder(r101);
            return true;
        L15:
            r111.enforceInterface(DESCRIPTOR);
            setDownloadNotificationEventListener(r111.readInt(), IDownloadNotificationEventAidlListener.Stub.asInterface(r111.readStrongBinder()));
            r112.writeNoException();
            return true;
        L17:
            r111.enforceInterface(DESCRIPTOR);
            INotificationClickAidlCallback r107 = getNotificationClickCallback(r111.readInt());
            r112.writeNoException();
            if (r107 == null) goto L20;
            r102 = r107.asBinder();
        L20:
            r112.writeStrongBinder(r102);
            return true;
        L22:
            r111.enforceInterface(DESCRIPTOR);
            IDownloadNotificationEventAidlListener r108 = getDownloadNotificationEventListener(r111.readInt());
            r112.writeNoException();
            if (r108 == null) goto L25;
            r103 = r108.asBinder();
        L25:
            r112.writeStrongBinder(r103);
            return true;
        L27:
            r111.enforceInterface(DESCRIPTOR);
            dispatchProcessCallback(r111.readInt(), r111.readInt());
            r112.writeNoException();
            return true;
        L29:
            r111.enforceInterface(DESCRIPTOR);
            addProcessCallback(ProcessAidlCallback.Stub.asInterface(r111.readStrongBinder()));
            r112.writeNoException();
            return true;
        L31:
            r111.enforceInterface(DESCRIPTOR);
            syncDownloadInfoFromOtherCache(r111.readInt());
            r112.writeNoException();
            return true;
        L33:
            r111.enforceInterface(DESCRIPTOR);
            clearData();
            r112.writeNoException();
            return true;
        L35:
            r111.enforceInterface(DESCRIPTOR);
            boolean r109 = removeDownloadTaskData(r111.readInt());
            r112.writeNoException();
            r112.writeInt(r109 ? 1 : 0);
            return true;
        L37:
            r111.enforceInterface(DESCRIPTOR);
            boolean r114 = removeDownloadInfo(r111.readInt());
            r112.writeNoException();
            r112.writeInt(r114 ? 1 : 0);
            return true;
        L39:
            r111.enforceInterface(DESCRIPTOR);
            if (r111.readInt() == 0) goto L42;
            r104 = DownloadInfo.CREATOR.createFromParcel(r111);
        L42:
            boolean r115 = updateDownloadInfo(r104);
            r112.writeNoException();
            r112.writeInt(r115 ? 1 : 0);
            return true;
        L44:
            r111.enforceInterface(DESCRIPTOR);
            int r116 = getDownloadWithIndependentProcessStatus(r111.readInt());
            r112.writeNoException();
            r112.writeInt(r116);
            return true;
        L46:
            r111.enforceInterface(DESCRIPTOR);
            int r117 = r111.readInt();
            if (r111.readInt() == 0) goto L49;
            r105 = true;
        L49:
            setDownloadWithIndependentProcessStatus(r117, r105);
            r112.writeNoException();
            return true;
        L51:
            r111.enforceInterface(DESCRIPTOR);
            boolean r118 = isDownloadCacheSyncSuccess();
            r112.writeNoException();
            r112.writeInt(r118 ? 1 : 0);
            return true;
        L53:
            r111.enforceInterface(DESCRIPTOR);
            setLogLevel(r111.readInt());
            r112.writeNoException();
            return true;
        L55:
            r111.enforceInterface(DESCRIPTOR);
            List<DownloadInfo> r119 = getUnCompletedDownloadInfosWithMimeType(r111.readString());
            r112.writeNoException();
            r112.writeTypedList(r119);
            return true;
        L57:
            r111.enforceInterface(DESCRIPTOR);
            boolean r120 = isHttpServiceInit();
            r112.writeNoException();
            r112.writeInt(r120 ? 1 : 0);
            return true;
        L59:
            r111.enforceInterface(DESCRIPTOR);
            if (r111.readInt() == 0) goto L62;
            r100 = DownloadInfo.CREATOR.createFromParcel(r111);
        L62:
            boolean r121 = isDownloadSuccessAndFileNotExist(r100);
            r112.writeNoException();
            r112.writeInt(r121 ? 1 : 0);
            return true;
        L64:
            r111.enforceInterface(DESCRIPTOR);
            int r122 = r111.readInt();
            int r123 = r111.readInt();
            IDownloadAidlListener r124 = IDownloadAidlListener.Stub.asInterface(r111.readStrongBinder());
            int r125 = r111.readInt();
            if (r111.readInt() == 0) goto L67;
            boolean r126 = true;
        L69:
            if (r111.readInt() == 0) goto L71;
            boolean r127 = true;
        L72:
            addDownloadListener1(r122, r123, r124, r125, r126, r127);
            r112.writeNoException();
            return true;
        L71:
            r127 = false;
            goto L72
        L67:
            r126 = false;
            goto L69
        L74:
            r111.enforceInterface(DESCRIPTOR);
            int r128 = r111.readInt();
            int r129 = r111.readInt();
            IDownloadAidlListener r130 = IDownloadAidlListener.Stub.asInterface(r111.readStrongBinder());
            int r131 = r111.readInt();
            if (r111.readInt() == 0) goto L77;
            boolean r132 = true;
        L78:
            addDownloadListener(r128, r129, r130, r131, r132);
            r112.writeNoException();
            return true;
        L77:
            r132 = false;
            goto L78
        L80:
            r111.enforceInterface(DESCRIPTOR);
            int r133 = r111.readInt();
            int r134 = r111.readInt();
            IDownloadAidlListener r135 = IDownloadAidlListener.Stub.asInterface(r111.readStrongBinder());
            int r136 = r111.readInt();
            if (r111.readInt() == 0) goto L83;
            boolean r137 = true;
        L84:
            removeDownloadListener(r133, r134, r135, r136, r137);
            r112.writeNoException();
            return true;
        L83:
            r137 = false;
            goto L84
        L86:
            r111.enforceInterface(DESCRIPTOR);
            int r138 = r111.readInt();
            if (r111.readInt() == 0) goto L89;
            r105 = true;
        L89:
            resetDownloadData(r138, r105);
            r112.writeNoException();
            return true;
        L91:
            r111.enforceInterface(DESCRIPTOR);
            int r139 = r111.readInt();
            if (r111.readInt() == 0) goto L94;
            boolean r140 = true;
        L96:
            if (r111.readInt() == 0) goto L98;
            r105 = true;
        L98:
            clearDownloadData(r139, r140, r105);
            r112.writeNoException();
            return true;
        L94:
            r140 = false;
            goto L96
        L100:
            r111.enforceInterface(DESCRIPTOR);
            restartAllPauseReserveOnWifiDownloadTasks(r111.createStringArrayList());
            r112.writeNoException();
            return true;
        L102:
            r111.enforceInterface(DESCRIPTOR);
            restartAllFailedDownloadTasks(r111.createStringArrayList());
            r112.writeNoException();
            return true;
        L104:
            r111.enforceInterface(DESCRIPTOR);
            List<DownloadInfo> r141 = getDownloadInfosByMonitorScene(r111.createStringArrayList());
            r112.writeNoException();
            r112.writeTypedList(r141);
            return true;
        L106:
            r111.enforceInterface(DESCRIPTOR);
            List<DownloadInfo> r142 = getDownloadInfosByFilters(r111.readString(), r111.readString());
            r112.writeNoException();
            r112.writeTypedList(r142);
            return true;
        L108:
            r111.enforceInterface(DESCRIPTOR);
            List<DownloadInfo> r143 = getAllDownloadInfo();
            r112.writeNoException();
            r112.writeTypedList(r143);
            return true;
        L110:
            r111.enforceInterface(DESCRIPTOR);
            List<DownloadInfo> r144 = getDownloadInfosByFileExtension(r111.readString());
            r112.writeNoException();
            r112.writeTypedList(r144);
            return true;
        L112:
            r111.enforceInterface(DESCRIPTOR);
            List<DownloadInfo> r145 = getDownloadingDownloadInfosWithMimeType(r111.readString());
            r112.writeNoException();
            r112.writeTypedList(r145);
            return true;
        L114:
            r111.enforceInterface(DESCRIPTOR);
            List<DownloadInfo> r146 = getSuccessedDownloadInfosWithMimeType(r111.readString());
            r112.writeNoException();
            r112.writeTypedList(r146);
            return true;
        L116:
            r111.enforceInterface(DESCRIPTOR);
            DownloadInfo r147 = getDownloadInfoByUrlAndPath(r111.readString(), r111.readString());
            r112.writeNoException();
            if (r147 == null) goto L119;
            r112.writeInt(1);
            r147.writeToParcel(r112, 1);
        L120:
            return true;
        L119:
            r112.writeInt(0);
            goto L120
        L121:
            r111.enforceInterface(DESCRIPTOR);
            int r148 = getDownloadId(r111.readString(), r111.readString());
            r112.writeNoException();
            r112.writeInt(r148);
            return true;
        L123:
            r111.enforceInterface(DESCRIPTOR);
            List<DownloadInfo> r149 = getDownloadInfoList(r111.readString());
            r112.writeNoException();
            r112.writeTypedList(r149);
            return true;
        L125:
            r111.enforceInterface(DESCRIPTOR);
            DownloadInfo r150 = getDownloadInfo(r111.readInt());
            r112.writeNoException();
            if (r150 == null) goto L128;
            r112.writeInt(1);
            r150.writeToParcel(r112, 1);
        L129:
            return true;
        L128:
            r112.writeInt(0);
            goto L129
        L130:
            r111.enforceInterface(DESCRIPTOR);
            boolean r151 = isDownloading(r111.readInt());
            r112.writeNoException();
            r112.writeInt(r151 ? 1 : 0);
            return true;
        L132:
            r111.enforceInterface(DESCRIPTOR);
            int r152 = getStatus(r111.readInt());
            r112.writeNoException();
            r112.writeInt(r152);
            return true;
        L134:
            r111.enforceInterface(DESCRIPTOR);
            long r153 = getCurBytes(r111.readInt());
            r112.writeNoException();
            r112.writeLong(r153);
            return true;
        L136:
            r111.enforceInterface(DESCRIPTOR);
            pauseAll();
            r112.writeNoException();
            return true;
        L138:
            r111.enforceInterface(DESCRIPTOR);
            restart(r111.readInt());
            r112.writeNoException();
            return true;
        L140:
            r111.enforceInterface(DESCRIPTOR);
            resume(r111.readInt());
            r112.writeNoException();
            return true;
        L142:
            r111.enforceInterface(DESCRIPTOR);
            boolean r154 = canResume(r111.readInt());
            r112.writeNoException();
            r112.writeInt(r154 ? 1 : 0);
            return true;
        L144:
            r111.enforceInterface(DESCRIPTOR);
            int r155 = r111.readInt();
            if (r111.readInt() == 0) goto L147;
            r105 = true;
        L147:
            cancel(r155, r105);
            r112.writeNoException();
            return true;
        L149:
            r111.enforceInterface(DESCRIPTOR);
            int r156 = r111.readInt();
            if (r111.readInt() == 0) goto L152;
            r105 = true;
        L152:
            pause(r156, r105);
            r112.writeNoException();
            return true;
        L154:
            r111.enforceInterface(DESCRIPTOR);
            tryDownload(DownloadAidlTask.Stub.asInterface(r111.readStrongBinder()));
            r112.writeNoException();
            return true;
        L7:
            return super.onTransact(r110, r111, r112, r113);
        L156:
            r112.writeString(DESCRIPTOR);
            return true;
        }
    }

    void addDownloadListener(int r100, int r101, IDownloadAidlListener r102, int r103, boolean r104) throws RemoteException;

    void addDownloadListener1(int r100, int r101, IDownloadAidlListener r102, int r103, boolean r104, boolean r105) throws RemoteException;

    void addProcessCallback(ProcessAidlCallback r100) throws RemoteException;

    boolean canResume(int r100) throws RemoteException;

    void cancel(int r100, boolean r101) throws RemoteException;

    void clearData() throws RemoteException;

    void clearDownloadData(int r100, boolean r101, boolean r102) throws RemoteException;

    void dispatchProcessCallback(int r100, int r101) throws RemoteException;

    List<DownloadInfo> getAllDownloadInfo() throws RemoteException;

    long getCurBytes(int r100) throws RemoteException;

    IDownloadAidlFileProvider getDownloadFileUriProvider(int r100) throws RemoteException;

    int getDownloadId(String r100, String r101) throws RemoteException;

    DownloadInfo getDownloadInfo(int r100) throws RemoteException;

    DownloadInfo getDownloadInfoByUrlAndPath(String r100, String r101) throws RemoteException;

    List<DownloadInfo> getDownloadInfoList(String r100) throws RemoteException;

    List<DownloadInfo> getDownloadInfosByFileExtension(String r100) throws RemoteException;

    List<DownloadInfo> getDownloadInfosByFilters(String r100, String r101) throws RemoteException;

    List<DownloadInfo> getDownloadInfosByMonitorScene(List<String> r100) throws RemoteException;

    IDownloadNotificationEventAidlListener getDownloadNotificationEventListener(int r100) throws RemoteException;

    int getDownloadWithIndependentProcessStatus(int r100) throws RemoteException;

    List<DownloadInfo> getDownloadingDownloadInfosWithMimeType(String r100) throws RemoteException;

    INotificationClickAidlCallback getNotificationClickCallback(int r100) throws RemoteException;

    int getStatus(int r100) throws RemoteException;

    List<DownloadInfo> getSuccessedDownloadInfosWithMimeType(String r100) throws RemoteException;

    List<DownloadInfo> getUnCompletedDownloadInfosWithMimeType(String r100) throws RemoteException;

    boolean isDownloadCacheSyncSuccess() throws RemoteException;

    boolean isDownloadSuccessAndFileNotExist(DownloadInfo r100) throws RemoteException;

    boolean isDownloading(int r100) throws RemoteException;

    boolean isHttpServiceInit() throws RemoteException;

    void pause(int r100, boolean r101) throws RemoteException;

    void pauseAll() throws RemoteException;

    boolean removeDownloadInfo(int r100) throws RemoteException;

    void removeDownloadListener(int r100, int r101, IDownloadAidlListener r102, int r103, boolean r104) throws RemoteException;

    boolean removeDownloadTaskData(int r100) throws RemoteException;

    void resetDownloadData(int r100, boolean r101) throws RemoteException;

    void restart(int r100) throws RemoteException;

    void restartAllFailedDownloadTasks(List<String> r100) throws RemoteException;

    void restartAllPauseReserveOnWifiDownloadTasks(List<String> r100) throws RemoteException;

    void resume(int r100) throws RemoteException;

    void setDownloadNotificationEventListener(int r100, IDownloadNotificationEventAidlListener r101) throws RemoteException;

    void setDownloadWithIndependentProcessStatus(int r100, boolean r101) throws RemoteException;

    void setLogLevel(int r100) throws RemoteException;

    void setThrottleNetSpeed(int r100, long r101, int r102) throws RemoteException;

    void syncDownloadInfoFromOtherCache(int r100) throws RemoteException;

    void tryDownload(DownloadAidlTask r100) throws RemoteException;

    boolean updateDownloadInfo(DownloadInfo r100) throws RemoteException;
}
