package com.bytedance.sliver;

import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadAsyncTask;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes22.dex */
public final class Sliver {
    private static final int SUPPORT_API_MAX = 34;
    private static final int SUPPORT_API_MIN = 19;
    private static final String TAG = "SLIVER";
    private static final Map<Thread, e> cache = null;
    private static final boolean isArt = false;
    private static volatile boolean isInit;
    private static final Map<String, Long> mark = null;
    private static final g sDefaultExecutor = null;
    private static final h sDefaultLogger = null;
    private static g sExecutor;
    private static final List<f> sListenerList = null;
    private static h sLogger;
    private static boolean sLoggerEnable;
    private static final Field threadPeerField = null;
    private static final Field threadPeerFieldDalvik = null;

    public static final enum Mode extends Enum<Mode> {
        public static final Mode NORMAL = null;
        public static final Mode RING = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Mode[] f270298a = null;

        static {
            Mode r100 = new Mode("RING", 0);
            RING = r100;
            Mode r101 = new Mode(EffectConstants.NORMAL, 1);
            NORMAL = r101;
            f270298a = new Mode[]{r100, r101};
        }

        public static Mode[] values() {
            return (Mode[]) f270298a.clone();
        }

        public static Mode valueOf(String r100) {
            return (Mode) r27.a.a(Mode.class, r100);
        }

