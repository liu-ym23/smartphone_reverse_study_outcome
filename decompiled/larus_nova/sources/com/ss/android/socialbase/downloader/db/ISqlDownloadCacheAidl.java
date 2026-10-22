package com.ss.android.socialbase.downloader.db;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.List;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes5.dex */
public interface ISqlDownloadCacheAidl extends IInterface {

    /* JADX INFO: loaded from: classes38.dex */
    public static class Default implements ISqlDownloadCacheAidl {
        public Default() {
        }

        @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
        public DownloadInfo OnDownloadTaskCancel(int r100, long r101) throws RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
        public DownloadInfo OnDownloadTaskCompleted(int r100, long r101) throws RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
        public DownloadInfo OnDownloadTaskConnected(int r100, long r101, String r102, String r103) throws RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
        public DownloadInfo OnDownloadTaskError(int r100, long r101) throws RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
        public DownloadInfo OnDownloadTaskIntercept(int r100) throws RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
        public DownloadInfo OnDownloadTaskPause(int r100, long r101) throws RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
        public DownloadInfo OnDownloadTaskPrepare(int r100) throws RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
        public DownloadInfo OnDownloadTaskProgress(int r100, long r101) throws RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
        public DownloadInfo OnDownloadTaskRetry(int r100) throws RemoteException {
            return null;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
        public boolean cacheExist(int r100) throws RemoteException {
            return false;
        }

        @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
        public void clearData() throws RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
        public boolean ensureDownloadCacheSyncSuccess() throws RemoteException {
            return false;
        }

        @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
        public List<DownloadInfo> getAllDownloadInfo() throws RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
        public DownloadInfo getDownloadInfo(int r100) throws RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
        public List<DownloadInfo> getDownloadInfoList(String r100) throws RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
        public List<DownloadInfo> getDownloadInfosByFileExtension(String r100) throws RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
        public List<DownloadInfo> getDownloadInfosByFilters(String r100, String r101) throws RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
        public List<DownloadInfo> getDownloadInfosByMonitorScene(List<String> r100) throws RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
        public List<DownloadInfo> getSuccessedDownloadInfosWithMimeType(String r100) throws RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
        public List<DownloadInfo> getUnCompletedDownloadInfosWithMimeType(String r100) throws RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
        public void init(boolean r100) throws RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
        public boolean isDownloadCacheSyncSuccess() throws RemoteException {
            return false;
        }

        @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
        public DownloadInfo onDownloadTaskStart(int r100) throws RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
        public boolean removeDownloadInfo(int r100) throws RemoteException {
            return false;
        }

        @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
        public boolean removeDownloadTaskData(int r100) throws RemoteException {
            return false;
        }

        @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
        public void setInitCallback(ISqlCacheLoadCompleteCallbackAidl r100) throws RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
        public void syncDownloadInfo(DownloadInfo r100) throws RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
        public void syncDownloadInfoFromOtherCache(int r100) throws RemoteException {
        }

        @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
        public boolean updateDownloadInfo(DownloadInfo r100) throws RemoteException {
            return false;
        }
    }

    public static abstract class Stub extends Binder implements ISqlDownloadCacheAidl {
        private static final String DESCRIPTOR = "com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl";
        static final int TRANSACTION_OnDownloadTaskCancel = 22;
        static final int TRANSACTION_OnDownloadTaskCompleted = 20;
        static final int TRANSACTION_OnDownloadTaskConnected = 16;
        static final int TRANSACTION_OnDownloadTaskError = 18;
        static final int TRANSACTION_OnDownloadTaskIntercept = 24;
        static final int TRANSACTION_OnDownloadTaskPause = 21;
        static final int TRANSACTION_OnDownloadTaskPrepare = 23;
        static final int TRANSACTION_OnDownloadTaskProgress = 17;
        static final int TRANSACTION_OnDownloadTaskRetry = 19;
        static final int TRANSACTION_cacheExist = 2;
        static final int TRANSACTION_clearData = 14;
        static final int TRANSACTION_ensureDownloadCacheSyncSuccess = 26;
        static final int TRANSACTION_getAllDownloadInfo = 8;
        static final int TRANSACTION_getDownloadInfo = 3;
        static final int TRANSACTION_getDownloadInfoList = 4;
        static final int TRANSACTION_getDownloadInfosByFileExtension = 7;
        static final int TRANSACTION_getDownloadInfosByFilters = 9;
        static final int TRANSACTION_getDownloadInfosByMonitorScene = 10;
        static final int TRANSACTION_getSuccessedDownloadInfosWithMimeType = 5;
        static final int TRANSACTION_getUnCompletedDownloadInfosWithMimeType = 6;
        static final int TRANSACTION_init = 1;
        static final int TRANSACTION_isDownloadCacheSyncSuccess = 25;
        static final int TRANSACTION_onDownloadTaskStart = 15;
        static final int TRANSACTION_removeDownloadInfo = 12;
        static final int TRANSACTION_removeDownloadTaskData = 13;
        static final int TRANSACTION_setInitCallback = 29;
        static final int TRANSACTION_syncDownloadInfo = 27;
        static final int TRANSACTION_syncDownloadInfoFromOtherCache = 28;
        static final int TRANSACTION_updateDownloadInfo = 11;

