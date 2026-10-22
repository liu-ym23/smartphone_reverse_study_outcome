package com.ss.android.socialbase.downloader.impls;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.ss.android.socialbase.downloader.common.AppStatusManager;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.IDownloadLaunchHandler;
import com.ss.android.socialbase.downloader.downloader.IReserveWifiStatusListener;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.exception.DownloadOutOfSpaceException;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public class RetrySchedulerImpl implements Handler.Callback, AppStatusManager.AppStatusChangeListener {
    private static final int MIN_INTERVAL_MS = 3000;
    private static final int MIN_INTERVAL_MS_ACCELERATION = 5000;
    public static final int RETRY_SCHEDULE_NORMAL = 1;
    public static final int RETRY_SCHEDULE_WHEN_APP_BACKGROUND = 3;
    public static final int RETRY_SCHEDULE_WHEN_APP_FOREGROUND = 4;
    public static final int RETRY_SCHEDULE_WHEN_OTHER_CONNECTED = 5;
    public static final int RETRY_SCHEDULE_WHEN_OTHER_SUCCEED = 2;
    private static final int SCHEDULE_ALL_TASK_RETRY_DELAY = 2000;
    private static final int SCHEDULE_ALL_TASK_RETRY_MIN_INTERVAL = 10000;
    private static final String TAG = "RetryScheduler";
    private static volatile RetrySchedulerImpl sInstance;
    private static RetryScheduler.RetryScheduleHandler sRetryScheduleHandler;
    private ConnectivityManager mConnectivityManager;
    private final Context mContext;
    private final Handler mHandler;
    private final boolean mIsDownloaderProcess;
    private long mLastHandleAllTaskTime;
    private final SparseArray<RetryInfo> mRetryInfoList;
    private int mWaitingRetryTasksCount;

    public static class RetryInfo {
        final int[] allowErrorCode;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        final int f449577id;
        final int intervalMs;
        final int intervalMsAcceleration;
        final int level;
        private AtomicInteger mCurrentIntervalMs;
        private boolean mIsWaitingRetry;
        private AtomicLong mLastRetryTime;
        private boolean mNeedWifi;
        private AtomicInteger mRetryCount;
        final int maxCount;
        final boolean useJobScheduler;

        public int getCurrentRetryIntervalMs() {
            return this.mCurrentIntervalMs.get();
        }

        public void increaseRetryCount() {
            this.mRetryCount.incrementAndGet();
        }

        public void increaseRetryInterval() {
            this.mCurrentIntervalMs.addAndGet(this.intervalMsAcceleration);
        }

        public void resetRetryInterval() {
            this.mCurrentIntervalMs.set(this.intervalMs);
        }

        public static /* synthetic */ AtomicInteger access$300(RetryInfo r100) {
            return r100.mRetryCount;
        }

        public static /* synthetic */ boolean access$500(RetryInfo r100) {
            return r100.mIsWaitingRetry;
        }

        public void updateRetryTimeStamp(long r100) {
            this.mLastRetryTime.set(r100);
        }

        public static /* synthetic */ boolean access$402(RetryInfo r100, boolean r101) {
            r100.mNeedWifi = r101;
            return r101;
        }

        public static /* synthetic */ boolean access$502(RetryInfo r100, boolean r101) {
            r100.mIsWaitingRetry = r101;
            return r101;
        }

        public boolean canRetry(long r100, int r101, int r102, boolean r103) {
            if (this.mIsWaitingRetry == true) goto L9;
            if (Logger.debug() == false) goto L7;
            Logger.taskDebug(RetrySchedulerImpl.TAG, this.f449577id, "canRetry", "IsWaitingRetry is false, return false");
        L7:
            return false;
        L9:
            if (this.level >= r101) goto L12;
            return false;
        L12:
            if (this.mRetryCount.get() < this.maxCount) goto L15;
            return false;
        L15:
            if (this.mNeedWifi == true) goto L17;
        L19:
            if (r103 == false) goto L21;
            return true;
        L21:
            if ((r100 - this.mLastRetryTime.get()) >= this.intervalMs) goto L25;
            return false;
        L25:
            return true;
        L17:
            if (r102 == 2) goto L19;
            return false;
        }

        public RetryInfo(int r100, int r101, int r102, int r103, int r104, boolean r105, int[] r106) {
            if (r103 >= 3000) goto L6;
            r103 = 3000;
        L6:
            if (r104 >= 5000) goto L8;
            r104 = 5000;
        L8:
            this.f449577id = r100;
            this.level = r101;
            this.maxCount = r102;
            this.intervalMs = r103;
            this.intervalMsAcceleration = r104;
            this.useJobScheduler = r105;
            this.allowErrorCode = r106;
            this.mCurrentIntervalMs = new AtomicInteger(r103);
            this.mLastRetryTime = new AtomicLong(0);
            this.mRetryCount = new AtomicInteger(0);
        }
    }

    private int getNetWorkType() {
        if (this.mConnectivityManager != null) goto L6;
        this.mConnectivityManager = (ConnectivityManager) this.mContext.getApplicationContext().getSystemService("connectivity");     // Catch: Exception -> L18
    L6:
        NetworkInfo r100 = this.mConnectivityManager.getActiveNetworkInfo();     // Catch: Exception -> L18
        if (r100 == null) goto L17;
        if (r100.isConnected() == false) goto L17;
        if (r100.getType() != 1) goto L16;
        return 2;
    L16:
        return 1;
    L17:
        return 0;
    }

    @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener
    public void onAppBackground() {
        scheduleAllTaskRetry(3, false);
    }

    @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener
    public void onAppForeground() {
        scheduleAllTaskRetry(4, false);
    }

    public void scheduleRetryWhenHasTaskConnected() {
        scheduleAllTaskRetry(5, false);
    }

    public void scheduleRetryWhenHasTaskSucceed() {
        scheduleAllTaskRetry(2, true);
    }

    public static RetrySchedulerImpl getInstance() {
        if (sInstance != null) goto L15;
        monitor-enter(RetrySchedulerImpl.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new RetrySchedulerImpl();     // Catch: Throwable -> L11
    L9:
        monitor-exit(RetrySchedulerImpl.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private RetrySchedulerImpl() {
        this.mHandler = new Handler(Looper.getMainLooper(), this);
        this.mRetryInfoList = new SparseArray();
        this.mWaitingRetryTasksCount = 0;
        this.mContext = DownloadComponentManager.getAppContext();
        registerNetworkCallback();
        this.mIsDownloaderProcess = DownloadHelper.isDownloaderProcess();
        AppStatusManager.getInstance().registerAppSwitchListener(this);
    }

    private void registerNetworkCallback() {
        if (DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.USE_NETWORK_CALLBACK, 0) == 1) goto L5;
        return;
    L5:
        DownloadComponentManager.getCPUThreadExecutor().execute(new AnonymousClass1(this));
    }

    public static /* synthetic */ Context access$000(RetrySchedulerImpl r100) {
        return r100.mContext;
    }

    public static /* synthetic */ ConnectivityManager access$100(RetrySchedulerImpl r100) {
        return r100.mConnectivityManager;
    }

    public static /* synthetic */ int access$600(RetrySchedulerImpl r100) {
        return r100.mWaitingRetryTasksCount;
    }

    public static /* synthetic */ int access$700(RetrySchedulerImpl r100) {
        return r100.getNetWorkType();
    }

    public static /* synthetic */ SparseArray access$800(RetrySchedulerImpl r100) {
        return r100.mRetryInfoList;
    }

    private RetryInfo createRetryInfo(int r110) {
        DownloadSetting r100 = DownloadSetting.obtain(r110);
        boolean r101 = false;
        int r102 = r100.optInt(DownloadSettingKeys.RETRY_SCHEDULE, 0);
        JSONObject r103 = r100.optJSONObject(DownloadSettingKeys.RETRY_SCHEDULE_CONFIG);
        int r104 = 60;
        if (r103 == null) goto L10;
        int r105 = r103.optInt(DownloadSettingKeys.RetryScheduleConfig.MAX_COUNT, 60);
        int r106 = r103.optInt(DownloadSettingKeys.RetryScheduleConfig.INTERVAL_SEC, 60);
        int r107 = r103.optInt(DownloadSettingKeys.RetryScheduleConfig.INTERVAL_SEC_ACCELERATION, 60);
        if (sRetryScheduleHandler != null) goto L7;
    L9:
        int[] r111 = parserAllowErrorCode(r103.optString(DownloadSettingKeys.RetryScheduleConfig.ALLOW_ERROR_CODE));
        int r108 = r107;
        boolean r109 = r101;
        int r112 = r105;
        r104 = r106;
    L12:
        return new RetryInfo(r110, r102, r112, r104 * 1000, r108 * 1000, r109, r111);
    L7:
        if (r103.optInt(DownloadSettingKeys.RetryScheduleConfig.USE_JOB_SCHEDULER, 0) != 1) goto L9;
        r101 = true;
        goto L9
    L10:
        r111 = null;
        r108 = 60;
        r112 = 60;
        r109 = false;
        goto L12
    }

    private RetryInfo obtainRetryInfo(int r100) {
        RetryInfo r101 = this.mRetryInfoList.get(r100);
        if (r101 != null) goto L15;
        SparseArray<RetryInfo> r102 = this.mRetryInfoList;
        monitor-enter(r102);
        r101 = this.mRetryInfoList.get(r100);     // Catch: Throwable -> L12
        if (r101 != null) goto L9;
        r101 = createRetryInfo(r100);     // Catch: Throwable -> L12
    L9:
        this.mRetryInfoList.put(r100, r101);     // Catch: Throwable -> L12
        monitor-exit(r102);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    L15:
        return r101;
    }

    private int[] parserAllowErrorCode(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L15;
        return null;
    L15:
        String[] r101 = r100.split(",");     // Catch: Throwable -> L14
        if (r101.length > 0) goto L8;
        return null;
    L8:
        int[] r102 = new int[r101.length];     // Catch: Throwable -> L14
        int r103 = 0;
    L10:
        if (r103 >= r101.length) goto L13;
        r102[r103] = CastIntegerProtector.parseInt(r101[r103]);     // Catch: Throwable -> L14
        r103 = r103 + 1;
        goto L10
    L13:
        return r102;
    L14:
        return null;
    }

    private void removeRetryInfo(int r100) {
        SparseArray<RetryInfo> r101 = this.mRetryInfoList;
        monitor-enter(r101);
        this.mRetryInfoList.remove(r100);     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static void setRetryScheduleHandler(RetryScheduler.RetryScheduleHandler r100) {
        sRetryScheduleHandler = r100;
    }

    public void doSchedulerRetry(final int r100) {
        DownloadComponentManager.getCPUThreadExecutor().execute(new AnonymousClass3(this, r100));
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message r100) {
        if (r100.what != 0) goto L10;
        int r101 = r100.arg1;
        if (r100.arg2 != 1) goto L7;
        boolean r102 = true;
    L8:
        doScheduleAllTaskRetry(r101, r102);
    L13:
        return true;
    L7:
        r102 = false;
        goto L8
    L10:
        if (Logger.debug() == false) goto L12;
        Logger.taskDebug(TAG, r100.what, "handleMessage", "DoSchedulerRetry");
    L12:
        doSchedulerRetry(r100.what);
        goto L13
    }

    public void tryCancelScheduleRetry(int r100) {
        SparseArray<RetryInfo> r101 = this.mRetryInfoList;
        monitor-enter(r101);
        RetryInfo r102 = this.mRetryInfoList.get(r100);     // Catch: Throwable -> L21
        if (r102 != null) goto L9;
        monitor-exit(r101);     // Catch: Throwable -> L21
        return;
    L9:
        if (RetryInfo.access$500(r102) == false) goto L13;
        RetryInfo.access$502(r102, false);     // Catch: Throwable -> L21
        int r103 = this.mWaitingRetryTasksCount - 1;     // Catch: Throwable -> L21
        this.mWaitingRetryTasksCount = r103;     // Catch: Throwable -> L21
        if (r103 >= 0) goto L13;
        this.mWaitingRetryTasksCount = 0;     // Catch: Throwable -> L21
    L13:
        monitor-exit(r101);     // Catch: Throwable -> L21
        if (r102.useJobScheduler == false) goto L19;
        RetryScheduler.RetryScheduleHandler r104 = sRetryScheduleHandler;
        if (r104 == null) goto L25;
        r104.cancelRetry(r100);
        return;
    L25:
        return;
    L19:
        this.mHandler.removeMessages(r100);
        return;
    L21:
        th = move-exception;
        throw th;
    }

    public void tryStartScheduleRetry(DownloadInfo r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(DownloadConstants.MIME_APK) == false) goto L6;
        return;
    L6:
        if (DownloadConstants.MIME_APK.equals(r100.getMimeType()) == true) goto L9;
        return;
    L9:
        if (r100.isOnlyWifi() == false) goto L11;
    L14:
        boolean r101 = true;
    L15:
        tryStartScheduleRetry(r100, r101, getNetWorkType());
        return;
    L11:
        if (r100.isPauseReserveOnWifi() == true) goto L14;
        r101 = false;
        goto L15
    }

    public static /* synthetic */ ConnectivityManager access$102(RetrySchedulerImpl r100, ConnectivityManager r101) {
        r100.mConnectivityManager = r101;
        return r101;
    }

    private boolean canRetryForAllowErrorCode(RetryInfo r100, int r101) {
        int[] r102 = r100.allowErrorCode;
        if (r102 != null) goto L5;
    L14:
        return false;
    L5:
        if (r102.length == 0) goto L14;
        int r103 = r102.length;
        int r104 = 0;
    L8:
        if (r104 >= r103) goto L14;
        if (r102[r104] == r101) goto L11;
        r104 = r104 + 1;
        goto L8
    L11:
        return true;
    }

    private boolean canRetryWhenInsufficientSpace(DownloadInfo r110, BaseException r111) {
        long r100 = DownloadUtils.getAvailableSpaceBytes(r110.getTempPath());     // Catch: BaseException -> L5
    L8:
        if ((r111 instanceof DownloadOutOfSpaceException) == false) goto L10;
        long r101 = ((DownloadOutOfSpaceException) r111).getRequiredSpaceBytes();
    L12:
        if (r100 >= r101) goto L39;
        DownloadSetting r102 = DownloadSetting.obtain(r110.getId());
        if (r102.optInt(DownloadSettingKeys.SPACE_FILL_PART_DOWNLOAD, 0) == 1) goto L16;
    L38:
        return false;
    L16:
        if (r100 <= 0) goto L37;
        int r103 = r102.optInt(DownloadSettingKeys.SPACE_FILL_MIN_KEEP_MB, 100);
        if (r103 <= 0) goto L39;
        long r104 = r100 - (((long) r103) * 1048576);
        if (Logger.debugScene(r110) == false) goto L31;
        StringBuilder r105 = new StringBuilder("Retry schedule: available = ");
        if (r100 <= 0) goto L24;
        boolean r106 = true;
    L25:
        r105.append(r106);
        r105.append(", minKeep = ");
        r105.append(r103);
        r105.append("MB, canDownload = ");
        if (r104 <= 0) goto L28;
        boolean r107 = true;
    L29:
        r105.append(r107);
        Logger.taskDebug(TAG, r110, "canRetryWhenInsufficientSpace", r105.toString());
        goto L31
    L28:
        r107 = false;
        goto L29
    L24:
        r106 = false;
    L31:
        if (r104 > 0) goto L39;
        if (Logger.debugScene(r110) == false) goto L35;
        Logger.taskDebug(TAG, r110, "canRetryWhenInsufficientSpace", "CanDownload <= 0 , canRetry = false");
    L35:
        return false;
    L37:
        if (r102.optInt(DownloadSettingKeys.DOWNLOAD_WHEN_SPACE_NEGATIVE, 0) != 1) goto L38;
    L39:
        return true;
    L10:
        r101 = r110.getTotalBytes() - r110.getCurBytes();
    L5:
        e = move-exception;
        e.printStackTrace();
        r100 = 0;
        goto L8
    }

    private void doScheduleAllTaskRetry(final int r100, final boolean r101) {
        DownloadComponentManager.getCPUThreadExecutor().execute(new AnonymousClass2(this, r100, r101));
    }

    private void scheduleAllTaskRetry(int r100, boolean r101) {
        if (this.mWaitingRetryTasksCount > 0) goto L5;
        return;
    L5:
        long r102 = System.currentTimeMillis();
        monitor-enter(this);
        if (r101 == false) goto L25;
    L12:
        this.mLastHandleAllTaskTime = r102;     // Catch: Throwable -> L22
        monitor-exit(this);     // Catch: Throwable -> L22
        if (Logger.debug() == false) goto L18;
        Logger.globalDebug(TAG, "scheduleAllTaskRetry", "level = [" + r100 + "], force = [" + r101 + "]");
    L18:
        if (r101 == false) goto L20;
        this.mHandler.removeMessages(0);
    L20:
        Message r103 = Message.obtain();
        r103.what = 0;
        r103.arg1 = r100;
        r103.arg2 = r101 ? 1 : 0;
        this.mHandler.sendMessageDelayed(r103, 2000);
        return;
    L25:
    L22:
        th = move-exception;
        throw th;
    L9:
        if ((r102 - this.mLastHandleAllTaskTime) >= 10000) goto L12;
        monitor-exit(this);     // Catch: Throwable -> L22
    }

    public static /* synthetic */ void access$200(RetrySchedulerImpl r100, int r101, boolean r102) {
        r100.scheduleAllTaskRetry(r101, r102);
    }

    private void doSchedulerRetryInSubThread(int r110, int r111, boolean r112) {
        Context r100 = this.mContext;
        if (r100 != null) goto L5;
        return;
    L5:
        SparseArray<RetryInfo> r101 = this.mRetryInfoList;
        monitor-enter(r101);
        RetryInfo r102 = this.mRetryInfoList.get(r110);     // Catch: Throwable -> L82
        if (r102 != null) goto L11;
        monitor-exit(r101);     // Catch: Throwable -> L82
        return;
    L11:
        boolean r103 = true;
        if (RetryInfo.access$500(r102) == false) goto L16;
        RetryInfo.access$502(r102, false);     // Catch: Throwable -> L82
        int r104 = this.mWaitingRetryTasksCount - 1;     // Catch: Throwable -> L82
        this.mWaitingRetryTasksCount = r104;     // Catch: Throwable -> L82
        if (r104 >= 0) goto L16;
        this.mWaitingRetryTasksCount = 0;     // Catch: Throwable -> L82
    L16:
        monitor-exit(r101);     // Catch: Throwable -> L82
        if (Logger.debug() == false) goto L20;
        Logger.taskDebug(TAG, r110, "doSchedulerRetryInSubThread", "RetryCount = " + RetryInfo.access$300(r102) + ", mWaitingRetryTasksCount = " + this.mWaitingRetryTasksCount);
    L20:
        DownloadInfo r105 = Downloader.getInstance(r100).getDownloadInfo(r110);
        if (r105 != null) goto L24;
        removeRetryInfo(r110);
        return;
    L24:
        int r106 = r105.getRealStatus();
        if (r106 != (-3)) goto L27;
    L80:
        removeRetryInfo(r110);
        return;
    L27:
        if (r106 == (-4)) goto L80;
        if (r106 == (-5)) goto L71;
        if (r106 != (-2)) goto L36;
        if (r105.isPauseReserveOnWifi() == true) goto L71;
    L36:
        if (r106 == (-1)) goto L38;
        return;
    L38:
        if (r111 == 0) goto L40;
        boolean r107 = true;
    L44:
        BaseException r108 = r105.getFailedException();
        if (r107 == true) goto L47;
    L49:
        r102.increaseRetryCount();
        if (r107 == true) goto L52;
        if (r112 == false) goto L63;
        r102.increaseRetryInterval();
    L63:
        if (r105.isOnlyWifi() == false) goto L65;
    L68:
        tryStartScheduleRetry(r105, r103, r111);
        return;
    L65:
        if (r105.isPauseReserveOnWifi() == true) goto L68;
        r103 = false;
        goto L68
    L52:
        if (Logger.debug() == false) goto L54;
        Logger.taskDebug(TAG, r110, "doSchedulerRetryInSubThread", "doSchedulerRetry: restart task, ****** id = " + r102.f449577id);
    L54:
        r102.updateRetryTimeStamp(System.currentTimeMillis());
        if (r112 == false) goto L57;
        r102.increaseRetryInterval();
    L57:
        r105.setRetryScheduleCount(RetryInfo.access$300(r102).get());
        if (r105.getStatus() != (-1)) goto L86;
        Downloader.getInstance(r100).restart(r105.getId());
        return;
    L86:
        return;
    L47:
        if (DownloadUtils.isInsufficientSpaceError(r108) == false) goto L49;
        r107 = canRetryWhenInsufficientSpace(r105, r108);
        goto L49
    L40:
        if (r102.useJobScheduler == false) goto L42;
        r107 = false;
        goto L44
    L42:
        return;
    L71:
        if (r106 != (-2)) goto L75;
        IReserveWifiStatusListener r113 = Downloader.getInstance(DownloadComponentManager.getAppContext()).getReserveWifiStatusListener();
        if (r113 == null) goto L75;
        r113.onStatusChanged(r105, 4, 3);
    L75:
        IDownloadLaunchHandler r114 = DownloadComponentManager.getDownloadLaunchHandler();
        if (r114 == null) goto L78;
        r114.onLaunchResume(Collections.singletonList(r105), 3);
    L78:
        removeRetryInfo(r110);
        return;
    L82:
        th = move-exception;
        throw th;
    }

    private void tryStartScheduleRetry(DownloadInfo r110, boolean r111, int r112) {
        BaseException r100 = r110.getFailedException();
        if (r100 != null) goto L5;
        return;
    L5:
        RetryInfo r101 = obtainRetryInfo(r110.getId());
        if (RetryInfo.access$300(r101).get() > r101.maxCount) goto L8;
        int r102 = r100.getErrorCode();
        if (DownloadUtils.isInsufficientSpaceError(r100) == false) goto L14;
    L25:
        RetryInfo.access$402(r101, r111);
        SparseArray<RetryInfo> r103 = this.mRetryInfoList;
        monitor-enter(r103);
    L48:
        th = move-exception;
        throw th;
    L28:
        if (RetryInfo.access$500(r101) == true) goto L30;
        RetryInfo.access$502(r101, true);     // Catch: Throwable -> L48
        this.mWaitingRetryTasksCount++;     // Catch: Throwable -> L48
    L30:
        monitor-exit(r103);     // Catch: Throwable -> L48
        int r104 = r101.getCurrentRetryIntervalMs();
        if (Logger.debugScene(r110) == false) goto L35;
        Logger.taskDebug(TAG, r110, "tryStartScheduleRetry", "Id = " + r101.f449577id + ", delayTimeMills = " + r104 + ", mWaitingRetryTasks = " + this.mWaitingRetryTasksCount);
    L35:
        if (r101.useJobScheduler == false) goto L44;
        if (r112 != 0) goto L38;
        r101.resetRetryInterval();
    L38:
        RetryScheduler.RetryScheduleHandler r105 = sRetryScheduleHandler;
        if (r105 == null) goto L42;
        r105.scheduleRetry(r110, r104, r111, r112);
    L42:
        if (this.mIsDownloaderProcess == false) goto L54;
        r101.updateRetryTimeStamp(System.currentTimeMillis());
        r101.increaseRetryCount();
        r101.increaseRetryInterval();
        return;
    L54:
        return;
    L44:
        if (r111 == false) goto L46;
        return;
    L46:
        this.mHandler.removeMessages(r110.getId());
        this.mHandler.sendEmptyMessageDelayed(r110.getId(), r104);
        return;
    L14:
        if (DownloadUtils.isNetworkError(r100) == true) goto L25;
        if (r110.statusInPause() == false) goto L20;
        if (r110.isPauseReserveOnWifi() == true) goto L25;
    L20:
        if (canRetryForAllowErrorCode(r101, r102) == true) goto L23;
        return;
    L23:
        if (Logger.debugScene(r110) == false) goto L25;
        Logger.taskDebug(TAG, r110, "tryStartScheduleRetry", "Allow error code, id = " + r101.f449577id + ", error code = " + r102);
        goto L25
    L8:
        if (Logger.debugScene(r110) == false) goto L53;
        Logger.taskDebug(TAG, r110, "tryStartScheduleRetry", "Id = " + r101.f449577id + ", mRetryCount = " + RetryInfo.access$300(r101) + ", maxCount = " + r101.maxCount);
        return;
    }

    public static /* synthetic */ void access$900(RetrySchedulerImpl r100, int r101, int r102, boolean r103) {
        r100.doSchedulerRetryInSubThread(r101, r102, r103);
    }
}
