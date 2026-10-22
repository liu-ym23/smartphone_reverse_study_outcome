package com.ss.android.ugc.bytex.pthread.base.convergence.handler;

import android.os.HandlerThread;
import android.os.Looper;
import com.ss.android.ugc.bytex.pthread.base.convergence.handler.impl.UnifiedHandlerThread;
import com.ss.android.ugc.bytex.pthread.base.convergence.helper.ReflectHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\n\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000bH\u0002¨\u0006\u0012"}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/convergence/handler/FakeHandlerThread;", "Landroid/os/HandlerThread;", "name", "", "(Ljava/lang/String;)V", "priority", "", "(Ljava/lang/String;I)V", "getLooper", "Landroid/os/Looper;", "quit", "", "quitSafely", "start", "", "updateAliveStatus", "alive", "Companion", "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, 13})
public class FakeHandlerThread extends HandlerThread {
    public static final Companion Companion = null;
    private static final ThreadLocal<FakeHandlerThread> looperCall = null;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/convergence/handler/FakeHandlerThread$Companion;", "", "()V", "looperCall", "Ljava/lang/ThreadLocal;", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/handler/FakeHandlerThread;", "getStashThread", "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, 13})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final FakeHandlerThread getStashThread() {
            FakeHandlerThread r100 = (FakeHandlerThread) FakeHandlerThread.access$getLooperCall$cp().get();
            FakeHandlerThread.access$getLooperCall$cp().remove();
            return r100;
        }
    }

    static {
        Companion = new Companion(null);
        looperCall = new ThreadLocal();
    }

    public FakeHandlerThread(String r100) {
        super(r100);
    }

    public FakeHandlerThread(String r100, int r101) {
        super(r100, r101);
    }

    public static final /* synthetic */ ThreadLocal access$getLooperCall$cp() {
        return looperCall;
    }

    private final void updateAliveStatus(boolean r100) {
        if (isAlive() == r100) goto L10;
        ReflectHelper r101 = ReflectHelper.INSTANCE;
        if (r100 == false) goto L7;
        long r102 = 1;
    L8:
        r101.setFieldLongValue(Thread.class, this, "nativePeer", r102);
        return;
    L7:
        r102 = 0;
        goto L8
    }

    @Override // android.os.HandlerThread
    public Looper getLooper() {
        looperCall.set(this);
        return UnifiedHandlerThread.INSTANCE.getLooper();
    }

    @Override // android.os.HandlerThread
    public boolean quit() {
        updateAliveStatus(false);
        return false;
    }

    @Override // android.os.HandlerThread
    public boolean quitSafely() {
        updateAliveStatus(false);
        return false;
    }

    @Override // java.lang.Thread
    public void start() {
        updateAliveStatus(true);
    }
}
