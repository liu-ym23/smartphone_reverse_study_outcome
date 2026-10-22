package com.ss.android.ugc.bytex.pthread.base.convergence.handler;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.ss.android.ugc.bytex.pthread.base.convergence.handler.impl.HandlerFactory;
import com.ss.android.ugc.bytex.pthread.base.convergence.handler.impl.HandlerThreadPool;
import com.ss.android.ugc.bytex.pthread.base.convergence.handler.impl.MessageHandlerAdapter;
import com.ss.android.ugc.bytex.pthread.base.convergence.handler.impl.SysHandlerExecutorFactory;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\"\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0007J\u0018\u0010\u0014\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\r2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aJ\u000e\u0010\u0014\u001a\u00020\u00172\u0006\u0010\u000e\u001a\u00020\u000fJ\u0016\u0010\u0014\u001a\u00020\u00172\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u001aJ\u0016\u0010\u0014\u001a\u00020\u00172\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u001e\u0010\u0014\u001a\u00020\u00172\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0015J \u0010\u0014\u001a\u00020\u00172\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aJ\u0016\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0016\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\nJ \u0010!\u001a\u00020\"2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011J\u000e\u0010!\u001a\u00020\"2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0018\u0010#\u001a\u00020\"2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020\u0011H\u0007J \u0010#\u001a\u00020\"2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010$\u001a\u00020\u0011H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/convergence/handler/HandlerHub;", "", "()V", "enableReplace", "", "handlerFactory", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/handler/IHandlerFactory;", "handlerThreadPool", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/handler/IHandlerThreadPool;", "sysExecutorFactory", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/handler/IHandlerExecutorFactory;", "unifiedExecutorFactory", "createExecutor", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/handler/IHandlerExecutor;", "name", "", "priority", "", "thread", "Ljava/lang/Thread;", "createHandler", "Landroid/os/Handler;", "handler", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/handler/IHandler;", "executor", "messageHandler", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/handler/IMessageHandler;", "createHandlerOnReuseThread", "level", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/handler/BusyLevel;", "init", "", "unifiedHandlerExecutorFactory", "obtainReuseHandlerThread", "Landroid/os/HandlerThread;", "obtainReuseHandlerThreadForASM", "index", "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, 13})
public final class HandlerHub {
    public static final HandlerHub INSTANCE = null;
    private static volatile boolean enableReplace;
    private static final IHandlerFactory handlerFactory = null;
    private static final IHandlerThreadPool handlerThreadPool = null;
    private static final IHandlerExecutorFactory sysExecutorFactory = null;
    private static IHandlerExecutorFactory unifiedExecutorFactory;

    static {
        INSTANCE = new HandlerHub();
        sysExecutorFactory = new SysHandlerExecutorFactory();
        handlerFactory = new HandlerFactory();
        handlerThreadPool = new HandlerThreadPool();
    }

    private HandlerHub() {
    }

    private final IHandlerExecutor createExecutor(String r100, int r101, Thread r102) {
        if (enableReplace == true) goto L6;
        IHandlerExecutorFactory r103 = sysExecutorFactory;
    L9:
        return r103.create(r100, r101, r102);
    L6:
        r103 = unifiedExecutorFactory;
        if (r103 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("unifiedExecutorFactory");
        goto L9
    }

    @JvmStatic
    public static final Handler createHandler(Handler r100) {
        FakeHandlerThread r101 = FakeHandlerThread.Companion.getStashThread();
        if (r101 == null) goto L5;
    L7:
        if (r101 == null) goto L9;
        boolean r102 = true;
    L10:
        if (r102 == false) goto L18;
        HandlerHub r103 = INSTANCE;
        IHandler r104 = r103.createHandler(r103.createExecutor(r101.getName(), r101.getPriority(), r101), new MessageHandlerAdapter(r100));
        if ((r104 instanceof HandlerProvider) == false) goto L16;
        return ((HandlerProvider) r104).getHandler();
    L16:
        throw new IllegalArgumentException("must be is a HandlerProvider".toString());
    L18:
        throw new IllegalArgumentException("not find FakeHandlerThread".toString());
    L9:
        r102 = false;
        goto L10
    L5:
        if (Intrinsics.areEqual(r100.getLooper(), Looper.getMainLooper()) == false) goto L7;
        return r100;
    }

    public static /* synthetic */ HandlerThread obtainReuseHandlerThread$default(HandlerHub r100, BusyLevel r101, String r102, int r103, int r104, Object r105) {
        if ((r104 & 4) == 0) goto L6;
        r103 = 0;
    L6:
        return r100.obtainReuseHandlerThread(r101, r102, r103);
    }

    @JvmStatic
    public static final HandlerThread obtainReuseHandlerThreadForASM(String r100, int r101) {
        return INSTANCE.obtainReuseHandlerThread(BusyLevel.values()[r101], r100, 0);
    }

    @JvmStatic
    public static final HandlerThread obtainReuseHandlerThreadForASM(String r100, int r101, int r102) {
        return INSTANCE.obtainReuseHandlerThread(BusyLevel.values()[r102], r100, r101);
    }

    public final IHandlerExecutor createExecutor(String r100) {
        return createExecutor(r100, 0);
    }

    public final IHandlerExecutor createExecutor(String r100, int r101) {
        return createExecutor(r100, r101, null);
    }

    public final IHandler createHandler(IHandlerExecutor r100, IMessageHandler r101) {
        return handlerFactory.create(r100, r101);
    }

    public final IHandler createHandler(String r100) {
        return createHandler(r100, 0, null);
    }

    public final IHandler createHandler(String r100, int r101) {
        return createHandler(r100, r101, null);
    }

    public final IHandler createHandler(String r100, int r101, Handler r102) {
        return createHandler(createExecutor(r100, r101), new MessageHandlerAdapter(r102));
    }

    public final IHandler createHandler(String r100, int r101, IMessageHandler r102) {
        return createHandler(createExecutor(r100, r101), r102);
    }

    public final IHandler createHandler(String r100, IMessageHandler r101) {
        return createHandler(r100, 0, r101);
    }

    public final Handler createHandlerOnReuseThread(BusyLevel r100, String r101) {
        return new Handler(obtainReuseHandlerThread$default(this, r100, r101, 0, 4, null).getLooper());
    }

    public final void init(boolean r100, IHandlerExecutorFactory r101) {
        unifiedExecutorFactory = r101;
        enableReplace = r100;
    }

    public final HandlerThread obtainReuseHandlerThread(BusyLevel r100, String r101, int r102) {
        if (enableReplace == true) goto L7;
        return new PthreadHandlerThreadV2(r101, r102);
    L7:
        return handlerThreadPool.obtain(r100, r101);
    }

    public final HandlerThread obtainReuseHandlerThread(String r100) {
        return obtainReuseHandlerThread$default(this, BusyLevel.P2, r100, 0, 4, null);
    }
}
