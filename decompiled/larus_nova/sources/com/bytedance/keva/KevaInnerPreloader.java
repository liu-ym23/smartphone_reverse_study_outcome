package com.bytedance.keva;

import android.os.Looper;
import android.util.Pair;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes3.dex */
public class KevaInnerPreloader {
    public static final String COLLECT_REPO_NAME = "keva_sdk_collect_repo";
    public static final boolean ENABLE_LOG = true;
    public static final String KEY_LAUNCH_COUNT = "key_launch_count";
    public static final String KEY_LAUNCH_PREFIX = "key_preload_launch_cost_prefix_";
    public static final String KEY_VERSION = "key_preload_version";
    public static final int LAUNCH_COUNTS = 3;
    private static final int MAX_LAUNCH_COUNT = 7;
    private static final long MODE_MASK = Long.MIN_VALUE;
    public static final String RESULT_REPO_NAME = "keva_sdk_result_repo";
    public static final String TAG = "KevaInnerPreloader";
    private static final long TIME_MASK = Long.MAX_VALUE;
    private final ConcurrentHashMap<String, ModeTimeAndCost> mCollectRepoStampMap;
    private final ArrayList<String> mConflictRepoList;
    private int mCurrentLaunchCount;
    private final AtomicBoolean mLaunchMarked;
    private long mMainThreadTotalCost;
    private HashMap<String, Long> mNameCostMap;
    private final int mPreloadLevel;
    private int mResultVersion;
    private final AtomicLong mSubThreadTotalCost;
    private final int mThreshold;
    private final int mTimeMsPreloadDelay;
    private final int mTimeMsToAvoidCollide;
    private final int mVersion;

    /* JADX INFO: loaded from: classes19.dex */
    public static class CollectRepoHolder {
        static final KevaImpl sInstance = null;

        public CollectRepoHolder() {
        }

        static {
            KevaPrivateImpl r100 = new KevaPrivateImpl(KevaInnerPreloader.COLLECT_REPO_NAME, null, 0);
            sInstance = r100;
            r100.init(true);
        }
    }

    /* JADX INFO: loaded from: classes19.dex */
    public static class ModeTimeAndCost {
        static final long AFTER_INIT_CAP = 9999;
        static final long COST_CAP = 127;
        long afterInit;
        long cost;
        int mode;

        private long capAfterInit(long r100) {
            if (r100 >= 0) goto L6;
            return 0;
        L6:
            if (r100 > AFTER_INIT_CAP) goto L8;
            return r100;
        L8:
            return AFTER_INIT_CAP;
        }

        private long capCost(long r100) {
            if (r100 >= 0) goto L6;
            return 0;
        L6:
            if (r100 > COST_CAP) goto L8;
            return r100;
        L8:
            return COST_CAP;
        }

        public ModeTimeAndCost(int r100, long r101, long r102) {
            this.mode = r100;
            this.afterInit = capAfterInit(r101);
            this.cost = capCost(r102);
        }
    }

    /* JADX INFO: loaded from: classes19.dex */
    public static class ResultRepoHolder {
        static final KevaImpl sInstance = null;

        public ResultRepoHolder() {
        }

        static {
            KevaPrivateImpl r100 = new KevaPrivateImpl(KevaInnerPreloader.RESULT_REPO_NAME, null, 0);
            sInstance = r100;
            r100.init(true);
        }
    }

    private static void KevaLog(String r100) {
    }

    public static /* synthetic */ void a(String r100, int r101, long r102) {
        lambda$doPreload$0(r100, r101, r102);
    }

    private static long absDiff(long r100, long r101) {
        if (r100 <= r101) goto L6;
        return r100 - r101;
    L6:
        return r101 - r100;
    }

    private static long combineModeAndTime(int r100, long r101) {
        long r102 = ((long) r100) << 63;
        return r102 | (r101 & Long.MAX_VALUE);
    }

    private static int getMode(long r100) {
        return (int) (r100 >>> 63);
    }

    private static long getTime(long r100) {
        return r100 & Long.MAX_VALUE;
    }

    private long updateCompactTime(int r100, long r101, long r110, long r111) {
        int r102 = (3 - r100) * 21;
        int r103 = r102 + 21;
        long r112 = r111 & (((-1) << r103) | (~((1 << r103) - (1 << r102))));
        return (((r101 & 16383) | ((r110 & 127) << 14)) << r102) | r112;
    }

    private long updateMode(long r100, int r101) {
        boolean r102 = true;
        if ((r101 & 1) != 0) goto L6;
        r102 = false;
    L6:
        if (r102 == false) goto L10;
        return r100 | Long.MIN_VALUE;
    L10:
        return r100 & Long.MAX_VALUE;
    }

