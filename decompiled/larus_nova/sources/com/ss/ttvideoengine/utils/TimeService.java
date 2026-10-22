package com.ss.ttvideoengine.utils;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.ss.ttvideoengine.net.NetUtils;
import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: loaded from: classes35.dex */
public class TimeService {
    private static final int ERROR_COUNT = 6;
    private static final String TAG = "TimeService";
    private static final int TIMESERVICE_STATE_NOT_UPDATE = 0;
    private static final int TIMESERVICE_STATE_UPDATED = 2;
    private static final int TIMESERVICE_STATE_UPDATING = 1;
    private static int mErrorCount;
    private static boolean mForceUseLocalTime;
    private static String mNtpServer;
    private static int mState;
    private static TimeInfo mTimeInfo;

    public static class TimeInfo {
        private long mLocalTime;
        private long mNtpTime;

        public boolean isUpdated() {
            if (this.mNtpTime <= 0) goto L6;
            return true;
        L6:
            return false;
        }

        public TimeInfo() {
            this.mNtpTime = -1;
            this.mLocalTime = -1;
        }

        public static /* synthetic */ long access$000(TimeInfo r100) {
            return r100.mNtpTime;
        }

        public static /* synthetic */ long access$100(TimeInfo r100) {
            return r100.mLocalTime;
        }

        public static /* synthetic */ long access$002(TimeInfo r100, long r101) {
            r100.mNtpTime = r101;
            return r101;
        }

        public static /* synthetic */ long access$102(TimeInfo r100, long r101) {
            r100.mLocalTime = r101;
            return r101;
        }
    }

    public TimeService() {
    }

    static {
        mTimeInfo = new TimeInfo();
        mState = 0;
        mForceUseLocalTime = true;
        mErrorCount = 0;
    }

    public static /* synthetic */ int access$508() {
        int r100 = mErrorCount;
        mErrorCount = r100 + 1;
        return r100;
    }

    public static long currentTimeMillis() {
        if (mForceUseLocalTime == true) goto L19;
        monitor-enter(TimeService.class);
        TimeInfo r100 = mTimeInfo;     // Catch: Throwable -> L15
        if (r100 != null) goto L9;
    L13:
        monitor-exit(TimeService.class);     // Catch: Throwable -> L15
        goto L19
    L9:
        if (r100.isUpdated() == false) goto L13;
        long r101 = (TimeInfo.access$000(mTimeInfo) + SystemClock.elapsedRealtime()) - TimeInfo.access$100(mTimeInfo);     // Catch: Throwable -> L15
        monitor-exit(TimeService.class);     // Catch: Throwable -> L15
        return r101;
    L15:
        th = move-exception;
        throw th;
    L19:
        return System.currentTimeMillis();
    }

    public static boolean isUpdated() {
        monitor-enter(TimeService.class);
        TimeInfo r100 = mTimeInfo;     // Catch: Throwable -> L12
        if (r100 == null) goto L9;
        boolean r101 = r100.isUpdated();     // Catch: Throwable -> L12
        monitor-exit(TimeService.class);     // Catch: Throwable -> L12
        return r101;
    L9:
        monitor-exit(TimeService.class);     // Catch: Throwable -> L12
        return false;
    L12:
        th = move-exception;
        throw th;
    }

    public static /* synthetic */ String access$200() {
        return mNtpServer;
    }

    public static /* synthetic */ TimeInfo access$300() {
        return mTimeInfo;
    }

    public static /* synthetic */ int access$500() {
        return mErrorCount;
    }

    public static /* synthetic */ int access$402(int r100) {
        mState = r100;
        return r100;
    }

    public static void updateTimeFromNTP(final Context r100) {
        if (mForceUseLocalTime == false) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(mNtpServer) == false) goto L8;
        return;
    L8:
        monitor-enter(TimeService.class);
        TimeInfo r101 = mTimeInfo;     // Catch: Throwable -> L32
        if (r101 != null) goto L12;
    L15:
        if (r100 == null) goto L22;
        if (NetUtils.isNetAvailable(r100) == true) goto L22;
        TTVideoEngineLog.d(TAG, "network unavailable");     // Catch: Throwable -> L32
        monitor-exit(TimeService.class);     // Catch: Throwable -> L32
        return;
    L22:
        if (mState != 0) goto L30;
        mState = 1;     // Catch: Throwable -> L32
        if (mErrorCount <= 6) goto L27;
        monitor-exit(TimeService.class);     // Catch: Throwable -> L32
        return;
    L27:
        monitor-exit(TimeService.class);     // Catch: Throwable -> L32
        EngineThreadPool.addExecuteTask(new AnonymousClass1(r100));
        return;
    L30:
        monitor-exit(TimeService.class);     // Catch: Throwable -> L32
        return;
    L12:
        if (r101.isUpdated() == false) goto L15;
        monitor-exit(TimeService.class);     // Catch: Throwable -> L32
        return;
    L32:
        th = move-exception;
        throw th;
    }

    public static String longToStringWithFormat(long r100, String r101) {
        return new SimpleDateFormat(r101).format(new Date(r100));
    L4:
        return "";
    }

    public static void setForceUseLocalTime(boolean r100, String r101) {
        TTVideoEngineLog.d(TAG, "force use localtime:" + r100);
        mForceUseLocalTime = r100;
        mNtpServer = r101;
    }
}
