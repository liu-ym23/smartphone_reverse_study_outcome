package com.ss.android.ugc.bytex.pthread.base.convergence.handler.impl;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.ss.android.ugc.bytex.pthread.base.convergence.handler.IMessageHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/convergence/handler/impl/HandlerWrapper;", "Landroid/os/Handler;", "looper", "Landroid/os/Looper;", "messageHandler", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/handler/IMessageHandler;", "(Landroid/os/Looper;Lcom/ss/android/ugc/bytex/pthread/base/convergence/handler/IMessageHandler;)V", "dispatchMessage", "", "msg", "Landroid/os/Message;", "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, 13})
public final class HandlerWrapper extends Handler {
    private final IMessageHandler messageHandler;

    public HandlerWrapper(Looper r100, IMessageHandler r101) {
        super(r100);
        this.messageHandler = r101;
    }

    public /* synthetic */ HandlerWrapper(Looper r100, IMessageHandler r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101);
    }

    @Override // android.os.Handler
    public void dispatchMessage(Message r100) {
        IMessageHandler r101 = this.messageHandler;
        if (r101 == null) goto L5;
        r101.dispatchMessage(r100);
        return;
    L5:
        super.dispatchMessage(r100);
    }
}
