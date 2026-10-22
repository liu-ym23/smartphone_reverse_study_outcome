package com.ss.android.ugc.bytex.pthread.base.convergence.hook;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.concurrent.Executor;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0017\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB\u000f\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016R\u001d\u0010\n\u001a\u0004\u0018\u00010\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/convergence/hook/HandlerProxy;", "Landroid/os/Handler;", "()V", "looper", "Landroid/os/Looper;", "(Landroid/os/Looper;)V", "callback", "Landroid/os/Handler$Callback;", "(Landroid/os/Looper;Landroid/os/Handler$Callback;)V", "(Landroid/os/Handler$Callback;)V", "executor", "Ljava/util/concurrent/Executor;", "getExecutor", "()Ljava/util/concurrent/Executor;", "executor$delegate", "Lkotlin/Lazy;", "isMainThread", "", "dispatchMessage", "", "msg", "Landroid/os/Message;", "Companion", "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, 13})
public final class HandlerProxy extends Handler {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final Companion Companion = null;
    private static final Looper sMainLooper = null;
    private final Lazy executor$delegate;
    private final boolean isMainThread;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/convergence/hook/HandlerProxy$Companion;", "", "()V", "sMainLooper", "Landroid/os/Looper;", "kotlin.jvm.PlatformType", "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, 13})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(HandlerProxy.class), "executor", "getExecutor()Ljava/util/concurrent/Executor;"))};
        Companion = new Companion(null);
        sMainLooper = Looper.getMainLooper();
    }

    public HandlerProxy() {
        this.executor$delegate = LazyKt.lazy(HandlerProxy$executor$2.INSTANCE);
        this.isMainThread = Intrinsics.areEqual(sMainLooper, getLooper());
    }

    public HandlerProxy(Handler.Callback r100) {
        super(r100);
        this.executor$delegate = LazyKt.lazy(HandlerProxy$executor$2.INSTANCE);
        this.isMainThread = Intrinsics.areEqual(sMainLooper, getLooper());
    }

    public HandlerProxy(Looper r100) {
        super(r100);
        this.executor$delegate = LazyKt.lazy(HandlerProxy$executor$2.INSTANCE);
        this.isMainThread = Intrinsics.areEqual(sMainLooper, getLooper());
    }

    public HandlerProxy(Looper r100, Handler.Callback r101) {
        super(r100, r101);
        this.executor$delegate = LazyKt.lazy(HandlerProxy$executor$2.INSTANCE);
        this.isMainThread = Intrinsics.areEqual(sMainLooper, getLooper());
    }

    /* JADX INFO: renamed from: access$dispatchMessage$s-270412444, reason: not valid java name */
    public static final /* synthetic */ void m8706access$dispatchMessage$s270412444(HandlerProxy r100, Message r101) {
        super.dispatchMessage(r101);
    }

    private final Executor getExecutor() {
        Lazy r100 = this.executor$delegate;
        KProperty r101 = $$delegatedProperties[0];
        return (Executor) r100.getValue();
    }

    @Override // android.os.Handler
    public void dispatchMessage(final Message r100) {
        Executor r101 = getExecutor();
        if (this.isMainThread == true) goto L8;
        if (r101 == null) goto L8;
        r101.execute(new AnonymousClass1(this, r100));
        return;
    L8:
        super.dispatchMessage(r100);
    }
}
