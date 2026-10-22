package io.opentelemetry.context;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.lang.ref.Reference;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes41.dex */
public final class StrictContextStorage implements c, AutoCloseable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Logger f492684c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f492685a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f492686b;

    public static class CallerStackTrace extends Throwable {
        volatile boolean closed;
        final b context;
        final long threadId;
        final String threadName;

        public CallerStackTrace(b r100) {
            super("Thread [" + ThreadMethodProxy.currentThread().getName() + "] opened scope for " + r100 + " here:");
            this.threadName = ThreadMethodProxy.currentThread().getName();
            this.threadId = ThreadMethodProxy.currentThread().getId();
            this.context = r100;
        }
    }

    public static class a extends ktc.b<h, CallerStackTrace> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ConcurrentHashMap<ktc.a.c<h>, CallerStackTrace> f492687b;

        @Override // java.lang.Runnable
        public final void run() {
        L17:
        L10:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L15;
            throw th;
        L15:
            return;
        L3:
            if (Thread.interrupted() == true) goto L27;
            CallerStackTrace r100 = this.f492687b.remove(remove());     // Catch: Throwable -> L10 InterruptedException -> L16
            if (r100 == null) goto L17;
            if (r100.closed == true) goto L17;
            StrictContextStorage.f492684c.log(Level.SEVERE, "Scope garbage collected before being closed.", StrictContextStorage.d(r100));     // Catch: Throwable -> L10 InterruptedException -> L16
            goto L26
        L27:
            return;
        }

        public a(ConcurrentHashMap<ktc.a.c<h>, CallerStackTrace> r100) {
            super(r100);
            this.f492687b = r100;
            PthreadThreadV2 r101 = new PthreadThreadV2(this, "StrictContextStorage$PendingScopes");
            ThreadMethodProxy.setName(r101, "weak-ref-cleaner-strictcontextstorage");
            ThreadMethodProxy.setPriority(r101, 1);
            r101.setDaemon(true);
            ThreadMethodProxy.start(r101);
        }
    }

    @Override // io.opentelemetry.context.c
    public final b root() {
        return io.opentelemetry.context.a.f492696b;
    }

    static {
        f492684c = Logger.getLogger(StrictContextStorage.class.getName());
    }

    @Override // java.lang.AutoCloseable
    public final void close() {
        a r100 = this.f492686b;
    L3:
        Reference<? extends h> r101 = r100.poll();
        if (r101 == null) goto L6;
        r100.f506166a.remove(r101);
        goto L3
    L6:
        a r102 = this.f492686b;
        List r103 = (List) r102.f492687b.values().stream().filter(new i()).collect(Collectors.toList());
        r102.f492687b.clear();
        if (r103.isEmpty() == false) goto L9;
        return;
    L9:
        if (r103.size() <= 1) goto L15;
        f492684c.log(Level.SEVERE, "Multiple scopes leaked - first will be thrown as an error.");
        Iterator r104 = r103.iterator();
    L12:
        if (r104.hasNext() == false) goto L15;
        CallerStackTrace r105 = (CallerStackTrace) r104.next();
        f492684c.log(Level.SEVERE, "Scope leaked", d(r105));
    L15:
        throw d((CallerStackTrace) ListProtector.get(r103, 0));
    }

    @Override // io.opentelemetry.context.c
    @Nullable
    public final b current() {
        return this.f492685a.current();
    }

    public StrictContextStorage(c r100) {
        this.f492685a = r100;
        this.f492686b = new a(new ConcurrentHashMap());
    }

    public static AssertionError d(CallerStackTrace r100) {
        AssertionError r101 = new AssertionError("Thread [" + r100.threadName + "] opened a scope of " + r100.context + " here:");
        r101.setStackTrace(r100.getStackTrace());
        return r101;
    }
}
