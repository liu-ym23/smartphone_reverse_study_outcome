package com.ss.android.ugc.bytex.pthread.base.convergence.handler.impl;

import android.os.Handler;
import android.os.Message;
import com.ss.android.ugc.bytex.pthread.base.convergence.handler.IMessageHandler;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/convergence/handler/impl/MessageHandlerAdapter;", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/handler/IMessageHandler;", "handler", "Landroid/os/Handler;", "(Landroid/os/Handler;)V", "dispatchMessage", "", "msg", "Landroid/os/Message;", "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, 13})
public final class MessageHandlerAdapter implements IMessageHandler {
    private final Handler handler;

    public MessageHandlerAdapter(Handler r100) {
        this.handler = r100;
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.handler.IMessageHandler
    public void dispatchMessage(Message r100) {
        this.handler.dispatchMessage(r100);
    }
}
