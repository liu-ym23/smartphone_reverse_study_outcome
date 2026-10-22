package com.ttnet.org.chromium.base.library_loader;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Bundle;
import android.system.Os;
import com.larus.utils.logger.FLogger;
import com.ttnet.org.chromium.base.BaseSwitches;
import com.ttnet.org.chromium.base.CommandLine;
import com.ttnet.org.chromium.base.ContextUtils;
import com.ttnet.org.chromium.base.JNIUtils;
import com.ttnet.org.chromium.base.Log;
import com.ttnet.org.chromium.base.NativeLibraryLoadedStatus;
import com.ttnet.org.chromium.base.StrictModeContext;
import com.ttnet.org.chromium.base.TimeUtils;
import com.ttnet.org.chromium.base.TraceEvent;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.MainDex;
import com.ttnet.org.chromium.base.compat.ApiHelperForM;
import com.ttnet.org.chromium.base.metrics.RecordHistogram;
import com.ttnet.org.chromium.base.metrics.UmaRecorderHolder;
import com.ttnet.org.chromium.build.BuildConfig;
import com.ttnet.org.chromium.build.NativeLibraries;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Locale;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
@JNINamespace("base::android")
@MainDex
public class LibraryLoader {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final boolean ALLOW_CHROMIUM_LINKER_IN_ZYGOTE = true;
    private static final String BACKGROUND_THREAD_POOL_KEY = "background_thread_pool_enabled";
    static final boolean DEBUG = false;
    private static final int DEFAULT_REACHED_CODE_SAMPLING_INTERVAL_US = 10000;
    private static final String DEPRECATED_REACHED_CODE_PROFILER_KEY = "reached_code_profiler_enabled";
    private static final String REACHED_CODE_SAMPLING_INTERVAL_KEY = "reached_code_sampling_interval";
    private static final String TAG = "LibraryLoader";
    private static boolean sBrowserStartupBlockedForTesting;
    private static LibraryLoader sInstance;
    private boolean mCommandLineSwitched;
    private boolean mConfigurationSet;
    private boolean mFallbackToSystemLinker;
    private volatile boolean mInitialized;
    private NativeLibraryPreloader mLibraryPreloader;
    private boolean mLibraryPreloaderCalled;
    private int mLibraryProcessType;
    private Linker mLinker;
    private volatile int mLoadState;
    private boolean mLoadedByZygote;
    private final Object mLock;
    private final MultiProcessMediator mMediator;
    private final Object mNonMainDexLock;
    private boolean mUseChromiumLinker;
    private boolean mUseModernLinker;

    @Retention(RetentionPolicy.SOURCE)
    public @interface CreatedIn {
        public static final int CHILD_WITHOUT_ZYGOTE = 2;
        public static final int MAIN = 0;
        public static final int ZYGOTE = 1;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface LoadState {
        public static final int LOADED = 2;
        public static final int MAIN_DEX_LOADED = 1;
        public static final int NOT_LOADED = 0;
    }

    public class MultiProcessMediator {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private static final String LINKER_HISTOGRAM_PREFIX = "ChromiumAndroidLinker.";
        private volatile int mCreatedIn;
        private volatile boolean mInitDone;
        private long mLoadAddress;
        final /* synthetic */ LibraryLoader this$0;

        private String creationAsString() {
            int r100 = this.mCreatedIn;
            if (r100 != 0) goto L5;
            return "Browser";
        L5:
            if (r100 != 1) goto L7;
            return "Zygote";
        L7:
            if (r100 == 2) goto L10;
            return "";
        L10:
            return "Child";
        }

        private long getLoadAddress() {
            Object r100 = LibraryLoader.access$000(this.this$0);
            monitor-enter(r100);
            long r101 = this.mLoadAddress;     // Catch: Throwable -> L7
            monitor-exit(r100);     // Catch: Throwable -> L7
            return r101;
        L7:
            th = move-exception;
            throw th;
        }

        private void recordLinkerHistogramsAfterLibraryLoad() {
            if (LibraryLoader.access$100(this.this$0) == true) goto L5;
            return;
        L5:
            LibraryLoader.access$200(this.this$0).recordHistograms(creationAsString());
        }

