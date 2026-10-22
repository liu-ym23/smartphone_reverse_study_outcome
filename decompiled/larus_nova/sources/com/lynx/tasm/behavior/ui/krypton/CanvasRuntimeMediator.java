package com.lynx.tasm.behavior.ui.krypton;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.c;
import el9.a;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes32.dex */
public class CanvasRuntimeMediator {
    private static final String TAG = "KryptonCanvasRuntimeMediator";
    private static Class<?> mCanvasManagerClass;
    private static Constructor<?> mCanvasManagerConstructor;
    private volatile LynxKryptonAudioFrameCallback mAudioDownstreamCallback;
    private volatile LynxKryptonAudioDownstreamMode mAudioDownstreamMode;
    private final Map<Class<?>, Object> mCachedServiceMap;
    private volatile boolean mHasInitCanvasManager;
    private ICanvasManager mICanvasManagerInstance;
    private volatile boolean mIsCanvasEnvReady;
    private final WeakReference<LynxContext> mLynxContextWeak;
    private long mNativeRuntimeMediatorWeakPtr;
    private final ReadWriteLock mRuntimeMediatorLock;
    private String mTemporaryDirectory;
    private final ReadWriteLock mTemporaryDirectoryLock;

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    private native long nativeCreate();

    private native void nativeNotifyCanvasInitializeSuccess(long r100);

    private native void nativeReleaseRuntimeMediatorWeakPtr(long r100);

    private native long nativeResetToWeakPtr(long r100);

    private void onCanvasEnvPrepared() {
        this.mIsCanvasEnvReady = true;
    }