    public void doPreload() {
        KevaImpl r100 = ResultRepoHolder.sInstance;
        this.mResultVersion = r100.getInt(KEY_VERSION, 0);
        this.mCurrentLaunchCount = r100.getInt(KEY_LAUNCH_COUNT, 0) + 1;
        KevaLog("result v=" + this.mResultVersion + ", currentCount=" + this.mCurrentLaunchCount);
        if (this.mResultVersion == this.mVersion) goto L5;
        return;
    L5:
        Map<String, ?> r101 = r100.getAll();
        r101.remove(KEY_VERSION);
        r101.remove(KEY_LAUNCH_COUNT);
        ScheduledExecutorService r102 = PThreadExecutorsUtils.newSingleThreadScheduledExecutor(new DefaultThreadFactory(TAG));
        ArrayList r103 = new ArrayList(r101.entrySet());
        Collections.sort(r103, new AnonymousClass3(this));
        Iterator r104 = r103.iterator();
    L7:
        if (r104.hasNext() == false) goto L9;
        Map.Entry r105 = (Map.Entry) r104.next();
        final String r106 = (String) r105.getKey();
        long r107 = ((Long) r105.getValue()).longValue();
        final int r108 = getMode(r107);
        final long r109 = getTime(r107);
        r102.schedule(new b(r106, r108, r109), r109, TimeUnit.MILLISECONDS);
        goto L7
    L9:
        r102.shutdown();
    }