        public void ensureInitializedInMainProcess() {
            if (this.mInitDone == false) goto L6;
            return;
        L6:
            if (LibraryLoader.access$100(this.this$0) == false) goto L12;
            boolean r100 = LibraryLoader.mainProcessIntendsToProvideRelroFd();
            if (r100 == false) goto L10;
            int r101 = 2;
        L11:
            LibraryLoader.access$200(this.this$0).ensureInitialized(r100, r101, 0);
            goto L12
        L10:
            r101 = 0;
        L12:
            this.mCreatedIn = 0;
            this.mInitDone = true;
        }

        public void initInAppZygote() {
            if (LibraryLoader.access$100(this.this$0) == true) goto L5;
        L7:
            LibraryLoader.access$302(this.this$0, true);
        L8:
            this.mCreatedIn = 1;
            return;
        L5:
            if (LibraryLoader.mainProcessIntendsToProvideRelroFd() == true) goto L7;
            LibraryLoader.access$200(this.this$0).ensureInitialized(true, 0, 0);
            goto L8
        }

        public void initInChildProcess() {
            if (LibraryLoader.access$100(this.this$0) == true) goto L7;
            this.mInitDone = true;
            return;
        L7:
            if (LibraryLoader.mainProcessIntendsToProvideRelroFd() == false) goto L10;
            LibraryLoader.access$200(this.this$0).ensureInitialized(false, 1, getLoadAddress());
        L17:
            if (this.mCreatedIn == 1) goto L19;
            this.mCreatedIn = 2;
        L19:
            this.mInitDone = true;
            return;
        L10:
            if (this.this$0.isLoadedByZygote() == true) goto L17;
            if (this.mCreatedIn != 1) goto L15;
            LibraryLoader.access$200(this.this$0).ensureInitialized(false, 1, getLoadAddress());
            goto L17
        L15:
            LibraryLoader.access$200(this.this$0).ensureInitialized(false, 0, getLoadAddress());
            goto L17
        }

        static {
        }

        public MultiProcessMediator(LibraryLoader r100) {
            this.this$0 = r100;
            this.mCreatedIn = 0;
        }

        public static /* synthetic */ void access$500(MultiProcessMediator r100) {
            r100.recordLinkerHistogramsAfterLibraryLoad();
        }

        private void recordLoadTimeHistogram(long r100) {
            RecordHistogram.recordTimesHistogram(LINKER_HISTOGRAM_PREFIX + creationAsString() + "LoadTime2", r100);
        }

        public void putLoadAddressToBundle(Bundle r100) {
            if (LibraryLoader.access$100(this.this$0) == false) goto L6;
            LibraryLoader.access$200(this.this$0).putLoadAddressToBundle(r100);
            return;
        }

        public void putSharedRelrosToBundle(Bundle r100) {
            if (LibraryLoader.access$100(this.this$0) == false) goto L6;
            LibraryLoader.access$200(this.this$0).putSharedRelrosToBundle(r100);
            return;
        }

        public void recordLoadThreadTimeHistogram(long r100) {
            RecordHistogram.recordTimesHistogram(LINKER_HISTOGRAM_PREFIX + creationAsString() + "ThreadLoadTime", r100);
        }

        public void takeLoadAddressFromBundle(Bundle r100) {
            this.mLoadAddress = Linker.extractLoadAddressFromBundle(r100);
        }

        public void takeSharedRelrosFromBundle(Bundle r100) {
            if (LibraryLoader.access$100(this.this$0) == false) goto L6;
            LibraryLoader.access$200(this.this$0).takeSharedRelrosFromBundle(r100);
            return;
        }

        public static /* synthetic */ void access$600(MultiProcessMediator r100, long r101) {
            r100.recordLoadTimeHistogram(r101);
        }
    }

    public interface Natives {
        boolean libraryLoaded(int r100);

        void registerNonMainDexJni();
    }

    public static /* synthetic */ void access$001(String r100) {
        System.loadLibrary(r100);
    }

