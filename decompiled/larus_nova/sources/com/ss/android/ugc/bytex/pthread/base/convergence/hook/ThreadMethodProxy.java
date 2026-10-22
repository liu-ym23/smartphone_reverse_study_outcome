package com.ss.android.ugc.bytex.pthread.base.convergence.hook;

import android.os.Looper;
import com.ss.android.ugc.bytex.pthread.base.convergence.core.ICoreThread;
import com.ss.android.ugc.bytex.pthread.base.convergence.handler.NotQuitThread;
import com.ss.android.ugc.bytex.pthread.base.convergence.helper.TimeUnitHelper;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007J\b\u0010\t\u001a\u00020\bH\u0007J\u0014\u0010\n\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0007J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J \u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0007J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\u0007J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\u0007J\u0018\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0019H\u0007J\u0018\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u0014H\u0007J\u0010\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0007J \u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u0012H\u0007J\u000e\u0010!\u001a\u0004\u0018\u00010\"*\u00020\bH\u0002¨\u0006#"}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/convergence/hook/ThreadMethodProxy;", "", "()V", "addShutdownHook", "", "runtime", "Ljava/lang/Runtime;", "thread", "Ljava/lang/Thread;", "currentThread", "getAttachThread", "getLooperThread", "looper", "Landroid/os/Looper;", "isAlive", "", "join", "millis", "", "nanos", "", "quit", "quitSafely", "setName", "name", "", "setPriority", "newPriority", "start", "timedJoin", "timeUnit", "Ljava/util/concurrent/TimeUnit;", "timeout", "getProxy", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/hook/IThreadProxy;", "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, 13})
public final class ThreadMethodProxy {
    public static final ThreadMethodProxy INSTANCE = null;

    static {
        INSTANCE = new ThreadMethodProxy();
    }

    private ThreadMethodProxy() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmStatic
    public static final void addShutdownHook(Runtime r100, Thread r101) {
        if ((r101 instanceof IThreadProxyProvider) == false) goto L5;
        ((IThreadProxyProvider) r101).setEnable(false);
    L5:
        if (r100 == null) goto L8;
        r100.addShutdownHook(r101);
        return;
    }

    @JvmStatic
    public static final Thread currentThread() {
        Thread r100 = Thread.currentThread();
        if ((r100 instanceof ICoreThread) == true) goto L5;
        Thread r101 = null;
    L6:
        ICoreThread r102 = (ICoreThread) r101;
        if (r102 == null) goto L12;
        Thread r103 = r102.getDelegateThread();
        if (r103 != null) goto L11;
        return r100;
    L11:
        return r103;
    L12:
        return r100;
    L5:
        r101 = r100;
        goto L6
    }

    @JvmStatic
    public static final Thread getAttachThread(Thread r100) {
        if (r100 == null) goto L9;
        IThreadProxy r101 = INSTANCE.getProxy(r100);
        if (r101 == null) goto L10;
        Thread r102 = r101.getAttachThread();
        if (r102 != null) goto L8;
        return r100;
    L8:
        return r102;
    L10:
        return r100;
    L9:
        return r100;
    }

    @JvmStatic
    public static final Thread getLooperThread(Looper r100) {
        Thread r101 = r100.getThread();
        if ((r101 instanceof ICoreThread) == true) goto L5;
        Thread r102 = null;
    L6:
        ICoreThread r103 = (ICoreThread) r102;
        if (r103 == null) goto L12;
        Thread r104 = r103.getDelegateThread();
        if (r104 != null) goto L11;
        return r101;
    L11:
        return r104;
    L12:
        return r101;
    L5:
        r102 = r101;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final IThreadProxy getProxy(Thread r100) {
        if ((r100 instanceof IThreadProxyProvider) == true) goto L5;
        return null;
    L5:
        return ((IThreadProxyProvider) r100).getProxy();
    }

    @JvmStatic
    public static final boolean isAlive(Thread r100) {
        IThreadProxy r101 = INSTANCE.getProxy(r100);
        if (r101 == null) goto L6;
        return r101.isRealAlive();
    L6:
        return r100.isAlive();
    }

    @JvmStatic
    public static final void join(Thread r100) {
        IThreadProxy r101 = INSTANCE.getProxy(r100);
        if (r101 == null) goto L5;
        r101.join();
        return;
    L5:
        r100.join();
    }

    @JvmStatic
    public static final void join(Thread r100, long r101) {
        IThreadProxy r102 = INSTANCE.getProxy(r100);
        if (r102 == null) goto L5;
        r102.join(r101);
        return;
    L5:
        r100.join(r101);
    }

    @JvmStatic
    public static final void join(Thread r100, long r101, int r102) {
        IThreadProxy r103 = INSTANCE.getProxy(r100);
        if (r103 == null) goto L5;
        r103.join(r101, r102);
        return;
    L5:
        r100.join(r101, r102);
    }

    @JvmStatic
    public static final void quit(Looper r100) {
        if ((r100.getThread() instanceof NotQuitThread) == true) goto L6;
        r100.quit();
        return;
    }

    @JvmStatic
    public static final void quitSafely(Looper r100) {
        if ((r100.getThread() instanceof NotQuitThread) == true) goto L6;
        r100.quitSafely();
        return;
    }

    @JvmStatic
    public static final void setName(Thread r100, String r101) {
        IThreadProxy r102 = INSTANCE.getProxy(r100);
        if (r102 == null) goto L7;
        Thread r103 = r102.getAttachThread();
        if (r103 == null) goto L7;
        r103.setName(r101);
    L7:
        r100.setName(r101);
    }

    @JvmStatic
    public static final void setPriority(Thread r100, int r101) {
        IThreadProxy r102 = INSTANCE.getProxy(r100);
        if (r102 == null) goto L7;
        Thread r103 = r102.getAttachThread();
        if (r103 == null) goto L7;
        r103.setPriority(r101);
    L7:
        r100.setPriority(r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmStatic
    public static final void start(Thread r100) {
        if ((r100 instanceof IThreadProxyProvider) == false) goto L5;
        ((IThreadProxyProvider) r100).setEnable(true);
    L5:
        r100.start();
    }

    @JvmStatic
    public static final void timedJoin(TimeUnit r100, Thread r110, long r111) {
        if (r111 <= 0) goto L6;
        long r101 = r100.toMillis(r111);
        join(r110, r101, TimeUnitHelper.INSTANCE.excessNanos(r100, r111, r101));
        return;
    }
}
