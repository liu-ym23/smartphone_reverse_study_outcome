package com.bytedance.vmsdk.worker;

import com.bytedance.map.api.monitor.MapMonitorConst;
import com.bytedance.mira.Mira;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mira.pm.PluginPackageManager;
import com.bytedance.pia.core.metrics.ErrorType;
import com.bytedance.vmsdk.jsbridge.JSModule;
import com.bytedance.vmsdk.jsbridge.JSModuleManager;
import com.bytedance.vmsdk.jsbridge.utils.JavaOnlyArray;
import com.bytedance.vmsdk.jsbridge.utils.JavaOnlyMap;
import com.bytedance.vmsdk.monitor.VmSdkMonitor;
import com.bytedance.vmsdk.net.Request;
import com.bytedance.vmsdk.net.Response;
import com.bytedance.vmsdk.registry.JavaScriptRegistry;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.utils.logger.FLogger;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;
import op7.d;
import org.json.JSONException;
import org.json.JSONObject;
import rp7.f;
import rp7.h;

/* JADX INFO: loaded from: classes3.dex */
public class JsWorker {
    private static final String CACHE_PATH = "/woker_code_cache.bin";
    public static final String DEFAULT_BIZ_NAME = "unknown_android";
    private static final long QJS = 0;
    private static final String TAG = "VMSDK_JsWorker";
    private static final long V8 = 1;
    private static boolean isInitialised;
    private boolean isIcuInitialised;
    private zp7.a mDevTool;
    private EngineType mEngineType;
    private IWorkerExceptionDelegate mExceptionDelegate;
    private d mInspectorClientNew;
    private JavaScriptRegistry mJavaScriptModuleRegistry;
    private JSModuleManager mModuleManager;
    private AtomicLong mNativeWorkerPtr;
    private yp7.a mOnErrorCallback;
    private yp7.a mOnMessageCallback;
    private int mSrcID;
    private yp7.b mWorkerDelegate;

    public static final enum EngineType extends Enum<EngineType> {
        private static final /* synthetic */ EngineType[] $VALUES = null;
        public static final EngineType QUICKJS = null;
        public static final EngineType V8 = null;

        static {
            EngineType r100 = new EngineType("QUICKJS", 0);
            QUICKJS = r100;
            EngineType r101 = new EngineType("V8", 1);
            V8 = r101;
            $VALUES = new EngineType[]{r100, r101};
        }

        public static EngineType[] values() {
            return (EngineType[]) $VALUES.clone();
        }

        public static EngineType valueOf(String r100) {
            return (EngineType) r27.a.a(EngineType.class, r100);
        }

        private EngineType(String r100, int r101) {
            super(r100, r101);
        }
    }

    /* JADX INFO: loaded from: classes22.dex */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f272515a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ JsWorker f272516b;

        @Override // java.lang.Runnable
        public final void run() {
            JsWorker.access$100(this.f272515a, JsWorker.access$000(this.f272516b).get());     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(JsWorker r100, long r101) {
            this.f272516b = r100;
            this.f272515a = r101;
        }
    }

    /* JADX INFO: loaded from: classes22.dex */
    public class b implements com.bytedance.vmsdk.net.a<Response> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f272517a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ JsWorker f272518b;

        @Override // com.bytedance.vmsdk.net.a
        public final void a(Response r100) {
            Response r101 = r100;
            if (this.f272518b.isRunning() == false) goto L6;
            JsWorker.access$200(JsWorker.access$000(this.f272518b).get(), r101, this.f272517a);
            return;
        }