    private void logLinkersUsed() {
        Log.i(TAG, "Configuration: useChromiumLinker() = %b, mUseModernLinker = %b", new Object[]{Boolean.valueOf(useChromiumLinker()), Boolean.valueOf(this.mUseModernLinker)});
    }

    public static void setBrowserProcessStartupBlockedForTesting() {
        sBrowserStartupBlockedForTesting = true;
    }

    public void assertCompatibleProcessType(int r100) {
    }

    public void setLibrariesLoadedForNativeTests() {
        this.mLoadState = 2;
        this.mInitialized = true;
    }

    static {
        sInstance = new LibraryLoader();
    }

    private void ensureCommandLineSwitchedAlreadyLocked() {
        if (this.mCommandLineSwitched == false) goto L5;
        return;
    L5:
        CommandLine.enableNativeProxy();
        this.mCommandLineSwitched = true;
    }

    private boolean forceSystemLinker() {
        if (this.mUseChromiumLinker == true) goto L5;
    L9:
        return false;
    L5:
        if (this.mUseModernLinker == true) goto L9;
        if (Build.VERSION.SDK_INT < 29) goto L9;
        return true;
    }

    private Linker getLinker() {
        Object r100 = this.mLock;
        monitor-enter(r100);
    L18:
        th = move-exception;
        throw th;
    L5:
        if (this.mLinker == null) goto L7;
    L15:
        Linker r101 = this.mLinker;     // Catch: Throwable -> L18
        monitor-exit(r100);     // Catch: Throwable -> L18
        return r101;
    L7:
        if (this.mUseModernLinker == false) goto L9;
        Linker r102 = new ModernLinker();     // Catch: Throwable -> L18
    L10:
        this.mLinker = r102;     // Catch: Throwable -> L18
        if (this.mUseModernLinker == false) goto L13;
        String r103 = "Using ModernLinker";
    L14:
        Log.i(TAG, r103, new Object[0]);     // Catch: Throwable -> L18
        goto L15
    L13:
        r103 = "Using LegacyLinker";
        goto L14
    L9:
        r102 = new LegacyLinker();     // Catch: Throwable -> L18
        goto L10
    }

    private void initializeAlreadyLocked() {
        if (this.mInitialized == false) goto L6;
        return;
    L6:
        if (this.mLibraryProcessType != 1) goto L13;
        int r100 = getReachedCodeSamplingIntervalUs();
        if (r100 <= 0) goto L11;
        CommandLine.getInstance().appendSwitch(BaseSwitches.ENABLE_REACHED_CODE_PROFILER);
        CommandLine.getInstance().appendSwitchWithValue(BaseSwitches.REACHED_CODE_SAMPLING_INTERVAL_US, Integer.toString(r100));
    L11:
        if (isBackgroundThreadPoolEnabled() == false) goto L13;
        CommandLine.getInstance().appendSwitch(BaseSwitches.ENABLE_BACKGROUND_THREAD_POOL);
    L13:
        ensureCommandLineSwitchedAlreadyLocked();
        if (LibraryLoaderJni.get().libraryLoaded(this.mLibraryProcessType) == false) goto L17;
        Log.i(TAG, "Successfully loaded native library", new Object[0]);
        UmaRecorderHolder.onLibraryLoaded();
        TraceEvent.onNativeTracingReady();
        this.mInitialized = true;
        return;
    L17:
        Log.e(TAG, "error calling LibraryLoaderJni.get().libraryLoaded", new Object[0]);
        throw new ProcessInitException(1);
    }

    public static boolean mainProcessIntendsToProvideRelroFd() {
        if (Build.VERSION.SDK_INT > 30) goto L5;
        return true;
    L5:
        return false;
    }

    public static void setEnvForNative() {
        if (BuildConfig.IS_UBSAN == true) goto L10;
        return;
    L10:
        Os.setenv("UBSAN_OPTIONS", "print_stacktrace=1 stack_trace_format='#%n pc %o %m' handle_segv=0 handle_sigbus=0 handle_sigfpe=0", true);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        Log.w(TAG, "failed to set UBSAN_OPTIONS", new Object[]{e});
    }

