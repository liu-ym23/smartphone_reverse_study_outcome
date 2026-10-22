package com.google.common.util.concurrent;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
final class ListenerCallQueue<L> {
    private static final Logger logger = null;
    private final List<PerListenerQueue<L>> listeners;

    public interface Event<L> {
        void call(L r100);
    }

    public static final class PerListenerQueue<L> implements Runnable {
        final Executor executor;
        boolean isThreadScheduled;
        final Queue<Object> labelQueue;
        final L listener;
        final Queue<Event<L>> waitQueue;

        public void com_google_common_util_concurrent_ListenerCallQueue$PerListenerQueue__run$___twin___() {
        L2:
            boolean r100 = true;
            monitor-enter(this);     // Catch: Throwable -> L25
            com.google.common.base.m.o(this.isThreadScheduled);     // Catch: Throwable -> L17
            Event<L> r101 = this.waitQueue.poll();     // Catch: Throwable -> L17
            Object r102 = this.labelQueue.poll();     // Catch: Throwable -> L17
            if (r101 == null) goto L6;
            monitor-exit(this);     // Catch: Throwable -> L17
            r101.call(this.listener);     // Catch: RuntimeException -> L14 Throwable -> L25
        L14:
            e = move-exception;
            ListenerCallQueue.access$000().log(Level.SEVERE, "Exception while executing callback: " + this.listener + " " + r102, e);     // Catch: Throwable -> L25
            goto L2
        L6:
            this.isThreadScheduled = false;     // Catch: Throwable -> L17
            monitor-exit(this);     // Catch: Throwable -> L9
            return;
        L9:
            Throwable th10 = th;
            boolean r103 = false;
        L41:
            monitor-exit(this);     // Catch: Throwable -> L23
            throw th10;     // Catch: Throwable -> L21
        L21:
            th = move-exception;
            boolean r104 = r103;
            th = th;
            r100 = r104;
        L26:
            if (r100 == false) goto L34;
            monitor-enter(this);
            this.isThreadScheduled = false;     // Catch: Throwable -> L31
            monitor-exit(this);     // Catch: Throwable -> L31
        L31:
            th = move-exception;
            throw th;
        L34:
            throw th;
        L23:
            th10 = th;
        L17:
            th = move-exception;
            th10 = th;
            r103 = true;
        L25:
            th = th;
            goto L26
        }

        public void dispatch() {
            monitor-enter(this);
        L21:
            th = move-exception;
            throw th;
        L4:
            if (this.isThreadScheduled == true) goto L6;
            boolean r100 = true;
            this.isThreadScheduled = true;     // Catch: Throwable -> L21
        L7:
            monitor-exit(this);     // Catch: Throwable -> L21
            if (r100 == true) goto L26;
            return;
        L26:
            this.executor.execute(this);     // Catch: RuntimeException -> L11
            return;
        L11:
            e = move-exception;
            monitor-enter(this);
            this.isThreadScheduled = false;     // Catch: Throwable -> L17
            ListenerCallQueue.access$000().log(Level.SEVERE, "Exception while running callbacks for " + this.listener + " on " + this.executor, e);
            throw e;
        L17:
            th = move-exception;
            throw th;
        L6:
            r100 = false;
            goto L7
        }

        @Override // java.lang.Runnable
        public void run() {
            com_google_common_util_concurrent_ListenerCallQueue$PerListenerQueue_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_google_common_util_concurrent_ListenerCallQueue$PerListenerQueue_com_larus_apm_impl_protector_RunnableLancet_run(PerListenerQueue r100) {
            r100.com_google_common_util_concurrent_ListenerCallQueue$PerListenerQueue__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public PerListenerQueue(L r100, Executor r101) {
            this.waitQueue = new ArrayDeque();
            this.labelQueue = new ArrayDeque();
            r100.getClass();
            this.listener = r100;
            r101.getClass();
            this.executor = r101;
        }

        public synchronized void add(Event<L> r100, Object r101) {
            monitor-enter(this);
            this.waitQueue.add(r100);     // Catch: Throwable -> L6
            this.labelQueue.add(r101);     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }
    }

    public void dispatch() {
        int r100 = 0;
    L4:
        if (r100 >= this.listeners.size()) goto L6;
        ((PerListenerQueue) ListProtector.get(this.listeners, r100)).dispatch();
        r100 = r100 + 1;
        goto L4
    }

    static {
        logger = Logger.getLogger(ListenerCallQueue.class.getName());
    }

    public ListenerCallQueue() {
        this.listeners = Collections.synchronizedList(new ArrayList());
    }

    public static /* synthetic */ Logger access$000() {
        return logger;
    }

    public void enqueue(Event<L> r100) {
        enqueueHelper(r100, r100);
    }

    private void enqueueHelper(Event<L> r100, Object r101) {
        com.google.common.base.m.l(r100, "event");
        com.google.common.base.m.l(r101, "label");
        List<PerListenerQueue<L>> r102 = this.listeners;
        monitor-enter(r102);
        Iterator<PerListenerQueue<L>> r103 = this.listeners.iterator();     // Catch: Throwable -> L10
    L6:
        if (r103.hasNext() == false) goto L8;
        r103.next().add(r100, r101);     // Catch: Throwable -> L10
        goto L6
    L8:
        monitor-exit(r102);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public void addListener(L r100, Executor r101) {
        com.google.common.base.m.l(r100, "listener");
        com.google.common.base.m.l(r101, "executor");
        this.listeners.add(new PerListenerQueue(r100, r101));
    }

    public void enqueue(Event<L> r100, String r101) {
        enqueueHelper(r100, r101);
    }
}
