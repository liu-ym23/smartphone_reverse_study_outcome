package com.ss.android.ugc.bytex.pthread.base.convergence.core;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B%\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u0012\u0010\u0013\u001a\u00020\u000e2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R!\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0019"}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/convergence/core/ExemptThreadFactory;", "Ljava/util/concurrent/ThreadFactory;", "namePrefix", "", "debugMode", "", "enableMonitor", "(Ljava/lang/String;ZZ)V", "group", "Ljava/lang/ThreadGroup;", "threadNumber", "Ljava/util/concurrent/atomic/AtomicInteger;", "threadSet", "", "Ljava/lang/Thread;", "getThreadSet", "()Ljava/util/Set;", "threadSet$delegate", "Lkotlin/Lazy;", "newThread", "r", "Ljava/lang/Runnable;", "printAllThreadStackTrace", "", "tag", "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, 13})
public final class ExemptThreadFactory implements ThreadFactory {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    private final boolean debugMode;
    private final boolean enableMonitor;
    private final ThreadGroup group;
    private String namePrefix;
    private final AtomicInteger threadNumber;
    private final Lazy threadSet$delegate;

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(ExemptThreadFactory.class), "threadSet", "getThreadSet()Ljava/util/Set;"))};
    }

    public ExemptThreadFactory() {
        this(null, false, false, 7, null);
    }

    public ExemptThreadFactory(String r100, boolean r101, boolean r102) {
        this.namePrefix = r100;
        this.debugMode = r101;
        this.enableMonitor = r102;
        this.threadNumber = new AtomicInteger(1);
        this.threadSet$delegate = LazyKt.lazy(ExemptThreadFactory$threadSet$2.INSTANCE);
        SecurityManager r103 = System.getSecurityManager();
        if (r103 == null) goto L5;
        ThreadGroup r104 = r103.getThreadGroup();
    L6:
        this.group = r104;
        return;
    L5:
        r104 = Thread.currentThread().getThreadGroup();
        goto L6
    }

    public /* synthetic */ ExemptThreadFactory(String r100, boolean r101, boolean r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = false;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = false;
    L11:
        this(r100, r101, r102);
    }

    public static final /* synthetic */ boolean access$getEnableMonitor$p(ExemptThreadFactory r100) {
        return r100.enableMonitor;
    }

    private final Set<Thread> getThreadSet() {
        Lazy r100 = this.threadSet$delegate;
        KProperty r101 = $$delegatedProperties[0];
        return (Set) r100.getValue();
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(final Runnable r100) {
        CoreThread r101 = new CoreThread(this.group, new ExemptThreadFactory$newThread$t$1(this, r100), this.namePrefix + "-" + this.threadNumber.getAndIncrement(), 0);
        if (r101.isDaemon() == false) goto L6;
        r101.setDaemon(false);
    L6:
        if (r101.getPriority() == 5) goto L9;
        r101.setPriority(5);
    L9:
        if (this.debugMode == false) goto L18;
        Set<Thread> r102 = getThreadSet();
        monitor-enter(r102);
        getThreadSet().add(r101);     // Catch: Throwable -> L15
        monitor-exit(r102);
    L15:
        th = move-exception;
        throw th;
    L18:
        return r101;
    }

    public final void printAllThreadStackTrace(String r110) {
        if (this.debugMode == true) goto L5;
        return;
    L5:
        Set<Thread> r111 = getThreadSet();
        monitor-enter(r111);
        Iterator<Thread> r100 = getThreadSet().iterator();     // Catch: Throwable -> L14
    L9:
        if (r100.hasNext() == false) goto L11;
        ArraysKt.joinToString$default(r100.next().getStackTrace(), "\n", null, null, 0, null, null, 62, null);     // Catch: Throwable -> L14
        goto L9
    L11:
        Unit r101 = Unit.INSTANCE;     // Catch: Throwable -> L14
        monitor-exit(r111);
        return;
    L14:
        th = move-exception;
        throw th;
    }
}
