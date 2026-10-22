package com.ss.videoarch.strategy.network;

import android.os.Handler;
import android.os.Looper;
import com.ss.videoarch.strategy.dataCenter.config.LSSettings;
import com.ss.videoarch.strategy.strategy.networkStrategy.SettingsManager;
import com.ss.videoarch.strategy.strategy.nodeOptimizer.DnsOptimizer;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes38.dex */
public class LSSettingsApi {
    static final String TAG = "LSSettingsApi";
    private long AUTO_RETRY_SYNC_INTERVAL;
    private int MAX_RETRY_TIMES;
    private long firstSendRequestTime;
    private final Set<Listener> listeners;
    private boolean mFirstCheckResponse;
    private Handler mHandler;
    private boolean mIsSyncing;
    private int mRetryTimes;
    private SettingsManager mSettingsManager;
    private final ThreadPoolApi mThreadPoolApi;
    private long sendRequestTime;

    public interface Listener {
        void onSettingsUpdated(String r100);
    }

    public void addListener(Listener r100) {
        this.listeners.add(r100);
    }

    public void removeListener(Listener r100) {
        this.listeners.remove(r100);
    }

    public void setHandler(Handler r100) {
        this.mHandler = r100;
    }

    public LSSettingsApi(ThreadPoolApi r100, HttpApi r101) {
        this.AUTO_RETRY_SYNC_INTERVAL = 10000;
        this.MAX_RETRY_TIMES = 5;
        this.mSettingsManager = SettingsManager.getInstance();
        this.listeners = new HashSet();
        this.mHandler = new Handler(Looper.getMainLooper());
        this.firstSendRequestTime = -1;
        this.sendRequestTime = -1;
        this.mFirstCheckResponse = true;
        this.mIsSyncing = false;
        this.mRetryTimes = 0;
        this.mThreadPoolApi = r100;
    }

    public static /* synthetic */ boolean access$002(LSSettingsApi r100, boolean r101) {
        r100.mIsSyncing = r101;
        return r101;
    }

    public void postHttpRequest(final String r100, final boolean r101) {
        if (this.mIsSyncing == false) goto L5;
        return;
    L5:
        int r102 = LSSettings.inst().mEnableNativeNodeOptimize;
        if (LSSettings.inst().mEnableNativeNodeOptimize != 1) goto L8;
        return;
    L8:
        this.mIsSyncing = true;
        if (r101 == false) goto L11;
        sendRequest(r100, r101);
        return;
    L11:
        this.mThreadPoolApi.execute(new AnonymousClass1(this, r100, r101));
    }

    public void sendRequest(final String r100, final boolean r110) {
        this.AUTO_RETRY_SYNC_INTERVAL = LSSettings.inst().mAutoRetrySyncInterval;
        this.MAX_RETRY_TIMES = LSSettings.inst().mMaxRetryTimes;
        int r101 = LSSettings.inst().mEnableNativeNodeOptimize;
        final boolean[] r102 = {false};
        this.sendRequestTime = System.currentTimeMillis();
        SettingsManager.ResponseData r103 = this.mSettingsManager.sendRequest(r100);
        DnsOptimizer.inst().mResponseStatusCode = r103.statusCode;
        DnsOptimizer.inst().mResponseCost = (int) (System.currentTimeMillis() - this.sendRequestTime);
        r103.responseCost = (int) (System.currentTimeMillis() - this.sendRequestTime);
        r102[0] = LSSettings.inst().init(r103);
        if (r110 == false) goto L5;
        this.mIsSyncing = false;
        checkResponse(r102, r100, r110);
        return;
    L5:
        this.mHandler.post(new AnonymousClass2(this, r102, r100, r110));
    }

    private void checkResponse(boolean[] r100, String r101, boolean r102) {
        int r103 = LSSettings.inst().mEnableNativeNodeOptimize;
        if (r100[0] == true) goto L11;
        int r104 = this.mRetryTimes + 1;
        this.mRetryTimes = r104;
        if (r104 <= this.MAX_RETRY_TIMES) goto L8;
        DnsOptimizer.inst().mRetryFailStopSchedule = true;
        return;
    L8:
        scheduleAutoPostHttpRequest(this.AUTO_RETRY_SYNC_INTERVAL, r101, r102);
        return;
    L11:
        if (this.mFirstCheckResponse == false) goto L15;
        DnsOptimizer r105 = DnsOptimizer.inst();
        r105.mFirstResponseCost = (int) (System.currentTimeMillis() - this.firstSendRequestTime);
        this.mFirstCheckResponse = false;
        if (LSSettings.inst().mGetHotDomains != 1) goto L15;
        scheduleAutoPostHttpRequest(((long) LSSettings.inst().mCommonConfigInfo.mLSStrategySDKSettings.mHotDomainTTL) * 1000, r101, r102);
    L15:
        this.mRetryTimes = 0;
        Iterator<Listener> r106 = this.listeners.iterator();
    L17:
        if (r106.hasNext() == false) goto L19;
        r106.next().onSettingsUpdated(r101);
        goto L17
    }

    private void scheduleAutoPostHttpRequest(long r100, final String r101, final boolean r102) {
        int r103 = LSSettings.inst().mEnableNativeNodeOptimize;
        this.mHandler.removeCallbacksAndMessages(null);
        this.mHandler.postDelayed(new AnonymousClass3(this, r101, r102), r100);
    }

    public static /* synthetic */ void access$100(LSSettingsApi r100, boolean[] r101, String r102, boolean r103) {
        r100.checkResponse(r101, r102, r103);
    }
}