        /* JADX INFO: loaded from: classes6.dex */
        public static class Proxy implements ISqlDownloadCacheAidl {
            public static ISqlDownloadCacheAidl sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
            public void clearData() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_db_ISqlDownloadCacheAidl$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 14, r100, r101, 0) == false) goto L6;
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

            @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
            public boolean ensureDownloadCacheSyncSuccess() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                boolean r102 = false;
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_db_ISqlDownloadCacheAidl$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 26, r100, r101, 0) == false) goto L6;
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
                boolean r103 = Stub.getDefaultImpl().ensureDownloadCacheSyncSuccess();     // Catch: Throwable -> L15
                r101.recycle();
                r100.recycle();
                return r103;
            L15:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
            public List<DownloadInfo> getAllDownloadInfo() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_db_ISqlDownloadCacheAidl$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 8, r100, r101, 0) == false) goto L6;
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

            @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
            public boolean isDownloadCacheSyncSuccess() throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                boolean r102 = false;
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_db_ISqlDownloadCacheAidl$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 25, r100, r101, 0) == false) goto L6;
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

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public Proxy(IBinder r100) {
                this.mRemote = r100;
            }

            @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
            public DownloadInfo OnDownloadTaskIntercept(int r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r101.writeInt(r100);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_db_ISqlDownloadCacheAidl$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 24, r101, r102, 0) == false) goto L6;
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
                DownloadInfo r104 = Stub.getDefaultImpl().OnDownloadTaskIntercept(r100);     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return r104;
            L17:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
            public DownloadInfo OnDownloadTaskPrepare(int r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r101.writeInt(r100);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_db_ISqlDownloadCacheAidl$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 23, r101, r102, 0) == false) goto L6;
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
                DownloadInfo r104 = Stub.getDefaultImpl().OnDownloadTaskPrepare(r100);     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return r104;
            L17:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
            public DownloadInfo OnDownloadTaskRetry(int r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r101.writeInt(r100);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_db_ISqlDownloadCacheAidl$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 19, r101, r102, 0) == false) goto L6;
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
                DownloadInfo r104 = Stub.getDefaultImpl().OnDownloadTaskRetry(r100);     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return r104;
            L17:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
            public boolean cacheExist(int r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                r101.writeInt(r100);     // Catch: Throwable -> L15
                boolean r103 = false;
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_db_ISqlDownloadCacheAidl$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r101, r102, 0) == false) goto L6;
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
                boolean r104 = Stub.getDefaultImpl().cacheExist(r100);     // Catch: Throwable -> L15
                r102.recycle();
                r101.recycle();
                return r104;
            L15:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
            public DownloadInfo getDownloadInfo(int r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r101.writeInt(r100);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_db_ISqlDownloadCacheAidl$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r101, r102, 0) == false) goto L6;
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

            @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
            public List<DownloadInfo> getDownloadInfoList(String r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r101.writeString(r100);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_db_ISqlDownloadCacheAidl$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r101, r102, 0) == false) goto L6;
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

            @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
            public List<DownloadInfo> getDownloadInfosByFileExtension(String r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r101.writeString(r100);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_db_ISqlDownloadCacheAidl$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 7, r101, r102, 0) == false) goto L6;
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

            @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
            public List<DownloadInfo> getDownloadInfosByMonitorScene(List<String> r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r101.writeStringList(r100);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_db_ISqlDownloadCacheAidl$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 10, r101, r102, 0) == false) goto L6;
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

            @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
            public List<DownloadInfo> getSuccessedDownloadInfosWithMimeType(String r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r101.writeString(r100);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_db_ISqlDownloadCacheAidl$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 5, r101, r102, 0) == false) goto L6;
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

            @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
            public List<DownloadInfo> getUnCompletedDownloadInfosWithMimeType(String r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r101.writeString(r100);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_db_ISqlDownloadCacheAidl$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 6, r101, r102, 0) == false) goto L6;
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

            @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
            public void init(boolean r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r100 == false) goto L6;
                int r103 = 1;
            L7:
                r101.writeInt(r103);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_db_ISqlDownloadCacheAidl$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r101, r102, 0) == false) goto L10;
            L14:
                r102.readException();     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().init(r100);     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return;
            L6:
                r103 = 0;
            L17:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
            public DownloadInfo onDownloadTaskStart(int r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r101.writeInt(r100);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_db_ISqlDownloadCacheAidl$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 15, r101, r102, 0) == false) goto L6;
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
                DownloadInfo r104 = Stub.getDefaultImpl().onDownloadTaskStart(r100);     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return r104;
            L17:
                th = move-exception;
                r102.recycle();
                r101.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
            public boolean removeDownloadInfo(int r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                r101.writeInt(r100);     // Catch: Throwable -> L15
                boolean r103 = false;
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_db_ISqlDownloadCacheAidl$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 12, r101, r102, 0) == false) goto L6;
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

            @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
            public boolean removeDownloadTaskData(int r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                r101.writeInt(r100);     // Catch: Throwable -> L15
                boolean r103 = false;
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_db_ISqlDownloadCacheAidl$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 13, r101, r102, 0) == false) goto L6;
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

            @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
            public void setInitCallback(ISqlCacheLoadCompleteCallbackAidl r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r100 == null) goto L6;
                IBinder r103 = r100.asBinder();     // Catch: Throwable -> L17
            L7:
                r101.writeStrongBinder(r103);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_db_ISqlDownloadCacheAidl$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 29, r101, r102, 0) == false) goto L10;
            L14:
                r102.readException();     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().setInitCallback(r100);     // Catch: Throwable -> L17
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

            @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
            public void syncDownloadInfo(DownloadInfo r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r100 == null) goto L6;
                r101.writeInt(1);     // Catch: Throwable -> L17
                r100.writeToParcel(r101, 0);     // Catch: Throwable -> L17
            L8:
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_db_ISqlDownloadCacheAidl$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 27, r101, r102, 0) == false) goto L10;
            L14:
                r102.readException();     // Catch: Throwable -> L17
                r102.recycle();
                r101.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().syncDownloadInfo(r100);     // Catch: Throwable -> L17
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

            @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
            public void syncDownloadInfoFromOtherCache(int r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r101.writeInt(r100);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_db_ISqlDownloadCacheAidl$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 28, r101, r102, 0) == false) goto L6;
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

            @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
            public boolean updateDownloadInfo(DownloadInfo r100) throws RemoteException {
                Parcel r101 = Parcel.obtain();
                Parcel r102 = Parcel.obtain();
                r101.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L20
                boolean r103 = true;
                if (r100 == null) goto L6;
                r101.writeInt(1);     // Catch: Throwable -> L20
                r100.writeToParcel(r101, 0);     // Catch: Throwable -> L20
            L8:
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_db_ISqlDownloadCacheAidl$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 11, r101, r102, 0) == false) goto L10;
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

            @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
            public DownloadInfo OnDownloadTaskCancel(int r100, long r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r102.writeInt(r100);     // Catch: Throwable -> L17
                r102.writeLong(r101);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_db_ISqlDownloadCacheAidl$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 22, r102, r103, 0) == false) goto L6;
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
                DownloadInfo r105 = Stub.getDefaultImpl().OnDownloadTaskCancel(r100, r101);     // Catch: Throwable -> L17
                r103.recycle();
                r102.recycle();
                return r105;
            L17:
                th = move-exception;
                r103.recycle();
                r102.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
            public DownloadInfo OnDownloadTaskCompleted(int r100, long r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r102.writeInt(r100);     // Catch: Throwable -> L17
                r102.writeLong(r101);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_db_ISqlDownloadCacheAidl$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 20, r102, r103, 0) == false) goto L6;
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
                DownloadInfo r105 = Stub.getDefaultImpl().OnDownloadTaskCompleted(r100, r101);     // Catch: Throwable -> L17
                r103.recycle();
                r102.recycle();
                return r105;
            L17:
                th = move-exception;
                r103.recycle();
                r102.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
            public DownloadInfo OnDownloadTaskError(int r100, long r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r102.writeInt(r100);     // Catch: Throwable -> L17
                r102.writeLong(r101);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_db_ISqlDownloadCacheAidl$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 18, r102, r103, 0) == false) goto L6;
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
                DownloadInfo r105 = Stub.getDefaultImpl().OnDownloadTaskError(r100, r101);     // Catch: Throwable -> L17
                r103.recycle();
                r102.recycle();
                return r105;
            L17:
                th = move-exception;
                r103.recycle();
                r102.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
            public DownloadInfo OnDownloadTaskPause(int r100, long r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r102.writeInt(r100);     // Catch: Throwable -> L17
                r102.writeLong(r101);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_db_ISqlDownloadCacheAidl$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 21, r102, r103, 0) == false) goto L6;
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
                DownloadInfo r105 = Stub.getDefaultImpl().OnDownloadTaskPause(r100, r101);     // Catch: Throwable -> L17
                r103.recycle();
                r102.recycle();
                return r105;
            L17:
                th = move-exception;
                r103.recycle();
                r102.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
            public DownloadInfo OnDownloadTaskProgress(int r100, long r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r102.writeInt(r100);     // Catch: Throwable -> L17
                r102.writeLong(r101);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_db_ISqlDownloadCacheAidl$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 17, r102, r103, 0) == false) goto L6;
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
                DownloadInfo r105 = Stub.getDefaultImpl().OnDownloadTaskProgress(r100, r101);     // Catch: Throwable -> L17
                r103.recycle();
                r102.recycle();
                return r105;
            L17:
                th = move-exception;
                r103.recycle();
                r102.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
            public List<DownloadInfo> getDownloadInfosByFilters(String r100, String r101) throws RemoteException {
                Parcel r102 = Parcel.obtain();
                Parcel r103 = Parcel.obtain();
                r102.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r102.writeString(r100);     // Catch: Throwable -> L13
                r102.writeString(r101);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_db_ISqlDownloadCacheAidl$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 9, r102, r103, 0) == false) goto L6;
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

            @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
            public DownloadInfo OnDownloadTaskConnected(int r110, long r111, String r112, String r113) throws RemoteException {
                Parcel r100 = Parcel.obtain();
                Parcel r101 = Parcel.obtain();
                r100.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                r100.writeInt(r110);     // Catch: Throwable -> L17
                r100.writeLong(r111);     // Catch: Throwable -> L17
                r100.writeString(r112);     // Catch: Throwable -> L17
                r100.writeString(r113);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_ss_android_socialbase_downloader_db_ISqlDownloadCacheAidl$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 16, r100, r101, 0) == false) goto L6;
            L10:
                r101.readException();     // Catch: Throwable -> L17
                if (r101.readInt() == 0) goto L14;
                DownloadInfo r114 = DownloadInfo.CREATOR.createFromParcel(r101);     // Catch: Throwable -> L17
            L15:
                r101.recycle();
                r100.recycle();
                return r114;
            L14:
                r114 = null;
                goto L15
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                DownloadInfo r115 = Stub.getDefaultImpl().OnDownloadTaskConnected(r110, r111, r112, r113);     // Catch: Throwable -> L17
                r101.recycle();
                r100.recycle();
                return r115;
            L17:
                th = move-exception;
                r101.recycle();
                r100.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_ss_android_socialbase_downloader_db_ISqlDownloadCacheAidl$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
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

        public static ISqlDownloadCacheAidl getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static ISqlDownloadCacheAidl asInterface(IBinder r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            IInterface r101 = r100.queryLocalInterface(DESCRIPTOR);
            if (r101 == null) goto L12;
            if ((r101 instanceof ISqlDownloadCacheAidl) == false) goto L12;
            return (ISqlDownloadCacheAidl) r101;
        L12:
            return new Proxy(r100);
        }

        public static boolean setDefaultImpl(ISqlDownloadCacheAidl r100) {
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
            if (r110 == 1598968902) goto L108;
            DownloadInfo r100 = null;
            boolean r101 = false;
            switch(r110) {
                case 1: goto L103;
                case 2: goto L101;
                case 3: goto L96;
                case 4: goto L94;
                case 5: goto L92;
                case 6: goto L90;
                case 7: goto L88;
                case 8: goto L86;
                case 9: goto L84;
                case 10: goto L82;
                case 11: goto L77;
                case 12: goto L75;
                case 13: goto L73;
                case 14: goto L71;
                case 15: goto L66;
                case 16: goto L61;
                case 17: goto L56;
                case 18: goto L51;
                case 19: goto L46;
                case 20: goto L41;
                case 21: goto L36;
                case 22: goto L31;
                case 23: goto L26;
                case 24: goto L21;
                case 25: goto L19;
                case 26: goto L17;
                case 27: goto L12;
                case 28: goto L10;
                case 29: goto L8;
                default: goto L7;
            };
        L8:
            r111.enforceInterface(DESCRIPTOR);
            setInitCallback(ISqlCacheLoadCompleteCallbackAidl.Stub.asInterface(r111.readStrongBinder()));
            r112.writeNoException();
            return true;
        L10:
            r111.enforceInterface(DESCRIPTOR);
            syncDownloadInfoFromOtherCache(r111.readInt());
            r112.writeNoException();
            return true;
        L12:
            r111.enforceInterface(DESCRIPTOR);
            if (r111.readInt() == 0) goto L15;
            r100 = DownloadInfo.CREATOR.createFromParcel(r111);
        L15:
            syncDownloadInfo(r100);
            r112.writeNoException();
            return true;
        L17:
            r111.enforceInterface(DESCRIPTOR);
            boolean r114 = ensureDownloadCacheSyncSuccess();
            r112.writeNoException();
            r112.writeInt(r114 ? 1 : 0);
            return true;
        L19:
            r111.enforceInterface(DESCRIPTOR);
            boolean r115 = isDownloadCacheSyncSuccess();
            r112.writeNoException();
            r112.writeInt(r115 ? 1 : 0);
            return true;
        L21:
            r111.enforceInterface(DESCRIPTOR);
            DownloadInfo r116 = OnDownloadTaskIntercept(r111.readInt());
            r112.writeNoException();
            if (r116 == null) goto L24;
            r112.writeInt(1);
            r116.writeToParcel(r112, 1);
        L25:
            return true;
        L24:
            r112.writeInt(0);
            goto L25
        L26:
            r111.enforceInterface(DESCRIPTOR);
            DownloadInfo r117 = OnDownloadTaskPrepare(r111.readInt());
            r112.writeNoException();
            if (r117 == null) goto L29;
            r112.writeInt(1);
            r117.writeToParcel(r112, 1);
        L30:
            return true;
        L29:
            r112.writeInt(0);
            goto L30
        L31:
            r111.enforceInterface(DESCRIPTOR);
            DownloadInfo r118 = OnDownloadTaskCancel(r111.readInt(), r111.readLong());
            r112.writeNoException();
            if (r118 == null) goto L34;
            r112.writeInt(1);
            r118.writeToParcel(r112, 1);
        L35:
            return true;
        L34:
            r112.writeInt(0);
            goto L35
        L36:
            r111.enforceInterface(DESCRIPTOR);
            DownloadInfo r119 = OnDownloadTaskPause(r111.readInt(), r111.readLong());
            r112.writeNoException();
            if (r119 == null) goto L39;
            r112.writeInt(1);
            r119.writeToParcel(r112, 1);
        L40:
            return true;
        L39:
            r112.writeInt(0);
            goto L40
        L41:
            r111.enforceInterface(DESCRIPTOR);
            DownloadInfo r120 = OnDownloadTaskCompleted(r111.readInt(), r111.readLong());
            r112.writeNoException();
            if (r120 == null) goto L44;
            r112.writeInt(1);
            r120.writeToParcel(r112, 1);
        L45:
            return true;
        L44:
            r112.writeInt(0);
            goto L45
        L46:
            r111.enforceInterface(DESCRIPTOR);
            DownloadInfo r121 = OnDownloadTaskRetry(r111.readInt());
            r112.writeNoException();
            if (r121 == null) goto L49;
            r112.writeInt(1);
            r121.writeToParcel(r112, 1);
        L50:
            return true;
        L49:
            r112.writeInt(0);
            goto L50
        L51:
            r111.enforceInterface(DESCRIPTOR);
            DownloadInfo r122 = OnDownloadTaskError(r111.readInt(), r111.readLong());
            r112.writeNoException();
            if (r122 == null) goto L54;
            r112.writeInt(1);
            r122.writeToParcel(r112, 1);
        L55:
            return true;
        L54:
            r112.writeInt(0);
            goto L55
        L56:
            r111.enforceInterface(DESCRIPTOR);
            DownloadInfo r123 = OnDownloadTaskProgress(r111.readInt(), r111.readLong());
            r112.writeNoException();
            if (r123 == null) goto L59;
            r112.writeInt(1);
            r123.writeToParcel(r112, 1);
        L60:
            return true;
        L59:
            r112.writeInt(0);
            goto L60
        L61:
            r111.enforceInterface(DESCRIPTOR);
            DownloadInfo r124 = OnDownloadTaskConnected(r111.readInt(), r111.readLong(), r111.readString(), r111.readString());
            r112.writeNoException();
            if (r124 == null) goto L64;
            r112.writeInt(1);
            r124.writeToParcel(r112, 1);
        L65:
            return true;
        L64:
            r112.writeInt(0);
            goto L65
        L66:
            r111.enforceInterface(DESCRIPTOR);
            DownloadInfo r125 = onDownloadTaskStart(r111.readInt());
            r112.writeNoException();
            if (r125 == null) goto L69;
            r112.writeInt(1);
            r125.writeToParcel(r112, 1);
        L70:
            return true;
        L69:
            r112.writeInt(0);
            goto L70
        L71:
            r111.enforceInterface(DESCRIPTOR);
            clearData();
            r112.writeNoException();
            return true;
        L73:
            r111.enforceInterface(DESCRIPTOR);
            boolean r126 = removeDownloadTaskData(r111.readInt());
            r112.writeNoException();
            r112.writeInt(r126 ? 1 : 0);
            return true;
        L75:
            r111.enforceInterface(DESCRIPTOR);
            boolean r127 = removeDownloadInfo(r111.readInt());
            r112.writeNoException();
            r112.writeInt(r127 ? 1 : 0);
            return true;
        L77:
            r111.enforceInterface(DESCRIPTOR);
            if (r111.readInt() == 0) goto L80;
            r100 = DownloadInfo.CREATOR.createFromParcel(r111);
        L80:
            boolean r128 = updateDownloadInfo(r100);
            r112.writeNoException();
            r112.writeInt(r128 ? 1 : 0);
            return true;
        L82:
            r111.enforceInterface(DESCRIPTOR);
            List<DownloadInfo> r129 = getDownloadInfosByMonitorScene(r111.createStringArrayList());
            r112.writeNoException();
            r112.writeTypedList(r129);
            return true;
        L84:
            r111.enforceInterface(DESCRIPTOR);
            List<DownloadInfo> r130 = getDownloadInfosByFilters(r111.readString(), r111.readString());
            r112.writeNoException();
            r112.writeTypedList(r130);
            return true;
        L86:
            r111.enforceInterface(DESCRIPTOR);
            List<DownloadInfo> r131 = getAllDownloadInfo();
            r112.writeNoException();
            r112.writeTypedList(r131);
            return true;
        L88:
            r111.enforceInterface(DESCRIPTOR);
            List<DownloadInfo> r132 = getDownloadInfosByFileExtension(r111.readString());
            r112.writeNoException();
            r112.writeTypedList(r132);
            return true;
        L90:
            r111.enforceInterface(DESCRIPTOR);
            List<DownloadInfo> r133 = getUnCompletedDownloadInfosWithMimeType(r111.readString());
            r112.writeNoException();
            r112.writeTypedList(r133);
            return true;
        L92:
            r111.enforceInterface(DESCRIPTOR);
            List<DownloadInfo> r134 = getSuccessedDownloadInfosWithMimeType(r111.readString());
            r112.writeNoException();
            r112.writeTypedList(r134);
            return true;
        L94:
            r111.enforceInterface(DESCRIPTOR);
            List<DownloadInfo> r135 = getDownloadInfoList(r111.readString());
            r112.writeNoException();
            r112.writeTypedList(r135);
            return true;
        L96:
            r111.enforceInterface(DESCRIPTOR);
            DownloadInfo r136 = getDownloadInfo(r111.readInt());
            r112.writeNoException();
            if (r136 == null) goto L99;
            r112.writeInt(1);
            r136.writeToParcel(r112, 1);
        L100:
            return true;
        L99:
            r112.writeInt(0);
            goto L100
        L101:
            r111.enforceInterface(DESCRIPTOR);
            boolean r137 = cacheExist(r111.readInt());
            r112.writeNoException();
            r112.writeInt(r137 ? 1 : 0);
            return true;
        L103:
            r111.enforceInterface(DESCRIPTOR);
            if (r111.readInt() == 0) goto L106;
            r101 = true;
        L106:
            init(r101);
            r112.writeNoException();
            return true;
        L7:
            return super.onTransact(r110, r111, r112, r113);
        L108:
            r112.writeString(DESCRIPTOR);
            return true;
        }
    }

    DownloadInfo OnDownloadTaskCancel(int r100, long r101) throws RemoteException;

    DownloadInfo OnDownloadTaskCompleted(int r100, long r101) throws RemoteException;

    DownloadInfo OnDownloadTaskConnected(int r100, long r101, String r102, String r103) throws RemoteException;

    DownloadInfo OnDownloadTaskError(int r100, long r101) throws RemoteException;

    DownloadInfo OnDownloadTaskIntercept(int r100) throws RemoteException;

    DownloadInfo OnDownloadTaskPause(int r100, long r101) throws RemoteException;

    DownloadInfo OnDownloadTaskPrepare(int r100) throws RemoteException;

    DownloadInfo OnDownloadTaskProgress(int r100, long r101) throws RemoteException;

    DownloadInfo OnDownloadTaskRetry(int r100) throws RemoteException;

    boolean cacheExist(int r100) throws RemoteException;

    void clearData() throws RemoteException;

    boolean ensureDownloadCacheSyncSuccess() throws RemoteException;

    List<DownloadInfo> getAllDownloadInfo() throws RemoteException;

    DownloadInfo getDownloadInfo(int r100) throws RemoteException;

    List<DownloadInfo> getDownloadInfoList(String r100) throws RemoteException;

    List<DownloadInfo> getDownloadInfosByFileExtension(String r100) throws RemoteException;

    List<DownloadInfo> getDownloadInfosByFilters(String r100, String r101) throws RemoteException;

    List<DownloadInfo> getDownloadInfosByMonitorScene(List<String> r100) throws RemoteException;

    List<DownloadInfo> getSuccessedDownloadInfosWithMimeType(String r100) throws RemoteException;

    List<DownloadInfo> getUnCompletedDownloadInfosWithMimeType(String r100) throws RemoteException;

    void init(boolean r100) throws RemoteException;

    boolean isDownloadCacheSyncSuccess() throws RemoteException;

    DownloadInfo onDownloadTaskStart(int r100) throws RemoteException;

    boolean removeDownloadInfo(int r100) throws RemoteException;

    boolean removeDownloadTaskData(int r100) throws RemoteException;

    void setInitCallback(ISqlCacheLoadCompleteCallbackAidl r100) throws RemoteException;

    void syncDownloadInfo(DownloadInfo r100) throws RemoteException;

    void syncDownloadInfoFromOtherCache(int r100) throws RemoteException;

    boolean updateDownloadInfo(DownloadInfo r100) throws RemoteException;
}
