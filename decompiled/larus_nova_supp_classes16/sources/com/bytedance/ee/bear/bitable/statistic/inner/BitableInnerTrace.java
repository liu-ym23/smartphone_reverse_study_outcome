package com.bytedance.ee.bear.bitable.statistic.inner;

import android.os.Handler;
import android.os.HandlerThread;
import com.bytedance.ee.bear.bitable.statistic.BitableTraceType;
import com.bytedance.ee.bear.bitable.statistic.n;
import com.bytedance.ee.bear.bitable.toast.ToastModel;
import com.larus.apm.impl.protector.RunnableProtector;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public abstract class BitableInnerTrace implements n {
    public static final Lazy<HandlerThread> j = null;
    public final String a;
    public final e b;
    public final List<BitableInnerTrace> c;
    public final Map<String, Serializable> d;
    public final Lazy e;
    public final AtomicBoolean f;
    public final AtomicBoolean g;
    public final String h;
    public volatile boolean i;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ BitableInnerTrace a;

        public b(BitableInnerTrace r1) {
            this.a = r1;
        }

        public final void a() {
            BitableInnerTrace r0 = this.a;
            if (r0.g.compareAndSet(false, true) == false) goto L6;
            int r1 = com.bytedance.ee.bear.bitable.statistic.common.e.a;
            tt5.a.h("BitableStatistic", "BitableInnerTrace " + ("clear trace " + r0.h));
            r0.m();
            r0.b.c(r0.h);
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.n
    public abstract /* synthetic */ BitableTraceType getType();

    public abstract void m();

    static {
        j = LazyKt.lazy(BitableInnerTrace$Companion$traceHandlerThread$2.INSTANCE);
    }

    public final void j() {
        if (this.i == true) goto L5;
        return;
    L5:
        if (this.f.get() == true) goto L9;
        l().postDelayed(new b(this), ToastModel.DEFAULT_DURATION);
        return;
    }

    public final List<Map<String, Serializable>> k() {
        String r0 = this.a;
        if (r0 != null) goto L5;
        return null;
    L5:
        BitableInnerTrace r1 = this.b.a(r0, BitableInnerTrace.class, true);
        if (r1 != null) goto L8;
        return null;
    L8:
        List<Map<String, Serializable>> r2 = r1.k();
        ConcurrentHashMap r3 = (ConcurrentHashMap) r1.d;
        if ((!r3.isEmpty()) == false) goto L13;
        if (r2 != null) goto L12;
        r2 = new ArrayList();
    L12:
        r2.add(r3);
    L13:
        return r2;
    }

    public final Handler l() {
        return (Handler) this.e.getValue();
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.n
    public final String getTraceId() {
        return this.h;
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.n
    public final String h() {
        return this.a;
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.n
    public synchronized void b(Boolean r3) {
        monitor-enter(this);
        this.i = true;     // Catch: Throwable -> L13
        if (Intrinsics.areEqual(r3, Boolean.TRUE) == false) goto L10;
        Iterator<T> r4 = this.c.iterator();     // Catch: Throwable -> L13
    L8:
        if (r4.hasNext() == false) goto L10;
        BitableInnerTrace r0 = (BitableInnerTrace) r4.next();     // Catch: Throwable -> L13
        r0.b(Boolean.TRUE);     // Catch: Throwable -> L13
        r0.j();     // Catch: Throwable -> L13
    L10:
        j();     // Catch: Throwable -> L13
        monitor-exit(this);
        return;
    L13:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.n
    public final Map<String, Serializable> c(boolean r3) {
        if (r3 == false) goto L4;
        List<Map<String, Serializable>> r4 = k();
        if (r4 == null) goto L8;
        LinkedHashMap r0 = new LinkedHashMap();
        Iterator<T> r5 = r4.iterator();
    L11:
        if (r5.hasNext() == false) goto L13;
        r0.putAll((Map) r5.next());
        goto L11
    L13:
        r0.putAll(this.d);
        return r0;
    L8:
        return this.d;
    L4:
        return this.d;
    }

    public BitableInnerTrace(String r3, e r4) {
        Intrinsics.checkNotNullParameter(r4, "traceProvider");
        this.a = r3;
        this.b = r4;
        this.c = new CopyOnWriteArrayList();
        this.d = new ConcurrentHashMap();
        this.e = LazyKt.lazy(BitableInnerTrace$traceHandler$2.INSTANCE);
        this.f = new AtomicBoolean(false);
        this.g = new AtomicBoolean(false);
        this.h = r4.b();
        if (r3 == null) goto L10;
        BitableInnerTrace r5 = r4.a(r3, BitableInnerTrace.class, true);
        if (r5 == null) goto L11;
        List<BitableInnerTrace> r6 = r5.c;
        if (r6 == null) goto L12;
        ((CopyOnWriteArrayList) r6).add(this);
        return;
    L12:
        return;
    L11:
        return;
    }
}
