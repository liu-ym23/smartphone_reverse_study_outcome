package com.ss.ttvideoengine.portrait;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadTimer;
import com.ss.ttvideoengine.TTNetWorkListener;
import com.ss.ttvideoengine.info.networkRTTLevelListener;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes34.dex */
public class NetworkPortraitData {
    private static final int MIN_NETWORK_DATA_MS = 120000;
    private static final String NET_PORTRAIT_DATA = "net-portrait-data";
    private static final String TAG = "NetworkPortraitData";
    private List<Integer> mCatowerRttList;
    private List<Integer> mCatowerRttMsList;
    private Map<Long, Float> mMdlSpeedList;
    private volatile int mNetLevelMaxCount;
    private volatile int mNetMinDataSize;
    private volatile int mNetTimerTaskIntervalMs;
    private networkRTTLevelListener mRTTLevelListener;
    private List<String> mSignalStrengthList;
    private Timer mTimer;
    private TimerTask mTimerTask;

    /* JADX INFO: renamed from: com.ss.ttvideoengine.portrait.NetworkPortraitData$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public class MyTimerTask extends TimerTask {
        final /* synthetic */ NetworkPortraitData this$0;

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            com_ss_ttvideoengine_portrait_NetworkPortraitData$MyTimerTask_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_ss_ttvideoengine_portrait_NetworkPortraitData$MyTimerTask__run$___twin___() {
            int r100 = this.this$0.getNetworkRTTLevel();
            int r101 = this.this$0.getNetworkRTTMS();
            String r102 = TTNetWorkListener.getInstance().getSignalStrength();
            monitor-enter(this);
        L10:
            th = move-exception;
            throw th;
        L5:
            if (NetworkPortraitData.access$100(this.this$0).size() < NetworkPortraitData.access$200(this.this$0)) goto L7;
            NetworkPortraitData.access$100(this.this$0).remove(0);     // Catch: Throwable -> L10
            NetworkPortraitData.access$300(this.this$0).remove(0);     // Catch: Throwable -> L10
            NetworkPortraitData.access$400(this.this$0).remove(0);     // Catch: Throwable -> L10
        L7:
            NetworkPortraitData.access$100(this.this$0).add(Integer.valueOf(r100));     // Catch: Throwable -> L10
            NetworkPortraitData.access$300(this.this$0).add(Integer.valueOf(r101));     // Catch: Throwable -> L10
            NetworkPortraitData.access$400(this.this$0).add(r102);     // Catch: Throwable -> L10
            monitor-exit(this);     // Catch: Throwable -> L10
        }

