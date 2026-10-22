package com.ss.android.ugc.bytex.pthread.base.convergence.hook;

import android.os.Looper;
import android.util.EventsUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.core.ICoreThread;
import com.ss.android.ugc.bytex.pthread.base.convergence.handler.NotQuitThread;
import com.ss.android.ugc.bytex.pthread.base.convergence.helper.TimeUnitHelper;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007J\b\u0010\t\u001a\u00020\bH\u0007J\u0014\u0010\n\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0007J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J \u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0007J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\u0007J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\u0007J\u0018\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0019H\u0007J\u0018\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u0014H\u0007J\u0010\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0007J \u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u0012H\u0007J\u000e\u0010!\u001a\u0004\u0018\u00010\"*\u00020\bH\u0002¨\u0006#"}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/convergence/hook/ThreadMethodProxy;", XmlPullParser.NO_NAMESPACE, "()V", "addShutdownHook", XmlPullParser.NO_NAMESPACE, "runtime", "Ljava/lang/Runtime;", "thread", "Ljava/lang/Thread;", "currentThread", "getAttachThread", "getLooperThread", "looper", "Landroid/os/Looper;", "isAlive", XmlPullParser.NO_NAMESPACE, "join", "millis", XmlPullParser.NO_NAMESPACE, "nanos", XmlPullParser.NO_NAMESPACE, "quit", "quitSafely", "setName", "name", XmlPullParser.NO_NAMESPACE, "setPriority", "newPriority", "start", "timedJoin", "timeUnit", "Ljava/util/concurrent/TimeUnit;", "timeout", "getProxy", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/hook/IThreadProxy;", "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, EventsUtils.FEAT_TYPE_PERF_COMMON_DATA})
public final class ThreadMethodProxy {
    public static final ThreadMethodProxy INSTANCE = null;

    static {
        INSTANCE = new ThreadMethodProxy();
    }

    private ThreadMethodProxy() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmStatic
    public static final void addShutdownHook(Runtime r2, Thread r3) {
        if ((r3 instanceof IThreadProxyProvider) == false) goto L5;
        ((IThreadProxyProvider) r3).setEnable(false);
    L5:
        if (r2 == null) goto L8;
        r2.addShutdownHook(r3);
        return;
    }

    @JvmStatic
    public static final Thread currentThread() {
        Thread r0 = Thread.currentThread();
        if ((r0 instanceof ICoreThread) == true) goto L5;
        Thread r1 = null;
    L6:
        ICoreThread r2 = (ICoreThread) r1;
        if (r2 == null) goto L12;
        Thread r3 = r2.getDelegateThread();
        if (r3 != null) goto L11;
        return r0;
    L11:
        return r3;
    L12:
        return r0;
    L5:
        r1 = r0;
        goto L6
    }

    @JvmStatic
    public static final Thread getAttachThread(Thread r1) {
        if (r1 == null) goto L9;
        IThreadProxy r0 = INSTANCE.getProxy(r1);
        if (r0 == null) goto L10;
        Thread r2 = r0.getAttachThread();
        if (r2 != null) goto L8;
        return r1;
    L8:
        return r2;
    L10:
        return r1;
    L9:
        return r1;
    }

    @JvmStatic
    public static final Thread getLooperThread(Looper r1) {
        Thread r2 = r1.getThread();
        if ((r2 instanceof ICoreThread) == true) goto L5;
        Thread r0 = null;
    L6:
        ICoreThread r3 = (ICoreThread) r0;
        if (r3 == null) goto L12;
        Thread r4 = r3.getDelegateThread();
        if (r4 != null) goto L11;
        return r2;
    L11:
        return r4;
    L12:
        return r2;
    L5:
        r0 = r2;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final IThreadProxy getProxy(Thread r2) {
        if ((r2 instanceof IThreadProxyProvider) == true) goto L5;
        return null;
    L5:
        return ((IThreadProxyProvider) r2).getProxy();
    }

    @JvmStatic
    public static final boolean isAlive(Thread r1) {
        IThreadProxy r0 = INSTANCE.getProxy(r1);
        if (r0 == null) goto L6;
        return r0.isRealAlive();
    L6:
        return r1.isAlive();
    }

    @JvmStatic
    public static final void join(Thread r1) {
        IThreadProxy r0 = INSTANCE.getProxy(r1);
        if (r0 == null) goto L5;
        r0.join();
        return;
    L5:
        r1.join();
    }

    @JvmStatic
    public static final void join(Thread r1, long r2) {
        IThreadProxy r0 = INSTANCE.getProxy(r1);
        if (r0 == null) goto L5;
        r0.join(r2);
        return;
    L5:
        r1.join(r2);
    }

    @JvmStatic
    public static final void join(Thread r1, long r2, int r4) {
        IThreadProxy r0 = INSTANCE.getProxy(r1);
        if (r0 == null) goto L5;
        r0.join(r2, r4);
        return;
    L5:
        r1.join(r2, r4);
    }

    @JvmStatic
    public static final void quit(Looper r1) {
        if ((r1.getThread() instanceof NotQuitThread) == true) goto L6;
        r1.quit();
        return;
    }

    @JvmStatic
    public static final void quitSafely(Looper r1) {
        if ((r1.getThread() instanceof NotQuitThread) == true) goto L6;
        r1.quitSafely();
        return;
    }

    @JvmStatic
    public static final void setName(Thread r1, String r2) {
        IThreadProxy r0 = INSTANCE.getProxy(r1);
        if (r0 == null) goto L7;
        Thread r3 = r0.getAttachThread();
        if (r3 == null) goto L7;
        r3.setName(r2);
    L7:
        r1.setName(r2);
    }

    @JvmStatic
    public static final void setPriority(Thread r1, int r2) {
        IThreadProxy r0 = INSTANCE.getProxy(r1);
        if (r0 == null) goto L7;
        Thread r3 = r0.getAttachThread();
        if (r3 == null) goto L7;
        r3.setPriority(r2);
    L7:
        r1.setPriority(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmStatic
    public static final void start(Thread r2) {
        if ((r2 instanceof IThreadProxyProvider) == false) goto L5;
        ((IThreadProxyProvider) r2).setEnable(true);
    L5:
        r2.start();
    }

    @JvmStatic
    public static final void timedJoin(TimeUnit r9, Thread r10, long r11) {
        if (r11 <= 0) goto L6;
        long r0 = r9.toMillis(r11);
        join(r10, r0, TimeUnitHelper.INSTANCE.excessNanos(r9, r11, r0));
        return;
    }
}
