package com.ss.android.ugc.bytex.pthread.base.proxy;

import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import com.ss.android.ugc.bytex.pthread.base.convergence.SuperThreadPool;
import com.ss.android.ugc.bytex.pthread.base.convergence.external.IThreadMonitor;
import com.ss.android.ugc.bytex.pthread.base.convergence.handler.Dispatcher;
import com.ss.android.ugc.bytex.pthread.base.convergence.handler.ReuseableHandlerThread;
import com.ss.android.ugc.bytex.pthread.base.convergence.helper.SystemUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ExtraProvider;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.HandlerThreadProxyWrapper;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.IThreadProxy;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadProxy;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000f\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u0017\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0010\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020(H\u0016J\u0012\u0010-\u001a\u0004\u0018\u00010\u000e2\u0006\u0010.\u001a\u00020\u0005H\u0016J\b\u0010/\u001a\u00020\bH\u0016J\n\u00100\u001a\u0004\u0018\u00010\u0013H\u0016J\n\u00101\u001a\u0004\u0018\u000102H\u0016J\b\u00103\u001a\u00020\bH\u0016J\b\u00104\u001a\u00020\u000bH\u0016J\b\u00105\u001a\u00020+H\u0002J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u00106\u001a\u00020+H\u0016J\b\u00107\u001a\u00020+H\u0002J\b\u00108\u001a\u00020\u000bH\u0016J\b\u00109\u001a\u00020\u000bH\u0017J\u0012\u0010:\u001a\u0004\u0018\u00010\u000e2\u0006\u0010.\u001a\u00020\u0005H\u0016J\b\u0010;\u001a\u00020+H\u0016J\u0018\u0010<\u001a\u00020+2\u0006\u0010.\u001a\u00020\u00052\u0006\u0010=\u001a\u00020\u000eH\u0016J\b\u0010>\u001a\u00020+H\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u001a\u001a\u0004\u0018\u00010\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010 \u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u000e\u0010%\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010&\u001a\b\u0012\u0004\u0012\u00020(0'X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006?"}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/proxy/PthreadHandlerThreadV2;", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/hook/HandlerThreadProxyWrapper;", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/hook/ExtraProvider;", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/handler/ReuseableHandlerThread;", "name", "", "(Ljava/lang/String;)V", "priority", "", "(Ljava/lang/String;I)V", "isQuit", "", "mExtra", "Ljava/util/concurrent/ConcurrentHashMap;", "", "mIdentify", "mLock", "Ljava/lang/Object;", "mLooper", "Landroid/os/Looper;", "getMLooper", "()Landroid/os/Looper;", "setMLooper", "(Landroid/os/Looper;)V", "mName", "mPriority", "mThreadProxy", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/hook/ThreadProxy;", "getMThreadProxy", "()Lcom/ss/android/ugc/bytex/pthread/base/convergence/hook/ThreadProxy;", "mThreadProxy$delegate", "Lkotlin/Lazy;", "mTid", "getMTid", "()I", "setMTid", "(I)V", "resueThread", "runnableBlockingQueue", "Ljava/util/concurrent/LinkedBlockingQueue;", "Ljava/lang/Runnable;", "tidLock", "execute", "", "runnable", "getExtra", "key", "getIdentify", "getLooper", "getProxy", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/hook/IThreadProxy;", "getThreadId", "isReuse", "loopExecuteMessage", "onQuit", "prepareReuseLooper", "quit", "quitSafely", "removeExtra", "run", "setExtra", "value", "start", "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, 13})
public class PthreadHandlerThreadV2 extends HandlerThreadProxyWrapper implements ReuseableHandlerThread, ExtraProvider {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    private volatile boolean isQuit;
    private ConcurrentHashMap<String, Object> mExtra;
    private final int mIdentify;
    private final Object mLock;
    private Looper mLooper;
    private final String mName;
    private int mPriority;
    private final Lazy mThreadProxy$delegate;
    private int mTid;
    private volatile boolean resueThread;
    private final LinkedBlockingQueue<Runnable> runnableBlockingQueue;
    private final Object tidLock;

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(PthreadHandlerThreadV2.class), "mThreadProxy", "getMThreadProxy()Lcom/ss/android/ugc/bytex/pthread/base/convergence/hook/ThreadProxy;"))};
    }

    public PthreadHandlerThreadV2(String r100) {
        super(r100);
        this.mTid = -1;
        this.mLock = new Object();
        this.mIdentify = Dispatcher.attachHandlerThreadIdentify();
        this.tidLock = new Object();
        this.runnableBlockingQueue = new LinkedBlockingQueue();
        this.isQuit = true;
        this.mExtra = new ConcurrentHashMap();
        this.mThreadProxy$delegate = LazyKt.lazy(new PthreadHandlerThreadV2$mThreadProxy$2(this));
        this.mName = r100;
    }

    public PthreadHandlerThreadV2(String r100, int r101) {
        super(r100, r101);
        this.mTid = -1;
        this.mLock = new Object();
        this.mIdentify = Dispatcher.attachHandlerThreadIdentify();
        this.tidLock = new Object();
        this.runnableBlockingQueue = new LinkedBlockingQueue();
        this.isQuit = true;
        this.mExtra = new ConcurrentHashMap();
        this.mThreadProxy$delegate = LazyKt.lazy(new PthreadHandlerThreadV2$mThreadProxy$2(this));
        this.mName = r100;
    }

    private final ThreadProxy getMThreadProxy() {
        Lazy r100 = this.mThreadProxy$delegate;
        KProperty r101 = $$delegatedProperties[0];
        return (ThreadProxy) r100.getValue();
    }

    private final void loopExecuteMessage() {
    L3:
        if (this.isQuit == true) goto L4;
        Runnable r100 = this.runnableBlockingQueue.take();     // Catch: Exception -> L7
    L8:
        if (r100 == null) goto L3;
        r100.run();
    L7:
        r100 = null;
        goto L8
    }

    private final void prepareReuseLooper() {
        Looper r100 = Dispatcher.getDispatcherLooper();
        Looper r101 = SystemUtils.newLooper();
        SystemUtils.setupLooper(r101, SystemUtils.getLooperMessageQueue(r100), this);
        this.mLooper = r101;
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.handler.ReuseableHandlerThread
    public void execute(Runnable r100) {
        this.runnableBlockingQueue.put(r100);     // Catch: Exception -> L4
        return;
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.hook.ExtraProvider
    public Object getExtra(String r100) {
        return this.mExtra.get(r100);
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.handler.ReuseableHandlerThread
    public int getIdentify() {
        return this.mIdentify;
    }

    @Override // android.os.HandlerThread
    public Looper getLooper() {
        IThreadProxy r100 = getProxy();
        if (r100 == null) goto L27;
        if (r100.isRealAlive() == true) goto L8;
        return null;
    L8:
        Looper r101 = this.mLooper;
        if (r101 == null) goto L11;
        return r101;
    L11:
        Object r102 = this.mLock;
        monitor-enter(r102);
    L31:
    L23:
        th = move-exception;
        throw th;
    L14:
        if (r100.isRealAlive() == false) goto L19;
        if (this.mLooper != null) goto L19;
        this.mLock.wait();     // Catch: InterruptedException -> L28 Throwable -> L23
    L19:
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L23
        monitor-exit(r102);
        return this.mLooper;
    L27:
        return super.getLooper();
    }

    public final Looper getMLooper() {
        return this.mLooper;
    }

    public final int getMTid() {
        return this.mTid;
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.hook.IThreadProxyProvider
    public IThreadProxy getProxy() {
        if (isEnable$threadpool_plugin_base_release() == true) goto L7;
        return null;
    L7:
        return getMThreadProxy();
    }

    @Override // android.os.HandlerThread
    public int getThreadId() {
        if (this.resueThread == false) goto L26;
        if (this.mTid != (-1)) goto L24;
        IThreadProxy r100 = getProxy();
        if (r100 != null) goto L9;
        Intrinsics.throwNpe();
    L9:
        Object r101 = this.tidLock;
        monitor-enter(r101);
    L34:
    L20:
        th = move-exception;
        throw th;
    L12:
        if (r100.isRealAlive() == false) goto L17;
        if (this.mTid != (-1)) goto L17;
        this.tidLock.wait();     // Catch: InterruptedException -> L31 Throwable -> L20
    L17:
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L20
        monitor-exit(r101);
    L24:
        return this.mTid;
    L26:
        if (getProxy() == null) goto L30;
        return this.mTid;
    L30:
        return super.getThreadId();
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.handler.ReuseableHandlerThread
    public boolean isReuse() {
        return this.resueThread;
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.handler.ReuseableHandlerThread
    public String name() {
        return this.mName;
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.handler.ReuseableHandlerThread
    public void onQuit() {
        this.mTid = -1;
        this.isQuit = true;
    }

    @Override // android.os.HandlerThread
    public boolean quit() {
        if (this.resueThread == false) goto L11;
        Looper r100 = getLooper();
        if (r100 == null) goto L8;
        Dispatcher.onLooperQuit(r100);
        return true;
    L8:
        return false;
    L11:
        return super.quit();
    }

    @Override // android.os.HandlerThread
    public boolean quitSafely() {
        if (this.resueThread == false) goto L11;
        Looper r100 = getLooper();
        if (r100 == null) goto L8;
        Dispatcher.onLooperQuit(r100);
        return true;
    L8:
        return false;
    L11:
        return super.quitSafely();
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.hook.ExtraProvider
    public Object removeExtra(String r100) {
        return this.mExtra.remove(r100);
    }

    @Override // android.os.HandlerThread, java.lang.Thread, java.lang.Runnable
    public void run() {
        if (this.resueThread == false) goto L15;
        SystemUtils.getLooperThreadLocal().set(this.mLooper);
        Object r100 = this.tidLock;
        monitor-enter(r100);
        this.mTid = Process.myTid();     // Catch: Throwable -> L12
        this.tidLock.notifyAll();     // Catch: Throwable -> L12
        Unit r101 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(r100);
        Process.setThreadPriority(this.mPriority);
        onLooperPrepared();
        IThreadMonitor r102 = SuperThreadPool.INSTANCE.getThreadMonitor();
        if (r102 == null) goto L11;
        r102.afterLooperPrepared(this);
    L11:
        loopExecuteMessage();
        this.mTid = -1;
        return;
    L12:
        th = move-exception;
        throw th;
    L15:
        SuperThreadPool r103 = SuperThreadPool.INSTANCE;
        if (r103.isEnable(4) == true) goto L18;
        IThreadMonitor r104 = r103.getThreadMonitor();
    L19:
        if (r104 == null) goto L45;
        r104.onThreadRunning(this);
    L45:
    L41:
        th = move-exception;
        if (r104 == null) goto L44;
        r104.onThreadExit(this);
    L44:
        throw th;
    L22:
        if (getProxy() == null) goto L37;
        this.mTid = Process.myTid();     // Catch: Throwable -> L41
        Looper.prepare();     // Catch: Throwable -> L41
        Object r105 = this.mLock;     // Catch: Throwable -> L41
        monitor-enter(r105);     // Catch: Throwable -> L41
        this.mLooper = Looper.myLooper();     // Catch: Throwable -> L34
        this.mLock.notifyAll();     // Catch: Throwable -> L34
        Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L34
        monitor-exit(r105);     // Catch: Throwable -> L41
        Process.setThreadPriority(this.mPriority);     // Catch: Throwable -> L41
        onLooperPrepared();     // Catch: Throwable -> L41
        IThreadMonitor r107 = r103.getThreadMonitor();     // Catch: Throwable -> L41
        if (r107 == null) goto L30;
        r107.afterLooperPrepared(this);     // Catch: Throwable -> L41
    L30:
        Looper.loop();     // Catch: Throwable -> L41
        this.mTid = -1;     // Catch: Throwable -> L41
        if (r104 == null) goto L51;
        r104.onThreadExit(this);
        return;
    L51:
        return;
    L34:
        th = move-exception;
        throw th;     // Catch: Throwable -> L41
    L37:
        super.run();     // Catch: Throwable -> L41
        if (r104 == null) goto L52;
        r104.onThreadExit(this);
        return;
    L52:
        return;
    L18:
        r104 = null;
        goto L19
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.hook.ExtraProvider
    public void setExtra(String r100, Object r101) {
        this.mExtra.put(r100, r101);
    }

    public final void setMLooper(Looper r100) {
        this.mLooper = r100;
    }

    public final void setMTid(int r100) {
        this.mTid = r100;
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.hook.HandlerThreadProxyWrapper, java.lang.Thread
    public void start() {
        SuperThreadPool r100 = SuperThreadPool.INSTANCE;
        if (r100.getEnableHandlerThreadReuse() == true) goto L5;
    L9:
        boolean r101 = false;
    L10:
        this.resueThread = r101;
        if (this.resueThread == false) goto L16;
        this.isQuit = false;
        prepareReuseLooper();
        super.start();
        Looper r102 = this.mLooper;
        if (r102 != null) goto L15;
        Intrinsics.throwNpe();
    L15:
        new Handler(r102).post(this);
        return;
    L16:
        super.start();
        return;
    L5:
        if (r100.isEnable(4) == false) goto L9;
        if (isEnable$threadpool_plugin_base_release() == false) goto L9;
        r101 = true;
        goto L10
    }
}
