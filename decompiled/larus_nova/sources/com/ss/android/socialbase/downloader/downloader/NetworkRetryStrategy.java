package com.ss.android.socialbase.downloader.downloader;

import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public class NetworkRetryStrategy {
    private static final String TAG = "NetworkRetryStrategy";
    private List<Long> delayIntervalMs;
    private int mCurrentPeriodRetryCount;
    private int mCurrentRetryCount;
    private int mCurrentRetryResetCount;
    private long mCurrentRetryTime;
    private int mDownloadId;
    private boolean mEnabled;
    private int mPeriodRetryCountLimit;
    private int mRetryCountLimit;
    private long mRetryPeriodTime;
    private int mRetryResetCountLimit;
    private int mTotalRetryCount;

    private void delay() {
        if (this.delayIntervalMs.isEmpty() == false) goto L17;
        return;
    L17:
    L14:
        th = move-exception;
        Logger.taskError(TAG, this.mDownloadId, "delay", "Error:" + th.toString());
        th.printStackTrace();
        return;
    L6:
        if (this.mCurrentRetryCount < this.delayIntervalMs.size()) goto L8;
        List<Long> r100 = this.delayIntervalMs;     // Catch: Throwable -> L14
        long r101 = ((Long) ListProtector.get(r100, r100.size() - 1)).longValue();     // Catch: Throwable -> L14
    L10:
        if (Logger.debug() == false) goto L12;
        Logger.taskDebug(TAG, this.mDownloadId, "delay", "Sleep:" + r101);     // Catch: Throwable -> L14
    L12:
        Thread.sleep(r101);     // Catch: Throwable -> L14
        return;
    L8:
        r101 = ((Long) ListProtector.get(this.delayIntervalMs, this.mCurrentRetryCount)).longValue();     // Catch: Throwable -> L14
        goto L10
    }

    private boolean resetLimit() {
        int r100 = this.mRetryResetCountLimit;
        if (r100 > 0) goto L6;
        return false;
    L6:
        if (this.mCurrentRetryResetCount >= r100) goto L8;
        return false;
    L8:
        if (Logger.debug() == false) goto L13;
        Logger.taskDebug(TAG, this.mDownloadId, "resetLimit", "CurrentRetryResetCount:" + this.mCurrentRetryResetCount + " retryResetCountLimit:" + this.mRetryResetCountLimit);
        return true;
    L13:
        return true;
    }

    private boolean retryLimit() {
        if (this.mRetryPeriodTime > 0) goto L5;
    L22:
        return false;
    L5:
        if (this.mPeriodRetryCountLimit <= 0) goto L22;
        if (this.mCurrentRetryTime != 0) goto L11;
        this.mCurrentRetryTime = System.currentTimeMillis();
        return false;
    L11:
        long r100 = System.currentTimeMillis();
        if ((r100 - this.mCurrentRetryTime) < this.mRetryPeriodTime) goto L14;
        this.mCurrentRetryTime = System.currentTimeMillis();
        this.mCurrentPeriodRetryCount = 0;
        goto L22
    L14:
        if (this.mCurrentPeriodRetryCount > this.mPeriodRetryCountLimit) goto L16;
        return false;
    L16:
        if (Logger.debug() == false) goto L23;
        Logger.taskDebug(TAG, this.mDownloadId, "retryLimit", "CurrentPeriodRetryCount:" + this.mCurrentPeriodRetryCount + " periodRetryCountLimit:" + this.mPeriodRetryCountLimit + " currentRetryPeriodTime:" + (r100 - this.mCurrentRetryTime) + " retryPeriodTime:" + this.mRetryPeriodTime);
        return true;
    L23:
        return true;
    }

    public void doRetry() {
        if (this.mEnabled == true) goto L5;
        return;
    L5:
        delay();
        this.mCurrentRetryCount++;
        this.mCurrentPeriodRetryCount++;
        this.mTotalRetryCount++;
        if (Logger.debug() == false) goto L9;
        Logger.taskDebug(TAG, this.mDownloadId, "doRetry", "CurrentRetryCount:" + this.mCurrentRetryCount + " currentPeriodRetryCount:" + this.mCurrentPeriodRetryCount + " totalRetryCount:" + this.mTotalRetryCount);
        return;
    }

    public void reset() {
        if (resetLimit() == false) goto L7;
        this.mEnabled = false;
        return;
    L7:
        if (Logger.debug() == false) goto L9;
        Logger.taskDebug(TAG, this.mDownloadId, BasicTestActionHandler.TEST_ACTION_RESET, "Reset currentRetryResetCount");
    L9:
        this.mCurrentRetryResetCount++;
        this.mCurrentRetryCount = 0;
    }

    public int getTotalRetryCount() {
        return this.mTotalRetryCount;
    }

    public NetworkRetryStrategy(DownloadInfo r110) {
        this.mCurrentRetryCount = 0;
        this.mCurrentPeriodRetryCount = 0;
        this.mCurrentRetryTime = 0;
        this.mCurrentRetryResetCount = 0;
        this.mRetryCountLimit = 0;
        this.mPeriodRetryCountLimit = 0;
        this.mRetryPeriodTime = 0;
        this.mRetryResetCountLimit = 0;
        this.mTotalRetryCount = 0;
        this.mEnabled = false;
        this.delayIntervalMs = new ArrayList();
        this.mDownloadId = 0;
        initInternal(r110);     // Catch: Throwable -> L8
        if (Logger.debugScene(r110) == false) goto L13;
        StringBuilder r100 = new StringBuilder("Init retryCountLimit:");
    L7:
        r100.append(this.mRetryCountLimit);
        r100.append(" delayIntervalMs:");
        r100.append(this.delayIntervalMs.toString());
        r100.append(" retryPeriodTime:");
        r100.append(this.mRetryPeriodTime);
        r100.append(" periodRetryCountLimit:");
        r100.append(this.mPeriodRetryCountLimit);
        r100.append(" retryResetCountLimit:");
        r100.append(this.mRetryResetCountLimit);
        Logger.taskDebug(TAG, r110, TAG, r100.toString());
        return;
    L13:
        return;
    L8:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L14
        Logger.taskError(TAG, this.mDownloadId, TAG, "Init Error" + th.toString());     // Catch: Throwable -> L14
        if (Logger.debugScene(r110) == false) goto L24;
        r100 = new StringBuilder("Init retryCountLimit:");
        goto L7
    L24:
        return;
    L14:
        th = move-exception;
        if (Logger.debugScene(r110) == false) goto L18;
        Logger.taskDebug(TAG, r110, TAG, "Init retryCountLimit:" + this.mRetryCountLimit + " delayIntervalMs:" + this.delayIntervalMs.toString() + " retryPeriodTime:" + this.mRetryPeriodTime + " periodRetryCountLimit:" + this.mPeriodRetryCountLimit + " retryResetCountLimit:" + this.mRetryResetCountLimit);
    L18:
        throw th;
    }

    private void initInternal(DownloadInfo r100) throws Throwable {
        if (r100 == null) goto L5;
        int r101 = r100.getId();
        this.mDownloadId = r101;
        JSONObject r102 = DownloadSetting.obtain(r101).optJSONObject(DownloadSettingKeys.RETRY_STRATEGY);
    L6:
        if (r102 != null) goto L8;
        return;
    L8:
        int r103 = r102.optInt("retry_count");
        if (r103 <= 0) goto L11;
        this.mRetryCountLimit = r103;
    L11:
        JSONArray r104 = r102.optJSONArray(DownloadSettingKeys.RetryStrategy.KEY_DELAY_INTERVAL_MS);
        if (r104 != null) goto L14;
    L22:
        long r105 = r102.optLong(DownloadSettingKeys.RetryStrategy.KEY_RETRY_PERIOD_MS);
        if (r105 <= 0) goto L25;
        this.mRetryPeriodTime = r105;
    L25:
        int r106 = r102.optInt(DownloadSettingKeys.RetryStrategy.KEY_RETRY_COUNT_LIMIT_PERIOD);
        if (r106 <= 0) goto L28;
        this.mPeriodRetryCountLimit = r106;
    L28:
        int r107 = r102.optInt(DownloadSettingKeys.RetryStrategy.KEY_RETRY_RESET_COUNT_LIMIT);
        if (r107 <= 0) goto L32;
        this.mRetryResetCountLimit = r107;
    L32:
        if (this.mRetryCountLimit > 0) goto L34;
        return;
    L34:
        if (this.mRetryResetCountLimit <= 0) goto L41;
        this.mEnabled = true;
        return;
    L41:
        return;
    L14:
        if (r104.length() <= 0) goto L22;
        int r108 = 0;
    L17:
        if (r108 >= r104.length()) goto L22;
        long r109 = r104.optLong(r108);
        if (r109 <= 0) goto L21;
        this.delayIntervalMs.add(Long.valueOf(r109));
    L21:
        r108 = r108 + 1;
        goto L17
    L5:
        r102 = DownloadSetting.obtainGlobal().optJSONObject(DownloadSettingKeys.RETRY_STRATEGY);
        goto L6
    }

    public boolean canRetry(BaseException r100) {
        if (r100 == null) goto L22;
        if (this.mEnabled == false) goto L22;
        if (Logger.debug() == false) goto L11;
        Logger.taskDebug(TAG, this.mDownloadId, "canRetry", "CurrentRetryCount:" + this.mCurrentRetryCount + " retryCountLimit:" + this.mRetryCountLimit + " error:" + r100.getErrorCode());
    L11:
        if (retryLimit() == false) goto L15;
        this.mEnabled = false;
        return false;
    L15:
        if (this.mCurrentRetryCount < this.mRetryCountLimit) goto L17;
    L20:
        return false;
    L17:
        if (DownloadUtils.isNetworkError(r100) == false) goto L20;
        return true;
    L22:
        if (Logger.debug() == false) goto L24;
        Logger.taskDebug(TAG, this.mDownloadId, "canRetry", "Enabled: " + this.mEnabled);
    L24:
        return false;
    }
}