        public b(JsWorker r100, long r101) {
            this.f272518b = r100;
            this.f272517a = r101;
        }
    }

    /* JADX INFO: loaded from: classes22.dex */
    public class c implements com.bytedance.vmsdk.net.a<Throwable> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f272519a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ JsWorker f272520b;

        @Override // com.bytedance.vmsdk.net.a
        public final void a(Throwable r100) {
            Throwable r101 = r100;
            if (this.f272520b.isRunning() == false) goto L6;
            JsWorker.access$300(JsWorker.access$000(this.f272520b).get(), r101.getMessage(), this.f272519a);
            return;
        }

        public c(JsWorker r100, long r101) {
            this.f272520b = r100;
            this.f272519a = r101;
        }
    }

    public static /* synthetic */ void a(JsWorker r100) {
        r100.lambda$registerICU$0();
    }

    public static /* synthetic */ void access$001(String r100) {
        System.loadLibrary(r100);
    }

    public static /* synthetic */ Class access$002(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public static boolean initDevtool() {
        Long r100 = (Long) INVOKESTATIC_com_bytedance_vmsdk_worker_JsWorker_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.bytedance.vmsdk.devtool.DevtoolManager").getMethod("initialize", new Class[0]).invoke(null, new Object[0]);     // Catch: Throwable -> L10
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100.longValue() == 0) goto L14;
        nativeInitInspectorFactory(r100.longValue());     // Catch: Throwable -> L10
        return true;
    L14:
        return false;
    L15:
        return false;
    }

    private native void nativeBind(long r100, int r101, int r102);

    private static native long nativeCreateWorker(JsWorker r100, long r101, JSModuleManager r102, String r103, boolean r104, String r105, boolean r106);

    private native void nativeEvaluateCodeCache(long r100, byte[] r101);

    private static native void nativeEvaluateJavaScript(long r100, String r101, String r102, boolean r103);

    private static native byte[] nativeGenCodeCache(String r100, long r101);

    private native long nativeGetNapiEnv(long r100);

    private static native void nativeInitInspector(long r100, long r101);

    private static native void nativeInitInspectorFactory(long r100);

    private static native void nativeInitQJSWebAssembly(long r100, long r101);

    private native Object nativeInvokeJavaScriptFunction(long r100, String r101, JavaOnlyArray r102, char r103);

    private native Object nativeInvokeJavaScriptModule(long r100, String r101, String r102, JavaOnlyArray r103, char r104);

    private native void nativeOnCloseInspectorSession(long r100);

    private native void nativeOnInspectorMessage(long r100, String r101);

    private native void nativeOnJSRunner(long r100, Runnable r101);

    private native void nativeOnJSRunnerAtFront(long r100, Runnable r101);

    private native void nativeOnJSRunnerDelay(long r100, Runnable r101, long r102);

    private native void nativeOnOpenInspectorSession(long r100);

    private native void nativeOnPlatformRunner(long r100, Runnable r101);

    private native void nativeOnWorkerRunner(long r100, Runnable r101);

    private static native void nativePostMessage(long r100, String r101);

    private static native void nativeRegisterDelegateFunction(long r100);

    private static native void nativeReject(long r100, String r101, long r102);

    private static native void nativeResolve(long r100, Response r101, long r102);

    private native void nativeSetExceptionDelegate(long r100, IWorkerExceptionDelegate r101);

    private native void nativeSetProperties(long r100, JavaOnlyMap r101);

    private native void nativeSetupLoader(long r100, String r101);

    private static native void nativeTerminate(long r100);

    private native void nativeTriggerGC(long r100);

    private static native void nativeV8PipeInit(long r100, long[] r101);

    public static void v8pipeInit(long[] r100) {
    }

    public static long getWasmRegisterFunctionPtr() {
        return ((Long) INVOKESTATIC_com_bytedance_vmsdk_worker_JsWorker_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.bytedance.vmsdk.wasm.RegisterWebAssembly").getMethod("registerWebAssembly", new Class[0]).invoke(null, new Object[0])).longValue();
    L4:
        e = move-exception;
        e.getMessage();
        Objects.toString(e.getCause());
        return 0;
    }

    private /* synthetic */ void lambda$registerICU$0() {
        long r100 = nativeGetNapiEnv(this.mNativeWorkerPtr.get());
        if (r100 != 0) goto L12;
        return;
    L12:
        boolean r101 = false;
        INVOKESTATIC_com_bytedance_vmsdk_worker_JsWorker_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.bytedance.vmsdk.icu.RegisterICU").getMethod("nativeRegisterICUInNapiEnv", new Class[]{Long.TYPE}).invoke(null, new Object[]{Long.valueOf(r100)});     // Catch: Exception -> L7
    L9:
        if (r101 == true) goto L15;
        this.isIcuInitialised = true;
        return;
    L15:
        return;
    L7:
        e = move-exception;
        e.getMessage();
        Objects.toString(e.getCause());
        r101 = true;
        goto L9
    }

    private void registerICU() {
        INVOKESTATIC_com_bytedance_vmsdk_worker_JsWorker_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("icu");     // Catch: Exception -> L4
        boolean r100 = true;
    L6:
        if (r100 == false) goto L11;
        postOnJSRunner(new yp7.c(this));
        return;
    L11:
        return;
    L4:
        e = move-exception;
        e.getMessage();
        r100 = false;
        goto L6
    }

    private boolean workDelegateExists() {
        if (this.mWorkerDelegate == null) goto L5;
        return true;
    L5:
        return false;
    }

    public long getNapiEnv() {
        if (this.mNativeWorkerPtr.get() != 0) goto L5;
        return 0;
    L5:
        return nativeGetNapiEnv(this.mNativeWorkerPtr.get());
    }

    public long getNativePtr() {
        return this.mNativeWorkerPtr.get();
    }

    public boolean isRunning() {
        if (this.mNativeWorkerPtr.get() == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public void terminate() {
        if (this.mOnMessageCallback == null) goto L6;
        this.mOnMessageCallback = null;
    L6:
        if (this.mOnErrorCallback == null) goto L8;
        this.mOnErrorCallback = null;
    L8:
        zp7.a r100 = this.mDevTool;
        if (r100 == null) goto L14;
        zp7.b r101 = r100.f573204a;
        if (r101 == null) goto L13;
        r101.destroy();
        r100.f573204a = null;
    L13:
        this.mDevTool = null;
    L14:
        d r102 = this.mInspectorClientNew;
        if (r102 == null) goto L24;
        pp7.d r103 = d.f524732h;
        op7.b r104 = r103.f530219d;
        List<d> r105 = r104.f524731b;
        monitor-enter(r105);
        ((ArrayList) r104.f524731b).remove(r102);     // Catch: Throwable -> L21
        monitor-exit(r105);     // Catch: Throwable -> L21
        r103.f530220e.b(r102.f524737e, r102.f524738f);
        this.mInspectorClientNew = null;
    L21:
        th = move-exception;
        throw th;
    L24:
        JSModuleManager r106 = this.mModuleManager;
        if (r106 == null) goto L28;
        r106.destroy();
        this.mModuleManager = null;
    L28:
        if (this.mNativeWorkerPtr.get() == 0) goto L35;
        isInitialised = false;
        long r107 = this.mNativeWorkerPtr.getAndSet(0);
        if (r107 == 0) goto L36;
        nativeTerminate(r107);
        return;
    L36:
        return;
    }

    public JsWorker() {
        this.mNativeWorkerPtr = new AtomicLong(0);
        this.mDevTool = null;
        this.mInspectorClientNew = null;
        EngineType r100 = EngineType.QUICKJS;
        this.mEngineType = r100;
        this.mSrcID = -1;
        this.isIcuInitialised = false;
        init(null, r100, null, false, DEFAULT_BIZ_NAME, false, false, false, false);
    }

    public static boolean initialize() {
        String[] r100 = {"quick", "napi", ErrorType.WORKER};
        int r101 = 0;
        boolean r102 = false;
    L4:
        if (r101 >= 3) goto L11;
        INVOKESTATIC_com_bytedance_vmsdk_worker_JsWorker_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(r100[r101]);     // Catch: Throwable -> L8
    L10:
        r101 = r101 + 1;
    L8:
        th = move-exception;
        th.getMessage();
        r102 = true;
        goto L10
    L11:
        initDevtool();
        isInitialised = !r102;
        return !r102;
    }

    public static boolean initializeWithoutThrow() {
        String[] r100 = {"quick", "napi", ErrorType.WORKER};
        int r101 = 0;
    L4:
        if (r101 >= 3) goto L6;
        INVOKESTATIC_com_bytedance_vmsdk_worker_JsWorker_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(r100[r101]);
        r101 = r101 + 1;
        goto L4
    L6:
        isInitialised = true;
        return true;
    }

    public void onCloseInspectorSession() {
        if (isRunning() == false) goto L6;
        nativeOnCloseInspectorSession(this.mNativeWorkerPtr.get());
        return;
    }

    public void onOpenInspectorSession() {
        if (isRunning() == false) goto L6;
        nativeOnOpenInspectorSession(this.mNativeWorkerPtr.get());
        return;
    }

    public void triggerGC() {
        if (isRunning() == false) goto L6;
        nativeTriggerGC(this.mNativeWorkerPtr.get());
        return;
    }

    public static boolean isIsInitialised() {
        return isInitialised;
    }

    public EngineType EngineType() {
        return this.mEngineType;
    }

    public IWorkerExceptionDelegate getDelegate() {
        return this.mExceptionDelegate;
    }

    public d getInspectorClient() {
        return this.mInspectorClientNew;
    }

    public JSModuleManager getModuleManager() {
        return this.mModuleManager;
    }

    public int id() {
        return this.mSrcID;
    }

    public boolean isIsIcuInitialised() {
        return this.isIcuInitialised;
    }

    public JsWorker(com.bytedance.vmsdk.worker.a r110) {
        this.mNativeWorkerPtr = new AtomicLong(0);
        this.mDevTool = null;
        this.mInspectorClientNew = null;
        this.mEngineType = EngineType.QUICKJS;
        this.mSrcID = -1;
        this.isIcuInitialised = false;
        init(r110.f272526f, r110.f272521a, r110.f272523c, r110.f272524d, r110.f272522b, r110.f272525e, false, false, false);
    }

    private String FetchJsWithUrlSync(String r100) {
        yp7.b r101 = this.mWorkerDelegate;
        if (r101 != null) goto L5;
        return "";
    L5:
        return r101.a(r100);
    }

    @JvmStatic
    public static void INVOKESTATIC_com_bytedance_vmsdk_worker_JsWorker_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r100) {
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
        com.bytedance.librarian.a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_vmsdk_worker_JsWorker_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class r103 = access$002(r100);     // Catch: Throwable -> L8
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
        Class r104 = access$002(r100);     // Catch: Throwable -> L17
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

    private void SendInspectorResponse(String r100) {
        d r101 = this.mInspectorClientNew;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.f524733a == null) goto L17;
        h r102 = (h) r101.f524733a;
        r102.getClass();
        int r103 = f.f538860a;
        byte[] r104 = r100.getBytes("UTF-8");     // Catch: UnsupportedEncodingException -> L10
        r102.a(rp7.b.a((byte) 1, r104, r104.length));
        return;
    L10:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static /* synthetic */ AtomicLong access$000(JsWorker r100) {
        return r100.mNativeWorkerPtr;
    }

    public static String getCacheFilePath(String r100) {
        return r100 + CACHE_PATH;
    }

    public static boolean initializeWithPlugin(String r100) {
    L22:
        th = move-exception;
        th.getMessage();
        return false;
    L5:
        if (np7.b.d() == true) goto L28;
    L9:
        boolean r101 = false;
    L10:
        boolean r102 = np7.b.e(r100);     // Catch: Throwable -> L22
        if (isInitialised == true) goto L18;
        if (r101 == false) goto L16;
        if (r102 == false) goto L16;
        boolean r103 = true;
    L17:
        isInitialised = r103;
    L16:
        r103 = false;
    L18:
        if (r101 == false) goto L30;
        if (r102 == false) goto L31;
        return true;
    L31:
        return false;
    L30:
        return false;
    L28:
        np7.b.a();     // Catch: Throwable -> L25
        r101 = true;
        goto L10
    }

    public static boolean initializeWithPlugin2(String r100) {
        boolean r101 = np7.b.e(r100);     // Catch: Throwable -> L7
        if (isInitialised == true) goto L6;
        isInitialised = r101;
    L6:
        return r101;
    L7:
        th = move-exception;
        th.getMessage();
        return false;
    }

    private void onError(String r100) {
        yp7.a r101 = this.mOnErrorCallback;
        if (r101 == null) goto L6;
        r101.a(r100);
    }

    private void onMessage(String r100) {
        yp7.a r101 = this.mOnMessageCallback;
        if (r101 == null) goto L6;
        r101.a(r100);
    }

    public static boolean preLoadPlugin(String r100) {
        if (np7.b.d() == false) goto L16;
    L10:
        th = move-exception;
        th.getMessage();
        return false;
    L6:
        if (PluginPackageManager.checkPluginInstalled(r100) == true) goto L9;
        return Mira.loadPlugin(r100);
    L9:
        return true;
    L16:
        return false;
    }

    public void evaluateCodeCache(byte[] r100) {
        if (isRunning() == false) goto L6;
        nativeEvaluateCodeCache(this.mNativeWorkerPtr.get(), r100);
        return;
    }

    public void evaluateJavaScript(String r100) {
        if (isRunning() == false) goto L6;
        nativeEvaluateJavaScript(this.mNativeWorkerPtr.get(), r100, null, false);
        return;
    }

    public <T extends com.bytedance.vmsdk.registry.a> T getJavaScriptFunction(Class<T> r100) {
        return (T) this.mJavaScriptModuleRegistry.getJavaScriptFunction(this, r100);
    }

    public <T extends com.bytedance.vmsdk.registry.b> T getJavaScriptModule(Class<T> r100) {
        return (T) this.mJavaScriptModuleRegistry.getJavaScriptModule(this, r100);
    }

    public void initInspector(long r100) {
        nativeInitInspector(this.mNativeWorkerPtr.get(), r100);
    }

    public void initV8Pipe(long[] r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.length <= 3) goto L8;
        nativeV8PipeInit(this.mNativeWorkerPtr.get(), r100);
        return;
    }

    public void onInspectorMessage(String r100) {
        if (isRunning() == false) goto L6;
        nativeOnInspectorMessage(this.mNativeWorkerPtr.get(), r100);
        return;
    }

    public void postMessage(String r100) {
        if (isRunning() == false) goto L6;
        nativePostMessage(this.mNativeWorkerPtr.get(), r100);
        return;
    }

    public void postOnJSRunner(Runnable r100) {
        if (isRunning() == false) goto L6;
        nativeOnJSRunner(this.mNativeWorkerPtr.get(), r100);
        return;
    }

    public void postOnJSRunnerAtFront(Runnable r100) {
        if (isRunning() == false) goto L6;
        nativeOnJSRunnerAtFront(this.mNativeWorkerPtr.get(), r100);
        return;
    }

    public void postOnPlatformRunner(Runnable r100) {
        if (this.mNativeWorkerPtr.get() == 0) goto L6;
        nativeOnPlatformRunner(this.mNativeWorkerPtr.get(), r100);
        return;
    }

    public void postOnWorkerRunner(Runnable r100) {
        if (isRunning() == false) goto L6;
        nativeOnWorkerRunner(this.mNativeWorkerPtr.get(), r100);
        return;
    }

    public void setDelegate(IWorkerExceptionDelegate r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (this.mNativeWorkerPtr.get() == 0) goto L8;
        this.mExceptionDelegate = r100;
        nativeSetExceptionDelegate(this.mNativeWorkerPtr.get(), r100);
        return;
    }

    public void setGlobalProperties(JavaOnlyMap r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.size() > 0) goto L6;
        return;
    L6:
        if (isRunning() == false) goto L11;
        nativeSetProperties(this.mNativeWorkerPtr.get(), r100);
        return;
    }

    public void setInspectorClient(d r100) {
        this.mInspectorClientNew = r100;
    }

    public void setOnErrorCallback(yp7.a r100) {
        this.mOnErrorCallback = r100;
    }

    public void setOnMessageCallback(yp7.a r100) {
        this.mOnMessageCallback = r100;
    }

    public void setWorkerDelegate(yp7.b r100) {
        this.mWorkerDelegate = r100;
        if (r100 == null) goto L6;
        nativeRegisterDelegateFunction(this.mNativeWorkerPtr.get());
        return;
    }

    public void setupLoader(String r100) {
        if (isRunning() == false) goto L6;
        nativeSetupLoader(this.mNativeWorkerPtr.get(), r100);
        return;
    }

    public JsWorker(JSModuleManager r110) {
        this.mNativeWorkerPtr = new AtomicLong(0);
        this.mDevTool = null;
        this.mInspectorClientNew = null;
        EngineType r100 = EngineType.QUICKJS;
        this.mEngineType = r100;
        this.mSrcID = -1;
        this.isIcuInitialised = false;
        init(r110, r100, null, false, DEFAULT_BIZ_NAME, false, false, false, false);
    }

    public JsWorker(JSModuleManager r110, EngineType r111) {
        this.mNativeWorkerPtr = new AtomicLong(0);
        this.mDevTool = null;
        this.mInspectorClientNew = null;
        this.mEngineType = EngineType.QUICKJS;
        this.mSrcID = -1;
        this.isIcuInitialised = false;
        init(r110, r111, null, false, DEFAULT_BIZ_NAME, false, false, false, false);
    }

    public static /* synthetic */ void access$100(long r100, long r101) {
        nativeInitQJSWebAssembly(r100, r101);
    }

    public static byte[] genCodeCache(String r100, EngineType r101) {
        if (r101 != EngineType.QUICKJS) goto L5;
        long r102 = 0;
    L7:
        return nativeGenCodeCache(r100, r102);
    L5:
        r102 = 1;
        goto L7
    }

    public void bind(int r100, int r101) {
        this.mSrcID = r100;
        nativeBind(this.mNativeWorkerPtr.get(), r100, r101);
    }

    public void evaluateJavaScript(String r100, String r101) {
        if (isRunning() == false) goto L11;
        zp7.a r102 = this.mDevTool;
        if (r102 == null) goto L9;
        zp7.b r103 = r102.f573204a;
        if (r103 == null) goto L9;
        r103.a();
    L9:
        nativeEvaluateJavaScript(this.mNativeWorkerPtr.get(), r100, r101, false);
        return;
    }

    public void evaluateJavaScriptWithException(String r100, String r101) {
        if (isRunning() == false) goto L11;
        zp7.a r102 = this.mDevTool;
        if (r102 == null) goto L9;
        zp7.b r103 = r102.f573204a;
        if (r103 == null) goto L9;
        r103.a();
    L9:
        nativeEvaluateJavaScript(this.mNativeWorkerPtr.get(), r100, r101, true);
        return;
    }

    public void initWebAssembly(long r100, EngineType r101) {
        if (np7.a.f520042a.booleanValue() == true) goto L12;
        return;
    L12:
    L9:
        e = move-exception;
        e.getMessage();
        Objects.toString(e.getCause());
        return;
    L6:
        if (r101 != EngineType.QUICKJS) goto L14;
        postOnJSRunner(new a(this, r100));     // Catch: Exception -> L9
        return;
    }

    public void postOnJSRunnerDelay(Runnable r100, long r101) {
        if (this.mNativeWorkerPtr.get() == 0) goto L6;
        nativeOnJSRunnerDelay(this.mNativeWorkerPtr.get(), r100, r101);
        return;
    }

    public JsWorker(JSModuleManager r110, EngineType r111, String r112) {
        this.mNativeWorkerPtr = new AtomicLong(0);
        this.mDevTool = null;
        this.mInspectorClientNew = null;
        this.mEngineType = EngineType.QUICKJS;
        this.mSrcID = -1;
        this.isIcuInitialised = false;
        init(r110, r111, r112 + CACHE_PATH, false, DEFAULT_BIZ_NAME, false, false, false, false);
    }

    public static /* synthetic */ void access$200(long r100, Response r101, long r102) {
        nativeResolve(r100, r101, r102);
    }

    public static /* synthetic */ void access$300(long r100, String r101, long r102) {
        nativeReject(r100, r101, r102);
    }

    public void registerModule(String r100, Class<? extends JSModule> r101, Object r102) {
        if (this.mModuleManager != null) goto L5;
        return;
    L5:
        if (isRunning() == false) goto L9;
        this.mModuleManager.b(r100, r101, r102);
        return;
    }

    public JsWorker(JSModuleManager r110, EngineType r111, boolean r112) {
        this.mNativeWorkerPtr = new AtomicLong(0);
        this.mDevTool = null;
        this.mInspectorClientNew = null;
        this.mEngineType = EngineType.QUICKJS;
        this.mSrcID = -1;
        this.isIcuInitialised = false;
        init(r110, r111, null, r112, DEFAULT_BIZ_NAME, false, false, false, false);
    }

    public JsWorker(JSModuleManager r110, EngineType r111, String r112, boolean r113) {
        this.mNativeWorkerPtr = new AtomicLong(0);
        this.mDevTool = null;
        this.mInspectorClientNew = null;
        this.mEngineType = EngineType.QUICKJS;
        this.mSrcID = -1;
        this.isIcuInitialised = false;
        init(r110, r111, r112 + CACHE_PATH, r113, DEFAULT_BIZ_NAME, false, false, false, false);
    }

    private void Fetch(String r100, String r101, byte[] r102, long r103) {
        if (this.mWorkerDelegate == null) goto L15;
    L10:
        e = move-exception;
        e.getMessage();
        return;
    L5:
        if (r101.isEmpty() == false) goto L7;
        JSONObject r104 = new JSONObject();     // Catch: JSONException -> L10
    L8:
        Request r105 = new Request(r100, r104, r102);     // Catch: JSONException -> L10
        b r106 = new b(this, r103);     // Catch: JSONException -> L10
        c r107 = new c(this, r103);     // Catch: JSONException -> L10
        this.mWorkerDelegate.b(r105, r106, r107);     // Catch: JSONException -> L10
        return;
    L7:
        r104 = new JSONObject(r101);     // Catch: JSONException -> L10
        goto L8
    }

    public Object invokeJavaScriptFunction(String r100, JavaOnlyArray r101, char r102, boolean r110) {
        if (isRunning() == true) goto L5;
        return null;
    L5:
        return nativeInvokeJavaScriptFunction(this.mNativeWorkerPtr.get(), r100, r101, r102);
    }

    public Object invokeJavaScriptModule(String r100, String r110, JavaOnlyArray r111, char r112) {
        if (isRunning() == true) goto L5;
        return null;
    L5:
        return nativeInvokeJavaScriptModule(this.mNativeWorkerPtr.get(), r100, r110, r111, r112);
    }

    public JsWorker(JSModuleManager r110, EngineType r111, String r112, boolean r113, String r114) {
        this.mNativeWorkerPtr = new AtomicLong(0);
        this.mDevTool = null;
        this.mInspectorClientNew = null;
        this.mEngineType = EngineType.QUICKJS;
        this.mSrcID = -1;
        this.isIcuInitialised = false;
        init(r110, r111, r112 + CACHE_PATH, r113, r114, false, false, false, false);
    }

    private void init(JSModuleManager r110, EngineType r111, String r112, boolean r113, String r114, boolean r115, boolean r210, boolean r211, boolean r212) {
        if (isInitialised == true) goto L6;
        initialize();
    L6:
        if (r111 != EngineType.QUICKJS) goto L8;
        long r100 = 0;
    L9:
        this.mEngineType = r111;
        if (wp7.a.b().a("vmsdk_enable_codecache") == true) goto L12;
        String r101 = null;
    L13:
        this.mNativeWorkerPtr.set(nativeCreateWorker(this, r100, r110, r101, r113, r114, r212));
        if (r210 == false) goto L16;
        registerICU();
    L16:
        this.mJavaScriptModuleRegistry = new JavaScriptRegistry();
        this.mModuleManager = r110;
        if (r115 == false) goto L19;
        this.mDevTool = new zp7.a(this);
        this.mInspectorClientNew = new d(this);
    L19:
        if (r211 == false) goto L28;
        long r102 = getWasmRegisterFunctionPtr();
        if (r102 == 0) goto L28;
        initWebAssembly(r102, this.mEngineType);
    L28:
        JSONObject r103 = new JSONObject();     // Catch: Throwable -> L25
        r103.put(MapMonitorConst.BIZ_NAME, r114);     // Catch: Throwable -> L25
        r103.put("init_worker", true);     // Catch: Throwable -> L25
        r103.put("vmsdk_android_version", "4.1.3-doubao");     // Catch: Throwable -> L25
        r103.toString();     // Catch: Throwable -> L25
        VmSdkMonitor.a();     // Catch: Throwable -> L25
        throw null;     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        th.getMessage();
        return;
    L12:
        r101 = r112;
        goto L13
    L8:
        r100 = 1;
        goto L9
    }
}
