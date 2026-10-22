package com.google.common.util.concurrent;

import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public final class ExecutionList {
    private static final Logger log = null;
    private boolean executed;

    @CheckForNull
    private RunnableExecutorPair runnables;

    public static final class RunnableExecutorPair {
        final Executor executor;

        @CheckForNull
        RunnableExecutorPair next;
        final Runnable runnable;

        public RunnableExecutorPair(Runnable r100, Executor r101, @CheckForNull RunnableExecutorPair r102) {
            this.runnable = r100;
            this.executor = r101;
            this.next = r102;
        }
    }

    public ExecutionList() {
    }

    public void execute() {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L4:
        if (this.executed == false) goto L7;
        monitor-exit(this);     // Catch: Throwable -> L14
        return;
    L7:
        this.executed = true;     // Catch: Throwable -> L14
        RunnableExecutorPair r100 = this.runnables;     // Catch: Throwable -> L14
        RunnableExecutorPair r101 = null;
        this.runnables = null;     // Catch: Throwable -> L14
        monitor-exit(this);     // Catch: Throwable -> L14
    L9:
        if (r100 == null) goto L11;
        RunnableExecutorPair r102 = r100.next;
        r100.next = r101;
        r101 = r100;
        r100 = r102;
    L11:
        if (r101 == null) goto L13;
        executeListener(r101.runnable, r101.executor);
        r101 = r101.next;
        goto L11
    }

    static {
        log = Logger.getLogger(ExecutionList.class.getName());
    }

    private static void executeListener(Runnable r100, Executor r101) {
        r101.execute(r100);     // Catch: RuntimeException -> L4
        return;
    L4:
        e = move-exception;
        log.log(Level.SEVERE, "RuntimeException while executing runnable " + r100 + " with executor " + r101, e);
    }

    public void add(Runnable r100, Executor r101) {
        com.google.common.base.m.l(r100, "Runnable was null.");
        com.google.common.base.m.l(r101, "Executor was null.");
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.executed == true) goto L9;
        this.runnables = new RunnableExecutorPair(r100, r101, this.runnables);     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L12
        return;
    L9:
        monitor-exit(this);     // Catch: Throwable -> L12
        executeListener(r100, r101);
    }
}