    public void markPreloadDone() {
        if (this.mLaunchMarked.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        final long r100 = System.currentTimeMillis() - KevaImpl.sInitStamp;
        KevaImpl.sExecutor.execute(new AnonymousClass1(this, r100));
    }

    public KevaInnerPreloader(KevaBuilder r100) {
        this.mCollectRepoStampMap = new ConcurrentHashMap();
        this.mLaunchMarked = new AtomicBoolean(false);
        this.mSubThreadTotalCost = new AtomicLong(0);
        this.mConflictRepoList = new ArrayList();
        this.mThreshold = r100.mTimeMsLoadThreshold;
        this.mPreloadLevel = r100.mPercentPreloadBuffer;
        this.mVersion = r100.mUpdateVersionCode / r100.mVersionMask;
        this.mTimeMsPreloadDelay = r100.mTimeMsPreloadDelay;
        this.mTimeMsToAvoidCollide = r100.mTimeMsToAvoidCollide;
    }

    public static /* synthetic */ int access$100(KevaInnerPreloader r100) {
        return r100.mCurrentLaunchCount;
    }

    public static /* synthetic */ long access$200(KevaInnerPreloader r100) {
        return r100.mMainThreadTotalCost;
    }

    public static /* synthetic */ AtomicLong access$300(KevaInnerPreloader r100) {
        return r100.mSubThreadTotalCost;
    }

    public static /* synthetic */ HashMap access$400(KevaInnerPreloader r100) {
        return r100.mNameCostMap;
    }

    public static /* synthetic */ ArrayList access$500(KevaInnerPreloader r100) {
        return r100.mConflictRepoList;
    }

    public static /* synthetic */ long access$600(long r100) {
        return getTime(r100);
    }

    private static long average(long[] r100) {
        int r101 = r100.length;
        long r102 = 0;
        int r103 = 0;
    L3:
        if (r103 >= r101) goto L6;
        r102 = r102 + r100[r103];
        r103 = r103 + 1;
        goto L3
    L6:
        return r102 / ((long) r100.length);
    }

    private int calculateLaunchCount(long[] r100) {
        int r101 = r100.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L9;
        if (r100[r102] == 0) goto L7;
        r102 = r102 + 1;
        goto L3
    L7:
        return r102 + 1;
    L9:
        return 3;
    }

    private void collectAndProduceResult(long r210) {
        KevaImpl r100 = CollectRepoHolder.sInstance;
        KevaImpl r110 = ResultRepoHolder.sInstance;
        String r111 = KEY_VERSION;
        int r101 = r100.getInt(KEY_VERSION, 0);
        int r102 = this.mVersion;
        String r112 = KEY_LAUNCH_COUNT;
        if (r101 >= r102) goto L5;
        r100.clear();
        r100.storeInt(KEY_VERSION, this.mVersion);
    L16:
        long[] r113 = new long[3];
        int r103 = 0;
    L18:
        if (r103 >= 3) goto L20;
        r113[r103] = r100.getLong(KEY_LAUNCH_PREFIX + r103, 0);
        r103 = r103 + 1;
        goto L18
    L20:
        int r114 = calculateLaunchCount(r113);
        r110.storeInt(KEY_LAUNCH_COUNT, r114);
        int r104 = r114 - 1;
        r113[r104] = r210;
        r100.storeLong(KEY_LAUNCH_PREFIX + r104, r210);
        KevaLog("collect v=" + this.mVersion + ", 此次启动耗时:" + r210 + ", L1:" + r113[0] + ", L2:" + r113[1] + ", L3:" + r113[2] + ", 启动次数:" + r114);
        Map<String, ?> r105 = r100.getAll();
        HashMap r106 = new HashMap();
        Iterator<Map.Entry<String, ?>> r107 = r105.entrySet().iterator();
    L22:
        if (r107.hasNext() == false) goto L29;
        Map.Entry<String, ?> r108 = r107.next();
        String r109 = r108.getKey();
        if (r109.equals(KEY_VERSION) == true) goto L22;
        if (r109.startsWith(KEY_LAUNCH_PREFIX) == true) goto L22;
        r106.put(r109, Long.valueOf(((Long) r108.getValue()).longValue()));
        goto L22
    L29:
        Set<Map.Entry<String, ModeTimeAndCost>> r115 = this.mCollectRepoStampMap.entrySet();
        this.mNameCostMap = new HashMap();
        Iterator<Map.Entry<String, ModeTimeAndCost>> r116 = r115.iterator();
    L31:
        if (r116.hasNext() == false) goto L40;
        Map.Entry<String, ModeTimeAndCost> r117 = r116.next();
        String r118 = r117.getKey();
        int r119 = r117.getValue().mode;
        long r120 = r117.getValue().afterInit;
        long r121 = r117.getValue().cost;
        this.mNameCostMap.put(r118, Long.valueOf(r121));
        if (r106.containsKey(r118) == false) goto L38;
        long r122 = ((Long) r106.get(r118)).longValue();
        long r211 = r121;
        int r123 = r119;
        HashMap r124 = r106;
        String r125 = r118;
        long r126 = updateCompactTime(r114, r120, r211, r122);
        if (r123 <= getMode(r122)) goto L37;
        KevaLog("误用降级: " + r125 + ", 此次=" + r123 + ", 历史mode=" + getMode(r122));
        r126 = updateMode(r126, r123);
    L37:
        r124.put(r125, Long.valueOf(r126));
    L39:
        KevaLog("存, repo=" + r125 + ", ini=" + r120 + ", cost=" + r211 + ", mode=" + r123);
        r106 = r124;
        r112 = r112;
        r111 = r111;
        goto L31
    L38:
        r211 = r121;
        r123 = r119;
        r124 = r106;
        r125 = r118;
        r124.put(r125, Long.valueOf(initCompactTimeAndMode(r114, r120, r211, r123)));
        goto L39
    L40:
        String r212 = r111;
        String r213 = r112;
        Set r127 = r106.entrySet();
        Iterator r128 = r127.iterator();
    L42:
        if (r128.hasNext() == false) goto L45;
        Map.Entry r129 = (Map.Entry) r128.next();
        r100.storeLong((String) r129.getKey(), ((Long) r129.getValue()).longValue());
        goto L42
    L45:
        if (r114 >= 3) goto L47;
        return;
    L47:
        List<Pair<String, ModeTimeAndCost>> r130 = new ArrayList();
        Iterator r131 = r127.iterator();
    L49:
        if (r131.hasNext() == false) goto L51;
        populateAvgList(r130, (Map.Entry) r131.next());
        goto L49
    L51:
        ArrayList r132 = new ArrayList();
        long r133 = average(r113);
        arrangePreload(r130, r132, this.mPreloadLevel, r133 - averageAbsDiff(r113, r133));
        r110.clear();
        Iterator r134 = r132.iterator();
    L53:
        if (r134.hasNext() == false) goto L55;
        Pair r135 = (Pair) r134.next();
        r110.storeLong((String) r135.first, ((Long) r135.second).longValue());
        goto L53
    L55:
        r110.storeInt(r212, this.mVersion);
        r110.storeInt(r213, 3);
        r100.clear();
        r100.storeInt(r212, this.mVersion);
        System.out.println("break point");
        return;
    L5:
        if (r101 == r102) goto L7;
        return;
    L7:
        if (this.mCurrentLaunchCount <= 3) goto L16;
        Set<Map.Entry<String, ModeTimeAndCost>> r136 = this.mCollectRepoStampMap.entrySet();
        this.mNameCostMap = new HashMap();
        Iterator<Map.Entry<String, ModeTimeAndCost>> r137 = r136.iterator();
    L10:
        if (r137.hasNext() == false) goto L12;
        Map.Entry<String, ModeTimeAndCost> r138 = r137.next();
        this.mNameCostMap.put(r138.getKey(), Long.valueOf(r138.getValue().cost));
        goto L10
    L12:
        int r139 = this.mCurrentLaunchCount;
        if (r139 >= 7) goto L72;
        r110.storeInt(KEY_LAUNCH_COUNT, r139);
        return;
    }

    public static /* synthetic */ void access$000(KevaInnerPreloader r100, long r101) {
        r100.collectAndProduceResult(r101);
    }

    private static long averageAbsDiff(long[] r100, long r101) {
        int r102 = r100.length;
        long r103 = 0;
        int r104 = 0;
    L3:
        if (r104 >= r102) goto L6;
        r103 = r103 + absDiff(r100[r104], r101);
        r104 = r104 + 1;
        goto L3
    L6:
        return r103 / ((long) r100.length);
    }

    private void populateAvgList(List<Pair<String, ModeTimeAndCost>> r110, Map.Entry<String, Long> r111) {
        long r100 = getTime(r111.getValue().longValue());
        long r101 = 0;
        int r102 = 0;
        long r103 = 0;
        long r104 = 0;
        int r105 = 1;
    L4:
        if (r105 >= 4) goto L11;
        long r112 = (r100 >> ((3 - r105) * 21)) & 4194303;
        long r113 = 16383 & r112;
        long r114 = (r112 >> 14) & 127;
        if (r113 <= r101) goto L10;
        if (r114 <= r101) goto L10;
        r103 = r103 + r113;
        r104 = r104 + r114;
        r102 = r102 + 1;
    L10:
        KevaLog("取, repo=" + r111.getKey() + ", 启动次数=" + r105 + ", ini=" + r113 + ", cost=" + r114 + ", mode=" + getMode(r111.getValue().longValue()));
        r105 = r105 + 1;
        r101 = 0;
        goto L4
    L11:
        if (r102 <= 1) goto L18;
        long r106 = r102;
        r110.add(new Pair(r111.getKey(), new ModeTimeAndCost(getMode(r111.getValue().longValue()), r103 / r106, (r104 / r106) + 1)));
        return;
    }

    private static /* synthetic */ void lambda$doPreload$0(String r100, int r101, long r102) {
        Keva.getRepoSync(r100, r101);
        KevaLog("preload " + r100 + ", mode=" + r101 + ", delay " + r102 + " ms");
    }

    private void arrangePreload(List<Pair<String, ModeTimeAndCost>> r110, List<Pair<String, Long>> r210, int r211, long r212) {
        int r100 = r211;
        if (r100 >= 1) goto L5;
        return;
    L5:
        if (r100 >= 10) goto L24;
        long r101 = this.mTimeMsPreloadDelay;
        Collections.sort(r110, new AnonymousClass2(this));
        Iterator<Pair<String, ModeTimeAndCost>> r102 = r110.iterator();
    L9:
        if (r102.hasNext() == false) goto L25;
        Pair<String, ModeTimeAndCost> r103 = r102.next();
        Object r104 = r103.second;
        long r105 = (((ModeTimeAndCost) r104).afterInit * ((long) r100)) / 10;
        long r111 = ((ModeTimeAndCost) r104).cost;
        String r106 = (String) r103.first;
        long r112 = r101 + r111;
        Iterator<Pair<String, ModeTimeAndCost>> r113 = r102;
        if (r112 <= r105) goto L15;
        KevaLog("放弃预加载: " + r106 + ", start=" + r105 + ", current=" + r101 + ", cost=" + r111);
        this.mConflictRepoList.add(r106);
    L13:
        r102 = r113;
        r100 = r211;
        goto L9
    L15:
        if (r112 > r212) goto L16;
        r210.add(new Pair(r106, Long.valueOf(combineModeAndTime(((ModeTimeAndCost) r103.second).mode, r101))));
        r101 = r101 + (r111 + ((long) this.mTimeMsToAvoidCollide));
        goto L13
    L16:
        KevaLog("放弃预加载: " + r106 + ", start=" + r105 + ", current=" + r101 + ", cost=" + r111 + ", latestTiming=" + r212);
        this.mConflictRepoList.add(r106);
        return;
    L25:
        return;
    }

    private long initCompactTimeAndMode(int r100, long r110, long r111, int r112) {
        return updateMode(updateCompactTime(r100, r110, r111, 0), r112);
    }

    public void onObtain(String r100, int r110, long r111, long r112) {
        if (r112 > this.mThreshold) goto L5;
        return;
    L5:
        if (this.mLaunchMarked.get() == false) goto L7;
        return;
    L7:
        if (this.mResultVersion == this.mVersion) goto L9;
    L10:
        this.mCollectRepoStampMap.putIfAbsent(r100, new ModeTimeAndCost(r110, r111, r112));
        if (Looper.myLooper() != Looper.getMainLooper()) goto L13;
        boolean r101 = true;
    L14:
        if (r101 == false) goto L16;
        this.mMainThreadTotalCost += r112;
        return;
    L16:
        this.mSubThreadTotalCost.addAndGet(r112);
        return;
    L13:
        r101 = false;
        goto L14
    L9:
        if (this.mCurrentLaunchCount < 7) goto L10;
    }
}
