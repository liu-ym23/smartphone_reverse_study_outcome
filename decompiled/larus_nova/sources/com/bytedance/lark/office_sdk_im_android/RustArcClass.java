package com.bytedance.lark.office_sdk_im_android;

import com.bytedance.map.api.monitor.MapMonitorConst;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J<\u0010\f\u001a\u0002H\r\"\u0004\b\u0000\u0010\r2!\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u0002H\r0\u000fH\u0080\bø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\b\u0010\u0017\u001a\u00020\u0015H\u0014J\r\u0010\u0018\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\u0019R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\u00020\u0004X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001a"}, d2 = {"Lcom/bytedance/lark/office_sdk_im_android/RustArcClass;", "Lcom/bytedance/lark/office_sdk_im_android/Disposable;", "Ljava/lang/AutoCloseable;", "pointer", "", "(J)V", "callCounter", "Ljava/util/concurrent/atomic/AtomicLong;", "getPointer", "()J", "wasDestroyed", "Ljava/util/concurrent/atomic/AtomicBoolean;", "callWithPointer", "R", "block", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "callWithPointer$office_sdk_im_android_release", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "close", "", MapMonitorConst.EVENT_DESTROY, "freeRustArcPtr", "getPointerInternal", "getPointerInternal$office_sdk_im_android_release", "office_sdk_im_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class RustArcClass implements Disposable, AutoCloseable {
    private final AtomicLong callCounter;
    private final long pointer;
    private final AtomicBoolean wasDestroyed;

    @Override // java.lang.AutoCloseable
    public synchronized void close() {
        monitor-enter(this);
        destroy();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public void freeRustArcPtr() {
    }

    @Override // com.bytedance.lark.office_sdk_im_android.Disposable
    public void destroy() {
        if (this.wasDestroyed.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        if (this.callCounter.decrementAndGet() != 0) goto L9;
        freeRustArcPtr();
        return;
    }

    public final long getPointer() {
        return this.pointer;
    }

    public final long getPointerInternal$office_sdk_im_android_release() {
        return this.pointer;
    }

    public RustArcClass(long r100) {
        this.pointer = r100;
        this.wasDestroyed = new AtomicBoolean(false);
        this.callCounter = new AtomicLong(1);
    }

    public static final /* synthetic */ void access$freeRustArcPtr(RustArcClass r100) {
        r100.freeRustArcPtr();
    }

    public static final /* synthetic */ AtomicLong access$getCallCounter$p(RustArcClass r100) {
        return r100.callCounter;
    }

    public static final /* synthetic */ long access$getPointer(RustArcClass r100) {
        return r100.pointer;
    }

    public final <R> R callWithPointer$office_sdk_im_android_release(Function1<? super Long, ? extends R> r100) {
        Intrinsics.checkNotNullParameter(r100, "block");
    L3:
        long r101 = access$getCallCounter$p(this).get();
        if (r101 == 0) goto L25;
        if (r101 == Long.MAX_VALUE) goto L23;
        if (access$getCallCounter$p(this).compareAndSet(r101, 1 + r101) == false) goto L3;
        R r102 = r100.invoke(Long.valueOf(access$getPointer(this)));     // Catch: Throwable -> L16
        InlineMarker.finallyStart(1);
        if (access$getCallCounter$p(this).decrementAndGet() != 0) goto L14;
        access$freeRustArcPtr(this);
    L14:
        InlineMarker.finallyEnd(1);
        return r102;
    L16:
        th = move-exception;
        InlineMarker.finallyStart(1);
        if (access$getCallCounter$p(this).decrementAndGet() != 0) goto L20;
        access$freeRustArcPtr(this);
    L20:
        InlineMarker.finallyEnd(1);
        throw th;
    L23:
        throw new IllegalStateException(getClass().getSimpleName().concat(" call counter would overflow"));
    L25:
        throw new IllegalStateException(getClass().getSimpleName().concat(" object has already been destroyed"));
    }
}
