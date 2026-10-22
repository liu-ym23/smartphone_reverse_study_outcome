package com.bytedance.ttcnpa;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00020\u00012\u00020\u0002J<\u0010\f\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00032!\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0080\bø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\r"}, d2 = {"Lcom/bytedance/ttcnpa/RustArcClass;", "Lcom/bytedance/ttcnpa/Disposable;", "Ljava/lang/AutoCloseable;", "R", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "pointer", "block", "callWithJNIPointer$ttcnpa_release", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "callWithJNIPointer", "ttcnpa_release"}, k = 1, mv = {1, 7, 1})
public abstract class RustArcClass implements Disposable, AutoCloseable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArcHandle f271034a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f271035b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicLong f271036c;

    public void a() {
    }

    @Override // java.lang.AutoCloseable
    public final synchronized void close() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.f271035b.compareAndSet(false, true) == true) goto L6;
    L11:
        monitor-exit(this);
        return;
    L6:
        if (this.f271036c.decrementAndGet() != 0) goto L11;
        a();     // Catch: Throwable -> L9
        goto L11
    }

    public RustArcClass(ArcHandle.LongHandle r100) {
        Intrinsics.checkNotNullParameter(r100, "pointer");
        this.f271034a = r100;
        this.f271035b = new AtomicBoolean(false);
        this.f271036c = new AtomicLong(1);
    }

    public final <R> R callWithJNIPointer$ttcnpa_release(Function1<? super Long, ? extends R> r100) {
        Intrinsics.checkNotNullParameter(r100, "block");
    L3:
        long r101 = this.f271036c.get();
        if (r101 == 0) goto L29;
        if (r101 == Long.MAX_VALUE) goto L27;
        if (this.f271036c.compareAndSet(r101, 1 + r101) == false) goto L3;
        ArcHandle r102 = this.f271034a;     // Catch: Throwable -> L20
        if ((r102 instanceof ArcHandle.LongHandle) == false) goto L19;
        R r103 = r100.invoke(Long.valueOf(((ArcHandle.LongHandle) r102).f271030a));     // Catch: Throwable -> L20
        InlineMarker.finallyStart(1);
        if (this.f271036c.decrementAndGet() != 0) goto L16;
        a();
    L16:
        InlineMarker.finallyEnd(1);
        return r103;
    L19:
        throw new IllegalStateException(getClass().getSimpleName() + " pointer type mismatch(long expected)");     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        InlineMarker.finallyStart(1);
        if (this.f271036c.decrementAndGet() != 0) goto L24;
        a();
    L24:
        InlineMarker.finallyEnd(1);
        throw th;
    L27:
        throw new IllegalStateException(getClass().getSimpleName().concat(" call counter would overflow"));
    L29:
        throw new IllegalStateException(getClass().getSimpleName().concat(" object has already been destroyed"));
    }
}