    private void setLinkerImplementationIfNeededAlreadyLocked() {
        if (this.mConfigurationSet == false) goto L5;
        return;
    L5:
        this.mUseChromiumLinker = NativeLibraries.sUseLinker;
        this.mUseModernLinker = NativeLibraries.sUseModernLinker;
        this.mConfigurationSet = true;
    }

    private boolean useChromiumLinker() {
        if (this.mUseChromiumLinker == true) goto L5;
    L7:
        return false;
    L5:
        if (forceSystemLinker() == true) goto L7;
        return true;
    }

    public void enableJniChecks() {
        if (BuildConfig.ENABLE_ASSERTS == true) goto L5;
        return;
    L5:
        NativeLibraryLoadedStatus.setProvider(new AnonymousClass1(this));
    }

    public void ensureMainDexInitialized() {
        Object r100 = this.mLock;
        monitor-enter(r100);
        loadMainDexAlreadyLocked(ContextUtils.getApplicationContext().getApplicationInfo(), false);     // Catch: Throwable -> L7
        initializeAlreadyLocked();     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void initialize() {
        Object r100 = this.mLock;
        monitor-enter(r100);
        initializeAlreadyLocked();     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean isInitialized() {
        if (this.mInitialized == true) goto L5;
    L7:
        return false;
    L5:
        if (isLoaded() == false) goto L7;
        return true;
    }

    public boolean isLoaded() {
        if (this.mLoadState != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isLoadedByZygote() {
        Object r100 = this.mLock;
        monitor-enter(r100);
        boolean r101 = this.mLoadedByZygote;     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    public void loadNonMainDex() {
        /*  JADX ERROR: Simple mode code generation failed
            java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
            	at java.base/java.util.Objects.checkIndex(Objects.java:365)
            	at java.base/java.util.ArrayList.get(ArrayList.java:428)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:354)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            */
        /*
            this = this;
            int r0 = r4.mLoadState
            r1 = 2
            if (r0 != r1) goto L6
            return
        L6:
            java.lang.Object r0 = r4.mNonMainDexLock
            monitor-enter(r0)
            int r2 = r4.mLoadState     // Catch: java.lang.Throwable -> L39
            if (r2 != r1) goto Lf
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L39
            return
        Lf:
            java.lang.String r2 = "LibraryLoader.loadNonMainDex"
            com.ttnet.org.chromium.base.TraceEvent r2 = com.ttnet.org.chromium.base.TraceEvent.scoped(r2)     // Catch: java.lang.Throwable -> L39
            boolean r3 = com.ttnet.org.chromium.base.JNIUtils.isSelectiveJniRegistrationEnabled()     // Catch: java.lang.Throwable -> L2b
            if (r3 != 0) goto L22
            com.ttnet.org.chromium.base.library_loader.LibraryLoader$Natives r3 = com.ttnet.org.chromium.base.library_loader.LibraryLoaderJni.get()     // Catch: java.lang.Throwable -> L2b
            r3.registerNonMainDexJni()     // Catch: java.lang.Throwable -> L2b
        L22:
            r4.mLoadState = r1     // Catch: java.lang.Throwable -> L2b
            if (r2 == 0) goto L29
            r2.close()     // Catch: java.lang.Throwable -> L39
        L29:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L39
            return
        L2b:
            r1 = move-exception
            if (r2 == 0) goto L36
            r2.close()     // Catch: java.lang.Throwable -> L32
            goto L36
        L32:
            r2 = move-exception
            r1.addSuppressed(r2)     // Catch: java.lang.Throwable -> L39
        L36:
            throw r1     // Catch: java.lang.Throwable -> L39
        L37:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L39
            throw r1
        L39:
            r1 = move-exception
            goto L37
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ttnet.org.chromium.base.library_loader.LibraryLoader.loadNonMainDex():void");
    }

    public void switchCommandLineForWebView() {
        Object r100 = this.mLock;
        monitor-enter(r100);
        ensureCommandLineSwitchedAlreadyLocked();     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public LibraryLoader() {
        this.mNonMainDexLock = new Object();
        this.mMediator = new MultiProcessMediator(this);
        this.mLock = new Object();
    }

    public static int getReachedCodeSamplingIntervalUs() {
        StrictModeContext r100 = StrictModeContext.allowDiskReads();
    L13:
        th = move-exception;
        if (r100 != null) goto L20;
    L19:
        throw th;
    L20:
        r100.close();     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        th.addSuppressed(th);
        goto L19
    L4:
        if (ContextUtils.getAppSharedPreferences().getBoolean(DEPRECATED_REACHED_CODE_PROFILER_KEY, false) == false) goto L9;
        if (r100 == null) goto L24;
        r100.close();
        return 10000;
    L24:
        return 10000;
    L9:
        int r101 = ContextUtils.getAppSharedPreferences().getInt(REACHED_CODE_SAMPLING_INTERVAL_KEY, 0);     // Catch: Throwable -> L13
        if (r100 == null) goto L12;
        r100.close();
    L12:
        return r101;
    }

    public static boolean isBackgroundThreadPoolEnabled() {
        StrictModeContext r100 = StrictModeContext.allowDiskReads();
        boolean r101 = ContextUtils.getAppSharedPreferences().getBoolean(BACKGROUND_THREAD_POOL_KEY, false);     // Catch: Throwable -> L7
        if (r100 == null) goto L6;
        r100.close();
    L6:
        return r101;
    L7:
        th = move-exception;
        if (r100 != null) goto L16;
    L13:
        throw th;
    L16:
        r100.close();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        th.addSuppressed(th);
        goto L13
    }

    public void ensureInitialized() {
        if (isInitialized() == false) goto L5;
        return;
    L5:
        ensureMainDexInitialized();
        loadNonMainDex();
    }

    public void loadNow() {
        loadNowOverrideApplicationContext(ContextUtils.getApplicationContext());
    }

    public void preloadNow() {
        preloadNowOverridePackageName(ContextUtils.getApplicationContext().getApplicationInfo().packageName);
    }

    public static LibraryLoader getInstance() {
        return sInstance;
    }

    public static boolean isBrowserProcessStartupBlockedForTesting() {
        return sBrowserStartupBlockedForTesting;
    }

    private static boolean isInZipFile() {
        return NativeLibraries.sUseLibraryInZipFile;
    }

    public final MultiProcessMediator getMediator() {
        return this.mMediator;
    }

    @JvmStatic
    public static void INVOKESTATIC_com_ttnet_org_chromium_base_library_loader_LibraryLoader_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r100) {
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
        com.bytedance.librarian.a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
    }

    public static /* synthetic */ Object access$000(LibraryLoader r100) {
        return r100.mLock;
    }

    public static /* synthetic */ boolean access$100(LibraryLoader r100) {
        return r100.useChromiumLinker();
    }

    public static /* synthetic */ Linker access$200(LibraryLoader r100) {
        return r100.getLinker();
    }

    public static /* synthetic */ int access$400(LibraryLoader r100) {
        return r100.mLoadState;
    }

    public static void setBackgroundThreadPoolEnabledOnNextRuns(boolean r100) {
        ContextUtils.getAppSharedPreferences().edit().putBoolean(BACKGROUND_THREAD_POOL_KEY, r100).apply();
    }

    public static void setLibraryLoaderForTesting(LibraryLoader r100) {
        sInstance = r100;
    }

    public void loadNowInZygote(ApplicationInfo r100) {
        Object r101 = this.mLock;
        monitor-enter(r101);
        loadMainDexAlreadyLocked(r100, true);     // Catch: Throwable -> L10
        loadNonMainDex();     // Catch: Throwable -> L10
        this.mLoadedByZygote = true;     // Catch: Throwable -> L10
        monitor-exit(r101);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public void loadNowOverrideApplicationContext(Context r100) {
        Object r101 = this.mLock;
        monitor-enter(r101);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (this.mLoadState != 0) goto L7;
    L11:
        loadMainDexAlreadyLocked(r100.getApplicationInfo(), false);     // Catch: Throwable -> L15
        monitor-exit(r101);     // Catch: Throwable -> L15
        loadNonMainDex();
        return;
    L7:
        if (r100 == ContextUtils.getApplicationContext()) goto L11;
        throw new IllegalStateException("Attempt to load again from alternate context.");     // Catch: Throwable -> L15
    }

    public void preloadNowOverridePackageName(String r100) {
        Object r101 = this.mLock;
        monitor-enter(r101);
        setLinkerImplementationIfNeededAlreadyLocked();     // Catch: Throwable -> L11
        if (useChromiumLinker() == false) goto L8;
        monitor-exit(r101);     // Catch: Throwable -> L11
        return;
    L8:
        preloadAlreadyLocked(r100, false);     // Catch: Throwable -> L11
        monitor-exit(r101);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public void setLibraryProcessType(int r100) {
        int r101 = this.mLibraryProcessType;
        if (r100 != r101) goto L5;
        return;
    L5:
        if (r101 != 0) goto L9;
        this.mLibraryProcessType = r100;
        return;
    L9:
        throw new IllegalStateException(String.format("Trying to change the LibraryProcessType from %d to %d", new Object[]{Integer.valueOf(this.mLibraryProcessType), Integer.valueOf(r100)}));
    }

    public void setNativeLibraryPreloader(NativeLibraryPreloader r100) {
        Object r101 = this.mLock;
        monitor-enter(r101);
        this.mLibraryPreloader = r100;     // Catch: Throwable -> L9
        monitor-exit(r101);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public static /* synthetic */ boolean access$302(LibraryLoader r100, boolean r101) {
        r100.mFallbackToSystemLinker = r101;
        return r101;
    }

    private void loadWithChromiumLinker(ApplicationInfo r100, String r101) {
        Linker r102 = getLinker();
        if (isInZipFile() == false) goto L5;
        String r103 = r100.sourceDir;
        r102.setApkFilePath(r103);
        Log.i(TAG, "Loading %s from within %s", new Object[]{r101, r103});
    L6:
        r102.loadLibrary(r101);
        MultiProcessMediator.access$500(getMediator());
        return;
    L5:
        Log.i(TAG, "Loading %s", new Object[]{r101});
        goto L6
    }

    private void loadWithSystemLinkerAlreadyLocked(ApplicationInfo r110, boolean r111) {
        setEnvForNative();
        preloadAlreadyLocked(r110.packageName, r111);
        String[] r112 = NativeLibraries.LIBRARIES;
        int r100 = r112.length;
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L20;
        String r102 = r112[r101];
        if (forceSystemLinker() == false) goto L7;
    L9:
        boolean r103 = false;
    L11:
        if (isInZipFile() == false) goto L18;
        if (r103 == true) goto L18;
        boolean r104 = ApiHelperForM.isProcess64Bit();
        String r105 = r110.sourceDir;
        boolean r106 = forceSystemLinker();
        String r107 = r105 + "!/" + makeLibraryPathInZipFile(r102, r106, r104);
        Log.i(TAG, "libraryName: %s", new Object[]{r107});
        if (r106 == false) goto L17;
        Log.w(TAG, "Forcing system linker, relocations will not be shared. This negatively impacts memory usage.", new Object[0]);
    L17:
        System.load(r107);
    L19:
        r101 = r101 + 1;
    L18:
        INVOKESTATIC_com_ttnet_org_chromium_base_library_loader_LibraryLoader_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(r102);
        goto L19
    L7:
        if (Build.VERSION.SDK_INT < 29) goto L9;
        r103 = true;
        goto L11
    }

    private void preloadAlreadyLocked(String r100, boolean r101) {
        TraceEvent r102 = TraceEvent.scoped("LibraryLoader.preloadAlreadyLocked");
        NativeLibraryPreloader r103 = this.mLibraryPreloader;     // Catch: Throwable -> L11
        if (r103 != null) goto L6;
    L8:
        if (r102 == null) goto L22;
        r102.close();
        return;
    L22:
        return;
    L6:
        if (this.mLibraryPreloaderCalled == true) goto L8;
        r103.loadLibrary(r100);     // Catch: Throwable -> L11
        this.mLibraryPreloaderCalled = true;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        if (r102 != null) goto L18;
    L17:
        throw th;
    L18:
        r102.close();     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        th.addSuppressed(th);
        goto L17
    }

    public static void setReachedCodeProfilerEnabledOnNextRuns(boolean r100, int r101) {
        if (r100 == false) goto L5;
        if (r101 != 0) goto L5;
        r101 = 10000;
    L7:
        SharedPreferences.Editor r102 = ContextUtils.getAppSharedPreferences().edit();
        r102.remove(DEPRECATED_REACHED_CODE_PROFILER_KEY);
        r102.putInt(REACHED_CODE_SAMPLING_INTERVAL_KEY, r101).apply();
        return;
    L5:
        if (r100 == true) goto L7;
        r101 = 0;
        goto L7
    }

    public void loadMainDexAlreadyLocked(ApplicationInfo r100, boolean r101) {
        if (this.mLoadState < 1) goto L28;
        return;
    L28:
        TraceEvent r102 = TraceEvent.scoped("LibraryLoader.loadMainDexAlreadyLocked");     // Catch: UnsatisfiedLinkError -> L23
        setLinkerImplementationIfNeededAlreadyLocked();     // Catch: Throwable -> L16
        TimeUtils.UptimeMillisTimer r103 = new TimeUtils.UptimeMillisTimer();     // Catch: Throwable -> L16
        TimeUtils.CurrentThreadTimeMillisTimer r104 = new TimeUtils.CurrentThreadTimeMillisTimer();     // Catch: Throwable -> L16
        if (useChromiumLinker() == true) goto L9;
    L11:
        loadWithSystemLinkerAlreadyLocked(r100, r101);     // Catch: Throwable -> L16
    L12:
        long r105 = r103.getElapsedMillis();     // Catch: Throwable -> L16
        MultiProcessMediator.access$600(getMediator(), r105);     // Catch: Throwable -> L16
        getMediator().recordLoadThreadTimeHistogram(r104.getElapsedMillis());     // Catch: Throwable -> L16
        this.mLoadState = 1;     // Catch: Throwable -> L16
        if (r102 == null) goto L31;
        r102.close();     // Catch: UnsatisfiedLinkError -> L23
        return;
    L31:
        return;
    L9:
        if (this.mFallbackToSystemLinker == true) goto L11;
        loadWithChromiumLinker(r100, NativeLibraries.LIBRARIES[0]);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        if (r102 != null) goto L26;
    L22:
        throw th;     // Catch: UnsatisfiedLinkError -> L23
    L26:
        r102.close();     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        th.addSuppressed(th);     // Catch: UnsatisfiedLinkError -> L23
    L23:
        e = move-exception;
        throw new ProcessInitException(2, e);
    }

    public void setLinkerImplementation(boolean r100, boolean r101) {
        this.mUseChromiumLinker = r100;
        this.mUseModernLinker = r101;
        this.mConfigurationSet = true;
    }

    public static String makeLibraryPathInZipFile(String r100, boolean r101, boolean r102) {
        int r103 = NativeLibraries.sCpuFamily;
        if (r103 == 1) goto L14;
        if (r103 == 2) goto L11;
        if (r103 != 3) goto L10;
        if (r102 == false) goto L8;
        String r104 = "x86_64";
    L17:
        if (r101 == false) goto L19;
        String r105 = "crazy.";
    L21:
        return String.format(Locale.US, "lib/%s/%s%s", new Object[]{r104, r105, System.mapLibraryName(r100)});
    L19:
        r105 = "";
        goto L21
    L8:
        r104 = "x86";
        goto L17
    L10:
        throw new RuntimeException("Unknown CPU ABI for native libraries");
    L11:
        if (r102 == false) goto L13;
        r104 = "mips64";
        goto L17
    L13:
        r104 = "mips";
        goto L17
    L14:
        if (r102 == false) goto L16;
        r104 = "arm64-v8a";
        goto L17
    L16:
        r104 = "armeabi-v7a";
        goto L17
    }
}
