package com.ss.videoarch.live.ttquic;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import android.util.LruCache;
import com.bytedance.android.livehostapi.platform.base.IBaseHostPerformanceMonitor;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import com.ss.mediakit.medialoader.AVMDLDataLoader;
import com.ss.ttvideoengine.net.DNSParser;
import com.ss.ttvideoengine.utils.Error;
import java.io.File;
import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public class PreloadManager {
    private static final int CORE_POOL_SIZE = 1;
    private static final String EVENT_THREAD_NAME = "tt_preload_event";
    private static final int MAXIMUM_POOL_SIZE = 1;
    public static final int PRELOAD_TASK_PLAY = 1;
    public static final int PRELOAD_TASK_PRELOAD = 0;
    private static final int TASK_MAX_SIZE = 64;
    private static final int TASK_QUEUE_MAX_SIZE = 64;
    private static boolean mInitialized;
    private Context mContext;
    private c mCurrentTask;
    private int mEnableCancelAll;
    private Handler mEventHandler;
    private HandlerThread mEventThread;
    private final Object mListenerLock;
    private final HashMap<Integer, PreloadListener> mListeners;
    private int mMpdPreloadMinSec;
    private long mNativePtr;
    private int mOptCancelTask;
    private int mPlayCacheMaxAgeSec;
    private final Stack<Integer> mPlayerIds;
    private int mPreloadCacheMaxAgeSec;
    private final ThreadPoolExecutor mPreloadExecutor;
    private final Set<String> mPreloadList;
    private String mQuicScfgPath;
    private int mRequestOpenTimeout;
    private int mRequestReadTimeout;
    private final Object mTaskLock;
    private final LruCache<String, c> mTasks;

    public class a implements Handler.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PreloadManager f458590a;

        public a(PreloadManager r100) {
            this.f458590a = r100;
        }

        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message r100) {
            TTEvent r101 = (TTEvent) r100.obj;
            PreloadManager.access$400(this.f458590a, r101);
            if (TextUtils.isEmpty(r101.url) == true) goto L16;
            c r102 = (c) PreloadManager.access$600(this.f458590a).get(PreloadManager.access$500(this.f458590a, r101.url));
            if (r102 == null) goto L20;
            r101.bundle = r102.f458600i;
            r101.mode = r102.f458598g;
            Object r103 = PreloadManager.access$700(this.f458590a);
            monitor-enter(r103);
            PreloadListener r104 = (PreloadListener) PreloadManager.access$800(this.f458590a).get(Integer.valueOf(r102.f458593b));     // Catch: Throwable -> L13
            if (r104 == null) goto L11;
            Bundle r105 = new Bundle();     // Catch: Throwable -> L13
            r105.putInt("preload_event", r101.what);     // Catch: Throwable -> L13
            r105.putString("preload_url", r101.url);     // Catch: Throwable -> L13
            r105.putString("preload_error", r101.error);     // Catch: Throwable -> L13
            r105.putInt("preload_code", r101.code);     // Catch: Throwable -> L13
            r105.putInt("preload_sub_code", r101.subCode);     // Catch: Throwable -> L13
            r105.putInt("preload_num", r101.preloadNum);     // Catch: Throwable -> L13
            r105.putInt("video_cached_num", r101.videoCachedNum);     // Catch: Throwable -> L13
            r105.putInt("audio_cached_num", r101.audioCachedNum);     // Catch: Throwable -> L13
            r105.putInt("video_init_section_cached", r101.videoInitSectionCached);     // Catch: Throwable -> L13
            r105.putInt("audio_init_section_cached", r101.audioInitSectionCached);     // Catch: Throwable -> L13
            r105.putLong("cache_read_bytes", r101.cacheReadBytes);     // Catch: Throwable -> L13
            r105.putLong("cache_write_bytes", r101.cacheWriteBytes);     // Catch: Throwable -> L13
            r105.putInt("cache_mode", r101.cacheMode);     // Catch: Throwable -> L13
            r105.putInt("cache_frame_count", r101.cacheFrameCount);     // Catch: Throwable -> L13
            r105.putLong("cache_duration", r101.cacheDuration);     // Catch: Throwable -> L13
            r105.putInt(IBaseHostPerformanceMonitor.CACHE_BITMAP_MEMORY_SIZE, r101.cacheSize);     // Catch: Throwable -> L13
            r105.putLong("cancel_cost_time", r101.cancelCostTime);     // Catch: Throwable -> L13
            r105.putInt("opt_cancel_task", r101.optCancelTask);     // Catch: Throwable -> L13
            r105.putInt("mode", r101.mode);     // Catch: Throwable -> L13
            r105.putBundle("ext_info", r101.bundle);     // Catch: Throwable -> L13
            r104.onPreloadEvent(r101.what, r105);     // Catch: Throwable -> L13
        L11:
            monitor-exit(r103);     // Catch: Throwable -> L13
            return true;
        L13:
            th = move-exception;
            throw th;
        L20:
            return true;
        L16:
            return true;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final PreloadManager f458591a = null;

        static {
            f458591a = new PreloadManager(null);
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f458592a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f458593b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final AtomicInteger f458594c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f458595d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f458596e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f458597f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f458598g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public TTRequestParam f458599h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public Bundle f458600i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final CountDownLatch f458601j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final /* synthetic */ PreloadManager f458602k;

        public final void a() {
            if (this.f458594c.get() != 1) goto L5;
        L7:
            PreloadManager r100 = this.f458602k;
            int r101 = PreloadManager.access$1100(r100, PreloadManager.access$1000(r100), this.f458599h);
            if (r101 == 0) goto L18;
            String r102 = "invoke native_preload error";
        L15:
            if (r101 == 0) goto L20;
            TTEvent r103 = new TTEvent();
            r103.what = 2;
            r103.url = this.f458592a;
            r103.error = r102;
            r103.code = r101;
            Message r104 = PreloadManager.access$1200(this.f458602k).obtainMessage();
            r104.what = r103.what;
            r104.obj = r103;
            PreloadManager.access$1200(this.f458602k).sendMessage(r104);
            return;
        L20:
            return;
        L18:
            this.f458601j.await();     // Catch: InterruptedException -> L12
        L14:
            r102 = "";
        L12:
            e = move-exception;
            e.printStackTrace();
            goto L14
        L5:
            if (this.f458594c.get() == 6) goto L7;
            r102 = String.format("PreloadTask state invalid : %d", new Object[]{Integer.valueOf(this.f458594c.get())});
            r101 = -3007;
            goto L15
        }

        public final String toString() {
            return "PreloadTask{url='" + this.f458592a + "', playerId=" + this.f458593b + ", state=" + this.f458594c + ", cachedTime=" + this.f458595d + ", code=" + this.f458597f + ", mode=" + this.f458598g + ", requestParam=" + this.f458599h + ", scheduleTime=" + this.f458596e + '}';
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public c(PreloadManager r100) {
            this.f458602k = r100;
            this.f458592a = "";
            this.f458593b = -1;
            this.f458594c = new AtomicInteger(0);
            this.f458595d = -1;
            this.f458596e = -1;
            this.f458597f = 0;
            this.f458598g = -1;
            this.f458601j = new CountDownLatch(1);
        }
    }

    public static class d implements ThreadFactory {
        public d() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable r100) {
            return new PthreadThreadV2(r100, "PreloadExecutor");
        }
    }

    public static class e implements Comparator<c> {
        public e() {
        }

        @Override // java.util.Comparator
        public final int compare(c r100, c r101) {
            c r102 = r100;
            c r103 = r101;
            int r104 = r102.f458598g;
            int r105 = r103.f458598g;
            if (r104 != r105) goto L6;
            long r106 = r102.f458596e;
            long r107 = r103.f458596e;
        L12:
            return (int) (r106 - r107);
        L6:
            if (r104 != 1) goto L8;
            return -1;
        L8:
            if (r105 == 1) goto L14;
            r106 = r102.f458596e;
            r107 = r103.f458596e;
            goto L12
        L14:
            return 1;
        }
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    private native int native_cancel(long r100, String r101);

    private native int native_destroy(long r100);

    private native long native_init(TTEngineParam r100, Handler r101);

    private native int native_preload(long r100, TTRequestParam r101);

    public int getActivePlayer() {
    L8:
        e = move-exception;
        e.toString();
        return 0;
    L4:
        if (this.mPlayerIds.isEmpty() == false) goto L6;
        return 0;
    L6:
        return this.mPlayerIds.peek().intValue();
    }

    private void destroyEvent() {
        Handler r100 = this.mEventHandler;
        if (r100 == null) goto L5;
        r100.removeCallbacksAndMessages(null);
        this.mEventHandler = null;
    L5:
        HandlerThread r101 = this.mEventThread;
        if (r101 == null) goto L9;
        r101.quit();
        this.mEventThread = null;
        return;
    }

    private int initContext() {
        Class r100 = INVOKESTATIC_com_ss_videoarch_live_ttquic_PreloadManager_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.ss.videoarch.live.ttquic.ContextUtils");     // Catch: Throwable -> L9
        if (r100 == null) goto L5;
        Method r101 = r100.getMethod("initApplicationContext", new Class[]{Context.class});     // Catch: Throwable -> L9
        r101.setAccessible(true);     // Catch: Throwable -> L9
        r101.invoke(null, new Object[]{this.mContext.getApplicationContext()});     // Catch: Throwable -> L9
    L5:
        Class r102 = INVOKESTATIC_com_ss_videoarch_live_ttquic_PreloadManager_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.ss.videoarch.live.ttquic.JNIUtils");     // Catch: Throwable -> L9
        if (r102 == null) goto L8;
        Method r103 = r102.getMethod("setClassLoader", new Class[]{ClassLoader.class});     // Catch: Throwable -> L9
        r103.setAccessible(true);     // Catch: Throwable -> L9
        r103.invoke(null, new Object[]{this.mContext.getClassLoader()});     // Catch: Throwable -> L9
    L8:
        return 0;
    L9:
        th = move-exception;
        th.toString();
        return -4002;
    }

    private int initEvent() {
        PthreadHandlerThreadV2 r100 = new PthreadHandlerThreadV2(EVENT_THREAD_NAME);     // Catch: Exception -> L5
        this.mEventThread = r100;     // Catch: Exception -> L5
        ThreadMethodProxy.start(r100);     // Catch: Exception -> L5
        this.mEventHandler = new Handler(this.mEventThread.getLooper(), new a(this));     // Catch: Exception -> L5
        return 0;
    L5:
        e = move-exception;
        e.toString();
        return -4003;
    }

    public int cancelAll() {
        if (this.mEnableCancelAll == 1) goto L5;
        return -1;
    L5:
        if (this.mNativePtr == 0) goto L26;
        String r100 = "";
        Object r101 = this.mTaskLock;
        monitor-enter(r101);
        c r102 = this.mCurrentTask;     // Catch: Throwable -> L18
        if (r102 == null) goto L12;
        r102.f458594c.set(3);     // Catch: Throwable -> L18
        r100 = this.mCurrentTask.f458592a;     // Catch: Throwable -> L18
    L12:
        monitor-exit(r101);     // Catch: Throwable -> L18
        if (TextUtils.isEmpty(r100) == true) goto L25;
        native_cancel(this.mNativePtr, r100);
        return 0;
    L25:
        return 0;
    L18:
        th = move-exception;
        throw th;
    L26:
        return -1;
    }

    public void destroy() {
        long r100 = this.mNativePtr;
        if (r100 == 0) goto L5;
        native_destroy(r100);
        this.mNativePtr = 0;
    L5:
        destroyEvent();
        Object r101 = this.mListenerLock;
        monitor-enter(r101);
        this.mListeners.clear();     // Catch: Throwable -> L11
        monitor-exit(r101);     // Catch: Throwable -> L11
        mInitialized = false;
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public int getCurrentTaskState() {
        Object r100 = this.mTaskLock;
        monitor-enter(r100);
        c r101 = this.mCurrentTask;     // Catch: Throwable -> L10
        if (r101 == null) goto L7;
        int r102 = r101.f458594c.get();     // Catch: Throwable -> L10
    L8:
        monitor-exit(r100);     // Catch: Throwable -> L10
        return r102;
    L7:
        r102 = 0;
    L10:
        th = move-exception;
        throw th;
    }

    private PreloadManager() {
        this.mNativePtr = 0;
        this.mEventThread = null;
        this.mEventHandler = null;
        this.mPreloadCacheMaxAgeSec = 600;
        this.mPlayCacheMaxAgeSec = 600;
        this.mRequestOpenTimeout = 5000;
        this.mRequestReadTimeout = 5000;
        this.mEnableCancelAll = 1;
        this.mMpdPreloadMinSec = -1;
        this.mOptCancelTask = 0;
        this.mListenerLock = new Object();
        this.mListeners = new HashMap();
        this.mPreloadList = new HashSet();
        this.mTasks = new LruCache(64);
        this.mTaskLock = new Object();
        this.mCurrentTask = null;
        this.mPlayerIds = new Stack();
        this.mPreloadExecutor = new PThreadPoolExecutor(1, 1, 0, TimeUnit.SECONDS, new PriorityBlockingQueue(64, new e()), new d());
    }

    private int loadLibrary() {
        com.ss.videoarch.live.ttquic.a.a("ttffmpeg");     // Catch: Throwable -> L19
        com.ss.videoarch.live.ttquic.a.a("ffmpeg_dashdec");     // Catch: Throwable -> L17
        com.ss.videoarch.live.ttquic.a.a("ttmcmaf");     // Catch: Throwable -> L15
        com.ss.videoarch.live.ttquic.a.a("vcbasekit");     // Catch: Throwable -> L13
        com.ss.videoarch.live.ttquic.a.a("ttquic");     // Catch: Throwable -> L11
        com.ss.videoarch.live.ttquic.a.a("ttpreload");     // Catch: Throwable -> L9
        return 0;
    L9:
        th = move-exception;
        th.toString();
        return -1004;
    L11:
        th = move-exception;
        th.toString();
        return -1001;
    L13:
        th = move-exception;
        th.toString();
        return -1006;
    L15:
        th = move-exception;
        th.toString();
        return -1002;
    L17:
        th = move-exception;
        th.toString();
        return -1005;
    L19:
        th = move-exception;
        th.toString();
        return -1003;
    }

    public static PreloadManager getInstance() {
        return b.f458591a;
    }

    public /* synthetic */ PreloadManager(a r100) {
        this();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_ss_videoarch_live_ttquic_PreloadManager_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class r103 = access$000(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r104 = access$000(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    public static /* synthetic */ long access$1000(PreloadManager r100) {
        return r100.mNativePtr;
    }

    public static /* synthetic */ Handler access$1200(PreloadManager r100) {
        return r100.mEventHandler;
    }

    public static /* synthetic */ LruCache access$600(PreloadManager r100) {
        return r100.mTasks;
    }

    public static /* synthetic */ Object access$700(PreloadManager r100) {
        return r100.mListenerLock;
    }

    public static /* synthetic */ HashMap access$800(PreloadManager r100) {
        return r100.mListeners;
    }

    private String cacheKey(String r100) {
        Uri.Builder r101 = UriProtector.parse(r100).buildUpon();
        r101.clearQuery();
        return r101.build().getPath();
    }

    private void updateTaskState(TTEvent r100) {
        if (r100.what != 0) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r100.url) == false) goto L8;
        return;
    L8:
        c r101 = this.mTasks.get(cacheKey(r100.url));
        if (r101 != null) goto L11;
        return;
    L11:
        Object r102 = this.mTaskLock;
        monitor-enter(r102);
        this.mCurrentTask = null;     // Catch: Throwable -> L23
        monitor-exit(r102);     // Catch: Throwable -> L23
        int r103 = r100.what;
        if (1 != r103) goto L20;
        r101.f458594c.set(4);
        r101.f458595d = System.currentTimeMillis();
        r101.f458601j.countDown();
        return;
    L20:
        if (2 != r103) goto L29;
        r101.f458594c.set(5);
        r101.f458597f = r100.code;
        r101.f458601j.countDown();
        return;
    L29:
        return;
    L23:
        th = move-exception;
        throw th;
    }

    public void attachPlayer(int r100) {
        this.mPlayerIds.push(Integer.valueOf(r100));
    }

    public int cancelAll(int r100) {
        if (this.mEnableCancelAll == 1) goto L5;
        return -1;
    L5:
        if (this.mNativePtr == 0) goto L13;
        c r101 = this.mCurrentTask;
        if (r101 == null) goto L14;
        r101.f458594c.set(3);
        native_cancel(this.mNativePtr, this.mCurrentTask.f458592a);
        return 0;
    L14:
        return -1;
    L13:
        return -1;
    }

    public void detachPlayer(int r100) {
        this.mPlayerIds.remove(Integer.valueOf(r100));     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.toString();
    }

    public void recordResource(String r100) {
        this.mPreloadList.add(r100);
        this.mPreloadList.size();
    }

    public void removeListener(int r100) {
        Object r101 = this.mListenerLock;
        monitor-enter(r101);
        this.mListeners.remove(Integer.valueOf(r100));     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static /* synthetic */ void access$400(PreloadManager r100, TTEvent r101) {
        r100.updateTaskState(r101);
    }

    public static /* synthetic */ String access$500(PreloadManager r100, String r101) {
        return r100.cacheKey(r101);
    }

    private int parseEngineParam(String r110, TTEngineParam r111) {
        JSONObject r100 = new JSONObject(r110);     // Catch: Exception -> L54
        if (r100.has("cacheMaxSize") == false) goto L7;
        r111.cacheMaxSize = r100.optInt("cacheMaxSize");     // Catch: Exception -> L54
    L7:
        if (r100.has("PreloadCacheMaxAge") == false) goto L10;
        this.mPreloadCacheMaxAgeSec = r100.optInt("PreloadCacheMaxAge");     // Catch: Exception -> L54
    L10:
        if (r100.has("PlayCacheMaxAge") == false) goto L13;
        this.mPlayCacheMaxAgeSec = r100.optInt("PlayCacheMaxAge");     // Catch: Exception -> L54
    L13:
        if (r100.has("openTimeout") == false) goto L16;
        this.mRequestOpenTimeout = r100.optInt("openTimeout");     // Catch: Exception -> L54
    L16:
        if (r100.has("readTimeout") == false) goto L19;
        this.mRequestReadTimeout = r100.optInt("readTimeout");     // Catch: Exception -> L54
    L19:
        if (r100.has("EnableCancelAll") == false) goto L22;
        this.mEnableCancelAll = r100.optInt("EnableCancelAll");     // Catch: Exception -> L54
    L22:
        if (r100.has("MpdPreloadMinSec") == false) goto L25;
        this.mMpdPreloadMinSec = r100.optInt("MpdPreloadMinSec");     // Catch: Exception -> L54
    L25:
        if (r100.has("optCancelTask") == false) goto L28;
        this.mOptCancelTask = r100.optInt("optCancelTask");     // Catch: Exception -> L54
    L28:
        if (r111.cacheMaxSize > 0) goto L30;
        r111.cacheMaxSize = 209715200;
    L30:
        StringBuilder r112 = new StringBuilder();
        r112.append(this.mContext.getFilesDir().getAbsolutePath());
        String r101 = File.separator;
        r112.append(r101);
        r112.append("live_preload");
        r111.cachePath = r112.toString();
        r111.flvCachePath = r111.cachePath + r101 + "flv";
        PolarisFileWrapper r113 = new PolarisFileWrapper(r111.cachePath);
        if (r113.exists() == false) goto L33;
    L35:
        PolarisFileWrapper r114 = new PolarisFileWrapper(r111.flvCachePath);
        if (r114.exists() == true) goto L41;
        if (r114.mkdirs() == true) goto L41;
        return -1;
    L41:
        if (this.mPreloadCacheMaxAgeSec > 0) goto L44;
        this.mPreloadCacheMaxAgeSec = 600;
    L44:
        if (this.mPlayCacheMaxAgeSec > 0) goto L47;
        this.mPlayCacheMaxAgeSec = 600;
    L47:
        if (this.mRequestOpenTimeout > 0) goto L50;
        this.mRequestOpenTimeout = 5000;
    L50:
        if (this.mRequestReadTimeout > 0) goto L59;
        this.mRequestReadTimeout = 5000;
        return 0;
    L59:
        return 0;
    L33:
        if (r113.mkdirs() == true) goto L35;
        return -1;
    L54:
        e = move-exception;
        e.printStackTrace();
        return -1;
    }

    public void addListener(int r100, Object r101) {
        Object r102 = this.mListenerLock;
        monitor-enter(r102);
    L9:
        th = move-exception;
        throw th;
    L5:
        if ((r101 instanceof PreloadListener) == false) goto L7;
        this.mListeners.put(Integer.valueOf(r100), (PreloadListener) r101);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r102);     // Catch: Throwable -> L9
    }

    public int cancel(int r100, String r101) {
        c r102 = this.mTasks.get(cacheKey(r101));
        if (r102 != null) goto L6;
        return -3002;
    L6:
        if (r102.f458593b == r100) goto L9;
        return -3003;
    L9:
        if (1 == r102.f458594c.get()) goto L11;
        return -3004;
    L11:
        r102.f458594c.set(3);
        native_cancel(this.mNativePtr, r101);
        return 0;
    }

    public Bundle getPreloadInfo(String r110, int r111) {
        Bundle r100 = new Bundle();
        long r101 = 0;
        int r102 = -1;
        String r103 = "";
        if (r111 == 0) goto L6;
        if (1 == r111) goto L6;
        int r112 = -2;
    L42:
        r100.putInt("preload_result", r112);
        r100.putLong("time_delta", r101);
        r100.putInt("preload_mode", r102);
        r100.putString("preload_resolution", r103);
        return r100;
    L6:
        String r113 = cacheKey(r110);
        c r114 = this.mTasks.get(r113);
        if (r114 != null) goto L13;
        if (this.mPreloadList.contains(r113) == false) goto L11;
        r112 = -3002;
        goto L42
    L11:
        r112 = -3009;
        goto L42
    L13:
        if (4 == r114.f458594c.get()) goto L25;
        if (6 == r114.f458594c.get()) goto L25;
        if (1 != r114.f458594c.get()) goto L21;
        r112 = -3001;
        goto L42
    L21:
        if (5 != r114.f458594c.get()) goto L23;
        r112 = r114.f458597f;
        goto L42
    L23:
        r112 = -999;
    L25:
        if (r114.f458595d <= 0) goto L41;
        r101 = System.currentTimeMillis() - r114.f458595d;
        if (r101 >= (((long) this.mPlayCacheMaxAgeSec) * 1000)) goto L40;
        int r115 = r114.f458598g;
        if (r115 != (-1)) goto L31;
        r112 = -3005;
        goto L42
    L31:
        int r104 = 0;
        if (r115 == 1) goto L34;
        r103 = r114.f458600i.getString("resolution", "");
        r112 = 0;
    L39:
        r102 = r114.f458598g;
        goto L42
    L34:
        if (r101 < r114.f458599h.cmafPreloadMPDExpMs) goto L37;
        r104 = -8002;
    L37:
        r112 = r104;
        goto L39
    L40:
        r112 = Error.RenderException;
        goto L42
    L41:
        r112 = -8001;
        goto L42
    }

    public int init(Context r100, String r101) {
        if (mInitialized == false) goto L5;
        return 0;
    L5:
        this.mContext = r100.getApplicationContext();
        this.mQuicScfgPath = r100.getFilesDir().getAbsolutePath() + "/pullstream.scfg";
        int r102 = loadLibrary();
        if (r102 == 0) goto L8;
        return r102;
    L8:
        TTEngineParam r103 = new TTEngineParam();
        int r104 = parseEngineParam(r101, r103);
        if (r104 == 0) goto L11;
        return r104;
    L11:
        int r105 = initContext();
        if (r105 == 0) goto L14;
        return r105;
    L14:
        int r106 = initEvent();
        if (r106 == 0) goto L17;
        return r106;
    L17:
        long r107 = native_init(r103, this.mEventHandler);
        this.mNativePtr = r107;
        if (r107 != 0) goto L21;
        return AVMDLDataLoader.AVMDLErrorIsInvalidRequestInfo;
    L21:
        mInitialized = true;
        return 0;
    }

    public static /* synthetic */ int access$1100(PreloadManager r100, long r101, TTRequestParam r102) {
        return r100.native_preload(r101, r102);
    }

    private int parseSdkParams(String r210, String r211, TTRequestParam r212) {
        r212.url = r210;     // Catch: Exception -> L85
        JSONObject r110 = new JSONObject(r211);     // Catch: Exception -> L85
        if (r110.has("cmaf") == false) goto L27;
        JSONObject r100 = new JSONObject(r110.optString("cmaf"));     // Catch: Exception -> L85
        if (r100.has("CmafEnableFastOpen") == false) goto L9;
        r212.cmafEnableFastOpen = r100.optInt("CmafEnableFastOpen");     // Catch: Exception -> L85
    L9:
        if (r100.has("CmafSkipInitSection") == false) goto L12;
        r212.cmafSkipInitSection = r100.optInt("CmafSkipInitSection");     // Catch: Exception -> L85
    L12:
        if (r100.has("CmafStartSegmentOffset") == false) goto L15;
        r212.cmafStartSegOffset = r100.optInt("CmafStartSegmentOffset");     // Catch: Exception -> L85
    L15:
        if (r100.has("CmafPreloadNum") == false) goto L18;
        r212.cmafPreloadNum = r100.optInt("CmafPreloadNum");     // Catch: Exception -> L85
    L18:
        if (r100.has("CmafPreloadParallel") == false) goto L21;
        r212.cmafPreloadParallel = r100.optInt("CmafPreloadParallel");     // Catch: Exception -> L85
    L21:
        if (r100.has("CmafPreloadMPDUpdateMs") == false) goto L24;
        r212.cmafPreloadMPDUpdateMs = r100.optInt("CmafPreloadMPDUpdateMs");     // Catch: Exception -> L85
    L24:
        if (r100.has("CmafPreloadMPDExpMs") == false) goto L27;
        r212.cmafPreloadMPDExpMs = r100.optInt("CmafPreloadMPDExpMs");     // Catch: Exception -> L85
    L27:
        if (r110.has("httpx") == false) goto L35;
        String r101 = r110.optString("httpx");     // Catch: Exception -> L85
        r212.httpxParams = r101;     // Catch: Exception -> L85
        JSONObject r102 = new JSONObject(r101);     // Catch: Exception -> L85
        if (r102.has("HttpQuicVersion") == false) goto L32;
        r212.quicVersion = r102.optInt("HttpQuicVersion");     // Catch: Exception -> L85
    L32:
        if (r102.has("HttpEnableCertVerify") == false) goto L35;
        r212.enableCertVerify = r102.optInt("HttpEnableCertVerify");     // Catch: Exception -> L85
    L35:
        if (r110.has("LivePreloadConfig") == false) goto L40;
        JSONObject r103 = new JSONObject(r110.optString("LivePreloadConfig"));     // Catch: Exception -> L85
        if (r103.has("PreloadMode") == false) goto L40;
        r212.preloadMode = r103.optInt("PreloadMode", -1);     // Catch: Exception -> L85
    L40:
        if (r110.has("quic") == false) goto L43;
        r212.quicParams = r110.optString("quic");     // Catch: Exception -> L85
    L43:
        if (r110.has("EnableSaveSCFG") == false) goto L51;
        if (1 != r110.optInt("EnableSaveSCFG")) goto L47;
        boolean r104 = true;
    L48:
        if (r104 == false) goto L51;
        PreloadManager r105 = this;
        r212.quicSCFGAddr = r105.mQuicScfgPath;     // Catch: Exception -> L83
    L53:
        if (r110.has("SuggestProtocol") == false) goto L67;
        String r106 = r110.optString("SuggestProtocol");     // Catch: Exception -> L83
        r212.protocol = r106;     // Catch: Exception -> L83
        if (TextUtils.equals("h2", r106) == false) goto L58;
        r212.httpVersion = 2;     // Catch: Exception -> L83
        r212.lowProtocol = 1;     // Catch: Exception -> L83
        r212.cryptoProtocol = 2;     // Catch: Exception -> L83
        goto L67
    L58:
        if (TextUtils.equals("h2q", r106) == false) goto L61;
        r212.httpVersion = 2;     // Catch: Exception -> L83
        r212.lowProtocol = 2;     // Catch: Exception -> L83
        r212.cryptoProtocol = 1;     // Catch: Exception -> L83
        goto L67
    L61:
        if (TextUtils.equals("tls", r106) == false) goto L64;
        r212.httpVersion = 1;     // Catch: Exception -> L83
        r212.lowProtocol = 1;     // Catch: Exception -> L83
        r212.cryptoProtocol = 2;     // Catch: Exception -> L83
        goto L67
    L64:
        if (TextUtils.equals("tcp", r106) == false) goto L67;
        r212.httpVersion = 1;     // Catch: Exception -> L83
        r212.lowProtocol = 0;     // Catch: Exception -> L83
    L67:
        if (r110.has("SuggestFormat") == false) goto L70;
        r212.format = r110.optString("SuggestFormat");     // Catch: Exception -> L83
    L70:
        if (r110.has("CacheFrameCount") == false) goto L73;
        r212.cacheFrameCount = r110.optInt("CacheFrameCount");     // Catch: Exception -> L83
    L73:
        if (r110.has("CacheDuration") == false) goto L76;
        r212.cacheDuration = r110.optInt("CacheDuration");     // Catch: Exception -> L83
    L76:
        if (r110.has("MinCacheDuration") == false) goto L79;
        r212.minCacheDuration = r110.optInt("MinCacheDuration");     // Catch: Exception -> L83
    L79:
        if (r110.has("CacheMode") == false) goto L81;
        r212.cacheMode = r110.optInt("CacheMode");     // Catch: Exception -> L83
    L81:
        r212.httpCacheMaxAgeSec = r105.mPreloadCacheMaxAgeSec;     // Catch: Exception -> L83
        r212.openTimeoutMs = r105.mRequestOpenTimeout;     // Catch: Exception -> L83
        r212.readTimeoutMs = r105.mRequestReadTimeout;     // Catch: Exception -> L83
        r212.optCancelTask = r105.mOptCancelTask;     // Catch: Exception -> L83
        return 0;
    L83:
        e = e;
    L87:
        e.toString();
        return -2004;
    L47:
        r104 = false;
    L51:
        r105 = this;
    L85:
        e = e;
        goto L87
    }

    public int preload(int r210, String r211, String r212, Bundle r213) {
        if (getActivePlayer() != r210) goto L5;
        if (r213 != null) goto L8;
        Bundle r100 = new Bundle();
    L9:
        String r101 = cacheKey(r211);
        TTRequestParam r102 = new TTRequestParam();
        int r103 = parseSdkParams(r211, r212, r102);
        if (r103 != 0) goto L75;
        c r104 = this.mTasks.get(r101);
        if (r104 == null) goto L39;
        long r110 = System.currentTimeMillis();
        int r111 = r104.f458594c.get();
        long r105 = r104.f458595d;
        if (r104.f458598g != 1) goto L28;
        if (4 != r111) goto L24;
        int r112 = this.mMpdPreloadMinSec;
        if (r112 <= 0) goto L37;
        if (r105 <= 0) goto L37;
        if ((r110 - r105) >= (((long) r112) * 1000)) goto L37;
        r103 = -3010;
    L37:
        if (this.mPreloadList.contains(r101) == false) goto L39;
        this.mPreloadList.remove(r101);
        goto L39
    L24:
        if (1 != r111) goto L26;
    L35:
        r103 = -3001;
        goto L37
    L26:
        if (6 != r111) goto L37;
    L28:
        if (4 == r111) goto L30;
        if (1 != r111) goto L37;
    L30:
        if (r105 <= 0) goto L37;
        if ((r110 - r105) >= (((long) this.mPreloadCacheMaxAgeSec) * 1000)) goto L37;
        r103 = -3000;
    L39:
        if (r103 != 0) goto L76;
        String r106 = r100.getString(DNSParser.DNS_RESULT_IP, "");
        if (TextUtils.isEmpty(r106) == true) goto L44;
        r102.ipaddr = r106;
    L44:
        String r107 = r100.getString("host", "");
        if (TextUtils.isEmpty(r107) == true) goto L48;
        r102.host = r107;
    L48:
        if (0 != this.mNativePtr) goto L50;
        return AVMDLDataLoader.AVMDLErrorIsInvalidRequestInfo;
    L50:
        if (r104 != null) goto L53;
        r104 = new c(this);
        r104.f458595d = -1;
    L53:
        if (r100.getInt("mpd_updating", 0) != 1) goto L55;
        r104.f458594c.set(6);
    L56:
        r104.f458592a = r211;
        r104.f458593b = r210;
        r104.f458596e = System.currentTimeMillis();
        r104.f458597f = 0;
        r104.f458598g = r102.preloadMode;
        r104.f458599h = r102;
        int r108 = r102.cmafPreloadMPDUpdateMs;
        if (r108 > 0) goto L60;
        r108 = 2000;
    L60:
        r100.putInt("mpd_update_int", r108);
        r104.f458600i = r100;
        this.mTasks.put(r101, r104);
        if (this.mPreloadList.contains(r101) == false) goto L63;
        this.mPreloadList.remove(r101);
    L63:
        Object r109 = this.mTaskLock;
        monitor-enter(r109);
        this.mCurrentTask = r104;     // Catch: Throwable -> L69
        monitor-exit(r109);     // Catch: Throwable -> L69
        this.mPreloadExecutor.execute(r104);
        return r103;
    L69:
        th = move-exception;
        throw th;
    L55:
        r104.f458594c.set(1);
        goto L56
    L76:
        return r103;
    L75:
        return r103;
    L8:
        r100 = r213;
        goto L9
    L5:
        return -3003;
    }
}
