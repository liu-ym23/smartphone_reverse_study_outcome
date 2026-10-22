package com.ss.android.ugc.bytex.pthread.base.convergence.hook;

import android.os.Handler;
import com.ss.android.ugc.bytex.pthread.base.convergence.handler.IHandlerHolder;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0001H\u0007J\u001a\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0007J$\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u0007J\u001a\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u0007J\u0018\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\"\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0001H\u0007¨\u0006\u0011"}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/convergence/hook/HandlerMethodProxy;", "", "()V", "hasMessages", "", "handler", "Landroid/os/Handler;", "what", "", "object", "removeCallbacks", "", "r", "Ljava/lang/Runnable;", "token", "removeCallbacksAndMessages", "removeMessages", "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, 13})
public final class HandlerMethodProxy {
    public static final HandlerMethodProxy INSTANCE = null;

    static {
        INSTANCE = new HandlerMethodProxy();
    }

    private HandlerMethodProxy() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmStatic
    public static final boolean hasMessages(Handler r100, int r101) {
        if ((r100 instanceof IHandlerHolder) == false) goto L6;
        return ((IHandlerHolder) r100).getHandler().hasMessages(r101);
    L6:
        return r100.hasMessages(r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmStatic
    public static final boolean hasMessages(Handler r100, int r101, Object r102) {
        if ((r100 instanceof IHandlerHolder) == false) goto L6;
        return ((IHandlerHolder) r100).getHandler().hasMessages(r101, r102);
    L6:
        return r100.hasMessages(r101, r102);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmStatic
    public static final void removeCallbacks(Handler r100, Runnable r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        if ((r100 instanceof IHandlerHolder) == false) goto L6;
        ((IHandlerHolder) r100).getHandler().removeCallbacks(r101);
        return;
    L6:
        r100.removeCallbacks(r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmStatic
    public static final void removeCallbacks(Handler r100, Runnable r101, Object r102) {
        if (r101 != null) goto L4;
        return;
    L4:
        if ((r100 instanceof IHandlerHolder) == false) goto L6;
        ((IHandlerHolder) r100).getHandler().removeCallbacks(r101, r102);
        return;
    L6:
        r100.removeCallbacks(r101, r102);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmStatic
    public static final void removeCallbacksAndMessages(Handler r100, Object r101) {
        if ((r100 instanceof IHandlerHolder) == false) goto L5;
        ((IHandlerHolder) r100).getHandler().removeCallbacksAndMessages(r101);
        return;
    L5:
        r100.removeCallbacksAndMessages(r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmStatic
    public static final void removeMessages(Handler r100, int r101) {
        if ((r100 instanceof IHandlerHolder) == false) goto L5;
        ((IHandlerHolder) r100).getHandler().removeMessages(r101);
        return;
    L5:
        r100.removeMessages(r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmStatic
    public static final void removeMessages(Handler r100, int r101, Object r102) {
        if ((r100 instanceof IHandlerHolder) == false) goto L5;
        ((IHandlerHolder) r100).getHandler().removeMessages(r101, r102);
        return;
    L5:
        r100.removeMessages(r101, r102);
    }
}