        public Mode(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static class a implements h {
        public a() {
        }
    }

    public static class b implements g {
        public b() {
        }
    }

    public static class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f270299a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e f270300b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f270301c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Thread f270302d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ boolean f270303e;

        public final void a() {
            if (TextUtils.isEmpty(this.f270299a) == true) goto L7;
            Long r100 = (Long) Sliver.access$100().get(this.f270299a);
            if (r100 == null) goto L7;
            long r101 = r100.longValue();
        L8:
            Sliver.access$200(this.f270300b.f270306a, this.f270301c, r101);
            StringBuilder r102 = new StringBuilder();
            r102.append(this.f270302d);
            r102.append(" dump ");
            if (this.f270303e == false) goto L11;
            String r103 = DocumentType.DOCX_SYNC_BLOCK_NAME;
        L12:
            r102.append(r103);
            r102.append(" success");
            Sliver.onStep(r102.toString());
            return;
        L11:
            r103 = "async";
        L7:
            r101 = -1;
            goto L8
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

        public c(String r100, e r101, String r102, Thread r103, boolean r104) {
            this.f270299a = r100;
            this.f270300b = r101;
            this.f270301c = r102;
            this.f270302d = r103;
            this.f270303e = r104;
        }
    }

    public static class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f270304a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Thread f270305b;

        @Override // java.lang.Runnable
        public final void run() {
            Sliver.access$300(this.f270304a.f270306a);     // Catch: Throwable -> L4
            Sliver.onStep(this.f270305b + " clear success");     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public d(e r100, Thread r101) {
            this.f270304a = r100;
            this.f270305b = r101;
        }
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f270306a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f270307b;

        public e() {
        }
    }

    public interface f {
        void a();
    }

    public interface g {
    }

    public interface h {
    }

    public interface i {
    }

    public Sliver() {
    }

    public static /* synthetic */ void access$000(String r100) {
        System.loadLibrary(r100);
    }

    public static /* synthetic */ Class access$001(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public static void enableLog() {
        sLoggerEnable = true;
    }

    private static boolean isArt() {
        return true;
    }

    private static native void nClear(long r100);

    private static native void nDump(long r100, String r101, long r102);

    private static native long[] nGetMethodStackTrace(Thread r100, long r101);

    private static native String nGetStackTrace(Thread r100, long r101);

    private static native String nGetStackTrace(long[] r100);

    private static native String[] nGetStackTrace3(long[] r100);

    private static native boolean nInit(int r100, Method r101, boolean r102, boolean r103);

    private static native void nPause(long r100);

    private static native void nResetSamplingMs(long r100, int r101);

    private static native void nResume(long r100);

    private static native long nStart(Thread r100, long r101, int r102, int r103, int r104);

    private static native void nStop(long r100);

    static {
        cache = new ConcurrentHashMap(16);
        mark = new ConcurrentHashMap(16);
        sListenerList = new CopyOnWriteArrayList();
        a r100 = new a();
        sDefaultLogger = r100;
        sLogger = r100;
        sLoggerEnable = false;
        b r101 = new b();
        sDefaultExecutor = r101;
        sExecutor = r101;
        boolean r102 = isArt();
        isArt = r102;
        Field r103 = null;
        if (r102 == false) goto L6;
        Field r104 = Thread.class.getDeclaredField("nativePeer");     // Catch: Throwable -> L12
    L5:
        Field r105 = r103;
        r103 = r104;
        Field r106 = r105;
        r103.setAccessible(true);     // Catch: Throwable -> L15
    L13:
        threadPeerField = r103;
        threadPeerFieldDalvik = r106;
        return;
    L6:
        r104 = Thread.class.getDeclaredField("vmThread");     // Catch: Throwable -> L12
        r103 = INVOKESTATIC_com_bytedance_sliver_Sliver_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("java.lang.VMThread").getDeclaredField("vmData");     // Catch: Throwable -> L11
        r103.setAccessible(true);     // Catch: Throwable -> L11
    L11:
        Field r107 = r103;
        r103 = r104;
        r106 = r107;
    L12:
        r106 = r103;
        goto L13
    }

    public static synchronized boolean clearAll() {
        monitor-enter(Sliver.class);
        boolean r100 = SliverAllThreadSupport.clearAll();     // Catch: Throwable -> L7
        monitor-exit(Sliver.class);
        return r100;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized boolean pauseAll() {
        monitor-enter(Sliver.class);
        boolean r100 = SliverAllThreadSupport.pauseAll();     // Catch: Throwable -> L7
        monitor-exit(Sliver.class);
        return r100;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized boolean resumeAll() {
        monitor-enter(Sliver.class);
        boolean r100 = SliverAllThreadSupport.resumeAll();     // Catch: Throwable -> L7
        monitor-exit(Sliver.class);
        return r100;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized boolean stopAll() {
        monitor-enter(Sliver.class);
        boolean r100 = SliverAllThreadSupport.stopAll();     // Catch: Throwable -> L7
        monitor-exit(Sliver.class);
        return r100;
    L7:
        th = move-exception;
        throw th;
    }

    public static boolean clear() {
        return clear(ThreadMethodProxy.currentThread());
    }

    private static boolean loadLibrary() {
        INVOKESTATIC_com_bytedance_sliver_Sliver_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("sliver");     // Catch: Throwable -> L5
        return true;
    L5:
        th = move-exception;
        onError("sliver so load failed", th);
        return false;
    }

    public static boolean pause() {
        return pause(ThreadMethodProxy.currentThread());
    }

    public static boolean resume() {
        return resume(ThreadMethodProxy.currentThread());
    }

    public static boolean stop() {
        return stop(ThreadMethodProxy.currentThread());
    }

    public static /* synthetic */ Map access$100() {
        return mark;
    }

    public static boolean isInit() {
        return isInit;
    }

    @JvmStatic
    public static void INVOKESTATIC_com_bytedance_sliver_Sliver_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r100) {
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
        com.bytedance.librarian.a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_sliver_Sliver_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class r103 = access$001(r100);     // Catch: Throwable -> L8
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
        Class r104 = access$001(r100);     // Catch: Throwable -> L17
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

    public static /* synthetic */ void access$300(long r100) {
        nClear(r100);
    }

    public static synchronized boolean clear(Thread r100) {
        monitor-enter(Sliver.class);
    L18:
        th = move-exception;
        throw th;
    L5:
        if (isInit == true) goto L9;
        onError(r100 + " clear failed, because sliver is not init", new Throwable());     // Catch: Throwable -> L18
        monitor-exit(Sliver.class);
        return false;
    L9:
        e r101 = cache.get(r100);     // Catch: Throwable -> L18
        if (r101 != null) goto L14;
        onError(r100 + " clear failed, because thread is not sampling", new Throwable());     // Catch: Throwable -> L18
        monitor-exit(Sliver.class);
        return false;
    L14:
        g r102 = sExecutor;     // Catch: Throwable -> L18
        d r103 = new d(r101, r100);     // Catch: Throwable -> L18
        ((b) r102).getClass();     // Catch: Throwable -> L18
        PthreadAsyncTask.execute(r103);     // Catch: Throwable -> L18
        monitor-exit(Sliver.class);
        return true;
    }

    public static boolean dump(String r100) {
        return dump(ThreadMethodProxy.currentThread(), r100);
    }

    public static synchronized boolean dumpAll(String r100) {
        monitor-enter(Sliver.class);
        boolean r101 = dumpAll(r100, false);     // Catch: Throwable -> L8
        monitor-exit(Sliver.class);
        return r101;
    L8:
        th = move-exception;
        throw th;
    }

    public static synchronized long[] getMethodStackTrace(Thread r100) {
        monitor-enter(Sliver.class);
    L18:
        th = move-exception;
        throw th;
    L6:
        if (init(false) == true) goto L10;
        long[] r101 = new long[0];     // Catch: Throwable -> L18
        monitor-exit(Sliver.class);
        return r101;
    L10:
        long r102 = getThreadPeer(r100);     // Catch: Throwable -> L18
        if (r102 != 0) goto L15;
        long[] r103 = new long[0];     // Catch: Throwable -> L18
        monitor-exit(Sliver.class);
        return r103;
    L15:
        long[] r104 = nGetMethodStackTrace(r100, r102);     // Catch: Throwable -> L18
        monitor-exit(Sliver.class);
        return r104;
    }

    public static synchronized String getStackTrace(Thread r100) {
        monitor-enter(Sliver.class);
    L18:
        th = move-exception;
        throw th;
    L6:
        if (init(false) == false) goto L8;
        long r101 = getThreadPeer(r100);     // Catch: Throwable -> L18
        if (r101 == 0) goto L13;
        String r102 = nGetStackTrace(r100, r101);     // Catch: Throwable -> L18
        monitor-exit(Sliver.class);
        return r102;
    L13:
        monitor-exit(Sliver.class);
        return "";
    L8:
        monitor-exit(Sliver.class);
        return "";
    }

    public static synchronized String[] getStackTraceArray(long[] r100) {
        monitor-enter(Sliver.class);
        if (r100 != null) goto L17;
    L14:
        monitor-exit(Sliver.class);
        return null;
    L17:
    L11:
        th = move-exception;
        throw th;
    L6:
        if (r100.length == 0) goto L14;
        String[] r101 = nGetStackTrace3(r100);     // Catch: Throwable -> L11
        monitor-exit(Sliver.class);
        return r101;
    }

    public static long getThreadPeer(Thread r100) {
        if (isArt == false) goto L11;
        Field r101 = threadPeerField;
        if (r101 == null) goto L24;
        Object r102 = r101.get(r100);     // Catch: Throwable -> L21
        if (r102 != null) goto L10;
        return 0;
    L10:
        return ((Long) r102).longValue();
    L24:
        return 0;
    L11:
        Field r103 = threadPeerField;
        if (r103 == null) goto L25;
        Field r104 = threadPeerFieldDalvik;
        if (r104 == null) goto L26;
        Object r105 = r104.get(r103.get(r100));     // Catch: Throwable -> L21
        if (r105 != null) goto L20;
        return 0;
    L20:
        return ((Integer) r105).intValue();
    L26:
        return 0;
    L25:
        return 0;
    L28:
        return 0;
    }

    public static synchronized boolean init(boolean r100) {
        monitor-enter(Sliver.class);
        int r101 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L29
        if (r101 <= 34) goto L10;
        onError("not support api : " + r101 + ", sliver support 19-34", new Throwable());     // Catch: Throwable -> L29
        monitor-exit(Sliver.class);
        return false;
    L10:
        if (isInit == false) goto L15;
        onStep("sliver already init");     // Catch: Throwable -> L29
        monitor-exit(Sliver.class);
        return true;
    L15:
        if (loadLibrary() == true) goto L33;
        monitor-exit(Sliver.class);
        return false;
    L33:
        Method r102 = Looper.class.getMethod("loop", new Class[0]);     // Catch: Throwable -> L20
    L22:
        if (nInit(r101, r102, r100, isArt) == true) goto L26;
        onError("sliver init failed, because native init error", new Throwable());     // Catch: Throwable -> L29
        monitor-exit(Sliver.class);
        return false;
    L26:
        isInit = true;     // Catch: Throwable -> L29
        onStep("sliver init success, protect is " + r100);     // Catch: Throwable -> L29
        monitor-exit(Sliver.class);
        return true;
    L20:
        r102 = null;
    L29:
        th = move-exception;
        throw th;
    }

    public static void mark(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        mark.put(r100, Long.valueOf(System.nanoTime()));
    }

    public static int mode2Int(Mode r100) {
        if (r100 != Mode.RING) goto L6;
        return 0;
    L6:
        if (r100 != Mode.NORMAL) goto L9;
        return 1;
    L9:
        return 0;
    }

    public static void onStep(String r100) {
        if (sLoggerEnable == true) goto L5;
        return;
    L5:
        sLogger.getClass();
    }

    public static synchronized boolean pause(Thread r100) {
        monitor-enter(Sliver.class);
        e r101 = cache.get(r100);     // Catch: Throwable -> L17
        if (r101 != null) goto L10;
        onError(r100 + " pause failed, because thread is not sampling", new Throwable());     // Catch: Throwable -> L17
        monitor-exit(Sliver.class);
        return false;
    L10:
        if (r101.f270307b == true) goto L14;
        onStep(r100 + " already pause");     // Catch: Throwable -> L17
        monitor-exit(Sliver.class);
        return true;
    L14:
        nPause(r101.f270306a);     // Catch: Throwable -> L17
        r101.f270307b = false;     // Catch: Throwable -> L17
        onStep(r100 + " pause success");     // Catch: Throwable -> L17
        monitor-exit(Sliver.class);
        return true;
    L17:
        th = move-exception;
        throw th;
    }

    public static void registerSamplingListener(f r100) {
        List<f> r101 = sListenerList;
        if (r101.contains(r100) == false) goto L5;
        return;
    L5:
        r101.add(r100);
    }

    public static synchronized boolean resetSamplingMs(int r100) {
        monitor-enter(Sliver.class);
        boolean r101 = resetSamplingMs(ThreadMethodProxy.currentThread(), r100);     // Catch: Throwable -> L7
        monitor-exit(Sliver.class);
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized boolean resume(Thread r100) {
        monitor-enter(Sliver.class);
        e r101 = cache.get(r100);     // Catch: Throwable -> L18
        if (r101 != null) goto L11;
        onError(r100 + " resume failed, because thread is not sampling", new Throwable());     // Catch: Throwable -> L18
        monitor-exit(Sliver.class);
        return false;
    L11:
        if (r101.f270307b == false) goto L15;
        onStep(r100 + " already resume");     // Catch: Throwable -> L18
        monitor-exit(Sliver.class);
        return true;
    L15:
        nResume(r101.f270306a);     // Catch: Throwable -> L18
        r101.f270307b = true;     // Catch: Throwable -> L18
        onStep(r100 + " resume success");     // Catch: Throwable -> L18
        monitor-exit(Sliver.class);
        return true;
    L18:
        th = move-exception;
        throw th;
    }

    public static void setExecutor(g r100) {
        if (r100 == null) goto L5;
        sExecutor = r100;
        return;
    }

    public static void setLogger(h r100) {
        if (r100 == null) goto L5;
        enableLog();
        sLogger = r100;
        return;
    }

    public static boolean start(int r100) {
        return start(ThreadMethodProxy.currentThread(), r100, 100000, Mode.RING);
    }

    public static synchronized boolean stop(Thread r100) {
        monitor-enter(Sliver.class);
    L18:
        th = move-exception;
        throw th;
    L5:
        if (isInit == true) goto L10;
        onError(r100 + " stop failed, because sliver is not init", new Throwable());     // Catch: Throwable -> L18
        monitor-exit(Sliver.class);
        return false;
    L10:
        e r101 = cache.remove(r100);     // Catch: Throwable -> L18
        if (r101 != null) goto L15;
        onError(r100 + " stop failed, because thread is not sampling", new Throwable());     // Catch: Throwable -> L18
        monitor-exit(Sliver.class);
        return true;
    L15:
        nStop(r101.f270306a);     // Catch: Throwable -> L18
        onStep(r100 + " stop success");     // Catch: Throwable -> L18
        monitor-exit(Sliver.class);
        return true;
    }

    public static void unRegisterSamplingListener(f r100) {
        sListenerList.remove(r100);
    }

    public static synchronized String getStackTrace(long[] r100) {
        monitor-enter(Sliver.class);
        if (r100 == null) goto L12;
    L14:
        th = move-exception;
        throw th;
    L6:
        if (r100.length == 0) goto L12;
        String r101 = nGetStackTrace(r100);     // Catch: Throwable -> L14
        monitor-exit(Sliver.class);
        return r101;
    L12:
        monitor-exit(Sliver.class);
        return "";
    }

    public static boolean dump(String r100, String r101) {
        return dump(ThreadMethodProxy.currentThread(), r100, r101);
    }

    public static synchronized boolean dumpAll(String r100, boolean r101) {
        monitor-enter(Sliver.class);
        boolean r102 = SliverAllThreadSupport.dumpAll(r100, r101);     // Catch: Throwable -> L7
        monitor-exit(Sliver.class);
        return r102;
    L7:
        th = move-exception;
        throw th;
    }

    public static void onError(String r100, Throwable r101) {
        if (sLoggerEnable == true) goto L5;
        return;
    L5:
        sLogger.getClass();
    }

    public static synchronized boolean resetSamplingMs(Thread r100, int r101) {
        monitor-enter(Sliver.class);
    L18:
        th = move-exception;
        throw th;
    L5:
        if (isInit == true) goto L9;
        onError(r100 + " reset sampling ms  failed, because sliver is not init", new Throwable());     // Catch: Throwable -> L18
        monitor-exit(Sliver.class);
        return false;
    L9:
        e r102 = cache.get(r100);     // Catch: Throwable -> L18
        if (r102 != null) goto L14;
        onError(r100 + " reset sampling ms  failed, because thread is not sampling", new Throwable());     // Catch: Throwable -> L18
        monitor-exit(Sliver.class);
        return false;
    L14:
        nResetSamplingMs(r102.f270306a, r101);     // Catch: Throwable -> L18
        onStep(r100 + " reset sampling ms success");     // Catch: Throwable -> L18
        monitor-exit(Sliver.class);
        return true;
    }

    public static boolean startAll(int r100, int r101) {
        return startAll(r100, r101, 50000, Mode.RING, null);
    }

    public static boolean dump(Thread r100, String r101) {
        return dump(r100, r101, false);
    }

    public static /* synthetic */ void access$200(long r100, String r101, long r102) {
        nDump(r100, r101, r102);
    }

    public static synchronized boolean dump(Thread r100, String r101, boolean r102) {
        monitor-enter(Sliver.class);
        boolean r103 = dump(r100, r101, r102, null);     // Catch: Throwable -> L8
        monitor-exit(Sliver.class);
        return r103;
    L8:
        th = move-exception;
        throw th;
    }

    public static synchronized void reportStack(Thread r100, long[] r101, long r102) {
        monitor-enter(Sliver.class);
        int r103 = 0;
    L14:
        List<f> r104 = sListenerList;     // Catch: Throwable -> L11
        if (r103 >= r104.size()) goto L9;
        ((f) ListProtector.get(r104, r103)).a();     // Catch: Throwable -> L11
        r103 = r103 + 1;
        goto L14
    L9:
        monitor-exit(Sliver.class);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public static boolean dump(Thread r100, String r101, String r102) {
        return dump(r100, r101, false, r102);
    }

    public static synchronized boolean dump(Thread r100, String r110, boolean r111, String r112) {
        monitor-enter(Sliver.class);
    L25:
        th = move-exception;
        throw th;
    L5:
        if (isInit == true) goto L9;
        onError(r100 + " dump failed, because sliver is not init", new Throwable());     // Catch: Throwable -> L25
        monitor-exit(Sliver.class);
        return false;
    L9:
        e r101 = cache.get(r100);     // Catch: Throwable -> L25
        if (r101 != null) goto L14;
        onError(r100 + " stop failed, because thread is not sampling", new Throwable());     // Catch: Throwable -> L25
        monitor-exit(Sliver.class);
        return false;
    L14:
        c r102 = new c(r112, r101, r110, r100, r111);     // Catch: Throwable -> L25
        StringBuilder r113 = new StringBuilder();     // Catch: Throwable -> L25
        r113.append(r100);     // Catch: Throwable -> L25
        r113.append(" dump ");     // Catch: Throwable -> L25
        if (r111 == false) goto L17;
        String r103 = DocumentType.DOCX_SYNC_BLOCK_NAME;
    L18:
        r113.append(r103);     // Catch: Throwable -> L25
        r113.append(" start");     // Catch: Throwable -> L25
        onStep(r113.toString());     // Catch: Throwable -> L25
        if (r111 == false) goto L21;
        r102.run();     // Catch: Throwable -> L25
    L22:
        monitor-exit(Sliver.class);
        return true;
    L21:
        ((b) sExecutor).getClass();     // Catch: Throwable -> L25
        PthreadAsyncTask.execute(r102);     // Catch: Throwable -> L25
        goto L22
    L17:
        r103 = "async";
        goto L18
    }

    public static synchronized boolean start(Thread r110, int r111, int r112, Mode r113) {
        monitor-enter(Sliver.class);
    L32:
        th = move-exception;
        throw th;
    L5:
        if (SliverAllThreadSupport.isStart() == false) goto L10;
        onError("sliver start failed , because sliver all thread was started", new Throwable());     // Catch: Throwable -> L32
        monitor-exit(Sliver.class);
        return false;
    L10:
        if (init(false) == true) goto L14;
        onError("sliver start failed , because sliver init failed", new Throwable());     // Catch: Throwable -> L32
        monitor-exit(Sliver.class);
        return false;
    L14:
        Map<Thread, e> r100 = cache;     // Catch: Throwable -> L32
        if (r100.containsKey(r110) == false) goto L19;
        onStep(r110 + " already sampling by sliver");     // Catch: Throwable -> L32
        monitor-exit(Sliver.class);
        return true;
    L19:
        long r101 = getThreadPeer(r110);     // Catch: Throwable -> L32
        if (r101 != 0) goto L24;
        onError("sliver start failed , because can't get thread peer", new Throwable());     // Catch: Throwable -> L32
        monitor-exit(Sliver.class);
        return false;
    L24:
        long r102 = nStart(r110, r101, r111, r112, mode2Int(r113));     // Catch: Throwable -> L32
        if (r102 != 0) goto L29;
        onError("sliver start failed , because can't get native peer", new Throwable());     // Catch: Throwable -> L32
        monitor-exit(Sliver.class);
        return false;
    L29:
        e r103 = new e();     // Catch: Throwable -> L32
        r103.f270306a = r102;     // Catch: Throwable -> L32
        r103.f270307b = true;     // Catch: Throwable -> L32
        r100.put(r110, r103);     // Catch: Throwable -> L32
        onStep(r110 + " sampling by sliver success");     // Catch: Throwable -> L32
        monitor-exit(Sliver.class);
        return true;
    }

    public static synchronized boolean startAll(int r100, int r101, int r102, Mode r103, i r104) {
        monitor-enter(Sliver.class);
    L16:
        th = move-exception;
        throw th;
    L6:
        if (cache.isEmpty() == true) goto L10;
        monitor-exit(Sliver.class);
        return false;
    L10:
        if (init(false) == true) goto L13;
        monitor-exit(Sliver.class);
        return false;
    L13:
        boolean r105 = SliverAllThreadSupport.startAll(r100, r101, r102, r103, r104);     // Catch: Throwable -> L16
        monitor-exit(Sliver.class);
        return r105;
    }
}
