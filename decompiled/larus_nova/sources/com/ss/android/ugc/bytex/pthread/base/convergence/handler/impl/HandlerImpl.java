package com.ss.android.ugc.bytex.pthread.base.convergence.handler.impl;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.ugc.glue.monitor.UGCMonitor;
import com.ss.android.ugc.bytex.pthread.base.convergence.handler.HandlerProvider;
import com.ss.android.ugc.bytex.pthread.base.convergence.handler.IHandler;
import com.ss.android.ugc.bytex.pthread.base.convergence.handler.IHandlerExecutor;
import com.ss.android.ugc.bytex.pthread.base.convergence.handler.IMessageQueue;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\n\u001a\u00020\u0004H\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u001a\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u000eH\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u001a\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0016\u001a\u0004\u0018\u00010\u0012H\u0016J \u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0010H\u0016J*\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00102\b\u0010\u0016\u001a\u0004\u0018\u00010\u0012H\u0016J\u0010\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\"\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0018\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020 H\u0016J\"\u0010!\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u00122\u0006\u0010\"\u001a\u00020 H\u0017J\u0018\u0010!\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020 H\u0016J\u0010\u0010#\u001a\u00020$2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u001a\u0010#\u001a\u00020$2\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u0010%\u001a\u00020$2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0012H\u0016J\u0010\u0010&\u001a\u00020$2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u001a\u0010&\u001a\u00020$2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0010\u0010'\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010(\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0018\u0010)\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020 H\u0016J\u0010\u0010*\u001a\u00020\u000e2\u0006\u0010+\u001a\u00020\u0015H\u0016J\u0018\u0010,\u001a\u00020\u000e2\u0006\u0010+\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0018\u0010-\u001a\u00020\u000e2\u0006\u0010+\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020 H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/convergence/handler/impl/HandlerImpl;", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/handler/IHandler;", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/handler/HandlerProvider;", "handler", "Landroid/os/Handler;", "messageQueue", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/handler/IMessageQueue;", "executor", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/handler/IHandlerExecutor;", "(Landroid/os/Handler;Lcom/ss/android/ugc/bytex/pthread/base/convergence/handler/IMessageQueue;Lcom/ss/android/ugc/bytex/pthread/base/convergence/handler/IHandlerExecutor;)V", "getHandler", "getLooper", "Landroid/os/Looper;", "hasMessages", "", "what", "", "object", "", "isCurrentThread", "obtainMessage", "Landroid/os/Message;", MapBundleKey.MapObjKey.OBJ_SL_OBJ, "arg1", "arg2", UGCMonitor.TYPE_POST, "r", "Ljava/lang/Runnable;", "postAtFrontOfQueue", "postAtTime", "token", "uptimeMillis", "", "postDelayed", "delayMillis", "removeCallbacks", "", "removeCallbacksAndMessages", "removeMessages", "sendEmptyMessage", "sendEmptyMessageAtTime", "sendEmptyMessageDelayed", "sendMessageAtFrontOfQueue", "msg", "sendMessageAtTime", "sendMessageDelayed", "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, 13})
public final class HandlerImpl implements HandlerProvider, IHandler {
    private final IHandlerExecutor executor;
    private final Handler handler;
    private final IMessageQueue messageQueue;

