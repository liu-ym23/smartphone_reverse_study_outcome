package com.bytedance.keva;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import android.os.Looper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
abstract class KevaImpl extends Keva implements Keva.ClearMemory {
    static final boolean sEnableExecutorOpt = false;
    static final Executor sExecutor = null;
    private static final boolean sGetRepoLockOpt = false;
    static final int sInitRepoOpt = 0;
    static final long sInitStamp = 0;
    private static final boolean sMainThreadPriorityOpt = false;
    static final KevaMonitor sMonitor = null;
    private static final ConcurrentHashMap<String, ConcurrentHashMap<String, Object>> sPathRepoMap = null;
    private static final String sPortedSpRepoName = null;
    static final KevaInnerPreloader sPreloader = null;
    private static final int sPriorityValue = 0;
    private static final int sRepoIdleReleaseMainThreadThreshold = 0;
    private static final Set<String> sRepoIdleReleaseWhiteList = null;
    private static final ConcurrentHashMap<String, Object> sRepoMap = null;
    private static final File sSharedPrefsDir = null;
    protected int mBigValueAccessIndex;
    private final List<Keva.OnChangeListener> mChangeListeners;
    private volatile boolean mDisableIdleRelease;
    private List<KevaValueWrapper> mDuplicatedOldWrappers;
    volatile long mHandle;
    private final boolean mIsMultiProcess;
    private volatile int mLastAccessIndex;
    private int mLastClearAccessIndex;
    private int mLastTryClearIndex;
    private int mMainThreadAccessAfterClearCount;
    private final int mMode;
    private final String mName;
    private volatile boolean mNeedRebuildValueMap;
    private boolean mPendingMainThreadAccessAfterClear;
    private String mSpecifiedPath;
    volatile HashMap<String, KevaValueWrapper> mValueMap;

    public static class KevaValueWrapper {
        int accessIndex;
        volatile boolean loaded;
        volatile long offset;
        volatile int type;
        volatile Object value;

        public KevaValueWrapper() {
        }
    }

    public static native void checkReportException(long r0);

    private static native void clear(long r0);

    private static native boolean delete(String r0);

    private native void dump(long r1);

    private native void erase(long r1, String r3, long r4);

    private native void eraseUnusedChunk(long r1, long r3);

    public static void forceInitImpl() {
    }

    private static native void initialize(String r0);

    private native long loadRepo(String r1, int r2, boolean r3);

    private native long loadRepoWithPath(String r1, String r2, int r3);

    private native int protectPortingInterProcess(String r1, boolean r2, int r3);

    private native long storeBoolean(long r1, String r3, long r4, boolean r6);

    private native long storeBytes(long r1, String r3, long r4, byte[] r6, int r7);

    private native long storeDouble(long r1, String r3, long r4, double r6);

    private native long storeFloat(long r1, String r3, long r4, float r6);

    private native long storeInt(long r1, String r3, long r4, int r6);

    private native long storeLong(long r1, String r3, long r4, long r6);

    private native long storeString(long r1, String r3, long r4, String r6);

    private native long storeStringArray(long r1, String r3, long r4, String[] r6, int r7);

