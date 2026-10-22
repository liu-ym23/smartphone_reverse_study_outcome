package com.ss.android.ugc.bytex.pthread.base.convergence.handler.impl;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.ss.android.ugc.bytex.pthread.base.convergence.handler.IHandler;
import com.ss.android.ugc.bytex.pthread.base.convergence.handler.IHandlerExecutor;
import com.ss.android.ugc.bytex.pthread.base.convergence.handler.IHandlerHolder;
import com.ss.android.ugc.bytex.pthread.base.convergence.handler.IMessageHandler;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B!\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u000bH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/convergence/handler/impl/ForwardHandler;", "Landroid/os/Handler;", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/handler/IHandlerHolder;", "looper", "Landroid/os/Looper;", "executor", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/handler/IHandlerExecutor;", "messageHandler", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/handler/IMessageHandler;", "(Landroid/os/Looper;Lcom/ss/android/ugc/bytex/pthread/base/convergence/handler/IHandlerExecutor;Lcom/ss/android/ugc/bytex/pthread/base/convergence/handler/IMessageHandler;)V", "iHandler", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/handler/IHandler;", "getIHandler", "()Lcom/ss/android/ugc/bytex/pthread/base/convergence/handler/IHandler;", "iHandler$delegate", "Lkotlin/Lazy;", "dispatchMessage", "", "msg", "Landroid/os/Message;", "getHandler", "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, 13})
public final class ForwardHandler extends Handler implements IHandlerHolder {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    private final IHandlerExecutor executor;
    private final Lazy iHandler$delegate;
    private final IMessageHandler messageHandler;

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(ForwardHandler.class), "iHandler", "getIHandler()Lcom/ss/android/ugc/bytex/pthread/base/convergence/handler/IHandler;"))};
    }

    public ForwardHandler(Looper r100, IHandlerExecutor r101, IMessageHandler r102) {
        super(r100);
        this.executor = r101;
        this.messageHandler = r102;
        this.iHandler$delegate = LazyKt.lazy(new ForwardHandler$iHandler$2(this));
    }

    public /* synthetic */ ForwardHandler(Looper r100, IHandlerExecutor r101, IMessageHandler r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 4) == 0) goto L5;
        r102 = null;
    L5:
        this(r100, r101, r102);
    }

    public static final /* synthetic */ IHandlerExecutor access$getExecutor$p(ForwardHandler r100) {
        return r100.executor;
    }

    private final IHandler getIHandler() {
        Lazy r100 = this.iHandler$delegate;
        KProperty r101 = $$delegatedProperties[0];
        return (IHandler) r100.getValue();
    }

    @Override // android.os.Handler
    public void dispatchMessage(Message r100) {
        if (UnifiedHandlerThread.INSTANCE.isCurrentThread() == false) goto L5;
        this.executor.dispatchMessage(Message.obtain(r100));
        return;
    L5:
        IMessageHandler r101 = this.messageHandler;
        if (r101 == null) goto L8;
        r101.dispatchMessage(r100);
        return;
    L8:
        super.dispatchMessage(r100);
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.handler.IHandlerHolder
    public IHandler getHandler() {
        return getIHandler();
    }
}