    public HandlerImpl(Handler r100, IMessageQueue r101, IHandlerExecutor r102) {
        this.handler = r100;
        this.messageQueue = r101;
        this.executor = r102;
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.handler.HandlerProvider
    public Handler getHandler() {
        return this.handler;
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.handler.IHandler
    public Looper getLooper() {
        return this.handler.getLooper();
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.handler.IHandler
    public boolean hasMessages(int r100) {
        if (this.handler.hasMessages(r100) == false) goto L6;
        return true;
    L6:
        IMessageQueue r101 = this.messageQueue;
        if (r101 != null) goto L11;
        return false;
    L11:
        return r101.hasMessages(this.handler, r100, null);
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.handler.IHandler
    public boolean hasMessages(int r100, Object r101) {
        if (this.handler.hasMessages(r100, r101) == false) goto L6;
        return true;
    L6:
        IMessageQueue r102 = this.messageQueue;
        if (r102 != null) goto L11;
        return false;
    L11:
        return r102.hasMessages(this.handler, r100, r101);
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.handler.IHandler
    public boolean isCurrentThread() {
        return this.executor.isCurrentThread();
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.handler.IHandler
    public Message obtainMessage() {
        return this.handler.obtainMessage();
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.handler.IHandler
    public Message obtainMessage(int r100) {
        return this.handler.obtainMessage(r100);
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.handler.IHandler
    public Message obtainMessage(int r100, int r101, int r102) {
        return this.handler.obtainMessage(r100, r101, r102);
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.handler.IHandler
    public Message obtainMessage(int r100, int r101, int r102, Object r103) {
        return this.handler.obtainMessage(r100, r101, r102, r103);
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.handler.IHandler
    public Message obtainMessage(int r100, Object r101) {
        return this.handler.obtainMessage(r100, r101);
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.handler.IHandler
    public boolean post(Runnable r100) {
        return this.handler.post(r100);
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.handler.IHandler
    public boolean postAtFrontOfQueue(Runnable r100) {
        return this.handler.postAtFrontOfQueue(r100);
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.handler.IHandler
    public boolean postAtTime(Runnable r100, long r101) {
        return this.handler.postAtTime(r100, r101);
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.handler.IHandler
    public boolean postAtTime(Runnable r100, Object r101, long r102) {
        return this.handler.postAtTime(r100, r101, r102);
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.handler.IHandler
    public boolean postDelayed(Runnable r100, long r101) {
        return this.handler.postDelayed(r100, r101);
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.handler.IHandler
    public boolean postDelayed(Runnable r100, Object r101, long r102) {
        return this.handler.postDelayed(r100, r101, r102);
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.handler.IHandler
    public void removeCallbacks(Runnable r100) {
        this.handler.removeCallbacks(r100);
        IMessageQueue r101 = this.messageQueue;
        if (r101 == null) goto L6;
        r101.removeMessages(this.handler, r100, null);
        return;
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.handler.IHandler
    public void removeCallbacks(Runnable r100, Object r101) {
        this.handler.removeCallbacks(r100, r101);
        IMessageQueue r102 = this.messageQueue;
        if (r102 == null) goto L6;
        r102.removeMessages(this.handler, r100, r101);
        return;
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.handler.IHandler
    public void removeCallbacksAndMessages(Object r100) {
        this.handler.removeCallbacksAndMessages(r100);
        IMessageQueue r101 = this.messageQueue;
        if (r101 == null) goto L6;
        r101.removeCallbacksAndMessages(this.handler, r100);
        return;
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.handler.IHandler
    public void removeMessages(int r100) {
        this.handler.removeMessages(r100);
        IMessageQueue r101 = this.messageQueue;
        if (r101 == null) goto L6;
        r101.removeMessages(this.handler, r100, null);
        return;
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.handler.IHandler
    public void removeMessages(int r100, Object r101) {
        this.handler.removeMessages(r100, r101);
        IMessageQueue r102 = this.messageQueue;
        if (r102 == null) goto L6;
        r102.removeMessages(this.handler, r100, r101);
        return;
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.handler.IHandler
    public boolean sendEmptyMessage(int r100) {
        return this.handler.sendEmptyMessage(r100);
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.handler.IHandler
    public boolean sendEmptyMessageAtTime(int r100, long r101) {
        return this.handler.sendEmptyMessageAtTime(r100, r101);
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.handler.IHandler
    public boolean sendEmptyMessageDelayed(int r100, long r101) {
        return this.handler.sendEmptyMessageDelayed(r100, r101);
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.handler.IHandler
    public boolean sendMessage(Message r100) {
        return IHandler.DefaultImpls.sendMessage(this, r100);
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.handler.IHandler
    public boolean sendMessageAtFrontOfQueue(Message r100) {
        return this.handler.sendMessageAtFrontOfQueue(r100);
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.handler.IHandler
    public boolean sendMessageAtTime(Message r100, long r101) {
        return this.handler.sendMessageAtTime(r100, r101);
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.handler.IHandler
    public boolean sendMessageDelayed(Message r100, long r101) {
        return this.handler.sendMessageDelayed(r100, r101);
    }
}
