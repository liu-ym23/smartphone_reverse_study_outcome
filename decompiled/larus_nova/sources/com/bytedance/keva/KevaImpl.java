package com.bytedance.keva;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import android.os.Looper;
import androidx.camera.video.AudioStats;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
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

/* JADX INFO: loaded from: classes.dex */
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

    /* JADX INFO: loaded from: classes6.dex */
    public static class PortedSpRepoHolder {
        private static final KevaImpl sInstance = null;
        private static final Map<String, ?> sPortedSpMap = null;

        private PortedSpRepoHolder() {
        }

        static {
            KevaMultiProcessImpl r100 = new KevaMultiProcessImpl(KevaImpl.access$000(), null, 1);
            sInstance = r100;
            r100.init(true);
            sPortedSpMap = r100.buildNewMap(new HashMap());
        }

        public static /* synthetic */ KevaImpl access$100() {
            return sInstance;
        }

        public static /* synthetic */ Map access$400() {
            return sPortedSpMap;
        }
    }

    /* JADX INFO: loaded from: classes19.dex */
    public interface PrivateConstants {
        public static final int BLOCK_TYPE_BYTES = 0;
        public static final int BLOCK_TYPE_OBJECT = 4;
        public static final int BLOCK_TYPE_STRING_ARRAY = 3;
        public static final int BLOCK_TYPE_STRING_UTF16 = 2;
        public static final int BLOCK_TYPE_STRING_UTF8 = 1;
        public static final String EMPTY_STRING = "";
        public static final int EXT_TYPE_BYTES = 7;
        public static final int EXT_TYPE_OBJECT = 71;
        public static final int EXT_TYPE_STRING_ARRAY = 55;
        public static final int EXT_TYPE_STRING_UTF16 = 39;
        public static final int EXT_TYPE_STRING_UTF8 = 23;
        public static final String FILES_DIR_NAME = "files";
        public static final String KEVA = "keva";
        public static final String LIB_NAME = "keva";
        public static final String PORTED_SP = "keva_porting_sp";
        public static final int REPORT_VALUE_SIZE_THRESHOLD = 10000;
        public static final String SP_DIR_NAME = "shared_prefs";
        public static final int TYPE_BOOL = 2;
        public static final int TYPE_BYTES = 7;
        public static final int TYPE_DOUBLE = 5;
        public static final int TYPE_FLOAT = 4;
        public static final int TYPE_INT = 1;
        public static final int TYPE_INVALID = 0;
        public static final int TYPE_LONG = 3;
        public static final int TYPE_STRING = 6;
    }

    public static native void checkReportException(long r100);

    private static native void clear(long r100);

    private static native boolean delete(String r100);

    private native void dump(long r100);

    private native void erase(long r100, String r101, long r102);

    private native void eraseUnusedChunk(long r100, long r101);

    public static void forceInitImpl() {
    }

    private static native void initialize(String r100);

    private native long loadRepo(String r100, int r101, boolean r102);

    private native long loadRepoWithPath(String r100, String r101, int r102);

    private native int protectPortingInterProcess(String r100, boolean r101, int r102);

    private native long storeBoolean(long r100, String r101, long r102, boolean r103);

    private native long storeBytes(long r100, String r101, long r102, byte[] r103, int r104);

    private native long storeDouble(long r100, String r101, long r102, double r103);

    private native long storeFloat(long r100, String r101, long r102, float r103);

    private native long storeInt(long r100, String r101, long r102, int r103);

    private native long storeLong(long r100, String r101, long r102, long r103);

    private native long storeString(long r100, String r101, long r102, String r103);

    private native long storeStringArray(long r100, String r101, long r102, String[] r103, int r104);

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

    public native boolean contains(long r100, String r101, long r102);

    public void dumpNative() {
        monitor-enter(this);
        dump(this.mHandle);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public native boolean fetchBoolean(long r100, String r101, long r102, boolean r103);

    public abstract boolean fetchBoolean(String r100, boolean r101);

    public native byte[] fetchBytes(long r100, String r101, long r102, byte[] r103, int r104);

    public abstract byte[] fetchBytes(String r100, byte[] r101, int r102, boolean r103);

    public native double fetchDouble(long r100, String r101, long r102, double r103);

    public abstract double fetchDouble(String r100, double r101);

    public native float fetchFloat(long r100, String r101, long r102, float r103);

    public abstract float fetchFloat(String r100, float r101);

    public native int fetchInt(long r100, String r101, long r102, int r103);

    public abstract int fetchInt(String r100, int r101);

    public native long fetchLong(long r100, String r101, long r102, long r103);

    public abstract long fetchLong(String r100, long r101);

    public native String fetchString(long r100, String r101, long r102, String r103);

    public abstract String fetchString(String r100, String r101, boolean r102);

    public native String[] fetchStringArray(long r100, String r101, long r102, String[] r103, int r104);

    public abstract String[] fetchStringArray(String r100, String[] r101, boolean r102);

    public native void rebuildValueMap(long r100);

    private void cleanUpAfterLoadRepo() {
        if (this.mHandle != 0) goto L14;
        sMonitor.reportWarning(1, this.mName, null, null, "free space is " + Environment.getDataDirectory().getFreeSpace());
        return;
    L14:
        Iterator<KevaValueWrapper> r100 = this.mDuplicatedOldWrappers.iterator();     // Catch: Throwable -> L11
    L7:
        if (r100.hasNext() == false) goto L9;
        eraseUnusedChunk(this.mHandle, r100.next().offset);     // Catch: Throwable -> L11
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
        ArrayList r100 = new ArrayList();
        ConcurrentHashMap<String, Object> r101 = sRepoMap;
        monitor-enter(r101);
        r100.addAll(r101.values());     // Catch: Throwable -> L26
        monitor-exit(r101);     // Catch: Throwable -> L26
        Iterator<ConcurrentHashMap<String, Object>> r102 = sPathRepoMap.values().iterator();
    L8:
        if (r102.hasNext() == false) goto L17;
        ConcurrentHashMap<String, Object> r103 = r102.next();
        monitor-enter(r103);
        r100.addAll(r103.values());     // Catch: Throwable -> L14
        monitor-exit(r103);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    L17:
        Iterator r104 = r100.iterator();
        int r105 = 0;
    L19:
        if (r104.hasNext() == false) goto L25;
        Object r106 = r104.next();
        if ((r106 instanceof KevaImpl) == false) goto L19;
        if (((KevaImpl) r106).tryClearValueMapIfIdle() == false) goto L19;
        r105 = r105 + 1;
        goto L19
    L25:
        return r105;
    L26:
        th = move-exception;
        throw th;
    }

    private void innerRebuildValueMap() {
        rebuildValueMap(this.mHandle);
    }

    public static void markPreloadDone() {
        KevaInnerPreloader r100 = sPreloader;
        if (r100 == null) goto L6;
        r100.markPreloadDone();
        return;
    }

    private boolean tryClearValueMapIfIdle() {
        if (this.mHandle != 0) goto L6;
        return false;
    L6:
        if (this.mDisableIdleRelease == false) goto L8;
        return false;
    L8:
        Set<String> r100 = sRepoIdleReleaseWhiteList;
        if (r100.isEmpty() == false) goto L11;
    L14:
        int r101 = this.mLastAccessIndex;
        if (this.mLastTryClearIndex >= r101) goto L18;
        this.mLastTryClearIndex = r101;
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
        if (r100.contains(this.mName) == false) goto L14;
        this.mDisableIdleRelease = true;
        return false;
    }

    @Override // com.bytedance.keva.Keva
    public void dump() {
        monitor-enter(this);
        sMonitor.logDebug("start dumping keva " + this.mName + ", size=" + this.mValueMap.size());     // Catch: Throwable -> L11
        Iterator<Map.Entry<String, KevaValueWrapper>> r100 = this.mValueMap.entrySet().iterator();     // Catch: Throwable -> L11
    L6:
        if (r100.hasNext() == false) goto L8;
        Map.Entry<String, KevaValueWrapper> r101 = r100.next();     // Catch: Throwable -> L11
        KevaValueWrapper r102 = r101.getValue();     // Catch: Throwable -> L11
        String r103 = r101.getKey();     // Catch: Throwable -> L11
        sMonitor.logDebug("key: " + r103 + ", value: " + r102.value + ", offset: " + r102.offset + ", loaded: " + r102.loaded);     // Catch: Throwable -> L11
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
        KevaBuilder r100 = KevaBuilder.getInstance();
        KevaBuilder.clearInstance();
        sRepoMap = new ConcurrentHashMap();
        sPathRepoMap = new ConcurrentHashMap();
        Executor r101 = r100.mExecutor;
        if (r101 == null) goto L5;
        sExecutor = r101;
    L6:
        String r102 = r100.mPortedRepoName;
        if (r102 != null) goto L10;
        r102 = PrivateConstants.PORTED_SP;
    L10:
        sPortedSpRepoName = r102;
        Context r103 = r100.mContext;
        File r104 = r103.getFilesDir();
        if (r104 != null) goto L14;
        r104 = new PolarisFileWrapper(r103.getApplicationInfo().dataDir, PrivateConstants.FILES_DIR_NAME);
    L14:
        if (r104.exists() == true) goto L16;
        r104.mkdirs();
    L16:
        File r105 = r100.mWorkDir;
        if (r105 != null) goto L19;
        r105 = new PolarisFileWrapper(r104, "keva");
    L19:
        sSharedPrefsDir = new PolarisFileWrapper(r104.getParent(), "shared_prefs");
        KevaMonitor r106 = r100.mMonitor;
        if (r106 != null) goto L23;
        r106 = new KevaMonitor();
    L23:
        sMonitor = r106;
        r106.logDebug("Keva version: 1.6.10.SHARED.CXXAPI-alpha.39");
        if (r105.exists() == false) goto L26;
    L28:
        sEnableExecutorOpt = r100.mEnableExecutorOpt;
        sMainThreadPriorityOpt = r100.mMainThreadPriorityOpt;
        sPriorityValue = r100.mPriorityValue;
        sGetRepoLockOpt = r100.mGetRepoLockOpt;
        sInitRepoOpt = r100.mInitRepoOpt;
        sRepoIdleReleaseMainThreadThreshold = Math.max(1, r100.mRepoIdleReleaseMainThreadThreshold);
        Set<String> r107 = r100.mRepoIdleReleaseWhiteList;
        if (r107 != null) goto L31;
    L32:
        r107 = Collections.emptySet();
    L33:
        sRepoIdleReleaseWhiteList = r107;
        r106.loadLibrary("keva");     // Catch: Throwable -> L36
        initialize(r105.getAbsolutePath());     // Catch: Throwable -> L36
    L39:
        if (r100.mTimeMsLoadThreshold == 0) goto L41;
        final KevaInnerPreloader r108 = new KevaInnerPreloader(r100);
        sPreloader = r108;
        Executor r109 = sExecutor;
        Objects.requireNonNull(r108);
        r109.execute(new a(r108));
    L42:
        sInitStamp = System.currentTimeMillis();
        return;
    L41:
        sPreloader = null;
    L36:
        th = move-exception;
        th.printStackTrace();
        KevaMonitor r110 = sMonitor;
        r110.logDebug("fail to load so and init");
        r110.reportThrowable(1, null, null, null, th);
        goto L39
    L31:
        if (r107.isEmpty() == false) goto L33;
    L26:
        if (r105.mkdirs() == true) goto L28;
        r106.reportThrowable(1, null, null, null, new IllegalStateException("fail to create work dir " + r105.getPath()));
        goto L28
    L5:
        int r111 = Math.max(Runtime.getRuntime().availableProcessors() * 2, 6);
        PThreadPoolExecutor r112 = new PThreadPoolExecutor(r111, r111, 30, TimeUnit.SECONDS, new LinkedBlockingQueue(), new DefaultThreadFactory("keva/KevaImpl"));
        r112.allowCoreThreadTimeOut(true);
        sExecutor = r112;
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

    public static /* synthetic */ String access$500(KevaImpl r100) {
        return r100.mName;
    }

    public static void clearOnLowMemory(int r100) {
        ArrayList r101 = new ArrayList();
        ConcurrentHashMap<String, Object> r102 = sRepoMap;
        monitor-enter(r102);
        r101.addAll(r102.values());     // Catch: Throwable -> L24
        monitor-exit(r102);     // Catch: Throwable -> L24
        Iterator<ConcurrentHashMap<String, Object>> r103 = sPathRepoMap.values().iterator();
    L8:
        if (r103.hasNext() == false) goto L17;
        ConcurrentHashMap<String, Object> r104 = r103.next();
        monitor-enter(r104);
        r101.addAll(r104.values());     // Catch: Throwable -> L14
        monitor-exit(r104);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    L17:
        Iterator r105 = r101.iterator();
    L19:
        if (r105.hasNext() == false) goto L23;
        Object r106 = r105.next();
        if ((r106 instanceof Keva.ClearMemory) == false) goto L19;
        ((Keva.ClearMemory) r106).clearMemory(r100);
        goto L19
    L23:
        return;
    L24:
        th = move-exception;
        throw th;
    }

    private void doLoadRepo(boolean r100) {
        String r101 = this.mSpecifiedPath;     // Catch: Throwable -> L11
        if (r101 != null) goto L5;
        this.mHandle = loadRepo(this.mName, this.mMode, r100);     // Catch: Throwable -> L11
    L6:
        cleanUpAfterLoadRepo();     // Catch: Throwable -> L11
        if (r100 == false) goto L9;
        return;
    L9:
        sMonitor.onLoadRepo(this.mName, this.mMode);     // Catch: Throwable -> L11
        return;
    L5:
        this.mHandle = loadRepoWithPath(this.mName, r101, this.mMode);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        sMonitor.reportThrowable(1, this.mName, null, null, th);
    }

    private void doPortingFromSp(Context r210) {
        monitor-enter(this);
    L80:
        th = move-exception;
        throw th;
    L5:
        if (this.mHandle == 0) goto L8;
        monitor-exit(this);     // Catch: Throwable -> L80
        return;
    L8:
        boolean r110 = this instanceof KevaMultiProcessImpl;     // Catch: Throwable -> L80
        if (r110 == false) goto L16;
        int r100 = protectPortingInterProcess(this.mName, true, -1);     // Catch: Throwable -> L80
        if (isRepoPorted(this.mName) == false) goto L15;
        doLoadRepo(false);     // Catch: Throwable -> L80
        protectPortingInterProcess(this.mName, false, r100);     // Catch: Throwable -> L80
        monitor-exit(this);     // Catch: Throwable -> L80
        return;
    L15:
        int r111 = r100;
    L17:
        if (r110 == false) goto L19;
    L21:
        boolean r101 = false;
    L22:
        KevaMonitor r102 = sMonitor;     // Catch: Throwable -> L80
        r102.logDebug("poring load empty repo >> " + this.mName);     // Catch: Throwable -> L80
        doLoadRepo(false);     // Catch: Throwable -> L80
        if (this.mHandle != 0) goto L26;
        monitor-exit(this);     // Catch: Throwable -> L80
        return;
    L26:
        if (r101 == true) goto L28;
        clear();     // Catch: Throwable -> L80
    L28:
        SharedPreferences r103 = r210.getSharedPreferences(this.mName, 0);     // Catch: Throwable -> L80
        r102.logDebug("poring get sp >> " + this.mName);     // Catch: Throwable -> L80
        Map<String, ?> r104 = r103.getAll();     // Catch: Throwable -> L80
        r102.logDebug("poring get all value >> " + this.mName);     // Catch: Throwable -> L80
        Iterator<Map.Entry<String, ?>> r112 = r104.entrySet().iterator();     // Catch: Throwable -> L80
    L30:
        if (r112.hasNext() == false) goto L74;
        Map.Entry<String, ?> r105 = r112.next();     // Catch: Throwable -> L80
        String r106 = r105.getKey();     // Catch: Throwable -> L80
        Object r113 = r105.getValue();     // Catch: Throwable -> L80
        if (r113 == null) goto L30;
        if ("".equals(r106) == false) goto L37;
        String r107 = null;
    L38:
        KevaMonitor r108 = sMonitor;     // Catch: Throwable -> L80
        r108.logDebug("poring process key: " + r107 + ", value: " + r113 + " >> " + this.mName);     // Catch: Throwable -> L80
        KevaValueWrapper r109 = new KevaValueWrapper();     // Catch: Throwable -> L80
        this.mValueMap.put(r107, r109);     // Catch: Throwable -> L80
    L69:
        th = th;
    L72:
        sMonitor.reportThrowable(3, this.mName, r107, r113, th);     // Catch: Throwable -> L80
        goto L30
    L40:
        if ((r113 instanceof Boolean) == false) goto L44;
        r109.offset = storeBoolean(this.mHandle, r107, r109.offset, ((Boolean) r113).booleanValue());     // Catch: Throwable -> L67
        r109.value = r113;     // Catch: Throwable -> L67
    L61:
        if (this.mIsMultiProcess == true) goto L64;
        r109.loaded = true;     // Catch: Throwable -> L67
    L64:
        if (this.mIsMultiProcess == false) goto L30;
        r109.value = null;     // Catch: Throwable -> L67
    L67:
        th = th;
        goto L72
    L44:
        String r114 = r107;
        if ((r113 instanceof Integer) == false) goto L48;
        r109.offset = storeInt(this.mHandle, r114, r109.offset, ((Integer) r113).intValue());     // Catch: Throwable -> L67
        r109.value = r113;     // Catch: Throwable -> L67
        goto L61
    L48:
        if ((r113 instanceof Long) == false) goto L51;
        r109.offset = storeLong(this.mHandle, r114, r109.offset, ((Long) r113).longValue());     // Catch: Throwable -> L67
        r109.value = r113;     // Catch: Throwable -> L67
        goto L61
    L51:
        if ((r113 instanceof Float) == false) goto L54;
        r109.offset = storeFloat(this.mHandle, r114, r109.offset, ((Float) r113).floatValue());     // Catch: Throwable -> L67
        r109.value = r113;     // Catch: Throwable -> L67
        goto L61
    L54:
        if ((r113 instanceof String) == false) goto L57;
        r109.offset = storeString(this.mHandle, r114, r109.offset, (String) r113);     // Catch: Throwable -> L67
        r109.value = r113;     // Catch: Throwable -> L67
        goto L61
    L57:
        if ((r113 instanceof Set) == false) goto L59;
        Set r115 = (Set) r113;     // Catch: Throwable -> L67
        String[] r116 = new String[r115.size()];     // Catch: Throwable -> L67
        r115.toArray(r116);     // Catch: Throwable -> L67
        r109.offset = storeStringArray(this.mHandle, r114, r109.offset, r116, 3);     // Catch: Throwable -> L67
        r109.value = r116;     // Catch: Throwable -> L67
        goto L61
    L59:
        r108.reportThrowable(1, this.mName, r114, r113, new IllegalStateException("do not support type: " + r113.getClass()));     // Catch: Throwable -> L67
        goto L61
    L37:
        r107 = r106;
        goto L38
    L74:
        getPortedSpRepo().storeBoolean(this.mName, true);     // Catch: Throwable -> L80
        if (r110 == false) goto L77;
        protectPortingInterProcess(this.mName, false, r111);     // Catch: Throwable -> L80
    L77:
        monitor-exit(this);     // Catch: Throwable -> L80
        sMonitor.logDebug("poring set ported repo >> " + this.mName);
        return;
    L19:
        if (delete(this.mName) == false) goto L21;
        r101 = true;
        goto L22
    L16:
        r111 = -1;
        goto L17
    }

    private static boolean existSharedPrefs(String r100) {
        return new PolarisFileWrapper(sSharedPrefsDir, r100 + ".xml").exists();
    }

    public static boolean isRepoPorted(String r100) {
        if (PortedSpRepoHolder.access$400().get(r100) == null) goto L7;
        return true;
    L7:
        return getPortedSpRepo().getBoolean(r100, false);
    }

    private KevaValueWrapper obtainWrapperLocked(String r100) {
        KevaValueWrapper r101 = this.mValueMap.get(r100);
        if (r101 != null) goto L6;
        KevaValueWrapper r102 = new KevaValueWrapper();
        this.mValueMap.put(r100, r102);
        return r102;
    L6:
        return r101;
    }

    @Override // com.bytedance.keva.Keva
    public Map<String, Object> buildNewMap(Map<String, Object> r110) {
        if (r110 != KevaConstants.FLAG_CURRENT_KEY_MAP) goto L11;
        monitor-enter(this);
        onRepoAccessLocked();     // Catch: Throwable -> L8
        HashMap r111 = (HashMap) this.mValueMap.clone();     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        return r111;
    L8:
        th = move-exception;
        throw th;
    L11:
        monitor-enter(this);
        onRepoAccessLocked();     // Catch: Throwable -> L74
        Iterator<Map.Entry<String, KevaValueWrapper>> r100 = this.mValueMap.entrySet().iterator();     // Catch: Throwable -> L74
    L14:
        if (r100.hasNext() == false) goto L72;
        Map.Entry<String, KevaValueWrapper> r101 = r100.next();     // Catch: Throwable -> L74
        KevaValueWrapper r102 = r101.getValue();     // Catch: Throwable -> L74
        if (r102.offset == 0) goto L14;
        String r103 = r101.getKey();     // Catch: Throwable -> L74
    L69:
        th = move-exception;
        sMonitor.reportThrowable(2, this.mName, r103, Long.valueOf(r102.offset), th);     // Catch: Throwable -> L74
        goto L14
    L20:
        if (r102.loaded == true) goto L59;
        int r104 = r102.type;     // Catch: Throwable -> L69
        if (r104 == 23) goto L57;
        if (r104 == 39) goto L57;
        if (r104 == 55) goto L52;
        switch(r104) {
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
        r102.value = fetchBytes(this.mHandle, r103, r102.offset, null, 0);     // Catch: Throwable -> L69
    L54:
        if (this.mIsMultiProcess == true) goto L59;
        r102.loaded = true;     // Catch: Throwable -> L69
        goto L59
    L36:
        r102.value = fetchString(this.mHandle, r103, r102.offset, null);     // Catch: Throwable -> L69
        goto L54
    L29:
        if (this.mIsMultiProcess == false) goto L34;
        if (r102.type <= 5) goto L54;
    L34:
        throw new UnsupportedOperationException("keva has not implemented type " + r102.type);     // Catch: Throwable -> L69
    L38:
        if (this.mIsMultiProcess == false) goto L54;
        r102.value = Double.valueOf(fetchDouble(this.mHandle, r103, r102.offset, AudioStats.AUDIO_AMPLITUDE_NONE));     // Catch: Throwable -> L69
        goto L54
    L41:
        if (this.mIsMultiProcess == false) goto L54;
        r102.value = Float.valueOf(fetchFloat(this.mHandle, r103, r102.offset, 0.0f));     // Catch: Throwable -> L69
        goto L54
    L44:
        if (this.mIsMultiProcess == false) goto L54;
        r102.value = Long.valueOf(fetchLong(this.mHandle, r103, r102.offset, 0));     // Catch: Throwable -> L69
        goto L54
    L47:
        if (this.mIsMultiProcess == false) goto L54;
        r102.value = Boolean.valueOf(fetchBoolean(this.mHandle, r103, r102.offset, false));     // Catch: Throwable -> L69
        goto L54
    L50:
        if (this.mIsMultiProcess == false) goto L54;
        r102.value = Integer.valueOf(fetchInt(this.mHandle, r103, r102.offset, 0));     // Catch: Throwable -> L69
        goto L54
    L52:
        r102.value = fetchStringArray(this.mHandle, r103, r102.offset, null, 3);     // Catch: Throwable -> L69
    L57:
        throw new UnsupportedOperationException("keva has not implemented type " + r102.type);     // Catch: Throwable -> L69
    L59:
        if (this.mIsMultiProcess == false) goto L61;
    L65:
        r110.put(r103, r102.value);     // Catch: Throwable -> L69
        if (this.mIsMultiProcess == false) goto L14;
        r102.value = null;     // Catch: Throwable -> L69
        goto L14
    L61:
        if (r102.type != 6) goto L63;
    L64:
        int r105 = this.mBigValueAccessIndex + 1;     // Catch: Throwable -> L69
        this.mBigValueAccessIndex = r105;     // Catch: Throwable -> L69
        r102.accessIndex = r105;     // Catch: Throwable -> L69
        goto L65
    L63:
        if ((r102.type & 7) == 0) goto L65;
    L72:
        monitor-exit(this);     // Catch: Throwable -> L74
        return r110;
    L74:
        th = move-exception;
        throw th;
    }

    public void checkMode(int r100) {
        if (this.mHandle != 0) goto L6;
        return;
    L6:
        if (this.mMode == r100) goto L9;
        sMonitor.reportThrowable(1, this.mName, null, null, new IllegalStateException("mode is different: " + this.mMode + " != " + r100));
        return;
    }

    @Override // com.bytedance.keva.Keva.ClearMemory
    public void clearMemory(int r100) {
        if (this.mIsMultiProcess == false) goto L5;
        return;
    L5:
        monitor-enter(this);
        if (r100 != 0) goto L30;
        int r101 = Integer.MAX_VALUE;
    L9:
        Iterator<KevaValueWrapper> r102 = this.mValueMap.values().iterator();     // Catch: Throwable -> L27
    L11:
        if (r102.hasNext() == false) goto L24;
        KevaValueWrapper r103 = r102.next();     // Catch: Throwable -> L27
        if (r103 == null) goto L11;
        if (r103.loaded == false) goto L11;
        int r104 = r103.accessIndex;     // Catch: Throwable -> L27
        if (r104 == 0) goto L11;
        if (r104 > r101) goto L11;
        if (r103.type == 6) goto L23;
        if ((r103.type & 7) != 7) goto L11;
    L23:
        r103.value = null;     // Catch: Throwable -> L27
        r103.loaded = false;     // Catch: Throwable -> L27
        goto L11
    L24:
        this.mLastClearAccessIndex = this.mBigValueAccessIndex;     // Catch: Throwable -> L27
        monitor-exit(this);     // Catch: Throwable -> L27
        return;
    L27:
        th = move-exception;
        throw th;
    L30:
        r101 = this.mLastClearAccessIndex;     // Catch: Throwable -> L27
        goto L9
    }

    @Override // com.bytedance.keva.Keva
    public void erase(String r110) {
        if ("".equals(r110) == false) goto L5;
        r110 = null;
    L5:
        monitor-enter(this);
        onRepoAccessLocked();     // Catch: Throwable -> L28
        KevaValueWrapper r100 = this.mValueMap.remove(r110);     // Catch: Throwable -> L23
        if (r100 != null) goto L10;
        long r101 = 0;
    L12:
        if (this.mIsMultiProcess == false) goto L14;
    L17:
        erase(this.mHandle, r110, r101);     // Catch: Throwable -> L23
        if (r100 == null) goto L26;
        r100.value = null;     // Catch: Throwable -> L23
        r100.offset = 0;     // Catch: Throwable -> L23
        if (this.mIsMultiProcess == true) goto L26;
        r100.loaded = true;     // Catch: Throwable -> L23
    L26:
        monitor-exit(this);     // Catch: Throwable -> L28
        return;
    L14:
        if (r101 != 0) goto L17;
        monitor-exit(this);     // Catch: Throwable -> L28
        return;
    L10:
        r101 = r100.offset;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        sMonitor.reportThrowable(4, this.mName, r110, null, th);     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        throw th;
    }

    public void init(boolean r100) {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.mHandle == 0) goto L7;
        monitor-exit(this);     // Catch: Throwable -> L10
        return;
    L7:
        doLoadRepo(r100);     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
    }

    @Override // com.bytedance.keva.Keva
    public void registerChangeListener(Keva.OnChangeListener r100) {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.mChangeListeners.contains(r100) == true) goto L6;
        this.mChangeListeners.add(r100);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);     // Catch: Throwable -> L8
    }

    @Override // com.bytedance.keva.Keva
    public void unRegisterChangeListener(Keva.OnChangeListener r100) {
        monitor-enter(this);
        this.mChangeListeners.remove(r100);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public static /* synthetic */ void access$300(KevaImpl r100, Context r101) {
        r100.doPortingFromSp(r101);
    }

    public static Keva getRepo(String r100, int r101) {
        return getRepoImpl(r100, null, r101, false);
    }

    public static Keva getRepoSync(String r100, int r101) {
        return getRepoImpl(r100, null, r101, true);
    }

    private void notifyChangeListeners(Keva r100, String r101) {
        if (this.mChangeListeners.size() != 0) goto L5;
        return;
    L5:
        Iterator<Keva.OnChangeListener> r102 = this.mChangeListeners.iterator();
    L7:
        if (r102.hasNext() == false) goto L9;
        r102.next().onChanged(r100, r101);
        goto L7
    }

    @Override // com.bytedance.keva.Keva
    public boolean getBoolean(String r100, boolean r101) {
        if ("".equals(r100) == false) goto L5;
        r100 = null;
    L5:
        String r102 = r100;
        monitor-enter(this);
        onRepoAccessLocked();     // Catch: Throwable -> L15
        boolean r103 = fetchBoolean(r102, r101);     // Catch: Throwable -> L11
        monitor-exit(this);     // Catch: Throwable -> L15
        return r103;
    L11:
        th = move-exception;
        sMonitor.reportThrowable(2, this.mName, r102, null, th);     // Catch: Throwable -> L15
        return r101;
    L15:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.keva.Keva
    public byte[] getBytes(String r100, byte[] r101) {
        if ("".equals(r100) == false) goto L5;
        r100 = null;
    L5:
        String r102 = r100;
        monitor-enter(this);
        onRepoAccessLocked();     // Catch: Throwable -> L16
        byte[] r103 = fetchBytes(r102, r101, 0, false);     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L16
        return r103;
    L12:
        th = move-exception;
        sMonitor.reportThrowable(2, this.mName, r102, r101, th);     // Catch: Throwable -> L16
        return r101;
    L16:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.keva.Keva
    public byte[] getBytesJustDisk(String r100, byte[] r101) {
        if ("".equals(r100) == false) goto L5;
        r100 = null;
    L5:
        String r102 = r100;
        monitor-enter(this);
        onRepoAccessLocked();     // Catch: Throwable -> L16
        byte[] r103 = fetchBytes(r102, r101, 0, true);     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L16
        return r103;
    L12:
        th = move-exception;
        sMonitor.reportThrowable(2, this.mName, r102, r101, th);     // Catch: Throwable -> L16
        return r101;
    L16:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.keva.Keva
    public double getDouble(String r100, double r101) {
        if ("".equals(r100) == false) goto L5;
        r100 = null;
    L5:
        String r102 = r100;
        monitor-enter(this);
        onRepoAccessLocked();     // Catch: Throwable -> L15
        double r103 = fetchDouble(r102, r101);     // Catch: Throwable -> L11
        monitor-exit(this);     // Catch: Throwable -> L15
        return r103;
    L11:
        th = move-exception;
        sMonitor.reportThrowable(2, this.mName, r102, Double.valueOf(r101), th);     // Catch: Throwable -> L15
        return r101;
    L15:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.keva.Keva
    public float getFloat(String r100, float r101) {
        if ("".equals(r100) == false) goto L5;
        r100 = null;
    L5:
        String r102 = r100;
        monitor-enter(this);
        onRepoAccessLocked();     // Catch: Throwable -> L15
        float r103 = fetchFloat(r102, r101);     // Catch: Throwable -> L11
        monitor-exit(this);     // Catch: Throwable -> L15
        return r103;
    L11:
        th = move-exception;
        sMonitor.reportThrowable(2, this.mName, r102, Float.valueOf(r101), th);     // Catch: Throwable -> L15
        return r101;
    L15:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.keva.Keva
    public int getInt(String r100, int r101) {
        if ("".equals(r100) == false) goto L5;
        r100 = null;
    L5:
        String r102 = r100;
        monitor-enter(this);
        onRepoAccessLocked();     // Catch: Throwable -> L15
        int r103 = fetchInt(r102, r101);     // Catch: Throwable -> L11
        monitor-exit(this);     // Catch: Throwable -> L15
        return r103;
    L11:
        th = move-exception;
        sMonitor.reportThrowable(2, this.mName, r102, Integer.valueOf(r101), th);     // Catch: Throwable -> L15
        return r101;
    L15:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.keva.Keva
    public long getLong(String r100, long r101) {
        if ("".equals(r100) == false) goto L5;
        r100 = null;
    L5:
        String r102 = r100;
        monitor-enter(this);
        onRepoAccessLocked();     // Catch: Throwable -> L15
        long r103 = fetchLong(r102, r101);     // Catch: Throwable -> L11
        monitor-exit(this);     // Catch: Throwable -> L15
        return r103;
    L11:
        th = move-exception;
        sMonitor.reportThrowable(2, this.mName, r102, Long.valueOf(r101), th);     // Catch: Throwable -> L15
        return r101;
    L15:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.keva.Keva
    public String getString(String r100, String r101) {
        if ("".equals(r100) == false) goto L5;
        r100 = null;
    L5:
        String r102 = r100;
        monitor-enter(this);
        onRepoAccessLocked();     // Catch: Throwable -> L16
        String r103 = fetchString(r102, r101, false);     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L16
        return r103;
    L12:
        th = move-exception;
        sMonitor.reportThrowable(2, this.mName, r102, r101, th);     // Catch: Throwable -> L16
        return r101;
    L16:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.keva.Keva
    public String[] getStringArray(String r100, String[] r101) {
        if ("".equals(r100) == false) goto L5;
        r100 = null;
    L5:
        String r102 = r100;
        monitor-enter(this);
        onRepoAccessLocked();     // Catch: Throwable -> L16
        String[] r103 = fetchStringArray(r102, r101, false);     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L16
        return r103;
    L12:
        th = move-exception;
        sMonitor.reportThrowable(2, this.mName, r102, r101, th);     // Catch: Throwable -> L16
        return r101;
    L16:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.keva.Keva
    public String[] getStringArrayJustDisk(String r100, String[] r101) {
        if ("".equals(r100) == false) goto L5;
        r100 = null;
    L5:
        String r102 = r100;
        monitor-enter(this);
        onRepoAccessLocked();     // Catch: Throwable -> L16
        String[] r103 = fetchStringArray(r102, r101, true);     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L16
        return r103;
    L12:
        th = move-exception;
        sMonitor.reportThrowable(2, this.mName, r102, r101, th);     // Catch: Throwable -> L16
        return r101;
    L16:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.keva.Keva
    public String getStringJustDisk(String r100, String r101) {
        if ("".equals(r100) == false) goto L5;
        r100 = null;
    L5:
        String r102 = r100;
        monitor-enter(this);
        onRepoAccessLocked();     // Catch: Throwable -> L16
        String r103 = fetchString(r102, r101, true);     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L16
        return r103;
    L12:
        th = move-exception;
        sMonitor.reportThrowable(2, this.mName, r102, r101, th);     // Catch: Throwable -> L16
        return r101;
    L16:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.keva.Keva
    public Set<String> getStringSet(String r100, Set<String> r101) {
        if ("".equals(r100) == false) goto L5;
        r100 = null;
    L5:
        String r102 = r100;
        monitor-enter(this);
        onRepoAccessLocked();     // Catch: Throwable -> L16
        Set<String> r103 = fetchStringSet(r102, r101, false);     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L16
        return r103;
    L12:
        th = move-exception;
        sMonitor.reportThrowable(2, this.mName, r102, r101, th);     // Catch: Throwable -> L16
        return r101;
    L16:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.keva.Keva
    public Set<String> getStringSetJustDisk(String r100, Set<String> r101) {
        if ("".equals(r100) == false) goto L5;
        r100 = null;
    L5:
        String r102 = r100;
        monitor-enter(this);
        onRepoAccessLocked();     // Catch: Throwable -> L16
        Set<String> r103 = fetchStringSet(r102, r101, true);     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L16
        return r103;
    L12:
        th = move-exception;
        sMonitor.reportThrowable(2, this.mName, r102, r101, th);     // Catch: Throwable -> L16
        return r101;
    L16:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.keva.Keva
    public void storeBoolean(String r110, boolean r111) {
        if ("".equals(r110) == false) goto L5;
        r110 = null;
    L5:
        monitor-enter(this);
        onRepoAccessLocked();     // Catch: Throwable -> L29
        KevaValueWrapper r100 = obtainWrapperLocked(r110);     // Catch: Throwable -> L29
        if (this.mIsMultiProcess == false) goto L9;
    L32:
        r100.offset = storeBoolean(this.mHandle, r110, r100.offset, r111);     // Catch: Throwable -> L24
        r100.value = Boolean.valueOf(r111);     // Catch: Throwable -> L24
        if (this.mIsMultiProcess == true) goto L20;
        r100.loaded = true;     // Catch: Throwable -> L24
    L20:
        if (this.mIsMultiProcess == false) goto L22;
        r100.value = null;     // Catch: Throwable -> L24
    L22:
        notifyChangeListeners(this, r110);     // Catch: Throwable -> L24
    L27:
        monitor-exit(this);     // Catch: Throwable -> L29
        return;
    L24:
        th = move-exception;
        sMonitor.reportThrowable(3, this.mName, r110, Boolean.valueOf(r111), th);     // Catch: Throwable -> L29
        goto L27
    L9:
        if (r100.loaded == false) goto L32;
        if (r100.value == null) goto L32;
        if (r100.value.equals(Boolean.valueOf(r111)) == false) goto L32;
        monitor-exit(this);     // Catch: Throwable -> L29
        return;
    L29:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.keva.Keva
    public void storeBytes(String r100, byte[] r101) {
        storeBytes(r100, r101, 0, false);
    }

    @Override // com.bytedance.keva.Keva
    public void storeBytesJustDisk(String r100, byte[] r101) {
        storeBytes(r100, r101, 0, true);
    }

    @Override // com.bytedance.keva.Keva
    public void storeDouble(String r110, double r111) {
        if ("".equals(r110) == false) goto L5;
        r110 = null;
    L5:
        monitor-enter(this);
        onRepoAccessLocked();     // Catch: Throwable -> L29
        KevaValueWrapper r100 = obtainWrapperLocked(r110);     // Catch: Throwable -> L29
        if (this.mIsMultiProcess == false) goto L9;
    L32:
        r100.offset = storeDouble(this.mHandle, r110, r100.offset, r111);     // Catch: Throwable -> L24
        r100.value = Double.valueOf(r111);     // Catch: Throwable -> L24
        if (this.mIsMultiProcess == true) goto L20;
        r100.loaded = true;     // Catch: Throwable -> L24
    L20:
        if (this.mIsMultiProcess == false) goto L22;
        r100.value = null;     // Catch: Throwable -> L24
    L22:
        notifyChangeListeners(this, r110);     // Catch: Throwable -> L24
    L27:
        monitor-exit(this);     // Catch: Throwable -> L29
        return;
    L24:
        th = move-exception;
        sMonitor.reportThrowable(3, this.mName, r110, Double.valueOf(r111), th);     // Catch: Throwable -> L29
        goto L27
    L9:
        if (r100.loaded == false) goto L32;
        if (r100.value == null) goto L32;
        if (r100.value.equals(Double.valueOf(r111)) == false) goto L32;
        monitor-exit(this);     // Catch: Throwable -> L29
        return;
    L29:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.keva.Keva
    public void storeFloat(String r110, float r111) {
        if ("".equals(r110) == false) goto L5;
        r110 = null;
    L5:
        monitor-enter(this);
        onRepoAccessLocked();     // Catch: Throwable -> L29
        KevaValueWrapper r100 = obtainWrapperLocked(r110);     // Catch: Throwable -> L29
        if (this.mIsMultiProcess == false) goto L9;
    L32:
        r100.offset = storeFloat(this.mHandle, r110, r100.offset, r111);     // Catch: Throwable -> L24
        r100.value = Float.valueOf(r111);     // Catch: Throwable -> L24
        if (this.mIsMultiProcess == true) goto L20;
        r100.loaded = true;     // Catch: Throwable -> L24
    L20:
        if (this.mIsMultiProcess == false) goto L22;
        r100.value = null;     // Catch: Throwable -> L24
    L22:
        notifyChangeListeners(this, r110);     // Catch: Throwable -> L24
    L27:
        monitor-exit(this);     // Catch: Throwable -> L29
        return;
    L24:
        th = move-exception;
        sMonitor.reportThrowable(3, this.mName, r110, Float.valueOf(r111), th);     // Catch: Throwable -> L29
        goto L27
    L9:
        if (r100.loaded == false) goto L32;
        if (r100.value == null) goto L32;
        if (r100.value.equals(Float.valueOf(r111)) == false) goto L32;
        monitor-exit(this);     // Catch: Throwable -> L29
        return;
    L29:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.keva.Keva
    public void storeInt(String r110, int r111) {
        if ("".equals(r110) == false) goto L5;
        r110 = null;
    L5:
        monitor-enter(this);
        onRepoAccessLocked();     // Catch: Throwable -> L29
        KevaValueWrapper r100 = obtainWrapperLocked(r110);     // Catch: Throwable -> L29
        if (this.mIsMultiProcess == false) goto L9;
    L32:
        r100.offset = storeInt(this.mHandle, r110, r100.offset, r111);     // Catch: Throwable -> L24
        r100.value = Integer.valueOf(r111);     // Catch: Throwable -> L24
        if (this.mIsMultiProcess == true) goto L20;
        r100.loaded = true;     // Catch: Throwable -> L24
    L20:
        if (this.mIsMultiProcess == false) goto L22;
        r100.value = null;     // Catch: Throwable -> L24
    L22:
        notifyChangeListeners(this, r110);     // Catch: Throwable -> L24
    L27:
        monitor-exit(this);     // Catch: Throwable -> L29
        return;
    L24:
        th = move-exception;
        sMonitor.reportThrowable(3, this.mName, r110, Integer.valueOf(r111), th);     // Catch: Throwable -> L29
        goto L27
    L9:
        if (r100.loaded == false) goto L32;
        if (r100.value == null) goto L32;
        if (r100.value.equals(Integer.valueOf(r111)) == false) goto L32;
        monitor-exit(this);     // Catch: Throwable -> L29
        return;
    L29:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.keva.Keva
    public void storeLong(String r110, long r111) {
        if ("".equals(r110) == false) goto L5;
        r110 = null;
    L5:
        monitor-enter(this);
        onRepoAccessLocked();     // Catch: Throwable -> L29
        KevaValueWrapper r100 = obtainWrapperLocked(r110);     // Catch: Throwable -> L29
        if (this.mIsMultiProcess == false) goto L9;
    L32:
        r100.offset = storeLong(this.mHandle, r110, r100.offset, r111);     // Catch: Throwable -> L24
        r100.value = Long.valueOf(r111);     // Catch: Throwable -> L24
        if (this.mIsMultiProcess == true) goto L20;
        r100.loaded = true;     // Catch: Throwable -> L24
    L20:
        if (this.mIsMultiProcess == false) goto L22;
        r100.value = null;     // Catch: Throwable -> L24
    L22:
        notifyChangeListeners(this, r110);     // Catch: Throwable -> L24
    L27:
        monitor-exit(this);     // Catch: Throwable -> L29
        return;
    L24:
        th = move-exception;
        sMonitor.reportThrowable(3, this.mName, r110, Long.valueOf(r111), th);     // Catch: Throwable -> L29
        goto L27
    L9:
        if (r100.loaded == false) goto L32;
        if (r100.value == null) goto L32;
        if (r100.value.equals(Long.valueOf(r111)) == false) goto L32;
        monitor-exit(this);     // Catch: Throwable -> L29
        return;
    L29:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.keva.Keva
    public void storeString(String r100, String r101) {
        storeString(r100, r101, false);
    }

    @Override // com.bytedance.keva.Keva
    public void storeStringArray(String r100, String[] r101) {
        storeStringArray(r100, r101, false);
    }

    @Override // com.bytedance.keva.Keva
    public void storeStringArrayJustDisk(String r100, String[] r101) {
        storeStringArray(r100, r101, true);
    }

    @Override // com.bytedance.keva.Keva
    public void storeStringJustDisk(String r100, String r101) {
        storeString(r100, r101, true);
    }

    @Override // com.bytedance.keva.Keva
    public void storeStringSet(String r100, Set<String> r101) {
        storeStringSet(r100, r101, false);
    }

    @Override // com.bytedance.keva.Keva
    public void storeStringSetJustDisk(String r100, Set<String> r101) {
        storeStringSet(r100, r101, true);
    }

    public KevaImpl(String r100, String r101, int r102) {
        this.mValueMap = new HashMap();
        boolean r103 = false;
        this.mLastAccessIndex = 0;
        this.mLastTryClearIndex = -1;
        this.mChangeListeners = new ArrayList();
        this.mDuplicatedOldWrappers = new ArrayList();
        this.mBigValueAccessIndex = 0;
        this.mLastClearAccessIndex = -1;
        this.mName = r100;
        this.mMode = r102;
        this.mSpecifiedPath = r101;
        if ((r102 & 1) == 0) goto L5;
        r103 = true;
    L5:
        this.mIsMultiProcess = r103;
    }

    private Set<String> fetchStringSet(String r100, Set<String> r101, boolean r102) {
        if (r101 == null) goto L5;
        String[] r103 = (String[]) r101.toArray(new String[0]);
    L6:
        String[] r104 = fetchStringArray(r100, r103, r102);
        if (r104 != null) goto L9;
        return null;
    L9:
        return new HashSet(Arrays.asList(r104));
    L5:
        r103 = null;
        goto L6
    }

    public static KevaImpl getEmptyRepoImpl(String r100, String r101, int r102) {
        if (r102 >= 0) goto L4;
    L5:
        sMonitor.reportThrowable(1, r100, null, null, new IllegalArgumentException("mode is not valid: " + r102));
    L7:
        if ((r102 & 1) != 0) goto L10;
        return new KevaPrivateImpl(r100, r101, r102);
    L10:
        return new KevaMultiProcessImpl(r100, r101, r102);
    L4:
        if (r102 < 2) goto L7;
        goto L5
    }

    public static Keva getRepoFromSp(Context r100, String r101, int r102) {
        return getRepoFromSpImpl(r100, r101, r102, false);
    }

    public static Keva getRepoFromSpSync(Context r100, String r101, int r102) {
        return getRepoFromSpImpl(r100, r101, r102, true);
    }

    public static Keva getRepoSyncWithPath(String r100, String r101, int r102) {
        if (r101 == null) goto L12;
        if ("".equals(r101) == true) goto L12;
        if (r101.startsWith(HTTP.URL_DEFAULT) == true) goto L12;
        if (r101.endsWith(HTTP.URL_DEFAULT) == false) goto L12;
        return getRepoImpl(r100, r101, r102, true);
    L12:
        throw new IllegalArgumentException("path is wrong: " + r101);
    }

    private void reportBigValue(final String r100, final Object r101, final int r102) {
        if (r102 <= 10000) goto L6;
        sExecutor.execute(new AnonymousClass5(this, r100, r101, r102));
        return;
    }

    private void storeString(final String r110, final String r111, boolean r112) {
        if ("".equals(r110) == false) goto L5;
        r110 = null;
    L5:
        monitor-enter(this);
        onRepoAccessLocked();     // Catch: Throwable -> L36
        KevaValueWrapper r100 = obtainWrapperLocked(r110);     // Catch: Throwable -> L36
        if (this.mIsMultiProcess == false) goto L9;
    L39:
        r100.offset = storeString(this.mHandle, r110, r100.offset, r111);     // Catch: Throwable -> L27
        r100.type = 6;     // Catch: Throwable -> L27
        if (r112 == true) goto L24;
        r100.value = r111;     // Catch: Throwable -> L27
        if (this.mIsMultiProcess == true) goto L22;
        r100.loaded = true;     // Catch: Throwable -> L27
    L22:
        if (this.mIsMultiProcess == false) goto L25;
        r100.value = null;     // Catch: Throwable -> L27
    L25:
        notifyChangeListeners(this, r110);     // Catch: Throwable -> L27
    L30:
        monitor-exit(this);     // Catch: Throwable -> L36
        if (r111 == null) goto L42;
        final int r113 = r111.length();
        if (r113 <= 10000) goto L43;
        sExecutor.execute(new AnonymousClass6(this, r110, r111, r113));
        return;
    L43:
        return;
    L42:
        return;
    L24:
        r100.value = null;     // Catch: Throwable -> L27
        r100.loaded = false;     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        sMonitor.reportThrowable(3, this.mName, r110, r111, th);     // Catch: Throwable -> L36
        goto L30
    L9:
        if (r100.loaded == false) goto L39;
        if (r100.value == null) goto L39;
        if (r100.value.equals(r111) == false) goto L39;
        monitor-exit(this);     // Catch: Throwable -> L36
        return;
    L36:
        th = move-exception;
        throw th;
    }

    private void storeStringArray(final String r110, String[] r111, boolean r112) {
        if ("".equals(r110) == false) goto L5;
        r110 = null;
    L5:
        monitor-enter(this);
        onRepoAccessLocked();     // Catch: Throwable -> L27
        KevaValueWrapper r100 = obtainWrapperLocked(r110);     // Catch: Throwable -> L27
        r100.offset = storeStringArray(this.mHandle, r110, r100.offset, r111, 3);     // Catch: Throwable -> L18
        r100.type = 55;     // Catch: Throwable -> L18
        if (r112 == true) goto L15;
        r100.value = r111;     // Catch: Throwable -> L18
        if (this.mIsMultiProcess == true) goto L13;
        r100.loaded = true;     // Catch: Throwable -> L18
    L13:
        if (this.mIsMultiProcess == false) goto L16;
        r100.value = null;     // Catch: Throwable -> L18
    L16:
        notifyChangeListeners(this, r110);     // Catch: Throwable -> L18
    L21:
        monitor-exit(this);     // Catch: Throwable -> L27
        if (r111 == null) goto L34;
        final String r113 = Arrays.toString(r111);
        final int r114 = r113.length();
        if (r114 <= 10000) goto L35;
        sExecutor.execute(new AnonymousClass8(this, r110, r113, r114));
        return;
    L35:
        return;
    L34:
        return;
    L15:
        r100.value = null;     // Catch: Throwable -> L18
        r100.loaded = false;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        sMonitor.reportThrowable(3, this.mName, r110, null, th);     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        throw th;
    }

    private void storeStringSet(String r100, Set<String> r101, boolean r102) {
        if (r101 == null) goto L4;
        String[] r103 = new String[r101.size()];
        r101.toArray(r103);
    L5:
        storeStringArray(r100, r103, r102);
        return;
    L4:
        r103 = null;
        goto L5
    }

    public void addMapBoolWhenLoading(String r100, boolean r101, long r102) {
        addMapObjectWhenLoading(r100, Boolean.valueOf(r101), r102, 2);
    }

    public void addMapDoubleWhenLoading(String r100, double r101, long r110) {
        addMapObjectWhenLoading(r100, Double.valueOf(r101), r110, 5);
    }

    public void addMapFloatWhenLoading(String r100, float r101, long r102) {
        addMapObjectWhenLoading(r100, Float.valueOf(r101), r102, 4);
    }

    public void addMapIntWhenLoading(String r100, int r101, long r102) {
        addMapObjectWhenLoading(r100, Integer.valueOf(r101), r102, 1);
    }

    public void addMapLongWhenLoading(String r100, long r101, long r110) {
        addMapObjectWhenLoading(r100, Long.valueOf(r101), r110, 3);
    }

    public void addMapOffsetWhenLoading(String r100, long r101, int r102) {
        if ("".equals(r100) == false) goto L5;
        r100 = null;
    L5:
        KevaValueWrapper r103 = new KevaValueWrapper();
        r103.offset = r101;
        r103.type = r102;
        KevaValueWrapper r104 = this.mValueMap.put(r100, r103);
        if (r104 == null) goto L11;
        List<KevaValueWrapper> r105 = this.mDuplicatedOldWrappers;
        if (r105 == null) goto L12;
        r105.add(r104);
        return;
    L12:
        return;
    }

    private void addMapObjectWhenLoading(String r100, Object r101, long r102, int r103) {
        if ("".equals(r100) == false) goto L5;
        r100 = null;
    L5:
        KevaValueWrapper r104 = new KevaValueWrapper();
        r104.value = r101;
        r104.offset = r102;
        r104.type = r103;
        if (this.mIsMultiProcess == true) goto L9;
        r104.loaded = true;
    L9:
        if (this.mIsMultiProcess == false) goto L11;
        r104.value = null;
    L11:
        KevaValueWrapper r105 = this.mValueMap.put(r100, r104);
        if (r105 == null) goto L17;
        List<KevaValueWrapper> r106 = this.mDuplicatedOldWrappers;
        if (r106 == null) goto L18;
        r106.add(r105);
        return;
    L18:
        return;
    }

    private static Keva getRepoFromSpImpl(final Context r110, final String r111, final int r112, boolean r113) {
        if (isRepoPorted(r111) == true) goto L5;
        boolean r100 = true;
        if (existSharedPrefs(r111) == true) goto L10;
        getPortedSpRepo().storeBoolean(r111, true);
        return getRepo(r111, r112);
    L10:
        boolean r101 = false;
        if (sMainThreadPriorityOpt == true) goto L13;
    L17:
        final boolean r102 = false;
    L18:
        sMonitor.logDebug("do poring from sp: " + r111);
        if (sGetRepoLockOpt == false) goto L43;
        ConcurrentHashMap<String, Object> r103 = sRepoMap;
        Object r104 = r103.get(r111);
        if (r104 != null) goto L27;
        r104 = new Object();
        Object r105 = r103.putIfAbsent(r111, r104);
        if (r105 == null) goto L27;
        r104 = r105;
    L27:
        if ((r104 instanceof Keva) == true) goto L42;
        monitor-enter(r104);
        Object r106 = r103.get(r111);     // Catch: Throwable -> L39
        if ((r106 instanceof Keva) == true) goto L36;
        if (r113 == false) goto L34;
        Object r114 = getEmptyRepoImpl(r111, null, r112);     // Catch: Throwable -> L39
    L33:
        r106 = r114;
        r103.put(r111, r106);     // Catch: Throwable -> L39
    L37:
        monitor-exit(r104);     // Catch: Throwable -> L39
        r101 = r100;
        r104 = r106;
        goto L42
    L34:
        r114 = new KevaFuture(r111, r112, new AnonymousClass3(r102, r111, r112, r110));     // Catch: Throwable -> L39
        goto L33
    L36:
        r100 = false;
    L39:
        th = move-exception;
        throw th;
    L42:
        Keva r107 = (Keva) r104;
    L56:
        if (r101 == false) goto L64;
        if ((r107 instanceof KevaImpl) == true) goto L73;
    L67:
        return r107;
    L73:
        ((KevaImpl) r107).doPortingFromSp(r110);     // Catch: UnsatisfiedLinkError -> L61
    L61:
        e = move-exception;
        sMonitor.reportThrowable(1, r111, null, null, e);
        goto L67
    L64:
        if ((r107 instanceof KevaImpl) == false) goto L66;
        ((KevaImpl) r107).checkMode(r112);
        goto L67
    L66:
        ((KevaFuture) r107).checkMode(r112);
        goto L67
    L43:
        ConcurrentHashMap<String, Object> r108 = sRepoMap;
        monitor-enter(r108);
        r107 = (Keva) r108.get(r111);     // Catch: Throwable -> L68
        if (r107 == null) goto L49;
        r100 = false;
    L49:
        if (r100 == false) goto L54;
        if (r113 == false) goto L52;
        Keva r115 = getEmptyRepoImpl(r111, null, r112);     // Catch: Throwable -> L68
    L53:
        r108.put(r111, r115);     // Catch: Throwable -> L68
        r107 = r115;
        goto L54
    L52:
        r115 = new KevaFuture(r111, r112, new AnonymousClass4(r102, r111, r112, r110));     // Catch: Throwable -> L68
    L54:
        monitor-exit(r108);     // Catch: Throwable -> L68
        r101 = r100;
    L68:
        th = move-exception;
        throw th;
    L13:
        if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()) != ThreadMethodProxy.currentThread()) goto L17;
        if (sPriorityValue == 0) goto L17;
        r102 = true;
        goto L18
    L5:
        return getRepo(r111, r112);
    }

    private static Keva getRepoImpl(final String r100, final String r101, final int r110, boolean r111) {
        if (r101 != null) goto L4;
        ConcurrentHashMap<String, Object> r102 = sRepoMap;
    L5:
        boolean r103 = true;
        if (sMainThreadPriorityOpt == true) goto L8;
    L12:
        final boolean r104 = false;
    L13:
        boolean r105 = sGetRepoLockOpt;
        if (r105 == false) goto L38;
        Object r106 = r102.get(r100);
        if (r106 != null) goto L22;
        r106 = new Object();
        Object r107 = r102.putIfAbsent(r100, r106);
        if (r107 == null) goto L22;
        r106 = r107;
    L22:
        if ((r106 instanceof Keva) == false) goto L24;
        Keva r108 = (Keva) r106;
        r103 = false;
    L49:
        if (r103 == true) goto L57;
        if (r105 == true) goto L57;
        if ((r108 instanceof KevaFuture) == true) goto L55;
        ((KevaImpl) r108).checkMode(r110);
    L59:
        return r108;
    L55:
        ((KevaFuture) r108).checkMode(r110);
    L57:
        if ((r108 instanceof KevaFuture) == true) goto L59;
        ((KevaImpl) r108).init(false);
        goto L59
    L24:
        monitor-enter(r106);
        Object r109 = r102.get(r100);     // Catch: Throwable -> L35
        if ((r109 instanceof Keva) == false) goto L28;
        r103 = false;
    L32:
        Keva r112 = (Keva) r109;     // Catch: Throwable -> L35
        monitor-exit(r106);     // Catch: Throwable -> L35
        r108 = r112;
        goto L49
    L28:
        if (r111 == false) goto L30;
        r109 = getEmptyRepoImpl(r100, r101, r110);     // Catch: Throwable -> L35
    L31:
        r102.put(r100, r109);     // Catch: Throwable -> L35
        goto L32
    L30:
        r109 = new KevaFuture(r100, r110, new AnonymousClass1(r104, r100, r101, r110));     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        throw th;
    L38:
        monitor-enter(r102);
        r108 = (Keva) r102.get(r100);     // Catch: Throwable -> L60
        if (r108 == null) goto L43;
        r103 = false;
    L43:
        if (r103 == false) goto L48;
        if (r111 == false) goto L46;
        Keva r113 = getEmptyRepoImpl(r100, r101, r110);     // Catch: Throwable -> L60
    L47:
        r102.put(r100, r113);     // Catch: Throwable -> L60
        r108 = r113;
        goto L48
    L46:
        r113 = new KevaFuture(r100, r110, new AnonymousClass2(r104, r100, r101, r110));     // Catch: Throwable -> L60
    L48:
        monitor-exit(r102);     // Catch: Throwable -> L60
    L60:
        th = move-exception;
        throw th;
    L8:
        if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()) != ThreadMethodProxy.currentThread()) goto L12;
        if (sPriorityValue == 0) goto L12;
        r104 = true;
        goto L13
    L4:
        ConcurrentHashMap<String, ConcurrentHashMap<String, Object>> r114 = sPathRepoMap;
        r114.putIfAbsent(r101, new ConcurrentHashMap());
        r102 = r114.get(r101);
        goto L5
    }

    private void storeBytes(final String r110, byte[] r111, int r112, boolean r113) {
        if ("".equals(r110) == false) goto L5;
        r110 = null;
    L5:
        monitor-enter(this);
        onRepoAccessLocked();     // Catch: Throwable -> L27
        KevaValueWrapper r100 = obtainWrapperLocked(r110);     // Catch: Throwable -> L27
        r100.offset = storeBytes(this.mHandle, r110, r100.offset, r111, r112);     // Catch: Throwable -> L18
        r100.type = (r112 << 4) | 7;     // Catch: Throwable -> L18
        if (r113 == true) goto L15;
        r100.value = r111;     // Catch: Throwable -> L18
        if (this.mIsMultiProcess == true) goto L13;
        r100.loaded = true;     // Catch: Throwable -> L18
    L13:
        if (this.mIsMultiProcess == false) goto L16;
        r100.value = null;     // Catch: Throwable -> L18
    L16:
        notifyChangeListeners(this, r110);     // Catch: Throwable -> L18
    L21:
        monitor-exit(this);     // Catch: Throwable -> L27
        if (r111 == null) goto L34;
        final int r114 = r111.length;
        if (r114 <= 10000) goto L35;
        sExecutor.execute(new AnonymousClass7(this, r110, r114));
        return;
    L35:
        return;
    L34:
        return;
    L15:
        r100.value = null;     // Catch: Throwable -> L18
        r100.loaded = false;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        sMonitor.reportThrowable(3, this.mName, r110, r111, th);     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        throw th;
    }

    public static void passWarning(int r100, String r101, String r102, Object r103, String r110) {
        sMonitor.reportWarning(r100, r101, r102, r103, r110);
    }
}
