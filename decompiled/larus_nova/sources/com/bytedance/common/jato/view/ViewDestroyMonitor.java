package com.bytedance.common.jato.view;

import android.os.Build;
import android.os.Process;
import android.view.View;
import androidx.core.util.Pools;
import com.bytedance.common.jato.JatoNativeLoader;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import el9.a;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.security.SecureRandom;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import libcore.util.NativeAllocationRegistry;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes15.dex */
public class ViewDestroyMonitor {
    private static volatile ViewDestroyMonitor instance;
    private int delay;
    private boolean enableMonitor;
    private boolean ignoreInflate;
    private final AtomicInteger inflateCount;
    private volatile int inited;
    private InflateInfoProvider provider;
    private final SecureRandom random;
    private final Pools.Pool<Task> sTaskPool;
    private int sampleRate;
    private final CopyOnWriteArrayList<ViewDestroyListener> viewDestroyListeners;

    /* JADX INFO: renamed from: com.bytedance.common.jato.view.ViewDestroyMonitor$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public interface InflateInfoProvider {
        InflateInfo getInflateInfo();
    }

    public class RenderNodeNativeAllocationRegistryProxy extends NativeAllocationRegistry {
        final NativeAllocationRegistry impl;
        final /* synthetic */ ViewDestroyMonitor this$0;

        public Runnable registerNativeAllocation(Object r100, long r101) {
            this.this$0.notifyViewCreatedAsync(r100, r101);
            return this.impl.registerNativeAllocation(r100, r101);
        }