    @Override // com.bytedance.keva.Keva
    public void clear() {
        monitor-enter(this);
        onRepoAccessLocked();     // Catch: Throwable -> L11
        this.mValueMap.clear();     // Catch: Throwable -> L6
        clear(this.mHandle);     // Catch: Throwable -> L6
    L9:
        monitor-exit(this);     // Catch: Throwable -> L11
        return;
    L6:
        th = move-exception;
        sMonitor.reportThrowable(4, this.mName, null, null, th);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public native boolean contains(long r1, String r3, long r4);

    public void dumpNative() {
        monitor-enter(this);
        dump(this.mHandle);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public native boolean fetchBoolean(long r1, String r3, long r4, boolean r6);

    public abstract boolean fetchBoolean(String r1, boolean r2);

    public native byte[] fetchBytes(long r1, String r3, long r4, byte[] r6, int r7);

    public abstract byte[] fetchBytes(String r1, byte[] r2, int r3, boolean r4);

    public native double fetchDouble(long r1, String r3, long r4, double r6);

    public abstract double fetchDouble(String r1, double r2);

    public native float fetchFloat(long r1, String r3, long r4, float r6);

    public abstract float fetchFloat(String r1, float r2);

    public native int fetchInt(long r1, String r3, long r4, int r6);

    public abstract int fetchInt(String r1, int r2);

    public native long fetchLong(long r1, String r3, long r4, long r6);

    public abstract long fetchLong(String r1, long r2);

    public native String fetchString(long r1, String r3, long r4, String r6);

    public abstract String fetchString(String r1, String r2, boolean r3);

    public native String[] fetchStringArray(long r1, String r3, long r4, String[] r6, int r7);

    public abstract String[] fetchStringArray(String r1, String[] r2, boolean r3);

    public native void rebuildValueMap(long r1);

    private void cleanUpAfterLoadRepo() {
        if (this.mHandle != 0) goto L14;
        sMonitor.reportWarning(1, this.mName, null, null, "free space is " + Environment.getDataDirectory().getFreeSpace());
        return;
    L14:
        Iterator<KevaValueWrapper> r0 = this.mDuplicatedOldWrappers.iterator();     // Catch: Throwable -> L11
    L7:
        if (r0.hasNext() == false) goto L9;
        eraseUnusedChunk(this.mHandle, r0.next().offset);     // Catch: Throwable -> L11
        goto L7
    L9:
        this.mDuplicatedOldWrappers = null;     // Catch: Throwable -> L11
        checkReportException(this.mHandle);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        sMonitor.reportThrowable(1, this.mName, null, null, th);
    }

    public static int clearIdleRepoMemory() {
        ArrayList r0 = new ArrayList();
        ConcurrentHashMap<String, Object> r1 = sRepoMap;
        monitor-enter(r1);
        r0.addAll(r1.values());     // Catch: Throwable -> L26
        monitor-exit(r1);     // Catch: Throwable -> L26
        Iterator<ConcurrentHashMap<String, Object>> r2 = sPathRepoMap.values().iterator();
    L8:
        if (r2.hasNext() == false) goto L17;
        ConcurrentHashMap<String, Object> r3 = r2.next();
        monitor-enter(r3);
        r0.addAll(r3.values());     // Catch: Throwable -> L14
        monitor-exit(r3);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    L17:
        Iterator r4 = r0.iterator();
        int r5 = 0;
    L19:
        if (r4.hasNext() == false) goto L25;
        Object r6 = r4.next();
        if ((r6 instanceof KevaImpl) == false) goto L19;
        if (((KevaImpl) r6).tryClearValueMapIfIdle() == false) goto L19;
        r5 = r5 + 1;
        goto L19
    L25:
        return r5;
    L26:
        th = move-exception;
        throw th;
    }

    private void innerRebuildValueMap() {
        rebuildValueMap(this.mHandle);
    }

    public static void markPreloadDone() {
        KevaInnerPreloader r0 = sPreloader;
        if (r0 == null) goto L6;
        r0.markPreloadDone();
        return;
    }

    private boolean tryClearValueMapIfIdle() {
        if (this.mHandle != 0) goto L6;
        return false;
    L6:
        if (this.mDisableIdleRelease == false) goto L8;
        return false;
    L8:
        Set<String> r0 = sRepoIdleReleaseWhiteList;
        if (r0.isEmpty() == false) goto L11;
    L14:
        int r1 = this.mLastAccessIndex;
        if (this.mLastTryClearIndex >= r1) goto L18;
        this.mLastTryClearIndex = r1;
        return false;
    L18:
        monitor-enter(this);
    L26:
        th = move-exception;
        throw th;
    L20:
        if (this.mNeedRebuildValueMap == false) goto L23;
        monitor-exit(this);     // Catch: Throwable -> L26
        return false;
    L23:
        this.mValueMap = new HashMap();     // Catch: Throwable -> L26
        this.mNeedRebuildValueMap = true;     // Catch: Throwable -> L26
        this.mPendingMainThreadAccessAfterClear = true;     // Catch: Throwable -> L26
        this.mLastTryClearIndex = this.mLastAccessIndex;     // Catch: Throwable -> L26
        monitor-exit(this);     // Catch: Throwable -> L26
        return true;
    L11:
        if (r0.contains(this.mName) == false) goto L14;
        this.mDisableIdleRelease = true;
        return false;
    }

    @Override // com.bytedance.keva.Keva
    public void dump() {
        monitor-enter(this);
        sMonitor.logDebug("start dumping keva " + this.mName + ", size=" + this.mValueMap.size());     // Catch: Throwable -> L11
        Iterator<Map.Entry<String, KevaValueWrapper>> r0 = this.mValueMap.entrySet().iterator();     // Catch: Throwable -> L11
    L6:
        if (r0.hasNext() == false) goto L8;
        Map.Entry<String, KevaValueWrapper> r1 = r0.next();     // Catch: Throwable -> L11
        KevaValueWrapper r2 = r1.getValue();     // Catch: Throwable -> L11
        String r3 = r1.getKey();     // Catch: Throwable -> L11
        sMonitor.logDebug("key: " + r3 + ", value: " + r2.value + ", offset: " + r2.offset + ", loaded: " + r2.loaded);     // Catch: Throwable -> L11
        goto L6
    L8:
        sMonitor.logDebug("finish dumping keva " + this.mName + ", size=" + this.mValueMap.size());     // Catch: Throwable -> L11
        monitor-exit(this);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public final void onRepoAccessLocked() {
        this.mLastAccessIndex++;
        if (this.mPendingMainThreadAccessAfterClear == false) goto L12;
        if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()) != ThreadMethodProxy.currentThread()) goto L8;
        this.mMainThreadAccessAfterClearCount++;
    L8:
        if (this.mMainThreadAccessAfterClearCount < sRepoIdleReleaseMainThreadThreshold) goto L10;
        this.mDisableIdleRelease = true;
    L10:
        this.mPendingMainThreadAccessAfterClear = false;
    L12:
        if (this.mNeedRebuildValueMap == true) goto L14;
        return;
    L14:
        if (this.mHandle == 0) goto L23;
        this.mValueMap.clear();     // Catch: Throwable -> L17
        innerRebuildValueMap();     // Catch: Throwable -> L17
        checkReportException(this.mHandle);     // Catch: Throwable -> L17
        this.mNeedRebuildValueMap = false;     // Catch: Throwable -> L17
        return;
    L17:
        th = move-exception;
        sMonitor.reportThrowable(2, this.mName, null, null, th);
        return;
    }

    static {
        KevaBuilder r0 = KevaBuilder.getInstance();
        KevaBuilder.clearInstance();
        sRepoMap = new ConcurrentHashMap();
        sPathRepoMap = new ConcurrentHashMap();
        Executor r1 = r0.mExecutor;
        if (r1 == null) goto L5;
        sExecutor = r1;
    L6:
        String r2 = r0.mPortedRepoName;
        if (r2 != null) goto L10;
        r2 = "keva_porting_sp";
    L10:
        sPortedSpRepoName = r2;
        Context r3 = r0.mContext;
        File r4 = r3.getFilesDir();
        if (r4 != null) goto L14;
        r4 = new PolarisFileWrapper(r3.getApplicationInfo().dataDir, "files");
    L14:
        if (r4.exists() == true) goto L16;
        r4.mkdirs();
    L16:
        File r5 = r0.mWorkDir;
        if (r5 != null) goto L19;
        r5 = new PolarisFileWrapper(r4, "keva");
    L19:
        sSharedPrefsDir = new PolarisFileWrapper(r4.getParent(), "shared_prefs");
        KevaMonitor r6 = r0.mMonitor;
        if (r6 != null) goto L23;
        r6 = new KevaMonitor();
    L23:
        sMonitor = r6;
        r6.logDebug("Keva version: 1.6.10.SHARED.CXXAPI-alpha.39");
        if (r5.exists() == false) goto L26;
    L28:
        sEnableExecutorOpt = r0.mEnableExecutorOpt;
        sMainThreadPriorityOpt = r0.mMainThreadPriorityOpt;
        sPriorityValue = r0.mPriorityValue;
        sGetRepoLockOpt = r0.mGetRepoLockOpt;
        sInitRepoOpt = r0.mInitRepoOpt;
        sRepoIdleReleaseMainThreadThreshold = Math.max(1, r0.mRepoIdleReleaseMainThreadThreshold);
        Set<String> r7 = r0.mRepoIdleReleaseWhiteList;
        if (r7 != null) goto L31;
    L32:
        r7 = Collections.emptySet();
    L33:
        sRepoIdleReleaseWhiteList = r7;
        r6.loadLibrary("keva");     // Catch: Throwable -> L36
        initialize(r5.getAbsolutePath());     // Catch: Throwable -> L36
    L39:
        if (r0.mTimeMsLoadThreshold == 0) goto L41;
        KevaInnerPreloader r8 = new KevaInnerPreloader(r0);
        sPreloader = r8;
        Executor r9 = sExecutor;
        Objects.requireNonNull(r8);
        r9.execute(new a(r8));
    L42:
        sInitStamp = System.currentTimeMillis();
        return;
    L41:
        sPreloader = null;
    L36:
        th = move-exception;
        th.printStackTrace();
        KevaMonitor r10 = sMonitor;
        r10.logDebug("fail to load so and init");
        r10.reportThrowable(1, null, null, null, th);
        goto L39
    L31:
        if (r7.isEmpty() == false) goto L33;
    L26:
        if (r5.mkdirs() == true) goto L28;
        r6.reportThrowable(1, null, null, null, new IllegalStateException("fail to create work dir " + r5.getPath()));
        goto L28
    L5:
        int r11 = Math.max(Runtime.getRuntime().availableProcessors() * 2, 6);
        PThreadPoolExecutor r12 = new PThreadPoolExecutor(r11, r11, 30, TimeUnit.SECONDS, new LinkedBlockingQueue(), new DefaultThreadFactory("keva/KevaImpl"));
        r12.allowCoreThreadTimeOut(true);
        sExecutor = r12;
        goto L6
    }

    private static Keva getPortedSpRepo() {
        return PortedSpRepoHolder.access$100();
    }

    public static /* synthetic */ String access$000() {
        return sPortedSpRepoName;
    }

    public static /* synthetic */ int access$200() {
        return sPriorityValue;
    }

    @Override // com.bytedance.keva.Keva
    public String name() {
        return this.mName;
    }

    public static /* synthetic */ String access$500(KevaImpl r0) {
        return r0.mName;
    }

    public static void clearOnLowMemory(int r4) {
        ArrayList r0 = new ArrayList();
        ConcurrentHashMap<String, Object> r1 = sRepoMap;
        monitor-enter(r1);
        r0.addAll(r1.values());     // Catch: Throwable -> L24
        monitor-exit(r1);     // Catch: Throwable -> L24
        Iterator<ConcurrentHashMap<String, Object>> r2 = sPathRepoMap.values().iterator();
    L8:
        if (r2.hasNext() == false) goto L17;
        ConcurrentHashMap<String, Object> r3 = r2.next();
        monitor-enter(r3);
        r0.addAll(r3.values());     // Catch: Throwable -> L14
        monitor-exit(r3);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    L17:
        Iterator r5 = r0.iterator();
    L19:
        if (r5.hasNext() == false) goto L23;
        Object r6 = r5.next();
        if ((r6 instanceof Keva.ClearMemory) == false) goto L19;
        ((Keva.ClearMemory) r6).clearMemory(r4);
        goto L19
    L23:
        return;
    L24:
        th = move-exception;
        throw th;
    }

    private void doLoadRepo(boolean r7) {
        String r0 = this.mSpecifiedPath;     // Catch: Throwable -> L11
        if (r0 != null) goto L5;
        this.mHandle = loadRepo(this.mName, this.mMode, r7);     // Catch: Throwable -> L11
    L6:
        cleanUpAfterLoadRepo();     // Catch: Throwable -> L11
        if (r7 == false) goto L9;
        return;
    L9:
        sMonitor.onLoadRepo(this.mName, this.mMode);     // Catch: Throwable -> L11
        return;
    L5:
        this.mHandle = loadRepoWithPath(this.mName, r0, this.mMode);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        sMonitor.reportThrowable(1, this.mName, null, null, th);
    }

    private void doPortingFromSp(Context r21) {
        monitor-enter(this);
    L80:
        th = move-exception;
        throw th;
    L5:
        if (this.mHandle == 0) goto L8;
        monitor-exit(this);     // Catch: Throwable -> L80
        return;
    L8:
        boolean r10 = this instanceof KevaMultiProcessImpl;     // Catch: Throwable -> L80
        if (r10 == false) goto L16;
        int r3 = protectPortingInterProcess(this.mName, true, -1);     // Catch: Throwable -> L80
        if (isRepoPorted(this.mName) == false) goto L15;
        doLoadRepo(false);     // Catch: Throwable -> L80
        protectPortingInterProcess(this.mName, false, r3);     // Catch: Throwable -> L80
        monitor-exit(this);     // Catch: Throwable -> L80
        return;
    L15:
        int r13 = r3;
    L17:
        if (r10 == false) goto L19;
    L21:
        boolean r4 = false;
    L22:
        KevaMonitor r5 = sMonitor;     // Catch: Throwable -> L80
        r5.logDebug("poring load empty repo >> " + this.mName);     // Catch: Throwable -> L80
        doLoadRepo(false);     // Catch: Throwable -> L80
        if (this.mHandle != 0) goto L26;
        monitor-exit(this);     // Catch: Throwable -> L80
        return;
    L26:
        if (r4 == true) goto L28;
        clear();     // Catch: Throwable -> L80
    L28:
        SharedPreferences r2 = r21.getSharedPreferences(this.mName, 0);     // Catch: Throwable -> L80
        r5.logDebug("poring get sp >> " + this.mName);     // Catch: Throwable -> L80
        Map<String, ?> r1 = r2.getAll();     // Catch: Throwable -> L80
        r5.logDebug("poring get all value >> " + this.mName);     // Catch: Throwable -> L80
        Iterator<Map.Entry<String, ?>> r14 = r1.entrySet().iterator();     // Catch: Throwable -> L80
    L30:
        if (r14.hasNext() == false) goto L74;
        Map.Entry<String, ?> r0 = r14.next();     // Catch: Throwable -> L80
        String r6 = r0.getKey();     // Catch: Throwable -> L80
        Object r15 = r0.getValue();     // Catch: Throwable -> L80
        if (r15 == null) goto L30;
        if (XmlPullParser.NO_NAMESPACE.equals(r6) == false) goto L37;
        String r7 = null;
    L38:
        KevaMonitor r8 = sMonitor;     // Catch: Throwable -> L80
        r8.logDebug("poring process key: " + r7 + ", value: " + r15 + " >> " + this.mName);     // Catch: Throwable -> L80
        KevaValueWrapper r9 = new KevaValueWrapper();     // Catch: Throwable -> L80
        this.mValueMap.put(r7, r9);     // Catch: Throwable -> L80
    L69:
        th = th;
    L72:
        sMonitor.reportThrowable(3, this.mName, r7, r15, th);     // Catch: Throwable -> L80
        goto L30
    L40:
        if ((r15 instanceof Boolean) == false) goto L44;
        r9.offset = storeBoolean(this.mHandle, r7, r9.offset, ((Boolean) r15).booleanValue());     // Catch: Throwable -> L67
        r9.value = r15;     // Catch: Throwable -> L67
    L61:
        if (this.mIsMultiProcess == true) goto L64;
        r9.loaded = true;     // Catch: Throwable -> L67
    L64:
        if (this.mIsMultiProcess == false) goto L30;
        r9.value = null;     // Catch: Throwable -> L67
    L67:
        th = th;
        goto L72
    L44:
        String r17 = r7;
        if ((r15 instanceof Integer) == false) goto L48;
        r9.offset = storeInt(this.mHandle, r17, r9.offset, ((Integer) r15).intValue());     // Catch: Throwable -> L67
        r9.value = r15;     // Catch: Throwable -> L67
        goto L61
    L48:
        if ((r15 instanceof Long) == false) goto L51;
        r9.offset = storeLong(this.mHandle, r17, r9.offset, ((Long) r15).longValue());     // Catch: Throwable -> L67
        r9.value = r15;     // Catch: Throwable -> L67
        goto L61
    L51:
        if ((r15 instanceof Float) == false) goto L54;
        r9.offset = storeFloat(this.mHandle, r17, r9.offset, ((Float) r15).floatValue());     // Catch: Throwable -> L67
        r9.value = r15;     // Catch: Throwable -> L67
        goto L61
    L54:
        if ((r15 instanceof String) == false) goto L57;
        r9.offset = storeString(this.mHandle, r17, r9.offset, (String) r15);     // Catch: Throwable -> L67
        r9.value = r15;     // Catch: Throwable -> L67
        goto L61
    L57:
        if ((r15 instanceof Set) == false) goto L59;
        Set r11 = (Set) r15;     // Catch: Throwable -> L67
        String[] r12 = new String[r11.size()];     // Catch: Throwable -> L67
        r11.toArray(r12);     // Catch: Throwable -> L67
        r9.offset = storeStringArray(this.mHandle, r17, r9.offset, r12, 3);     // Catch: Throwable -> L67
        r9.value = r12;     // Catch: Throwable -> L67
        goto L61
    L59:
        r8.reportThrowable(1, this.mName, r17, r15, new IllegalStateException("do not support type: " + r15.getClass()));     // Catch: Throwable -> L67
        goto L61
    L37:
        r7 = r6;
        goto L38
    L74:
        getPortedSpRepo().storeBoolean(this.mName, true);     // Catch: Throwable -> L80
        if (r10 == false) goto L77;
        protectPortingInterProcess(this.mName, false, r13);     // Catch: Throwable -> L80
    L77:
        monitor-exit(this);     // Catch: Throwable -> L80
        sMonitor.logDebug("poring set ported repo >> " + this.mName);
        return;
    L19:
        if (delete(this.mName) == false) goto L21;
        r4 = true;
        goto L22
    L16:
        r13 = -1;
        goto L17
    }

    private static boolean existSharedPrefs(String r3) {
        return new PolarisFileWrapper(sSharedPrefsDir, r3 + ".xml").exists();
    }

    public static boolean isRepoPorted(String r2) {
        if (PortedSpRepoHolder.access$400().get(r2) == null) goto L7;
        return true;
    L7:
        return getPortedSpRepo().getBoolean(r2, false);
    }

    private KevaValueWrapper obtainWrapperLocked(String r3) {
        KevaValueWrapper r0 = this.mValueMap.get(r3);
        if (r0 != null) goto L6;
        KevaValueWrapper r1 = new KevaValueWrapper();
        this.mValueMap.put(r3, r1);
        return r1;
    L6:
        return r0;
    }

    @Override // com.bytedance.keva.Keva
    public Map<String, Object> buildNewMap(Map<String, Object> r13) {
        if (r13 != KevaConstants.FLAG_CURRENT_KEY_MAP) goto L11;
        monitor-enter(this);
        onRepoAccessLocked();     // Catch: Throwable -> L8
        HashMap r14 = (HashMap) this.mValueMap.clone();     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        return r14;
    L8:
        th = move-exception;
        throw th;
    L11:
        monitor-enter(this);
        onRepoAccessLocked();     // Catch: Throwable -> L74
        Iterator<Map.Entry<String, KevaValueWrapper>> r0 = this.mValueMap.entrySet().iterator();     // Catch: Throwable -> L74
    L14:
        if (r0.hasNext() == false) goto L72;
        Map.Entry<String, KevaValueWrapper> r1 = r0.next();     // Catch: Throwable -> L74
        KevaValueWrapper r2 = r1.getValue();     // Catch: Throwable -> L74
        if (r2.offset == 0) goto L14;
        String r3 = r1.getKey();     // Catch: Throwable -> L74
    L69:
        th = move-exception;
        sMonitor.reportThrowable(2, this.mName, r3, Long.valueOf(r2.offset), th);     // Catch: Throwable -> L74
        goto L14
    L20:
        if (r2.loaded == true) goto L59;
        int r4 = r2.type;     // Catch: Throwable -> L69
        if (r4 == 23) goto L57;
        if (r4 == 39) goto L57;
        if (r4 == 55) goto L52;
        switch(r4) {
            case 1: goto L50;
            case 2: goto L47;
            case 3: goto L44;
            case 4: goto L41;
            case 5: goto L38;
            case 6: goto L36;
            case 7: goto L35;
            default: goto L29;
        };     // Catch: Throwable -> L69
    L35:
        r2.value = fetchBytes(this.mHandle, r3, r2.offset, null, 0);     // Catch: Throwable -> L69
    L54:
        if (this.mIsMultiProcess == true) goto L59;
        r2.loaded = true;     // Catch: Throwable -> L69
        goto L59
    L36:
        r2.value = fetchString(this.mHandle, r3, r2.offset, null);     // Catch: Throwable -> L69
        goto L54
    L29:
        if (this.mIsMultiProcess == false) goto L34;
        if (r2.type <= 5) goto L54;
    L34:
        throw new UnsupportedOperationException("keva has not implemented type " + r2.type);     // Catch: Throwable -> L69
    L38:
        if (this.mIsMultiProcess == false) goto L54;
        r2.value = Double.valueOf(fetchDouble(this.mHandle, r3, r2.offset, 0.0d));     // Catch: Throwable -> L69
        goto L54
    L41:
        if (this.mIsMultiProcess == false) goto L54;
        r2.value = Float.valueOf(fetchFloat(this.mHandle, r3, r2.offset, 0.0f));     // Catch: Throwable -> L69
        goto L54
    L44:
        if (this.mIsMultiProcess == false) goto L54;
        r2.value = Long.valueOf(fetchLong(this.mHandle, r3, r2.offset, 0));     // Catch: Throwable -> L69
        goto L54
    L47:
        if (this.mIsMultiProcess == false) goto L54;
        r2.value = Boolean.valueOf(fetchBoolean(this.mHandle, r3, r2.offset, false));     // Catch: Throwable -> L69
        goto L54
    L50:
        if (this.mIsMultiProcess == false) goto L54;
        r2.value = Integer.valueOf(fetchInt(this.mHandle, r3, r2.offset, 0));     // Catch: Throwable -> L69
        goto L54
    L52:
        r2.value = fetchStringArray(this.mHandle, r3, r2.offset, null, 3);     // Catch: Throwable -> L69
    L57:
        throw new UnsupportedOperationException("keva has not implemented type " + r2.type);     // Catch: Throwable -> L69
    L59:
        if (this.mIsMultiProcess == false) goto L61;
    L65:
        r13.put(r3, r2.value);     // Catch: Throwable -> L69
        if (this.mIsMultiProcess == false) goto L14;
        r2.value = null;     // Catch: Throwable -> L69
        goto L14
    L61:
        if (r2.type != 6) goto L63;
    L64:
        int r5 = this.mBigValueAccessIndex + 1;     // Catch: Throwable -> L69
        this.mBigValueAccessIndex = r5;     // Catch: Throwable -> L69
        r2.accessIndex = r5;     // Catch: Throwable -> L69
        goto L65
    L63:
        if ((r2.type & 7) == 0) goto L65;
    L72:
        monitor-exit(this);     // Catch: Throwable -> L74
        return r13;
    L74:
        th = move-exception;
        throw th;
    }

    public void checkMode(int r9) {
        if (this.mHandle != 0) goto L6;
        return;
    L6:
        if (this.mMode == r9) goto L9;
        sMonitor.reportThrowable(1, this.mName, null, null, new IllegalStateException("mode is different: " + this.mMode + " != " + r9));
        return;
    }

    @Override // com.bytedance.keva.Keva.ClearMemory
    public void clearMemory(int r5) {
        if (this.mIsMultiProcess == false) goto L5;
        return;
    L5:
        monitor-enter(this);
        if (r5 != 0) goto L30;
        int r6 = Integer.MAX_VALUE;
    L9:
        Iterator<KevaValueWrapper> r0 = this.mValueMap.values().iterator();     // Catch: Throwable -> L27
    L11:
        if (r0.hasNext() == false) goto L24;
        KevaValueWrapper r1 = r0.next();     // Catch: Throwable -> L27
        if (r1 == null) goto L11;
        if (r1.loaded == false) goto L11;
        int r2 = r1.accessIndex;     // Catch: Throwable -> L27
        if (r2 == 0) goto L11;
        if (r2 > r6) goto L11;
        if (r1.type == 6) goto L23;
        if ((r1.type & 7) != 7) goto L11;
    L23:
        r1.value = null;     // Catch: Throwable -> L27
        r1.loaded = false;     // Catch: Throwable -> L27
        goto L11
    L24:
        this.mLastClearAccessIndex = this.mBigValueAccessIndex;     // Catch: Throwable -> L27
        monitor-exit(this);     // Catch: Throwable -> L27
        return;
    L27:
        th = move-exception;
        throw th;
    L30:
        r6 = this.mLastClearAccessIndex;     // Catch: Throwable -> L27
        goto L9
    }

    @Override // com.bytedance.keva.Keva
    public void erase(String r11) {
        if (XmlPullParser.NO_NAMESPACE.equals(r11) == false) goto L5;
        r11 = null;
    L5:
        monitor-enter(this);
        onRepoAccessLocked();     // Catch: Throwable -> L28
        KevaValueWrapper r0 = this.mValueMap.remove(r11);     // Catch: Throwable -> L23
        if (r0 != null) goto L10;
        long r6 = 0;
    L12:
        if (this.mIsMultiProcess == false) goto L14;
    L17:
        erase(this.mHandle, r11, r6);     // Catch: Throwable -> L23
        if (r0 == null) goto L26;
        r0.value = null;     // Catch: Throwable -> L23
        r0.offset = 0;     // Catch: Throwable -> L23
        if (this.mIsMultiProcess == true) goto L26;
        r0.loaded = true;     // Catch: Throwable -> L23
    L26:
        monitor-exit(this);     // Catch: Throwable -> L28
        return;
    L14:
        if (r6 != 0) goto L17;
        monitor-exit(this);     // Catch: Throwable -> L28
        return;
    L10:
        r6 = r0.offset;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        sMonitor.reportThrowable(4, this.mName, r11, null, th);     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        throw th;
    }

    public void init(boolean r6) {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.mHandle == 0) goto L7;
        monitor-exit(this);     // Catch: Throwable -> L10
        return;
    L7:
        doLoadRepo(r6);     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
    }