        private MyTimerTask(NetworkPortraitData r100) {
            this.this$0 = r100;
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_ss_ttvideoengine_portrait_NetworkPortraitData$MyTimerTask_com_larus_apm_impl_protector_RunnableLancet_run(MyTimerTask r100) {
            r100.com_ss_ttvideoengine_portrait_NetworkPortraitData$MyTimerTask__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public /* synthetic */ MyTimerTask(NetworkPortraitData r100, AnonymousClass1 r101) {
            this(r100);
        }
    }

    public synchronized void stop() {
        monitor-enter(this);
        Timer r100 = this.mTimer;     // Catch: Throwable -> L11
        if (r100 == null) goto L6;
        r100.cancel();     // Catch: Throwable -> L11
        this.mTimer = null;     // Catch: Throwable -> L11
    L6:
        TimerTask r101 = this.mTimerTask;     // Catch: Throwable -> L11
        if (r101 == null) goto L9;
        r101.cancel();     // Catch: Throwable -> L11
        this.mTimerTask = null;     // Catch: Throwable -> L11
    L9:
        monitor-exit(this);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public List<Float> getMdlSeepList() {
        Map<Long, Float> r100 = this.mMdlSpeedList;
        if (r100 != null) goto L5;
        return null;
    L5:
        if (r100.isEmpty() == false) goto L8;
        return null;
    L8:
        return new ArrayList(this.mMdlSpeedList.values());
    }

    public int getNetworkRTTLevel() {
        networkRTTLevelListener r100 = this.mRTTLevelListener;
        if (r100 != null) goto L5;
        return -1;
    L5:
        return r100.onNetworkLog();
    }

    public int getNetworkRTTMS() {
        networkRTTLevelListener r100 = this.mRTTLevelListener;
        if (r100 != null) goto L5;
        return -1;
    L5:
        return r100.getNetworkRTTMs();
    }

    public synchronized void start() {
        monitor-enter(this);
    L30:
        th = move-exception;
        throw th;
    L5:
        if (this.mNetTimerTaskIntervalMs > 0) goto L9;
        TTVideoEngineLog.e(TAG, "invalid parameter");     // Catch: Throwable -> L30
        monitor-exit(this);
        return;
    L9:
        List<Integer> r100 = this.mCatowerRttList;     // Catch: Throwable -> L30
        List<Integer> r101 = Collections.EMPTY_LIST;     // Catch: Throwable -> L30
        if (r100 != r101) goto L13;
        this.mCatowerRttList = new ArrayList();     // Catch: Throwable -> L30
    L13:
        if (this.mCatowerRttMsList != r101) goto L16;
        this.mCatowerRttMsList = new ArrayList();     // Catch: Throwable -> L30
    L16:
        if (this.mSignalStrengthList != r101) goto L19;
        this.mSignalStrengthList = new ArrayList();     // Catch: Throwable -> L30
    L19:
        if (this.mMdlSpeedList != Collections.EMPTY_MAP) goto L21;
        this.mMdlSpeedList = new LinkedHashMap();     // Catch: Throwable -> L30
    L21:
        TimerTask r102 = this.mTimerTask;     // Catch: Throwable -> L30
        if (r102 == null) goto L25;
        r102.cancel();     // Catch: Throwable -> L30
    L25:
        if (this.mTimer != null) goto L27;
        this.mTimer = new PthreadTimer(NET_PORTRAIT_DATA);     // Catch: Throwable -> L30
    L27:
        MyTimerTask r103 = new MyTimerTask(this, null);     // Catch: Throwable -> L30
        this.mTimerTask = r103;     // Catch: Throwable -> L30
        this.mTimer.schedule(r103, 500, this.mNetTimerTaskIntervalMs);     // Catch: Throwable -> L30
        TTVideoEngineLog.d(TAG, "network timer task scheduled, interval " + this.mNetTimerTaskIntervalMs);     // Catch: Throwable -> L30
        monitor-exit(this);
    }

    public NetworkPortraitData() {
        this.mCatowerRttList = Collections.emptyList();
        this.mCatowerRttMsList = Collections.emptyList();
        this.mSignalStrengthList = Collections.emptyList();
        this.mMdlSpeedList = Collections.emptyMap();
        this.mNetLevelMaxCount = 100;
        this.mNetTimerTaskIntervalMs = 0;
        this.mNetMinDataSize = 120000;
    }

    public List<Integer> getRttList() {
        return this.mCatowerRttList;
    }

    public List<String> getSignalStrengthList() {
        return this.mSignalStrengthList;
    }

    public static /* synthetic */ List access$100(NetworkPortraitData r100) {
        return r100.mCatowerRttList;
    }

    public static /* synthetic */ int access$200(NetworkPortraitData r100) {
        return r100.mNetLevelMaxCount;
    }

    public static /* synthetic */ List access$300(NetworkPortraitData r100) {
        return r100.mCatowerRttMsList;
    }

    public static /* synthetic */ List access$400(NetworkPortraitData r100) {
        return r100.mSignalStrengthList;
    }

    public List<Float> getNetSpeedHistoryData(int r100) {
        return getSubListToMeetMinSize(new ArrayList(this.mMdlSpeedList.values()), r100);
    L5:
        return new ArrayList();
    }

    public List<Integer> getRttHistoryData(int r100) {
        return getSubListToMeetMinSize(this.mCatowerRttList, r100);
    }

    public List<Integer> getRttMsHistoryData(int r100) {
        return getSubListToMeetMinSize(this.mCatowerRttMsList, r100);
    }

    public void setMaxCount(int r100) {
        if (r100 >= 0) goto L5;
        return;
    L5:
        if (r100 >= 10) goto L7;
        r100 = 10;
    L7:
        this.mNetLevelMaxCount = r100;
    }

    public void setMinDataSize(int r100) {
        this.mNetMinDataSize = r100;
    }

    public void setNetSpeed(float r100) {
        Map<Long, Float> r101 = this.mMdlSpeedList;     // Catch: Exception -> L9
        if (r101 != Collections.EMPTY_MAP) goto L5;
        return;
    L5:
        if (r101.size() <= this.mNetLevelMaxCount) goto L7;
        Long r102 = this.mMdlSpeedList.keySet().iterator().next();     // Catch: Exception -> L9
        this.mMdlSpeedList.remove(r102);     // Catch: Exception -> L9
    L7:
        this.mMdlSpeedList.put(Long.valueOf(System.currentTimeMillis()), Float.valueOf(r100));     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        TTVideoEngineLog.e(TAG, e.getMessage());
    }

    public void setNetworkRTTLevelListener(networkRTTLevelListener r100) {
        this.mRTTLevelListener = r100;
    }

    public void setSampleInterval(int r100) {
        if (r100 >= 0) goto L5;
        return;
    L5:
        if (r100 >= 500) goto L7;
        r100 = 500;
    L7:
        this.mNetTimerTaskIntervalMs = r100;
    }

    private <T> List<T> getSubListToMeetMinSize(List<T> r100, int r101) {
        if (this.mNetTimerTaskIntervalMs == 0) goto L5;
        int r102 = (this.mNetMinDataSize / this.mNetTimerTaskIntervalMs) - r101;
        if (r102 > 0) goto L11;
        return new ArrayList();
    L11:
        if (r102 <= r100.size()) goto L15;
        return new ArrayList(r100);
    L15:
        return r100.subList(r100.size() - r102, r100.size());
    L5:
        return new ArrayList();
    }

    public synchronized void schedule(TimerTask r100, int r101) {
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (this.mTimer != null) goto L7;
        this.mTimer = new PthreadTimer(NET_PORTRAIT_DATA);     // Catch: Throwable -> L16
    L7:
        Timer r102 = this.mTimer;     // Catch: Throwable -> L16
        if (r101 > 0) goto L10;
        r101 = this.mNetTimerTaskIntervalMs;     // Catch: Throwable -> L16
    L10:
        r102.schedule(r100, 1000, r101);     // Catch: Throwable -> L16
        if (this.mTimerTask != null) goto L13;
        MyTimerTask r103 = new MyTimerTask(this, null);     // Catch: Throwable -> L16
        this.mTimerTask = r103;     // Catch: Throwable -> L16
        this.mTimer.schedule(r103, 1000, this.mNetTimerTaskIntervalMs);     // Catch: Throwable -> L16
    L13:
        TTVideoEngineLog.d(TAG, "network timer task scheduled, interval " + this.mNetTimerTaskIntervalMs);     // Catch: Throwable -> L16
        monitor-exit(this);
    }
}