        public RenderNodeNativeAllocationRegistryProxy(ViewDestroyMonitor r100, NativeAllocationRegistry r101, ClassLoader r102, long r110, long r111) {
            this.this$0 = r100;
            super(r102, r110, r111);
            this.impl = r101;
        }
    }

    public class Task implements Runnable {
        InflateInfo inflateInfo;
        long renderNodePtr;
        WeakReference<Object> renderNodeRef;
        final /* synthetic */ ViewDestroyMonitor this$0;
        int threadId;
        String threadName;
        long timestamp;

        @Override // java.lang.Runnable
        public void run() {
            com_bytedance_common_jato_view_ViewDestroyMonitor$Task_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_bytedance_common_jato_view_ViewDestroyMonitor$Task__run$___twin___() {
            WeakReference<Object> r100 = this.renderNodeRef;
            if (r100 != null) goto L5;
            ViewDestroyMonitor.access$000(this.this$0, this.renderNodePtr, this.timestamp);
        L12:
            this.this$0.recycleTask(this);
            return;
        L5:
            Object r101 = r100.get();
            if (r101 == null) goto L12;
            View r102 = ViewUtils.getViewFromRenderNode(r101);
            if (r102 == null) goto L12;
            if (this.renderNodePtr != ViewUtils.getRenderNodePtr(r102)) goto L12;
            ViewDestroyMonitor.access$100(this.this$0, this.renderNodePtr);
            this.this$0.onViewCreatedInner(r102, this.renderNodePtr, this.timestamp, this.threadName, this.threadId, this.inflateInfo);
            goto L12
        }

        private Task(ViewDestroyMonitor r100) {
            this.this$0 = r100;
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_bytedance_common_jato_view_ViewDestroyMonitor$Task_com_larus_apm_impl_protector_RunnableLancet_run(Task r100) {
            r100.com_bytedance_common_jato_view_ViewDestroyMonitor$Task__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public /* synthetic */ Task(ViewDestroyMonitor r100, AnonymousClass1 r101) {
            this(r100);
        }
    }

    public interface ViewDestroyListener {
        void onViewCreated(View r100, long r101, long r102, String r103, int r104, InflateInfo r105);

        void onViewDestroy(long r100, long r101);
    }

    public static ViewDestroyMonitor getInstance() {
        if (instance != null) goto L15;
        monitor-enter(ViewDestroyMonitor.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (instance != null) goto L9;
        instance = new ViewDestroyMonitor();     // Catch: Throwable -> L11
    L9:
        monitor-exit(ViewDestroyMonitor.class);     // Catch: Throwable -> L11
    L15:
        return instance;
    }

    public boolean checkInit() {
        if (Build.VERSION.SDK_INT >= 24) goto L6;
        return false;
    L6:
        if (this.inited != (-1)) goto L16;
        if (JatoNativeLoader.loadLibrary() == true) goto L10;
    L14:
        this.inited = 0;
        goto L16
    L10:
        if (ViewNative.init() == false) goto L14;
        if (javaInited() == false) goto L14;
        ViewNative.nativeSetEnableMonitor(this.enableMonitor);
        this.inited = 1;
    L16:
        if (this.inited != 1) goto L19;
        return true;
    L19:
        return false;
    }

    public void enableMonitor() {
        if (this.enableMonitor == true) goto L8;
        this.enableMonitor = true;
        if (this.inited != 1) goto L9;
        ViewNative.nativeSetEnableMonitor(true);
        return;
    L9:
        return;
    }

    public InflateInfo getExtraInfo() {
        InflateInfoProvider r100 = this.provider;
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.getInflateInfo();
    }

    public boolean replaceRegistry() {
        if (Build.VERSION.SDK_INT >= 24) goto L8;
        return false;
    L8:
        Field r100 = INVOKEVIRTUAL_com_bytedance_common_jato_view_ViewDestroyMonitor_com_larus_mirabridge_impl_lancet_MiraReflectLancet_loadClass(View.class.getClassLoader(), ViewUtils.getRenderNodeClassName() + "$NoImagePreloadHolder").getDeclaredField("sRegistry");     // Catch: Throwable -> L7
        r100.setAccessible(true);     // Catch: Throwable -> L7
        r100.set(null, new RenderNodeNativeAllocationRegistryProxy(this, (NativeAllocationRegistry) r100.get(null), View.class.getClassLoader(), 0, 0));     // Catch: Throwable -> L7
        return true;
    L7:
        return false;
    }

    public ViewDestroyMonitor() {
        this.random = new SecureRandom();
        this.viewDestroyListeners = new CopyOnWriteArrayList();
        this.sTaskPool = new Pools.SynchronizedPool(1000);
        this.inflateCount = new AtomicInteger(0);
        this.sampleRate = 10000;
        this.ignoreInflate = true;
        this.delay = 100;
        this.inited = -1;
        this.enableMonitor = false;
    }

    private boolean javaInited() {
        if (ViewUtils.checkInit() == true) goto L5;
    L7:
        return false;
    L5:
        if (replaceRegistry() == false) goto L7;
        return true;
    }

    public static void onViewDestroy(long r100) {
        getInstance().onViewDestroyAsync(r100);
    }

    private void onViewDestroyAsync(long r100) {
        Task r101 = newTask(null, r100, TimeUtils.getNow(), null);
        ViewHandler.getHandler().post(r101);
    }

    private long registerRenderNode(long r100) {
        if (r100 != 0) goto L5;
    L10:
        return 0;
    L5:
        if (checkInit() == false) goto L10;
        if (ViewNative.nativeRegister(r100) == false) goto L10;
        return r100;
    }

    public void addViewDestroyListener(ViewDestroyListener r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.viewDestroyListeners.add(r100);
        checkInit();
    }

    public void recycleTask(Task r100) {
        r100.renderNodeRef = null;
        r100.inflateInfo = null;
        this.sTaskPool.release(r100);
    }

    public void setProvider(InflateInfoProvider r100) {
        this.provider = r100;
    }

    public void setSampleRate(int r100) {
        this.sampleRate = r100;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKEVIRTUAL_com_bytedance_common_jato_view_ViewDestroyMonitor_com_larus_mirabridge_impl_lancet_MiraReflectLancet_loadClass(ClassLoader r100, String r101) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r102 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r103 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class<?> r104 = r100.loadClass(r101);     // Catch: Throwable -> L8
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r101);     // Catch: Throwable -> L8
    L7:
        return r104;
    L8:
        th = move-exception;
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r101);
    L12:
        throw th;
    L34:
        Class<?> r105 = r100.loadClass(r101);     // Catch: Throwable -> L17
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r101);     // Catch: Throwable -> L17
    L16:
        return r105;
    L17:
        th = move-exception;
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r101);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.loadClass(r101);
    }

    public static /* synthetic */ long access$100(ViewDestroyMonitor r100, long r101) {
        return r100.registerRenderNode(r101);
    }

    private void onViewDestroyInner(long r100, long r101) {
        Iterator<ViewDestroyListener> r102 = this.viewDestroyListeners.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r102.next().onViewDestroy(r100, r101);
        goto L4
    }

    public void notifyViewCreatedAsync(Object r110, long r111) {
        if (this.ignoreInflate == true) goto L7;
        if (this.inflateCount.get() == 0) goto L7;
        return;
    L7:
        if (this.sampleRate < 10000) goto L9;
    L10:
        ViewHandler.getHandler().postDelayed(newTask(r110, r111, TimeUtils.getNow(), getExtraInfo()), this.delay);
        return;
    L9:
        if (this.random.nextInt(10000) < this.sampleRate) goto L10;
    }

    public static /* synthetic */ void access$000(ViewDestroyMonitor r100, long r101, long r102) {
        r100.onViewDestroyInner(r101, r102);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Task newTask(Object r100, long r101, long r102, InflateInfo r103) {
        Task r104 = this.sTaskPool.acquire();
        WeakReference<Object> r105 = null;
        Object[] r106 = 0;
        if (r104 != null) goto L5;
        r104 = new Task(this, r106 == true ? 1 : 0);
    L5:
        if (r100 == null) goto L8;
        r105 = new WeakReference(r100);
    L8:
        r104.renderNodeRef = r105;
        r104.renderNodePtr = r101;
        r104.timestamp = r102;
        r104.threadName = ThreadMethodProxy.currentThread().getName();
        r104.threadId = Process.myTid();
        r104.inflateInfo = r103;
        return r104;
    }

    public void onViewCreatedInner(View r110, long r111, long r112, String r113, int r114, InflateInfo r210) {
        Iterator<ViewDestroyListener> r100 = this.viewDestroyListeners.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().onViewCreated(r110, r111, r112, r113, r114, r210);
        goto L4
    }
}
