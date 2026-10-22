package com.bytedance.ee.bear.bitable.statistic.inner;

import android.os.Handler;
import android.os.HandlerThread;
import com.bytedance.ee.bear.bitable.statistic.BitableTraceType;
import com.bytedance.ee.bear.bitable.statistic.n;
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

/* JADX INFO: loaded from: classes16.dex */
public abstract class BitableInnerTrace implements n {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Lazy<HandlerThread> f215679j = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f215680a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f215681b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<BitableInnerTrace> f215682c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, Serializable> f215683d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f215684e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AtomicBoolean f215685f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AtomicBoolean f215686g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f215687h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile boolean f215688i;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BitableInnerTrace f215689a;

        public b(BitableInnerTrace r100) {
            this.f215689a = r100;
        }

        public final void a() {
            BitableInnerTrace r100 = this.f215689a;
            if (r100.f215686g.compareAndSet(false, true) == false) goto L6;
            int r101 = com.bytedance.ee.bear.bitable.statistic.common.e.f215628a;
            tt5.a.h("BitableStatistic", "BitableInnerTrace " + ("clear trace " + r100.f215687h));
            r100.m();
            r100.f215681b.c(r100.f215687h);
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
        f215679j = LazyKt.lazy(BitableInnerTrace$Companion$traceHandlerThread$2.INSTANCE);
    }

    public final void j() {
        if (this.f215688i == true) goto L5;
        return;
    L5:
        if (this.f215685f.get() == true) goto L9;
        l().postDelayed(new b(this), 3000);
        return;
    }

    public final List<Map<String, Serializable>> k() {
        String r100 = this.f215680a;
        if (r100 != null) goto L5;
        return null;
    L5:
        BitableInnerTrace r101 = this.f215681b.a(r100, BitableInnerTrace.class, true);
        if (r101 != null) goto L8;
        return null;
    L8:
        List<Map<String, Serializable>> r102 = r101.k();
        ConcurrentHashMap r103 = (ConcurrentHashMap) r101.f215683d;
        if ((!r103.isEmpty()) == false) goto L13;
        if (r102 != null) goto L12;
        r102 = new ArrayList();
    L12:
        r102.add(r103);
    L13:
        return r102;
    }

    public final Handler l() {
        return (Handler) this.f215684e.getValue();
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.n
    public final String getTraceId() {
        return this.f215687h;
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.n
    public final String h() {
        return this.f215680a;
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.n
    public synchronized void b(Boolean r100) {
        monitor-enter(this);
        this.f215688i = true;     // Catch: Throwable -> L13
        if (Intrinsics.areEqual(r100, Boolean.TRUE) == false) goto L10;
        Iterator<T> r101 = this.f215682c.iterator();     // Catch: Throwable -> L13
    L8:
        if (r101.hasNext() == false) goto L10;
        BitableInnerTrace r102 = (BitableInnerTrace) r101.next();     // Catch: Throwable -> L13
        r102.b(Boolean.TRUE);     // Catch: Throwable -> L13
        r102.j();     // Catch: Throwable -> L13
    L10:
        j();     // Catch: Throwable -> L13
        monitor-exit(this);
        return;
    L13:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.n
    public final Map<String, Serializable> c(boolean r100) {
        if (r100 == false) goto L4;
        List<Map<String, Serializable>> r101 = k();
        if (r101 == null) goto L8;
        LinkedHashMap r102 = new LinkedHashMap();
        Iterator<T> r103 = r101.iterator();
    L11:
        if (r103.hasNext() == false) goto L13;
        r102.putAll((Map) r103.next());
        goto L11
    L13:
        r102.putAll(this.f215683d);
        return r102;
    L8:
        return this.f215683d;
    L4:
        return this.f215683d;
    }

    public BitableInnerTrace(String r100, e r101) {
        Intrinsics.checkNotNullParameter(r101, "traceProvider");
        this.f215680a = r100;
        this.f215681b = r101;
        this.f215682c = new CopyOnWriteArrayList();
        this.f215683d = new ConcurrentHashMap();
        this.f215684e = LazyKt.lazy(BitableInnerTrace$traceHandler$2.INSTANCE);
        this.f215685f = new AtomicBoolean(false);
        this.f215686g = new AtomicBoolean(false);
        this.f215687h = r101.b();
        if (r100 == null) goto L10;
        BitableInnerTrace r102 = r101.a(r100, BitableInnerTrace.class, true);
        if (r102 == null) goto L11;
        List<BitableInnerTrace> r103 = r102.f215682c;
        if (r103 == null) goto L12;
        ((CopyOnWriteArrayList) r103).add(this);
        return;
    L12:
        return;
    L11:
        return;
    }
}