    @Override // com.bytedance.keva.Keva
    public void registerChangeListener(Keva.OnChangeListener r2) {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.mChangeListeners.contains(r2) == true) goto L6;
        this.mChangeListeners.add(r2);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);     // Catch: Throwable -> L8
    }

    @Override // com.bytedance.keva.Keva
    public void unRegisterChangeListener(Keva.OnChangeListener r2) {
        monitor-enter(this);
        this.mChangeListeners.remove(r2);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public static /* synthetic */ void access$300(KevaImpl r0, Context r1) {
        r0.doPortingFromSp(r1);
    }

    public static Keva getRepo(String r2, int r3) {
        return getRepoImpl(r2, null, r3, false);
    }

    public static Keva getRepoSync(String r2, int r3) {
        return getRepoImpl(r2, null, r3, true);
    }

    private void notifyChangeListeners(Keva r3, String r4) {
        if (this.mChangeListeners.size() != 0) goto L5;
        return;
    L5:
        Iterator<Keva.OnChangeListener> r0 = this.mChangeListeners.iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        r0.next().onChanged(r3, r4);
        goto L7
    }

    @Override // com.bytedance.keva.Keva
    public boolean getBoolean(String r7, boolean r8) {
        if (XmlPullParser.NO_NAMESPACE.equals(r7) == false) goto L5;
        r7 = null;
    L5:
        String r3 = r7;
        monitor-enter(this);
        onRepoAccessLocked();     // Catch: Throwable -> L15
        boolean r9 = fetchBoolean(r3, r8);     // Catch: Throwable -> L11
        monitor-exit(this);     // Catch: Throwable -> L15
        return r9;
    L11:
        th = move-exception;
        sMonitor.reportThrowable(2, this.mName, r3, null, th);     // Catch: Throwable -> L15
        return r8;
    L15:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.keva.Keva
    public byte[] getBytes(String r7, byte[] r8) {
        if (XmlPullParser.NO_NAMESPACE.equals(r7) == false) goto L5;
        r7 = null;
    L5:
        String r3 = r7;
        monitor-enter(this);
        onRepoAccessLocked();     // Catch: Throwable -> L16
        byte[] r9 = fetchBytes(r3, r8, 0, false);     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L16
        return r9;
    L12:
        th = move-exception;
        sMonitor.reportThrowable(2, this.mName, r3, r8, th);     // Catch: Throwable -> L16
        return r8;
    L16:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.keva.Keva
    public byte[] getBytesJustDisk(String r7, byte[] r8) {
        if (XmlPullParser.NO_NAMESPACE.equals(r7) == false) goto L5;
        r7 = null;
    L5:
        String r3 = r7;
        monitor-enter(this);
        onRepoAccessLocked();     // Catch: Throwable -> L16
        byte[] r9 = fetchBytes(r3, r8, 0, true);     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L16
        return r9;
    L12:
        th = move-exception;
        sMonitor.reportThrowable(2, this.mName, r3, r8, th);     // Catch: Throwable -> L16
        return r8;
    L16:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.keva.Keva
    public double getDouble(String r7, double r8) {
        if (XmlPullParser.NO_NAMESPACE.equals(r7) == false) goto L5;
        r7 = null;
    L5:
        String r3 = r7;
        monitor-enter(this);
        onRepoAccessLocked();     // Catch: Throwable -> L15
        double r9 = fetchDouble(r3, r8);     // Catch: Throwable -> L11
        monitor-exit(this);     // Catch: Throwable -> L15
        return r9;
    L11:
        th = move-exception;
        sMonitor.reportThrowable(2, this.mName, r3, Double.valueOf(r8), th);     // Catch: Throwable -> L15
        return r8;
    L15:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.keva.Keva
    public float getFloat(String r7, float r8) {
        if (XmlPullParser.NO_NAMESPACE.equals(r7) == false) goto L5;
        r7 = null;
    L5:
        String r3 = r7;
        monitor-enter(this);
        onRepoAccessLocked();     // Catch: Throwable -> L15
        float r9 = fetchFloat(r3, r8);     // Catch: Throwable -> L11
        monitor-exit(this);     // Catch: Throwable -> L15
        return r9;
    L11:
        th = move-exception;
        sMonitor.reportThrowable(2, this.mName, r3, Float.valueOf(r8), th);     // Catch: Throwable -> L15
        return r8;
    L15:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.keva.Keva
    public int getInt(String r7, int r8) {
        if (XmlPullParser.NO_NAMESPACE.equals(r7) == false) goto L5;
        r7 = null;
    L5:
        String r3 = r7;
        monitor-enter(this);
        onRepoAccessLocked();     // Catch: Throwable -> L15
        int r9 = fetchInt(r3, r8);     // Catch: Throwable -> L11
        monitor-exit(this);     // Catch: Throwable -> L15
        return r9;
    L11:
        th = move-exception;
        sMonitor.reportThrowable(2, this.mName, r3, Integer.valueOf(r8), th);     // Catch: Throwable -> L15
        return r8;
    L15:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.keva.Keva
    public long getLong(String r7, long r8) {
        if (XmlPullParser.NO_NAMESPACE.equals(r7) == false) goto L5;
        r7 = null;
    L5:
        String r3 = r7;
        monitor-enter(this);
        onRepoAccessLocked();     // Catch: Throwable -> L15
        long r9 = fetchLong(r3, r8);     // Catch: Throwable -> L11
        monitor-exit(this);     // Catch: Throwable -> L15
        return r9;
    L11:
        th = move-exception;
        sMonitor.reportThrowable(2, this.mName, r3, Long.valueOf(r8), th);     // Catch: Throwable -> L15
        return r8;
    L15:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.keva.Keva
    public String getString(String r7, String r8) {
        if (XmlPullParser.NO_NAMESPACE.equals(r7) == false) goto L5;
        r7 = null;
    L5:
        String r3 = r7;
        monitor-enter(this);
        onRepoAccessLocked();     // Catch: Throwable -> L16
        String r9 = fetchString(r3, r8, false);     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L16
        return r9;
    L12:
        th = move-exception;
        sMonitor.reportThrowable(2, this.mName, r3, r8, th);     // Catch: Throwable -> L16
        return r8;
    L16:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.keva.Keva
    public String[] getStringArray(String r7, String[] r8) {
        if (XmlPullParser.NO_NAMESPACE.equals(r7) == false) goto L5;
        r7 = null;
    L5:
        String r3 = r7;
        monitor-enter(this);
        onRepoAccessLocked();     // Catch: Throwable -> L16
        String[] r9 = fetchStringArray(r3, r8, false);     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L16
        return r9;
    L12:
        th = move-exception;
        sMonitor.reportThrowable(2, this.mName, r3, r8, th);     // Catch: Throwable -> L16
        return r8;
    L16:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.keva.Keva
    public String[] getStringArrayJustDisk(String r7, String[] r8) {
        if (XmlPullParser.NO_NAMESPACE.equals(r7) == false) goto L5;
        r7 = null;
    L5:
        String r3 = r7;
        monitor-enter(this);
        onRepoAccessLocked();     // Catch: Throwable -> L16
        String[] r9 = fetchStringArray(r3, r8, true);     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L16
        return r9;
    L12:
        th = move-exception;
        sMonitor.reportThrowable(2, this.mName, r3, r8, th);     // Catch: Throwable -> L16
        return r8;
    L16:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.keva.Keva
    public String getStringJustDisk(String r7, String r8) {
        if (XmlPullParser.NO_NAMESPACE.equals(r7) == false) goto L5;
        r7 = null;
    L5:
        String r3 = r7;
        monitor-enter(this);
        onRepoAccessLocked();     // Catch: Throwable -> L16
        String r9 = fetchString(r3, r8, true);     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L16
        return r9;
    L12:
        th = move-exception;
        sMonitor.reportThrowable(2, this.mName, r3, r8, th);     // Catch: Throwable -> L16
        return r8;
    L16:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.keva.Keva
    public Set<String> getStringSet(String r7, Set<String> r8) {
        if (XmlPullParser.NO_NAMESPACE.equals(r7) == false) goto L5;
        r7 = null;
    L5:
        String r3 = r7;
        monitor-enter(this);
        onRepoAccessLocked();     // Catch: Throwable -> L16
        Set<String> r9 = fetchStringSet(r3, r8, false);     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L16
        return r9;
    L12:
        th = move-exception;
        sMonitor.reportThrowable(2, this.mName, r3, r8, th);     // Catch: Throwable -> L16
        return r8;
    L16:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.keva.Keva
    public Set<String> getStringSetJustDisk(String r7, Set<String> r8) {
        if (XmlPullParser.NO_NAMESPACE.equals(r7) == false) goto L5;
        r7 = null;
    L5:
        String r3 = r7;
        monitor-enter(this);
        onRepoAccessLocked();     // Catch: Throwable -> L16
        Set<String> r9 = fetchStringSet(r3, r8, true);     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L16
        return r9;
    L12:
        th = move-exception;
        sMonitor.reportThrowable(2, this.mName, r3, r8, th);     // Catch: Throwable -> L16
        return r8;
    L16:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.keva.Keva
    public void storeBoolean(String r10, boolean r11) {
        if (XmlPullParser.NO_NAMESPACE.equals(r10) == false) goto L5;
        r10 = null;
    L5:
        monitor-enter(this);
        onRepoAccessLocked();     // Catch: Throwable -> L29
        KevaValueWrapper r0 = obtainWrapperLocked(r10);     // Catch: Throwable -> L29
        if (this.mIsMultiProcess == false) goto L9;
    L32:
        r0.offset = storeBoolean(this.mHandle, r10, r0.offset, r11);     // Catch: Throwable -> L24
        r0.value = Boolean.valueOf(r11);     // Catch: Throwable -> L24
        if (this.mIsMultiProcess == true) goto L20;
        r0.loaded = true;     // Catch: Throwable -> L24
    L20:
        if (this.mIsMultiProcess == false) goto L22;
        r0.value = null;     // Catch: Throwable -> L24
    L22:
        notifyChangeListeners(this, r10);     // Catch: Throwable -> L24
    L27:
        monitor-exit(this);     // Catch: Throwable -> L29
        return;
    L24:
        th = move-exception;
        sMonitor.reportThrowable(3, this.mName, r10, Boolean.valueOf(r11), th);     // Catch: Throwable -> L29
        goto L27
    L9:
        if (r0.loaded == false) goto L32;
        if (r0.value == null) goto L32;
        if (r0.value.equals(Boolean.valueOf(r11)) == false) goto L32;
        monitor-exit(this);     // Catch: Throwable -> L29
        return;
    L29:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.keva.Keva
    public void storeBytes(String r2, byte[] r3) {
        storeBytes(r2, r3, 0, false);
    }

    @Override // com.bytedance.keva.Keva
    public void storeBytesJustDisk(String r3, byte[] r4) {
        storeBytes(r3, r4, 0, true);
    }

    @Override // com.bytedance.keva.Keva
    public void storeDouble(String r11, double r12) {
        if (XmlPullParser.NO_NAMESPACE.equals(r11) == false) goto L5;
        r11 = null;
    L5:
        monitor-enter(this);
        onRepoAccessLocked();     // Catch: Throwable -> L29
        KevaValueWrapper r0 = obtainWrapperLocked(r11);     // Catch: Throwable -> L29
        if (this.mIsMultiProcess == false) goto L9;
    L32:
        r0.offset = storeDouble(this.mHandle, r11, r0.offset, r12);     // Catch: Throwable -> L24
        r0.value = Double.valueOf(r12);     // Catch: Throwable -> L24
        if (this.mIsMultiProcess == true) goto L20;
        r0.loaded = true;     // Catch: Throwable -> L24
    L20:
        if (this.mIsMultiProcess == false) goto L22;
        r0.value = null;     // Catch: Throwable -> L24
    L22:
        notifyChangeListeners(this, r11);     // Catch: Throwable -> L24
    L27:
        monitor-exit(this);     // Catch: Throwable -> L29
        return;
    L24:
        th = move-exception;
        sMonitor.reportThrowable(3, this.mName, r11, Double.valueOf(r12), th);     // Catch: Throwable -> L29
        goto L27
    L9:
        if (r0.loaded == false) goto L32;
        if (r0.value == null) goto L32;
        if (r0.value.equals(Double.valueOf(r12)) == false) goto L32;
        monitor-exit(this);     // Catch: Throwable -> L29
        return;
    L29:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.keva.Keva
    public void storeFloat(String r10, float r11) {
        if (XmlPullParser.NO_NAMESPACE.equals(r10) == false) goto L5;
        r10 = null;
    L5:
        monitor-enter(this);
        onRepoAccessLocked();     // Catch: Throwable -> L29
        KevaValueWrapper r0 = obtainWrapperLocked(r10);     // Catch: Throwable -> L29
        if (this.mIsMultiProcess == false) goto L9;
    L32:
        r0.offset = storeFloat(this.mHandle, r10, r0.offset, r11);     // Catch: Throwable -> L24
        r0.value = Float.valueOf(r11);     // Catch: Throwable -> L24
        if (this.mIsMultiProcess == true) goto L20;
        r0.loaded = true;     // Catch: Throwable -> L24
    L20:
        if (this.mIsMultiProcess == false) goto L22;
        r0.value = null;     // Catch: Throwable -> L24
    L22:
        notifyChangeListeners(this, r10);     // Catch: Throwable -> L24
    L27:
        monitor-exit(this);     // Catch: Throwable -> L29
        return;
    L24:
        th = move-exception;
        sMonitor.reportThrowable(3, this.mName, r10, Float.valueOf(r11), th);     // Catch: Throwable -> L29
        goto L27
    L9:
        if (r0.loaded == false) goto L32;
        if (r0.value == null) goto L32;
        if (r0.value.equals(Float.valueOf(r11)) == false) goto L32;
        monitor-exit(this);     // Catch: Throwable -> L29
        return;
    L29:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.keva.Keva
    public void storeInt(String r10, int r11) {
        if (XmlPullParser.NO_NAMESPACE.equals(r10) == false) goto L5;
        r10 = null;
    L5:
        monitor-enter(this);
        onRepoAccessLocked();     // Catch: Throwable -> L29
        KevaValueWrapper r0 = obtainWrapperLocked(r10);     // Catch: Throwable -> L29
        if (this.mIsMultiProcess == false) goto L9;
    L32:
        r0.offset = storeInt(this.mHandle, r10, r0.offset, r11);     // Catch: Throwable -> L24
        r0.value = Integer.valueOf(r11);     // Catch: Throwable -> L24
        if (this.mIsMultiProcess == true) goto L20;
        r0.loaded = true;     // Catch: Throwable -> L24
    L20:
        if (this.mIsMultiProcess == false) goto L22;
        r0.value = null;     // Catch: Throwable -> L24
    L22:
        notifyChangeListeners(this, r10);     // Catch: Throwable -> L24
    L27:
        monitor-exit(this);     // Catch: Throwable -> L29
        return;
    L24:
        th = move-exception;
        sMonitor.reportThrowable(3, this.mName, r10, Integer.valueOf(r11), th);     // Catch: Throwable -> L29
        goto L27
    L9:
        if (r0.loaded == false) goto L32;
        if (r0.value == null) goto L32;
        if (r0.value.equals(Integer.valueOf(r11)) == false) goto L32;
        monitor-exit(this);     // Catch: Throwable -> L29
        return;
    L29:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.keva.Keva
    public void storeLong(String r11, long r12) {
        if (XmlPullParser.NO_NAMESPACE.equals(r11) == false) goto L5;
        r11 = null;
    L5:
        monitor-enter(this);
        onRepoAccessLocked();     // Catch: Throwable -> L29
        KevaValueWrapper r0 = obtainWrapperLocked(r11);     // Catch: Throwable -> L29
        if (this.mIsMultiProcess == false) goto L9;
    L32:
        r0.offset = storeLong(this.mHandle, r11, r0.offset, r12);     // Catch: Throwable -> L24
        r0.value = Long.valueOf(r12);     // Catch: Throwable -> L24
        if (this.mIsMultiProcess == true) goto L20;
        r0.loaded = true;     // Catch: Throwable -> L24
    L20:
        if (this.mIsMultiProcess == false) goto L22;
        r0.value = null;     // Catch: Throwable -> L24
    L22:
        notifyChangeListeners(this, r11);     // Catch: Throwable -> L24
    L27:
        monitor-exit(this);     // Catch: Throwable -> L29
        return;
    L24:
        th = move-exception;
        sMonitor.reportThrowable(3, this.mName, r11, Long.valueOf(r12), th);     // Catch: Throwable -> L29
        goto L27
    L9:
        if (r0.loaded == false) goto L32;
        if (r0.value == null) goto L32;
        if (r0.value.equals(Long.valueOf(r12)) == false) goto L32;
        monitor-exit(this);     // Catch: Throwable -> L29
        return;
    L29:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.keva.Keva
    public void storeString(String r2, String r3) {
        storeString(r2, r3, false);
    }

    @Override // com.bytedance.keva.Keva
    public void storeStringArray(String r2, String[] r3) {
        storeStringArray(r2, r3, false);
    }

    @Override // com.bytedance.keva.Keva
    public void storeStringArrayJustDisk(String r2, String[] r3) {
        storeStringArray(r2, r3, true);
    }

    @Override // com.bytedance.keva.Keva
    public void storeStringJustDisk(String r2, String r3) {
        storeString(r2, r3, true);
    }

    @Override // com.bytedance.keva.Keva
    public void storeStringSet(String r2, Set<String> r3) {
        storeStringSet(r2, r3, false);
    }

    @Override // com.bytedance.keva.Keva
    public void storeStringSetJustDisk(String r2, Set<String> r3) {
        storeStringSet(r2, r3, true);
    }

    public KevaImpl(String r4, String r5, int r6) {
        this.mValueMap = new HashMap();
        boolean r0 = false;
        this.mLastAccessIndex = 0;
        this.mLastTryClearIndex = -1;
        this.mChangeListeners = new ArrayList();
        this.mDuplicatedOldWrappers = new ArrayList();
        this.mBigValueAccessIndex = 0;
        this.mLastClearAccessIndex = -1;
        this.mName = r4;
        this.mMode = r6;
        this.mSpecifiedPath = r5;
        if ((r6 & 1) == 0) goto L5;
        r0 = true;
    L5:
        this.mIsMultiProcess = r0;
    }

    private Set<String> fetchStringSet(String r3, Set<String> r4, boolean r5) {
        if (r4 == null) goto L5;
        String[] r6 = (String[]) r4.toArray(new String[0]);
    L6:
        String[] r7 = fetchStringArray(r3, r6, r5);
        if (r7 != null) goto L9;
        return null;
    L9:
        return new HashSet(Arrays.asList(r7));
    L5:
        r6 = null;
        goto L6
    }

    public static KevaImpl getEmptyRepoImpl(String r7, String r8, int r9) {
        if (r9 >= 0) goto L4;
    L5:
        sMonitor.reportThrowable(1, r7, null, null, new IllegalArgumentException("mode is not valid: " + r9));
    L7:
        if ((r9 & 1) != 0) goto L10;
        return new KevaPrivateImpl(r7, r8, r9);
    L10:
        return new KevaMultiProcessImpl(r7, r8, r9);
    L4:
        if (r9 < 2) goto L7;
        goto L5
    }

    public static Keva getRepoFromSp(Context r1, String r2, int r3) {
        return getRepoFromSpImpl(r1, r2, r3, false);
    }

    public static Keva getRepoFromSpSync(Context r1, String r2, int r3) {
        return getRepoFromSpImpl(r1, r2, r3, true);
    }

    public static Keva getRepoSyncWithPath(String r2, String r3, int r4) {
        if (r3 == null) goto L12;
        if (XmlPullParser.NO_NAMESPACE.equals(r3) == true) goto L12;
        if (r3.startsWith("/") == true) goto L12;
        if (r3.endsWith("/") == false) goto L12;
        return getRepoImpl(r2, r3, r4, true);
    L12:
        throw new IllegalArgumentException("path is wrong: " + r3);
    }

    private void reportBigValue(String r3, Object r4, int r5) {
        if (r5 <= 10000) goto L6;
        sExecutor.execute(new 5(this, r3, r4, r5));
        return;
    }

    private void storeString(String r10, String r11, boolean r12) {
        if (XmlPullParser.NO_NAMESPACE.equals(r10) == false) goto L5;
        r10 = null;
    L5:
        monitor-enter(this);
        onRepoAccessLocked();     // Catch: Throwable -> L36
        KevaValueWrapper r0 = obtainWrapperLocked(r10);     // Catch: Throwable -> L36
        if (this.mIsMultiProcess == false) goto L9;
    L39:
        r0.offset = storeString(this.mHandle, r10, r0.offset, r11);     // Catch: Throwable -> L27
        r0.type = 6;     // Catch: Throwable -> L27
        if (r12 == true) goto L24;
        r0.value = r11;     // Catch: Throwable -> L27
        if (this.mIsMultiProcess == true) goto L22;
        r0.loaded = true;     // Catch: Throwable -> L27
    L22:
        if (this.mIsMultiProcess == false) goto L25;
        r0.value = null;     // Catch: Throwable -> L27
    L25:
        notifyChangeListeners(this, r10);     // Catch: Throwable -> L27
    L30:
        monitor-exit(this);     // Catch: Throwable -> L36
        if (r11 == null) goto L42;
        int r13 = r11.length();
        if (r13 <= 10000) goto L43;
        sExecutor.execute(new 6(this, r10, r11, r13));
        return;
    L43:
        return;
    L42:
        return;
    L24:
        r0.value = null;     // Catch: Throwable -> L27
        r0.loaded = false;     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        sMonitor.reportThrowable(3, this.mName, r10, r11, th);     // Catch: Throwable -> L36
        goto L30
    L9:
        if (r0.loaded == false) goto L39;
        if (r0.value == null) goto L39;
        if (r0.value.equals(r11) == false) goto L39;
        monitor-exit(this);     // Catch: Throwable -> L36
        return;
    L36:
        th = move-exception;
        throw th;
    }

    private void storeStringArray(String r11, String[] r12, boolean r13) {
        if (XmlPullParser.NO_NAMESPACE.equals(r11) == false) goto L5;
        r11 = null;
    L5:
        monitor-enter(this);
        onRepoAccessLocked();     // Catch: Throwable -> L27
        KevaValueWrapper r0 = obtainWrapperLocked(r11);     // Catch: Throwable -> L27
        r0.offset = storeStringArray(this.mHandle, r11, r0.offset, r12, 3);     // Catch: Throwable -> L18
        r0.type = 55;     // Catch: Throwable -> L18
        if (r13 == true) goto L15;
        r0.value = r12;     // Catch: Throwable -> L18
        if (this.mIsMultiProcess == true) goto L13;
        r0.loaded = true;     // Catch: Throwable -> L18
    L13:
        if (this.mIsMultiProcess == false) goto L16;
        r0.value = null;     // Catch: Throwable -> L18
    L16:
        notifyChangeListeners(this, r11);     // Catch: Throwable -> L18
    L21:
        monitor-exit(this);     // Catch: Throwable -> L27
        if (r12 == null) goto L34;
        String r14 = Arrays.toString(r12);
        int r15 = r14.length();
        if (r15 <= 10000) goto L35;
        sExecutor.execute(new 8(this, r11, r14, r15));
        return;
    L35:
        return;
    L34:
        return;
    L15:
        r0.value = null;     // Catch: Throwable -> L18
        r0.loaded = false;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        sMonitor.reportThrowable(3, this.mName, r11, null, th);     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        throw th;
    }

    private void storeStringSet(String r2, Set<String> r3, boolean r4) {
        if (r3 == null) goto L4;
        String[] r0 = new String[r3.size()];
        r3.toArray(r0);
    L5:
        storeStringArray(r2, r0, r4);
        return;
    L4:
        r0 = null;
        goto L5
    }

    public void addMapBoolWhenLoading(String r7, boolean r8, long r9) {
        addMapObjectWhenLoading(r7, Boolean.valueOf(r8), r9, 2);
    }

    public void addMapDoubleWhenLoading(String r7, double r8, long r10) {
        addMapObjectWhenLoading(r7, Double.valueOf(r8), r10, 5);
    }

    public void addMapFloatWhenLoading(String r7, float r8, long r9) {
        addMapObjectWhenLoading(r7, Float.valueOf(r8), r9, 4);
    }

    public void addMapIntWhenLoading(String r7, int r8, long r9) {
        addMapObjectWhenLoading(r7, Integer.valueOf(r8), r9, 1);
    }

    public void addMapLongWhenLoading(String r7, long r8, long r10) {
        addMapObjectWhenLoading(r7, Long.valueOf(r8), r10, 3);
    }

    public void addMapOffsetWhenLoading(String r2, long r3, int r5) {
        if (XmlPullParser.NO_NAMESPACE.equals(r2) == false) goto L5;
        r2 = null;
    L5:
        KevaValueWrapper r0 = new KevaValueWrapper();
        r0.offset = r3;
        r0.type = r5;
        KevaValueWrapper r4 = this.mValueMap.put(r2, r0);
        if (r4 == null) goto L11;
        List<KevaValueWrapper> r6 = this.mDuplicatedOldWrappers;
        if (r6 == null) goto L12;
        r6.add(r4);
        return;
    L12:
        return;
    }

    private void addMapObjectWhenLoading(String r3, Object r4, long r5, int r7) {
        if (XmlPullParser.NO_NAMESPACE.equals(r3) == false) goto L5;
        r3 = null;
    L5:
        KevaValueWrapper r0 = new KevaValueWrapper();
        r0.value = r4;
        r0.offset = r5;
        r0.type = r7;
        if (this.mIsMultiProcess == true) goto L9;
        r0.loaded = true;
    L9:
        if (this.mIsMultiProcess == false) goto L11;
        r0.value = null;
    L11:
        KevaValueWrapper r6 = this.mValueMap.put(r3, r0);
        if (r6 == null) goto L17;
        List<KevaValueWrapper> r8 = this.mDuplicatedOldWrappers;
        if (r8 == null) goto L18;
        r8.add(r6);
        return;
    L18:
        return;
    }

    private static Keva getRepoFromSpImpl(Context r12, String r13, int r14, boolean r15) {
        if (isRepoPorted(r13) == true) goto L5;
        boolean r1 = true;
        if (existSharedPrefs(r13) == true) goto L10;
        getPortedSpRepo().storeBoolean(r13, true);
        return getRepo(r13, r14);
    L10:
        boolean r2 = false;
        if (sMainThreadPriorityOpt == true) goto L13;
    L17:
        boolean r0 = false;
    L18:
        sMonitor.logDebug("do poring from sp: " + r13);
        if (sGetRepoLockOpt == false) goto L43;
        ConcurrentHashMap<String, Object> r3 = sRepoMap;
        Object r5 = r3.get(r13);
        if (r5 != null) goto L27;
        r5 = new Object();
        Object r6 = r3.putIfAbsent(r13, r5);
        if (r6 == null) goto L27;
        r5 = r6;
    L27:
        if ((r5 instanceof Keva) == true) goto L42;
        monitor-enter(r5);
        Object r7 = r3.get(r13);     // Catch: Throwable -> L39
        if ((r7 instanceof Keva) == true) goto L36;
        if (r15 == false) goto L34;
        Object r16 = getEmptyRepoImpl(r13, null, r14);     // Catch: Throwable -> L39
    L33:
        r7 = r16;
        r3.put(r13, r7);     // Catch: Throwable -> L39
    L37:
        monitor-exit(r5);     // Catch: Throwable -> L39
        r2 = r1;
        r5 = r7;
        goto L42
    L34:
        r16 = new KevaFuture(r13, r14, new 3(r0, r13, r14, r12));     // Catch: Throwable -> L39
        goto L33
    L36:
        r1 = false;
    L39:
        th = move-exception;
        throw th;
    L42:
        Keva r8 = (Keva) r5;
    L56:
        if (r2 == false) goto L64;
        if ((r8 instanceof KevaImpl) == true) goto L73;
    L67:
        return r8;
    L73:
        ((KevaImpl) r8).doPortingFromSp(r12);     // Catch: UnsatisfiedLinkError -> L61
    L61:
        e = move-exception;
        sMonitor.reportThrowable(1, r13, null, null, e);
        goto L67
    L64:
        if ((r8 instanceof KevaImpl) == false) goto L66;
        ((KevaImpl) r8).checkMode(r14);
        goto L67
    L66:
        ((KevaFuture) r8).checkMode(r14);
        goto L67
    L43:
        ConcurrentHashMap<String, Object> r4 = sRepoMap;
        monitor-enter(r4);
        r8 = (Keva) r4.get(r13);     // Catch: Throwable -> L68
        if (r8 == null) goto L49;
        r1 = false;
    L49:
        if (r1 == false) goto L54;
        if (r15 == false) goto L52;
        Keva r17 = getEmptyRepoImpl(r13, null, r14);     // Catch: Throwable -> L68
    L53:
        r4.put(r13, r17);     // Catch: Throwable -> L68
        r8 = r17;
        goto L54
    L52:
        r17 = new KevaFuture(r13, r14, new 4(r0, r13, r14, r12));     // Catch: Throwable -> L68
    L54:
        monitor-exit(r4);     // Catch: Throwable -> L68
        r2 = r1;
    L68:
        th = move-exception;
        throw th;
    L13:
        if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()) != ThreadMethodProxy.currentThread()) goto L17;
        if (sPriorityValue == 0) goto L17;
        r0 = true;
        goto L18
    L5:
        return getRepo(r13, r14);
    }

    private static Keva getRepoImpl(final String r8, final String r9, final int r10, boolean r11) {
        if (r9 != null) goto L4;
        ConcurrentHashMap<String, Object> r0 = sRepoMap;
    L5:
        boolean r2 = true;
        if (sMainThreadPriorityOpt == true) goto L8;
    L12:
        final boolean r1 = false;
    L13:
        boolean r4 = sGetRepoLockOpt;
        if (r4 == false) goto L38;
        Object r5 = r0.get(r8);
        if (r5 != null) goto L22;
        r5 = new Object();
        Object r6 = r0.putIfAbsent(r8, r5);
        if (r6 == null) goto L22;
        r5 = r6;
    L22:
        if ((r5 instanceof Keva) == false) goto L24;
        Keva r7 = (Keva) r5;
        r2 = false;
    L49:
        if (r2 == true) goto L57;
        if (r4 == true) goto L57;
        if ((r7 instanceof KevaFuture) == true) goto L55;
        ((KevaImpl) r7).checkMode(r10);
    L59:
        return r7;
    L55:
        ((KevaFuture) r7).checkMode(r10);
    L57:
        if ((r7 instanceof KevaFuture) == true) goto L59;
        ((KevaImpl) r7).init(false);
        goto L59
    L24:
        monitor-enter(r5);
        Object r12 = r0.get(r8);     // Catch: Throwable -> L35
        if ((r12 instanceof Keva) == false) goto L28;
        r2 = false;
    L32:
        Keva r13 = (Keva) r12;     // Catch: Throwable -> L35
        monitor-exit(r5);     // Catch: Throwable -> L35
        r7 = r13;
        goto L49
    L28:
        if (r11 == false) goto L30;
        r12 = getEmptyRepoImpl(r8, r9, r10);     // Catch: Throwable -> L35
    L31:
        r0.put(r8, r12);     // Catch: Throwable -> L35
        goto L32
    L30:
        r12 = new KevaFuture(r8, r10, new AnonymousClass1(r1, r8, r9, r10));     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        throw th;
    L38:
        monitor-enter(r0);
        r7 = (Keva) r0.get(r8);     // Catch: Throwable -> L60
        if (r7 == null) goto L43;
        r2 = false;
    L43:
        if (r2 == false) goto L48;
        if (r11 == false) goto L46;
        Keva r14 = getEmptyRepoImpl(r8, r9, r10);     // Catch: Throwable -> L60
    L47:
        r0.put(r8, r14);     // Catch: Throwable -> L60
        r7 = r14;
        goto L48
    L46:
        r14 = new KevaFuture(r8, r10, new AnonymousClass2(r1, r8, r9, r10));     // Catch: Throwable -> L60
    L48:
        monitor-exit(r0);     // Catch: Throwable -> L60
    L60:
        th = move-exception;
        throw th;
    L8:
        if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()) != ThreadMethodProxy.currentThread()) goto L12;
        if (sPriorityValue == 0) goto L12;
        r1 = true;
        goto L13
    L4:
        ConcurrentHashMap<String, ConcurrentHashMap<String, Object>> r3 = sPathRepoMap;
        r3.putIfAbsent(r9, new ConcurrentHashMap());
        r0 = r3.get(r9);
        goto L5
    }

    private void storeBytes(String r11, byte[] r12, int r13, boolean r14) {
        if (XmlPullParser.NO_NAMESPACE.equals(r11) == false) goto L5;
        r11 = null;
    L5:
        monitor-enter(this);
        onRepoAccessLocked();     // Catch: Throwable -> L27
        KevaValueWrapper r0 = obtainWrapperLocked(r11);     // Catch: Throwable -> L27
        r0.offset = storeBytes(this.mHandle, r11, r0.offset, r12, r13);     // Catch: Throwable -> L18
        r0.type = (r13 << 4) | 7;     // Catch: Throwable -> L18
        if (r14 == true) goto L15;
        r0.value = r12;     // Catch: Throwable -> L18
        if (this.mIsMultiProcess == true) goto L13;
        r0.loaded = true;     // Catch: Throwable -> L18
    L13:
        if (this.mIsMultiProcess == false) goto L16;
        r0.value = null;     // Catch: Throwable -> L18
    L16:
        notifyChangeListeners(this, r11);     // Catch: Throwable -> L18
    L21:
        monitor-exit(this);     // Catch: Throwable -> L27
        if (r12 == null) goto L34;
        int r15 = r12.length;
        if (r15 <= 10000) goto L35;
        sExecutor.execute(new 7(this, r11, r15));
        return;
    L35:
        return;
    L34:
        return;
    L15:
        r0.value = null;     // Catch: Throwable -> L18
        r0.loaded = false;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        sMonitor.reportThrowable(3, this.mName, r11, r12, th);     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        throw th;
    }

    public static void passWarning(int r6, String r7, String r8, Object r9, String r10) {
        sMonitor.reportWarning(r6, r7, r8, r9, r10);
    }
}