    private synchronized void setupCanvasEnvInternal() {
        monitor-enter(this);
        TraceEvent.beginSection("CanvasRuntimeMediator.setupCanvas");     // Catch: Throwable -> L17
        if (this.mHasInitCanvasManager == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        if (this.mICanvasManagerInstance != null) goto L14;
        LLog.i(TAG, "[Krypton] Create and init canvas manager");     // Catch: Throwable -> L17
        tryCreateCanvasManager();     // Catch: Throwable -> L17
        if (initCanvasManager() == false) goto L14;
        if (this.mIsCanvasEnvReady == true) goto L14;
        notifyCanvasInitializeSuccess();     // Catch: Throwable -> L17
    L14:
        this.mHasInitCanvasManager = true;     // Catch: Throwable -> L17
        TraceEvent.endSection("CanvasRuntimeMediator.setupCanvas");     // Catch: Throwable -> L17
        monitor-exit(this);
        return;
    L17:
        th = move-exception;
        throw th;
    }

    private boolean initCanvasManager() {
        LLog.i(TAG, "[Krypton] Init CanvasManager, load so and create KryptonApp");
        if (this.mICanvasManagerInstance != null) goto L5;
        return false;
    L5:
        LynxContext r100 = this.mLynxContextWeak.get();
        if (this.mICanvasManagerInstance.init(r100) == true) goto L8;
        return false;
    L8:
        this.mTemporaryDirectoryLock.readLock().lock();
        String r101 = this.mTemporaryDirectory;
        if (r101 != null) goto L11;
    L13:
        this.mTemporaryDirectoryLock.readLock().unlock();
        Iterator<Map.Entry<Class<?>, Object>> r102 = this.mCachedServiceMap.entrySet().iterator();
    L15:
        if (r102.hasNext() == false) goto L18;
        Map.Entry<Class<?>, Object> r103 = r102.next();
        this.mICanvasManagerInstance.registerService(r103.getKey(), r103.getValue());
        goto L15
    L18:
        if (this.mAudioDownstreamCallback == null) goto L23;
        this.mICanvasManagerInstance.setAudioDownstreamCallback(this.mAudioDownstreamCallback, this.mAudioDownstreamMode);
        this.mAudioDownstreamCallback = null;
        this.mAudioDownstreamMode = LynxKryptonAudioDownstreamMode.KEEP_PLAYBACK;
        return true;
    L23:
        return true;
    L11:
        if (r101.isEmpty() == true) goto L13;
        this.mICanvasManagerInstance.setTemporaryDirectory(this.mTemporaryDirectory);
        goto L13
    }

    private void notifyCanvasInitializeSuccess() {
        LLog.i(TAG, "[Krypton] TriggerCanvasEnvReady to execute cached tasks");
        this.mRuntimeMediatorLock.readLock().lock();
        long r100 = this.mNativeRuntimeMediatorWeakPtr;
        if (r100 == 0) goto L5;
        nativeNotifyCanvasInitializeSuccess(r100);
    L5:
        this.mRuntimeMediatorLock.readLock().unlock();
    }

    private void onAppEnterBackground() {
        ICanvasManager r100 = this.mICanvasManagerInstance;
        if (r100 == null) goto L6;
        r100.onAppEnterBackground();
        return;
    }

    private void onAppEnterForeground() {
        ICanvasManager r100 = this.mICanvasManagerInstance;
        if (r100 == null) goto L6;
        r100.onAppEnterForeground();
        return;
    }

    private void onRuntimeDetach() {
        ICanvasManager r100 = this.mICanvasManagerInstance;
        if (r100 == null) goto L6;
        r100.onRuntimeDetach();
        return;
    }

    private void onRuntimeMediatorDestroy() {
        ICanvasManager r100 = this.mICanvasManagerInstance;
        if (r100 == null) goto L6;
        r100.onRuntimeMediatorDestroy();
        this.mRuntimeMediatorLock.writeLock().lock();
        nativeReleaseRuntimeMediatorWeakPtr(this.mNativeRuntimeMediatorWeakPtr);
        this.mNativeRuntimeMediatorWeakPtr = 0;
        this.mRuntimeMediatorLock.writeLock().unlock();
        return;
    }

    private void setupCanvasFromJS() {
        LLog.i(TAG, "[Krypton] setupCanvasFromJS");
        setupCanvasEnvInternal();
    }

    private void tryCreateCanvasManager() {
    L14:
        e = move-exception;
        LLog.e(TAG, "[Krypton]  create canvasManager error" + e.toString());
        return;
    L4:
        if (mCanvasManagerClass != null) goto L7;
        mCanvasManagerClass = INVOKESTATIC_com_lynx_tasm_behavior_ui_krypton_CanvasRuntimeMediator_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.lynx.canvas.CanvasManager");     // Catch: Exception -> L14
    L7:
        if (mCanvasManagerConstructor != null) goto L9;
        mCanvasManagerConstructor = mCanvasManagerClass.getConstructor(new Class[0]);     // Catch: Exception -> L14
    L9:
        Object r100 = mCanvasManagerConstructor.newInstance(new Object[0]);     // Catch: Exception -> L14
        if ((r100 instanceof ICanvasManager) == false) goto L12;
        LLog.e(TAG, "[Krypton]  create canvasManager success.");     // Catch: Exception -> L14
        this.mICanvasManagerInstance = (ICanvasManager) r100;     // Catch: Exception -> L14
        return;
    L12:
        LLog.e(TAG, "[Krypton]  create canvasManager error");     // Catch: Exception -> L14
    }

    public void deInit() {
        ICanvasManager r100 = this.mICanvasManagerInstance;
        if (r100 == null) goto L5;
        r100.deInit();
    L5:
        this.mAudioDownstreamCallback = null;
        this.mAudioDownstreamMode = LynxKryptonAudioDownstreamMode.KEEP_PLAYBACK;
    }

    public void setupCanvasFromUI() {
        LLog.i(TAG, "[Krypton] setupCanvasFromUI");
        setupCanvasEnvInternal();
    }

    public long getNativePtr() {
        return nativeCreate();
    }

    public ICanvasManager getCanvasManager() {
        return this.mICanvasManagerInstance;
    }

    public CanvasRuntimeMediator(LynxContext r100) {
        this.mCachedServiceMap = new ConcurrentHashMap();
        this.mAudioDownstreamMode = LynxKryptonAudioDownstreamMode.KEEP_PLAYBACK;
        this.mIsCanvasEnvReady = false;
        this.mTemporaryDirectoryLock = new ReentrantReadWriteLock(true);
        this.mRuntimeMediatorLock = new ReentrantReadWriteLock(true);
        this.mHasInitCanvasManager = false;
        this.mLynxContextWeak = new WeakReference(r100);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_lynx_tasm_behavior_ui_krypton_CanvasRuntimeMediator_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
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

    private void onRuntimeAttach(long r100) {
        ICanvasManager r101 = this.mICanvasManagerInstance;
        if (r101 == null) goto L6;
        r101.onNapiEnvReady(r100);
        return;
    }

    private void onRuntimeCreate(long r100) {
        ICanvasManager r101 = this.mICanvasManagerInstance;
        if (r101 == null) goto L6;
        r101.onRuntimeMediatorReady(r100);
        return;
    }

    private void onRuntimeInit(long r100) {
        ICanvasManager r101 = this.mICanvasManagerInstance;
        if (r101 == null) goto L5;
        r101.onRuntimeInit(r100);
    L5:
        onCanvasEnvPrepared();
    }

    private void setTaskRunner(long r100) {
        ICanvasManager r101 = this.mICanvasManagerInstance;
        if (r101 == null) goto L6;
        r101.setTaskRunner(r100);
        return;
    }

    public void onTemplateLoad(String r100) {
        ICanvasManager r101 = this.mICanvasManagerInstance;
        if (r101 == null) goto L6;
        r101.onTemplateLoad(r100);
        return;
    }

    public void registerCanvasBehavior(c r100) {
        ICanvasManager r101 = this.mICanvasManagerInstance;
        if (r101 == null) goto L6;
        r101.registerCanvasBehavior(r100);
        return;
    }

    public void resetNativePtr(long r100) {
        this.mNativeRuntimeMediatorWeakPtr = nativeResetToWeakPtr(r100);
    }

    public void setTemporaryDirectory(String r100) {
        this.mTemporaryDirectoryLock.writeLock().lock();
        this.mTemporaryDirectory = r100;
        this.mTemporaryDirectoryLock.writeLock().unlock();
        ICanvasManager r101 = this.mICanvasManagerInstance;
        if (r101 == null) goto L6;
        r101.setTemporaryDirectory(r100);
        return;
    }

    public void registerService(Class<?> r100, Object r101) {
        this.mCachedServiceMap.put(r100, r101);
        ICanvasManager r102 = this.mICanvasManagerInstance;
        if (r102 == null) goto L6;
        r102.registerService(r100, r101);
        return;
    }

    public void setAudioDownstreamCallback(LynxKryptonAudioFrameCallback r100, LynxKryptonAudioDownstreamMode r101) {
        if (r101 != null) goto L5;
        r101 = LynxKryptonAudioDownstreamMode.KEEP_PLAYBACK;
    L5:
        if (this.mICanvasManagerInstance != null) goto L8;
        this.mAudioDownstreamCallback = r100;
        this.mAudioDownstreamMode = r101;
        return;
    L8:
        this.mAudioDownstreamCallback = null;
        this.mICanvasManagerInstance.setAudioDownstreamCallback(r100, r101);
    }
}
